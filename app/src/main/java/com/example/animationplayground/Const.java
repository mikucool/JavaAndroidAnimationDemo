package com.example.animationplayground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Const {
    private static final String DEFAULT_PACKAGE = "com.example.animationplayground.";
    public static final List<Map<String, String>> MAP_LIST = new ArrayList<>();

    static {
        Map<String, String> viewsAnimationMap = new HashMap<>();
        viewsAnimationMap.put("1 BasicXMLAnimation", DEFAULT_PACKAGE + "views_animation.fragment.Animation1Fragment");
        viewsAnimationMap.put("2 BasicCodeAnimation", DEFAULT_PACKAGE + "views_animation.fragment.Animation2Fragment");
        viewsAnimationMap.put("3 CombineListener", DEFAULT_PACKAGE + "views_animation.fragment.Animation3Fragment");
        viewsAnimationMap.put("4 Interpolator", DEFAULT_PACKAGE + "views_animation.fragment.Animation4Fragment");
        viewsAnimationMap.put("5 Example_1", DEFAULT_PACKAGE + "views_animation.fragment.Animation5Fragment");
        MAP_LIST.add(viewsAnimationMap);

        Map<String, String> propertiesAnimationMap = new HashMap<>();
        propertiesAnimationMap.put("1 PropertiesAnimationsXML", DEFAULT_PACKAGE + "properties_animation.fragment.PropertiesAnimationDemoFragment");
        propertiesAnimationMap.put("2 PropertiesAnimationsProgramming", DEFAULT_PACKAGE + "properties_animation.fragment.PropertiesAnimationDemo2Fragment");
        MAP_LIST.add(propertiesAnimationMap);
    }
}
