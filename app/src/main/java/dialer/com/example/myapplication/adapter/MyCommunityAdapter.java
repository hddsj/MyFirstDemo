package dialer.com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import dialer.com.example.myapplication.R;

public class MyCommunityAdapter extends BaseAdapter {
    private Context context;
    private String[] text={"每次煮饭洗碗的时候看看植物就觉得很治愈，心头的烦躁也被抚平了不少。我们多给自己创造一些微小的美好，再难的日子也能好好度过。","终于开始爬了。","金盏花又开了一朵。"};
    private String[] USERNAME={"用户A","用户B","用户C"};
    private int[] PICS={R.drawable.first,R.drawable.comment_second_pic,R.drawable.comment_third_pic};
    public MyCommunityAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null){
            view=View.inflate(context,R.layout.community_card_item,null);
            viewHolder=new ViewHolder();
            viewHolder.pic=view.findViewById(R.id.iv_show);
            viewHolder.username=view.findViewById(R.id.username);
            viewHolder.content=view.findViewById(R.id.comment);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.username.setText(USERNAME[i]);
        viewHolder.content.setText(text[i]);
        viewHolder.pic.setImageResource(PICS[i]);
        return view;
    }
    class ViewHolder{
        public ImageView pic;
        public TextView username;
        public TextView content;
    }
}
