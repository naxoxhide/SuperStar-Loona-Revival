package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ak;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: VideoReportDataDao.java */
/* JADX INFO: loaded from: classes4.dex */
public class q extends a<com.mbridge.msdk.foundation.entity.n> {
    private static final String a = "com.mbridge.msdk.foundation.db.q";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static q f2080b;

    private q(g gVar) {
        super(gVar);
    }

    public static synchronized q a(g gVar) {
        if (f2080b == null) {
            f2080b = new q(gVar);
        }
        return f2080b;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0348 A[Catch: Exception -> 0x0354, all -> 0x0357, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x0354, blocks: (B:101:0x0348, B:93:0x0331), top: B:120:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0350 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x02d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x02db  */
    public final synchronized List<com.mbridge.msdk.foundation.entity.n> a(String str) {
        Cursor cursor;
        Cursor cursorQuery;
        Cursor cursor2;
        com.mbridge.msdk.foundation.entity.n nVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        Cursor cursor3;
        com.mbridge.msdk.foundation.entity.n nVar2;
        String str2 = str;
        synchronized (this) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        cursorQuery = getReadableDatabase().query("reward_report", null, "key=?", new String[]{str2}, null, null, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.getCount() > 0) {
                                    ArrayList arrayList3 = new ArrayList();
                                    while (cursorQuery.moveToNext()) {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(SDKConstants.PARAM_KEY));
                                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("networkType"));
                                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("network_str"));
                                        cursorQuery.getInt(cursorQuery.getColumnIndex("isCompleteView"));
                                        cursorQuery.getInt(cursorQuery.getColumnIndex("watchedMillis"));
                                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("videoLength"));
                                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("offerUrl"));
                                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("reason"));
                                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("result"));
                                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("duration"));
                                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("videoSize"));
                                        String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("campaignId"));
                                        String string7 = cursorQuery.getString(cursorQuery.getColumnIndex("video_url"));
                                        String string8 = cursorQuery.getString(cursorQuery.getColumnIndex("unitId"));
                                        String string9 = cursorQuery.getString(cursorQuery.getColumnIndex("rid"));
                                        String string10 = cursorQuery.getString(cursorQuery.getColumnIndex("rid_n"));
                                        String string11 = cursorQuery.getString(cursorQuery.getColumnIndex("ad_type"));
                                        String string12 = cursorQuery.getString(cursorQuery.getColumnIndex("resource_type"));
                                        String string13 = cursorQuery.getString(cursorQuery.getColumnIndex("device_id"));
                                        String string14 = cursorQuery.getString(cursorQuery.getColumnIndex("creative"));
                                        int i5 = cursorQuery.getInt(cursorQuery.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T));
                                        if (str2.equals("2000021")) {
                                            try {
                                                try {
                                                    nVar = new com.mbridge.msdk.foundation.entity.n(string, i, string3, string4, string2);
                                                    nVar.q(string6);
                                                    nVar.e(string7);
                                                    nVar.m(string9);
                                                    nVar.o(string10);
                                                    nVar.p(string8);
                                                    cursor2 = cursorQuery;
                                                    arrayList = arrayList3;
                                                    if (nVar != null) {
                                                        try {
                                                            arrayList2 = arrayList;
                                                            arrayList2.add(nVar);
                                                        } catch (Exception e) {
                                                            e = e;
                                                            cursorQuery = cursor2;
                                                            e.printStackTrace();
                                                            aa.d(a, e.getMessage());
                                                            if (cursorQuery != null) {
                                                                cursorQuery.close();
                                                            }
                                                            return null;
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            cursor = cursor2;
                                                            if (cursor != null) {
                                                                try {
                                                                    cursor.close();
                                                                } catch (Exception unused) {
                                                                }
                                                            }
                                                            throw th;
                                                        }
                                                    } else {
                                                        arrayList2 = arrayList;
                                                    }
                                                    getWritableDatabase().delete("reward_report", "id = ?", new String[]{cursor2.getInt(cursor2.getColumnIndex("id")) + ""});
                                                    arrayList3 = arrayList2;
                                                    cursorQuery = cursor2;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    cursor = cursorQuery;
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                e.printStackTrace();
                                                aa.d(a, e.getMessage());
                                                if (cursorQuery != null) {
                                                    cursorQuery.close();
                                                }
                                                return null;
                                            }
                                        } else {
                                            if (str2.equals("2000022")) {
                                                arrayList = arrayList3;
                                                nVar = new com.mbridge.msdk.foundation.entity.n(string, i, i2, string3, i3, string5, i4, string2);
                                                nVar.q(string6);
                                                nVar.e(string7);
                                                nVar.m(string9);
                                                nVar.o(string10);
                                                nVar.p(string8);
                                                nVar.s(string4);
                                                nVar.h(string11);
                                            } else {
                                                arrayList = arrayList3;
                                                if (str2.equals("2000025")) {
                                                    nVar = new com.mbridge.msdk.foundation.entity.n(string, i, i2, string3, i3, string5, i4, string2);
                                                } else if (str2.equals("2000024")) {
                                                    nVar = new com.mbridge.msdk.foundation.entity.n(string, i, string3, string4, string2);
                                                } else {
                                                    if ("2000039".equals(str2)) {
                                                        nVar = new com.mbridge.msdk.foundation.entity.n(cursorQuery.getString(cursorQuery.getColumnIndex("h5_click_data")));
                                                    } else {
                                                        if ("2000043".equals(str2)) {
                                                            try {
                                                                cursor3 = cursorQuery;
                                                                nVar = nVar2;
                                                                try {
                                                                    nVar2 = new com.mbridge.msdk.foundation.entity.n(str, i3, string5, cursorQuery.getString(cursorQuery.getColumnIndex(CampaignEx.ENDCARD_URL)), string6, string8, string4, cursorQuery.getString(cursorQuery.getColumnIndex("type")));
                                                                    nVar.m(string9);
                                                                    nVar.o(string10);
                                                                    if (!TextUtils.isEmpty(string6)) {
                                                                        nVar.q(string6);
                                                                    }
                                                                    nVar.c(i5);
                                                                    nVar.h(string11);
                                                                    nVar.a(string12);
                                                                    nVar.b(string13);
                                                                    nVar.c(string14);
                                                                    str2 = str;
                                                                    cursor2 = cursor3;
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    cursorQuery = cursor3;
                                                                } catch (Throwable th3) {
                                                                    th = th3;
                                                                    cursor = cursor3;
                                                                    if (cursor != null) {
                                                                        cursor.close();
                                                                    }
                                                                    throw th;
                                                                }
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                cursor3 = cursorQuery;
                                                            }
                                                        } else {
                                                            Cursor cursor4 = cursorQuery;
                                                            try {
                                                                str2 = str;
                                                                if ("2000045".equals(str2)) {
                                                                    nVar = new com.mbridge.msdk.foundation.entity.n();
                                                                    nVar.r(str2);
                                                                    nVar.d(i);
                                                                    nVar.e(i3);
                                                                    nVar.q(string6);
                                                                    cursor2 = cursor4;
                                                                    nVar.i(cursor2.getString(cursor2.getColumnIndex("template_url")));
                                                                    nVar.s(string4);
                                                                    nVar.m(string9);
                                                                    nVar.o(string10);
                                                                    nVar.p(string8);
                                                                } else {
                                                                    cursor2 = cursor4;
                                                                    if ("2000044".equals(str2)) {
                                                                        nVar = new com.mbridge.msdk.foundation.entity.n();
                                                                        nVar.r(str2);
                                                                        nVar.d(i);
                                                                        nVar.q(string6);
                                                                        nVar.d(cursor2.getString(cursor2.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_URL)));
                                                                        nVar.s(string4);
                                                                        nVar.m(string9);
                                                                        nVar.o(string10);
                                                                        nVar.p(string8);
                                                                    } else if ("2000054".equals(str2)) {
                                                                        nVar = new com.mbridge.msdk.foundation.entity.n();
                                                                        nVar.r(str2);
                                                                        nVar.a(string12);
                                                                        nVar.p(string8);
                                                                        nVar.b(string13);
                                                                        nVar.h(string11);
                                                                        nVar.q(string6);
                                                                        nVar.m(string9);
                                                                        nVar.o(string10);
                                                                        nVar.e(i3);
                                                                        nVar.s(string4);
                                                                        nVar.d(i);
                                                                        nVar.c(string14);
                                                                        nVar.c(i5);
                                                                    } else {
                                                                        nVar = null;
                                                                    }
                                                                }
                                                            } catch (Exception e5) {
                                                                e = e5;
                                                                cursor2 = cursor4;
                                                                cursorQuery = cursor2;
                                                                e.printStackTrace();
                                                                aa.d(a, e.getMessage());
                                                                if (cursorQuery != null) {
                                                                    cursorQuery.close();
                                                                }
                                                                return null;
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                cursor2 = cursor4;
                                                                cursor = cursor2;
                                                                if (cursor != null) {
                                                                    cursor.close();
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                        if (nVar != null) {
                                                            arrayList2 = arrayList;
                                                            arrayList2.add(nVar);
                                                        } else {
                                                            arrayList2 = arrayList;
                                                        }
                                                        getWritableDatabase().delete("reward_report", "id = ?", new String[]{cursor2.getInt(cursor2.getColumnIndex("id")) + ""});
                                                        arrayList3 = arrayList2;
                                                        cursorQuery = cursor2;
                                                    }
                                                    e.printStackTrace();
                                                    aa.d(a, e.getMessage());
                                                    if (cursorQuery != null) {
                                                        cursorQuery.close();
                                                    }
                                                }
                                            }
                                            cursor2 = cursorQuery;
                                            if (nVar != null) {
                                                arrayList2 = arrayList;
                                                arrayList2.add(nVar);
                                            } else {
                                                arrayList2 = arrayList;
                                            }
                                            getWritableDatabase().delete("reward_report", "id = ?", new String[]{cursor2.getInt(cursor2.getColumnIndex("id")) + ""});
                                            arrayList3 = arrayList2;
                                            cursorQuery = cursor2;
                                        }
                                    }
                                    Cursor cursor5 = cursorQuery;
                                    ArrayList arrayList4 = arrayList3;
                                    if (cursor5 != null) {
                                        try {
                                            cursor5.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    return arrayList4;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            } catch (Throwable th6) {
                                th = th6;
                                cursor2 = cursorQuery;
                            }
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (Exception e7) {
                        e = e7;
                        cursorQuery = null;
                    } catch (Throwable th7) {
                        th = th7;
                        cursor = null;
                    }
                }
            } catch (Exception unused3) {
            }
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x001b A[EXC_TOP_SPLITTER, PHI: r0 r1
      0x001b: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:16:0x0025, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]
      0x001b: PHI (r1v3 int) = (r1v0 int), (r1v5 int) binds: [B:16:0x0025, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final synchronized int a() {
        int i;
        Cursor cursorRawQuery = null;
        i = 0;
        try {
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("select count(*) from reward_report", null);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    i = cursorRawQuery.getInt(0);
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        return i;
    }

    public final synchronized long a(com.mbridge.msdk.foundation.entity.n nVar) {
        if (nVar != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(SDKConstants.PARAM_KEY, nVar.s());
                contentValues.put("networkType", Integer.valueOf(nVar.z()));
                contentValues.put("network_str", nVar.A());
                contentValues.put("isCompleteView", Integer.valueOf(nVar.B()));
                contentValues.put("watchedMillis", Integer.valueOf(nVar.t()));
                contentValues.put("videoLength", Integer.valueOf(nVar.u()));
                if (!TextUtils.isEmpty(nVar.v())) {
                    contentValues.put("offerUrl", nVar.v());
                }
                if (!TextUtils.isEmpty(nVar.w())) {
                    contentValues.put("reason", URLEncoder.encode(nVar.w(), "utf-8"));
                }
                contentValues.put("result", Integer.valueOf(nVar.C()));
                contentValues.put("duration", nVar.x());
                contentValues.put("videoSize", Long.valueOf(nVar.y()));
                contentValues.put("type", nVar.h());
                String strG = nVar.g();
                if (!TextUtils.isEmpty(strG)) {
                    contentValues.put(CampaignEx.ENDCARD_URL, strG);
                }
                String strF = nVar.f();
                if (!TextUtils.isEmpty(strF)) {
                    contentValues.put("video_url", strF);
                }
                String strO = nVar.o();
                if (!TextUtils.isEmpty(strO)) {
                    contentValues.put("rid", strO);
                }
                String strP = nVar.p();
                if (!TextUtils.isEmpty(strP)) {
                    contentValues.put("rid_n", strP);
                }
                String strJ = nVar.j();
                if (!TextUtils.isEmpty(strJ)) {
                    contentValues.put("template_url", strJ);
                }
                String strE = nVar.e();
                if (!TextUtils.isEmpty(strE)) {
                    contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, strE);
                }
                String strI = nVar.i();
                if (!TextUtils.isEmpty(strI)) {
                    contentValues.put("ad_type", URLEncoder.encode(strI, "utf-8"));
                }
                contentValues.put("unitId", nVar.q());
                contentValues.put("campaignId", nVar.r());
                if ("2000039".equals(nVar.s())) {
                    String strF2 = com.mbridge.msdk.foundation.entity.n.f(nVar);
                    if (ak.b(strF2)) {
                        contentValues.put("h5_click_data", strF2);
                    }
                }
                String strA = nVar.a();
                if (!TextUtils.isEmpty(strA)) {
                    contentValues.put("resource_type", URLEncoder.encode(strA, "utf-8"));
                }
                String strB = nVar.b();
                if (!TextUtils.isEmpty(strB)) {
                    contentValues.put("device_id", URLEncoder.encode(strB, "utf-8"));
                }
                String strC = nVar.c();
                if (!TextUtils.isEmpty(strC)) {
                    contentValues.put("creative", URLEncoder.encode(strC, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(nVar.l()));
                return getWritableDatabase().insert("reward_report", null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                aa.d(a, e.getMessage());
                return -1L;
            }
        }
        return -1L;
    }
}
