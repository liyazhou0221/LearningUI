package liyz.com.learningui.CustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 *  离屏绘制
 */
public class CustomFermodeView extends View {
    private int mWidth;
    private int mHeigth;
    private Paint mPaint;

    public CustomFermodeView(Context context) {
        super(context);
        init();
    }

    public CustomFermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeigth = MeasureSpec.getSize(heightMeasureSpec);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 1、组合渲染 ComposeShader
        // 2、画笔Paint.setXfermode
        // 3、PorterDuffColorFilter
        // 禁止硬件加速：14 之后，某些API是不支持硬件加速的
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);

        //setBackgroundColor(Color.GRAY);

        // 离屏绘制
        int layerId = canvas.saveLayer(0,0,getWidth(),getHeight(),mPaint,Canvas.ALL_SAVE_FLAG);
        // 目标图
        canvas.drawBitmap(createReactBitmap(mWidth,mHeigth),0,0,mPaint);
        // 设置混合模式
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        // 源图 重叠区域右下角部分
        canvas.drawBitmap(createCircleBitmap(mWidth,mHeigth),0,0,mPaint);
        // 清除混合模式
        mPaint.setXfermode(null);

        canvas.restoreToCount(layerId);


    }

    private Bitmap createReactBitmap(int mWidth, int mHeigth) {
        Bitmap bitmap = Bitmap.createBitmap(mWidth,mHeigth,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFF66AAFF);
        canvas.drawRect(new Rect(mWidth / 20 ,mHeigth /3,2 * mWidth /3,19 * mHeigth /20),paint);
        return bitmap;
    }
    private Bitmap createCircleBitmap(int mWidth, int mHeigth) {
        Bitmap bitmap = Bitmap.createBitmap(mWidth,mHeigth,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFFFFCC44);
        canvas.drawCircle(mWidth * 2 / 3 ,mHeigth /3,mHeigth /4 ,paint);
        return bitmap;
    }
}
