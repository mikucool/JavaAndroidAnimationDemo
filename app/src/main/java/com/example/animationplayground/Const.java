package com.example.animationplayground;

import java.util.HashMap;

public class Const {
    private static final String DEFAULT_PACKAGE = "com.example.animationplayground.fragment";
    public static final HashMap<String, String> FRAGMENT_MAP = new HashMap<>();

    static {
        FRAGMENT_MAP.put("animation1", DEFAULT_PACKAGE + ".Animation1Fragment");
        FRAGMENT_MAP.put("animation2", DEFAULT_PACKAGE + ".Animation2Fragment");
        FRAGMENT_MAP.put("animation3", DEFAULT_PACKAGE + ".Animation3Fragment");
        FRAGMENT_MAP.put("animation4", DEFAULT_PACKAGE + ".Animation4Fragment");
    }
}
