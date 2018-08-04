package com.example.admin.frist_week.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.frist_week.R;
import com.example.admin.frist_week.adapter.RecyclerAdapter;
import com.example.admin.frist_week.bean.DrawableBean;
import com.example.admin.frist_week.bean.MessageEvent;
import com.example.admin.frist_week.presenter.Presenter;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity implements Iview {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private List<DrawableBean.ResultsBean> mResults;
    private Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mPresenter = new Presenter(this);
        mPresenter.getdatas();
    }
    @Override
    public void viewSuccess(DrawableBean drawableBean) {
        mResults = drawableBean.getResults();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(ShowActivity.this, mResults);
                recyclerview.setAdapter(recyclerAdapter);
                recyclerAdapter.setItemClick(new RecyclerAdapter.ItemClick() {
                    @Override
                    public void item(String url, TextView title) {
                        Toast.makeText(ShowActivity.this, "不要瞎鸡儿看", Toast.LENGTH_SHORT).show();
                        String s = title.getText().toString();
                        EventBus.getDefault().post(new MessageEvent(s,url));
                        finish();
                    }
                });
            }
        });
    }

    @Override
    public void viewFail(int code) {

    }
}
