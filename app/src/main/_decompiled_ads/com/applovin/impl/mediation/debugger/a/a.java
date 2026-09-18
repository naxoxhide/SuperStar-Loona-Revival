package com.applovin.impl.mediation.debugger.a;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdCallback;
import com.amazon.device.ads.DTBAdRequest;
import com.amazon.device.ads.DTBAdResponse;
import com.amazon.device.ads.DTBAdSize;
import com.applovin.mediation.MaxAdFormat;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements DTBAdCallback {
    private final InterfaceC0122a aof;
    private DTBAdRequest aog;
    private final MaxAdFormat format;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0122a {
        void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat);

        void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat);
    }

    public a(b bVar, MaxAdFormat maxAdFormat, InterfaceC0122a interfaceC0122a) {
        this((List<?>) Arrays.asList(bVar.uF()), maxAdFormat, interfaceC0122a);
    }

    public a(List<?> list, MaxAdFormat maxAdFormat, InterfaceC0122a interfaceC0122a) {
        this.format = maxAdFormat;
        this.aof = interfaceC0122a;
        try {
            DTBAdSize[] dTBAdSizeArr = new DTBAdSize[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj instanceof DTBAdSize) {
                    dTBAdSizeArr[i] = (DTBAdSize) obj;
                }
            }
            DTBAdRequest dTBAdRequest = new DTBAdRequest();
            this.aog = dTBAdRequest;
            dTBAdRequest.setSizes(dTBAdSizeArr);
        } catch (Throwable unused) {
        }
    }

    public void loadAd() {
        DTBAdRequest dTBAdRequest = this.aog;
        if (dTBAdRequest == null) {
            this.aof.onAdLoadFailed(null, this.format);
        } else {
            dTBAdRequest.loadAd(this);
        }
    }

    public void onSuccess(DTBAdResponse dTBAdResponse) {
        this.aof.onAdResponseLoaded(dTBAdResponse, this.format);
    }

    public void onFailure(AdError adError) {
        this.aof.onAdLoadFailed(adError, this.format);
    }
}
