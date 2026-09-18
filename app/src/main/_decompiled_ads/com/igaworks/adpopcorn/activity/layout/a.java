package com.igaworks.adpopcorn.activity.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.e;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.g;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class a extends FrameLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f1582b;
    private double c;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public a(android.content.Context r31, boolean r32, int r33, int r34, boolean r35) {
        /*
            Method dump skipped, instruction units count: 1755
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igaworks.adpopcorn.activity.layout.a.<init>(android.content.Context, boolean, int, int, boolean):void");
    }

    public static int a(int i) {
        return (int) ((((double) i) / 720.0d) * 376.0d);
    }

    public static a a(Context context, int i, int i2, int i3, boolean z) {
        a aVar = new a(context, false, i2, i3, z);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (i != 0) {
            layoutParams.topMargin = i;
        }
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public static a a(Context context, boolean z, boolean z2, int i, int i2, boolean z3) {
        a aVar;
        ViewGroup.LayoutParams layoutParams;
        if (z) {
            int iE = (int) (com.igaworks.adpopcorn.cores.common.d.e() * 618.0d);
            int iD = (int) (com.igaworks.adpopcorn.cores.common.d.d() * 163.0d);
            if (i == 1) {
                iE = (int) (com.igaworks.adpopcorn.cores.common.d.e() * 600.0d);
                iD = (int) (com.igaworks.adpopcorn.cores.common.d.d() * 158.0d);
            }
            aVar = new a(context, z, i, i2, z3);
            layoutParams = z2 ? new AbsListView.LayoutParams(iE, iD) : new LinearLayout.LayoutParams(iE, iD);
        } else {
            aVar = new a(context, z, i, i2, z3);
            layoutParams = new AbsListView.LayoutParams(-1, -1);
        }
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x04d1 A[Catch: Exception -> 0x04e3, TryCatch #0 {Exception -> 0x04e3, blocks: (B:4:0x000e, B:7:0x00ad, B:9:0x01d1, B:11:0x01df, B:13:0x01f7, B:15:0x023d, B:17:0x0263, B:19:0x026e, B:25:0x02c1, B:32:0x0312, B:45:0x0340, B:47:0x034a, B:50:0x0352, B:66:0x03e1, B:70:0x0412, B:72:0x0431, B:74:0x0437, B:78:0x0445, B:79:0x0448, B:81:0x0450, B:83:0x0455, B:85:0x047b, B:91:0x04ad, B:103:0x04df, B:96:0x04c1, B:97:0x04c8, B:100:0x04d1, B:102:0x04d9, B:84:0x046b, B:86:0x0481, B:88:0x0487, B:90:0x04ab, B:89:0x049c, B:52:0x0393, B:55:0x039a, B:57:0x03a4, B:59:0x03ac, B:65:0x03bb, B:62:0x03b3, B:64:0x03b9, B:69:0x03eb, B:40:0x0330, B:42:0x033a, B:33:0x0318, B:18:0x0269, B:20:0x0280, B:22:0x02a7, B:24:0x02b1, B:23:0x02ad, B:12:0x01ea, B:8:0x0156), top: B:108:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:101:0x04d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x04d9 A[Catch: Exception -> 0x04e3, TryCatch #0 {Exception -> 0x04e3, blocks: (B:4:0x000e, B:7:0x00ad, B:9:0x01d1, B:11:0x01df, B:13:0x01f7, B:15:0x023d, B:17:0x0263, B:19:0x026e, B:25:0x02c1, B:32:0x0312, B:45:0x0340, B:47:0x034a, B:50:0x0352, B:66:0x03e1, B:70:0x0412, B:72:0x0431, B:74:0x0437, B:78:0x0445, B:79:0x0448, B:81:0x0450, B:83:0x0455, B:85:0x047b, B:91:0x04ad, B:103:0x04df, B:96:0x04c1, B:97:0x04c8, B:100:0x04d1, B:102:0x04d9, B:84:0x046b, B:86:0x0481, B:88:0x0487, B:90:0x04ab, B:89:0x049c, B:52:0x0393, B:55:0x039a, B:57:0x03a4, B:59:0x03ac, B:65:0x03bb, B:62:0x03b3, B:64:0x03b9, B:69:0x03eb, B:40:0x0330, B:42:0x033a, B:33:0x0318, B:18:0x0269, B:20:0x0280, B:22:0x02a7, B:24:0x02b1, B:23:0x02ad, B:12:0x01ea, B:8:0x0156), top: B:108:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0440  */
    /* JADX WARN: Code duplicated, block: B:78:0x0445 A[Catch: Exception -> 0x04e3, TryCatch #0 {Exception -> 0x04e3, blocks: (B:4:0x000e, B:7:0x00ad, B:9:0x01d1, B:11:0x01df, B:13:0x01f7, B:15:0x023d, B:17:0x0263, B:19:0x026e, B:25:0x02c1, B:32:0x0312, B:45:0x0340, B:47:0x034a, B:50:0x0352, B:66:0x03e1, B:70:0x0412, B:72:0x0431, B:74:0x0437, B:78:0x0445, B:79:0x0448, B:81:0x0450, B:83:0x0455, B:85:0x047b, B:91:0x04ad, B:103:0x04df, B:96:0x04c1, B:97:0x04c8, B:100:0x04d1, B:102:0x04d9, B:84:0x046b, B:86:0x0481, B:88:0x0487, B:90:0x04ab, B:89:0x049c, B:52:0x0393, B:55:0x039a, B:57:0x03a4, B:59:0x03ac, B:65:0x03bb, B:62:0x03b3, B:64:0x03b9, B:69:0x03eb, B:40:0x0330, B:42:0x033a, B:33:0x0318, B:18:0x0269, B:20:0x0280, B:22:0x02a7, B:24:0x02b1, B:23:0x02ad, B:12:0x01ea, B:8:0x0156), top: B:108:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0450 A[Catch: Exception -> 0x04e3, TryCatch #0 {Exception -> 0x04e3, blocks: (B:4:0x000e, B:7:0x00ad, B:9:0x01d1, B:11:0x01df, B:13:0x01f7, B:15:0x023d, B:17:0x0263, B:19:0x026e, B:25:0x02c1, B:32:0x0312, B:45:0x0340, B:47:0x034a, B:50:0x0352, B:66:0x03e1, B:70:0x0412, B:72:0x0431, B:74:0x0437, B:78:0x0445, B:79:0x0448, B:81:0x0450, B:83:0x0455, B:85:0x047b, B:91:0x04ad, B:103:0x04df, B:96:0x04c1, B:97:0x04c8, B:100:0x04d1, B:102:0x04d9, B:84:0x046b, B:86:0x0481, B:88:0x0487, B:90:0x04ab, B:89:0x049c, B:52:0x0393, B:55:0x039a, B:57:0x03a4, B:59:0x03ac, B:65:0x03bb, B:62:0x03b3, B:64:0x03b9, B:69:0x03eb, B:40:0x0330, B:42:0x033a, B:33:0x0318, B:18:0x0269, B:20:0x0280, B:22:0x02a7, B:24:0x02b1, B:23:0x02ad, B:12:0x01ea, B:8:0x0156), top: B:108:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0455 A[Catch: Exception -> 0x04e3, TryCatch #0 {Exception -> 0x04e3, blocks: (B:4:0x000e, B:7:0x00ad, B:9:0x01d1, B:11:0x01df, B:13:0x01f7, B:15:0x023d, B:17:0x0263, B:19:0x026e, B:25:0x02c1, B:32:0x0312, B:45:0x0340, B:47:0x034a, B:50:0x0352, B:66:0x03e1, B:70:0x0412, B:72:0x0431, B:74:0x0437, B:78:0x0445, B:79:0x0448, B:81:0x0450, B:83:0x0455, B:85:0x047b, B:91:0x04ad, B:103:0x04df, B:96:0x04c1, B:97:0x04c8, B:100:0x04d1, B:102:0x04d9, B:84:0x046b, B:86:0x0481, B:88:0x0487, B:90:0x04ab, B:89:0x049c, B:52:0x0393, B:55:0x039a, B:57:0x03a4, B:59:0x03ac, B:65:0x03bb, B:62:0x03b3, B:64:0x03b9, B:69:0x03eb, B:40:0x0330, B:42:0x033a, B:33:0x0318, B:18:0x0269, B:20:0x0280, B:22:0x02a7, B:24:0x02b1, B:23:0x02ad, B:12:0x01ea, B:8:0x0156), top: B:108:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:84:0x046b A[Catch: Exception -> 0x04e3, TryCatch #0 {Exception -> 0x04e3, blocks: (B:4:0x000e, B:7:0x00ad, B:9:0x01d1, B:11:0x01df, B:13:0x01f7, B:15:0x023d, B:17:0x0263, B:19:0x026e, B:25:0x02c1, B:32:0x0312, B:45:0x0340, B:47:0x034a, B:50:0x0352, B:66:0x03e1, B:70:0x0412, B:72:0x0431, B:74:0x0437, B:78:0x0445, B:79:0x0448, B:81:0x0450, B:83:0x0455, B:85:0x047b, B:91:0x04ad, B:103:0x04df, B:96:0x04c1, B:97:0x04c8, B:100:0x04d1, B:102:0x04d9, B:84:0x046b, B:86:0x0481, B:88:0x0487, B:90:0x04ab, B:89:0x049c, B:52:0x0393, B:55:0x039a, B:57:0x03a4, B:59:0x03ac, B:65:0x03bb, B:62:0x03b3, B:64:0x03b9, B:69:0x03eb, B:40:0x0330, B:42:0x033a, B:33:0x0318, B:18:0x0269, B:20:0x0280, B:22:0x02a7, B:24:0x02b1, B:23:0x02ad, B:12:0x01ea, B:8:0x0156), top: B:108:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0481 A[Catch: Exception -> 0x04e3, TryCatch #0 {Exception -> 0x04e3, blocks: (B:4:0x000e, B:7:0x00ad, B:9:0x01d1, B:11:0x01df, B:13:0x01f7, B:15:0x023d, B:17:0x0263, B:19:0x026e, B:25:0x02c1, B:32:0x0312, B:45:0x0340, B:47:0x034a, B:50:0x0352, B:66:0x03e1, B:70:0x0412, B:72:0x0431, B:74:0x0437, B:78:0x0445, B:79:0x0448, B:81:0x0450, B:83:0x0455, B:85:0x047b, B:91:0x04ad, B:103:0x04df, B:96:0x04c1, B:97:0x04c8, B:100:0x04d1, B:102:0x04d9, B:84:0x046b, B:86:0x0481, B:88:0x0487, B:90:0x04ab, B:89:0x049c, B:52:0x0393, B:55:0x039a, B:57:0x03a4, B:59:0x03ac, B:65:0x03bb, B:62:0x03b3, B:64:0x03b9, B:69:0x03eb, B:40:0x0330, B:42:0x033a, B:33:0x0318, B:18:0x0269, B:20:0x0280, B:22:0x02a7, B:24:0x02b1, B:23:0x02ad, B:12:0x01ea, B:8:0x0156), top: B:108:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0487 A[Catch: Exception -> 0x04e3, TryCatch #0 {Exception -> 0x04e3, blocks: (B:4:0x000e, B:7:0x00ad, B:9:0x01d1, B:11:0x01df, B:13:0x01f7, B:15:0x023d, B:17:0x0263, B:19:0x026e, B:25:0x02c1, B:32:0x0312, B:45:0x0340, B:47:0x034a, B:50:0x0352, B:66:0x03e1, B:70:0x0412, B:72:0x0431, B:74:0x0437, B:78:0x0445, B:79:0x0448, B:81:0x0450, B:83:0x0455, B:85:0x047b, B:91:0x04ad, B:103:0x04df, B:96:0x04c1, B:97:0x04c8, B:100:0x04d1, B:102:0x04d9, B:84:0x046b, B:86:0x0481, B:88:0x0487, B:90:0x04ab, B:89:0x049c, B:52:0x0393, B:55:0x039a, B:57:0x03a4, B:59:0x03ac, B:65:0x03bb, B:62:0x03b3, B:64:0x03b9, B:69:0x03eb, B:40:0x0330, B:42:0x033a, B:33:0x0318, B:18:0x0269, B:20:0x0280, B:22:0x02a7, B:24:0x02b1, B:23:0x02ad, B:12:0x01ea, B:8:0x0156), top: B:108:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:89:0x049c A[Catch: Exception -> 0x04e3, TryCatch #0 {Exception -> 0x04e3, blocks: (B:4:0x000e, B:7:0x00ad, B:9:0x01d1, B:11:0x01df, B:13:0x01f7, B:15:0x023d, B:17:0x0263, B:19:0x026e, B:25:0x02c1, B:32:0x0312, B:45:0x0340, B:47:0x034a, B:50:0x0352, B:66:0x03e1, B:70:0x0412, B:72:0x0431, B:74:0x0437, B:78:0x0445, B:79:0x0448, B:81:0x0450, B:83:0x0455, B:85:0x047b, B:91:0x04ad, B:103:0x04df, B:96:0x04c1, B:97:0x04c8, B:100:0x04d1, B:102:0x04d9, B:84:0x046b, B:86:0x0481, B:88:0x0487, B:90:0x04ab, B:89:0x049c, B:52:0x0393, B:55:0x039a, B:57:0x03a4, B:59:0x03ac, B:65:0x03bb, B:62:0x03b3, B:64:0x03b9, B:69:0x03eb, B:40:0x0330, B:42:0x033a, B:33:0x0318, B:18:0x0269, B:20:0x0280, B:22:0x02a7, B:24:0x02b1, B:23:0x02ad, B:12:0x01ea, B:8:0x0156), top: B:108:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:93:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:94:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:96:0x04c1 A[Catch: Exception -> 0x04e3, TryCatch #0 {Exception -> 0x04e3, blocks: (B:4:0x000e, B:7:0x00ad, B:9:0x01d1, B:11:0x01df, B:13:0x01f7, B:15:0x023d, B:17:0x0263, B:19:0x026e, B:25:0x02c1, B:32:0x0312, B:45:0x0340, B:47:0x034a, B:50:0x0352, B:66:0x03e1, B:70:0x0412, B:72:0x0431, B:74:0x0437, B:78:0x0445, B:79:0x0448, B:81:0x0450, B:83:0x0455, B:85:0x047b, B:91:0x04ad, B:103:0x04df, B:96:0x04c1, B:97:0x04c8, B:100:0x04d1, B:102:0x04d9, B:84:0x046b, B:86:0x0481, B:88:0x0487, B:90:0x04ab, B:89:0x049c, B:52:0x0393, B:55:0x039a, B:57:0x03a4, B:59:0x03ac, B:65:0x03bb, B:62:0x03b3, B:64:0x03b9, B:69:0x03eb, B:40:0x0330, B:42:0x033a, B:33:0x0318, B:18:0x0269, B:20:0x0280, B:22:0x02a7, B:24:0x02b1, B:23:0x02ad, B:12:0x01ea, B:8:0x0156), top: B:108:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:98:0x04cc  */
    public void a(View view, Context context, g gVar, boolean z, boolean z2, int i) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        int iA;
        int iA2;
        float fA;
        boolean zA;
        int i2;
        GradientDrawable gradientDrawable3;
        TextView textView;
        int i3;
        FrameLayout.LayoutParams layoutParams;
        int iA3;
        ImageView imageView;
        String str;
        FrameLayout.LayoutParams layoutParams2;
        int iA4;
        if (gVar != null) {
            try {
                String strW = gVar.w();
                String strV = gVar.V();
                String strP = gVar.P();
                int iK = gVar.K();
                String strC = gVar.c();
                int iB = gVar.b();
                com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
                boolean zF0 = gVar.f0();
                LinearLayout linearLayout = (LinearLayout) view.findViewById(1);
                i iVar = (i) view.findViewById(2);
                ImageView imageView2 = (ImageView) view.findViewById(3);
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(4);
                TextView textView2 = (TextView) view.findViewById(5);
                TextView textView3 = (TextView) view.findViewById(6);
                TextView textView4 = (TextView) view.findViewById(8);
                ImageView imageView3 = (ImageView) view.findViewById(9);
                TextView textView5 = (TextView) view.findViewById(10);
                ImageView imageView4 = (ImageView) view.findViewById(12);
                ImageView imageView5 = (ImageView) view.findViewById(13);
                ((LinearLayout) view.findViewById(100)).setVisibility(8);
                if (i != 4) {
                    GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
                    gradientDrawable4.setShape(0);
                    gradientDrawable4.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
                    gradientDrawable4.setGradientType(0);
                    gradientDrawable4.setStroke(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)));
                    GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)});
                    gradientDrawable5.setShape(0);
                    gradientDrawable5.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
                    gradientDrawable5.setGradientType(0);
                    gradientDrawable5.setStroke(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.REWARD_VIEW_LINE_COLOR)));
                    gradientDrawable2 = gradientDrawable4;
                    gradientDrawable = gradientDrawable5;
                } else {
                    GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)});
                    gradientDrawable6.setShape(0);
                    gradientDrawable6.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
                    gradientDrawable6.setGradientType(0);
                    GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR)});
                    gradientDrawable7.setShape(0);
                    gradientDrawable7.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP)));
                    gradientDrawable7.setGradientType(0);
                    gradientDrawable = gradientDrawable7;
                    gradientDrawable2 = gradientDrawable6;
                }
                int iC = k.c(iK);
                int iB2 = k.b(iK);
                String strA = k.a(gVarA, iK);
                if (z2) {
                    iA = (int) (this.f1582b * 128.0d);
                    iA2 = iA;
                } else {
                    iA = com.igaworks.adpopcorn.cores.common.d.a(context, 64);
                    iA2 = com.igaworks.adpopcorn.cores.common.d.a(context, 64);
                }
                e.a(context, strW, iVar, iA, iA2, (e.b) null);
                linearLayout2.setBackgroundColor(0);
                APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_SIZE);
                APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_COMING_SOON_BADGE_SIZE);
                GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iB2, iB2});
                if (zF0) {
                    linearLayout.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMING_SOON_LAYOUT_BG_COLOR));
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(context, aPSizeA2.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(context, aPSizeA2.getHeight()));
                    layoutParams3.rightMargin = z2 ? (int) (this.f1582b * 10.0d) : com.igaworks.adpopcorn.cores.common.d.a(context, 5);
                    textView5.setLayoutParams(layoutParams3);
                    fA = com.igaworks.adpopcorn.cores.common.d.a(context, aPSizeA2.getHeight()) / 2;
                } else {
                    linearLayout.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR));
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(context, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(context, aPSizeA.getHeight()));
                    layoutParams4.rightMargin = z2 ? (int) (this.f1582b * 10.0d) : com.igaworks.adpopcorn.cores.common.d.a(context, 5);
                    textView5.setLayoutParams(layoutParams4);
                    fA = com.igaworks.adpopcorn.cores.common.d.a(context, aPSizeA.getHeight()) / 2;
                }
                gradientDrawable8.setCornerRadius(fA);
                gradientDrawable8.setShape(0);
                gradientDrawable8.setGradientType(0);
                k.b(textView2, strV, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 2, TextUtils.TruncateAt.END, false);
                textView3.setVisibility(8);
                if (iK == 16 || iK == 26 || iK == 27) {
                    imageView2.setVisibility(0);
                    com.igaworks.adpopcorn.a.a.a(context, "igaw_ap_ic_play.png", imageView2, false);
                } else {
                    imageView2.setVisibility(8);
                }
                String str2 = "";
                if (iK == 7 || iK == 23) {
                    zA = com.igaworks.adpopcorn.a.b.a().a(context, "participateFlag", strC, false);
                    if (zA) {
                        str2 = gVarA.F;
                    }
                } else {
                    zA = false;
                }
                if (iK == 25 && (zA = com.igaworks.adpopcorn.a.b.a().a(context, "participateFlag", strC, false))) {
                    str2 = gVarA.v0;
                }
                if (!zA) {
                    if (strP == null || strP.length() == 0) {
                        i2 = 9;
                        k.b(textView4, "", com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CHECKED_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                        textView4.setBackgroundDrawable(null);
                    } else {
                        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP);
                        if (strP != null) {
                            i2 = 9;
                            if (strP.length() >= 9) {
                                iC2 -= 4;
                            }
                            k.b(textView4, strP, iC2, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                            gradientDrawable3 = gradientDrawable2;
                        } else {
                            i2 = 9;
                        }
                        if (strP != null && strP.length() >= 7) {
                            iC2 -= 2;
                        }
                        k.b(textView4, strP, iC2, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                        gradientDrawable3 = gradientDrawable2;
                    }
                    k.b(textView5, strA, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), iC, null, 0, 1, TextUtils.TruncateAt.END, false);
                    if (strA != null || strA.length() <= i2) {
                        textView = textView5;
                    } else {
                        textView = textView5;
                        textView.setTextSize(1, 9.0f);
                    }
                    if (i != 4) {
                        textView.setBackgroundDrawable(gradientDrawable8);
                    }
                    imageView4.setVisibility(0);
                    if (z) {
                        imageView5.setVisibility(8);
                        if (z2) {
                            layoutParams2 = new FrameLayout.LayoutParams(-1, (int) (this.c * 6.0d));
                            iA4 = (int) (this.c * 163.0d);
                            i3 = 3;
                        } else {
                            i3 = 3;
                            layoutParams2 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(context, 3));
                            iA4 = com.igaworks.adpopcorn.cores.common.d.a(context, 84);
                        }
                        layoutParams2.topMargin = iA4;
                        imageView4.setLayoutParams(layoutParams2);
                    } else {
                        i3 = 3;
                        imageView5.setVisibility(8);
                        if (z2) {
                            layoutParams = new FrameLayout.LayoutParams(-1, (int) (this.c * 16.0d));
                            iA3 = (int) (this.c * 169.0d);
                        } else {
                            layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(context, 8));
                            iA3 = com.igaworks.adpopcorn.cores.common.d.a(context, 85);
                        }
                        layoutParams.topMargin = iA3;
                    }
                    if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_CAMPAIGN_BADGE)) {
                        if (iB == 1) {
                            imageView = imageView3;
                            imageView.setVisibility(0);
                            str = "igaw_ap_badge_new.png";
                        } else {
                            imageView = imageView3;
                            if (iB == 2) {
                                imageView.setVisibility(0);
                                str = "igaw_ap_badge_hot.png";
                            } else if (iB == i3) {
                                imageView.setVisibility(0);
                                str = "igaw_ap_badge_end.png";
                            }
                        }
                        com.igaworks.adpopcorn.a.a.a(context, str, imageView, false);
                        return;
                    }
                    imageView = imageView3;
                    imageView.setVisibility(8);
                }
                k.b(textView4, " " + str2 + " ", com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CHECKED_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                gradientDrawable3 = gradientDrawable;
                i2 = 9;
                textView4.setBackgroundDrawable(gradientDrawable3);
                k.b(textView5, strA, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP), iC, null, 0, 1, TextUtils.TruncateAt.END, false);
                if (strA != null) {
                    textView = textView5;
                } else {
                    textView = textView5;
                }
                if (i != 4) {
                    textView.setBackgroundDrawable(gradientDrawable8);
                }
                imageView4.setVisibility(0);
                if (z) {
                    imageView5.setVisibility(8);
                    if (z2) {
                        layoutParams2 = new FrameLayout.LayoutParams(-1, (int) (this.c * 6.0d));
                        iA4 = (int) (this.c * 163.0d);
                        i3 = 3;
                    } else {
                        i3 = 3;
                        layoutParams2 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(context, 3));
                        iA4 = com.igaworks.adpopcorn.cores.common.d.a(context, 84);
                    }
                    layoutParams2.topMargin = iA4;
                    imageView4.setLayoutParams(layoutParams2);
                } else {
                    i3 = 3;
                    imageView5.setVisibility(8);
                    if (z2) {
                        layoutParams = new FrameLayout.LayoutParams(-1, (int) (this.c * 16.0d));
                        iA3 = (int) (this.c * 169.0d);
                    } else {
                        layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(context, 8));
                        iA3 = com.igaworks.adpopcorn.cores.common.d.a(context, 85);
                    }
                    layoutParams.topMargin = iA3;
                }
                if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.DISABLE_CAMPAIGN_BADGE)) {
                    if (iB == 1) {
                        imageView = imageView3;
                        imageView.setVisibility(0);
                        str = "igaw_ap_badge_new.png";
                    } else {
                        imageView = imageView3;
                        if (iB == 2) {
                            imageView.setVisibility(0);
                            str = "igaw_ap_badge_hot.png";
                        } else if (iB == i3) {
                            imageView.setVisibility(0);
                            str = "igaw_ap_badge_end.png";
                        }
                    }
                    com.igaworks.adpopcorn.a.a.a(context, str, imageView, false);
                    return;
                }
                imageView = imageView3;
                imageView.setVisibility(8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(View view, g gVar) {
        if (gVar != null) {
            try {
                String strW = gVar.w();
                i iVar = (i) view.findViewById(2);
                APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
                Context context = this.a;
                e.a(context, strW, iVar, com.igaworks.adpopcorn.cores.common.d.a(context, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()), (e.b) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
