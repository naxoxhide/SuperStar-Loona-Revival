package com.mbridge.msdk.scheme.applet;

import android.net.Uri;
import android.text.TextUtils;
import com.igaworks.adpopcorn.nativead.custom.ApCustomRewardCPMError;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.scheme.report.AppletsReport;
import com.mbridge.msdk.scheme.request.AppletSchemeRequest;
import com.mbridge.msdk.scheme.response.AppletSchemeResponse;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class AppletsModel implements Serializable {
    private static final String DYNAMIC_VIEW_WX_IS_REDIRECT_0 = "0";
    private static final String DYNAMIC_VIEW_WX_IS_REDIRECT_1 = "1";
    private static final String DYNAMIC_VIEW_WX_QUERY_PARAM_EVENT_CALLBACK = "event_callback";
    private static final String DYNAMIC_VIEW_WX_QUERY_PARAM_INSTALL_CALLBACK = "install_callback";
    public static final int REQUEST_TYPE_CLICK = 1;
    public static final int REQUEST_TYPE_SHOW = 0;
    private static String TAG = "AppletsModel";
    private static final String URL_ENCODE_UTF_8 = "UTF-8";
    private static final String WX_MINIPROGRAM = "wx_miniprogram";
    private static final int WX_SCHEME_REQUEST_ERROR_CODE_44993 = 44993;
    private volatile IAppletSchemeCallBack appletSchemeCallBack;
    private final CampaignEx campaignEx;
    private Map<String, String> params;
    private String reBuildClickUrl;
    private final String requestId;
    private final String unitID;
    private boolean isRequestTimesMaxPerDay = false;
    private volatile boolean isRequesting = false;
    private volatile boolean isRequestSuccess = false;
    private int lastRequestType = -1;
    private boolean isSupportWxScheme = false;
    private boolean isUserClick = false;
    private String deepLink = "";

    public AppletsModel(CampaignEx campaignEx, String str, String str2) {
        this.campaignEx = campaignEx;
        this.unitID = str;
        this.requestId = str2;
    }

    public void requestWxAppletsScheme(int i, IAppletSchemeCallBack iAppletSchemeCallBack) {
        if (this.campaignEx == null || TextUtils.isEmpty(this.unitID)) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            aa.d(TAG, "start request wx scheme");
        }
        this.isRequesting = true;
        if (iAppletSchemeCallBack != null) {
            this.appletSchemeCallBack = iAppletSchemeCallBack;
        }
        handlerSchemeRequestStart();
        AppletSchemeRequest appletSchemeRequest = new AppletSchemeRequest(b.d().g());
        if (this.params == null) {
            this.params = getAppletsParamsAndBuildRequest(this.campaignEx);
        }
        if (this.params == null) {
            return;
        }
        if (isRequestTimesMaxPerDay()) {
            handlerSchemeRequestFailed(WX_SCHEME_REQUEST_ERROR_CODE_44993, "get wxscheme failed : request times is max");
            return;
        }
        this.lastRequestType = i;
        appletSchemeRequest.get(1, d.a().g, this.params, new com.mbridge.msdk.foundation.same.net.b(5000, 5000, 5000, ApCustomRewardCPMError.PARTICIPATION_FAILED, 0), new DefaultAppletSchemeResponse(this));
    }

    public void setAppletSchemeCallBack(IAppletSchemeCallBack iAppletSchemeCallBack) {
        this.appletSchemeCallBack = iAppletSchemeCallBack;
    }

    public boolean isRequesting() {
        return this.isRequesting;
    }

    public void setRequestingFinish() {
        this.isRequesting = false;
    }

    public boolean isRequestSuccess() {
        return this.isRequestSuccess;
    }

    public String getReBuildClickUrl() {
        return this.reBuildClickUrl;
    }

    private void handlerSchemeRequestStart() {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        try {
            this.appletSchemeCallBack.onAppletSchemeRequestStart();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.b(TAG, "handler wx scheme start exception ", e);
            }
        }
        AppletsReport.reportAppletsLoadState(b.d().g(), "start load wx scheme", this.unitID, this.requestId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerSchemeRequestNetworkError(a aVar) {
        String message;
        if (this.appletSchemeCallBack == null) {
            return;
        }
        int i = -1;
        if (aVar != null) {
            i = aVar.a;
            message = aVar.getMessage();
            if (i == 10) {
                message = "request timeout";
            }
        } else {
            message = "unKnown";
        }
        if (MBridgeConstans.DEBUG) {
            aa.a(TAG, String.format("handlerSchemeRequestNetworkError network error by code %s and %s", String.valueOf(i), message));
        }
        try {
            this.appletSchemeCallBack.onNetworkError(i, "network error: " + message, this.reBuildClickUrl);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.b(TAG, "handler wx scheme network error exception ", e);
            }
        }
        AppletsReport.reportAppletsLoadState(b.d().g(), String.format("network error by code %s and %s", String.valueOf(i), message), this.unitID, this.requestId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerSchemeRequestResult(k<JSONObject> kVar) throws SchemeRequestException {
        JSONObject jSONObject = kVar.a;
        if (MBridgeConstans.DEBUG) {
            aa.a("AppletsModel", "result: " + jSONObject.toString());
        }
        if (jSONObject.has("wx_scheme")) {
            String strOptString = jSONObject.optString("wx_scheme", "");
            if (TextUtils.isEmpty(strOptString)) {
                throw new SchemeRequestException("wx_scheme value is null");
            }
            this.isRequestSuccess = true;
            handlerSchemeRequestSuccess(strOptString);
            return;
        }
        int iOptInt = jSONObject.optInt("error_code", -1);
        String strOptString2 = jSONObject.optString("error_msg", "");
        if (iOptInt == WX_SCHEME_REQUEST_ERROR_CODE_44993) {
            this.isRequestTimesMaxPerDay = true;
        }
        handlerSchemeRequestFailed(iOptInt, strOptString2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerSchemeRequestFailed(int i, String str) {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            aa.a(TAG, String.format("handlerSchemeRequestFailed network error by code %s and %s", String.valueOf(i), str));
        }
        try {
            this.appletSchemeCallBack.onAppletSchemeRequestFailed(i, str, this.reBuildClickUrl);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.b(TAG, "handler wx scheme failed exception  ", e);
            }
        }
        AppletsReport.reportAppletsLoadState(b.d().g(), String.format("network error by code %s and %s", String.valueOf(i), str), this.unitID, this.requestId);
    }

    private void handlerSchemeRequestSuccess(String str) {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            aa.a(TAG, "handlerSchemeRequestSuccess: " + str);
        }
        try {
            this.deepLink = str;
            this.appletSchemeCallBack.onAppletSchemeRequestSuccess(str);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.b(TAG, "handler wx scheme success exception ", e);
            }
        }
        AppletsReport.reportAppletsLoadState(b.d().g(), "request wx scheme success", this.unitID, this.requestId);
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerRequestNetworkError() {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            aa.a(TAG, "handlerRequestNetworkError response or result is null");
        }
        try {
            this.appletSchemeCallBack.onNetworkError(1, "response or result is null", this.reBuildClickUrl);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.b(TAG, "handler request network error exception ", e);
            }
        }
        AppletsReport.reportAppletsLoadState(b.d().g(), "response or result is null", this.unitID, this.requestId);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b9 A[Catch: Exception -> 0x00cd, TRY_LEAVE, TryCatch #2 {Exception -> 0x00cd, blocks: (B:14:0x0045, B:16:0x0054, B:21:0x0063, B:23:0x006b, B:32:0x00a4, B:34:0x00b9, B:29:0x007e, B:31:0x0082, B:51:0x00ed, B:62:0x0107, B:73:0x0121, B:74:0x0124, B:82:0x013c, B:84:0x014e, B:85:0x0166, B:79:0x0133, B:81:0x0137, B:69:0x0116, B:71:0x011a, B:58:0x00fc, B:60:0x0100, B:47:0x00e2, B:49:0x00e6, B:41:0x00d6, B:25:0x0073, B:52:0x00f0, B:63:0x010a), top: B:100:0x0045, inners: #0, #1, #3, #4, #6 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01cc  */
    private Map<String, String> getAppletsParamsAndBuildRequest(CampaignEx campaignEx) {
        String queryParameter;
        String str;
        String str2;
        String str3;
        String str4 = MBridgeConstans.DYNAMIC_VIEW_WX_IS_REDIRECT;
        String str5 = "query";
        HashMap map = new HashMap();
        if (campaignEx == null) {
            return map;
        }
        try {
            Uri uri = Uri.parse(campaignEx.getClickURL());
            if (uri != null && uri.getQueryParameterNames() != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = uri.getQueryParameterNames().iterator();
                int i = 0;
                try {
                    try {
                        try {
                            try {
                                while (true) {
                                    queryParameter = "";
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    try {
                                        Iterator<String> it2 = it;
                                        String next = it.next();
                                        if (TextUtils.isEmpty(next) || TextUtils.equals(next, "wx_miniprogram")) {
                                            str4 = str4;
                                            str5 = str5;
                                        } else {
                                            try {
                                                queryParameter = uri.getQueryParameter(next);
                                            } catch (Exception unused) {
                                            }
                                            String strEncode = queryParameter;
                                            if (TextUtils.equals(next, DYNAMIC_VIEW_WX_QUERY_PARAM_EVENT_CALLBACK) || TextUtils.equals(next, DYNAMIC_VIEW_WX_QUERY_PARAM_INSTALL_CALLBACK)) {
                                                try {
                                                    strEncode = URLEncoder.encode(strEncode, "UTF-8");
                                                } catch (Exception e) {
                                                    if (MBridgeConstans.DEBUG) {
                                                        aa.b(TAG, "encode url for " + strEncode + " failed", e);
                                                    }
                                                    sb.append(next).append("=").append(strEncode);
                                                    if (i < uri.getQueryParameterNames().size()) {
                                                        sb.append("&");
                                                    }
                                                    i++;
                                                    it = it2;
                                                    str4 = str4;
                                                    str5 = str5;
                                                }
                                            }
                                            sb.append(next).append("=").append(strEncode);
                                            if (i < uri.getQueryParameterNames().size()) {
                                                sb.append("&");
                                            }
                                            i++;
                                        }
                                        it = it2;
                                        str4 = str4;
                                        str5 = str5;
                                    } catch (Exception e2) {
                                        e = e2;
                                        if (MBridgeConstans.DEBUG) {
                                            aa.b(TAG, "create wechat app request param failed ", e);
                                        }
                                    }
                                    e = e2;
                                    if (MBridgeConstans.DEBUG) {
                                        aa.b(TAG, "create wechat app request param failed ", e);
                                    }
                                    return map;
                                }
                                String queryParameter2 = uri.getQueryParameter("app");
                                if (queryParameter2 == null) {
                                    queryParameter2 = "";
                                }
                                str = queryParameter2;
                            } catch (Exception e3) {
                                if (MBridgeConstans.DEBUG) {
                                    aa.b(TAG, "create wechat app request param failed ", e3);
                                }
                                str = "";
                            }
                            String strEncode2 = URLEncoder.encode(sb.toString(), "UTF-8");
                            if (strEncode2 != null) {
                                queryParameter = strEncode2;
                            }
                        } catch (UnsupportedEncodingException e4) {
                            if (MBridgeConstans.DEBUG) {
                                aa.b(TAG, "create wechat app request param failed ", e4);
                            }
                        }
                        String queryParameter3 = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                        if (queryParameter3 == null) {
                            queryParameter3 = "";
                        }
                        str2 = queryParameter3;
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            aa.b(TAG, "create wechat app request param failed ", e5);
                        }
                        str2 = "";
                    }
                    String queryParameter4 = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID);
                    if (queryParameter4 == null) {
                        queryParameter4 = "";
                    }
                    str3 = queryParameter4;
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        aa.b(TAG, "create wechat app request param failed ", e6);
                    }
                    str3 = "";
                }
                String str6 = str4;
                String str7 = str5;
                map.put("app", str);
                map.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str2);
                map.put(MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID, str3);
                String str8 = queryParameter;
                map.put(str7, str8);
                map.put(str6, "0");
                if (MBridgeConstans.DEBUG) {
                    aa.a(TAG, "query: " + str8);
                }
                this.reBuildClickUrl = reCreateClickUrl("app=" + str + "&" + MBridgeConstans.DYNAMIC_VIEW_WX_PATH + "=" + str2 + "&" + str7 + "=" + str8 + "&" + MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID + "=" + str3 + "&" + str6 + "=1");
                return map;
            }
            return map;
        } catch (Exception e7) {
            e = e7;
        }
    }

    private String reCreateClickUrl(String str) {
        return d.a().g + "?" + str;
    }

    public boolean canRequestWxScheme(int i) {
        if (!isSupportWxScheme()) {
            return false;
        }
        if (i != 0) {
            return i == 1;
        }
        return isCanRequestByTemplateUrl("2");
    }

    private boolean isCanRequestByLinkType() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null) {
            return false;
        }
        int linkType = campaignEx.getLinkType();
        return linkType == 8 || linkType == 9;
    }

    private boolean isCanRequestByClickUrl(String str) {
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx == null) {
                return false;
            }
            String clickURL = campaignEx.getClickURL();
            if (TextUtils.isEmpty(clickURL)) {
                return false;
            }
            return TextUtils.equals(al.a(clickURL, "wx_miniprogram"), str);
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            aa.b(TAG, "query wx_miniprogram from click url exception ", e);
            return false;
        }
    }

    private boolean isCanRequestByTemplateUrl(String str) {
        CampaignEx.c rewardTemplateMode;
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx != null && (rewardTemplateMode = campaignEx.getRewardTemplateMode()) != null && !TextUtils.isEmpty(rewardTemplateMode.e())) {
                return TextUtils.equals(al.a(rewardTemplateMode.e(), MBridgeConstans.DYNAMIC_VIEW_REQ_WX_URL), str);
            }
            return false;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            aa.b(TAG, "query reqwxurl from template url exception ", e);
            return false;
        }
    }

    public boolean isRequestTimesMaxPerDay() {
        return this.isRequestTimesMaxPerDay;
    }

    public boolean can(int i) {
        if (isRequesting() || !canRequestWxScheme(i)) {
            return false;
        }
        if (this.lastRequestType == -1) {
            return true;
        }
        if (isRequestSuccess()) {
            return false;
        }
        int i2 = this.lastRequestType;
        return (i2 == 0 && i == 1) || (i2 == 1 && i == 1 && this.isUserClick);
    }

    public void setUserClick(boolean z) {
        this.isUserClick = z;
    }

    public boolean isSupportWxScheme() {
        if (!this.isSupportWxScheme) {
            this.isSupportWxScheme = isCanRequestByClickUrl("1") && isCanRequestByLinkType();
        }
        return this.isSupportWxScheme;
    }

    public void clearRequestState() {
        this.isRequestSuccess = false;
        this.isRequesting = false;
        this.appletSchemeCallBack = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeRequestingState(boolean z) {
        this.isRequesting = z;
    }

    private static final class DefaultAppletSchemeResponse extends AppletSchemeResponse {
        private AppletsModel appletsModel;

        public DefaultAppletSchemeResponse(AppletsModel appletsModel) {
            this.appletsModel = appletsModel;
        }

        @Override // com.mbridge.msdk.scheme.response.AppletSchemeResponse, com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
        public final void onSuccess(k<JSONObject> kVar) {
            super.onSuccess(kVar);
            AppletsModel appletsModel = this.appletsModel;
            if (appletsModel == null) {
                return;
            }
            appletsModel.changeRequestingState(false);
            if (kVar == null || kVar.a == null) {
                this.appletsModel.handlerRequestNetworkError();
                return;
            }
            try {
                this.appletsModel.handlerSchemeRequestResult(kVar);
            } catch (SchemeRequestException e) {
                this.appletsModel.handlerSchemeRequestFailed(-2, e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.scheme.response.AppletSchemeResponse, com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
        public final void onError(a aVar) {
            super.onError(aVar);
            AppletsModel appletsModel = this.appletsModel;
            if (appletsModel == null) {
                return;
            }
            appletsModel.changeRequestingState(false);
            this.appletsModel.handlerSchemeRequestNetworkError(aVar);
        }
    }

    private static final class SchemeRequestException extends Exception {
        public SchemeRequestException(String str) {
            super(str);
        }
    }
}
