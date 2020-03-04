package me.victor.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

/**
 * @author Victor
 */
public class MyFrameLayout extends FrameLayout {
    private Scroller mScroller;

    public MyFrameLayout(Context context) {
        super(context);
    }

    public MyFrameLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
        postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("Scroller", getScrollX() + "," + getScrollY());
                mScroller.startScroll(0, 0, 200, 200);
                invalidate();
            }
        }, 2000);
    }

    public MyFrameLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            Log.d("Scroller", String.valueOf(mScroller.getCurrY()));
            scrollTo(mScroller.getCurrY(), mScroller.getCurrY());
            invalidate();
        }
    }
}