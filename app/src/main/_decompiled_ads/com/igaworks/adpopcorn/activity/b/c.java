package com.igaworks.adpopcorn.activity.b;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.net.MailTo;
import androidx.webkit.internal.AssetHelper;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.igaworks.adpopcorn.activity.layout.ApOfferWallLayout;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends Dialog implements com.igaworks.adpopcorn.a.g.a.d {
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private ListView G;
    private o H;
    private EditText I;
    private EditText J;
    private EditText K;
    private EditText L;
    private EditText M;
    private TextView N;
    private TextView O;
    private TextView P;
    private TextView Q;
    private TextView R;
    private com.igaworks.adpopcorn.activity.c.a S;
    private com.igaworks.adpopcorn.a.c T;
    private com.igaworks.adpopcorn.activity.b.d.a U;
    private boolean V;
    private String W;
    private ApOfferWallLayout X;
    private com.igaworks.adpopcorn.activity.layout.e.b Y;
    private com.igaworks.adpopcorn.activity.layout.f.b Z;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.igaworks.adpopcorn.cores.common.g f1512b;
    private LinearLayout c;
    private boolean d;
    private boolean e;
    private GradientDrawable f;
    private GradientDrawable g;
    private GradientDrawable h;
    private GradientDrawable i;
    private GradientDrawable j;
    private GradientDrawable k;
    private GradientDrawable l;
    private StateListDrawable m;
    private ColorStateList n;
    private int o;
    private com.igaworks.adpopcorn.a.g.a p;
    private com.igaworks.adpopcorn.activity.b.d.DialogC0410d q;
    private ArrayList<com.igaworks.adpopcorn.cores.model.b> r;
    private ArrayList<String> s;
    private ArrayList<String> t;
    private ArrayList<String> u;
    private int v;
    private int w;
    private int x;
    private com.igaworks.adpopcorn.activity.b.f y;
    private LinearLayout z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.U == null || !c.this.U.isShowing()) {
                return;
            }
            c.this.U.dismiss();
        }
    }

    class b implements View.OnClickListener {

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.igaworks.adpopcorn.a.b.a().b(c.this.a, "adpopcorn_parameter", "check_user_agreement", false);
                if (c.this.U != null) {
                    c.this.U.dismiss();
                }
                c.this.dismiss();
                if (c.this.X != null) {
                    c.this.X.exitOfferwall();
                } else if (c.this.Y != null) {
                    c.this.Y.i();
                } else if (c.this.Z != null) {
                    c.this.Z.h();
                }
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (c.this.U != null && c.this.U.isShowing()) {
                    c.this.U.dismiss();
                }
                c.this.U = new com.igaworks.adpopcorn.activity.b.d.a(c.this.a, c.this.o, c.this.f1512b.m1, c.this.f1512b.p1, -1, c.this.f1512b.H, new a(), c.this.d, true);
                c.this.U.setCancelable(false);
                c.this.U.show();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.c$c, reason: collision with other inner class name */
    class C0406c implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.c$c$a */
        class a implements View.OnClickListener {
            final /* synthetic */ int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f1513b;

            a(int i, String str) {
                this.a = i;
                this.f1513b = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.U != null) {
                    c.this.U.dismiss();
                }
                c.this.dismiss();
                int i = this.a;
                if (i == 3) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(this.f1513b));
                        c.this.a.startActivity(intent);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if (i == 4) {
                    try {
                        Intent intent2 = new Intent("android.intent.action.SENDTO");
                        intent2.setType(AssetHelper.DEFAULT_MIME_TYPE);
                        intent2.setData(Uri.parse(MailTo.MAILTO_SCHEME + this.f1513b));
                        intent2.putExtra("android.intent.extra.SUBJECT", c.this.f1512b.L);
                        c.this.a.startActivity(intent2);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        C0406c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c cVar;
            c.this.v = i;
            if (c.this.N != null) {
                c.this.N.setText((CharSequence) c.this.s.get(i));
            }
            int i2 = 1;
            if (i != c.this.s.size() - 1) {
                int iC = ((com.igaworks.adpopcorn.cores.model.b) c.this.r.get(i)).c();
                String strB = ((com.igaworks.adpopcorn.cores.model.b) c.this.r.get(i)).b();
                if (iC == 1) {
                    cVar = c.this;
                } else if (iC == 2) {
                    c.this.a(2);
                } else if (iC == 3 || iC == 4) {
                    if (c.this.U != null && c.this.U.isShowing()) {
                        c.this.U.dismiss();
                    }
                    c.this.U = new com.igaworks.adpopcorn.activity.b.d.a(c.this.a, c.this.o, c.this.f1512b.Y, c.this.f1512b.V0, -1, c.this.f1512b.H, new a(iC, strB), c.this.d, true);
                    c.this.U.setCancelable(true);
                    c.this.U.show();
                }
                c.this.q.dismiss();
            }
            cVar = c.this;
            i2 = 5;
            cVar.a(i2);
            c.this.q.dismiss();
        }
    }

    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.this.x = i;
            if (c.this.L != null) {
                if (c.this.x == c.this.u.size() - 1) {
                    c.this.L.setText("");
                    c.this.L.setHint(c.this.f1512b.U0);
                    c.this.L.setEnabled(true);
                } else {
                    c.this.L.setText((CharSequence) c.this.u.get(i));
                    c.this.L.setEnabled(false);
                }
            }
            c.this.q.dismiss();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.U != null) {
                c.this.U.dismiss();
            }
            c.this.dismiss();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar;
            com.igaworks.adpopcorn.activity.b.f fVar;
            if (c.this.o == 16973841) {
                c.this.e = true;
            }
            if (c.this.V) {
                cVar = c.this;
                fVar = new com.igaworks.adpopcorn.activity.b.f(c.this.a, c.this.o, c.this.d, c.this.f1512b, c.this.e, c.this.W);
            } else {
                int offerwallType = 0;
                if (c.this.X != null) {
                    offerwallType = c.this.X.getOfferwallType();
                } else if (c.this.Y != null) {
                    offerwallType = c.this.Y.getOfferwallType();
                } else if (c.this.Z != null) {
                    offerwallType = c.this.Z.getOfferwallType();
                }
                int i = offerwallType;
                cVar = c.this;
                fVar = new com.igaworks.adpopcorn.activity.b.f(c.this.a, c.this.o, c.this.d, c.this.f1512b, c.this.e, i);
            }
            cVar.y = fVar;
            c.this.y.show();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022";
            try {
                String strA = com.igaworks.adpopcorn.a.b.a().a(c.this.a, "adpopcorn_sdk_flag", "no_ad_landingurl", "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022");
                if (strA != null && strA.length() > 0) {
                    str = strA;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                c.this.a.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.j();
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.k();
        }
    }

    class l implements AdapterView.OnItemClickListener {
        l() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.this.w = i;
            if (c.this.H != null) {
                c.this.H.notifyDataSetInvalidated();
            }
            c.this.i();
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.S == null || c.this.R == null) {
                return;
            }
            c.this.S.setSelected(!c.this.S.isSelected());
            if (c.this.S.isSelected()) {
                c.this.R.setEnabled(true);
            } else {
                c.this.R.setEnabled(false);
            }
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.v != c.this.s.size() - 1) {
                c.this.h();
            }
        }
    }

    private class o extends BaseAdapter {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f1514b;

        public o(Context context, List<String> list) {
            this.a = context;
            this.f1514b = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> list = this.f1514b;
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
            LinearLayout linearLayout;
            com.igaworks.adpopcorn.activity.c.d dVar;
            TextView textView;
            if (view == null) {
                linearLayout = new LinearLayout(this.a);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 30)));
                linearLayout.setGravity(16);
                dVar = new com.igaworks.adpopcorn.activity.c.d(this.a);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16));
                layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
                layoutParams.gravity = 16;
                dVar.setLayoutParams(layoutParams);
                dVar.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 3), com.igaworks.adpopcorn.cores.common.d.a(this.a, 3), com.igaworks.adpopcorn.cores.common.d.a(this.a, 3), com.igaworks.adpopcorn.cores.common.d.a(this.a, 3));
                dVar.setId(0);
                textView = new TextView(this.a);
                textView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 298), -1));
                textView.setGravity(16);
                textView.setIncludeFontPadding(false);
                textView.setId(1);
                linearLayout.addView(dVar);
                linearLayout.addView(textView);
            } else {
                linearLayout = (LinearLayout) view;
                dVar = (com.igaworks.adpopcorn.activity.c.d) linearLayout.findViewById(0);
                textView = (TextView) linearLayout.findViewById(1);
            }
            com.igaworks.adpopcorn.cores.common.k.b(textView, this.f1514b.get(i), 13, Color.parseColor("#919191"), null, 0, 2, TextUtils.TruncateAt.END, false);
            if (c.this.w == i) {
                dVar.setChecked(true);
            } else {
                dVar.setChecked(false);
            }
            return linearLayout;
        }
    }

    public c(Context context, int i2, boolean z, com.igaworks.adpopcorn.cores.common.g gVar, boolean z2, ApOfferWallLayout apOfferWallLayout) {
        super(context, i2);
        this.v = -1;
        this.w = 0;
        this.x = 0;
        this.V = false;
        this.W = "";
        this.a = context;
        this.o = i2;
        this.d = z;
        this.f1512b = gVar;
        this.e = z2;
        this.V = false;
        this.X = apOfferWallLayout;
        this.Z = null;
    }

    public c(Context context, int i2, boolean z, com.igaworks.adpopcorn.cores.common.g gVar, boolean z2, com.igaworks.adpopcorn.activity.layout.e.b bVar) {
        super(context, i2);
        this.v = -1;
        this.w = 0;
        this.x = 0;
        this.V = false;
        this.W = "";
        this.a = context;
        this.o = i2;
        this.d = z;
        this.f1512b = gVar;
        this.e = z2;
        this.V = false;
        this.Y = bVar;
        this.X = null;
        this.Z = null;
    }

    public c(Context context, int i2, boolean z, com.igaworks.adpopcorn.cores.common.g gVar, boolean z2, String str) {
        super(context, i2);
        this.v = -1;
        this.w = 0;
        this.x = 0;
        this.V = false;
        this.W = "";
        this.a = context;
        this.o = i2;
        this.d = z;
        this.f1512b = gVar;
        this.e = z2;
        this.W = str;
        this.V = true;
        this.X = null;
        this.Z = null;
    }

    private void a() {
        try {
            this.z.setVisibility(8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (i2 == 0) {
            this.B.setVisibility(8);
            this.O.setVisibility(8);
            return;
        }
        if (i2 == 1) {
            this.B.setVisibility(0);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            this.E.setVisibility(0);
            this.G.setVisibility(8);
            this.O.setVisibility(0);
            this.R.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
            layoutParams2.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
            this.A.setLayoutParams(layoutParams2);
            layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, FacebookRequestErrorClassification.EC_INVALID_TOKEN));
        } else {
            if (i2 != 2) {
                if (i2 == 5) {
                    this.B.setVisibility(0);
                    this.C.setVisibility(8);
                    this.D.setVisibility(8);
                    this.E.setVisibility(8);
                    this.G.setVisibility(0);
                    this.M.setVisibility(0);
                    this.O.setVisibility(8);
                    this.R.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
                    layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 19);
                    this.A.setLayoutParams(layoutParams3);
                    this.M.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 143)));
                    this.M.setEnabled(false);
                    this.R.setVisibility(8);
                    i();
                    return;
                }
                return;
            }
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            this.G.setVisibility(8);
            this.O.setVisibility(0);
            this.R.setVisibility(0);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
            layoutParams4.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
            this.A.setLayoutParams(layoutParams4);
            layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 104));
        }
        this.M.setLayoutParams(layoutParams);
        this.M.setEnabled(true);
        this.M.setText("");
    }

    private boolean a(String str) {
        return Pattern.compile("^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$").matcher(str).matches();
    }

    private void b() {
        String strG;
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            a(false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MBridgeConstans.APP_KEY, this.T.b());
            jSONObject.put("adid", this.T.a());
            if (this.V) {
                String str2 = this.W;
                strG = (str2 == null || str2.length() <= 0) ? this.T.a() : this.W;
            } else {
                strG = this.T.g();
            }
            jSONObject.put("usn", strG);
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.p;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/cscampaign";
            } else {
                aVar = this.p;
                str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/cscampaign";
            }
            aVar.a(7, str, jSONObject, this);
        } catch (Exception unused) {
        }
    }

    private void c() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        this.c = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.c.setOrientation(1);
        this.c.addView(g());
        if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.ENABLE_CS_DIALOG_TOP_BAR_SHADOW)) {
            this.c.addView(f());
        }
        this.c.addView(e());
        setContentView(this.c);
        a(0);
    }

    private void d() {
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_ALL_LAYOUT_CORNER_ROUND_DP);
        this.f1512b = com.igaworks.adpopcorn.cores.common.g.a();
        if (this.e) {
            getWindow().setFlags(1024, 1024);
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR)});
        this.f = gradientDrawable;
        gradientDrawable.setShape(0);
        this.f.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_CORNER_ROUND_DP)));
        this.f.setGradientType(0);
        this.f.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_LINE_COLOR));
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_BG_COLOR);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_STROKE_COLOR);
        int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_STROKE_DP);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC2, iC2});
        this.g = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.g.setGradientType(0);
        if (iC > 0) {
            this.g.setCornerRadius(iC);
        }
        this.g.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC4), iC3);
        int iC5 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_CORNER_ROUND_DP);
        int iC6 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_BG_COLOR);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC6, iC6});
        gradientDrawable3.setShape(0);
        float f2 = iC5;
        gradientDrawable3.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, f2));
        gradientDrawable3.setGradientType(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC6, iC6});
        gradientDrawable4.setShape(0);
        gradientDrawable4.setAlpha(204);
        gradientDrawable4.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, f2));
        gradientDrawable4.setGradientType(0);
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-14211752, -14211752});
        gradientDrawable5.setAlpha(WorkQueueKt.MASK);
        gradientDrawable5.setShape(0);
        gradientDrawable5.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 22.5f));
        gradientDrawable5.setGradientType(0);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.m = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable4);
        this.m.addState(new int[]{-16842910}, gradientDrawable5);
        this.m.addState(StateSet.WILD_CARD, gradientDrawable3);
        this.n = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{-16842910}, new int[0]}, new int[]{Color.parseColor("#ffffff"), Color.parseColor("#80ffffff"), Color.parseColor("#ffffff")});
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_BG_COLOR)});
        this.h = gradientDrawable6;
        gradientDrawable6.setShape(0);
        this.h.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        this.h.setGradientType(0);
        this.h.setStroke(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_STROKE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_STROKE_COLOR));
        GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_BG_COLOR)});
        this.j = gradientDrawable7;
        gradientDrawable7.setShape(0);
        this.j.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        this.j.setGradientType(0);
        this.j.setStroke(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_STROKE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_STROKE_COLOR));
        GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_BG_COLOR)});
        this.k = gradientDrawable8;
        gradientDrawable8.setShape(0);
        this.k.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        this.k.setGradientType(0);
        this.k.setStroke(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_STROKE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_STROKE_COLOR));
        GradientDrawable gradientDrawable9 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_BG_COLOR)});
        this.l = gradientDrawable9;
        gradientDrawable9.setShape(0);
        this.l.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        this.l.setGradientType(0);
        this.l.setStroke(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_STROKE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_STROKE_COLOR));
        GradientDrawable gradientDrawable10 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_BG_COLOR)});
        this.i = gradientDrawable10;
        gradientDrawable10.setShape(0);
        this.i.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        this.i.setGradientType(0);
        this.i.setStroke(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_STROKE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_STROKE_COLOR));
        this.T = com.igaworks.adpopcorn.a.d.a(this.a).e();
        this.p = new com.igaworks.adpopcorn.a.g.a(this.a);
        this.v = -1;
        this.w = 0;
        this.x = 0;
        this.r = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        this.s = arrayList;
        arrayList.add(this.f1512b.m0);
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.t = arrayList2;
        arrayList2.add(this.f1512b.M0);
        this.t.add(this.f1512b.N0);
        if (!this.V) {
            this.t.add(this.f1512b.O0);
        }
        ArrayList<String> arrayList3 = new ArrayList<>();
        this.u = arrayList3;
        arrayList3.add(this.f1512b.R0);
        this.u.add(this.f1512b.S0);
        this.u.add(this.f1512b.T0);
        this.u.add(this.f1512b.U0);
    }

    private FrameLayout e() {
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ScrollView scrollView = new ScrollView(this.a);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.setFillViewport(true);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_LR_PADDING);
        linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_TOP_PADDING)), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), 0);
        TextView textView = new TextView(this.a);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setGravity(3);
        textView.setIncludeFontPadding(false);
        com.igaworks.adpopcorn.cores.common.k.b(textView, this.f1512b.z0, 13, Color.parseColor("#181818"), null, 0, 1, TextUtils.TruncateAt.END, false);
        linearLayout.addView(textView);
        FrameLayout frameLayout2 = new FrameLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        frameLayout2.setLayoutParams(layoutParams);
        frameLayout2.setBackgroundDrawable(this.g);
        frameLayout2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), com.igaworks.adpopcorn.cores.common.d.a(this.a, 10));
        TextView textView2 = new TextView(this.a);
        textView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView2.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.b(textView2, this.f1512b.A0 + "\n" + this.f1512b.B0 + "\n" + this.f1512b.C0 + "\n" + this.f1512b.D0, 11, Color.parseColor("#919191"), null, 0, 0, TextUtils.TruncateAt.END, false);
        frameLayout2.addView(textView2);
        TextView textView3 = new TextView(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        textView3.setLayoutParams(layoutParams2);
        textView3.setGravity(85);
        com.igaworks.adpopcorn.cores.common.k.b(textView3, "...<u>" + this.f1512b.s1 + "</u>", 11, Color.parseColor("#919191"), null, 0, 0, TextUtils.TruncateAt.END, false);
        frameLayout2.addView(textView3);
        textView3.setOnClickListener(new i());
        linearLayout.addView(frameLayout2);
        this.A = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
        layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        this.A.setLayoutParams(layoutParams3);
        this.A.setOrientation(0);
        this.A.setBackgroundColor(-1);
        this.A.setGravity(17);
        this.A.setBackgroundDrawable(this.h);
        this.A.setOnClickListener(new j());
        this.N = new TextView(this.a);
        this.N.setLayoutParams(new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40), 1.0f));
        this.N.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.b(this.N, this.f1512b.M, 13, Color.parseColor("#919191"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.N.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), 0, 0, 0);
        this.A.addView(this.N);
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 11), com.igaworks.adpopcorn.cores.common.d.a(this.a, 6));
        layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 13);
        imageView.setLayoutParams(layoutParams4);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_down.png", imageView, false);
        imageView.setColorFilter(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_DROP_DOWN_ICON_COLOR), PorterDuff.Mode.MULTIPLY);
        this.A.addView(imageView);
        linearLayout.addView(this.A);
        this.B = new LinearLayout(this.a);
        this.B.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.B.setOrientation(1);
        this.O = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
        this.O.setLayoutParams(layoutParams5);
        this.O.setGravity(19);
        this.O.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        this.O.setIncludeFontPadding(false);
        String strReplaceAll = this.f1512b.E0;
        if (this.d) {
            strReplaceAll = strReplaceAll.replaceAll("\n", "");
        }
        com.igaworks.adpopcorn.cores.common.k.b(this.O, strReplaceAll, 13, Color.parseColor("#181818"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.B.addView(this.O);
        this.C = new LinearLayout(this.a);
        this.C.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40)));
        this.C.setOrientation(0);
        this.I = new EditText(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams6.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
        this.I.setLayoutParams(layoutParams6);
        this.I.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.I, "", 13, Color.parseColor("#919191"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.I.setHint(this.f1512b.F0 + this.f1512b.G0);
        this.I.setHintTextColor(Color.parseColor("#919191"));
        this.I.setBackgroundDrawable(this.j);
        this.I.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), 0, 0, 0);
        this.C.addView(this.I);
        this.B.addView(this.C);
        this.D = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
        layoutParams7.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        this.D.setLayoutParams(layoutParams7);
        this.D.setOrientation(0);
        this.J = new EditText(this.a);
        this.J.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.J.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.J, "", 13, Color.parseColor("#919191"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.J.setHint(this.f1512b.H0 + this.f1512b.G0);
        this.J.setHintTextColor(Color.parseColor("#919191"));
        this.J.setBackgroundDrawable(this.j);
        this.J.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), 0, 0, 0);
        this.J.setInputType(2);
        this.D.addView(this.J);
        this.B.addView(this.D);
        this.E = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
        layoutParams8.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        this.E.setLayoutParams(layoutParams8);
        this.E.setOrientation(0);
        this.K = new EditText(this.a);
        this.K.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.K.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.K, "", 13, Color.parseColor("#919191"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.K.setHint(this.f1512b.j + this.f1512b.G0);
        this.K.setHintTextColor(Color.parseColor("#919191"));
        this.K.setBackgroundDrawable(this.k);
        this.K.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), 0, 0, 0);
        this.E.addView(this.K);
        TextView textView4 = new TextView(this.a);
        textView4.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 22), -1));
        textView4.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.b(textView4, "@", 13, Color.parseColor("#181818"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.E.addView(textView4);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 140), com.igaworks.adpopcorn.cores.common.d.a(this.a, 40)));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setBackgroundDrawable(this.l);
        linearLayout2.setOnClickListener(new k());
        this.L = new EditText(this.a);
        this.L.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 99), com.igaworks.adpopcorn.cores.common.d.a(this.a, 39)));
        this.L.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.L, this.f1512b.R0, 13, Color.parseColor("#919191"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.L.setHint(this.f1512b.U0);
        this.L.setBackgroundColor(Color.parseColor("#00000000"));
        this.L.setHintTextColor(Color.parseColor("#919191"));
        this.L.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), 0, 0, 0);
        linearLayout2.addView(this.L);
        this.L.setEnabled(false);
        ImageView imageView2 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 11), com.igaworks.adpopcorn.cores.common.d.a(this.a, 6));
        layoutParams9.gravity = 17;
        layoutParams9.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        layoutParams9.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        imageView2.setLayoutParams(layoutParams9);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_down.png", imageView2, false);
        imageView2.setColorFilter(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CS_DIALOG_DROP_DOWN_ICON_COLOR)), PorterDuff.Mode.MULTIPLY);
        linearLayout2.addView(imageView2);
        this.E.addView(linearLayout2);
        this.B.addView(this.E);
        this.G = new ListView(this.a);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 96));
        layoutParams10.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 11);
        this.G.setLayoutParams(layoutParams10);
        o oVar = new o(this.a, this.t);
        this.H = oVar;
        this.G.setAdapter((ListAdapter) oVar);
        this.G.setDivider(new ColorDrawable(0));
        this.G.setDividerHeight(1);
        this.G.setSelector(new ColorDrawable(0));
        this.G.setOnItemClickListener(new l());
        this.B.addView(this.G);
        this.M = new EditText(this.a);
        this.M.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 104)));
        this.M.setGravity(3);
        com.igaworks.adpopcorn.cores.common.k.b(this.M, "", 13, Color.parseColor("#919191"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.M.setHint(this.f1512b.k + this.f1512b.G0);
        this.M.setHintTextColor(Color.parseColor("#919191"));
        this.M.setBackgroundDrawable(this.i);
        this.M.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), com.igaworks.adpopcorn.cores.common.d.a(this.a, 13), 0, 0);
        this.B.addView(this.M);
        this.P = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams11.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.P.setIncludeFontPadding(false);
        this.P.setLayoutParams(layoutParams11);
        this.P.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.b(this.P, this.f1512b.P, 11, Color.parseColor("#919191"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.B.addView(this.P);
        this.Q = new TextView(this.a);
        new LinearLayout.LayoutParams(-2, -2).bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.Q.setIncludeFontPadding(false);
        this.Q.setLayoutParams(layoutParams11);
        this.Q.setGravity(19);
        this.Q.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        com.igaworks.adpopcorn.cores.common.k.b(this.Q, this.f1512b.P1, 13, Color.parseColor("#8c8c8c"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.B.addView(this.Q);
        this.F = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams12.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 30);
        this.F.setGravity(19);
        this.F.setLayoutParams(layoutParams12);
        this.F.setOrientation(0);
        this.S = new com.igaworks.adpopcorn.activity.c.a(this.a);
        this.S.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 30), com.igaworks.adpopcorn.cores.common.d.a(this.a, 30)));
        this.S.setSelected(false);
        this.S.setOnClickListener(new m());
        TextView textView5 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams13.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        textView5.setLayoutParams(layoutParams13);
        textView5.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(textView5, this.f1512b.R1, 13, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.F.addView(this.S);
        this.F.addView(textView5);
        this.B.addView(this.F);
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_SIZE);
        this.R = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
        layoutParams14.gravity = 1;
        layoutParams14.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        this.R.setLayoutParams(layoutParams14);
        this.R.setGravity(17);
        this.R.setBackgroundDrawable(this.m);
        com.igaworks.adpopcorn.cores.common.k.b(this.R, this.f1512b.l, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.R.setOnClickListener(new n());
        this.R.setEnabled(false);
        this.R.setTextColor(this.n);
        this.B.addView(this.R);
        linearLayout.addView(this.B);
        scrollView.addView(linearLayout);
        frameLayout.addView(scrollView);
        this.z = new LinearLayout(this.a);
        this.z.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.z.setOrientation(0);
        this.z.setGravity(17);
        ProgressBar progressBar = new ProgressBar(this.a, null, R.attr.progressBarStyleLarge);
        progressBar.setLayoutParams(new ViewGroup.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), com.igaworks.adpopcorn.cores.common.d.a(this.a, 50)));
        this.z.addView(progressBar);
        frameLayout.addView(this.z);
        return frameLayout;
    }

    private View f() {
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

    /* JADX WARN: Failed to calculate best type for var: r2v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v12 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v12 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v12 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v12 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v14 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v14 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v14 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v14 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v15 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v15 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v8 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v8 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v8 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v8 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v9 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v9 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v9 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v9 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r6v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v9 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r6v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v9 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r6v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v9 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r6v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v9 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r7v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v14 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r7v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v14 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r7v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v14 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r7v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v14 ??, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v14 android.widget.RelativeLayout$LayoutParams, new type: android.widget.RelativeLayout$LayoutParams
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    private RelativeLayout g() {
        int iC;
        TextUtils.TruncateAt truncateAt;
        String str;
        int iC2;
        Typeface typeface;
        int i2;
        int i3;
        boolean z;
        int i4;
        RelativeLayout.LayoutParams layoutParams;
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_MODE);
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_SIZE);
        APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_SIZE);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, iC3)));
        relativeLayout.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR));
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight()));
        layoutParams2.addRule(15);
        if (zB) {
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth() + 22);
        } else {
            layoutParams2.addRule(9);
            layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        }
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setBackgroundDrawable(this.f);
        com.igaworks.adpopcorn.cores.common.g gVar = this.f1512b;
        if (gVar == null || gVar.w0.length() <= 10) {
            String str2 = this.f1512b.w0;
            iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_SIZE_DP);
            int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_COLOR);
            truncateAt = TextUtils.TruncateAt.END;
            str = str2;
            iC2 = iC4;
            typeface = null;
            i2 = 0;
            i3 = 1;
            z = false;
        } else {
            String str3 = this.f1512b.w0;
            iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_SIZE_DP) - 2;
            str = str3;
            iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_COLOR);
            typeface = null;
            i2 = 0;
            i3 = 1;
            truncateAt = TextUtils.TruncateAt.END;
            z = false;
        }
        com.igaworks.adpopcorn.cores.common.k.b(textView, str, iC, iC2, typeface, i2, i3, truncateAt, z);
        relativeLayout.addView(textView);
        textView.setOnClickListener(new f());
        TextView textView2 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        if (zB) {
            layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
            i4 = 9;
        } else {
            i4 = 14;
        }
        layoutParams3.addRule(i4);
        layoutParams3.addRule(r14);
        textView2.setLayoutParams(layoutParams3);
        com.igaworks.adpopcorn.cores.common.k.b(textView2, this.f1512b.J, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD));
        textView2.setGravity(17);
        relativeLayout.addView(textView2);
        ImageView imageView = new ImageView(this.a);
        if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_ID) == -100) {
            ViewGroup.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_close.png", imageView, false);
            layoutParams = layoutParams4;
        } else {
            ViewGroup.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_ID));
            layoutParams = layoutParams5;
        }
        imageView.setOnClickListener(new g());
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        layoutParams.addRule(r14);
        layoutParams.addRule(11);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC3));
        layoutParams6.addRule(r14);
        layoutParams6.addRule(11);
        linearLayout.setLayoutParams(layoutParams6);
        linearLayout.setOnClickListener(new h());
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        EditText editText;
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        int i2 = this.v;
        if (i2 == -1) {
            new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1512b.N, 1, 17);
            return;
        }
        try {
            int iC = this.r.get(i2).c();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.r.get(this.v).a());
            if (iC == 2) {
                EditText editText2 = this.I;
                if (editText2 == null || editText2.getText() == null || this.I.getText().toString().length() <= 0) {
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1512b.O, 1, 17);
                    return;
                }
                jSONObject.put("customer_name", this.I.getText().toString());
                EditText editText3 = this.J;
                if (editText3 == null || editText3.getText() == null || this.J.getText().toString().length() <= 0) {
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1512b.O, 1, 17);
                    return;
                } else {
                    if (this.J.getText().toString().length() < 10) {
                        new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1512b.R, 1, 17);
                        return;
                    }
                    jSONObject.put("customer_phone", this.J.getText().toString());
                }
            }
            EditText editText4 = this.K;
            if (editText4 == null || editText4.getText() == null || this.K.getText().toString().length() <= 0 || (editText = this.L) == null || editText.getText() == null || this.L.getText().toString().length() <= 0) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1512b.O, 1, 17);
                return;
            }
            String strTrim = this.K.getText().toString().trim();
            String strTrim2 = this.L.getText().toString().trim();
            if (!a(strTrim + "@" + strTrim2)) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1512b.m, 1, 17);
                return;
            }
            jSONObject.put("customer_email", strTrim + "@" + strTrim2);
            EditText editText5 = this.M;
            if (editText5 == null || editText5.getText() == null || this.M.getText().toString().length() <= 0) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1512b.n, 1, 17);
                return;
            }
            jSONObject.put("message", this.M.getText().toString());
            a(false);
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.p;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/addcs";
            } else {
                aVar = this.p;
                str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/addcs";
            }
            aVar.a(8, str, jSONObject, this);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        EditText editText;
        String str;
        int i2 = this.w;
        if (i2 == 0) {
            editText = this.M;
            str = this.f1512b.P0;
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.M.setText(this.f1512b.n1);
                    com.igaworks.adpopcorn.activity.b.d.a aVar = this.U;
                    if (aVar != null && aVar.isShowing()) {
                        this.U.dismiss();
                        this.U = null;
                    }
                    Context context = this.a;
                    int i3 = this.o;
                    String str2 = this.f1512b.m1;
                    String str3 = this.f1512b.n1 + this.f1512b.o1;
                    com.igaworks.adpopcorn.cores.common.g gVar = this.f1512b;
                    com.igaworks.adpopcorn.activity.b.d.a aVar2 = new com.igaworks.adpopcorn.activity.b.d.a(context, i3, str2, str3, -1, gVar.c0, new a(), gVar.b0, new b(), this.d);
                    this.U = aVar2;
                    aVar2.setCancelable(false);
                    this.U.show();
                    return;
                }
                return;
            }
            editText = this.M;
            str = this.f1512b.Q0;
        }
        editText.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            com.igaworks.adpopcorn.activity.b.d.DialogC0410d dialogC0410d = this.q;
            if (dialogC0410d != null && dialogC0410d.isShowing()) {
                this.q.dismiss();
            }
            ArrayList<String> arrayList = this.s;
            if (arrayList != null && arrayList.size() == 0) {
                this.s.add(this.f1512b.m0);
            }
            ArrayList<String> arrayList2 = this.s;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.DialogC0410d dialogC0410d2 = new com.igaworks.adpopcorn.activity.b.d.DialogC0410d(context, com.igaworks.adpopcorn.activity.b.d.a(context), this.s, this.v, this.d, new C0406c());
            this.q = dialogC0410d2;
            dialogC0410d2.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            com.igaworks.adpopcorn.activity.b.d.DialogC0410d dialogC0410d = this.q;
            if (dialogC0410d != null && dialogC0410d.isShowing()) {
                this.q.dismiss();
            }
            ArrayList<String> arrayList = this.u;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.DialogC0410d dialogC0410d2 = new com.igaworks.adpopcorn.activity.b.d.DialogC0410d(context, com.igaworks.adpopcorn.activity.b.d.a(context), this.u, this.x, this.d, new d());
            this.q = dialogC0410d2;
            dialogC0410d2.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z) {
        try {
            this.z.setVisibility(0);
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
        d();
        c();
        b();
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        com.igaworks.adpopcorn.activity.layout.e.b bVar;
        com.igaworks.adpopcorn.activity.layout.f.b bVar2;
        try {
            a();
            if (i2 != 7) {
                if (i2 == 8) {
                    a();
                    if (fVar != null && fVar.a().length() > 0) {
                        try {
                            if (new JSONObject(fVar.a()).getBoolean("Result")) {
                                Context context = this.a;
                                int i3 = this.o;
                                com.igaworks.adpopcorn.cores.common.g gVar = this.f1512b;
                                com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, i3, gVar.o, gVar.Q, -1, gVar.H, new e(), this.d, true);
                                this.U = aVar;
                                aVar.setCancelable(false);
                                this.U.show();
                                return;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1512b.e, 1, 17);
                    return;
                }
                return;
            }
            if (fVar == null || fVar.a().length() <= 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(fVar.a());
                if (jSONObject.has("CSCampaigns")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("CSCampaigns");
                    ArrayList<com.igaworks.adpopcorn.cores.model.b> arrayList = this.r;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    ArrayList<String> arrayList2 = this.s;
                    if (arrayList2 != null && arrayList2.size() > 1) {
                        this.s.clear();
                    }
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                        String string = jSONObject2.getString("Auth");
                        String string2 = jSONObject2.getString("CSSource");
                        String string3 = jSONObject2.getString("Title");
                        ApOfferWallLayout apOfferWallLayout = this.X;
                        if ((apOfferWallLayout != null && apOfferWallLayout.getOfferwallType() == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle")) || (((bVar = this.Y) != null && bVar.getOfferwallType() == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle")) || ((bVar2 = this.Z) != null && bVar2.getOfferwallType() == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle")))) {
                            string3 = jSONObject2.getString("FeedTitle");
                        }
                        int i5 = jSONObject2.getInt("CSTypeCode");
                        com.igaworks.adpopcorn.cores.model.b bVar3 = new com.igaworks.adpopcorn.cores.model.b();
                        bVar3.a(string);
                        bVar3.b(string2);
                        bVar3.c(string3);
                        bVar3.a(i5);
                        this.r.add(0, bVar3);
                        this.s.add(0, string3);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        com.igaworks.adpopcorn.activity.b.f fVar = this.y;
        if (fVar == null || !fVar.isShowing()) {
            return;
        }
        this.y.dismiss();
        this.y = null;
    }
}
