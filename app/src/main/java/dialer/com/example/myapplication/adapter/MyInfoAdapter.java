package dialer.com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import dialer.com.example.myapplication.R;
import dialer.com.example.myapplication.utils.UtilTools;

public class MyInfoAdapter extends BaseAdapter {
    private static final String TAG = "MyInfoAdapter";
    private int layoutInflater;
    private Context context;
    private int PICS[]={R.drawable.info_pic_1,R.drawable.info_pic_2,R.drawable.info_pic_3,R.drawable.info_pic_4,
            R.drawable.info_pic_5,R.drawable.info_pic_6,R.drawable.info_pic_7,R.drawable.info_pic_8,R.drawable.info_pic_9,
            R.drawable.info_pic_10};//植物列表所需要的图片
    private String TITLES[]={"空气凤梨","罗汉松","条纹十二卷","紫薇","锦晃星","常春藤","白肋万年青","金线兰","红掌","海芋"};//植物的名字
    private String INFOS[]={"空气凤梨是地球上唯一完全生于空气中的植物，不用泥土即可生长茂盛，并能绽放出鲜艳的花朵",
            "罗汉松，罗汉松科，罗汉松属常绿针叶乔木。高达20m，胸径60cm，树冠广卵形。树皮灰褐色至暗灰色，浅纵裂，片状脱落","条纹十二卷本名条纹蛇尾兰，为百合科十二卷属多年生肉质草本植物，具有很好的观赏价值","紫薇（拉丁文名：Lagerstroemia indica L.），别名：痒痒花、痒痒树、紫金花、紫兰花、蚊子花、西洋水杨梅、百日红、无皮树。是双子叶植物纲","锦晃星是景天科石莲花属的多肉植物，肥厚、多肉的叶片上布满了白色的绒毛，叶缘有夺目的红色，与冬季和早春展开的橙红色小花交相辉映，异常美丽","常春藤为多年生常绿攀援灌木，叶形美丽四季常青。在南方地区多作为垂直绿化使用，将其栽植于假山、墙根，让其自然生长。","茎高可达50厘米，幼株叶柄苍绿色，淡紫色斑块，叶片表面中肋白色，成熟植株叶柄下半部具鞘；叶片宽椭圆形，短渐尖，花枝上部的叶柄短","（天门冬目兰科植物）植株高8-18厘米。根状茎匍匐，伸长，肉质，具节，节上生根。茎直立，肉质，圆柱形，具2-4枚叶。叶片卵圆形或卵形","红掌为多年生常绿草本植物。花朵独特，色泽鲜艳华丽，花期较长，每朵花颜色多变，从绽放到枯萎先后变为米黄、乳白、绿色、黄色，具有极大的观赏价值","海芋（拉丁学名：Alocasia macrorrhiza (L.) Schott ），天南星科海芋属多年生草本植物。染色体数2n=2x=26。茎粗壮，高可达3m"};//植物列表的信息概括

    public MyInfoAdapter(int layoutInflater, Context context) {
        this.layoutInflater = layoutInflater;
        this.context = context;
    }

    @Override
    public int getCount() {
        return PICS.length;
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
        MyHolder myHolder;
        if (view==null){
            view=View.inflate(context,layoutInflater,null);
            myHolder=new MyHolder();
            myHolder.imageView=view.findViewById(R.id.iv_info_pic);
            myHolder.title=view.findViewById(R.id.tv_info_title);
            myHolder.infos=view.findViewById(R.id.tv_info_text);
            view.setTag(myHolder);
        }else
        {
            myHolder = (MyHolder) view.getTag();
        }
        UtilTools.setFont(context,myHolder.title);
        UtilTools.setFont(context,myHolder.infos);
        myHolder.imageView.setImageResource(PICS[i]);
        myHolder.title.setText(TITLES[i]);
        myHolder.infos.setText(INFOS[i]);
        return view;
    }
    class MyHolder {
        public ImageView imageView;
        public TextView title;
        public TextView infos;
    }
}
