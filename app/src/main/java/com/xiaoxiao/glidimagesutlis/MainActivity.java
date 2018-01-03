package com.xiaoxiao.glidimagesutlis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.image.library.UtilsImg;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

       // UtilsImg.get(UtilsImg.LoadType.AnimaRoundAppointImg).GlideImg(this,null,"http://img3.imgtn.bdimg.com/it/u=1185206325,1637226420&fm=27&gp=0.jpg",0,imageView,10,null,0);
    }
}
