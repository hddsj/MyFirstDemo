package dialer.com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import dialer.com.example.myapplication.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        initView();//初始化控件
    }
    /*
     * @Author CST18043
     * @Description //TODO 初始化控件的方法
     * @Date  2020/4/22 17:05
     * @Param
     * @return
     */
    private void initView() {
        System.out.println("点击成功！！！！！！！！！！！");
        Intent intent = getIntent();//获取跳转到该活动的意图
        String address = intent.getStringExtra("address");//获取地址
        webView = findViewById(R.id.web_show_imforms);
        webView.getSettings().setJavaScriptEnabled(true);//设置运行js的渲染
        webView.setWebViewClient(new WebViewClient());//新建Web客户端对象
        webView.loadUrl(address);//访问url

    }
}
