package com.javarush.cryptanalyser.tyapkin.applications;

import com.javarush.cryptanalyser.tyapkin.gui.EncodePanel;

import javax.swing.*;

public class GuiEncoderApplication {

    /**
     * Точка входа в приложение.
     */
    public static void main(String... args) {
        // Новая рамка
        JFrame frame = new JFrame();
        // Устанавливаем размер
        frame.setSize(800, 600);
        // Добавляем в нее панель кодирования
        EncodePanel encodePanel = new EncodePanel();
        frame.add(encodePanel);
        // делаем видимой
        frame.setVisible(true);
    }
}
