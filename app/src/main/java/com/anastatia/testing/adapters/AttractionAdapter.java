package com.anastatia.testing.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anastatia.testing.R;
import com.anastatia.testing.TestingApp;
import com.anastatia.testing.fragments.AttractionFragment;
import com.anastatia.testing.view.holders.AttractionViewHolder;
import com.anastatia.testing.data.vos.AttractionVO;

import java.util.List;

/**
 * Created by Nyein Nyein on 7/18/2016.
 */
public class AttractionAdapter extends RecyclerView.Adapter<AttractionViewHolder> {

    private LayoutInflater layoutInflater;
    private List<AttractionVO> mAttractionVOList;
    private AttractionViewHolder.ControllerAttractionItem mControllerAttractionItem;

    public AttractionAdapter(List<AttractionVO> attractionVOList, AttractionViewHolder.ControllerAttractionItem controllerAttractionItem) {
        layoutInflater = LayoutInflater.from(TestingApp.getContext());
        mAttractionVOList = attractionVOList;
        mControllerAttractionItem = controllerAttractionItem;
    }


    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= layoutInflater.inflate(R.layout.attraction_list_item, parent, false);
        return new AttractionViewHolder(view, mControllerAttractionItem);

    }

    @Override
    public void onBindViewHolder(AttractionViewHolder holder, int position) {

        holder.bindData(mAttractionVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return mAttractionVOList.size();
    }

    public void setNewData(List<AttractionVO> newAttractionList) {
        mAttractionVOList = newAttractionList;
        notifyDataSetChanged();
    }
}
