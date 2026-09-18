package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.b.a.a.d.f.m;
import b.b.a.a.h.j;
import b.b.a.a.h.k;
import b.b.a.a.h.o;
import b.b.a.a.h.u;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.v;
import java.util.ArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    private static String y = "";
    private InteractViewContainer w;
    private Runnable x;

    class a implements o<Bitmap> {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
        }

        @Override // b.b.a.a.h.o
        public void a(k<Bitmap> kVar) {
            Bitmap bitmapC = kVar.c();
            if (bitmapC == null || kVar.e() == null) {
                return;
            }
            this.a.setBackground(DynamicBaseWidgetImp.this.a(bitmapC));
        }
    }

    class b implements b.b.a.a.h.h {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // b.b.a.a.h.h
        public Bitmap a(Bitmap bitmap) {
            return b.b.a.a.d.g.a.a(DynamicBaseWidgetImp.this.i, bitmap, this.a);
        }
    }

    class c implements o<Bitmap> {
        final /* synthetic */ View a;

        c(View view) {
            this.a = view;
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
        }

        @Override // b.b.a.a.h.o
        public void a(k<Bitmap> kVar) {
            this.a.setBackground(new BitmapDrawable(kVar.c()));
            b.b.a.a.d.d.h.h hVar = DynamicBaseWidgetImp.this.k;
            if (hVar == null || hVar.n() == null || 6 != DynamicBaseWidgetImp.this.k.n().c() || Build.VERSION.SDK_INT < 19 || this.a.getBackground() == null) {
                return;
            }
            this.a.getBackground().setAutoMirrored(true);
        }
    }

    class d implements Runnable {
        final /* synthetic */ View a;

        d(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (DynamicBaseWidgetImp.this.j.H() > 0) {
                    DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                    Drawable drawableC = dynamicBaseWidgetImp.c(dynamicBaseWidgetImp.l.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.j.H())));
                    if (drawableC == null) {
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        drawableC = dynamicBaseWidgetImp2.a(true, dynamicBaseWidgetImp2.l.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.j.H())));
                    }
                    if (drawableC != null) {
                        this.a.setBackground(drawableC);
                        return;
                    }
                    View view = this.a;
                    DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                    view.setBackground(dynamicBaseWidgetImp3.a(true, dynamicBaseWidgetImp3.l.getBgColor()));
                }
            } catch (Exception unused) {
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DynamicBaseWidgetImp.this.setVisibility(8);
        }
    }

    class f implements Runnable {
        final /* synthetic */ View a;

        f(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DynamicBaseWidgetImp.this.k.n().g().y() != null) {
                return;
            }
            this.a.setVisibility(0);
            DynamicBaseWidgetImp.this.setVisibility(0);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.l;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                dynamicBaseWidgetImp.w = new InteractViewContainer(dynamicBaseWidgetImp2.i, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.j);
            } else {
                m renderRequest = DynamicBaseWidgetImp.this.l.getRenderRequest();
                int i = renderRequest.i();
                int iE = renderRequest.e();
                int iG = renderRequest.g();
                int iD = renderRequest.d();
                DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                dynamicBaseWidgetImp3.w = new InteractViewContainer(dynamicBaseWidgetImp4.i, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.j, i, iE, iG, iD);
            }
            DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
            dynamicBaseWidgetImp5.b(dynamicBaseWidgetImp5.w);
            if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
            }
            DynamicBaseWidgetImp.this.setClipChildren(false);
            DynamicBaseWidgetImp.this.w.setTag(2);
            DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
            dynamicBaseWidgetImp6.addView(dynamicBaseWidgetImp6.w, new FrameLayout.LayoutParams(-1, -1));
            DynamicBaseWidgetImp.this.w.f();
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DynamicBaseWidgetImp.this.w != null) {
                DynamicBaseWidgetImp.this.w.setVisibility(8);
            }
        }
    }

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, b.b.a.a.d.d.h.h hVar) {
        super(context, dynamicRootView, hVar);
        setTag(Integer.valueOf(getClickArea()));
        String strF = hVar.n().f();
        if ("logo-union".equals(strF)) {
            dynamicRootView.setLogoUnionHeight(this.f - ((int) b.b.a.a.d.g.d.a(context, this.j.L() + this.j.I())));
        } else if ("scoreCountWithIcon".equals(strF)) {
            dynamicRootView.setScoreCountWithIcon(this.f - ((int) b.b.a.a.d.g.d.a(context, this.j.L() + this.j.I())));
        }
    }

    private static String getBuildModel() {
        try {
            y = v.a();
        } catch (Throwable unused) {
            y = Build.MODEL;
        }
        if (TextUtils.isEmpty(y)) {
            y = Build.MODEL;
        }
        return y;
    }

    private void j() {
        int iF = this.j.F();
        int iY = this.j.y();
        g gVar = new g();
        this.x = gVar;
        postDelayed(gVar, ((long) iF) * 1000);
        if (this.j.W() || iY >= Integer.MAX_VALUE || iF >= iY) {
            return;
        }
        postDelayed(new h(), ((long) iY) * 1000);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        Drawable backgroundDrawable;
        View view = this.m;
        if (view == null) {
            view = this;
        }
        setContentDescription(this.k.a(this.j.p()));
        String strF = this.j.f();
        if (this.j.c() && Build.VERSION.SDK_INT >= 17) {
            b.b.a.a.d.e.a.a.d().c().a(this.j.f90b).a(u.BITMAP).a(new b(this.j.d())).a(new a(view));
        } else if (!TextUtils.isEmpty(strF)) {
            if (!strF.startsWith("http:")) {
                strF = b.b.a.a.d.d.i.h.a(strF);
            }
            j jVarA = b.b.a.a.d.e.a.a.d().c().a(strF).a(u.BITMAP);
            a(jVarA);
            jVarA.a(new c(view));
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.j.b() > 0.0d) {
            postDelayed(new d(view), (long) (this.j.b() * 1000.0d));
        }
        View view2 = this.m;
        if (view2 != null) {
            view2.setPadding((int) b.b.a.a.d.g.d.a(this.i, this.j.J()), (int) b.b.a.a.d.g.d.a(this.i, this.j.L()), (int) b.b.a.a.d.g.d.a(this.i, this.j.K()), (int) b.b.a.a.d.g.d.a(this.i, this.j.I()));
        }
        if (this.n || this.j.T() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.e, this.f);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View view = this.m;
        if (view == null) {
            view = this;
        }
        double dN0 = this.k.n().g().n0();
        if (dN0 < 90.0d && dN0 > 0.0d) {
            i.b().postDelayed(new e(), (long) (dN0 * 1000.0d));
        }
        double dO0 = this.k.n().g().o0();
        if (dO0 > 0.0d) {
            i.b().postDelayed(new f(view), (long) (dO0 * 1000.0d));
        }
        if (!TextUtils.isEmpty(this.j.D())) {
            j();
        }
        super.onAttachedToWindow();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.x);
    }

    private static void a(j jVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            jVar.a(Bitmap.Config.ARGB_8888);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable c(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String string = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    string = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = b.b.a.a.d.d.h.g.b(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable gradientDrawableA = a(b(string), iArr);
            gradientDrawableA.setShape(0);
            gradientDrawableA.setCornerRadius(b.b.a.a.d.g.d.a(this.i, this.j.j()));
            return gradientDrawableA;
        } catch (Throwable unused) {
            return null;
        }
    }
}
