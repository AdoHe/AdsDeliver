/**
 * 
 */
package edu.tongji.se.tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hezibo
 *
 */
public class Encry 
{
	public static String randomString(int count) {
        return org.apache.commons.lang3.RandomStringUtils.randomAscii(count);
    }
    
    public static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static String hash(String password) {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Encry.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sha1;
    }
    
    public static String generateSalt() {
        return randomString(8);
    }
    
    public static String generatePasswordInDatabase(String input, String salt) {
        return hash(input + salt);
    }
    
    public static boolean checkPasswordByInput(String input, String salt, String passwordInDatabase) {
        return generatePasswordInDatabase(input, salt).equals(passwordInDatabase);        
    }
}
