package com.gomfactory.adpie.sdk.util;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationUtil {
    public static final int ANIMATION_BOTTOM_TO_TOP_SLIDE = 4;
    public static final int ANIMATION_FADE = 5;
    public static final int ANIMATION_LEFT_TO_RIGHT_SLIDE = 1;
    public static final int ANIMATION_NONE = 0;
    public static final int ANIMATION_RIGHT_TO_LEFT_SLIDE = 2;
    public static final int ANIMATION_TOP_TO_BOTTOM_SLIDE = 3;
    private static final long duration = 500;

    public static Animation getShowAnimation(int i, View view) {
        AnimationSet animationSet;
        Animation animation;
        AnimationSet animationSet2;
        AnimationSet animationSet3;
        AnimationSet animationSet4;
        AlphaAnimation alphaAnimation;
        AlphaAnimation alphaAnimation2;
        if (i == 1) {
            animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f));
            animationSet.setDuration(duration);
        } else if (i == 2) {
            animationSet2 = new AnimationSet(true);
            animationSet2.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet2.addAnimation(new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f));
            animationSet2.setDuration(duration);
        } else if (i == 3) {
            animationSet3 = new AnimationSet(true);
            animationSet3.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet3.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f));
            animationSet3.setDuration(duration);
        } else if (i == 4) {
            animationSet4 = new AnimationSet(true);
            animationSet4.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet4.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f));
            animationSet4.setDuration(duration);
        } else if (i == 5) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(duration);
        } else {
            alphaAnimation2 = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation2.setDuration(0L);
        }
        if (animation != null) {
            animation = animationSet;
            animation = animationSet2;
            animation = animationSet3;
            animation = animationSet4;
            animation = alphaAnimation;
            animation = alphaAnimation2;
            animation.setFillEnabled(true);
            animation.setFillAfter(false);
            animation.setFillBefore(true);
        }
        animation = animationSet;
        animation = animationSet2;
        animation = animationSet3;
        animation = animationSet4;
        animation = alphaAnimation;
        animation = alphaAnimation2;
        return animation;
    }

    public static Animation getHideAnimation(int i, View view) {
        TranslateAnimation translateAnimation;
        Animation animation;
        TranslateAnimation translateAnimation2;
        TranslateAnimation translateAnimation3;
        TranslateAnimation translateAnimation4;
        AlphaAnimation alphaAnimation;
        AlphaAnimation alphaAnimation2;
        if (i == 1) {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(duration);
        } else if (i == 2) {
            translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setDuration(duration);
        } else if (i == 3) {
            translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation3.setDuration(duration);
        } else if (i == 4) {
            translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation4.setDuration(duration);
        } else if (i == 5) {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(duration);
        } else {
            alphaAnimation2 = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation2.setDuration(0L);
        }
        if (animation != null) {
            animation = translateAnimation;
            animation = translateAnimation2;
            animation = translateAnimation3;
            animation = translateAnimation4;
            animation = alphaAnimation;
            animation = alphaAnimation2;
            animation.setFillEnabled(true);
            animation.setFillAfter(true);
            animation.setFillBefore(false);
        }
        animation = translateAnimation;
        animation = translateAnimation2;
        animation = translateAnimation3;
        animation = translateAnimation4;
        animation = alphaAnimation;
        animation = alphaAnimation2;
        return animation;
    }
}
