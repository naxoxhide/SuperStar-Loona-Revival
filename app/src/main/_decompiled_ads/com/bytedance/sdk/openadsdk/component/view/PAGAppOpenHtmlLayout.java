package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.widget.DSPAdChoice;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class PAGAppOpenHtmlLayout extends PAGAppOpenBaseLayout {
    b k;

    public interface b {
        void a();

        void a(View view, int i);

        void b();
    }

    public PAGAppOpenHtmlLayout(Context context, q qVar) {
        super(context);
        a(context, qVar);
    }

    private void a(Context context, q qVar) {
        DspHtmlWebView dspHtmlWebView = new DspHtmlWebView(context);
        c.c().c(dspHtmlWebView);
        dspHtmlWebView.a(qVar, new a(), "open_ad");
        addView(dspHtmlWebView, new ViewGroup.LayoutParams(-1, -1));
        dspHtmlWebView.v();
        int iA = b0.a(context, 9.0f);
        int iA2 = b0.a(context, 10.0f);
        this.d = new PAGTextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b0.a(context, 31.0f), b0.a(context, 14.0f));
        layoutParams.leftMargin = iA2;
        layoutParams.bottomMargin = iA2;
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        this.d.setBackgroundResource(t.e(context, "tt_ad_logo_new"));
        this.d.setGravity(17);
        addView(this.d, layoutParams);
        DSPAdChoice dSPAdChoice = new DSPAdChoice(context);
        this.j = dSPAdChoice;
        dSPAdChoice.setPadding(iA, 0, iA, 0);
        this.j.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b0.a(context, 32.0f), b0.a(context, 14.0f));
        layoutParams2.addRule(12);
        layoutParams2.addRule(11);
        layoutParams2.setMargins(0, 0, iA2, iA2);
        addView(this.j, layoutParams2);
        View view = this.i;
        if (view != null) {
            addView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k = null;
    }

    public void setRenderListener(b bVar) {
        this.k = bVar;
    }

    class a implements DspHtmlWebView.e {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.e
        public void a(View view, int i) {
            b bVar = PAGAppOpenHtmlLayout.this.k;
            if (bVar != null) {
                bVar.a(view, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.e
        public View c() {
            return PAGAppOpenHtmlLayout.this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.e
        public View d() {
            PAGAppOpenTopBarView pAGAppOpenTopBarView = PAGAppOpenHtmlLayout.this.i;
            if (pAGAppOpenTopBarView != null) {
                return pAGAppOpenTopBarView.getTopDislike();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.e
        public void a() {
            b bVar = PAGAppOpenHtmlLayout.this.k;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.e
        public void a(int i, int i2) {
            b bVar = PAGAppOpenHtmlLayout.this.k;
            if (bVar != null) {
                bVar.b();
            }
        }
    }
}
