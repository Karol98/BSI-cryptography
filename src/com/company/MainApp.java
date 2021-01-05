package com.company;

import com.company.Algorithms.*;
import com.company.Menu.Keyin;
import com.company.Menu.TextColor;

/**
 * @Authors Mario Gliwa s18866
 * Karol Skwierawski s18497
 * <p>
 * <p>
 * <p>
 * DES - is a block cipher algorithm that takes plain text in blocks of 64 bits and converts them to ciphertext using
 * keys of 48 bits. It is a symmetric key algorithm, which means that the same key is used for encrypting and decrypting data
 * <p>
 * 3DES - Triple DES is a encryption technique which uses three instance of DES on same plain text. It uses there different
 * types of key choosing technique in first all used keys are different and in second two keys are same and one ise different and
 * in third all keys are same.
 * <p>
 * AES - AES is block cipher capable of handling 128 bit blocks, using keys sized at 128, 192, and 256 bits.
 * Each cipher encrypts and decrypts data in blocks of 128 bits using cryptographic keys of 128-, 192- and 256-bits, respectively.
 * It uses the same key for encrypting and decrypting, so the sender and the receiver must both know — and use — the same secret key.
 */

public class MainApp {

    public static void main(String[] args) throws Exception {


        int swValue;

        // Display menu graphics
        System.out.println(TextColor.BLUE + "=====================================================");
        System.out.println("|         BSI-Project-Calculator                    |");
        System.out.println("=====================================================");
        System.out.println("| Options:                                          |");
        System.out.println("|        1. 3DES encryption/decryption              |");
        System.out.println("|        2. AES encryption/decryption               |");
        System.out.println("|        3. DES encryption/decryption               |");
        System.out.println("|        4. RSA encryption/decryption               |");
        System.out.println("|        5. RES encryption/decryption               |");
        System.out.println("|        6. Race                                    |");
        System.out.println("=====================================================");
        swValue = Keyin.inInt(TextColor.GREEN + " Select option: ");
        System.out.println(TextColor.RESET);

        // Switch construct
        switch (swValue) {
            case 1:
                TripleDES.main();
                break;
            case 2:
                AES.main();
                break;
            case 3:
                DES.main();
                break;
            case 4:
                RsaExample.main();
                break;
            case 5:
                DSA.main();
                break;
            case 6:
                TripleDES.main();
                AES.main();
                RsaExample.main();
                DSA.main();
                break;
        }
    }

}
