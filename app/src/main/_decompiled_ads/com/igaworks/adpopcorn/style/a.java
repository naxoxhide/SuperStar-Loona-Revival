package com.igaworks.adpopcorn.style;

import android.graphics.Color;
import android.graphics.Typeface;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.igaworks.adpopcorn.cores.common.APUpdateLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f1662b;
    private HashMap<String, Object> a;

    public a() {
        HashMap<String, Object> map = new HashMap<>();
        this.a = map;
        try {
            map.clear();
            c();
        } catch (Exception unused) {
        }
    }

    public static a b() {
        if (f1662b == null) {
            f1662b = new a();
        }
        return f1662b;
    }

    private void c() {
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR, -12490271);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TITLE_TEXT, "");
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TITLE_LOGO_RESOURCE_ID, -100);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP, 20);
        HashMap<String, Object> map = this.a;
        Boolean bool = Boolean.FALSE;
        map.put(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD, bool);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR, -13682114);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT, 48);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_ID, -100);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_WIDTH, 14);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_HEIGHT, 14);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_SHADOW, bool);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_BG_COLOR, -13682114);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_HEIGHT, 30);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_ICON_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.REWARD_VIEW_LINE_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.REWARD_VIEW_TEXT_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.REWARD_VIEW_CHECKED_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.INSTALL_TYPE_BADGE_COLOR, -107943);
        this.a.put(ApStyleManager.CustomStyle.INSTALL_TYPE_BADGE_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.EXECUTE_TYPE_BADGE_COLOR, -12874770);
        this.a.put(ApStyleManager.CustomStyle.EXECUTE_TYPE_BADGE_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.OTHER_TYPE_BADGE_COLOR, -26306);
        this.a.put(ApStyleManager.CustomStyle.OTHER_TYPE_BADGE_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.COMING_SOON_LAYOUT_BG_COLOR, 436207616);
        this.a.put(ApStyleManager.CustomStyle.COMING_SOON_BADGE_COLOR, 0);
        this.a.put(ApStyleManager.CustomStyle.COMING_SOON_BADGE_LINE_COLOR, Integer.valueOf(SupportMenu.CATEGORY_MASK));
        this.a.put(ApStyleManager.CustomStyle.COMING_SOON_BADGE_TEXT_COLOR, Integer.valueOf(SupportMenu.CATEGORY_MASK));
        this.a.put(ApStyleManager.CustomStyle.COMING_SOON_BADGE_DESC_TEXT_COLOR, Integer.valueOf(SupportMenu.CATEGORY_MASK));
        this.a.put(ApStyleManager.CustomStyle.COMING_SOON_BADGE_DESC_TEXT_SIZE_DP, 12);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TOP_LAYOUT_BG_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BOTTOM_LAYOUT_BG_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_BG_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_LINE_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_BG_COLOR, Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_TEXT_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_LINE_COLOR, Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_TEXT_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR, Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK));
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.TERMS_OF_USE_OFFERWALL, "");
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_MODE, bool);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TITLE_LOGO_RESOURCE_SIZE, new APSize(99, 18));
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_BG_COLOR, -1118482);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_LR_PADDING, 8);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TOP_PADDING, 8);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TEXTVIEW_FONT, null);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TEXTVIEW_LINE_SPACE, 0);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_LR_PADDING, 8);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TOP_PADDING, 8);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_LR_PADDING, 8);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_TOP_PADDING, 8);
        this.a.put(ApStyleManager.CustomStyle.ENABLE_OFFERWALL_TOP_BAR_SHADOW, bool);
        this.a.put(ApStyleManager.CustomStyle.ENABLE_REWARD_HISTORY_DIALOG_TOP_BAR_SHADOW, bool);
        this.a.put(ApStyleManager.CustomStyle.ENABLE_CS_DIALOG_TOP_BAR_SHADOW, bool);
        HashMap<String, Object> map2 = this.a;
        Boolean bool2 = Boolean.TRUE;
        map2.put(ApStyleManager.CustomStyle.ALWAYS_SHOW_OFFERWALL_TOP_BAR_SHADOW, bool2);
        this.a.put(ApStyleManager.CustomStyle.SHADOW_BAR_HEIGHT_DP, 5);
        this.a.put(ApStyleManager.CustomStyle.SHADOW_BAR_RESOURCE_ID, -100);
        this.a.put(ApStyleManager.CustomStyle.SPECIAL_OFFER_TOP_ROUND_DP, 0);
        this.a.put(ApStyleManager.CustomStyle.SPECIAL_OFFER_BOTTOM_MARGIN_DP, 8);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_SIZE, new APSize(24, 24));
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_ID, -100);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_SIZE, new APSize(26, 26));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BG_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_DIVIDER_COLOR, -1118482);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_CORNER_ROUND_DP, 0);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_FOOTER_MARGIN_DP, 15);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR, -12490271);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR, -12490271);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CHECKED_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_SIZE, new APSize(71, 31));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP, 14);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP, 10);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_STROKE_DP, 1);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_COMING_SOON_REWARD_VIEW_OPACITY, 100);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE, new APSize(62, 62));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR, -11972521);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP, 14);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_SIZE, new APSize(55, 20));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_BADGE_TEXT_SIZE_DP, 12);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_COMING_SOON_BADGE_SIZE, new APSize(55, 20));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_MIDDLE_LAYOUT_BG_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BOTTOM_DIVIDER_COLOR, -3222310);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_SIZE, new APSize(69, 20));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_TEXT_SIZE_DP, 14);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_CORNER_ROUND_DP, 8);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_STROKE_DP, 1);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_APP_ICON_SIZE, new APSize(64, 64));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TITLE_TEXT_COLOR, -11972521);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TITLE_TEXT_SIZE_DP, 16);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_DESC_TEXT_COLOR, -14537693);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_DESC_TEXT_SIZE_DP, 14);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BADGE_SIZE, new APSize(55, 20));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BADGE_TEXT_SIZE_DP, 12);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_EXCHANGE_BTN_POSITION, bool);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_SIZE, new APSize(144, 40));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_SIZE, new APSize(144, 40));
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BTN_CORNER_ROUND_DP, 20);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BTN_STROKE_DP, 1);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP, 16);
        this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_TEXT_SIZE_DP, 16);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_CORNER_ROUND_DP, 6);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_SIZE, new APSize(WorkQueueKt.MASK, 35));
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_SIZE, new APSize(WorkQueueKt.MASK, 35));
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP, 18);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP, 1);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP, 14);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_SIZE_DP, 14);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_COLOR, -15198184);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_SIZE_DP, 18);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_COLOR, -15198184);
        this.a.put(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_SIZE_DP, 13);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_SIZE, new APSize(83, 27));
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_SIZE_DP, 12);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_LINE_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_CORNER_ROUND_DP, 3);
        this.a.put(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_TITLE_TEXT_COLOR, -11972521);
        this.a.put(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_TITLE_TEXT_SIZE_DP, 13);
        this.a.put(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_DIVIDER_COLOR, -3222310);
        this.a.put(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_RADIO_DOT_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.USE_MATERIAL_STYLE_CAMPAIGN_DIALOG, bool);
        this.a.put(ApStyleManager.CustomStyle.USE_MATERIAL_STYLE_COMMON_DIALOG, bool);
        this.a.put(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.MATERIAL_STYLE_COMMON_DIALOG_TITLE_DIVIDER_COLOR, -789517);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_BG_COLOR, -920587);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_COLOR, -14605015);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_HEAD_TEXT_SIZE_DP, 12);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_COLOR, -11972521);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_DIVIDER_COLOR, -1447447);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_TEXT_SIZE_DP, 10);
        this.a.put(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_SIZE_DP, 10);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_ALL_LAYOUT_CORNER_ROUND_DP, 0);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_DROP_DOWN_ICON_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_BG_COLOR, -920587);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_STROKE_COLOR, -2170138);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_FAQ_LAYOUT_STROKE_DP, 1);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_BG_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_STROKE_COLOR, -13222069);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_CAMPAIGN_LAYOUT_STROKE_DP, 1);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_BG_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_STROKE_COLOR, -2170138);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_NAME_PHONE_LAYOUT_STROKE_DP, 1);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_BG_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_STROKE_COLOR, -2170138);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_EMAIL_LAYOUT_STROKE_DP, 1);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_BG_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_STROKE_COLOR, -2170138);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_MESSAGE_LAYOUT_STROKE_DP, 1);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_SIZE, new APSize(150, 36));
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_TEXT_SIZE_DP, 14);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_BG_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_CORNER_ROUND_DP, 18);
        this.a.put(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY, 85);
        this.a.put(ApStyleManager.CustomStyle.DIALOG_DIVIDER_LR_PADDING, 0);
        this.a.put(ApStyleManager.CustomStyle.DISABLE_CAMPAIGN_BADGE, bool);
        this.a.put(ApStyleManager.CustomStyle.ENABLE_TOP_BAR_EXPAND_MENU, bool);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_BG_COLOR, -13682114);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_HEIGHT, 0);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT, "");
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT_SIZE_DP, 16);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT_LR_PADDING, 0);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT_BOTTOM_PADDING, 0);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_SUB_TEXT, "");
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_SUB_TEXT_SIZE_DP, 14);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_SUB_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_SUB_TEXT_LR_PADDING, 0);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_LINK_TEXT, "by adpopcorn v." + APUpdateLog.SDK_VERSION_NUM);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_CLICKABLE_LINK_TEXT, bool2);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_LINK_URL, "https://reward.adpopcorn.com");
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CUSTOM_TEXT, "");
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_MAIN_TITLE_SIZE_DP, 13);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_MAIN_TITLE_TEXT_COLOR, 2431236);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_PADDING, 0);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_BACKGROUND_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_SIZE_DP, 11);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_TEXT_COLOR, -6712437);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_SIZE_DP, 13);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_COLOR, 2431236);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_SIZE, new APSize(26, 26));
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_OFF_RESOURCE_ID, -100);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_ON_RESOURCE_ID, -100);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_AGREE_BTN_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_AGREE_BTN_TEXT_COLOR, -100);
        this.a.put(ApStyleManager.CustomStyle.SCHEDULE_CAMPAIGN_LIST_DIVIDER_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.USE_MULITI_LANGUAGE, bool2);
        this.a.put(ApStyleManager.CustomStyle.DEFAULT_LANGUAGE, "default");
        this.a.put(ApStyleManager.CustomStyle.COMMON_POPUP_AD_TITLE_TEXT_SIZE_DP, 18);
        this.a.put(ApStyleManager.CustomStyle.COMMON_POPUP_AD_TITLE_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.COMMON_POPUP_AD_DESC_TEXT_SIZE_DP, 12);
        this.a.put(ApStyleManager.CustomStyle.COMMON_POPUP_AD_DESC_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.PORTRAIT_POPUP_AD_REWARD_CONDITION_ICON_COLOR, -13279);
        this.a.put(ApStyleManager.CustomStyle.PORTRAIT_POPUP_AD_REWARD_CONDITION_TEXT_COLOR, -13279);
        this.a.put(ApStyleManager.CustomStyle.LANDSCAPE_POPUP_AD_REWARD_CONDITION_ICON_COLOR, -16777216);
        this.a.put(ApStyleManager.CustomStyle.LANDSCAPE_POPUP_AD_REWARD_CONDITION_TEXT_COLOR, -16777216);
        this.a.put(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_BG_COLOR, -13279);
        this.a.put(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_TEXT_COLOR, -16777216);
        this.a.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_BTN_COLOR, -12490271);
        this.a.put(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_BTN_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.LOADING_BAR_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_TEXT_COLOR, -10493);
        this.a.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_ID, -100);
        this.a.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_SIZE, new APSize(14, 14));
        this.a.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_TEXT_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_PRE_TEXT_COLOR, -13682115);
        this.a.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_REWARD_TEXT_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_REWARD_INFO_TEXT_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_REWARD_ICON_RESOURCE_ID, -100);
        this.a.put(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_REWARD_ICON_RESOURCE_SIZE, new APSize(20, 20));
        this.a.put(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_REWARD_ICON_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_REWARD_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.DISABLE_SPECIAL_OFFER, bool);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_L_PADDING, 8);
        this.a.put(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_R_PADDING, 4);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_ENABLE, bool);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT, "안내");
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT_COLOR, -14803419);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT_SIZE_DP, 15);
        this.a.put(ApStyleManager.CustomStyle.DISABLE_BOTTOM_BAR_ICON, bool);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_SIZE_DP, 10);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_DIVIDER_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_IGAWORKS_LINK_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_BOLD, bool2);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_LIST_ITEM_HEIGHT, 84);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_LIST_ITEM_DIVIDER_HEIGHT, 2);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TOSS_MEDIA_MODE, bool);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_BAR_HEIGHT, 52);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_REWARD_SUMMARY_BAR_HEIGHT, 30);
        this.a.put(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_PRE_TEXT_COLOR, -10493);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_TEXT_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_SELECT_LINE_COLOR, -12490016);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_TEXT_COLOR, -13354688);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_TAB_UNSELECT_LINE_COLOR, 1023410176);
        this.a.put(ApStyleManager.CustomStyle.SPLASH_DIALOG_PROGRESS_BAR_DRAWABLE_ID, -100);
        this.a.put(ApStyleManager.CustomStyle.OFFERWALL_CUSTOM_MEDIA_MODE, 0);
        this.a.put(ApStyleManager.CustomStyle.FEED_OFFERWALL_LIST_ITEM_CORNER_ROUND_DP, 0);
        this.a.put(ApStyleManager.CustomStyle.ALWAYS_SHOW_SPLASH_DIALOG, bool);
        this.a.put(ApStyleManager.CustomStyle.USE_ONESTORE_COMMON_POINT, bool);
        this.a.put(ApStyleManager.CustomStyle.PASS_PARTICIPATE_EVENT, bool);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_ENABLE_AUTO_ROLLING, bool);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_AUTO_ROLLING_TRIGGER_TIME, 4);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_NAME_TEXT, "클릭하고 적립받기");
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_NAME_TEXT_COLOR, -15132391);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_ENABLE_OFFERWALL_SHORTCUT, bool2);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_OFFERWALL_SHORTCUT_TEXT, "더 보기");
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_OFFERWALL_SHORTCUT_TEXT_COLOR, -14079442);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_OFFERWALL_SHORTCUT_LANDING_URL, "");
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_ENABLE_TEXT_BOX_OUTLINE, bool2);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_TITLE_TEXT_COLOR, -15132391);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_TITLE_TEXT_SIZE_DP, 16);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_DESC_TEXT_COLOR, -13224394);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_DESC_TEXT_SIZE_DP, 14);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_BTN_LINE_TYPE, bool);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_REWARD_ICON_RESOURCE_ID, -100);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_REWARD_ICON_RESOURCE_SIZE, new APSize(0, 0));
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_DEFAULT_TEXT, "더 알아보기");
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_COMPLETE_DEFAULT_TEXT, "참여완료");
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_TEXT_COLOR, -1);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_BTN_COLOR, -12755713);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_TEXT_MODE, bool);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_CURRENT_PAGE_TEXT_COLOR, -15132391);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_TOTAL_PAGE_TEXT_COLOR, -2368549);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_UNSELECTED_COLOR, -2368549);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_INDICATOR_SELECTED_COLOR, -15132391);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_HIDDEN_TOP_AREA, bool);
        this.a.put(ApStyleManager.CustomStyle.NATIVE_RCPM_HIDDEN_INDICATOR_AREA, bool);
    }

    public APSize a(String str) {
        try {
            if (this.a.containsKey(str)) {
                return (APSize) this.a.get(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void a() {
        try {
            if (this.a == null) {
                this.a = new HashMap<>();
            }
            this.a.clear();
            c();
        } catch (Exception unused) {
        }
    }

    public void a(HashMap<String, Object> map) {
        try {
            boolean z = false;
            int iIntValue = -100;
            int iIntValue2 = -100;
            for (Map.Entry entry : new ArrayList(map.entrySet())) {
                this.a.put((String) entry.getKey(), entry.getValue());
                if (entry.getKey() != null && ((String) entry.getKey()).contentEquals(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_WIDTH)) {
                    iIntValue = ((Integer) entry.getValue()).intValue();
                }
                if (entry.getKey() != null && ((String) entry.getKey()).contentEquals(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_HEIGHT)) {
                    iIntValue2 = ((Integer) entry.getValue()).intValue();
                }
                if (entry.getKey() != null && ((String) entry.getKey()).contentEquals(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_SIZE)) {
                    z = true;
                }
                if (entry.getKey() != null && ((String) entry.getKey()).contentEquals(ApStyleManager.CustomStyle.REWARD_VIEW_LINE_COLOR)) {
                    this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_LINE_COLOR, entry.getValue());
                }
                if (entry.getKey() != null && ((String) entry.getKey()).contentEquals(ApStyleManager.CustomStyle.REWARD_VIEW_TEXT_COLOR)) {
                    this.a.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR, entry.getValue());
                }
                if (entry.getKey() != null && ((String) entry.getKey()).contentEquals(ApStyleManager.CustomStyle.TOP_BAR_SHADOW)) {
                    this.a.put(ApStyleManager.CustomStyle.ENABLE_OFFERWALL_TOP_BAR_SHADOW, entry.getValue());
                    this.a.put(ApStyleManager.CustomStyle.ENABLE_REWARD_HISTORY_DIALOG_TOP_BAR_SHADOW, entry.getValue());
                    this.a.put(ApStyleManager.CustomStyle.ENABLE_CS_DIALOG_TOP_BAR_SHADOW, entry.getValue());
                }
                if (entry.getKey() != null && ((String) entry.getKey()).contentEquals(ApStyleManager.CustomStyle.TERMS_OF_USE_OFFERWALL)) {
                    this.a.put(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CUSTOM_TEXT, entry.getValue());
                }
            }
            if (z || iIntValue == -100 || iIntValue2 == -100) {
                return;
            }
            this.a.put(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_SIZE, new APSize(iIntValue, iIntValue2));
        } catch (Exception unused) {
        }
    }

    public void b(HashMap<String, Object> map) {
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(ApStyleManager.CustomStyle.OTHER_TYPE_BADGE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#2272eb")));
        map2.put(ApStyleManager.CustomStyle.INSTALL_TYPE_BADGE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#fb8800")));
        map2.put(ApStyleManager.CustomStyle.EXECUTE_TYPE_BADGE_TEXT_COLOR, Integer.valueOf(Color.parseColor("#109595")));
        map2.put(ApStyleManager.CustomStyle.INSTALL_TYPE_BADGE_COLOR, -1);
        map2.put(ApStyleManager.CustomStyle.EXECUTE_TYPE_BADGE_COLOR, -1);
        map2.put(ApStyleManager.CustomStyle.OTHER_TYPE_BADGE_COLOR, -1);
        map2.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP, 16);
        map2.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_CORNER_ROUND_DP, 4);
        map2.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_SIZE_DP, 13);
        map2.put(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR, Integer.valueOf(Color.parseColor("#ffffff")));
        map2.put(ApStyleManager.CustomStyle.OFFERWALL_LR_PADDING, 0);
        map2.put(ApStyleManager.CustomStyle.OFFERWALL_TOP_PADDING, 0);
        map2.put(ApStyleManager.CustomStyle.SPECIAL_OFFER_BOTTOM_MARGIN_DP, 0);
        a(map2);
        if (map != null) {
            a(map);
        }
    }

    public boolean b(String str) {
        try {
            if (this.a.containsKey(str)) {
                return ((Boolean) this.a.get(str)).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public int c(String str) {
        try {
            if (this.a.containsKey(str)) {
                if (!str.equals(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_RADIO_DOT_COLOR) && !str.equals(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.CS_DIALOG_DROP_DOWN_ICON_COLOR) && !str.equals(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_BG_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_POPUP_AD_TITLE_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_POPUP_AD_DESC_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.PORTRAIT_POPUP_AD_REWARD_CONDITION_ICON_COLOR) && !str.equals(ApStyleManager.CustomStyle.PORTRAIT_POPUP_AD_REWARD_CONDITION_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.LANDSCAPE_POPUP_AD_REWARD_CONDITION_ICON_COLOR) && !str.equals(ApStyleManager.CustomStyle.LANDSCAPE_POPUP_AD_REWARD_CONDITION_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_BG_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_TEXT_COLOR)) {
                    if (!str.equals(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_LINE_COLOR) && !str.equals(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_COLOR)) {
                        return ((Integer) this.a.get(str)).intValue();
                    }
                    return ((Integer) this.a.get(str)).intValue() == -100 ? ((Integer) this.a.get(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR)).intValue() : ((Integer) this.a.get(str)).intValue();
                }
                return ((Integer) this.a.get(str)).intValue() == -100 ? ((Integer) this.a.get(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR)).intValue() : ((Integer) this.a.get(str)).intValue();
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public String d(String str) {
        try {
            if (!this.a.containsKey(str)) {
                return "";
            }
            if (!str.equals(ApStyleManager.CustomStyle.OFFERWALL_TITLE_TEXT) && !str.equals(ApStyleManager.CustomStyle.TERMS_OF_USE_OFFERWALL) && !str.equals(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_TITLE_TEXT) && !str.equals(ApStyleManager.CustomStyle.TOP_BAR_EXPAND_MENU_SUB_TEXT) && !str.equals(ApStyleManager.CustomStyle.BOTTOM_BAR_LINK_TEXT) && !str.equals(ApStyleManager.CustomStyle.BOTTOM_BAR_LINK_URL) && !str.equals(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CUSTOM_TEXT) && !str.equals(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT) && !str.equals(ApStyleManager.CustomStyle.DEFAULT_LANGUAGE) && !str.equals(ApStyleManager.CustomStyle.NATIVE_RCPM_NAME_TEXT) && !str.equals(ApStyleManager.CustomStyle.NATIVE_RCPM_OFFERWALL_SHORTCUT_TEXT) && !str.equals(ApStyleManager.CustomStyle.NATIVE_RCPM_OFFERWALL_SHORTCUT_LANDING_URL) && !str.equals(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_DEFAULT_TEXT) && !str.equals(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_COMPLETE_DEFAULT_TEXT)) {
                if (!str.equals(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_RADIO_DOT_COLOR) && !str.equals(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.REWARD_HISTORY_DIALOG_TABLE_ROW_REWARD_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.CS_DIALOG_DROP_DOWN_ICON_COLOR) && !str.equals(ApStyleManager.CustomStyle.CS_DIALOG_SEND_BTN_BG_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_POPUP_AD_TITLE_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_POPUP_AD_DESC_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.PORTRAIT_POPUP_AD_REWARD_CONDITION_ICON_COLOR) && !str.equals(ApStyleManager.CustomStyle.PORTRAIT_POPUP_AD_REWARD_CONDITION_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.LANDSCAPE_POPUP_AD_REWARD_CONDITION_ICON_COLOR) && !str.equals(ApStyleManager.CustomStyle.LANDSCAPE_POPUP_AD_REWARD_CONDITION_TEXT_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_BG_COLOR) && !str.equals(ApStyleManager.CustomStyle.COMMON_POPUP_AD_REWARD_BTN_TEXT_COLOR)) {
                    if (!str.equals(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_LINE_COLOR) && !str.equals(ApStyleManager.CustomStyle.REWARD_HISTORY_BTN_TEXT_COLOR)) {
                        return "#" + Integer.toHexString(c(str));
                    }
                    return ((Integer) this.a.get(str)).intValue() == -100 ? "#" + Integer.toHexString(c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR)) : "#" + Integer.toHexString(c(str));
                }
                return ((Integer) this.a.get(str)).intValue() == -100 ? "#" + Integer.toHexString(c(ApStyleManager.CustomStyle.OFFERWALL_THEME_COLOR)) : "#" + Integer.toHexString(c(str));
            }
            return (String) this.a.get(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public Typeface e(String str) {
        try {
            if (this.a.containsKey(str)) {
                return (Typeface) this.a.get(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
