package com.broad.core.utils;

@SuppressWarnings("unused")
public class UnboxUtils {

    public static int safeUnbox(Integer boxed) {
        return boxed == null ? 0 : boxed;
    }

    public static long safeUnbox(Long boxed) {
        return boxed == null ? 0L : boxed;
    }

    public static short safeUnbox(Short boxed) {
        return boxed == null ? 0 : boxed;
    }

    public static byte safeUnbox(Byte boxed) {
        return boxed == null ? 0 : boxed;
    }

    public static char safeUnbox(Character boxed) {
        return boxed == null ? '\u0000' : boxed;
    }

    public static double safeUnbox(Double boxed) {
        return boxed == null ? 0.0 : boxed;
    }

    public static float safeUnbox(Float boxed) {
        return boxed == null ? 0f : boxed;
    }

    public static boolean safeUnbox(Boolean boxed) {
        return boxed != null && boxed;
    }
}