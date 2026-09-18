package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: UnitCacheControllerRefactor.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m {
    private com.mbridge.msdk.videocommon.listener.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f2671b;
    private final Context c;
    private final String d;
    private com.mbridge.msdk.videocommon.d.c e;
    private final int f;
    private final CopyOnWriteArrayList<CampaignEx> g;
    private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.download.a> h;

    public m(List<CampaignEx> list, String str, int i) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.g = copyOnWriteArrayList;
        this.h = new ConcurrentHashMap<>();
        this.c = com.mbridge.msdk.foundation.controller.b.d().g();
        this.d = str;
        this.f = i;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    public m(CampaignEx campaignEx, String str, int i) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.g = copyOnWriteArrayList;
        this.h = new ConcurrentHashMap<>();
        this.c = com.mbridge.msdk.foundation.controller.b.d().g();
        this.d = str;
        this.f = i;
        if (campaignEx != null) {
            copyOnWriteArrayList.add(campaignEx);
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.a = aVar;
    }

    public final void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (this.f2671b == null) {
            this.f2671b = new ConcurrentHashMap<>();
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f2671b.put(str, aVar);
    }

    public final void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                this.g.addAll(list);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b("RewardVideoRefactorManager", this.d + " update error", e);
                }
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                this.g.add(campaignEx);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b("RewardVideoRefactorManager", this.d + " update error", e);
                }
            }
        }
    }

    public final void a() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            aa.a("RewardVideoRefactorManager", this.d + " load campaignExes is null");
            return;
        }
        for (CampaignEx campaignEx : copyOnWriteArrayList) {
            if (campaignEx != null && campaignEx != null) {
                try {
                    String str = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
                    if (!this.h.containsKey(str)) {
                        a(campaignEx, str, (com.mbridge.msdk.videocommon.download.a) null);
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.b("RewardVideoRefactorManager", this.d + " handlerCampaignLoadEvent error", e);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0167 A[Catch: Exception -> 0x01c3, TryCatch #4 {Exception -> 0x01c3, blocks: (B:99:0x015e, B:100:0x0161, B:102:0x0167, B:106:0x0174, B:109:0x017b, B:112:0x0182, B:114:0x0188, B:116:0x0192, B:119:0x01a2, B:121:0x01a8), top: B:200:0x015e }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0171 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:105:0x0172 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:128:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:129:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ba A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:147:0x01cf A[Catch: Exception -> 0x03ac, TryCatch #0 {Exception -> 0x03ac, blocks: (B:13:0x002d, B:145:0x01cb, B:147:0x01cf, B:148:0x01e7, B:156:0x01f7, B:158:0x01fc, B:159:0x01ff, B:161:0x0203, B:163:0x0209, B:164:0x020e, B:168:0x0286, B:183:0x034a), top: B:192:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:150:0x01ed A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:155:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:158:0x01fc A[Catch: Exception -> 0x03ac, TryCatch #0 {Exception -> 0x03ac, blocks: (B:13:0x002d, B:145:0x01cb, B:147:0x01cf, B:148:0x01e7, B:156:0x01f7, B:158:0x01fc, B:159:0x01ff, B:161:0x0203, B:163:0x0209, B:164:0x020e, B:168:0x0286, B:183:0x034a), top: B:192:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0209 A[Catch: Exception -> 0x03ac, TryCatch #0 {Exception -> 0x03ac, blocks: (B:13:0x002d, B:145:0x01cb, B:147:0x01cf, B:148:0x01e7, B:156:0x01f7, B:158:0x01fc, B:159:0x01ff, B:161:0x0203, B:163:0x0209, B:164:0x020e, B:168:0x0286, B:183:0x034a), top: B:192:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:166:0x0283  */
    /* JADX WARN: Code duplicated, block: B:167:0x0285  */
    /* JADX WARN: Code duplicated, block: B:170:0x032e  */
    /* JADX WARN: Code duplicated, block: B:172:0x0331 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:173:0x0333  */
    /* JADX WARN: Code duplicated, block: B:175:0x0336  */
    /* JADX WARN: Code duplicated, block: B:177:0x0339  */
    /* JADX WARN: Code duplicated, block: B:178:0x033c  */
    /* JADX WARN: Code duplicated, block: B:179:0x033f  */
    /* JADX WARN: Code duplicated, block: B:180:0x0342  */
    /* JADX WARN: Code duplicated, block: B:181:0x0345  */
    /* JADX WARN: Code duplicated, block: B:182:0x0348  */
    /* JADX WARN: Code duplicated, block: B:207:0x0203 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x001d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00bf A[Catch: Exception -> 0x01c7, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x01c7, blocks: (B:18:0x0061, B:20:0x006b, B:24:0x0079, B:27:0x0081, B:30:0x0089, B:36:0x009a, B:45:0x00bf, B:50:0x00cd, B:52:0x00d7, B:60:0x00ea, B:62:0x00f4, B:66:0x00ff, B:70:0x010c, B:72:0x0112, B:77:0x0125), top: B:196:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00cd A[Catch: Exception -> 0x01c7, TRY_ENTER, TryCatch #2 {Exception -> 0x01c7, blocks: (B:18:0x0061, B:20:0x006b, B:24:0x0079, B:27:0x0081, B:30:0x0089, B:36:0x009a, B:45:0x00bf, B:50:0x00cd, B:52:0x00d7, B:60:0x00ea, B:62:0x00f4, B:66:0x00ff, B:70:0x010c, B:72:0x0112, B:77:0x0125), top: B:196:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d7 A[Catch: Exception -> 0x01c7, TryCatch #2 {Exception -> 0x01c7, blocks: (B:18:0x0061, B:20:0x006b, B:24:0x0079, B:27:0x0081, B:30:0x0089, B:36:0x009a, B:45:0x00bf, B:50:0x00cd, B:52:0x00d7, B:60:0x00ea, B:62:0x00f4, B:66:0x00ff, B:70:0x010c, B:72:0x0112, B:77:0x0125), top: B:196:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ff A[Catch: Exception -> 0x01c7, TryCatch #2 {Exception -> 0x01c7, blocks: (B:18:0x0061, B:20:0x006b, B:24:0x0079, B:27:0x0081, B:30:0x0089, B:36:0x009a, B:45:0x00bf, B:50:0x00cd, B:52:0x00d7, B:60:0x00ea, B:62:0x00f4, B:66:0x00ff, B:70:0x010c, B:72:0x0112, B:77:0x0125), top: B:196:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x010c A[Catch: Exception -> 0x01c7, TryCatch #2 {Exception -> 0x01c7, blocks: (B:18:0x0061, B:20:0x006b, B:24:0x0079, B:27:0x0081, B:30:0x0089, B:36:0x009a, B:45:0x00bf, B:50:0x00cd, B:52:0x00d7, B:60:0x00ea, B:62:0x00f4, B:66:0x00ff, B:70:0x010c, B:72:0x0112, B:77:0x0125), top: B:196:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0112 A[Catch: Exception -> 0x01c7, TryCatch #2 {Exception -> 0x01c7, blocks: (B:18:0x0061, B:20:0x006b, B:24:0x0079, B:27:0x0081, B:30:0x0089, B:36:0x009a, B:45:0x00bf, B:50:0x00cd, B:52:0x00d7, B:60:0x00ea, B:62:0x00f4, B:66:0x00ff, B:70:0x010c, B:72:0x0112, B:77:0x0125), top: B:196:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0122  */
    /* JADX WARN: Code duplicated, block: B:77:0x0125 A[Catch: Exception -> 0x01c7, TRY_LEAVE, TryCatch #2 {Exception -> 0x01c7, blocks: (B:18:0x0061, B:20:0x006b, B:24:0x0079, B:27:0x0081, B:30:0x0089, B:36:0x009a, B:45:0x00bf, B:50:0x00cd, B:52:0x00d7, B:60:0x00ea, B:62:0x00f4, B:66:0x00ff, B:70:0x010c, B:72:0x0112, B:77:0x0125), top: B:196:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0136  */
    /* JADX WARN: Code duplicated, block: B:84:0x013a  */
    /* JADX WARN: Code duplicated, block: B:85:0x013c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0146 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x0148  */
    /* JADX WARN: Code duplicated, block: B:90:0x014b A[Catch: Exception -> 0x01c5, TryCatch #3 {Exception -> 0x01c5, blocks: (B:86:0x013d, B:91:0x014f, B:90:0x014b), top: B:198:0x013d }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0156  */
    /* JADX WARN: Code duplicated, block: B:95:0x0158  */
    /* JADX WARN: Code duplicated, block: B:97:0x015b A[ADDED_TO_REGION] */
    public final List<com.mbridge.msdk.videocommon.download.a> a(List<CampaignEx> list, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        ArrayList<Integer> rsIgnoreCheckRule;
        boolean z5;
        int iJ;
        String str;
        String strB;
        String str2;
        boolean z6;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            aa.a("RewardVideoRefactorManager", this.d + " isReady campaignExes is null");
            return arrayList;
        }
        int size = list.size();
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null) {
                try {
                    String str3 = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
                    com.mbridge.msdk.videocommon.download.a aVarA = a(campaignEx, str3, this.h.get(str3));
                    if (campaignEx != null && aVarA != null) {
                        boolean z7 = false;
                        boolean z8 = true;
                        try {
                            int loadTimeoutState = campaignEx.getLoadTimeoutState();
                            if (aVarA.d()) {
                                z7 = true;
                                aVarA.d(z7);
                                if (aVarA.b()) {
                                    z2 = true;
                                } else {
                                    if (campaignEx == null) {
                                        str2 = "";
                                    } else {
                                        str2 = campaignEx.getendcard_url();
                                    }
                                    if (a(str2, campaignEx, aVarA)) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                }
                                if (loadTimeoutState == 0) {
                                    aVarA.b(true);
                                }
                                if (aVarA.c()) {
                                    z3 = true;
                                } else {
                                    strB = b(campaignEx);
                                    if (TextUtils.isEmpty(strB)) {
                                        if (!TextUtils.isEmpty(strB) || (aVarA != null && aVarA.c()) || campaignEx.isDynamicView() || !((campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) && campaignEx.getLoadTimeoutState() == 0 && j.a(strB) == null)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    }
                                    if (!TextUtils.isEmpty(strB) || (aVarA != null && aVarA.c()) || campaignEx.isDynamicView() || !((campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) && campaignEx.getLoadTimeoutState() == 0 && j.a(strB) == null)) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                }
                                if (loadTimeoutState == 0) {
                                    aVarA.c(true);
                                }
                                if (aVarA.a()) {
                                    z4 = true;
                                } else {
                                    z4 = true;
                                }
                                aVarA.a(z4);
                                if (z4) {
                                    arrayList.add(aVarA);
                                }
                                if (!MBridgeConstans.DEBUG) {
                                    rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                                    if (rsIgnoreCheckRule == null) {
                                        rsIgnoreCheckRule = new ArrayList<>();
                                    }
                                    StringBuilder sbAppend = new StringBuilder().append(this.d).append("  campaign name = ").append(campaignEx.getAppName()).append("\n\t\tcampaign id = ").append(campaignEx.getId()).append("\n\t\trequest id = ").append(campaignEx.getRequestId()).append("\n\t\tadType = ").append(this.f).append("\n\t\tunitID = ").append(this.d).append("\n\t\tisReady = ").append(z4).append("\n\t\tisDynamicView = ").append(campaignEx.isDynamicView()).append("\n\t\tisTPL = ");
                                    if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                                        z5 = false;
                                    } else {
                                        z5 = true;
                                    }
                                    StringBuilder sbAppend2 = sbAppend.append(z5).append("\n\t\tcurrentSuccessSize = ").append(arrayList.size()).append("\n\t\tisReadyCheckSize = ").append(size).append("\n\t\ttotalCampaignSize = ").append(this.g.size()).append("\n\t\tlinkType = ").append(campaignEx.getLinkType()).append("\n\t\tloadTimeoutState = ").append(campaignEx.getLoadTimeoutState()).append("\n\t\tisVideoReady = ").append(z7).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(0)).append("\n\t\t\treadyRate == ").append(f(campaignEx)).append("\n\t\t\tCDRate = ").append(e()).append("\n\t\t\tdlnet = ").append(f()).append("\n\t\t\tctn = ").append(d(campaignEx)).append("\n\t\t\tdownloadState = ");
                                    iJ = aVarA.j();
                                    if (iJ != 0) {
                                        str = "DOWNLOAD_READY";
                                    } else if (iJ != 1) {
                                        str = "DOWNLOAD_RUN";
                                    } else if (iJ != 2) {
                                        str = "DOWNLOAD_PAUSE";
                                    } else if (iJ != 4) {
                                        str = "DOWNLOAD_STOP";
                                    } else if (iJ != 5) {
                                        str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                                    } else {
                                        str = "DOWNLOAD_DONE";
                                    }
                                    aa.d("RewardVideoRefactorManager", sbAppend2.append(str).append("\n\t\tisTemplateReady = ").append(z3).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(1)).append("\n\t\tisEndCardReady = ").append(z2).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(2)).append("\n\t\t\tisOnlyPlayable = ").append(e(campaignEx)).append("\n\t\t\tisPlayableEndCard(dynamicView) = ").append(af.j(campaignEx.getendcard_url())).toString());
                                }
                            } else {
                                int iF = f(campaignEx);
                                int iF2 = f();
                                if (aVarA == null || campaignEx == null) {
                                    z8 = false;
                                    if (z8) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    try {
                                        aVarA.d(z7);
                                        if (aVarA.b()) {
                                            z2 = true;
                                        } else {
                                            if (campaignEx == null) {
                                                str2 = "";
                                            } else {
                                                str2 = campaignEx.getendcard_url();
                                            }
                                            if (a(str2, campaignEx, aVarA)) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                        }
                                        if (loadTimeoutState == 0 && z2) {
                                            try {
                                                aVarA.b(true);
                                            } catch (Exception e) {
                                                e = e;
                                                z3 = false;
                                                if (MBridgeConstans.DEBUG) {
                                                    aa.b("RewardVideoRefactorManager", this.d + " checkResourceReadyState error", e);
                                                }
                                                if (aVarA.a()) {
                                                    z4 = true;
                                                } else {
                                                    z4 = true;
                                                }
                                                aVarA.a(z4);
                                                if (z4) {
                                                    arrayList.add(aVarA);
                                                }
                                                if (!MBridgeConstans.DEBUG) {
                                                    rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                                                    if (rsIgnoreCheckRule == null) {
                                                        rsIgnoreCheckRule = new ArrayList<>();
                                                    }
                                                    StringBuilder sbAppend3 = new StringBuilder().append(this.d).append("  campaign name = ").append(campaignEx.getAppName()).append("\n\t\tcampaign id = ").append(campaignEx.getId()).append("\n\t\trequest id = ").append(campaignEx.getRequestId()).append("\n\t\tadType = ").append(this.f).append("\n\t\tunitID = ").append(this.d).append("\n\t\tisReady = ").append(z4).append("\n\t\tisDynamicView = ").append(campaignEx.isDynamicView()).append("\n\t\tisTPL = ");
                                                    if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    StringBuilder sbAppend4 = sbAppend3.append(z5).append("\n\t\tcurrentSuccessSize = ").append(arrayList.size()).append("\n\t\tisReadyCheckSize = ").append(size).append("\n\t\ttotalCampaignSize = ").append(this.g.size()).append("\n\t\tlinkType = ").append(campaignEx.getLinkType()).append("\n\t\tloadTimeoutState = ").append(campaignEx.getLoadTimeoutState()).append("\n\t\tisVideoReady = ").append(z7).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(0)).append("\n\t\t\treadyRate == ").append(f(campaignEx)).append("\n\t\t\tCDRate = ").append(e()).append("\n\t\t\tdlnet = ").append(f()).append("\n\t\t\tctn = ").append(d(campaignEx)).append("\n\t\t\tdownloadState = ");
                                                    iJ = aVarA.j();
                                                    if (iJ != 0) {
                                                        str = "DOWNLOAD_READY";
                                                    } else if (iJ != 1) {
                                                        str = "DOWNLOAD_RUN";
                                                    } else if (iJ != 2) {
                                                        str = "DOWNLOAD_PAUSE";
                                                    } else if (iJ != 4) {
                                                        str = "DOWNLOAD_STOP";
                                                    } else if (iJ != 5) {
                                                        str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                                                    } else {
                                                        str = "DOWNLOAD_DONE";
                                                    }
                                                    aa.d("RewardVideoRefactorManager", sbAppend4.append(str).append("\n\t\tisTemplateReady = ").append(z3).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(1)).append("\n\t\tisEndCardReady = ").append(z2).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(2)).append("\n\t\t\tisOnlyPlayable = ").append(e(campaignEx)).append("\n\t\t\tisPlayableEndCard(dynamicView) = ").append(af.j(campaignEx.getendcard_url())).toString());
                                                }
                                            }
                                        }
                                        if (aVarA.c()) {
                                            strB = b(campaignEx);
                                            if (!TextUtils.isEmpty(strB) || (aVarA != null && aVarA.c()) || campaignEx.isDynamicView() || !((campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) && campaignEx.getLoadTimeoutState() == 0 && j.a(strB) == null)) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                        } else {
                                            z3 = true;
                                        }
                                        if (loadTimeoutState == 0 && z3) {
                                            try {
                                                aVarA.c(true);
                                            } catch (Exception e2) {
                                                e = e2;
                                                if (MBridgeConstans.DEBUG) {
                                                    aa.b("RewardVideoRefactorManager", this.d + " checkResourceReadyState error", e);
                                                }
                                            }
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        z2 = false;
                                        z3 = false;
                                        if (MBridgeConstans.DEBUG) {
                                            aa.b("RewardVideoRefactorManager", this.d + " checkResourceReadyState error", e);
                                        }
                                        if (aVarA.a()) {
                                            z4 = true;
                                        } else {
                                            z4 = true;
                                        }
                                        aVarA.a(z4);
                                        if (z4) {
                                            arrayList.add(aVarA);
                                        }
                                        if (!MBridgeConstans.DEBUG) {
                                            rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                                            if (rsIgnoreCheckRule == null) {
                                                rsIgnoreCheckRule = new ArrayList<>();
                                            }
                                            StringBuilder sbAppend5 = new StringBuilder().append(this.d).append("  campaign name = ").append(campaignEx.getAppName()).append("\n\t\tcampaign id = ").append(campaignEx.getId()).append("\n\t\trequest id = ").append(campaignEx.getRequestId()).append("\n\t\tadType = ").append(this.f).append("\n\t\tunitID = ").append(this.d).append("\n\t\tisReady = ").append(z4).append("\n\t\tisDynamicView = ").append(campaignEx.isDynamicView()).append("\n\t\tisTPL = ");
                                            if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                                                z5 = true;
                                            } else {
                                                z5 = false;
                                            }
                                            StringBuilder sbAppend6 = sbAppend5.append(z5).append("\n\t\tcurrentSuccessSize = ").append(arrayList.size()).append("\n\t\tisReadyCheckSize = ").append(size).append("\n\t\ttotalCampaignSize = ").append(this.g.size()).append("\n\t\tlinkType = ").append(campaignEx.getLinkType()).append("\n\t\tloadTimeoutState = ").append(campaignEx.getLoadTimeoutState()).append("\n\t\tisVideoReady = ").append(z7).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(0)).append("\n\t\t\treadyRate == ").append(f(campaignEx)).append("\n\t\t\tCDRate = ").append(e()).append("\n\t\t\tdlnet = ").append(f()).append("\n\t\t\tctn = ").append(d(campaignEx)).append("\n\t\t\tdownloadState = ");
                                            iJ = aVarA.j();
                                            if (iJ != 0) {
                                                str = "DOWNLOAD_READY";
                                            } else if (iJ != 1) {
                                                str = "DOWNLOAD_RUN";
                                            } else if (iJ != 2) {
                                                str = "DOWNLOAD_PAUSE";
                                            } else if (iJ != 4) {
                                                str = "DOWNLOAD_STOP";
                                            } else if (iJ != 5) {
                                                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                                            } else {
                                                str = "DOWNLOAD_DONE";
                                            }
                                            aa.d("RewardVideoRefactorManager", sbAppend6.append(str).append("\n\t\tisTemplateReady = ").append(z3).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(1)).append("\n\t\tisEndCardReady = ").append(z2).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(2)).append("\n\t\t\tisOnlyPlayable = ").append(e(campaignEx)).append("\n\t\t\tisPlayableEndCard(dynamicView) = ").append(af.j(campaignEx.getendcard_url())).toString());
                                        }
                                    }
                                    if (aVarA.a() || (z7 && z2 && z3)) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    aVarA.a(z4);
                                    if (z4) {
                                        arrayList.add(aVarA);
                                    }
                                    if (!MBridgeConstans.DEBUG) {
                                        rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                                        if (rsIgnoreCheckRule == null) {
                                            rsIgnoreCheckRule = new ArrayList<>();
                                        }
                                        StringBuilder sbAppend7 = new StringBuilder().append(this.d).append("  campaign name = ").append(campaignEx.getAppName()).append("\n\t\tcampaign id = ").append(campaignEx.getId()).append("\n\t\trequest id = ").append(campaignEx.getRequestId()).append("\n\t\tadType = ").append(this.f).append("\n\t\tunitID = ").append(this.d).append("\n\t\tisReady = ").append(z4).append("\n\t\tisDynamicView = ").append(campaignEx.isDynamicView()).append("\n\t\tisTPL = ");
                                        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        StringBuilder sbAppend8 = sbAppend7.append(z5).append("\n\t\tcurrentSuccessSize = ").append(arrayList.size()).append("\n\t\tisReadyCheckSize = ").append(size).append("\n\t\ttotalCampaignSize = ").append(this.g.size()).append("\n\t\tlinkType = ").append(campaignEx.getLinkType()).append("\n\t\tloadTimeoutState = ").append(campaignEx.getLoadTimeoutState()).append("\n\t\tisVideoReady = ").append(z7).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(0)).append("\n\t\t\treadyRate == ").append(f(campaignEx)).append("\n\t\t\tCDRate = ").append(e()).append("\n\t\t\tdlnet = ").append(f()).append("\n\t\t\tctn = ").append(d(campaignEx)).append("\n\t\t\tdownloadState = ");
                                        iJ = aVarA.j();
                                        if (iJ != 0) {
                                            str = "DOWNLOAD_READY";
                                        } else if (iJ != 1) {
                                            str = "DOWNLOAD_RUN";
                                        } else if (iJ != 2) {
                                            str = "DOWNLOAD_PAUSE";
                                        } else if (iJ != 4) {
                                            str = "DOWNLOAD_STOP";
                                        } else if (iJ != 5) {
                                            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                                        } else {
                                            str = "DOWNLOAD_DONE";
                                        }
                                        aa.d("RewardVideoRefactorManager", sbAppend8.append(str).append("\n\t\tisTemplateReady = ").append(z3).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(1)).append("\n\t\tisEndCardReady = ").append(z2).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(2)).append("\n\t\t\tisOnlyPlayable = ").append(e(campaignEx)).append("\n\t\t\tisPlayableEndCard(dynamicView) = ").append(af.j(campaignEx.getendcard_url())).toString());
                                    }
                                } else {
                                    if (!aVarA.d() && !e(campaignEx) && !TextUtils.isEmpty(aVarA.e()) && iF2 != 3) {
                                        if (campaignEx.getRsIgnoreCheckRule() != null) {
                                            try {
                                                if (campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                    if (campaignEx.getIsTimeoutCheckVideoStatus() == 1 || campaignEx.getVideoCheckType() != 1) {
                                                        long jL = aVarA.l();
                                                        long jI = aVarA.i();
                                                        if (z || campaignEx.getVideoCheckType() != 1) {
                                                            if (aVarA != null || TextUtils.isEmpty(aVarA.e())) {
                                                                z8 = true;
                                                            } else if (iF == 0) {
                                                                if (aVarA.k() != null || TextUtils.isEmpty(aVarA.k().getVideoUrlEncode())) {
                                                                    z6 = false;
                                                                } else {
                                                                    z6 = true;
                                                                }
                                                                z8 = z6;
                                                            } else if (Utils.getDownloadRate(aVarA.i(), aVarA.l()) >= iF) {
                                                                z8 = true;
                                                            } else {
                                                                z8 = false;
                                                            }
                                                        } else if (iF != 0) {
                                                            if (jI != 0 || jL != 0) {
                                                                if (jL >= ((long) (iF / 100)) * jI) {
                                                                    campaignEx.setIsTimeoutCheckVideoStatus(1);
                                                                }
                                                                z8 = true;
                                                            }
                                                            if (aVarA != null) {
                                                                z8 = true;
                                                            } else if (iF == 0) {
                                                                if (aVarA.k() != null) {
                                                                    z6 = false;
                                                                } else {
                                                                    z6 = false;
                                                                }
                                                                z8 = z6;
                                                            } else if (Utils.getDownloadRate(aVarA.i(), aVarA.l()) >= iF) {
                                                                z8 = true;
                                                            } else {
                                                                z8 = false;
                                                            }
                                                        }
                                                    }
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                z2 = false;
                                                z3 = false;
                                                if (MBridgeConstans.DEBUG) {
                                                    aa.b("RewardVideoRefactorManager", this.d + " checkResourceReadyState error", e);
                                                }
                                                if (aVarA.a()) {
                                                    z4 = true;
                                                } else {
                                                    z4 = true;
                                                }
                                                aVarA.a(z4);
                                                if (z4) {
                                                    arrayList.add(aVarA);
                                                }
                                                if (!MBridgeConstans.DEBUG) {
                                                    rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                                                    if (rsIgnoreCheckRule == null) {
                                                        rsIgnoreCheckRule = new ArrayList<>();
                                                    }
                                                    StringBuilder sbAppend9 = new StringBuilder().append(this.d).append("  campaign name = ").append(campaignEx.getAppName()).append("\n\t\tcampaign id = ").append(campaignEx.getId()).append("\n\t\trequest id = ").append(campaignEx.getRequestId()).append("\n\t\tadType = ").append(this.f).append("\n\t\tunitID = ").append(this.d).append("\n\t\tisReady = ").append(z4).append("\n\t\tisDynamicView = ").append(campaignEx.isDynamicView()).append("\n\t\tisTPL = ");
                                                    if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    StringBuilder sbAppend10 = sbAppend9.append(z5).append("\n\t\tcurrentSuccessSize = ").append(arrayList.size()).append("\n\t\tisReadyCheckSize = ").append(size).append("\n\t\ttotalCampaignSize = ").append(this.g.size()).append("\n\t\tlinkType = ").append(campaignEx.getLinkType()).append("\n\t\tloadTimeoutState = ").append(campaignEx.getLoadTimeoutState()).append("\n\t\tisVideoReady = ").append(z7).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(0)).append("\n\t\t\treadyRate == ").append(f(campaignEx)).append("\n\t\t\tCDRate = ").append(e()).append("\n\t\t\tdlnet = ").append(f()).append("\n\t\t\tctn = ").append(d(campaignEx)).append("\n\t\t\tdownloadState = ");
                                                    iJ = aVarA.j();
                                                    if (iJ != 0) {
                                                        str = "DOWNLOAD_READY";
                                                    } else if (iJ != 1) {
                                                        str = "DOWNLOAD_RUN";
                                                    } else if (iJ != 2) {
                                                        str = "DOWNLOAD_PAUSE";
                                                    } else if (iJ != 4) {
                                                        str = "DOWNLOAD_STOP";
                                                    } else if (iJ != 5) {
                                                        str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                                                    } else {
                                                        str = "DOWNLOAD_DONE";
                                                    }
                                                    aa.d("RewardVideoRefactorManager", sbAppend10.append(str).append("\n\t\tisTemplateReady = ").append(z3).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(1)).append("\n\t\tisEndCardReady = ").append(z2).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(2)).append("\n\t\t\tisOnlyPlayable = ").append(e(campaignEx)).append("\n\t\t\tisPlayableEndCard(dynamicView) = ").append(af.j(campaignEx.getendcard_url())).toString());
                                                }
                                            }
                                        } else if (campaignEx.getIsTimeoutCheckVideoStatus() == 1) {
                                            long jL2 = aVarA.l();
                                            long jI2 = aVarA.i();
                                            if (z) {
                                                if (aVarA != null) {
                                                    z8 = true;
                                                } else if (iF == 0) {
                                                    if (aVarA.k() != null) {
                                                        z6 = false;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                    z8 = z6;
                                                } else if (Utils.getDownloadRate(aVarA.i(), aVarA.l()) >= iF) {
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                            } else if (aVarA != null) {
                                                z8 = true;
                                            } else if (iF == 0) {
                                                if (aVarA.k() != null) {
                                                    z6 = false;
                                                } else {
                                                    z6 = false;
                                                }
                                                z8 = z6;
                                            } else if (Utils.getDownloadRate(aVarA.i(), aVarA.l()) >= iF) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                        } else {
                                            long jL3 = aVarA.l();
                                            long jI3 = aVarA.i();
                                            if (z) {
                                                if (aVarA != null) {
                                                    z8 = true;
                                                } else if (iF == 0) {
                                                    if (aVarA.k() != null) {
                                                        z6 = false;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                    z8 = z6;
                                                } else if (Utils.getDownloadRate(aVarA.i(), aVarA.l()) >= iF) {
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                            } else if (aVarA != null) {
                                                z8 = true;
                                            } else if (iF == 0) {
                                                if (aVarA.k() != null) {
                                                    z6 = false;
                                                } else {
                                                    z6 = false;
                                                }
                                                z8 = z6;
                                            } else if (Utils.getDownloadRate(aVarA.i(), aVarA.l()) >= iF) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                        }
                                    }
                                    if (z8) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    aVarA.d(z7);
                                    if (aVarA.b()) {
                                        z2 = true;
                                    } else {
                                        if (campaignEx == null) {
                                            str2 = "";
                                        } else {
                                            str2 = campaignEx.getendcard_url();
                                        }
                                        if (a(str2, campaignEx, aVarA)) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                    }
                                    if (loadTimeoutState == 0) {
                                        aVarA.b(true);
                                    }
                                    if (aVarA.c()) {
                                        strB = b(campaignEx);
                                        if (TextUtils.isEmpty(strB)) {
                                            if (!TextUtils.isEmpty(strB) || (aVarA != null && aVarA.c()) || campaignEx.isDynamicView() || !((campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) && campaignEx.getLoadTimeoutState() == 0 && j.a(strB) == null)) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                        }
                                        if (!TextUtils.isEmpty(strB) || (aVarA != null && aVarA.c()) || campaignEx.isDynamicView() || !((campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) && campaignEx.getLoadTimeoutState() == 0 && j.a(strB) == null)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (loadTimeoutState == 0) {
                                        aVarA.c(true);
                                    }
                                    if (aVarA.a()) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    aVarA.a(z4);
                                    if (z4) {
                                        arrayList.add(aVarA);
                                    }
                                    if (!MBridgeConstans.DEBUG) {
                                        rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                                        if (rsIgnoreCheckRule == null) {
                                            rsIgnoreCheckRule = new ArrayList<>();
                                        }
                                        StringBuilder sbAppend11 = new StringBuilder().append(this.d).append("  campaign name = ").append(campaignEx.getAppName()).append("\n\t\tcampaign id = ").append(campaignEx.getId()).append("\n\t\trequest id = ").append(campaignEx.getRequestId()).append("\n\t\tadType = ").append(this.f).append("\n\t\tunitID = ").append(this.d).append("\n\t\tisReady = ").append(z4).append("\n\t\tisDynamicView = ").append(campaignEx.isDynamicView()).append("\n\t\tisTPL = ");
                                        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        StringBuilder sbAppend12 = sbAppend11.append(z5).append("\n\t\tcurrentSuccessSize = ").append(arrayList.size()).append("\n\t\tisReadyCheckSize = ").append(size).append("\n\t\ttotalCampaignSize = ").append(this.g.size()).append("\n\t\tlinkType = ").append(campaignEx.getLinkType()).append("\n\t\tloadTimeoutState = ").append(campaignEx.getLoadTimeoutState()).append("\n\t\tisVideoReady = ").append(z7).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(0)).append("\n\t\t\treadyRate == ").append(f(campaignEx)).append("\n\t\t\tCDRate = ").append(e()).append("\n\t\t\tdlnet = ").append(f()).append("\n\t\t\tctn = ").append(d(campaignEx)).append("\n\t\t\tdownloadState = ");
                                        iJ = aVarA.j();
                                        if (iJ != 0) {
                                            str = "DOWNLOAD_READY";
                                        } else if (iJ != 1) {
                                            str = "DOWNLOAD_RUN";
                                        } else if (iJ != 2) {
                                            str = "DOWNLOAD_PAUSE";
                                        } else if (iJ != 4) {
                                            str = "DOWNLOAD_STOP";
                                        } else if (iJ != 5) {
                                            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                                        } else {
                                            str = "DOWNLOAD_DONE";
                                        }
                                        aa.d("RewardVideoRefactorManager", sbAppend12.append(str).append("\n\t\tisTemplateReady = ").append(z3).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(1)).append("\n\t\tisEndCardReady = ").append(z2).append("\n\t\t\tisIgnore = ").append(rsIgnoreCheckRule.contains(2)).append("\n\t\t\tisOnlyPlayable = ").append(e(campaignEx)).append("\n\t\t\tisPlayableEndCard(dynamicView) = ").append(af.j(campaignEx.getendcard_url())).toString());
                                    }
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            z7 = false;
                        }
                    }
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        aa.b("RewardVideoRefactorManager", this.d + " isReady error", e6);
                    }
                }
            }
        }
        return arrayList;
    }

    private com.mbridge.msdk.videocommon.download.a a(CampaignEx campaignEx, String str, com.mbridge.msdk.videocommon.download.a aVar) {
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.videocommon.download.a aVarC = c(campaignEx);
        aVarC.m();
        this.h.put(str, aVarC);
        return aVarC;
    }

    private String b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return "";
        }
        try {
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                return rewardTemplateMode.e();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.b("RewardVideoRefactorManager", this.d + " getVideoTemplateUrl error", e);
            }
        }
        return "";
    }

    public final com.mbridge.msdk.videocommon.download.a b() {
        List<com.mbridge.msdk.videocommon.download.a> listA;
        if (this.g.size() == 0) {
            aa.a("RewardVideoRefactorManager", this.d + " isReady campaignExes is null");
            return null;
        }
        try {
            listA = a((List<CampaignEx>) this.g, false);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.b("RewardVideoRefactorManager", this.d + " isReady error", e);
            }
            listA = null;
        }
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        return listA.get(0);
    }

    private com.mbridge.msdk.videocommon.download.a c(CampaignEx campaignEx) {
        com.mbridge.msdk.videocommon.download.a aVar = null;
        try {
            com.mbridge.msdk.videocommon.download.a aVar2 = new com.mbridge.msdk.videocommon.download.a(this.c, campaignEx, this.d, f());
            try {
                aVar2.a(campaignEx);
                aVar2.d(this.f);
                aVar2.c(f(campaignEx));
                aVar2.b(e());
                aVar2.e(d(campaignEx));
                aVar2.a((d) null);
                aVar2.a(new a(this.d, this.f2671b, this.a));
                return aVar2;
            } catch (Exception e) {
                e = e;
                aVar = aVar2;
                if (MBridgeConstans.DEBUG) {
                    aa.a("RewardVideoRefactorManager", this.d + " createAndStartCampaignDownloadTask error " + e.getMessage());
                }
                return aVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private com.mbridge.msdk.videocommon.d.c c(String str) {
        try {
            if (this.e == null) {
                this.e = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), str, this.f == 287);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.a("RewardVideoRefactorManager", this.d + " getRewardUnitSetting error " + e.getMessage());
            }
        }
        return this.e;
    }

    private int d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 1;
        }
        try {
            return campaignEx.getVideoCtnType();
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return 1;
            }
            aa.a("RewardVideoRefactorManager", this.d + " getVideoCtnType error " + e.getMessage());
            return 1;
        }
    }

    private boolean a(String str, CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar) {
        boolean zB;
        if (campaignEx != null && aVar != null) {
            try {
                if (aVar.b()) {
                    aa.a("RewardVideoRefactorManager", this.d + " checkEndCardZipOrSourceDownLoad endCard download success");
                    return true;
                }
                if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                    return true;
                }
                if ((campaignEx.isDynamicView() && !af.j(str)) || ak.a(str)) {
                    return true;
                }
                if (campaignEx == null) {
                    zB = false;
                } else {
                    zB = (campaignEx.isMraid() || TextUtils.isEmpty(str) || (campaignEx.getLoadTimeoutState() == 1 && !e(campaignEx)) || ((campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) || ak.b(j.a(str)))) ? true : ak.b(j.b(str));
                }
                if (zB) {
                    return true;
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    aa.a("RewardVideoRefactorManager", this.d + " checkEndCardDownload error " + th.getMessage());
                }
            }
        }
        return false;
    }

    public final com.mbridge.msdk.videocommon.download.a c() {
        try {
            return b();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            aa.d("RewardVideoRefactorManager", this.d + " getCampaignDownLoadTask error:" + th.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.videocommon.download.a a(String str) {
        if (!TextUtils.isEmpty(str) && this.h.containsKey(str)) {
            return this.h.get(str);
        }
        return null;
    }

    public final CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> d() {
        try {
            CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(this.h);
            return copyOnWriteArrayList;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            aa.d("RewardVideoRefactorManager", this.d + " getCampaignDownLoadTaskList error:" + e.getMessage());
            return null;
        }
    }

    private boolean e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            aa.a("RewardVideoRefactorManager", this.d + " isPlayerAbleAds error:" + th.getMessage());
            return false;
        }
    }

    public final void b(String str) {
        com.mbridge.msdk.videocommon.download.a aVarRemove;
        CampaignEx campaignExK;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (!this.h.containsKey(str) || (aVarRemove = this.h.remove(str)) == null || (campaignExK = aVarRemove.k()) == null) {
                return;
            }
            this.g.remove(campaignExK);
            if (MBridgeConstans.DEBUG) {
                aa.a("RewardVideoRefactorManager", this.d + " removeCampaignDownloadTask campaign name: " + campaignExK.getAppName());
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.d("RewardVideoRefactorManager", this.d + " removeCampaignDownloadTask error:" + e.getMessage());
            }
        }
    }

    private int f(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return g();
    }

    private int g() {
        try {
            return c(this.d).r();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            aa.a("RewardVideoRefactorManager", this.d + " getRewardReadyRate error:" + th.getMessage());
            return 100;
        }
    }

    /* JADX INFO: compiled from: UnitCacheControllerRefactor.java */
    private static final class a implements com.mbridge.msdk.videocommon.listener.a {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f2672b;
        private final com.mbridge.msdk.videocommon.listener.a c;

        public a(String str, ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap, com.mbridge.msdk.videocommon.listener.a aVar) {
            this.a = str;
            this.f2672b = concurrentHashMap;
            this.c = aVar;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.c;
            if (aVar != null) {
                try {
                    aVar.a(str);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardVideoRefactorManager", this.a + " videoDownloadListener onDownLoadDone error: " + e.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f2672b;
            if (concurrentHashMap != null) {
                Iterator<com.mbridge.msdk.videocommon.listener.a> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("RewardVideoRefactorManager", this.a + " videoDownloadListener onDownLoadDone error: " + e2.getMessage());
                        }
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.c;
            if (aVar != null) {
                try {
                    aVar.a(str, str2);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardVideoRefactorManager", this.a + " videoDownloadListener onDownLoadFailed error: " + e.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f2672b;
            if (concurrentHashMap != null) {
                Iterator<com.mbridge.msdk.videocommon.listener.a> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str, str2);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("RewardVideoRefactorManager", this.a + " videoDownloadListener onDownLoadFailed error: " + e2.getMessage());
                        }
                    }
                }
            }
        }
    }

    private int e() {
        com.mbridge.msdk.videocommon.d.c cVarC = c(this.d);
        if (cVarC == null) {
            return 0;
        }
        try {
            return cVarC.s();
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return 0;
            }
            aa.a("RewardVideoRefactorManager", this.d + " getCDRate error " + e.getMessage());
            return 0;
        }
    }

    private int f() {
        if (TextUtils.isEmpty(this.d)) {
            return 1;
        }
        try {
            com.mbridge.msdk.videocommon.d.c cVarC = c(this.d);
            if (cVarC != null) {
                return cVarC.w();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.a("RewardVideoRefactorManager", this.d + " getDlnet error " + e.getMessage());
            }
        }
        return 1;
    }
}
