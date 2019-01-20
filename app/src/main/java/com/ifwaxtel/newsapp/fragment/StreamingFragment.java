package com.ifwaxtel.newsapp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ifwaxtel.newsapp.R;
import com.ifwaxtel.newsapp.adapter.StreamingListAdapter;
import com.ifwaxtel.newsapp.model.StreamingItemsObject;
import com.ifwaxtel.newsapp.util.ItemClickSupport;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * The type Streaming fragment.
 */
public class StreamingFragment extends Fragment {

    private int page;
    private String title;

    /**
     * The Rec list.
     */
    RecyclerView recList;
    /**
     * The Adapter.
     */
    StreamingListAdapter adapter;
    /**
     * The Array.
     */
    ArrayList array = new ArrayList();
    /**
     * The Swipe refresh.
     */
    SwipeRefreshLayout swipeRefresh;


    /**
     * Instantiates a new Streaming fragment.
     */
    public StreamingFragment() {
        // Required empty public constructor
    }

    /**
     * New instance streaming fragment.
     *
     * @param page  the page
     * @param title the title
     * @return the streaming fragment
     */
    public static StreamingFragment newInstance(int page, String title) {
        StreamingFragment fragment = new StreamingFragment();
        Bundle args = new Bundle();
        //args.putInt(VariableConstants.PAGE_NUMBER, page);
        //args.putString(VariableConstants.PAGE_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //page = getArguments().getInt(VariableConstants.PAGE_NUMBER, 0);
            //title = getArguments().getString(VariableConstants.PAGE_TITLE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        recList = (RecyclerView) v.findViewById(R.id.recList);
        swipeRefresh = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefresh);

        populateContent();
        adapter = new StreamingListAdapter(getActivity(), array, getActivity().getSupportFragmentManager(), getActivity());
        //recList.addItemDecoration(new Divider(getActivity(), LinearLayoutManager.VERTICAL));
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recList.setLayoutManager(llm);

        recList.setAdapter(adapter);

        ItemClickSupport.addTo(recList).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

            }
        });

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(false);
                Toast.makeText(getActivity(), "Page refreshed", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    private void populateContent() {
        for (int i = 0; i < 10; i++) {
            StreamingItemsObject no = new StreamingItemsObject();
            array.add(no);
        }
    }


    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);

    }

}
