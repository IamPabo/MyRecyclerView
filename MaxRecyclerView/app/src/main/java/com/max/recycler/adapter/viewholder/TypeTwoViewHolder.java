package com.max.recycler.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.max.recycler.R;
import com.max.recycler.model.EvaluationModel;

/**
 *
 */

public class TypeTwoViewHolder extends BaseViewHolder<EvaluationModel> {

    private ImageView mColor;
    private TextView mContent;
    private TextView mName;

    public TypeTwoViewHolder(View itemView) {
        super(itemView);
        mColor = (ImageView)itemView.findViewById(R.id.color);
        mContent = (TextView)itemView.findViewById(R.id.content);
        mName = (TextView)itemView.findViewById(R.id.name);
    }

    @Override
    public void bindViewHolder(EvaluationModel model) {
        mColor.setBackgroundColor(model.mColor);
        mContent.setText(model.mContent);
        mName.setText(model.mName);
    }

}
