package com.company;

import com.company.Algorithms.AES;
import com.company.Algorithms.DES;
import com.company.Menu.Keyin;
import com.company.Menu.TextColor;

/**
 * Autors
 * Mario Gliwa s18866
 * Karol Skwierawski s18497
 *
 *
 *
 * DES - is a block cipher algorithm that takes plain text in blocks of 64 bits and converts them to ciphertext using
 * keys of 48 bits. It is a symmetric key algorithm, which means that the same key is used for encrypting and decrypting data
 *
 * 3DES - Triple DES is a encryption technique which uses three instance of DES on same plain text. It uses there different
 * types of key choosing technique in first all used keys are different and in second two keys are same and one ise different and
 * in third all keys are same.
 *
 * AES - AES is block cipher capable of handling 128 bit blocks, using keys sized at 128, 192, and 256 bits.
 * Each cipher encrypts and decrypts data in blocks of 128 bits using cryptographic keys of 128-, 192- and 256-bits, respectively.
 * It uses the same key for encrypting and decrypting, so the sender and the receiver must both know — and use — the same secret key.
 *
 */

public class MainApp {

    public static void main(String[] args) {


        int swValue;

        // Display menu graphics
        System.out.println(TextColor.BLUE + "=====================================================");
        System.out.println("|         BSI-Project-Calculator                    |");
        System.out.println("=====================================================");
        System.out.println("| Options:                                          |");
        System.out.println("|        1. 3DES encryption/decryption              |");
        System.out.println("|        2. AES encryption/decryption               |");
        System.out.println("|        3. DES encryption/decryption               |");
        System.out.println("|        4. EXIT                                    |");
        System.out.println("=====================================================");
        swValue = Keyin.inInt(TextColor.GREEN + " Select option: ");

        // Switch construct
        switch (swValue) {
            case 1:

                break;
            case 2:
                final String secretKey = "ssshhhhhhhhhhh!!!!";

                String originalString = "BSI-Cryptography";
                String encryptedString = AES.encrypt(originalString, secretKey) ;
                String decryptedString = AES.decrypt(encryptedString, secretKey) ;

                System.out.println(originalString);
                System.out.println(encryptedString);
                System.out.println(decryptedString);
                break;
            case 3:
                String text = "123456ABCD1325361";
                String key = "AABB09182736CCDD";

                DES cipher = new DES();
                System.out.println("Encryption:\n");
                text = cipher.encrypt(text, key);
                System.out.println(
                        "\nCipher Text: " + text.toUpperCase() + "\n");
                System.out.println("Decryption\n");
                text = cipher.decrypt(text, key);
                System.out.println(
                        "\nPlain Text: "
                                + text.toUpperCase());
                break;
            default:
                System.out.println("Invalid selection");
                break; // This break is not really necessary
        }


    }

}
