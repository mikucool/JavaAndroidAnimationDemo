package com.example.animationplayground;

import java.util.HashMap;

public class Const {
    private static final String DEFAULT_PACKAGE = "com.example.animationplayground.fragment";
    public static final HashMap<String, String> FRAGMENT_MAP = new HashMap<>();

    static {
        FRAGMENT_MAP.put("1 BasicXMLAnimation", DEFAULT_PACKAGE + ".Animation1Fragment");
        FRAGMENT_MAP.put("2 BasicCodeAnimation", DEFAULT_PACKAGE + ".Animation2Fragment");
        FRAGMENT_MAP.put("3 CombineListener", DEFAULT_PACKAGE + ".Animation3Fragment");
        FRAGMENT_MAP.put("4 Interpolator", DEFAULT_PACKAGE + ".Animation4Fragment");
        FRAGMENT_MAP.put("5 Example_1", DEFAULT_PACKAGE + ".Animation5Fragment");
    }
}
