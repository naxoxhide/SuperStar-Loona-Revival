package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import b.b.a.a.d.d.h.h;
import b.b.a.a.d.d.i.j;
import com.bytedance.sdk.component.adexpress.widget.AnimationText;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicTextView extends DynamicBaseWidgetImp {

    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.m.getLayoutParams();
                DynamicTextView dynamicTextView = DynamicTextView.this;
                layoutParams.height = dynamicTextView.f + this.a;
                dynamicTextView.m.setLayoutParams(layoutParams);
                DynamicTextView.this.m.setTranslationY(-this.a);
                ((ViewGroup) DynamicTextView.this.m.getParent()).setClipChildren(false);
                ((ViewGroup) DynamicTextView.this.m.getParent().getParent()).setClipChildren(false);
            } catch (Throwable unused) {
            }
        }
    }

    public DynamicTextView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        if (this.j.Z()) {
            AnimationText animationText = new AnimationText(context, this.j.S(), this.j.s(), 1, this.j.P());
            this.m = animationText;
            animationText.setMaxLines(1);
        } else {
            TextView textView = new TextView(context);
            this.m = textView;
            textView.setIncludeFontPadding(false);
        }
        this.m.setTag(Integer.valueOf(getClickArea()));
        addView(this.m, getWidgetLayoutParams());
    }

    private boolean k() {
        DynamicRootView dynamicRootView = this.l;
        return (dynamicRootView == null || dynamicRootView.getRenderRequest() == null || this.l.getRenderRequest().l() == 4) ? false : true;
    }

    private void l() {
        int iA;
        if (TextUtils.equals(this.k.n().f(), "source") || TextUtils.equals(this.k.n().f(), "title") || TextUtils.equals(this.k.n().f(), "text_star")) {
            int[] iArrA = j.a(this.j.O(), this.j.s(), true);
            int iA2 = (int) b.b.a.a.d.g.d.a(getContext(), this.j.L());
            int iA3 = (int) b.b.a.a.d.g.d.a(getContext(), this.j.J());
            int iA4 = (int) b.b.a.a.d.g.d.a(getContext(), this.j.K());
            int iA5 = (int) b.b.a.a.d.g.d.a(getContext(), this.j.I());
            int iMin = Math.min(iA2, iA5);
            if (TextUtils.equals(this.k.n().f(), "source") && (iA = ((this.f - ((int) b.b.a.a.d.g.d.a(getContext(), this.j.s()))) - iA2) - iA5) > 1 && iA <= iMin * 2) {
                int i = iA / 2;
                this.m.setPadding(iA3, iA2 - i, iA4, iA5 - (iA - i));
                return;
            }
            int i2 = (((iArrA[1] + iA2) + iA5) - this.f) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= iMin * 2) {
                int i3 = i2 / 2;
                this.m.setPadding(iA3, iA2 - i3, iA4, iA5 - (i2 - i3));
            } else if (i2 > iA2 + iA5) {
                int i4 = (i2 - iA2) - iA5;
                this.m.setPadding(iA3, 0, iA4, 0);
                if (i4 <= ((int) b.b.a.a.d.g.d.a(getContext(), 1.0f)) + 1) {
                    ((TextView) this.m).setTextSize(this.j.s() - 1.0f);
                } else if (i4 <= (((int) b.b.a.a.d.g.d.a(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.m).setTextSize(this.j.s() - 2.0f);
                } else {
                    post(new a(i4));
                }
            } else if (iA2 > iA5) {
                this.m.setPadding(iA3, iA2 - (i2 - iMin), iA4, iA5 - iMin);
            } else {
                this.m.setPadding(iA3, iA2 - iMin, iA4, iA5 - (i2 - iMin));
            }
        }
        if (!TextUtils.equals(this.k.n().f(), "fillButton") || Build.VERSION.SDK_INT < 17) {
            return;
        }
        this.m.setTextAlignment(2);
        ((TextView) this.m).setGravity(17);
    }

    private void m() {
        if (this.m instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                arrayList.add(text);
            }
            ((AnimationText) this.m).setMaxLines(1);
            ((AnimationText) this.m).setTextColor(this.j.S());
            ((AnimationText) this.m).setTextSize(this.j.s());
            ((AnimationText) this.m).setAnimationText(arrayList);
            ((AnimationText) this.m).setAnimationType(this.j.R());
            ((AnimationText) this.m).setAnimationDuration(this.j.Q() * 1000);
            ((AnimationText) this.m).b();
        }
    }

    public void a(TextView textView, int i, Context context, String str) {
        textView.setText("(" + String.format(t.k(context, str), Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        int i;
        super.c();
        if (TextUtils.isEmpty(getText())) {
            this.m.setVisibility(4);
            return true;
        }
        if (this.j.Z()) {
            m();
            return true;
        }
        ((TextView) this.m).setText(this.j.O());
        if (Build.VERSION.SDK_INT >= 17) {
            ((TextView) this.m).setTextDirection(5);
            this.m.setTextAlignment(this.j.P());
        }
        ((TextView) this.m).setTextColor(this.j.S());
        ((TextView) this.m).setTextSize(this.j.s());
        if (this.j.X()) {
            int iG = this.j.G();
            if (iG > 0) {
                ((TextView) this.m).setLines(iG);
                ((TextView) this.m).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.m).setMaxLines(1);
            ((TextView) this.m).setGravity(17);
            ((TextView) this.m).setEllipsize(TextUtils.TruncateAt.END);
        }
        h hVar = this.k;
        if (hVar != null && hVar.n() != null) {
            if (b.b.a.a.d.c.c() && k() && (TextUtils.equals(this.k.n().f(), "text_star") || TextUtils.equals(this.k.n().f(), "score-count") || TextUtils.equals(this.k.n().f(), "score-count-type-1") || TextUtils.equals(this.k.n().f(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.k.n().f(), "score-count") || TextUtils.equals(this.k.n().f(), "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (Exception unused) {
                    }
                } catch (NumberFormatException unused2) {
                    i = -1;
                }
                if (i < 0) {
                    if (b.b.a.a.d.c.c()) {
                        setVisibility(8);
                        return true;
                    }
                    this.m.setVisibility(0);
                }
                if (TextUtils.equals(this.k.n().f(), "score-count-type-2")) {
                    ((TextView) this.m).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                    ((TextView) this.m).setGravity(17);
                    return true;
                }
                a((TextView) this.m, i, getContext(), "tt_comment_num");
            } else if (TextUtils.equals(this.k.n().f(), "text_star")) {
                double d = -1.0d;
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception e) {
                    m.b("DynamicStarView applyNativeStyle", e.toString());
                }
                if (d < 0.0d || d > 5.0d) {
                    if (b.b.a.a.d.c.c()) {
                        setVisibility(8);
                        return true;
                    }
                    this.m.setVisibility(0);
                }
                ((TextView) this.m).setIncludeFontPadding(false);
                ((TextView) this.m).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.k.n().f())) {
                ((TextView) this.m).setText("Permission list | Privacy policy");
            } else if (TextUtils.equals(this.k.n().f(), "development-name")) {
                ((TextView) this.m).setText(t.k(b.b.a.a.d.c.a(), "tt_text_privacy_development") + getText());
            } else if (TextUtils.equals(this.k.n().f(), "app-version")) {
                ((TextView) this.m).setText(t.k(b.b.a.a.d.c.a(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.m).setText(getText());
            }
            if (Build.VERSION.SDK_INT >= 17) {
                this.m.setTextAlignment(this.j.P());
                ((TextView) this.m).setGravity(this.j.t());
            }
            if (b.b.a.a.d.c.c()) {
                l();
            }
        }
        return true;
    }

    public String getText() {
        String strO = this.j.O();
        if (TextUtils.isEmpty(strO)) {
            if (!b.b.a.a.d.c.c() && TextUtils.equals(this.k.n().f(), "text_star")) {
                strO = CampaignEx.CLICKMODE_ON;
            }
            if (!b.b.a.a.d.c.c() && TextUtils.equals(this.k.n().f(), "score-count")) {
                strO = "6870";
            }
        }
        return (TextUtils.equals(this.k.n().f(), "title") || TextUtils.equals(this.k.n().f(), "subtitle")) ? strO.replace("\n", "") : strO;
    }
}
