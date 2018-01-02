package com.image.library;

import android.content.Context;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.engine.DiskCacheStrategy;



/**
 * Created by xiaoxiao on 2017/4/14.
 */
public class UtilsImg {
    //动画载入网络圆角图片
    public static void getRoundAnimImg(Context mContext, String url, int resourceId, ImageView view) {
        Glide.with(mContext)
                .load(url)
                .centerCrop().animate(R.anim.imgenlarge).transform(new GlideRoundTransform(mContext, 5))
                .placeholder(resourceId).into(view);
    }
    //无动画载入网络圆角图片
    public static void getRoundImg(Context mContext, String url, int resourceId, ImageView view) {
        Glide.with(mContext)
                .load(url).crossFade()
                .centerCrop().transform(new GlideRoundTransform(mContext, 5))
                .placeholder(resourceId).into(view);
    }

    //无动画载入网络圆角图片
    /*public static void getRoundAppointImg(Context mContext, String url, int resourceId, ImageView view,int RoundNum,RoundCornersTransformation.CornerType type) {
        Glide.with(mContext)
                .load(url).crossFade()
                .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, UtilsTools.dip2px(mContext,RoundNum), type))
                .placeholder(resourceId).into(view);
    }
    //无动画载入本地圆角图片
    public static void getLocationRoundAppointImg(Context mContext, int resourceId, ImageView view,int RoundNum,RoundCornersTransformation.CornerType type) {
        Glide.with(mContext)
                .load(resourceId).crossFade()
                .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, UtilsTools.dip2px(mContext,RoundNum), type))
                .into(view);
    }*/

    //普通载入网络图片
    public static void getGlideImg(Context mContext, String url, int resourceId, ImageView view) {
        Glide.with(mContext)
                .load(url)
                .centerCrop().dontAnimate().crossFade()
                .placeholder(resourceId)
                .into(view);
    }

    //动画载入网络图片
    public static void getGlideAnimImg(Context mContext, String url, int resourceId, ImageView view) {

        Glide.with(mContext)
                .load(url)
                .centerCrop().animate(R.anim.imgenlarge)
                .placeholder(resourceId)
                .into(view);
    }

    //本地图片
    public static void getGlideLocalImg(Context mContext, int LocalUrl, ImageView view) {
        Glide.with(mContext)
                .load(LocalUrl)
                .centerCrop()
                .into(view);
    }


    //本地圆角图片
    public static void getGlideRoundLocalImg(Context mContext, int LocalUrl, ImageView view) {
        Glide.with(mContext)
                .load(LocalUrl)
                .centerCrop().animate(R.anim.imgenlarge).transform(new GlideRoundTransform(mContext, 5))
                .into(view);
    }

    //圆形图片
    public static void getGlideCircleImg(Context mContext, String url, int resourceId, ImageView view) {
        Glide.with(mContext)
                .load(url).placeholder(resourceId)
                .centerCrop().transform(new GlideCircleTransform(mContext))
                .into(view);
    }

    //动态图片
    public static void getGlideGifImg(Context mContext, String url, ImageView view) {
        Glide.with(mContext).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(view);
    }

    //无动画载入相册选入圆角图片
    public static void getCmmRoundImg(Context mContext, String url,int state, ImageView view) {
        if(state == 0) {
            Glide.with(mContext)
                    .load(url).crossFade()
                    .centerCrop().transform(new GlideRoundTransform(mContext, 5))
                    .into(view);
        }else{
            Glide.with(mContext)
                    .load(state).crossFade()
                    .centerCrop().transform(new GlideRoundTransform(mContext, 5))
                    .into(view);
        }
    }

    //普通载入网络图片
    public static void getTabGlideImg(Context mContext, String url,int resourceId, ImageView view) {
        Glide.with(mContext)
                .load(url).placeholder(resourceId)
                .centerCrop().dontAnimate().crossFade().skipMemoryCache(true)
                .into(view);
    }

}
