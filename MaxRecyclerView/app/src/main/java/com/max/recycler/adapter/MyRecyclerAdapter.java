package com.max.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.max.recycler.R;
import com.max.recycler.adapter.viewholder.BaseViewHolder;
import com.max.recycler.adapter.viewholder.TypeOneViewHolder;
import com.max.recycler.adapter.viewholder.TypeThreeViewHolder;
import com.max.recycler.adapter.viewholder.TypeTwoViewHolder;
import com.max.recycler.model.EvaluationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView的Adapter
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private LayoutInflater mInflater;
    private List<EvaluationModel> mList = new ArrayList<>();

    public MyRecyclerAdapter(Context mContext){
        mInflater = LayoutInflater.from(mContext);
    }

    public void addList(List<EvaluationModel> list){
        mList.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case EvaluationModel.TYPE_ONE:
                return new TypeOneViewHolder(mInflater.inflate(R.layout.viewholder_one,parent,false));
            case EvaluationModel.TYPE_TWO:
                return new TypeTwoViewHolder(mInflater.inflate(R.layout.viewholder_two,parent,false));
            case EvaluationModel.TYPE_THREE:
                return new TypeThreeViewHolder(mInflater.inflate(R.layout.viewholder_three,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        EvaluationModel model = mList.get(position);
        ((BaseViewHolder)holder).bindViewHolder(model);
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).mType;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
