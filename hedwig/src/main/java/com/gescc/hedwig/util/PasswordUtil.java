package com.gescc.hedwig.util;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

/**
 * @author ChickenPaella
 *
 */
@Component
public class PasswordUtil {
	public String encodePassword(String rawPassword) {
		StringBuffer encodedPassword = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(rawPassword.getBytes());
			byte byteData[] = md.digest();
			for (int i = 0; i < byteData.length; i++) {
				encodedPassword.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedPassword.toString();
	}

	public boolean matchPassword(String rawPassword, String encodedPassword) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(rawPassword.getBytes());
			byte byteData[] = md.digest();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(sb.toString()==encodedPassword)
			return true;
		else return false;
	}
}
