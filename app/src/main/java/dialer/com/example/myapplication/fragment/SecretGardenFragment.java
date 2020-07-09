package dialer.com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dialer.com.example.myapplication.R;
import dialer.com.example.myapplication.utils.Constants;
import dialer.com.example.myapplication.utils.SharedPreferencesUtils;

public class SecretGardenFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageButton mWater_ib_btn;//浇水的按钮
    private ImageButton mFertilizer_ib_btn;//施肥的按钮
    private ImageButton mDebug_ib_btn;//杀虫的按钮
    private ProgressBar mProgress_life;//植物的生命值进度条
    private int life;//植物的生命值
    private TextView mLife;//显示生命值的文本框
    private RelativeLayout mBackground;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_secret_garden,null);
        initView();
        return view;
    }

    private void initView() {
        //初始化按钮
        mWater_ib_btn = view.findViewById(R.id.plant_water);
        mFertilizer_ib_btn = view.findViewById(R.id.plant_fertilizer);
        mDebug_ib_btn =view. findViewById(R.id.plant_debug);
        //初始化进度条
        mProgress_life =view. findViewById(R.id.plant_life_bar);
        //初始化生命值显示框
        mLife =view. findViewById(R.id.plant_life);;

        mDebug_ib_btn.setOnClickListener(this);
        mFertilizer_ib_btn.setOnClickListener(this);
        mWater_ib_btn.setOnClickListener(this);

        //获取背景控件
        mBackground = view.findViewById(R.id.secrete_garden_bg);
        //回显更新控件
        updateView();
    }

    private void updateView() {
        life = SharedPreferencesUtils.getLife(getActivity(), Constants.LIFE, 0);//从SharePreference的工具类中获取植物存储的生命值
        mProgress_life.setProgress(life);//更新进度条
        mLife.setText("生命值："+life);//进行生命值的显示

        boolean pic = SharedPreferencesUtils.getPic(getActivity(), Constants.ISCHANGEPIC, false);//获取是否更改背景的标识
        if (pic){
            mBackground.setBackgroundResource(R.drawable.secret_guarden_2);//更改背景
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.plant_debug:
            case R.id.plant_water:
                if (life<=95){
                    life = mProgress_life.getProgress();
                    life+=5;
                    mProgress_life.setProgress(life);
                }else {
                    Toast.makeText(getActivity(),"您的生命值已达上限，无法再浇水或者除虫了",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.plant_fertilizer:
                if (life<=90){
                    life = mProgress_life.getProgress();
                    life+=10;
                    mProgress_life.setProgress(life);
                }else {
                    Toast.makeText(getActivity(),"您的生命值已达上限，无法再施肥了",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        mLife.setText("当前生命值："+life);
        //如果生命值大于60，则更换背景图片
        if (life>=60){
            mBackground.setBackgroundResource(R.drawable.secret_guarden_2);
            SharedPreferencesUtils.savePic(getActivity(),Constants.ISCHANGEPIC,true);//将更换图片的情况存储为true
        }
        SharedPreferencesUtils.saveLife(getActivity(),Constants.LIFE,life);//存储生命值
    }
}
