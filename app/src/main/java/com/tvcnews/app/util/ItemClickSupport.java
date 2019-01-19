package com.tvcnews.app.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tvcnews.app.R;


/**
 * Created by iFwAxTel on 13/11/2016.
 */
public class ItemClickSupport {
    private final RecyclerView
            mRecyclerView ;
    private OnItemClickListener
            mOnItemClickListener;
    private OnItemLongClickListener
            mOnItemLongClickListener;
    private View . OnClickListener
            mOnClickListener = new
            View. OnClickListener () {
                @Override
                public void onClick(View v ) {
                    if (mOnItemClickListener != null) {
                        RecyclerView. ViewHolder
                                holder =
                                mRecyclerView . getChildViewHolder(v );
                        mOnItemClickListener. onItemClicked
                                (mRecyclerView ,
                                        holder . getAdapterPosition(), v );
                    }
                }
            };
    private View . OnLongClickListener
            mOnLongClickListener = new
            View. OnLongClickListener () {
                @Override
                public boolean onLongClick (View v ) {
                    if (mOnItemLongClickListener !=
                            null) {
                        RecyclerView. ViewHolder
                                holder =
                                mRecyclerView . getChildViewHolder(v );
                        return
                                mOnItemLongClickListener. onItemLongClicked(mRecyclerView ,
                                        holder . getAdapterPosition(), v );
                    }
                    return false;
                }
            };
    private
    RecyclerView. OnChildAttachStateChangeListener mAttachListener
            = new
            RecyclerView. OnChildAttachStateChangeListener() {
                @Override
                public void
                onChildViewAttachedToWindow(View
                                                    view) {
                    if (mOnItemClickListener != null) {
                        view. setOnClickListener
                                (mOnClickListener);
                    }
                    if (mOnItemLongClickListener !=
                            null) {
                        view. setOnLongClickListener
                                (mOnLongClickListener );
                    }
                }
                @Override
                public void
                onChildViewDetachedFromWindow (View
                                                       view) {
                }
            };
    private ItemClickSupport
            (RecyclerView recyclerView ) {
        mRecyclerView = recyclerView ;
        mRecyclerView . setTag(R. id . item_click_support , this);
        mRecyclerView . addOnChildAttachStateChangeListener(mAttachListener );
    }

    /**
     * Add to item click support.
     *
     * @param view the view
     * @return the item click support
     */
    public static ItemClickSupport addTo
            (RecyclerView view ) {
        ItemClickSupport support =
                (ItemClickSupport) view . getTag
                        (R. id. item_click_support );
        if (support == null) {
            support = new ItemClickSupport
                    (view);
        }
        return support ;
    }

    /**
     * Remove from item click support.
     *
     * @param view the view
     * @return the item click support
     */
    public static ItemClickSupport
    removeFrom(RecyclerView view ) {
        ItemClickSupport support =
                (ItemClickSupport) view . getTag
                        (R. id. item_click_support );
        if (support != null) {
            support . detach(view );
        }
        return support ;
    }

    /**
     * Sets on item click listener.
     *
     * @param listener the listener
     * @return the on item click listener
     */
    public ItemClickSupport
    setOnItemClickListener
            (OnItemClickListener listener ) {
        mOnItemClickListener = listener ;
        return this;
    }

    /**
     * Sets on item long click listener.
     *
     * @param listener the listener
     * @return the on item long click listener
     */
    public ItemClickSupport
    setOnItemLongClickListener
            (OnItemLongClickListener listener ) {
        mOnItemLongClickListener =
                listener;
        return this;
    }
    private void detach (RecyclerView view )
    {
        view. removeOnChildAttachStateChangeListener(mAttachListener );
        view. setTag(R. id . item_click_support , null);
    }

    /**
     * The interface On item click listener.
     */
    public interface OnItemClickListener {
        /**
         * On item clicked.
         *
         * @param recyclerView the recycler view
         * @param position     the position
         * @param v            the v
         */
        void onItemClicked(RecyclerView
                                   recyclerView, int position, View v);
    }

    /**
     * The interface On item long click listener.
     */
    public interface
    OnItemLongClickListener {
        /**
         * On item long clicked boolean.
         *
         * @param recyclerView the recycler view
         * @param position     the position
         * @param v            the v
         * @return the boolean
         */
        boolean onItemLongClicked
                (RecyclerView recyclerView, int position,
                 View v);
    }
}
