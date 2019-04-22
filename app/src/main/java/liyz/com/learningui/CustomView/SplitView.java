package liyz.com.learningui.CustomView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;
import java.util.List;

import liyz.com.learningui.R;

/**
 * 粒子效果
 */
public class SplitView extends View {

    private Paint paint;
    private Bitmap bitmap;
    private int d = 4;
    private List<Ball> balls = new ArrayList<>();
    private ValueAnimator valueAnimator;

    public SplitView(Context context) {
        this(context,null);
    }

    public SplitView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SplitView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        paint = new Paint();
//        paint = new Paint();
//        paint.setStrokeWidth(2);
//        paint.setStyle(Paint.Style.STROKE);

        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.image1);

        for (int i = 0;i < bitmap.getWidth();i++){
            for (int j = 0; j <bitmap.getHeight();j++){
                Ball ball = new Ball();
                ball.x = i * d + d/2;
                ball.y = j * d + d/2;
                ball.r = d /2;
                //速度(-20,20)
                ball.vX = (float) (Math.pow(-1, Math.ceil(Math.random() * 1000)) * 20 * Math.random());
                ball.vY = rangInt(-15, 35);


                ball.aY = 0;
                ball.aY = 0.98f;

                ball.color = bitmap.getPixel(i,j);
                balls.add(ball);
            }
        }

        valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (balls.get(0).y < bitmap.getHeight()){
                    updateBall();
                    invalidate();
                }
            }
        });
    }

    private int rangInt(int i, int j) {
        int max = Math.max(i, j);
        int min = Math.min(i, j) - 1;
        //在0到(max - min)范围内变化，取大于x的最小整数 再随机
        return (int) (min + Math.ceil(Math.random() * (max - min)));
    }


    private void updateBall() {

        for (Ball ball: balls) {
            ball.x += ball.vX;
            ball.y += ball.vY;
            ball.vX += ball.aX;
            ball.vY += ball.aY;
        }

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(200,200);
        for (Ball ball :balls ) {
            paint.setColor(ball.color);
            canvas.drawCircle(ball.x,ball.y,ball.r,paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            // draw
            valueAnimator.start();
        }

        return super.onTouchEvent(event);
    }
}
