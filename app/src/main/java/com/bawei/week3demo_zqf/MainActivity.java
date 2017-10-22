package com.bawei.week3demo_zqf;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bawei.week3demo_zqf.Presenter.AnimatorPresenter;
import com.bawei.week3demo_zqf.View.IViewAnimator;
import com.bawei.week3demo_zqf.View.MyView;

public class MainActivity extends AppCompatActivity implements IViewAnimator {

    private ImageView mImage;
    private MyView mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... params) {

                for (int i = 0; i <= 360; i++) {
                    SystemClock.sleep(4000/360);
                    publishProgress(i);
                }
                return null;
            }
            @Override
            protected void onProgressUpdate(Integer... values) {
                if (mProgressView.getProgress() >= 360) {
                    mProgressView.setProgress(360);
                }
                mProgressView.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                startActivity(new Intent(MainActivity.this,RecyclerActivity.class));
            }
        }.execute();
        //创建启动页Activity，在欢迎页中使用属性动画，完成Logo图标从上向下移动到屏幕中间
        AnimatorPresenter presenter = new AnimatorPresenter(this, this);
        presenter.setAnimatorForImage(mImage);


    }

    private void initView() {
        mImage = (ImageView) findViewById(R.id.image);
        mProgressView = (MyView) findViewById(R.id.progressView);
    }


    @Override
    public float getHeight() {
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height / 2;
    }

}
