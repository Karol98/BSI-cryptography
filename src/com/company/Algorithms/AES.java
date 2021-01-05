package com.company.Algorithms;

import com.company.Menu.TextColor;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author Karol Skwierawski s18497
 */

public class AES {

    public static void main() {
        long startTime = System.nanoTime();
        final String secretKey = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ";

        String originalString = "BSI-Cryptography";
        String encryptedString = AES.encrypt(originalString, secretKey) ;
        String decryptedString = AES.decrypt(encryptedString, secretKey) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(TextColor.BLUE+totalTime);
        System.out.println(TextColor.RESET);
    }

    private static SecretKeySpec secretKey;
    private static byte[] key;

    /**
        initializing secret key based on user input string.
     */

    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    /**
     * Encrypt user string, based on what user typed, and what key user used
     *
     * @param strToEncrypt The message, which user wants to encrypt
     * @param secret         The secret key, that only user know
     * @return The encrypted message
     *
     */

    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    /**
     * Decrypt user string, based on what user typed, and what key user used
     *
     * @param strToDecrypt The message, which user wants to encrypt
     * @param secret         The secret key, that only user know
     * @return The decrypted message
     */
    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}