package com.jlt.movement;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

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

// begin activity MultipleCoherentElements
public class MultipleCoherentElements extends Activity {

    /** CONSTANTS */

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
        // 1. use the multiple elements layout
        // 2. animate the views coming in

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the multiple elements layout

        setContentView( R.layout.activity_multiple_elements );

        // 2. animate the views coming in

        animateViewsIn();

    } // end onCreate

    /**
     * Other Methods
     */

    // begin method animateViewsIn
    private void animateViewsIn() {

        // 0. get
        // 0a. the root view
        // 0b. the number of children in the root
        // 0c. the offset from XML
        // 0d. a linear out slow in interpolator
        // 1. for each child
        // 1a. make it visible
        // 1b. make its position relative to top be 1.5 times more that the previous child
        // 1c. make it 85% opaque
        // 1d. animate
        // 1d1. to its natural position relative to top
        // 1d2. to full opacity
        // 1d3. using the above interpolator
        // 1d4. for a sec
        // 1d5. now
        // 1e. make the next child have that 1.5 times relative top difference

        // 0. get

        // 0a. the root view

        ViewGroup rootViewGroup = ( ViewGroup ) findViewById( R.id.ame_ll_root );

        // 0b. the number of children in the root

        int childCount = rootViewGroup.getChildCount();

        // 0c. the offset from XML

        // getDimensionPixelSize - Gets a dimen multiplied by the appropriate metric and truncated to integer pixels
        float yOffset = getResources().getDimensionPixelSize( R.dimen.offset_y );

        // 0d. a linear out slow in interpolator

        Interpolator lOSIInterpolator = AnimationUtils.loadInterpolator( this, android.R.interpolator.linear_out_slow_in );

        // 1. for each child

        // begin for through each child in the view group
        for ( int i = 0; i < childCount; i++ ) {

            View currentView = rootViewGroup.getChildAt( i );

            // 1a. make it visible

            currentView.setVisibility( View.VISIBLE );

            // 1b. make its position relative to top be 1.5 times more that the previous child

            currentView.setTranslationY( yOffset );

            Log.e( getClass().getSimpleName(), "animateViewsIn for loop: currentView translationY is " + yOffset  );

            // 1c. make it 85% opaque

            currentView.setAlpha( 0.85F );

            Log.e( getClass().getSimpleName(), "animateViewsIn for loop: currentView alpha 0.85 "  );

            // 1d. animate

            currentView

                    .animate()

            // 1d1. to its natural position relative to top

                    .translationY( 0f )

            // 1d2. to full opacity

                    .alpha( 1f )

            // 1d3. using the above interpolator

                    .setInterpolator( lOSIInterpolator )

            // 1d4. for a sec

                    .setDuration( 1000L )

            // 1d5. now

                    .start();

            Log.e( getClass().getSimpleName(), "animateViewsIn for loop: currentView translationY is told to animate" );

            // 1e. make the next child have that 1.5 times relative top difference

            yOffset *= 1.5f;

        } // end for through each child in the view group

    } // end method animateViewsIn

    // begin method containerClick
    public void containerClick( View view ) {

        // 0. animate in the views

        // 0. animate in the views

        animateViewsIn();

    } // end method containerClick

} // end activity MultipleCoherentElements
