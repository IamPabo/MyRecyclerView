package com.max.recycler;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.max.recycler.adapter.MyRecyclerAdapter;
import com.max.recycler.model.EvaluationModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mAdapter;

    int[] colors = {
            R.color.color_yellow,
            R.color.color_blue_drak,
            R.color.color_red,
            R.color.color_blue
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.main_recycler_view);
//        mRecyclerView.setLayoutManager(
//                new LinearLayoutManager(
//                        this,
//                        LinearLayoutManager.VERTICAL,
//                        false));
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        //根据type类型设置每行的item数量
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){

            @Override
            public int getSpanSize(int position) {
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                if(type == EvaluationModel.TYPE_ONE){
                    return gridLayoutManager.getSpanCount();
                }else{
                    return 1;
                }
            }
        });
        mAdapter = new MyRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        //Item装饰添加
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            //设置item间距
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                //获取当前Item的布局属性
                GridLayoutManager.LayoutParams layoutParams =
                        (GridLayoutManager.LayoutParams) view.getLayoutParams();
                //获取此View占用的单元格，当前的每行单元格设置为2
                int spanSize = layoutParams.getSpanSize();
                //获取View的Index，1：第一个以此类推
                int spanIndex = layoutParams.getSpanIndex();
                //设置item上下间距
                outRect.top = 20;
                //判断占用单元格不为2（为1）也就是说一行有两个item
                if(spanSize != gridLayoutManager.getSpanCount()){
                    if(spanIndex == 1){
                        //index是1说明当前在右边
                        outRect.left = 10;
                    }else{
                        //index是0说明当前在左边
                        outRect.right = 10;
                    }
                }
            }
        });
        initData();
    }

    private void initData() {
        List<EvaluationModel> list = new ArrayList<>();
        for(int i = 0;i < 20;i++){
            //随机三个数（0到2）  +1变成1到3
            int type = (int)(Math.random()*3)+1;
            EvaluationModel model = new EvaluationModel();
            model.mType = type;
            //自定义颜色需要调用ContextCompat.getColor
            model.mColor = ContextCompat.getColor(getApplicationContext(),colors[type - 1]);
            model.imgColor = ContextCompat.getColor(getApplicationContext(),colors[type]);
            model.mName = "name =" + type;
            model.mContent = "content = " + i;
            list.add(model);
        }
        mAdapter.addList(list);
        mAdapter.notifyDataSetChanged();
    }
}
