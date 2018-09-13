package com.tabao.core.utils;

import java.util.HashSet;
import java.util.Set;

public class ShiroKit
{

    private static ThreadLocal<String> requestURI = new ThreadLocal<String>();

    private static Set<String> buttonSet = new HashSet<>();

    private ShiroKit()
    {
    }

    public static void setRequestURI(String uri)
    {
        requestURI.set(uri);
    }

    public static String getRequestURI()
    {
        return requestURI.get();
    }

    public static void initButtonCode(Set<String> button)
    {
        buttonSet = button;
    }

    public static boolean isAuthzButton(String code)
    {
        return buttonSet.contains(code);
    }
}
