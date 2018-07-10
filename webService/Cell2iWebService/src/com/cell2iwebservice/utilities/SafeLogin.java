package com.cell2iwebservice.utilities;
import java.security.MessageDigest;

public class SafeLogin {
	public static String getSha256(String value) {
	    try{
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(value.getBytes());
	        return bytesToHex(md.digest());
	    } catch(Exception ex){
	        throw new RuntimeException(ex);
	    }
	 }

	protected static String bytesToHex(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		for (byte b : bytes) 
			result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		
		return result.toString();
	}	
}
