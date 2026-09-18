package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.communication.b;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.a.j;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BaseRewardSignal extends AbsFeedBackForH5 implements IRewardCommunication {
    protected IRewardCommunication d;

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        boolean zIsInstance;
        super.initialize(context, windVaneWebView);
        try {
            zIsInstance = Class.forName("com.mbridge.msdk.video.signal.factory.IJSFactory").isInstance(context);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            zIsInstance = false;
        }
        try {
            if (zIsInstance) {
                Class<?> cls = Class.forName("com.mbridge.msdk.video.signal.communication.BaseRewardSignalH5");
                this.d = (IRewardCommunication) cls.newInstance();
                cls.getMethod(MobileAdsBridgeBase.initializeMethodName, Context.class, WindVaneWebView.class).invoke(this.d, context, windVaneWebView);
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IRewardCommunication)) {
                this.d = (IRewardCommunication) windVaneWebView.getObject();
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        boolean zIsInstance;
        super.initialize(obj, windVaneWebView);
        try {
            zIsInstance = Class.forName("com.mbridge.msdk.video.signal.factory.IJSFactory").isInstance(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            zIsInstance = false;
        }
        try {
            if (zIsInstance) {
                Class<?> cls = Class.forName("com.mbridge.msdk.video.signal.communication.BaseRewardSignalH5");
                this.d = (IRewardCommunication) cls.newInstance();
                cls.getMethod(MobileAdsBridgeBase.initializeMethodName, Object.class, WindVaneWebView.class).invoke(this.d, obj, windVaneWebView);
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IRewardCommunication)) {
                this.d = (IRewardCommunication) windVaneWebView.getObject();
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        try {
            IRewardCommunication iRewardCommunication = this.d;
            if (iRewardCommunication != null) {
                iRewardCommunication.getEndScreenInfo(obj, str);
                aa.d("JS-Reward-Brigde", "getEndScreenInfo factory is true");
            } else {
                aa.d("JS-Reward-Brigde", "getEndScreenInfo factory is null");
                if (obj != null) {
                    a aVar = (a) obj;
                    if (aVar.a instanceof WindVaneWebView) {
                        WindVaneWebView windVaneWebView = aVar.a;
                        if (windVaneWebView.getWebViewListener() != null) {
                            ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(obj);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            aa.b("JS-Reward-Brigde", "getEndScreenInfo", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void install(Object obj, String str) {
        try {
            IRewardCommunication iRewardCommunication = this.d;
            if (iRewardCommunication != null) {
                iRewardCommunication.install(obj, str);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (obj != null) {
                a aVar = (a) obj;
                if (aVar.a.getObject() instanceof j) {
                    ((j) aVar.a.getObject()).click(1, str);
                    aa.d("JS-Reward-Brigde", "JSCommon install jump success");
                }
            }
            aa.d("JS-Reward-Brigde", "JSCommon install failed");
        } catch (Throwable th) {
            aa.b("JS-Reward-Brigde", "install", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.d.notifyCloseBtn(obj, str);
        } catch (Throwable th) {
            aa.b("JS-Reward-Brigde", "notifyCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.d.toggleCloseBtn(obj, str);
        } catch (Throwable th) {
            aa.b("JS-Reward-Brigde", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.d.triggerCloseBtn(obj, str);
        } catch (Throwable th) {
            aa.b("JS-Reward-Brigde", "triggerCloseBtn", th);
            g.a().a(obj, a(-1));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void setOrientation(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.d.setOrientation(obj, str);
        } catch (Throwable th) {
            aa.b("JS-Reward-Brigde", "setOrientation", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.d.handlerPlayableException(obj, str);
        } catch (Throwable th) {
            aa.b("JS-Reward-Brigde", "handlerPlayableException", th);
        }
    }

    private String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            aa.d("JS-Reward-Brigde", "code to string is error");
            return "";
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void openURL(Object obj, String str) {
        aa.d("JS-Reward-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                com.mbridge.msdk.click.b.a(this.a, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.b.b(this.a, strOptString);
            }
        } catch (JSONException e) {
            aa.d("JS-Reward-Brigde", e.getMessage());
        } catch (Throwable th) {
            aa.d("JS-Reward-Brigde", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void cai(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("packageName");
            if (TextUtils.isEmpty(strOptString)) {
                b.a(obj, "packageName is empty");
            }
            int i = af.c(com.mbridge.msdk.foundation.controller.b.d().g(), strOptString) ? 1 : 2;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", b.f2325b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", i);
                jSONObject.put("data", jSONObject2);
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception e) {
                b.a(obj, e.getMessage());
                aa.a("JS-Reward-Brigde", e.getMessage());
            }
        } catch (JSONException e2) {
            b.a(obj, "exception: " + e2.getLocalizedMessage());
            aa.b("JS-Reward-Brigde", "cai", e2);
        } catch (Throwable th) {
            b.a(obj, "exception: " + th.getLocalizedMessage());
            aa.b("JS-Reward-Brigde", "cai", th);
        }
    }
}
