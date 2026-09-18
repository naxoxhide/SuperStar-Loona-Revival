package com.applovin.impl.sdk;

import android.adservices.AdServicesState;
import android.adservices.measurement.MeasurementManager;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.text.TextUtils;
import android.view.InputEvent;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class aa {
    private final Executor aFs;
    private final MeasurementManager aFt;
    private final AtomicReference<JSONArray> aFu = new AtomicReference<>(new JSONArray());
    private final a aFv = new a();
    private final TopicsManager aFw;
    private final n sdk;

    protected aa(n nVar) {
        this.sdk = nVar;
        this.aFs = nVar.BM().KI();
        Context applicationContext = n.getApplicationContext();
        this.aFt = (MeasurementManager) applicationContext.getSystemService(MeasurementManager.class);
        this.aFw = (TopicsManager) applicationContext.getSystemService(TopicsManager.class);
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aQT)).booleanValue()) {
            g(((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aQW)).booleanValue(), 0L);
        }
    }

    public void I(List<String> list) {
        if (list == null || list.isEmpty() || this.aFt == null || !Fr()) {
            return;
        }
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("PrivacySandboxService", "Registering impression...");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.aFt.registerSource(Uri.parse(it.next()), null, this.aFs, new OutcomeReceiver<Object, Exception>() { // from class: com.applovin.impl.sdk.aa.1
                @Override // android.os.OutcomeReceiver
                public void onResult(Object obj) {
                    aa.this.sdk.BL();
                    if (x.Fk()) {
                        aa.this.sdk.BL().f("PrivacySandboxService", "Successfully registered impression");
                    }
                }

                @Override // android.os.OutcomeReceiver
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public void onError(Exception exc) {
                    aa.this.sdk.BL();
                    if (x.Fk()) {
                        aa.this.sdk.BL().c("PrivacySandboxService", "Failed to register impression", exc);
                    }
                }
            });
        }
    }

    public void a(List<String> list, InputEvent inputEvent) {
        if (list == null || list.isEmpty() || this.aFt == null || !Fr()) {
            return;
        }
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("PrivacySandboxService", "Registering click...");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.aFt.registerSource(Uri.parse(it.next()), inputEvent, this.aFs, new OutcomeReceiver<Object, Exception>() { // from class: com.applovin.impl.sdk.aa.2
                @Override // android.os.OutcomeReceiver
                public void onResult(Object obj) {
                    aa.this.sdk.BL();
                    if (x.Fk()) {
                        aa.this.sdk.BL().f("PrivacySandboxService", "Successfully registered click");
                    }
                }

                @Override // android.os.OutcomeReceiver
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public void onError(Exception exc) {
                    aa.this.sdk.BL();
                    if (x.Fk()) {
                        aa.this.sdk.BL().c("PrivacySandboxService", "Failed to register click", exc);
                    }
                }
            });
        }
    }

    public void cP(String str) {
        if (TextUtils.isEmpty(str) || this.aFt == null || !Fr()) {
            return;
        }
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("PrivacySandboxService", "Registering conversion: " + str);
        }
        this.aFt.registerTrigger(Uri.parse(str), this.aFs, new OutcomeReceiver<Object, Exception>() { // from class: com.applovin.impl.sdk.aa.3
            @Override // android.os.OutcomeReceiver
            public void onResult(Object obj) {
                aa.this.sdk.BL();
                if (x.Fk()) {
                    aa.this.sdk.BL().f("PrivacySandboxService", "Successfully registered conversion");
                }
            }

            @Override // android.os.OutcomeReceiver
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public void onError(Exception exc) {
                aa.this.sdk.BL();
                if (x.Fk()) {
                    aa.this.sdk.BL().c("PrivacySandboxService", "Failed to register conversion", exc);
                }
            }
        });
    }

    public JSONArray Fq() {
        return this.aFu.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, long j) {
        if (this.aFw == null) {
            return;
        }
        final GetTopicsRequest getTopicsRequestBuild = new GetTopicsRequest.Builder().setShouldRecordObservation(z).setAdsSdkName(ADXLogUtil.PLATFORM_APPLOVIN).build();
        if (j > 0) {
            this.sdk.BM().a(new com.applovin.impl.sdk.e.ab(this.sdk, true, "getTopics", new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$aa$XJ3_tsqoOeWrdLW8G9v_EnsYGL8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(getTopicsRequestBuild);
                }
            }), com.applovin.impl.sdk.e.q.b.BACKGROUND, j);
        } else {
            this.aFw.getTopics(getTopicsRequestBuild, this.aFs, this.aFv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(GetTopicsRequest getTopicsRequest) {
        this.aFw.getTopics(getTopicsRequest, this.aFs, this.aFv);
    }

    public static boolean Fr() {
        return com.applovin.impl.sdk.utils.h.Le() && AdServicesState.isAdServicesStateEnabled();
    }

    public static boolean M(Context context) {
        return com.applovin.impl.sdk.utils.h.d("android.permission.ACCESS_ADSERVICES_TOPICS", context);
    }

    public static boolean N(Context context) {
        return com.applovin.impl.sdk.utils.h.d("android.permission.ACCESS_ADSERVICES_ATTRIBUTION", context);
    }

    public static boolean O(Context context) {
        return com.applovin.impl.sdk.utils.h.d("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE", context);
    }

    public static boolean P(Context context) {
        return com.applovin.impl.sdk.utils.h.d("android.permission.ACCESS_ADSERVICES_AD_ID", context);
    }

    private class a implements OutcomeReceiver<GetTopicsResponse, Exception> {
        private a() {
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(GetTopicsResponse getTopicsResponse) {
            List<Topic> topics = getTopicsResponse.getTopics();
            int size = topics.size();
            aa.this.sdk.BL();
            if (x.Fk()) {
                aa.this.sdk.BL().g("PrivacySandboxService", size + " topic(s) received");
            }
            JSONArray jSONArray = new JSONArray();
            for (Topic topic : topics) {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putInt(jSONObject, "id", topic.getTopicId());
                JsonUtils.putLong(jSONObject, DeviceRequestsHelper.DEVICE_INFO_MODEL, topic.getModelVersion());
                JsonUtils.putLong(jSONObject, "taxonomy", topic.getTaxonomyVersion());
                jSONArray.put(jSONObject);
            }
            aa.this.aFu.set(jSONArray);
            aa.this.g(((Boolean) aa.this.sdk.a(com.applovin.impl.sdk.c.b.aQW)).booleanValue(), ((Long) aa.this.sdk.a(com.applovin.impl.sdk.c.b.aQU)).longValue());
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            Long l = (Long) aa.this.sdk.a(com.applovin.impl.sdk.c.b.aQV);
            boolean z = l.longValue() == -1;
            aa.this.sdk.BL();
            if (x.Fk()) {
                aa.this.sdk.BL().c("PrivacySandboxService", "Failed to retrieve topics" + (z ? "" : ", retrying in " + l + " ms"), exc);
            }
            if (z) {
                return;
            }
            aa.this.g(((Boolean) aa.this.sdk.a(com.applovin.impl.sdk.c.b.aQX)).booleanValue(), l.longValue());
        }
    }
}
