package com.igaworks.adpopcorn.renewal.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.cores.common.e;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.f;
import com.igaworks.adpopcorn.cores.model.g;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseAdapter {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<g> f1642b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private GradientDrawable d;
    private GradientDrawable e;
    private GradientDrawable f;
    private List<WeakReference<View>> g = new ArrayList();
    private boolean h;
    private int i;
    private com.igaworks.adpopcorn.a.g.a j;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.renewal.a.a$a, reason: collision with other inner class name */
    class C0436a implements com.igaworks.adpopcorn.a.g.a.d {
        C0436a(a aVar) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, f fVar) {
        }
    }

    class b implements com.igaworks.adpopcorn.a.g.a.d {
        b(a aVar) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, f fVar) {
        }
    }

    public class c {
        public LinearLayout a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i f1643b;
        public ImageView c;
        public LinearLayout d;
        public TextView e;
        public TextView f;
        public TextView g;
        public FrameLayout h;
        public LinearLayout i;
        public ImageView j;
        public TextView k;
        public TextView l;
        public TextView m;

        public c(a aVar) {
        }
    }

    public a(Context context, List<g> list, com.igaworks.adpopcorn.cores.common.g gVar, boolean z, int i, int i2) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        this.a = context;
        this.i = i2;
        this.f1642b = list;
        this.c = gVar;
        this.h = z;
        if (ApRewardStyle.mainOfferwallColor != Color.parseColor("#2685F4")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            int i3 = ApRewardStyle.mainOfferwallColor;
            GradientDrawable gradientDrawable3 = new GradientDrawable(orientation, new int[]{i3, i3});
            this.d = gradientDrawable3;
            gradientDrawable3.setAlpha(26);
        } else {
            this.d = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1576450, -1576450});
        }
        this.d.setShape(0);
        this.d.setCornerRadius(d.a(context, 6));
        this.d.setGradientType(0);
        if (ApRewardStyle.mainOfferwallColor != Color.parseColor("#2685F4")) {
            GradientDrawable.Orientation orientation2 = GradientDrawable.Orientation.TOP_BOTTOM;
            int i4 = ApRewardStyle.mainOfferwallColor;
            gradientDrawable = new GradientDrawable(orientation2, new int[]{i4, i4});
        } else {
            gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-14252556, -14252556});
        }
        this.e = gradientDrawable;
        this.e.setShape(0);
        this.e.setCornerRadius(d.a(context, 6));
        this.e.setGradientType(0);
        if (ApRewardStyle.mainOfferwallColor != Color.parseColor("#2685F4")) {
            GradientDrawable.Orientation orientation3 = GradientDrawable.Orientation.TOP_BOTTOM;
            int i5 = ApRewardStyle.mainOfferwallColor;
            gradientDrawable2 = new GradientDrawable(orientation3, new int[]{i5, i5});
        } else {
            gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-10668801, -14252556});
        }
        this.f = gradientDrawable2;
        this.f.setShape(0);
        this.f.setCornerRadius(d.a(context, 10));
        this.f.setStroke(d.a(context, 2), Color.parseColor("#ffffff"));
        this.f.setGradientType(0);
    }

    public void a() {
        try {
            List<WeakReference<View>> list = this.g;
            if (list != null) {
                Iterator<WeakReference<View>> it = list.iterator();
                while (it.hasNext()) {
                    com.igaworks.adpopcorn.cores.common.i.a(it.next().get());
                }
                this.g.clear();
                this.g = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<g> list = this.f1642b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        View viewA;
        String str;
        TextView textView;
        GradientDrawable gradientDrawable;
        String str2;
        Context context;
        String strD;
        ImageView imageView;
        int iA;
        int iA2;
        String str3;
        String str4;
        TextView textView2;
        GradientDrawable gradientDrawable2;
        String str5;
        String str6;
        g gVar = this.f1642b.get(i);
        String strR = gVar.r();
        gVar.K();
        gVar.c();
        boolean z = gVar.a0() || gVar.X();
        boolean zC0 = gVar.c0();
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ViewCompat.MEASURED_SIZE_MASK, ViewCompat.MEASURED_SIZE_MASK});
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(d.a(this.a, 10));
        gradientDrawable3.setGradientType(0);
        gradientDrawable3.setStroke(d.a(this.a, 2), ApRewardStyle.mainOfferwallColor);
        if (view == null) {
            cVar = new c(this);
            viewA = com.igaworks.adpopcorn.renewal.layout.a.a(this.a, this.h);
            cVar.a = (LinearLayout) viewA.findViewById(0);
            cVar.f1643b = (i) viewA.findViewById(1);
            cVar.c = (ImageView) viewA.findViewById(2);
            cVar.d = (LinearLayout) viewA.findViewById(3);
            cVar.e = (TextView) viewA.findViewById(4);
            cVar.f = (TextView) viewA.findViewById(5);
            cVar.g = (TextView) viewA.findViewById(6);
            cVar.h = (FrameLayout) viewA.findViewById(7);
            cVar.i = (LinearLayout) viewA.findViewById(100);
            cVar.j = (ImageView) viewA.findViewById(101);
            cVar.k = (TextView) viewA.findViewById(102);
            cVar.l = (TextView) viewA.findViewById(103);
            cVar.m = (TextView) viewA.findViewById(106);
            viewA.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
            viewA = view;
        }
        if (this.i == 2) {
            cVar.a.setVisibility(8);
            cVar.i.setVisibility(0);
            if (Build.VERSION.SDK_INT > 21) {
                cVar.i.setClipToOutline(true);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cVar.i.getLayoutParams();
            layoutParams.leftMargin = d.a(this.a, 16);
            layoutParams.rightMargin = d.a(this.a, 16);
            cVar.i.setLayoutParams(layoutParams);
            if (z) {
                k.a(cVar.k, gVar.n(), 14, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.a(cVar.l, gVar.g() + " ", 13, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
                try {
                    str6 = new DecimalFormat("###,###").format(gVar.m());
                } catch (Exception unused) {
                    str6 = gVar.m() + "";
                }
                k.a(cVar.m, str6 + gVar.O(), 14, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
                cVar.m.setBackgroundDrawable(null);
                cVar.m.setMinWidth(d.a(this.a, 61));
                cVar.m.getLayoutParams().width = -2;
                cVar.m.setBackgroundDrawable(this.d);
                cVar.j.setTag(gVar.j());
                cVar.j.setImageDrawable(null);
                e.a(this.a, gVar.j(), cVar.j, 0, 0, (e.b) null);
                if (!gVar.Z()) {
                    gVar.e(true);
                    if (this.j == null) {
                        this.j = new com.igaworks.adpopcorn.a.g.a(this.a);
                    }
                    Iterator<String> it = gVar.k().iterator();
                    while (it.hasNext()) {
                        this.j.a(14, it.next(), "", new C0436a(this));
                    }
                }
            } else {
                TextView textView3 = cVar.k;
                if (zC0) {
                    k.a(textView3, gVar.H(), 14, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, true);
                    k.a(cVar.l, gVar.B() + " ", 13, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
                    try {
                        str5 = new DecimalFormat("###,###").format(gVar.F());
                    } catch (Exception unused2) {
                        str5 = gVar.F() + "";
                    }
                    if (gVar.b0()) {
                        k.a(cVar.m, this.c.d, 14, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, false);
                    } else {
                        k.a(cVar.m, str5 + gVar.O(), 14, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
                    }
                    cVar.m.setBackgroundDrawable(null);
                    cVar.m.setMinWidth(d.a(this.a, 61));
                    cVar.m.getLayoutParams().width = -2;
                    cVar.m.setBackgroundDrawable(this.d);
                    cVar.j.setTag(gVar.D());
                    cVar.j.setImageDrawable(null);
                    context = this.a;
                    strD = gVar.D();
                    imageView = cVar.j;
                    iA = 0;
                    iA2 = 0;
                } else {
                    k.a(textView3, gVar.v(), 14, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, true);
                    k.a(cVar.l, gVar.p() + " ", 13, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
                    try {
                        str4 = new DecimalFormat("###,###").format(gVar.Q());
                    } catch (Exception unused3) {
                        str4 = gVar.Q() + "";
                    }
                    String str7 = str4 + gVar.O();
                    if (gVar.e0()) {
                        k.a(cVar.m, this.c.F, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, true);
                        cVar.m.setBackgroundDrawable(null);
                        cVar.m.setMinWidth(d.a(this.a, 61));
                        cVar.m.getLayoutParams().width = -2;
                        textView2 = cVar.m;
                        gradientDrawable2 = this.e;
                    } else {
                        k.a(cVar.m, str7, 14, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
                        cVar.m.setBackgroundDrawable(null);
                        cVar.m.setMinWidth(d.a(this.a, 61));
                        cVar.m.getLayoutParams().width = -2;
                        textView2 = cVar.m;
                        gradientDrawable2 = this.d;
                    }
                    textView2.setBackgroundDrawable(gradientDrawable2);
                    cVar.j.setTag(strR);
                    cVar.j.setImageDrawable(null);
                    e.a(this.a, strR, cVar.j, 0, 0, (e.b) null);
                }
            }
            this.g.add(new WeakReference<>(viewA));
            return viewA;
        }
        cVar.a.setVisibility(0);
        cVar.i.setVisibility(8);
        cVar.d.setBackgroundColor(0);
        if (Build.VERSION.SDK_INT > 21) {
            cVar.a.setClipToOutline(true);
        }
        if (z) {
            k.a(cVar.e, gVar.n(), 14, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, true);
            k.a(cVar.f, gVar.g() + " ", 13, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
            try {
                str3 = new DecimalFormat("###,###").format(gVar.m());
            } catch (Exception unused4) {
                str3 = gVar.m() + "";
            }
            k.a(cVar.g, str3 + gVar.O(), 14, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
            cVar.g.setBackgroundDrawable(null);
            cVar.g.setMinWidth(d.a(this.a, 61));
            cVar.g.getLayoutParams().width = -2;
            cVar.g.setBackgroundDrawable(this.d);
            if (!gVar.Z()) {
                gVar.e(true);
                if (this.j == null) {
                    this.j = new com.igaworks.adpopcorn.a.g.a(this.a);
                }
                Iterator<String> it2 = gVar.k().iterator();
                while (it2.hasNext()) {
                    this.j.a(14, it2.next(), "", new b(this));
                }
            }
        } else {
            TextView textView4 = cVar.e;
            if (zC0) {
                k.a(textView4, gVar.H(), 14, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.a(cVar.f, gVar.B() + " ", 13, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
                try {
                    str2 = new DecimalFormat("###,###").format(gVar.F());
                } catch (Exception unused5) {
                    str2 = gVar.F() + "";
                }
                if (gVar.b0()) {
                    k.a(cVar.g, this.c.d, 14, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, false);
                } else {
                    k.a(cVar.g, str2 + gVar.O(), 14, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
                }
                cVar.g.setBackgroundDrawable(null);
                cVar.g.setMinWidth(d.a(this.a, 61));
                cVar.g.getLayoutParams().width = -2;
                cVar.g.setBackgroundDrawable(this.d);
                cVar.f1643b.setTag(gVar.D());
                cVar.f1643b.setImageDrawable(null);
                context = this.a;
                strD = gVar.D();
            } else {
                k.a(textView4, gVar.V(), 14, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.a(cVar.f, gVar.p() + " ", 13, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
                try {
                    str = new DecimalFormat("###,###").format(gVar.Q());
                } catch (Exception unused6) {
                    str = gVar.Q() + "";
                }
                String str8 = str + gVar.O();
                if (gVar.e0()) {
                    k.a(cVar.g, this.c.F, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, true);
                    cVar.g.setBackgroundDrawable(null);
                    cVar.g.setMinWidth(d.a(this.a, 61));
                    cVar.g.getLayoutParams().width = -2;
                    textView = cVar.g;
                    gradientDrawable = this.e;
                } else {
                    k.a(cVar.g, str8, 14, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
                    cVar.g.setBackgroundDrawable(null);
                    cVar.g.setMinWidth(d.a(this.a, 61));
                    cVar.g.getLayoutParams().width = -2;
                    textView = cVar.g;
                    gradientDrawable = this.d;
                }
                textView.setBackgroundDrawable(gradientDrawable);
                if (gVar.W()) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.a(this.a, 52), d.a(this.a, 52));
                    layoutParams2.gravity = 17;
                    cVar.f1643b.setLayoutParams(layoutParams2);
                    cVar.h.setBackgroundDrawable(gradientDrawable3);
                    cVar.c.setBackgroundDrawable(this.f);
                    cVar.c.setVisibility(0);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(d.a(this.a, 56), d.a(this.a, 56));
                    layoutParams3.gravity = 17;
                    cVar.f1643b.setLayoutParams(layoutParams3);
                    cVar.h.setBackgroundDrawable(null);
                    cVar.c.setVisibility(8);
                }
            }
            imageView = cVar.f1643b;
            iA = d.a(this.a, 56);
            iA2 = d.a(this.a, 56);
        }
        cVar.f1643b.setTag(gVar.w());
        cVar.f1643b.setImageDrawable(null);
        context = this.a;
        strD = gVar.w();
        imageView = cVar.f1643b;
        iA = d.a(this.a, 56);
        iA2 = d.a(this.a, 56);
        e.a(context, strD, imageView, iA, iA2, (e.b) null);
        this.g.add(new WeakReference<>(viewA));
        return viewA;
    }
}
