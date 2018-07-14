package com.cell2iwebservice.utilities;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SafeLogin {
	public static String getSha256(String value) {
		String generatedPassword = null;
	    try{
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(value.getBytes());
	        generatedPassword = bytesToHex(md.digest());
	    } catch(Exception ex){
	        throw new RuntimeException(ex);
	    }
	    return generatedPassword;
	 }

	protected static String bytesToHex(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		for (byte b : bytes) 
			result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		
		return result.toString();
	}
	
	public String getSHA512(String passwordToHash, String salt){
		String generatedPassword = null;
		    try {
		         MessageDigest md = MessageDigest.getInstance("SHA-512");
		         md.update(salt.getBytes(StandardCharsets.UTF_8));
		         byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
		         generatedPassword = bytesToHex(bytes);
		    } catch (NoSuchAlgorithmException ex) {
		        ex.printStackTrace();
		        throw new RuntimeException(ex);
		    }
		    return generatedPassword;
		}
}
