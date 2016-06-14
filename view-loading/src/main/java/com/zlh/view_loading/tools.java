package com.zlh.view_loading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import java.io.InputStream;

/**
 * Created by sdbean-zlh on 16/6/14.
 */
public class tools {

    public static BitmapDrawable getBitmapDrawable(Context context, int intDrawable){

        BitmapFactory.Options opt = new BitmapFactory.Options();

        opt.inPreferredConfig = Bitmap.Config.RGB_565;

        opt.inPurgeable = true;

        opt.inInputShareable = true;

        //获取资源图片
        InputStream is = null;

        Bitmap bitmap = null;

        try {
            is = context.getResources().openRawResource(intDrawable);
            bitmap = BitmapFactory.decodeStream(is, null, opt);
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return new BitmapDrawable(context.getResources(),bitmap);

    }
}
