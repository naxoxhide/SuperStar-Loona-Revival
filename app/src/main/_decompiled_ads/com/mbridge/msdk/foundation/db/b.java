package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BidReplaceCampignDao.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends a {
    private static volatile b a;

    private b(g gVar) {
        super(gVar);
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(h.a(context));
                }
            }
        }
        return a;
    }

    public final void a(String str, List<CampaignEx> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        try {
            String requestId = list.get(0).getRequestId();
            String encryptPrice = list.get(0).getEncryptPrice();
            String campaignUnitId = list.get(0).getCampaignUnitId();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("bid_unit_id", campaignUnitId);
            contentValues.put("expect_bid_token", str);
            contentValues.put("expect_encrypt_price", "");
            contentValues.put("real_request_id", requestId);
            contentValues.put("real_encrypt_price", encryptPrice);
            contentValues.put("real_token_rule", (Integer) 1);
            contentValues.put("is_replace", (Integer) 0);
            writableDatabase.insert("bid_replace_campaign", null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || getWritableDatabase() == null) {
            return 0;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("bid_unit_id").append(" = '").append(str2).append("' AND ");
            sb.append("expect_bid_token").append(" = '").append(str).append("'");
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_replace", (Integer) 1);
            return getWritableDatabase().update("bid_replace_campaign", contentValues, sb.toString(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final int a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || getWritableDatabase() == null) {
            return 0;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("bid_unit_id").append(" = '").append(str2).append("' AND ");
            sb.append("expect_bid_token").append(" = '").append(str).append("'");
            ContentValues contentValues = new ContentValues();
            contentValues.put("expect_encrypt_price", str3);
            return getWritableDatabase().update("bid_replace_campaign", contentValues, sb.toString(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00e1 A[PHI: r9
      0x00e1: PHI (r9v7 android.database.Cursor) = (r9v6 android.database.Cursor), (r9v8 android.database.Cursor) binds: [B:29:0x00df, B:20:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    public final List<com.mbridge.msdk.foundation.entity.c> b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM bid_replace_campaign WHERE ");
        sb.append("bid_unit_id").append(" = '").append(str).append("' AND ");
        sb.append("real_request_id").append(" = '").append(str2).append("'");
        Cursor cursorRawQuery = null;
        try {
            try {
                synchronized (new Object()) {
                    cursorRawQuery = getReadableDatabase().rawQuery(sb.toString(), null);
                }
                if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                    while (cursorRawQuery.moveToNext()) {
                        com.mbridge.msdk.foundation.entity.c cVar = new com.mbridge.msdk.foundation.entity.c();
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bid_unit_id"));
                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("expect_bid_token"));
                        String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("expect_encrypt_price"));
                        String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("real_request_id"));
                        String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("real_encrypt_price"));
                        int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("real_token_rule"));
                        int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("is_replace"));
                        cVar.a(string);
                        cVar.b(string2);
                        cVar.c(string3);
                        cVar.d(string4);
                        cVar.e(string5);
                        cVar.a(i);
                        cVar.b(i2);
                        arrayList.add(cVar);
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception e) {
                aa.d("BidReplaceCampaignDao", e.getLocalizedMessage());
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

    public final int a(String str) {
        try {
            String str2 = "real_request_id = '" + str + "' AND is_replace = 1";
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", str2, null);
        } catch (Exception e) {
            aa.d("BidReplaceCampaignDao", e.getLocalizedMessage());
            return 0;
        }
    }

    public final int a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", "is_replace = 0", null);
        } catch (Exception e) {
            aa.d("BidReplaceCampaignDao", e.getLocalizedMessage());
            return 0;
        }
    }
}
