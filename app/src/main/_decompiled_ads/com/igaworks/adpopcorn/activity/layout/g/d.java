package com.igaworks.adpopcorn.activity.layout.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d extends LinearLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1602b;
    private boolean c;
    private View.OnClickListener d;
    private g e;
    private GradientDrawable f;
    private GradientDrawable g;
    private LinearLayout h;
    private LinearLayout i;
    private com.igaworks.adpopcorn.activity.layout.a j;
    private com.igaworks.adpopcorn.activity.layout.a k;
    private ViewFlipper l;
    private ImageView m;
    private int n;

    public d(Context context, int i, boolean z, int i2, g gVar, View.OnClickListener onClickListener) {
        super(context);
        this.n = 0;
        this.a = context;
        this.f1602b = i;
        this.c = z;
        this.n = i2;
        this.d = onClickListener;
        this.e = gVar;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        this.g = gradientDrawable;
        gradientDrawable.setShape(0);
        this.g.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
        this.g.setGradientType(0);
        this.g.setStroke(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)));
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)});
        this.f = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.f.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
        this.f.setGradientType(0);
        this.f.setStroke(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)));
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
            int iA = a(this.f1602b - com.igaworks.adpopcorn.cores.common.d.a(this.a, 17));
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setOrientation(1);
            linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPECIAL_OFFER_BOTTOM_MARGIN_DP)));
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
        View view2 = new View(this.a);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
        addView(view2);
        int iE = (int) (com.igaworks.adpopcorn.cores.common.d.e() * 618.0d);
        int iD = (int) (com.igaworks.adpopcorn.cores.common.d.d() * 326.0d);
        if (this.n == 1) {
            iE = (int) (com.igaworks.adpopcorn.cores.common.d.e() * 600.0d);
            iD = (int) (com.igaworks.adpopcorn.cores.common.d.d() * 316.0d);
        }
        this.h = new LinearLayout(this.a);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, iD));
        this.h.setOrientation(0);
        this.h.setId(0);
        this.l = new ViewFlipper(this.a);
        this.l.setLayoutParams(new LinearLayout.LayoutParams(iE, iD - com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
        this.l.setId(1);
        this.l.setTag(0);
        this.l.setOnClickListener(this.d);
        this.h.addView(this.l);
        ImageView imageView = new ImageView(this.a);
        this.m = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8), -1));
        this.h.addView(this.m);
        this.i = new LinearLayout(this.a);
        this.i.setLayoutParams(new LinearLayout.LayoutParams(iE, iD));
        this.i.setOrientation(1);
        this.i.setGravity(48);
        this.h.addView(this.i);
        addView(this.h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    private void a(int i, com.igaworks.adpopcorn.cores.model.g gVar) {
        ImageView imageView;
        LinearLayout linearLayout;
        TextView textView;
        LinearLayout linearLayout2;
        ImageView imageView2;
        int i2;
        ImageView imageView3;
        TextView textView2;
        LinearLayout linearLayout3;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        boolean z;
        boolean zA;
        TextView textView6;
        ?? r2;
        int i3;
        boolean z2;
        ImageView imageView4;
        Context context;
        String str;
        ImageView imageView5;
        String strW = gVar.w();
        String strV = gVar.V();
        String strP = gVar.P();
        int iK = gVar.K();
        String strC = gVar.c();
        boolean zF0 = gVar.f0();
        int iS = gVar.S();
        String strR = gVar.R();
        int iB = gVar.b();
        int iC = k.c(iK);
        int iB2 = k.b(iK);
        String strA = k.a(this.e, iK);
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_SIZE);
        APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_COMING_SOON_BADGE_SIZE);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iB2, iB2});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()) / 2);
        gradientDrawable.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_BADGE_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_BADGE_COLOR)});
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight()) / 2);
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMING_SOON_BADGE_LINE_COLOR)));
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
        gradientDrawable3.setGradientType(0);
        gradientDrawable3.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)));
        if (i == 0) {
            LinearLayout linearLayout4 = (LinearLayout) this.j.findViewById(1);
            ImageView imageView6 = (ImageView) this.j.findViewById(2);
            ImageView imageView7 = (ImageView) this.j.findViewById(3);
            LinearLayout linearLayout5 = (LinearLayout) this.j.findViewById(4);
            TextView textView7 = (TextView) this.j.findViewById(5);
            TextView textView8 = (TextView) this.j.findViewById(6);
            TextView textView9 = (TextView) this.j.findViewById(8);
            ImageView imageView8 = (ImageView) this.j.findViewById(9);
            TextView textView10 = (TextView) this.j.findViewById(10);
            linearLayout = (LinearLayout) this.j.findViewById(100);
            textView = textView7;
            linearLayout2 = linearLayout4;
            imageView2 = imageView8;
            i2 = 8;
            imageView = imageView7;
            textView2 = textView8;
            linearLayout3 = linearLayout5;
            textView3 = textView10;
            textView4 = textView9;
            imageView3 = imageView6;
        } else {
            LinearLayout linearLayout6 = (LinearLayout) this.k.findViewById(1);
            ImageView imageView9 = (ImageView) this.k.findViewById(2);
            imageView = (ImageView) this.k.findViewById(3);
            LinearLayout linearLayout7 = (LinearLayout) this.k.findViewById(4);
            TextView textView11 = (TextView) this.k.findViewById(5);
            TextView textView12 = (TextView) this.k.findViewById(6);
            TextView textView13 = (TextView) this.k.findViewById(8);
            ImageView imageView10 = (ImageView) this.k.findViewById(9);
            TextView textView14 = (TextView) this.k.findViewById(10);
            linearLayout = (LinearLayout) this.k.findViewById(100);
            textView = textView11;
            linearLayout2 = linearLayout6;
            imageView2 = imageView10;
            i2 = 8;
            imageView3 = imageView9;
            textView2 = textView12;
            linearLayout3 = linearLayout7;
            textView3 = textView14;
            textView4 = textView13;
        }
        linearLayout.setVisibility(i2);
        linearLayout2.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(zF0 ? ApStyleManager.CustomStyle.COMING_SOON_LAYOUT_BG_COLOR : ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR));
        linearLayout3.setBackgroundColor(0);
        if (iK == 16 || iK == 26 || iK == 27) {
            imageView.setVisibility(0);
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_play.png", imageView, false);
        } else {
            imageView.setVisibility(8);
        }
        String str2 = "";
        if (iK == 7 || iK == 23) {
            textView5 = textView3;
            z = false;
            zA = com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, false);
            if (zA) {
                str2 = this.e.F;
            }
        } else {
            textView5 = textView3;
            zA = false;
            z = false;
        }
        if (iK == 25 && (zA = com.igaworks.adpopcorn.a.b.a().a(this.a, "participateFlag", strC, z))) {
            str2 = this.e.v0;
        }
        if (zA) {
            k.b(textView4, " " + str2 + " ", com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CHECKED_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
            textView6 = textView4;
            textView6.setBackgroundDrawable(this.f);
            r2 = z;
        } else {
            textView6 = textView4;
            int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP);
            if (strP != null && strP.length() >= 9) {
                iC2 -= 4;
            } else if (strP != null && strP.length() >= 7) {
                iC2 -= 2;
            }
            r2 = z;
            k.b(textView6, strP, iC2, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
            textView6.setBackgroundDrawable(this.g);
        }
        TextView textView15 = textView6;
        k.b(textView, strV, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
        if (zF0) {
            TextView textView16 = textView5;
            TextView textView17 = textView2;
            i3 = 8;
            z2 = true;
            g gVar2 = this.e;
            k.b(textView16, iS == 1 ? gVar2.x0 : gVar2.y0, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMING_SOON_BADGE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
            k.b(textView17, strR, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_BADGE_DESC_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMING_SOON_BADGE_DESC_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
            textView16.setBackgroundDrawable(gradientDrawable2);
            textView17.setVisibility(r2);
            textView15.setBackgroundDrawable(gradientDrawable3);
        } else {
            k.b(textView5, strA, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), iC, null, 0, 1, TextUtils.TruncateAt.END, false);
            TextView textView18 = textView5;
            textView18.setBackgroundDrawable(gradientDrawable);
            i3 = 8;
            textView2.setVisibility(8);
            if (strA == null || strA.length() <= 9) {
                z2 = true;
            } else {
                z2 = true;
                textView18.setTextSize(1, 9.0f);
            }
        }
        if (!com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_CAMPAIGN_BADGE)) {
            imageView4 = imageView2;
            if (
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r48v1 boolean
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                */
            /*
                Method dump skipped, instruction units count: 1122
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.igaworks.adpopcorn.activity.layout.g.d.a(int, com.igaworks.adpopcorn.cores.model.g):void");
        }

        public void a(List<com.igaworks.adpopcorn.cores.model.g> list, boolean z) {
            if (list != null) {
                try {
                    int iE = (int) (com.igaworks.adpopcorn.cores.common.d.e() * 618.0d);
                    int iD = (int) (com.igaworks.adpopcorn.cores.common.d.d() * 326.0d);
                    if (this.n == 1) {
                        iE = (int) (com.igaworks.adpopcorn.cores.common.d.e() * 600.0d);
                        iD = (int) (com.igaworks.adpopcorn.cores.common.d.d() * 316.0d);
                    }
                    this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, iD));
                    this.l.setLayoutParams(z ? new LinearLayout.LayoutParams(iE, iD - ((int) (com.igaworks.adpopcorn.cores.common.d.d() * 2.0d))) : new LinearLayout.LayoutParams(iE, iD - com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
                    this.m.setLayoutParams(new LinearLayout.LayoutParams((int) (com.igaworks.adpopcorn.cores.common.d.e() * 15.0d), -1));
                    int i = this.n;
                    int i2 = i == 1 ? 1 : 0;
                    com.igaworks.adpopcorn.activity.layout.a aVarA = com.igaworks.adpopcorn.activity.layout.a.a(this.a, true, false, i, i2, z);
                    this.j = aVarA;
                    aVarA.setTag(1);
                    this.j.setOnClickListener(this.d);
                    this.i.addView(this.j);
                    com.igaworks.adpopcorn.activity.layout.a aVarA2 = com.igaworks.adpopcorn.activity.layout.a.a(this.a, true, false, this.n, i2, z);
                    this.k = aVarA2;
                    aVarA2.setTag(2);
                    this.k.setOnClickListener(this.d);
                    this.i.addView(this.k);
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        a(i3, list.get(i3));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
