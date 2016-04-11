package com.example.dan.database2;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {
    private ArrayList<User> mDataSet;
    public static final String EXTRA_POSITION = "com.alboteanu.database.POSITION";

    public UsersAdapter(ArrayList<User> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(v);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.name_entry.setText(mDataSet.get(position).getName());
        holder.email_entry.setText(mDataSet.get(position).getEmail());
        holder.icon_entry.setText("" + mDataSet.get(position).getName().charAt(0));

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public  class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView;
        TextView name_entry, email_entry, icon_entry;

        UserViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.user_layout);
            name_entry = (TextView) itemView.findViewById(R.id.name_entry);
            email_entry = (TextView) itemView.findViewById(R.id.email_entry);
            icon_entry = (TextView) itemView.findViewById(R.id.icon_entry);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            v.getContext().startActivity(new Intent(v.getContext(), EditActivity.class).putExtra(EXTRA_POSITION, getAdapterPosition()));
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
