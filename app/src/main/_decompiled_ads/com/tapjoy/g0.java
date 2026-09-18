package com.tapjoy;

import com.adxcorp.util.ADXLogUtil;
import org.w3c.dom.Document;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Document documentBuildDocument;
        String nodeTrimValue;
        TapjoyLog.i("TapjoyConnect", "Setting userID to " + TapjoyConnectCore.A);
        String hostURL = TapjoyConnectCore.getHostURL();
        String str = TapjoyConnectCore.f.getResponseFromURL(hostURL + TapjoyConstants.TJC_USER_ID_URL_PATH, TapjoyConnectCore.getURLParams()).response;
        boolean z = false;
        if (str != null && ((documentBuildDocument = TapjoyUtil.buildDocument(str)) == null || ((nodeTrimValue = TapjoyUtil.getNodeTrimValue(documentBuildDocument.getElementsByTagName(ADXLogUtil.EVENT_LOAD_SUCCESS))) != null && nodeTrimValue.equals("true")))) {
            z = true;
        }
        if (!z && !TapjoyConnectCore.j && !hostURL.equalsIgnoreCase(TapjoyConnectCore.getHostURL())) {
            TapjoyConnectCore.j = true;
            TapjoyConnectCore.setUserID(TapjoyConnectCore.A, TapjoyConnectCore.h);
            return;
        }
        if (z) {
            TapjoyLog.i("TapjoyConnect", "Set userID is successful");
            TJSetUserIDListener tJSetUserIDListener = TapjoyConnectCore.h;
            if (tJSetUserIDListener != null) {
                tJSetUserIDListener.onSetUserIDSuccess();
                return;
            }
            return;
        }
        TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Failed to set userID"));
        TJSetUserIDListener tJSetUserIDListener2 = TapjoyConnectCore.h;
        if (tJSetUserIDListener2 != null) {
            tJSetUserIDListener2.onSetUserIDFailure("Failed to set userID");
        }
        TapjoyConnectCore.i = true;
    }
}
