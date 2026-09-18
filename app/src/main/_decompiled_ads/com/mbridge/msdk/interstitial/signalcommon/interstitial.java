package com.mbridge.msdk.interstitial.signalcommon;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.interstitial.b.a;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class interstitial extends AbsFeedBackForH5 {
    private static final String d = "com.mbridge.msdk.interstitial.signalcommon.interstitial";
    private Object e;

    public void getInfo(Object obj, String str) {
        MBInterstitialActivity mBInterstitialActivity;
        try {
            this.e = obj;
            if (this.a == null) {
                a();
                return;
            }
            int iA = a(this.a);
            if (TextUtils.isEmpty(b())) {
                a();
                return;
            }
            try {
                if (iA == 1) {
                    try {
                        if (this.a != null && a(this.a) == 1) {
                            try {
                                MBInterstitialActivity mBInterstitialActivity2 = (MBInterstitialActivity) this.a;
                                if (mBInterstitialActivity2 != null) {
                                    mBInterstitialActivity2.hideLoading();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        if (this.a != null && a(this.a) == 1 && (mBInterstitialActivity = (MBInterstitialActivity) this.a) != null) {
                            mBInterstitialActivity.showWebView();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    if (this.a == null) {
                        a();
                        return;
                    }
                    if (a(this.a) != 1) {
                        a();
                        return;
                    }
                    if (this.a instanceof MBInterstitialActivity) {
                        ((MBInterstitialActivity) this.a).mIsMBPage = true;
                    }
                    final String strB = b();
                    if (TextUtils.isEmpty(strB)) {
                        a();
                        return;
                    }
                    final List<CampaignEx> listA = a(strB);
                    if (listA != null) {
                        String strA = a(listA);
                        if (TextUtils.isEmpty(strA)) {
                            a();
                            return;
                        }
                        g.a().a(obj, strA);
                        try {
                            if (!TextUtils.isEmpty(strB) && listA != null && listA.size() != 0) {
                                for (int i = 0; i < listA.size(); i++) {
                                    CampaignEx campaignEx = listA.get(i);
                                    if (campaignEx != null) {
                                        d.a(strB, campaignEx, ReportUtil.INVENTORY_TYPE_INTERSTITIAL);
                                    }
                                }
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        try {
                            if (!TextUtils.isEmpty(strB) && listA != null && listA.size() != 0) {
                                new Thread(new Runnable() { // from class: com.mbridge.msdk.interstitial.signalcommon.interstitial.2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        for (int i2 = 0; i2 < listA.size(); i2++) {
                                            CampaignEx campaignEx2 = (CampaignEx) listA.get(i2);
                                            if (campaignEx2 != null) {
                                                k.a(h.a(interstitial.this.a)).b(campaignEx2.getId());
                                            }
                                        }
                                    }
                                }).start();
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        try {
                            new Thread(new Runnable() { // from class: com.mbridge.msdk.interstitial.signalcommon.interstitial.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    a aVarA = a.a();
                                    if (aVarA != null) {
                                        aVarA.a(listA, strB);
                                    }
                                }
                            }).start();
                            return;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return;
                        }
                    }
                    a();
                }
            } catch (Exception e7) {
                e7.printStackTrace();
                a();
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            a();
        }
    }

    public void install(Object obj, String str) {
        try {
            if (this.a != null && (this.a instanceof MBInterstitialActivity)) {
                ((MBInterstitialActivity) this.a).clickTracking();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openURL(Object obj, String str) {
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
            aa.d(d, e.getMessage());
        } catch (Throwable th) {
            aa.d(d, th.getMessage());
        }
    }

    private void a() {
        try {
            g.a().a(this.e, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<CampaignEx> a(String str) {
        try {
            if (TextUtils.isEmpty(str) || a.a() == null) {
                return null;
            }
            return a.a().a(str, 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String a(List<CampaignEx> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() <= 0) {
                return "";
            }
            JSONArray camplistToJson = CampaignEx.parseCamplistToJson(list);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("campaignList", camplistToJson);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public List<String> getExcludeIdList(String str) {
        Exception e;
        ArrayList arrayList;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strOptString = new JSONObject(str).optString(com.mbridge.msdk.foundation.same.net.g.d.c);
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(strOptString);
            if (jSONArray.length() <= 0) {
                return null;
            }
            arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    if (!TextUtils.isEmpty(jSONArray.optString(i))) {
                        arrayList.add(jSONArray.optString(i));
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
        e.printStackTrace();
        return arrayList;
    }

    private int a(Context context) {
        return (context == null || !(context instanceof MBInterstitialActivity)) ? -1 : 1;
    }

    private String b() {
        MBInterstitialActivity mBInterstitialActivity;
        String str = null;
        try {
            if (this.a == null) {
                return null;
            }
            if (a(this.a) == 1) {
                try {
                    if (this.a != null && (this.a instanceof MBInterstitialActivity) && (mBInterstitialActivity = (MBInterstitialActivity) this.a) != null) {
                        str = mBInterstitialActivity.mUnitid;
                        return str;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }
}
