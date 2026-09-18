package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.layout.TTVideoTrafficTipsLayout;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: compiled from: VideoTrafficTipLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f703b;
    private Context c;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.a d;
    private c e;
    private boolean f = false;
    private b.a.a.a.a.a.a.f.b g;
    private ViewGroup h;

    /* JADX INFO: compiled from: VideoTrafficTipLayout.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.b();
            if (e.this.d != null) {
                e.this.d.a(b.START_VIDEO, (String) null);
            }
        }
    }

    /* JADX INFO: compiled from: VideoTrafficTipLayout.java */
    public enum b {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* JADX INFO: compiled from: VideoTrafficTipLayout.java */
    public interface c {
        void a();

        boolean d();
    }

    private void d() {
        this.g = null;
    }

    public boolean c() {
        View view = this.a;
        return view != null && view.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.c == null) {
            return;
        }
        a();
    }

    public void a(Context context, ViewGroup viewGroup) {
        if (context == null || !(viewGroup instanceof ViewGroup)) {
            return;
        }
        this.h = viewGroup;
        this.c = o.a().getApplicationContext();
    }

    private void a(Context context, View view, boolean z) {
        ViewGroup.LayoutParams layoutParamsA;
        if (context == null || view == null || this.a != null || (layoutParamsA = a(this.h)) == null) {
            return;
        }
        TTVideoTrafficTipsLayout tTVideoTrafficTipsLayout = new TTVideoTrafficTipsLayout(context);
        this.a = tTVideoTrafficTipsLayout;
        tTVideoTrafficTipsLayout.setLayoutParams(layoutParamsA);
        this.h.addView(this.a);
        this.f703b = (TextView) this.a.findViewById(h.b1);
        View viewFindViewById = this.a.findViewById(h.c1);
        if (z) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new a());
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    private ViewGroup.LayoutParams a(ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            return new RelativeLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof LinearLayout) {
            return new LinearLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        return null;
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.a aVar, c cVar) {
        this.e = cVar;
        this.d = aVar;
    }

    public boolean a(int i, b.a.a.a.a.a.a.f.b bVar, boolean z) {
        Context context = this.c;
        if (context == null || bVar == null) {
            return true;
        }
        a(context, this.h, z);
        this.g = bVar;
        if (i == 1 || i == 2) {
            return a(i);
        }
        return true;
    }

    private boolean a(int i) {
        c cVar;
        if (c() || this.f) {
            return true;
        }
        if (this.d != null && (cVar = this.e) != null) {
            if (cVar.d()) {
                this.d.d(null, null);
            }
            this.d.a(b.PAUSE_VIDEO, (String) null);
        }
        a(this.g, true);
        return false;
    }

    public void a(boolean z) {
        if (z) {
            d();
        }
        a();
    }

    private void a() {
        View view = this.a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void a(b.a.a.a.a.a.a.f.b bVar, boolean z) {
        View view;
        String str;
        View view2;
        if (bVar == null || (view = this.a) == null || this.c == null || view.getVisibility() == 0) {
            return;
        }
        c cVar = this.e;
        if (cVar != null) {
            cVar.a();
        }
        double dCeil = Math.ceil((bVar.p() * 1.0d) / 1048576.0d);
        if (z) {
            str = String.format(t.k(this.c, "tt_video_without_wifi_tips"), Float.valueOf(Double.valueOf(dCeil).floatValue()));
        } else {
            str = t.k(this.c, "tt_video_without_wifi_tips") + t.k(this.c, "tt_video_bytesize");
        }
        b0.a(this.a, 0);
        b0.a(this.f703b, str);
        Log.i("VideoTrafficTipLayout", "showTrafficTipCover: ");
        if (!b0.e(this.a) || (view2 = this.a) == null) {
            return;
        }
        view2.bringToFront();
        Log.i("VideoTrafficTipLayout", "showTrafficTipCover: bringToFront");
    }
}
