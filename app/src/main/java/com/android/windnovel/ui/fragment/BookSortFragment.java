package com.android.windnovel.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.windnovel.R;
import com.android.windnovel.model.bean.BookSubSortBean;
import com.android.windnovel.model.bean.packages.BookSortPackage;
import com.android.windnovel.model.bean.packages.BookSubSortPackage;
import com.android.windnovel.presenter.BookSortPresenter;
import com.android.windnovel.presenter.contract.BookSortContract;
import com.android.windnovel.ui.activity.BookSortListActivity;
import com.android.windnovel.ui.adapter.BookSortAdapter;
import com.android.windnovel.ui.base.BaseMVPFragment;
import com.android.windnovel.widget.RefreshLayout;
import com.android.windnovel.widget.itemdecoration.DividerGridItemDecoration;

import butterknife.BindView;

/**
 * Created by ZTH-003 on 17-4-23.
 * 分类选择
 */

public class BookSortFragment extends BaseMVPFragment<BookSortContract.Presenter> implements BookSortContract.View {
    private static final int SPAN_COUNT = 3;

    @BindView(R.id.book_sort_rl_refresh)
    RefreshLayout mRlRefresh;
    @BindView(R.id.book_sort_rv_boy)
    RecyclerView mRvBoy;
    @BindView(R.id.book_sort_rv_girl)
    RecyclerView mRvGirl;

    private BookSortAdapter mBoyAdapter;
    private BookSortAdapter mGirlAdapter;

    private BookSubSortPackage mSubSortPackage;

    /**********************init***********************************/
    @Override
    protected int getContentId() {
        return R.layout.activity_book_sort;
    }

//    @Override
//    protected void setUpToolbar(Toolbar toolbar) {
//        super.setUpToolbar(toolbar);
//        getSupportActionBar().setTitle(
//                getResources().getString(R.string.nb_fragment_find_sort));
//    }
//
//    @Override
//    protected void initWidget() {
//        super.initWidget();
//        setUpAdapter();
//    }


    @Override
    protected void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        setUpAdapter();
    }

    private void setUpAdapter() {
        mBoyAdapter = new BookSortAdapter();
        mGirlAdapter = new BookSortAdapter();

        RecyclerView.ItemDecoration itemDecoration = new DividerGridItemDecoration(getContext(), R.drawable.shape_divider_row, R.drawable.shape_divider_col);

        mRvBoy.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));
        mRvBoy.addItemDecoration(itemDecoration);
        mRvBoy.setAdapter(mBoyAdapter);

        mRvGirl.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));
        mRvGirl.addItemDecoration(itemDecoration);
        mRvGirl.setAdapter(mGirlAdapter);
    }

    @Override
    protected BookSortContract.Presenter bindPresenter() {
        return new BookSortPresenter();
    }

    @Override
    protected void initClick() {
        super.initClick();
        mBoyAdapter.setOnItemClickListener(
                (view, pos) -> {
                    BookSubSortBean subSortBean = mSubSortPackage.getMale().get(pos);
                    //上传
                    BookSortListActivity.startActivity(getContext(), "male", subSortBean);
                }
        );
        mGirlAdapter.setOnItemClickListener(
                (view, pos) -> {
                    BookSubSortBean subSortBean = mSubSortPackage.getFemale().get(pos);
                    //上传
                    BookSortListActivity.startActivity(getContext(), "female", subSortBean);
                }
        );
    }

    /*********************logic*******************************/

    @Override
    protected void processLogic() {
        super.processLogic();

        mRlRefresh.showLoading();
        mPresenter.refreshSortBean();
    }

    /***********************rewrite**********************************/
    @Override
    public void finishRefresh(BookSortPackage sortPackage, BookSubSortPackage subSortPackage) {
        if (sortPackage == null || sortPackage.getMale().size() == 0 || sortPackage.getFemale().size() == 0) {
            mRlRefresh.showEmpty();
        } else {
            mBoyAdapter.refreshItems(sortPackage.getMale());
            mGirlAdapter.refreshItems(sortPackage.getFemale());
        }
        mSubSortPackage = subSortPackage;
    }

    @Override
    public void showError() {
        mRlRefresh.showError();
    }

    @Override
    public void complete() {
        mRlRefresh.showFinish();
    }
}
