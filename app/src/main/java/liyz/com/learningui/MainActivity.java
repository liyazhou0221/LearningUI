package liyz.com.learningui;

import android.app.Activity;
import android.os.Bundle;

import liyz.com.learningui.CustomView.SplitView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 离屏绘制
        //setContentView(new CustomFermodeView(this));
        // 滤镜
        //setContentView(new ColorFilterView(this));
        // canvas操作
        //setContentView(new TransformView(this));
        // save restore
        //setContentView(new SaveRestoreView(this));
        // 粒子效果
        setContentView(new SplitView(this));
    }

}
