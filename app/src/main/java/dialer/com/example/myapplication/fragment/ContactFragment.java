package dialer.com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dialer.com.example.myapplication.R;
import dialer.com.example.myapplication.adapter.MyCommunityAdapter;

public class ContactFragment extends Fragment {
    private View view;
    private ListView listView;//显示列表
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_commuinty,null);
        initView();
        return view;
    }

    private void initView() {
        listView=view.findViewById(R.id.lv_community);
        listView.setAdapter(new MyCommunityAdapter(getActivity()));
    }
}
