package com.igaworks.adpopcorn.activity.b.k;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
public class b extends Dialog implements com.igaworks.adpopcorn.a.g.a.d {
    private FrameLayout A;
    private FrameLayout B;
    private ListView C;
    private q D;
    private EditText E;
    private EditText F;
    private EditText G;
    private EditText H;
    private EditText I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private com.igaworks.adpopcorn.activity.c.j.b O;
    private ImageView P;
    private com.igaworks.adpopcorn.a.c Q;
    private com.igaworks.adpopcorn.activity.b.d.a R;
    private GradientDrawable S;
    private boolean T;
    private String U;
    private ApOfferWallLayout V;
    private com.igaworks.adpopcorn.activity.layout.f.b W;
    private String X;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.igaworks.adpopcorn.cores.common.g f1547b;
    private LinearLayout c;
    private boolean d;
    private boolean e;
    private StateListDrawable f;
    private StateListDrawable g;
    private ColorStateList h;
    private int i;
    private com.igaworks.adpopcorn.a.g.a j;
    private com.igaworks.adpopcorn.activity.b.d.e k;
    private ArrayList<com.igaworks.adpopcorn.cores.model.b> l;
    private ArrayList<String> m;
    private ArrayList<String> n;
    private ArrayList<String> o;
    private int p;
    private int q;
    private int r;
    private com.igaworks.adpopcorn.activity.b.k.e s;
    private LinearLayout t;
    private LinearLayout u;
    private LinearLayout v;
    private LinearLayout w;
    private FrameLayout x;
    private FrameLayout y;
    private FrameLayout z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.O == null || b.this.N == null) {
                return;
            }
            b.this.O.setSelected(!b.this.O.isSelected());
            if (b.this.O.isSelected()) {
                b.this.N.setEnabled(true);
            } else {
                b.this.N.setEnabled(false);
            }
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.k.b$b, reason: collision with other inner class name */
    class ViewOnClickListenerC0417b implements View.OnClickListener {
        ViewOnClickListenerC0417b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.p == b.this.m.size() - 1 || b.this.O == null || !b.this.O.isSelected()) {
                return;
            }
            b.this.g();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.R == null || !b.this.R.isShowing()) {
                return;
            }
            b.this.R.dismiss();
        }
    }

    class d implements View.OnClickListener {

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.igaworks.adpopcorn.a.b.a().b(b.this.a, "adpopcorn_parameter", "check_user_agreement", false);
                if (b.this.R != null) {
                    b.this.R.dismiss();
                }
                b.this.dismiss();
                if (b.this.V != null) {
                    b.this.V.exitOfferwall();
                } else if (b.this.W != null) {
                    b.this.W.h();
                }
            }
        }

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (b.this.R != null && b.this.R.isShowing()) {
                    b.this.R.dismiss();
                }
                b.this.R = new com.igaworks.adpopcorn.activity.b.d.a(b.this.a, b.this.i, b.this.f1547b.e2, b.this.f1547b.g2, -1, b.this.f1547b.H, new a(), b.this.d, true);
                b.this.R.setCancelable(false);
                b.this.R.show();
            } catch (Exception unused) {
            }
        }
    }

    class e implements AdapterView.OnItemClickListener {

        class a implements View.OnClickListener {
            final /* synthetic */ int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f1548b;

            a(int i, String str) {
                this.a = i;
                this.f1548b = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.R != null) {
                    b.this.R.dismiss();
                }
                b.this.dismiss();
                int i = this.a;
                if (i == 3) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(this.f1548b));
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
                        intent2.setData(Uri.parse(MailTo.MAILTO_SCHEME + this.f1548b));
                        intent2.putExtra("android.intent.extra.SUBJECT", b.this.f1547b.L);
                        b.this.a.startActivity(intent2);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar;
            b.this.p = i;
            if (b.this.J != null) {
                b.this.J.setText((CharSequence) b.this.m.get(i));
                b.this.J.setTextColor(Color.parseColor("#000000"));
            }
            int i2 = 1;
            if (i != b.this.m.size() - 1) {
                int iC = ((com.igaworks.adpopcorn.cores.model.b) b.this.l.get(i)).c();
                String strB = ((com.igaworks.adpopcorn.cores.model.b) b.this.l.get(i)).b();
                if (iC == 1) {
                    bVar = b.this;
                } else if (iC == 2) {
                    b.this.a(2);
                } else if (iC == 3 || iC == 4) {
                    if (b.this.R != null && b.this.R.isShowing()) {
                        b.this.R.dismiss();
                    }
                    b.this.R = new com.igaworks.adpopcorn.activity.b.d.a(b.this.a, b.this.i, b.this.f1547b.Y, b.this.f1547b.V0, -1, b.this.f1547b.H, new a(iC, strB), b.this.d, true);
                    b.this.R.setCancelable(true);
                    b.this.R.show();
                }
                b.this.k.dismiss();
            }
            bVar = b.this;
            i2 = 5;
            bVar.a(i2);
            b.this.k.dismiss();
        }
    }

    class f implements AdapterView.OnItemClickListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b.this.r = i;
            if (b.this.H != null) {
                if (b.this.r == b.this.o.size() - 1) {
                    b.this.H.setText("");
                    b.this.H.setHint(b.this.f1547b.U0);
                    b.this.H.setEnabled(true);
                } else {
                    b.this.H.setText((CharSequence) b.this.o.get(i));
                    b.this.H.setEnabled(false);
                }
            }
            b.this.k.dismiss();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.R != null) {
                b.this.R.dismiss();
            }
            b.this.dismiss();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            com.igaworks.adpopcorn.activity.b.k.e eVar;
            if (b.this.i == 16973841) {
                b.this.e = true;
            }
            if (b.this.T) {
                bVar = b.this;
                eVar = new com.igaworks.adpopcorn.activity.b.k.e(b.this.a, b.this.i, b.this.d, b.this.f1547b, b.this.e, b.this.U);
            } else {
                int offerwallType = 0;
                if (b.this.V != null) {
                    offerwallType = b.this.V.getOfferwallType();
                } else if (b.this.W != null) {
                    offerwallType = b.this.W.getOfferwallType();
                }
                int i = offerwallType;
                bVar = b.this;
                eVar = new com.igaworks.adpopcorn.activity.b.k.e(b.this.a, b.this.i, b.this.d, b.this.f1547b, b.this.e, i);
            }
            bVar.s = eVar;
            b.this.s.show();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    class k implements Runnable {
        final /* synthetic */ TextView a;

        k(b bVar, TextView textView) {
            this.a = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TextView textView = this.a;
                if (textView == null || textView.getLineCount() < 5) {
                    return;
                }
                this.a.setTextSize(1, 11.0f);
            } catch (Exception unused) {
            }
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(b.this.X));
                b.this.a.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.i();
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.j();
        }
    }

    class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.j();
        }
    }

    class p implements AdapterView.OnItemClickListener {
        p() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b.this.q = i;
            if (b.this.D != null) {
                b.this.D.notifyDataSetInvalidated();
            }
            b.this.h();
        }
    }

    private class q extends BaseAdapter {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f1549b;

        public q(Context context, List<String> list) {
            this.a = context;
            this.f1549b = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> list = this.f1549b;
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
            com.igaworks.adpopcorn.activity.c.j.d dVar;
            TextView textView;
            if (view == null) {
                linearLayout = new LinearLayout(this.a);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                dVar = new com.igaworks.adpopcorn.activity.c.j.d(this.a);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 30), com.igaworks.adpopcorn.cores.common.d.a(this.a, 30));
                layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
                layoutParams.gravity = 48;
                dVar.setLayoutParams(layoutParams);
                dVar.setId(0);
                textView = new TextView(this.a);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 278), -2);
                layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
                layoutParams2.gravity = 48;
                textView.setLayoutParams(layoutParams2);
                textView.setGravity(48);
                textView.setIncludeFontPadding(false);
                textView.setId(1);
                linearLayout.addView(dVar);
                linearLayout.addView(textView);
            } else {
                linearLayout = (LinearLayout) view;
                dVar = (com.igaworks.adpopcorn.activity.c.j.d) linearLayout.findViewById(0);
                textView = (TextView) linearLayout.findViewById(1);
            }
            com.igaworks.adpopcorn.cores.common.k.b(textView, this.f1549b.get(i), 15, Color.parseColor("#919191"), null, 0, 2, TextUtils.TruncateAt.END, false);
            if (b.this.q == i) {
                dVar.setSelected(true);
            } else {
                dVar.setSelected(false);
            }
            return linearLayout;
        }
    }

    public b(Context context, int i2, boolean z, com.igaworks.adpopcorn.cores.common.g gVar, boolean z2, com.igaworks.adpopcorn.activity.layout.f.b bVar) {
        super(context, i2);
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.T = false;
        this.U = "";
        this.X = "https://m.onestore.co.kr/mobilepoc/web/customer/faqList.omp?category=MW000406 ";
        this.a = context;
        this.i = i2;
        this.d = z;
        this.f1547b = gVar;
        this.e = z2;
        this.T = false;
        this.V = null;
        this.W = bVar;
    }

    private void a() {
        try {
            this.t.setVisibility(8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (i2 == 0) {
            this.u.setVisibility(8);
            this.K.setVisibility(8);
            return;
        }
        if (i2 == 1) {
            this.u.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setVisibility(8);
            this.v.setVisibility(0);
            this.C.setVisibility(8);
            this.P.setVisibility(8);
            this.K.setVisibility(0);
            this.N.setVisibility(0);
            this.w.setVisibility(0);
            this.L.setVisibility(0);
            this.M.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
            layoutParams2.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
            this.x.setLayoutParams(layoutParams2);
            layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, FacebookRequestErrorClassification.EC_INVALID_TOKEN));
        } else {
            if (i2 != 2) {
                if (i2 == 5) {
                    this.u.setVisibility(0);
                    this.y.setVisibility(8);
                    this.z.setVisibility(8);
                    this.v.setVisibility(8);
                    this.C.setVisibility(0);
                    this.P.setVisibility(0);
                    this.I.setVisibility(0);
                    this.K.setVisibility(8);
                    this.N.setVisibility(8);
                    this.w.setVisibility(8);
                    this.L.setVisibility(8);
                    this.M.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
                    layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 19);
                    this.x.setLayoutParams(layoutParams3);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                    if (this.d) {
                        layoutParams4.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
                    }
                    this.I.setLayoutParams(layoutParams4);
                    this.I.setEnabled(false);
                    this.I.setBackgroundDrawable(null);
                    h();
                    return;
                }
                return;
            }
            this.u.setVisibility(0);
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.v.setVisibility(0);
            this.C.setVisibility(8);
            this.P.setVisibility(8);
            this.K.setVisibility(0);
            this.N.setVisibility(0);
            this.w.setVisibility(0);
            this.L.setVisibility(0);
            this.M.setVisibility(0);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
            layoutParams5.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
            this.x.setLayoutParams(layoutParams5);
            layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 104));
        }
        this.I.setLayoutParams(layoutParams);
        this.I.setEnabled(true);
        this.I.setText("");
        this.I.setBackgroundDrawable(this.g);
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
            jSONObject.put(MBridgeConstans.APP_KEY, this.Q.b());
            jSONObject.put("adid", this.Q.a());
            if (this.T) {
                String str2 = this.U;
                strG = (str2 == null || str2.length() <= 0) ? this.Q.a() : this.U;
            } else {
                strG = this.Q.g();
            }
            jSONObject.put("usn", strG);
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.j;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/cscampaign";
            } else {
                aVar = this.j;
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
        this.c.addView(e());
        setContentView(this.c);
        a(0);
    }

    private void d() {
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_ALL_LAYOUT_CORNER_ROUND_DP);
        this.f1547b = com.igaworks.adpopcorn.cores.common.g.a();
        if (this.e) {
            getWindow().setFlags(1024, 1024);
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-526344, -526344});
        this.S = gradientDrawable;
        gradientDrawable.setShape(0);
        this.S.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10.0f));
        this.S.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_BG_COLOR)});
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_STROKE_COLOR));
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_BG_COLOR)});
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        gradientDrawable3.setGradientType(0);
        gradientDrawable3.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), -13817478);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.g = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
        this.g.addState(new int[]{R.attr.state_focused}, gradientDrawable3);
        this.g.addState(StateSet.WILD_CARD, gradientDrawable2);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC2, iC2});
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 22.5f));
        gradientDrawable4.setGradientType(0);
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC2, iC2});
        gradientDrawable5.setShape(0);
        gradientDrawable5.setAlpha(204);
        gradientDrawable5.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 22.5f));
        gradientDrawable5.setGradientType(0);
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-14211752, -14211752});
        gradientDrawable6.setAlpha(WorkQueueKt.MASK);
        gradientDrawable6.setShape(0);
        gradientDrawable6.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 22.5f));
        gradientDrawable6.setGradientType(0);
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.f = stateListDrawable2;
        stateListDrawable2.addState(new int[]{R.attr.state_pressed}, gradientDrawable5);
        this.f.addState(new int[]{-16842910}, gradientDrawable6);
        this.f.addState(StateSet.WILD_CARD, gradientDrawable4);
        this.h = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{-16842910}, new int[0]}, new int[]{Color.parseColor("#ffffff"), Color.parseColor("#80ffffff"), Color.parseColor("#ffffff")});
        this.Q = com.igaworks.adpopcorn.a.d.a(this.a).e();
        this.j = new com.igaworks.adpopcorn.a.g.a(this.a);
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.l = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        this.m = arrayList;
        arrayList.add(this.f1547b.m0);
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.n = arrayList2;
        arrayList2.add(this.f1547b.M0);
        this.n.add(this.f1547b.N0);
        ArrayList<String> arrayList3 = new ArrayList<>();
        this.o = arrayList3;
        arrayList3.add(this.f1547b.R0);
        this.o.add(this.f1547b.S0);
        this.o.add(this.f1547b.T0);
        this.o.add(this.f1547b.U0);
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
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_TOP_PADDING);
        linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC2), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), 0);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setIncludeFontPadding(false);
        com.igaworks.adpopcorn.cores.common.k.b(textView, this.f1547b.W1, 15, Color.parseColor("#000000"), null, 0, 1, TextUtils.TruncateAt.END, false);
        linearLayout.addView(textView);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundDrawable(this.S);
        linearLayout2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC2), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC), 0);
        linearLayout.addView(linearLayout2);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 98));
        layoutParams3.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(3);
        com.igaworks.adpopcorn.cores.common.k.b(textView2, this.f1547b.A0 + "\n" + this.f1547b.B0 + "\n" + this.f1547b.C0 + "\n" + this.f1547b.D0, 12, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView2.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), 1.0f);
        linearLayout2.addView(textView2);
        new Handler().post(new k(this, textView2));
        TextView textView3 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
        layoutParams4.gravity = 1;
        layoutParams4.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        textView3.setLayoutParams(layoutParams4);
        textView3.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.b(textView3, this.f1547b.s1, 13, Color.parseColor("#4b469c"), null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout2.addView(textView3);
        textView3.setOnClickListener(new l());
        this.x = new FrameLayout(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 43));
        layoutParams5.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        this.x.setLayoutParams(layoutParams5);
        this.x.setOnClickListener(new m());
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
        layoutParams6.gravity = 80;
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout3.setGravity(80);
        linearLayout3.setBackgroundResource(com.igaworks.adpopcorn.R.drawable.onestore_input_bg);
        this.x.addView(linearLayout3);
        this.J = new TextView(this.a);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 260), -1);
        layoutParams7.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        layoutParams7.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 45);
        this.J.setLayoutParams(layoutParams7);
        this.J.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.b(this.J, this.f1547b.M, 15, Color.parseColor("#8c8c8c"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.J.setPadding(0, 0, 0, 0);
        this.J.setSingleLine();
        this.x.addView(this.J);
        ImageView imageView = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 30), com.igaworks.adpopcorn.cores.common.d.a(this.a, 30));
        layoutParams8.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
        layoutParams8.gravity = 21;
        imageView.setLayoutParams(layoutParams8);
        imageView.setImageResource(com.igaworks.adpopcorn.R.drawable.onestore_btn_dropdown_n);
        this.x.addView(imageView);
        linearLayout.addView(this.x);
        this.u = new LinearLayout(this.a);
        this.u.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.u.setOrientation(1);
        this.K = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 40);
        this.K.setLayoutParams(layoutParams9);
        this.K.setGravity(19);
        this.K.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        this.K.setIncludeFontPadding(false);
        String strReplaceAll = this.f1547b.E0;
        if (this.d) {
            strReplaceAll = strReplaceAll.replaceAll("\n", "");
        }
        com.igaworks.adpopcorn.cores.common.k.b(this.K, strReplaceAll, 13, Color.parseColor("#8c8c8c"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.u.addView(this.K);
        this.y = new FrameLayout(this.a);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 43));
        layoutParams10.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.y.setLayoutParams(layoutParams10);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams11 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
        layoutParams11.gravity = 80;
        linearLayout4.setLayoutParams(layoutParams11);
        linearLayout4.setGravity(80);
        linearLayout4.setBackgroundResource(com.igaworks.adpopcorn.R.drawable.onestore_input_bg);
        this.y.addView(linearLayout4);
        this.E = new EditText(this.a);
        FrameLayout.LayoutParams layoutParams12 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams12.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        this.E.setLayoutParams(layoutParams12);
        this.E.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.E, "", 15, Color.parseColor("#000000"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.E.setHint(this.f1547b.F0 + this.f1547b.G0);
        this.E.setHintTextColor(Color.parseColor("#a4a4a4"));
        this.E.setPadding(0, 0, 0, 0);
        this.E.setBackgroundColor(Color.parseColor("#00000000"));
        this.y.addView(this.E);
        this.u.addView(this.y);
        this.z = new FrameLayout(this.a);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 43));
        layoutParams13.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.z.setLayoutParams(layoutParams13);
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams14 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
        layoutParams14.gravity = 80;
        linearLayout5.setLayoutParams(layoutParams14);
        linearLayout5.setGravity(80);
        linearLayout5.setBackgroundResource(com.igaworks.adpopcorn.R.drawable.onestore_input_bg);
        this.z.addView(linearLayout5);
        this.F = new EditText(this.a);
        FrameLayout.LayoutParams layoutParams15 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams15.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        this.F.setLayoutParams(layoutParams15);
        this.F.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.F, "", 15, Color.parseColor("#000000"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.F.setHint(this.f1547b.H0 + this.f1547b.G0);
        this.F.setHintTextColor(Color.parseColor("#a4a4a4"));
        this.F.setPadding(0, 0, 0, 0);
        this.F.setBackgroundColor(Color.parseColor("#00000000"));
        this.F.setInputType(2);
        this.z.addView(this.F);
        this.u.addView(this.z);
        this.v = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 43));
        layoutParams16.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.v.setLayoutParams(layoutParams16);
        this.v.setOrientation(0);
        this.A = new FrameLayout(this.a);
        this.A.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        LinearLayout linearLayout6 = new LinearLayout(this.a);
        new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 8)).gravity = 80;
        linearLayout6.setLayoutParams(layoutParams14);
        linearLayout6.setGravity(80);
        linearLayout6.setBackgroundResource(com.igaworks.adpopcorn.R.drawable.onestore_input_bg);
        this.A.addView(linearLayout6);
        this.G = new EditText(this.a);
        this.G.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.G.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.G, "", 15, Color.parseColor("#000000"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.G.setHint(this.f1547b.j + this.f1547b.G0);
        this.G.setHintTextColor(Color.parseColor("#a4a4a4"));
        this.G.setBackgroundColor(Color.parseColor("#00000000"));
        this.G.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, 0, 0);
        this.A.addView(this.G);
        this.v.addView(this.A);
        TextView textView4 = new TextView(this.a);
        textView4.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 22), -1));
        textView4.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.b(textView4, "@", 13, Color.parseColor("#181818"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.v.addView(textView4);
        this.B = new FrameLayout(this.a);
        this.B.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 150), -1));
        this.B.setOnClickListener(new n());
        LinearLayout linearLayout7 = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
        layoutParams17.gravity = 80;
        linearLayout7.setLayoutParams(layoutParams17);
        linearLayout7.setGravity(80);
        linearLayout7.setBackgroundResource(com.igaworks.adpopcorn.R.drawable.onestore_input_bg);
        this.B.addView(linearLayout7);
        LinearLayout linearLayout8 = new LinearLayout(this.a);
        ViewGroup.LayoutParams layoutParams18 = new FrameLayout.LayoutParams(-1, -1);
        linearLayout8.setGravity(16);
        linearLayout8.setLayoutParams(layoutParams18);
        linearLayout8.setOrientation(0);
        linearLayout8.setOnClickListener(new o());
        this.B.addView(linearLayout8);
        this.H = new EditText(this.a);
        LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 90), -1);
        layoutParams19.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        this.H.setLayoutParams(layoutParams19);
        this.H.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(this.H, this.f1547b.R0, 15, Color.parseColor("#000000"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.H.setHint(this.f1547b.U0);
        this.H.setBackgroundColor(Color.parseColor("#00000000"));
        this.H.setHintTextColor(Color.parseColor("#a4a4a4"));
        this.H.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, 0, 0);
        linearLayout8.addView(this.H);
        this.H.setEnabled(false);
        ImageView imageView2 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 30), com.igaworks.adpopcorn.cores.common.d.a(this.a, 30));
        layoutParams20.gravity = 21;
        layoutParams20.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
        imageView2.setLayoutParams(layoutParams20);
        imageView2.setImageResource(com.igaworks.adpopcorn.R.drawable.onestore_btn_dropdown_n);
        linearLayout8.addView(imageView2);
        this.v.addView(this.B);
        this.u.addView(this.v);
        this.C = new ListView(this.a);
        LinearLayout.LayoutParams layoutParams21 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams21.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        this.C.setLayoutParams(layoutParams21);
        q qVar = new q(this.a, this.n);
        this.D = qVar;
        this.C.setAdapter((ListAdapter) qVar);
        this.C.setDivider(new ColorDrawable(0));
        this.C.setDividerHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 4));
        this.C.setSelector(new ColorDrawable(0));
        this.C.setOnItemClickListener(new p());
        this.u.addView(this.C);
        this.P = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.c() - com.igaworks.adpopcorn.cores.common.d.a(this.a, 40), com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
        layoutParams22.gravity = 17;
        this.P.setLayoutParams(layoutParams22);
        this.P.setBackgroundColor(Color.parseColor("#f7f7f8"));
        this.u.addView(this.P);
        this.I = new EditText(this.a);
        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 143));
        if (this.d) {
            layoutParams23.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        }
        this.I.setLayoutParams(layoutParams23);
        this.I.setGravity(3);
        com.igaworks.adpopcorn.cores.common.k.b(this.I, "", 15, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.I.setHint(this.f1547b.k + this.f1547b.G0);
        this.I.setHintTextColor(Color.parseColor("#8c8c8c"));
        this.I.setBackgroundDrawable(this.g);
        this.I.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        this.I.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
        this.u.addView(this.I);
        this.L = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams24.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams24.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 13);
        this.L.setIncludeFontPadding(false);
        this.L.setLayoutParams(layoutParams24);
        this.L.setGravity(19);
        this.L.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        com.igaworks.adpopcorn.cores.common.k.b(this.L, this.f1547b.P, 13, Color.parseColor("#8c8c8c"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.u.addView(this.L);
        this.M = new TextView(this.a);
        new LinearLayout.LayoutParams(-2, -2).bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.M.setIncludeFontPadding(false);
        this.M.setLayoutParams(layoutParams24);
        this.M.setGravity(19);
        this.M.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        com.igaworks.adpopcorn.cores.common.k.b(this.M, this.f1547b.a2, 13, Color.parseColor("#8c8c8c"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.u.addView(this.M);
        this.w = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams25.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 30);
        this.w.setGravity(19);
        this.w.setLayoutParams(layoutParams25);
        this.w.setOrientation(0);
        this.O = new com.igaworks.adpopcorn.activity.c.j.b(this.a);
        this.O.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 30), com.igaworks.adpopcorn.cores.common.d.a(this.a, 30)));
        this.O.setSelected(false);
        this.O.setOnClickListener(new a());
        TextView textView5 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams26.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        textView5.setLayoutParams(layoutParams26);
        textView5.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.b(textView5, this.f1547b.b2, 15, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.w.addView(this.O);
        this.w.addView(textView5);
        this.u.addView(this.w);
        this.N = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 140), com.igaworks.adpopcorn.cores.common.d.a(this.a, 45));
        layoutParams27.gravity = 1;
        layoutParams27.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        this.N.setLayoutParams(layoutParams27);
        this.N.setGravity(17);
        this.N.setBackgroundDrawable(this.f);
        com.igaworks.adpopcorn.cores.common.k.b(this.N, this.f1547b.l, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.N.setOnClickListener(new ViewOnClickListenerC0417b());
        this.N.setEnabled(false);
        this.N.setTextColor(this.h);
        this.u.addView(this.N);
        linearLayout.addView(this.u);
        scrollView.addView(linearLayout);
        frameLayout.addView(scrollView);
        this.t = new LinearLayout(this.a);
        this.t.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.t.setOrientation(0);
        this.t.setGravity(17);
        ProgressBar progressBar = new ProgressBar(this.a, null, R.attr.progressBarStyleLarge);
        progressBar.setLayoutParams(new ViewGroup.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), com.igaworks.adpopcorn.cores.common.d.a(this.a, 50)));
        this.t.addView(progressBar);
        frameLayout.addView(this.t);
        return frameLayout;
    }

    private RelativeLayout f() {
        RelativeLayout.LayoutParams layoutParams;
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_MODE);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, iC)));
        relativeLayout.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR));
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 21));
        if (zB) {
            layoutParams2.addRule(15);
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        }
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.b(textView, this.f1547b.w0, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_SIZE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
        relativeLayout.addView(textView);
        textView.setOnClickListener(new h());
        TextView textView2 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        if (zB) {
            layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 58);
            layoutParams3.addRule(9);
        } else {
            layoutParams3.addRule(14);
        }
        layoutParams3.addRule(15);
        textView2.setLayoutParams(layoutParams3);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR);
        com.igaworks.adpopcorn.cores.common.k.b(textView2, this.f1547b.V1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD));
        textView2.setGravity(17);
        relativeLayout.addView(textView2);
        ImageView imageView = new ImageView(this.a);
        if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_ID) == -100) {
            layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_arrow_back.png", imageView, false);
        } else {
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_SIZE);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(com.igaworks.adpopcorn.R.drawable.onestore_gnb_gnb_back);
            layoutParams = layoutParams4;
        }
        imageView.setOnClickListener(new i());
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        layoutParams5.addRule(15);
        layoutParams5.addRule(9);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOnClickListener(new j());
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        EditText editText;
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        int i2 = this.p;
        if (i2 == -1) {
            new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1547b.N, 1, 17);
            return;
        }
        try {
            int iC = this.l.get(i2).c();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.l.get(this.p).a());
            if (iC == 2) {
                EditText editText2 = this.E;
                if (editText2 == null || editText2.getText() == null || this.E.getText().toString().length() <= 0) {
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1547b.O, 1, 17);
                    return;
                }
                jSONObject.put("customer_name", this.E.getText().toString());
                EditText editText3 = this.F;
                if (editText3 == null || editText3.getText() == null || this.F.getText().toString().length() <= 0) {
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1547b.O, 1, 17);
                    return;
                } else {
                    if (this.F.getText().toString().length() < 10) {
                        new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1547b.R, 1, 17);
                        return;
                    }
                    jSONObject.put("customer_phone", this.F.getText().toString());
                }
            }
            EditText editText4 = this.G;
            if (editText4 == null || editText4.getText() == null || this.G.getText().toString().length() <= 0 || (editText = this.H) == null || editText.getText() == null || this.H.getText().toString().length() <= 0) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1547b.O, 1, 17);
                return;
            }
            String strTrim = this.G.getText().toString().trim();
            String strTrim2 = this.H.getText().toString().trim();
            if (!a(strTrim + "@" + strTrim2)) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1547b.m, 1, 17);
                return;
            }
            jSONObject.put("customer_email", strTrim + "@" + strTrim2);
            EditText editText5 = this.I;
            if (editText5 == null || editText5.getText() == null || this.I.getText().toString().length() <= 0) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1547b.n, 1, 17);
                return;
            }
            jSONObject.put("message", this.I.getText().toString());
            a(false);
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.j;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/addcs";
            } else {
                aVar = this.j;
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
        int i2 = this.q;
        if (i2 == 0) {
            editText = this.I;
            str = this.f1547b.h2;
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.I.setText(this.f1547b.f2);
                    com.igaworks.adpopcorn.activity.b.d.a aVar = this.R;
                    if (aVar != null && aVar.isShowing()) {
                        this.R.dismiss();
                        this.R = null;
                    }
                    Context context = this.a;
                    int i3 = this.i;
                    String str2 = this.f1547b.e2;
                    String str3 = this.f1547b.f2 + "\n\n" + this.f1547b.o1;
                    com.igaworks.adpopcorn.cores.common.g gVar = this.f1547b;
                    com.igaworks.adpopcorn.activity.b.d.a aVar2 = new com.igaworks.adpopcorn.activity.b.d.a(context, i3, str2, str3, -1, gVar.c0, new c(), gVar.b0, new d(), this.d);
                    this.R = aVar2;
                    aVar2.setCancelable(false);
                    this.R.show();
                    return;
                }
                return;
            }
            editText = this.I;
            str = this.f1547b.i2;
        }
        editText.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            com.igaworks.adpopcorn.activity.b.d.e eVar = this.k;
            if (eVar != null && eVar.isShowing()) {
                this.k.dismiss();
            }
            ArrayList<String> arrayList = this.m;
            if (arrayList != null && arrayList.size() == 0) {
                this.m.add(this.f1547b.m0);
            }
            ArrayList<String> arrayList2 = this.m;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.e eVar2 = new com.igaworks.adpopcorn.activity.b.d.e(context, com.igaworks.adpopcorn.activity.b.d.a(context), this.m, this.p, new e());
            this.k = eVar2;
            eVar2.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            com.igaworks.adpopcorn.activity.b.d.e eVar = this.k;
            if (eVar != null && eVar.isShowing()) {
                this.k.dismiss();
            }
            ArrayList<String> arrayList = this.o;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.e eVar2 = new com.igaworks.adpopcorn.activity.b.d.e(context, com.igaworks.adpopcorn.activity.b.d.a(context), this.o, this.r, new f());
            this.k = eVar2;
            eVar2.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z) {
        try {
            this.t.setVisibility(0);
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
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
            getWindow().getDecorView().setSystemUiVisibility(8192);
        }
        d();
        c();
        b();
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        com.igaworks.adpopcorn.activity.layout.f.b bVar;
        try {
            a();
            if (i2 != 7) {
                if (i2 == 8) {
                    a();
                    if (fVar != null && fVar.a().length() > 0) {
                        try {
                            if (new JSONObject(fVar.a()).getBoolean("Result")) {
                                Context context = this.a;
                                int i3 = this.i;
                                com.igaworks.adpopcorn.cores.common.g gVar = this.f1547b;
                                com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, i3, gVar.o, gVar.Q, -1, gVar.H, new g(), this.d, true);
                                this.R = aVar;
                                aVar.setCancelable(false);
                                this.R.show();
                                return;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1547b.e, 1, 17);
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
                    ArrayList<com.igaworks.adpopcorn.cores.model.b> arrayList = this.l;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    ArrayList<String> arrayList2 = this.m;
                    if (arrayList2 != null && arrayList2.size() > 1) {
                        this.m.clear();
                    }
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                        String string = jSONObject2.getString("Auth");
                        String string2 = jSONObject2.getString("CSSource");
                        String string3 = jSONObject2.getString("Title");
                        ApOfferWallLayout apOfferWallLayout = this.V;
                        if ((apOfferWallLayout != null && apOfferWallLayout.getOfferwallType() == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle")) || ((bVar = this.W) != null && bVar.getOfferwallType() == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle"))) {
                            string3 = jSONObject2.getString("FeedTitle");
                        }
                        int i5 = jSONObject2.getInt("CSTypeCode");
                        com.igaworks.adpopcorn.cores.model.b bVar2 = new com.igaworks.adpopcorn.cores.model.b();
                        bVar2.a(string);
                        bVar2.b(string2);
                        bVar2.c(string3);
                        bVar2.a(i5);
                        this.l.add(0, bVar2);
                        this.m.add(0, string3);
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
        com.igaworks.adpopcorn.activity.b.k.e eVar = this.s;
        if (eVar == null || !eVar.isShowing()) {
            return;
        }
        this.s.dismiss();
        this.s = null;
    }
}
