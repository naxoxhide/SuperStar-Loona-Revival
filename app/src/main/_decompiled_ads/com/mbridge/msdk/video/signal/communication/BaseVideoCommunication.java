package com.mbridge.msdk.video.signal.communication;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BaseVideoCommunication extends AbsFeedBackForH5 implements IVideoCommunication {
    protected IJSFactory d;
    private FastKV e = null;

    private String a(int i) {
        switch (i) {
            case 1:
                return "sdk_info";
            case 2:
                return MBridgeConstans.PROPERTIES_UNIT_ID;
            case 3:
                return "appSetting";
            case 4:
                return "unitSetting";
            case 5:
                return DeviceRequestsHelper.DEVICE_INFO_DEVICE;
            case 6:
                return "sdkSetting";
            default:
                return "";
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reportData(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        super.initialize(obj, windVaneWebView);
        if (obj instanceof IJSFactory) {
            this.d = (IJSFactory) obj;
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void init(Object obj, String str) {
        aa.b("JS-Video-Brigde", "init");
        try {
            IJSFactory iJSFactory = this.d;
            int i = 1;
            if (iJSFactory != null) {
                String strC = iJSFactory.getJSCommon().c();
                if (!TextUtils.isEmpty(strC)) {
                    strC = Base64.encodeToString(strC.getBytes(), 2);
                }
                g.a().a(obj, strC);
                this.d.getJSCommon().b(true);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("showTransparent");
                int iOptInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                int iOptInt3 = jSONObject.optInt("closeType");
                int iOptInt4 = jSONObject.optInt("orientationType");
                int iOptInt5 = jSONObject.optInt("webfront");
                int iOptInt6 = jSONObject.optInt("showAlertRole");
                this.d.getJSCommon().a(iOptInt == 1);
                this.d.getJSCommon().b(iOptInt2);
                this.d.getJSCommon().c(iOptInt3);
                this.d.getJSCommon().d(iOptInt4);
                this.d.getJSCommon().e(iOptInt5);
                c jSCommon = this.d.getJSCommon();
                if (iOptInt6 != 0) {
                    i = iOptInt6;
                }
                jSCommon.h(i);
                return;
            }
            if (obj != null) {
                a aVar = (a) obj;
                if (aVar.a.getObject() instanceof j) {
                    j jVar = (j) aVar.a.getObject();
                    String strC2 = jVar.c();
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int iOptInt7 = jSONObject2.optInt("showTransparent");
                        int iOptInt8 = jSONObject2.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                        int iOptInt9 = jSONObject2.optInt("closeType");
                        int iOptInt10 = jSONObject2.optInt("orientationType");
                        int iOptInt11 = jSONObject2.optInt("webfront");
                        int iOptInt12 = jSONObject2.optInt("showAlertRole");
                        jVar.a(iOptInt7 == 1);
                        jVar.b(iOptInt8);
                        jVar.c(iOptInt9);
                        jVar.d(iOptInt10);
                        jVar.e(iOptInt11);
                        if (iOptInt12 != 0) {
                            i = iOptInt12;
                        }
                        jVar.h(i);
                        aa.b("JS-Video-Brigde", "init jsCommon.setIsShowingTransparent = " + iOptInt7);
                    }
                    g.a().a(obj, Base64.encodeToString(strC2.getBytes(), 2));
                }
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "init error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void click(Object obj, String str) {
        int iOptInt;
        String strOptString;
        j jVar;
        aa.b("JS-Video-Brigde", "click");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                iOptInt = jSONObject.optInt("type");
                strOptString = jSONObject.optString(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT);
            } catch (JSONException e) {
                e.printStackTrace();
                iOptInt = 1;
                strOptString = "";
            }
            IJSFactory iJSFactory = this.d;
            if (iJSFactory != null) {
                iJSFactory.getJSCommon().click(iOptInt, strOptString);
                return;
            }
            if (obj != null) {
                a aVar = (a) obj;
                if (!(aVar.a.getObject() instanceof j) || (jVar = (j) aVar.a.getObject()) == null) {
                    return;
                }
                jVar.click(iOptInt, strOptString);
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "click error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void statistics(Object obj, String str) {
        aa.b("JS-Video-Brigde", "statistics,params:" + str);
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.d.getJSCommon().a(jSONObject.optInt("type"), jSONObject.optString("data"));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "statistics error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void triggerCloseBtn(Object obj, String str) {
        aa.b("JS-Video-Brigde", "triggerCloseBtn");
        try {
            if (this.d == null || TextUtils.isEmpty(str) || !new JSONObject(str).optString("state").equals("click")) {
                return;
            }
            this.d.getJSVideoModule().closeVideoOperate(1, -1);
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "triggerCloseBtn error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showVideoLocation(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("margin_top", 0);
            int iOptInt2 = jSONObject.optInt("margin_left", 0);
            int iOptInt3 = jSONObject.optInt("view_width", 0);
            int iOptInt4 = jSONObject.optInt("view_height", 0);
            int iOptInt5 = jSONObject.optInt("radius", 0);
            int iOptInt6 = jSONObject.optInt("border_top", 0);
            int iOptInt7 = jSONObject.optInt("border_left", 0);
            int iOptInt8 = jSONObject.optInt("border_width", 0);
            int iOptInt9 = jSONObject.optInt("border_height", 0);
            aa.b("JS-Video-Brigde", "showVideoLocation,margin_top:" + iOptInt + ",marginLeft:" + iOptInt2 + ",viewWidth:" + iOptInt3 + ",viewHeight:" + iOptInt4 + ",radius:" + iOptInt5 + ",borderTop: " + iOptInt6 + ",borderLeft: " + iOptInt7 + ",borderWidth: " + iOptInt8 + ",borderHeight: " + iOptInt9);
            this.d.getJSVideoModule().showVideoLocation(iOptInt, iOptInt2, iOptInt3, iOptInt4, iOptInt5, iOptInt6, iOptInt7, iOptInt8, iOptInt9);
            this.d.getJSCommon().f();
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "showVideoLocation error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void soundOperate(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
            int iOptInt2 = jSONObject.optInt("view_visible");
            String strOptString = jSONObject.optString(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT, "");
            aa.b("JS-Video-Brigde", "soundOperate,mute:" + iOptInt + ",viewVisible:" + iOptInt2 + ",pt:" + strOptString);
            if (TextUtils.isEmpty(strOptString)) {
                this.d.getJSVideoModule().soundOperate(iOptInt, iOptInt2);
            } else {
                this.d.getJSVideoModule().soundOperate(iOptInt, iOptInt2, strOptString);
            }
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "soundOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void videoOperate(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("pause_or_resume");
            aa.b("JS-Video-Brigde", "videoOperate,pauseOrResume:" + iOptInt);
            this.d.getJSVideoModule().videoOperate(iOptInt);
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "videoOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeVideoOperte(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("close");
            int iOptInt2 = jSONObject.optInt("view_visible");
            aa.b("JS-Video-Brigde", "closeVideoOperte,close:" + iOptInt + ",viewVisible:" + iOptInt2);
            this.d.getJSVideoModule().closeVideoOperate(iOptInt, iOptInt2);
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "closeOperte error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void progressOperate(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
            int iOptInt2 = jSONObject.optInt("view_visible");
            aa.b("JS-Video-Brigde", "progressOperate,progress:" + iOptInt + ",viewVisible:" + iOptInt2);
            this.d.getJSVideoModule().progressOperate(iOptInt, iOptInt2);
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void progressBarOperate(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.d.getJSVideoModule().progressBarOperate(new JSONObject(str).optInt("view_visible"));
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getCurrentProgress(Object obj, String str) {
        try {
            IJSFactory iJSFactory = this.d;
            if (iJSFactory != null) {
                String currentProgress = iJSFactory.getJSVideoModule().getCurrentProgress();
                aa.b("JS-Video-Brigde", "getCurrentProgress:" + currentProgress);
                if (!TextUtils.isEmpty(currentProgress)) {
                    currentProgress = Base64.encodeToString(currentProgress.getBytes(), 2);
                }
                g.a().a(obj, currentProgress);
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "getCurrentProgress error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showVideoClickView(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("type");
            aa.b("JS-Video-Brigde", "showVideoClickView,type:" + iOptInt);
            this.d.getJSContainerModule().showVideoClickView(iOptInt);
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setScaleFitXY(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("fitxy");
            aa.b("JS-Video-Brigde", "setScaleFitXY,type:" + iOptInt);
            this.d.getJSVideoModule().setScaleFitXY(iOptInt);
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("state");
            aa.b("JS-Video-Brigde", "notifyCloseBtn,result:" + iOptInt);
            this.d.getJSVideoModule().notifyCloseBtn(iOptInt);
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "notifyCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void openURL(Object obj, String str) {
        aa.d("JS-Video-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                b.a(this.a, strOptString);
            } else if (iOptInt == 2) {
                b.b(this.a, strOptString);
            }
        } catch (JSONException e) {
            aa.d("JS-Video-Brigde", e.getMessage());
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showAlertView(Object obj, String str) {
        aa.b("JS-Video-Brigde", "showAlertView");
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.d.getJSVideoModule().showIVRewardAlertView(str);
            g.a().a(obj, "showAlertView", "");
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "showAlertView", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("state");
            aa.b("JS-Video-Brigde", "toggleCloseBtn,result:" + iOptInt);
            int i = 2;
            if (iOptInt != 1) {
                i = iOptInt == 2 ? 1 : 0;
            }
            this.d.getJSVideoModule().closeVideoOperate(0, i);
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void handlerH5Exception(Object obj, String str) {
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            aa.b("JS-Video-Brigde", "handlerH5Exception,params:" + str);
            this.d.getJSCommon().handlerH5Exception(jSONObject.optInt("code", -999), jSONObject.optString("message", "h5 error"));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "handlerH5Exception", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void isSystemResume(Object obj, String str) {
        try {
            if (this.d != null) {
                aa.b("JS-Video-Brigde", "isSystemResume,params:" + str);
                g.a().a(obj, b(this.d.getActivityProxy().h()));
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "isSystemResume", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                a aVar = (a) obj;
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a.getObject() instanceof j) {
                    ((j) aVar.a.getObject()).i(iOptInt);
                }
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().a(windVaneWebView, iOptInt);
                    }
                }
            } catch (Throwable th) {
                aa.b("JS-Video-Brigde", "readyStatus", th);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playVideoFinishOperate(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str) || this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("type");
            aa.b("JS-Video-Brigde", "playVideoFinishOperate,type: " + iOptInt);
            this.d.getJSCommon().f(iOptInt);
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "playVideoFinishOperate error", th);
        }
    }

    private String b(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            aa.d("JS-Video-Brigde", "code to string is error");
            return "";
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reactDeveloper(Object obj, String str) {
        aa.a("JS-Video-Brigde", "reactDeveloper");
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.d.getJSBTModule().reactDeveloper(obj, str);
            } else {
                g.a().b(obj, b(1));
            }
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "reactDeveloper error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reportUrls(Object obj, String str) {
        aa.a("JS-Video-Brigde", "reportUrls");
        try {
            if (!TextUtils.isEmpty(str)) {
                IJSFactory iJSFactory = this.d;
                if (iJSFactory != null && iJSFactory.getJSBTModule() != null) {
                    this.d.getJSBTModule().reportUrls(obj, str);
                } else {
                    com.mbridge.msdk.video.bt.a.c.a().b(obj, str);
                }
            } else {
                g.a().b(obj, b(1));
            }
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "reportUrls error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getFileInfo(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().N(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "getFileInfo error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getSDKInfo(Object obj, String str) {
        aa.b("JS-Video-Brigde", "getSDKInfo");
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("type");
                JSONObject jSONObject = new JSONObject();
                int i = 0;
                if (this.d != null) {
                    while (i < jSONArray.length()) {
                        int i2 = jSONArray.getInt(i);
                        jSONObject.put(a(i2), this.d.getJSCommon().g(i2));
                        i++;
                    }
                } else if (obj != null) {
                    while (i < jSONArray.length()) {
                        int i3 = jSONArray.getInt(i);
                        a aVar = (a) obj;
                        if (aVar.a.getObject() instanceof j) {
                            jSONObject.put(a(i3), ((j) aVar.a.getObject()).g(i3));
                        }
                        i++;
                    }
                }
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                return;
            }
            g.a().b(obj, "params is null");
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "getSDKInfo error", th);
            g.a().b(obj, "exception");
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void loadads(Object obj, String str) {
        int i;
        int iOptInt;
        String str2;
        String str3;
        aa.b("JS-Video-Brigde", "loadads");
        try {
            if (TextUtils.isEmpty(str)) {
                i = 1;
                iOptInt = 1;
                str2 = "";
                str3 = str2;
            } else {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString(MBridgeConstans.PLACEMENT_ID);
                String strOptString2 = jSONObject.optString("unitId");
                int iOptInt2 = jSONObject.optInt("type", 1);
                if (iOptInt2 > 2) {
                    iOptInt2 = 1;
                }
                str3 = strOptString2;
                iOptInt = jSONObject.optInt("adtype", 1);
                i = iOptInt2;
                str2 = strOptString;
            }
            if (TextUtils.isEmpty(str3)) {
                g.a().a(obj, b(1));
                return;
            }
            if (obj != null) {
                a aVar = (a) obj;
                if (aVar.a instanceof WindVaneWebView) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(windVaneWebView, str2, str3, i, iOptInt);
                    }
                }
            }
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "loadads error", th);
            g.a().a(obj, b(1));
        }
    }

    private void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("message", "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Exception e) {
            aa.a("JS-Video-Brigde", e.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createWebview(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().b(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "createWebview error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "createView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createPlayerView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().c(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "createPlayerView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().d(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "createSubPlayTemplateView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void destroyComponent(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().e(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "destroyComponent error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getComponentOptions(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().f(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getComponentOptions error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewRect(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().g(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setViewRect error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void removeFromSuperView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().h(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "removeFromSuperView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void appendSubView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().i(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "appendSubView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void appendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().j(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "appendViewTo error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyAppendSubView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().k(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "appendSubView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyAppendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().l(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "appendViewTo error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void bringViewToFront(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().m(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "bringViewToFront error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void hideView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().n(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "hideView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().o(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "showView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewBgColor(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().p(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setViewBgColor error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewAlpha(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().q(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setViewAlpha error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewScale(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().r(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setViewScale error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void insertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().a(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "insertViewAbove error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void insertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().b(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "insertViewBelow error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyInsertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().s(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "insertViewAbove error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyInsertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().b(obj, new JSONObject(str), false);
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "insertViewBelow error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewLoad(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().t(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "webviewLoad error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewReload(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().u(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "webviewReload error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewGoBack(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().v(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "webviewGoBack error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewGoForward(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().w(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "webviewGoForward error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerPlay(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().x(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerPlay error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerPause(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().y(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerPause error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerResume(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().z(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerResume error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerStop(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().A(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerStop error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerUpdateFrame(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().B(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerUpdateFrame error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerMute(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().C(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerMute error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerUnmute(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().D(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerUnmute error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerGetMuteState(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().E(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerGetMuteState error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerSetSource(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().F(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerSetSource error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerSetRenderType(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().G(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerSetRenderType error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void preloadSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            if (this.d != null) {
                com.mbridge.msdk.video.bt.a.c.a().H(obj, new JSONObject(str));
            } else {
                a aVar = (a) obj;
                if (aVar.a instanceof WindVaneWebView) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(obj, str);
                        aa.a("JS-Video-Brigde", "preloadSubPlayTemplateView: RVWebViewListener");
                    } else {
                        aa.a("JS-Video-Brigde", "preloadSubPlayTemplateView: failed");
                    }
                }
            }
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "preloadSubPlayTemplateView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeAd(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().I(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "closeAd error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void broadcast(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().J(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "broadcast error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeWeb(Object obj, String str) {
        aa.d("JS-Video-Brigde", "type" + str);
        try {
            if (TextUtils.isEmpty(str) || this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("status");
            this.d.getJSContainerModule().hideAlertWebview();
            this.d.getJSVideoModule().hideAlertView(iOptInt);
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "closeWeb", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void ivRewardAdsWithoutVideo(Object obj, String str) {
        aa.d("JS-Video-Brigde", "ivRewardAdsWithoutVideo ： params" + str);
        try {
            if (TextUtils.isEmpty(str) || this.d == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.d.getJSContainerModule().ivRewardAdsWithoutVideo(str);
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "ivRewardAdsWithoutVideo", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setSubPlayTemplateInfo(Object obj, String str) {
        aa.d("JS-Video-Brigde", "setSubPlayTemplateInfo : " + str);
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().K(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setSubPlayTemplateInfo error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewFireEvent(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().L(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setSubPlayTemplateInfo error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void increaseOfferFrequence(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().M(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "increaseOfferFrequence error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void handleNativeObject(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.b.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "handleNativeObject error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void loadingResourceStatus(Object obj, String str) {
        a(obj, str);
        if (obj != null) {
            try {
                a aVar = (a) obj;
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().c(windVaneWebView, iOptInt);
                    }
                }
            } catch (Throwable th) {
                aa.d("JS-Video-Brigde", "loadingResourceStatus error " + th);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createNativeEC(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().O(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "createNativeEC error " + th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0059  */
    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setCacheItem(Object obj, String str) {
        boolean z;
        com.mbridge.msdk.foundation.controller.c.a();
        if (this.e == null) {
            try {
                this.e = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.e = null;
            }
        }
        String str2 = "Save Success";
        if (this.e != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    z = false;
                    str2 = "";
                } else {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString(SDKConstants.PARAM_KEY);
                    String string2 = jSONObject.getString("value");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        try {
                            this.e.putString(string, string2);
                        } catch (Exception unused2) {
                        }
                    }
                    z = true;
                }
            } catch (Throwable th) {
                aa.d("JS-Video-Brigde", "setCacheItem error " + th);
                str2 = "Save Error, reason is : " + th.getMessage();
                z = false;
            }
        } else {
            try {
                SharedPreferences sharedPreferences = com.mbridge.msdk.foundation.controller.b.d().g().getSharedPreferences("MBridgeH5CacheSP", 0);
                if (TextUtils.isEmpty(str)) {
                    z = false;
                    str2 = "";
                } else {
                    JSONObject jSONObject2 = new JSONObject(str);
                    String string3 = jSONObject2.getString(SDKConstants.PARAM_KEY);
                    String string4 = jSONObject2.getString("value");
                    if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                        sharedPreferences.edit().putString(string3, string4).apply();
                    }
                    z = true;
                }
            } catch (Throwable th2) {
                aa.d("JS-Video-Brigde", "setCacheItem error " + th2);
                str2 = "Save Error, reason is : " + th2.getMessage();
                z = false;
            }
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("code", z ? 0 : 1);
            jSONObject3.put("message", str2);
            if (obj != null && z) {
                g.a().a(obj, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } else {
                g.a().b(obj, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            }
        } catch (Throwable unused3) {
            aa.d("JS-Video-Brigde", "setCacheItem error ");
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004d  */
    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void removeCacheItem(Object obj, String str) {
        boolean z;
        com.mbridge.msdk.foundation.controller.c.a();
        if (this.e == null) {
            try {
                this.e = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.e = null;
            }
        }
        String str2 = "Delete Success";
        if (this.e != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    z = false;
                    str2 = "";
                } else {
                    String string = new JSONObject(str).getString(SDKConstants.PARAM_KEY);
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            this.e.remove(string);
                        } catch (Exception unused2) {
                        }
                    }
                    z = true;
                }
            } catch (Throwable th) {
                aa.d("JS-Video-Brigde", "removeCacheItem error " + th);
                str2 = "Delete Error, reason is : " + th.getMessage();
                z = false;
            }
        } else {
            try {
                SharedPreferences sharedPreferences = com.mbridge.msdk.foundation.controller.b.d().g().getSharedPreferences("MBridgeH5CacheSP", 0);
                if (TextUtils.isEmpty(str)) {
                    z = false;
                    str2 = "";
                } else {
                    String string2 = new JSONObject(str).getString(SDKConstants.PARAM_KEY);
                    if (!TextUtils.isEmpty(string2)) {
                        sharedPreferences.edit().remove(string2).apply();
                    }
                    z = true;
                }
            } catch (Throwable th2) {
                aa.d("JS-Video-Brigde", "removeCacheItem error " + th2);
                str2 = "Delete Error, reason is : " + th2.getMessage();
                z = false;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", z ? 0 : 1);
            jSONObject.put("message", str2);
            if (obj != null && z) {
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } else {
                g.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable unused3) {
            aa.d("JS-Video-Brigde", "removeCacheItem error ");
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getAllCache(Object obj, String str) {
        JSONObject jSONObject;
        com.mbridge.msdk.foundation.controller.c.a();
        JSONObject jSONObject2 = null;
        Map<String, Object> all = null;
        jSONObject2 = null;
        if (this.e == null) {
            try {
                this.e = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.e = null;
            }
        }
        String str2 = "getAllCache Success";
        if (this.e != null) {
            try {
                jSONObject = new JSONObject();
                try {
                    try {
                        all = this.e.getAll();
                    } catch (Throwable th) {
                        th = th;
                        jSONObject2 = jSONObject;
                        aa.d("JS-Video-Brigde", "getAllCache error " + th);
                        str2 = "getAllCache Error, reason is : " + th.getMessage();
                        jSONObject = jSONObject2;
                    }
                } catch (Exception unused2) {
                }
                if (all != null) {
                    for (Map.Entry<String, Object> entry : all.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            try {
                SharedPreferences sharedPreferences = com.mbridge.msdk.foundation.controller.b.d().g().getSharedPreferences("MBridgeH5CacheSP", 0);
                JSONObject jSONObject3 = new JSONObject();
                try {
                    for (Map.Entry<String, ?> entry2 : sharedPreferences.getAll().entrySet()) {
                        jSONObject3.put(entry2.getKey(), entry2.getValue());
                    }
                    jSONObject = jSONObject3;
                } catch (Throwable th3) {
                    th = th3;
                    jSONObject2 = jSONObject3;
                    aa.d("JS-Video-Brigde", "getAllCache error " + th);
                    str2 = "getAllCache Error, reason is : " + th.getMessage();
                    jSONObject = jSONObject2;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("code", 0);
            jSONObject4.put("message", str2);
            if (jSONObject != null) {
                jSONObject4.put("data", jSONObject);
            } else {
                jSONObject4.put("data", JsonUtils.EMPTY_JSON);
            }
            if (obj != null) {
                g.a().a(obj, Base64.encodeToString(jSONObject4.toString().getBytes(), 2));
            }
        } catch (Throwable th5) {
            aa.d("JS-Video-Brigde", "getAllCache error " + th5);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void clearAllCache(Object obj, String str) {
        com.mbridge.msdk.foundation.controller.c.a();
        if (this.e == null) {
            try {
                this.e = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.e = null;
            }
        }
        FastKV fastKV = this.e;
        if (fastKV != null) {
            try {
                try {
                    fastKV.clear();
                } catch (Exception unused2) {
                }
                if (obj != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("message", ADXLogUtil.EVENT_LOAD_SUCCESS);
                    g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    return;
                }
                return;
            } catch (Throwable th) {
                aa.d("JS-Video-Brigde", "getAllCache error " + th);
                return;
            }
        }
        try {
            com.mbridge.msdk.foundation.controller.b.d().g().getSharedPreferences("MBridgeH5CacheSP", 0).edit().clear().apply();
            if (obj != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 0);
                jSONObject2.put("message", ADXLogUtil.EVENT_LOAD_SUCCESS);
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            }
        } catch (Throwable th2) {
            aa.d("JS-Video-Brigde", "getAllCache error " + th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getCutout(Object obj, String str) {
        try {
            String strI = this.d.getJSCommon().i();
            aa.d("JS-Video-Brigde", strI);
            if (obj != null && !TextUtils.isEmpty(strI)) {
                g.a().a(obj, Base64.encodeToString(strI.getBytes(), 2));
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("message", "No notch data, plz try again later.");
                g.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getCutout error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void cai(Object obj, String str) {
        aa.a("JS-Video-Brigde", "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("packageName");
            if (TextUtils.isEmpty(strOptString)) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "packageName is empty");
            }
            int i = af.c(com.mbridge.msdk.foundation.controller.b.d().g(), strOptString) ? 1 : 2;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", com.mbridge.msdk.mbsignalcommon.communication.b.f2325b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", i);
                jSONObject.put("data", jSONObject2);
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception e) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, e.getMessage());
                aa.a("JS-Video-Brigde", e.getMessage());
            }
        } catch (JSONException e2) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + e2.getLocalizedMessage());
            aa.b("JS-Video-Brigde", "cai", e2);
        } catch (Throwable th) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + th.getLocalizedMessage());
            aa.b("JS-Video-Brigde", "cai", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getAppSetting(Object obj, String str) {
        JSONObject jSONObject;
        try {
            String strOptString = new JSONObject(str).optString(PangleConstants.APP_ID, "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(strOptString)) {
                String strC = d.a().c(strOptString);
                if (TextUtils.isEmpty(strC)) {
                    jSONObject = new JSONObject(d.a().b().aM());
                } else {
                    jSONObject = new JSONObject(strC);
                    jSONObject.put("isDefault", 0);
                }
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", ADXLogUtil.EVENT_LOAD_SUCCESS);
                    jSONObject2.put("data", jSONObject);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get App Setting error, plz try again later.");
                }
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get App Setting error, because must give a appId.");
            }
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getAppSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getRewardSetting(Object obj, String str) {
        try {
            JSONObject jSONObjectL = com.mbridge.msdk.videocommon.d.b.a().b().l();
            JSONObject jSONObject = new JSONObject();
            if (obj != null && jSONObjectL != null) {
                jSONObject.put("code", 0);
                jSONObject.put("message", ADXLogUtil.EVENT_LOAD_SUCCESS);
                jSONObject.put("data", jSONObjectL);
            } else {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Get Reward Setting error, plz try again later.");
            }
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getRewardSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getRewardUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(PangleConstants.APP_ID, "");
            String strOptString2 = jSONObject.optString("unitid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                JSONObject jSONObjectF = com.mbridge.msdk.videocommon.d.b.a().a(strOptString, strOptString2).F();
                if (obj != null && jSONObjectF != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", ADXLogUtil.EVENT_LOAD_SUCCESS);
                    jSONObject2.put("data", jSONObjectF);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get Reward Unit Setting error, plz try again later.");
                }
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get reward unit Setting error, because must give appId and unitId.");
            }
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getRewardUnitSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "Get Unit Setting error, RV/IV can not support this method.");
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getUnitSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getEncryptPrice(Object obj, String str) {
        String str2;
        try {
            String str3 = "not replaced";
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            int i = 1;
            if (TextUtils.isEmpty(str)) {
                str2 = "params is null";
            } else {
                JSONObject jSONObject3 = new JSONObject(str);
                String strOptString = jSONObject3.optString("unitid", "");
                String strOptString2 = jSONObject3.optString("requestId", "");
                if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                    str2 = "params parsing exception";
                } else {
                    com.mbridge.msdk.foundation.entity.c cVarC = com.mbridge.msdk.foundation.same.a.d.c(strOptString, strOptString2);
                    if (cVarC != null && cVarC.d() == 1) {
                        str3 = "success";
                        jSONObject2.put("encrypt_p", cVarC.b());
                        jSONObject2.put(CampaignUnit.KEY_IRLFA, 1);
                        i = 0;
                    }
                    str2 = str3;
                }
            }
            jSONObject.put("code", i);
            jSONObject.put("message", str2);
            jSONObject.put("data", jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getEncryptPrice error : " + th.getMessage());
        }
    }
}
