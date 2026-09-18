package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.security.CertificateUtil;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.pub.model.EvtTrackUrls;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends RelativeLayout {
    public Animation a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Animation f2865b;
    public j0 c;
    public com.tnkfactory.ad.pub.a d;
    public HandlerC0529e e;
    public boolean f;
    public long g;
    public com.tnkfactory.ad.pub.b h;
    public Map<String, Object> i;
    public boolean j;
    public d k;
    public com.tnkfactory.ad.pub.a.c l;
    public com.tnkfactory.ad.pub.a.d m;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e eVar = e.this;
            if (eVar.d.L != 4) {
                eVar.requestFocus();
            }
            e.this.b();
        }
    }

    public class b implements j.d {
        public final /* synthetic */ com.tnkfactory.ad.pub.b.b a;

        public b(com.tnkfactory.ad.pub.b.b bVar) {
            this.a = bVar;
        }

        @Override // com.tnkfactory.ad.pub.a.j.d
        public final void a() {
        }

        @Override // com.tnkfactory.ad.pub.a.j.d
        public final void b() {
            this.a.a();
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.this.a(this.a);
        }
    }

    public interface d {
    }

    /* JADX INFO: renamed from: com.tnkfactory.ad.pub.a.e$e, reason: collision with other inner class name */
    public static class HandlerC0529e extends Handler {
        public final WeakReference<e> a;

        public HandlerC0529e(e eVar) {
            this.a = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            e eVar = this.a.get();
            if (eVar == null || message == null || !eVar.j) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                eVar.a(AdListener.CLOSE_SIMPLE, true);
                return;
            }
            if (i == 1) {
                eVar.a(message.arg1, eVar.d.j);
                return;
            }
            if (i == 2) {
                eVar.a(AdListener.CLOSE_EXIT, true);
                return;
            }
            if (i == 8) {
                if (eVar.d.z != null) {
                    i.a(eVar.getContext(), eVar.d.z, false);
                }
            } else {
                if (i == 9) {
                    eVar.a(message.arg1, (String) message.obj);
                    return;
                }
                int i2 = i - 100;
                com.tnkfactory.ad.pub.b.t tVar = new com.tnkfactory.ad.pub.b.t(eVar.getContext(), eVar.d);
                if (i2 != 100) {
                    tVar.a(i2, eVar.i, null);
                } else {
                    tVar.a(i2, eVar.i, new f(eVar));
                    eVar.f = false;
                }
            }
        }
    }

    public e(Context context, int i, int i2, com.tnkfactory.ad.pub.a aVar, boolean z) {
        super(context);
        this.a = null;
        this.f2865b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = 0L;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = null;
        this.l = null;
        this.m = null;
        try {
            com.tnkfactory.ad.pub.b bVarA = w.a(context, i, i2, aVar.c0, aVar.b0, aVar.J, z, aVar);
            this.h = bVarA;
            if (bVarA == null) {
                this.j = false;
                return;
            }
            this.j = true;
            addView(bVarA);
            a(aVar);
            HandlerC0529e handlerC0529e = new HandlerC0529e(this);
            this.e = handlerC0529e;
            this.h.a(handlerC0529e);
        } catch (Exception e) {
            e.printStackTrace();
            this.j = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        if (!l0.a((View) this, true) || this.l == null || this.m == null) {
            return;
        }
        c();
        d();
    }

    public final void a(int i) {
        com.tnkfactory.ad.pub.a aVar = this.d;
        i.a(getContext(), i.a(aVar.d, aVar.j, aVar.g, i, this.i), true);
        if (this.d.C != null) {
            new com.tnkfactory.ad.pub.b.s(this.d.C).start();
        }
        j0 j0Var = this.c;
        if (j0Var != null) {
            j0Var.a();
        }
    }

    public void a(int i, boolean z) {
        com.tnkfactory.ad.pub.b bVar = this.h;
        for (String str : bVar.g.keySet()) {
            View viewA = bVar.a(str);
            if (viewA != null) {
                bVar.g.get(str);
                viewA.clearAnimation();
            }
        }
        this.j = false;
    }

    public final void a(String str, String str2) {
        if (str != null) {
            View viewA = this.h.a(str2);
            if (viewA instanceof TextView) {
                ((TextView) viewA).setText(str);
            }
        }
    }

    public void b() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x002c  */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    public final boolean b(com.tnkfactory.ad.pub.a aVar) {
        boolean z;
        boolean z2 = false;
        for (String str : aVar.d0.keySet()) {
            t tVar = (t) aVar.d0.get(str);
            com.tnkfactory.ad.pub.b bVar = this.h;
            bVar.getClass();
            if (tVar == null) {
                z2 = z2;
                z = true;
            } else {
                View viewA = bVar.a(str);
                Bitmap bitmap = tVar.a;
                if (viewA instanceof ImageView) {
                    if (bitmap != null) {
                        ImageView imageView = (ImageView) viewA;
                        if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            double width = ((double) bitmap.getWidth()) / ((double) bitmap.getHeight());
                            double d2 = ((double) imageView.getLayoutParams().width) / ((double) imageView.getLayoutParams().height);
                            imageView.setScaleType((d2 > 1.0d ? width <= d2 : width > d2) ? ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.CENTER_CROP);
                        }
                        imageView.setImageBitmap(bitmap);
                        if (u.a("c77c089be85694").equals(str)) {
                            ?? r2 = bVar.a;
                            if (r2 != 0 && r2.size() > 0) {
                                int iA = l0.a(bitmap, 2);
                                Iterator it = bVar.a.iterator();
                                while (it.hasNext()) {
                                    bVar.a((String) it.next(), iA);
                                }
                            }
                            ?? r3 = bVar.f2898b;
                            if (r3 != 0 && r3.size() > 0) {
                                int iA2 = l0.a(bitmap, 3);
                                Iterator it2 = bVar.f2898b.iterator();
                                while (it2.hasNext()) {
                                    bVar.a((String) it2.next(), iA2);
                                }
                            }
                            ?? r4 = bVar.c;
                            if (r4 != 0 && r4.size() > 0) {
                                int iA3 = l0.a(bitmap, 0);
                                Iterator it3 = bVar.c.iterator();
                                while (it3.hasNext()) {
                                    bVar.a((String) it3.next(), iA3);
                                }
                            }
                            ?? r5 = bVar.d;
                            if (r5 != 0 && r5.size() > 0) {
                                z = true;
                                int iA4 = l0.a(bitmap, 1);
                                Iterator it4 = bVar.d.iterator();
                                while (it4.hasNext()) {
                                    bVar.a((String) it4.next(), iA4);
                                }
                            }
                        }
                        z = true;
                    } else {
                        z2 = z2;
                    }
                    z = true;
                } else {
                    z2 = z2;
                    z = true;
                    tVar.a(viewA);
                }
            }
            z2 = (!str.equals(u.a("c77c089be85694")) || tVar == null || tVar.a == null) ? z2 : z;
        }
        return z2;
    }

    public final void c() {
        if (this.l != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.l);
            this.l = null;
        }
        if (this.m != null) {
            getViewTreeObserver().removeOnScrollChangedListener(this.m);
            this.m = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00c9  */
    public final void d() {
        Animation scaleAnimation;
        com.tnkfactory.ad.pub.a aVar;
        j jVar;
        int i;
        if (this.g == 0) {
            this.g = System.currentTimeMillis();
            com.tnkfactory.ad.pub.b.b bVar = new com.tnkfactory.ad.pub.b.b(getContext(), this.d);
            if (i.a(this.d.k) || (jVar = (aVar = this.d).e0) == null || (i = aVar.f0) < 3 || i == 3) {
                bVar.a();
            } else {
                jVar.setPageListener(new b(bVar));
            }
        }
        com.tnkfactory.ad.pub.b bVar2 = this.h;
        for (k0 k0Var : bVar2.e) {
            bVar2.postDelayed(new y(bVar2, k0Var), k0Var.a);
        }
        com.tnkfactory.ad.pub.b bVar3 = this.h;
        for (String str : bVar3.g.keySet()) {
            View viewA = bVar3.a(str);
            if (viewA != null && viewA.getVisibility() == 0) {
                String str2 = bVar3.g.get(str);
                if (str2 != null) {
                    String strTrim = str2.trim();
                    strTrim.getClass();
                    strTrim.hashCode();
                    switch (strTrim) {
                        case "shrink":
                            scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(1000L);
                            scaleAnimation.setRepeatCount(-1);
                            scaleAnimation.setRepeatMode(2);
                            scaleAnimation.setInterpolator(new AccelerateInterpolator(4.0f));
                            break;
                        case "blink":
                            scaleAnimation = new AlphaAnimation(1.0f, 0.0f);
                            scaleAnimation.setDuration(500L);
                            scaleAnimation.setRepeatCount(-1);
                            scaleAnimation.setFillAfter(true);
                            scaleAnimation.setStartOffset(2000L);
                            scaleAnimation.setInterpolator(new AccelerateInterpolator(2.0f));
                            break;
                        case "shake":
                            scaleAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
                            scaleAnimation.setDuration(700L);
                            scaleAnimation.setRepeatCount(-1);
                            scaleAnimation.setRepeatMode(2);
                            scaleAnimation.setInterpolator(new CycleInterpolator(7.0f));
                            scaleAnimation.setFillAfter(true);
                            scaleAnimation.setStartOffset(2000L);
                            break;
                        default:
                            scaleAnimation = null;
                            break;
                    }
                } else {
                    scaleAnimation = null;
                }
                if (scaleAnimation != null) {
                    viewA.startAnimation(scaleAnimation);
                }
            }
        }
        j0 j0Var = this.c;
        if (j0Var != null) {
            j0Var.b();
        }
    }

    public final void e() {
        setFocusableInTouchMode(true);
        setFocusable(true);
        Animation animation = this.a;
        if (animation != null) {
            postDelayed(new a(), animation.getDuration());
            startAnimation(this.a);
        } else {
            if (this.d.L != 4) {
                requestFocus();
            }
            b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l == null) {
            this.l = new com.tnkfactory.ad.pub.a.c(this);
            getViewTreeObserver().addOnGlobalLayoutListener(this.l);
        }
        if (this.m == null) {
            this.m = new com.tnkfactory.ad.pub.a.d(this);
            EvtTrackUrls evtTrackUrls = this.d.g0;
            if (evtTrackUrls != null && !evtTrackUrls.creativeView.isEmpty()) {
                com.tnkfactory.ad.pub.c.a.a().a(this.d.g0.creativeView);
            }
            getViewTreeObserver().addOnScrollChangedListener(this.m);
        }
        postDelayed(new Runnable() { // from class: com.tnkfactory.ad.pub.a.-$$Lambda$e$93FUQXql1e6BTDhSggfZ49jQz1s
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        }, 100L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public final void a(int i, String str) {
        if (str == null) {
            Logger.e("error #2103");
            return;
        }
        this.d.j = str;
        if (this.g != 0 && System.currentTimeMillis() - this.g >= this.d.Q) {
            if (this.k != null) {
                TextView textView = new TextView(getContext());
                textView.setOnClickListener(new c(i));
                o oVar = (o) this.k;
                m mVar = oVar.f2882b;
                Context context = textView.getContext();
                com.tnkfactory.ad.pub.a aVar = oVar.f2882b.e;
                oVar.f2882b.f.addView(m.a(mVar, context, textView), oVar.a);
                return;
            }
            a(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0122  */
    /* JADX WARN: Code duplicated, block: B:33:0x0137  */
    /* JADX WARN: Code duplicated, block: B:35:0x0148  */
    /* JADX WARN: Code duplicated, block: B:54:0x0188  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b1  */
    public final boolean a(com.tnkfactory.ad.pub.a aVar) {
        Animation animationB;
        boolean z;
        boolean z2;
        boolean z3;
        long j;
        String str;
        View viewA;
        com.tnkfactory.ad.pub.b bVar;
        String str2;
        this.d = aVar;
        int iCurrentTimeMillis = aVar.N;
        if (iCurrentTimeMillis == 0) {
            iCurrentTimeMillis = ((int) (System.currentTimeMillis() % 9)) + 1;
        }
        Animation[] animationArr = new Animation[2];
        switch (iCurrentTimeMillis) {
            case 2:
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                animationB = alphaAnimation;
                break;
            case 3:
                animationB = l.b();
                break;
            case 4:
                animationB = l.g();
                break;
            case 5:
                animationB = l.c();
                break;
            case 6:
                animationB = l.e();
                break;
            case 7:
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.setDuration(500L);
                animationB = animationSet;
                break;
            case 8:
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f, 1, 0.5f, 1, 0.5f);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                AnimationSet animationSet2 = new AnimationSet(false);
                animationSet2.addAnimation(scaleAnimation2);
                animationSet2.addAnimation(alphaAnimation2);
                animationSet2.setDuration(300L);
                animationB = animationSet2;
                break;
            case 9:
                ScaleAnimation scaleAnimation3 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
                AnimationSet animationSet3 = new AnimationSet(false);
                animationSet3.addAnimation(scaleAnimation3);
                animationSet3.addAnimation(alphaAnimation3);
                animationSet3.setDuration(300L);
                animationB = animationSet3;
                break;
            default:
                animationB = null;
                break;
        }
        animationArr[0] = animationB;
        animationArr[1] = l.a(iCurrentTimeMillis);
        this.a = animationArr[0];
        this.f2865b = animationArr[1];
        if (this.h == null) {
            return false;
        }
        boolean zB = b(aVar);
        if (aVar.e0 == null) {
            z = false;
        } else {
            int i = aVar.h;
            if (i == 4) {
                bVar = this.h;
                str2 = "c77c0982e45d";
            } else {
                if (i == 5) {
                    bVar = this.h;
                    str2 = "c77c0c84e85895";
                } else {
                    Logger.e("can't find webview");
                    viewA = null;
                }
                if (viewA instanceof ViewGroup) {
                    aVar.e0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    ((ViewGroup) viewA).addView(aVar.e0);
                    if (aVar.f0 >= 3) {
                        aVar.e0.loadDataWithBaseURL(aVar.q, aVar.k, "text/html", "utf-8", null);
                    }
                    z = true;
                } else {
                    z = false;
                }
            }
            viewA = bVar.a(u.a(str2));
            if (viewA instanceof ViewGroup) {
                aVar.e0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                ((ViewGroup) viewA).addView(aVar.e0);
                if (aVar.f0 >= 3) {
                    aVar.e0.loadDataWithBaseURL(aVar.q, aVar.k, "text/html", "utf-8", null);
                }
                z = true;
            } else {
                z = false;
            }
        }
        boolean z4 = zB | z;
        if (aVar.o != null) {
            View viewA2 = this.h.a(u.a("c77c179fed549e"));
            com.tnkfactory.ad.pub.d dVar = viewA2 instanceof com.tnkfactory.ad.pub.d ? (com.tnkfactory.ad.pub.d) viewA2 : null;
            if (dVar != null) {
                dVar.setAdData(aVar);
                dVar.setAutoStart(aVar.D == 1);
                dVar.setMediaPath(aVar.o);
                if (aVar.X == 1) {
                    this.f = true;
                    dVar.B = true;
                }
                if (aVar.E == 1) {
                    dVar.setMuteOnStart(true);
                }
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        boolean z5 = z4 | z2;
        if (aVar.p != null) {
            View viewA3 = this.h.a(u.a("c77c1899fc458469f6"));
            if (viewA3 instanceof com.tnkfactory.ad.pub.f) {
                com.tnkfactory.ad.pub.f fVar = (com.tnkfactory.ad.pub.f) viewA3;
                fVar.setAutoStart(aVar.D == 1);
                fVar.setYoutubeId(aVar.p);
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            z3 = false;
        }
        boolean z6 = z5 | z3;
        if (aVar.v > 0.0f) {
            View viewA4 = this.h.a(u.a("c77c1397fd589f6c"));
            if (viewA4 instanceof z0) {
                ((z0) viewA4).setRating(aVar.v);
            } else if (viewA4 instanceof TextView) {
                ((TextView) viewA4).setText(String.valueOf(aVar.v));
            }
            View viewA5 = this.h.a(u.a("c86d0c84e8459865f4"));
            if (viewA5 instanceof TextView) {
                ((TextView) viewA5).setText(String.valueOf(aVar.v));
            } else if (viewA5 instanceof z0) {
                ((z0) viewA5).setRating(aVar.v);
            }
        }
        a(aVar.s, u.a("c77c159ffd5d94"));
        a(aVar.s, u.a("c77c159ffd5d9439"));
        a(aVar.t, u.a("c77c0593fa52"));
        a(aVar.u, u.a("c77c0593fa52c3"));
        a(aVar.y, u.a("c77c0282e8"));
        a(aVar.y, u.a("c77c0282e803"));
        String str3 = aVar.i0;
        if (str3 != null) {
            com.tnkfactory.ad.pub.b bVar2 = this.h;
            long j2 = 0;
            if (str3 != null) {
                String[] strArrSplit = str3.split(CertificateUtil.DELIMITER);
                if (strArrSplit.length != 0) {
                    try {
                        if (strArrSplit.length == 3) {
                            int iIndexOf = strArrSplit[2].indexOf(".");
                            if (iIndexOf != -1) {
                                strArrSplit[2] = strArrSplit[2].substring(0, iIndexOf);
                            }
                            j = ((long) (Integer.parseInt(strArrSplit[0]) * 3600)) + 0 + ((long) (Integer.parseInt(strArrSplit[1]) * 60));
                            str = strArrSplit[2];
                        } else if (strArrSplit.length == 2) {
                            j = ((long) (Integer.parseInt(strArrSplit[0]) * 60)) + 0;
                            str = strArrSplit[1];
                        }
                        j2 = j + ((long) Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            bVar2.a(j2);
        }
        return z6;
    }
}
