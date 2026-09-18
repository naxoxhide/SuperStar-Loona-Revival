package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.t;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: FullViewManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f2346b;
    private WeakReference<Context> a;

    private a(Context context) {
        this.a = new WeakReference<>(context);
    }

    public static a a(Context context) {
        if (f2346b == null) {
            synchronized (a.class) {
                if (f2346b == null) {
                    f2346b = new a(context);
                }
            }
        }
        return f2346b;
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.nativex.view.mbfullview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FullViewManager.java */
    private class C0499a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<MBridgeTopFullView> f2348b;

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
        }

        public C0499a(MBridgeTopFullView mBridgeTopFullView) {
            this.f2348b = new WeakReference<>(mBridgeTopFullView);
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(Bitmap bitmap, String str) {
            WeakReference<MBridgeTopFullView> weakReference = this.f2348b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f2348b.get().getMBridgeFullViewDisplayIcon().setImageBitmap(a.a(a.this, bitmap, 25));
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.nativex.view.mbfullview.a$2, reason: invalid class name */
    /* JADX INFO: compiled from: FullViewManager.java */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BaseView.a.values().length];
            a = iArr;
            try {
                iArr[BaseView.a.FULL_TOP_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BaseView.a.FULL_MIDDLE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final void a(BaseView.a aVar, CampaignEx campaignEx, BaseView baseView) {
        int i = AnonymousClass2.a[aVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            baseView.getMBridgeFullTvInstall().setText(campaignEx.getAdCall());
            return;
        }
        MBridgeTopFullView mBridgeTopFullView = (MBridgeTopFullView) baseView;
        if (mBridgeTopFullView != null) {
            Context context = this.a.get();
            if (context != null) {
                b.a(context).a(campaignEx.getIconUrl(), new C0499a(mBridgeTopFullView));
            }
            mBridgeTopFullView.getMBridgeFullViewDisplayTitle().setText(campaignEx.getAppName());
            mBridgeTopFullView.getMBridgeFullViewDisplayDscription().setText(campaignEx.getAppDesc());
            mBridgeTopFullView.getMBridgeFullTvInstall().setText(campaignEx.getAdCall());
            mBridgeTopFullView.getStarLevelLayoutView().setRating((int) campaignEx.getRating());
        }
    }

    public final void a(boolean z, BaseView baseView, int i) {
        RelativeLayout.LayoutParams layoutParams;
        Context context = this.a.get();
        if (context != null) {
            if (z) {
                layoutParams = new RelativeLayout.LayoutParams((int) (a(z) / 3.0f), af.b(context, 45.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = af.b(context, 10.0f);
                layoutParams.rightMargin = af.a(context) && i == 0 ? af.l(context) + af.b(context, 8.0f) : af.b(context, 8.0f);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, af.b(context, 45.0f));
                layoutParams.addRule(12);
            }
            baseView.getmAnimationContent().setLayoutParams(layoutParams);
        }
    }

    private float a(boolean z) {
        try {
            Context context = this.a.get();
            if (context == null) {
                return 0.0f;
            }
            float fJ = af.j(context);
            return z ? fJ + af.l(context) : fJ;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final void a(final boolean z, boolean z2, final BaseView baseView) {
        int color = Color.parseColor("#ff264870");
        baseView.getmAnimationPlayer().setBackgroundColor(color);
        Context context = this.a.get();
        if (!z) {
            if (baseView.style != BaseView.a.FULL_MIDDLE_VIEW) {
                if (context != null) {
                    baseView.getmAnimationContent().setBackgroundResource(t.a(context, "mbridge_nativex_cta_por_pre", "drawable"));
                    baseView.getmAnimationPlayer().setBackgroundResource(t.a(context, "mbridge_nativex_cta_por_pre", "drawable"));
                    return;
                }
                return;
            }
        } else {
            if (baseView.style == BaseView.a.FULL_TOP_VIEW && context != null) {
                baseView.getmAnimationContent().setBackgroundResource(t.a(context, "mbridge_nativex_fullview_background", "drawable"));
                baseView.getmAnimationPlayer().setBackgroundColor(color);
            }
            if (z2) {
                baseView.getmAnimationPlayer().getBackground().setAlpha(80);
            } else {
                baseView.getmAnimationPlayer().setBackgroundColor(Color.parseColor("#ff4c8fdf"));
                baseView.getmAnimationPlayer().getBackground().setAlpha(200);
            }
        }
        if (z2) {
            new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.nativex.view.mbfullview.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    baseView.getmAnimationPlayer().setBackgroundColor(Color.parseColor("#ff4c8fdf"));
                    baseView.getmAnimationPlayer().getBackground().setAlpha(z ? 200 : 255);
                    a.a(a.this, baseView.getmAnimationPlayer());
                }
            }, 1000L);
        }
    }

    public final void a(View view, BaseView baseView) {
        if (view == null || baseView == null) {
            return;
        }
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        baseView.i.addView(view);
    }

    public final void a(BaseView baseView, boolean z) {
        if (baseView == null || Build.VERSION.SDK_INT < 11) {
            return;
        }
        baseView.setSystemUiVisibility(z ? 0 : InputDeviceCompat.SOURCE_TOUCHSCREEN);
    }

    static /* synthetic */ Bitmap a(a aVar, Bitmap bitmap, int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        bitmap.getWidth();
        float f = i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    static /* synthetic */ void a(a aVar, View view) {
        if (view == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(800L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setRepeatCount(2);
        alphaAnimation.setRepeatMode(1);
        view.startAnimation(alphaAnimation);
    }
}
