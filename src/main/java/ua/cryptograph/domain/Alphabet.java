package ua.cryptograph.domain;

import java.util.Map;

public class Alphabet {
    public Map<String, String> nameToAlphabet() {
        return Map.of("English", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,\"':!? ",
                "Ukrainian", "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\"':!? ");
    }
}
