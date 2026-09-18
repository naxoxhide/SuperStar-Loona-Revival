package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.util.k0;
import com.fyber.inneractive.sdk.web.d0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c<T extends d0> extends c0<T> {
    public final b N;

    public c(Context context, b bVar, boolean z, boolean z2) {
        super(context, z, z2, i.g.INTERSTITIAL);
        this.N = bVar;
    }

    @Override // com.fyber.inneractive.sdk.web.g.a
    public void a() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fyber.inneractive.sdk.web.d
    public boolean a(String str, k0 k0Var) {
        com.fyber.inneractive.sdk.flow.vast.e eVar;
        if (str == null || !str.toLowerCase().startsWith("fmpendcard://".toLowerCase())) {
            return false;
        }
        b bVar = this.N;
        if (bVar != null) {
            d.InterfaceC0308d interfaceC0308d = this.f;
            L l = this.g;
            bVar.getClass();
            Uri uri = Uri.parse(str);
            String authority = uri != null ? uri.getAuthority() : null;
            if (!TextUtils.isEmpty(authority)) {
                authority.getClass();
                authority.hashCode();
                switch (authority) {
                    case "success":
                        String queryParameter = uri.getQueryParameter("version");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            bVar.f1355b = queryParameter;
                        }
                        g();
                        break;
                    case "failure":
                        String queryParameter2 = uri.getQueryParameter("version");
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            bVar.f1355b = queryParameter2;
                        }
                        bVar.a(interfaceC0308d, this, uri.getQueryParameter("error"));
                        break;
                    case "click":
                        if (l != 0 && (eVar = bVar.c) != null) {
                            b.a aVar = new b.a(bVar.f1355b, eVar.d);
                            com.fyber.inneractive.sdk.model.vast.b bVar2 = bVar.a;
                            com.fyber.inneractive.sdk.model.vast.c cVar = bVar2.h;
                            String str2 = cVar != null ? cVar.g : null;
                            if (str2 == null) {
                                str2 = bVar2.f959b;
                            }
                            l.a(str2, k0Var, aVar);
                            break;
                        }
                        break;
                }
            } else {
                bVar.a(interfaceC0308d, this, "empty type");
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.web.g.a
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.web.d
    public com.fyber.inneractive.sdk.measurement.a.InterfaceC0271a d() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.web.d, com.fyber.inneractive.sdk.web.f
    public void a(WebView webView) {
        JSONObject jSONObject;
        if (webView == null || this.N == null) {
            return;
        }
        webView.setLongClickable(false);
        webView.setOnLongClickListener(new com.fyber.inneractive.sdk.util.a0());
        b bVar = this.N;
        com.fyber.inneractive.sdk.model.vast.l lVar = bVar.a.f;
        if (lVar != null) {
            try {
                jSONObject = new JSONObject();
                h0.a(jSONObject, "name", lVar.a);
                h0.a(jSONObject, "description", lVar.f967b);
                JSONArray jSONArray = new JSONArray();
                List<String> list = lVar.c;
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                }
                h0.a(jSONObject, "icons", jSONArray);
                h0.a(jSONObject, CampaignEx.JSON_KEY_STAR, Float.valueOf(lVar.d));
                JSONArray jSONArray2 = new JSONArray();
                List<String> list2 = lVar.e;
                if (list2 != null) {
                    Iterator<String> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        jSONArray2.put(it2.next());
                    }
                }
                h0.a(jSONObject, "screenshots", jSONArray2);
            } catch (Exception unused) {
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript(String.format("loadAssets(%s);", jSONObject), new a(bVar));
        } else {
            webView.loadUrl(String.format("javascript:loadAssets('%s');", jSONObject));
        }
    }

    @Override // com.fyber.inneractive.sdk.web.d, com.fyber.inneractive.sdk.web.f
    public void a(int i) {
        d.InterfaceC0308d interfaceC0308d;
        if (this.N == null || (interfaceC0308d = this.f) == null) {
            return;
        }
        interfaceC0308d.a(this, new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.g.WEBVIEW_FMP_ENDCARD_ERROR));
    }
}
