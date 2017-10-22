package com.bawei.week3demo_zqf.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    private Paint paint;
    private float progress;
    private int countProgress;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(0);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(300,300,150,paint);
        canvas.drawCircle(300,300,130,paint);
        paint.setTextSize(30);

        canvas.drawText(countProgress+"%",280,280,paint);

        paint.setStrokeWidth(20);
        RectF oval=new RectF(160,160,440,440);
        canvas.drawArc(oval,270,progress,false,paint);
    }

    public void setProgress(float progress) {
        this.progress = progress;
        countProgress= (int) (progress*100/360);
        invalidate();
    }

    public float getProgress() {
        return progress;
    }
}