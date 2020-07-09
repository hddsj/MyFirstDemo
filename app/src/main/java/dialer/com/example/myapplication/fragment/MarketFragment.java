package dialer.com.example.myapplication.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import dialer.com.example.myapplication.R;
import dialer.com.example.myapplication.adapter.MyMarketAdapter;

public class MarketFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_market,null);
        initView();
        return view;
    }
    private void initView() {
        recyclerView = view.findViewById(R.id.market_rcv);
        recyclerView.addItemDecoration(new SpacesItemDecoration(1));//设置recycleView的间距
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);//新建布局管理者，并设置布局的列数
        recyclerView.setLayoutManager(layoutManager);
        MyMarketAdapter myAdapter=new MyMarketAdapter(getActivity());//新建适配器
        recyclerView.setAdapter(myAdapter);//绑定适配器
    }
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0)
                outRect.top = space;
        }
    }
}
