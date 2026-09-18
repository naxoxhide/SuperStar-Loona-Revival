package com.bytedance.sdk.openadsdk.core.i0;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.m;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.AdSessionConfiguration;
import com.iab.omid.library.bytedance2.adsession.AdSessionContext;
import com.iab.omid.library.bytedance2.adsession.CreativeType;
import com.iab.omid.library.bytedance2.adsession.ImpressionType;
import com.iab.omid.library.bytedance2.adsession.Owner;
import com.iab.omid.library.bytedance2.adsession.Partner;
import com.iab.omid.library.bytedance2.adsession.VerificationScriptResource;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ViewabilityTrackerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static g a(View view, Set<j> set) {
        AdSession adSessionA = a(CreativeType.VIDEO, set, Owner.NATIVE);
        return new i(adSessionA, AdEvents.createAdEvents(adSessionA), view, MediaEvents.createMediaEvents(adSessionA));
    }

    public static g a(WebView webView) {
        Partner partnerB = e.b();
        if (partnerB != null) {
            AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(partnerB, webView, "", ""));
            return new g(adSessionCreateAdSession, AdEvents.createAdEvents(adSessionCreateAdSession), webView);
        }
        throw new IllegalArgumentException("Parameter 'partner' may not be null.");
    }

    private static AdSession a(CreativeType creativeType, Set<j> set, Owner owner) {
        List<VerificationScriptResource> listA = a(set);
        if (listA.isEmpty()) {
            m.b("verificationScriptResources is empty");
        }
        Partner partnerB = e.b();
        if (partnerB == null) {
            return null;
        }
        return AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, owner, false), AdSessionContext.createNativeAdSessionContext(partnerB, e.a(), listA, "", ""));
    }

    private static List<VerificationScriptResource> a(Set<j> set) {
        ArrayList arrayList = new ArrayList();
        for (j jVar : set) {
            try {
                if (!TextUtils.isEmpty(jVar.b()) && !TextUtils.isEmpty(jVar.c())) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(jVar.b(), jVar.a(), jVar.c()));
                } else {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(jVar.a()));
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}
