package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: FrequenceDao.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends a<com.mbridge.msdk.foundation.entity.g> {
    private static k a;

    private k(g gVar) {
        super(gVar);
    }

    public static synchronized k a(g gVar) {
        if (a == null) {
            a = new k(gVar);
        }
        return a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0047 A[PHI: r0
      0x0047: PHI (r0v6 android.database.Cursor) = (r0v5 android.database.Cursor), (r0v7 android.database.Cursor) binds: [B:25:0x0045, B:17:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    public final long[] a() {
        Throwable th;
        Cursor cursorRawQuery;
        try {
            cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM frequence WHERE fc_a<impression_count", null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.getCount() > 0) {
                        long[] jArr = new long[cursorRawQuery.getCount()];
                        int i = 0;
                        while (cursorRawQuery.moveToNext()) {
                            jArr[i] = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("id"));
                            i++;
                        }
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return jArr;
                    }
                } catch (Exception unused) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Exception unused2) {
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
        return null;
    }

    public final synchronized void b() {
        try {
            String str = "ts<" + (System.currentTimeMillis() - 86400000);
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("frequence", str, null);
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized boolean a(String str) {
        Cursor cursor = null;
        try {
            try {
                synchronized (str) {
                    Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM frequence WHERE id='" + str + "'", null);
                    if (cursorRawQuery == null || cursorRawQuery.getCount() <= 0) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return false;
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return true;
                }
            } catch (Exception unused) {
                if (0 != 0) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void b(String str) {
        if (a(str)) {
            String str2 = "UPDATE frequence Set impression_count=impression_count+1 WHERE id=" + str;
            if (getReadableDatabase() != null) {
                getReadableDatabase().execSQL(str2);
            }
        }
    }

    private synchronized long b(com.mbridge.msdk.foundation.entity.g gVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", gVar.a());
            contentValues.put("fc_a", Integer.valueOf(gVar.b()));
            contentValues.put("fc_b", Integer.valueOf(gVar.c()));
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(gVar.f()));
            contentValues.put("impression_count", Integer.valueOf(gVar.d()));
            contentValues.put("click_count", Integer.valueOf(gVar.e()));
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(gVar.f()));
            if (getWritableDatabase() == null) {
                return -1L;
            }
            return getWritableDatabase().insert("frequence", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized void a(com.mbridge.msdk.foundation.entity.g gVar) {
        if (!a(gVar.a())) {
            b(gVar);
        }
    }
}
