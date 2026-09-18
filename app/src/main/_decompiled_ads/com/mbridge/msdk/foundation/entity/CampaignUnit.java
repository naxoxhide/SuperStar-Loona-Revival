package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class CampaignUnit implements NoProGuard, Serializable {
    public static final String JSON_KEY_ADS = "ads";
    public static final String JSON_KEY_AD_HTML = "cam_html";
    public static final String JSON_KEY_AD_TYPE = "ad_type";
    public static final String JSON_KEY_AD_ZIP = "cam_tpl_url";
    public static final String JSON_KEY_BANNER_HTML = "cam_html";
    public static final String JSON_KEY_BANNER_URL = "cam_tpl_url";
    public static final String JSON_KEY_CSP = "csp";
    public static final String JSON_KEY_DO = "do";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_END_SCREEN_URL = "end_screen_url";
    public static final String JSON_KEY_FRAME_ADS = "frames";
    public static final String JSON_KEY_HTML_URL = "html_url";
    public static final String JSON_KEY_IA_EXT1 = "ia_all_ext1";
    public static final String JSON_KEY_IA_EXT2 = "ia_all_ext2";
    public static final String JSON_KEY_IA_ICON = "ia_icon";
    public static final String JSON_KEY_IA_ORI = "ia_ori";
    public static final String JSON_KEY_IA_RST = "ia_rst";
    public static final String JSON_KEY_IA_URL = "ia_url";
    public static final String JSON_KEY_JM_DO = "jm_do";
    public static final String JSON_KEY_MOF_TEMPLATE_URL = "mof_template_url";
    public static final String JSON_KEY_MOF_TPLID = "mof_tplid";
    public static final String JSON_KEY_NSCPT = "nscpt";
    public static final String JSON_KEY_ONLY_IMPRESSION_URL = "only_impression_url";
    public static final String JSON_KEY_PARENT_SESSION_ID = "parent_session_id";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_REPLACE_TMP = "replace_tmp";
    public static final String JSON_KEY_REQ_EXT_DATA = "req_ext_data";
    public static final String JSON_KEY_RKS = "rks";
    public static final String JSON_KEY_SESSION_ID = "a";
    public static final String JSON_KEY_SH = "sh";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_UNIT_SIZE = "unit_size";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String KEY_IRLFA = "irlfa";
    private static final String TAG = "CampaignUnit";
    private static final long serialVersionUID = 1;
    private String adHtml;
    private int adType;
    private String adZip;
    public ArrayList<CampaignEx> ads;
    private String bannerHtml;
    private String bannerUrl;
    private String csp;
    private String domain;
    private double ecppv;
    private HashMap<String, String> epMap;
    private String htmlUrl;
    private String ia_all_ext1;
    private String ia_all_ext2;
    private String ia_icon;
    private int ia_ori;
    private int ia_rst;
    private String ia_url;
    private int jmDo;
    private List<Frame> listFrames;
    private String localRequestId;
    private String onlyImpressionUrl;
    private String parentSessionId;
    private String requestId;
    private HashMap<String, String> rks;
    private String sessionId;
    private String sh;
    private int template;
    private int tokenRule;
    private String unitSize;
    private int vcn;
    private String msg = "";
    private StringBuffer cParams = new StringBuffer();
    private String encryptPrice = "";

    private Object nullToEmpty(Object obj) {
        return obj == null ? "" : obj;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public void setAdZip(String str) {
        this.adZip = str;
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public String getIa_icon() {
        return this.ia_icon;
    }

    public void setIa_icon(String str) {
        this.ia_icon = str;
    }

    public int getIa_rst() {
        return this.ia_rst;
    }

    public void setIa_rst(int i) {
        this.ia_rst = i;
    }

    public String getIa_url() {
        return this.ia_url;
    }

    public void setIa_url(String str) {
        this.ia_url = str;
    }

    public int getIa_ori() {
        return this.ia_ori;
    }

    public void setIa_ori(int i) {
        this.ia_ori = i;
    }

    public String getIa_all_ext1() {
        return this.ia_all_ext1;
    }

    public void setIa_all_ext1(String str) {
        this.ia_all_ext1 = str;
    }

    public String getIa_all_ext2() {
        return this.ia_all_ext2;
    }

    public void setIa_all_ext2(String str) {
        this.ia_all_ext2 = str;
    }

    public HashMap<String, String> getRks() {
        return this.rks;
    }

    public void setRks(HashMap<String, String> map) {
        this.rks = map;
    }

    public HashMap<String, String> getEpMap() {
        return this.epMap;
    }

    public void setEpMap(HashMap<String, String> map) {
        this.epMap = map;
    }

    public String getCsp() {
        return this.csp;
    }

    public void setCsp(String str) {
        this.csp = str;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public int getTokenRule() {
        int i = this.tokenRule;
        if (i == 1) {
            return i;
        }
        return 0;
    }

    public void setTokenRule(int i) {
        this.tokenRule = i;
    }

    public int getVcn() {
        int i = this.vcn;
        if (i > 1) {
            return i;
        }
        return 1;
    }

    public void setVcn(int i) {
        this.vcn = i;
    }

    public String getSh() {
        return this.sh;
    }

    public void setSh(String str) {
        this.sh = str;
    }

    public int getJmDo() {
        return this.jmDo;
    }

    public void setJmDo(int i) {
        this.jmDo = i;
    }

    public List<Frame> getListFrames() {
        return this.listFrames;
    }

    public void setListFrames(List<Frame> list) {
        this.listFrames = list;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getParentSessionId() {
        return this.parentSessionId;
    }

    public void setParentSessionId(String str) {
        this.parentSessionId = str;
    }

    public int getAdType() {
        return this.adType;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public String getUnitSize() {
        return this.unitSize;
    }

    public void setUnitSize(String str) {
        this.unitSize = str;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public String getOnlyImpressionUrl() {
        return this.onlyImpressionUrl;
    }

    public void setOnlyImpressionUrl(String str) {
        this.onlyImpressionUrl = str;
    }

    public double getEcppv() {
        return this.ecppv;
    }

    public void setEcppv(double d) {
        this.ecppv = d;
    }

    public ArrayList<CampaignEx> getAds() {
        return this.ads;
    }

    public void setAds(ArrayList<CampaignEx> arrayList) {
        this.ads = arrayList;
    }

    public int getTemplate() {
        return this.template;
    }

    public void setTemplate(int i) {
        this.template = i;
    }

    public String assembCParams() {
        String str;
        String strValueOf;
        StringBuffer stringBuffer = this.cParams;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            return this.cParams.toString();
        }
        try {
            String strA = w.a();
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            String strE = w.e(contextG);
            String strD = w.d(contextG);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                strValueOf = String.valueOf(w.r(contextG));
                str = w.l(contextG) + "x" + w.m(contextG);
            } else {
                str = "";
                strValueOf = str;
            }
            this.cParams = this.cParams.append(getAdType()).append("|").append(nullToEmpty("1")).append("|").append(nullToEmpty(Build.VERSION.RELEASE)).append("|").append(nullToEmpty(MBConfiguration.SDK_VERSION)).append("|").append(nullToEmpty(w.i())).append("|").append(nullToEmpty(str)).append("|").append(nullToEmpty(Integer.valueOf(w.h(com.mbridge.msdk.foundation.controller.b.d().g())))).append("|").append(nullToEmpty(w.g(com.mbridge.msdk.foundation.controller.b.d().g()))).append("|").append(nullToEmpty(strValueOf)).append("|").append(nullToEmpty(strD)).append(nullToEmpty(strE)).append("|").append("|").append("|").append("|").append(nullToEmpty(strA)).append("|").append(nullToEmpty("")).append("|").append(nullToEmpty(w.k())).append("|").append(nullToEmpty("")).append("|").append("").append("|").append(nullToEmpty("")).append("|").append(nullToEmpty(com.mbridge.msdk.foundation.same.a.l + "," + com.mbridge.msdk.foundation.same.a.m)).append("|").append(w.u()).append("|");
        } catch (Throwable th) {
            aa.b(TAG, th.getMessage(), th);
        }
        return this.cParams.toString();
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject) {
        return parseV5CampaignUnit(jSONObject, "");
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject, String str) {
        return parseCampaignUnit(jSONObject, str);
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject) {
        return parseCampaignUnit(jSONObject, "");
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionUrl)) {
                return "";
            }
            Uri uri = Uri.parse(this.onlyImpressionUrl);
            if (uri != null) {
                this.requestId = uri.getQueryParameter(CampaignEx.JSON_KEY_AD_K);
            }
            return this.requestId;
        } catch (Exception unused) {
            return "";
        }
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
        Iterator<CampaignEx> it = getAds().iterator();
        while (it.hasNext()) {
            it.next().setLocalRequestId(str);
        }
    }

    private static void getSysIDAndBKUPID(JSONObject jSONObject) {
        FastKV fastKVBuild;
        com.mbridge.msdk.foundation.controller.c.a();
        try {
            fastKVBuild = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), u.b("H+tU+FeXHM==")).build();
        } catch (Exception unused) {
            fastKVBuild = null;
        }
        if (fastKVBuild != null) {
            try {
                Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                if (jSONObject == null || contextG == null) {
                    return;
                }
                String strOptString = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.l, strOptString)) {
                    com.mbridge.msdk.foundation.same.a.l = strOptString;
                    com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.l);
                    try {
                        fastKVBuild.putString(u.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.l);
                    } catch (Exception unused2) {
                    }
                }
                String strOptString2 = jSONObject.optString("c");
                if (TextUtils.isEmpty(strOptString2) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.m, strOptString2)) {
                    return;
                }
                com.mbridge.msdk.foundation.same.a.m = strOptString2;
                com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.m);
                try {
                    fastKVBuild.putString(u.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.m);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            Context contextG2 = com.mbridge.msdk.foundation.controller.b.d().g();
            if (jSONObject == null || contextG2 == null) {
                return;
            }
            String strOptString3 = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            if (!TextUtils.isEmpty(strOptString3) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.l, strOptString3)) {
                com.mbridge.msdk.foundation.same.a.l = strOptString3;
                com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.l);
                SharedPreferences sharedPreferences = contextG2.getSharedPreferences(u.b("H+tU+FeXHM=="), 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString(u.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.l);
                    editorEdit.apply();
                }
            }
            String strOptString4 = jSONObject.optString("c");
            if (TextUtils.isEmpty(strOptString4) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.m, strOptString4)) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.m = strOptString4;
            com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.m);
            SharedPreferences sharedPreferences2 = contextG2.getSharedPreferences(u.b("H+tU+FeXHM=="), 0);
            if (sharedPreferences2 != null) {
                SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
                editorEdit2.putString(u.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.m);
                editorEdit2.apply();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:59:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:63:0x02fc A[Catch: Exception -> 0x0392, TryCatch #7 {Exception -> 0x0392, blocks: (B:61:0x02f6, B:63:0x02fc, B:64:0x0302, B:66:0x0308), top: B:98:0x02f6 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0308 A[Catch: Exception -> 0x0392, TRY_LEAVE, TryCatch #7 {Exception -> 0x0392, blocks: (B:61:0x02f6, B:63:0x02fc, B:64:0x0302, B:66:0x0308), top: B:98:0x02f6 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0347 A[Catch: Exception -> 0x0395, TryCatch #5 {Exception -> 0x0395, blocks: (B:68:0x0341, B:70:0x0347, B:72:0x037a, B:71:0x0373, B:73:0x038d), top: B:94:0x0341 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0373 A[Catch: Exception -> 0x0395, TryCatch #5 {Exception -> 0x0395, blocks: (B:68:0x0341, B:70:0x0347, B:72:0x037a, B:71:0x0373, B:73:0x038d), top: B:94:0x0341 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0392 A[PHI: r12
      0x0392: PHI (r12v20 com.mbridge.msdk.foundation.entity.CampaignUnit) = 
      (r12v9 com.mbridge.msdk.foundation.entity.CampaignUnit)
      (r12v21 com.mbridge.msdk.foundation.entity.CampaignUnit)
      (r12v22 com.mbridge.msdk.foundation.entity.CampaignUnit)
      (r12v21 com.mbridge.msdk.foundation.entity.CampaignUnit)
     binds: [B:55:0x02d9, B:60:0x02f4, B:81:0x0392, B:62:0x02fa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x02f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject, String str) {
        CampaignUnit campaignUnit;
        ArrayList arrayList;
        CampaignUnit campaignUnit2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        ArrayList<CampaignEx> arrayList2;
        int i;
        String str11;
        String str12;
        String str13;
        CampaignEx campaign;
        String str14;
        String str15;
        JSONObject jSONObject2 = jSONObject;
        String str16 = JSON_KEY_ADS;
        String str17 = "template";
        String str18 = CampaignEx.JSON_KEY_ECPPV;
        String str19 = JSON_KEY_ONLY_IMPRESSION_URL;
        String str20 = JSON_KEY_HTML_URL;
        if (jSONObject2 != null) {
            try {
                CampaignUnit campaignUnit3 = new CampaignUnit();
                try {
                    String strOptString = jSONObject2.optString(JSON_KEY_RKS);
                    if (!TextUtils.isEmpty(strOptString)) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(strOptString);
                            Iterator<String> itKeys = jSONObject3.keys();
                            HashMap<String, String> map = new HashMap<>();
                            while (itKeys != null && itKeys.hasNext()) {
                                String next = itKeys.next();
                                map.put(next, jSONObject3.optString(next));
                            }
                            campaignUnit3.setRks(map);
                        } catch (Exception unused) {
                            return campaignUnit3;
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        HashMap<String, String> map2 = new HashMap<>();
                        map2.put("encrypt_p", "");
                        map2.put(KEY_IRLFA, "");
                        campaignUnit3.setEpMap(map2);
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(JSON_KEY_REQ_EXT_DATA);
                    int iOptInt = jSONObject2.optInt(JSON_KEY_NSCPT, 1);
                    String strOptString2 = jSONObject2.optString(JSON_KEY_MOF_TEMPLATE_URL, "");
                    int iOptInt2 = jSONObject2.optInt(JSON_KEY_MOF_TPLID, 0);
                    String string = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : "";
                    new JSONArray();
                    JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("pv_urls");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList.add(jSONArrayOptJSONArray.getString(i2));
                        }
                    }
                    com.mbridge.msdk.foundation.db.a.a.a().a(jSONObject2.optJSONObject(JSON_KEY_REPLACE_TMP), true);
                    getSysIDAndBKUPID(jSONObject);
                    campaignUnit3.setSessionId(jSONObject2.optString("a"));
                    campaignUnit3.setParentSessionId(jSONObject2.optString(JSON_KEY_PARENT_SESSION_ID));
                    campaignUnit3.setAdType(jSONObject2.optInt("ad_type"));
                    campaignUnit3.setUnitSize(jSONObject2.optString(JSON_KEY_UNIT_SIZE));
                    campaignUnit3.setHtmlUrl(jSONObject2.optString(JSON_KEY_HTML_URL));
                    campaignUnit3.setOnlyImpressionUrl(jSONObject2.optString(JSON_KEY_ONLY_IMPRESSION_URL));
                    campaignUnit3.setEcppv(jSONObject2.optDouble(CampaignEx.JSON_KEY_ECPPV));
                    campaignUnit3.setTemplate(jSONObject2.optInt("template"));
                    campaignUnit3.setJmDo(jSONObject2.optInt(JSON_KEY_JM_DO));
                    campaignUnit3.setIa_icon(jSONObject2.optString("ia_icon"));
                    campaignUnit3.setIa_rst(jSONObject2.optInt("ia_rst"));
                    campaignUnit3.setIa_url(jSONObject2.optString("ia_url"));
                    campaignUnit3.setIa_ori(jSONObject2.optInt("ia_ori"));
                    campaignUnit3.setIa_all_ext1(jSONObject2.optString(JSON_KEY_IA_EXT1));
                    campaignUnit3.setIa_all_ext2(jSONObject2.optString(JSON_KEY_IA_EXT2));
                    campaignUnit3.setVcn(jSONObject2.optInt("vcn"));
                    campaignUnit3.setTokenRule(jSONObject2.optInt("token_r"));
                    campaignUnit3.setEncryptPrice(jSONObject2.optString("encrypt_p"));
                    JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray(JSON_KEY_ADS);
                    JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray(JSON_KEY_FRAME_ADS);
                    String str21 = "web env is not support";
                    String str22 = JSON_KEY_END_SCREEN_URL;
                    if (jSONArrayOptJSONArray3 != null) {
                        try {
                            if (jSONArrayOptJSONArray3.length() > 0) {
                                ArrayList arrayList3 = new ArrayList();
                                String str23 = "web env is not support";
                                int i3 = iOptInt2;
                                int i4 = 0;
                                while (i4 < jSONArrayOptJSONArray3.length()) {
                                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray3.optJSONObject(i4);
                                    int i5 = i4;
                                    JSONArray jSONArray = jSONObjectOptJSONObject2.getJSONArray(str16);
                                    String str24 = str16;
                                    ArrayList arrayList4 = new ArrayList();
                                    String str25 = str17;
                                    JSONObject jSONObject4 = jSONObjectOptJSONObject2;
                                    int i6 = 0;
                                    while (i6 < jSONArray.length()) {
                                        JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i6);
                                        String strOptString3 = jSONObject2.optString(str19);
                                        String strOptString4 = jSONObject2.optString(str20);
                                        String strOptString5 = jSONObject2.optString(str22);
                                        String strOptString6 = jSONObject2.optString(str18);
                                        String str26 = str22;
                                        String str27 = str23;
                                        JSONObject jSONObject5 = jSONObject4;
                                        String str28 = string;
                                        JSONArray jSONArray2 = jSONArrayOptJSONArray3;
                                        String str29 = str18;
                                        int i7 = iOptInt;
                                        String str30 = str20;
                                        ArrayList arrayList5 = arrayList3;
                                        String str31 = str19;
                                        JSONArray jSONArray3 = jSONArray;
                                        int i8 = i3;
                                        CampaignUnit campaignUnit4 = campaignUnit3;
                                        try {
                                            CampaignEx campaign2 = CampaignEx.parseCampaign(jSONObjectOptJSONObject3, strOptString3, strOptString4, strOptString5, false, campaignUnit3, str, strOptString6);
                                            if (campaign2 != null) {
                                                try {
                                                    campaign2.setKeyIaUrl(campaignUnit4.getIa_url());
                                                    campaign2.setKeyIaOri(campaignUnit4.getIa_ori());
                                                    campaign2.setKeyIaRst(campaignUnit4.getIa_rst());
                                                    campaign2.setKeyIaIcon(campaignUnit4.getIa_icon());
                                                    campaign2.setAdType(jSONObject2.optInt("ad_type"));
                                                    campaign2.setIa_ext1(jSONObject2.optString(CampaignEx.KEY_IA_EXT1));
                                                    campaign2.setIa_ext2(jSONObject2.optString(CampaignEx.KEY_IA_EXT2));
                                                    campaign2.setVcn(campaignUnit4.getVcn());
                                                    campaign2.setTokenRule(campaignUnit4.getTokenRule());
                                                    campaign2.setEncryptPrice(campaignUnit4.getEncryptPrice());
                                                    campaign2.setMof_tplid(i8);
                                                    str2 = strOptString2;
                                                    campaign2.setMof_template_url(str2);
                                                    campaign2.setNscpt(i7);
                                                    campaign2.setPv_urls(arrayList);
                                                    str3 = str28;
                                                    campaign2.setReq_ext_data(str3);
                                                    arrayList4.add(campaign2);
                                                    campaignUnit2 = campaignUnit4;
                                                    str4 = str27;
                                                } catch (Exception unused2) {
                                                    return campaignUnit4;
                                                }
                                            } else {
                                                str2 = strOptString2;
                                                str3 = str28;
                                                campaignUnit2 = campaignUnit4;
                                                str4 = str27;
                                                campaignUnit2.setMsg(str4);
                                            }
                                            try {
                                                i6++;
                                                i3 = i8;
                                                arrayList3 = arrayList5;
                                                str23 = str4;
                                                strOptString2 = str2;
                                                str20 = str30;
                                                str19 = str31;
                                                str22 = str26;
                                                iOptInt = i7;
                                                campaignUnit3 = campaignUnit2;
                                                jSONArrayOptJSONArray3 = jSONArray2;
                                                str18 = str29;
                                                jSONObject4 = jSONObject5;
                                                string = str3;
                                                jSONArray = jSONArray3;
                                            } catch (Exception unused3) {
                                                return campaignUnit2;
                                            }
                                        } catch (Exception unused4) {
                                            campaignUnit2 = campaignUnit4;
                                            return campaignUnit2;
                                        }
                                    }
                                    String str32 = string;
                                    JSONObject jSONObject6 = jSONObject4;
                                    String str33 = str18;
                                    int i9 = iOptInt;
                                    String str34 = str20;
                                    ArrayList arrayList6 = arrayList3;
                                    Frame frame = new Frame();
                                    frame.setParentSessionId(jSONObject2.optString(JSON_KEY_PARENT_SESSION_ID));
                                    frame.setSessionId(jSONObject2.optString("a"));
                                    frame.setCampaigns(arrayList4);
                                    frame.setTemplate(jSONObject6.optInt(str25));
                                    arrayList6.add(frame);
                                    i3 = i3;
                                    arrayList3 = arrayList6;
                                    str17 = str25;
                                    str23 = str23;
                                    strOptString2 = strOptString2;
                                    str20 = str34;
                                    str19 = str19;
                                    str22 = str22;
                                    iOptInt = i9;
                                    campaignUnit3 = campaignUnit3;
                                    jSONArrayOptJSONArray3 = jSONArrayOptJSONArray3;
                                    str18 = str33;
                                    string = str32;
                                    i4 = i5 + 1;
                                    str16 = str24;
                                }
                                campaignUnit2 = campaignUnit3;
                                campaignUnit2.setListFrames(arrayList3);
                            } else {
                                str5 = CampaignEx.JSON_KEY_ECPPV;
                                str6 = JSON_KEY_ONLY_IMPRESSION_URL;
                                str7 = JSON_KEY_END_SCREEN_URL;
                                campaignUnit2 = campaignUnit3;
                                str8 = strOptString2;
                                str9 = string;
                                str10 = JSON_KEY_HTML_URL;
                                if (jSONArrayOptJSONArray2 == null) {
                                    try {
                                        if (jSONArrayOptJSONArray2.length() > 0) {
                                            arrayList2 = new ArrayList<>();
                                            i = 0;
                                            while (i < jSONArrayOptJSONArray2.length()) {
                                                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i);
                                                String str35 = str6;
                                                String strOptString7 = jSONObject2.optString(str35);
                                                String str36 = str10;
                                                String strOptString8 = jSONObject2.optString(str36);
                                                str11 = str9;
                                                String str37 = str7;
                                                String strOptString9 = jSONObject2.optString(str37);
                                                String str38 = str5;
                                                str12 = str21;
                                                campaignUnit = campaignUnit2;
                                                JSONArray jSONArray4 = jSONArrayOptJSONArray2;
                                                str13 = str8;
                                                try {
                                                    campaign = CampaignEx.parseCampaign(jSONObjectOptJSONObject4, strOptString7, strOptString8, strOptString9, false, campaignUnit, str, jSONObject2.optString(str38));
                                                    if (campaign != null) {
                                                        campaign.setMof_tplid(iOptInt2);
                                                        str14 = str13;
                                                        campaign.setMof_template_url(str14);
                                                        campaign.setNscpt(iOptInt);
                                                        campaign.setPv_urls(arrayList);
                                                        campaign.setReq_ext_data(str11);
                                                        campaign.setVcn(campaignUnit.getVcn());
                                                        campaign.setTokenRule(campaignUnit.getTokenRule());
                                                        campaign.setEncryptPrice(campaignUnit.getEncryptPrice());
                                                        arrayList2.add(campaign);
                                                        str15 = str12;
                                                    } else {
                                                        str14 = str13;
                                                        str15 = str12;
                                                        campaignUnit.setMsg(str15);
                                                    }
                                                    i++;
                                                    str9 = str11;
                                                    str6 = str35;
                                                    campaignUnit2 = campaignUnit;
                                                    str10 = str36;
                                                    jSONArrayOptJSONArray2 = jSONArray4;
                                                    str8 = str14;
                                                    str5 = str38;
                                                    str7 = str37;
                                                    jSONObject2 = jSONObject;
                                                    str21 = str15;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            campaignUnit = campaignUnit2;
                                            campaignUnit.setAds(arrayList2);
                                        }
                                    } catch (Exception unused6) {
                                    }
                                }
                            }
                            campaignUnit = campaignUnit2;
                        } catch (Exception unused7) {
                            campaignUnit2 = campaignUnit3;
                        }
                    } else {
                        str5 = CampaignEx.JSON_KEY_ECPPV;
                        str6 = JSON_KEY_ONLY_IMPRESSION_URL;
                        str7 = JSON_KEY_END_SCREEN_URL;
                        campaignUnit2 = campaignUnit3;
                        str8 = strOptString2;
                        str9 = string;
                        str10 = JSON_KEY_HTML_URL;
                        if (jSONArrayOptJSONArray2 == null) {
                            campaignUnit = campaignUnit2;
                        } else if (jSONArrayOptJSONArray2.length() > 0) {
                            arrayList2 = new ArrayList<>();
                            i = 0;
                            while (i < jSONArrayOptJSONArray2.length()) {
                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i);
                                String str39 = str6;
                                String strOptString10 = jSONObject2.optString(str39);
                                String str310 = str10;
                                String strOptString11 = jSONObject2.optString(str310);
                                str11 = str9;
                                String str311 = str7;
                                String strOptString12 = jSONObject2.optString(str311);
                                String str312 = str5;
                                str12 = str21;
                                campaignUnit = campaignUnit2;
                                JSONArray jSONArray5 = jSONArrayOptJSONArray2;
                                str13 = str8;
                                campaign = CampaignEx.parseCampaign(jSONObjectOptJSONObject5, strOptString10, strOptString11, strOptString12, false, campaignUnit, str, jSONObject2.optString(str312));
                                if (campaign != null) {
                                    campaign.setMof_tplid(iOptInt2);
                                    str14 = str13;
                                    campaign.setMof_template_url(str14);
                                    campaign.setNscpt(iOptInt);
                                    campaign.setPv_urls(arrayList);
                                    campaign.setReq_ext_data(str11);
                                    campaign.setVcn(campaignUnit.getVcn());
                                    campaign.setTokenRule(campaignUnit.getTokenRule());
                                    campaign.setEncryptPrice(campaignUnit.getEncryptPrice());
                                    arrayList2.add(campaign);
                                    str15 = str12;
                                } else {
                                    str14 = str13;
                                    str15 = str12;
                                    campaignUnit.setMsg(str15);
                                }
                                i++;
                                str9 = str11;
                                str6 = str39;
                                campaignUnit2 = campaignUnit;
                                str10 = str310;
                                jSONArrayOptJSONArray2 = jSONArray5;
                                str8 = str14;
                                str5 = str312;
                                str7 = str311;
                                jSONObject2 = jSONObject;
                                str21 = str15;
                            }
                            campaignUnit = campaignUnit2;
                            campaignUnit.setAds(arrayList2);
                        } else {
                            campaignUnit = campaignUnit2;
                        }
                    }
                } catch (Exception unused8) {
                    campaignUnit = campaignUnit3;
                }
                return campaignUnit;
            } catch (Exception unused9) {
            }
        }
        return null;
    }
}
