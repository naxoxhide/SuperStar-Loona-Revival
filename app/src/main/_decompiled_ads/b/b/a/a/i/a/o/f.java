package b.b.a.a.i.a.o;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tapjoy.TapjoyConstants;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: TrackRetryRepertoryImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements e {
    private Context a;

    public f(Context context) {
        this.a = context;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0064 A[DONT_GENERATE, PHI: r1
      0x0064: PHI (r1v4 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v1 android.database.Cursor) binds: [B:21:0x0062, B:12:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.b.a.a.i.a.o.e
    public List<d> a() {
        LinkedList linkedList = new LinkedList();
        Cursor cursorA = b.b.a.a.i.a.j.g.c.a(this.a, "trackurl", null, null, null, null, null, null);
        if (cursorA != null) {
            while (cursorA.moveToNext()) {
                try {
                    linkedList.add(new d(cursorA.getString(cursorA.getColumnIndex("id")), cursorA.getString(cursorA.getColumnIndex("url")), cursorA.getInt(cursorA.getColumnIndex("replaceholder")) > 0, cursorA.getInt(cursorA.getColumnIndex(TapjoyConstants.TJC_RETRY))));
                } catch (Throwable unused) {
                    if (cursorA != null) {
                        try {
                            cursorA.close();
                            cursorA = null;
                        } finally {
                            if (cursorA != null) {
                                cursorA.close();
                            }
                        }
                    }
                }
            }
            if (cursorA != null) {
            }
        }
        return linkedList;
    }

    @Override // b.b.a.a.i.a.o.e
    public void b(d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", dVar.a());
        contentValues.put("url", dVar.c());
        contentValues.put("replaceholder", Integer.valueOf(dVar.d() ? 1 : 0));
        contentValues.put(TapjoyConstants.TJC_RETRY, Integer.valueOf(dVar.b()));
        b.b.a.a.i.a.j.g.c.a(this.a, "trackurl", contentValues);
    }

    @Override // b.b.a.a.i.a.o.e
    public void c(d dVar) {
        b.b.a.a.i.a.j.g.c.a(this.a, "trackurl", "id=?", new String[]{dVar.a()});
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, " + TapjoyConstants.TJC_RETRY + " INTEGER default 0)";
    }

    @Override // b.b.a.a.i.a.o.e
    public void a(d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", dVar.a());
        contentValues.put("url", dVar.c());
        contentValues.put("replaceholder", Integer.valueOf(dVar.d() ? 1 : 0));
        contentValues.put(TapjoyConstants.TJC_RETRY, Integer.valueOf(dVar.b()));
        b.b.a.a.i.a.j.g.c.a(this.a, "trackurl", contentValues, "id=?", new String[]{dVar.a()});
    }
}
