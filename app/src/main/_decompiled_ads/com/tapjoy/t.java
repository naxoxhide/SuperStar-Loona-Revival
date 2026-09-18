package com.tapjoy;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.tapjoy.internal.f5;
import com.tapjoy.internal.g5;
import com.tapjoy.internal.j6;
import com.tapjoy.internal.k2;
import com.tapjoy.internal.l2;
import com.tapjoy.internal.m8;
import com.tapjoy.internal.ma;
import com.tapjoy.internal.na;
import com.tapjoy.internal.r8;
import com.tapjoy.internal.v1;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class t extends Thread {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJPlacement f2851b;
    public final /* synthetic */ ma c;
    public final /* synthetic */ com.tapjoy.internal.v d;
    public final /* synthetic */ TJCorePlacement e;

    public t(TJCorePlacement tJCorePlacement, String str, TJPlacement tJPlacement, ma maVar, com.tapjoy.internal.v vVar) {
        this.e = tJCorePlacement;
        this.a = str;
        this.f2851b = tJPlacement;
        this.c = maVar;
        this.d = vVar;
    }

    /* JADX WARN: Code duplicated, block: B:81:0x02cd A[PHI: r11
      0x02cd: PHI (r11v3 long) = (r11v1 long), (r11v2 long) binds: [B:80:0x02cb, B:83:0x02d3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        boolean z3;
        int i = 0;
        while (true) {
            TapjoyLog.i("TJCorePlacement", "Sending content request for placement " + this.e.d.getPlacementName());
            TJCorePlacement tJCorePlacement = this.e;
            v1 v1Var = v1.m;
            String placementName = tJCorePlacement.d.getPlacementName();
            Context context = this.e.f2688b;
            g5 g5Var = v1Var.a;
            g5Var.a.e.a();
            tJCorePlacement.k = new l2(g5Var.a, placementName, context);
            TapjoyHttpURLResponse responseFromURL = new TapjoyURLConnection().getResponseFromURL(this.a, (Map<String, String>) null, (Map<String, String>) null, this.e.c);
            this.e.d.setHttpStatusCode(responseFromURL.statusCode);
            this.e.d.setHttpResponse(responseFromURL.response);
            if (!responseFromURL.getHeaderFieldAsString(TapjoyConstants.TAPJOY_PRERENDER_HEADER).equals("0")) {
                this.e.d.setPrerenderingRequested(true);
            }
            String headerFieldAsString = responseFromURL.getHeaderFieldAsString(TapjoyConstants.TAPJOY_DEBUG_HEADER);
            if (headerFieldAsString != null) {
                TapjoyLog.v("TJCorePlacement", "Tapjoy-Server-Debug: ".concat(headerFieldAsString));
            }
            if (!responseFromURL.getHeaderFieldAsString(TapjoyConstants.TAPJOY_HANDLE_DISMISS_ON_PAUSE_HEADER).equals("0")) {
                this.e.d.setHandleDismissOnPause(true);
            }
            long j = responseFromURL.expires;
            if (j > 0) {
                long jA = responseFromURL.date;
                if (jA <= 0) {
                    jA = na.a();
                }
                long j2 = j - jA;
                if (j2 > 0) {
                    this.e.g = SystemClock.elapsedRealtime() + j2;
                }
            } else {
                this.e.g = 0L;
            }
            if (this.f2851b.getListener() == null) {
                this.e.n = false;
                z = true;
            } else {
                int i2 = responseFromURL.statusCode;
                if (i2 == 0) {
                    ma maVar = this.c;
                    long j3 = this.d.e;
                    maVar.getClass();
                    try {
                        z2 = (SystemClock.elapsedRealtime() - maVar.f2784b) + j3 > maVar.a;
                    } catch (NullPointerException unused) {
                    }
                    if (z2) {
                        String str = responseFromURL.response;
                        if (str == null) {
                            str = TapjoyErrorMessage.NETWORK_ERROR;
                        }
                        this.e.a(this.f2851b, TapjoyErrorMessage.ErrorType.NETWORK_ERROR, new TJError(responseFromURL.statusCode, str));
                    } else {
                        com.tapjoy.internal.v vVar = this.d;
                        long j4 = vVar.e;
                        long j5 = (long) (j4 * vVar.d);
                        long j6 = vVar.f2822b;
                        if (j5 < j6) {
                            j5 = j6;
                        } else {
                            j6 = vVar.c;
                            if (j5 > j6) {
                                j5 = j6;
                            }
                        }
                        vVar.e = j5;
                        if (j4 > 0) {
                            synchronized (vVar) {
                                try {
                                    vVar.wait(j4);
                                } catch (InterruptedException unused2) {
                                }
                            }
                        }
                        z = false;
                    }
                } else if (i2 != 200) {
                    this.e.a(this.f2851b);
                } else {
                    String headerFieldAsString2 = responseFromURL.getHeaderFieldAsString(HttpHeaders.CONTENT_TYPE);
                    if (TextUtils.isEmpty(headerFieldAsString2) || !headerFieldAsString2.contains("json")) {
                        TJCorePlacement tJCorePlacement2 = this.e;
                        tJCorePlacement2.p = true;
                        tJCorePlacement2.a(tJCorePlacement2.a("REQUEST"));
                        TJCorePlacement tJCorePlacement3 = this.e;
                        m8 m8Var = new m8(this);
                        TapjoyLog.i("TJCorePlacement", "Checking if there is content to cache for placement " + tJCorePlacement3.d.getPlacementName());
                        String headerFieldAsString3 = responseFromURL.getHeaderFieldAsString(TapjoyConstants.TAPJOY_CACHE_HEADER);
                        try {
                            if (TJPlacementManager.canCachePlacement()) {
                                JSONArray jSONArray = new JSONArray(headerFieldAsString3);
                                if (jSONArray.length() > 0) {
                                    TapjoyLog.i("TJCorePlacement", "Begin caching content for placement " + tJCorePlacement3.d.getPlacementName());
                                    TJPlacementManager.incrementPlacementCacheCount();
                                    tJCorePlacement3.i = true;
                                    TapjoyCache.getInstance().cacheAssetGroup(jSONArray, new r8(m8Var));
                                } else {
                                    m8Var.onCachingComplete(1);
                                }
                            } else {
                                TapjoyLog.i("TJCorePlacement", "Placement caching limit reached. No content will be cached for placement " + tJCorePlacement3.d.getPlacementName());
                                m8Var.onCachingComplete(2);
                            }
                        } catch (Exception e) {
                            m8Var.onCachingComplete(2);
                            TapjoyLog.d("TJCorePlacement", "Error while handling placement cache: " + e.getMessage());
                        }
                    } else if (responseFromURL.getHeaderFieldAsString(TapjoyConstants.TAPJOY_DISABLE_PRELOAD_HEADER).equals("1")) {
                        try {
                            this.e.b(responseFromURL.response);
                            TJCorePlacement tJCorePlacement4 = this.e;
                            tJCorePlacement4.p = true;
                            tJCorePlacement4.a(tJCorePlacement4.a("REQUEST"));
                            this.e.a();
                        } catch (TapjoyException e2) {
                            this.e.a(this.f2851b, TapjoyErrorMessage.ErrorType.SERVER_ERROR, new TJError(responseFromURL.statusCode, e2.getMessage() + " for placement " + this.e.d.getPlacementName()));
                        }
                    } else {
                        TJCorePlacement tJCorePlacement5 = this.e;
                        String str2 = responseFromURL.response;
                        tJCorePlacement5.getClass();
                        try {
                            k2 k2Var = (k2) tJCorePlacement5.k.a(URI.create(tJCorePlacement5.d.getUrl()), new ByteArrayInputStream(str2.getBytes()));
                            f5 f5Var = k2Var.a;
                            tJCorePlacement5.l = f5Var;
                            f5Var.b();
                            if (k2Var.a.a()) {
                                z3 = true;
                            } else {
                                TapjoyLog.e("TJCorePlacement", "Failed to load fiverocks placement");
                                z3 = false;
                            }
                        } catch (j6 e3) {
                            TapjoyLog.e("TJCorePlacement", e3.toString());
                            e3.printStackTrace();
                        } catch (IOException e4) {
                            TapjoyLog.e("TJCorePlacement", e4.toString());
                            e4.printStackTrace();
                        }
                        if (z3) {
                            TJCorePlacement tJCorePlacement6 = this.e;
                            tJCorePlacement6.p = true;
                            tJCorePlacement6.a(tJCorePlacement6.a("REQUEST"));
                            this.e.a();
                        } else {
                            String str3 = responseFromURL.response;
                            if (str3 == null) {
                                str3 = TapjoyErrorMessage.ASSET_ERROR;
                            }
                            this.e.a(this.f2851b, TapjoyErrorMessage.ErrorType.SERVER_ERROR, new TJError(responseFromURL.statusCode, str3));
                        }
                    }
                }
                this.e.n = false;
                z = true;
            }
            if (z) {
                return;
            }
            i++;
            this.e.c.put(TapjoyConstants.TJC_RETRY, Integer.toString(i));
        }
    }
}
