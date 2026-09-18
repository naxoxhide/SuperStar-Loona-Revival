package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.b.a.a.h.u;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.f0.n;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle001001Layout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle002003HLayout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle002003Layout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle003002HLayout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle003002Layout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle009016HLayout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle009016VLayout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle016009HLayout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle016009VLayout;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FullInteractionStyleView extends BackupView {
    private float m;
    private int n;
    private int o;
    private int p;
    private View q;
    private View r;
    private FrameLayout s;
    private com.bytedance.sdk.openadsdk.core.c0.e t;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                TTWebsiteActivity.a(((BackupView) FullInteractionStyleView.this).a, ((BackupView) FullInteractionStyleView.this).f646b, ((BackupView) FullInteractionStyleView.this).e);
            } catch (Throwable th) {
                m.b("FullInteractionStyleView", th.getMessage());
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                TTWebsiteActivity.a(((BackupView) FullInteractionStyleView.this).a, ((BackupView) FullInteractionStyleView.this).f646b, ((BackupView) FullInteractionStyleView.this).e);
            } catch (Throwable th) {
                m.b("FullInteractionStyleView", th.getMessage());
            }
        }
    }

    public FullInteractionStyleView(Context context, String str) {
        super(context, str);
        this.p = 1;
        this.a = context;
    }

    private float getHeightDp() {
        return b0.b(this.a, b0.c(this.a));
    }

    private float getWidthDp() {
        return b0.b(this.a, b0.d(this.a));
    }

    private void n() {
        TextView textView = (TextView) this.q.findViewById(h.y0);
        if (textView != null) {
            textView.setText(getDescription());
            c(textView);
        }
    }

    private void o() {
        this.f = b0.a(this.a, this.n);
        this.g = b0.a(this.a, this.o);
        int i = (int) (this.m * 1000.0f);
        if (this.p == 1) {
            if (i == 666) {
                s();
                return;
            }
            if (i == 1000) {
                r();
                return;
            }
            if (i == 1500) {
                u();
                return;
            } else if (i == 1777) {
                p();
                return;
            } else {
                a(0.562f);
                w();
                return;
            }
        }
        if (i == 562) {
            x();
            return;
        }
        if (i == 666) {
            t();
            return;
        }
        if (i == 1000) {
            r();
        } else if (i == 1500) {
            v();
        } else {
            a(1.777f);
            q();
        }
    }

    private void p() {
        TTInteractionStyle016009VLayout tTInteractionStyle016009VLayout = new TTInteractionStyle016009VLayout(this.a);
        this.q = tTInteractionStyle016009VLayout;
        b(tTInteractionStyle016009VLayout);
        y();
        n();
    }

    private void q() {
        TTInteractionStyle016009HLayout tTInteractionStyle016009HLayout = new TTInteractionStyle016009HLayout(this.a);
        this.q = tTInteractionStyle016009HLayout;
        b(tTInteractionStyle016009HLayout);
        y();
    }

    private void r() {
        TTInteractionStyle001001Layout tTInteractionStyle001001Layout = new TTInteractionStyle001001Layout(this.a);
        this.q = tTInteractionStyle001001Layout;
        b(tTInteractionStyle001001Layout);
        y();
        n();
    }

    private void s() {
        TTInteractionStyle002003Layout tTInteractionStyle002003Layout = new TTInteractionStyle002003Layout(this.a);
        this.q = tTInteractionStyle002003Layout;
        b(tTInteractionStyle002003Layout);
        y();
        n();
    }

    private void t() {
        TTInteractionStyle002003HLayout tTInteractionStyle002003HLayout = new TTInteractionStyle002003HLayout(this.a);
        this.q = tTInteractionStyle002003HLayout;
        b(tTInteractionStyle002003HLayout);
        y();
        n();
    }

    private void u() {
        View tTInteractionStyle003002Layout = new TTInteractionStyle003002Layout(this.a);
        this.q = tTInteractionStyle003002Layout;
        b(tTInteractionStyle003002Layout);
        this.s = (FrameLayout) this.q.findViewById(h.A0);
        ImageView imageView = (ImageView) this.q.findViewById(h.B0);
        TextView textView = (TextView) this.q.findViewById(h.C0);
        ImageView imageView2 = (ImageView) this.q.findViewById(520093739);
        a(this.s, imageView);
        textView.setText(getDescription());
        c(this.s);
        c(imageView);
        c(textView);
        imageView2.setOnClickListener(new b());
    }

    private void v() {
        TTInteractionStyle003002HLayout tTInteractionStyle003002HLayout = new TTInteractionStyle003002HLayout(this.a);
        this.q = tTInteractionStyle003002HLayout;
        b(tTInteractionStyle003002HLayout);
        y();
    }

    private void w() {
        TTInteractionStyle009016VLayout tTInteractionStyle009016VLayout = new TTInteractionStyle009016VLayout(this.a);
        this.q = tTInteractionStyle009016VLayout;
        b(tTInteractionStyle009016VLayout);
        y();
    }

    private void x() {
        TTInteractionStyle009016HLayout tTInteractionStyle009016HLayout = new TTInteractionStyle009016HLayout(this.a);
        this.q = tTInteractionStyle009016HLayout;
        b(tTInteractionStyle009016HLayout);
        y();
        n();
    }

    private void y() {
        this.s = (FrameLayout) this.q.findViewById(h.A0);
        ImageView imageView = (ImageView) this.q.findViewById(h.z0);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) this.q.findViewById(h.s0);
        TextView textView = (TextView) this.q.findViewById(h.x0);
        TextView textView2 = (TextView) this.q.findViewById(h.t0);
        ImageView imageView2 = (ImageView) this.q.findViewById(520093739);
        if (!TextUtils.isEmpty(this.f646b.r())) {
            textView2.setText(this.f646b.r());
        }
        a(this.s, imageView);
        if (this.f646b.b0() != null && !TextUtils.isEmpty(this.f646b.b0().d())) {
            com.bytedance.sdk.openadsdk.n.c.b().a(this.f646b.b0().d(), this.f646b.b0().e(), this.f646b.b0().b(), tTRoundRectImageView, this.f646b);
        }
        textView.setText(getTitle());
        c(this.s);
        c(imageView);
        c(tTRoundRectImageView);
        c(textView);
        c(textView2);
        imageView2.setOnClickListener(new a());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(View view, int i, com.bytedance.sdk.openadsdk.core.f0.m mVar) {
    }

    public View getInteractionStyleRootView() {
        return this;
    }

    public FrameLayout getVideoContainer() {
        return this.s;
    }

    public void setDownloadListener(com.bytedance.sdk.openadsdk.core.c0.e eVar) {
        this.t = eVar;
    }

    public void setIsMute(boolean z) {
        View view = this.r;
        if (view != null && (view instanceof NativeVideoTsView)) {
            ((NativeVideoTsView) view).setIsQuiet(z);
        }
    }

    private void b(View view) {
        if (view.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            view.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            addView(view);
        }
    }

    private void c(View view) {
        if (view == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.c0.b aVar = this.t;
        if (aVar == null) {
            Context context = this.a;
            q qVar = this.f646b;
            String str = this.e;
            aVar = new com.bytedance.sdk.openadsdk.core.c0.a(context, qVar, str, a0.f(str));
            aVar.a(a(this.f646b, this.a));
        }
        view.setOnTouchListener(aVar);
        view.setOnClickListener(aVar);
    }

    public void a(q qVar, float f, int i, int i2, int i3) {
        this.m = f;
        this.p = i;
        this.f646b = qVar;
        this.e = "fullscreen_interstitial_ad";
        this.n = i2;
        this.o = i3;
        e(this.h);
        o();
    }

    private void a(FrameLayout frameLayout, ImageView imageView) {
        q qVar = this.f646b;
        if (qVar == null) {
            return;
        }
        boolean zC = q.c(qVar);
        if (this.f646b.N0() != null && zC) {
            b0.a((View) imageView, 8);
            b0.a((View) frameLayout, 0);
        } else {
            a(imageView);
            b0.a((View) imageView, 0);
            b0.a((View) frameLayout, 8);
        }
    }

    private void a(ImageView imageView) {
        List<n> listD0;
        n nVar;
        q qVar = this.f646b;
        if (qVar == null || (listD0 = qVar.d0()) == null || listD0.size() <= 0 || (nVar = listD0.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.d.a(nVar).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.h.c.a(this.f646b, nVar.d(), imageView));
    }

    private b.c.a.a.a.a.c a(q qVar, Context context) {
        if (qVar != null && qVar.e0() == 4) {
            return new b.c.a.a.a.a.b(context, qVar, this.e);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0072  */
    private void a(float f) {
        float fMin;
        float fMax;
        int iMax;
        int iMax2;
        float heightDp = getHeightDp();
        float widthDp = getWidthDp();
        if (this.p == 2) {
            fMin = Math.max(heightDp, widthDp);
            fMax = Math.min(heightDp, widthDp);
        } else {
            fMin = Math.min(heightDp, widthDp);
            fMax = Math.max(heightDp, widthDp);
        }
        if (this.p != 2 && b0.a((Activity) this.a)) {
            fMax -= b0.b(this.a, b0.b());
        }
        int i = 20;
        int i2 = 0;
        if (this.p != 2) {
            if (f == 0.0f || f == 100.0f) {
                iMax2 = 0;
                iMax = 0;
                i = 0;
            } else {
                float f2 = 20;
                iMax2 = (int) Math.max((fMax - (((fMin - f2) - f2) / f)) / 2.0f, 0.0f);
                iMax = 20;
                i2 = 20;
                i = iMax2;
            }
        } else if (f == 0.0f || f == 100.0f) {
            iMax2 = 0;
            iMax = 0;
            i = 0;
        } else {
            float f3 = 20;
            iMax = (int) Math.max((fMin - (((fMax - f3) - f3) * f)) / 2.0f, 0.0f);
            i2 = iMax;
            iMax2 = 20;
        }
        ((Activity) this.a).getWindow().getDecorView().setPadding(b0.a(this.a, i2), b0.a(this.a, i), b0.a(this.a, iMax), b0.a(this.a, iMax2));
    }
}
