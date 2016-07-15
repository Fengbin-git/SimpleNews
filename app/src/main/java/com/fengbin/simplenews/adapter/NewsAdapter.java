package com.fengbin.simplenews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fengbin.simplenews.R;
import com.fengbin.simplenews.bean.NewsEntity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
    private List<NewsEntity.StoriesBean> stories = null;
    private OnRecyclerItemClickListener clickListener;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.no_image)
            .showImageOnFail(R.drawable.no_image)
            .showImageForEmptyUri(R.drawable.no_image)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .considerExifParams(true)
            .build();

    public void setClickListener(OnRecyclerItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public List<NewsEntity.StoriesBean> getStories() {
        return stories;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycker_item,parent,false);
        NewsViewHolder holder = new NewsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final NewsViewHolder holder, int position) {
        String title = stories.get(position).getTitle();
        holder.tv_message.setText(title);
        imageLoader.displayImage(stories.get(position).getImages().get(0),holder.iv_picture,options);
        if(clickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = holder.getLayoutPosition();
                    clickListener.onItemClick(holder.itemView,i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(stories == null) {
            return 0;
        }
        return stories.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView tv_message;
        ImageView iv_picture;
        public NewsViewHolder(View itemView) {
            super(itemView);
            tv_message = (TextView) itemView.findViewById(R.id.tv_message);
            iv_picture = (ImageView) itemView.findViewById(R.id.iv_picture);
        }
    }
    public void refreshNewsList(List<NewsEntity.StoriesBean> data){
        stories = data;
        notifyDataSetChanged();
    }
    public interface OnRecyclerItemClickListener{
        void onItemClick(View view,int position);
    }
}
