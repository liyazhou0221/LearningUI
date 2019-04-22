package liyz.com.learningui.CustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
//import android.graphics.Color;
//import android.graphics.LightingColorFilter;
//import android.graphics.PorterDuff;
//import android.graphics.PorterDuffColorFilter;
import android.view.View;

import liyz.com.learningui.R;

public class ColorFilterView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;

    public ColorFilterView(Context context) {
        super(context);
        
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.image);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * R = R * MUL.R / 0XFF + ADD.R
         * G = G * MUL.G /0XFF + ADD.G
         * B = B * MUL.B /0XFF + ADD.B
         */

//        //红色去除
//        LightingColorFilter filter = new LightingColorFilter(0x00ffff,0x000000);
//        mPaint.setColorFilter(filter);
//        canvas.drawBitmap(mBitmap,0,0,mPaint);
//        //原始图片
//        LightingColorFilter filter = new LightingColorFilter(0xffffff,0x000000);
//        mPaint.setColorFilter(filter);
//        canvas.drawBitmap(mBitmap,0,0,mPaint);
//        // 绿色更亮
//        LightingColorFilter filter = new LightingColorFilter(0xffffff,0x003000);
//        mPaint.setColorFilter(filter);
//        canvas.drawBitmap(mBitmap,0,0,mPaint);

//        // 增强的颜色，模式
//        PorterDuffColorFilter filter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN);
//        mPaint.setColorFilter(filter);
//        canvas.drawBitmap(mBitmap,0,0,mPaint);

        float[] colorMatrix = {
                //系数（前4位）|偏移量第四位
                1,0,0,0,100,//red
                0,1,0,0,100,//green
                0,0,1,0,0,//blue
                0,0,0,1,0//alpha
        };

        ColorMatrix matrix = new ColorMatrix();
        // 亮度调节:R,G,B,alpha
//        matrix.setScale(2,1,1,1);
        // 饱和度调节：0 -无色，1-原图，>1 饱和度增加
//        matrix.setSaturation(0);
        // 色调调节
        /**
         * Set the rotation on a color axis by the specified values.
         * <p>
         * <code>axis=0</code> correspond to a rotation around the RED color
         * <code>axis=1</code> correspond to a rotation around the GREEN color
         * <code>axis=2</code> correspond to a rotation around the BLUE color
         * </p>
         */
        matrix.setRotate(0,45);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        mPaint.setColorFilter(filter);

        canvas.drawBitmap(mBitmap,0,0,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
