package com.javarush.cryptanalyser.tyapkin.gui;

import com.javarush.cryptanalyser.tyapkin.coding.Encode;
import com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Панель кодирования шифром цезаря.
 */
public class EncodePanel extends JPanel {

    /**
     * Ссылка на элемент который отвечает за ввод текста
     */
    private JTextField inputTextField;
    /**
     * Ссылка на элемент который отвечает за ввод ключа
     */
    private JTextField inputKeyTextField;
    /**
     * Ссылка на элемент который отвечает за вывод текста
     */
    private JTextField outputTextField;

    public EncodePanel() {
        super();
        // Устанавилаем лэйаут коробкой по вертикальной оси
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Размер панели
        setSize(600, 400);
        // инициализируем
        init();
    }

    /**
     * Инициализация панели шифрования текста
     */
    private void init() {
        // Создаем заголовок для поля ввода текста
        JLabel inputTextLabel = new JLabel("Введите текст для шифрования");
        add(inputTextLabel);
        // Создаем поле ввода текста
        inputTextField = new JTextField();
        add(inputTextField);
        // Создаем заголовок для поля ввода ключа
        JLabel inputKeyTextLabel = new JLabel("Введите ключ");
        add(inputKeyTextLabel);
        // Создаем поле ввода ключа
        inputKeyTextField = new JTextField();
        inputKeyTextField.setSize(20, 20);
        add(inputKeyTextField);
        // Создаем заголовок для поля вывода шифра
        JLabel outputTextLabel = new JLabel("Результат шифрования");
        add(outputTextLabel);
        // Создаем поле вывода шифра
        outputTextField = new JTextField();
        outputTextField.setEnabled(false);
        add(outputTextField);
        // Создаем Кнопку
        JButton encodeButton = new JButton("Шифровать");
        encodeButton.addActionListener(new EncodeButtonActionListener());
        add(encodeButton);
    }

    /**
     * Обработчик нажатия на кнопку.
     */
    class EncodeButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // генератор случайных чисел
            final Random rng = new Random();
            // забираем текст для шифрования
            final String textToEncode = inputTextField.getText();
            // забираем текст ключа шифрования
            final String encryptionKeyText = inputKeyTextField.getText();
            int encryptionKey;
            // если текст ключа шифрования пустой то берем случайный ключ
            if (encryptionKeyText.isEmpty()) {
                encryptionKey = rng.nextInt(cryptoAlphabet.ALPHABET.length() - 1);
                inputTextField.setText(String.valueOf(encryptionKey));
            } else {
                // если текст не пустой пытаемся первый элемент текста превратить в целое число, если не получается берем случайный ключ
                try {
                    encryptionKey = Integer.parseInt(encryptionKeyText.substring(0, 1));
                } catch (NumberFormatException nfeIgnored) {
                    encryptionKey = rng.nextInt(cryptoAlphabet.ALPHABET.length() - 1);
                    inputTextField.setText(String.valueOf(encryptionKey));
                }
            }
            // Проводим шифрование и выставляем результат в поле вывода текста
            outputTextField.setText(Encode.encrypt(textToEncode, encryptionKey));
        }
    }
}
