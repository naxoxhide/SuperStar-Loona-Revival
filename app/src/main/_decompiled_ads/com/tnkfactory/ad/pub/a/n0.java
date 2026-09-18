package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ShapeDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.NativeAdItem;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 extends r {
    public static final String n = String.valueOf(System.currentTimeMillis());
    public static final WeakHashMap<View, n0> o = new WeakHashMap<>();
    public NativeAdItem f;
    public long g;
    public o0 h;
    public p0 i;
    public q0 j;
    public ViewGroup k;
    public j1 l;
    public c m;

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            i.a(view.getContext(), n0.this.e.z, false);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            n0.this.f(view.getContext());
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            i.a(view.getContext(), n0.this.e.z, false);
        }
    }

    public static class e extends Handler {
        public final WeakReference<n0> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f2879b;

        public e(Context context, n0 n0Var) {
            this.a = new WeakReference<>(n0Var);
            this.f2879b = context;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            n0 n0Var = this.a.get();
            if (n0Var != null) {
                Context context = this.f2879b;
                if (message == null) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    n0Var.f(context);
                } else {
                    if (i != 9) {
                        return;
                    }
                    n0Var.a(context, (String) message.obj);
                }
            }
        }
    }

    public class f implements View.OnTouchListener {
        public GestureDetector a;

        public class a extends GestureDetector.SimpleOnGestureListener {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                n0 n0Var = n0.this;
                Context context = this.a.getContext();
                String str = n0.n;
                n0Var.f(context);
                return true;
            }
        }

        public f(View view) {
            if (!view.isClickable()) {
                view.setClickable(true);
            }
            this.a = new GestureDetector(view.getContext(), new a(view));
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

    public n0(AdItem adItem, String str) {
        super(str);
        this.g = 0L;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = new c();
        this.f = (NativeAdItem) adItem;
    }

    public final void a(Context context, String str) {
        if (str == null || this.d != 2 || this.g == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.g;
        com.tnkfactory.ad.pub.a aVar = this.e;
        if (jCurrentTimeMillis < aVar.Q) {
            return;
        }
        i.a(context, i.a(aVar.d, str, aVar.g, 0, this.c), true);
        a(this.f);
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void a(View view) {
        if (view != null) {
            view.setOnClickListener(new d());
        }
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void a(ViewGroup viewGroup) {
        this.k = viewGroup;
        if (viewGroup != null) {
            if (this.e.W == 0) {
                viewGroup.setOnClickListener(this.m);
            } else {
                viewGroup.setOnTouchListener(new f(viewGroup));
            }
        }
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void a(ViewGroup viewGroup, j1 j1Var) {
        if (viewGroup == null) {
            return;
        }
        WeakHashMap<View, n0> weakHashMap = o;
        n0 n0Var = weakHashMap.get(viewGroup);
        if (n0Var != null) {
            if (n0Var == this) {
                return;
            } else {
                n0Var.j();
            }
        }
        j();
        weakHashMap.put(viewGroup, this);
        this.k = viewGroup;
        this.l = j1Var;
        if (this.d == 2 && l()) {
            if (l0.a((View) this.k, false)) {
                m();
            } else {
                k();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    @Override // com.tnkfactory.ad.pub.a.r
    public final View b(Context context) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        t tVar = (t) this.e.d0.get(u.a("c77c089be85694"));
        Bitmap bitmap = tVar != null ? tVar.a : null;
        if (bitmap != null) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(layoutParams);
            imageView.setAdjustViewBounds(true);
            imageView.setImageBitmap(bitmap);
            return imageView;
        }
        if (this.e.k == null) {
            return null;
        }
        j jVar = new j(context);
        jVar.setLayoutParams(layoutParams);
        jVar.setHandler(new e(jVar.getContext(), this));
        com.tnkfactory.ad.pub.a aVar = this.e;
        if (aVar.j != null) {
            jVar.c = true;
            jVar.d.a.f2862b = new k(jVar);
        }
        jVar.loadDataWithBaseURL(aVar.q, aVar.k, "text/html", "utf-8", null);
        return jVar;
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        if (this.i != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.i);
            this.i = null;
        }
        if (this.j != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.j);
            this.j = null;
        }
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void b(AdItem adItem) {
        super.b(adItem);
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void c(Context context) {
        if (!d()) {
            a(this.f, AdError.FAIL_NO_PLACEMENT_ID);
        } else {
            if (this.d != 0) {
                a(this.f, AdError.FAIL_DUP_LOAD);
                return;
            }
            this.d = 1;
            n();
            new com.tnkfactory.ad.pub.b.k(context).a(this.a, 2, new a());
        }
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void d(Context context) {
        com.tnkfactory.ad.pub.a aVar = this.e;
        String str = aVar.e;
        String strA = u.a("d66d03d8e0");
        String strA2 = u.a("d66a0e95ec428242fe6f76462dea3cbf84");
        Object[] objArr = {aVar.c, aVar.g};
        g gVar = aVar.m0;
        List<String> list = aVar.B;
        com.tnkfactory.ad.pub.b.g gVar2 = new com.tnkfactory.ad.pub.b.g(context, str, strA, strA2, objArr, gVar);
        gVar2.h = list;
        gVar2.start();
        this.g = System.currentTimeMillis();
    }

    public final void f(Context context) {
        if (this.e.C != null) {
            new com.tnkfactory.ad.pub.b.s(this.e.C).start();
        }
        a(context, this.e.j);
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.ArrayList, java.util.List<java.lang.Integer>] */
    public final void j() {
        View viewFindViewWithTag;
        View viewFindViewById;
        n();
        j1 j1Var = this.l;
        if (j1Var != null) {
            if (j1Var.a) {
                View viewFindViewById2 = this.k.findViewById(j1Var.l);
                if (viewFindViewById2 instanceof TextView) {
                    ((TextView) viewFindViewById2).setText("");
                }
            }
            j1 j1Var2 = this.l;
            if (j1Var2.f2872b) {
                View viewFindViewById3 = this.k.findViewById(j1Var2.m);
                if (viewFindViewById3 instanceof TextView) {
                    ((TextView) viewFindViewById3).setText("");
                }
            }
            j1 j1Var3 = this.l;
            if (j1Var3.g) {
                View viewFindViewById4 = this.k.findViewById(j1Var3.r);
                if (viewFindViewById4 instanceof TextView) {
                    ((TextView) viewFindViewById4).setText("");
                }
            }
            j1 j1Var4 = this.l;
            if (j1Var4.c) {
                View viewFindViewById5 = this.k.findViewById(j1Var4.n);
                if (viewFindViewById5 instanceof ImageView) {
                    ((ImageView) viewFindViewById5).setImageBitmap(null);
                }
            }
            j1 j1Var5 = this.l;
            if (j1Var5.e) {
                View viewFindViewById6 = this.k.findViewById(j1Var5.p);
                if (viewFindViewById6 instanceof TextView) {
                    ((TextView) viewFindViewById6).setText("");
                }
            }
            j1 j1Var6 = this.l;
            if (j1Var6.f) {
                View viewFindViewById7 = this.k.findViewById(j1Var6.q);
                if (viewFindViewById7 instanceof ImageView) {
                    ((ImageView) viewFindViewById7).setImageBitmap(null);
                }
            }
            j1 j1Var7 = this.l;
            if (j1Var7.i) {
                View viewFindViewById8 = this.k.findViewById(j1Var7.t);
                if (viewFindViewById8 instanceof TextView) {
                    ((TextView) viewFindViewById8).setText("");
                }
            }
            j1 j1Var8 = this.l;
            if (j1Var8.h) {
                View viewFindViewById9 = this.k.findViewById(j1Var8.s);
                if (viewFindViewById9 instanceof ImageView) {
                    ((ImageView) viewFindViewById9).setImageBitmap(null);
                    viewFindViewById9.setOnClickListener(null);
                }
            }
            if (this.e.v > 0.0f) {
                j1 j1Var9 = this.l;
                if (j1Var9.j && (viewFindViewById = this.k.findViewById(j1Var9.u)) != null) {
                    viewFindViewById.setBackground(null);
                }
                j1 j1Var10 = this.l;
                if (j1Var10.k) {
                    View viewFindViewById10 = this.k.findViewById(j1Var10.v);
                    if (viewFindViewById10 instanceof TextView) {
                        ((TextView) viewFindViewById10).setText("");
                    }
                }
            }
            View viewFindViewById11 = this.k.findViewById(this.l.o);
            if ((viewFindViewById11 instanceof ViewGroup) && (viewFindViewWithTag = viewFindViewById11.findViewWithTag(n)) != null) {
                ((ViewGroup) viewFindViewById11).removeView(viewFindViewWithTag);
            }
            Iterator it = this.l.C.iterator();
            while (it.hasNext()) {
                View viewFindViewById12 = this.k.findViewById(((Integer) it.next()).intValue());
                if (viewFindViewById12 != null) {
                    viewFindViewById12.setOnClickListener(null);
                }
            }
            this.l = null;
        }
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            o.remove(viewGroup);
        }
        this.k = null;
    }

    public final void k() {
        ViewGroup viewGroup;
        o0 o0Var;
        if (this.d != 2 || (viewGroup = this.k) == null || this.g > 0 || (o0Var = this.h) != null) {
            return;
        }
        if (o0Var == null) {
            o0 o0Var2 = new o0(this);
            this.h = o0Var2;
            viewGroup.addOnLayoutChangeListener(o0Var2);
        }
        ViewGroup viewGroup2 = this.k;
        if (viewGroup2 == null) {
            return;
        }
        if (this.i == null) {
            this.i = new p0(this, viewGroup2);
            viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener(this.i);
        }
        if (this.j == null) {
            this.j = new q0(this, viewGroup2);
            viewGroup2.getViewTreeObserver().addOnScrollChangedListener(this.j);
        }
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [java.util.ArrayList, java.util.List<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r2v45, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    public final boolean l() {
        ViewGroup viewGroup;
        j1 j1Var;
        View viewFindViewById;
        if (this.d != 2 || (viewGroup = this.k) == null || (j1Var = this.l) == null || !j1Var.d) {
            return false;
        }
        if (j1Var.a) {
            View viewFindViewById2 = viewGroup.findViewById(j1Var.l);
            if (viewFindViewById2 instanceof TextView) {
                ((TextView) viewFindViewById2).setText(this.e.s);
            }
        }
        j1 j1Var2 = this.l;
        if (j1Var2.f2872b) {
            View viewFindViewById3 = this.k.findViewById(j1Var2.m);
            if (viewFindViewById3 instanceof TextView) {
                ((TextView) viewFindViewById3).setText(this.e.t);
            }
        }
        j1 j1Var3 = this.l;
        if (j1Var3.g) {
            View viewFindViewById4 = this.k.findViewById(j1Var3.r);
            if (viewFindViewById4 instanceof TextView) {
                ((TextView) viewFindViewById4).setText(this.e.y);
            }
        }
        j1 j1Var4 = this.l;
        if (j1Var4.c) {
            View viewFindViewById5 = this.k.findViewById(j1Var4.n);
            if (viewFindViewById5 instanceof ImageView) {
                ((ImageView) viewFindViewById5).setImageBitmap(this.e.a());
            }
        }
        j1 j1Var5 = this.l;
        if (j1Var5.e) {
            View viewFindViewById6 = this.k.findViewById(j1Var5.p);
            if (viewFindViewById6 instanceof TextView) {
                ((TextView) viewFindViewById6).setText(this.e.x);
            }
        }
        j1 j1Var6 = this.l;
        View viewB = null;
        if (j1Var6.f) {
            View viewFindViewById7 = this.k.findViewById(j1Var6.q);
            if (viewFindViewById7 instanceof ImageView) {
                ImageView imageView = (ImageView) viewFindViewById7;
                t tVar = (t) this.e.d0.get(u.a("c77c179ae6569e"));
                imageView.setImageBitmap(tVar != null ? tVar.a : null);
            }
        }
        j1 j1Var7 = this.l;
        if (j1Var7.i) {
            View viewFindViewById8 = this.k.findViewById(j1Var7.t);
            if (viewFindViewById8 instanceof TextView) {
                ((TextView) viewFindViewById8).setText(this.e.w);
            }
        }
        j1 j1Var8 = this.l;
        if (j1Var8.h) {
            View viewFindViewById9 = this.k.findViewById(j1Var8.s);
            if (viewFindViewById9 instanceof ImageView) {
                ((ImageView) viewFindViewById9).setImageBitmap(this.e.b());
                if (this.e.z != null) {
                    viewFindViewById9.setOnClickListener(new b());
                }
            }
        }
        if (this.e.v > 0.0f) {
            j1 j1Var9 = this.l;
            if (j1Var9.j && (viewFindViewById = this.k.findViewById(j1Var9.u)) != null) {
                j1 j1Var10 = this.l;
                float f2 = this.e.v;
                float f3 = j1Var10.B;
                float f4 = j1Var10.A;
                float f5 = f2 / f3;
                if (f4 > 0.0f) {
                    float f6 = f4 / f3;
                    f5 = ((int) (f5 / f6)) * f6;
                }
                viewFindViewById.setBackground(new ShapeDrawable(new v.b(f5, j1Var10.z, j1Var10.w, j1Var10.x, j1Var10.y)));
            }
            j1 j1Var11 = this.l;
            if (j1Var11.k) {
                View viewFindViewById10 = this.k.findViewById(j1Var11.v);
                if (viewFindViewById10 instanceof TextView) {
                    ((TextView) viewFindViewById10).setText(String.valueOf(this.e.v));
                }
            }
        }
        View viewFindViewById11 = this.k.findViewById(this.l.o);
        if (viewFindViewById11 == null) {
            Logger.w(u.a("e5770f82ec5f855dfa7a730337ea75be85ce431f2b50c68d5e"));
        } else if (viewFindViewById11 instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) viewFindViewById11;
            View viewFindViewWithTag = viewGroup2.findViewWithTag(n);
            if (viewFindViewWithTag != null) {
                viewGroup2.removeView(viewFindViewWithTag);
            }
            viewB = b(viewGroup2.getContext());
            viewGroup2.addView(viewB);
        } else {
            Logger.w(u.a("e5770f82ec5f855dfa7a730337ea75be85ce43186473c18c0770a5710af5e8"));
        }
        if (viewB == null) {
            return false;
        }
        Iterator it = this.l.C.iterator();
        while (it.hasNext()) {
            View viewFindViewById12 = this.k.findViewById(((Integer) it.next()).intValue());
            if (viewFindViewById12 != null) {
                if (this.e.W == 0) {
                    viewFindViewById12.setOnClickListener(this.m);
                } else {
                    viewFindViewById12.setOnTouchListener(new f(viewFindViewById12));
                }
            }
        }
        return true;
    }

    public final void m() {
        if (this.g > 0 || this.d != 2 || this.k == null) {
            return;
        }
        this.g = System.currentTimeMillis();
        n();
        Context context = this.k.getContext();
        com.tnkfactory.ad.pub.a aVar = this.e;
        String str = aVar.e;
        String strA = u.a("d66d03d8e0");
        String strA2 = u.a("d66a0e95ec428242fe6f76462dea3cbf84");
        Object[] objArr = {aVar.c, aVar.g};
        g gVar = aVar.m0;
        List<String> list = aVar.B;
        com.tnkfactory.ad.pub.b.g gVar2 = new com.tnkfactory.ad.pub.b.g(context, str, strA, strA2, objArr, gVar);
        gVar2.h = list;
        gVar2.start();
        c(this.f);
    }

    public final void n() {
        ViewGroup viewGroup = this.k;
        if (viewGroup == null) {
            return;
        }
        o0 o0Var = this.h;
        if (o0Var != null) {
            viewGroup.removeOnLayoutChangeListener(o0Var);
            this.h = null;
        }
        b(this.k);
    }

    public class a extends com.tnkfactory.ad.pub.b.r {
        public a() {
        }

        @Override // com.tnkfactory.ad.pub.b.r
        public final void a(Throwable th) {
            n0.this.d = 0;
            Logger.e(com.tnkfactory.ad.pub.a.a.a("error #2201 : ").append(th.toString()).toString());
            n0 n0Var = n0.this;
            n0Var.a(n0Var.f, AdError.FAIL_SYSTEM);
        }

        @Override // com.tnkfactory.ad.pub.b.r
        public final void a(Object obj) {
            n0 n0Var = n0.this;
            com.tnkfactory.ad.pub.a aVar = (com.tnkfactory.ad.pub.a) obj;
            n0Var.e = aVar;
            if (aVar != null && !aVar.a) {
                n0Var.d = 2;
                n0Var.b(n0Var.f);
                n0 n0Var2 = n0.this;
                if (n0Var2.k == null || !n0Var2.l()) {
                    return;
                }
                if (l0.a((View) n0.this.k, false)) {
                    n0.this.m();
                    return;
                } else {
                    n0.this.k();
                    return;
                }
            }
            n0Var.d = 0;
            AdError adErrorC = aVar == null ? AdError.FAIL_NO_AD : aVar.c();
            n0 n0Var3 = n0.this;
            n0Var3.a(n0Var3.f, adErrorC);
        }
    }
}
