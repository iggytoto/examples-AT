/**
 * IggytotoBruteForceDecoder.java
 * <p>
 * Version  since           who             Description
 * 1        21/03/2023     zhuravlev         created
 * <p>
 * Copyright (c) 2023 Prof. Schumann GmbH
 * Weender Landstrasse 23, 37073 Goettingen, Germany
 * <p>
 * This software is the confidential and proprietary information of
 * Prof. Schumann GmbH.
 * The sourcecode is provided for information purposes only and may not
 * be redistributed without licence agreement with Prof. Schumann GmbH.
 */
package com.javarush.cryptanalyser.tyapkin.codingText;

import java.util.Random;

import com.javarush.cryptanalyser.tyapkin.coding.Decode;
import com.javarush.cryptanalyser.tyapkin.coding.Encode;
import com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet;

public class BruteForceDecoder {

    /**
     * Декодирует входящую строку шифром цезаря методом прямого перебора. Результаты выводятся в консоль.
     * За алфавит берется {@link  cryptoAlphabet#ALPHABET}
     * @param codedText Шифрованный текст
     */
    public void process(String codedText) {
        // берем алфавит
        final String alphabet = cryptoAlphabet.ALPHABET;
        // находим его длинну
        final int iterations = alphabet.length();
        // делаем цикл от 0 до длиннаалфавита-1 по i
        for (int i = 0; i < iterations; i++) {
            // на каждом шаге производим дешифрование по ключу i и выводим на экран
            System.out.println(i + " -> " + Decode.decrypt(codedText, i));
        }
    }

    /**
     * Точка входа для тестирования только прямого перебора.
     */
    public static void main(String... args) {
        final Random rng = new Random();
        final int randomKey = rng.nextInt(cryptoAlphabet.ALPHABET.length() - 1);
        System.out.println(randomKey);
        final String encodedText = Encode.encrypt("Тестовый текст", randomKey);
        final BruteForceDecoder bruteForceDecoder = new BruteForceDecoder();
        bruteForceDecoder.process(encodedText);
    }
}