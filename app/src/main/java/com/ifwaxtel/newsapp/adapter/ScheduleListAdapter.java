package com.ifwaxtel.newsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifwaxtel.newsapp.R;
import com.ifwaxtel.newsapp.model.ScheduleObject;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by iFwAxTel on 13/01/2017.
 */
public class ScheduleListAdapter extends RecyclerView.Adapter<ScheduleListAdapter.ProgrammeHolder> {

    private LayoutInflater mInflater;
    private List<ScheduleObject> items;
    /**
     * The Context.
     */
    Context context;

    /**
     * Instantiates a new Schedule list adapter.
     *
     * @param context   the context
     * @param itemsList the items list
     */
    public ScheduleListAdapter(Context context, List<ScheduleObject> itemsList) {
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
    public ScheduleObject getItem(int position) {
        return items.get(position);
    }

    @Override
    public ProgrammeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = DataBindingUtil.inflate(mInflater, R.layout.item_programme, parent, false).getRoot();
        ProgrammeHolder holder = new ProgrammeHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProgrammeHolder holder, final int position) {
        ScheduleObject obj = items.get(position);

        holder.programmeTitle.setText(obj.getTitle());
        holder.programmeAnchor.setText(obj.getAnchor());
        holder.newsImage.setImageDrawable(obj.getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * The type Programme holder.
     */
    public class ProgrammeHolder extends RecyclerView.ViewHolder {

        /**
         * The Programme title.
         */
        TextView programmeTitle, /**
         * The Programme anchor.
         */
        programmeAnchor, /**
         * The Programme time.
         */
        programmeTime;
        /**
         * The News image.
         */
        ImageView newsImage;

        /**
         * Instantiates a new Programme holder.
         *
         * @param v the v
         */
        public ProgrammeHolder(View v) {
            super(v);
            programmeTitle = (TextView) v.findViewById(R.id.programmeTitle);
            programmeAnchor = (TextView) v.findViewById(R.id.programmeAnchor);
            programmeTime = (TextView) v.findViewById(R.id.programmeTime);
            newsImage = (ImageView) v.findViewById(R.id.newsImage);


        }
    }
}
