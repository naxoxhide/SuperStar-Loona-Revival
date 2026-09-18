package com.tnkfactory.ad.pub.c;

import android.os.Build;
import com.google.common.net.HttpHeaders;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.pub.a.x0;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static a a;

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public static String a(String str, int i) {
        HttpURLConnection httpURLConnection;
        int i2;
        if (str != null) {
            str = str.replace("[ERRORCODE]", "" + i);
        }
        String string = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (!str.startsWith("https")) {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        if (Build.VERSION.SDK != null && (i2 = Build.VERSION.SDK_INT) > 13 && i2 < 19) {
                            httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "close");
                        }
                        httpURLConnection.setConnectTimeout(3000);
                        httpURLConnection.setReadTimeout(3000);
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setUseCaches(false);
                        String str2 = "HTTP ResponseCode : " + httpURLConnection.getResponseCode();
                        httpURLConnection.disconnect();
                        string = str2;
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection2 = httpURLConnection;
                        e.toString();
                        HttpURLConnection httpURLConnection3 = httpURLConnection2;
                        string = e.toString();
                        httpURLConnection = httpURLConnection3;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                Logger.d("https invoke " + str + " : return code = " + string);
                return string;
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setReadTimeout(3000);
            httpsURLConnection.setConnectTimeout(3000);
            httpsURLConnection.setDoOutput(false);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setSSLSocketFactory(new x0());
            string = "Https ResponseCode : " + httpsURLConnection.getResponseCode();
            httpsURLConnection.disconnect();
        } catch (SocketException | Exception unused) {
        }
        Logger.d("https invoke " + str + " : return code = " + string);
        return string;
    }

    public static /* synthetic */ void a(String str) {
        try {
            a(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (final String str : arrayList) {
            new Thread(new Runnable() { // from class: com.tnkfactory.ad.pub.c.-$$Lambda$oxtdNzN3HYwGr07iNWWVNlQiLno
                @Override // java.lang.Runnable
                public final void run() {
                    a.a(str);
                }
            }).start();
        }
    }
}
