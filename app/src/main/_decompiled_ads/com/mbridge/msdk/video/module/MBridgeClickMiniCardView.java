package com.mbridge.msdk.video.module;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.videocommon.download.g;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MBridgeClickMiniCardView extends MBridgeH5EndCardView {
    private boolean y;

    public MBridgeClickMiniCardView(Context context) {
        super(context);
        this.y = false;
    }

    public MBridgeClickMiniCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = false;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView, com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        if (this.f) {
            a(this.n);
        }
        super.onSelfConfigurationChanged(configuration);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    protected final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    protected final void e() {
        super.e();
        if (this.f) {
            setBackgroundResource(findColor("mbridge_reward_minicard_bg"));
            a(this.n);
            setClickable(true);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    protected final String a() {
        if (this.f2526b == null) {
            return null;
        }
        CampaignEx.c rewardTemplateMode = this.f2526b.getRewardTemplateMode();
        String strD = rewardTemplateMode != null ? rewardTemplateMode.d() : null;
        if (TextUtils.isEmpty(strD) || !strD.contains(".zip")) {
            return strD;
        }
        String strB = g.a().b(strD);
        return !TextUtils.isEmpty(strB) ? strB : strD;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void preLoadData(b bVar) {
        super.preLoadData(bVar);
        setCloseVisible(0);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void webviewshow() {
        if (this.q != null) {
            this.q.post(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeClickMiniCardView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        aa.a(MBridgeBaseView.TAG, "webviewshow");
                        String string = "";
                        try {
                            int[] iArr = new int[2];
                            MBridgeClickMiniCardView.this.q.getLocationOnScreen(iArr);
                            aa.d(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", af.a(com.mbridge.msdk.foundation.controller.b.d().g(), iArr[0]));
                            jSONObject.put("startY", af.a(com.mbridge.msdk.foundation.controller.b.d().g(), iArr[1]));
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeClickMiniCardView.this.q, "webviewshow", Base64.encodeToString(string.toString().getBytes(), 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            HashMap map = new HashMap();
            map.put("type", "3");
            m.a().a("2000133", this.f2526b, map);
        }
    }

    private void a(View view) {
        int i = af.i(this.a);
        int iH = (int) ((af.h(this.a) * 0.7f) + 0.5f);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) ((i * 0.7f) + 0.5f);
        layoutParams.height = iH;
        view.setLayoutParams(layoutParams);
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        setBackgroundColor(0);
    }

    public void setMBridgeClickMiniCardViewClickable(boolean z) {
        setClickable(z);
    }

    public void setMiniCardLocation(int i, int i2, int i3, int i4) {
        this.y = true;
        resizeMiniCard(i3, i4);
    }

    public void resizeMiniCard(int i, int i2) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        View viewFindViewById = ((Activity) this.a).getWindow().findViewById(R.id.content);
        int width = viewFindViewById.getWidth();
        int height = viewFindViewById.getHeight();
        if (i <= 0 || i2 <= 0 || i > width || i2 > height) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.n.setLayoutParams(layoutParams);
    }

    public void setRadius(int i) {
        if (i > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(af.b(getContext(), i));
            gradientDrawable.setColor(-1);
            if (Build.VERSION.SDK_INT >= 16) {
                this.q.setBackground(gradientDrawable);
            } else {
                this.q.setBackgroundDrawable(gradientDrawable);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.q.setClipToOutline(true);
            }
        }
    }
}
