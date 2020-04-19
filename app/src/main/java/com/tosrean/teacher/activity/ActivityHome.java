package com.tosrean.teacher.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.tosrean.teacher.R;
import com.tosrean.teacher.adapter.AdapterPager;
import com.tosrean.teacher.util.MyFunction;
import com.tosrean.teacher.util.Tools;

public class ActivityHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Tools.setSystemBarColor(this,R.color.colorPrimaryDark);
        initView();
    }
    private void initView(){
        initNavigation();
        initTeacher();
    }

    private void initNavigation() {
        final NavigationView nav = findViewById(R.id.navigation);
        nav.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_logout:
                MyFunction.getInstance().logout(ActivityHome.this);
                Intent intent = new Intent(ActivityHome.this,ActivityMain.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }

    private void initTeacher(){
        final LinearLayoutManager manager;
        final RecyclerView recycler = findViewById(R.id.recycler_teacher);
        manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(new AdapterPager(this,null));
    }
}
