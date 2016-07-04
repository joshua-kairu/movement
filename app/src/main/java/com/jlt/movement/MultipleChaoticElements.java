package com.jlt.movement;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import java.util.Random;

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

// begin activity MultipleChaoticElements
public class MultipleChaoticElements extends Activity {

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
        // 2. animate the views coming in chaotically

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the multiple elements layout

        setContentView( R.layout.activity_multiple_elements );

        // 2. animate the views coming in chaotically

        animateViewsInChaotic();

    } // end onCreate

    /**
     * Other Methods
     */

    // begin method animateViewsInChaotic
    private void animateViewsInChaotic() {

        // 0. get
        // 0a. the root view
        // 0b. the number of children in the root
        // 0c. a linear out slow in interpolator
        // 0d. the maximum width offset of the screen
        // 0e. the maximum height offset of the screen
        // 0f. a random generator
        // 1. for each child
        // 1a. make it visible
        // 1b. make it 85% opaque
        // 1c. make its position relative to left
        // 1c1. randomly smaller than the max width offset
        // 1c2. randomly positive or negative
        // 1d. make its position relative to top
        // 1d1. randomly smaller than the max height offset
        // 1d2. randomly positive or negative
        // 1e. animate
        // 1e1. to its natural position relative to top
        // 1e2. to its natural position relative to left
        // 1e3. to full opacity
        // 1e4. using the above interpolator
        // 1e5. for a sec
        // 1e6. now

        // 0. get

        // 0a. the root view

        ViewGroup rootViewGroup = ( ViewGroup ) findViewById( R.id.ame_ll_root );

        // 0b. the number of children in the root

        int childCount = rootViewGroup.getChildCount();

        // 0c. a linear out slow in interpolator

        Interpolator lOSIInterpolator = AnimationUtils.loadInterpolator( this, android.R.interpolator.linear_out_slow_in );

        // 0d. the maximum width offset of the screen

        // widthPixels - absolute width of the display in pixels
        float maxWidthOffset = 2f * getResources().getDisplayMetrics().widthPixels;

        // 0e. the maximum height offset of the screen

        // heightPixels - absolute height of the display in pixels
        float maxHeightOffset = 2f * getResources().getDisplayMetrics().heightPixels;

        // 0f. a random generator

        Random random = new Random();

        // 1. for each child

        // begin for through each child in the root view
        for ( int i = 0; i < childCount; i++ ) {

            View currentChildView = rootViewGroup.getChildAt( i );

            // 1a. make it visible

            currentChildView.setVisibility( View.VISIBLE );

            // 1b. make it 85% opaque

            currentChildView.setAlpha( 0.85f );

            // 1c. make its position relative to left

            // 1c1. randomly smaller than the max width offset

            float xOffset = random.nextFloat() * maxWidthOffset;

            // 1c2. randomly positive or negative

            if ( random.nextBoolean() == true ) { xOffset *= -1; }

            currentChildView.setTranslationX( xOffset );

            // 1d. make its position relative to top

            // 1d1. randomly smaller than the max height offset

            float yOffset = random.nextFloat() * maxHeightOffset;

            // 1d2. randomly positive or negative

            if ( random.nextBoolean() == true ) { yOffset *= -1; }

            currentChildView.setTranslationY( yOffset );

            // 1e. animate

            currentChildView

                    .animate()

            // 1e1. to its natural position relative to top

                    .translationY( 0f )

            // 1e2. to its natural position relative to left

                    .translationX( 0f )

            // 1e3. to full opacity

                    .alpha( 1f )

            // 1e4. using the above interpolator

                    .setInterpolator( lOSIInterpolator )

            // 1e5. for a sec

                    .setDuration( 1000 )

            // 1e6. now

                    .start();

        } // end for through each child in the root view

    } // end method animateViewsInChaotic

    // begin method containerClick
    public void containerClick( View view ) {

        // 0. animate in the views

        // 0. animate in the views

        animateViewsInChaotic();

    } // end method containerClick
    
} // end activity MultipleChaoticElements