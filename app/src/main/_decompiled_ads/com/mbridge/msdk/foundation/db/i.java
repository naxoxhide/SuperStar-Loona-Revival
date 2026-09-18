package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.out.Campaign;

/* JADX INFO: compiled from: DailyPlayCapDao.java */
/* JADX INFO: loaded from: classes4.dex */
public class i extends a<Campaign> {
    private static final String a = "com.mbridge.msdk.foundation.db.i";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static i f2078b;

    private i(g gVar) {
        super(gVar);
    }

    public static synchronized i a(g gVar) {
        if (f2078b == null) {
            f2078b = new i(gVar);
        }
        return f2078b;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0067 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0 r1
      0x0067: PHI (r0v2 android.database.Cursor) = (r0v1 android.database.Cursor), (r0v3 android.database.Cursor) binds: [B:24:0x0075, B:19:0x0065] A[DONT_GENERATE, DONT_INLINE]
      0x0067: PHI (r1v1 boolean) = (r1v0 boolean), (r1v3 boolean) binds: [B:24:0x0075, B:19:0x0065] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final boolean a(String str, int i) {
        Cursor cursorRawQuery = null;
        boolean z = false;
        try {
            cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM dailyplaycap where unit_id ='" + str + "'", null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                long j = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("first_insert_timestamp"));
                long j2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("play_time"));
                if (j != 0) {
                    if (System.currentTimeMillis() - 86400000 > j) {
                        b(str);
                    } else if (i > 0 && j2 >= i) {
                        z = true;
                    }
                }
            }
            if (cursorRawQuery != null) {
            }
        } catch (Throwable th) {
            try {
                aa.b(a, th.getMessage());
            } finally {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return z;
    }

    private synchronized void b(String str) {
        try {
            if (getWritableDatabase() == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("first_insert_timestamp", (Integer) 0);
            contentValues.put("play_time", (Integer) 0);
            getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = '" + str + "'", null);
        } catch (Throwable th) {
            aa.b(a, th.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0075  */
    /* JADX WARN: Code duplicated, block: B:26:0x007b A[Catch: all -> 0x006e, Exception -> 0x0072, TryCatch #7 {Exception -> 0x0072, all -> 0x006e, blocks: (B:14:0x0042, B:16:0x0048, B:18:0x0069, B:26:0x007b, B:27:0x0084), top: B:58:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00d4 A[EXC_TOP_SPLITTER, PHI: r1
      0x00d4: PHI (r1v4 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v5 android.database.Cursor) binds: [B:37:0x00de, B:30:0x00d2] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final synchronized void a(String str) {
        long j;
        long j2;
        Cursor cursor = null;
        try {
            try {
                if (getWritableDatabase() == null) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (c(str)) {
                    Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM dailyplaycap where unit_id ='" + str + "'", null);
                    if (cursorRawQuery != null) {
                        try {
                            if (cursorRawQuery.getCount() > 0) {
                                cursorRawQuery.moveToFirst();
                                j = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("first_insert_timestamp"));
                                j2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("play_time"));
                                if (jCurrentTimeMillis - 86400000 > j) {
                                    b(str);
                                    j2 = 0;
                                }
                            } else {
                                j = 0;
                                j2 = 0;
                            }
                            if (j == 0) {
                                contentValues.put("first_insert_timestamp", Long.valueOf(jCurrentTimeMillis));
                            }
                            contentValues.put("play_time", Long.valueOf(j2 + 1));
                            getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = '" + str + "'", null);
                            cursor = cursorRawQuery;
                        } catch (Exception e) {
                            e = e;
                            cursor = cursorRawQuery;
                            e.printStackTrace();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable unused) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } else {
                        j = 0;
                        j2 = 0;
                        if (j == 0) {
                            contentValues.put("first_insert_timestamp", Long.valueOf(jCurrentTimeMillis));
                        }
                        contentValues.put("play_time", Long.valueOf(j2 + 1));
                        getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = '" + str + "'", null);
                        cursor = cursorRawQuery;
                    }
                }
                contentValues.put("first_insert_timestamp", Long.valueOf(jCurrentTimeMillis));
                contentValues.put("play_time", (Long) 1L);
                contentValues.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                getWritableDatabase().insert("dailyplaycap", null, contentValues);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private synchronized boolean c(String str) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT play_time FROM dailyplaycap WHERE unit_id='" + str + "'", null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.close();
                return true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
