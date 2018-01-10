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
 * @author xiaoxiao
 * @date 2017/4/14
 */
public class UtilsImg {
    static Drawable d1;
    static Drawable d2;

    /**
     * @param mContext 当前Activity
     * @param imgUrl   图片Url
     * @param view     ImageView控件
     */
    public static void glideImg(final Context mContext, final Object imgUrl, final ImageView view) {
        Glide.with(mContext)
                .load(imgUrl).crossFade()
                .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, dip2px(mContext, 0), RoundCornersTransformation.CornerType.ALL))
                .into(view);
    }

    /**
     * @param mContext   当前Activity
     * @param imgUrl     图片Url
     * @param resourceId 图片未加载显示的默认图
     * @param view       ImageView控件
     */
    public static void glideImg(final Context mContext, final Object imgUrl, int resourceId, final ImageView view) {
        Glide.with(mContext)
                .load(imgUrl).crossFade().placeholder(resourceId)
                .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, dip2px(mContext, 0), RoundCornersTransformation.CornerType.ALL))
                .into(view);
    }

    /**
     * @param mContext   当前Activity
     * @param imgUrl     图片Url
     * @param resourceId 图片未加载显示的默认图
     * @param view       ImageView控件
     */
    public static void glideImg(final Context mContext, final Object imgUrl, int resourceId, int animationId, final ImageView view) {
        Glide.with(mContext)
                .load(imgUrl).placeholder(resourceId).animate(animationId)
                .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, dip2px(mContext, 0), RoundCornersTransformation.CornerType.ALL))
                .into(view);
    }

    /**
     * @param mContext   当前Activity
     * @param imgUrl     图片Url
     * @param resourceId 图片未加载显示的默认图
     * @param view       ImageView控件
     * @param type       图片圆角的位置
     */
    public static void glideImg(final Context mContext, final Object imgUrl, int resourceId, final ImageView view, int RoundNum, RoundCornersTransformation.CornerType type) {
        Glide.with(mContext)
                .load(imgUrl).placeholder(resourceId)
                .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, dip2px(mContext, RoundNum), type))
                .into(view);
    }

    /**
     * @param mContext    当前Activity
     * @param imgUrl      图片Url
     * @param resourceId  图片未加载显示的默认图
     * @param animationId 图片显示时候的动画
     * @param view        ImageView控件
     * @param roundNum    图片圆角的度数 0--xxx
     * @param type        图片圆角的位置
     */
    public static void glideImg(final Context mContext, final Object imgUrl, int resourceId, int animationId, final ImageView view, int roundNum, RoundCornersTransformation.CornerType type) {
        Glide.with(mContext)
                .load(imgUrl).placeholder(resourceId).animate(animationId)
                .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, dip2px(mContext, roundNum), type))
                .into(view);
    }

    /**
     * @param mContext 当前Activity
     * @param imgUrl   图片Url
     * @param view     ImageView控件
     */
    public static void glideGifImg(final Context mContext, final String imgUrl, final ImageView view) {
        Glide.with(mContext).load(imgUrl).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(view);
    }

    /**
     * @param mContext   当前Activity
     * @param resourceId 图片未加载显示的默认图
     * @param view       ImageView控件

    public static void glideLocationgImg(final Context mContext, final int resourceId, final ImageView view) {
        Glide.with(mContext)
                .load(resourceId).crossFade()
                .centerCrop().bitmapTransform(new RoundCornersTransformation(mContext, dip2px(mContext, 0), RoundCornersTransformation.CornerType.ALL))
                .into(view);
    }*/

    /**
     * @param mContext 当前Activity
     * @param imgUrl   图片Url
     * @param view     ImageView控件
     */
    public static void glideCircleImg(Context mContext, String imgUrl, ImageView view) {
        Glide.with(mContext)
                .load(imgUrl).crossFade()
                .centerCrop().transform(new GlideCircleTransform(mContext))
                .into(view);
    }

    /**
     * @param mContext   当前Activity
     * @param imgUrl     图片Url
     * @param resourceId 图片未加载显示的默认图
     * @param view       ImageView控件
     */
    public static void glideCircleImg(Context mContext, String imgUrl, int resourceId, ImageView view) {
        Glide.with(mContext)
                .load(imgUrl).placeholder(resourceId).crossFade()
                .centerCrop().transform(new GlideCircleTransform(mContext))
                .into(view);
    }

    /**
     * @param mContext       当前Activity
     * @param beginUrl       原图片Url
     * @param endUrl         需要动画过度后图片的Url
     * @param transitionTime 图片显示时候的动画时间
     * @param view           ImageView控件
     */
    public static void alphaAnima(final Context mContext, Object beginUrl, final Object endUrl, final int transitionTime, final ImageView view) {
        Glide.with(mContext).load(beginUrl).asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        d1 = BitmapToDrawable(mContext, resource);
                        Glide.with(mContext).load(endUrl).asBitmap()
                                .into(new SimpleTarget<Bitmap>() {
                                    @Override
                                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                        d2 = BitmapToDrawable(mContext, resource);
                                        Drawable[] drawableArray = {
                                                d1, d2
                                        };
                                        TransitionDrawable transitionDrawable = new TransitionDrawable(drawableArray);
                                        view.setImageDrawable(transitionDrawable);
                                        transitionDrawable.startTransition(transitionTime);
                                    }
                                });
                    }
                });
    }


    public static Drawable BitmapToDrawable(Context mContext, Bitmap bmp) {
        Drawable drawable = new BitmapDrawable(mContext.getResources(), bmp);
        return drawable;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
