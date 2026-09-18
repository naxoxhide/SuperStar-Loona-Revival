package com.igaworks.adpopcorn.activity.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.cores.common.e;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.f;
import com.igaworks.adpopcorn.cores.model.g;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseAdapter {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<g> f1502b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private GradientDrawable d;
    private GradientDrawable e;
    private GradientDrawable f;
    private GradientDrawable g;
    private GradientDrawable h;
    private GradientDrawable i;
    private GradientDrawable j;
    private GradientDrawable k;
    private GradientDrawable l;
    private GradientDrawable m;
    private List<WeakReference<View>> n = new ArrayList();
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private com.igaworks.adpopcorn.a.g.a s;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.a.a$a, reason: collision with other inner class name */
    class C0400a implements com.igaworks.adpopcorn.a.g.a.d {
        C0400a(a aVar) {
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
        public i f1503b;
        public ImageView c;
        public LinearLayout d;
        public TextView e;
        public TextView f;
        public TextView g;
        public LinearLayout h;
        public ImageView i;
        public TextView j;
        public ImageView k;
        public ImageView l;
        public ImageView m;
        public LinearLayout n;
        public ImageView o;
        public TextView p;
        public TextView q;
        public TextView r;
        public TextView s;
        public TextView t;

        public c(a aVar) {
        }
    }

    public a(Context context, List<g> list, com.igaworks.adpopcorn.cores.common.g gVar, boolean z, int i, int i2, boolean z2) {
        this.a = context;
        this.q = i;
        this.r = i2;
        this.f1502b = list;
        this.c = gVar;
        this.o = z;
        this.p = z2;
        if (i2 != 4) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
            this.e = gradientDrawable;
            gradientDrawable.setShape(0);
            this.e.setCornerRadius(d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
            this.e.setGradientType(0);
            this.e.setStroke(d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)));
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)});
            this.d = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.d.setCornerRadius(d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
            this.d.setGradientType(0);
            this.d.setStroke(d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)));
        } else {
            GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)});
            this.e = gradientDrawable3;
            gradientDrawable3.setShape(0);
            this.e.setCornerRadius(d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
            this.e.setGradientType(0);
            GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)});
            this.d = gradientDrawable4;
            gradientDrawable4.setShape(0);
            this.d.setCornerRadius(d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
            this.d.setGradientType(0);
        }
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_COMING_SOON_BADGE_SIZE);
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_BADGE_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_BADGE_COLOR)});
        this.f = gradientDrawable5;
        gradientDrawable5.setShape(0);
        this.f.setCornerRadius(d.a(context, aPSizeA.getHeight()) / 2);
        this.f.setGradientType(0);
        this.f.setStroke(d.a(context, 1), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMING_SOON_BADGE_LINE_COLOR)));
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        this.g = gradientDrawable6;
        gradientDrawable6.setShape(0);
        this.g.setCornerRadius(d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
        this.g.setGradientType(0);
        this.g.setStroke(d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)));
        int iA = d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_CORNER_ROUND_DP));
        GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR)});
        this.h = gradientDrawable7;
        gradientDrawable7.setShape(0);
        float f = iA;
        this.h.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.h.setGradientType(0);
        GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR)});
        this.i = gradientDrawable8;
        gradientDrawable8.setShape(0);
        this.i.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
        this.i.setGradientType(0);
        GradientDrawable gradientDrawable9 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_LAYOUT_BG_COLOR)});
        this.j = gradientDrawable9;
        gradientDrawable9.setShape(0);
        this.j.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.j.setGradientType(0);
        GradientDrawable gradientDrawable10 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_LAYOUT_BG_COLOR)});
        this.k = gradientDrawable10;
        gradientDrawable10.setShape(0);
        this.k.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
        this.k.setGradientType(0);
        GradientDrawable gradientDrawable11 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_BTN_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_BTN_COLOR)});
        this.l = gradientDrawable11;
        gradientDrawable11.setShape(0);
        this.l.setCornerRadius(d.a(context, 3));
        this.l.setGradientType(0);
        GradientDrawable gradientDrawable12 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        this.m = gradientDrawable12;
        gradientDrawable12.setShape(0);
        this.m.setCornerRadius(d.a(context, 3));
        this.m.setGradientType(0);
        this.m.setStroke(d.a(context, 1), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.FEED_OFFERWALL_BTN_COLOR)));
    }

    public void a() {
        try {
            List<WeakReference<View>> list = this.n;
            if (list != null) {
                Iterator<WeakReference<View>> it = list.iterator();
                while (it.hasNext()) {
                    com.igaworks.adpopcorn.cores.common.i.a(it.next().get());
                }
                this.n.clear();
                this.n = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i) {
        this.r = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<g> list = this.f1502b;
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

    /* JADX WARN: Code duplicated, block: B:148:0x06f3  */
    /* JADX WARN: Code duplicated, block: B:150:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:156:0x072f  */
    /* JADX WARN: Code duplicated, block: B:159:0x0740  */
    /* JADX WARN: Code duplicated, block: B:160:0x075a  */
    /* JADX WARN: Code duplicated, block: B:162:0x078f  */
    /* JADX WARN: Code duplicated, block: B:164:0x0799  */
    /* JADX WARN: Code duplicated, block: B:165:0x07c3  */
    /* JADX WARN: Code duplicated, block: B:168:0x0856  */
    /* JADX WARN: Code duplicated, block: B:171:0x0872  */
    /* JADX WARN: Code duplicated, block: B:172:0x088b  */
    /* JADX WARN: Code duplicated, block: B:177:0x08a6  */
    /* JADX WARN: Code duplicated, block: B:179:0x08aa  */
    /* JADX WARN: Code duplicated, block: B:181:0x08b9  */
    /* JADX WARN: Code duplicated, block: B:183:0x08bc  */
    /* JADX WARN: Code duplicated, block: B:184:0x08c8  */
    /* JADX WARN: Code duplicated, block: B:186:0x08cb  */
    /* JADX WARN: Code duplicated, block: B:187:0x08d7  */
    /* JADX WARN: Code duplicated, block: B:69:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:73:0x045e  */
    /* JADX WARN: Code duplicated, block: B:81:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:82:0x04bc  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v54 */
    /* JADX WARN: Type inference failed for: r5v55 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        View viewA;
        View view2;
        String str;
        TextView textView;
        GradientDrawable gradientDrawable;
        String str2;
        String str3;
        String str4;
        int i2;
        LinearLayout linearLayout;
        int iC;
        LinearLayout linearLayout2;
        GradientDrawable gradientDrawable2;
        boolean zA;
        int i3;
        c cVar2;
        c cVar3;
        int i4;
        int i5;
        ?? r10;
        Context context;
        ImageView imageView;
        String str5;
        boolean z;
        LinearLayout linearLayout3;
        GradientDrawable gradientDrawable3;
        ?? r5;
        g gVar = this.f1502b.get(i);
        String strW = gVar.w();
        String strR = gVar.r();
        String strV = gVar.V();
        String strP = gVar.P();
        int iK = gVar.K();
        String strC = gVar.c();
        int iB = gVar.b();
        int iC2 = k.c(iK);
        int iB2 = k.b(iK);
        String strA = k.a(this.c, iK);
        boolean zF0 = gVar.f0();
        int iS = gVar.S();
        String strR2 = gVar.R();
        boolean z2 = gVar.a0() || gVar.X();
        boolean zC0 = gVar.c0();
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_SIZE);
        APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_COMING_SOON_BADGE_SIZE);
        int i6 = iS;
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iB2, iB2});
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius(d.a(this.a, aPSizeA.getHeight()) / 2);
        gradientDrawable4.setGradientType(0);
        if (view == null) {
            cVar = new c(this);
            viewA = com.igaworks.adpopcorn.activity.layout.a.a(this.a, this.o, true, this.q, this.r, this.p);
            cVar.h = (LinearLayout) viewA.findViewById(0);
            cVar.a = (LinearLayout) viewA.findViewById(1);
            cVar.f1503b = (i) viewA.findViewById(2);
            cVar.c = (ImageView) viewA.findViewById(3);
            cVar.d = (LinearLayout) viewA.findViewById(4);
            cVar.e = (TextView) viewA.findViewById(5);
            cVar.f = (TextView) viewA.findViewById(6);
            cVar.g = (TextView) viewA.findViewById(8);
            cVar.i = (ImageView) viewA.findViewById(9);
            cVar.j = (TextView) viewA.findViewById(10);
            cVar.k = (ImageView) viewA.findViewById(11);
            cVar.l = (ImageView) viewA.findViewById(12);
            cVar.m = (ImageView) viewA.findViewById(13);
            cVar.n = (LinearLayout) viewA.findViewById(100);
            cVar.o = (ImageView) viewA.findViewById(101);
            cVar.p = (TextView) viewA.findViewById(102);
            cVar.q = (TextView) viewA.findViewById(103);
            cVar.r = (TextView) viewA.findViewById(104);
            cVar.s = (TextView) viewA.findViewById(105);
            cVar.t = (TextView) viewA.findViewById(106);
            viewA.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
            viewA = view;
        }
        int i7 = this.r;
        if (i7 == 2 || i7 == 3) {
            view2 = viewA;
            cVar.h.setVisibility(8);
            cVar.l.setVisibility(8);
            cVar.m.setVisibility(8);
            cVar.n.setVisibility(0);
            if (Build.VERSION.SDK_INT > 21) {
                cVar.n.setClipToOutline(true);
            }
            if (z2) {
                k.b(cVar.p, gVar.n(), 16, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
                k.b(cVar.q, gVar.g() + " ", 14, Color.parseColor("#6c757d"), null, 0, 0, TextUtils.TruncateAt.END, false);
                try {
                    str4 = new DecimalFormat("###,###").format(gVar.m());
                    str3 = "";
                } catch (Exception unused) {
                    str3 = "";
                    str4 = gVar.m() + str3;
                }
                k.b(cVar.r, "+" + str4, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.b(cVar.s, gVar.O(), 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.b(cVar.t, this.c.y1, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
                cVar.t.setBackgroundDrawable(this.l);
                cVar.t.getLayoutParams().width = d.a(this.a, 84);
                cVar.o.setTag(gVar.j());
                cVar.o.setImageDrawable(null);
                e.a(this.a, gVar.j(), cVar.o, 0, 0, (e.b) null);
                if (!gVar.Z()) {
                    gVar.e(true);
                    if (this.s == null) {
                        this.s = new com.igaworks.adpopcorn.a.g.a(this.a);
                    }
                    Iterator<String> it = gVar.k().iterator();
                    while (it.hasNext()) {
                        this.s.a(14, it.next(), str3, new C0400a(this));
                    }
                }
            } else if (zC0) {
                k.b(cVar.p, gVar.H(), 16, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
                k.b(cVar.q, gVar.B() + " ", 14, Color.parseColor("#626669"), null, 0, 0, TextUtils.TruncateAt.END, false);
                try {
                    str2 = new DecimalFormat("###,###").format(gVar.F());
                } catch (Exception unused2) {
                    str2 = gVar.F() + "";
                }
                if (gVar.b0()) {
                    k.b(cVar.t, this.c.d, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
                } else {
                    k.b(cVar.t, "+" + str2 + " " + this.c.y1, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
                }
                cVar.t.setBackgroundDrawable(this.l);
                cVar.t.getLayoutParams().width = d.a(this.a, 97);
                cVar.o.setTag(gVar.D());
                cVar.o.setImageDrawable(null);
                e.a(this.a, gVar.D(), cVar.o, 0, 0, (e.b) null);
            } else {
                k.b(cVar.p, gVar.v(), 16, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
                k.b(cVar.q, gVar.p() + " ", 14, Color.parseColor("#6c757d"), null, 0, 0, TextUtils.TruncateAt.END, false);
                try {
                    str = new DecimalFormat("###,###").format(gVar.Q());
                } catch (Exception unused3) {
                    str = gVar.Q() + "";
                }
                k.b(cVar.r, "+" + str, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.b(cVar.s, gVar.O(), 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                String str6 = this.c.y1;
                if ((iK == 7 || iK == 23) && com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, false)) {
                    k.b(cVar.t, this.c.F, 14, Color.parseColor("#4169e1"), null, 0, 0, TextUtils.TruncateAt.END, false);
                    textView = cVar.t;
                    gradientDrawable = this.m;
                } else {
                    k.b(cVar.t, str6, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
                    textView = cVar.t;
                    gradientDrawable = this.l;
                }
                textView.setBackgroundDrawable(gradientDrawable);
                cVar.t.getLayoutParams().width = d.a(this.a, 84);
                cVar.o.setTag(strR);
                cVar.o.setImageDrawable(null);
                e.a(this.a, strR, cVar.o, 0, 0, (e.b) null);
            }
        } else {
            cVar.h.setVisibility(0);
            cVar.n.setVisibility(8);
            if (i != 0 || !gVar.W() || this.o || this.r == 4) {
                i2 = 8;
                cVar.l.setVisibility(8);
            } else {
                cVar.l.setVisibility(0);
                i2 = 8;
            }
            cVar.m.setVisibility(i2);
            cVar.d.setBackgroundColor(0);
            View view3 = viewA;
            if (z2) {
                if (i == 0) {
                    cVar.a.setBackgroundDrawable(this.h);
                    r5 = 1;
                } else {
                    r5 = 1;
                    r5 = 1;
                    if (i == this.f1502b.size() - 1) {
                        cVar.a.setBackgroundDrawable(this.i);
                    } else {
                        cVar.a.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR));
                    }
                }
                k.b(cVar.g, gVar.m() + gVar.O(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                cVar.g.setBackgroundDrawable(this.e);
                k.b(cVar.e, gVar.n(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                if (this.r != 4) {
                    cVar.j.setBackgroundDrawable(gradientDrawable4);
                }
                k.b(cVar.j, strA, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, false);
                if (strA != null && strA.length() > 9) {
                    cVar.j.setTextSize(r5, 9.0f);
                }
                cVar.f.setVisibility(8);
                if (i < this.f1502b.size() - r5) {
                    cVar.k.setVisibility(0);
                    cVar.k.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_DIVIDER_COLOR)));
                } else {
                    cVar.k.setVisibility(8);
                }
                cVar.f1503b.clearColorFilter();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()));
                layoutParams.rightMargin = d.a(this.a, 10);
                cVar.j.setLayoutParams(layoutParams);
                cVar.f1503b.setTag(strW);
                cVar.f1503b.setImageDrawable(null);
                APSize aPSizeA3 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
                e.a(this.a, gVar.i(), cVar.f1503b, d.a(this.a, aPSizeA3.getWidth()), d.a(this.a, aPSizeA3.getHeight()), (e.b) null);
                if (!gVar.Z()) {
                    gVar.e((boolean) r5);
                    if (this.s == null) {
                        this.s = new com.igaworks.adpopcorn.a.g.a(this.a);
                    }
                    Iterator<String> it2 = gVar.k().iterator();
                    while (it2.hasNext()) {
                        this.s.a(14, it2.next(), "", new b(this));
                    }
                }
            } else {
                String str7 = "";
                if (zC0) {
                    if (i == 0) {
                        linearLayout3 = cVar.a;
                        gradientDrawable3 = this.h;
                    } else {
                        if (i == this.f1502b.size() - 1) {
                            linearLayout3 = cVar.a;
                            gradientDrawable3 = this.i;
                        } else {
                            cVar.a.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR));
                        }
                        if (gVar.b0()) {
                            k.b(cVar.g, this.c.d, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                        } else {
                            k.b(cVar.g, gVar.F() + gVar.O(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                        }
                        cVar.g.setBackgroundDrawable(this.e);
                        k.b(cVar.e, gVar.H(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                        if (this.r != 4) {
                            cVar.j.setBackgroundDrawable(gradientDrawable4);
                        }
                        k.b(cVar.j, strA, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, false);
                        if (strA != null && strA.length() > 9) {
                            cVar.j.setTextSize(1, 9.0f);
                        }
                        cVar.f.setVisibility(8);
                        if (i < this.f1502b.size() - 1) {
                            cVar.k.setVisibility(0);
                            cVar.k.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_DIVIDER_COLOR)));
                        } else {
                            cVar.k.setVisibility(8);
                        }
                        cVar.f1503b.clearColorFilter();
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()));
                        layoutParams2.rightMargin = d.a(this.a, 10);
                        cVar.j.setLayoutParams(layoutParams2);
                        cVar.f1503b.setTag(strW);
                        cVar.f1503b.setImageDrawable(null);
                        APSize aPSizeA4 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
                        e.a(this.a, gVar.w(), cVar.f1503b, d.a(this.a, aPSizeA4.getWidth()), d.a(this.a, aPSizeA4.getHeight()), (e.b) null);
                    }
                    linearLayout3.setBackgroundDrawable(gradientDrawable3);
                    if (gVar.b0()) {
                        k.b(cVar.g, this.c.d, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                    } else {
                        k.b(cVar.g, gVar.F() + gVar.O(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                    }
                    cVar.g.setBackgroundDrawable(this.e);
                    k.b(cVar.e, gVar.H(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                    if (this.r != 4) {
                        cVar.j.setBackgroundDrawable(gradientDrawable4);
                    }
                    k.b(cVar.j, strA, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, false);
                    if (strA != null) {
                        cVar.j.setTextSize(1, 9.0f);
                    }
                    cVar.f.setVisibility(8);
                    if (i < this.f1502b.size() - 1) {
                        cVar.k.setVisibility(0);
                        cVar.k.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_DIVIDER_COLOR)));
                    } else {
                        cVar.k.setVisibility(8);
                    }
                    cVar.f1503b.clearColorFilter();
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()));
                    layoutParams3.rightMargin = d.a(this.a, 10);
                    cVar.j.setLayoutParams(layoutParams3);
                    cVar.f1503b.setTag(strW);
                    cVar.f1503b.setImageDrawable(null);
                    APSize aPSizeA5 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
                    e.a(this.a, gVar.w(), cVar.f1503b, d.a(this.a, aPSizeA5.getWidth()), d.a(this.a, aPSizeA5.getHeight()), (e.b) null);
                } else {
                    if (!zF0) {
                        if (i == 0) {
                            linearLayout2 = cVar.a;
                            gradientDrawable2 = this.h;
                        } else if (i == this.f1502b.size() - 1) {
                            linearLayout2 = cVar.a;
                            gradientDrawable2 = this.i;
                        } else {
                            linearLayout = cVar.a;
                            iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR);
                            linearLayout.setBackgroundColor(iC);
                        }
                        linearLayout2.setBackgroundDrawable(gradientDrawable2);
                    } else if (i == 0) {
                        cVar.a.setBackgroundDrawable(this.j);
                    } else if (i == this.f1502b.size() - 1) {
                        linearLayout2 = cVar.a;
                        gradientDrawable2 = this.k;
                        linearLayout2.setBackgroundDrawable(gradientDrawable2);
                    } else {
                        linearLayout = cVar.a;
                        iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_LAYOUT_BG_COLOR);
                        linearLayout.setBackgroundColor(iC);
                    }
                    if (iK == 16 || iK == 26 || iK == 27) {
                        cVar.c.setVisibility(0);
                        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_play.png", cVar.c, false);
                    } else {
                        cVar.c.setVisibility(8);
                    }
                    if (iK == 7 || iK == 23) {
                        zA = com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, false);
                        if (zA) {
                            str7 = this.c.F;
                        }
                    } else {
                        zA = false;
                    }
                    String str8 = (iK == 25 && (zA = com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, false))) ? this.c.v0 : str7;
                    int i8 = Build.VERSION.SDK_INT;
                    if (i8 >= 11) {
                        cVar.g.setAlpha(1.0f);
                    }
                    if (zA) {
                        k.b(cVar.g, " " + str8 + " ", com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CHECKED_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                        cVar.g.setBackgroundDrawable(this.d);
                        i3 = 4;
                    } else {
                        if (strP == null || strP.length() == 0) {
                            gradientDrawable4 = gradientDrawable4;
                            i6 = i6;
                            i3 = 4;
                            k.b(cVar.g, "", com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CHECKED_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                            cVar.g.setBackgroundDrawable(null);
                        } else {
                            int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP);
                            if (strP != null && strP.length() >= 9) {
                                iC3 -= 4;
                            } else if (strP != null && strP.length() >= 7) {
                                iC3 -= 2;
                            }
                            int i9 = iC3;
                            i3 = 4;
                            k.b(cVar.g, strP, i9, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                            cVar.g.setBackgroundDrawable(this.e);
                        }
                        cVar2 = cVar;
                        k.b(cVar.e, strV, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                        if (zF0) {
                            cVar3 = cVar2;
                            i4 = 1;
                            i5 = 8;
                            r10 = 0;
                            if (i6 == 1) {
                                k.b(cVar3.j, this.c.x0, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMING_SOON_BADGE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                            } else {
                                k.b(cVar3.j, this.c.y0, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMING_SOON_BADGE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                            }
                            k.b(cVar3.f, strR2, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_BADGE_DESC_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMING_SOON_BADGE_DESC_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(d.a(this.a, aPSizeA2.getWidth()), d.a(this.a, aPSizeA2.getHeight()));
                            layoutParams4.rightMargin = d.a(this.a, 10);
                            cVar3.j.setLayoutParams(layoutParams4);
                            cVar3.j.setBackgroundDrawable(this.f);
                            cVar3.f.setVisibility(0);
                            cVar3.g.setBackgroundDrawable(this.g);
                            if (i8 >= 11) {
                                cVar3.g.setAlpha(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_COMING_SOON_REWARD_VIEW_OPACITY) / 100.0f);
                            }
                            if (i < this.f1502b.size() - 1) {
                                cVar3.k.setVisibility(0);
                                cVar3.k.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.SCHEDULE_CAMPAIGN_LIST_DIVIDER_COLOR)));
                            } else {
                                cVar3.k.setVisibility(8);
                            }
                            cVar3.f1503b.setColorFilter(436207616, PorterDuff.Mode.SRC_ATOP);
                        } else {
                            cVar3 = cVar2;
                            if (this.r != i3) {
                                cVar3.j.setBackgroundDrawable(gradientDrawable4);
                            }
                            k.b(cVar3.j, strA, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, false);
                            if (strA != null || strA.length() <= 9) {
                                i4 = 1;
                            } else {
                                i4 = 1;
                                cVar3.j.setTextSize(1, 9.0f);
                            }
                            i5 = 8;
                            cVar3.f.setVisibility(8);
                            if (i < this.f1502b.size() - i4) {
                                z = false;
                                cVar3.k.setVisibility(0);
                                cVar3.k.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_DIVIDER_COLOR)));
                            } else {
                                z = false;
                                cVar3.k.setVisibility(8);
                            }
                            cVar3.f1503b.clearColorFilter();
                            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()));
                            layoutParams5.rightMargin = d.a(this.a, 10);
                            cVar3.j.setLayoutParams(layoutParams5);
                            r10 = z;
                        }
                        if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_CAMPAIGN_BADGE)) {
                            cVar3.i.setVisibility(i5);
                        } else {
                            if (iB == i4) {
                                cVar3.i.setVisibility(r10);
                                context = this.a;
                                imageView = cVar3.i;
                                str5 = "igaw_ap_badge_new.png";
                            } else if (iB == 2) {
                                cVar3.i.setVisibility(r10);
                                context = this.a;
                                imageView = cVar3.i;
                                str5 = "igaw_ap_badge_hot.png";
                            } else if (iB == 3) {
                                cVar3.i.setVisibility(r10);
                                context = this.a;
                                imageView = cVar3.i;
                                str5 = "igaw_ap_badge_end.png";
                            } else {
                                cVar3.i.setVisibility(i5);
                            }
                            com.igaworks.adpopcorn.a.a.a(context, str5, imageView, r10);
                        }
                        cVar3.f1503b.setTag(strW);
                        cVar3.f1503b.setImageDrawable(null);
                        APSize aPSizeA6 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
                        Context context2 = this.a;
                        i iVar = cVar3.f1503b;
                        int iA = d.a(context2, aPSizeA6.getWidth());
                        int iA2 = d.a(this.a, aPSizeA6.getHeight());
                        view2 = view3;
                        e.a(context2, strW, iVar, iA, iA2, (e.b) null);
                    }
                    cVar2 = cVar;
                    k.b(cVar.e, strV, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                    if (zF0) {
                        cVar3 = cVar2;
                        if (this.r != i3) {
                            cVar3.j.setBackgroundDrawable(gradientDrawable4);
                        }
                        k.b(cVar3.j, strA, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, false);
                        if (strA != null) {
                            i4 = 1;
                        } else {
                            i4 = 1;
                        }
                        i5 = 8;
                        cVar3.f.setVisibility(8);
                        if (i < this.f1502b.size() - i4) {
                            z = false;
                            cVar3.k.setVisibility(0);
                            cVar3.k.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_DIVIDER_COLOR)));
                        } else {
                            z = false;
                            cVar3.k.setVisibility(8);
                        }
                        cVar3.f1503b.clearColorFilter();
                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()));
                        layoutParams6.rightMargin = d.a(this.a, 10);
                        cVar3.j.setLayoutParams(layoutParams6);
                        r10 = z;
                    } else {
                        cVar3 = cVar2;
                        i4 = 1;
                        i5 = 8;
                        r10 = 0;
                        if (i6 == 1) {
                            k.b(cVar3.j, this.c.x0, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMING_SOON_BADGE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                        } else {
                            k.b(cVar3.j, this.c.y0, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMING_SOON_BADGE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                        }
                        k.b(cVar3.f, strR2, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_BADGE_DESC_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMING_SOON_BADGE_DESC_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(d.a(this.a, aPSizeA2.getWidth()), d.a(this.a, aPSizeA2.getHeight()));
                        layoutParams7.rightMargin = d.a(this.a, 10);
                        cVar3.j.setLayoutParams(layoutParams7);
                        cVar3.j.setBackgroundDrawable(this.f);
                        cVar3.f.setVisibility(0);
                        cVar3.g.setBackgroundDrawable(this.g);
                        if (i8 >= 11) {
                            cVar3.g.setAlpha(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_COMING_SOON_REWARD_VIEW_OPACITY) / 100.0f);
                        }
                        if (i < this.f1502b.size() - 1) {
                            cVar3.k.setVisibility(0);
                            cVar3.k.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.SCHEDULE_CAMPAIGN_LIST_DIVIDER_COLOR)));
                        } else {
                            cVar3.k.setVisibility(8);
                        }
                        cVar3.f1503b.setColorFilter(436207616, PorterDuff.Mode.SRC_ATOP);
                    }
                    if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_CAMPAIGN_BADGE)) {
                        if (iB == i4) {
                            cVar3.i.setVisibility(r10);
                            context = this.a;
                            imageView = cVar3.i;
                            str5 = "igaw_ap_badge_new.png";
                        } else if (iB == 2) {
                            cVar3.i.setVisibility(r10);
                            context = this.a;
                            imageView = cVar3.i;
                            str5 = "igaw_ap_badge_hot.png";
                        } else if (iB == 3) {
                            cVar3.i.setVisibility(r10);
                            context = this.a;
                            imageView = cVar3.i;
                            str5 = "igaw_ap_badge_end.png";
                        } else {
                            cVar3.i.setVisibility(i5);
                        }
                        com.igaworks.adpopcorn.a.a.a(context, str5, imageView, r10);
                    } else {
                        cVar3.i.setVisibility(i5);
                    }
                    cVar3.f1503b.setTag(strW);
                    cVar3.f1503b.setImageDrawable(null);
                    APSize aPSizeA7 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
                    Context context3 = this.a;
                    i iVar2 = cVar3.f1503b;
                    int iA3 = d.a(context3, aPSizeA7.getWidth());
                    int iA4 = d.a(this.a, aPSizeA7.getHeight());
                    view2 = view3;
                    e.a(context3, strW, iVar2, iA3, iA4, (e.b) null);
                }
            }
            view2 = view3;
        }
        this.n.add(new WeakReference<>(view2));
        return view2;
    }
}
