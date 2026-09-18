package b.a.a.a.a.a.b.c.m;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import b.b.a.a.k.h;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: VideoProxyDB.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c e;
    private final SparseArray<Map<String, b.a.a.a.a.a.b.c.m.a>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f51b;
    private final Executor c;
    private volatile SQLiteStatement d;

    /* JADX INFO: compiled from: VideoProxyDB.java */
    class a implements Runnable {
        final /* synthetic */ b.a.a.a.a.a.b.c.m.a a;

        a(b.a.a.a.a.a.b.c.m.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.this.d == null) {
                    c cVar = c.this;
                    cVar.d = cVar.f51b.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                } else {
                    c.this.d.clearBindings();
                }
                c.this.d.bindString(1, this.a.a);
                c.this.d.bindString(2, this.a.f50b);
                c.this.d.bindLong(3, this.a.c);
                c.this.d.bindLong(4, this.a.d);
                c.this.d.bindString(5, this.a.e);
                c.this.d.executeInsert();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: VideoProxyDB.java */
    class b implements Runnable {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.f51b.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(this.a)});
            } catch (Throwable unused) {
            }
        }
    }

    private c(Context context) {
        SparseArray<Map<String, b.a.a.a.a.a.b.c.m.a>> sparseArray = new SparseArray<>(2);
        this.a = sparseArray;
        this.c = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new h(5, "video_proxy_db"));
        this.f51b = new d(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public void b(int i) {
        Map<String, b.a.a.a.a.a.b.c.m.a> map = this.a.get(i);
        if (map != null) {
            map.clear();
        }
        this.c.execute(new b(i));
    }

    public static c a(Context context) {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c(context);
                }
            }
        }
        return e;
    }

    public b.a.a.a.a.a.b.c.m.a a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, b.a.a.a.a.a.b.c.m.a> map = this.a.get(i);
        b.a.a.a.a.a.b.c.m.a aVar = map == null ? null : map.get(str);
        if (aVar != null) {
            return aVar;
        }
        try {
            Cursor cursorQuery = this.f51b.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    aVar = new b.a.a.a.a.a.b.c.m.a(cursorQuery.getString(cursorQuery.getColumnIndex(SDKConstants.PARAM_KEY)), cursorQuery.getString(cursorQuery.getColumnIndex("mime")), cursorQuery.getInt(cursorQuery.getColumnIndex("contentLength")), i, cursorQuery.getString(cursorQuery.getColumnIndex("extra")));
                }
                cursorQuery.close();
            }
            if (aVar != null && map != null) {
                map.put(str, aVar);
            }
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(b.a.a.a.a.a.b.c.m.a aVar) {
        if (aVar != null) {
            Map<String, b.a.a.a.a.a.b.c.m.a> map = this.a.get(aVar.d);
            if (map != null) {
                map.put(aVar.a, aVar);
            }
            this.c.execute(new a(aVar));
        }
    }

    public void a(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        int i2 = -1;
        Map<String, b.a.a.a.a.a.b.c.m.a> map = this.a.get(i);
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i2++;
            strArr[i2] = str;
        }
        strArr[i2 + 1] = String.valueOf(i);
        try {
            this.f51b.getWritableDatabase().delete("video_http_header_t", "key IN(" + a(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    private String a(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }
}
