package com.tvcnews.app.adapter;

import android.app.TimePickerDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.tvcnews.app.R;
import com.tvcnews.app.model.NewsItemsObject;

import java.util.Calendar;
import java.util.List;

/**
 * Created by iFwAxTel on 13/01/2017.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsHolder> {

    private LayoutInflater mInflater;
    private List<NewsItemsObject> items;
    /**
     * The Context.
     */
    Context context;

    /**
     * Instantiates a new News list adapter.
     *
     * @param context   the context
     * @param itemsList the items list
     */
    public NewsListAdapter(Context context, List<NewsItemsObject> itemsList) {
        this.context = context;
        this.items = itemsList;
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Gets item.
     *
     * @param position the position
     * @return the item
     */
    public NewsItemsObject getItem(int position) {
        return items.get(position);
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = DataBindingUtil.inflate(mInflater, R.layout.item_news, parent, false).getRoot();
        NewsHolder holder = new NewsHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, final int position) {
        NewsItemsObject obj = items.get(position);

        if (obj.isChecked()){
            holder.newsBookmark.setChecked(true);
        }
        holder.newsTitle.setText(obj.getTitle());
        holder.newsImage.setImageDrawable(obj.getImage());
        holder.newsContentMini.setText(obj.getBody());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * The type News holder.
     */
    public class NewsHolder extends RecyclerView.ViewHolder {

        /**
         * The News title.
         */
        TextView newsTitle, /**
         * The News content mini.
         */
        newsContentMini, /**
         * The News views.
         */
        newsViews;
        /**
         * The News image.
         */
        ImageView newsImage;
        /**
         * The News bookmark.
         */
        AppCompatCheckBox newsBookmark, /**
         * The News likes.
         */
        newsLikes;

        /**
         * Instantiates a new News holder.
         *
         * @param v the v
         */
        public NewsHolder(View v) {
            super(v);
            newsTitle = (TextView)v.findViewById(R.id.newsTitle);
            newsContentMini = (TextView)v.findViewById(R.id.newsContentMini);
            newsLikes = (AppCompatCheckBox)v.findViewById(R.id.newsLikes);
            newsViews = (TextView)v.findViewById(R.id.newsViews);
            newsImage = (ImageView) v.findViewById(R.id.newsImage);
            newsBookmark = (AppCompatCheckBox) v.findViewById(R.id.newsBookmark);


        }
    }
}
