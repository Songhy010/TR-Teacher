package com.tosrean.teacher.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tosrean.teacher.R;
import com.tosrean.teacher.util.Tools;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tools.setSystemBarColor(this,R.color.colorPrimary);
        initView();
    }
    private void initView(){
        initToolbar();
    }
    private void initToolbar(){
        final ImageView iv_back = findViewById(R.id.iv_back);
        iv_back.setVisibility(View.GONE);
    }
}
