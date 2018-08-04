package com.example.admin.frist_week.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtils {
    public static OkHttpClient sClient = null;
    public OkHttpUtils(){

    }
    public static OkHttpClient getInstance(){
        if (sClient == null){
            synchronized (OkHttpUtils.class){
                if (sClient == null){
                    sClient = new OkHttpClient();
                }
            }
        }
        return sClient;
    }

    public static void doGet(String url, Callback callback){
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = getInstance().newCall(request);
        call.enqueue(callback);
    }
}
