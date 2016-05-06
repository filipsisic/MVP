package com.vasko.mvp.repo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vasko.mvp.R;
import com.vasko.mvp.data.GitHubUser;

import java.util.ArrayList;
import java.util.List;

class RepoAdapter extends BaseAdapter {

    private final List<GitHubUser> list;
    private LayoutInflater inflater;

    public RepoAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        list = new ArrayList<>();
    }

    public void notifyDataSetChanged(List<GitHubUser> contributors) {
        list.clear();
        list.addAll(contributors);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public GitHubUser getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.repo_adapter_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        GitHubUser user = list.get(position);
        if (user.getName() != null) {
            viewHolder.name.setText(user.getName());
        } else {
            viewHolder.name.setText(user.getLogin());
        }

        return convertView;
    }

    private static class ViewHolder {
        private TextView name;
    }


}
