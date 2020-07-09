package dialer.com.example.myapplication.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import dialer.com.example.myapplication.R;
import dialer.com.example.myapplication.fragment.ContactFragment;
import dialer.com.example.myapplication.fragment.InformatintFragment;
import dialer.com.example.myapplication.fragment.MarketFragment;
import dialer.com.example.myapplication.fragment.SecretGardenFragment;

public class HomeActivity extends AppCompatActivity  {
    private TabLayout mTabLayout;
    private List<String> mTitle;
    private List<Fragment> mFragments;
    private ViewPager mViewPager;
    private int[]PICS={R.drawable.imformation,R.drawable.market,R.drawable.secret_garden,R.drawable.plant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initData();
        initView();
    }

    private void initData() {
        mTitle=new ArrayList<>();
//        mTitle.add("土味百科");
//        mTitle.add("土味商城");
//        mTitle.add("秘密花园");
//        mTitle.add("植来植往");
        mFragments=new ArrayList<>();
        mFragments.add(new InformatintFragment());
        mFragments.add(new MarketFragment());
        mFragments.add(new SecretGardenFragment());
        mFragments.add(new ContactFragment());
    }

    private void initView() {
        mTabLayout=findViewById(R.id.mTabLayout);

        mViewPager=findViewById(R.id.home_viewPager);
        mViewPager.setOffscreenPageLimit(mFragments.size());
        //设置滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            //设置标题
        });


        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.imformation);
        mTabLayout.getTabAt(1).setIcon(R.drawable.market);
        mTabLayout.getTabAt(2).setIcon(R.drawable.secret_garden);
        mTabLayout.getTabAt(3).setIcon(R.drawable.plant);
    }



}
