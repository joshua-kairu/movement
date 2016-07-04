package com.jlt.movement;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

// begin activity CurveMotionList
public class CurveMotionList extends Activity {

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
        // 1. use the curve motion grid layout
        // 2. initialize the recycler view
        // 2a. from the layout
        // 2b. with the message adapter
        // 2c. with a linear layout manager
        // 2d. with a fixed size

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the curve motion grid layout

        setContentView( R.layout.activity_curved_motion_grid );

        // 2. initialize the recycler view

        // 2a. from the layout

        RecyclerView listRecyclerView = ( RecyclerView ) findViewById( R.id.acmg_rv_list );

        // 2b. with the message adapter

        listRecyclerView.setAdapter( new MessageAdapter( this ) );

        // 2c. with a linear layout manager

        listRecyclerView.setLayoutManager( new LinearLayoutManager( this ) );

        // 2d. with a fixed size

        listRecyclerView.setHasFixedSize( true );

    } // end onCreate

    /** Other Methods */

    /* Inner Classes */

    // begin class MessageAdapter
    // adapter for the recycler view
    public class MessageAdapter extends RecyclerView.Adapter< MessageHolder > {

        /** CONSTANTS */

        /* Arrays */

        private final int COLORS[] = new int[]
                { 0xff956689, 0xff80678A, 0xff6A6788,
                  0xff546683, 0xff3F657B, 0xff3F657B };

        /** VARIABLES */

        /* Activities */

        private Activity hostActivity; // the host activity

        /* Layout Inflaters */

        private LayoutInflater layoutInflater; // a layout inflater

        /* CONSTRUCTOR */

        // begin constructor
        public MessageAdapter( Activity theHostActivity ) {

            // 0. initialize the
            // 0a. host activity
            // 0b. inflater from the host activity

            // 0. initialize the

            // 0a. host activity

            this.hostActivity = theHostActivity;

            // 0b. inflater from the host activity

            layoutInflater = LayoutInflater.from( hostActivity );

        } // end constructor

        /** METHODS */

        /** Getters and Setters */

        /** Overrides */

        @Override
        // begin onCreateViewHolder
        public MessageHolder onCreateViewHolder( ViewGroup parent, int viewType ) {

            // 0. use the message view for each of the items in the recycler

            // 0. use the message view for each of the items in the recycler

            return new MessageHolder( layoutInflater.inflate( R.layout.message, parent, false ) );

        } // end onCreateViewHolder

        @Override
        // begin onBindViewHolder
        public void onBindViewHolder( final MessageHolder messageHolder, final int position ) {

            // 0. get the color at the current position
            // 1. use gotten color as the tint of the current avatar
            // 2. when an item is clicked
            // 2a. plan to start a curved motion detail activity
            // 2b. animate the transition using a curve for all even items in the recycler
            // 2c. pass the gotten color to the activity
            // 2d. pass the condition of curving to the activity
            // 2e. transition to the activity using a shared content transition based on the avatar
            // 2f. start the curve motion detail activity

            // 0. get the color at the current position

            final int currentColor = COLORS[ position % COLORS.length ];

            // 1. use gotten color as the tint of the current avatar

            // setBackgroundTintList - apply a tint to the background drawable so subsequent drawings to this drawables will show this tint
            // ColorStateList -  maps View state sets to colors
            messageHolder.avatar.setBackgroundTintList( ColorStateList.valueOf( currentColor ) );

            // 2. when an item is clicked

            // begin messageHolder.itemView.setOnClickListener
            messageHolder.itemView.setOnClickListener(

                    // begin new View.OnClickListener
                    new View.OnClickListener() {

                        @Override
                        // begin onClick
                        public void onClick( View v ) {

                            // 2a. plan to start a curved motion detail activity

                            Intent curvedMotionDetailIntent = new Intent( CurveMotionList.this, CurveMotionDetail.class );

                            // 2b. animate the transition using a curve for all even items in the recycler

                            boolean curve = ( ( position % 2 ) == 0 );

                            // 2c. pass the gotten color to the activity

                            curvedMotionDetailIntent.putExtra( CurveMotionDetail.EXTRA_COLOR, currentColor );

                            // 2d. pass the condition of curving to the activity

                            curvedMotionDetailIntent.putExtra( CurveMotionDetail.EXTRA_CURVE_CONDITION, curve );

                            // 2e. transition to the activity using a shared content transition based on the avatar

                            Bundle transitionBundle = ActivityOptions.makeSceneTransitionAnimation(
                                    CurveMotionList.this, messageHolder.avatar, messageHolder.avatar.getTransitionName() ).toBundle();

                            // 2f. start the curve motion detail activity

                            startActivity( curvedMotionDetailIntent, transitionBundle );

                        } // end onClick

                    } // end new View.OnClickListener

            ); // end messageHolder.itemView.setOnClickListener

        } // end onBindViewHolder

        @Override
        // getItemCount
        public int getItemCount() { return 64; }

        /** Other Methods */

        /** INNER CLASSES */

    } // end class MessageAdapter

    /** INNER CLASSES */

    // begin class MessageHolder
    // a view holder for the message
    public class MessageHolder extends RecyclerView.ViewHolder {

        /** CONSTANTS */

        /** VARIABLES */

        /* Views */

        View

        avatar, // the avatar view
        title, // the title view
        subtitle; // the subtitle view

        /* CONSTRUCTOR */

        // begin constructor
        public MessageHolder( View itemView ) {

            // 0. super things
            // 1. initialize the
            // 1a. avatar
            // 1b. title
            // 1c. subtitle

            // 0. super things

            super( itemView );

            // 1. initialize the

            // 1a. avatar

            avatar = itemView.findViewById( R.id.m_avatar );

            // 1b. title

            title = itemView.findViewById( R.id.m_title );

            // 1c. subtitle

            subtitle = itemView.findViewById( R.id.m_subtitle );

        } // end constructor

        /** METHODS */

        /** Getters and Setters */

        /** Overrides */

        /** Other Methods */

    } // end class MessageHolder

} // end activity CurveMotionList