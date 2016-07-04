/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.jlt.movement;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

// begin fragment OldVersionDialogFragment
public class OldVersionDialogFragment extends DialogFragment {

    /** CONSTANTS */

    /** VARIABLES */

    /**
     * CONSTRUCTOR
     */

    // empty constructor for fragment subclasses
    public OldVersionDialogFragment() {
    }

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */
    @NonNull
    @Override

    // begin onCreateDialog
    public Dialog onCreateDialog( Bundle savedInstanceState ) {

        // 0. get an alert dialog builder
        // 1. build the dialog
        // 1a. use the string message
        // 1b. for the negative button
        // 1b1. use the string negative
        // 2. create and return the dialog

        // 0. get an alert dialog builder

        AlertDialog.Builder builder = new AlertDialog.Builder( getActivity() );

        // 1. build the dialog

        builder

        // 1a. use the string message

            .setMessage( R.string.dialog_message_error_old_version )

        // 1b. for the negative button

        // 1b1. use the string negative

            .setNegativeButton( R.string.dialog_message_negative, null );

        // 2. create and return the dialog

        return builder.create();

    } // end onCreateDialog

    /** Other Methods */

    /** INNER CLASSES */

} // end fragment OldVersionDialogFragment