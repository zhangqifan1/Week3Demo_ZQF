package com.bawei.week3demo_zqf.Model;

import android.animation.AnimatorSet;
import android.content.Context;
import android.widget.ImageView;

/**
 * Created by 张祺钒
 * on2017/10/21.
 */

public interface IModelAnimator {
     AnimatorSet getAnimatorSet(ImageView imageView,Context context,float height);
}
