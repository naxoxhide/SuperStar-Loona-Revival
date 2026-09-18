package com.applovin.impl.sdk.a;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.ScriptInjector;
import com.iab.omid.library.applovin.adsession.Partner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private final Context E = n.getApplicationContext();
    private String aIA;
    private final n sdk;

    public f(n nVar) {
        this.sdk = nVar;
    }

    public void uB() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKL)).booleanValue()) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("OpenMeasurementService", "Initializing Open Measurement SDK v" + getSdkVersion() + "...");
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$f$hu2yoxUGKLCImvFfSurpwuQ39lU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.IU();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void IU() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Omid.activate(this.E);
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("OpenMeasurementService", "Init " + (isInitialized() ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed") + " and took " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        }
        IS();
    }

    public boolean isInitialized() {
        return Omid.isActive();
    }

    public String getSdkVersion() {
        return Omid.getVersion();
    }

    public Partner getPartner() {
        return Partner.createPartner((String) this.sdk.a(com.applovin.impl.sdk.c.b.aKM), AppLovinSdk.VERSION);
    }

    public String IR() {
        return this.aIA;
    }

    private void IS() {
        this.sdk.BM().a(new ab(this.sdk, "OpenMeasurementService", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$f$NjWqgeadH1-8rwOZTp8NZ__695I
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.IT();
            }
        }), q.b.BACKGROUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void IT() {
        if (this.aIA != null) {
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.E.getResources().openRawResource(R.raw.omsdk_v_1_0)));
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            this.aIA = sb.toString();
                            bufferedReader.close();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        Log.e("OpenMeasurementService", "Failed to load JavaScript Open Measurement SDK", th);
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e2) {
                Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e2);
            }
        } catch (Throwable th3) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("OpenMeasurementService", "Failed to retrieve resource omskd_v_1_0.js", th3);
            }
        }
    }

    public String dp(String str) {
        try {
            return ScriptInjector.injectScriptContentIntoHtml(this.aIA, str);
        } catch (Throwable th) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("OpenMeasurementService", "Failed to inject JavaScript SDK into HTML", th);
            }
            return str;
        }
    }
}
