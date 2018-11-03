package com.android.windnovel.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.windnovel.R;
import com.android.windnovel.model.bean.SectionBean;
import com.android.windnovel.model.flag.FindType;
import com.android.windnovel.ui.activity.BookListActivity;
import com.android.windnovel.ui.adapter.SectionAdapter;
import com.android.windnovel.ui.base.BaseFragment;
import com.android.windnovel.widget.itemdecoration.DividerItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ZTH-003 on 17-4-15.
 */

public class FindFragment extends BaseFragment {
    /******************view************************/
    @BindView(R.id.find_rv_content)
    RecyclerView mRvContent;
    /*******************Object***********************/
    SectionAdapter mAdapter;

    @Override
    protected int getContentId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initWidget(Bundle savedInstanceState) {
        setUpAdapter();
    }

    private void setUpAdapter(){
        ArrayList<SectionBean> sections = new ArrayList<>();
        for (FindType type : FindType.values()){
            sections.add(new SectionBean(type.getTypeName(),type.getIconId()));
        }

        mAdapter = new SectionAdapter();
        mRvContent.setHasFixedSize(true);
        mRvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvContent.addItemDecoration(new DividerItemDecoration(getContext()));
        mRvContent.setAdapter(mAdapter);
        mAdapter.addItems(sections);
    }


    @Override
    protected void initClick() {
        mAdapter.setOnItemClickListener(
                (view,pos) -> {
                    FindType type = FindType.values()[pos];
                    Intent intent;
                    //跳转
                    switch (type){
                        case TOP:

                            break;
                        case SORT:

                            break;
                        case TOPIC:
                            intent = new Intent(getContext(), BookListActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
        );

    }
}
