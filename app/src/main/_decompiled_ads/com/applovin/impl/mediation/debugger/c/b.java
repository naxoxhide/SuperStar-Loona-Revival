package com.applovin.impl.mediation.debugger.c;

import android.text.TextUtils;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {
    private final a apN;

    public interface a {
        void a(com.applovin.impl.mediation.debugger.a.b bVar);

        void bG(String str);
    }

    public b(n nVar, a aVar) {
        super("TaskFetchDeveloperUri", nVar);
        this.apN = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strValueOf;
        if (this.sdk.BT() != null) {
            strValueOf = String.valueOf(this.sdk.BS().Eg().Ek());
        } else {
            strValueOf = String.valueOf(this.sdk.BQ().CY().get(CampaignEx.JSON_KEY_PACKAGE_NAME));
        }
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Looking up developer URI for package name: " + strValueOf);
        }
        this.sdk.BM().b(new w<String>(com.applovin.impl.sdk.network.c.D(this.sdk).db("GET").da("https://play.google.com/store/apps/details?id=" + strValueOf).ad("").aS(false).Ie(), this.sdk) { // from class: com.applovin.impl.mediation.debugger.c.b.1
            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void d(String str, int i) {
                if (TextUtils.isEmpty(str)) {
                    x xVar2 = this.logger;
                    if (x.Fk()) {
                        this.logger.i(this.tag, "No developer URI found - response is empty");
                    }
                    b.this.apN.a(com.applovin.impl.mediation.debugger.a.b.DEVELOPER_URI_NOT_FOUND);
                }
                Matcher matcher = Pattern.compile("(?<=\"appstore:developer_url\" content=\").+?(?=\">)").matcher(str);
                if (matcher.find()) {
                    String strGroup = matcher.group();
                    x xVar3 = this.logger;
                    if (x.Fk()) {
                        this.logger.f(this.tag, "Found developer URI: " + strGroup);
                    }
                    b.this.apN.bG(strGroup);
                    return;
                }
                x xVar4 = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, "Unable to find developer URI from the Play Store listing metadata");
                }
                b.this.apN.a(com.applovin.impl.mediation.debugger.a.b.DEVELOPER_URI_NOT_FOUND);
            }

            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            public void a(int i, String str, String str2) {
                x xVar2 = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, "Unable to fetch developer URI due to: " + str + ", and received error code: " + i);
                }
                b.this.apN.a(com.applovin.impl.mediation.debugger.a.b.DEVELOPER_URI_NOT_FOUND);
            }
        });
    }
}
