package com.igaworks.adpopcorn.activity.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adxcorp.util.ADXLogUtil;
import com.google.common.net.HttpHeaders;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f extends Dialog implements com.igaworks.adpopcorn.a.g.a.d {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1534b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private LinearLayout d;
    private boolean e;
    private boolean f;
    private com.igaworks.adpopcorn.activity.b.d.a g;
    private com.igaworks.adpopcorn.activity.b.d.c h;
    private com.igaworks.adpopcorn.a.g.a i;
    private ListView j;
    private TextView k;
    private ArrayList<com.igaworks.adpopcorn.cores.model.c> l;
    private e m;
    private com.igaworks.adpopcorn.a.c n;
    private boolean o;
    private String p;
    private int q;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.dismiss();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.b();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.d();
            f.this.b();
        }
    }

    private class e extends BaseAdapter {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<com.igaworks.adpopcorn.cores.model.c> f1535b;
        private int d = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_COLOR);
        private int e = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_COLOR);
        private int c = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_DIVIDER_COLOR);
        private int f = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_SIZE_DP);
        private int g = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_SIZE_DP);

        public e(Context context, List<com.igaworks.adpopcorn.cores.model.c> list) {
            this.a = context;
            this.f1535b = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<com.igaworks.adpopcorn.cores.model.c> list = this.f1535b;
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
            TextView textView;
            TextView textView2;
            TextView textView3;
            View view2;
            if (view == null) {
                LinearLayout linearLayout = new LinearLayout(this.a);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 25)));
                linearLayout.setGravity(17);
                linearLayout.setOrientation(0);
                LinearLayout linearLayout2 = new LinearLayout(this.a);
                LinearLayout.LayoutParams layoutParams = f.this.e ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 158), -1) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 108), -1);
                layoutParams.rightMargin = 0;
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout2.setGravity(17);
                linearLayout2.setOrientation(1);
                textView = new TextView(this.a);
                textView.setLayoutParams(f.this.e ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 142), 0, 1.0f) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 90), 0, 1.0f));
                textView.setGravity(17);
                textView.setId(0);
                ImageView imageView = new ImageView(this.a);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
                imageView.setBackgroundColor(this.c);
                linearLayout2.addView(textView);
                linearLayout2.addView(imageView);
                linearLayout.addView(linearLayout2);
                LinearLayout linearLayout3 = new LinearLayout(this.a);
                LinearLayout.LayoutParams layoutParams2 = f.this.e ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 278), -1) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 149), -1);
                layoutParams2.rightMargin = 0;
                linearLayout3.setLayoutParams(layoutParams2);
                linearLayout3.setGravity(17);
                linearLayout3.setOrientation(1);
                textView2 = new TextView(this.a);
                LinearLayout.LayoutParams layoutParams3 = f.this.e ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 264), 0, 1.0f) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 130), 0, 1.0f);
                layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 3);
                textView2.setLayoutParams(layoutParams3);
                textView2.setGravity(17);
                textView2.setId(1);
                ImageView imageView2 = new ImageView(this.a);
                imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
                imageView2.setBackgroundColor(this.c);
                linearLayout3.addView(textView2);
                linearLayout3.addView(imageView2);
                linearLayout.addView(linearLayout3);
                LinearLayout linearLayout4 = new LinearLayout(this.a);
                LinearLayout.LayoutParams layoutParams4 = f.this.e ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 158), -1) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 83), -1);
                layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 3);
                linearLayout4.setLayoutParams(layoutParams4);
                linearLayout4.setGravity(17);
                linearLayout4.setOrientation(1);
                textView3 = new TextView(this.a);
                textView3.setLayoutParams(f.this.e ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 142), 0, 1.0f) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 64), 0, 1.0f));
                textView3.setGravity(17);
                textView3.setId(2);
                ImageView imageView3 = new ImageView(this.a);
                imageView3.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
                imageView3.setBackgroundColor(this.c);
                linearLayout4.addView(textView3);
                linearLayout4.addView(imageView3);
                linearLayout.addView(linearLayout4);
                view2 = linearLayout;
            } else {
                LinearLayout linearLayout5 = (LinearLayout) view;
                textView = (TextView) linearLayout5.findViewById(0);
                textView2 = (TextView) linearLayout5.findViewById(1);
                textView3 = (TextView) linearLayout5.findViewById(2);
                view2 = linearLayout5;
            }
            k.b(textView, this.f1535b.get(i).b(), this.f, this.d, null, 0, 1, TextUtils.TruncateAt.END, false);
            k.b(textView2, this.f1535b.get(i).a(), this.f, this.d, null, 0, 1, TextUtils.TruncateAt.END, false);
            k.b(textView3, this.f1535b.get(i).c(), this.g, this.e, null, 0, 1, TextUtils.TruncateAt.END, false);
            return view2;
        }
    }

    public f(Context context, int i, boolean z, com.igaworks.adpopcorn.cores.common.g gVar, boolean z2, int i2) {
        super(context, i);
        this.o = false;
        this.p = "";
        this.q = 0;
        this.a = context;
        this.f1534b = i;
        this.e = z;
        this.c = gVar;
        this.f = z2;
        this.o = false;
        this.q = i2;
    }

    public f(Context context, int i, boolean z, com.igaworks.adpopcorn.cores.common.g gVar, boolean z2, String str) {
        super(context, i);
        this.o = false;
        this.p = "";
        this.q = 0;
        this.a = context;
        this.f1534b = i;
        this.e = z;
        this.c = gVar;
        this.f = z2;
        this.p = str;
        this.o = true;
    }

    private void a() {
        try {
            b();
            com.igaworks.adpopcorn.cores.common.g gVar = this.c;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.a, this.f1534b, gVar.I, gVar.S, -1, gVar.z, new c(), gVar.c, new d(), this.e);
            this.g = aVar;
            aVar.setCancelable(false);
            this.g.show();
        } catch (Exception unused) {
        }
    }

    private void a(com.igaworks.adpopcorn.cores.model.f fVar) {
        TextView textView;
        String str;
        int color;
        c();
        if (fVar != null) {
            try {
                if (fVar.a() != null && fVar.a().length() > 0) {
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    if (jSONObject.getBoolean("Result") && jSONObject.has("CompletedCampaigns") && !jSONObject.isNull("CompletedCampaigns")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("CompletedCampaigns");
                        ArrayList<com.igaworks.adpopcorn.cores.model.c> arrayList = this.l;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String string = "";
                            String string2 = (!jSONObject2.has("Title") || jSONObject2.isNull("Title")) ? "" : jSONObject2.getString("Title");
                            if (this.q == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle")) {
                                string2 = jSONObject2.getString("FeedTitle");
                            }
                            String string3 = (!jSONObject2.has(HttpHeaders.DATE) || jSONObject2.isNull(HttpHeaders.DATE)) ? "" : jSONObject2.getString(HttpHeaders.DATE);
                            if (jSONObject2.has(ADXLogUtil.EVENT_REWARD) && !jSONObject2.isNull(ADXLogUtil.EVENT_REWARD)) {
                                string = jSONObject2.getString(ADXLogUtil.EVENT_REWARD);
                            }
                            com.igaworks.adpopcorn.cores.model.c cVar = new com.igaworks.adpopcorn.cores.model.c();
                            cVar.a(string2);
                            cVar.b(string3);
                            cVar.c(string);
                            this.l.add(cVar);
                        }
                        this.m.notifyDataSetChanged();
                        ArrayList<com.igaworks.adpopcorn.cores.model.c> arrayList2 = this.l;
                        if (arrayList2 == null || arrayList2.size() != 0) {
                            textView = this.k;
                            str = this.c.L0;
                            color = Color.parseColor("#919191");
                        } else {
                            textView = this.k;
                            str = this.c.T;
                            color = Color.parseColor("#919191");
                        }
                        k.b(textView, str, 12, color, null, 0, 0, TextUtils.TruncateAt.END, false);
                        return;
                    }
                }
            } catch (Exception unused) {
                c();
            }
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.igaworks.adpopcorn.activity.b.d.a aVar = this.g;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.g.dismiss();
        this.g = null;
    }

    private void c() {
        try {
            com.igaworks.adpopcorn.activity.b.d.c cVar = this.h;
            if (cVar != null) {
                cVar.dismiss();
                this.h = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String strG;
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            a(false);
            Locale locale = Locale.getDefault();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MBridgeConstans.APP_KEY, this.n.b());
            jSONObject.put("adid", this.n.a());
            jSONObject.put("language", locale.getLanguage());
            if (this.o) {
                String str2 = this.p;
                strG = (str2 == null || str2.length() <= 0) ? this.n.a() : this.p;
            } else {
                strG = this.n.g();
            }
            jSONObject.put("usn", strG);
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.i;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/campaignhistory";
            } else {
                aVar = this.i;
                str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/campaignhistory";
            }
            aVar.a(9, str, jSONObject, this);
        } catch (Exception unused) {
            c();
        }
    }

    private void e() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        this.d = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.d.setOrientation(1);
        this.d.addView(h());
        if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ENABLE_REWARD_HISTORY_DIALOG_TOP_BAR_SHADOW)) {
            this.d.addView(g());
        }
        this.d.addView(f());
        setContentView(this.d);
    }

    private LinearLayout f() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(1);
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_LR_PADDING);
        linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TOP_PADDING)), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), 0);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 30)));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(1);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_BG_COLOR);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_COLOR);
        int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_SIZE_DP);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams = this.e ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 158), -1) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 108), -1);
        layoutParams.rightMargin = 0;
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        k.b(textView, this.c.I0, iC4, iC3, null, 0, 0, TextUtils.TruncateAt.END, false);
        textView.setBackgroundColor(iC2);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = this.e ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 278), -1) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 149), -1);
        layoutParams2.rightMargin = 0;
        textView2.setLayoutParams(layoutParams2);
        textView2.setGravity(17);
        k.b(textView2, this.c.J0, iC4, iC3, null, 0, 0, TextUtils.TruncateAt.END, false);
        textView2.setBackgroundColor(iC2);
        linearLayout2.addView(textView2);
        TextView textView3 = new TextView(this.a);
        textView3.setLayoutParams(this.e ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 158), -1) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 83), -1));
        textView3.setGravity(17);
        k.b(textView3, this.c.K0, iC4, iC3, null, 0, 0, TextUtils.TruncateAt.END, false);
        textView3.setBackgroundColor(iC2);
        linearLayout2.addView(textView3);
        linearLayout.addView(linearLayout2);
        this.l = new ArrayList<>();
        ListView listView = new ListView(this.a);
        this.j = listView;
        listView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        e eVar = new e(this.a, this.l);
        this.m = eVar;
        this.j.setAdapter((ListAdapter) eVar);
        this.j.setDivider(new ColorDrawable(0));
        this.j.setDividerHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
        this.j.setSelector(new ColorDrawable(0));
        this.k = new TextView(this.a);
        AbsListView.LayoutParams layoutParams3 = new AbsListView.LayoutParams(-1, -2);
        this.k.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 10));
        this.k.setLayoutParams(layoutParams3);
        this.k.setGravity(17);
        this.j.addFooterView(this.k);
        linearLayout.addView(this.j);
        return linearLayout;
    }

    private View g() {
        ImageView imageView = new ImageView(this.a);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 5)));
        try {
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_shadow.png", imageView, false);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setBackgroundColor(-1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return imageView;
    }

    private RelativeLayout h() {
        int i;
        RelativeLayout.LayoutParams layoutParams;
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_MODE);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, iC)));
        relativeLayout.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR));
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (zB) {
            layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
            i = 9;
        } else {
            i = 14;
        }
        layoutParams2.addRule(i);
        layoutParams2.addRule(15);
        textView.setLayoutParams(layoutParams2);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR);
        k.b(textView, this.c.w0, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD));
        textView.setGravity(17);
        relativeLayout.addView(textView);
        ImageView imageView = new ImageView(this.a);
        if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_ID) == -100) {
            layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_close.png", imageView, false);
        } else {
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_SIZE);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_ID));
            layoutParams = layoutParams3;
        }
        imageView.setOnClickListener(new a());
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        layoutParams4.addRule(15);
        layoutParams4.addRule(11);
        linearLayout.setLayoutParams(layoutParams4);
        linearLayout.setOnClickListener(new b());
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    public void a(boolean z) {
        try {
            c();
            if (((Activity) this.a).isFinishing()) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.c cVar = new com.igaworks.adpopcorn.activity.b.d.c(context, com.igaworks.adpopcorn.activity.b.d.a(context));
            this.h = cVar;
            cVar.setCancelable(z);
            this.h.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        if (com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
            getWindow().addFlags(524288);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = 2;
        layoutParams.dimAmount = fC;
        getWindow().setAttributes(layoutParams);
        this.c = com.igaworks.adpopcorn.cores.common.g.a();
        if (this.f) {
            getWindow().setFlags(1024, 1024);
        }
        this.n = com.igaworks.adpopcorn.a.d.a(this.a).e();
        this.i = new com.igaworks.adpopcorn.a.g.a(this.a);
        e();
        d();
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        try {
            c();
            if (i == 9) {
                a(fVar);
            }
        } catch (Exception unused) {
        }
    }
}
