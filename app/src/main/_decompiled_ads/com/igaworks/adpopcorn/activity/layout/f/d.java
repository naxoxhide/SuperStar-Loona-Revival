package com.igaworks.adpopcorn.activity.layout.f;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.igaworks.adpopcorn.cores.common.e;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.text.DecimalFormat;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes2.dex */
public class d extends LinearLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1596b;
    private boolean c;
    private View.OnClickListener d;
    private g e;
    private StateListDrawable f;
    private ColorStateList g;
    private LinearLayout h;
    private LinearLayout i;
    private a j;
    private a k;
    private ViewFlipper l;
    private boolean m;
    private int n;

    public d(Context context, int i, boolean z, int i2, g gVar, View.OnClickListener onClickListener) {
        super(context);
        this.n = 0;
        this.a = context;
        this.f1596b = i;
        this.c = z;
        this.n = i2;
        this.d = onClickListener;
        this.e = gVar;
        this.m = false;
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC, iC});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, 22.5f));
        gradientDrawable.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC, iC});
        gradientDrawable2.setShape(0);
        gradientDrawable2.setAlpha(204);
        gradientDrawable2.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, 22.5f));
        gradientDrawable2.setGradientType(0);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-14211752, -14211752});
        gradientDrawable3.setAlpha(WorkQueueKt.MASK);
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, 22.5f));
        gradientDrawable3.setGradientType(0);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
        this.f.addState(new int[]{-16842910}, gradientDrawable3);
        this.f.addState(StateSet.WILD_CARD, gradientDrawable);
        this.g = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{-16842910}, new int[0]}, new int[]{Color.parseColor("#ffffff"), Color.parseColor("#80ffffff"), Color.parseColor("#ffffff")});
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        setOrientation(1);
        setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_BG_COLOR)));
        a();
    }

    private int a(int i) {
        return (int) ((((double) i) / 720.0d) * 376.0d);
    }

    private void a() {
        if (!this.c) {
            int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TOP_PADDING);
            View view = new View(this.a);
            if (iC > 0) {
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, iC)));
            } else {
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
            }
            int iA = a(this.f1596b - com.igaworks.adpopcorn.cores.common.d.a(this.a, 17));
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setOrientation(1);
            linearLayout.setPadding(0, 0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPECIAL_OFFER_BOTTOM_MARGIN_DP)));
            linearLayout.setId(0);
            ViewFlipper viewFlipper = new ViewFlipper(this.a);
            viewFlipper.setLayoutParams(new LinearLayout.LayoutParams(-1, iA));
            viewFlipper.setId(1);
            viewFlipper.setTag(0);
            viewFlipper.setOnClickListener(this.d);
            linearLayout.addView(viewFlipper);
            addView(view);
            addView(linearLayout);
            return;
        }
        int iA2 = a((com.igaworks.adpopcorn.cores.common.d.c() - com.igaworks.adpopcorn.cores.common.d.a(this.a, 60)) / 2);
        this.h = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, iA2);
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        this.h.setLayoutParams(layoutParams);
        this.h.setOrientation(0);
        this.h.setId(0);
        this.l = new ViewFlipper(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, iA2 - com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), 1.0f);
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        this.l.setLayoutParams(layoutParams2);
        this.l.setId(1);
        this.l.setTag(0);
        this.l.setOnClickListener(this.d);
        this.h.addView(this.l);
        this.i = new LinearLayout(this.a);
        this.i.setLayoutParams(new LinearLayout.LayoutParams(0, iA2 + com.igaworks.adpopcorn.cores.common.d.a(this.a, 2), 1.0f));
        this.i.setOrientation(1);
        this.i.setGravity(48);
        this.h.addView(this.i);
        addView(this.h);
    }

    private void a(int i, com.igaworks.adpopcorn.cores.model.g gVar) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ImageView imageView;
        LinearLayout linearLayout3;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        a aVar;
        String str;
        if (i == 0) {
            linearLayout = (LinearLayout) this.j.findViewById(0);
            linearLayout2 = (LinearLayout) this.j.findViewById(1);
            imageView = (ImageView) this.j.findViewById(2);
            linearLayout3 = (LinearLayout) this.j.findViewById(3);
            textView = (TextView) this.j.findViewById(4);
            textView2 = (TextView) this.j.findViewById(5);
            textView3 = (TextView) this.j.findViewById(6);
            textView4 = (TextView) this.j.findViewById(7);
            aVar = this.j;
        } else {
            linearLayout = (LinearLayout) this.k.findViewById(0);
            linearLayout2 = (LinearLayout) this.k.findViewById(1);
            imageView = (ImageView) this.k.findViewById(2);
            linearLayout3 = (LinearLayout) this.k.findViewById(3);
            textView = (TextView) this.k.findViewById(4);
            textView2 = (TextView) this.k.findViewById(5);
            textView3 = (TextView) this.k.findViewById(6);
            textView4 = (TextView) this.k.findViewById(7);
            aVar = this.k;
        }
        LinearLayout linearLayout4 = (LinearLayout) aVar.findViewById(100);
        TextView textView5 = textView3;
        LinearLayout linearLayout5 = linearLayout;
        TextView textView6 = textView;
        linearLayout5.setVisibility(0);
        linearLayout4.setVisibility(8);
        linearLayout3.setBackgroundColor(0);
        linearLayout2.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR));
        if (gVar == null) {
            return;
        }
        String strW = gVar.w();
        String strV = gVar.V();
        int iK = gVar.K();
        String strC = gVar.c();
        String str2 = this.e.y1;
        if ((iK == 7 || iK == 23) && com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, false)) {
            str2 = this.e.F;
        }
        k.b(textView4, (iK == 25 && com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, false)) ? this.e.v0 : str2, 11, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView4.setBackgroundDrawable(this.f);
        textView4.setTextColor(this.g);
        k.b(textView6, strV, 14, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
        String strP = gVar.p();
        if (strP.isEmpty()) {
            strP = this.e.c2;
        }
        k.b(textView2, strP, 12, Color.parseColor("#8c8c8c"), null, 0, 1, TextUtils.TruncateAt.END, false);
        imageView.clearColorFilter();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 16));
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        textView2.setLayoutParams(layoutParams);
        try {
            str = new DecimalFormat("###,###").format(gVar.Q());
        } catch (Exception unused) {
            str = gVar.Q() + "";
        }
        k.b(textView5, str + gVar.O(), 12, Color.parseColor("#4b469c"), null, 0, 0, TextUtils.TruncateAt.END, true);
        imageView.setTag(strW);
        imageView.setImageDrawable(null);
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
        Context context = this.a;
        e.a(context, strW, imageView, com.igaworks.adpopcorn.cores.common.d.a(context, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()), (e.b) null);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x00af A[ADDED_TO_REGION, LOOP:0: B:16:0x00af->B:21:0x00c4, LOOP_START, PHI: r1
      0x00af: PHI (r1v3 int) = (r1v0 int), (r1v4 int) binds: [B:15:0x00ad, B:21:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:17:0x00b1 A[Catch: Exception -> 0x00ab, TryCatch #0 {Exception -> 0x00ab, blocks: (B:4:0x0006, B:6:0x000a, B:8:0x0095, B:10:0x009b, B:12:0x00a8, B:11:0x00a5, B:22:0x00c7, B:17:0x00b1, B:19:0x00b7, B:21:0x00c4, B:20:0x00c1), top: B:26:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x00b7 A[Catch: Exception -> 0x00ab, TryCatch #0 {Exception -> 0x00ab, blocks: (B:4:0x0006, B:6:0x000a, B:8:0x0095, B:10:0x009b, B:12:0x00a8, B:11:0x00a5, B:22:0x00c7, B:17:0x00b1, B:19:0x00b7, B:21:0x00c4, B:20:0x00c1), top: B:26:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x00c1 A[Catch: Exception -> 0x00ab, TryCatch #0 {Exception -> 0x00ab, blocks: (B:4:0x0006, B:6:0x000a, B:8:0x0095, B:10:0x009b, B:12:0x00a8, B:11:0x00a5, B:22:0x00c7, B:17:0x00b1, B:19:0x00b7, B:21:0x00c4, B:20:0x00c1), top: B:26:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
    public void a(List<com.igaworks.adpopcorn.cores.model.g> list, boolean z) {
        int i = 0;
        if (list != null) {
            try {
                if (!this.m) {
                    int iA = a((com.igaworks.adpopcorn.cores.common.d.c() - com.igaworks.adpopcorn.cores.common.d.a(this.a, 60)) / 2);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, iA);
                    layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
                    layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
                    this.h.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, iA, 1.0f);
                    layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
                    this.l.setLayoutParams(layoutParams2);
                    a aVarA = a.a(this.a, true, false, this.n, 0, z);
                    this.j = aVarA;
                    aVarA.setTag(1);
                    this.j.setOnClickListener(this.d);
                    this.i.addView(this.j);
                    a aVarA2 = a.a(this.a, true, false, this.n, 0, z);
                    this.k = aVarA2;
                    aVarA2.setTag(2);
                    this.k.setOnClickListener(this.d);
                    this.i.addView(this.k);
                    while (i < 2) {
                        if (i < list.size()) {
                            a(i, list.get(i));
                        } else {
                            a(i, (com.igaworks.adpopcorn.cores.model.g) null);
                        }
                        i++;
                    }
                } else {
                    if (list != null) {
                        return;
                    }
                    while (i < 2) {
                        if (i < list.size()) {
                            a(i, list.get(i));
                        } else {
                            a(i, (com.igaworks.adpopcorn.cores.model.g) null);
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            if (list != null) {
                return;
            }
            while (i < 2) {
                if (i < list.size()) {
                    a(i, list.get(i));
                } else {
                    a(i, (com.igaworks.adpopcorn.cores.model.g) null);
                }
                i++;
            }
        }
        this.m = true;
    }
}
