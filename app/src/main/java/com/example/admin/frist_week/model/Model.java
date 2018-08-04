package com.example.admin.frist_week.model;

import android.util.Log;

import com.example.admin.frist_week.bean.DrawableBean;
import com.example.admin.frist_week.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Model {
    private static final String TAG = "Model";
    public void getdata(final Imodel imodel){
        OkHttpUtils.doGet("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "model:网络请求失败 ");
                imodel.modelFail(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "model:网络请求成功 ");
                String json = response.body().string();
                DrawableBean drawableBean = new Gson().fromJson(json, DrawableBean.class);
                imodel.modelSuccess(drawableBean);
            }
        });
    }
}
