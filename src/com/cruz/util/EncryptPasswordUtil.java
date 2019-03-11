package com.cruz.util;

import java.security.MessageDigest;

public class EncryptPasswordUtil {

	public static String encrypt(String password) {
		byte[] plainText = password.getBytes();

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			md.reset();
			md.update(plainText);
			byte[] encodedPassword = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < encodedPassword.length; i++) {
				if ((encodedPassword[i] & 0xff) < 0x10) {
					sb.append("0");
				}

				sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
