package com.ifwaxtel.newsapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifwaxtel.newsapp.R;
import com.ifwaxtel.newsapp.dialog.PlayVideo;
import com.ifwaxtel.newsapp.model.StreamingItemsObject;

import java.util.List;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by iFwAxTel on 13/01/2017.
 */
public class StreamingListAdapter extends RecyclerView.Adapter<StreamingListAdapter.StreamsHolder> {

    private LayoutInflater mInflater;
    private List<StreamingItemsObject> items;
    /**
     * The Context.
     */
    Context context;
    /**
     * The Fm.
     */
    FragmentManager fm;
    /**
     * The Activity.
     */
    Activity activity;

    /**
     * Instantiates a new Streaming list adapter.
     *
     * @param context   the context
     * @param itemsList the items list
     * @param frag      the frag
     * @param _activity the activity
     */
    public StreamingListAdapter(Context context, List<StreamingItemsObject> itemsList, FragmentManager frag, Activity _activity) {
        this.context = context;
        this.items = itemsList;
        mInflater = LayoutInflater.from(context);
        fm = frag;
        this.activity = _activity;
    }

    /**
     * Gets item.
     *
     * @param position the position
     * @return the item
     */
    public StreamingItemsObject getItem(int position) {
        return items.get(position);
    }

    @Override
    public StreamsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = DataBindingUtil.inflate(mInflater, R.layout.item_streams, parent, false).getRoot();
        StreamsHolder holder = new StreamsHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(StreamsHolder holder, final int position) {
        StreamingItemsObject obj = items.get(position);

        //holder.dayText.setText(obj.getWeekDay());
        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayVideo playVideo = new PlayVideo();
                playVideo.addContext(activity);
                playVideo.show(fm, "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * The type Streams holder.
     */
    public class StreamsHolder extends RecyclerView.ViewHolder {

        /**
         * The News title.
         */
        TextView newsTitle, /**
         * The News views.
         */
        newsViews;
        /**
         * The News image.
         */
        ImageView newsImage, /**
         * The Play button.
         */
        playButton;
        /**
         * The News bookmark.
         */
        AppCompatCheckBox newsBookmark, /**
         * The News likes.
         */
        newsLikes;

        /**
         * Instantiates a new Streams holder.
         *
         * @param v the v
         */
        public StreamsHolder(View v) {
            super(v);
            newsTitle = (TextView) v.findViewById(R.id.newsTitle);
            newsLikes = (AppCompatCheckBox) v.findViewById(R.id.newsLikes);
            newsViews = (TextView) v.findViewById(R.id.newsViews);
            newsImage = (ImageView) v.findViewById(R.id.newsImage);
            newsBookmark = (AppCompatCheckBox) v.findViewById(R.id.newsBookmark);
            playButton = (ImageView) v.findViewById(R.id.playButton);


        }
    }
}
