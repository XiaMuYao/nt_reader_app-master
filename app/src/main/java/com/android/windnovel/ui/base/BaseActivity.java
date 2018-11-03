package com.android.windnovel.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.windnovel.R;
import com.android.windnovel.utils.StatusBarCompat;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZTH-003 on 2016/9/8.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final int INVALID_VAL = -1;

    protected CompositeDisposable mDisposable;
    //ButterKnife
    private Toolbar mToolbar;

    private Unbinder unbinder;
    /****************************abstract area*************************************/

    @LayoutRes
    protected abstract int getContentId();

    /************************init area************************************/
    protected void addDisposable(Disposable d){
        if (mDisposable == null){
            mDisposable = new CompositeDisposable();
        }
        mDisposable.add(d);
    }

    /**
     * 配置Toolbar
     * @param toolbar
     */
    protected void setUpToolbar(Toolbar toolbar){
    }

    protected void initData(Bundle savedInstanceState){
    }
    /**
     * 初始化零件
     */
    protected void initWidget() {

    }
    /**
     * 初始化点击事件
     */
    protected void initClick(){
    }
    /**
     * 逻辑使用区
     */
    protected void processLogic(){
    }

    /*************************lifecycle area*****************************************************/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentId());
        initData(savedInstanceState);
        unbinder = ButterKnife.bind(this);
        initToolbar();
        initWidget();
        initClick();
        processLogic();
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
        MobclickAgent.openActivityDurationTrack(false);
    }

    private void initToolbar(){
        //更严谨是通过反射判断是否存在Toolbar
        mToolbar = ButterKnife.findById(this, R.id.toolbar);
        if (mToolbar != null){
            supportActionBar(mToolbar);
            setUpToolbar(mToolbar);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (mDisposable != null){
            mDisposable.dispose();
        }
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
    }

    /**************************used method area*******************************************/

    protected void startActivity(Class<? extends AppCompatActivity> activity){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
    }

    protected ActionBar supportActionBar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        mToolbar.setNavigationOnClickListener(
                (v) -> finish()
        );
        return actionBar;
    }

    protected void setStatusBarColor(int statusColor){
        StatusBarCompat.compat(this, ContextCompat.getColor(this, statusColor));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
