package com.igaworks.adpopcorn.activity.b.k;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
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
import androidx.core.view.ViewCompat;
import com.adxcorp.util.ADXLogUtil;
import com.google.common.net.HttpHeaders;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.f;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends Dialog implements com.igaworks.adpopcorn.a.g.a.d {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1557b;
    private g c;
    private LinearLayout d;
    private LinearLayout e;
    private boolean f;
    private boolean g;
    private com.igaworks.adpopcorn.activity.b.d.a h;
    private com.igaworks.adpopcorn.activity.b.d.c i;
    private com.igaworks.adpopcorn.a.g.a j;
    private ListView k;
    private TextView l;
    private TextView m;
    private LinearLayout n;
    private ArrayList<com.igaworks.adpopcorn.cores.model.c> o;
    private C0420e p;
    private com.igaworks.adpopcorn.a.c q;
    private GradientDrawable r;
    private boolean s;
    private String t;
    private int u;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.dismiss();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.b();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.d();
            e.this.b();
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.k.e$e, reason: collision with other inner class name */
    private class C0420e extends BaseAdapter {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<com.igaworks.adpopcorn.cores.model.c> f1558b;
        private int c = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_COLOR);
        private int d = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_COLOR);
        private int e;
        private int f;

        public C0420e(Context context, List<com.igaworks.adpopcorn.cores.model.c> list) {
            this.a = context;
            this.f1558b = list;
            com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_DIVIDER_COLOR);
            this.e = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_SIZE_DP);
            this.f = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_SIZE_DP);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<com.igaworks.adpopcorn.cores.model.c> list = this.f1558b;
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
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 51)));
                linearLayout.setOrientation(1);
                LinearLayout linearLayout2 = new LinearLayout(this.a);
                linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50)));
                linearLayout2.setGravity(17);
                linearLayout2.setOrientation(0);
                linearLayout2.setId(0);
                textView = new TextView(this.a);
                textView.setLayoutParams(e.this.f ? new LinearLayout.LayoutParams(0, -1, 0.27f) : new LinearLayout.LayoutParams(0, -1, 0.28f));
                textView.setGravity(17);
                textView.setId(1);
                linearLayout2.addView(textView);
                textView2 = new TextView(this.a);
                LinearLayout.LayoutParams layoutParams = e.this.f ? new LinearLayout.LayoutParams(0, -1, 0.46f) : new LinearLayout.LayoutParams(0, -1, 0.54f);
                layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
                layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
                textView2.setLayoutParams(layoutParams);
                textView2.setGravity(19);
                textView2.setId(2);
                linearLayout2.addView(textView2);
                textView3 = new TextView(this.a);
                textView3.setLayoutParams(e.this.f ? new LinearLayout.LayoutParams(0, -1, 0.27f) : new LinearLayout.LayoutParams(0, -1, 0.18f));
                textView3.setGravity(17);
                textView3.setId(3);
                linearLayout2.addView(textView3);
                linearLayout.addView(linearLayout2);
                LinearLayout linearLayout3 = new LinearLayout(this.a);
                linearLayout3.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
                linearLayout3.setGravity(17);
                linearLayout3.setBackgroundColor(Color.parseColor("#f7f7f8"));
                linearLayout3.setOrientation(0);
                linearLayout3.setId(4);
                linearLayout.addView(linearLayout3);
                view2 = linearLayout;
            } else {
                LinearLayout linearLayout4 = (LinearLayout) view;
                textView = (TextView) linearLayout4.findViewById(1);
                textView2 = (TextView) linearLayout4.findViewById(2);
                textView3 = (TextView) linearLayout4.findViewById(3);
                view2 = linearLayout4;
            }
            k.b(textView, this.f1558b.get(i).b(), this.e, this.c, null, 0, 1, TextUtils.TruncateAt.END, false);
            k.b(textView2, this.f1558b.get(i).a(), this.e, this.c, null, 0, 1, TextUtils.TruncateAt.END, false);
            k.b(textView3, this.f1558b.get(i).c(), this.f, this.d, null, 0, 1, TextUtils.TruncateAt.END, false);
            return view2;
        }
    }

    public e(Context context, int i, boolean z, g gVar, boolean z2, int i2) {
        super(context, i);
        this.s = false;
        this.t = "";
        this.u = 0;
        this.a = context;
        this.f1557b = i;
        this.f = z;
        this.c = gVar;
        this.g = z2;
        this.s = false;
        this.u = i2;
    }

    public e(Context context, int i, boolean z, g gVar, boolean z2, String str) {
        super(context, i);
        this.s = false;
        this.t = "";
        this.u = 0;
        this.a = context;
        this.f1557b = i;
        this.f = z;
        this.c = gVar;
        this.g = z2;
        this.t = str;
        this.s = true;
    }

    private void a() {
        try {
            b();
            g gVar = this.c;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.a, this.f1557b, gVar.I, gVar.S, -1, gVar.z, new c(), gVar.c, new d(), this.f);
            this.h = aVar;
            aVar.setCancelable(false);
            this.h.show();
        } catch (Exception unused) {
        }
    }

    private void a(f fVar) {
        String string;
        TextView textView;
        int color;
        c();
        if (fVar != null) {
            try {
                if (fVar.a() != null && fVar.a().length() > 0) {
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    if (jSONObject.getBoolean("Result") && jSONObject.has("CompletedCampaigns") && !jSONObject.isNull("CompletedCampaigns")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("CompletedCampaigns");
                        ArrayList<com.igaworks.adpopcorn.cores.model.c> arrayList = this.o;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        int i = 0;
                        while (true) {
                            string = "";
                            if (i >= jSONArray.length()) {
                                break;
                            }
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String string2 = (!jSONObject2.has("Title") || jSONObject2.isNull("Title")) ? "" : jSONObject2.getString("Title");
                            if (this.u == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle")) {
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
                            this.o.add(cVar);
                            i++;
                        }
                        ArrayList<com.igaworks.adpopcorn.cores.model.c> arrayList2 = this.o;
                        if (arrayList2 == null || arrayList2.size() != 0) {
                            this.m.setVisibility(8);
                            this.n.setVisibility(8);
                            textView = this.m;
                            color = Color.parseColor("#8c8c8c");
                        } else {
                            this.m.setVisibility(0);
                            this.n.setVisibility(0);
                            textView = this.m;
                            string = this.c.T;
                            color = Color.parseColor("#8c8c8c");
                        }
                        k.b(textView, string, 12, color, null, 0, 0, TextUtils.TruncateAt.END, false);
                        this.p.notifyDataSetChanged();
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
        com.igaworks.adpopcorn.activity.b.d.a aVar = this.h;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.h.dismiss();
        this.h = null;
    }

    private void c() {
        try {
            com.igaworks.adpopcorn.activity.b.d.c cVar = this.i;
            if (cVar != null) {
                cVar.dismiss();
                this.i = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            jSONObject.put(MBridgeConstans.APP_KEY, this.q.b());
            jSONObject.put("adid", this.q.a());
            jSONObject.put("language", locale.getLanguage());
            if (this.s) {
                String str2 = this.t;
                strG = (str2 == null || str2.length() <= 0) ? this.q.a() : this.t;
            } else {
                strG = this.q.g();
            }
            jSONObject.put("usn", strG);
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.j;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/campaignhistory";
            } else {
                aVar = this.j;
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
        this.d.addView(g());
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
        linearLayout.setGravity(17);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_LR_PADDING);
        linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TOP_PADDING)), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), 0);
        this.l = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        this.l.setLayoutParams(layoutParams);
        linearLayout.addView(this.l);
        k.b(this.l, this.c.L0, 15, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 35)));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(1);
        linearLayout2.setBackgroundDrawable(this.r);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_COLOR);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_SIZE_DP);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = this.f ? new LinearLayout.LayoutParams(0, -1, 0.27f) : new LinearLayout.LayoutParams(0, -1, 0.28f);
        layoutParams2.rightMargin = 0;
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        k.b(textView, this.c.I0, iC3, iC2, null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = this.f ? new LinearLayout.LayoutParams(0, -1, 0.46f) : new LinearLayout.LayoutParams(0, -1, 0.54f);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(19);
        k.b(textView2, this.c.J0, iC3, iC2, null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout2.addView(textView2);
        TextView textView3 = new TextView(this.a);
        textView3.setLayoutParams(this.f ? new LinearLayout.LayoutParams(0, -1, 0.27f) : new LinearLayout.LayoutParams(0, -1, 0.18f));
        textView3.setGravity(17);
        k.b(textView3, this.c.K0, iC3, iC2, null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout2.addView(textView3);
        linearLayout.addView(linearLayout2);
        this.o = new ArrayList<>();
        ListView listView = new ListView(this.a);
        this.k = listView;
        listView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        C0420e c0420e = new C0420e(this.a, this.o);
        this.p = c0420e;
        this.k.setAdapter((ListAdapter) c0420e);
        this.k.setDivider(new ColorDrawable(ViewCompat.MEASURED_SIZE_MASK));
        this.k.setDividerHeight(0);
        this.k.setSelector(new ColorDrawable(0));
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        this.e = linearLayout3;
        linearLayout3.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.e.setGravity(49);
        this.e.setOrientation(1);
        this.m = new TextView(this.a);
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 81)));
        this.m.setGravity(17);
        this.e.addView(this.m);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        this.n = linearLayout4;
        linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
        this.n.setGravity(17);
        this.n.setBackgroundColor(Color.parseColor("#f7f7f8"));
        this.n.setOrientation(0);
        this.e.addView(this.n);
        TextView textView4 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        textView4.setLayoutParams(layoutParams4);
        textView4.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        textView4.setGravity(3);
        k.b(textView4, this.c.m2, 13, Color.parseColor("#8c8c8c"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.e.addView(textView4);
        this.k.addFooterView(this.e);
        linearLayout.addView(this.k);
        return linearLayout;
    }

    private RelativeLayout g() {
        RelativeLayout.LayoutParams layoutParams;
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_MODE);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, iC)));
        relativeLayout.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR));
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (zB) {
            layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 58);
            layoutParams2.addRule(9);
        } else {
            layoutParams2.addRule(14);
        }
        layoutParams2.addRule(15);
        textView.setLayoutParams(layoutParams2);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR);
        k.b(textView, this.c.w0, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD));
        textView.setGravity(17);
        relativeLayout.addView(textView);
        ImageView imageView = new ImageView(this.a);
        if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_ID) == -100) {
            layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_arrow_back.png", imageView, false);
        } else {
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_SIZE);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.drawable.onestore_gnb_gnb_back);
            layoutParams = layoutParams3;
        }
        imageView.setOnClickListener(new a());
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        layoutParams4.addRule(15);
        layoutParams4.addRule(9);
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
            this.i = cVar;
            cVar.setCancelable(z);
            this.i.show();
        } catch (Exception e) {
            e.printStackTrace();
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
        this.c = g.a();
        if (this.g) {
            getWindow().setFlags(1024, 1024);
        }
        this.q = com.igaworks.adpopcorn.a.d.a(this.a).e();
        this.j = new com.igaworks.adpopcorn.a.g.a(this.a);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-526344, -526344});
        this.r = gradientDrawable;
        gradientDrawable.setShape(0);
        this.r.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 5.0f));
        this.r.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
            getWindow().getDecorView().setSystemUiVisibility(8192);
        }
        e();
        d();
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i, f fVar) {
        try {
            c();
            if (i == 9) {
                a(fVar);
            }
        } catch (Exception unused) {
        }
    }
}
