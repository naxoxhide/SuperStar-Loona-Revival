package com.mbridge.msdk.splash.signal;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class SplashSignal extends AbsFeedBackForH5 {
    private static String d = "SplashSignal";
    private b e;

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof b)) {
                return;
            }
            this.e = (b) windVaneWebView.getObject();
        } catch (Throwable th) {
            aa.b(d, MobileAdsBridgeBase.initializeMethodName, th);
        }
    }

    public void init(Object obj, String str) {
        aa.d(d, MobileAdsBridgeBase.initializeMethodName + str);
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(obj, str);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        aa.d(d, "toggleCloseBtn" + str);
        b bVar = this.e;
        if (bVar != null) {
            bVar.b(obj, str);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        aa.d(d, "triggerCloseBtn" + str);
        b bVar = this.e;
        if (bVar != null) {
            bVar.c(obj, str);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().a(windVaneWebView, iOptInt);
                    }
                }
            } catch (Throwable th) {
                aa.b(d, "readyStatus", th);
            }
        }
    }

    public void install(Object obj, String str) {
        b bVar = this.e;
        if (bVar != null) {
            bVar.d(obj, str);
        }
    }

    public void resetCountdown(Object obj, String str) {
        aa.d(d, "resetCountdown" + str);
        b bVar = this.e;
        if (bVar != null) {
            bVar.f(obj, str);
        }
    }

    public void openURL(Object obj, String str) {
        aa.d(d, "openURL" + str);
        b bVar = this.e;
        if (bVar != null) {
            bVar.e(obj, str);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        if (obj != null) {
            try {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().a(windVaneWebView, 0, str.toString(), windVaneWebView.getUrl());
                    }
                }
            } catch (Throwable th) {
                aa.b(d, "handlerH5Exception", th);
            }
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a(obj, new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            aa.d(d, "sendImpressions");
            b bVar = this.e;
            if (bVar != null) {
                bVar.g(obj, str);
            }
        } catch (Throwable th) {
            aa.b(d, "sendImpressions", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            aa.d(d, "reportUrls");
            b bVar = this.e;
            if (bVar != null) {
                bVar.h(obj, str);
            }
        } catch (Throwable th) {
            aa.b(d, "reportUrls", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            c.b(obj, new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onSignalCommunication(Object obj, String str) {
        try {
            aa.d(d, "onSignalCommunication");
            b bVar = this.e;
            if (bVar != null) {
                bVar.i(obj, str);
            }
        } catch (Throwable th) {
            aa.b(d, "onSignalCommunication", th);
        }
    }

    public void pauseCountDown(Object obj, String str) {
        try {
            aa.d(d, "pauseCountDown");
            b bVar = this.e;
            if (bVar != null) {
                bVar.j(obj, str);
            }
        } catch (Throwable th) {
            aa.b(d, "pauseCountDown", th);
        }
    }

    public void resumeCountDown(Object obj, String str) {
        try {
            aa.d(d, "resumeCountDown");
            b bVar = this.e;
            if (bVar != null) {
                bVar.k(obj, str);
            }
        } catch (Throwable th) {
            aa.b(d, "resumeCountDown", th);
        }
    }
}
