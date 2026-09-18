package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.AabEntity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.Campaign;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: CampaignDao.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends a<Campaign> {
    private static final String a = "com.mbridge.msdk.foundation.db.f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static f f2076b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;

    private f(g gVar) {
        super(gVar);
        this.c = "rid";
        this.d = BidResponsedEx.KEY_CID;
        this.e = CampaignEx.JSON_KEY_PLCT;
        this.f = CampaignEx.JSON_KEY_PLCTB;
        this.g = "timestamp";
        this.h = "ridCount";
        this.i = " WHERE ";
        this.j = " AND ";
        this.k = "SELECT ";
        this.l = ProxyConfig.MATCH_ALL_SCHEMES;
        this.m = " FROM ";
        this.n = " AND readyState = '0'";
        this.o = " AND is_bid_campaign = 1";
        this.p = " order by ts ASC";
        this.q = " group by request_id";
        this.r = " group by bid_token";
    }

    public static synchronized f a(g gVar) {
        if (f2076b == null) {
            f2076b = new f(gVar);
        }
        return f2076b;
    }

    public final synchronized void a(String str, int i, int i2) {
        try {
            String str2 = "unitid = " + str + " AND level = " + i + " AND adSource = " + i2;
            if (getWritableDatabase() == null) {
                return;
            }
            getWritableDatabase().delete("campaign", str2, null);
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str, int i, int i2, boolean z) {
        try {
            String str2 = ("unitid = " + str + " AND level = " + i + " AND adSource = " + i2) + " AND is_bid_campaign = " + (z ? 1 : 0);
            if (getWritableDatabase() == null) {
            } else {
                getWritableDatabase().delete("campaign", str2, null);
            }
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("readyState", (Integer) 2);
                    String str2 = ("id = '" + campaignEx.getId() + "' AND unitid = " + str + " AND " + SDKAnalyticsEvents.PARAMETER_REQUEST_ID + " = '" + campaignEx.getRequestId() + "'") + " AND is_bid_campaign = " + (campaignEx.isBidCampaign() ? 1 : 0);
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, str2, null);
                        }
                    } catch (SQLException e) {
                        aa.d("CampaignDao", e.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list, boolean z) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        if (campaignEx.getLoadTimeoutState() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unitid").append(" = '").append(str).append("' AND ").append("id").append(" = '").append(campaignEx.getId()).append("' AND ").append(SDKAnalyticsEvents.PARAMETER_REQUEST_ID).append(" = '").append(campaignEx.getRequestId()).append("'");
                            if (z) {
                                sb.append(" AND is_bid_campaign = 1");
                            } else {
                                sb.append(" AND is_bid_campaign = 0");
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("readyState", (Integer) 2);
                            SQLiteDatabase writableDatabase = getWritableDatabase();
                            if (writableDatabase != null) {
                                writableDatabase.update("campaign", contentValues, sb.toString(), null);
                            }
                        }
                    } catch (SQLException e) {
                        aa.d("CampaignDao", e.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list, String str2, int i) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && !TextUtils.isEmpty(str2)) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            try {
                for (CampaignEx campaignEx : list) {
                    if (campaignEx != null) {
                        String str3 = "unitid = '" + str + "' AND id = '" + campaignEx.getId() + "' AND " + SDKAnalyticsEvents.PARAMETER_REQUEST_ID + " = '" + campaignEx.getRequestId() + "'";
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(str2, Integer.valueOf(i));
                        writableDatabase.update("campaign", contentValues, str3, null);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list, List<CampaignEx> list2, boolean z) {
        String str2;
        if (getWritableDatabase() == null) {
            return;
        }
        try {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        for (CampaignEx campaignEx : list) {
                            try {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("readyState", (Integer) 0);
                                String str3 = "unitid = '" + str + "' AND id = '" + campaignEx.getId() + "' AND " + SDKAnalyticsEvents.PARAMETER_REQUEST_ID + " = '" + campaignEx.getRequestId() + "'";
                                if (z) {
                                    str2 = str3 + " AND is_bid_campaign = 1";
                                } else {
                                    str2 = str3 + " AND is_bid_campaign = 0";
                                }
                                getWritableDatabase().update("campaign", contentValues, str2, null);
                            } catch (Exception e) {
                                aa.d("CampaignDao", e.getLocalizedMessage());
                            }
                        }
                    }
                } catch (Exception e2) {
                    aa.d("CampaignDao", e2.getLocalizedMessage());
                }
            }
            if (list2 != null && list2.size() > 0) {
                for (CampaignEx campaignEx2 : list2) {
                    try {
                        if (campaignEx2.getLoadTimeoutState() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unitid").append(" = '").append(str).append("' AND ").append("id").append(" = '").append(campaignEx2.getId()).append("' AND ").append(SDKAnalyticsEvents.PARAMETER_REQUEST_ID).append(" = '").append(campaignEx2.getRequestId()).append("'");
                            if (z) {
                                sb.append(" AND is_bid_campaign = 1");
                            } else {
                                sb.append(" AND is_bid_campaign = 0");
                            }
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("readyState", (Integer) 2);
                            getWritableDatabase().update("campaign", contentValues2, sb.toString(), null);
                        }
                    } catch (SQLException e3) {
                        aa.d("CampaignDao", e3.getLocalizedMessage());
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", (Integer) 0);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid = '" + str + "' AND id = '" + campaignEx.getId() + "' AND " + SDKAnalyticsEvents.PARAMETER_REQUEST_ID + " = '" + campaignEx.getRequestId() + "'", null);
                        }
                    } catch (Exception e) {
                        aa.d("CampaignDao", e.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list, String str2) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("local_request_id", str2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid = '" + str + "' AND id = '" + campaignEx.getId() + "' AND " + SDKAnalyticsEvents.PARAMETER_REQUEST_ID + " = '" + campaignEx.getRequestId() + "'", null);
                        }
                    } catch (Exception e) {
                        aa.d("CampaignDao", e.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, String str2) {
        try {
            String str3 = "id = '" + str + "' AND unitid = " + str2;
            if (getWritableDatabase() == null) {
            } else {
                getWritableDatabase().delete("campaign", str3, null);
            }
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("unitid").append(" = '").append(str).append("' AND ").append("readyState").append(" = ").append(2);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.delete("campaign", sb.toString(), null);
                }
            } catch (Exception e) {
                aa.d("CampaignDao", e.getLocalizedMessage());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized List<CampaignEx> b(String str) {
        try {
            StringBuilder sb = new StringBuilder("SELECT * FROM ");
            sb.append("campaign").append(" WHERE ");
            sb.append("unitid").append(" = '").append(str).append("' AND ").append("readyState").append(" = ").append(2);
            Cursor cursorRawQuery = getReadableDatabase().rawQuery(sb.toString(), null);
            if (cursorRawQuery == null || cursorRawQuery.getCount() <= 0) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(a(cursorRawQuery));
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final synchronized void a(List<CampaignEx> list, String str) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unitid").append(" = '").append(str).append("' AND ").append("id").append(" = '").append(campaignEx.getId()).append("' AND ").append(SDKAnalyticsEvents.PARAMETER_REQUEST_ID).append(" = '").append(campaignEx.getRequestId()).append("'");
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", (Integer) 2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, sb.toString(), null);
                        }
                    } catch (SQLException e) {
                        aa.d("CampaignDao", e.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, String str2, boolean z, String str3) {
        try {
            String str4 = "id = '" + str + "' AND unitid = " + str2 + " AND is_bid_campaign = " + (z ? "1" : "0") + " AND " + SDKAnalyticsEvents.PARAMETER_REQUEST_ID + " = '" + str3 + "'";
            if (getWritableDatabase() == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            getWritableDatabase().update("campaign", contentValues, str4, null);
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void b(String str, String str2) {
        try {
            if (getWritableDatabase() == null) {
                return;
            }
            String str3 = "id = '" + str + "' AND " + SDKAnalyticsEvents.PARAMETER_REQUEST_ID + " = '" + str2 + "'";
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            getWritableDatabase().update("campaign", contentValues, str3, null);
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str, String str2, int i, int i2, boolean z) {
        String str3;
        try {
            String str4 = "id = '" + str + "' AND unitid = " + str2 + " AND level = " + i + " AND adSource = " + i2;
            if (z) {
                str3 = str4 + " AND is_bid_campaign = 1";
            } else {
                str3 = str4 + " AND is_bid_campaign = 0";
            }
            if (getWritableDatabase() == null) {
                return;
            }
            getWritableDatabase().delete("campaign", str3, null);
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void c(String str) {
        try {
            String str2 = "unitid = " + str;
            if (getWritableDatabase() == null) {
            } else {
                getWritableDatabase().delete("campaign", str2, null);
            }
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str, int i, boolean z) {
        String str2;
        try {
            if (z) {
                str2 = "placement_id = " + str + " AND ad_type = " + i;
            } else {
                str2 = "ad_type = " + i;
            }
            if (getWritableDatabase() == null) {
            } else {
                getWritableDatabase().delete("campaign", str2, null);
            }
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void a() {
        try {
            String str = "ts<" + (System.currentTimeMillis() - 3600000) + " AND " + CampaignEx.JSON_KEY_ST_TS + ">0";
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str, null);
            }
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void a(long j, String str) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str2 = "(plctb>0 and (plctb* 1000+ts)<" + jCurrentTimeMillis + ") or (" + CampaignEx.JSON_KEY_PLCTB + "<=0 and " + CampaignEx.JSON_KEY_ST_TS + "<" + (jCurrentTimeMillis - j) + ") and unitid=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str2, strArr);
            }
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
    }

    public final synchronized void b(long j, String str) {
        try {
            String str2 = "ts<" + (System.currentTimeMillis() - j) + " and unitid=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str2, strArr);
            }
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void a(List<CampaignEx> list, String str, String str2, int i) {
        if (list != null) {
            if (list.size() != 0) {
                if (getWritableDatabase() == null) {
                    return;
                }
                Iterator<CampaignEx> it = list.iterator();
                while (it.hasNext()) {
                    a(it.next(), str, str2, i);
                }
            }
        }
    }

    private synchronized long a(CampaignEx campaignEx, String str, String str2, int i) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = campaignEx.getPv_urls().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("id", campaignEx.getId());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            contentValues.put(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, str);
            contentValues.put("unitid", str2);
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
            contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
            contentValues.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put("video_url", campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put(CampaignUnit.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
            contentValues.put(CampaignUnit.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().a());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.c());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.b()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.a()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID, Long.valueOf(campaignEx.getVidCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_CREATIVE_ID, Long.valueOf(campaignEx.getEcCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_TEMP_ID, Long.valueOf(campaignEx.getEcTemplateId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put("bid_token", campaignEx.getBidToken());
            contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            contentValues.put("ext_data", campaignEx.getExt_data());
            contentValues.put(CampaignUnit.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, campaignEx.getRequestId());
            contentValues.put("n_request_id", campaignEx.getNRid());
            contentValues.put("local_request_id", campaignEx.getLocalRequestId());
            contentValues.put("n_local_request_id", campaignEx.getNLRid());
            contentValues.put("err_type_default_ad", Integer.valueOf(campaignEx.getErrTypeByDefaultAd()));
            contentValues.put("err_reason_default_ad", campaignEx.getErrReasonByDefaultAd());
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
            contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
            if (campaignEx.getAabEntity() != null) {
                contentValues.put(CampaignEx.JSON_KEY_AAB, campaignEx.getAabEntity().toJson().toString());
            }
            contentValues.put(CampaignEx.JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
            contentValues.put("privacy_button_video", Integer.valueOf(campaignEx.getPrivacyButtonTemplateVisibility()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_REPORT_TYPE, Integer.valueOf(campaignEx.getImpReportType()));
            return getWritableDatabase().insert("campaign", null, contentValues);
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
            return -1L;
        }
        throw th;
    }

    public final synchronized long a(CampaignEx campaignEx, String str, int i) {
        String str2;
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = campaignEx.getPv_urls().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("unitid", str);
            contentValues.put(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, campaignEx.getRequestId());
            contentValues.put("n_request_id", campaignEx.getNRid());
            contentValues.put("local_request_id", campaignEx.getLocalRequestId());
            contentValues.put("n_local_request_id", campaignEx.getNLRid());
            contentValues.put("err_type_default_ad", Integer.valueOf(campaignEx.getErrTypeByDefaultAd()));
            contentValues.put("err_reason_default_ad", campaignEx.getErrReasonByDefaultAd());
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
            contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
            contentValues.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put("video_url", campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put(CampaignUnit.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
            contentValues.put(CampaignUnit.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().a());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.c());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.b()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.a()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID, Long.valueOf(campaignEx.getVidCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_CREATIVE_ID, Long.valueOf(campaignEx.getEcCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_TEMP_ID, Long.valueOf(campaignEx.getEcTemplateId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put("bid_token", campaignEx.getBidToken());
            contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            contentValues.put("ext_data", campaignEx.getExt_data());
            contentValues.put(CampaignUnit.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, campaignEx.getPlacementId());
            contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
            contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
            contentValues.put(CampaignEx.JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
            contentValues.put("privacy_button_video", Integer.valueOf(campaignEx.getPrivacyButtonTemplateVisibility()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_REPORT_TYPE, Integer.valueOf(campaignEx.getImpReportType()));
            if (campaignEx.getAabEntity() != null) {
                contentValues.put(CampaignEx.JSON_KEY_AAB, campaignEx.getAabEntity().toJson().toString());
            }
            if (a(campaignEx.getId(), campaignEx.getTab(), str, i, campaignEx.getType(), campaignEx.isBidCampaign())) {
                if (campaignEx.isBidCampaign()) {
                    str2 = "unitid = " + str + " AND is_bid_campaign = 1";
                } else {
                    str2 = "id = " + campaignEx.getId() + " AND unitid = " + str + " AND is_bid_campaign = 0";
                }
                return getWritableDatabase().update("campaign", contentValues, str2, null);
            }
            return getWritableDatabase().insert("campaign", null, contentValues);
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
            return -1L;
        }
    }

    public final synchronized void b(final List<CampaignEx> list, final String str) {
        if (list != null) {
            if (list.size() != 0) {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.db.f.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            f.this.a((CampaignEx) it.next(), str, 0);
                        }
                    }
                }).start();
            }
        }
    }

    public final synchronized int a(String str, long j) {
        try {
            com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (cVarB == null) {
                cVarB = com.mbridge.msdk.c.d.a().b();
            }
            long jQ = cVarB.Q() * 1000;
            a(jQ, str);
            List<CampaignEx> listA = a(str, 0, 0, 1, false);
            if (listA != null && !listA.isEmpty()) {
                Iterator<CampaignEx> it = listA.iterator();
                while (it.hasNext()) {
                    if (!it.next().isSpareOffer(j, jQ)) {
                        return 0;
                    }
                }
                return 1;
            }
            return -1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public final synchronized boolean a(String str, int i, String str2, int i2, int i3, boolean z) {
        String str3;
        try {
            if (z) {
                str3 = "SELECT id FROM campaign WHERE unitid = " + str2 + " AND is_bid_campaign = 1";
            } else {
                str3 = "SELECT id FROM campaign WHERE id='" + str + "' AND tab=" + i + " AND unitid = '" + str2 + "' AND level = " + i2 + " AND adSource = " + i3 + " AND is_bid_campaign = 0";
            }
            Cursor cursorRawQuery = getReadableDatabase().rawQuery(str3, null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.close();
                return true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final List<CampaignEx> a(String str, int i, int i2, int i3) {
        return g("SELECT * FROM campaign" + (" WHERE unitid = '" + str + "' AND level = " + i2 + " AND adSource = " + i3) + (i > 0 ? " LIMIT " + i : ""));
    }

    public final synchronized List<CampaignEx> a(String str, int i, int i2, int i3, boolean z) {
        String str2;
        String str3 = " WHERE unitid = '" + str + "' AND level = " + i2 + " AND adSource = " + i3;
        if (z) {
            str2 = str3 + " AND is_bid_campaign = 1";
        } else {
            str2 = str3 + " AND is_bid_campaign = 0";
        }
        return g("SELECT * FROM campaign" + str2 + (i > 0 ? " LIMIT " + i : ""));
    }

    public final synchronized List<CampaignEx> a(String str, int i, int i2, int i3, String str2) {
        String str3;
        str3 = ((" WHERE unitid = '" + str + "' AND level = " + i2 + " AND adSource = " + i3) + " AND is_bid_campaign = 1") + " AND readyState = '0'";
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + " AND request_id = '" + str2 + "'";
        }
        return g("SELECT * FROM campaign" + (str3 + " order by ts ASC") + (i > 0 ? " LIMIT " + i : ""));
    }

    public final synchronized List<CampaignEx> b(String str, int i, int i2, int i3) {
        return g("SELECT * FROM campaign" + (" WHERE unitid = '" + str + "' AND level = " + i2 + " AND adSource = " + i3) + (i > 0 ? " LIMIT " + i : ""));
    }

    /* JADX WARN: Code duplicated, block: B:50:0x06ab A[Catch: all -> 0x06af, TRY_ENTER, TryCatch #4 {all -> 0x06af, blocks: (B:31:0x0686, B:37:0x068f, B:50:0x06ab, B:51:0x06ae), top: B:58:0x0002 }] */
    private synchronized List<CampaignEx> g(String str) {
        Throwable th;
        Cursor cursorRawQuery;
        try {
            try {
                cursorRawQuery = getReadableDatabase().rawQuery(str, null);
                if (cursorRawQuery != null) {
                    try {
                        try {
                            if (cursorRawQuery.getCount() > 0) {
                                ArrayList arrayList = new ArrayList();
                                while (cursorRawQuery.moveToNext()) {
                                    CampaignEx campaignEx = new CampaignEx();
                                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("pv_urls"));
                                    boolean z = false;
                                    if (!TextUtils.isEmpty(string)) {
                                        JSONArray jSONArray = new JSONArray(string);
                                        ArrayList arrayList2 = new ArrayList();
                                        for (int i = 0; i < jSONArray.length(); i++) {
                                            arrayList2.add(jSONArray.getString(i));
                                        }
                                        campaignEx.setPv_urls(arrayList2);
                                    }
                                    campaignEx.setId(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id")));
                                    campaignEx.setTab(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("tab")));
                                    campaignEx.setPackageName(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_PACKAGE_NAME)));
                                    campaignEx.setAppName(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING)));
                                    campaignEx.setAppDesc(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("app_desc")));
                                    campaignEx.setSize(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_APP_SIZE)));
                                    campaignEx.setImageSize(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_SIZE)));
                                    campaignEx.setIconUrl(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_ICON_URL)));
                                    campaignEx.setImageUrl(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_URL)));
                                    campaignEx.setImpressionURL(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_IMPRESSION_URL)));
                                    campaignEx.setNoticeUrl(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_NOTICE_URL)));
                                    campaignEx.setClickURL(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(DownloadModel.DOWNLOAD_URL)));
                                    campaignEx.setWtick(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
                                    campaignEx.setDeepLinkUrl(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("deeplink_url")));
                                    campaignEx.setUserActivation(Boolean.parseBoolean(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_USER_ACTIVATION))));
                                    campaignEx.setOnlyImpressionURL(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("only_impression")));
                                    campaignEx.setTemplate(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("template")));
                                    campaignEx.setLandingType(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)));
                                    campaignEx.setLinkType(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)));
                                    campaignEx.setClick_mode(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_CLICK_MODE)));
                                    campaignEx.setRating(Double.parseDouble(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("star"))));
                                    campaignEx.setNumberRating(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_NUMBER_RATING)));
                                    campaignEx.setClickInterval(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("cti")));
                                    campaignEx.setTimestamp(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_ST_TS)));
                                    campaignEx.setCacheLevel(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("level")));
                                    campaignEx.setType(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("adSource")));
                                    campaignEx.setAdCall(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ad_call")));
                                    campaignEx.setFca(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("fc_a")));
                                    campaignEx.setFcb(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("fc_b")));
                                    campaignEx.setAd_url_list(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_AD_URL_LIST)));
                                    campaignEx.setVideoLength(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
                                    campaignEx.setVideoSize(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_SIZE)));
                                    campaignEx.setVideoResolution(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
                                    campaignEx.setEndcard_click_result(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_ENDCARD_CLICK)));
                                    campaignEx.setVideoUrlEncode(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_url")));
                                    campaignEx.setWatchMile(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_WATCH_MILE)));
                                    campaignEx.setTImp(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_T_IMP)));
                                    campaignEx.setBty(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("bty")));
                                    campaignEx.setAdvImp(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("advImp")));
                                    campaignEx.setLocalRequestId(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("local_request_id")));
                                    campaignEx.setNRid(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("n_request_id")));
                                    campaignEx.setNLRid(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("n_local_request_id")));
                                    campaignEx.setErrTypeByDefaultAd(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("err_type_default_ad")));
                                    campaignEx.setErrReasonByDefaultAd(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("err_reason_default_ad")));
                                    campaignEx.setOfferType(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_OFFER_TYPE)));
                                    campaignEx.setGuidelines(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
                                    campaignEx.setHtmlUrl(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignUnit.JSON_KEY_HTML_URL)));
                                    campaignEx.setEndScreenUrl(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignUnit.JSON_KEY_END_SCREEN_URL)));
                                    campaignEx.setRewardName(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_REWARD_NAME)));
                                    campaignEx.setRewardAmount(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_REWARD_AMOUNT)));
                                    campaignEx.setRewardPlayStatus(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("reward_play_status")));
                                    campaignEx.setRetarget_offer(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("retarget")));
                                    campaignEx.setCampaignUnitId(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("unitid")));
                                    campaignEx.setNativeVideoTracking(CampaignEx.TrackingStr2Object(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("native_ad_tracking"))));
                                    campaignEx.setNativeVideoTrackingString(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("native_ad_tracking")));
                                    campaignEx.setVideo_end_type(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.VIDEO_END_TYPE)));
                                    campaignEx.setendcard_url(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.ENDCARD_URL)));
                                    campaignEx.setPlayable_ads_without_video(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
                                    campaignEx.setMof_template_url(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL)));
                                    campaignEx.setMof_tplid(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignUnit.JSON_KEY_MOF_TPLID)));
                                    campaignEx.setRewardTemplateMode(CampaignEx.c.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("reward_teamplate"))));
                                    campaignEx.setVideoMD5Value(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
                                    campaignEx.setGifUrl(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_GIF_URL)));
                                    campaignEx.setNvT2(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_NV_T2)));
                                    campaignEx.setClickTimeOutInterval(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("c_coi")));
                                    campaignEx.setcUA(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_C_UA)));
                                    campaignEx.setImpUA(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_IMP_UA)));
                                    campaignEx.setOc_time(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.KEY_OC_TIME)));
                                    campaignEx.setOc_type(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.KEY_OC_TYPE)));
                                    campaignEx.setT_list(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.KEY_T_LIST)));
                                    campaignEx.setGhId(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(DomainCampaignEx.KEY_GH_ID)));
                                    campaignEx.setGhPath(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(DomainCampaignEx.KEY_GH_PATH)));
                                    campaignEx.setBindId(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(DomainCampaignEx.KEY_BIND_ID)));
                                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.KEY_ADCHOICE));
                                    if (!TextUtils.isEmpty(string2)) {
                                        campaignEx.setAdchoice(CampaignEx.a.b(string2));
                                    }
                                    campaignEx.setAdchoiceSizeHeight(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("adchoice_size_height")));
                                    campaignEx.setAdchoiceSizeWidth(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("adchoice_size_width")));
                                    campaignEx.setPlct(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_PLCT)));
                                    campaignEx.setPlctb(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_PLCTB)));
                                    campaignEx.setAdZip(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ad_zip")));
                                    campaignEx.setAdHtml(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_AD_HTML)));
                                    campaignEx.setBannerUrl(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_BANNER_URL)));
                                    campaignEx.setBannerHtml(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_BANNER_HTML)));
                                    campaignEx.setCreativeId(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_CREATIVE_ID)));
                                    campaignEx.setVidCrtvId(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID)));
                                    campaignEx.setEcCrtvId(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_EC_CREATIVE_ID)));
                                    campaignEx.setEcTemplateId(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_EC_TEMP_ID)));
                                    campaignEx.setIsBidCampaign(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("is_bid_campaign")) == 1);
                                    campaignEx.setBidToken(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bid_token")));
                                    campaignEx.setAdType(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("ad_type")));
                                    campaignEx.setFac(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_FAC)));
                                    campaignEx.setTpOffer(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_TP_OFFER)));
                                    campaignEx.setMraid(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_MRAID)));
                                    if (cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("is_mraid_campaign")) == 1) {
                                        z = true;
                                    }
                                    campaignEx.setIsMraid(z);
                                    campaignEx.setOmid(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.KEY_OMID)));
                                    campaignEx.setReady_rate(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_READY_RATE)));
                                    campaignEx.setExt_data(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ext_data")));
                                    campaignEx.setNscpt(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignUnit.JSON_KEY_NSCPT)));
                                    campaignEx.setReq_ext_data(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignUnit.JSON_KEY_REQ_EXT_DATA)));
                                    campaignEx.setReadyState(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("readyState")));
                                    campaignEx.setLoadTimeoutState(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("load_timeout")));
                                    campaignEx.setPlacementId(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER)));
                                    campaignEx.setMaitve(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_MAITVE)));
                                    campaignEx.setMaitve_src(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_MAITVESRC)));
                                    campaignEx.setFlb(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_FLB)));
                                    campaignEx.setFlbSkipTime(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
                                    campaignEx.setCbd(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
                                    campaignEx.setVst(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
                                    campaignEx.setAdSpaceT(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
                                    campaignEx.setVcn(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("vcn")));
                                    campaignEx.setTokenRule(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("token_r")));
                                    campaignEx.setEncryptPrice(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("encrypt_p")));
                                    campaignEx.setVideoCheckType(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE)));
                                    campaignEx.setVideoCtnType(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE)));
                                    campaignEx.setRsIgnoreCheckRuleByString(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE)));
                                    campaignEx.setVideoCompleteTime(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
                                    campaignEx.setAabEntity(AabEntity.parser(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_AAB))));
                                    campaignEx.setPrivacyUrl(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_PRIVACY_URL)));
                                    campaignEx.setPrivacyButtonTemplateVisibility(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("privacy_button_video")));
                                    campaignEx.setImpReportType(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_IMP_REPORT_TYPE));
                                    arrayList.add(campaignEx);
                                }
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                return arrayList;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        aa.d("CampaignDao", e.getLocalizedMessage());
                        if (cursorRawQuery != null) {
                        }
                        return null;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (Throwable th3) {
                th = th3;
                cursorRawQuery = null;
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
            return null;
        } catch (Throwable th4) {
            throw th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0155 A[PHI: r1
      0x0155: PHI (r1v23 android.database.Cursor) = (r1v22 android.database.Cursor), (r1v24 android.database.Cursor) binds: [B:32:0x0153, B:23:0x0141] A[DONT_GENERATE, DONT_INLINE]] */
    public final List<com.mbridge.msdk.foundation.entity.b> d(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String str2 = "SELECT request_id as rid ,count(*) as ridCount ,vcn,token_r,bid_token,local_request_id,ts as timestamp FROM campaign" + (((((" WHERE unitid = '" + str + "' AND level = 0 AND adSource = 1") + " AND is_bid_campaign = 1") + " AND readyState = '0'") + " group by request_id") + " order by ts ASC");
        Cursor cursorRawQuery = null;
        try {
            try {
                synchronized (new Object()) {
                    cursorRawQuery = getReadableDatabase().rawQuery(str2, null);
                }
                if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                    while (cursorRawQuery.moveToNext()) {
                        com.mbridge.msdk.foundation.entity.b bVar = new com.mbridge.msdk.foundation.entity.b();
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("rid"));
                        if (!TextUtils.isEmpty(string)) {
                            String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("local_request_id"));
                            String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bid_token"));
                            int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("ridCount"));
                            int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("token_r"));
                            long j = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("timestamp"));
                            int i3 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("vcn"));
                            bVar.b(string);
                            bVar.c(i);
                            bVar.c(j);
                            bVar.a(i2);
                            bVar.b(i3);
                            bVar.c(string2);
                            if (!TextUtils.isEmpty(string3)) {
                                bVar.a(string3);
                            }
                            arrayList.add(bVar);
                        }
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception e) {
                aa.d("CampaignDao", e.getLocalizedMessage());
                if (0 != 0) {
                    cursorRawQuery.close();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (0 != 0) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a5 A[PHI: r1
      0x00a5: PHI (r1v11 android.database.Cursor) = (r1v10 android.database.Cursor), (r1v12 android.database.Cursor) binds: [B:29:0x00a3, B:20:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    public final List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String str2 = "SELECT request_id as rid FROM campaign" + (((" WHERE unitid = '" + str + "'") + " AND is_bid_campaign = 1") + " group by request_id");
        Cursor cursorRawQuery = null;
        try {
            try {
                synchronized (new Object()) {
                    cursorRawQuery = getReadableDatabase().rawQuery(str2, null);
                }
                if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("rid"));
                        if (!TextUtils.isEmpty(string)) {
                            arrayList.add(string);
                        }
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception e) {
                aa.d("CampaignDao", e.getLocalizedMessage());
                if (0 != 0) {
                    cursorRawQuery.close();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (0 != 0) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final int c(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = "unitid = '" + str2 + "' AND " + SDKAnalyticsEvents.PARAMETER_REQUEST_ID + " = '" + str + "' AND is_bid_campaign = 1";
        } else {
            str3 = "unitid = '" + str2 + "' AND is_bid_campaign = 1";
        }
        String str4 = str3 + " AND readyState = '0'";
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            return getWritableDatabase().update("campaign", contentValues, str4, null);
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0131 A[PHI: r1
      0x0131: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:30:0x012f, B:21:0x011d] A[DONT_GENERATE, DONT_INLINE]] */
    public final ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b> f(String str) {
        String str2 = "SELECT request_id as rid, id as cid, plct as plct, plctb as plctb, ts as timestamp FROM campaign" + (((" WHERE unitid = '" + str + "' AND level = 0 AND adSource = 1") + " AND is_bid_campaign = 1") + " AND readyState = '0'");
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b> concurrentHashMap = new ConcurrentHashMap<>();
        Cursor cursorRawQuery = null;
        try {
            try {
                synchronized (new Object()) {
                    cursorRawQuery = getReadableDatabase().rawQuery(str2, null);
                }
                if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("rid"));
                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(BidResponsedEx.KEY_CID));
                        long j = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_PLCT));
                        long j2 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_PLCTB));
                        long j3 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("timestamp"));
                        if (concurrentHashMap.containsKey(string)) {
                            com.mbridge.msdk.foundation.entity.b bVar = concurrentHashMap.get(string);
                            if (bVar != null) {
                                bVar.b(string);
                                bVar.a(j);
                                bVar.b(j2);
                                bVar.c(j3);
                                if (bVar.c() != null) {
                                    bVar.c().add(string2);
                                }
                            }
                        } else {
                            com.mbridge.msdk.foundation.entity.b bVar2 = new com.mbridge.msdk.foundation.entity.b();
                            bVar2.b(string);
                            bVar2.a(j);
                            bVar2.b(j2);
                            bVar2.c(j3);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(string2);
                            bVar2.a(arrayList);
                            concurrentHashMap.put(string, bVar2);
                        }
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception e) {
                aa.d("CampaignDao", e.getLocalizedMessage());
                if (0 != 0) {
                    cursorRawQuery.close();
                }
            }
            return concurrentHashMap;
        } catch (Throwable th) {
            if (0 != 0) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private CampaignEx a(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        try {
            String string = cursor.getString(cursor.getColumnIndex("pv_urls"));
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                campaignEx.setPv_urls(arrayList);
            }
        } catch (JSONException unused) {
        }
        campaignEx.setId(cursor.getString(cursor.getColumnIndex("id")));
        campaignEx.setTab(cursor.getInt(cursor.getColumnIndex("tab")));
        campaignEx.setPackageName(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_PACKAGE_NAME)));
        campaignEx.setAppName(cursor.getString(cursor.getColumnIndex(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING)));
        campaignEx.setAppDesc(cursor.getString(cursor.getColumnIndex("app_desc")));
        campaignEx.setSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_APP_SIZE)));
        campaignEx.setImageSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_SIZE)));
        campaignEx.setIconUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_ICON_URL)));
        campaignEx.setImageUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_URL)));
        campaignEx.setImpressionURL(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMPRESSION_URL)));
        campaignEx.setNoticeUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_NOTICE_URL)));
        campaignEx.setClickURL(cursor.getString(cursor.getColumnIndex(DownloadModel.DOWNLOAD_URL)));
        campaignEx.setWtick(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
        campaignEx.setDeepLinkUrl(cursor.getString(cursor.getColumnIndex("deeplink_url")));
        campaignEx.setUserActivation(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_USER_ACTIVATION))));
        campaignEx.setOnlyImpressionURL(cursor.getString(cursor.getColumnIndex("only_impression")));
        campaignEx.setTemplate(cursor.getInt(cursor.getColumnIndex("template")));
        campaignEx.setLandingType(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)));
        campaignEx.setLinkType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)));
        campaignEx.setClick_mode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_CLICK_MODE)));
        campaignEx.setRating(Double.parseDouble(cursor.getString(cursor.getColumnIndex("star"))));
        campaignEx.setNumberRating(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NUMBER_RATING)));
        campaignEx.setClickInterval(cursor.getInt(cursor.getColumnIndex("cti")));
        campaignEx.setTimestamp(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_ST_TS)));
        campaignEx.setCacheLevel(cursor.getInt(cursor.getColumnIndex("level")));
        campaignEx.setAdCall(cursor.getString(cursor.getColumnIndex("ad_call")));
        campaignEx.setFcb(cursor.getInt(cursor.getColumnIndex("fc_b")));
        campaignEx.setAd_url_list(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_URL_LIST)));
        campaignEx.setVideoLength(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
        campaignEx.setVideoSize(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_SIZE)));
        campaignEx.setVideoResolution(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
        campaignEx.setEndcard_click_result(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_ENDCARD_CLICK)));
        campaignEx.setVideoUrlEncode(cursor.getString(cursor.getColumnIndex("video_url")));
        campaignEx.setWatchMile(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WATCH_MILE)));
        campaignEx.setTImp(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_T_IMP)));
        campaignEx.setBty(cursor.getInt(cursor.getColumnIndex("bty")));
        campaignEx.setAdvImp(cursor.getString(cursor.getColumnIndex("advImp")));
        campaignEx.setLocalRequestId(cursor.getString(cursor.getColumnIndex("local_request_id")));
        campaignEx.setNRid(cursor.getString(cursor.getColumnIndex("n_request_id")));
        campaignEx.setNLRid(cursor.getString(cursor.getColumnIndex("n_local_request_id")));
        campaignEx.setErrTypeByDefaultAd(cursor.getInt(cursor.getColumnIndex("err_type_default_ad")));
        campaignEx.setErrReasonByDefaultAd(cursor.getString(cursor.getColumnIndex("err_reason_default_ad")));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setOfferType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_OFFER_TYPE)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_HTML_URL)));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_HTML_URL)));
        campaignEx.setEndScreenUrl(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_END_SCREEN_URL)));
        campaignEx.setRewardName(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_NAME)));
        campaignEx.setRewardAmount(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_AMOUNT)));
        campaignEx.setRewardPlayStatus(cursor.getInt(cursor.getColumnIndex("reward_play_status")));
        campaignEx.setRetarget_offer(cursor.getInt(cursor.getColumnIndex("retarget")));
        campaignEx.setCampaignUnitId(cursor.getString(cursor.getColumnIndex("unitid")));
        campaignEx.setNativeVideoTracking(CampaignEx.TrackingStr2Object(cursor.getString(cursor.getColumnIndex("native_ad_tracking"))));
        campaignEx.setNativeVideoTrackingString(cursor.getString(cursor.getColumnIndex("native_ad_tracking")));
        campaignEx.setVideo_end_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.VIDEO_END_TYPE)));
        campaignEx.setendcard_url(cursor.getString(cursor.getColumnIndex(CampaignEx.ENDCARD_URL)));
        campaignEx.setPlayable_ads_without_video(cursor.getInt(cursor.getColumnIndex(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
        campaignEx.setMof_template_url(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL)));
        campaignEx.setMof_tplid(cursor.getInt(cursor.getColumnIndex(CampaignUnit.JSON_KEY_MOF_TPLID)));
        campaignEx.setRewardTemplateMode(CampaignEx.c.a(cursor.getString(cursor.getColumnIndex("reward_teamplate"))));
        campaignEx.setVideoMD5Value(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
        campaignEx.setGifUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GIF_URL)));
        campaignEx.setNvT2(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NV_T2)));
        campaignEx.setClickTimeOutInterval(cursor.getInt(cursor.getColumnIndex("c_coi")));
        campaignEx.setcUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_UA)));
        campaignEx.setImpUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_UA)));
        campaignEx.setJmPd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_JM_PD)));
        campaignEx.setIsDeleted(cursor.getInt(cursor.getColumnIndex("is_deleted")));
        campaignEx.setIsClick(cursor.getInt(cursor.getColumnIndex("is_click")));
        campaignEx.setIsAddSuccesful(cursor.getInt(cursor.getColumnIndex("is_add_sucesful")));
        campaignEx.setIsDownLoadZip(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_IS_DOWNLOAD)));
        campaignEx.setInteractiveCache(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_CACHE)));
        campaignEx.setKeyIaOri(cursor.getInt(cursor.getColumnIndex("ia_ori")));
        campaignEx.setAdType(cursor.getInt(cursor.getColumnIndex("ad_type")));
        campaignEx.setFac(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FAC)));
        campaignEx.setTpOffer(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_TP_OFFER)));
        campaignEx.setIa_ext1(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT1)));
        campaignEx.setIa_ext2(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT2)));
        campaignEx.setKeyIaRst(cursor.getInt(cursor.getColumnIndex("ia_rst")));
        campaignEx.setKeyIaUrl(cursor.getString(cursor.getColumnIndex("ia_url")));
        campaignEx.setKeyIaIcon(cursor.getString(cursor.getColumnIndex("ia_icon")));
        campaignEx.setOc_time(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TIME)));
        campaignEx.setOc_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TYPE)));
        campaignEx.setT_list(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_T_LIST)));
        campaignEx.setGhId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_ID)));
        campaignEx.setGhPath(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_PATH)));
        campaignEx.setBindId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_BIND_ID)));
        String string2 = cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ADCHOICE));
        if (!TextUtils.isEmpty(string2)) {
            campaignEx.setAdchoice(CampaignEx.a.b(string2));
        }
        campaignEx.setAdchoiceSizeHeight(cursor.getInt(cursor.getColumnIndex("adchoice_size_height")));
        campaignEx.setAdchoiceSizeWidth(cursor.getInt(cursor.getColumnIndex("adchoice_size_width")));
        campaignEx.setPlct(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCT)));
        campaignEx.setPlctb(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCTB)));
        campaignEx.setAdZip(cursor.getString(cursor.getColumnIndex("ad_zip")));
        campaignEx.setAdHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_HTML)));
        campaignEx.setBannerUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_URL)));
        campaignEx.setBannerHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_HTML)));
        campaignEx.setCreativeId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_CREATIVE_ID)));
        campaignEx.setVidCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID)));
        campaignEx.setEcCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_CREATIVE_ID)));
        campaignEx.setEcTemplateId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_TEMP_ID)));
        campaignEx.setIsBidCampaign(cursor.getInt(cursor.getColumnIndex("is_bid_campaign")) == 1);
        campaignEx.setBidToken(cursor.getString(cursor.getColumnIndex("bid_token")));
        campaignEx.setMraid(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MRAID)));
        campaignEx.setIsMraid(cursor.getInt(cursor.getColumnIndex("is_mraid_campaign")) == 1);
        campaignEx.setOmid(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_OMID)));
        campaignEx.setReady_rate(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_READY_RATE)));
        campaignEx.setExt_data(cursor.getString(cursor.getColumnIndex("ext_data")));
        campaignEx.setNscpt(cursor.getInt(cursor.getColumnIndex(CampaignUnit.JSON_KEY_NSCPT)));
        campaignEx.setReq_ext_data(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_REQ_EXT_DATA)));
        campaignEx.setReadyState(cursor.getInt(cursor.getColumnIndex("readyState")));
        campaignEx.setLoadTimeoutState(cursor.getInt(cursor.getColumnIndex("load_timeout")));
        campaignEx.setPlacementId(cursor.getString(cursor.getColumnIndex(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER)));
        campaignEx.setMaitve(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVE)));
        campaignEx.setMaitve_src(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVESRC)));
        campaignEx.setFlb(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB)));
        campaignEx.setFlbSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
        campaignEx.setCbd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
        campaignEx.setVst(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
        campaignEx.setAdSpaceT(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
        campaignEx.setVcn(cursor.getInt(cursor.getColumnIndex("vcn")));
        campaignEx.setTokenRule(cursor.getInt(cursor.getColumnIndex("token_r")));
        campaignEx.setEncryptPrice(cursor.getString(cursor.getColumnIndex("encrypt_p")));
        campaignEx.setVideoCheckType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE)));
        campaignEx.setVideoCtnType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE)));
        campaignEx.setRsIgnoreCheckRuleByString(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE)));
        campaignEx.setVideoCompleteTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
        campaignEx.setAabEntity(AabEntity.parser(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AAB))));
        campaignEx.setPrivacyUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_PRIVACY_URL)));
        campaignEx.setPrivacyButtonTemplateVisibility(cursor.getInt(cursor.getColumnIndex("privacy_button_video")));
        campaignEx.setImpReportType(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_REPORT_TYPE));
        return campaignEx;
    }

    public final synchronized void d(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str3 = "unitid = '" + str + "'";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + " AND bid_token != '" + str2 + "'";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            getWritableDatabase().update("campaign", contentValues, (str3 + " AND is_bid_campaign = 1") + " AND bid_token IS NOT NULL", null);
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void e(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String str3 = (TextUtils.isEmpty(str) ? "" : "unitid = '" + str + "' AND ") + "n_local_request_id = '" + str2 + "' AND bid_token IS NOT NULL AND n_local_request_id IS NOT NULL";
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            getWritableDatabase().update("campaign", contentValues, str3, null);
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final synchronized void f(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                String str3 = "unitid = '" + str + "' AND bid_token = '" + str2 + "' AND bid_token IS NOT NULL";
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", (Integer) 2);
                getWritableDatabase().update("campaign", contentValues, str3, null);
            }
        } catch (Exception e) {
            aa.d("CampaignDao", e.getLocalizedMessage());
        }
    }

    public final List<CampaignEx> b(String str, int i, boolean z) throws Throwable {
        ArrayList arrayList;
        String str2;
        Cursor cursor = null;
        arrayList = null;
        ArrayList arrayList2 = null;
        cursor = null;
        try {
            try {
                if (z) {
                    str2 = "placement_id = " + str + " AND ad_type = " + i;
                } else {
                    str2 = "ad_type = " + i;
                }
                Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM campaign WHERE " + str2, null);
                if (cursorRawQuery != null) {
                    try {
                        try {
                            if (cursorRawQuery.getCount() > 0) {
                                arrayList = new ArrayList();
                                while (cursorRawQuery.moveToNext()) {
                                    try {
                                        arrayList.add(a(cursorRawQuery));
                                    } catch (Exception e) {
                                        cursor = cursorRawQuery;
                                        e = e;
                                        aa.d("CampaignDao", e.getLocalizedMessage());
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        return arrayList;
                                    }
                                }
                                arrayList2 = arrayList;
                            }
                        } catch (Throwable th) {
                            cursor = cursorRawQuery;
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        cursor = cursorRawQuery;
                        e = e2;
                        arrayList = null;
                    }
                }
                if (cursorRawQuery == null) {
                    return arrayList2;
                }
                cursorRawQuery.close();
                return arrayList2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
    }
}
