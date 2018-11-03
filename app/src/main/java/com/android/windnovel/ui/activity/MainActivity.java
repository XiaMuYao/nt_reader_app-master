package com.android.windnovel.ui.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.windnovel.R;
import com.android.windnovel.ui.base.AppManager;
import com.android.windnovel.ui.base.BaseActivity;
import com.android.windnovel.ui.dialog.SexChooseDialog;
import com.android.windnovel.ui.fragment.BillboardFragment;
import com.android.windnovel.ui.fragment.BookShelfFragment;
import com.android.windnovel.ui.fragment.BookSortFragment;
import com.android.windnovel.ui.fragment.SettingFragment;
import com.android.windnovel.utils.Constant;
import com.android.windnovel.utils.PermissionsChecker;
import com.android.windnovel.utils.SharedPreUtils;
import com.android.windnovel.utils.ToastUtils;
import com.android.windnovel.widget.FragmentPagerAdapter;
import com.android.windnovel.widget.NoScrollViewPager;
import com.brioal.bottomtab.entity.TabEntity;
import com.brioal.bottomtab.interfaces.OnTabSelectedListener;
import com.brioal.bottomtab.view.BottomLayout;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    /*************Constant**********/
    private static final int PERMISSIONS_REQUEST_STORAGE = 1;

    static final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    /***************Object*********************/
    private final ArrayList<Fragment> mFragmentList = new ArrayList<>();
    @BindView(R.id.main_bottomTab)
    BottomLayout mBottomLayout;
    @BindView(R.id.vp_content)
    NoScrollViewPager vpContent;

    private PermissionsChecker mPermissionsChecker;
    /*****************Params*********************/
    private boolean isPrepareFinish = false;

    private List<TabEntity> mList;

    @Override
    protected int getContentId() {
        return R.layout.activity_base_tab;
    }

    /**************init method***********************/
    @Override
    protected void setUpToolbar(Toolbar toolbar) {
        super.setUpToolbar(toolbar);
        toolbar.setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("");
    }

    private void initFragment() {
        Fragment bookShelfFragment = new BookShelfFragment();
        Fragment bookSortFragment = new BookSortFragment();
        Fragment billBoardFragment = new BillboardFragment();
        Fragment settingFragment = new SettingFragment();
        mFragmentList.add(bookShelfFragment);
        mFragmentList.add(bookSortFragment);
        mFragmentList.add(billBoardFragment);
        mFragmentList.add(settingFragment);

        // 注意使用的是：getSupportFragmentManager
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        vpContent.setAdapter(adapter);
        // 设置ViewPager最大缓存的页面个数(cpu消耗少)
        vpContent.setOffscreenPageLimit(mFragmentList.size());
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        initFragment();
        initBottonLayout();
        AppManager.getAppManager().finishAllActivityExceptThis(this);
        //性别选择框
        showSexChooseDialog();
    }

    private void showSexChooseDialog() {
        String sex = SharedPreUtils.getInstance().getString(Constant.SHARED_SEX);
        if (sex.equals("")) {
            Dialog dialog = new SexChooseDialog(this);
            dialog.show();
        }
    }

    private void initBottonLayout() {
        vpContent.setNoScroll(true);
        mList = new ArrayList<>();
        mList.add(new TabEntity(R.mipmap.icon_main_tab_1, "书架"));
        mList.add(new TabEntity(R.mipmap.icon_main_tab_2, "分类"));
        mList.add(new TabEntity(R.mipmap.icon_main_tab_4, "榜单"));
        mList.add(new TabEntity(R.mipmap.icon_main_tab_5, "设置"));
        mBottomLayout.setList(mList); //设置数据源

        //设置Item点击事件
        mBottomLayout.setSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onSelected(int position) {
                mBottomLayout.cleanNews(position); //清除未读消息
                switch (position) {
                    case 0:
                        vpContent.setCurrentItem(0);
                        break;
                    case 1:
                        vpContent.setCurrentItem(1);
                        break;
                    case 2:
                        vpContent.setCurrentItem(2);
                        break;
                    case 3:
                        vpContent.setCurrentItem(3);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Class<?> activityCls = null;
        switch (id) {
            case R.id.action_search:
                activityCls = SearchActivity.class;
                break;
//            case R.id.action_login:
//                break;
//            case R.id.action_my_message:
//                break;
            case R.id.action_download:
                activityCls = DownloadActivity.class;
                break;
//            case R.id.action_sync_bookshelf:
//                break;
//            case R.id.action_scan_local_book:
//
//                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
//
//                    if (mPermissionsChecker == null) {
//                        mPermissionsChecker = new PermissionsChecker(this);
//                    }
//
//                    //获取读取和写入SD卡的权限
//                    if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
//                        //请求权限
//                        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSIONS_REQUEST_STORAGE);
//                        return super.onOptionsItemSelected(item);
//                    }
//                }
//
//                activityCls = FileSystemActivity.class;
//                break;
//            case R.id.action_wifi_book:
//                break;
//            case R.id.action_feedback:
//                break;
//            case R.id.action_night_mode:
//                break;
//            case R.id.action_settings:
//                vpContent.setCurrentItem(4);
//                break;
            default:
                break;
        }
        if (activityCls != null) {
            Intent intent = new Intent(this, activityCls);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (menu != null && menu instanceof MenuBuilder) {
            try {
                Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(menu, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onPreparePanel(featureId, view, menu);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSIONS_REQUEST_STORAGE: {
                // 如果取消权限，则返回的值为0
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //跳转到 FileSystemActivity
                    Intent intent = new Intent(this, FileSystemActivity.class);
                    startActivity(intent);

                } else {
                    ToastUtils.show("用户拒绝开启读写权限");
                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (!isPrepareFinish) {
            isPrepareFinish = true;
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
    }
}
