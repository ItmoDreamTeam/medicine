package org.itmodreamteam.medicine.util;

import java.util.Random;

public class ReadableStringGenerator {

    private static final String VOWELS = "aeyuio";
    private static final String CONSONANTS = "qwrtplkjhgfdszxcvbnm";

    public static String generateName(int words) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < words; ++i) {
            name.append(generateWord());
            if (i < words - 1) {
                name.append(' ');
            }
        }
        name.setCharAt(0, Character.toUpperCase(name.charAt(0)));
        return name.toString();
    }

    public static String generateWord() {
        return generateWord(10);
    }

    public static String generateWord(int length) {
        StringBuilder readableString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; ++i) {
            readableString.append(i % 2 == 0 ? VOWELS.charAt(random.nextInt(VOWELS.length())) : CONSONANTS.charAt(random.nextInt(CONSONANTS.length())));
        }
        return readableString.toString();
    }
}
