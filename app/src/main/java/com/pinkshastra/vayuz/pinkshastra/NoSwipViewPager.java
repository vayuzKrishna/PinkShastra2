package com.pinkshastra.vayuz.pinkshastra;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by krishnathakur on 1/14/16.
 */
public class NoSwipViewPager extends ViewPager {

    public NoSwipViewPager(Context context) {
        super(context);
    }

    public NoSwipViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages
        return false;
    }
}
