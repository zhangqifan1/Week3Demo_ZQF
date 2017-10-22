package com.bawei.week3demo_zqf.Model;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.ImageView;

/**
 * Created by 张祺钒
 * on2017/10/21.
 */

public class AnimatorModel implements IModelAnimator {

    @Override
    public AnimatorSet getAnimatorSet(ImageView imageView, Context context,float height) {


        AnimatorSet animatorSet=new AnimatorSet();
        ObjectAnimator objectAnimatorTranslate = ObjectAnimator.ofFloat(imageView, "translationY", 0f, height);
        ObjectAnimator objectAnimatorScaleX = ObjectAnimator.ofFloat(imageView, "scaleX",new float[]{1,2,0,1});
        ObjectAnimator objectAnimatorScaleY = ObjectAnimator.ofFloat(imageView, "scaleY",new float[]{1,2,0,1});
        animatorSet.play(objectAnimatorScaleX).with(objectAnimatorScaleY).after(objectAnimatorTranslate);
        animatorSet.setDuration(3000);
        return animatorSet;
    }
}
