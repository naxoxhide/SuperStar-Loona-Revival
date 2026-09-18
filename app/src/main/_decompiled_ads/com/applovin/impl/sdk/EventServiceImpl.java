package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class EventServiceImpl implements AppLovinEventService {
    public static final List<String> ALLOW_PRE_INIT_EVENT_TYPES = Arrays.asList("landing", TJAdUnitConstants.String.VIDEO_PAUSED, "resumed", "cf_start", "tos_ok", "gdpr_ok");
    private final Map<String, Object> aEO;
    private final AtomicBoolean aEP = new AtomicBoolean();
    private final n sdk;

    public String toString() {
        return "EventService{}";
    }

    public EventServiceImpl(n nVar) {
        this.sdk = nVar;
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aLz)).booleanValue()) {
            this.aEO = JsonUtils.toStringObjectMap((String) nVar.b(com.applovin.impl.sdk.c.d.aRB, JsonUtils.EMPTY_JSON));
        } else {
            this.aEO = new HashMap();
            nVar.a(com.applovin.impl.sdk.c.d.aRB, JsonUtils.EMPTY_JSON);
        }
    }

    public void maybeTrackAppOpenEvent() {
        if (this.aEP.compareAndSet(false, true)) {
            this.sdk.BD().trackEvent("landing");
        }
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void setSuperProperty(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            x.H("AppLovinEventService", "Super property key cannot be null or empty");
            return;
        }
        if (obj == null) {
            this.aEO.remove(str);
            EV();
            return;
        }
        List<String> listB = this.sdk.b(com.applovin.impl.sdk.c.b.aLy);
        if (!com.applovin.impl.sdk.utils.u.a(obj, listB, this.sdk)) {
            x.H("AppLovinEventService", "Failed to set super property '" + obj + "' for key '" + str + "' - valid super property types include: " + listB);
        } else {
            this.aEO.put(str, com.applovin.impl.sdk.utils.u.a(obj, this.sdk));
            EV();
        }
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public Map<String, Object> getSuperProperties() {
        return CollectionUtils.map(this.aEO);
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        try {
            map2.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            map2.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            x.e("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
            this.sdk.Cq().d("AppLovinEventService", "trackIAP", th);
        }
        trackEvent("iap", map2);
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackCheckout(String str, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        map2.put("transaction_id", str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, map2);
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, null);
    }

    public void trackEvent(String str, Map<String, String> map, final Map<String, String> map2) {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AppLovinEventService", "Tracking event: \"" + str + "\" with parameters: " + map);
        }
        final s sVar = new s(str, map, this.aEO);
        final boolean zContains = ALLOW_PRE_INIT_EVENT_TYPES.contains(str);
        try {
            this.sdk.BM().a(new com.applovin.impl.sdk.e.ab(this.sdk, zContains, "submitTrackEventPostback", new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$EventServiceImpl$UkAyE4Y8xsAKqLVr1_Tp7h5nnUI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(sVar, map2, zContains);
                }
            }), com.applovin.impl.sdk.e.q.b.BACKGROUND);
        } catch (Throwable th) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("AppLovinEventService", "Unable to track event: " + sVar, th);
            }
            this.sdk.Cq().d("AppLovinEventService", "trackEvent", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(s sVar, Map map, boolean z) {
        Map<String, String> mapA = a(sVar, false);
        Map<String, Object> mapER = sVar.ER();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPY)).booleanValue() || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPT)).booleanValue()) {
            mapER.putAll(mapA);
            mapA = null;
        }
        this.sdk.Cs().a(com.applovin.impl.sdk.network.h.IB().dh(ET()).di(EU()).n(mapA).p(mapER).o(a(sVar, (Map<String, String>) map)).aW(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQi)).booleanValue()).aV(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()).aX(z).b(com.applovin.impl.sdk.utils.p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPQ)).intValue())).ID());
    }

    public void trackEventSynchronously(String str) {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        }
        s sVar = new s(str, new HashMap(), this.aEO);
        Map<String, String> mapA = a(sVar, true);
        Map<String, Object> mapER = sVar.ER();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPY)).booleanValue() || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPT)).booleanValue()) {
            mapER.putAll(mapA);
            mapA = null;
        }
        this.sdk.Cs().a(com.applovin.impl.sdk.network.h.IB().dh(ET()).di(EU()).n(mapA).p(mapER).o(a(sVar, (Map<String, String>) null)).aW(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQi)).booleanValue()).aV(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()).ID());
    }

    private String ET() {
        return ((String) this.sdk.a(com.applovin.impl.sdk.c.b.aLt)) + "4.0/pix";
    }

    private String EU() {
        return ((String) this.sdk.a(com.applovin.impl.sdk.c.b.aLu)) + "4.0/pix";
    }

    private Map<String, String> a(s sVar, boolean z) {
        Map<String, Object> mapA;
        boolean zContains = this.sdk.b(com.applovin.impl.sdk.c.b.aLx).contains(sVar.getName());
        if (this.sdk.BT() != null) {
            mapA = this.sdk.BT().a(null, z, false);
        } else {
            mapA = this.sdk.BQ().a(null, z, false);
        }
        mapA.put("event", zContains ? sVar.getName() : "postinstall");
        mapA.put("event_id", sVar.mQ());
        mapA.put(CampaignEx.JSON_KEY_ST_TS, Long.toString(sVar.ES()));
        if (!zContains) {
            mapA.put("sub_event", sVar.getName());
        }
        return com.applovin.impl.sdk.utils.u.s(mapA);
    }

    private Map<String, String> a(s sVar, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        boolean zContains = this.sdk.b(com.applovin.impl.sdk.c.b.aLx).contains(sVar.getName());
        map2.put("AppLovin-Event", zContains ? sVar.getName() : "postinstall");
        if (!zContains) {
            map2.put("AppLovin-Sub-Event", sVar.getName());
        }
        return map2;
    }

    private void EV() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLz)).booleanValue()) {
            this.sdk.a(com.applovin.impl.sdk.c.d.aRB, CollectionUtils.toJsonString(this.aEO, JsonUtils.EMPTY_JSON));
        }
    }
}
