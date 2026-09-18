package b.b.a.a.i.a.j.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import b.b.a.a.i.a.i;
import com.tapjoy.TapjoyConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: DBHelper.java */
/* JADX INFO: loaded from: classes.dex */
class b {
    private c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f206b;

    /* JADX INFO: renamed from: b.b.a.a.i.a.j.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DBHelper.java */
    private class C0042b extends AbstractCursor {
        private C0042b(b bVar) {
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

    b(Context context) {
        try {
            this.f206b = context.getApplicationContext();
            if (this.a == null) {
                this.a = new c();
            }
        } catch (Throwable unused) {
        }
    }

    public c a() {
        return this.a;
    }

    /* JADX INFO: compiled from: DBHelper.java */
    public class c {
        private volatile SQLiteDatabase a = null;

        public c() {
        }

        private void a() {
            try {
                if (this.a == null || !this.a.isOpen()) {
                    synchronized (this) {
                        try {
                            if (this.a == null || !this.a.isOpen()) {
                                this.a = i.f().d().a(i.f().c());
                                this.a.setLockingEnabled(false);
                                b.b.a.a.i.a.l.c.a("---------------DB CREATE  SUCCESS------------");
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (b()) {
                    throw th2;
                }
            }
        }

        private boolean b() {
            SQLiteDatabase sQLiteDatabase = this.a;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }

        public void a(String str) throws SQLException {
            try {
                a();
                this.a.execSQL(str);
            } catch (Throwable th) {
                if (b()) {
                    throw th;
                }
            }
        }

        public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                a();
                return this.a.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                C0042b c0042b = new C0042b();
                if (b()) {
                    throw th;
                }
                return c0042b;
            }
        }

        public int a(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                a();
                return this.a.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (b()) {
                    throw e;
                }
                return 0;
            }
        }

        public long a(String str, String str2, ContentValues contentValues) throws Exception {
            try {
                a();
                return this.a.insert(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                if (b()) {
                    throw e;
                }
                return -1L;
            }
        }

        public synchronized void a(String str, String str2, List<b.b.a.a.i.a.m.a> list) {
            JSONObject jSONObjectB;
            try {
                try {
                    a();
                    this.a.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (int i = 0; i < list.size(); i++) {
                        b.b.a.a.i.a.m.a aVar = list.get(i);
                        if (aVar != null && (jSONObjectB = aVar.b()) != null) {
                            contentValues.put("id", aVar.i());
                            String strB = i.f().a().b(jSONObjectB.toString());
                            if (!TextUtils.isEmpty(strB)) {
                                contentValues.put("value", strB);
                                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                contentValues.put(TapjoyConstants.TJC_RETRY, (Integer) 0);
                                contentValues.put("encrypt", (Integer) 1);
                                this.a.insert(str, str2, contentValues);
                            }
                            contentValues.clear();
                        }
                    }
                    this.a.setTransactionSuccessful();
                    b.b.a.a.i.a.l.c.b("DBHelper", str + " insert list size=" + list.size());
                    if (this.a != null) {
                        this.a.endTransaction();
                    }
                } catch (Throwable th) {
                    if (this.a != null) {
                        this.a.endTransaction();
                    }
                    throw th;
                }
            } catch (Exception e) {
                b.b.a.a.i.a.l.c.b("DBHelper", str + " insert list error=" + list.size());
                e.printStackTrace();
                if (!b()) {
                    if (this.a != null) {
                    }
                } else {
                    throw e;
                }
            }
        }

        public int a(String str, String str2, String[] strArr) throws Exception {
            try {
                a();
                return this.a.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (b()) {
                    throw e;
                }
                return 0;
            }
        }
    }
}
