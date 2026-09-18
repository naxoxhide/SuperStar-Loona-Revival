package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tapjoy.internal.f5;
import com.tapjoy.internal.i8;
import com.tapjoy.internal.n8;
import com.tapjoy.internal.o8;
import com.tapjoy.internal.p8;
import com.tapjoy.internal.q8;
import com.tapjoy.internal.r3;
import com.tapjoy.internal.v1;
import com.tapjoy.internal.x0;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class TJPlacement {
    public TJCorePlacement a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TJPlacementListener f2697b;
    public TJPlacementListener c;
    public TJPlacementVideoListener d;
    public String e;
    public TJEntryPoint f = null;
    public String pushId;

    @Deprecated
    public TJPlacement(Context context, String str, TJPlacementListener tJPlacementListener) {
        TJCorePlacement tJCorePlacementA = TJPlacementManager.a(str);
        tJCorePlacementA = tJCorePlacementA == null ? TJPlacementManager.a(str, "", "", false) : tJCorePlacementA;
        tJCorePlacementA.setContext(context);
        a(tJCorePlacementA, tJPlacementListener);
    }

    public static void dismissContent() {
        TJPlacementManager.dismissContentShowing("true".equals(TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISMISS_CONTENT_ALL")));
    }

    public final void a(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        this.a = tJCorePlacement;
        this.e = UUID.randomUUID().toString();
        this.f2697b = tJPlacementListener;
        this.c = tJPlacementListener != null ? (TJPlacementListener) Proxy.newProxyInstance(TJPlacementListener.class.getClassLoader(), new Class[]{TJPlacementListener.class}, new com.tapjoy.internal.j(tJPlacementListener, Thread.currentThread(), Looper.myLooper())) : null;
        FiveRocksIntegration.addPlacementCallback(getName(), this);
    }

    public int getCurrencyAmountRequired(String str) {
        if (!this.a.e.i.contains(str)) {
            return -1;
        }
        TJCurrencyParameters tJCurrencyParameters = this.a.e;
        if (tJCurrencyParameters.h.containsKey(str)) {
            return ((Integer) tJCurrencyParameters.h.get(str)).intValue();
        }
        return -1;
    }

    public int getCurrencyBalance(String str) {
        if ((str != null || this.a.e.f) && !this.a.e.i.contains(str)) {
            return -1;
        }
        TJCurrencyParameters tJCurrencyParameters = this.a.e;
        if (tJCurrencyParameters.g.containsKey(str)) {
            return ((Integer) tJCurrencyParameters.g.get(str)).intValue();
        }
        return -1;
    }

    public TJEntryPoint getEntryPoint() {
        return this.f;
    }

    public String getGUID() {
        return this.e;
    }

    public TJPlacementListener getListener() {
        return this.f2697b;
    }

    public String getName() {
        return this.a.getPlacementData() != null ? this.a.getPlacementData().getPlacementName() : "";
    }

    @Deprecated
    public TJPlacementVideoListener getVideoListener() {
        return this.d;
    }

    public boolean isContentAvailable() {
        return this.a.isContentAvailable();
    }

    public boolean isContentReady() {
        return this.a.isContentReady();
    }

    @Deprecated
    public boolean isLimited() {
        return false;
    }

    public void requestContent() {
        String name = getName();
        TapjoyLog.i("TJPlacement", "requestContent() called for placement " + name);
        if (TJPrivacyPolicy.getInstance() != null && TJPrivacyPolicy.getInstance().getUserConsent() == TJStatus.UNKNOWN) {
            TapjoyLog.w("TJPlacement", "[INFO] Your application calls requestContent without having previously called setUserConsent. You can review Tapjoy supported consent API here - https://dev.tapjoy.com/sdk-integration/#sdk11122_gdpr_release.");
        }
        boolean z = false;
        if (!TapjoyConnectCore.isConnected()) {
            this.a.a(this, TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, new TJError(0, "SDK not connected -- connect must be called first with a successful callback"));
            return;
        }
        if (this.a.getContext() == null) {
            this.a.a(this, TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, new TJError(0, "Context is null -- TJPlacement requires a valid Context."));
            return;
        }
        if (TextUtils.isEmpty(name)) {
            this.a.a(this, TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, new TJError(0, "Invalid placement name -- TJPlacement requires a valid placement name."));
            return;
        }
        this.a.h.setSdkBeacon();
        TJCorePlacement tJCorePlacement = this.a;
        tJCorePlacement.a("REQUEST", this);
        if (tJCorePlacement.g - SystemClock.elapsedRealtime() > 0) {
            TapjoyLog.d("TJCorePlacement", "Content has not expired yet for " + tJCorePlacement.d.getPlacementName());
            if (!tJCorePlacement.p) {
                tJCorePlacement.a(this);
                return;
            }
            tJCorePlacement.o = false;
            tJCorePlacement.a(this);
            tJCorePlacement.a();
            return;
        }
        if (!(!TextUtils.isEmpty(tJCorePlacement.t))) {
            synchronized (tJCorePlacement) {
                String url = tJCorePlacement.d.getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = tJCorePlacement.getPlacementContentUrl();
                    if (TextUtils.isEmpty(url)) {
                        tJCorePlacement.a(tJCorePlacement.a("REQUEST"), TapjoyErrorMessage.ErrorType.SDK_ERROR, new TJError(0, "TJPlacement is missing APP_ID"));
                    } else {
                        tJCorePlacement.d.updateUrl(url);
                        TapjoyLog.d("TJCorePlacement", "sendContentRequest -- URL: " + url + " name: " + tJCorePlacement.d.getPlacementName());
                        tJCorePlacement.a(url, (HashMap) null);
                    }
                } else {
                    TapjoyLog.d("TJCorePlacement", "sendContentRequest -- URL: " + url + " name: " + tJCorePlacement.d.getPlacementName());
                    tJCorePlacement.a(url, (HashMap) null);
                }
            }
            return;
        }
        HashMap map = new HashMap();
        map.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_AGENT, tJCorePlacement.t);
        map.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_ID, tJCorePlacement.u);
        HashMap map2 = tJCorePlacement.v;
        if (map2 != null && !map2.isEmpty()) {
            z = true;
        }
        if (!z) {
            tJCorePlacement.a(tJCorePlacement.d.getMediationURL(), map);
            return;
        }
        for (String str : tJCorePlacement.v.keySet()) {
            map.put(TJAdUnitConstants.AUCTION_PARAM_PREFIX + str, (String) tJCorePlacement.v.get(str));
        }
        tJCorePlacement.a(tJCorePlacement.d.getAuctionMediationURL(), map);
    }

    @Deprecated
    public void setAdapterVersion(String str) {
        this.a.s = str;
    }

    @Deprecated
    public void setAuctionData(HashMap<String, String> map) {
        if (map == null || map.isEmpty()) {
            TapjoyLog.d("TJPlacement", "auctionData can not be null or empty");
            return;
        }
        TJCorePlacement tJCorePlacement = this.a;
        tJCorePlacement.v = map;
        String appID = TapjoyConnectCore.getAppID();
        if (TextUtils.isEmpty(appID)) {
            TapjoyLog.i("TJCorePlacement", "Placement auction data can not be set for a null app ID");
        } else {
            tJCorePlacement.d.setAuctionMediationURL(TapjoyConnectCore.getPlacementURL() + "v1/apps/" + appID + "/bid_content?");
        }
    }

    public void setCurrencyAmountRequired(String str, int i, TJSetCurrencyAmountRequiredListener tJSetCurrencyAmountRequiredListener) {
        if (str != null && !str.isEmpty() && this.a.e.i.contains(str) && i > 0) {
            TJCurrencyParameters tJCurrencyParameters = this.a.e;
            tJCurrencyParameters.d = str;
            tJCurrencyParameters.e = i;
            tJCurrencyParameters.h.put(str, Integer.valueOf(i));
            if (tJSetCurrencyAmountRequiredListener != null) {
                tJSetCurrencyAmountRequiredListener.onSetCurrencyAmountRequiredSuccess();
                return;
            }
            return;
        }
        if (str != null && str.isEmpty() && tJSetCurrencyAmountRequiredListener != null) {
            tJSetCurrencyAmountRequiredListener.onSetCurrencyAmountRequiredFailure(1, "Currency id is null or empty");
            return;
        }
        if (!this.a.e.i.contains(str) && tJSetCurrencyAmountRequiredListener != null) {
            tJSetCurrencyAmountRequiredListener.onSetCurrencyAmountRequiredFailure(1, "Invalid currency id");
        } else {
            if (i > 0 || tJSetCurrencyAmountRequiredListener == null) {
                return;
            }
            tJSetCurrencyAmountRequiredListener.onSetCurrencyAmountRequiredFailure(1, "Amount is negative or zero");
        }
    }

    public void setCurrencyBalance(String str, int i, TJSetCurrencyBalanceListener tJSetCurrencyBalanceListener) {
        if (str != null && !str.isEmpty() && this.a.e.i.contains(str)) {
            TJCurrencyParameters tJCurrencyParameters = this.a.e;
            if (tJCurrencyParameters.f && i >= 0) {
                tJCurrencyParameters.f2690b = str;
                tJCurrencyParameters.c = i;
                tJCurrencyParameters.g.put(str, Integer.valueOf(i));
                if (tJSetCurrencyBalanceListener != null) {
                    tJSetCurrencyBalanceListener.onSetCurrencyBalanceSuccess();
                    return;
                }
                return;
            }
        }
        if (str != null && str.isEmpty() && tJSetCurrencyBalanceListener != null) {
            tJSetCurrencyBalanceListener.onSetCurrencyBalanceFailure(1, "Currency id is null or empty");
            return;
        }
        if (!this.a.e.i.contains(str) && tJSetCurrencyBalanceListener != null) {
            tJSetCurrencyBalanceListener.onSetCurrencyBalanceFailure(1, "Invalid currency id");
            return;
        }
        if (!this.a.e.f && tJSetCurrencyBalanceListener != null) {
            tJSetCurrencyBalanceListener.onSetCurrencyBalanceFailure(1, "App uses Tapjoy managed currencies");
        } else {
            if (i >= 0 || tJSetCurrencyBalanceListener == null) {
                return;
            }
            tJSetCurrencyBalanceListener.onSetCurrencyBalanceFailure(1, "Balance is negative");
        }
    }

    public void setEntryPoint(TJEntryPoint tJEntryPoint) {
        this.f = tJEntryPoint;
    }

    @Deprecated
    public void setMediationId(String str) {
        this.a.u = str;
    }

    @Deprecated
    public void setMediationName(String str) {
        TapjoyLog.d("TJPlacement", "setMediationName=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TJCorePlacement tJCorePlacement = this.a;
        Context context = tJCorePlacement != null ? tJCorePlacement.getContext() : null;
        TJCorePlacement tJCorePlacementA = TJPlacementManager.a(getName(), str, "", false);
        this.a = tJCorePlacementA;
        tJCorePlacementA.t = str;
        tJCorePlacementA.r = str;
        tJCorePlacementA.d.setPlacementType(str);
        String appID = TapjoyConnectCore.getAppID();
        if (TextUtils.isEmpty(appID)) {
            TapjoyLog.i("TJCorePlacement", "Placement mediation name can not be set for a null app ID");
        } else {
            tJCorePlacementA.d.setMediationURL(TapjoyConnectCore.getPlacementURL() + "v1/apps/" + appID + "/mediation_content?");
        }
        if (context != null) {
            this.a.setContext(context);
        }
    }

    @Deprecated
    public void setVideoListener(TJPlacementVideoListener tJPlacementVideoListener) {
        this.d = tJPlacementVideoListener;
    }

    public void showContent() {
        int i;
        TapjoyLog.i("TJPlacement", "showContent() called for placement " + getName());
        if (i8.e) {
            HashMap map = new HashMap();
            map.put("contentReady", String.valueOf(isContentReady()));
            this.a.getAdUnit().getTjBeacon().a(TJAdUnitConstants.String.BEACON_SHOW_PATH, map);
        }
        if (!this.a.isContentAvailable()) {
            TapjoyLog.e("TJPlacement", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "No placement content available. Can not show content for non-200 placement."));
            return;
        }
        TJCorePlacement tJCorePlacement = this.a;
        tJCorePlacement.getClass();
        if (TapjoyConnectCore.isFullScreenViewOpen()) {
            TapjoyLog.w("TJCorePlacement", "Only one view can be presented at a time.");
            return;
        }
        if (TapjoyConnectCore.isViewOpen()) {
            TapjoyLog.w("TJCorePlacement", "Will close N2E content.");
            TapjoyUtil.runOnMainThread(new n8());
        }
        tJCorePlacement.a("SHOW", this);
        String string = UUID.randomUUID().toString();
        f5 f5Var = tJCorePlacement.l;
        if (f5Var != null) {
            f5Var.c = string;
            if (f5Var instanceof x0) {
                i = 3;
            } else {
                i = f5Var instanceof r3 ? 2 : 0;
            }
            TapjoyConnectCore.viewWillOpen(string, i);
            tJCorePlacement.l.f2755b = new o8(tJCorePlacement, string);
            p8 p8Var = new p8(tJCorePlacement);
            synchronized (v1.class) {
                if (v1.n == null) {
                    v1.n = new Handler(Looper.getMainLooper());
                }
                v1.n.post(p8Var);
            }
        } else {
            tJCorePlacement.d.setContentViewId(string);
            TJMemoryDataStorage.getInstance().put(tJCorePlacement.d.getPlacementName(), tJCorePlacement.d);
            Intent intent = new Intent(tJCorePlacement.f2688b, (Class<?>) TJAdUnitActivity.class);
            intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_NAME, tJCorePlacement.d.getPlacementName());
            intent.setFlags(268435456);
            TapjoyUtil.runOnMainThread(new q8(tJCorePlacement, intent));
        }
        tJCorePlacement.g = 0L;
        tJCorePlacement.p = false;
        tJCorePlacement.q = false;
    }

    public TJPlacement(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        a(tJCorePlacement, tJPlacementListener);
    }
}
