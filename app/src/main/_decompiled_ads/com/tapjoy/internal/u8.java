package com.tapjoy.internal;

import com.adxcorp.util.ADXLogUtil;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJCurrency;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.TapjoyUtil;
import java.util.Map;
import org.w3c.dom.Document;

/* JADX INFO: loaded from: classes4.dex */
public final class u8 implements Runnable {
    public final /* synthetic */ Map a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJAwardCurrencyListener f2821b;
    public final /* synthetic */ TJCurrency c;

    public u8(TJCurrency tJCurrency, Map map, TJAwardCurrencyListener tJAwardCurrencyListener) {
        this.c = tJCurrency;
        this.a = map;
        this.f2821b = tJAwardCurrencyListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TapjoyHttpURLResponse responseFromURL = new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_AWARD_CURRENCY_URL_PATH, this.a);
        TJCurrency tJCurrency = this.c;
        TJAwardCurrencyListener tJAwardCurrencyListener = this.f2821b;
        synchronized (tJCurrency) {
            String nodeTrimValue = "Failed to award currency";
            String str = responseFromURL.response;
            if (str != null) {
                Document documentBuildDocument = TapjoyUtil.buildDocument(str);
                if (documentBuildDocument != null) {
                    String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(documentBuildDocument.getElementsByTagName(ADXLogUtil.EVENT_LOAD_SUCCESS));
                    if (nodeTrimValue2 != null && nodeTrimValue2.equals("true")) {
                        String nodeTrimValue3 = TapjoyUtil.getNodeTrimValue(documentBuildDocument.getElementsByTagName("TapPoints"));
                        String nodeTrimValue4 = TapjoyUtil.getNodeTrimValue(documentBuildDocument.getElementsByTagName("CurrencyName"));
                        if (nodeTrimValue3 == null || nodeTrimValue4 == null) {
                            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is invalid -- missing tags."));
                        } else {
                            int i = Integer.parseInt(nodeTrimValue3);
                            tJCurrency.saveCurrencyBalance(i);
                            if (tJAwardCurrencyListener != null) {
                                tJAwardCurrencyListener.onAwardCurrencyResponse(nodeTrimValue4, i);
                            }
                        }
                    } else if (nodeTrimValue2 == null || !nodeTrimValue2.endsWith(TJAdUnitConstants.String.FALSE)) {
                        TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is invalid -- missing <Success> tag."));
                    } else {
                        nodeTrimValue = TapjoyUtil.getNodeTrimValue(documentBuildDocument.getElementsByTagName("Message"));
                        TapjoyLog.i("TJCurrency", nodeTrimValue);
                    }
                }
            } else {
                TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is NULL"));
            }
            if (tJAwardCurrencyListener != null) {
                tJAwardCurrencyListener.onAwardCurrencyResponseFailure(nodeTrimValue);
            }
        }
    }
}
