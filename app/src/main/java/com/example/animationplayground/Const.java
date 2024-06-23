package com.example.animationplayground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Const {
    private static final String DEFAULT_PACKAGE = "com.example.animationplayground.";
    public static final List<Map<String, String>> MAP_LIST = new ArrayList<>();

    static {
        // 1
        Map<String, String> viewsAnimationMap = new HashMap<>();
        viewsAnimationMap.put("1 BasicXMLAnimation", DEFAULT_PACKAGE + "views_animation.fragment.Animation1Fragment");
        viewsAnimationMap.put("2 BasicCodeAnimation", DEFAULT_PACKAGE + "views_animation.fragment.Animation2Fragment");
        viewsAnimationMap.put("3 CombineListener", DEFAULT_PACKAGE + "views_animation.fragment.Animation3Fragment");
        viewsAnimationMap.put("4 Interpolator", DEFAULT_PACKAGE + "views_animation.fragment.Animation4Fragment");
        viewsAnimationMap.put("5 Example_1", DEFAULT_PACKAGE + "views_animation.fragment.Animation5Fragment");
        MAP_LIST.add(viewsAnimationMap);
        // 2
        Map<String, String> propertiesAnimationMap = new HashMap<>();
        propertiesAnimationMap.put("1 PropertiesAnimationsXML", DEFAULT_PACKAGE + "properties_animation.fragment.PropertiesAnimationDemoFragment");
        propertiesAnimationMap.put("2 PropertiesAnimationsProgramming", DEFAULT_PACKAGE + "properties_animation.fragment.PropertiesAnimationDemo2Fragment");
        MAP_LIST.add(propertiesAnimationMap);
        // 3
        Map<String, String> canvasMap = new HashMap<>();
        canvasMap.put("1 BasicShape", DEFAULT_PACKAGE + "canvas.fragment.BasicShapeFragment");
        canvasMap.put("2 CustomSelector", DEFAULT_PACKAGE + "canvas.fragment.CustomSelectorFragment");
        MAP_LIST.add(canvasMap);
        // 4
        Map<String, String> frameAniamtionMap = new HashMap<>();
        frameAniamtionMap.put("1 Demo", DEFAULT_PACKAGE + "frame_animation.fragment.FrameAnimationDemoFragment");
        MAP_LIST.add(frameAniamtionMap);
        // 5
        Map<String, String> layoutAniamtionMap = new HashMap<>();
        layoutAniamtionMap.put("1 Layout Animation", DEFAULT_PACKAGE + "layout_animation.fragment.LayoutAnimationDemoFragment");
        layoutAniamtionMap.put("2 Layout Transition", DEFAULT_PACKAGE + "layout_animation.fragment.LayoutTransitionDemoFragment");
        MAP_LIST.add(layoutAniamtionMap);
        // 6
        Map<String, String> activityTransactionMap = new HashMap<>();
        activityTransactionMap.put("1 Shared Element Transition", DEFAULT_PACKAGE + "transition_animation.ui.TransitionOriginFragment");
        MAP_LIST.add(activityTransactionMap);

    }
}
