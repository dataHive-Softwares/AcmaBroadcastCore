package com.broad.acmabroad.core.utils;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

public class DimenUtils {
    public static float dpFromPx(@NotNull final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(@NotNull final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
