package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f implements AppLovinCommunicatorSubscriber {
    private final Object ayZ = new Object();
    private final LinkedHashMap<String, Bundle> aza = new LinkedHashMap<String, Bundle>() { // from class: com.applovin.impl.sdk.f.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Bundle> entry) {
            return size() > 16;
        }
    };
    private final Set<a> azb = Collections.synchronizedSet(new HashSet());
    private final n sdk;

    public interface a {
        void onCreativeIdGenerated(String str, String str2);
    }

    public f(n nVar) {
        this.sdk = nVar;
        if (StringUtils.isValidString(getVersion())) {
            AppLovinCommunicator.getInstance(n.getApplicationContext()).subscribe(this, "safedk_ad_info");
        }
    }

    public Bundle cy(String str) {
        Bundle bundle;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.ayZ) {
            bundle = this.aza.get(str);
        }
        return bundle;
    }

    public void cz(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.ayZ) {
            this.aza.remove(str);
        }
    }

    public void a(a aVar) {
        this.azb.add(aVar);
    }

    public void b(a aVar) {
        this.azb.remove(aVar);
    }

    public static String getVersion() {
        return cA(MobileAdsBridge.versionMethodName);
    }

    public static String getSdkKey() {
        return cA("getSdkKey");
    }

    private static String cA(String str) {
        Class<?> cls;
        try {
            try {
                cls = Class.forName("com.applovin.quality.AppLovinQualityService");
            } catch (Throwable unused) {
                cls = Class.forName("com.safedk.android.SafeDK");
            }
            return (String) cls.getMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused2) {
            return "";
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle bundle = appLovinCommunicatorMessage.getMessageData().getBundle("public");
            if (bundle == null) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().h("AppLovinSdk", "Received SafeDK ad info without public data");
                    return;
                }
                return;
            }
            Bundle bundle2 = appLovinCommunicatorMessage.getMessageData().getBundle("private");
            if (bundle2 == null) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().h("AppLovinSdk", "Received SafeDK ad info without private data");
                    return;
                }
                return;
            }
            if (MaxAdFormat.formatFromString(bundle2.getString(FirebaseAnalytics.Param.AD_FORMAT)) == null) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().h("AppLovinSdk", "Received SafeDK ad info without ad format");
                    return;
                }
                return;
            }
            final String string = bundle2.getString("id");
            if (TextUtils.isEmpty(string)) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().h("AppLovinSdk", "Received SafeDK ad info without serve id");
                    return;
                }
                return;
            }
            synchronized (this.ayZ) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("AppLovinSdk", "Storing current SafeDK ad info for serve id: " + string);
                }
                this.aza.put(string, bundle);
            }
            final String string2 = bundle.getString("ad_review_creative_id");
            if (!StringUtils.isValidString(string2) || this.azb.isEmpty()) {
                return;
            }
            for (final a aVar : new HashSet(this.azb)) {
                this.sdk.BM().a(new com.applovin.impl.sdk.e.ab(this.sdk, "creativeIdGenerated", new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$f$KZVx787FMa5-J9aWVIRJAa8Nsxk
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.onCreativeIdGenerated(string, string2);
                    }
                }), com.applovin.impl.sdk.e.q.b.BACKGROUND);
            }
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return f.class.getSimpleName();
    }
}
