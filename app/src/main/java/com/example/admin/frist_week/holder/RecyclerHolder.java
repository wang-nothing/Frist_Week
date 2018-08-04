package com.example.admin.frist_week.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.admin.frist_week.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class RecyclerHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView item_simple;
    public TextView item_title;
    public RecyclerHolder(@NonNull View itemView) {
        super(itemView);
        item_simple = itemView.findViewById(R.id.item_simple);
        item_title = itemView.findViewById(R.id.item_title);
    }
}
