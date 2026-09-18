package com.igaworks.adpopcorn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import com.igaworks.adpopcorn.a.b;
import com.igaworks.adpopcorn.a.d;
import com.igaworks.adpopcorn.activity.ApOfferWallActivity_NT;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.interfaces.IAPLoadVideoAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAPOpenCampaignPageEventListener;
import com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener;
import com.igaworks.adpopcorn.renewal.ApRewardOfferWallActivity;
import com.igaworks.adpopcorn.style.APOfferwallTabInfo;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Adpopcorn {
    @Deprecated
    public static void checkRequiredPermission(Activity activity) {
        try {
            d.a((Context) activity).a(activity);
        } catch (Exception unused) {
        }
    }

    public static void loadPopupAd(Context context, IAPPopupAdEventListener iAPPopupAdEventListener) {
        try {
            d.a(context).a(context, iAPPopupAdEventListener);
        } catch (Exception unused) {
        }
    }

    public static void loadVideoAd(Context context, IAPLoadVideoAdEventListener iAPLoadVideoAdEventListener) {
        try {
            d.a(context).a(context, iAPLoadVideoAdEventListener);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public static void onRequestPermissionsResult(Context context, int i, String[] strArr, int[] iArr) {
        try {
            d.a(context).a(context, i, strArr, iArr);
        } catch (Exception unused) {
        }
    }

    public static void openCPMOfferwall(Context context) {
        try {
            d dVarA = d.a(context);
            if (dVarA.e().i()) {
                return;
            }
            HashMap map = new HashMap();
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TEXTVIEW_FONT, Typeface.createFromAsset(context.getAssets(), "font/pretendardstd_regular.ttf"));
            ApStyleManager.setCustomOfferwallStyle(map);
            g gVarA = g.a();
            APOfferwallTabInfo aPOfferwallTabInfo = new APOfferwallTabInfo();
            aPOfferwallTabInfo.setTabCount(5);
            aPOfferwallTabInfo.setTabTitle(gVarA.A1, gVarA.F1, gVarA.D1, gVarA.G1, gVarA.E1);
            aPOfferwallTabInfo.setTabType(0, 10, 8, 11, 9);
            dVarA.b(context);
            dVarA.b("open_offerwall", "cpm_offerwall");
            Intent intent = new Intent(context, (Class<?>) ApRewardOfferWallActivity.class);
            intent.putExtra("offerwallType", 2);
            intent.putExtra("offerwallTabInfo", aPOfferwallTabInfo);
            intent.setFlags(268435456);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openCampaignPage(Context context, String str, IAPOpenCampaignPageEventListener iAPOpenCampaignPageEventListener) {
        try {
            d.a(context).a(context, str, iAPOpenCampaignPageEventListener);
        } catch (Exception unused) {
        }
    }

    public static void openFeedOfferWall(Context context) {
        try {
            d dVarA = d.a(context);
            if (dVarA.e().i()) {
                return;
            }
            HashMap map = new HashMap();
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TEXTVIEW_FONT, Typeface.createFromAsset(context.getAssets(), "font/pretendardstd_regular.ttf"));
            ApStyleManager.setCustomOfferwallStyle(map);
            g gVarA = g.a();
            APOfferwallTabInfo aPOfferwallTabInfo = new APOfferwallTabInfo();
            aPOfferwallTabInfo.setTabCount(3);
            aPOfferwallTabInfo.setTabTitle(gVarA.A1, gVarA.D1, gVarA.E1, "", "");
            aPOfferwallTabInfo.setTabType(0, 8, 9, -1, -1);
            dVarA.b(context);
            dVarA.b("open_offerwall", "feed_offerwall");
            Intent intent = new Intent(context, (Class<?>) ApRewardOfferWallActivity.class);
            intent.putExtra("offerwallType", 2);
            intent.putExtra("offerwallTabInfo", aPOfferwallTabInfo);
            intent.setFlags(268435456);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openOfferWall(Context context) {
        try {
            d dVarA = d.a(context);
            if (dVarA.e().i()) {
                return;
            }
            HashMap map = new HashMap();
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TEXTVIEW_FONT, Typeface.createFromAsset(context.getAssets(), "font/pretendardstd_regular.ttf"));
            ApStyleManager.setCustomOfferwallStyle(map);
            g gVarA = g.a();
            APOfferwallTabInfo aPOfferwallTabInfo = new APOfferwallTabInfo();
            aPOfferwallTabInfo.setTabCount(3);
            aPOfferwallTabInfo.setTabTitle(gVarA.A1, gVarA.D1, gVarA.E1, "", "");
            aPOfferwallTabInfo.setTabType(0, 8, 9, -1, -1);
            dVarA.b(context);
            dVarA.b("open_offerwall", "general_offerwall");
            Intent intent = new Intent(context, (Class<?>) ApRewardOfferWallActivity.class);
            intent.putExtra("offerwallType", 2);
            intent.putExtra("offerwallTabInfo", aPOfferwallTabInfo);
            intent.setFlags(268435456);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void openTabOfferwall(Context context, APOfferwallTabInfo aPOfferwallTabInfo, HashMap<String, Object> map) {
        try {
            d dVarA = d.a(context);
            if (dVarA.e().i()) {
                return;
            }
            HashMap map2 = new HashMap();
            map2.put(ApStyleManager.CustomStyle.OTHER_TYPE_BADGE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#2272eb")));
            map2.put(ApStyleManager.CustomStyle.INSTALL_TYPE_BADGE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#fb8800")));
            map2.put(ApStyleManager.CustomStyle.EXECUTE_TYPE_BADGE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#109595")));
            map2.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP, 16);
            map2.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP, 4);
            map2.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP, 13);
            map2.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map2.put(ApStyleManager.CustomStyle.OFFERWALL_LR_PADDING, 0);
            map2.put(ApStyleManager.CustomStyle.OFFERWALL_TOP_PADDING, 0);
            map2.put(ApStyleManager.CustomStyle.SPECIAL_OFFER_BOTTOM_MARGIN_DP, 0);
            ApStyleManager.setCustomOfferwallStyle(map2);
            if (map != null) {
                ApStyleManager.setCustomOfferwallStyle(map);
            }
            dVarA.b(context);
            dVarA.b("open_offerwall", "tab_offerwall");
            Intent intent = new Intent(context, (Class<?>) ApOfferWallActivity_NT.class);
            intent.putExtra("offerwallType", 3);
            intent.putExtra("offerwallTabInfo", aPOfferwallTabInfo);
            intent.setFlags(268435456);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setEventListener(Context context, IAdPOPcornEventListener iAdPOPcornEventListener) {
        try {
            d.a(context).a(iAdPOPcornEventListener);
        } catch (Exception unused) {
        }
    }

    public static void setSensorLandscapeEnable(Context context, boolean z) {
        try {
            b.a().b(context, "adpopcorn_sdk_flag", "landscape_sensor", z);
        } catch (Exception unused) {
        }
    }

    public static void setSupportAllOrientation(Context context, boolean z) {
        try {
            b.a().b(context, "adpopcorn_sdk_flag", "allScreenOrientation", z);
        } catch (Exception unused) {
        }
    }

    public static void setUserId(Context context, String str) {
        try {
            d.a(context).a(context, str, false);
        } catch (Exception unused) {
        }
    }

    public static void showPopupAd(Activity activity) {
        try {
            d.a((Context) activity).d(activity);
        } catch (Exception unused) {
        }
    }

    public static void showVideoAd(Context context, IAPShowVideoAdEventListener iAPShowVideoAdEventListener) {
        try {
            d.a(context).a(context, iAPShowVideoAdEventListener);
        } catch (Exception unused) {
        }
    }
}
