package com.vasko.mvp.followers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vasko.mvp.data.GitHubUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 5.5.2016..
 */
public class FollowersAdapter extends BaseAdapter {

    private List<GitHubUser> followers;
    private LayoutInflater inflater;

    public FollowersAdapter(Context context) {
        followers = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void createList(List<GitHubUser> followers) {
        this.followers.clear();
        this.followers.addAll(followers);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return followers.size();
    }

    @Override
    public GitHubUser getItem(int position) {
        return followers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        GitHubUser user = followers.get(position);
        if (user.getName() != null) {
            viewHolder.textView.setText(user.getName());
        } else {
            viewHolder.textView.setText(user.getLogin());
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }
}
