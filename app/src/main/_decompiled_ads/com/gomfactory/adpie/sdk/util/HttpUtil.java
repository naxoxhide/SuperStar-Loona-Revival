package com.gomfactory.adpie.sdk.util;

import android.os.Handler;
import android.os.Message;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class HttpUtil {
    public static final int BACKGROUND_ASYNC_REDIRECT = 100;
    public static final String TAG = "HttpUtil";

    public static void getFinalURL(final String str, final Handler handler) {
        new AsyncTaskUtil() { // from class: com.gomfactory.adpie.sdk.util.HttpUtil.1
            @Override // com.gomfactory.adpie.sdk.util.AsyncTaskUtil
            public void doInBackground() {
                String strTryConnectUrl = HttpUtil.tryConnectUrl(str, 0);
                Handler handler2 = handler;
                if (handler2 != null) {
                    Message messageObtainMessage = handler2.obtainMessage();
                    messageObtainMessage.what = 100;
                    messageObtainMessage.obj = strTryConnectUrl;
                    handler.sendMessage(messageObtainMessage);
                }
            }
        }.execute();
    }

    public static String tryConnectUrl(String str, int i) {
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", AdPieSDK.getInstance().getCommonHeader().getUserAgent());
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "[tryConnectUrl] ResponseCode : " + responseCode);
            }
            if (responseCode == 303 || responseCode == 301 || responseCode == 302) {
                String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                if (headerField.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    headerField = url.getProtocol() + "://" + url.getHost() + headerField;
                }
                int i2 = i + 1;
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "[tryConnectUrl] Location : " + headerField + "\ncount : " + i2);
                }
                if (i2 <= 20) {
                    return tryConnectUrl(headerField, i2);
                }
            }
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
        }
        return str;
    }
}
