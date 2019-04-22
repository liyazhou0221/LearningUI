package liyz.com.learningui.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 平移、缩放、旋转
 */
public class TransformView extends View {
    private Paint paint;

    public TransformView(Context context) {
        this(context,null);
    }

    public TransformView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TransformView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 平移
//        canvas.drawRect(0,0,400,400,paint);
//        canvas.translate(50,50);
//        paint.setColor(Color.GRAY);
//        canvas.drawRect(0,0,400,400,paint);
//        canvas.drawLine(0,0,400,400,paint);

        // 缩放
//        canvas.drawRect(200,200,400,400,paint);
////        canvas.scale(0.5f,0.5f);
//        // 先 translate 后 scale，再反向 translate
//        canvas.scale(0.5f,0.5f,200,200);
//        paint.setColor(Color.GRAY);
//        canvas.drawRect(200,200,400,400,paint);

        // 旋转
//        canvas.translate(50,50);
//        canvas.drawRect(0,0,400,400,paint);
//        canvas.rotate(45);
//        paint.setColor(Color.GRAY);
//        canvas.drawRect(0,0,400,400,paint);

//        canvas.drawRect(200,200,400,400,paint);
//        // 按照px py旋转
//        canvas.rotate(45,300,300);
//        paint.setColor(Color.GRAY);
//        canvas.drawRect(200,200,400,400,paint);
        // 倾斜
//        canvas.drawRect(0,0,200,200,paint);
//        //canvas.skew(1,0);//沿X轴倾斜
//        canvas.skew(0,1);//沿Y轴倾斜
//        paint.setColor(Color.GRAY);
//        canvas.drawRect(0,0,200,200,paint);
        // 切割
//        canvas.drawRect(100,100,400,400,paint);
//        paint.setColor(Color.GRAY);
//        canvas.drawRect(100,400,400,700,paint);
//
//         canvas.clipRect(100,100,400,400);
//        // requires API level 26 (current min is 22):
//         //canvas.clipOutRect(100,100,400,400);
//
//        canvas.drawCircle(50,50,50,paint);// 在裁剪外，不能绘制
//        canvas.drawCircle(150,150,50,paint);// 在裁剪外，不能绘制

        // 矩阵
        canvas.drawRect(0,0,400,400,paint);
        // 利用矩阵设置旋转效果
        Matrix matrix = new Matrix();
        //matrix.setRotate(45);
        //matrix.setTranslate(50,50);
        matrix.setScale(0.5f,0.5f);
        canvas.setMatrix(matrix);
        canvas.drawRect(0,0,400,400,paint);

    }
}
