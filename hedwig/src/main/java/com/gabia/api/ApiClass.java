package com.gabia.api;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class ApiClass {

	private String smsId = "";
	private String apiKey = "";
	private String method = "basic";
	private final static String apiUrl = "http://sms.gabia.com/api";
	private final static String methodName = "gabiasms";

	private String refXmlFormat = "<request>" + "<sms-id>%s</sms-id>"
			+ "<access-token>%s</access-token>"
			+ "<response-format>xml</response-format>"
			+ "<method>SMS.getStatusByRef</method>" + "<params>"
			+ "<ref_key>%s</ref_key>" + "</params>" + "</request>";
	
	private String refXmlFormat_all = "<request>" + "<sms-id>%s</sms-id>"
			+ "<access-token>%s</access-token>"
			+ "<response-format>xml</response-format>"
			+ "<method>SMS.getStatusByRef_all</method>" + "<params>"
			+ "<ref_key>%s</ref_key>" + "</params>" + "</request>";
	
	private String reqXmlFormat = "<request>" + "<sms-id>%s</sms-id>"
			+ "<access-token>%s</access-token>"
			+ "<response-format>xml</response-format>"
			+ "<method>SMS.send</method>" + "<params>"
			+ "<send_type>%s</send_type>" + "<ref_key>%s</ref_key>"
			+ "<subject>%s</subject>" + "<message>%s</message>"
			+ "<callback>%s</callback>" + "<phone>%s</phone>" 
			+ "<reserve>%s</reserve>" + "</params>"
			+ "</request>";
	
	private String reqXmlFormat2 = "<request>" + "<sms-id>%s</sms-id>"
			+ "<access-token>%s</access-token>"
			+ "<response-format>xml</response-format>"
			+ "<method>SMS.multi_send</method>" + "<params>"
			+ "<send_type>%s</send_type>" + "<ref_key>%s</ref_key>"
			+ "<subject>%s</subject>" + "<message>%s</message>"
			+ "<callback>%s</callback>" + "<phone>%s</phone>"
			+ "<reserve>%s</reserve>" + "</params>"
			+ "</request>";
	
	private String reserveCancel = "<request>" + "<sms-id>%s</sms-id>"
			+ "<access-token>%s</access-token>"
			+ "<response-format>xml</response-format>"
			+ "<method>SMS.reservationCancel</method>" + "<params>"
			+ "<ref_key>%s</ref_key>" + "<send_type>%s</send_type>"
			+ "<phonenum>%s</phonenum>" + "</params>" + "</request>";

	public ApiClass(String smsId, String apiKey) {
		this.smsId = smsId;
		this.apiKey = apiKey;
	}
	
	public String MakeToString(String phone_arr[]){
		String phone_st = Arrays.toString(phone_arr);
		phone_st = phone_st.replace("[","");
		phone_st = phone_st.replace("]","");
		phone_st = phone_st.replace(" ", "");
		return phone_st;
	}
	
	public String send(String[] args) {
		try {
			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			config.setServerURL(new URL(apiUrl));
			XmlRpcClient client = new XmlRpcClient();
			client.setConfig(config);

			String nonce = getNonce();
			String md5_access_token = nonce + getMD5(nonce + this.apiKey);
			String s;

			if (args[0] == "status_by_ref") {
				s = String.format(refXmlFormat, this.smsId, md5_access_token,
						args[1]);
			}else if(args[0] == "status_by_ref_all"){
				this.method = args[0];
				s = String.format(refXmlFormat_all, this.smsId, md5_access_token,
						args[1]);
			}else if(args[0] == "multi_sms"){
				args[0] = "sms";
				args[2] = this.escape_xml_str(args[2]);
				args[3] = this.escape_xml_str(args[3]);
				s = String.format(reqXmlFormat2, this.smsId, md5_access_token,
						args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
			}else if(args[0] == "multi_lms"){
				args[0] = "lms";
				args[2] = this.escape_xml_str(args[2]);
				args[3] = this.escape_xml_str(args[3]);
				s = String.format(reqXmlFormat2, this.smsId, md5_access_token,
						args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
			}else if(args[0] == "reserveCancel"){
				s = String.format(reserveCancel, this.smsId, md5_access_token,
						args[1], args[2],args[3]);
			}else{
				args[2] = this.escape_xml_str(args[2]);
				args[3] = this.escape_xml_str(args[3]);
				s = String.format(reqXmlFormat, this.smsId, md5_access_token,
						args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
			}

//			System.out.println(s);
			Object[] params = new Object[] { new String(s) };
			String response = (String) client.execute(methodName, params);

//			System.out.println("Response:" + getResultXml(response));
			return response;
		} catch (XmlRpcException exception) {
			System.err.println("JavaClient: XML-RPC Fault #"
					+ Integer.toString(exception.code) + ": "
					+ exception.toString());
		} catch (Exception exception) {
			System.err.println("JavaClient: " + exception.toString());
		}
		return "";
	}
	
	public String escape_xml_str(String str){
		str = str.replace("&", "&amp");
		str = str.replace("<", "&lt");
		str = str.replace(">", "&gt");
		str = str.replace("'", "&apos");
		str = str.replace("\"", "&quot");
		
		return str;
	}
	public String getNonce() {
		StringBuffer nonce = new StringBuffer();
		Random random = new Random();

		String chars[] = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,0,1,2,3,4,5,6,7,8,9"
				.split(",");

		for (int i = 0; i < 8; i++) {
			nonce.append(chars[random.nextInt(chars.length)]);
		}
		// System.out.println("nonce:" + nonce.toString());
		return nonce.toString();
	}

	public String getMD5(String str) throws NoSuchAlgorithmException {
		MessageDigest di = MessageDigest.getInstance("MD5");
		di.update(new String(str).getBytes());
		byte[] md5Code = di.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < md5Code.length; i++) {
			String md5Char = String.format("%02x", 0xff & (char) md5Code[i]);
			sb.append(md5Char);
		}

		return sb.toString();
	}

	public ApiResult getResult( String xmlStr ) {
		String code = "";
		String mesg = "";
		
		try {
			// first of all we request out
			// DOM-implementation:
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			// then we have to create document-loader:
			DocumentBuilder loader = factory.newDocumentBuilder();

			// loading a DOM-tree...
			Document document = loader.parse(new InputSource(new StringReader(
					xmlStr)));
			// at last, we get a root element:
			Element tree = document.getDocumentElement();
			// ... do something with document element ...
			NodeList items = tree.getElementsByTagName("code");
			code = items.item(0).getFirstChild().getNodeValue();
			
			items = tree.getElementsByTagName("mesg");
			mesg = items.item(0).getFirstChild().getNodeValue();

		} catch (IOException ex) {
			// any IO errors occur:
			handleError(ex);
		} catch (SAXException ex) {
			// parse errors occur:
			handleError(ex);
		} catch (ParserConfigurationException ex) {
			// document-loader cannot be created which,
			// satisfies the configuration requested
			handleError(ex);
		} catch (FactoryConfigurationError ex) {
			// DOM-implementation is not available
			// or cannot be instantiated:
			handleError(ex);
		} catch (NullPointerException ex) {
			// DOM-implementation is not available
			// or cannot be instantiated:
			handleError(ex);
		}
		
		ApiResult res = new ApiResult(code,mesg);
		return res;
	}
	
	public String getResultXml(String xmlStr) {
		try {
			// first of all we request out
			// DOM-implementation:
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			// then we have to create document-loader:
			DocumentBuilder loader = factory.newDocumentBuilder();

			// loading a DOM-tree...
			Document document = loader.parse(new InputSource(new StringReader(
					xmlStr)));
			// at last, we get a root element:
			Element tree = document.getDocumentElement();
			// ... do something with document element ...
			NodeList items = tree.getElementsByTagName("result");
			String nodeValue = items.item(0).getFirstChild().getNodeValue();

			byte[] bytDecoded = Base64Utils.decode(nodeValue);
			String result = new String(bytDecoded);
			
			
//			System.out.println("DecodedString=" + result);

			return result.toString();
			
		} catch (IOException ex) {
			// any IO errors occur:
			handleError(ex);
		} catch (SAXException ex) {
			// parse errors occur:
			handleError(ex);
		} catch (ParserConfigurationException ex) {
			// document-loader cannot be created which,
			// satisfies the configuration requested
			handleError(ex);
		} catch (FactoryConfigurationError ex) {
			// DOM-implementation is not available
			// or cannot be instantiated:
			handleError(ex);
		} catch (NullPointerException ex) {
			// DOM-implementation is not available
			// or cannot be instantiated:
			handleError(ex);
		}
		
		return "";
	}

	public String[][] getResultXml_All(String xmlStr) {
		String[][] result_ref_all = null;
		try {
			// first of all we request out
			// DOM-implementation:
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			// then we have to create document-loader:
			DocumentBuilder loader = factory.newDocumentBuilder();

			// loading a DOM-tree...
			Document document = loader.parse(new InputSource(new StringReader(
					xmlStr)));
			// at last, we get a root element:
			Element tree = document.getDocumentElement();
			// ... do something with document element ...
			NodeList items = tree.getElementsByTagName("result");
			String nodeValue = items.item(0).getFirstChild().getNodeValue();

			byte[] bytDecoded = Base64Utils.decode(nodeValue);
			String result = new String(bytDecoded);
			System.out.println(result);
			document = loader.parse(new InputSource(new StringReader(result)));
			tree = document.getDocumentElement();
			items = tree.getElementsByTagName("entry");
			
			if(items.item(0).getFirstChild().getNodeValue() == "NODATA"){
				return result_ref_all;
			}
			result_ref_all = new String[items.getLength()][2];
			for(int a=0; a<items.getLength(); a++){
				Node nd = items.item(a);
				if(nd.getNodeType() == Node.ELEMENT_NODE){
					Element el = (Element)nd;
					
					NodeList phoneNdlist = el.getElementsByTagName("PHONENUM");
					NodeList mesgNdlist = el.getElementsByTagName("MESG");
					Element phoneEl = (Element)phoneNdlist.item(0);
					Element mesgEl = (Element)mesgNdlist.item(0);
					NodeList chNdListPhone = phoneEl.getChildNodes();
					NodeList chNdListMesg = mesgEl.getChildNodes();
					
					result_ref_all[a][0] = (String)chNdListPhone.item(0).getNodeValue();
					result_ref_all[a][1] = (String)chNdListMesg.item(0).getNodeValue();
					//System.out.println("**code**" + chNdListPhone.item(0).getNodeValue());
					//System.out.println("**mesg**"+ chNdListMesg.item(0).getNodeValue());
				}
			}
			
			//System.out.println(Arrays.toString(result_ref_all));
//			System.out.println("DecodedString=" + result);

			return result_ref_all;
			
		} catch (IOException ex) {
			// any IO errors occur:
			handleError(ex);
		} catch (SAXException ex) {
			// parse errors occur:
			handleError(ex);
		} catch (ParserConfigurationException ex) {
			// document-loader cannot be created which,
			// satisfies the configuration requested
			handleError(ex);
		} catch (FactoryConfigurationError ex) {
			// DOM-implementation is not available
			// or cannot be instantiated:
			handleError(ex);
		} catch (NullPointerException ex) {
			// DOM-implementation is not available
			// or cannot be instantiated:
			handleError(ex);
		}
		
		return result_ref_all;
	}
	
	private static final void handleError(Throwable ex) {
		// ... handle error here...
		System.out.println("Error Handler: " + ex.toString());
	}
}
