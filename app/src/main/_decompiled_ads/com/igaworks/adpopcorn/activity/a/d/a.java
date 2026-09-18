package com.igaworks.adpopcorn.activity.a.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
    private List<g> f1508b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private GradientDrawable d;
    private GradientDrawable e;
    private GradientDrawable f;
    private GradientDrawable g;
    private List<WeakReference<View>> h = new ArrayList();
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private com.igaworks.adpopcorn.a.g.a m;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.a.d.a$a, reason: collision with other inner class name */
    class C0403a implements com.igaworks.adpopcorn.a.g.a.d {
        C0403a(a aVar) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, f fVar) {
        }
    }

    public class b {
        public LinearLayout a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LinearLayout f1509b;
        public i c;
        public LinearLayout d;
        public TextView e;
        public TextView f;
        public TextView g;
        public LinearLayout h;
        public ImageView i;
        public TextView j;
        public TextView k;
        public TextView l;
        public TextView m;
        public TextView n;

        public b(a aVar) {
        }
    }

    public a(Context context, List<g> list, com.igaworks.adpopcorn.cores.common.g gVar, boolean z, int i, int i2, boolean z2) {
        this.a = context;
        this.k = i;
        this.l = i2;
        this.f1508b = list;
        this.c = gVar;
        this.i = z;
        this.j = z2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-789517, -789517});
        this.d = gradientDrawable;
        gradientDrawable.setShape(0);
        this.d.setCornerRadius(d.a(context, 16));
        this.d.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-9072407, -9072407});
        this.e = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.e.setCornerRadius(d.a(context, 16));
        this.e.setGradientType(0);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.f = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.f.setGradientType(0);
        this.f.setStroke(d.a(context, 1), Color.parseColor("#ececec"));
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        this.g = gradientDrawable4;
        gradientDrawable4.setShape(0);
        this.g.setCornerRadius(d.a(context, 18));
        this.g.setGradientType(0);
        this.g.setStroke(d.a(context, 1), Color.parseColor("#ececec"));
    }

    public void a() {
        try {
            List<WeakReference<View>> list = this.h;
            if (list != null) {
                Iterator<WeakReference<View>> it = list.iterator();
                while (it.hasNext()) {
                    com.igaworks.adpopcorn.cores.common.i.a(it.next().get());
                }
                this.h.clear();
                this.h = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i) {
        this.l = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<g> list = this.f1508b;
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
        View view2;
        b bVar;
        String str;
        TextView textView;
        GradientDrawable gradientDrawable;
        b bVar2;
        String str2;
        StringBuilder sbAppend;
        TextView textView2;
        TextView textView3;
        GradientDrawable gradientDrawable2;
        String str3;
        g gVar = this.f1508b.get(i);
        String strW = gVar.w();
        String strR = gVar.r();
        String strV = gVar.V();
        gVar.P();
        int iK = gVar.K();
        String strC = gVar.c();
        if (view == null) {
            b bVar3 = new b(this);
            com.igaworks.adpopcorn.activity.layout.g.a aVarA = com.igaworks.adpopcorn.activity.layout.g.a.a(this.a, this.i, true, this.k, this.l, this.j);
            bVar3.a = (LinearLayout) aVarA.findViewById(0);
            bVar3.f1509b = (LinearLayout) aVarA.findViewById(1);
            bVar3.c = (i) aVarA.findViewById(2);
            bVar3.d = (LinearLayout) aVarA.findViewById(3);
            bVar3.e = (TextView) aVarA.findViewById(4);
            bVar3.f = (TextView) aVarA.findViewById(5);
            bVar3.g = (TextView) aVarA.findViewById(6);
            bVar3.h = (LinearLayout) aVarA.findViewById(100);
            bVar3.i = (ImageView) aVarA.findViewById(101);
            bVar3.j = (TextView) aVarA.findViewById(102);
            bVar3.k = (TextView) aVarA.findViewById(103);
            bVar3.l = (TextView) aVarA.findViewById(104);
            bVar3.m = (TextView) aVarA.findViewById(105);
            bVar3.n = (TextView) aVarA.findViewById(106);
            aVarA.setTag(bVar3);
            bVar = bVar3;
            view2 = aVarA;
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        if (this.l == 0) {
            bVar.a.setVisibility(0);
            bVar.h.setVisibility(8);
            bVar.d.setBackgroundColor(0);
            bVar.f1509b.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR));
            if (gVar.a0() || gVar.X()) {
                bVar2 = bVar;
                k.b(bVar2.e, gVar.n(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                try {
                    str2 = new DecimalFormat("###,###").format(gVar.m());
                } catch (Exception unused) {
                    str2 = gVar.m() + "";
                }
                TextView textView4 = bVar2.f;
                sbAppend = new StringBuilder().append(gVar.g()).append(str2);
                textView2 = textView4;
            } else if (gVar.c0()) {
                k.b(bVar.e, gVar.H(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                try {
                    str3 = new DecimalFormat("###,###").format(gVar.F());
                } catch (Exception unused2) {
                    str3 = gVar.F() + "";
                }
                textView2 = bVar.f;
                bVar2 = bVar;
                sbAppend = new StringBuilder().append(gVar.A()).append(str3);
            } else {
                k.b(bVar.e, strV, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                bVar2 = bVar;
                textView2 = bVar2.f;
                sbAppend = new StringBuilder().append(gVar.p()).append(gVar.Q());
            }
            k.b(textView2, sbAppend.append(gVar.O()).append(this.c.r2).toString(), 10, Color.parseColor("#969696"), null, 0, 1, TextUtils.TruncateAt.END, false);
            String str4 = this.c.q2;
            int color = Color.parseColor("#6280e3");
            if ((iK == 7 || iK == 23) && com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, false)) {
                str4 = this.c.F;
                color = Color.parseColor("#ffffff");
                textView3 = bVar2.g;
                gradientDrawable2 = this.e;
            } else {
                textView3 = bVar2.g;
                gradientDrawable2 = this.d;
            }
            textView3.setBackgroundDrawable(gradientDrawable2);
            k.b(bVar2.g, str4, 10, color, null, 0, 2, TextUtils.TruncateAt.END, false);
            bVar2.c.setTag(strW);
            bVar2.c.setImageDrawable(null);
            bVar2.c.setBackgroundDrawable(this.g);
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
            Context context = this.a;
            e.a(context, strW, bVar2.c, d.a(context, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()), (e.b) null);
        } else {
            b bVar4 = bVar;
            view2 = view2;
            bVar4.a.setVisibility(8);
            bVar4.h.setVisibility(0);
            bVar4.h.setBackgroundDrawable(this.f);
            k.b(bVar4.j, gVar.v(), 12, Color.parseColor("#232532"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(bVar4.k, gVar.p() + " ", 10, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
            try {
                str = new DecimalFormat("###,###").format(gVar.Q());
            } catch (Exception unused3) {
                str = gVar.Q() + "";
            }
            k.b(bVar4.l, str, 10, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
            k.b(bVar4.m, gVar.O(), 10, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
            String str5 = this.c.q2;
            int color2 = Color.parseColor("#6280e3");
            if ((iK == 7 || iK == 23) && com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, false)) {
                str5 = this.c.F;
                color2 = Color.parseColor("#ffffff");
                textView = bVar4.n;
                gradientDrawable = this.e;
            } else {
                textView = bVar4.n;
                gradientDrawable = this.d;
            }
            textView.setBackgroundDrawable(gradientDrawable);
            k.b(bVar4.n, str5, 10, color2, null, 0, 0, TextUtils.TruncateAt.END, false);
            bVar4.i.setTag(strR);
            bVar4.i.setImageDrawable(null);
            e.a(this.a, strR, bVar4.i, 0, 0, (e.b) null);
        }
        if ((gVar.a0() || gVar.X()) && !gVar.Z()) {
            gVar.e(true);
            if (this.m == null) {
                this.m = new com.igaworks.adpopcorn.a.g.a(this.a);
            }
            Iterator<String> it = gVar.k().iterator();
            while (it.hasNext()) {
                this.m.a(14, it.next(), "", new C0403a(this));
            }
        }
        View view3 = view2;
        this.h.add(new WeakReference<>(view3));
        return view3;
    }
}
