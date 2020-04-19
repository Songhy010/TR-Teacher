package com.tosrean.teacher.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.navigation.NavigationView;
import com.tosrean.teacher.R;
import com.tosrean.teacher.listener.VolleyCallback;
import com.tosrean.teacher.util.Global;
import com.tosrean.teacher.util.MyFunction;
import com.tosrean.teacher.util.Tools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ActivityMain extends ActivityController {

    private final String TAG = "Ac Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tools.setSystemBarColor(this,R.color.colorPrimary);
        if(MyFunction.getInstance().isNetworkAvailable(this)){
            showDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(MyFunction.getInstance().isHistory(ActivityMain.this)){
                        MyFunction.getInstance().openActivity(ActivityMain.this,ActivityHome.class);
                        MyFunction.getInstance().finishActivity(ActivityMain.this);
                    }else{
                        MyFunction.getInstance().openActivity(ActivityMain.this,ActivityLogin.class);
                        MyFunction.getInstance().finishActivity(ActivityMain.this);
                    }
                    hideDialog();
                }
            }, 3000);
        }else {
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
        }
    }
}
