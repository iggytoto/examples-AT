package com.javarush.cryptanalyser.tyapkin.utility;

public interface CipherStorage {

    /**
     * Сохраним данный текст
     */
    void save(String text);

    /**
     * @return вернем сохраненный шифр или пустую строку если не нашли файл или он пуст
     */
    String read();
}
