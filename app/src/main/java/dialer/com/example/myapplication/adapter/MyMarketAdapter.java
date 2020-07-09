package dialer.com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dialer.com.example.myapplication.R;
import dialer.com.example.myapplication.utils.UtilTools;

public class MyMarketAdapter extends RecyclerView.Adapter<MyMarketAdapter.ViewHolder> {
    //植物信息
    String NAME[]={"空气凤梨","罗汉松","条纹十二卷","紫薇花盆景","锦晃星","常春藤","白肋万年青","金线兰","红掌","海芋"};
    String PRICE[]={"价格：18元","价格：27元","价格：9.9元","价格：34元","价格：15元","价格：13元","价格：19.9元","价格：16元"
            ,"价格：13.9元","价格：23元"};
    String SIZE[]={"高度：10-15cm","高度：30-40cm","高度：15-20cm","高度：15-20cm","高度：多肉类无高度","高度：30-40cm","高度25-30cm","高度：15-20cm","高度：20-25cm","高度：20-25cm"};
    String SORT[]={"种类：凤梨科、铁兰属","种类：罗汉松科、罗汉松属","种类：百合科、十二卷属","种类：千屈菜科紫薇属","种类：景                 天科石莲花属","种类：五加科、常春藤属","种类：天南星科、花叶万年青属","种类：兰科、开唇兰属","种类：天南星科                    花烛属","种类：海芋属"};
    int PICS[]={R.drawable.market_item_pic_1,R.drawable.market_item_pic_2,R.drawable.market_item_pic_3,R.drawable.market_item_pic_4,R.drawable.market_item_pic_5,R.drawable.market_item_pic_6,R.drawable.market_item_pic_7,R.drawable.market_item_pic_8,R.drawable.market_item_pic_9,R.drawable.market_item_pic_10};
    //上下文
    private Context mContext;

    public MyMarketAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyMarketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //判断上下文是否存在
        if (mContext==null){
            mContext=parent.getContext();
        }
        //获取单个条目界面
        View view1 = View.inflate(mContext, R.layout.new_market_card_view_item, null);
        ViewHolder holder=new ViewHolder(view1);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyMarketAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(PICS[position]);
        UtilTools.setFont(mContext, holder.size);
        UtilTools.setFont(mContext, holder.sort);
        UtilTools.setFont(mContext, holder.price);
        UtilTools.setFont(mContext, holder.title);
        holder.size.setText(SIZE[position]);
        holder.sort.setText(SORT[position]);
        holder.price.setText(PRICE[position]);
        holder.title.setText(NAME[position]);
    }

    @Override
    public int getItemCount() {
        return NAME.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView price;
        TextView size;
        TextView sort;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.market_tv_title);
            imageView=itemView.findViewById(R.id.iv_market_pic);
            price=itemView.findViewById(R.id.market_item_tv_price);
            sort=itemView.findViewById(R.id.market_item_tv_sort);
            size=itemView.findViewById(R.id.market_item_tv_size);
        }
    }
}
