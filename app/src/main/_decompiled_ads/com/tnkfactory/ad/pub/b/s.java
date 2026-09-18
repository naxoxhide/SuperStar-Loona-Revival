package com.tnkfactory.ad.pub.b;

import android.os.Build;
import com.google.common.net.HttpHeaders;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.pub.a.x0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes4.dex */
public final class s extends Thread {
    public List<String> a;

    public s(List<String> list) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        for (String str : this.a) {
            if (str != null) {
                try {
                    try {
                        URL url = new URL(str);
                        if (str.startsWith("http://")) {
                            try {
                                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                if (Build.VERSION.SDK != null && (i = Build.VERSION.SDK_INT) > 13 && i < 19) {
                                    httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "close");
                                }
                                httpURLConnection.setConnectTimeout(5000);
                                httpURLConnection.setReadTimeout(5000);
                                httpURLConnection.setRequestMethod("GET");
                                httpURLConnection.setDoOutput(false);
                                httpURLConnection.setUseCaches(false);
                                Logger.d("http invoke " + str + " : return code = " + httpURLConnection.getResponseCode());
                            } catch (MalformedURLException | ProtocolException | IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                            httpsURLConnection.setReadTimeout(5000);
                            httpsURLConnection.setConnectTimeout(5000);
                            httpsURLConnection.setDoOutput(false);
                            httpsURLConnection.setUseCaches(false);
                            httpsURLConnection.setRequestMethod("GET");
                            httpsURLConnection.setSSLSocketFactory(new x0());
                            Logger.d("https invoke " + str + " : return code = " + httpsURLConnection.getResponseCode());
                            httpsURLConnection.disconnect();
                        }
                    } catch (KeyManagementException e2) {
                        e = e2;
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e3) {
                        e = e3;
                        e.printStackTrace();
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                    }
                } catch (MalformedURLException e5) {
                    e = e5;
                    e.printStackTrace();
                } catch (ProtocolException e6) {
                    e = e6;
                    e.printStackTrace();
                } catch (IOException e7) {
                    e = e7;
                    e.printStackTrace();
                }
            }
        }
    }
}
