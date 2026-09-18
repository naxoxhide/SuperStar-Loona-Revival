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
import com.igaworks.adpopcorn.cores.common.h;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener;
import com.igaworks.adpopcorn.interfaces.IAPRewardInfoCallbackListener;
import com.igaworks.adpopcorn.interfaces.IAdPopcornParticipateEventListener;
import com.igaworks.adpopcorn.interfaces.IOnestoreEventListener;
import com.igaworks.adpopcorn.renewal.layout.ApRewardOfferWallLayout;
import com.igaworks.adpopcorn.style.APOfferwallTabInfo;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class AdpopcornExtension {
    public static void didGiveRewardItemWithRewardKey(Context context, String str, String str2) {
        try {
            d dVarA = d.a(context);
            if (dVarA.g()) {
                dVarA.c(str, str2);
            } else {
                h.a("This method is for only Unity.\nPlease check the IgawAdpopcorn.isUnityPlatform(boolean isUnity)", context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getClientPendingRewardItems(Context context) {
        try {
            d.a(context).c(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getEarnableTotalRewardInfo(Context context, IAPRewardInfoCallbackListener iAPRewardInfoCallbackListener) {
        try {
            h.b(context, "AP_OFFER", "setEarnableRewardInfoListener", 3);
            d.a(context).a(iAPRewardInfoCallbackListener);
        } catch (Exception unused) {
        }
    }

    public static void openBerryPopcornOfferWall(Context context) {
        try {
            d dVarA = d.a(context);
            if (dVarA.e().i()) {
                return;
            }
            HashMap map = new HashMap();
            map.put(ApStyleManager.CustomStyle.OFFERWALL_CUSTOM_MEDIA_MODE, 2);
            map.put(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_TEXT_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_BG_COLOR, Integer.valueOf(Color.parseColor("#fcfcfc")));
            Boolean bool = Boolean.TRUE;
            map.put(ApStyleManager.CustomStyle.ALWAYS_SHOW_SPLASH_DIALOG, bool);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TOP_PADDING, 8);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_LR_PADDING, 0);
            map.put(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY, 33);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_CORNER_ROUND_DP, 8);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_SIZE_DP, 12);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#969696")));
            map.put(ApStyleManager.CustomStyle.SPECIAL_OFFER_TOP_ROUND_DP, 8);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR, Integer.valueOf(Color.parseColor("#000000")));
            map.put(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP, 16);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_LIST_ITEM_HEIGHT, 59);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_LIST_ITEM_DIVIDER_HEIGHT, 1);
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE, new APSize(42, 42));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR, Integer.valueOf(Color.parseColor("#fcfcfc")));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP, 12);
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#232532")));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_FOOTER_MARGIN_DP, 0);
            map.put(ApStyleManager.CustomStyle.BOTTOM_BAR_HEIGHT, 0);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_MODE, bool);
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_MAIN_TITLE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#323232")));
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_MAIN_TITLE_SIZE_DP, 12);
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_BACKGROUND_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_SIZE, new APSize(21, 21));
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_OFF_RESOURCE_ID, Integer.valueOf(R.drawable.tpmn_checknull));
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_ON_RESOURCE_ID, Integer.valueOf(R.drawable.tpmn_check));
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_SIZE_DP, 10);
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#969696")));
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_SIZE_DP, 11);
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#323232")));
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_SIZE, new APSize(128, 32));
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_SIZE, new APSize(128, 32));
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP, 15);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP, 1);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP, 12);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_SIZE_DP, 12);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_COLOR, Integer.valueOf(Color.parseColor("#929292")));
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR, Integer.valueOf(Color.parseColor("#ececec")));
            map.put(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT, 130);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_BAR_HEIGHT, 32);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR, Integer.valueOf(Color.parseColor("#fcfcfc")));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR, Integer.valueOf(Color.parseColor("#232532")));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_TEXT_COLOR, Integer.valueOf(Color.parseColor("#929292")));
            map.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR, Integer.valueOf(Color.parseColor("#969696")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_TOP_PADDING, 20);
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_LR_PADDING, 20);
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_BG_COLOR, Integer.valueOf(Color.parseColor("#efefef")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_STROKE_COLOR, Integer.valueOf(Color.parseColor("#efefef")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_ALL_LAYOUT_CORNER_ROUND_DP, 8);
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_STROKE_DP, 1);
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_STROKE_COLOR, Integer.valueOf(Color.parseColor("#ececec")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_DROP_DOWN_ICON_COLOR, Integer.valueOf(Color.parseColor("#000000")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_SIZE, new APSize(63, 26));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_COLOR, Integer.valueOf(Color.parseColor("#2a2a2a")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_SIZE_DP, 11);
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_LINE_COLOR, Integer.valueOf(Color.parseColor("#cfcfcf")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_CORNER_ROUND_DP, 7);
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_TEXT_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_COLOR, Integer.valueOf(Color.parseColor("#2a2a2a")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_SIZE_DP, 11);
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_LR_PADDING, 20);
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_DIVIDER_COLOR, Integer.valueOf(Color.parseColor("#ececec")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_COLOR, Integer.valueOf(Color.parseColor("#2a2a2a")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_SIZE_DP, 11);
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_COLOR, Integer.valueOf(Color.parseColor("#632185")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_SIZE_DP, 11);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#2a2a2a")));
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_SIZE_DP, 15);
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_APP_ICON_SIZE, new APSize(42, 42));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TOP_LAYOUT_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_MIDDLE_LAYOUT_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BOTTOM_LAYOUT_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            ApStyleManager.setCustomOfferwallStyle(map);
            g gVarA = g.a();
            APOfferwallTabInfo aPOfferwallTabInfo = new APOfferwallTabInfo();
            aPOfferwallTabInfo.setTabCount(2);
            aPOfferwallTabInfo.setTabTitle(gVarA.s2, gVarA.t2, "", "", "");
            aPOfferwallTabInfo.setTabType(8, 9, 0, -1, -1);
            dVarA.b(context);
            dVarA.b("open_offerwall", "tpmn_offerwall");
            Intent intent = new Intent(context, (Class<?>) ApOfferWallActivity_NT.class);
            intent.putExtra("offerwallType", 0);
            intent.putExtra("offerwallTabInfo", aPOfferwallTabInfo);
            if (context instanceof Activity) {
                intent.putExtra("offerwallOrientation", context.getResources().getConfiguration().orientation);
            }
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openCSPage(Activity activity, String str) {
        try {
            d.a((Context) activity).a(activity, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openLegacyFeedOfferWall(Context context) {
        try {
            d dVarA = d.a(context);
            if (dVarA.e().i()) {
                return;
            }
            dVarA.b(context);
            dVarA.b("open_offerwall", "legacy_offerwall");
            Intent intent = new Intent(context, (Class<?>) ApOfferWallActivity_NT.class);
            intent.putExtra("offerwallType", 2);
            intent.setFlags(268435456);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openLegacyOfferWall(Context context) {
        try {
            d dVarA = d.a(context);
            if (dVarA.e().i()) {
                return;
            }
            dVarA.b(context);
            dVarA.b("open_offerwall", "legacy_offerwall");
            Intent intent = new Intent(context, (Class<?>) ApOfferWallActivity_NT.class);
            intent.putExtra("offerwallType", 0);
            intent.setFlags(268435456);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openLotteMembersOfferWall(Context context) {
        try {
            d dVarA = d.a(context);
            if (dVarA.e().i()) {
                return;
            }
            HashMap map = new HashMap();
            map.put(ApStyleManager.CustomStyle.OFFERWALL_CUSTOM_MEDIA_MODE, 3);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TITLE_TEXT, "뉴스 바로 적립");
            map.put(ApStyleManager.CustomStyle.OFFERWALL_BG_COLOR, Integer.valueOf(Color.parseColor("#f5f5f5")));
            Boolean bool = Boolean.TRUE;
            map.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_MODE, bool);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_LR_PADDING, 16);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TOP_PADDING, 0);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT, 50);
            map.put(ApStyleManager.CustomStyle.BOTTOM_BAR_HEIGHT, 0);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR, Integer.valueOf(Color.parseColor("#000000")));
            map.put(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP, 16);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_L_PADDING, 18);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_R_PADDING, 18);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_BAR_HEIGHT, 51);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR, Integer.valueOf(Color.parseColor("#222222")));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_LINE_COLOR, Integer.valueOf(Color.parseColor("#222222")));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_TEXT_COLOR, Integer.valueOf(Color.parseColor("#999999")));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_LINE_COLOR, Integer.valueOf(Color.parseColor("#00222222")));
            map.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_BTN_COLOR, Integer.valueOf(Color.parseColor("#009bfa")));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR, Integer.valueOf(Color.parseColor("#f5f5f5")));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP, 8);
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR, Integer.valueOf(Color.parseColor("#009bfa")));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR, Integer.valueOf(Color.parseColor("#009bfa")));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#222222")));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP, 16);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_ID, Integer.valueOf(R.drawable.onestore_x_ic_detail_cancel_2));
            map.put(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_SIZE, new APSize(24, 24));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_REWARD_SUMMARY_BAR_HEIGHT, 0);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_ID, Integer.valueOf(R.drawable.lottemem_back));
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_SIZE, new APSize(24, 24));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE, new APSize(96, 96));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_LIST_ITEM_HEIGHT, 128);
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_COLOR, Integer.valueOf(Color.parseColor("#009BFA")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_DROP_DOWN_ICON_COLOR, Integer.valueOf(Color.parseColor("#009BFA")));
            map.put(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_RADIO_DOT_COLOR, Integer.valueOf(Color.parseColor("#009BFA")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_BG_COLOR, Integer.valueOf(Color.parseColor("#009BFA")));
            map.put(ApStyleManager.CustomStyle.DISABLE_SPECIAL_OFFER, bool);
            ApStyleManager.setCustomOfferwallStyle(map);
            g gVarA = g.a();
            APOfferwallTabInfo aPOfferwallTabInfo = new APOfferwallTabInfo();
            aPOfferwallTabInfo.setTabCount(3);
            aPOfferwallTabInfo.setTabTitle(gVarA.G1, gVarA.D1, gVarA.E1, "", "");
            aPOfferwallTabInfo.setTabType(11, 8, 9, -1, -1);
            dVarA.b(context);
            dVarA.b("open_offerwall", "lottemem_offerwall");
            Intent intent = new Intent(context, (Class<?>) ApOfferWallActivity_NT.class);
            intent.putExtra("offerwallType", 0);
            intent.putExtra("offerwallTabInfo", aPOfferwallTabInfo);
            b.a().b(context, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_imp_day", 0);
            if (context instanceof Activity) {
                intent.putExtra("offerwallOrientation", context.getResources().getConfiguration().orientation);
            }
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openOnestoreOfferWall(Context context, ArrayList<String> arrayList, String str, String str2, boolean z, IOnestoreEventListener iOnestoreEventListener) {
        try {
            d dVarA = d.a(context);
            if (dVarA.e().i()) {
                return;
            }
            HashMap map = new HashMap();
            map.put(ApStyleManager.CustomStyle.OFFERWALL_CUSTOM_MEDIA_MODE, 1);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TITLE_TEXT, "원스토어 포인트존");
            map.put(ApStyleManager.CustomStyle.OFFERWALL_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            Boolean bool = Boolean.TRUE;
            map.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_MODE, bool);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT, 70);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR, Integer.valueOf(Color.parseColor("#000000")));
            map.put(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP, 17);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_L_PADDING, 20);
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_R_PADDING, 8);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_BAR_HEIGHT, 40);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_ENABLE, bool);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT_SIZE_DP, 15);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT_COLOR, Integer.valueOf(Color.parseColor("#4b469c")));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_REWARD_SUMMARY_BAR_HEIGHT, 48);
            map.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_PRE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR, Integer.valueOf(Color.parseColor("#ff3543")));
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_ID, Integer.valueOf(R.drawable.onestore_gnb_gnb_back));
            map.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_SIZE, new APSize(30, 30));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR, Integer.valueOf(Color.parseColor("#0f0c3f")));
            map.put(ApStyleManager.CustomStyle.DISABLE_BOTTOM_BAR_ICON, bool);
            map.put(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_SIZE_DP, 13);
            map.put(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_BOLD, Boolean.FALSE);
            map.put(ApStyleManager.CustomStyle.BOTTOM_BAR_HEIGHT, 40);
            map.put(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_DIVIDER_COLOR, Integer.valueOf(Color.parseColor("#4Dffffff")));
            map.put(ApStyleManager.CustomStyle.BOTTOM_BAR_LINK_TEXT, "by ONE store");
            map.put(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_REWARD_INFO_TEXT_COLOR, Integer.valueOf(Color.parseColor("#4b469c")));
            map.put(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_BTN_COLOR, Integer.valueOf(Color.parseColor("#272558")));
            map.put(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_PRE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_TEXT_COLOR, Integer.valueOf(Color.parseColor("#ff3543")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_SIZE_DP, 15);
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_COLOR, Integer.valueOf(Color.parseColor("#4b469c")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_LR_PADDING, 20);
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_TOP_PADDING, 0);
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_BG_COLOR, Integer.valueOf(Color.parseColor("#f7f7f8")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_STROKE_COLOR, Integer.valueOf(Color.parseColor("#f7f7f8")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_STROKE_DP, 0);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR, Integer.valueOf(Color.parseColor("#272558")));
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP, 22);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP, 1);
            map.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR, Integer.valueOf(Color.parseColor("#acaac4")));
            map.put(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR, Integer.valueOf(Color.parseColor("#7f4b469c")));
            map.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_SIZE, new APSize(30, 30));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_STROKE_DP, 1);
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_STROKE_COLOR, Integer.valueOf(Color.parseColor("#e1e1e1")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.CS_DIALOG_ALL_LAYOUT_CORNER_ROUND_DP, 15);
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_LR_PADDING, 20);
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TOP_PADDING, 10);
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_BG_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_SIZE_DP, 12);
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_COLOR, Integer.valueOf(Color.parseColor("#000000")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_COLOR, Integer.valueOf(Color.parseColor("#000000")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_COLOR, Integer.valueOf(Color.parseColor("#ff3543")));
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_SIZE_DP, 12);
            map.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_SIZE_DP, 12);
            map.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_SIZE, new APSize(19, 19));
            map.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_ID, Integer.valueOf(R.drawable.onestore_ic_detail_point));
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE, new APSize(56, 56));
            map.put(ApStyleManager.CustomStyle.OFFERWALL_LIST_ITEM_HEIGHT, 91);
            map.put(ApStyleManager.CustomStyle.OFFERWALL_LIST_ITEM_DIVIDER_HEIGHT, 1);
            map.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_FOOTER_MARGIN_DP, 34);
            map.put(ApStyleManager.CustomStyle.BOTTOM_BAR_BG_COLOR, Integer.valueOf(Color.parseColor("#B3000000")));
            map.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR, Integer.valueOf(Color.parseColor("#4b469c")));
            map.put(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY, 60);
            map.put(ApStyleManager.CustomStyle.USE_ONESTORE_COMMON_POINT, Boolean.valueOf(z));
            ApStyleManager.setCustomOfferwallStyle(map);
            g gVarA = g.a();
            APOfferwallTabInfo aPOfferwallTabInfo = new APOfferwallTabInfo();
            aPOfferwallTabInfo.setTabCount(2);
            aPOfferwallTabInfo.setTabTitle(gVarA.H1, gVarA.I1, "", "", "");
            aPOfferwallTabInfo.setTabType(10, 8, 9, 0, -1);
            dVarA.b(context);
            dVarA.b("open_offerwall", "onestore_offerwall");
            dVarA.a(str, iOnestoreEventListener);
            Intent intent = new Intent(context, (Class<?>) ApOfferWallActivity_NT.class);
            intent.putExtra("offerwallType", 2);
            intent.putExtra("offerwallTabInfo", aPOfferwallTabInfo);
            intent.putExtra("offerwallAppKey", str);
            intent.putExtra("offerwallHashKey", str2);
            intent.putStringArrayListExtra("offerwallFilterCampaignList", arrayList);
            b.a().b(context, "adpopcorn_splash_reward_sp", "adpopcorn_splash_reward_imp_day", 0);
            if (context instanceof Activity) {
                intent.putExtra("offerwallOrientation", context.getResources().getConfiguration().orientation);
            }
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openOnestoryOfferWall(Context context, ArrayList<String> arrayList, String str, String str2, boolean z, IOnestoreEventListener iOnestoreEventListener) {
        try {
            d dVarA = d.a(context);
            if (dVarA.e().i()) {
                return;
            }
            g gVarA = g.a();
            APOfferwallTabInfo aPOfferwallTabInfo = new APOfferwallTabInfo();
            aPOfferwallTabInfo.setTabCount(2);
            aPOfferwallTabInfo.setTabTitle(gVarA.D1, gVarA.E1, "", "", "");
            aPOfferwallTabInfo.setTabType(8, 9, 0, -1, -1);
            dVarA.b(context);
            dVarA.b("open_offerwall", "general_offerwall");
            Intent intent = new Intent(context, (Class<?>) ApOfferWallActivity_NT.class);
            intent.putExtra("offerwallType", 0);
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

    public static boolean openURL(String str) {
        return d.d(str);
    }

    public static void setAppKeyAndHashKey(Context context, String str, String str2) {
        try {
            d dVarA = d.a(context);
            if (k.a(str)) {
                dVarA.e("adpopcorn_app_key", str);
            }
            if (k.a(str2)) {
                dVarA.e("adpopcorn_hash_key", str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setClientRewardCallbackListener(Context context, IAPClientRewardCallbackListener iAPClientRewardCallbackListener) {
        try {
            d.a(context).a(iAPClientRewardCallbackListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setCustomOfferwallLayout(Context context, ApRewardOfferWallLayout apRewardOfferWallLayout) {
        try {
            h.b(context, "AP_OFFER", "setCustomOfferwallLayout true", 0);
            d.a(context);
            if (apRewardOfferWallLayout != null) {
                apRewardOfferWallLayout.setCustomViewMode(true);
                apRewardOfferWallLayout.initOfferwallLayout(true, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setCustomOfferwallLayout(Context context, ApRewardOfferWallLayout apRewardOfferWallLayout, boolean z) {
        try {
            h.b(context, "AP_OFFER", "setCustomOfferwallLayout true", 0);
            d.a(context);
            if (apRewardOfferWallLayout != null) {
                apRewardOfferWallLayout.setCustomViewMode(true);
                apRewardOfferWallLayout.initOfferwallLayout(z, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDefaultViewTypeCPMTabLayout(Context context, ApRewardOfferWallLayout apRewardOfferWallLayout) {
        try {
            HashMap map = new HashMap();
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TEXTVIEW_FONT, Typeface.createFromAsset(context.getAssets(), "font/pretendardstd_regular.ttf"));
            ApStyleManager.setCustomOfferwallStyle(map);
            g gVarA = g.a();
            APOfferwallTabInfo aPOfferwallTabInfo = new APOfferwallTabInfo();
            aPOfferwallTabInfo.setTabCount(5);
            aPOfferwallTabInfo.setTabTitle(gVarA.A1, gVarA.F1, gVarA.D1, gVarA.G1, gVarA.E1);
            aPOfferwallTabInfo.setTabType(0, 10, 8, 11, 9);
            apRewardOfferWallLayout.setTabOfferwallInfo(aPOfferwallTabInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDefaultViewTypeTabLayout(Context context, ApRewardOfferWallLayout apRewardOfferWallLayout) {
        try {
            HashMap map = new HashMap();
            map.put(ApStyleManager.CustomStyle.OFFERWALL_TEXTVIEW_FONT, Typeface.createFromAsset(context.getAssets(), "font/pretendardstd_regular.ttf"));
            ApStyleManager.setCustomOfferwallStyle(map);
            g gVarA = g.a();
            APOfferwallTabInfo aPOfferwallTabInfo = new APOfferwallTabInfo();
            aPOfferwallTabInfo.setTabCount(3);
            aPOfferwallTabInfo.setTabTitle(gVarA.A1, gVarA.D1, gVarA.E1, "", "");
            aPOfferwallTabInfo.setTabType(0, 8, 9, -1, -1);
            apRewardOfferWallLayout.setTabOfferwallInfo(aPOfferwallTabInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setExceptionPermissionList(Context context, int i) {
        try {
            d.a(context).a(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFromPluginAPI(Context context, boolean z) {
        try {
            d.a(context).b(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setMarketPlace(Context context, String str) {
        try {
            b.a().b(context, "adpopcorn_parameter", "adpopcorn_sdk_market", str);
            d.a(context).g(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setNoAdLandingPage(Context context, String str) {
        try {
            b.a().b(context, "adpopcorn_sdk_flag", "no_ad_landingurl", str);
        } catch (Exception unused) {
        }
    }

    public static void setOfferwallImpressions(Context context) {
        try {
            h.b(context, "AP_OFFER", "Called ViewType Offerwall Impression", 0);
            d.a(context).b("open_offerwall", "view_type_offerwall");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUserAgreement(Context context, boolean z) {
        try {
            d.a(context).a(context, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUserFilter(Context context, String str, String str2) {
        try {
            d.a(context).e(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tryParticipateCampaign(Context context, String str, IAdPopcornParticipateEventListener iAdPopcornParticipateEventListener) {
        try {
            h.b(context, "AP_OFFER", "tryParticipateCampaign", 3);
            d.a(context).a(str, iAdPopcornParticipateEventListener);
        } catch (Exception unused) {
        }
    }

    public static void useFlagShowWhenLocked(Context context, boolean z) {
        try {
            h.b(context, "AP_OFFER", "useFlagShowWhenLocked : " + z, 0);
            b.a().b(context, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", z);
        } catch (Exception unused) {
        }
    }
}
