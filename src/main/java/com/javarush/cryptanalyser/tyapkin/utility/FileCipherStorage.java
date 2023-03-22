package com.javarush.cryptanalyser.tyapkin.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileCipherStorage implements CipherStorage {
    String root = System.getProperty("user.dir");
    String output = "output.txt";
    String fileOutput = root + File.separator + output;


    @Override
    public void save(String text) {
        try {
            Files.writeString(Path.of(fileOutput), text, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return вернем сохраненный шифр или пустую строку если не нашли файл или он пуст
     */
    @Override
    public String read() {
        try {
            List<String> allStrings = null;
            allStrings = Files.readAllLines(Path.of(fileOutput));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < allStrings.size(); i++) {
                sb.append(allStrings.get(i));
            }
            return sb.toString();
        } catch (IOException e) {
            System.out.printf(e.getMessage());
            return "";
        }
    }
}
