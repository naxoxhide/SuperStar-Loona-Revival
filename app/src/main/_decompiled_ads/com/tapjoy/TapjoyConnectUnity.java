package com.tapjoy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.unity3d.player.UnityPlayer;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class TapjoyConnectUnity {
    private static final String CONNECT_FLAG_DICTIONARY_NAME = "connectFlags";
    private static final int CURRENCY_ALERT_CODE = 1;
    private static final String SEGMENTATION_DICTIONARY_NAME = "segmentationParams";
    private static final String TAG = "TapjoyConnectUnity";
    private static final String UNITY_GAME_OBJECT_NAME = "TapjoyUnity";
    private static Activity activity;
    private static Context applicationContext;
    private static Handler handler;
    private static TJPrivacyPolicy privacyPolicy;
    private static TapjoyConnectUnity tapjoyUnity;
    private int tapjoycurrencyTotal = 0;
    private static Hashtable<String, TJPlacement> cSharpGuidMap = new Hashtable<>();
    private static Hashtable<String, String> javaToCSharpMap = new Hashtable<>();
    private static Hashtable<String, TJActionRequest> actionRequestMap = new Hashtable<>();
    private static Hashtable<String, Object> cSharpDictionaryRefs = new Hashtable<>();
    private static int earnedAmount = 0;
    private static String earnedCurrencyName = "Points";
    private static final TJConnectListener CONNECT_LISTENER = new TJConnectListener() { // from class: com.tapjoy.TapjoyConnectUnity.1
        @Override // com.tapjoy.TJConnectListener, com.tapjoy.TJConnectInterface
        public void onConnectSuccess() {
            Tapjoy.setEarnedCurrencyListener(TapjoyConnectUnity.EARNED_CURRENCY_LISTENER);
            Tapjoy.setVideoListener(TapjoyConnectUnity.VIDEO_LISTENER);
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeConnectCallback", "OnConnectSuccess");
        }

        @Override // com.tapjoy.TJConnectListener, com.tapjoy.TJConnectInterface
        public void onConnectFailure(int i, String str) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeConnectCallback", "OnConnectFailure," + i + "," + str);
        }
    };
    private static final TJVideoListener VIDEO_LISTENER = new TJVideoListener() { // from class: com.tapjoy.TapjoyConnectUnity.2
        @Override // com.tapjoy.TJVideoListener
        public void onVideoStart() {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeVideoCallback", "OnVideoStart");
        }

        @Override // com.tapjoy.TJVideoListener
        public void onVideoError(int i) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeVideoCallback", "OnVideoError," + i);
        }

        @Override // com.tapjoy.TJVideoListener
        public void onVideoComplete() {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeVideoCallback", "OnVideoComplete");
        }
    };
    private static final TJPlacementListener PLACEMENT_LISTENER = new TJPlacementListener() { // from class: com.tapjoy.TapjoyConnectUnity.3
        @Override // com.tapjoy.TJPlacementListener
        public void onRequestSuccess(TJPlacement tJPlacement) {
            String name;
            String str = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnPlacementRequestSuccess," + str + "," + name + "," + tJPlacement.isContentAvailable());
        }

        @Override // com.tapjoy.TJPlacementListener
        public void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
            String name;
            String str = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnPlacementRequestFailure," + str + "," + name + "," + tJError.message);
        }

        @Override // com.tapjoy.TJPlacementListener
        public void onContentReady(TJPlacement tJPlacement) {
            String name;
            String str = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnPlacementContentReady," + str + "," + name);
        }

        @Override // com.tapjoy.TJPlacementListener
        public void onContentShow(TJPlacement tJPlacement) {
            String name;
            String str = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnPlacementContentShow," + str + "," + name);
        }

        @Override // com.tapjoy.TJPlacementListener
        public void onContentDismiss(TJPlacement tJPlacement) {
            String name;
            String str = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnPlacementContentDismiss," + str + "," + name);
        }

        @Override // com.tapjoy.TJPlacementListener
        public void onClick(TJPlacement tJPlacement) {
            String name;
            String str = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnPlacementClick," + str + "," + name);
        }

        @Override // com.tapjoy.TJPlacementListener
        public void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
            String name;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            TapjoyConnectUnity.actionRequestMap.put(str2, tJActionRequest);
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnPurchaseRequest," + str2 + "," + name + "," + tJActionRequest.getRequestId() + "," + tJActionRequest.getToken() + "," + str);
        }

        @Override // com.tapjoy.TJPlacementListener
        public void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i) {
            String name;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            TapjoyConnectUnity.actionRequestMap.put(str2, tJActionRequest);
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnRewardRequest," + str2 + "," + name + "," + tJActionRequest.getRequestId() + "," + tJActionRequest.getToken() + "," + str + "," + i);
        }
    };
    private static final TJPlacementVideoListener PLACEMENT_VIDEO_LISTENER = new TJPlacementVideoListener() { // from class: com.tapjoy.TapjoyConnectUnity.4
        @Override // com.tapjoy.TJPlacementVideoListener
        public void onVideoStart(TJPlacement tJPlacement) {
            String name;
            String str = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementVideoCallback", "OnVideoStart," + str + "," + name);
        }

        @Override // com.tapjoy.TJPlacementVideoListener
        public void onVideoError(TJPlacement tJPlacement, String str) {
            String name;
            String str2 = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementVideoCallback", "OnVideoError," + str2 + "," + name + "," + str);
        }

        @Override // com.tapjoy.TJPlacementVideoListener
        public void onVideoComplete(TJPlacement tJPlacement) {
            String name;
            String str = (String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID());
            try {
                name = Uri.encode(tJPlacement.getName(), "UTF-8");
            } catch (Exception unused) {
                name = tJPlacement.getName();
            }
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementVideoCallback", "OnVideoComplete," + str + "," + name);
        }
    };
    private static final TJSetUserIDListener SET_USER_ID_LISTENER = new TJSetUserIDListener() { // from class: com.tapjoy.TapjoyConnectUnity.5
        @Override // com.tapjoy.TJSetUserIDListener
        public void onSetUserIDSuccess() {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeSetUserIDCallback", "OnSetUserIDSuccess");
        }

        @Override // com.tapjoy.TJSetUserIDListener
        public void onSetUserIDFailure(String str) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeSetUserIDCallback", "OnSetUserIDFailure," + str);
        }
    };
    private static final TJGetCurrencyBalanceListener GET_CURRENCY_BALANCE_LISTENER = new TJGetCurrencyBalanceListener() { // from class: com.tapjoy.TapjoyConnectUnity.6
        @Override // com.tapjoy.TJGetCurrencyBalanceListener
        public void onGetCurrencyBalanceResponse(String str, int i) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", "OnGetCurrencyBalanceResponse," + str + "," + i);
        }

        @Override // com.tapjoy.TJGetCurrencyBalanceListener
        public void onGetCurrencyBalanceResponseFailure(String str) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", "OnGetCurrencyBalanceResponseFailure," + str);
        }
    };
    private static final TJSpendCurrencyListener SPEND_CURRENCY_LISTENER = new TJSpendCurrencyListener() { // from class: com.tapjoy.TapjoyConnectUnity.7
        @Override // com.tapjoy.TJSpendCurrencyListener
        public void onSpendCurrencyResponse(String str, int i) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", "OnSpendCurrencyResponse," + str + "," + i);
        }

        @Override // com.tapjoy.TJSpendCurrencyListener
        public void onSpendCurrencyResponseFailure(String str) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", "OnSpendCurrencyResponseFailure," + str);
        }
    };
    private static final TJAwardCurrencyListener AWARD_CURRENCY_LISTENER = new TJAwardCurrencyListener() { // from class: com.tapjoy.TapjoyConnectUnity.8
        @Override // com.tapjoy.TJAwardCurrencyListener
        public void onAwardCurrencyResponse(String str, int i) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", "OnAwardCurrencyResponse," + str + "," + i);
        }

        @Override // com.tapjoy.TJAwardCurrencyListener
        public void onAwardCurrencyResponseFailure(String str) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", "OnAwardCurrencyResponseFailure," + str);
        }
    };
    private static final TJEarnedCurrencyListener EARNED_CURRENCY_LISTENER = new TJEarnedCurrencyListener() { // from class: com.tapjoy.TapjoyConnectUnity.9
        @Override // com.tapjoy.TJEarnedCurrencyListener
        public void onEarnedCurrency(String str, int i) {
            TapjoyConnectUnity.earnedAmount = i;
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeCurrencyCallback", "OnEarnedCurrency," + str + "," + i);
        }
    };
    private static final TJOfferwallDiscoverListener offersListener = new TJOfferwallDiscoverListener() { // from class: com.tapjoy.TapjoyConnectUnity.10
        @Override // com.tapjoy.TJOfferwallDiscoverListener
        public void requestSuccess() {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeOfferwallDiscoverCallback", "OnOfferwallDiscoverRequestSuccess");
        }

        @Override // com.tapjoy.TJOfferwallDiscoverListener
        public void requestFailure(TJError tJError) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeOfferwallDiscoverCallback", "OnOfferwallDiscoverRequestFailure");
        }

        @Override // com.tapjoy.TJOfferwallDiscoverListener
        public void contentReady() {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeOfferwallDiscoverCallback", "OnOfferwallDiscoverContentReady");
        }

        @Override // com.tapjoy.TJOfferwallDiscoverListener
        public void contentError(TJError tJError) {
            UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativeOfferwallDiscoverCallback", String.format(Locale.ENGLISH, "OnOfferwallDiscoverContentError,%d,%s", Integer.valueOf(tJError.code), tJError.message));
        }
    };
    static final Runnable showDefaultEarnedCurrencyAlert = new Runnable() { // from class: com.tapjoy.TapjoyConnectUnity.15
        @Override // java.lang.Runnable
        public void run() {
            try {
                new AlertDialog.Builder(TapjoyConnectUnity.activity).setTitle("Congratulations!").setMessage("You've just earned " + TapjoyConnectUnity.earnedAmount + " " + TapjoyConnectUnity.earnedCurrencyName).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tapjoy.TapjoyConnectUnity.15.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static void onActivityStart() {
    }

    public static void onActivityStop() {
    }

    private TapjoyConnectUnity() {
    }

    public static void activate(String str) {
        Activity activity2 = UnityPlayer.currentActivity;
        activity = activity2;
        applicationContext = activity2.getApplicationContext();
        if (activity != null) {
            TapjoyConnectCore.setPlugin(TapjoyConstants.TJC_PLUGIN_UNITY);
            activity.runOnUiThread(new Runnable() { // from class: com.tapjoy.TapjoyConnectUnity.11
                @Override // java.lang.Runnable
                public void run() {
                    Tapjoy.setActivity(TapjoyConnectUnity.activity);
                    TapjoyConnectUnity.handler = new Handler() { // from class: com.tapjoy.TapjoyConnectUnity.11.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            super.handleMessage(message);
                            if (message == null || message.arg1 != 1) {
                                return;
                            }
                            post(TapjoyConnectUnity.showDefaultEarnedCurrencyAlert);
                        }
                    };
                }
            });
        }
    }

    public static void connect(String str) {
        connect(str, getReferenceDictionary(CONNECT_FLAG_DICTIONARY_NAME, false));
    }

    public static void connect(final String str, final Hashtable<String, Object> hashtable) {
        tapjoyUnity = new TapjoyConnectUnity();
        Activity activity2 = activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() { // from class: com.tapjoy.TapjoyConnectUnity.12
                @Override // java.lang.Runnable
                public void run() {
                    Tapjoy.connect(TapjoyConnectUnity.applicationContext, str, hashtable, TapjoyConnectUnity.CONNECT_LISTENER);
                }
            });
        }
    }

    @Deprecated
    public static void setReceiveRemoteNotification(String str) {
        Tapjoy.setReceiveRemoteNotification(applicationContext, new HashMap(getReferenceDictionary(str)));
        removeRefDictionary(str);
    }

    public static void activateInstallReferrerClient() {
        Tapjoy.activateInstallReferrerClient(applicationContext);
    }

    public static void setInstallReferrer(String str) {
        Tapjoy.setInstallReferrer(applicationContext, str);
    }

    public static void actionComplete(String str) {
        Tapjoy.actionComplete(str);
    }

    public static void getPrivacyPolicy() {
        if (privacyPolicy == null) {
            privacyPolicy = Tapjoy.getPrivacyPolicy();
        }
    }

    public static void setSubjectToGDPR(boolean z) {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy != null) {
            tJPrivacyPolicy.setSubjectToGDPR(z ? TJStatus.TRUE : TJStatus.FALSE);
        }
    }

    public static void setSubjectToGDPR(int i) {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy != null) {
            tJPrivacyPolicy.setSubjectToGDPR(TJStatus.valueOf(i));
        }
    }

    public static int getSubjectToGDPR() {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy != null && tJPrivacyPolicy.getSubjectToGDPR() != null) {
            return privacyPolicy.getSubjectToGDPR().getValue();
        }
        return TJStatus.UNKNOWN.getValue();
    }

    public static void setUserConsent(String str) {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy == null || str == null) {
            return;
        }
        tJPrivacyPolicy.setUserConsent(str.equals("1") ? TJStatus.TRUE : TJStatus.FALSE);
    }

    public static void setUserConsent(int i) {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy != null) {
            tJPrivacyPolicy.setUserConsent(TJStatus.valueOf(i));
        }
    }

    public static int getUserConsent() {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy != null && tJPrivacyPolicy.getUserConsent() != null) {
            return privacyPolicy.getUserConsent().getValue();
        }
        return TJStatus.UNKNOWN.getValue();
    }

    public static void setBelowConsentAge(boolean z) {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy != null) {
            tJPrivacyPolicy.setBelowConsentAge(z ? TJStatus.TRUE : TJStatus.FALSE);
        }
    }

    public static void setBelowConsentAge(int i) {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy != null) {
            tJPrivacyPolicy.setBelowConsentAge(TJStatus.valueOf(i));
        }
    }

    public static int getBelowConsentAge() {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy != null && tJPrivacyPolicy.getBelowConsentAge() != null) {
            return privacyPolicy.getBelowConsentAge().getValue();
        }
        return TJStatus.UNKNOWN.getValue();
    }

    public static void setUSPrivacy(String str) {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy != null) {
            tJPrivacyPolicy.setUSPrivacy(str);
        }
    }

    public static String getUSPrivacy() {
        TJPrivacyPolicy tJPrivacyPolicy = privacyPolicy;
        if (tJPrivacyPolicy != null) {
            return tJPrivacyPolicy.getUSPrivacy();
        }
        return null;
    }

    public static void optOutAdvertisingID(boolean z) {
        Tapjoy.optOutAdvertisingID(applicationContext, z);
    }

    public static void setUserID(String str) {
        Tapjoy.setUserID(str, SET_USER_ID_LISTENER);
    }

    public static void setCustomParameter(String str) {
        Tapjoy.setCustomParameter(str);
    }

    public static String getCustomParameter() {
        return Tapjoy.getCustomParameter();
    }

    public static void setMaxLevel(int i) {
        Tapjoy.setMaxLevel(i);
    }

    public static int getMaxLevel() {
        return Tapjoy.getMaxLevel();
    }

    public static void awardCurrency(int i) {
        Tapjoy.awardCurrency(i, AWARD_CURRENCY_LISTENER);
    }

    public static void getCurrencyBalance() {
        Tapjoy.getCurrencyBalance(GET_CURRENCY_BALANCE_LISTENER);
    }

    public static void spendCurrency(int i) {
        Tapjoy.spendCurrency(i, SPEND_CURRENCY_LISTENER);
    }

    public static void setCurrencyAmountRequired(String str, String str2, int i) {
        final TJPlacement tJPlacement = cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            tJPlacement.setCurrencyAmountRequired(str2, i, new TJSetCurrencyAmountRequiredListener() { // from class: com.tapjoy.TapjoyConnectUnity.13
                @Override // com.tapjoy.TJSetCurrencyAmountRequiredListener
                public void onSetCurrencyAmountRequiredSuccess() {
                    UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnSetCurrencyAmountRequiredSuccess," + ((String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID())) + "," + TapjoyConnectUnity.getEncodedString(tJPlacement.getName()));
                }

                @Override // com.tapjoy.TJSetCurrencyAmountRequiredListener
                public void onSetCurrencyAmountRequiredFailure(int i2, String str3) {
                    UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnSetCurrencyAmountRequiredFailure," + ((String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID())) + "," + TapjoyConnectUnity.getEncodedString(tJPlacement.getName()) + "," + i2 + "," + str3);
                }
            });
        }
    }

    public static int getCurrencyAmountRequired(String str, String str2) {
        TJPlacement tJPlacement = cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            return tJPlacement.getCurrencyAmountRequired(str2);
        }
        return -1;
    }

    public static void setCurrencyBalance(String str, String str2, int i) {
        final TJPlacement tJPlacement = cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            tJPlacement.setCurrencyBalance(str2, i, new TJSetCurrencyBalanceListener() { // from class: com.tapjoy.TapjoyConnectUnity.14
                @Override // com.tapjoy.TJSetCurrencyBalanceListener
                public void onSetCurrencyBalanceSuccess() {
                    UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnSetCurrencyBalanceSuccess," + ((String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID())) + "," + TapjoyConnectUnity.getEncodedString(tJPlacement.getName()));
                }

                @Override // com.tapjoy.TJSetCurrencyBalanceListener
                public void onSetCurrencyBalanceFailure(int i2, String str3) {
                    UnityPlayer.UnitySendMessage(TapjoyConnectUnity.UNITY_GAME_OBJECT_NAME, "OnNativePlacementCallback", "OnSetCurrencyBalanceFailure," + ((String) TapjoyConnectUnity.javaToCSharpMap.get(tJPlacement.getGUID())) + "," + TapjoyConnectUnity.getEncodedString(tJPlacement.getName()) + "," + i2 + "," + str3);
                }
            });
        }
    }

    public static int getCurrencyBalance(String str, String str2) {
        TJPlacement tJPlacement = cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            return tJPlacement.getCurrencyBalance(str2);
        }
        return -1;
    }

    public static void setEntryPoint(String str, String str2) {
        TJPlacement tJPlacement = cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            tJPlacement.setEntryPoint(TJEntryPoint.fromString(str2));
        }
    }

    public static String getEntryPoint(String str) {
        TJPlacement tJPlacement = cSharpGuidMap.get(str);
        if (tJPlacement != null && tJPlacement.getEntryPoint() != null) {
            return tJPlacement.getEntryPoint().getValue();
        }
        return TJEntryPoint.ENTRY_POINT_UNKNOWN.getValue();
    }

    public static String getSupportURL() {
        return Tapjoy.getSupportURL();
    }

    public static String getSupportURL(String str) {
        return Tapjoy.getSupportURL(str);
    }

    public static void showDefaultEarnedCurrencyAlert() {
        Message message = new Message();
        message.arg1 = 1;
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.sendMessage(message);
        }
    }

    public static void setUserSegment(int i) {
        Tapjoy.setUserSegment(TJSegment.valueOf(i));
    }

    public static int getUserSegment() {
        return Tapjoy.getUserSegment().getValue();
    }

    public static void createPlacement(String str, String str2) {
        TJPlacement tJPlacement = new TJPlacement(activity, str2, PLACEMENT_LISTENER);
        tJPlacement.setVideoListener(PLACEMENT_VIDEO_LISTENER);
        cSharpGuidMap.put(str, tJPlacement);
        javaToCSharpMap.put(tJPlacement.getGUID(), str);
    }

    public static void dismissPlacementContent() {
        TJPlacement.dismissContent();
    }

    public static void requestPlacementContent(String str) {
        TJPlacement tJPlacement = cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            tJPlacement.requestContent();
        }
    }

    public static void showPlacementContent(String str) {
        TJPlacement tJPlacement = cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            tJPlacement.showContent();
        }
    }

    public static boolean isPlacementContentAvailable(String str) {
        TJPlacement tJPlacement = cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            return tJPlacement.isContentAvailable();
        }
        return false;
    }

    public static boolean isPlacementContentReady(String str) {
        TJPlacement tJPlacement = cSharpGuidMap.get(str);
        if (tJPlacement != null) {
            return tJPlacement.isContentReady();
        }
        return false;
    }

    public static void removePlacement(String str) {
        cSharpGuidMap.remove(str);
    }

    public static void requestOWDiscover(String str, float f) {
        TapjoyPluginAPI.RequestOWDiscover(activity, str, f, offersListener);
    }

    public static void requestOWDiscover(String str, float f, float f2, float f3, float f4) {
        TapjoyPluginAPI.RequestOWDiscover(activity, str, f, f2, f3, f4, offersListener);
    }

    public static void showOWDiscover() {
        TapjoyPluginAPI.ShowOWDiscover(activity);
    }

    public static void destroyOWDiscover() {
        TapjoyPluginAPI.DestroyOWDiscover();
    }

    public static void removeRefDictionary(String str) {
        cSharpDictionaryRefs.remove(str);
    }

    public static void actionRequestCompleted(String str) {
        TJActionRequest tJActionRequest = actionRequestMap.get(str);
        if (tJActionRequest != null) {
            tJActionRequest.completed();
            actionRequestMap.remove(str);
        }
    }

    public static void actionRequestCancelled(String str) {
        TJActionRequest tJActionRequest = actionRequestMap.get(str);
        if (tJActionRequest != null) {
            tJActionRequest.cancelled();
            actionRequestMap.remove(str);
        }
    }

    public static void removeActionRequest(String str) {
        actionRequestMap.remove(str);
    }

    public static Hashtable<String, Object> getReferenceDictionary(String str, boolean z) {
        Hashtable<String, Object> hashtable = (Hashtable) cSharpDictionaryRefs.get(str);
        if (hashtable != null || !z) {
            return hashtable;
        }
        Hashtable<String, Object> hashtable2 = new Hashtable<>();
        cSharpDictionaryRefs.put(str, hashtable2);
        return hashtable2;
    }

    public static Hashtable<String, Object> getReferenceDictionary(String str) {
        return getReferenceDictionary(str, true);
    }

    public static void setKeyValueInDictionary(String str, String str2, String str3) {
        getReferenceDictionary(str3).put(str, str2);
    }

    public static void setKeyValueInDictionary(String str, int i, String str2) {
        getReferenceDictionary(str2).put(str, Integer.valueOf(i));
    }

    public static void setKeyValueInDictionary(String str, float f, String str2) {
        getReferenceDictionary(str2).put(str, Float.valueOf(f));
    }

    public static void setKeyValueInDictionary(String str, boolean z, String str2) {
        getReferenceDictionary(str2).put(str, Boolean.valueOf(z));
    }

    public static void setDictionaryInDictionary(String str, String str2, String str3) {
        Hashtable hashtable = (Hashtable) cSharpDictionaryRefs.get(str3);
        if (hashtable == null) {
            hashtable = new Hashtable();
            cSharpDictionaryRefs.put(str3, hashtable);
        }
        Hashtable hashtable2 = (Hashtable) cSharpDictionaryRefs.get(str2);
        if (hashtable2 == null) {
            TapjoyLog.i(UNITY_GAME_OBJECT_NAME, "no dictionary reference by the name of " + str2);
        } else {
            hashtable.put(str, hashtable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getEncodedString(String str) {
        try {
            return Uri.encode(str, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
