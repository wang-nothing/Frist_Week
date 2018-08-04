package com.example.admin.frist_week.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.frist_week.R;
import com.example.admin.frist_week.bean.DrawableBean;
import com.example.admin.frist_week.holder.RecyclerHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {
    private Context mContext;
    private List<DrawableBean.ResultsBean> mResults;

    public RecyclerAdapter(Context context, List<DrawableBean.ResultsBean> results) {
        mContext = context;
        mResults = results;
    }

    private View mView;

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_show, null);
        return new RecyclerHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerHolder recyclerHolder, final int i) {
        String who = mResults.get(i).getWho();
        String url = mResults.get(i).getUrl();
        recyclerHolder.item_simple.setImageURI(url);
        recyclerHolder.item_title.setText(who);
        recyclerHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemClick.item(mResults.get(i).getUrl(),recyclerHolder.item_title);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }
    private ItemClick mItemClick;

    public void setItemClick(ItemClick itemClick) {
        mItemClick = itemClick;
    }

    public interface ItemClick  {
        void item(String url, TextView title);
    }
}
