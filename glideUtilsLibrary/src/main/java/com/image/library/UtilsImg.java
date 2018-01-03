package com.image.library;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;


/**
 *
 * @author xiaoxiao
 * @date 2017/4/14
 */
public class UtilsImg {
    Drawable d1, d2;
    private static LoadType mLoadType;

    private static UtilsImg manager;

    public enum LoadType {
        /**
         * 动画载入网络圆角图片
         */
        AnimaRoundAppointImg,
        /**
         * 无动画载入网络圆角图片
         */
        RoundAppointImg,
        /**
         * 无动画载入本地圆角图片
         */
        LocationRoundAppointImg,
        /**
         * 动态图片
         */
        GlideGifImg,
        /**
         * 圆形图片
         */
        GlideCircleImg,
        /**
         * 仿美团点击TAB动画特效
         */
        AlphaAnima,
    }

    public void GlideImg(final Context mContext, String beginUrl, final String endUrl, int resourceId, final ImageView view, int RoundNum,RoundCornersTransformation.CornerType type,int animationId) {
        if(resourceId ==0 ){
            resourceId = R.color.transparent;
        }
        if(type == null){
            type = RoundCornersTransformation.CornerType.ALL;
        }
        if(animationId == 0){
            animationId = R.anim.imgenlarge;
        }
        switch (mLoadType) {
            case AnimaRoundAppointImg:
                Glide.with(mContext)
                        .load(endUrl).animate(animationId)
                        .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, dip2px(mContext, RoundNum), type))
                        .placeholder(resourceId).into(view);
                break;
            case RoundAppointImg:
                Glide.with(mContext)
                        .load(endUrl).crossFade().dontAnimate()
                        .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, dip2px(mContext, RoundNum), type))
                        .placeholder(resourceId).into(view);
                break;
            case LocationRoundAppointImg:
                Glide.with(mContext)
                        .load(resourceId).crossFade()
                        .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, dip2px(mContext, RoundNum), type))
                        .into(view);
                break;
            case GlideGifImg:
                Glide.with(mContext).load(endUrl).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(view);
                break;
            case GlideCircleImg:
                Glide.with(mContext)
                        .load(endUrl).placeholder(resourceId)
                        .centerCrop().transform(new GlideCircleTransform(mContext))
                        .into(view);
                break;
            case AlphaAnima:
                Glide.with(mContext).load(beginUrl).asBitmap()
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                d1 = BitmapToDrawable(resource);
                                Glide.with(mContext).load(endUrl).asBitmap()
                                        .into(new SimpleTarget<Bitmap>() {
                                            @Override
                                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                                d2 = BitmapToDrawable(resource);
                                                Drawable[] drawableArray = {
                                                        d1, d2
                                                };
                                                TransitionDrawable transitionDrawable = new TransitionDrawable(drawableArray);
                                                view.setImageDrawable(transitionDrawable);
                                                transitionDrawable.startTransition(250);
                                            }
                                        });
                            }
                        });

                break;
            default:
                break;
        }
    }


    public static UtilsImg get(LoadType type) {
        mLoadType = type;
        if (manager == null) {
            synchronized (UtilsImg.class) {
                if (manager == null) {
                    manager = new UtilsImg();
                }
            }
        }
        return manager;
    }

    public static Drawable BitmapToDrawable(Bitmap bmp) {
        Drawable drawable = new BitmapDrawable(bmp);
        return drawable;
    }
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
