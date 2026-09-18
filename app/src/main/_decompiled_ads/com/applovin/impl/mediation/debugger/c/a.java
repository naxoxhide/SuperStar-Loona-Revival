package com.applovin.impl.mediation.debugger.c;

import android.net.Uri;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {
    private String anR;
    private final InterfaceC0124a apK;
    private final String apL;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0124a {
        void a(com.applovin.impl.mediation.debugger.a.b bVar, String str);

        void t(String str, String str2);
    }

    public a(n nVar, String str, InterfaceC0124a interfaceC0124a) {
        super("TaskFetchAppAdsContent", nVar);
        this.apL = str;
        this.apK = interfaceC0124a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList(Arrays.asList(Uri.parse(this.apL).getAuthority().split("\\.")));
        if (arrayList.size() > 0) {
            String str = (String) arrayList.get(0);
            if ("www".equals(str) || InneractiveMediationDefs.GENDER_MALE.equals(str)) {
                arrayList.remove(0);
            }
        }
        String strJoin = TextUtils.join(".", arrayList);
        Uri uriBuild = new Uri.Builder().scheme("https").authority(strJoin).appendPath("app-ads.txt").build();
        com.applovin.impl.sdk.network.c cVarIe = com.applovin.impl.sdk.network.c.D(this.sdk).db("GET").da(uriBuild.toString()).dc(new Uri.Builder().scheme(ProxyConfig.MATCH_HTTP).authority(strJoin).appendPath("app-ads.txt").build().toString()).ad("").aS(false).Ie();
        this.anR = uriBuild.toString();
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Looking up app-ads.txt at " + this.anR);
        }
        this.sdk.BM().b(new w<String>(cVarIe, this.sdk) { // from class: com.applovin.impl.mediation.debugger.c.a.1
            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void d(String str2, int i) {
                if (TextUtils.isEmpty(str2)) {
                    x xVar2 = this.logger;
                    if (x.Fk()) {
                        this.logger.i(this.tag, "No app-ads.txt found");
                    }
                    a.this.apK.a(com.applovin.impl.mediation.debugger.a.b.APPADSTXT_NOT_FOUND, a.this.anR);
                    return;
                }
                x xVar3 = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Found app-ads.txt");
                }
                a.this.apK.t(str2, a.this.anR);
            }

            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            public void a(int i, String str2, String str3) {
                x xVar2 = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, "Unable to fetch app-ads.txt due to: " + str2 + ", and received error code: " + i);
                }
                a.this.apK.a(com.applovin.impl.mediation.debugger.a.b.APPADSTXT_NOT_FOUND, a.this.anR);
            }
        });
    }
}
