package com.mbridge.msdk.video.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.dynview.j.c;
import com.mbridge.msdk.video.module.a.a.e;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.widget.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MBridgeClickCTAView extends MBridgeBaseView {
    private ViewGroup n;
    private ImageView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private String s;
    private float t;
    private float u;
    private int v;
    private ObjectAnimator w;

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.w = objectAnimator;
    }

    public void setUnitId(String str) {
        this.s = str;
    }

    public MBridgeClickCTAView(Context context) {
        super(context);
    }

    public MBridgeClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    protected final void c() {
        super.c();
        if (this.f) {
            if (this.f2526b != null && this.f2526b.isDynamicView()) {
                setOnClickListener(new a() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.2
                    @Override // com.mbridge.msdk.widget.a
                    protected final void a(View view) {
                        MBridgeClickCTAView.b(MBridgeClickCTAView.this);
                    }
                });
            }
            this.q.setOnClickListener(new a() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.3
                @Override // com.mbridge.msdk.widget.a
                protected final void a(View view) {
                    MBridgeClickCTAView.b(MBridgeClickCTAView.this);
                }
            });
            ImageView imageView = this.o;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                    }
                });
            }
        }
    }

    public void preLoadData(b bVar) {
        if (this.f2526b != null) {
            if (this.f2526b.isDynamicView()) {
                com.mbridge.msdk.video.dynview.b.a().a(new c().b(this, this.f2526b), new g() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.1
                    @Override // com.mbridge.msdk.video.dynview.e.g
                    public final void a(com.mbridge.msdk.video.dynview.a aVar) {
                        if (aVar != null) {
                            this.addView(aVar.a());
                            MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                            mBridgeClickCTAView.f = mBridgeClickCTAView.b();
                            MBridgeClickCTAView mBridgeClickCTAView2 = MBridgeClickCTAView.this;
                            mBridgeClickCTAView2.r = (TextView) mBridgeClickCTAView2.findViewById(mBridgeClickCTAView2.findID("mbridge_tv_desc"));
                            MBridgeClickCTAView.this.c();
                        }
                    }

                    @Override // com.mbridge.msdk.video.dynview.e.g
                    public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                        aa.d(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
                    }
                });
            } else {
                int iFindLayout = findLayout("mbridge_reward_clickable_cta");
                if (iFindLayout >= 0) {
                    this.c.inflate(iFindLayout, this);
                    this.f = b();
                    c();
                    setWrapContent();
                }
            }
            if (this.f) {
                this.q.setText(this.f2526b.getAdCall());
                if (!TextUtils.isEmpty(this.f2526b.getIconUrl())) {
                    com.mbridge.msdk.foundation.same.c.b.a(this.a.getApplicationContext()).a(this.f2526b.getIconUrl(), new e(this.o, this.f2526b, this.s) { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.5
                        @Override // com.mbridge.msdk.video.module.a.a.e, com.mbridge.msdk.foundation.same.c.c
                        public final void onFailedLoad(String str, String str2) {
                            super.onFailedLoad(str, str2);
                            MBridgeClickCTAView.this.a();
                        }
                    });
                } else {
                    a();
                }
                if (this.p != null && !TextUtils.isEmpty(this.f2526b.getAppName())) {
                    this.p.setText(this.f2526b.getAppName());
                }
                if (this.r == null || TextUtils.isEmpty(this.f2526b.getAppDesc())) {
                    return;
                }
                this.r.setText(this.f2526b.getAppDesc());
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.v = configuration.orientation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ImageView imageView = this.o;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        this.n = (ViewGroup) findViewById(findID("mbridge_viewgroup_ctaroot"));
        this.o = (ImageView) findViewById(findID("mbridge_iv_appicon"));
        this.p = (TextView) findViewById(findID("mbridge_tv_title"));
        TextView textView = (TextView) findViewById(findID("mbridge_tv_install"));
        this.q = textView;
        return isNotNULL(this.n, this.o, this.p, textView);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.t = motionEvent.getRawX();
        this.u = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.w;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.w;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static /* synthetic */ void b(MBridgeClickCTAView mBridgeClickCTAView) {
        JSONObject jSONObject;
        JSONException e;
        if (mBridgeClickCTAView.f2526b != null && mBridgeClickCTAView.f2526b.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeClickCTAView.f2526b.getRewardTemplateMode();
                q.a(com.mbridge.msdk.foundation.controller.b.d().g(), "cta_click", mBridgeClickCTAView.f2526b.getCampaignUnitId(), mBridgeClickCTAView.f2526b.isBidCampaign(), mBridgeClickCTAView.f2526b.getRequestId(), mBridgeClickCTAView.f2526b.getRequestIdNotice(), mBridgeClickCTAView.f2526b.getId(), rewardTemplateMode != null ? rewardTemplateMode.b() + "" : "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.h, mBridgeClickCTAView.a(0));
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
            }
        } catch (JSONException e4) {
            jSONObject = null;
            e = e4;
        }
        mBridgeClickCTAView.e.a(105, jSONObject);
    }
}
