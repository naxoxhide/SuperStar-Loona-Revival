package com.igaworks.adpopcorn.plugin.ane;

import android.content.Context;
import android.util.Log;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.igaworks.adpopcorn.Adpopcorn;
import com.igaworks.adpopcorn.AdpopcornExtension;
import com.igaworks.adpopcorn.cores.common.APPopupAdError;
import com.igaworks.adpopcorn.cores.common.APVideoError;
import com.igaworks.adpopcorn.cores.model.APClientRewardItem;
import com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener;
import com.igaworks.adpopcorn.interfaces.IAPLoadVideoAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAPRewardInfoCallbackListener;
import com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdpopcornFunction implements FREFunction {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1635b = "";

    class a implements IAdPOPcornEventListener {
        final /* synthetic */ FREContext a;

        a(AdpopcornFunction adpopcornFunction, FREContext fREContext) {
            this.a = fREContext;
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener
        public void OnAgreePrivacy() {
            Log.d("IgawAdpopcornANEPlugin", "OnAgreePrivacy");
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnAgreePrivacy", "");
            }
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener
        public void OnClosedOfferWallPage() {
            Log.d("IgawAdpopcornANEPlugin", "OnClosedOfferWallPage");
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnClosedOfferWallPage", "");
            }
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener
        public void OnDisagreePrivacy() {
            Log.d("IgawAdpopcornANEPlugin", "OnDisagreePrivacy");
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnDisagreePrivacy", "");
            }
        }
    }

    class b implements IAPLoadVideoAdEventListener {
        final /* synthetic */ FREContext a;

        b(AdpopcornFunction adpopcornFunction, FREContext fREContext) {
            this.a = fREContext;
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPLoadVideoAdEventListener
        public void OnLoadVideoAdFailure(APVideoError aPVideoError) {
            Log.d("IgawAdpopcornANEPlugin", "OnLoadVideoAdFailure");
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnLoadVideoAdFailure", aPVideoError.getErrorMessage());
            }
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPLoadVideoAdEventListener
        public void OnLoadVideoAdSuccess() {
            Log.d("IgawAdpopcornANEPlugin", "OnLoadVideoAdSuccess");
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnLoadVideoAdSuccess", "");
            }
        }
    }

    class c implements IAPShowVideoAdEventListener {
        final /* synthetic */ FREContext a;

        c(AdpopcornFunction adpopcornFunction, FREContext fREContext) {
            this.a = fREContext;
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener
        public void OnShowVideoAdFailure(APVideoError aPVideoError) {
            Log.d("IgawAdpopcornANEPlugin", "OnShowVideoAdFailure");
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnShowVideoAdFailure", aPVideoError.getErrorMessage());
            }
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener
        public void OnShowVideoAdSuccess() {
            Log.d("IgawAdpopcornANEPlugin", "OnShowVideoAdSuccess");
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnShowVideoAdSuccess", "");
            }
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener
        public void OnVideoAdClose() {
            Log.d("IgawAdpopcornANEPlugin", "OnVideoAdClose");
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnVideoAdClose", "");
            }
        }
    }

    class d implements IAPClientRewardCallbackListener {
        final /* synthetic */ FREContext a;

        d(AdpopcornFunction adpopcornFunction, FREContext fREContext) {
            this.a = fREContext;
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener
        public void onDidGiveRewardItemResult(boolean z, String str, int i, String str2) {
            String str3 = str2 + RemoteSettings.FORWARD_SLASH_STRING + String.valueOf(z);
            Log.d("IgawAdpopcornANEPlugin", "onDidGiveRewardItemResult : " + str3);
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("onDidGiveRewardItemResult", str3);
            }
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener
        public void onGetRewardInfo(boolean z, String str, APClientRewardItem[] aPClientRewardItemArr) {
            Log.d("IgawAdpopcornANEPlugin", "onGetRewardInfo");
            if (aPClientRewardItemArr == null || aPClientRewardItemArr.length == 0) {
                return;
            }
            for (APClientRewardItem aPClientRewardItem : aPClientRewardItemArr) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("campaignkey", aPClientRewardItem.getCampaignKey());
                    jSONObject.put("campaignname", aPClientRewardItem.getCampaignTitle());
                    jSONObject.put(FirebaseAnalytics.Param.QUANTITY, aPClientRewardItem.getRewardQuantity());
                    jSONObject.put("cv", aPClientRewardItem.getCV());
                    jSONObject.put("rewardkey", aPClientRewardItem.getRTID());
                    Log.d("IgawAdpopcornANEPlugin", "onGetRewardInfo : " + jSONObject.toString());
                    FREContext fREContext = this.a;
                    if (fREContext != null) {
                        fREContext.dispatchStatusEventAsync("onGetRewardInfo", jSONObject.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class e implements IAPRewardInfoCallbackListener {
        final /* synthetic */ FREContext a;

        e(AdpopcornFunction adpopcornFunction, FREContext fREContext) {
            this.a = fREContext;
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPRewardInfoCallbackListener
        public void OnEarnableTotalRewardInfo(boolean z, int i, String str) {
            Log.d("IgawAdpopcornANEPlugin", "OnEarnableTotalRewardInfo : " + z);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("queryResult", z);
                jSONObject.put("totalCount", i);
                jSONObject.put("totalReward", str);
                this.a.dispatchStatusEventAsync("OnEarnableTotalRewardInfo", jSONObject.toString());
            } catch (Exception unused) {
            }
        }
    }

    class f implements IAPPopupAdEventListener {
        final /* synthetic */ FREContext a;

        f(AdpopcornFunction adpopcornFunction, FREContext fREContext) {
            this.a = fREContext;
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
        public void OnLoadPopupAdFailure(APPopupAdError aPPopupAdError) {
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnLoadPopupAdFailure", aPPopupAdError.getErrorMessage());
            }
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
        public void OnLoadPopupAdSuccess() {
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnLoadPopupAdSuccess", "");
            }
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
        public void OnPopupAdClose() {
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnPopupAdClose", "");
            }
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
        public void OnShowPopupAdFailure(APPopupAdError aPPopupAdError) {
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnShowPopupAdFailure", aPPopupAdError.getErrorMessage());
            }
        }

        @Override // com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener
        public void OnShowPopupAdSuccess() {
            FREContext fREContext = this.a;
            if (fREContext != null) {
                fREContext.dispatchStatusEventAsync("OnShowPopupAdSuccess", "");
            }
        }
    }

    public FREObject call(FREContext fREContext, FREObject[] fREObjectArr) {
        this.a = fREContext.getActivity();
        try {
            this.f1635b = fREObjectArr[0].getAsString();
            Log.d("IgawAdpopcornANEPlugin", "Method Name : " + this.f1635b);
            if (this.f1635b.equals("openOfferwall")) {
                Adpopcorn.openOfferWall(this.a);
            } else if (this.f1635b.equals("openFeedOfferWall")) {
                Adpopcorn.openFeedOfferWall(this.a);
            } else if (this.f1635b.equals("setUserId")) {
                Adpopcorn.setUserId(this.a, fREObjectArr[1].getAsString());
            } else if (this.f1635b.equals("setSensorLandscapeEnable")) {
                Adpopcorn.setSensorLandscapeEnable(this.a, fREObjectArr[1].getAsBool());
            } else if (this.f1635b.equals("setEventListener")) {
                Adpopcorn.setEventListener(this.a, new a(this, fREContext));
            } else if (this.f1635b.equals("loadVideoAd")) {
                Adpopcorn.loadVideoAd(this.a, new b(this, fREContext));
            } else if (this.f1635b.equals("showVideoAd")) {
                Adpopcorn.showVideoAd(this.a, new c(this, fREContext));
            } else if (this.f1635b.equals("useFlagShowWhenLocked")) {
                AdpopcornExtension.useFlagShowWhenLocked(this.a, fREObjectArr[1].getAsBool());
            } else if (this.f1635b.equals("setClientRewardCallbackListener")) {
                AdpopcornExtension.setFromPluginAPI(this.a, true);
                AdpopcornExtension.setClientRewardCallbackListener(this.a, new d(this, fREContext));
            } else if (this.f1635b.equals("getClientPendingRewardItems")) {
                AdpopcornExtension.getClientPendingRewardItems(this.a);
            } else if (this.f1635b.equals("didGiveRewardItem")) {
                AdpopcornExtension.didGiveRewardItemWithRewardKey(this.a, fREObjectArr[1].getAsString(), fREObjectArr[2].getAsString());
            } else if (this.f1635b.equals("setExceptionPermissionList")) {
                AdpopcornExtension.setExceptionPermissionList(this.a, fREObjectArr[1].getAsInt());
            } else if (this.f1635b.equals("getEarnableTotalRewardInfo")) {
                AdpopcornExtension.getEarnableTotalRewardInfo(this.a, new e(this, fREContext));
            } else if (this.f1635b.equals("checkRequiredPermission")) {
                Adpopcorn.checkRequiredPermission(fREContext.getActivity());
            } else if (!this.f1635b.equals("onRequestPermissionsResult")) {
                if (this.f1635b.equals("loadPopupAd")) {
                    Adpopcorn.loadPopupAd(this.a, new f(this, fREContext));
                } else if (this.f1635b.equals("showPopupAd")) {
                    Adpopcorn.showPopupAd(fREContext.getActivity());
                } else {
                    Log.d("IgawAdpopcornANEPlugin", "Method Name is wrong...");
                }
            }
            return null;
        } catch (FRETypeMismatchException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        } catch (FREInvalidObjectException e5) {
            e5.printStackTrace();
            return null;
        } catch (FREWrongThreadException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
