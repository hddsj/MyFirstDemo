package dialer.com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import dialer.com.example.myapplication.R;
import dialer.com.example.myapplication.utils.Constants;

public class SplashActivity extends AppCompatActivity {
    private TextView tv_version;//版本号
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case Constants.DELAY_MSG_IN_SPLASH:
                    startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                    finish();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }

    private void initView() {
        //延时2s
        handler.sendEmptyMessageDelayed(Constants.DELAY_MSG_IN_SPLASH, Constants.DELAT_TIME_IN_SPLASH);
        tv_version = findViewById(R.id.tv_splash_version);//获取显示版本号的TextView
    }
}
