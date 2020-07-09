package dialer.com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dialer.com.example.myapplication.R;
import dialer.com.example.myapplication.adapter.MyInfoAdapter;
import dialer.com.example.myapplication.ui.WebViewActivity;

public class InformatintFragment extends Fragment {
    private View view;//Fragment视图
    private ListView listView;//列表
    private static final String TAG = "InformatintFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_imformation,null);
        initView();
        return view;
    }

    private void initView() {
       listView= view.findViewById(R.id.imfo_list);
       listView.setAdapter(new MyInfoAdapter(R.layout.imformation_item_layout,getActivity()));
        //设置列表里各条目的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        enterWeb("https://baike.baidu.com/item/%E7%A9%BA%E6%B0%94%E5%87%A4%E6%A2%A8");//将跳转的超链接地址发送给要进行页面跳转的方法
                        break;
                    case 1:
                        enterWeb("https://baike.baidu.com/item/%E7%BD%97%E6%B1%89%E6%9D%BE/843310");
                        break;
                    case 2:
                        enterWeb("https://baike.baidu.com/item/%E6%9D%A1%E7%BA%B9%E5%8D%81%E4%BA%8C%E5%8D%B7");
                        break;
                    case 3:
                        enterWeb("https://baike.baidu.com/item/%E7%B4%AB%E8%96%87/17982");
                        break;
                    case 4:
                        enterWeb("https://baike.baidu.com/item/%E9%94%A6%E6%99%83%E6%98%9F");
                        break;
                    case 5:
                        enterWeb("https://baike.baidu.com/item/%E5%B8%B8%E6%98%A5%E8%97%A4/70130#viewPageContent");
                        break;
                    case 6:
                        enterWeb("https://baike.baidu.com/item/%E7%99%BD%E8%82%8B%E4%B8%87%E5%B9%B4%E9%9D%92");
                        break;
                    case 7:
                        enterWeb("https://baike.baidu.com/item/%E9%87%91%E7%BA%BF%E5%85%B0/4864938");
                        break;
                    case 8:
                        enterWeb("https://baike.baidu.com/item/%E8%8A%B1%E7%83%9B/15417121?fromtitle=%E7%BA%A2%E6%8E%8C&fromid=1091076");
                        break;
                    case 9:
                        enterWeb("https://baike.baidu.com/item/%E6%B5%B7%E8%8A%8B/1101879#viewPageContent");
                        break;
                }
            }
        });
    }

    private void enterWeb(String s) {
        Intent intent=new Intent(getActivity(), WebViewActivity.class);//建立意图跳转对象
        intent.putExtra("address",s);//将相应跳转地址写入意图中
        startActivity(intent);//进行页面跳转
    }

}

