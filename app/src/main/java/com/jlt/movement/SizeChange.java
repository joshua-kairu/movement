package com.jlt.movement;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Movement
 *
 * Simple app to show proper moving of items in Android
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

// begin activity SizeChange
public class SizeChange extends Activity {

    /** CONSTANTS */

    /* Floats */

    public static final float LARGE_SCALE = 1.5f;

    /** VARIABLES */

    /* Card Views */

    @Bind( R.id.asc_cv_card )
    CardView cardView; // the card we'll change the size of

    /* Primitives */

    private boolean

    symmetric = true,
    small = true;

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */

    @Override
    // begin onCreate
    protected void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. use the size change layout
        // 2. bind views

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the size change layout

        setContentView( R.layout.activity_size_change );

        // 2. bind views

        ButterKnife.bind( this );

    } // end onCreate

    /**
     * Other Methods
     */

    // begin method changeSize
    public void changeSize( View view ) {

        // 0. get a fast out slow in interpolator
        // 1. create an object animator scaling the card horizontally
        // 2. use the above interpolator for the job
        // 3. choose an animation duration depending on the symmetry of the card
        // 4. create an object animator scaling the card vertically
        // 5. use the above interpolator for the job
        // 6. animation should last 0.6 seconds
        // 7. start the scaling animations
        // 8. toggle the states so that we switch between large/small a/symmetric

        // 0. get a fast out slow in interpolator

        Interpolator interpolator = AnimationUtils.loadInterpolator( this, android.R.interpolator.fast_out_linear_in );

        // 1. create an object animator scaling the card horizontally

        // the single value at the end means we animate to that value
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat( cardView, View.SCALE_X, ( small == true ) ? LARGE_SCALE : 1f );

        // 2. use the above interpolator for the job

        scaleXAnimator.setInterpolator( interpolator );

        // 3. choose an animation duration depending on the symmetry of the card

        scaleXAnimator.setDuration( ( symmetric == true ) ? 600L : 200L );

        // 4. create an object animator scaling the card vertically

        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat( cardView, View.SCALE_Y, ( small == true ) ? LARGE_SCALE : 1f );

        // 5. use the above interpolator for the job

        scaleYAnimator.setInterpolator( interpolator );

        // 6. animation should last 0.6 seconds

        scaleYAnimator.setDuration( 600L );

        // 7. start the scaling animations

        scaleXAnimator.start();

        scaleYAnimator.start();

        // 8. toggle the states so that we switch between large/small a/symmetric

        small = !small;

        if ( small == true ) { symmetric = !symmetric; }

    } // end method changeSize

} // end activity SizeChange