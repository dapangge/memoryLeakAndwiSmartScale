package com.example.pingmu;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//代码创建控件
		ImageView imageView = new ImageView(this);
		//设置控件背景
		imageView.setBackgroundColor(Color.BLUE);
		//设置控件尺寸属性
		LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px(200), dip2px(200));
		//添加到布局中去
			//找到根布局
		LinearLayout ll_root = (LinearLayout) findViewById(R.id.ll_root);
		//添加
		ll_root.addView(imageView, layoutParams);
	}

	public int dip2px(int dip){
		//获取设备的像素密度
		float density = getResources().getDisplayMetrics().density;
		//乘以密度后，
			//加0.5的原因：强制转换后，会把小数点后的值全部舍弃，如果后面是0.8或 0.9的时候，舍去的话，精度太差
				//加了0.5f以后，就达到了四舍五入的目的，精度得到了保证
		return (int) (dip*density+0.5f);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
