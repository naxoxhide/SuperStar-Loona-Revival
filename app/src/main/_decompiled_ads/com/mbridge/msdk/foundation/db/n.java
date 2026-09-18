package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReportErrorDao.java */
/* JADX INFO: loaded from: classes4.dex */
public class n extends a {
    private static n a;

    private n(g gVar) {
        super(gVar);
    }

    public static n a(g gVar) {
        if (a == null) {
            synchronized (n.class) {
                if (a == null) {
                    a = new n(gVar);
                }
            }
        }
        return a;
    }

    public final synchronized int a() {
        int i;
        Cursor cursorQuery = null;
        i = 0;
        try {
            try {
                cursorQuery = getReadableDatabase().query("reporterror", new String[]{" count(*) "}, null, null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    i = cursorQuery.getInt(0);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        return i;
    }

    public final synchronized int a(String str) {
        try {
            String[] strArr = {str};
            if (getWritableDatabase() == null) {
                return -1;
            }
            return getWritableDatabase().delete("reporterror", "url=?", strArr);
        } catch (Exception unused) {
            return -1;
        }
    }

    public final synchronized void a(String str, String str2, long j) {
        if (str == null) {
            str = "";
        }
        try {
            if (getWritableDatabase() == null) {
                return;
            }
            getWritableDatabase().execSQL("DELETE from reporterror where url='" + str2 + "' and data='" + str + "' and time_stamp=" + j + " or count > 5 ");
        } catch (Exception unused) {
        }
    }

    private synchronized int b(int i) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return getWritableDatabase().rawQuery("DELETE from reporterror where count >= " + i, null).getCount();
    }

    public final synchronized int b() {
        int count;
        Cursor cursorQuery = null;
        count = 0;
        try {
            try {
                cursorQuery = getReadableDatabase().query("reporterror", new String[]{" count(*) "}, null, null, null, null, null, null);
                count = cursorQuery.getCount();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
                return count;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        return count;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ad A[Catch: all -> 0x00b1, TRY_ENTER, TryCatch #0 {all -> 0x00b1, blocks: (B:27:0x00a3, B:19:0x0094, B:34:0x00ad, B:35:0x00b0), top: B:39:0x0003 }] */
    public final synchronized List<com.mbridge.msdk.foundation.entity.l> a(int i) {
        ArrayList arrayList;
        Exception e;
        Cursor cursorQuery;
        ArrayList arrayList2;
        Cursor cursor = null;
        arrayList2 = null;
        arrayList2 = null;
        try {
            try {
                b(5);
                cursorQuery = getReadableDatabase().query("reporterror", null, null, null, null, null, null, i + "");
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.getCount() > 0) {
                                arrayList = new ArrayList();
                                while (cursorQuery.moveToNext()) {
                                    try {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("method"));
                                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("unitId"));
                                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("count"));
                                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex("time_stamp"));
                                        com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l(string, string3, string2, string4);
                                        lVar.a(i2 + 1);
                                        lVar.a(j);
                                        arrayList.add(lVar);
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        arrayList2 = arrayList;
                                    }
                                }
                                arrayList2 = arrayList;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        arrayList = null;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e4) {
                arrayList = null;
                e = e4;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return arrayList2;
    }

    private synchronized boolean b(String str, String str2, long j) {
        if (str == null) {
            str = "";
        }
        try {
            if (getWritableDatabase() == null) {
                return false;
            }
            return getReadableDatabase().rawQuery(new StringBuilder().append("select * from reporterror where url='").append(str2).append("' and ").append("data").append("='").append(str).append("' and ").append("time_stamp").append("=").append(j).toString(), null).getCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        throw th;
    }

    public final synchronized long a(com.mbridge.msdk.foundation.entity.l lVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", lVar.b());
            contentValues.put("method", lVar.c());
            contentValues.put("data", lVar.d());
            contentValues.put("unitId", lVar.a());
            contentValues.put("time_stamp", Long.valueOf(lVar.f()));
            if (getWritableDatabase() == null) {
                return -1L;
            }
            if (b(lVar.d(), lVar.b(), lVar.f())) {
                return getWritableDatabase().rawQuery("UPDATE reporterror SET count = " + lVar.e() + " where url='" + lVar.b() + "' and data='" + lVar.d() + "' and time_stamp=" + lVar.f(), null).getCount();
            }
            contentValues.put("count", Integer.valueOf(lVar.e()));
            return getWritableDatabase().insert("reporterror", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }
}
