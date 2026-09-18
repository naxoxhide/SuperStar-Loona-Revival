package com.igaworks.adpopcorn.activity.a.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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
    private List<g> f1504b;
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

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.a.b.a$a, reason: collision with other inner class name */
    class C0401a implements com.igaworks.adpopcorn.a.g.a.d {
        C0401a(a aVar) {
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
        public LinearLayout f1505b;
        public LinearLayout c;
        public i d;
        public TextView e;
        public TextView f;
        public TextView g;
        public LinearLayout h;
        public ImageView i;
        public TextView j;
        public TextView k;
        public TextView l;

        public c(a aVar) {
        }
    }

    public a(Context context, List<g> list, com.igaworks.adpopcorn.cores.common.g gVar, boolean z, int i, int i2, boolean z2) {
        this.a = context;
        this.q = i;
        this.r = i2;
        this.f1504b = list;
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
        this.l.setCornerRadius(d.a(context, 8));
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
        List<g> list = this.f1504b;
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
        View view2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        g gVar = this.f1504b.get(i);
        String strW = gVar.w();
        String strV = gVar.V();
        String strP = gVar.p();
        gVar.P();
        int iB = k.b(gVar.K());
        boolean z = gVar.a0() || gVar.X();
        boolean zC0 = gVar.c0();
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_SIZE);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iB, iB});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(d.a(this.a, aPSizeA.getHeight()) / 2);
        gradientDrawable.setGradientType(0);
        if (view == null) {
            cVar = new c(this);
            com.igaworks.adpopcorn.activity.layout.e.a aVarA = com.igaworks.adpopcorn.activity.layout.e.a.a(this.a, this.o, true, this.q, this.r, this.p);
            cVar.a = (LinearLayout) aVarA.findViewById(0);
            cVar.f1505b = (LinearLayout) aVarA.findViewById(1);
            cVar.d = (i) aVarA.findViewById(2);
            cVar.c = (LinearLayout) aVarA.findViewById(3);
            cVar.e = (TextView) aVarA.findViewById(4);
            cVar.f = (TextView) aVarA.findViewById(5);
            cVar.g = (TextView) aVarA.findViewById(7);
            cVar.h = (LinearLayout) aVarA.findViewById(100);
            cVar.i = (ImageView) aVarA.findViewById(101);
            cVar.j = (TextView) aVarA.findViewById(102);
            cVar.k = (TextView) aVarA.findViewById(103);
            cVar.l = (TextView) aVarA.findViewById(106);
            aVarA.setTag(cVar);
            view2 = aVarA;
        } else {
            cVar = (c) view.getTag();
            view2 = view;
        }
        c cVar2 = cVar;
        if (this.r != 2) {
            cVar2.a.setVisibility(0);
            cVar2.h.setVisibility(8);
            if (Build.VERSION.SDK_INT > 21) {
                cVar2.a.setClipToOutline(true);
            }
            cVar2.c.setBackgroundColor(0);
            cVar2.f1505b.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR));
            if (z) {
                try {
                    str = new DecimalFormat("###,###").format(gVar.m());
                } catch (Exception unused) {
                    str = gVar.m() + "";
                }
                k.b(cVar2.e, gVar.n(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                k.b(cVar2.f, gVar.g(), 14, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                k.b(cVar2.g, str + gVar.O(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, true);
                cVar2.d.setTag(strW);
                cVar2.d.setImageDrawable(null);
                APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
                e.a(this.a, gVar.i(), cVar2.d, d.a(this.a, aPSizeA2.getWidth()), d.a(this.a, aPSizeA2.getHeight()), (e.b) null);
                if (!gVar.Z()) {
                    gVar.e(true);
                    if (this.s == null) {
                        this.s = new com.igaworks.adpopcorn.a.g.a(this.a);
                    }
                    Iterator<String> it = gVar.k().iterator();
                    while (it.hasNext()) {
                        this.s.a(14, it.next(), "", new b(this));
                    }
                }
            } else {
                try {
                    DecimalFormat decimalFormat = new DecimalFormat("###,###");
                    str2 = ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR;
                    try {
                        str3 = decimalFormat.format(gVar.Q());
                    } catch (Exception unused2) {
                        str3 = gVar.Q() + "";
                    }
                } catch (Exception unused3) {
                    str2 = ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR;
                }
                String str6 = str2;
                k.b(cVar2.e, strV, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(str6)), Typeface.SERIF, 0, 1, TextUtils.TruncateAt.END, false);
                k.b(cVar2.f, strP.trim(), 14, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(str6)), null, 0, 1, TextUtils.TruncateAt.END, false);
                k.b(cVar2.g, "+" + str3, 16, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, true);
                cVar2.d.setTag(strW);
                cVar2.d.setImageDrawable(null);
                APSize aPSizeA3 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
                Context context = this.a;
                e.a(context, strW, cVar2.d, d.a(context, aPSizeA3.getWidth()), d.a(this.a, aPSizeA3.getHeight()), (e.b) null);
            }
            View view3 = view2;
            this.n.add(new WeakReference<>(view3));
            return view3;
        }
        cVar2.a.setVisibility(8);
        cVar2.h.setVisibility(0);
        if (Build.VERSION.SDK_INT > 21) {
            cVar2.h.setClipToOutline(true);
        }
        if (zC0) {
            k.b(cVar2.j, gVar.H(), 16, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(cVar2.k, gVar.B() + " ", 14, Color.parseColor("#626669"), null, 0, 0, TextUtils.TruncateAt.END, false);
            try {
                str5 = new DecimalFormat("###,###").format(gVar.F());
            } catch (Exception unused4) {
                str5 = gVar.F() + "";
            }
            if (gVar.b0()) {
                k.b(cVar2.l, this.c.d, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
            } else {
                k.b(cVar2.l, "+" + str5 + " " + this.c.y1, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
            }
            cVar2.l.setBackgroundDrawable(this.l);
            cVar2.l.getLayoutParams().width = d.a(this.a, 97);
            cVar2.i.setTag(gVar.D());
            cVar2.i.setImageDrawable(null);
            e.a(this.a, gVar.D(), cVar2.i, 0, 0, (e.b) null);
        } else if (z) {
            k.b(cVar2.j, gVar.n(), 16, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(cVar2.k, gVar.g() + " ", 14, Color.parseColor("#626669"), null, 0, 0, TextUtils.TruncateAt.END, false);
            try {
                str4 = new DecimalFormat("###,###").format(gVar.m());
            } catch (Exception unused5) {
                str4 = gVar.m() + "";
            }
            if (gVar.Y()) {
                k.b(cVar2.l, this.c.d, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
            } else {
                k.b(cVar2.l, "+" + str4 + " " + this.c.y1, 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
            }
            cVar2.l.setBackgroundDrawable(this.l);
            cVar2.l.getLayoutParams().width = d.a(this.a, 97);
            cVar2.i.setTag(gVar.j());
            cVar2.i.setImageDrawable(null);
            e.a(this.a, gVar.j(), cVar2.i, 0, 0, (e.b) null);
            if (!gVar.Z()) {
                gVar.e(true);
                if (this.s == null) {
                    this.s = new com.igaworks.adpopcorn.a.g.a(this.a);
                }
                Iterator<String> it2 = gVar.k().iterator();
                while (it2.hasNext()) {
                    this.s.a(14, it2.next(), "", new C0401a(this));
                }
            }
        }
        View view4 = view2;
        this.n.add(new WeakReference<>(view4));
        return view4;
    }
}
