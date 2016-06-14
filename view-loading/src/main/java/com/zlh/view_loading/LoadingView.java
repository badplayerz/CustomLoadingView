package com.zlh.view_loading;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by sdbean-zlh on 15/7/15.
 */
public class LoadingView {

    public static Dialog createLoadingDialog(Context context, String msg) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.custom_loading, null);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);

        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
        spaceshipImage.setImageDrawable(tools.getBitmapDrawable(context,R.drawable.publicloading));
//        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(context, R.anim.load_http_animation);

        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
//        tipTextView.setText(msg);

        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);

        loadingDialog.setCancelable(true);
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        return loadingDialog;

    }


}
