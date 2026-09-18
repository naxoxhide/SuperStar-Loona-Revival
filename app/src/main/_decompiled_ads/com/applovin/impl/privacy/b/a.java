package com.applovin.impl.privacy.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.kbeanie.imagechooser.api.ChooserType;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String l(Integer num) {
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 2) {
            return "SFBX CMP";
        }
        if (iIntValue == 3) {
            return "Liveramp CMP";
        }
        if (iIntValue == 5) {
            return "UserCentrics CMP";
        }
        if (iIntValue == 6) {
            return "Sourcepoint Dialogue CMP";
        }
        if (iIntValue == 7) {
            return "Didomi CMP";
        }
        if (iIntValue == 302) {
            return "Gravito CMP";
        }
        if (iIntValue == 303) {
            return "Impala CMP";
        }
        switch (iIntValue) {
            case 10:
                return "InMobi Choice CMP";
            case 14:
                return "Yahoo EMEA CMP";
            case 21:
                return "Traffective CMP";
            case 28:
                return "Onetrust / Cookiepro CMP";
            case 31:
                return "Consentmanager CMP";
            case 35:
                return "BurdaForward GmbH CMP";
            case 68:
                return "Uniconsent CMP";
            case 76:
                return "Sibbo CMP";
            case 84:
                return "Alma CMP";
            case 90:
                return "Commanders Act CMP";
            case 104:
                return "AdOcean CMP";
            case 123:
                return "Iubenda CMP";
            case 125:
                return "Ebay CMP";
            case 134:
                return "Cookiebot CMP";
            case 167:
                return "1&1 Mail & Media GmbH CMP";
            case 171:
                return "Viber Media CMP";
            case 231:
                return "Interia CMP";
            case 237:
                return "ALPRED SL CMP";
            case 273:
                return "One Consent CMP";
            case ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO /* 300 */:
                return "Google consent management solutions";
            case 306:
                return "mobile.de CMP";
            case 309:
                return "Kleinanzeigen CMP";
            case 318:
                return "Seven.One Entertainment Group GmbH CMP";
            case 327:
                return "FunCorp CMP";
            case 329:
                return "wetter.com GmbH CMP";
            case 345:
                return "Axel Springer Deutschland GmbH CMP";
            case 350:
                return "Easybrain CMP";
            case 397:
                return "Autoscout24 CMP";
            default:
                return null;
        }
    }

    public static Integer cn(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("ADCOLONY")) {
            return Integer.valueOf(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED);
        }
        if (str.startsWith("ADMOB") || str.startsWith("GOOGLE")) {
            return 755;
        }
        if (str.startsWith("AMAZON")) {
            return 793;
        }
        if (str.startsWith("BIDMACHINE")) {
            return 736;
        }
        if (str.startsWith("CRITEO")) {
            return 91;
        }
        if (str.startsWith("FYBER")) {
            return 512;
        }
        if (str.startsWith("INMOBI")) {
            return 333;
        }
        if (str.startsWith("MOBILEFUSE")) {
            return 909;
        }
        if (str.startsWith("OGURY")) {
            return 31;
        }
        if (str.startsWith("SMAATO")) {
            return 82;
        }
        return str.startsWith("VERVE") ? 512 : null;
    }

    public static String co(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("ADCOLONY")) {
            return "AdColony, Inc.";
        }
        if (str.startsWith("ADMOB") || str.startsWith("GOOGLE")) {
            return "Google Advertising Products";
        }
        if (str.startsWith("AMAZON")) {
            return "Amazon Advertising";
        }
        if (str.startsWith("BIDMACHINE")) {
            return "BidMachine Inc.";
        }
        if (str.startsWith("CRITEO")) {
            return "Criteo SA";
        }
        if (str.startsWith("FYBER")) {
            return "Fyber Monetization Ltd. (DT Exchange)";
        }
        if (str.startsWith("INMOBI")) {
            return "InMobi Pte Ltd";
        }
        if (str.startsWith("MOBILEFUSE")) {
            return "MobileFuse LLC";
        }
        if (str.startsWith("OGURY")) {
            return "Ogury Ltd";
        }
        if (str.startsWith("SMAATO")) {
            return "Smaato, Inc.";
        }
        if (str.startsWith("VERVE")) {
            return "Verve Group Europe GmbH";
        }
        return null;
    }

    public static Integer cp(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("APPLOVIN")) {
            return 1301;
        }
        if (str.startsWith("CHARTBOOST")) {
            return 2898;
        }
        if (str.startsWith("FACEBOOK")) {
            return 89;
        }
        if (str.startsWith("IRONSOURCE")) {
            return 2878;
        }
        if (str.startsWith("LINE")) {
            return 3214;
        }
        if (str.startsWith("NEND")) {
            return 1782;
        }
        return str.startsWith("UNITY") ? 3234 : null;
    }

    public static String cq(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("APPLOVIN")) {
            return "AppLovin Corp.";
        }
        if (str.startsWith("CHARTBOOST")) {
            return "Chartboost";
        }
        if (str.startsWith("FACEBOOK")) {
            return "Facebook";
        }
        if (str.startsWith("IRONSOURCE")) {
            return "ironSource Mobile";
        }
        if (str.startsWith("LINE")) {
            return "LINE";
        }
        if (str.startsWith("NEND")) {
            return "F@N communications (Nend)";
        }
        if (str.startsWith("UNITY")) {
            return "Unity Ads";
        }
        return null;
    }
}
