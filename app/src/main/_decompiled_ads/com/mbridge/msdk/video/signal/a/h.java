package com.mbridge.msdk.video.signal.a;

import android.content.res.Configuration;
import android.util.Base64;
import android.webkit.WebView;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSActivityProxy.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends a {
    private WebView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2552b = 0;

    public h(WebView webView) {
        this.a = webView;
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void a() {
        super.a();
        this.f2552b = 1;
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.a, "onSystemPause", "");
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void b() {
        super.b();
        this.f2552b = 0;
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.a, "onSystemResume", "");
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void f() {
        super.f();
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.a, "onSystemDestory", "");
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void a(Configuration configuration) {
        super.a(configuration);
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", TJAdUnitConstants.String.LANDSCAPE);
            } else {
                jSONObject.put("orientation", TJAdUnitConstants.String.PORTRAIT);
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.a, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void g() {
        super.g();
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.a, "onSystemBackPressed", "");
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void a(int i) {
        super.a(i);
        this.f2552b = i;
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final int h() {
        return this.f2552b;
    }
}
