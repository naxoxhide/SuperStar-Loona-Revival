package com.mbridge.msdk.e;

import android.database.Cursor;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes4.dex */
final class y {
    static boolean a(Object obj) {
        return obj == null;
    }

    static boolean b(Object obj) {
        return obj != null;
    }

    static boolean a(List<?> list) {
        return list == null || list.size() == 0;
    }

    static boolean b(List<i> list) {
        if (a((List<?>) list)) {
            return false;
        }
        for (i iVar : list) {
            if (!a(iVar)) {
                e eVarC = iVar.c();
                if (!a(eVarC) && eVarC.c() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static void a(Cursor cursor) {
        boolean z = false;
        try {
            if (b((Object) cursor) && !cursor.isClosed()) {
                z = true;
            }
        } catch (Exception unused) {
        }
        if (z) {
            try {
                cursor.close();
            } catch (Exception unused2) {
            }
        }
    }

    static List<i> b(Cursor cursor) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        try {
            int columnIndex = cursor.getColumnIndex("name");
            int columnIndex2 = cursor.getColumnIndex("type");
            int columnIndex3 = cursor.getColumnIndex("time_stamp");
            int columnIndex4 = cursor.getColumnIndex("properties");
            int columnIndex5 = cursor.getColumnIndex("priority");
            int columnIndex6 = cursor.getColumnIndex("uuid");
            int columnIndex7 = cursor.getColumnIndex("duration");
            int columnIndex8 = cursor.getColumnIndex("state");
            int columnIndex9 = cursor.getColumnIndex("report_count");
            int columnIndex10 = cursor.getColumnIndex("ignore_max_timeout");
            int columnIndex11 = cursor.getColumnIndex("ignore_max_retry_times");
            int columnIndex12 = cursor.getColumnIndex("invalid_time");
            while (cursor.moveToNext()) {
                try {
                    e eVar = new e(cursor.getString(columnIndex));
                    eVar.a(cursor.getInt(columnIndex2));
                    i = columnIndex;
                    i2 = columnIndex2;
                    try {
                        eVar.a(cursor.getLong(columnIndex3));
                        eVar.a(new JSONObject(cursor.getString(columnIndex4)));
                        eVar.b(cursor.getInt(columnIndex5));
                        eVar.a(cursor.getString(columnIndex6));
                        eVar.b(cursor.getLong(columnIndex7));
                        i iVar = new i(eVar);
                        iVar.b(cursor.getInt(columnIndex8));
                        iVar.a(cursor.getInt(columnIndex9));
                        boolean z = true;
                        iVar.a(cursor.getInt(columnIndex10) == 0);
                        if (cursor.getInt(columnIndex11) != 0) {
                            z = false;
                        }
                        iVar.b(z);
                        iVar.a(cursor.getLong(columnIndex12));
                        arrayList.add(iVar);
                    } catch (JSONException e) {
                        e = e;
                        if (a.a) {
                            Log.e("TrackManager", "create: ", e);
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    i = columnIndex;
                    i2 = columnIndex2;
                }
                columnIndex = i;
                columnIndex2 = i2;
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
