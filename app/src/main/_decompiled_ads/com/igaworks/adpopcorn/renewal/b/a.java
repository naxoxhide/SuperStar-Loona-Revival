package com.igaworks.adpopcorn.renewal.b;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.adxcorp.util.ADXLogUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.net.HttpHeaders;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;
import com.igaworks.adpopcorn.renewal.layout.ApRewardOfferWallLayout;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Dialog implements com.igaworks.adpopcorn.a.g.a.d {
    private m A;
    private EditText B;
    private EditText C;
    private EditText D;
    private EditText E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private com.igaworks.adpopcorn.renewal.c.a K;
    private com.igaworks.adpopcorn.a.c L;
    private com.igaworks.adpopcorn.renewal.b.d.a M;
    private ApRewardOfferWallLayout N;
    private int O;
    private List<TextView> P;
    private List<ImageView> Q;
    private ListView R;
    private TextView S;
    private ArrayList<com.igaworks.adpopcorn.cores.model.c> T;
    private m U;
    private ListView V;
    private ArrayList<com.igaworks.adpopcorn.cores.model.d> W;
    private m X;
    private ScrollView Y;
    private LinearLayout Z;
    private Context a;
    private LinearLayout a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.igaworks.adpopcorn.cores.common.g f1644b;
    AdapterView.OnItemClickListener b0;
    private boolean c;
    private boolean d;
    private GradientDrawable e;
    private GradientDrawable f;
    private GradientDrawable g;
    private GradientDrawable h;
    private StateListDrawable i;
    private int j;
    private com.igaworks.adpopcorn.a.g.a k;
    private com.igaworks.adpopcorn.renewal.b.d.DialogC0441d l;
    private ArrayList<com.igaworks.adpopcorn.cores.model.b> m;
    private ArrayList<String> n;
    private ArrayList<String> o;
    private ArrayList<String> p;
    private int q;
    private int r;
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private LinearLayout v;
    private LinearLayout w;
    private LinearLayout x;
    private LinearLayout y;
    private ListView z;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.renewal.b.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0437a implements View.OnClickListener {
        ViewOnClickListenerC0437a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.d();
            a.this.b();
            a.this.M.dismiss();
        }
    }

    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            try {
                String strA = ((com.igaworks.adpopcorn.cores.model.d) a.this.W.get(i)).a();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(strA));
                a.this.a.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.M != null) {
                a.this.M.dismiss();
            }
            a.this.dismiss();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(((Integer) view.getTag()).intValue());
        }
    }

    class f implements AdapterView.OnItemClickListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.this.r = i;
            if (a.this.A != null) {
                a.this.A.notifyDataSetInvalidated();
            }
            a.this.m();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.K == null || a.this.J == null) {
                return;
            }
            a.this.K.setSelected(!a.this.K.isSelected());
            if (a.this.K.isSelected()) {
                a.this.J.setEnabled(true);
            } else {
                a.this.J.setEnabled(false);
            }
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.q != a.this.n.size() - 1) {
                a.this.l();
            }
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.M == null || !a.this.M.isShowing()) {
                return;
            }
            a.this.M.dismiss();
        }
    }

    class j implements View.OnClickListener {

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.renewal.b.a$j$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0438a implements View.OnClickListener {
            ViewOnClickListenerC0438a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.igaworks.adpopcorn.a.b.a().b(a.this.a, "adpopcorn_parameter", "check_user_agreement", false);
                if (a.this.M != null) {
                    a.this.M.dismiss();
                }
                a.this.dismiss();
                if (a.this.N != null) {
                    a.this.N.exitOfferwall();
                }
            }
        }

        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (a.this.M != null && a.this.M.isShowing()) {
                    a.this.M.dismiss();
                }
                a.this.M = new com.igaworks.adpopcorn.renewal.b.d.a(a.this.a, a.this.j, a.this.f1644b.m1, a.this.f1644b.p1, -1, a.this.f1644b.H, new ViewOnClickListenerC0438a(), a.this.c, true);
                a.this.M.setCancelable(false);
                a.this.M.show();
            } catch (Exception unused) {
            }
        }
    }

    class k implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.renewal.b.a$k$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0439a implements View.OnClickListener {
            final /* synthetic */ int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f1645b;

            ViewOnClickListenerC0439a(int i, String str) {
                this.a = i;
                this.f1645b = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.M != null) {
                    a.this.M.dismiss();
                }
                a.this.dismiss();
                int i = this.a;
                if (i == 3) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(this.f1645b));
                        a.this.a.startActivity(intent);
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
                        intent2.setData(Uri.parse(MailTo.MAILTO_SCHEME + this.f1645b));
                        intent2.putExtra("android.intent.extra.SUBJECT", a.this.f1644b.L);
                        a.this.a.startActivity(intent2);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a aVar;
            a.this.q = i;
            if (a.this.F != null) {
                a.this.F.setText((CharSequence) a.this.n.get(i));
            }
            int i2 = 1;
            if (i != a.this.n.size() - 1) {
                int iC = ((com.igaworks.adpopcorn.cores.model.b) a.this.m.get(i)).c();
                String strB = ((com.igaworks.adpopcorn.cores.model.b) a.this.m.get(i)).b();
                if (iC == 1) {
                    aVar = a.this;
                } else if (iC == 2) {
                    a.this.b(2);
                } else if (iC == 3 || iC == 4) {
                    if (a.this.M != null && a.this.M.isShowing()) {
                        a.this.M.dismiss();
                    }
                    a.this.M = new com.igaworks.adpopcorn.renewal.b.d.a(a.this.a, a.this.j, a.this.f1644b.Y, a.this.f1644b.V0, -1, a.this.f1644b.H, new ViewOnClickListenerC0439a(iC, strB), a.this.c, true);
                    a.this.M.setCancelable(true);
                    a.this.M.show();
                }
                a.this.l.dismiss();
            }
            aVar = a.this;
            i2 = 5;
            aVar.b(i2);
            a.this.l.dismiss();
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.b();
        }
    }

    private class m extends BaseAdapter {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<com.igaworks.adpopcorn.cores.model.c> f1646b;
        private List<com.igaworks.adpopcorn.cores.model.d> c;
        private List<String> d;
        private int e;

        public m(int i, Context context, List<com.igaworks.adpopcorn.cores.model.d> list) {
            this.e = 0;
            this.a = context;
            this.e = i;
            this.c = list;
        }

        public m(Context context, List<String> list) {
            this.e = 0;
            this.a = context;
            this.e = 2;
            this.d = list;
        }

        public m(Context context, List<com.igaworks.adpopcorn.cores.model.c> list, int i) {
            this.e = 0;
            this.a = context;
            this.e = i;
            this.f1646b = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> list;
            int i = this.e;
            if (i == 0) {
                List<com.igaworks.adpopcorn.cores.model.c> list2 = this.f1646b;
                if (list2 == null) {
                    return 0;
                }
                return list2.size();
            }
            if (i == 1) {
                List<com.igaworks.adpopcorn.cores.model.d> list3 = this.c;
                if (list3 == null) {
                    return 0;
                }
                return list3.size();
            }
            if (i != 2 || (list = this.d) == null) {
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

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v14, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18, types: [android.widget.LinearLayout] */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            com.igaworks.adpopcorn.activity.c.d dVar;
            TextView textView;
            TextView textView2;
            LinearLayout linearLayout2;
            TextView textView3;
            String strB;
            int color;
            TextUtils.TruncateAt truncateAt;
            int i2;
            Typeface typeface;
            int i3;
            int i4;
            boolean z;
            ?? r2;
            TextView textView4;
            TextView textView5;
            ?? r3;
            Log.d("TEST111", "type : " + this.e);
            int i5 = this.e;
            if (i5 == 0) {
                if (view == null) {
                    ?? linearLayout3 = new LinearLayout(this.a);
                    linearLayout3.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 80)));
                    linearLayout3.setGravity(17);
                    linearLayout3.setOrientation(1);
                    LinearLayout linearLayout4 = new LinearLayout(this.a);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
                    layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
                    linearLayout4.setLayoutParams(layoutParams);
                    linearLayout4.setGravity(17);
                    linearLayout4.setOrientation(0);
                    linearLayout3.addView(linearLayout4);
                    textView4 = new TextView(this.a);
                    textView4.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
                    textView4.setGravity(3);
                    textView4.setId(0);
                    linearLayout4.addView(textView4);
                    textView3 = new TextView(this.a);
                    textView3.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                    textView3.setGravity(17);
                    textView3.setId(1);
                    linearLayout4.addView(textView3);
                    textView5 = new TextView(this.a);
                    textView5.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 18)));
                    textView5.setGravity(3);
                    textView5.setId(2);
                    linearLayout3.addView(textView5);
                    r3 = linearLayout3;
                } else {
                    LinearLayout linearLayout5 = (LinearLayout) view;
                    textView4 = (TextView) linearLayout5.findViewById(0);
                    textView3 = (TextView) linearLayout5.findViewById(1);
                    textView5 = (TextView) linearLayout5.findViewById(2);
                    r3 = linearLayout5;
                }
                com.igaworks.adpopcorn.cores.common.k.a(textView4, this.f1646b.get(i).a(), 15, Color.parseColor("#212529"), null, 0, 1, TextUtils.TruncateAt.END, true);
                z = true;
                com.igaworks.adpopcorn.cores.common.k.a(textView5, this.f1646b.get(i).b(), 13, Color.parseColor("#808C99"), null, 0, 1, TextUtils.TruncateAt.END, false);
                strB = "+" + this.f1646b.get(i).c();
                color = ApRewardStyle.mainOfferwallColor;
                truncateAt = TextUtils.TruncateAt.END;
                i2 = 15;
                typeface = null;
                i3 = 0;
                i4 = 1;
                r2 = r3;
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        return null;
                    }
                    if (view == null) {
                        linearLayout = new LinearLayout(this.a);
                        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 30)));
                        linearLayout.setGravity(16);
                        dVar = new com.igaworks.adpopcorn.activity.c.d(this.a);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16));
                        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
                        layoutParams2.gravity = 16;
                        dVar.setLayoutParams(layoutParams2);
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
                    com.igaworks.adpopcorn.cores.common.k.a(textView, this.d.get(i), 13, Color.parseColor("#919191"), null, 0, 2, TextUtils.TruncateAt.END, false);
                    if (a.this.r == i) {
                        dVar.setChecked(true);
                        return linearLayout;
                    }
                    dVar.setChecked(false);
                    return linearLayout;
                }
                if (view == null) {
                    LinearLayout linearLayout6 = new LinearLayout(this.a);
                    linearLayout6.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 63)));
                    linearLayout6.setGravity(17);
                    linearLayout6.setOrientation(0);
                    textView2 = new TextView(this.a);
                    textView2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
                    textView2.setGravity(19);
                    textView2.setId(0);
                    linearLayout6.addView(textView2);
                    ImageView imageView = new ImageView(this.a);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20)));
                    imageView.setImageResource(R.drawable.ap_reward_expand_more);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    linearLayout6.addView(imageView);
                    linearLayout2 = linearLayout6;
                } else {
                    LinearLayout linearLayout7 = (LinearLayout) view;
                    textView2 = (TextView) linearLayout7.findViewById(0);
                    linearLayout2 = linearLayout7;
                }
                textView3 = textView2;
                strB = this.c.get(i).b();
                color = Color.parseColor("#212529");
                truncateAt = TextUtils.TruncateAt.END;
                i2 = 15;
                typeface = null;
                i3 = 0;
                i4 = 1;
                z = false;
                r2 = linearLayout2;
            }
            com.igaworks.adpopcorn.cores.common.k.a(textView3, strB, i2, color, typeface, i3, i4, truncateAt, z);
            return r2;
        }
    }

    public a(Context context, int i2, boolean z, com.igaworks.adpopcorn.cores.common.g gVar, boolean z2, ApRewardOfferWallLayout apRewardOfferWallLayout) {
        super(context, i2);
        this.q = -1;
        this.r = 0;
        this.O = 0;
        this.b0 = new b();
        this.a = context;
        this.j = i2;
        this.c = z;
        this.f1644b = gVar;
        this.d = z2;
        this.N = apRewardOfferWallLayout;
    }

    private void a() {
        try {
            a(false);
            com.igaworks.adpopcorn.cores.common.g gVar = this.f1644b;
            com.igaworks.adpopcorn.renewal.b.d.a aVar = new com.igaworks.adpopcorn.renewal.b.d.a(this.a, this.j, gVar.I, gVar.S, -1, gVar.z, new l(), gVar.c, new ViewOnClickListenerC0437a(), this.c);
            this.M = aVar;
            aVar.setCancelable(false);
            this.M.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        TextView textView;
        FrameLayout.LayoutParams layoutParams;
        try {
            if (this.O == i2) {
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 2));
            layoutParams2.gravity = 80;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1.0f));
            layoutParams3.gravity = 80;
            for (int i3 = 0; i3 < 3; i3++) {
                TextView textView2 = this.P.get(i3);
                ImageView imageView = this.Q.get(i3);
                if (i2 == i3) {
                    textView2.setTextColor(Color.parseColor("#212529"));
                    imageView.setBackgroundColor(Color.parseColor("#212529"));
                    textView2.setTypeface(textView2.getTypeface(), 1);
                    textView2.setPaintFlags(textView2.getPaintFlags() | 32);
                    layoutParams = layoutParams2;
                } else {
                    textView2.setTextColor(Color.parseColor("#808C99"));
                    imageView.setBackgroundColor(Color.parseColor("#F1F2F4"));
                    textView2.setTypeface(null, 0);
                    textView2.setPaintFlags(textView2.getPaintFlags() ^ 32);
                    layoutParams = layoutParams3;
                }
                imageView.setLayoutParams(layoutParams);
            }
            this.O = i2;
            if (i2 == 0) {
                LinearLayout linearLayout = this.Z;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                LinearLayout linearLayout2 = this.a0;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                ScrollView scrollView = this.Y;
                if (scrollView != null) {
                    scrollView.setVisibility(8);
                }
                ArrayList<com.igaworks.adpopcorn.cores.model.c> arrayList = this.T;
                if (arrayList != null && arrayList.size() != 0) {
                    textView = this.S;
                    if (textView == null) {
                        return;
                    }
                }
                TextView textView3 = this.S;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    return;
                }
                return;
            }
            if (i2 == 1) {
                LinearLayout linearLayout3 = this.Z;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                LinearLayout linearLayout4 = this.a0;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                ScrollView scrollView2 = this.Y;
                if (scrollView2 != null) {
                    scrollView2.setVisibility(8);
                }
                textView = this.S;
                if (textView == null) {
                    return;
                }
            } else {
                LinearLayout linearLayout5 = this.Z;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
                LinearLayout linearLayout6 = this.a0;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(8);
                }
                ScrollView scrollView3 = this.Y;
                if (scrollView3 != null) {
                    scrollView3.setVisibility(0);
                }
                textView = this.S;
                if (textView == null) {
                    return;
                }
            }
            textView.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        n();
    }

    private void a(com.igaworks.adpopcorn.cores.model.f fVar) {
        JSONArray jSONArray;
        if (fVar != null) {
            try {
                if (fVar.a() == null || fVar.a().length() <= 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(fVar.a());
                if (jSONObject.getBoolean("Result") && jSONObject.has("CompletedCampaigns") && !jSONObject.isNull("CompletedCampaigns")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("CompletedCampaigns");
                    ArrayList<com.igaworks.adpopcorn.cores.model.c> arrayList = this.T;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    int i2 = 0;
                    while (true) {
                        String string = "";
                        if (i2 >= jSONArray2.length()) {
                            break;
                        }
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                        String string2 = (!jSONObject2.has("Title") || jSONObject2.isNull("Title")) ? "" : jSONObject2.getString("Title");
                        if (jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle")) {
                            string2 = jSONObject2.getString("FeedTitle");
                        }
                        String string3 = (!jSONObject2.has(HttpHeaders.DATE) || jSONObject2.isNull(HttpHeaders.DATE)) ? "" : jSONObject2.getString(HttpHeaders.DATE);
                        if (jSONObject2.has("DateV2") && !jSONObject2.isNull("DateV2")) {
                            string3 = jSONObject2.getString("DateV2");
                        }
                        if (jSONObject2.has(ADXLogUtil.EVENT_REWARD) && !jSONObject2.isNull(ADXLogUtil.EVENT_REWARD)) {
                            string = jSONObject2.getString(ADXLogUtil.EVENT_REWARD);
                        }
                        com.igaworks.adpopcorn.cores.model.c cVar = new com.igaworks.adpopcorn.cores.model.c();
                        cVar.a(string2);
                        cVar.b(string3);
                        cVar.c(string);
                        this.T.add(cVar);
                        i2++;
                    }
                    this.U.notifyDataSetChanged();
                    ArrayList<com.igaworks.adpopcorn.cores.model.c> arrayList2 = this.T;
                    if (arrayList2 == null || arrayList2.size() != 0) {
                        this.S.setVisibility(8);
                    } else {
                        com.igaworks.adpopcorn.cores.common.k.a(this.S, this.f1644b.T, 12, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
                        this.S.setVisibility(0);
                    }
                    try {
                        if (jSONObject.has("FaqList") && !jSONObject.isNull("FaqList") && (jSONArray = jSONObject.getJSONArray("FaqList")) != null && jSONArray.length() > 0) {
                            ArrayList<com.igaworks.adpopcorn.cores.model.d> arrayList3 = this.W;
                            if (arrayList3 != null) {
                                arrayList3.clear();
                            } else {
                                this.W = new ArrayList<>();
                            }
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                                String string4 = (!jSONObject3.has("Title") || jSONObject3.isNull("Title")) ? "" : jSONObject3.getString("Title");
                                String string5 = (!jSONObject3.has(HttpHeaders.LINK) || jSONObject3.isNull(HttpHeaders.LINK)) ? "" : jSONObject3.getString(HttpHeaders.LINK);
                                com.igaworks.adpopcorn.cores.model.d dVar = new com.igaworks.adpopcorn.cores.model.d();
                                dVar.b(string4);
                                dVar.a(string5);
                                this.W.add(dVar);
                            }
                            this.X.notifyDataSetChanged();
                        }
                    } catch (Exception unused) {
                    }
                    c();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                a();
            }
        }
    }

    private boolean a(String str) {
        return Pattern.compile("^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$").matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.s.setVisibility(8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (i2 == 0) {
            this.u.setVisibility(8);
            this.G.setVisibility(8);
            return;
        }
        if (i2 == 1) {
            this.u.setVisibility(0);
            this.v.setVisibility(8);
            this.w.setVisibility(8);
            this.x.setVisibility(0);
            this.z.setVisibility(8);
            this.G.setVisibility(0);
            this.J.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
            layoutParams2.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
            this.t.setLayoutParams(layoutParams2);
            layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, FacebookRequestErrorClassification.EC_INVALID_TOKEN));
        } else {
            if (i2 != 2) {
                if (i2 == 5) {
                    this.u.setVisibility(0);
                    this.v.setVisibility(8);
                    this.w.setVisibility(8);
                    this.x.setVisibility(8);
                    this.z.setVisibility(0);
                    this.E.setVisibility(0);
                    this.G.setVisibility(8);
                    this.J.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
                    layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
                    this.t.setLayoutParams(layoutParams3);
                    this.E.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 143)));
                    this.E.setEnabled(false);
                    m();
                    return;
                }
                return;
            }
            this.u.setVisibility(0);
            this.v.setVisibility(0);
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            this.z.setVisibility(8);
            this.G.setVisibility(0);
            this.J.setVisibility(0);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
            layoutParams4.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
            this.t.setLayoutParams(layoutParams4);
            layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 104));
        }
        this.E.setLayoutParams(layoutParams);
        this.E.setEnabled(true);
        this.E.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    private void c() {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            a(false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MBridgeConstans.APP_KEY, this.L.b());
            jSONObject.put("adid", this.L.a());
            jSONObject.put("usn", this.L.g());
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.k;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/cscampaign";
            } else {
                aVar = this.k;
                str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/cscampaign";
            }
            aVar.a(7, str, jSONObject, this);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            a(false);
            Locale locale = Locale.getDefault();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MBridgeConstans.APP_KEY, this.L.b());
            jSONObject.put("adid", this.L.a());
            jSONObject.put("language", locale.getLanguage());
            jSONObject.put("usn", this.L.g());
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.k;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/campaignhistory";
            } else {
                aVar = this.k;
                str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/campaignhistory";
            }
            aVar.a(9, str, jSONObject, this);
        } catch (Exception unused) {
            b();
        }
    }

    private void e() {
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        frameLayout.addView(linearLayout);
        this.s = new LinearLayout(this.a);
        this.s.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.s.setOrientation(0);
        this.s.setGravity(17);
        ProgressBar progressBar = new ProgressBar(this.a, null, android.R.attr.progressBarStyleLarge);
        progressBar.setLayoutParams(new ViewGroup.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), com.igaworks.adpopcorn.cores.common.d.a(this.a, 50)));
        this.s.addView(progressBar);
        this.s.setVisibility(8);
        frameLayout.addView(this.s);
        linearLayout.addView(k());
        linearLayout.addView(j());
        FrameLayout frameLayout2 = new FrameLayout(this.a);
        frameLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        linearLayout.addView(frameLayout2);
        frameLayout2.addView(i());
        frameLayout2.addView(h());
        frameLayout2.addView(g());
        this.S = new TextView(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.S.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 10));
        this.S.setLayoutParams(layoutParams);
        this.S.setGravity(17);
        frameLayout2.addView(this.S);
        setContentView(frameLayout);
        b(0);
        LinearLayout linearLayout2 = this.Z;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        LinearLayout linearLayout3 = this.a0;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        ScrollView scrollView = this.Y;
        if (scrollView != null) {
            scrollView.setVisibility(8);
        }
    }

    private void f() {
        String str;
        this.f1644b = com.igaworks.adpopcorn.cores.common.g.a();
        if (this.d) {
            getWindow().setFlags(1024, 1024);
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-394502, -394502});
        this.e = gradientDrawable;
        gradientDrawable.setShape(0);
        this.e.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 100));
        this.e.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.f = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.f.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
        this.f.setGradientType(0);
        this.f.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), Color.parseColor("#F1F2F4"));
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.g = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.g.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
        this.g.setGradientType(0);
        this.g.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), Color.parseColor("#F1F2F4"));
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.h = gradientDrawable4;
        gradientDrawable4.setShape(0);
        this.h.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
        this.h.setGradientType(0);
        this.h.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), Color.parseColor("#F1F2F4"));
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        int i2 = ApRewardStyle.mainOfferwallColor;
        GradientDrawable gradientDrawable5 = new GradientDrawable(orientation, new int[]{i2, i2});
        gradientDrawable5.setShape(0);
        float f2 = 8;
        gradientDrawable5.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, f2));
        gradientDrawable5.setGradientType(0);
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-2762275, -2762275});
        gradientDrawable6.setShape(0);
        gradientDrawable6.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, f2));
        gradientDrawable6.setGradientType(0);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.i = stateListDrawable;
        stateListDrawable.addState(new int[]{-16842910}, gradientDrawable6);
        this.i.addState(StateSet.WILD_CARD, gradientDrawable5);
        this.L = com.igaworks.adpopcorn.a.d.a(this.a).e();
        this.k = new com.igaworks.adpopcorn.a.g.a(this.a);
        this.q = -1;
        this.r = 0;
        this.m = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        this.n = arrayList;
        arrayList.add(this.f1644b.m0);
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.o = arrayList2;
        arrayList2.add(this.f1644b.M0);
        this.o.add(this.f1644b.N0);
        this.o.add(this.f1644b.O0);
        ArrayList<String> arrayList3 = new ArrayList<>();
        this.p = arrayList3;
        arrayList3.add(this.f1644b.R0);
        this.p.add(this.f1644b.S0);
        this.p.add(this.f1644b.T0);
        this.p.add(this.f1644b.U0);
        this.W = new ArrayList<>();
        for (int i3 = 0; i3 < 5; i3++) {
            com.igaworks.adpopcorn.cores.model.d dVar = new com.igaworks.adpopcorn.cores.model.d();
            if (i3 == 0) {
                dVar.b(this.f1644b.O2);
                str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022#2dc8698ca97c4beaac840a1e2daaee6b";
            } else if (i3 == 1) {
                dVar.b(this.f1644b.P2);
                str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022#4760f461db8f41c9bf2b5abe91c60be3";
            } else if (i3 == 2) {
                dVar.b(this.f1644b.Q2);
                str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022#dfca40fc9cc94b53a51b3521ad9c5558";
            } else if (i3 == 3) {
                dVar.b(this.f1644b.R2);
                str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022#b9dfd6560437424391087400c46f7b2a";
            } else {
                if (i3 == 4) {
                    dVar.b(this.f1644b.S2);
                    str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022#d0ec7b2ace3f453db28e3ba735b7d9f2";
                }
                this.W.add(dVar);
            }
            dVar.a(str);
            this.W.add(dVar);
        }
    }

    private FrameLayout g() {
        ScrollView scrollView = new ScrollView(this.a);
        this.Y = scrollView;
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.Y.setFillViewport(true);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), 0);
        this.t = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        this.t.setLayoutParams(layoutParams);
        this.t.setOrientation(0);
        this.t.setGravity(17);
        this.t.setBackgroundDrawable(this.f);
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.b.-$$Lambda$a$oqTHT3j2IJb00D_2KRHbf9HFgFg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        this.F = new TextView(this.a);
        this.F.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.F.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.a(this.F, this.f1644b.M, 15, Color.parseColor("#505963"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.F.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 14), 0, 0, 0);
        this.t.addView(this.F);
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 14);
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageResource(R.drawable.ap_reward_arrow_drop_down);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.addView(imageView);
        linearLayout.addView(this.t);
        this.u = new LinearLayout(this.a);
        this.u.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.u.setOrientation(1);
        this.G = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42));
        layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        this.G.setLayoutParams(layoutParams3);
        this.G.setGravity(19);
        String strReplaceAll = this.f1644b.E0;
        if (this.c) {
            strReplaceAll = strReplaceAll.replaceAll("\n", "");
        }
        com.igaworks.adpopcorn.cores.common.k.a(this.G, strReplaceAll, 15, Color.parseColor("#B8BFC6"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.u.addView(this.G);
        this.v = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
        layoutParams4.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.v.setLayoutParams(layoutParams4);
        this.v.setOrientation(0);
        this.B = new EditText(this.a);
        this.B.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.B.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.a(this.B, "", 15, Color.parseColor("#B8BFC6"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.B.setHint(this.f1644b.F0 + this.f1644b.G0);
        this.B.setHintTextColor(Color.parseColor("#B8BFC6"));
        this.B.setBackgroundDrawable(this.f);
        this.B.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 14), 0, 0, 0);
        this.v.addView(this.B);
        this.u.addView(this.v);
        this.w = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
        layoutParams5.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.w.setLayoutParams(layoutParams5);
        this.w.setOrientation(0);
        this.C = new EditText(this.a);
        this.C.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.C.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.a(this.C, "", 15, Color.parseColor("#B8BFC6"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.C.setHint(this.f1644b.H0 + this.f1644b.G0);
        this.C.setHintTextColor(Color.parseColor("#B8BFC6"));
        this.C.setBackgroundDrawable(this.f);
        this.C.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 14), 0, 0, 0);
        this.C.setInputType(2);
        this.w.addView(this.C);
        this.u.addView(this.w);
        this.x = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
        layoutParams6.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        this.x.setLayoutParams(layoutParams6);
        this.x.setOrientation(0);
        this.D = new EditText(this.a);
        this.D.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.D.setGravity(16);
        com.igaworks.adpopcorn.cores.common.k.a(this.D, "", 15, Color.parseColor("#B8BFC6"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.D.setHint(this.f1644b.j + this.f1644b.G0);
        this.D.setHintTextColor(Color.parseColor("#B8BFC6"));
        this.D.setBackgroundDrawable(this.f);
        this.D.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 14), 0, 0, 0);
        this.x.addView(this.D);
        this.u.addView(this.x);
        this.z = new ListView(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 96));
        layoutParams7.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 11);
        this.z.setLayoutParams(layoutParams7);
        m mVar = new m(this.a, this.o);
        this.A = mVar;
        this.z.setAdapter((ListAdapter) mVar);
        this.z.setDivider(new ColorDrawable(0));
        this.z.setDividerHeight(1);
        this.z.setSelector(new ColorDrawable(0));
        this.z.setOnItemClickListener(new f());
        this.u.addView(this.z);
        this.E = new EditText(this.a);
        this.E.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 104)));
        this.E.setGravity(3);
        com.igaworks.adpopcorn.cores.common.k.a(this.E, "", 15, Color.parseColor("#B8BFC6"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.E.setHint(this.f1644b.k + this.f1644b.G0);
        this.E.setHintTextColor(Color.parseColor("#B8BFC6"));
        this.E.setBackgroundDrawable(this.g);
        this.E.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 14), com.igaworks.adpopcorn.cores.common.d.a(this.a, 14), 0, 0);
        this.u.addView(this.E);
        this.H = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams8.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        this.H.setLayoutParams(layoutParams8);
        this.H.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.a(this.H, this.f1644b.Q, 14, Color.parseColor("#9CA6AF"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.u.addView(this.H);
        this.y = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        this.y.setGravity(17);
        this.y.setLayoutParams(layoutParams9);
        this.y.setBackgroundDrawable(this.h);
        this.y.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        ViewGroup.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 54));
        linearLayout2.setGravity(17);
        linearLayout2.setLayoutParams(layoutParams10);
        linearLayout2.setOrientation(0);
        this.y.addView(linearLayout2);
        this.K = new com.igaworks.adpopcorn.renewal.c.a(this.a);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
        layoutParams11.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        this.K.setLayoutParams(layoutParams11);
        this.K.setSelected(false);
        this.K.setOnClickListener(new g());
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams12.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        textView.setLayoutParams(layoutParams12);
        textView.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.a(textView, this.f1644b.R1, 15, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout2.addView(this.K);
        linearLayout2.addView(textView);
        ImageView imageView2 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
        layoutParams13.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams13.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        imageView2.setLayoutParams(layoutParams13);
        imageView2.setBackgroundColor(Color.parseColor("#F1F2F4"));
        this.y.addView(imageView2);
        this.I = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams14.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams14.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams14.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams14.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        this.I.setLayoutParams(layoutParams14);
        this.I.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        this.I.setGravity(19);
        com.igaworks.adpopcorn.cores.common.k.a(this.I, this.f1644b.Q1, 14, Color.parseColor("#9CA6AF"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.y.addView(this.I);
        this.u.addView(this.y);
        this.J = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 54));
        layoutParams15.gravity = 1;
        layoutParams15.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        this.J.setLayoutParams(layoutParams15);
        this.J.setGravity(17);
        this.J.setBackgroundDrawable(this.i);
        com.igaworks.adpopcorn.cores.common.k.a(this.J, this.f1644b.N2, 16, Color.parseColor("#FFFFFF"), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.J.setOnClickListener(new h());
        this.J.setEnabled(false);
        this.u.addView(this.J);
        linearLayout.addView(this.u);
        this.Y.addView(linearLayout);
        return this.Y;
    }

    private LinearLayout h() {
        this.a0 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        this.a0.setLayoutParams(layoutParams);
        this.a0.setOrientation(1);
        this.a0.setBackgroundColor(-1);
        this.a0.setGravity(1);
        this.a0.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), 0);
        ListView listView = new ListView(this.a);
        this.V = listView;
        listView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        m mVar = new m(1, this.a, this.W);
        this.X = mVar;
        this.V.setAdapter((ListAdapter) mVar);
        this.V.setDivider(new ColorDrawable(-394502));
        this.V.setDividerHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
        this.V.setSelector(new ColorDrawable(0));
        this.V.setOnItemClickListener(this.b0);
        this.a0.addView(this.V);
        return this.a0;
    }

    private LinearLayout i() {
        this.Z = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        this.Z.setLayoutParams(layoutParams);
        this.Z.setOrientation(1);
        this.Z.setBackgroundColor(-1);
        this.Z.setGravity(1);
        this.Z.setFocusable(true);
        this.Z.setFocusableInTouchMode(true);
        this.Z.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), 0);
        TextView textView = new TextView(this.a);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 38)));
        textView.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.a(textView, this.f1644b.L0, 13, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView.setBackgroundDrawable(this.e);
        this.Z.addView(textView);
        this.T = new ArrayList<>();
        ListView listView = new ListView(this.a);
        this.R = listView;
        listView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        m mVar = new m(this.a, this.T, 0);
        this.U = mVar;
        this.R.setAdapter((ListAdapter) mVar);
        this.R.setDivider(new ColorDrawable(-394502));
        this.R.setDividerHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 2));
        this.R.setVerticalScrollBarEnabled(false);
        this.R.setSelector(new ColorDrawable(0));
        this.Z.addView(this.R);
        return this.Z;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00e5 A[Catch: Exception -> 0x0155, TryCatch #0 {Exception -> 0x0155, blocks: (B:10:0x0029, B:13:0x0052, B:15:0x009c, B:20:0x00a6, B:22:0x00e5, B:24:0x0135, B:23:0x010c, B:17:0x00a1), top: B:28:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x010c A[Catch: Exception -> 0x0155, TryCatch #0 {Exception -> 0x0155, blocks: (B:10:0x0029, B:13:0x0052, B:15:0x009c, B:20:0x00a6, B:22:0x00e5, B:24:0x0135, B:23:0x010c, B:17:0x00a1), top: B:28:0x0029 }] */
    private LinearLayout j() {
        String str;
        String str2;
        ImageView imageView;
        FrameLayout.LayoutParams layoutParams;
        int paintFlags;
        LinearLayout linearLayout = new LinearLayout(this.a);
        List<TextView> list = this.P;
        if (list == null) {
            this.P = new ArrayList();
        } else {
            list.clear();
        }
        List<ImageView> list2 = this.Q;
        if (list2 == null) {
            this.Q = new ArrayList();
        } else {
            list2.clear();
        }
        try {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42));
            int i2 = 17;
            layoutParams2.gravity = 17;
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            int i3 = 0;
            while (i3 < 3) {
                FrameLayout frameLayout = new FrameLayout(this.a);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), 1.0f);
                layoutParams3.gravity = 49;
                frameLayout.setLayoutParams(layoutParams3);
                frameLayout.setTag(Integer.valueOf(i3));
                frameLayout.setOnClickListener(new e());
                TextView textView = new TextView(this.a);
                textView.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42)));
                textView.setGravity(i2);
                com.igaworks.adpopcorn.cores.common.g gVar = this.f1644b;
                String str3 = gVar.L2;
                if (i3 == 1) {
                    str2 = gVar.M2;
                } else {
                    if (i3 == 2) {
                        str2 = gVar.N2;
                    } else {
                        str = str3;
                    }
                    com.igaworks.adpopcorn.cores.common.k.a(textView, str, 16, Color.parseColor("#1e1e21"), null, 0, 1, TextUtils.TruncateAt.END, false);
                    textView.setTag(Integer.valueOf(i3));
                    frameLayout.addView(textView);
                    imageView = new ImageView(this.a);
                    imageView.setTag(Integer.valueOf(i3));
                    if (i3 == 0) {
                        layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 2));
                        textView.setTextColor(Color.parseColor("#212529"));
                        imageView.setBackgroundColor(Color.parseColor("#212529"));
                        textView.setTypeface(textView.getTypeface(), 1);
                        paintFlags = textView.getPaintFlags() | 32;
                    } else {
                        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1.0f));
                        textView.setTextColor(Color.parseColor("#808C99"));
                        imageView.setBackgroundColor(Color.parseColor("#F1F2F4"));
                        textView.setTypeface(null, 0);
                        layoutParams = layoutParams4;
                        paintFlags = textView.getPaintFlags() ^ 32;
                    }
                    textView.setPaintFlags(paintFlags);
                    layoutParams.gravity = 80;
                    imageView.setLayoutParams(layoutParams);
                    frameLayout.addView(imageView);
                    linearLayout.addView(frameLayout);
                    this.P.add(textView);
                    this.Q.add(imageView);
                    i3++;
                    i2 = 17;
                }
                str = str2;
                com.igaworks.adpopcorn.cores.common.k.a(textView, str, 16, Color.parseColor("#1e1e21"), null, 0, 1, TextUtils.TruncateAt.END, false);
                textView.setTag(Integer.valueOf(i3));
                frameLayout.addView(textView);
                imageView = new ImageView(this.a);
                imageView.setTag(Integer.valueOf(i3));
                if (i3 == 0) {
                    layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 2));
                    textView.setTextColor(Color.parseColor("#212529"));
                    imageView.setBackgroundColor(Color.parseColor("#212529"));
                    textView.setTypeface(textView.getTypeface(), 1);
                    paintFlags = textView.getPaintFlags() | 32;
                } else {
                    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1.0f));
                    textView.setTextColor(Color.parseColor("#808C99"));
                    imageView.setBackgroundColor(Color.parseColor("#F1F2F4"));
                    textView.setTypeface(null, 0);
                    layoutParams = layoutParams5;
                    paintFlags = textView.getPaintFlags() ^ 32;
                }
                textView.setPaintFlags(paintFlags);
                layoutParams.gravity = 80;
                imageView.setLayoutParams(layoutParams);
                frameLayout.addView(imageView);
                linearLayout.addView(frameLayout);
                this.P.add(textView);
                this.Q.add(imageView);
                i3++;
                i2 = 17;
            }
        } catch (Exception unused) {
        }
        return linearLayout;
    }

    private RelativeLayout k() {
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 46)));
        relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        ImageView imageView = new ImageView(this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 26), com.igaworks.adpopcorn.cores.common.d.a(this.a, 26));
        imageView.setImageResource(R.drawable.ap_reward_back);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.b.-$$Lambda$a$HWRn09mAb9GQLBzQIIpOj2fbz7c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, 46));
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOnClickListener(new d());
        relativeLayout.addView(linearLayout);
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 26));
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 48);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 48);
        textView.setLayoutParams(layoutParams3);
        com.igaworks.adpopcorn.cores.common.k.a(textView, this.f1644b.J, 18, Color.parseColor("#212529"), null, 0, 1, TextUtils.TruncateAt.END, true);
        textView.setGravity(17);
        relativeLayout.addView(textView);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        int i2 = this.q;
        if (i2 == -1) {
            new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1644b.N, 1, 17);
            return;
        }
        try {
            int iC = this.m.get(i2).c();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", this.m.get(this.q).a());
            if (iC == 2) {
                EditText editText = this.B;
                if (editText == null || editText.getText() == null || this.B.getText().toString().length() <= 0) {
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1644b.O, 1, 17);
                    return;
                }
                jSONObject.put("customer_name", this.B.getText().toString());
                EditText editText2 = this.C;
                if (editText2 == null || editText2.getText() == null || this.C.getText().toString().length() <= 0) {
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1644b.O, 1, 17);
                    return;
                } else {
                    if (this.C.getText().toString().length() < 10) {
                        new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1644b.R, 1, 17);
                        return;
                    }
                    jSONObject.put("customer_phone", this.C.getText().toString());
                }
            }
            EditText editText3 = this.D;
            if (editText3 == null || editText3.getText() == null || this.D.getText().toString().length() <= 0) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1644b.O, 1, 17);
                return;
            }
            String strTrim = this.D.getText().toString().trim();
            if (!a(strTrim)) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1644b.m, 1, 17);
                return;
            }
            jSONObject.put("customer_email", strTrim);
            EditText editText4 = this.E;
            if (editText4 == null || editText4.getText() == null || this.E.getText().toString().length() <= 0) {
                new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1644b.n, 1, 17);
                return;
            }
            jSONObject.put("message", this.E.getText().toString());
            a(false);
            if (com.igaworks.adpopcorn.a.d.E) {
                aVar = this.k;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/addcs";
            } else {
                aVar = this.k;
                str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/addcs";
            }
            aVar.a(8, str, jSONObject, this);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        EditText editText;
        String str;
        int i2 = this.r;
        if (i2 == 0) {
            editText = this.E;
            str = this.f1644b.P0;
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.E.setText(this.f1644b.n1);
                    com.igaworks.adpopcorn.renewal.b.d.a aVar = this.M;
                    if (aVar != null && aVar.isShowing()) {
                        this.M.dismiss();
                        this.M = null;
                    }
                    Context context = this.a;
                    int i3 = this.j;
                    String str2 = this.f1644b.m1;
                    String str3 = this.f1644b.n1 + this.f1644b.o1;
                    com.igaworks.adpopcorn.cores.common.g gVar = this.f1644b;
                    com.igaworks.adpopcorn.renewal.b.d.a aVar2 = new com.igaworks.adpopcorn.renewal.b.d.a(context, i3, str2, str3, -1, gVar.c0, new i(), gVar.b0, new j(), this.c);
                    this.M = aVar2;
                    aVar2.setCancelable(false);
                    this.M.show();
                    return;
                }
                return;
            }
            editText = this.E;
            str = this.f1644b.Q0;
        }
        editText.setText(str);
    }

    private void n() {
        try {
            com.igaworks.adpopcorn.renewal.b.d.DialogC0441d dialogC0441d = this.l;
            if (dialogC0441d != null && dialogC0441d.isShowing()) {
                this.l.dismiss();
            }
            ArrayList<String> arrayList = this.n;
            if (arrayList != null && arrayList.size() == 0) {
                this.n.add(this.f1644b.m0);
            }
            ArrayList<String> arrayList2 = this.n;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.renewal.b.d.DialogC0441d dialogC0441d2 = new com.igaworks.adpopcorn.renewal.b.d.DialogC0441d(context, com.igaworks.adpopcorn.activity.b.d.a(context), this.n, this.q, this.c, new k());
            this.l = dialogC0441d2;
            dialogC0441d2.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z) {
        try {
            this.s.setVisibility(0);
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
        f();
        e();
        d();
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i2, com.igaworks.adpopcorn.cores.model.f fVar) {
        try {
            if (i2 == 9) {
                a(fVar);
                return;
            }
            if (i2 != 7) {
                if (i2 == 8) {
                    b();
                    if (fVar != null && fVar.a().length() > 0) {
                        try {
                            if (new JSONObject(fVar.a()).getBoolean("Result")) {
                                Context context = this.a;
                                int i3 = this.j;
                                com.igaworks.adpopcorn.cores.common.g gVar = this.f1644b;
                                com.igaworks.adpopcorn.renewal.b.d.a aVar = new com.igaworks.adpopcorn.renewal.b.d.a(context, i3, gVar.o, gVar.Q, -1, gVar.H, new c(), this.c, true);
                                this.M = aVar;
                                aVar.setCancelable(false);
                                this.M.show();
                                return;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    new com.igaworks.adpopcorn.activity.c.b(this.a).a(this.f1644b.e, 1, 17);
                    return;
                }
                return;
            }
            b();
            if (fVar == null || fVar.a().length() <= 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(fVar.a());
                if (jSONObject.has("CSCampaigns")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("CSCampaigns");
                    ArrayList<com.igaworks.adpopcorn.cores.model.b> arrayList = this.m;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    ArrayList<String> arrayList2 = this.n;
                    if (arrayList2 != null && arrayList2.size() > 1) {
                        this.n.clear();
                    }
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                        String string = jSONObject2.getString("Auth");
                        String string2 = jSONObject2.getString("CSSource");
                        String string3 = jSONObject2.getString("Title");
                        ApRewardOfferWallLayout apRewardOfferWallLayout = this.N;
                        if (apRewardOfferWallLayout != null && apRewardOfferWallLayout.getOfferwallType() == 2 && jSONObject2.has("FeedTitle") && !jSONObject2.isNull("FeedTitle")) {
                            string3 = jSONObject2.getString("FeedTitle");
                        }
                        int i5 = jSONObject2.getInt("CSTypeCode");
                        com.igaworks.adpopcorn.cores.model.b bVar = new com.igaworks.adpopcorn.cores.model.b();
                        bVar.a(string);
                        bVar.b(string2);
                        bVar.c(string3);
                        bVar.a(i5);
                        this.m.add(0, bVar);
                        this.n.add(0, string3);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
