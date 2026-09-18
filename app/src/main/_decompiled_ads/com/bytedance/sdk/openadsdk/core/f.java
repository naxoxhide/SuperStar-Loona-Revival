package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: DBHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private static final Object c = new Object();
    private d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f569b;

    /* JADX INFO: compiled from: DBHelper.java */
    private class c extends AbstractCursor {
        private c(f fVar) {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }
    }

    f(Context context) {
        try {
            this.f569b = context == null ? o.a() : context.getApplicationContext();
            if (this.a == null) {
                this.a = new d();
            }
        } catch (Throwable unused) {
        }
    }

    public d c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context b() {
        Context context = this.f569b;
        return context == null ? o.a() : context;
    }

    /* JADX INFO: compiled from: DBHelper.java */
    public class d {
        private SQLiteDatabase a = null;

        public d() {
        }

        private synchronized void b() {
            try {
                synchronized (f.c) {
                    SQLiteDatabase sQLiteDatabase = this.a;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        f fVar = f.this;
                        SQLiteDatabase writableDatabase = fVar.new b(fVar.b()).getWritableDatabase();
                        this.a = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("DBHelper", th.getMessage());
                if (e()) {
                    throw th;
                }
            }
        }

        private synchronized boolean e() {
            SQLiteDatabase sQLiteDatabase;
            sQLiteDatabase = this.a;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }

        public synchronized void a(String str) throws SQLException {
            try {
                b();
                this.a.execSQL(str);
            } catch (Throwable th) {
                if (e()) {
                    throw th;
                }
            }
        }

        public synchronized void c() {
            b();
            SQLiteDatabase sQLiteDatabase = this.a;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        public SQLiteDatabase d() {
            b();
            return this.a;
        }

        public synchronized void f() {
            b();
            SQLiteDatabase sQLiteDatabase = this.a;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursorQuery;
            try {
                b();
                cursorQuery = this.a.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("DBHelper", th.getMessage());
                c cVar = new c();
                if (e()) {
                    throw th;
                }
                cursorQuery = cVar;
            }
            return cursorQuery;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int iUpdate;
            try {
                b();
                iUpdate = this.a.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("DBHelper", e.getMessage());
                if (e()) {
                    throw e;
                }
                iUpdate = 0;
            }
            return iUpdate;
        }

        public synchronized long a(String str, String str2, ContentValues contentValues) {
            long jReplace;
            try {
                b();
                jReplace = this.a.replace(str, str2, contentValues);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("DBHelper", e.getMessage());
                if (e()) {
                    throw e;
                }
                jReplace = -1;
            }
            return jReplace;
        }

        public synchronized int a(String str, String str2, String[] strArr) {
            int iDelete;
            try {
                b();
                iDelete = this.a.delete(str, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("DBHelper", e.getMessage());
                if (e()) {
                    throw e;
                }
                iDelete = 0;
            }
            return iDelete;
        }

        public synchronized void a() {
            b();
            SQLiteDatabase sQLiteDatabase = this.a;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }
    }

    /* JADX INFO: compiled from: DBHelper.java */
    private class b extends SQLiteOpenHelper {
        final Context a;

        public b(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 7);
            this.a = context;
        }

        private void a(SQLiteDatabase sQLiteDatabase, Context context) {
            com.bytedance.sdk.component.utils.m.a("DBHelper", "initDB........");
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.d.b());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.h.c());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.n.b());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.m.b());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.q.b.a());
            sQLiteDatabase.execSQL(b.b.a.a.d.e.b.a.d());
        }

        private void b(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayListC = c(sQLiteDatabase);
            if (arrayListC == null || arrayListC.size() <= 0) {
                return;
            }
            Iterator<String> it = arrayListC.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0039 A[PHI: r1
          0x0039: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:19:0x0037, B:13:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
        private ArrayList<String> c(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception unused) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
            return arrayList;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                a(sQLiteDatabase, this.a);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("DBHelper", th.getMessage());
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                try {
                    b(sQLiteDatabase);
                    a(sQLiteDatabase, f.this.f569b);
                    com.bytedance.sdk.component.utils.m.a("DBHelper", "onUpgrade...Reverse installation. Database reset and create table.....");
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.m.b(th.getMessage());
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                com.bytedance.sdk.component.utils.m.a("DBHelper", "onUpgrade....Database version upgrade.....old:" + i + ",new:" + i2);
                if (i > i2) {
                    b(sQLiteDatabase);
                    a(sQLiteDatabase, f.this.f569b);
                    com.bytedance.sdk.component.utils.m.a("DBHelper", "onUpgrade...Reverse installation. Database reset and create table.....");
                } else {
                    a(sQLiteDatabase, f.this.f569b);
                }
                switch (i) {
                    case 1:
                        com.bytedance.sdk.component.utils.m.a("DBHelper", "onUpgrade.....perform table creation.....");
                        a(sQLiteDatabase);
                        break;
                    case 2:
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                        a(sQLiteDatabase);
                        break;
                    case 3:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.n.b());
                        a(sQLiteDatabase);
                        break;
                    case 4:
                        sQLiteDatabase.execSQL(b.b.a.a.d.e.b.a.d());
                        a(sQLiteDatabase);
                        break;
                    case 5:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.m.b());
                        a(sQLiteDatabase);
                        break;
                    case 6:
                        a(sQLiteDatabase);
                        break;
                    default:
                        break;
                }
            } catch (Throwable unused) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.d.a());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.h.a());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.n.a());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.m.a());
        }
    }
}
