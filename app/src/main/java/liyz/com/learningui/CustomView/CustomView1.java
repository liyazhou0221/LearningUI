package liyz.com.learningui.CustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import liyz.com.learningui.R;

public class CustomView1 extends View {


    private Paint mpaint;
    private Shader mShader;

    public CustomView1(Context context) {
        super(context);
    }

    public CustomView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mpaint = new Paint();
        mpaint.setColor(Color.BLACK);
//        mpaint.setARGB(255,255,255,0);
//        mpaint.setStyle(Paint.Style.STROKE);//描边
        mpaint.setStyle(Paint.Style.FILL);//填充
        mpaint.setAntiAlias(true);// 抗锯齿


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mpaint == null){
            init();
        }

        //线性渲染
//        mShader = new LinearGradient(0,0,500,500,new int[]{Color.RED,Color.BLUE},null, Shader.TileMode.CLAMP);
//        mShader = new LinearGradient(0,0,500,500,new int[]{Color.RED,Color.BLUE,Color.GREEN},new float[]{0,0.5f,1}, Shader.TileMode.CLAMP);
//        mpaint.setShader(mShader);
//        canvas.drawCircle(250,250,250,mpaint);// 画圆
        // 矩形
//        canvas.drawRect(0,0,500,500,mpaint);

        // 环形渲染
//        mShader = new RadialGradient(250,250,250,new int[]{Color.RED,Color.GREEN,Color.BLUE},null, Shader.TileMode.CLAMP);
////        mShader = new RadialGradient(250,250,250,new int[]{Color.RED,Color.GREEN},null, Shader.TileMode.CLAMP);
//        mpaint.setShader(mShader);
//        canvas.drawCircle(250,250,250,mpaint);

        // 扫描渲染
//        mShader = new SweepGradient(250,250,new int[]{Color.RED,Color.GREEN},null);
//        mpaint.setShader(mShader);
//        canvas.drawCircle(250,250,250,mpaint);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        mShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR);
        mpaint.setShader(mShader);
//        canvas.drawCircle(250,250,250,mpaint);
        canvas.drawRect(0,0,500,500,mpaint);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
