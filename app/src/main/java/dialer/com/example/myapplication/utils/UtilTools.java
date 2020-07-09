package dialer.com.example.myapplication.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * @Author CST18043
 * @Description 工具类
 * @Date  2020/6/29 16:13
 * @Param
 * @return
 **/
public class UtilTools {
    public static void setFont(Context mContext, TextView textView){
        Typeface fontType=Typeface.createFromAsset(mContext.getAssets(),"fonts/ziti.ttf");
        textView.setTypeface(fontType);
    }
}
