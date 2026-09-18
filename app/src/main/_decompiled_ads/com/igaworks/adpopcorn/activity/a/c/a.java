package com.igaworks.adpopcorn.activity.a.c;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
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
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseAdapter {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<g> f1506b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private StateListDrawable d;
    private ColorStateList e;
    private List<WeakReference<View>> f = new ArrayList();
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private com.igaworks.adpopcorn.a.g.a k;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.a.c.a$a, reason: collision with other inner class name */
    class C0402a implements com.igaworks.adpopcorn.a.g.a.d {
        C0402a(a aVar) {
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
        public LinearLayout f1507b;
        public i c;
        public LinearLayout d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public ImageView i;
        public LinearLayout j;
        public ImageView k;
        public TextView l;
        public TextView m;
        public TextView n;
        public TextView o;
        public TextView p;

        public c(a aVar) {
        }
    }

    public a(Context context, List<g> list, com.igaworks.adpopcorn.cores.common.g gVar, boolean z, int i, int i2, boolean z2) {
        this.a = context;
        this.i = i;
        this.j = i2;
        this.f1506b = list;
        this.c = gVar;
        this.g = z;
        this.h = z2;
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC, iC});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(d.a(context, 22.5f));
        gradientDrawable.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC, iC});
        gradientDrawable2.setShape(0);
        gradientDrawable2.setAlpha(204);
        gradientDrawable2.setCornerRadius(d.a(context, 22.5f));
        gradientDrawable2.setGradientType(0);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-14211752, -14211752});
        gradientDrawable3.setAlpha(WorkQueueKt.MASK);
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(d.a(context, 22.5f));
        gradientDrawable3.setGradientType(0);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.d = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
        this.d.addState(new int[]{-16842910}, gradientDrawable3);
        this.d.addState(StateSet.WILD_CARD, gradientDrawable);
        this.e = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{-16842910}, new int[0]}, new int[]{Color.parseColor("#ffffff"), Color.parseColor("#80ffffff"), Color.parseColor("#ffffff")});
    }

    public void a() {
        try {
            List<WeakReference<View>> list = this.f;
            if (list != null) {
                Iterator<WeakReference<View>> it = list.iterator();
                while (it.hasNext()) {
                    com.igaworks.adpopcorn.cores.common.i.a(it.next().get());
                }
                this.f.clear();
                this.f = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i) {
        this.j = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<g> list = this.f1506b;
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
        Context context;
        int i2;
        c cVar2;
        String str2;
        FrameLayout.LayoutParams layoutParams;
        String str3;
        g gVar = this.f1506b.get(i);
        String strW = gVar.w();
        String strR = gVar.r();
        String strV = gVar.V();
        int iK = gVar.K();
        String strC = gVar.c();
        boolean z = gVar.a0() || gVar.X();
        if (view == null) {
            cVar = new c(this);
            viewA = com.igaworks.adpopcorn.activity.layout.f.a.a(this.a, this.g, true, this.i, this.j, this.h);
            cVar.a = (LinearLayout) viewA.findViewById(0);
            cVar.f1507b = (LinearLayout) viewA.findViewById(1);
            cVar.c = (i) viewA.findViewById(2);
            cVar.d = (LinearLayout) viewA.findViewById(3);
            cVar.e = (TextView) viewA.findViewById(4);
            cVar.f = (TextView) viewA.findViewById(5);
            cVar.g = (TextView) viewA.findViewById(6);
            cVar.h = (TextView) viewA.findViewById(7);
            cVar.i = (ImageView) viewA.findViewById(8);
            cVar.j = (LinearLayout) viewA.findViewById(100);
            cVar.k = (ImageView) viewA.findViewById(101);
            cVar.l = (TextView) viewA.findViewById(102);
            cVar.m = (TextView) viewA.findViewById(103);
            cVar.n = (TextView) viewA.findViewById(104);
            cVar.o = (TextView) viewA.findViewById(105);
            cVar.p = (TextView) viewA.findViewById(106);
            viewA.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
            viewA = view;
        }
        c cVar3 = cVar;
        try {
            str = new DecimalFormat("###,###").format(gVar.Q());
        } catch (Exception unused) {
            str = gVar.Q() + "";
        }
        String str4 = str;
        if (this.j == 2) {
            cVar3.a.setVisibility(8);
            cVar3.j.setVisibility(0);
            if (Build.VERSION.SDK_INT > 21) {
                cVar3.j.setClipToOutline(true);
            }
            if (i == 0) {
                layoutParams = (FrameLayout.LayoutParams) cVar3.j.getLayoutParams();
                layoutParams.leftMargin = d.a(this.a, 20);
                layoutParams.rightMargin = d.a(this.a, 20);
                layoutParams.topMargin = d.a(this.a, 20);
                layoutParams.bottomMargin = d.a(this.a, 20);
            } else {
                layoutParams = (FrameLayout.LayoutParams) cVar3.j.getLayoutParams();
                layoutParams.leftMargin = d.a(this.a, 20);
                layoutParams.rightMargin = d.a(this.a, 20);
                layoutParams.bottomMargin = d.a(this.a, 20);
                layoutParams.topMargin = d.a(this.a, 0);
            }
            cVar3.j.setLayoutParams(layoutParams);
            if (z) {
                k.b(cVar3.l, gVar.n(), 16, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
                k.b(cVar3.m, gVar.g() + " ", 14, Color.parseColor("#6c757d"), null, 0, 0, TextUtils.TruncateAt.END, false);
                try {
                    str3 = new DecimalFormat("###,###").format(gVar.m());
                } catch (Exception unused2) {
                    str3 = gVar.m() + "";
                }
                k.b(cVar3.n, str3, 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.b(cVar3.o, gVar.O(), 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.b(cVar3.p, this.c.y1, 11, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
                cVar3.p.setBackgroundDrawable(this.d);
                cVar3.k.setTag(gVar.j());
                cVar3.k.setImageDrawable(null);
                e.a(this.a, gVar.j(), cVar3.k, 0, 0, (e.b) null);
                if (!gVar.Z()) {
                    gVar.e(true);
                    if (this.k == null) {
                        this.k = new com.igaworks.adpopcorn.a.g.a(this.a);
                    }
                    Iterator<String> it = gVar.k().iterator();
                    while (it.hasNext()) {
                        this.k.a(14, it.next(), "", new C0402a(this));
                    }
                }
            } else {
                k.b(cVar3.l, gVar.v(), 13, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
                k.b(cVar3.m, gVar.p() + " ", 12, Color.parseColor("#8c8c8c"), null, 0, 0, TextUtils.TruncateAt.END, false);
                k.b(cVar3.n, str4, 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.b(cVar3.o, gVar.O(), 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
                String str5 = this.c.y1;
                boolean zA = com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, false);
                if ((iK == 7 || iK == 23) && zA) {
                    str5 = this.c.F;
                }
                if (iK == 25 && zA) {
                    str5 = this.c.v0;
                }
                k.b(cVar3.p, str5, 11, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
                cVar3.p.setBackgroundDrawable(this.d);
                cVar3.k.setTag(strR);
                cVar3.k.setImageDrawable(null);
                e.a(this.a, strR, cVar3.k, 0, 0, (e.b) null);
            }
        } else {
            cVar3.a.setVisibility(0);
            cVar3.j.setVisibility(8);
            cVar3.d.setBackgroundColor(0);
            cVar3.i.setVisibility(0);
            cVar3.f1507b.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar3.f1507b.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) cVar3.i.getLayoutParams();
            if (i % 2 == 0) {
                layoutParams2.leftMargin = d.a(this.a, 20);
                layoutParams2.rightMargin = d.a(this.a, 0);
                layoutParams3.leftMargin = d.a(this.a, 20);
                context = this.a;
                i2 = 0;
            } else {
                layoutParams2.leftMargin = d.a(this.a, 0);
                layoutParams2.rightMargin = d.a(this.a, 20);
                layoutParams3.leftMargin = d.a(this.a, 0);
                context = this.a;
                i2 = 20;
            }
            layoutParams3.rightMargin = d.a(context, i2);
            cVar3.i.setLayoutParams(layoutParams3);
            cVar3.f1507b.setLayoutParams(layoutParams2);
            String str6 = this.c.y1;
            boolean zA2 = com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, false);
            if ((iK == 7 || iK == 23) && zA2) {
                str6 = this.c.F;
            }
            if (iK == 25 && zA2) {
                str6 = this.c.v0;
            }
            k.b(cVar3.h, str6, 11, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
            cVar3.h.setBackgroundDrawable(this.d);
            cVar3.h.setTextColor(this.e);
            if (z) {
                k.b(cVar3.e, gVar.n(), 13, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
                k.b(cVar3.f, gVar.g(), 11, Color.parseColor("#8c8c8c"), null, 0, 1, TextUtils.TruncateAt.END, false);
                cVar3.c.clearColorFilter();
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, d.a(this.a, 16));
                layoutParams4.rightMargin = d.a(this.a, 6);
                cVar3.f.setLayoutParams(layoutParams4);
                try {
                    str2 = new DecimalFormat("###,###").format(gVar.m());
                } catch (Exception unused3) {
                    str2 = gVar.m() + "";
                }
                str4 = str2;
                if (!gVar.Z()) {
                    gVar.e(true);
                    if (this.k == null) {
                        this.k = new com.igaworks.adpopcorn.a.g.a(this.a);
                    }
                    Iterator<String> it2 = gVar.k().iterator();
                    while (it2.hasNext()) {
                        this.k.a(14, it2.next(), "", new b(this));
                    }
                }
                cVar2 = cVar3;
            } else {
                cVar2 = cVar3;
                k.b(cVar3.e, strV, 14, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
                String strP = gVar.p();
                if (strP.isEmpty()) {
                    strP = this.c.c2;
                }
                k.b(cVar2.f, strP, 12, Color.parseColor("#8c8c8c"), null, 0, 1, TextUtils.TruncateAt.END, false);
                cVar2.c.clearColorFilter();
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, d.a(this.a, 16));
                layoutParams5.rightMargin = d.a(this.a, 6);
                cVar2.f.setLayoutParams(layoutParams5);
            }
            k.b(cVar2.g, str4 + gVar.O(), 12, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
            cVar2.c.setTag(strW);
            cVar2.c.setImageDrawable(null);
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
            Context context2 = this.a;
            e.a(context2, strW, cVar2.c, d.a(context2, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()), (e.b) null);
        }
        this.f.add(new WeakReference<>(viewA));
        return viewA;
    }
}
