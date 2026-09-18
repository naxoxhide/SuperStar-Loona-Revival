package com.igaworks.adpopcorn.activity.b.l;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.igaworks.adpopcorn.R;
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
public class b extends Dialog implements com.igaworks.adpopcorn.a.g.a.d {
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
    private com.igaworks.adpopcorn.activity.layout.g.b Y;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.igaworks.adpopcorn.cores.common.g f1561b;
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
    private GradientDrawable m;
    private GradientDrawable n;
    private int o;
    private com.igaworks.adpopcorn.a.g.a p;
    private com.igaworks.adpopcorn.activity.b.d.g q;
    private ArrayList<com.igaworks.adpopcorn.cores.model.b> r;
    private ArrayList<String> s;
    private ArrayList<String> t;
    private ArrayList<String> u;
    private int v;
    private int w;
    private int x;
    private com.igaworks.adpopcorn.activity.b.l.c y;
    private LinearLayout z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.U == null || !b.this.U.isShowing()) {
                return;
            }
            b.this.U.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.l.b$b, reason: collision with other inner class name */
    class ViewOnClickListenerC0422b implements View.OnClickListener {

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.l.b$b$a */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.igaworks.adpopcorn.a.b.a().b(b.this.a, "adpopcorn_parameter", "check_user_agreement", false);
                if (b.this.U != null) {
                    b.this.U.dismiss();
                }
                b.this.dismiss();
                if (b.this.X != null) {
                    b.this.X.exitOfferwall();
                } else if (b.this.Y != null) {
                    b.this.Y.i();
                }
            }
        }

        ViewOnClickListenerC0422b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (b.this.U != null && b.this.U.isShowing()) {
                    b.this.U.dismiss();
                }
                b.this.U = new com.igaworks.adpopcorn.activity.b.d.a(b.this.a, b.this.o, b.this.f1561b.m1, b.this.f1561b.p1, -1, b.this.f1561b.H, new a(), b.this.d, true);
                b.this.U.setCancelable(false);
                b.this.U.show();
            } catch (Exception unused) {
            }
        }
    }

    class c implements AdapterView.OnItemClickListener {

        class a implements View.OnClickListener {
            final /* synthetic */ int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f1562b;

            a(int i, String str) {
                this.a = i;
                this.f1562b = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.U != null) {
                    b.this.U.dismiss();
                }
                b.this.dismiss();
                int i = this.a;
                if (i == 3) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(this.f1562b));
                        b.this.a.startActivity(intent);
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
                        intent2.setData(Uri.parse(MailTo.MAILTO_SCHEME + this.f1562b));
                        intent2.putExtra("android.intent.extra.SUBJECT", b.this.f1561b.L);
                        b.this.a.startActivity(intent2);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int i2;
            b bVar;
            if (i == -1) {
                bVar = b.this;
                i2 = 0;
            } else {
                b.this.v = i;
                if (b.this.N != null) {
                    b.this.N.setText((CharSequence) b.this.s.get(i));
                }
                i2 = 1;
                if (i != b.this.s.size() - 1) {
                    int iC = ((com.igaworks.adpopcorn.cores.model.b) b.this.r.get(i)).c();
                    String strB = ((com.igaworks.adpopcorn.cores.model.b) b.this.r.get(i)).b();
                    if (iC == 1) {
                        bVar = b.this;
                    } else if (iC == 2) {
                        b.this.a(2);
                    } else if (iC == 3 || iC == 4) {
                        if (b.this.U != null && b.this.U.isShowing()) {
                            b.this.U.dismiss();
                        }
                        b.this.U = new com.igaworks.adpopcorn.activity.b.d.a(b.this.a, b.this.o, b.this.f1561b.Y, b.this.f1561b.V0, -1, b.this.f1561b.H, new a(iC, strB), b.this.d, true);
                        b.this.U.setCancelable(true);
                        b.this.U.show();
                    }
                    b.this.q.dismiss();
                }
                bVar = b.this;
                i2 = 5;
            }
            bVar.a(i2);
            b.this.q.dismiss();
        }
    }

    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b.this.x = i;
            if (b.this.L != null) {
                if (b.this.x == b.this.u.size() - 1) {
                    b.this.L.setText("");
                    b.this.L.setHint(b.this.f1561b.U0);
                    b.this.L.setEnabled(true);
                } else {
                    b.this.L.setText((CharSequence) b.this.u.get(i));
                    b.this.L.setEnabled(false);
                }
            }
            b.this.q.dismiss();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.U != null) {
                b.this.U.dismiss();
            }
            b.this.dismiss();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.o == 16973841) {
                b.this.e = true;
            }
            b.this.y = new com.igaworks.adpopcorn.activity.b.l.c(b.this.a, b.this.o, b.this.d, b.this.f1561b, b.this.e, b.this.Y != null ? b.this.Y.getOfferwallType() : 0);
            b.this.y.show();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022";
            try {
                String strA = com.igaworks.adpopcorn.a.b.a().a(b.this.a, "adpopcorn_sdk_flag", "no_ad_landingurl", "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022");
                if (strA != null && strA.length() > 0) {
                    str = strA;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                b.this.a.startActivity(intent);
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
            b.this.i();
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.j();
        }
    }

    class l implements AdapterView.OnItemClickListener {
        l() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b.this.w = i;
            if (b.this.H != null) {
                b.this.H.notifyDataSetInvalidated();
            }
            b.this.h();
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            float f;
            if (b.this.S == null || b.this.R == null) {
                return;
            }
            b.this.S.setSelected(!b.this.S.isSelected());
            if (b.this.S.isSelected()) {
                if (Build.VERSION.SDK_INT < 11) {
                    return;
                }
                textView = b.this.R;
                f = 1.0f;
            } else {
                if (Build.VERSION.SDK_INT < 11) {
                    return;
                }
                textView = b.this.R;
                f = 0.3f;
            }
            textView.setAlpha(f);
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.v != b.this.s.size() - 1) {
                b.this.g();
            }
        }
    }

    private class o extends BaseAdapter {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f1563b;

        public o(Context context, List<String> list) {
            this.a = context;
            this.f1563b = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> list = this.f1563b;
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
            com.igaworks.adpopcorn.activity.c.k.b bVar;
            TextView textView;
            if (view == null) {
                linearLayout = new LinearLayout(this.a);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 30)));
                linearLayout.setGravity(16);
                bVar = new com.igaworks.adpopcorn.activity.c.k.b(this.a);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16));
                layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
                layoutParams.gravity = 16;
                bVar.setLayoutParams(layoutParams);
                bVar.setId(0);
                textView = new TextView(this.a);
                textView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 298), -1));
                textView.setGravity(16);
                textView.setIncludeFontPadding(false);
                textView.setId(1);
                linearLayout.addView(bVar);
                linearLayout.addView(textView);
            } else {
                linearLayout = (LinearLayout) view;
                bVar = (com.igaworks.adpopcorn.activity.c.k.b) linearLayout.findViewById(0);
                textView = (TextView) linearLayout.findViewById(1);
            }
            com.igaworks.adpopcorn.cores.common.k.b(textView, this.f1563b.get(i), 13, Color.parseColor("#919191"), null, 0, 2, TextUtils.TruncateAt.END, false);
            if (b.this.w == i) {
                bVar.setChecked(true);
            } else {
                bVar.setChecked(false);
            }
            return linearLayout;
        }
    }

    public b(Context context, int i2, boolean z, com.igaworks.adpopcorn.cores.common.g gVar, boolean z2, com.igaworks.adpopcorn.activity.layout.g.b bVar) {
        super(context, i2);
        this.v = -1;
        this.w = 0;
        this.x = 0;
        this.V = false;
        this.W = "";
        this.a = context;
        this.o = i2;
        this.d = z;
        this.f1561b = gVar;
        this.e = z2;
        this.V = false;
        this.X = null;
        this.Y = bVar;
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
            this.F.setVisibility(0);
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
                    this.F.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
                    layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 19);
                    this.A.setLayoutParams(layoutParams3);
                    this.M.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 143)));
                    this.M.setEnabled(false);
                    this.R.setVisibility(8);
                    h();
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
            this.F.setVisibility(0);
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
        this.c.addView(f());
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 0.5f)));
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(Color.parseColor("#d2d2d2"));
        this.c.addView(linearLayout2);
        this.c.addView(e());
        setContentView(this.c);
        a(0);
    }

    private void d() {
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_ALL_LAYOUT_CORNER_ROUND_DP);
        this.f1561b = com.igaworks.adpopcorn.cores.common.g.a();
        if (this.e) {
            getWindow().setFlags(1024, 1024);
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR)});
        this.f = gradientDrawable;
        gradientDrawable.setShape(0);
        this.f.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_CORNER_ROUND_DP)));
        this.f.setGradientType(0);
        this.f.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_LINE_COLOR));
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-12231749, -10280571});
        this.h = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.h.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
        this.h.setGradientType(0);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_BG_COLOR);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_STROKE_COLOR);
        int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_STROKE_DP);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC2, iC2});
        this.g = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.g.setGradientType(0);
        if (iC > 0) {
            this.g.setCornerRadius(iC);
        }
        this.g.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC4), iC3);
        int iC5 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_CORNER_ROUND_DP);
        int iC6 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_BG_COLOR);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC6, iC6});
        gradientDrawable4.setShape(0);
        float f2 = iC5;
        gradientDrawable4.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, f2));
        gradientDrawable4.setGradientType(0);
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC6, iC6});
        gradientDrawable5.setShape(0);
        gradientDrawable5.setAlpha(204);
        gradientDrawable5.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, f2));
        gradientDrawable5.setGradientType(0);
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-14211752, -14211752});
        gradientDrawable6.setAlpha(WorkQueueKt.MASK);
        gradientDrawable6.setShape(0);
        gradientDrawable6.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 22.5f));
        gradientDrawable6.setGradientType(0);
        GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_BG_COLOR)});
        this.i = gradientDrawable7;
        gradientDrawable7.setShape(0);
        this.i.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        this.i.setGradientType(0);
        this.i.setStroke(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_STROKE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_STROKE_COLOR));
        GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.n = gradientDrawable8;
        gradientDrawable8.setShape(0);
        this.n.setGradientType(0);
        this.n.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10));
        GradientDrawable gradientDrawable9 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_BG_COLOR)});
        this.k = gradientDrawable9;
        gradientDrawable9.setShape(0);
        this.k.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        this.k.setGradientType(0);
        this.k.setStroke(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_STROKE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_STROKE_COLOR));
        GradientDrawable gradientDrawable10 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_BG_COLOR)});
        this.l = gradientDrawable10;
        gradientDrawable10.setShape(0);
        this.l.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        this.l.setGradientType(0);
        this.l.setStroke(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_STROKE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_STROKE_COLOR));
        GradientDrawable gradientDrawable11 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_BG_COLOR)});
        this.m = gradientDrawable11;
        gradientDrawable11.setShape(0);
        this.m.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        this.m.setGradientType(0);
        this.m.setStroke(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_STROKE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_STROKE_COLOR));
        GradientDrawable gradientDrawable12 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_BG_COLOR)});
        this.j = gradientDrawable12;
        gradientDrawable12.setShape(0);
        this.j.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        this.j.setGradientType(0);
        this.j.setStroke(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_STROKE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_STROKE_COLOR));
        this.T = com.igaworks.adpopcorn.a.d.a(this.a).e();
        this.p = new com.igaworks.adpopcorn.a.g.a(this.a);
        this.v = -1;
        this.w = 0;
        this.x = 0;
        this.r = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        this.s = arrayList;
        arrayList.add(this.f1561b.m0);
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.t = arrayList2;
        arrayList2.add(this.f1561b.M0);
        this.t.add(this.f1561b.N0);
        if (!this.V) {
            this.t.add(this.f1561b.O0);
        }
        ArrayList<String> arrayList3 = new ArrayList<>();
        this.u = arrayList3;
        arrayList3.add(this.f1561b.R0);
        this.u.add(this.f1561b.S0);
        this.u.add(this.f1561b.T0);
        this.u.add(this.f1561b.U0);
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
        linearLayout.setBackgroundColor(Color.parseColor("#fcfcfc"));
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_LR_PADDING);
        linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_TOP_PADDING)), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), 0);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setIncludeFontPadding(false);
        com.igaworks.adpopcorn.cores.common.k.b(textView, this.f1561b.u2, 15, Color.parseColor("#4e4e4e"), null, 0, 1, TextUtils.TruncateAt.END, true);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this.a);
        textView2.setLayoutParams(layoutParams);
        textView2.setGravity(3);
        textView2.setIncludeFontPadding(false);
        com.igaworks.adpopcorn.cores.common.k.b(textView2, this.f1561b.v2, 15, Color.parseColor("#4e4e4e"), null, 0, 1, TextUtils.TruncateAt.END, false);
        linearLayout.addView(textView2);
        FrameLayout frameLayout2 = new FrameLayout(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 124));
        layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams2.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout2.setBackgroundDrawable(this.g);
        frameLayout2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), 0, 0);
        TextView textView3 = new TextView(this.a);
        textView3.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView3.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.b(textView3, this.f1561b.A0 + "\n" + this.f1561b.B0 + "\n" + this.f1561b.C0 + "\n" + this.f1561b.D0, 11, Color.parseColor("#919191"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView3.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8), 1.0f);
        textView3.setPadding(0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0);
        frameLayout2.addView(textView3);
        TextView textView4 = new TextView(this.a);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 60), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
        layoutParams3.gravity = 85;
        layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 19);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        textView4.setLayoutParams(layoutParams3);
        textView4.setGravity(17);
        textView4.setBackgroundDrawable(this.n);
        com.igaworks.adpopcorn.cores.common.k.b(textView4, this.f1561b.s1, 11, Color.parseColor("#424242"), null, 0, 0, TextUtils.TruncateAt.END, false);
        frameLayout2.addView(textView4);
        textView4.setOnClickListener(new i());
        linearLayout.addView(frameLayout2);
        this.A = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 49));
        layoutParams4.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        this.A.setLayoutParams(layoutParams4);
        this.A.setOrientation(0);
        this.A.setBackgroundColor(-1);
        this.A.setGravity(17);
        this.A.setBackgroundDrawable(this.i);
        this.A.setOnClickListener(new j());
        this.N = new TextView(this.a);
        this.N.setLayoutParams(new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 49), 1.0f));
        this.N.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.b(this.N, this.f1561b.M, 12, Color.parseColor("#2a2a2a"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.N.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, 0, 0);
        this.A.addView(this.N);
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 9), com.igaworks.adpopcorn.cores.common.d.a(this.a, 7));
        layoutParams5.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        imageView.setLayoutParams(layoutParams5);
        imageView.setImageResource(R.drawable.tpmn_indicator);
        this.A.addView(imageView);
        linearLayout.addView(this.A);
        this.B = new LinearLayout(this.a);
        this.B.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.B.setOrientation(1);
        this.O = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
        this.O.setLayoutParams(layoutParams6);
        this.O.setGravity(19);
        this.O.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        this.O.setIncludeFontPadding(false);
        String strReplaceAll = this.f1561b.E0;
        if (this.d) {
            strReplaceAll = strReplaceAll.replaceAll("\n", "");
        }
        com.igaworks.adpopcorn.cores.common.k.b(this.O, strReplaceAll, 13, Color.parseColor("#181818"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.B.addView(this.O);
        this.C = new LinearLayout(this.a);
        this.C.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 49)));
        this.C.setOrientation(0);
        this.I = new EditText(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams7.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
        this.I.setLayoutParams(layoutParams7);
        this.I.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.I, "", 12, Color.parseColor("#2a2a2a"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.I.setHint(this.f1561b.F0 + this.f1561b.G0);
        this.I.setHintTextColor(Color.parseColor("#919191"));
        this.I.setBackgroundDrawable(this.k);
        this.I.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, 0, 0);
        this.C.addView(this.I);
        this.B.addView(this.C);
        this.D = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 49));
        layoutParams8.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        this.D.setLayoutParams(layoutParams8);
        this.D.setOrientation(0);
        this.J = new EditText(this.a);
        this.J.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.J.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.J, "", 12, Color.parseColor("#2a2a2a"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.J.setHint(this.f1561b.H0 + this.f1561b.G0);
        this.J.setHintTextColor(Color.parseColor("#919191"));
        this.J.setBackgroundDrawable(this.k);
        this.J.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, 0, 0);
        this.J.setInputType(2);
        this.D.addView(this.J);
        this.B.addView(this.D);
        this.E = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 49));
        layoutParams9.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        this.E.setLayoutParams(layoutParams9);
        this.E.setOrientation(0);
        this.K = new EditText(this.a);
        this.K.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.K.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.K, "", 12, Color.parseColor("#2a2a2a"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.K.setHint(this.f1561b.j + this.f1561b.G0);
        this.K.setHintTextColor(Color.parseColor("#919191"));
        this.K.setBackgroundDrawable(this.l);
        this.K.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, 0, 0);
        this.E.addView(this.K);
        TextView textView5 = new TextView(this.a);
        textView5.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 22), -1));
        textView5.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.b(textView5, "@", 12, Color.parseColor("#2a2a2a"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.E.addView(textView5);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 140), com.igaworks.adpopcorn.cores.common.d.a(this.a, 49)));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setBackgroundDrawable(this.m);
        linearLayout2.setOnClickListener(new k());
        this.L = new EditText(this.a);
        this.L.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 99), com.igaworks.adpopcorn.cores.common.d.a(this.a, 49)));
        this.L.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.L, this.f1561b.R0, 12, Color.parseColor("#2a2a2a"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.L.setHint(this.f1561b.U0);
        this.L.setBackgroundColor(Color.parseColor("#00000000"));
        this.L.setHintTextColor(Color.parseColor("#919191"));
        this.L.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, 0, 0);
        linearLayout2.addView(this.L);
        this.L.setEnabled(false);
        ImageView imageView2 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 11), com.igaworks.adpopcorn.cores.common.d.a(this.a, 6));
        layoutParams10.gravity = 17;
        layoutParams10.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        layoutParams10.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        imageView2.setLayoutParams(layoutParams10);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setImageResource(R.drawable.tpmn_indicator);
        linearLayout2.addView(imageView2);
        this.E.addView(linearLayout2);
        this.B.addView(this.E);
        this.G = new ListView(this.a);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 96));
        layoutParams11.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 11);
        this.G.setLayoutParams(layoutParams11);
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
        com.igaworks.adpopcorn.cores.common.k.b(this.M, "", 12, Color.parseColor("#2a2a2a"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.M.setHint(this.f1561b.k + this.f1561b.G0);
        this.M.setHintTextColor(Color.parseColor("#919191"));
        this.M.setBackgroundDrawable(this.j);
        this.M.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 13), 0, 0);
        this.B.addView(this.M);
        this.P = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams12.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.P.setIncludeFontPadding(false);
        this.P.setLayoutParams(layoutParams12);
        this.P.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.b(this.P, this.f1561b.P, 12, Color.parseColor("#2a2a2a"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.B.addView(this.P);
        this.Q = new TextView(this.a);
        new LinearLayout.LayoutParams(-2, -2).bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.Q.setIncludeFontPadding(false);
        this.Q.setLayoutParams(layoutParams12);
        this.Q.setGravity(19);
        this.Q.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        com.igaworks.adpopcorn.cores.common.k.b(this.Q, this.f1561b.P1, 12, Color.parseColor("#2a2a2a"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.B.addView(this.Q);
        this.F = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams13.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 30);
        this.F.setGravity(19);
        this.F.setLayoutParams(layoutParams13);
        this.F.setOrientation(0);
        this.S = new com.igaworks.adpopcorn.activity.c.a(this.a);
        this.S.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 21), com.igaworks.adpopcorn.cores.common.d.a(this.a, 21)));
        this.S.setSelected(false);
        this.S.setOnClickListener(new m());
        TextView textView6 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams14.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        textView6.setLayoutParams(layoutParams14);
        textView6.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(textView6, this.f1561b.R1, 12, Color.parseColor("#2a2a2a"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.F.addView(this.S);
        this.F.addView(textView6);
        this.B.addView(this.F);
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_SIZE);
        this.R = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
        layoutParams15.gravity = 1;
        layoutParams15.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        this.R.setLayoutParams(layoutParams15);
        this.R.setGravity(17);
        this.R.setBackgroundDrawable(this.h);
        com.igaworks.adpopcorn.cores.common.k.b(this.R, this.f1561b.l, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.R.setOnClickListener(new n());
        if (Build.VERSION.SDK_INT >= 11) {
            this.R.setAlpha(0.3f);
        }
        this.B.addView(this.R);
        linearLayout.addView(this.B);
        scrollView.addView(linearLayout);
        frameLayout.addView(scrollView);
        this.z = new LinearLayout(this.a);
        this.z.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.z.setOrientation(0);
        this.z.setGravity(17);
        ProgressBar progressBar = new ProgressBar(this.a, null, android.R.attr.progressBarStyleLarge);
        progressBar.setLayoutParams(new ViewGroup.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), com.igaworks.adpopcorn.cores.common.d.a(this.a, 50)));
        this.z.addView(progressBar);
        frameLayout.addView(this.z);
        return frameLayout;
    }

    private RelativeLayout f() {
        String str;
        int iC;
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_SIZE);
        APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_SIZE);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 65)));
        relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight()));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        textView.setBackgroundDrawable(this.f);
        com.igaworks.adpopcorn.cores.common.g gVar = this.f1561b;
        if (gVar == null || gVar.K.length() <= 10) {
            str = this.f1561b.K;
            iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_SIZE_DP);
        } else {
            str = this.f1561b.K;
            iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_SIZE_DP) - 2;
        }
        com.igaworks.adpopcorn.cores.common.k.b(textView, str, iC, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
        relativeLayout.addView(textView);
        textView.setOnClickListener(new f());
        TextView textView2 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        textView2.setLayoutParams(layoutParams2);
        com.igaworks.adpopcorn.cores.common.k.b(textView2, this.f1561b.L, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD));
        textView2.setGravity(17);
        relativeLayout.addView(textView2);
        ImageView imageView = new ImageView(this.a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.tpmn_back);
        imageView.setOnClickListener(new g());
        layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        layoutParams3.addRule(15);
        layoutParams3.addRule(9);
        imageView.setLayoutParams(layoutParams3);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, 65));
        layoutParams4.addRule(15);
        layoutParams4.addRule(9);
        linearLayout.setLayoutParams(layoutParams4);
        linearLayout.setOnClickListener(new h());
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        EditText editText;
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        int i2 = this.v;
        if (i2 == -1) {
            new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1561b.N, 1, 17);
            return;
        }
        try {
            int iC = this.r.get(i2).c();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.r.get(this.v).a());
            if (iC == 2) {
                EditText editText2 = this.I;
                if (editText2 == null || editText2.getText() == null || this.I.getText().toString().length() <= 0) {
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1561b.O, 1, 17);
                    return;
                }
                jSONObject.put("customer_name", this.I.getText().toString());
                EditText editText3 = this.J;
                if (editText3 == null || editText3.getText() == null || this.J.getText().toString().length() <= 0) {
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1561b.O, 1, 17);
                    return;
                } else {
                    if (this.J.getText().toString().length() < 10) {
                        new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1561b.R, 1, 17);
                        return;
                    }
                    jSONObject.put("customer_phone", this.J.getText().toString());
                }
            }
            EditText editText4 = this.K;
            if (editText4 == null || editText4.getText() == null || this.K.getText().toString().length() <= 0 || (editText = this.L) == null || editText.getText() == null || this.L.getText().toString().length() <= 0) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1561b.O, 1, 17);
                return;
            }
            String strTrim = this.K.getText().toString().trim();
            String strTrim2 = this.L.getText().toString().trim();
            if (!a(strTrim + "@" + strTrim2)) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1561b.m, 1, 17);
                return;
            }
            jSONObject.put("customer_email", strTrim + "@" + strTrim2);
            EditText editText5 = this.M;
            if (editText5 == null || editText5.getText() == null || this.M.getText().toString().length() <= 0) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1561b.n, 1, 17);
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
    public void h() {
        EditText editText;
        String str;
        int i2 = this.w;
        if (i2 == 0) {
            editText = this.M;
            str = this.f1561b.P0;
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.M.setText(this.f1561b.n1);
                    com.igaworks.adpopcorn.activity.b.d.a aVar = this.U;
                    if (aVar != null && aVar.isShowing()) {
                        this.U.dismiss();
                        this.U = null;
                    }
                    Context context = this.a;
                    int i3 = this.o;
                    String str2 = this.f1561b.m1;
                    String str3 = this.f1561b.n1 + this.f1561b.o1;
                    com.igaworks.adpopcorn.cores.common.g gVar = this.f1561b;
                    com.igaworks.adpopcorn.activity.b.d.a aVar2 = new com.igaworks.adpopcorn.activity.b.d.a(context, i3, str2, str3, -1, gVar.c0, new a(), gVar.b0, new ViewOnClickListenerC0422b(), this.d);
                    this.U = aVar2;
                    aVar2.setCancelable(false);
                    this.U.show();
                    return;
                }
                return;
            }
            editText = this.M;
            str = this.f1561b.Q0;
        }
        editText.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            com.igaworks.adpopcorn.activity.b.d.g gVar = this.q;
            if (gVar != null && gVar.isShowing()) {
                this.q.dismiss();
            }
            ArrayList<String> arrayList = this.s;
            if (arrayList != null && arrayList.size() == 0) {
                this.s.add(this.f1561b.m0);
            }
            ArrayList<String> arrayList2 = this.s;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.g gVar2 = new com.igaworks.adpopcorn.activity.b.d.g(context, com.igaworks.adpopcorn.activity.b.d.a(context), this.s, this.v, new c());
            this.q = gVar2;
            gVar2.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            com.igaworks.adpopcorn.activity.b.d.g gVar = this.q;
            if (gVar != null && gVar.isShowing()) {
                this.q.dismiss();
            }
            ArrayList<String> arrayList = this.u;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.g gVar2 = new com.igaworks.adpopcorn.activity.b.d.g(context, com.igaworks.adpopcorn.activity.b.d.a(context), this.u, this.x, new d());
            this.q = gVar2;
            gVar2.show();
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
        com.igaworks.adpopcorn.activity.layout.g.b bVar;
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
                                com.igaworks.adpopcorn.cores.common.g gVar = this.f1561b;
                                com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, i3, gVar.o, gVar.Q, -1, gVar.H, new e(), this.d, true);
                                this.U = aVar;
                                aVar.setCancelable(false);
                                this.U.show();
                                return;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1561b.e, 1, 17);
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
                        if ((apOfferWallLayout != null && apOfferWallLayout.getOfferwallType() == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle")) || ((bVar = this.Y) != null && bVar.getOfferwallType() == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle"))) {
                            string3 = jSONObject2.getString("FeedTitle");
                        }
                        int i5 = jSONObject2.getInt("CSTypeCode");
                        com.igaworks.adpopcorn.cores.model.b bVar2 = new com.igaworks.adpopcorn.cores.model.b();
                        bVar2.a(string);
                        bVar2.b(string2);
                        bVar2.c(string3);
                        bVar2.a(i5);
                        this.r.add(0, bVar2);
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
        com.igaworks.adpopcorn.activity.b.l.c cVar = this.y;
        if (cVar == null || !cVar.isShowing()) {
            return;
        }
        this.y.dismiss();
        this.y = null;
    }
}
