package dialer.com.example.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {
    //SharedPreference对象
    private static SharedPreferences sharedPreferences;
    /*
     * @Author CST18043
     * @Description //TODO 存储生命值的方法
     * @Date  2020/4/10 22:41
     * @Param
     * @return
     */
    public static void saveLife(Context context, String key, int value){
        //判断文件对象是否存在，如果不存在，就新建一个
        if (sharedPreferences==null){
            //新建SharedPreferences文件对象，设置存储模式
            sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        }
        //获取编辑对象
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //获取编辑对象
        editor.putInt(key,value);
        //提交存储的内容
        editor.apply();
    }
    /*
     * @Author CST18043
     * @Description //TODO 获取生命值
     * @Date  2020/4/10 23:11
     * @Param 
     * @return 
     */
    public static int getLife(Context context, String key,int defvalue){
        if (sharedPreferences==null){
            //获取SharedPreferences对象
            sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        }
        //返回存储的值，如果没有值，则返回默认值0
       return sharedPreferences.getInt(key,defvalue);
    }

    /*
     * @Author CST18043
     * @Description //TODO 存储生命值的方法
     * @Date  2020/4/10 22:41
     * @Param
     * @return
     */
    public static void savePic(Context context, String key, boolean value){
        //判断文件对象是否存在，如果不存在，就新建一个
        if (sharedPreferences==null){
            //新建SharedPreferences文件对象，设置存储模式
            sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        }
        //获取编辑对象
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //获取编辑对象
        editor.putBoolean(key,value);
        //提交存储的内容
        editor.apply();
    }
    /*
     * @Author CST18043
     * @Description //TODO 获取生命值
     * @Date  2020/4/10 23:11
     * @Param
     * @return
     */
    public static boolean getPic(Context context, String key,boolean defvalue){
        if (sharedPreferences==null){
            //获取SharedPreferences对象
            sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        }
        //返回存储的值，如果没有值，则返回默认值false
        return sharedPreferences.getBoolean(key,defvalue);
    }
}
