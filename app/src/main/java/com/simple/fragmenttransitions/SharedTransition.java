package com.simple.fragmenttransitions;

import android.annotation.TargetApi;
import android.os.Build;
import android.transition.TransitionSet;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.ChangeImageTransform;
import android.util.AttributeSet;


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class SharedTransition extends TransitionSet {
    public SharedTransition() {
        init();
    }

    public SharedTransition(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOrdering(ORDERING_TOGETHER);
                addTransition(new ChangeBounds()).
                addTransition(new ChangeTransform());           
                
                
    }
}
