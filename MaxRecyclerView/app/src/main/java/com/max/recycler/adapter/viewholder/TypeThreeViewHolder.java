package com.max.recycler.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.max.recycler.R;
import com.max.recycler.model.EvaluationModel;

/**
 *
 */

public class TypeThreeViewHolder extends BaseViewHolder<EvaluationModel> {

    private ImageView mColor;
    private TextView mName;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        mColor = (ImageView)itemView.findViewById(R.id.color);
        mName = (TextView)itemView.findViewById(R.id.name);
    }

    @Override
    public void bindViewHolder(EvaluationModel model){
        mColor.setBackgroundColor(model.mColor);
        mName.setText(model.mName);
    }
}
