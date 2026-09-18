package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.aa;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReplaceTempDao.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m extends a {
    private static String a = "ReplaceTempDao";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static m f2079b;

    private m(g gVar) {
        super(gVar);
    }

    public static m a(g gVar) {
        if (f2079b == null) {
            synchronized (f.class) {
                if (f2079b == null) {
                    f2079b = new m(gVar);
                }
            }
        }
        return f2079b;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0050 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0052 A[Catch: all -> 0x004e, TRY_LEAVE, TryCatch #1 {all -> 0x004e, blocks: (B:7:0x002b, B:9:0x0031, B:10:0x0037, B:12:0x003d, B:16:0x0052), top: B:30:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0061 A[DONT_GENERATE, PHI: r1
      0x0061: PHI (r1v4 org.json.JSONObject) = (r1v0 org.json.JSONObject), (r1v6 org.json.JSONObject) binds: [B:19:0x005f, B:25:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    public final JSONObject a(String str) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM c_replace_temp WHERE d_key = '" + str + "'", null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.getCount() > 0) {
                    jSONObject = new JSONObject();
                    while (cursorRawQuery.moveToNext()) {
                        jSONObject = new JSONObject(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("d_value")));
                    }
                } else if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (cursorRawQuery != null) {
                }
            } catch (Throwable th) {
                try {
                    aa.d(a, th.getMessage());
                } finally {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
            }
        } else {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            if (cursorRawQuery != null) {
            }
        }
        return jSONObject;
    }

    public final void a(String str, JSONObject jSONObject) {
        boolean z;
        try {
            if (getWritableDatabase() == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("d_key", str);
            contentValues.put("d_value", jSONObject.toString());
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT d_value FROM c_replace_temp WHERE d_key='" + str + "'", null);
            if (cursorRawQuery == null || cursorRawQuery.getCount() <= 0) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                z = false;
            } else {
                cursorRawQuery.close();
                z = true;
            }
            if (!z) {
                getWritableDatabase().insert("c_replace_temp", null, contentValues);
            } else {
                getWritableDatabase().update("c_replace_temp", contentValues, "d_key = '" + str + "'", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0070 A[Catch: all -> 0x0069, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0069, blocks: (B:12:0x0037, B:14:0x003d, B:25:0x0070), top: B:42:0x0037 }] */
    public final JSONObject a() {
        JSONObject jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) 604800000);
        try {
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("c_replace_temp", "time<?", new String[]{String.valueOf(jCurrentTimeMillis)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jSONObject2 = null;
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM c_replace_temp", null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.getCount() > 0) {
                    jSONObject = new JSONObject();
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            jSONObject.put(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("d_key")), new JSONObject(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("d_value"))));
                        } catch (Throwable th) {
                            th = th;
                            try {
                                aa.d(a, th.getMessage());
                            } finally {
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                            }
                        }
                    }
                    jSONObject2 = jSONObject;
                } else if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th2) {
                JSONObject jSONObject3 = jSONObject2;
                th = th2;
                jSONObject = jSONObject3;
            }
        } else if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return jSONObject2;
    }
}
