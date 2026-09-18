package com.applovin.impl.sdk.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: classes.dex */
public class v {
    public static boolean gX(int i) {
        return i == 0;
    }

    public static void a(View view, long j) {
        a(view, j, null);
    }

    public static void a(final View view, long j, final Runnable runnable) {
        view.setVisibility(4);
        view.bringToFront();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.applovin.impl.sdk.utils.v.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
        view.startAnimation(alphaAnimation);
    }

    public static void b(final View view, long j, final Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.applovin.impl.sdk.utils.v.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
        view.startAnimation(alphaAnimation);
    }

    public static boolean T(int i, int i2) {
        return gX(i) != gX(i2);
    }

    public static String gY(int i) {
        if (i == 0) {
            return "VISIBLE";
        }
        if (i == 4) {
            return "INVISIBLE";
        }
        return i == 8 ? "GONE" : String.valueOf(i);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    /* JADX WARN: Code duplicated, block: B:24:0x0043  */
    public static int[] m(int i, int i2, int i3) {
        if (i == 0) {
            return new int[]{i2, i3};
        }
        if ((i & 119) == 119) {
            return new int[]{13};
        }
        if ((i & 112) == 112) {
            i2 = 15;
        } else if ((i & 48) == 48) {
            i2 = 10;
        } else if ((i & 80) == 80) {
            i2 = 12;
        } else if ((i & 16) == 16) {
            i2 = 15;
        }
        if ((i & 7) == 7) {
            i3 = 14;
        } else if (h.KT() && (i & GravityCompat.START) == 8388611) {
            i3 = 20;
        } else if ((i & 3) == 3) {
            i3 = 9;
        } else if (h.KT() && (i & GravityCompat.END) == 8388613) {
            i3 = 21;
        } else if ((i & 5) == 5) {
            i3 = 11;
        } else if ((i & 1) == 1) {
            i3 = 14;
        }
        return new int[]{i3, i2};
    }

    public static void B(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }
}
