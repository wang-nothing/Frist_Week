package com.example.admin.frist_week.presenter;

import com.example.admin.frist_week.bean.DrawableBean;
import com.example.admin.frist_week.model.Imodel;
import com.example.admin.frist_week.model.Model;
import com.example.admin.frist_week.view.Iview;

public class Presenter implements Ipresenter {
    private Iview mIview;
    private Model mModel;

    public Presenter(Iview iview) {
        mIview = iview;
        mModel = new Model();
    }

    public void getdatas(){
        mModel.getdata(new Imodel() {
            @Override
            public void modelSuccess(DrawableBean drawableBean) {
                mIview.viewSuccess(drawableBean);
            }

            @Override
            public void modelFail(int code) {
                mIview.viewFail(code);
            }
        });
    }
    @Override
    public void onDestroys() {
        if (mIview != null){
            mIview = null;
        }
    }
}
