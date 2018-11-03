package com.android.windnovel.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.RelativeLayout;

import com.android.windnovel.R;
import com.android.windnovel.model.local.ReadSettingManager;
import com.android.windnovel.ui.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by ZTH-003 on 2018/3/5.
 */

public class SettingFragment extends BaseFragment {

    @BindView(R.id.more_setting_rl_volume)
    RelativeLayout mRlVolume;
    @BindView(R.id.more_setting_sc_volume)
    SwitchCompat mScVolume;
    @BindView(R.id.more_setting_rl_full_screen)
    RelativeLayout mRlFullScreen;
    @BindView(R.id.more_setting_sc_full_screen)
    SwitchCompat mScFullScreen;
    private ReadSettingManager mSettingManager;
    private boolean isVolumeTurnPage;
    private boolean isFullScreen;

    @Override
    protected int getContentId() {
        return R.layout.fragment_more_setting;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        mSettingManager = ReadSettingManager.getInstance();
        isVolumeTurnPage = mSettingManager.isVolumeTurnPage();
        isFullScreen = mSettingManager.isFullScreen();
    }

    @Override
    protected void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        initSwitchStatus();
    }

    private void initSwitchStatus() {
        mScVolume.setChecked(isVolumeTurnPage);
        mScFullScreen.setChecked(isFullScreen);
    }

    @Override
    protected void initClick() {
        super.initClick();
        mRlVolume.setOnClickListener(
                (v) -> {
                    if (isVolumeTurnPage) {
                        isVolumeTurnPage = false;
                    } else {
                        isVolumeTurnPage = true;
                    }
                    mScVolume.setChecked(isVolumeTurnPage);
                    mSettingManager.setVolumeTurnPage(isVolumeTurnPage);
                }
        );

        mRlFullScreen.setOnClickListener(
                (v) -> {
                    if (isFullScreen) {
                        isFullScreen = false;
                    } else {
                        isFullScreen = true;
                    }
                    mScFullScreen.setChecked(isFullScreen);
                    mSettingManager.setFullScreen(isFullScreen);
                }
        );
    }
}
