package b.b.a.a.d.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: TmplDbHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile d d = null;
    public static int e = 20;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f105b = new Object();
    private LruCache<String, b.b.a.a.d.e.c.b> c = new a(this, e);
    private Set<String> a = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: compiled from: TmplDbHelper.java */
    class a extends LruCache<String, b.b.a.a.d.e.c.b> {
        a(d dVar, int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, b.b.a.a.d.e.c.b bVar) {
            return 1;
        }
    }

    private d() {
    }

    public static void a(int i) {
        e = i;
    }

    public static d c() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    Set<String> b(String str) {
        if (!TextUtils.isEmpty(str) && b.b.a.a.d.e.a.a.d().a() != null) {
            HashSet hashSet = new HashSet();
            Cursor cursorA = b.b.a.a.d.e.a.a.d().a().a("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
            try {
                if (cursorA != null) {
                    if (cursorA.moveToFirst()) {
                        do {
                            hashSet.add(cursorA.getString(cursorA.getColumnIndex("id")));
                        } while (cursorA.moveToNext());
                        return hashSet;
                    }
                }
            } catch (Exception e2) {
                Log.e("TmplDbHelper", "", e2);
            } finally {
                cursorA.close();
            }
        }
        return null;
    }

    b.b.a.a.d.e.c.b a(String str) {
        b.b.a.a.d.e.c.b bVar;
        b.b.a.a.d.e.c.b bVarA;
        if (TextUtils.isEmpty(str) || b.b.a.a.d.e.a.a.d().a() == null) {
            return null;
        }
        synchronized (this.f105b) {
            bVar = this.c.get(String.valueOf(str));
        }
        if (bVar != null) {
            return bVar;
        }
        Cursor cursorA = b.b.a.a.d.e.a.a.d().a().a("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorA != null) {
            try {
                if (cursorA.moveToFirst()) {
                    do {
                        String string = cursorA.getString(cursorA.getColumnIndex("rit"));
                        String string2 = cursorA.getString(cursorA.getColumnIndex("id"));
                        String string3 = cursorA.getString(cursorA.getColumnIndex("md5"));
                        String string4 = cursorA.getString(cursorA.getColumnIndex("url"));
                        String string5 = cursorA.getString(cursorA.getColumnIndex("data"));
                        bVarA = new b.b.a.a.d.e.c.b().d(string).b(string2).c(string3).e(string4).a(string5).f(cursorA.getString(cursorA.getColumnIndex("version"))).a(Long.valueOf(cursorA.getLong(cursorA.getColumnIndex("update_time"))));
                        synchronized (this.f105b) {
                            this.c.put(string2, bVarA);
                        }
                        this.a.add(string2);
                    } while (cursorA.moveToNext());
                    cursorA.close();
                    return bVarA;
                }
                cursorA.close();
            } catch (Throwable th) {
                try {
                    m.b("TmplDbHelper", "getTemplate error", th);
                } finally {
                    cursorA.close();
                }
            }
        }
        return null;
    }

    private void c(String str) {
        LruCache<String, b.b.a.a.d.e.c.b> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.c) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.f105b) {
            this.c.remove(str);
        }
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }

    List<b.b.a.a.d.e.c.b> a() {
        if (b.b.a.a.d.e.a.a.d().a() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorA = b.b.a.a.d.e.a.a.d().a().a("template_diff_new", null, null, null, null, null, null);
        if (cursorA != null) {
            while (cursorA.moveToNext()) {
                try {
                    String string = cursorA.getString(cursorA.getColumnIndex("rit"));
                    String string2 = cursorA.getString(cursorA.getColumnIndex("id"));
                    String string3 = cursorA.getString(cursorA.getColumnIndex("md5"));
                    String string4 = cursorA.getString(cursorA.getColumnIndex("url"));
                    String string5 = cursorA.getString(cursorA.getColumnIndex("data"));
                    arrayList.add(new b.b.a.a.d.e.c.b().d(string).b(string2).c(string3).e(string4).a(string5).f(cursorA.getString(cursorA.getColumnIndex("version"))).a(Long.valueOf(cursorA.getLong(cursorA.getColumnIndex("update_time")))));
                    synchronized (this.f105b) {
                        this.c.put(string2, (b.b.a.a.d.e.c.b) arrayList.get(arrayList.size() - 1));
                    }
                    this.a.add(string2);
                } catch (Throwable th) {
                    try {
                        m.b("TmplDbHelper", "getTemplate error", th);
                    } finally {
                        if (cursorA != null) {
                            cursorA.close();
                        }
                    }
                }
            }
            if (cursorA != null) {
            }
        }
        return arrayList;
    }

    void a(b.b.a.a.d.e.c.b bVar) {
        if (bVar == null || b.b.a.a.d.e.a.a.d().a() == null || TextUtils.isEmpty(bVar.b())) {
            return;
        }
        Cursor cursorA = b.b.a.a.d.e.a.a.d().a().a("template_diff_new", null, "id=?", new String[]{bVar.b()}, null, null, null);
        boolean z = cursorA != null && cursorA.getCount() > 0;
        if (cursorA != null) {
            try {
                cursorA.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", bVar.d());
        contentValues.put("id", bVar.b());
        contentValues.put("md5", bVar.c());
        contentValues.put("url", bVar.f());
        contentValues.put("data", bVar.a());
        contentValues.put("version", bVar.g());
        contentValues.put("update_time", bVar.e());
        if (z) {
            b.b.a.a.d.e.a.a.d().a().a("template_diff_new", contentValues, "id=?", new String[]{bVar.b()});
        } else {
            b.b.a.a.d.e.a.a.d().a().a("template_diff_new", contentValues);
        }
        synchronized (this.f105b) {
            this.c.put(bVar.b(), bVar);
        }
        this.a.add(bVar.b());
    }

    void a(Set<String> set) {
        if (set == null || set.isEmpty() || b.b.a.a.d.e.a.a.d().a() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                c(strArr[i]);
                b.b.a.a.d.e.a.a.d().a().a("template_diff_new", "id=?", new String[]{strArr[i]});
            }
        }
    }
}
