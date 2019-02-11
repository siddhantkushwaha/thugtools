package com.siddhantkushwaha.android.thugtools.thugtools.custom;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import org.jetbrains.annotations.NotNull;

public class CustomDialog extends DialogFragment {

    public interface ClickListener {
        void onPositiveButtonPressed(String key);

        void onNegativeButtonPressed(String key);

        void onNeutralButtonPressed(String key);
    }

    public static CustomDialog newInstance(String key, String title, String message, String positiveLabel, String negativeLabel, String neutralLabel, Boolean cancellable) {

        CustomDialog dialogFragment = new CustomDialog();
        Bundle args = new Bundle();
        args.putString("KEY", key);
        args.putString("TITLE", title);
        args.putString("MESSAGE", message);
        args.putString("POSITIVE_LABEL", positiveLabel);
        args.putString("NEGATIVE_LABEL", negativeLabel);
        args.putString("NEUTRAL_LABEL", neutralLabel);
        args.putBoolean("CANCELLABLE", cancellable);
        dialogFragment.setArguments(args);
        return dialogFragment;
    }

    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Bundle args = this.getArguments();

        if (args == null)
            throw new RuntimeException(CustomDialog.class.toString() + " Arguments cannot be null.");

        final Activity activity = getActivity();
        if (activity == null)
            throw new RuntimeException(CustomDialog.class.toString() + " Activity cannot be null.");

        setCancelable(args.getBoolean("CANCELLABLE"));

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle(args.getString("TITLE"))
                .setMessage(args.getString("MESSAGE"));

        if (args.getString("POSITIVE_LABEL") != null) {

            alertDialogBuilder.setPositiveButton(args.getString("POSITIVE_LABEL"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ((ClickListener) activity).onPositiveButtonPressed(args.getString("KEY"));
                }
            });
        }

        if (args.getString("NEGATIVE_LABEL") != null) {

            alertDialogBuilder.setNegativeButton(args.getString("NEGATIVE_LABEL"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ((ClickListener) activity).onNegativeButtonPressed(args.getString("KEY"));
                }
            });
        }

        if (args.getString("NEUTRAL_LABEL") != null) {

            alertDialogBuilder.setNeutralButton(args.getString("NEUTRAL_LABEL"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ((ClickListener) activity).onNeutralButtonPressed(args.getString("KEY"));
                }
            });
        }

        return alertDialogBuilder.create();
    }
}
