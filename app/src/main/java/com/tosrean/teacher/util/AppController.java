package com.tosrean.teacher.util;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends com.android.volley.my.AppController {
    private static AppController mInstance;
    private static RequestQueue queue;

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;


       /* final String global = MyFunction.getInstance().getDecrypted(this, MyFunction.getInstance().readFileAsset(this, getFilename()));
        Global.arData = global.split(";");*/
//http://sokhay.tcode.biz/wp-api/auth.php?api_id=home&type=pull
        Global.arData = new String[100];
        Global.arData[0] = "http://chekromlek.com/";
/*
        String s = "";
        for (int i = 0; i < Global.arData.length; i++) {
            s += Global.arData[i] + ";";
        }
        final String encrypted = MyFunction.getInstance().getEncrypted(this, s);
        Log.e("Encrypted", encrypted + "");
*/

        queue = Volley.newRequestQueue(this.getApplicationContext());

    }

    public <T> void addToRequestQueue(Request<T> req) {
        queue.add(req);
    }


    private String getFilename() {
        String result = "";
        final int st[] = {100, 97, 116, 97};
        for (int i = 0; i < st.length; i++) {
            result += (char) st[i];
        }
        return result;
    }
}
