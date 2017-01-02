package com.gescc.hedwig.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class KeyUtil {
	public String getSmsKey() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String currentTime = sdf.format(System.currentTimeMillis());
		StringBuffer key = new StringBuffer();
		Random random = new Random();
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(currentTime.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 5; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			for (int i = 0; i < 10; i++) {
				char c = sb.charAt(i);
				if (sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') {
					if (random.nextBoolean())
						c -= 32;
				}
				key.append(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
			key = null;
		}

		return key.toString();
	}
}
