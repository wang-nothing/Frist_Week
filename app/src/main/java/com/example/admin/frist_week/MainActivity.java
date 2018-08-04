package com.example.admin.frist_week;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.frist_week.bean.MessageEvent;
import com.example.admin.frist_week.view.ShowActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_tv)
    TextView mainTv;
    @BindView(R.id.main_simple)
    SimpleDraweeView mainSimple;
    @BindView(R.id.dianji)
    LinearLayout dianji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        mainTv.setText(messageEvent.getMessage());
        mainSimple.setImageURI(messageEvent.getPic());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.dianji)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this, ShowActivity.class));

    }
}
