package com.example.greenday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostViewAdapter extends RecyclerView.Adapter<PostViewAdapter.PostViewHolder> {

    private List<PostAccount> PostList;

    public PostViewAdapter(List<PostAccount> PostList){
        this.PostList = PostList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostAccount data = PostList.get(position);
        holder.title.setText(data.getTitle());
        holder.contents.setText(data.getContents());
    }

    @Override
    public int getItemCount() {
        return PostList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView contents;

        public PostViewHolder(@NonNull View itemView){
            super(itemView);

            this.title = (TextView) itemView.findViewById(R.id.item_post_title);
            this.contents = (TextView) itemView.findViewById(R.id.item_post_contents);
        }
    }
}
