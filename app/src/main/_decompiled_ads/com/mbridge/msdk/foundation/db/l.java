package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: LoadTimeDao.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends a<com.mbridge.msdk.foundation.entity.h> {
    private static l a;

    private l(g gVar) {
        super(gVar);
    }

    public static synchronized l a(g gVar) {
        if (a == null) {
            a = new l(gVar);
        }
        return a;
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
                cursorRawQuery = getReadableDatabase().rawQuery("select count(*) from load_stat", null);
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

    public final synchronized List<com.mbridge.msdk.foundation.entity.h> a(int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Cursor cursor = null;
        arrayList2 = null;
        arrayList2 = null;
        cursor = null;
        try {
            try {
                Cursor cursorRawQuery = getReadableDatabase().rawQuery("select * from load_stat LIMIT " + i, null);
                if (cursorRawQuery != null) {
                    try {
                        try {
                            if (cursorRawQuery.getCount() > 0) {
                                arrayList = new ArrayList();
                                int i2 = 0;
                                while (cursorRawQuery.moveToNext() && i2 < i) {
                                    try {
                                        i2++;
                                        int i3 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_AD_SOURCE_ID));
                                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("time"));
                                        int i4 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("adNum"));
                                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("unitId"));
                                        int i5 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("fb"));
                                        int i6 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("timeout"));
                                        int i7 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("network_type"));
                                        String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("network_type_str"));
                                        int i8 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_HB));
                                        com.mbridge.msdk.foundation.entity.h hVar = new com.mbridge.msdk.foundation.entity.h(i3, string, i4, string2, i5, i6, i7);
                                        hVar.c(string3);
                                        hVar.a(i8);
                                        arrayList.add(hVar);
                                        int i9 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"));
                                        if (getWritableDatabase() != null) {
                                            getWritableDatabase().delete("load_stat", "id = ?", new String[]{i9 + ""});
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = cursorRawQuery;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                            }
                                        }
                                        arrayList2 = arrayList;
                                    }
                                }
                                arrayList2 = arrayList;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = null;
                    }
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
        return arrayList2;
    }

    public final synchronized void a(com.mbridge.msdk.foundation.entity.h hVar) {
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", hVar.c());
        contentValues.put(CampaignEx.JSON_KEY_AD_SOURCE_ID, Integer.valueOf(hVar.b()));
        contentValues.put("adNum", Integer.valueOf(hVar.d()));
        contentValues.put("unitId", hVar.e());
        contentValues.put("fb", Integer.valueOf(hVar.f()));
        contentValues.put(CampaignEx.JSON_KEY_HB, Integer.valueOf(hVar.a()));
        contentValues.put("timeout", Integer.valueOf(hVar.g()));
        contentValues.put("network_type", Integer.valueOf(hVar.h()));
        contentValues.put("network_type_str", hVar.i());
        getWritableDatabase().insert("load_stat", null, contentValues);
    }
}
