package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.foundation.same.report.BatchReportMessage;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class BatchReportDao extends a<BatchReportMessage> implements NoProGuard, Serializable {
    private static volatile BatchReportDao instance;

    protected BatchReportDao(g gVar) {
        super(gVar);
    }

    public static BatchReportDao getInstance(g gVar) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                if (instance == null) {
                    instance = new BatchReportDao(gVar);
                }
            }
        }
        return instance;
    }

    public static BatchReportDao getInstance(Context context) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                if (instance == null) {
                    instance = new BatchReportDao(h.a(context));
                }
            }
        }
        return instance;
    }

    public void addReportMessage(String str, int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("report_message", str);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("uuid", UUID.randomUUID().toString().replace("-", ""));
            contentValues.put("report_state", (Integer) 0);
            contentValues.put("type", Integer.valueOf(i));
            writableDatabase.insert("batch_report", null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BatchReportMessage> getBatchReportMessages(long j, int i) throws Throwable {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = null;
        if (readableDatabase == null) {
            return null;
        }
        ArrayList<BatchReportMessage> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append("batch_report").append(" WHERE ").append("time").append(" <= ").append(j).append(" AND ").append("report_state").append(" = 0").append(" AND ").append("type").append(" = " + i).append(" ORDER BY ").append("time").append(" ASC ");
        try {
            try {
                Cursor cursorRawQuery = readableDatabase.rawQuery(sb.toString(), null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            arrayList.add(new BatchReportMessage(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("uuid")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("report_message")), cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("time"))));
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("report_state", (Integer) 1);
                readableDatabase.update("batch_report", contentValues, "time <= " + j, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void updateMessagesReportState(ArrayList<BatchReportMessage> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (arrayList == null || arrayList.size() == 0 || writableDatabase == null) {
            return;
        }
        for (BatchReportMessage batchReportMessage : arrayList) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("report_state", (Integer) 0);
                writableDatabase.update("batch_report", contentValues, "uuid = '" + batchReportMessage.getUuid() + "'", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteBatchReportMessagesByTimestamp(long j) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("delete from ").append("batch_report").append(" where ").append("time").append(" <= ").append(j);
        try {
            readableDatabase.execSQL(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
