package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MBridgeVideoEndCoverView extends MBridgeBaseView {
    private final String n;
    private View o;
    private ImageView p;
    private ImageView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private b u;

    public MBridgeVideoEndCoverView(Context context) {
        super(context);
        this.n = "MBridgeVideoEndCoverView";
    }

    public MBridgeVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = "MBridgeVideoEndCoverView";
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_videoend_cover");
        if (iFindLayout >= 0) {
            View viewInflate = this.c.inflate(iFindLayout, (ViewGroup) null);
            this.o = viewInflate;
            if (viewInflate != null) {
                this.f = a(viewInflate);
                addView(this.o, -1, -1);
                c();
            }
        }
    }

    public void preLoadData(b bVar) {
        this.u = bVar;
        try {
            if (this.f2526b == null || !this.f || this.f2526b == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.f2526b.getIconUrl()) && this.p != null) {
                com.mbridge.msdk.foundation.same.c.b.a(this.a.getApplicationContext()).a(this.f2526b.getIconUrl(), new j(this.p, af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 8.0f)));
            }
            TextView textView = this.r;
            if (textView != null) {
                textView.setText(this.f2526b.getAppName());
            }
            TextView textView2 = this.t;
            if (textView2 != null) {
                textView2.setText(this.f2526b.getAdCall());
            }
            TextView textView3 = this.s;
            if (textView3 != null) {
                textView3.setText(this.f2526b.getAppDesc());
            }
        } catch (Throwable th) {
            aa.a("MBridgeVideoEndCoverView", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.g = motionEvent.getRawX();
        this.h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.d = configuration.orientation;
        removeView(this.o);
        View view = this.o;
        if (view == null) {
            init(this.a);
            preLoadData(this.u);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.o.getParent()).removeView(this.o);
        }
        addView(this.o);
        a(this.o);
        c();
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.p = (ImageView) view.findViewById(findID("mbridge_vec_iv_icon"));
            this.q = (ImageView) view.findViewById(findID("mbridge_vec_iv_close"));
            this.r = (TextView) view.findViewById(findID("mbridge_vec_tv_title"));
            this.s = (TextView) view.findViewById(findID("mbridge_vec_tv_desc"));
            this.t = (TextView) view.findViewById(findID("mbridge_vec_btn"));
            return true;
        } catch (Throwable th) {
            aa.d("MBridgeVideoEndCoverView", th.getMessage());
            return false;
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    protected final void c() {
        super.c();
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoEndCoverView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.e.a(104, "");
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoEndCoverView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoEndCoverView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
    }

    protected final void a() {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2;
        JSONException e2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(a.f, af.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.g));
                    jSONObject2.put(a.g, af.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.h));
                    jSONObject2.put(a.i, 0);
                    try {
                        this.d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    jSONObject2.put(a.j, this.d);
                    jSONObject2.put(a.k, af.e(getContext()));
                } catch (JSONException e4) {
                    e2 = e4;
                    aa.d("MBridgeVideoEndCoverView", e2.getMessage());
                }
            } catch (JSONException e5) {
                jSONObject2 = jSONObject3;
                e2 = e5;
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.h, jSONObject2);
            } catch (JSONException e6) {
                e = e6;
                e.printStackTrace();
            }
        } catch (JSONException e7) {
            jSONObject = null;
            e = e7;
        }
        this.e.a(105, jSONObject);
    }
}
