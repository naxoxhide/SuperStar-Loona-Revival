package com.kakao.adfit.a;

import android.content.Context;
import android.os.Bundle;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.ads.AdListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AdConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0010\u001a\u0004\u0018\u00010\u00068&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\u00020\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001c\u0010)\u001a\u00020$8&@&X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010/\u001a\u00020*8&@&X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006008&X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/kakao/adfit/a/b;", "", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "context", "", InneractiveMediationDefs.GENDER_FEMALE, "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "baseUrl", InneractiveMediationDefs.GENDER_MALE, "setClientId", "getClientId$annotations", "()V", "clientId", "Lcom/kakao/adfit/ads/AdListener;", "h", "()Lcom/kakao/adfit/ads/AdListener;", "setAdListener", "(Lcom/kakao/adfit/ads/AdListener;)V", "adListener", "Lkotlin/Function0;", "", "g", "()Lkotlin/jvm/functions/Function0;", "isForeground", "n", "()Z", "setTestMode", "(Z)V", "isTestMode", "l", "setAppId", "appId", "", "i", "()I", "setRefreshSequence", "(I)V", "refreshSequence", "", CampaignEx.JSON_KEY_AD_K, "()J", "setRefreshInterval", "(J)V", "refreshInterval", "", "j", "()Ljava/util/Map;", "extraMap", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface b {
    Context e();

    String f();

    Function0<Boolean> g();

    AdListener h();

    int i();

    Map<String, String> j();

    long k();

    String l();

    String m();

    boolean n();

    /* JADX INFO: compiled from: AdConfig.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static void a(b bVar, String str, String str2) {
            if (str == null) {
                return;
            }
            if (str2 != null) {
                bVar.j().put(str, str2);
            } else {
                bVar.j().remove(str);
            }
        }

        public static void b(b bVar) {
            AdListener adListenerH = bVar.h();
            if (adListenerH != null) {
                adListenerH.onAdClicked();
            }
        }

        public static void c(b bVar) {
            AdListener adListenerH = bVar.h();
            if (adListenerH != null) {
                adListenerH.onAdLoaded();
            }
        }

        public static Bundle a(b bVar) {
            if (bVar.j().isEmpty()) {
                return null;
            }
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : bVar.j().entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            return bundle;
        }

        public static void a(b bVar, int i) {
            AdListener adListenerH = bVar.h();
            if (adListenerH != null) {
                adListenerH.onAdFailed(i);
            }
        }
    }
}
