package com.bawei.week3demo_zqf.Presenter;

import android.content.Context;
import android.widget.ImageView;

import com.bawei.week3demo_zqf.Model.AnimatorModel;
import com.bawei.week3demo_zqf.Model.IModelAnimator;
import com.bawei.week3demo_zqf.View.IViewAnimator;

/**
 * Created by 张祺钒
 * on2017/10/21.
 */

public class AnimatorPresenter {
    private IModelAnimator iModelAnimator;
    private IViewAnimator iViewAnimator;
    private Context context;

    public AnimatorPresenter(IViewAnimator iViewAnimator, Context context) {
        this.iViewAnimator = iViewAnimator;
        this.context = context;
        iModelAnimator = new AnimatorModel();
    }

    public void setAnimatorForImage(ImageView image) {
        iModelAnimator.getAnimatorSet(image, context, iViewAnimator.getHeight()).start();
    }

}
