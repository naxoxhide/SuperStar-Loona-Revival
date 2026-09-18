package com.tapjoy;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tapjoy.internal.h9;
import com.tapjoy.internal.i9;
import com.tapjoy.internal.j9;
import com.tapjoy.internal.k9;
import com.tapjoy.internal.l9;
import com.tapjoy.internal.m9;
import com.tapjoy.internal.n9;
import com.tapjoy.internal.o9;
import com.tapjoy.internal.p9;
import com.tapjoy.internal.r9;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TJSplitWebView extends RelativeLayout {
    public TJWebView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p9 f2701b;
    public p9 c;
    public String d;
    public String e;
    public String f;
    public Uri g;
    public HashSet h;
    public final JSONObject i;
    public TJAdUnitJSBridge j;
    public final Context k;
    public final Boolean l;
    public final boolean m;
    public RelativeLayout n;
    public FrameLayout o;
    public ProgressBar p;
    public TextView q;
    public TJImageButton r;
    public TJImageButton s;
    public final String t;
    public boolean u;
    public String v;
    public String w;
    public String x;

    public TJSplitWebView(Context context, JSONObject jSONObject, TJAdUnitJSBridge tJAdUnitJSBridge) {
        super(context);
        this.j = tJAdUnitJSBridge;
        this.k = context;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_LAYOUT);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(TJAdUnitConstants.String.SPLIT_VIEW_EXIT_HOSTS);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_ERROR_DIALOG_STRINGS);
        this.t = jSONObject.optString(TJAdUnitConstants.String.SPLIT_VIEW_URL_FOR_EXTERNAL_OPEN);
        this.i = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_ANIMATION);
        setLayoutOption(jSONObjectOptJSONObject);
        setExitHosts(jSONArrayOptJSONArray);
        setErrorDialog(jSONObjectOptJSONObject2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        TJWebView tJWebView = new TJWebView(context);
        this.a = tJWebView;
        tJWebView.setId(TapjoyUtil.generateViewId());
        this.a.setBackgroundColor(-1);
        WebSettings settings = this.a.getSettings();
        if (settings != null) {
            settings.setUseWideViewPort(true);
        }
        this.a.setWebViewClient(new x(this));
        Boolean boolValueOf = Boolean.valueOf(jSONObject.optBoolean(TJAdUnitConstants.String.SPLIT_VIEW_SHOW_TOOLBAR));
        this.l = boolValueOf;
        this.m = jSONObject.optBoolean(TJAdUnitConstants.String.SPLIT_VIEW_SHOW_URL, true);
        if (boolValueOf.booleanValue()) {
            addToolbar();
            addLineBreak();
            addProgressBar();
            this.a.setWebChromeClient(new h9(this));
        }
        addView(this.a, layoutParams);
    }

    public final void a(int i, int i2) {
        p9 p9Var = i <= i2 ? this.f2701b : this.c;
        if (p9Var == null) {
            this.a.setVisibility(4);
            return;
        }
        double d = i;
        int i3 = (int) (p9Var.a * d);
        double d2 = i2;
        int i4 = (int) (p9Var.f2799b * d2);
        if (i3 == 0 || i4 == 0) {
            this.a.setVisibility(4);
            return;
        }
        int i5 = (int) (d * p9Var.c);
        int i6 = (int) (d2 * p9Var.d);
        int i7 = (i - i3) - i5;
        int i8 = (i2 - i4) - i6;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i4;
        Boolean bool = this.l;
        if (bool == null || !bool.booleanValue()) {
            layoutParams.setMargins(i5, i6, i7, i8);
        } else {
            float screenDensityScale = new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale();
            int height = this.o.getHeight() + ((int) (40.0f * screenDensityScale));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams2.setMargins(i5, i6, i7, i8);
            this.n.setLayoutParams(layoutParams2);
            layoutParams.setMargins(i5, i6 + height, i7, i8);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i3, (int) screenDensityScale);
            layoutParams3.setMargins(i5, layoutParams.topMargin - this.p.getHeight(), i7, i8);
            this.p.setLayoutParams(layoutParams3);
            this.o.setLayoutParams(layoutParams3);
        }
        this.a.setLayoutParams(layoutParams);
        this.a.setVisibility(0);
        float f = p9Var.e;
        if (f <= 0.0f) {
            this.a.setBackground(null);
            this.a.setClipToOutline(false);
            Boolean bool2 = this.l;
            if (bool2 == null || !bool2.booleanValue()) {
                return;
            }
            this.n.setClipToOutline(false);
            return;
        }
        float[] fArr = new float[8];
        float f2 = f * getResources().getDisplayMetrics().density;
        Boolean bool3 = this.l;
        if (bool3 != null && bool3.booleanValue()) {
            this.n.setOutlineProvider(new o9(f2));
            this.n.setClipToOutline(true);
            return;
        }
        Arrays.fill(fArr, f2);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(-1);
        this.a.setBackground(shapeDrawable);
        this.a.setClipToOutline(true);
    }

    public void addLineBreak() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.o = frameLayout;
        frameLayout.setBackgroundColor(Color.parseColor("#dddddd"));
        addView(this.o);
    }

    public void addProgressBar() {
        ProgressBar progressBar = new ProgressBar(this.k, null, R.attr.progressBarStyleHorizontal);
        this.p = progressBar;
        progressBar.setMax(100);
        this.p.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#5d95ff")));
        this.p.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#dddddd")));
        addView(this.p);
    }

    public void addToolbar() {
        RelativeLayout relativeLayout = new RelativeLayout(this.k);
        this.n = relativeLayout;
        relativeLayout.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale() * 40.0f));
        layoutParams.addRule(6);
        this.n.setBackgroundColor(-1);
        this.n.setVisibility(0);
        setupToolbarUI();
        addView(this.n, layoutParams);
    }

    public void animateOpen(ViewGroup viewGroup) {
        JSONObject jSONObject = this.i;
        if (jSONObject != null && jSONObject.has(TJAdUnitConstants.String.ANIMATION_EVENT_ON_OPEN) && this.i.optString(TJAdUnitConstants.String.ANIMATION_EVENT_ON_OPEN).equalsIgnoreCase(TJAdUnitConstants.String.ANIMATION_TYPE_SLIDE_UP)) {
            setY(viewGroup.getHeight());
            animate().translationY(0.0f);
        }
    }

    public void applyLayoutOption(JSONObject jSONObject) {
        setLayoutOption(jSONObject);
        a(getWidth(), getHeight());
    }

    public String getLastUrl() {
        return this.e;
    }

    public boolean goBack() {
        if (!this.a.canGoBack()) {
            return false;
        }
        this.a.goBack();
        return true;
    }

    public void isFirstOrLastPage() {
        this.r.setEnabled(this.a.canGoBack());
        this.s.setEnabled(this.a.canGoForward());
    }

    public void loadUrl(String str) {
        TJWebView tJWebView = this.a;
        if (tJWebView != null) {
            this.d = str;
            this.e = str;
            tJWebView.loadUrl(str);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.a != null) {
            a(size, size2);
        }
        super.onMeasure(i, i2);
    }

    public void openInExternalBrowser() {
        Uri uri;
        if (TextUtils.isEmpty(this.t)) {
            uri = Uri.parse(this.a.getUrl());
            if (uri == null) {
                uri = Uri.parse(getLastUrl());
            }
        } else {
            uri = Uri.parse(this.t);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        if (this.a.getContext() != null) {
            try {
                this.a.getContext().startActivity(intent);
            } catch (Exception e) {
                TapjoyLog.d("TJSplitWebView", e.getMessage());
            }
        }
    }

    public void setErrorDialog(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.u = true;
            this.v = jSONObject.optString("description");
            this.w = jSONObject.optString("close");
            this.x = jSONObject.optString("reload");
        }
    }

    public void setExitHosts(JSONArray jSONArray) {
        if (jSONArray == null) {
            this.h = null;
            return;
        }
        this.h = new HashSet();
        for (int i = 0; i <= jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            if (strOptString != null) {
                this.h.add(strOptString);
            }
        }
    }

    public void setLayoutOption(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(TJAdUnitConstants.String.LANDSCAPE);
            this.c = jSONObjectOptJSONObject != null ? new p9(jSONObjectOptJSONObject) : null;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.PORTRAIT);
            this.f2701b = jSONObjectOptJSONObject2 != null ? new p9(jSONObjectOptJSONObject2) : null;
        }
    }

    public void setTrigger(String str, String str2) {
        this.f = r9.a(str);
        this.g = str2 != null ? Uri.parse(str2) : null;
    }

    public void setUserAgent(String str) {
        this.a.getSettings().setUserAgentString(str);
    }

    public void setupToolbarUI() {
        float screenDensityScale = new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        TJImageButton tJImageButton = new TJImageButton(this.k);
        this.r = tJImageButton;
        tJImageButton.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        int i = (int) (10.0f * screenDensityScale);
        layoutParams.setMargins(i, i, i, i);
        int i2 = (int) (5.0f * screenDensityScale);
        this.r.setPadding(i2, i, i, i);
        this.r.setEnabledImageBitmap(TapjoyIcons.getBackEnabledImage(screenDensityScale));
        this.r.setDisableImageBitmap(TapjoyIcons.getBackDisabledImage(screenDensityScale));
        this.r.setBackgroundColor(0);
        this.r.setOnClickListener(new i9(this));
        relativeLayout.addView(this.r, layoutParams);
        this.s = new TJImageButton(this.k);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, this.r.getId());
        layoutParams2.setMargins(i, i, i, i);
        this.s.setPadding(i, i, i2, i);
        this.s.setEnabledImageBitmap(TapjoyIcons.getForwardEnabledImage(screenDensityScale));
        this.s.setDisableImageBitmap(TapjoyIcons.getForwardDisabledImage(screenDensityScale));
        this.s.setBackgroundColor(0);
        this.s.setOnClickListener(new j9(this));
        relativeLayout.addView(this.s, layoutParams2);
        ImageButton imageButton = new ImageButton(this.k);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(i, i, i, i);
        imageButton.setPadding(i2, i2, i2, i2);
        imageButton.setImageBitmap(TapjoyIcons.getCloseImage(screenDensityScale));
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(new k9(this));
        relativeLayout.addView(imageButton, layoutParams3);
        TextView textView = new TextView(this.k);
        this.q = textView;
        textView.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.q.setMaxLines(1);
        this.q.setMaxEms(200);
        this.q.setTextAlignment(4);
        this.q.setTextColor(Color.parseColor("#5d95ff"));
        this.q.setBackgroundColor(0);
        this.q.setEnabled(false);
        this.q.setTypeface(Typeface.create("sans-serif-medium", 0));
        relativeLayout.addView(this.q, layoutParams4);
        ImageButton imageButton2 = new ImageButton(this.k);
        imageButton2.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(1, this.q.getId());
        layoutParams5.addRule(15);
        imageButton2.setPadding(i2, i2, i2, i2);
        imageButton2.setImageBitmap(TapjoyIcons.getOpenBrowserImage(screenDensityScale));
        imageButton2.setBackgroundColor(0);
        imageButton2.setOnClickListener(new l9(this));
        relativeLayout.addView(imageButton2, layoutParams5);
        if (!this.m) {
            this.q.setVisibility(4);
            imageButton2.setVisibility(4);
        }
        this.n.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -2));
    }

    public void showErrorDialog() {
        new AlertDialog.Builder(this.k, R.style.Theme.Material.Light.Dialog.Alert).setMessage(this.v).setPositiveButton(this.w, new n9()).setNegativeButton(this.x, new m9(this)).create().show();
    }
}
