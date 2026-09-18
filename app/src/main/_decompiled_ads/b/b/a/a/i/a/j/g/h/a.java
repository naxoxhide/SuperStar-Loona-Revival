package b.b.a.a.i.a.j.g.h;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import b.b.a.a.i.a.i;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdEventRepoImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    private final Context e;
    private b.b.a.a.i.a.m.d.a f;
    protected List<String> g;

    public a(Context context, b.b.a.a.i.a.m.d.a aVar) {
        super(context);
        this.g = new ArrayList();
        this.e = context;
        this.f = aVar;
        if (aVar == null) {
            this.f = b.b.a.a.i.a.m.d.a.a();
        }
    }

    public List<b.b.a.a.i.a.m.a> a(int i, String str) {
        long jA = b.b.a.a.i.a.k.a.a(i, a());
        b.b.a.a.i.a.l.c.d("" + b() + " query db max :" + jA + " limit:" + i);
        String str2 = (jA <= 0 || TextUtils.isEmpty(str)) ? null : str + " DESC limit " + jA;
        LinkedList linkedList = new LinkedList();
        this.g.clear();
        Cursor cursorA = b.b.a.a.i.a.j.g.c.a(a(), b(), new String[]{"id", "value", "encrypt"}, null, null, null, null, str2);
        if (cursorA != null) {
            try {
                b.b.a.a.i.a.f fVarA = i.f().a();
                while (cursorA.moveToNext()) {
                    try {
                        String string = cursorA.getString(cursorA.getColumnIndex("id"));
                        String string2 = cursorA.getString(cursorA.getColumnIndex("value"));
                        if (cursorA.getInt(cursorA.getColumnIndex("encrypt")) == 1) {
                            string2 = fVarA.a(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            b.b.a.a.i.a.l.c.a("log_show_query : value is null");
                            this.g.add(string);
                        } else {
                            JSONObject jSONObject = new JSONObject(string2);
                            b.b.a.a.i.a.m.c.a aVar = new b.b.a.a.i.a.m.c.a(string, jSONObject);
                            aVar.a(e());
                            aVar.b(f());
                            b.b.a.a.i.a.l.a.a(jSONObject, aVar);
                            linkedList.add(aVar);
                        }
                    } catch (Throwable th) {
                        b.b.a.a.i.a.l.c.b(th.getMessage());
                    }
                }
                if (cursorA != null) {
                    try {
                        cursorA.close();
                        if (!this.g.isEmpty()) {
                            d(this.g);
                            this.g.clear();
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th2) {
                if (cursorA != null) {
                    try {
                        cursorA.close();
                        if (!this.g.isEmpty()) {
                            d(this.g);
                            this.g.clear();
                        }
                    } catch (Exception unused2) {
                    }
                }
                throw th2;
            }
        }
        b.b.a.a.i.a.l.c.d("" + b() + " query db actually size :" + linkedList.size());
        return linkedList;
    }

    @Override // b.b.a.a.i.a.j.g.h.c
    public String b() {
        b.b.a.a.i.a.j.e eVarD = i.f().d();
        if (eVarD != null) {
            return eVarD.b();
        }
        return null;
    }

    public void c(List<b.b.a.a.i.a.m.a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (b.b.a.a.i.a.m.a aVar : list) {
            linkedList.add(aVar.i());
            b.b.a.a.i.a.l.a.b(aVar);
        }
        b.b.a.a.i.a.l.c.a("PADLT", b() + " adevent repo delete: " + linkedList.size());
        b.b.a.a.i.a.j.g.c.a(a(), "DELETE FROM " + b() + " WHERE " + a("id", linkedList, 1000, true));
        a(linkedList);
    }

    protected void d(List<String> list) {
        b.b.a.a.i.a.l.c.a("PADLT", b() + " adevent repo delete: " + list.size());
        b.b.a.a.i.a.j.g.c.a(a(), "DELETE FROM " + b() + " WHERE " + a("id", list, 1000, true));
        b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.a0(), list.size());
        a(list);
    }

    public byte e() {
        return (byte) 0;
    }

    public byte f() {
        return (byte) 2;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002e A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0 r1
      0x002e: PHI (r0v3 int) = (r0v0 int), (r0v5 int) binds: [B:12:0x002c, B:6:0x0022] A[DONT_GENERATE, DONT_INLINE]
      0x002e: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:12:0x002c, B:6:0x0022] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public int g() {
        int i = 0;
        Cursor cursorA = null;
        try {
            cursorA = b.b.a.a.i.a.j.g.c.a(a(), b(), new String[]{"count(1)"}, null, null, null, null, null);
            if (cursorA != null) {
                cursorA.moveToFirst();
                i = cursorA.getInt(0);
            }
        } catch (Exception unused) {
        } finally {
            if (cursorA != null) {
                try {
                    cursorA.close();
                } catch (Exception unused2) {
                }
            }
        }
        return i;
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS " + i.f().d().b() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public List<b.b.a.a.i.a.m.a> a(String str) {
        b.b.a.a.i.a.m.d.a aVar = this.f;
        if (aVar == null) {
            return new ArrayList();
        }
        return a(aVar.d(), str);
    }

    public boolean a(int i) {
        if (this.f == null) {
            return false;
        }
        int iG = g();
        int iE = this.f.e();
        b.b.a.a.i.a.l.c.d("" + b() + " check dbCount:" + iG + " MaxCacheCount:" + iE + " message:" + i);
        if (b.b.a.a.i.a.l.a.d() && (i == 1 || i == 2)) {
            return iG >= 1;
        }
        return iG >= iE;
    }

    private static String a(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int iMin = Math.min(i, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i2 = size / iMin;
        } else {
            i2 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * iMin;
            String strA = a(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str).append(str2).append("('").append(strA).append("')");
        }
        return a(sb.toString(), str + str2 + "('')");
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
