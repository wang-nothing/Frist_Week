package com.example.admin.frist_week.view;

import com.example.admin.frist_week.bean.DrawableBean;

public interface Iview {
    void viewSuccess(DrawableBean drawableBean);

    void viewFail(int code);
}
