package com.example.admin.frist_week.model;

import com.example.admin.frist_week.bean.DrawableBean;

public interface Imodel {
    void modelSuccess(DrawableBean drawableBean);

    void modelFail(int code);

}
