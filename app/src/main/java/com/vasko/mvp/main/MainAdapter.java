package com.vasko.mvp.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vasko.mvp.data.Repo;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseAdapter {

    private Context context;
    private List<Repo> list;

    public MainAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void notifyDataSetChanged(List<Repo> list) {
        this.list.clear();
        this.list.addAll(list);
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Repo getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        textView.setText(list.get(position).getName());
        return textView;
    }
}
