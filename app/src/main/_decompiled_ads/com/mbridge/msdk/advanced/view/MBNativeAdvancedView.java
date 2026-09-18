package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.advanced.js.b;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MBNativeAdvancedView extends RelativeLayout {
    private static String a = "MBAdvancedNativeView";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MBNativeAdvancedWebview f1899b;
    private View c;
    private boolean d;
    private boolean e;
    private boolean f;
    private b g;
    private Context h;

    public void setH5Ready(boolean z) {
        this.d = z;
    }

    public void setVideoReady(boolean z) {
        this.e = z;
    }

    public boolean isEndCardReady() {
        return this.f;
    }

    public void setEndCardReady(boolean z) {
        this.f = z;
    }

    public boolean isH5Ready() {
        return this.d;
    }

    public boolean isVideoReady() {
        return this.e;
    }

    public void resetLoadState() {
        this.f = false;
        this.e = false;
        this.d = false;
    }

    public b getAdvancedNativeSignalCommunicationImpl() {
        return this.g;
    }

    public void setAdvancedNativeSignalCommunicationImpl(b bVar) {
        this.g = bVar;
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f1899b;
        if (mBNativeAdvancedWebview != null) {
            mBNativeAdvancedWebview.setObject(bVar);
        }
    }

    public MBNativeAdvancedView(Context context) {
        this(context, null);
    }

    public MBNativeAdvancedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBNativeAdvancedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = context;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public MBNativeAdvancedWebview getAdvancedNativeWebview() {
        return this.f1899b;
    }

    public void setAdvancedNativeWebview(MBNativeAdvancedWebview mBNativeAdvancedWebview) {
        this.f1899b = mBNativeAdvancedWebview;
        b bVar = this.g;
        if (bVar != null) {
            mBNativeAdvancedWebview.setObject(bVar);
        }
    }

    public void changeCloseBtnState(int i) {
        View view = this.c;
        if (view != null) {
            if (i == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public View getCloseView() {
        return this.c;
    }

    public void setCloseView(View view) {
        this.c = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void clearResState() {
        this.f = false;
        this.e = false;
        this.d = false;
    }

    public void clearResStateAndRemoveClose() {
        clearResState();
        View view = this.c;
        if (view == null || view.getParent() == null) {
            return;
        }
        removeView(this.c);
    }

    public static void transInfoForMraid(WebView webView, int i, int i2, int i3, int i4) {
        String str;
        aa.d(a, "transInfoForMraid");
        try {
            int i5 = com.mbridge.msdk.foundation.controller.b.d().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i5 == 2) {
                str = TJAdUnitConstants.String.LANDSCAPE;
            } else {
                str = i5 == 1 ? TJAdUnitConstants.String.PORTRAIT : AdError.UNDEFINED_DOMAIN;
            }
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
            float fL = w.l(com.mbridge.msdk.foundation.controller.b.d().g());
            float fM = w.m(com.mbridge.msdk.foundation.controller.b.d().g());
            HashMap mapN = w.n(com.mbridge.msdk.foundation.controller.b.d().g());
            int iIntValue = ((Integer) mapN.get("width")).intValue();
            int iIntValue2 = ((Integer) mapN.get("height")).intValue();
            HashMap map = new HashMap();
            map.put("placementType", TJAdUnitConstants.String.INLINE);
            map.put("state", "default");
            map.put("viewable", "true");
            map.put("currentAppOrientation", jSONObject);
            float f = i;
            float f2 = i2;
            float f3 = i3;
            float f4 = i4;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, f, f2, f3, f4);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, f, f2, f3, f4);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, fL, fM);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(webView, iIntValue, iIntValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, map);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView);
        } catch (Throwable th) {
            aa.b(a, "transInfoForMraid", th);
        }
    }

    public void destroy() {
        removeAllViews();
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f1899b;
        if (mBNativeAdvancedWebview != null && !mBNativeAdvancedWebview.isDestoryed()) {
            this.f1899b.release();
            com.mbridge.msdk.advanced.js.a.a(this.f1899b, "onSystemDestory", "");
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    public void show() {
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f1899b;
        if (mBNativeAdvancedWebview != null && mBNativeAdvancedWebview.getParent() == null) {
            addView(this.f1899b, new ViewGroup.LayoutParams(-1, -1));
        }
        int[] iArr = new int[2];
        this.f1899b.getLocationInWindow(iArr);
        MBNativeAdvancedWebview mBNativeAdvancedWebview2 = this.f1899b;
        transInfoForMraid(mBNativeAdvancedWebview2, iArr[0], iArr[1], mBNativeAdvancedWebview2.getWidth(), this.f1899b.getHeight());
        MBNativeAdvancedWebview mBNativeAdvancedWebview3 = this.f1899b;
        if (mBNativeAdvancedWebview3 != null) {
            mBNativeAdvancedWebview3.setObject(this.g);
            this.f1899b.post(new Runnable() { // from class: com.mbridge.msdk.advanced.view.MBNativeAdvancedView.1
                @Override // java.lang.Runnable
                public final void run() {
                    String string = "";
                    try {
                        try {
                            int[] iArr2 = new int[2];
                            MBNativeAdvancedView.this.f1899b.getLocationOnScreen(iArr2);
                            aa.d(MBNativeAdvancedView.a, "coordinate:" + iArr2[0] + "--" + iArr2[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", af.a(com.mbridge.msdk.foundation.controller.b.d().g(), iArr2[0]));
                            jSONObject.put("startY", af.a(com.mbridge.msdk.foundation.controller.b.d().g(), iArr2[1]));
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b(MBNativeAdvancedView.a, th.getMessage(), th);
                        }
                        g.a().a((WebView) MBNativeAdvancedView.this.f1899b, "webviewshow", Base64.encodeToString(string.toString().getBytes(), 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        View view = this.c;
        if (view != null) {
            if (view.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.b(getContext(), 28.0f), af.b(getContext(), 16.0f));
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = af.b(getContext(), 2.0f);
                layoutParams.topMargin = af.b(getContext(), 2.0f);
                addView(this.c, layoutParams);
            } else {
                bringChildToFront(this.c);
            }
        }
        clearResState();
    }
}
