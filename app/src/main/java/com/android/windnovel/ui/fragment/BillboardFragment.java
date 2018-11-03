package com.android.windnovel.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ScrollView;

import com.android.windnovel.R;
import com.android.windnovel.model.bean.BillboardBean;
import com.android.windnovel.model.bean.packages.BillboardPackage;
import com.android.windnovel.presenter.BillboardPresenter;
import com.android.windnovel.presenter.contract.BillboardContract;
import com.android.windnovel.ui.activity.BillBookActivity;
import com.android.windnovel.ui.activity.OtherBillBookActivity;
import com.android.windnovel.ui.adapter.BillboardAdapter;
import com.android.windnovel.ui.base.BaseMVPFragment;
import com.android.windnovel.widget.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ZTH-003 on 17-4-23.
 * 数据的初始化，Expand的配置
 * 1. 查看Api制作数据Bean，制作相应的Adapter
 * 2. 初始化Expandable
 * 3. 制作数据获取类。
 */

public class BillboardFragment extends BaseMVPFragment<BillboardContract.Presenter>
        implements BillboardContract.View, ExpandableListView.OnGroupClickListener {

    @BindView(R.id.billboard_rl_refresh)
    RefreshLayout mRlRefresh;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.billboard_elv_boy)
    ExpandableListView mElvBoy;
    @BindView(R.id.billboard_elv_girl)
    ExpandableListView mElvGirl;

    private BillboardAdapter mBoyAdapter;
    private BillboardAdapter mGirlAdapter;

    @Override
    protected int getContentId() {
        return R.layout.activity_bilboard;
    }

    @Override
    protected void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        setUpAdapter();
    }

    private void setUpAdapter() {
        mBoyAdapter = new BillboardAdapter(getContext());
        mGirlAdapter = new BillboardAdapter(getContext());
        mElvBoy.setAdapter(mBoyAdapter);
        mElvGirl.setAdapter(mGirlAdapter);
        mRlRefresh.setFocusable(true);
        mRlRefresh.setFocusableInTouchMode(true);
        mRlRefresh.requestFocus();
    }

    @Override
    protected void initClick() {
        super.initClick();
        mRlRefresh.setOnReloadingListener(
                () -> mPresenter.loadBillboardList()
        );
        mElvBoy.setOnGroupClickListener(
                (parent, v, groupPosition, id) -> {
                    if (groupPosition != mBoyAdapter.getGroupCount() - 1) {
                        BillboardBean bean = mBoyAdapter.getGroup(groupPosition);
                        BillBookActivity.startActivity(getContext(), bean.get_id(),
                                bean.getMonthRank(), bean.getTotalRank());
                        return true;
                    }
                    return false;
                });
        mElvBoy.setOnChildClickListener(
                (parent, v, groupPosition, childPosition, id) -> {
                    if (groupPosition == mBoyAdapter.getGroupCount() - 1) {
                        BillboardBean bean = mBoyAdapter.getChild(groupPosition, childPosition);
                        OtherBillBookActivity.startActivity(getContext(), bean.getTitle(), bean.get_id());
                        return true;
                    }
                    return false;
                }
        );

        mElvGirl.setOnGroupClickListener(
                (parent, v, groupPosition, id) -> {
                    if (groupPosition != mGirlAdapter.getGroupCount() - 1) {
                        BillboardBean bean = mGirlAdapter.getGroup(groupPosition);
                        BillBookActivity.startActivity(getContext(), bean.get_id(),
                                bean.getMonthRank(), bean.getTotalRank());
                        return true;
                    }
                    return false;
                }
        );

        mElvGirl.setOnChildClickListener(
                (parent, v, groupPosition, childPosition, id) -> {
                    if (groupPosition == mGirlAdapter.getGroupCount() - 1) {
                        BillboardBean bean = mGirlAdapter.getChild(groupPosition, childPosition);
                        OtherBillBookActivity.startActivity(getContext(), bean.getTitle(), bean.get_id());
                        return true;
                    }
                    return false;
                }
        );
    }

    @Override
    protected BillboardContract.Presenter bindPresenter() {
        return new BillboardPresenter();
    }

    @Override
    protected void processLogic() {
        super.processLogic();

        mRlRefresh.showLoading();
        mPresenter.loadBillboardList();
    }

    @Override
    public void finishRefresh(BillboardPackage beans) {
        if (beans == null || beans.getMale() == null || beans.getFemale() == null
                || beans.getMale().size() == 0 || beans.getFemale().size() == 0) {
            mRlRefresh.showEmpty();
            return;
        }
        updateMaleBillboard(beans.getMale());
        updateFemaleBillboard(beans.getFemale());
    }

    private void updateMaleBillboard(List<BillboardBean> disposes) {
        List<BillboardBean> maleGroups = new ArrayList<>();
        List<BillboardBean> maleChildren = new ArrayList<>();
        for (BillboardBean bean : disposes) {
            if (bean.isCollapse()) {
                maleChildren.add(bean);
            } else {
                maleGroups.add(bean);
            }
        }
        maleGroups.add(new BillboardBean("其他排行榜"));
        mBoyAdapter.addGroups(maleGroups);
        mBoyAdapter.addChildren(maleChildren);
    }

    private void updateFemaleBillboard(List<BillboardBean> disposes) {
        List<BillboardBean> femaleGroups = new ArrayList<>();
        List<BillboardBean> femaleChildren = new ArrayList<>();

        for (BillboardBean bean : disposes) {
            if (bean.isCollapse()) {
                femaleChildren.add(bean);
            } else {
                femaleGroups.add(bean);
            }
        }
        femaleGroups.add(new BillboardBean("其他排行榜"));
        mGirlAdapter.addGroups(femaleGroups);
        mGirlAdapter.addChildren(femaleChildren);
    }

    @Override
    public void showError() {
        mRlRefresh.showError();
    }

    @Override
    public void complete() {
        mRlRefresh.showFinish();
    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        return false;
    }
}
