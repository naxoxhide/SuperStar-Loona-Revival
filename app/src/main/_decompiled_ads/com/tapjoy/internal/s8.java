package com.tapjoy.internal;

import com.adxcorp.util.ADXLogUtil;
import com.tapjoy.TJCurrency;
import com.tapjoy.TJGetCurrencyBalanceListener;
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
public final class s8 implements Runnable {
    public final /* synthetic */ Map a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJGetCurrencyBalanceListener f2812b;
    public final /* synthetic */ TJCurrency c;

    public s8(TJCurrency tJCurrency, Map map, TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        this.c = tJCurrency;
        this.a = map;
        this.f2812b = tJGetCurrencyBalanceListener;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00e2 A[Catch: all -> 0x00e9, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0027, B:6:0x002d, B:8:0x0033, B:10:0x003f, B:12:0x0047, B:15:0x005f, B:20:0x0071, B:21:0x008a, B:23:0x008f, B:26:0x0094, B:27:0x00b4, B:28:0x00c3, B:31:0x00e2, B:29:0x00d2), top: B:37:0x0027, inners: #1 }] */
    @Override // java.lang.Runnable
    public final void run() {
        TapjoyHttpURLResponse responseFromURL = new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_GET_CURRENCY_BALANCE_URL_PATH, this.a);
        TJCurrency tJCurrency = this.c;
        TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener = this.f2812b;
        synchronized (tJCurrency) {
            String str = responseFromURL.response;
            if (str != null) {
                Document documentBuildDocument = TapjoyUtil.buildDocument(str);
                if (documentBuildDocument != null) {
                    String nodeTrimValue = TapjoyUtil.getNodeTrimValue(documentBuildDocument.getElementsByTagName(ADXLogUtil.EVENT_LOAD_SUCCESS));
                    if (nodeTrimValue == null || !nodeTrimValue.equals("true")) {
                        TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is invalid -- missing <Success> tag."));
                    } else {
                        String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(documentBuildDocument.getElementsByTagName("TapPoints"));
                        String nodeTrimValue3 = TapjoyUtil.getNodeTrimValue(documentBuildDocument.getElementsByTagName("CurrencyName"));
                        if (nodeTrimValue2 == null || nodeTrimValue3 == null) {
                            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is invalid -- missing tags."));
                        } else {
                            try {
                                int i = Integer.parseInt(nodeTrimValue2);
                                int localCurrencyBalance = tJCurrency.getLocalCurrencyBalance();
                                if (TJCurrency.c != null && localCurrencyBalance != -9999 && i > localCurrencyBalance) {
                                    int i2 = i - localCurrencyBalance;
                                    TapjoyLog.i("TJCurrency", "earned: " + i2);
                                    TJCurrency.c.onEarnedCurrency(nodeTrimValue3, i2);
                                }
                                tJCurrency.saveCurrencyBalance(i);
                                if (tJGetCurrencyBalanceListener != null) {
                                    tJGetCurrencyBalanceListener.onGetCurrencyBalanceResponse(nodeTrimValue3, i);
                                }
                            } catch (Exception e) {
                                TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "Error parsing XML and calling listener: " + e.toString()));
                                if (tJGetCurrencyBalanceListener != null) {
                                    tJGetCurrencyBalanceListener.onGetCurrencyBalanceResponseFailure("Failed to get currency balance");
                                }
                            }
                        }
                    }
                }
            } else {
                TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is NULL"));
            }
            if (tJGetCurrencyBalanceListener != null) {
                tJGetCurrencyBalanceListener.onGetCurrencyBalanceResponseFailure("Failed to get currency balance");
            }
        }
    }
}
