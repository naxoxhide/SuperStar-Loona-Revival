package com.applovin.impl.mediation.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.applovin.impl.adview.s;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes.dex */
public class a extends FrameLayout implements View.OnClickListener {
    private InterfaceC0116a aul;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.a.a$a, reason: collision with other inner class name */
    interface InterfaceC0116a {
        void a(a aVar);
    }

    public void setListener(InterfaceC0116a interfaceC0116a) {
        this.aul = interfaceC0116a;
    }

    public a(c cVar, Context context) {
        super(context);
        setOnClickListener(this);
        s sVar = new s(context);
        int iDpToPx = AppLovinSdkUtils.dpToPx(context, cVar.xo());
        sVar.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx, iDpToPx, 17));
        sVar.fZ(iDpToPx);
        addView(sVar);
        int iDpToPx2 = AppLovinSdkUtils.dpToPx(context, cVar.xo() + (cVar.xp() * 2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPx2, iDpToPx2, 8388661);
        int iDpToPx3 = AppLovinSdkUtils.dpToPx(context, cVar.xm());
        int iDpToPx4 = AppLovinSdkUtils.dpToPx(context, cVar.xn());
        layoutParams.setMargins(iDpToPx4, iDpToPx3, iDpToPx4, 0);
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aul.a(this);
    }
}
