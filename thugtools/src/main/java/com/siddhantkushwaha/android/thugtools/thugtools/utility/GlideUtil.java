package com.siddhantkushwaha.android.thugtools.thugtools.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtil {

    /* Do not add functions with Glide Classes, since it will need Glide to be added to the main module, hence making
    it of no use */

    public static void preload(Context context, String uri, RequestOptions requestOptions) {

        GlideApp.with(context).load(uri).preload();
    }

    @SuppressLint("CheckResult")
    public static void loadImage(Context context, String uri, ImageView imageView, int placeHolder, int error) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(placeHolder);
        requestOptions.error(error);

        GlideApp.with(context.getApplicationContext())
                .load(uri)
                .apply(requestOptions)
                .into(imageView);
    }
}
