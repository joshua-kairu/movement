package com.jlt.movement;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.View;

/**
 * com.jlt.movement
 * <p/>
 * <one line to give the program's name and a brief idea of what it does.>
 * <p/>
 * Copyright (C) 2016 Kairu Joshua Wambugu
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */

// begin activity CurveMotionDetail
public class CurveMotionDetail extends Activity {

    /** CONSTANTS */

    /* Strings */

    public static final String

    EXTRA_COLOR = "EXTRA_COLOR", // extra for the color
    EXTRA_CURVE_CONDITION = "EXTRA_CURVE_CONDITION"; // extra for the curve condition

    /** VARIABLES */

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */

    @Override
    // begin onCreate
    protected void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. use the curve motion detail layout
        // 2. tint the avatar based on the passed extra
        // 3. if we should use curved motion, do so

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the curve motion detail layout

        setContentView( R.layout.activity_curved_motion_detail );

        // 2. tint the avatar based on the passed extra

        int tint = getIntent().getIntExtra( CurveMotionDetail.EXTRA_COLOR, 0xffff00ff );

        View avatarView = findViewById( R.id.acmd_v_avatar );

        avatarView.setBackgroundTintList( ColorStateList.valueOf( tint ) );

        // 3. if we should use curved motion, do so

        boolean curve = getIntent().getBooleanExtra( CurveMotionDetail.EXTRA_CURVE_CONDITION, false );

        getWindow().setSharedElementEnterTransition( TransitionInflater.from( this ).inflateTransition( ( curve == true ) ? R.transition.curve : R.transition.move ) );

    } // end onCreate

    /** Other Methods */

    /* Inner Classes */

} // end activity CurveMotionDetail