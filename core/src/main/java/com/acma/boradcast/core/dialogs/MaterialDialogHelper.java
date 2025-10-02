package com.acma.boradcast.core.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MaterialDialogHelper {
    @NonNull
    public static Dialog createDialog(
            Context context,
            @StringRes int titleRes,
            @StringRes int messageRes,
            @StringRes int positiveButtonText,
            @StringRes int negativeButtonText,
            OnClickListener positiveClickListener
    ) {
        return createDialog(context, titleRes, messageRes, positiveButtonText,
                negativeButtonText, positiveClickListener, null);
    }

    @NonNull
    public static Dialog createDialog(
            Context context,
            @StringRes int titleRes,
            @StringRes int messageRes,
            @StringRes int positiveButtonText,
            @StringRes int negativeButtonText,
            OnClickListener positiveClickListener,
            OnClickListener negativeClickListener
    ) {
        DialogInterface.OnClickListener onPositiveClickListener = (dialog, which) -> {
            if (positiveClickListener != null)
                positiveClickListener.onClick();
        };
        DialogInterface.OnClickListener onNegativeClickListener = (dialog, which) -> {
            if (negativeClickListener != null)
                negativeClickListener.onClick();
        };
        return new MaterialAlertDialogBuilder(context)
                .setTitle(titleRes)
                .setMessage(messageRes)
                .setPositiveButton(positiveButtonText, onPositiveClickListener)
                .setNegativeButton(negativeButtonText, onNegativeClickListener)
                .create();
    }

    public interface OnClickListener {
        void onClick();
    }
}