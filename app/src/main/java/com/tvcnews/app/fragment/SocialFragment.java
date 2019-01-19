package com.tvcnews.app.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tvcnews.app.R;
import com.tvcnews.app.adapter.NewsListAdapter;
import com.tvcnews.app.adapter.SocialFBListAdapter;
import com.tvcnews.app.adapter.SocialIGListAdapter;
import com.tvcnews.app.adapter.SocialTWListAdapter;
import com.tvcnews.app.model.NewsItemsObject;
import com.tvcnews.app.model.SocialItemsObject;
import com.tvcnews.app.util.Divider;

import java.util.ArrayList;

/**
 * The type Social fragment.
 */
public class SocialFragment extends Fragment implements Animation.AnimationListener{

    private int page;
    private String title;

    /**
     * The Social top.
     */
    RadioGroup socialTop;
    /**
     * The Facebook.
     */
    RadioButton facebook, /**
     * The Instagram.
     */
    instagram, /**
     * The Twitter.
     */
    twitter;
    /**
     * The Rec list.
     */
    RecyclerView recList;
    /**
     * The Adapter 1.
     */
    SocialFBListAdapter adapter1;
    /**
     * The Adapter 2.
     */
    SocialIGListAdapter adapter2;
    /**
     * The Adapter 3.
     */
    SocialTWListAdapter adapter3;
    /**
     * The Array.
     */
    ArrayList array = new ArrayList();

    /**
     * The Fab.
     */
    FloatingActionButton fab;
    /**
     * The Cancel.
     */
    TextView cancel, /**
     * The Save.
     */
    save, /**
     * The View title.
     */
    viewTitle;
    /**
     * The M title.
     */
    TextInputEditText mTitle;

    /**
     * The Add task.
     */
    RelativeLayout addTask;
    /**
     * The Trans back.
     */
    ImageView transBack;
    /**
     * The Slide up.
     */
    Animation slideUp;
    /**
     * The Slide down.
     */
    Animation slideDown;

    /**
     * The Swipe refresh.
     */
    SwipeRefreshLayout swipeRefresh;

    /**
     * Instantiates a new Social fragment.
     */
    public SocialFragment() {
        // Required empty public constructor
    }

    /**
     * New instance social fragment.
     *
     * @param page  the page
     * @param title the title
     * @return the social fragment
     */
    public static SocialFragment newInstance(int page, String title) {
        SocialFragment fragment = new SocialFragment();
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
        View v = inflater.inflate(R.layout.fragment_social, container, false);
        recList = (RecyclerView)v.findViewById(R.id.recList);
        facebook = (RadioButton) v.findViewById(R.id.facebook);
        instagram = (RadioButton) v.findViewById(R.id.instagram);
        twitter = (RadioButton) v.findViewById(R.id.twitter);
        socialTop = (RadioGroup) v.findViewById(R.id.socialTop);
        fab = (FloatingActionButton)v.findViewById(R.id.fab);
        cancel = (TextView)v.findViewById(R.id.cancel);
        save = (TextView)v.findViewById(R.id.save);
        viewTitle = (TextView)v.findViewById(R.id.viewTitle);
        mTitle = (TextInputEditText)v.findViewById(R.id.task_title);
        transBack = (ImageView)v.findViewById(R.id.transBack);
        addTask = (RelativeLayout)v.findViewById(R.id.addTask);

        swipeRefresh = (SwipeRefreshLayout)v.findViewById(R.id.swipeRefresh);

        socialTop.setOnCheckedChangeListener(checkedListener);
        facebook.setChecked(true);

        fab.setOnClickListener(clickManager);
        transBack.setOnClickListener(clickManager);
        cancel.setOnClickListener(clickManager);
        save.setOnClickListener(clickManager);

        slideUp = AnimationUtils.loadAnimation(getActivity(),R.anim.slide_up);
        slideDown = AnimationUtils.loadAnimation(getActivity(),R.anim.slide_down);

        slideDown.setAnimationListener(SocialFragment.this);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(false);
                Toast.makeText(getActivity(), "Page refreshed", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    private View.OnClickListener clickManager = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fab:
                    transBack.setVisibility(View.VISIBLE);
                    addTask.setVisibility(View.VISIBLE);
                    addTask.startAnimation(slideUp);
                    fab.hide();
                    break;
                case R.id.transBack:
                    addTask.startAnimation(slideDown);
                    break;
                case R.id.cancel:
                    addTask.startAnimation(slideDown);
                    break;
                case R.id.save:

                    break;
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener checkedListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.facebook:
                    populateFBContent();
                    break;
                case R.id.instagram:
                    populateIGContent();
                    break;
                case R.id.twitter:
                    populateTWContent();
                    break;
            }
        }
    };

    private void populateFBContent(){
        array.clear();
        for (int i = 0; i<10; i++){
            SocialItemsObject no = new SocialItemsObject();
            array.add(no);
        }
        adapter1 = new SocialFBListAdapter(getActivity(),array);
        recList.addItemDecoration(new Divider(getActivity(), LinearLayoutManager.VERTICAL));
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recList.setLayoutManager(llm);
        recList.setAdapter(adapter1);
    }

    private void populateIGContent(){
        array.clear();
        for (int i = 0; i<10; i++){
            SocialItemsObject no = new SocialItemsObject();
            array.add(no);
        }
        adapter2 = new SocialIGListAdapter(getActivity(),array);
        recList.addItemDecoration(new Divider(getActivity(), LinearLayoutManager.VERTICAL));
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recList.setLayoutManager(llm);
        recList.setAdapter(adapter2);
    }

    private void populateTWContent(){
        array.clear();
        for (int i = 0; i<10; i++){
            SocialItemsObject no = new SocialItemsObject();
            array.add(no);
        }
        adapter3 = new SocialTWListAdapter(getActivity(),array);
        recList.addItemDecoration(new Divider(getActivity(), LinearLayoutManager.VERTICAL));
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recList.setLayoutManager(llm);
        recList.setAdapter(adapter3);
    }

    @Override
    public void onAttach(Activity a){
        super.onAttach(a);

    }

    @Override
    public void onAnimationStart(Animation animation) {}
    @Override
    public void onAnimationEnd(Animation animation) {
        transBack.setVisibility(View.GONE);
        addTask.setVisibility(View.GONE);
        fab.show();
    }
    @Override
    public void onAnimationRepeat(Animation animation) {}

}
