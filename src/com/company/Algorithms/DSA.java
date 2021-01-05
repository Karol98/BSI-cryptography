package com.company.Algorithms;
import com.company.Menu.TextColor;

import java.security.KeyPair;

import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;

/**
 * Author:Mario Gliwa
 * source:https://www.tutorialspoint.com/java_cryptography/java_cryptography_creating_signature.htm
 */
public class DSA {
    public static void main() throws Exception {
        long startTime = System.nanoTime();
        /**
        Accepting text from user
        */
        String msg = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ";
        /**
         *  Creating KeyPair generator object
         */
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        /**
         *  Initializing the key pair generator
         */
        keyPairGen.initialize(2048);
        /**
         * Generate the pair of keys
         */
        KeyPair pair = keyPairGen.generateKeyPair();
        /**
         * Getting the private key from the key pair
         */
        PrivateKey privKey = pair.getPrivate();
        /**
         * Creating a Signature object
         */
        Signature sign = Signature.getInstance("SHA256withDSA");
        /**
         * Initialize the signature
         */
        sign.initSign(privKey);
        byte[] bytes = "msg".getBytes();
        /**
         * Adding data to the signature
         */
        sign.update(bytes);
        /**
         * Calculating the signature
         */
        byte[] signature = sign.sign();
        /**
         * Printing the signature
         */
        System.out.println("Digital signature for given text: "+new String(signature, "UTF8"));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(TextColor.BLUE+totalTime);
        System.out.println(TextColor.RESET);
    }
}