package com.bytedance.sdk.openadsdk.common;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTPrivacyAdReportDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends Dialog {
    private static final String[] f = {"SDK version", "App", "App version", "OS", "Device", "Creative info"};
    private Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f533b;
    private TextView c;
    private Button d;
    private ImageView e;

    /* JADX INFO: compiled from: TTPrivacyAdReportDialog.java */
    class a implements View.OnClickListener {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f534b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        a(String str, String str2, String str3, String str4) {
            this.a = str;
            this.f534b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ClipboardManager clipboardManager = (ClipboardManager) h.this.getContext().getSystemService("clipboard");
            if (clipboardManager != null) {
                StringBuilder sb = new StringBuilder("");
                String[] strArr = {BuildConfig.VERSION_NAME, this.a, this.f534b, this.c, this.d, h.this.f533b};
                for (int i = 0; i < h.f.length; i++) {
                    sb.append(h.f[i]).append(": ").append(strArr[i]).append("\n");
                }
                try {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("pangle sdk build info", sb));
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: TTPrivacyAdReportDialog.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.c.setText("loading ...");
            h.this.cancel();
        }
    }

    /* JADX INFO: compiled from: TTPrivacyAdReportDialog.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.c.setText(h.this.f533b);
        }
    }

    public h(Context context) {
        super(context, t.l(context, "tt_privacy_dialog_theme_ad_report"));
        this.a = new Handler(Looper.getMainLooper());
        this.f533b = "";
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a(getContext()), new ViewGroup.LayoutParams(b0.i(getContext()), (int) (((double) b0.g(getContext())) * 0.9d)));
        b();
        if (getWindow() != null) {
            getWindow().setGravity(80);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.a.postDelayed(new c(), 1000L);
    }

    private void b() {
        this.d.setOnClickListener(new a(a0.i(), a0.s(), "Android " + Build.VERSION.RELEASE, Build.BRAND + " " + Build.MODEL));
        this.e.setOnClickListener(new b());
    }

    public void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f533b = com.bytedance.sdk.component.utils.a.a(new JSONObject(str)).toString();
        } catch (JSONException e) {
            m.b("TTPrivacyAdReportDialog", e.getMessage());
        }
    }

    private View a(Context context) {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        pAGLinearLayout.setBackground(t.f(context, "tt_ad_report_info_bg"));
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(layoutParams);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, a(44.0f)));
        PAGTextView pAGTextView = new PAGTextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(191.0f), a(24.0f));
        layoutParams2.addRule(13);
        pAGTextView.setGravity(17);
        pAGTextView.setText("Ad Report");
        pAGTextView.setTextColor(Color.parseColor("#161823"));
        pAGTextView.setTextSize(1, 17.0f);
        pAGTextView.setLayoutParams(layoutParams2);
        this.e = new PAGImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a(40.0f), a(44.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = a(8.0f);
        this.e.setPadding(a(12.0f), a(14.0f), a(12.0f), a(14.0f));
        this.e.setImageResource(t.e(context, "tt_ad_xmark"));
        this.e.setLayoutParams(layoutParams3);
        View view = new View(context);
        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, a(0.5f));
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        view.setLayoutParams(layoutParams4);
        ScrollView scrollView = new ScrollView(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams5.leftMargin = a(16.0f);
        layoutParams5.rightMargin = a(16.0f);
        layoutParams5.weight = 1.0f;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams5.setMarginStart(a(16.0f));
            layoutParams5.setMarginEnd(a(16.0f));
        }
        scrollView.setLayoutParams(layoutParams5);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        ViewGroup.LayoutParams layoutParams6 = new ViewGroup.LayoutParams(-1, -1);
        pAGLinearLayout2.setOrientation(1);
        pAGLinearLayout2.setLayoutParams(layoutParams6);
        String strI = a0.i();
        String strS = a0.s();
        String str = "Android " + Build.VERSION.RELEASE;
        String str2 = Build.BRAND + " " + Build.MODEL;
        PAGLinearLayout pAGLinearLayoutA = a(context, "SDK version", BuildConfig.VERSION_NAME);
        PAGLinearLayout pAGLinearLayoutA2 = a(context, "App", strI);
        PAGLinearLayout pAGLinearLayoutA3 = a(context, "App version", strS);
        PAGLinearLayout pAGLinearLayoutA4 = a(context, "OS", str);
        PAGLinearLayout pAGLinearLayoutA5 = a(context, "Device", str2);
        PAGLinearLayout pAGLinearLayoutA6 = a(context, "Creative info", "loading ...");
        PAGLinearLayout pAGLinearLayout3 = new PAGLinearLayout(context);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, a(76.0f));
        pAGLinearLayout3.setBackgroundColor(Color.parseColor("#ffffff"));
        pAGLinearLayout3.setLayoutParams(layoutParams7);
        this.d = new Button(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -1);
        int iA = a(16.0f);
        layoutParams8.setMargins(iA, iA, iA, iA);
        this.d.setBackground(t.f(context, "tt_ad_report_info_button_bg"));
        this.d.setText("copy all");
        this.d.setTextColor(Color.parseColor("#333333"));
        this.d.setTextSize(14.0f);
        this.d.setLayoutParams(layoutParams8);
        pAGLinearLayout.addView(pAGRelativeLayout);
        pAGRelativeLayout.addView(pAGTextView);
        pAGRelativeLayout.addView(this.e);
        pAGLinearLayout.addView(view);
        pAGLinearLayout.addView(scrollView);
        scrollView.addView(pAGLinearLayout2);
        pAGLinearLayout2.addView(pAGLinearLayoutA);
        pAGLinearLayout2.addView(pAGLinearLayoutA2);
        pAGLinearLayout2.addView(pAGLinearLayoutA3);
        pAGLinearLayout2.addView(pAGLinearLayoutA4);
        pAGLinearLayout2.addView(pAGLinearLayoutA5);
        pAGLinearLayout2.addView(pAGLinearLayoutA6);
        pAGLinearLayout.addView(pAGLinearLayout3);
        pAGLinearLayout3.addView(this.d);
        return pAGLinearLayout;
    }

    private PAGLinearLayout a(Context context, String str, String str2) {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, str.equals("Creative info") ? -2 : a(74.0f));
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setPadding(0, a(16.0f), 0, a(16.0f));
        pAGLinearLayout.setLayoutParams(layoutParams);
        PAGTextView pAGTextView = new PAGTextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = a(7.0f);
        pAGTextView.setIncludeFontPadding(false);
        pAGTextView.setText(str);
        pAGTextView.setTextColor(Color.parseColor("#333333"));
        pAGTextView.setTextSize(16.0f);
        pAGTextView.setTypeface(Typeface.defaultFromStyle(1));
        pAGTextView.setLayoutParams(layoutParams2);
        pAGLinearLayout.addView(pAGTextView);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        if (str.equals("Creative info")) {
            this.c = pAGTextView2;
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        pAGTextView2.setIncludeFontPadding(false);
        pAGTextView2.setTextColor(Color.parseColor("#666666"));
        pAGTextView2.setText(str2);
        pAGTextView2.setTextSize(14.0f);
        pAGTextView2.setLayoutParams(layoutParams3);
        pAGLinearLayout.addView(pAGTextView2);
        return pAGLinearLayout;
    }

    private int a(float f2) {
        return b0.a(getContext(), f2);
    }
}
