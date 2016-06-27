package com.example.yoan.plusoumoins;

/**
 * Created by Yoan on 31/05/2016.
 */
public class Keys {
    private static String PREF_NAME = "MyPREFERENCES";
    private static String INIT = "INIT";
    private static String INCREM = "INCREM";
    private static String MAX = "MAX";
    private static String MIN = "MIN";
    private static long INIT_DEF = 0;
    private static long INCREM_DEF = 1;
    private static long MAX_DEF = 1000;
    private static long MIN_DEF = -1000;

    public static String getPrefName() {
        return PREF_NAME;
    }

    public static String getINIT() {
        return INIT;
    }

    public static String getINCREM() {
        return INCREM;
    }

    public static String getMAX() {
        return MAX;
    }

    public static String getMIN() {
        return MIN;
    }

    public static long getInitDef() {
        return INIT_DEF;
    }

    public static long getIncremDef() {
        return INCREM_DEF;
    }

    public static long getMaxDef() {
        return MAX_DEF;
    }

    public static long getMinDef() {
        return MIN_DEF;
    }
}
