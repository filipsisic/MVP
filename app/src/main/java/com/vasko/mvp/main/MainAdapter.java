package com.vasko.mvp.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vasko.mvp.R;
import com.vasko.mvp.data.Repo;

import java.util.ArrayList;
import java.util.List;

class MainAdapter extends BaseAdapter {

    private final Context context;
    private final List<Repo> list;

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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.main_adapter_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Repo repo = list.get(position);
        viewHolder.name.setText(repo.getName());

        return convertView;
    }

    private static class ViewHolder {
        private TextView name;
    }
}
