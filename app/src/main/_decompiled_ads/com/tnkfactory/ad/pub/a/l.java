package com.tnkfactory.ad.pub.a;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes4.dex */
public final class l {
    public static Animation a() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    public static Animation a(int i) {
        switch (i) {
            case 2:
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                return alphaAnimation;
            case 3:
                return a();
            case 4:
                return h();
            case 5:
                return d();
            case 6:
                return f();
            case 7:
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -720.0f, 1, 0.5f, 1, 0.5f);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.setDuration(500L);
                return animationSet;
            case 8:
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, 1, 0.5f, 1, 0.5f);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                AnimationSet animationSet2 = new AnimationSet(false);
                animationSet2.addAnimation(scaleAnimation2);
                animationSet2.addAnimation(alphaAnimation2);
                animationSet2.setDuration(300L);
                return animationSet2;
            case 9:
                ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, 1, 0.5f, 1, 0.5f);
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                AnimationSet animationSet3 = new AnimationSet(false);
                animationSet3.addAnimation(scaleAnimation3);
                animationSet3.addAnimation(alphaAnimation3);
                animationSet3.setDuration(300L);
                return animationSet3;
            default:
                return null;
        }
    }

    public static Animation a(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        strTrim.getClass();
        strTrim.hashCode();
        switch (strTrim) {
            case "bottom":
                return b();
            case "top":
                return g();
            case "left":
                return c();
            case "right":
                return e();
            default:
                return null;
        }
    }

    public static Animation b() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    public static Animation c() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    public static Animation d() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    public static Animation e() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    public static Animation f() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    public static Animation g() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -1.0f, 2, 0.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    public static Animation h() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }
}
