package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CacheCampaignDao.java */
/* JADX INFO: loaded from: classes4.dex */
public class c extends a {
    private static volatile c a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2074b = "com.mbridge.msdk.foundation.db.c";

    private c(g gVar) {
        super(gVar);
    }

    public static c a(g gVar) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(gVar);
                }
            }
        }
        return a;
    }

    public final long a(List<CampaignEx> list, String str) {
        CampaignEx campaignEx;
        if (list != null) {
            try {
                if (list.size() == 0 || TextUtils.isEmpty(str) || (campaignEx = list.get(0)) == null) {
                    return 0L;
                }
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rid", campaignEx.getRequestId());
                contentValues.put("lrid", campaignEx.getLocalRequestId());
                contentValues.put("unitid", str);
                JSONArray jSONArray = new JSONArray();
                Iterator<CampaignEx> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(it.next()));
                }
                contentValues.put("campaigns", jSONArray.toString());
                contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(campaignEx.getTimestamp()));
                long plctb = campaignEx.getPlctb();
                if (plctb == 0) {
                    com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                    if (cVarB == null) {
                        cVarB = com.mbridge.msdk.c.d.a().b();
                    }
                    plctb = cVarB.Q();
                }
                contentValues.put("interval_ts", Long.valueOf(plctb * 1000));
                contentValues.put("ecppv", campaignEx.getEcppv());
                contentValues.put("show_count", Integer.valueOf(campaignEx.getShowCount()));
                contentValues.put("state", (Integer) 0);
                if (c(campaignEx.getRequestId(), campaignEx.getLocalRequestId(), str)) {
                    return getWritableDatabase().update("CacheCampaign", contentValues, "rid='" + campaignEx.getRequestId() + "' AND lrid='" + campaignEx.getLocalRequestId() + "' AND unitid = '" + str + "' AND state = 1", null);
                }
                return getWritableDatabase().insert("CacheCampaign", null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                return -1L;
            }
        }
        return 0L;
    }

    private synchronized boolean c(String str, String str2, String str3) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT rid FROM CacheCampaign WHERE rid='" + str + "' AND lrid='" + str2 + "' AND unitid = '" + str3 + "'", null);
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            try {
                cursorRawQuery.close();
            } catch (Exception unused) {
            }
            return true;
        }
        if (cursorRawQuery != null) {
            try {
                cursorRawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public final synchronized void a(String str, int i) {
        if (i <= 0) {
            i = 1;
        }
        try {
            String str2 = "unitid = " + str + " AND ( (" + CampaignEx.JSON_KEY_ST_TS + " + interval_ts) < " + System.currentTimeMillis() + " OR show_count >= " + i + " )";
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("delete from ").append("CacheCampaign").append(" where ").append(str2);
            try {
                writableDatabase.execSQL(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            aa.d("CacheCampaignDao", e2.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str, String str2, String str3) {
        try {
            if (c(str2, str3, str)) {
                String str4 = "unitid = '" + str + "' AND rid = '" + str2 + "' AND lrid = '" + str3 + "'";
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("delete from ").append("CacheCampaign").append(" where ").append(str4);
                try {
                    writableDatabase.execSQL(sb.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0106 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r10
      0x0106: PHI (r10v11 android.database.Cursor) = (r10v10 android.database.Cursor), (r10v12 android.database.Cursor) binds: [B:35:0x010f, B:29:0x0104] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final List<com.mbridge.msdk.foundation.b.b> a(String str) {
        Cursor cursorRawQuery;
        try {
            cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM CacheCampaign" + (" WHERE unitid = '" + str + "' AND state > 0"), null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.getCount() > 0) {
                        ArrayList arrayList = new ArrayList();
                        while (cursorRawQuery.moveToNext()) {
                            com.mbridge.msdk.foundation.b.b bVar = new com.mbridge.msdk.foundation.b.b();
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("campaigns"));
                            JSONArray jSONArray = new JSONArray(string);
                            if (TextUtils.isEmpty(string)) {
                                if (cursorRawQuery != null) {
                                    try {
                                        cursorRawQuery.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                return null;
                            }
                            if (jSONArray.length() > 0) {
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    copyOnWriteArrayList.add(CampaignEx.parseCampaignWithBackData((JSONObject) jSONArray.get(i)));
                                }
                                bVar.a(copyOnWriteArrayList);
                            }
                            bVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("lrid")));
                            bVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("rid")));
                            bVar.c(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("unitid")));
                            bVar.d(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ecppv")));
                            bVar.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_ST_TS)));
                            bVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("state")));
                            bVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("show_count")));
                            arrayList.add(bVar);
                        }
                        if (cursorRawQuery != null) {
                            try {
                                cursorRawQuery.close();
                            } catch (Exception unused2) {
                            }
                        }
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (cursorRawQuery != null) {
                            try {
                                cursorRawQuery.close();
                            } catch (Exception unused3) {
                            }
                        }
                    }
                }
            }
            if (cursorRawQuery != null) {
            }
        } catch (Throwable th2) {
            th = th2;
            cursorRawQuery = null;
        }
        return null;
    }

    public final long a(String str, String str2, String str3, int i) {
        if (!c(str, str2, str3)) {
            return -1L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(i));
        return getWritableDatabase().update("CacheCampaign", contentValues, "rid='" + str + "' AND lrid='" + str2 + "' AND unitid = '" + str3 + "' AND state = 0", null);
    }

    public final void b(String str, String str2, String str3) {
        if (c(str, str2, str3)) {
            getWritableDatabase().execSQL("UPDATE CacheCampaign SET show_count = show_count + 1 WHERE " + ("rid='" + str + "' AND lrid='" + str2 + "' AND unitid = '" + str3 + "' AND state = 1"));
        }
    }
}
