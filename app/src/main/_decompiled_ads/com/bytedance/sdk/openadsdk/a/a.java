package com.bytedance.sdk.openadsdk.a;

import android.text.TextUtils;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.d.c;
import com.bytedance.sdk.openadsdk.utils.y;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* JADX INFO: compiled from: AdLoadUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdLoadUtils.java */
    static class RunnableC0164a implements Runnable {
        final /* synthetic */ PAGLoadListener a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f384b;
        final /* synthetic */ AdSlot c;

        RunnableC0164a(PAGLoadListener pAGLoadListener, g gVar, AdSlot adSlot) {
            this.a = pAGLoadListener;
            this.f384b = gVar;
            this.c = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.e()) {
                y.a(this.f384b);
                c.a(this.c);
                return;
            }
            m.b("AdLoadBaseManager", "please exec TTAdSdk.init before load ad");
            PAGLoadListener pAGLoadListener = this.a;
            if (pAGLoadListener != null) {
                pAGLoadListener.onError(10000, "Please exec TTAdSdk.init before load ad");
            }
        }
    }

    public static boolean a(PAGLoadListener pAGLoadListener) {
        if (j.a()) {
            return false;
        }
        if (pAGLoadListener == null) {
            return true;
        }
        pAGLoadListener.onError(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
        return true;
    }

    public static void a(g gVar, PAGLoadListener pAGLoadListener, AdSlot adSlot) {
        RunnableC0164a runnableC0164a = new RunnableC0164a(pAGLoadListener, gVar, adSlot);
        if (l.e()) {
            runnableC0164a.run();
        } else {
            l.a().post(runnableC0164a);
        }
    }

    public static void a(AdSlot.Builder builder, PAGRequest pAGRequest) {
        Map<String, Object> extraInfo;
        if (!l.e() || pAGRequest == null || builder == null || (extraInfo = pAGRequest.getExtraInfo()) == null) {
            return;
        }
        if (extraInfo.containsKey("ad_id") && extraInfo.get("ad_id") != null) {
            builder.setAdId(extraInfo.get("ad_id").toString());
        }
        if (extraInfo.containsKey(CampaignEx.JSON_KEY_CREATIVE_ID) && extraInfo.get(CampaignEx.JSON_KEY_CREATIVE_ID) != null) {
            builder.setCreativeId(extraInfo.get(CampaignEx.JSON_KEY_CREATIVE_ID).toString());
        }
        if (extraInfo.containsKey("ext") && extraInfo.get("ext") != null) {
            builder.setExt(extraInfo.get("ext").toString());
        }
        if (!extraInfo.containsKey("media_extra") || extraInfo.get("media_extra") == null) {
            return;
        }
        builder.setMediaExtra(extraInfo.get("media_extra").toString());
    }

    public static boolean a(String str, PAGRequest pAGRequest, PAGLoadListener pAGLoadListener) {
        if (TextUtils.isEmpty(str) && pAGLoadListener != null) {
            pAGLoadListener.onError(1, PAGErrorCode.PAGAdErrorCodeSlotIdNULLMsg);
            return true;
        }
        if (pAGRequest != null || pAGLoadListener == null) {
            return false;
        }
        pAGLoadListener.onError(2, PAGErrorCode.PAGAdErrorCodeRequestNULLMsg);
        return true;
    }
}
