package com.jlt.movement;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
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
public class SizeChange extends AppCompatActivity {

    /** CONSTANTS */

    /* Floats */

    public static final float LARGE_SCALE = 1.5f;

    /** VARIABLES */

    /* Card Views */

    @Bind( R.id.asc_cv_card )
    CardView cardView; // the card we'll change the size of

    /* Primitives */

    private boolean

    animateSidesSymmetrically = true, // boolean to tell if we are to animate length and width together
    cardSmall = true; // boolean to tell if the card is small or not

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
    public void changeSize( boolean animateSidesSimultaneously ) {

        // 0. get a fast out slow in interpolator
        // 1. create an object animator scaling the card horizontally
        // 2. use the above interpolator for the job
        // 3. choose an animation duration depending on the simultaneity(;-)) of the animation
        // 4. create an object animator scaling the card vertically
        // 5. use the above interpolator for the job
        // 6. animation should last 0.6 seconds
        // 7. start the scaling animations
        // 8. toggle the states so that we switch between large/small 

        // 0. get a fast out slow in interpolator

        Interpolator interpolator = new LinearOutSlowInInterpolator();

        // 1. create an object animator scaling the card horizontally

        // the single value at the end means we animate to that value
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat( cardView, View.SCALE_X, ( cardSmall == true ) ? LARGE_SCALE : 1f );

        // 2. use the above interpolator for the job

        scaleXAnimator.setInterpolator( interpolator );

        // 3. choose an animation duration depending on the simultaneity(;-)) of the animation

        scaleXAnimator.setDuration( ( animateSidesSimultaneously == true ) ? 600L : 200L );

        // 4. create an object animator scaling the card vertically

        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat( cardView, View.SCALE_Y, ( cardSmall == true ) ? LARGE_SCALE : 1f );

        // 5. use the above interpolator for the job

        scaleYAnimator.setInterpolator( interpolator );

        // 6. animation should last 0.6 seconds

        scaleYAnimator.setDuration( 600L );

        // 7. start the scaling animations

        scaleXAnimator.start();

        scaleYAnimator.start();

        // 8. toggle the states so that we switch between large/small 

        cardSmall = ! cardSmall;

    } // end method changeSize

    // begin method badButtonClick
    public void badButtonClick( View view ) {

        // a bad size change makes a view look like it's being zoomed in
        // as in, the size change affects view length and width simultaneously

        // 0. animate both of the card's size simultaneously

        // 0. animate both of the card's size simultaneously

        changeSize( true );

    } // end method badButtonClick

    // begin method goodButtonClick
    public void goodButtonClick( View view ) {

        // a good size change affects view length and width differently
        // but ends up with the desired end size

        // 0. animate both of the card's size not simultaneously

        // 0. animate both of the card's size not simultaneously

        changeSize( false );

    } // end method goodButtonClick

} // end activity SizeChange