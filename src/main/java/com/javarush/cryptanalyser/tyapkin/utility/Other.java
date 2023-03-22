package com.javarush.cryptanalyser.tyapkin.utility;

public class Other {


    public static void main(String... args){
       CipherStorage cs = getStorage();

       cs.save("teststststst");
        System.out.println(cs.read());
    }

    private static CipherStorage getStorage() {
        return new FileCipherStorage();
    }
}
