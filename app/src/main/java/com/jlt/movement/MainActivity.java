package com.jlt.movement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

// begin activity MainActivity
public class MainActivity extends Activity {

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
        // 1. use the main layout

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the main layout

        setContentView( R.layout.activity_main );

    } // end onCreate

    /** Other Methods */

    // method multipleCoherenceClick
    public void multipleCoherenceClick( View view ) { startActivity( new Intent( this, MultipleCoherentElements.class ) ); }

    // method multipleIncoherenceClick
    public void multipleIncoherenceClick( View view ) { startActivity( new Intent( this, MultipleChaoticElements.class ) ); }

    // method curvedMotionClick
    public void curvedMotionClick( View view ) { startActivity( new Intent( this, CurveMotionList.class ) ); }

    // method sizeChangeClick
    public void sizeChangeClick( View view ) { startActivity( new Intent( this, SizeChange.class ) ); }

    /** INNER CLASSES */

} // end activity MainActivity