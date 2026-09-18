package com.igaworks.adpopcorn.activity.b.l;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
public class c extends Dialog implements com.igaworks.adpopcorn.a.g.a.d {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1564b;
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
    private e p;
    private com.igaworks.adpopcorn.a.c q;
    private boolean r;
    private String s;
    private int t;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.l.c$c, reason: collision with other inner class name */
    class ViewOnClickListenerC0423c implements View.OnClickListener {
        ViewOnClickListenerC0423c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.b();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.d();
            c.this.b();
        }
    }

    private class e extends BaseAdapter {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<com.igaworks.adpopcorn.cores.model.c> f1565b;
        private int d = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_COLOR);
        private int e = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_COLOR);
        private int c = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_DIVIDER_COLOR);
        private int f = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_SIZE_DP);
        private int g = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_SIZE_DP);

        public e(c cVar, Context context, List<com.igaworks.adpopcorn.cores.model.c> list) {
            this.a = context;
            this.f1565b = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<com.igaworks.adpopcorn.cores.model.c> list = this.f1565b;
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
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 36)));
                linearLayout.setOrientation(1);
                LinearLayout linearLayout2 = new LinearLayout(this.a);
                linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 35)));
                linearLayout2.setGravity(17);
                linearLayout2.setOrientation(0);
                linearLayout2.setId(0);
                textView = new TextView(this.a);
                textView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 111.0f));
                textView.setGravity(17);
                textView.setId(1);
                linearLayout2.addView(textView);
                textView2 = new TextView(this.a);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 140.0f);
                layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 7);
                layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 7);
                textView2.setLayoutParams(layoutParams);
                textView2.setGravity(19);
                textView2.setId(2);
                linearLayout2.addView(textView2);
                textView3 = new TextView(this.a);
                textView3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 109.0f));
                textView3.setGravity(17);
                textView3.setId(3);
                linearLayout2.addView(textView3);
                linearLayout.addView(linearLayout2);
                LinearLayout linearLayout3 = new LinearLayout(this.a);
                linearLayout3.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
                linearLayout3.setGravity(17);
                linearLayout3.setBackgroundColor(this.c);
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
            k.b(textView, this.f1565b.get(i).b(), this.f, this.d, null, 0, 1, TextUtils.TruncateAt.END, false);
            k.b(textView2, this.f1565b.get(i).a(), this.f, this.d, null, 0, 1, TextUtils.TruncateAt.END, false);
            k.b(textView3, this.f1565b.get(i).c(), this.g, this.e, null, 0, 1, TextUtils.TruncateAt.END, false);
            return view2;
        }
    }

    public c(Context context, int i, boolean z, g gVar, boolean z2, int i2) {
        super(context, i);
        this.r = false;
        this.s = "";
        this.t = 0;
        this.a = context;
        this.f1564b = i;
        this.f = z;
        this.c = gVar;
        this.g = z2;
        this.r = false;
        this.t = i2;
    }

    private void a() {
        try {
            b();
            g gVar = this.c;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(this.a, this.f1564b, gVar.I, gVar.S, -1, gVar.z, new ViewOnClickListenerC0423c(), gVar.c, new d(), this.f);
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
                            if (this.t == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle")) {
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
            jSONObject.put(MBridgeConstans.APP_KEY, this.q.b());
            jSONObject.put("adid", this.q.a());
            jSONObject.put("language", locale.getLanguage());
            if (this.r) {
                String str2 = this.s;
                strG = (str2 == null || str2.length() <= 0) ? this.q.a() : this.s;
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
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 0.5f)));
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(Color.parseColor("#d2d2d2"));
        this.d.addView(linearLayout2);
        this.d.addView(f());
        setContentView(this.d);
    }

    private LinearLayout f() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#fcfcfc"));
        linearLayout.setGravity(1);
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        linearLayout.setGravity(17);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_LR_PADDING);
        linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TOP_PADDING)), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), 0);
        this.l = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 18);
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 18);
        this.l.setLayoutParams(layoutParams);
        linearLayout.addView(this.l);
        k.b(this.l, this.c.L0, 12, Color.parseColor("#969696"), null, 0, 0, TextUtils.TruncateAt.END, false);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 41)));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(1);
        linearLayout2.setBackgroundColor(Color.parseColor("#efefef"));
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_COLOR);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_SIZE_DP);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, 111.0f);
        layoutParams2.rightMargin = 0;
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        k.b(textView, this.c.I0, iC3, iC2, null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1, 140.0f);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        k.b(textView2, this.c.J0, iC3, iC2, null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout2.addView(textView2);
        TextView textView3 = new TextView(this.a);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 109.0f));
        textView3.setGravity(17);
        k.b(textView3, this.c.K0, iC3, iC2, null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout2.addView(textView3);
        linearLayout.addView(linearLayout2);
        this.o = new ArrayList<>();
        ListView listView = new ListView(this.a);
        this.k = listView;
        listView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        e eVar = new e(this, this.a, this.o);
        this.p = eVar;
        this.k.setAdapter((ListAdapter) eVar);
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
        this.k.addFooterView(this.e);
        linearLayout.addView(this.k);
        return linearLayout;
    }

    private RelativeLayout g() {
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_SIZE);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 65)));
        relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setLayoutParams(layoutParams);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR);
        k.b(textView, this.c.L, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP), iC, null, 0, 1, TextUtils.TruncateAt.END, com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD));
        textView.setGravity(17);
        relativeLayout.addView(textView);
        ImageView imageView = new ImageView(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.tpmn_back);
        imageView.setOnClickListener(new a());
        layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, 65));
        layoutParams3.addRule(15);
        layoutParams3.addRule(9);
        linearLayout.setLayoutParams(layoutParams3);
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
        this.c = g.a();
        if (this.g) {
            getWindow().setFlags(1024, 1024);
        }
        this.q = com.igaworks.adpopcorn.a.d.a(this.a).e();
        this.j = new com.igaworks.adpopcorn.a.g.a(this.a);
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
