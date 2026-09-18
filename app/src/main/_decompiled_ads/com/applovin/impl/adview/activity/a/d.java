package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.v;
import com.applovin.impl.sdk.ad.e;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    @Override // com.applovin.impl.adview.activity.a.a
    public /* bridge */ /* synthetic */ void a(n nVar) {
        super.a(nVar);
    }

    @Override // com.applovin.impl.adview.activity.a.a
    public /* bridge */ /* synthetic */ void k(View view) {
        super.k(view);
    }

    public d(e eVar, Activity activity, com.applovin.impl.sdk.n nVar) {
        super(eVar, activity, nVar);
    }

    public void a(ImageView imageView, n nVar, n nVar2, com.applovin.impl.adview.a aVar, v vVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.aiM.addView(appLovinAdView);
        if (nVar != null) {
            a(this.aiL.GL(), (this.aiL.GQ() ? 3 : 5) | 48, nVar);
        }
        if (nVar2 != null) {
            a(this.aiL.GL(), (this.aiL.GP() ? 3 : 5) | 48, nVar2);
        }
        if (imageView != null) {
            int iDpToPx = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNe)).intValue());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPx, iDpToPx, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNg)).intValue());
            int iDpToPx2 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNf)).intValue());
            layoutParams.setMargins(iDpToPx2, iDpToPx2, iDpToPx2, iDpToPx2);
            this.aiM.addView(imageView, layoutParams);
        }
        if (aVar != null) {
            this.aiM.addView(aVar, this.aiN);
        }
        if (vVar != null) {
            this.aiM.addView(vVar, new ViewGroup.LayoutParams(-1, -1));
        }
        if (viewGroup != null) {
            viewGroup.addView(this.aiM);
        } else {
            this.ahM.setContentView(this.aiM);
        }
    }
}
