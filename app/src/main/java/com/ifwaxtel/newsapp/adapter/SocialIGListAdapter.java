package com.ifwaxtel.newsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifwaxtel.newsapp.R;
import com.ifwaxtel.newsapp.model.SocialItemsObject;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by iFwAxTel on 13/01/2017.
 */
public class SocialIGListAdapter extends RecyclerView.Adapter<SocialIGListAdapter.SocialHolder> {

    private LayoutInflater mInflater;
    private List<SocialItemsObject> items;
    /**
     * The Context.
     */
    Context context;

    /**
     * Instantiates a new Social ig list adapter.
     *
     * @param context   the context
     * @param itemsList the items list
     */
    public SocialIGListAdapter(Context context, List<SocialItemsObject> itemsList) {
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
    public SocialItemsObject getItem(int position) {
        return items.get(position);
    }

    @Override
    public SocialHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = DataBindingUtil.inflate(mInflater, R.layout.item_feed_ig, parent, false).getRoot();
        SocialHolder holder = new SocialHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(SocialHolder holder, final int position) {
        SocialItemsObject obj = items.get(position);

        //holder.dayText.setText(obj.getWeekDay());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * The type Social holder.
     */
    public class SocialHolder extends RecyclerView.ViewHolder {

        /**
         * The News content mini.
         */
        TextView newsContentMini;
        /**
         * The News image.
         */
        ImageView newsImage, /**
         * The News bookmark.
         */
        newsBookmark;

        /**
         * Instantiates a new Social holder.
         *
         * @param v the v
         */
        public SocialHolder(View v) {
            super(v);

            newsContentMini = (TextView) v.findViewById(R.id.newsContentMini);
            newsImage = (ImageView) v.findViewById(R.id.newsImage);
            newsBookmark = (ImageView) v.findViewById(R.id.newsBookmark);


        }
    }
}
