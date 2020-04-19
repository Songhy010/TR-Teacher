package com.tosrean.teacher.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.material.navigation.NavigationView;
import com.tosrean.teacher.R;
import com.tosrean.teacher.listener.VolleyCallback;
import com.tosrean.teacher.util.ConstantStatus;
import com.tosrean.teacher.util.Global;
import com.tosrean.teacher.util.MyFunction;
import com.tosrean.teacher.util.Tools;

import org.json.JSONObject;

import java.util.HashMap;

public class ActivityLogin extends ActivityController {
    private final String TAG = "AC login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Tools.setSystemBarColor(this,R.color.colorPrimaryDark);
        initView();
    }

    private void initView(){
        initLogin();
    }

    private void initLogin() {
        findViewById(R.id.btnsignin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLogin();
            }
        });
    }

    private void loadLogin(){
        try{
            final EditText edtUser= findViewById(R.id.edt_user);
            final EditText edtPwd= findViewById(R.id.edt_pwd);
            final String url = Global.arData[0]+Global.arData[3]+Global.arData[4]+Global.arData[5];// wait m check messge abit //"https://app-tr-server.herokuapp.com/api/teacher/login";
            final HashMap<String,String> param = new HashMap<>();
            param.put(Global.arData[6],edtUser.getText().toString().trim());
            param.put(Global.arData[7],edtPwd.getText().toString().trim());
            showDialog();
            MyFunction.getInstance().requestString(Request.Method.POST, url, param, new VolleyCallback() {
                @Override
                public void onResponse(final String response) {
                    try{
                        final JSONObject object = new JSONObject(response);
                        final int code = Integer.parseInt(object.getString(Global.arData[8]));
                        if(code == ConstantStatus.RESPONSE_SUCCESS){
                            MyFunction.getInstance().saveText(ActivityLogin.this,Global.INFO_FILE,response);
                            MyFunction.getInstance().openActivity(ActivityLogin.this,ActivityMain.class);
                            MyFunction.getInstance().finishActivity(ActivityLogin.this);
                        }else{
                            MyFunction.getInstance().alertMessage(ActivityLogin.this,getString(R.string.information),getString(R.string.ok),getString(R.string.incorrect_password),1);
                        }
                    }catch (Exception e){
                        Log.e(TAG,e.getMessage()+"");
                    }
                    hideDialog();
                }

                @Override
                public void onErrorResponse(VolleyError e) {
                    Log.e(TAG,e.getMessage()+"");
                    loadLogin();
                }
            });
        }catch (Exception e){
            Log.e(TAG,e.getMessage()+"");
        }
    }
}
