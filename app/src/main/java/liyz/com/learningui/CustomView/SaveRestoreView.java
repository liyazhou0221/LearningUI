package liyz.com.learningui.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

/**
 * 离屏绘制
 */
public class SaveRestoreView extends View {
    private Paint paint;

    public SaveRestoreView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        System.out.println("onDraw: " + canvas.getSaveCount());
//        canvas.drawRect(0,0,400,400,paint);
//        int id = canvas.save();
//        canvas.translate(50,50);
//        canvas.drawLine(0,0,400,400,paint);
//        System.out.println("onDraw: " + canvas.getSaveCount());
//
//        canvas.save();
//        canvas.translate(50,50);
//        paint.setColor(Color.GREEN);
//        canvas.drawLine(0,0,400,500,paint);
//        System.out.println("onDraw: " + canvas.getSaveCount());
//
//        paint.setColor(Color.GRAY);
//        canvas.drawRect(0,0,400,400,paint);
//        canvas.restore();
//        canvas.drawLine(0,0,400,600,paint);
//        System.out.println("onDraw: " + canvas.getSaveCount());
//
//        canvas.restoreToCount(id);
//        System.out.println("onDraw: " + canvas.getSaveCount());

        canvas.drawRect(100,100,400,400,paint);

        // 离屏绘制
        int layerId = canvas.saveLayer(0, 0, 500, 500, paint);

        paint.setColor(Color.BLUE);
        Matrix matrix = new Matrix();
        matrix.setTranslate(50,50);
        canvas.setMatrix(matrix);
        // 由于离屏操作，绘制时无法画完整
        canvas.drawRect(0,0,500,500,paint);
        canvas.restoreToCount(layerId);

        paint.setColor(Color.GRAY);
        canvas.drawRect(0,0,50,50,paint);


    }
}
