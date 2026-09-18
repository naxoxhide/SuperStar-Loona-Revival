package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tapjoy.internal.ca;
import com.tapjoy.internal.f5;
import com.tapjoy.internal.h5;
import com.tapjoy.internal.i8;
import com.tapjoy.internal.l2;
import com.tapjoy.internal.m0;
import com.tapjoy.internal.ma;
import com.tapjoy.internal.v1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TJCorePlacement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f2688b;
    public Map c;
    public final TJPlacementData d;
    public TJCurrencyParameters e;
    public final String f;
    public long g;
    public final TJAdUnit h;
    public boolean m;
    public String r;
    public String s;
    public String t;
    public String u;
    public HashMap v;
    public final HashMap a = new HashMap();
    public boolean i = false;
    public boolean j = false;
    public l2 k = null;
    public f5 l = null;
    public volatile boolean n = false;
    public volatile boolean o = false;
    public volatile boolean p = false;
    public volatile boolean q = false;

    public TJCorePlacement(String str, String str2) {
        r rVar = new r(this);
        s sVar = new s(this);
        Activity activityA = com.tapjoy.internal.t.a();
        this.f2688b = activityA;
        if (activityA == null) {
            TapjoyLog.d("TJCorePlacement", "getVisibleActivity() is NULL. Activity can be explicitly set via `Tapjoy.setActivity(Activity)`");
        }
        TJPlacementData tJPlacementData = new TJPlacementData(str2, getPlacementContentUrl());
        this.d = tJPlacementData;
        tJPlacementData.setPlacementName(str);
        this.e = new TJCurrencyParameters(this.f2688b);
        this.f = UUID.randomUUID().toString();
        TJAdUnit tJAdUnit = new TJAdUnit();
        this.h = tJAdUnit;
        tJAdUnit.setWebViewListener(rVar);
        tJAdUnit.setVideoListener(sVar);
    }

    public final void a() {
        if (i8.e) {
            this.h.getTjBeacon().a("contentReady", (HashMap) null);
        }
        if (this.o) {
            return;
        }
        this.q = true;
        TapjoyLog.i("TJCorePlacement", "Content is ready for placement " + this.d.getPlacementName());
        TJPlacement tJPlacementA = a("REQUEST");
        if (tJPlacementA == null || tJPlacementA.getListener() == null) {
            return;
        }
        tJPlacementA.getListener().onContentReady(tJPlacementA);
        this.o = true;
    }

    public final void b(String str) throws TapjoyException {
        if (str == null) {
            throw new TapjoyException("TJPlacement request failed due to null response");
        }
        try {
            TapjoyLog.d("TJCorePlacement", "Disable preload flag is set for placement " + this.d.getPlacementName());
            this.d.setRedirectURL(new JSONObject(str).getString(TapjoyConstants.TJC_REDIRECT_URL));
            this.d.setPreloadDisabled(true);
            this.d.setHasProgressSpinner(true);
            TapjoyLog.d("TJCorePlacement", "redirect_url:" + this.d.getRedirectURL());
        } catch (JSONException unused) {
            throw new TapjoyException("TJPlacement request failed, malformed server response");
        }
    }

    public TJAdUnit getAdUnit() {
        return this.h;
    }

    public Context getContext() {
        return this.f2688b;
    }

    public String getPlacementContentUrl() {
        String appID = TapjoyConnectCore.getAppID();
        if (!TextUtils.isEmpty(appID)) {
            return TapjoyConnectCore.getPlacementURL() + "v1/apps/" + appID + "/content?";
        }
        TapjoyLog.i("TJCorePlacement", "Placement content URL cannot be generated for null app ID");
        return "";
    }

    public TJPlacementData getPlacementData() {
        return this.d;
    }

    public boolean isContentAvailable() {
        return this.p;
    }

    public boolean isContentReady() {
        return this.q;
    }

    public void setContext(Context context) {
        this.f2688b = context;
        this.e = new TJCurrencyParameters(context);
    }

    public final synchronized void a(String str, HashMap map) {
        String strB;
        com.tapjoy.internal.v vVar;
        long jLongValue;
        long jLongValue2;
        long jLongValue3;
        double dDoubleValue;
        if (this.n) {
            TapjoyLog.i("TJCorePlacement", "Placement " + this.d.getPlacementName() + " is already requesting content");
            return;
        }
        this.d.resetPlacementRequestData();
        this.h.resetContentLoadState();
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.l = null;
        this.k = null;
        this.n = true;
        TJPlacement tJPlacementA = a("REQUEST");
        Map<String, String> genericURLParams = TapjoyConnectCore.getGenericURLParams();
        this.c = genericURLParams;
        genericURLParams.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
        Map map2 = this.c;
        TJCurrencyParameters tJCurrencyParameters = this.e;
        tJCurrencyParameters.getClass();
        HashMap map3 = new HashMap();
        Context context = tJCurrencyParameters.a;
        if (context != null && !tJCurrencyParameters.f) {
            tJCurrencyParameters.c = new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE).getInt(TapjoyConstants.PREF_SERVER_CURRENCY_BALANCE, -9999);
        }
        if (tJCurrencyParameters.i.size() > 0 && !tJCurrencyParameters.f && tJCurrencyParameters.c >= 0) {
            TapjoyUtil.safePut(map3, TapjoyConstants.TJC_CURRENCY_ID_BALANCE, (String) tJCurrencyParameters.i.get(0), true);
            TapjoyUtil.safePut(map3, TapjoyConstants.TJC_CURRENCY_BALANCE, Integer.toString(tJCurrencyParameters.c), true);
        } else if (tJCurrencyParameters.i.contains(tJCurrencyParameters.f2690b) && tJCurrencyParameters.f && tJCurrencyParameters.c >= 0) {
            TapjoyUtil.safePut(map3, TapjoyConstants.TJC_CURRENCY_ID_BALANCE, tJCurrencyParameters.f2690b, true);
            TapjoyUtil.safePut(map3, TapjoyConstants.TJC_CURRENCY_BALANCE, Integer.toString(tJCurrencyParameters.c), true);
        }
        if (tJCurrencyParameters.i.contains(tJCurrencyParameters.d) && tJCurrencyParameters.e > 0) {
            TapjoyUtil.safePut(map3, TapjoyConstants.TJC_CURRENCY_ID_REQUIRED, tJCurrencyParameters.d, true);
            TapjoyUtil.safePut(map3, TapjoyConstants.TJC_CURRENCY_AMOUNT_REQUIRED, Integer.toString(tJCurrencyParameters.e), true);
        }
        map2.putAll(map3);
        TapjoyUtil.safePut(this.c, "event_name", this.d.getPlacementName(), true);
        TapjoyUtil.safePut(this.c, TJAdUnitConstants.PARAM_PLACEMENT_PRELOAD, String.valueOf(true), true);
        TapjoyUtil.safePut(this.c, "debug", Boolean.toString(false), true);
        v1 v1Var = v1.m;
        Map map4 = this.c;
        h5 h5Var = v1Var.f2824b;
        if (h5Var == null) {
            strB = null;
        } else {
            h5Var.a();
            strB = h5Var.f2764b.b();
        }
        TapjoyUtil.safePut(map4, TJAdUnitConstants.PARAM_ACTION_ID_EXCLUSION, strB, true);
        TapjoyUtil.safePut(this.c, TJAdUnitConstants.PARAM_PLACEMENT_BY_SDK, String.valueOf(this.m), true);
        TapjoyUtil.safePut(this.c, TJAdUnitConstants.PARAM_PUSH_ID, tJPlacementA.pushId, true);
        if (tJPlacementA.getEntryPoint() != null) {
            TapjoyUtil.safePut(this.c, TJAdUnitConstants.PARAM_ENTRY_POINT, tJPlacementA.getEntryPoint().getValue(), true);
        }
        TapjoyUtil.safePut(this.c, TapjoyConstants.TJC_MEDIATION_SOURCE, this.r, true);
        TapjoyUtil.safePut(this.c, TapjoyConstants.TJC_ADAPTER_VERSION, this.s, true);
        if (!TextUtils.isEmpty(TapjoyConnectCore.getCustomParameter())) {
            TapjoyUtil.safePut(this.c, TapjoyConstants.TJC_CUSTOM_PARAMETER, TapjoyConnectCore.getCustomParameter(), true);
        }
        if (map != null) {
            this.c.putAll(map);
        }
        if (i8.e) {
            TapjoyUtil.safePut(this.c, "sdk_beacon_id", this.h.getTjBeacon().a, true);
        }
        float fFloatValue = 0.0f;
        Iterator it = ca.c.a.a.iterator();
        while (it.hasNext()) {
            Map map5 = ((m0) it.next()).a;
            Object obj = map5 != null ? map5.get("placement_request_content_retry_timeout") : null;
            if (obj != null) {
                if (obj instanceof Number) {
                    fFloatValue = ((Number) obj).floatValue();
                    break;
                } else if (obj instanceof String) {
                    try {
                        fFloatValue = Float.parseFloat((String) obj);
                        break;
                    } catch (IllegalArgumentException unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        ma maVar = new ma((long) fFloatValue);
        Iterator it2 = ca.c.a.a.iterator();
        while (true) {
            if (it2.hasNext()) {
                Map map6 = ((m0) it2.next()).a;
                Object obj2 = map6 != null ? map6.get("placement_request_content_retry_backoff") : null;
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    try {
                        Object obj3 = list.get(0);
                        if (obj3 instanceof Number) {
                            jLongValue = ((Number) obj3).longValue();
                        } else if (obj3 instanceof String) {
                            jLongValue = Long.parseLong((String) obj3);
                        } else {
                            throw new IllegalArgumentException();
                        }
                        long j = jLongValue;
                        Object obj4 = list.get(1);
                        if (obj4 instanceof Number) {
                            jLongValue2 = ((Number) obj4).longValue();
                        } else if (obj4 instanceof String) {
                            jLongValue2 = Long.parseLong((String) obj4);
                        } else {
                            throw new IllegalArgumentException();
                        }
                        Object obj5 = list.get(2);
                        if (obj5 instanceof Number) {
                            jLongValue3 = ((Number) obj5).longValue();
                        } else if (obj5 instanceof String) {
                            jLongValue3 = Long.parseLong((String) obj5);
                        } else {
                            throw new IllegalArgumentException();
                        }
                        Object obj6 = list.get(3);
                        if (obj6 instanceof Number) {
                            dDoubleValue = ((Number) obj6).doubleValue();
                        } else if (obj6 instanceof String) {
                            dDoubleValue = Double.parseDouble((String) obj6);
                        } else {
                            throw new IllegalArgumentException();
                        }
                        vVar = new com.tapjoy.internal.v(j, jLongValue2, jLongValue3, dDoubleValue);
                        break;
                    } catch (RuntimeException unused2) {
                    }
                }
            } else {
                vVar = com.tapjoy.internal.v.f;
                break;
            }
        }
        new t(this, str, tJPlacementA, maVar, vVar).start();
    }

    public final void a(String str, TJPlacement tJPlacement) {
        synchronized (this.a) {
            this.a.put(str, tJPlacement);
            if (tJPlacement != null) {
                TapjoyLog.d("TJCorePlacement", "Setting " + str + " placement: " + tJPlacement.getGUID());
            }
        }
    }

    public final TJPlacement a(String str) {
        TJPlacement tJPlacement;
        synchronized (this.a) {
            tJPlacement = (TJPlacement) this.a.get(str);
            if (tJPlacement != null) {
                TapjoyLog.d("TJCorePlacement", "Returning " + str + " placement: " + tJPlacement.getGUID());
            }
        }
        return tJPlacement;
    }

    public final void a(TJPlacement tJPlacement) {
        if (tJPlacement == null || tJPlacement.getListener() == null) {
            return;
        }
        TapjoyLog.i("TJCorePlacement", "Content request delivered successfully for placement " + this.d.getPlacementName() + ", contentAvailable: " + isContentAvailable() + ", mediationAgent: " + this.t);
        tJPlacement.getListener().onRequestSuccess(tJPlacement);
    }

    public final void a(TJPlacement tJPlacement, TapjoyErrorMessage.ErrorType errorType, TJError tJError) {
        TapjoyLog.e("TJCorePlacement", new TapjoyErrorMessage(errorType, "Content request failed for placement " + this.d.getPlacementName() + "; Reason= " + tJError.message));
        if (tJPlacement == null || tJPlacement.getListener() == null) {
            return;
        }
        tJPlacement.getListener().onRequestFailure(tJPlacement, tJError);
    }
}
