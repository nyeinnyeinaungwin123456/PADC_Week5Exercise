package com.anastatia.testing.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anastatia.testing.R;
import com.anastatia.testing.adapters.AttractionAdapter;
import com.anastatia.testing.data.agents.model.AttractionModel;
import com.anastatia.testing.data.vos.AttractionVO;
import com.anastatia.testing.utils.MyanmarAttractionsConstants;
import com.anastatia.testing.view.holders.AttractionViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class AttractionFragment extends Fragment {

    @BindView(R.id.rv_attraction)
    RecyclerView recyclerView;

    AttractionAdapter attractionAdapter;
    private AttractionViewHolder.ControllerAttractionItem mControllerAttractionItem;

    public AttractionFragment() {
    }

    public static AttractionFragment newInstance(){

        AttractionFragment fragment = new AttractionFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerAttractionItem = (AttractionViewHolder.ControllerAttractionItem)context;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    attractionAdapter = new AttractionAdapter(AttractionModel.getInstance().getAttractionVOList());
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attraction, container, false);
        ButterKnife.bind(this, view);

        List<AttractionVO> attractionList = AttractionModel.getInstance().getAttractionList();
        attractionAdapter = new AttractionAdapter(attractionList, mControllerAttractionItem);

        recyclerView.setAdapter(attractionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.refreshLayout);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    refreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });

        return view;
    }


//
//    public interface AttractionController{
//    void onTapAttraction(AttractionVO attractionVO, ImageView imageView);
//    }
}
