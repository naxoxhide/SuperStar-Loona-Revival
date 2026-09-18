package b.b.a.a.k;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PoolTaskStatistics.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static AtomicInteger a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f248b = {"com.bytedance.sdk", "com.bykv.vk", "com.ss", "tt_pangle"};
    public static final String[] c = {"tt_pangle", "bd_tracker"};
    private static int d = 0;
    private static int e = 0;

    /* JADX INFO: compiled from: PoolTaskStatistics.java */
    public static class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f249b;
        public String c;

        public a(String str, int i, String str2, String str3) {
            this.a = 0;
            this.f249b = null;
            this.c = null;
            this.c = str;
            this.a = i;
            this.f249b = str3;
        }

        public void a(int i) {
            this.a = i;
        }

        public String toString() {
            return "ThreadModel{times=" + this.a + ", name='" + this.f249b + "', lastStackStack='" + this.c + "'}";
        }

        public int a() {
            return this.a;
        }
    }

    public static void a() {
        try {
            b();
        } catch (Throwable unused) {
        }
    }

    private static void b() {
        int i;
        c cVarG = e.g();
        if (cVarG == null) {
            return;
        }
        int i2 = 1;
        int iAddAndGet = a.addAndGet(1);
        int i3 = e.c;
        if (i3 < 0 || iAddAndGet % i3 != 0 || Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        HashMap map = new HashMap();
        if (allStackTraces == null) {
            return;
        }
        boolean zB = m.b();
        int size = allStackTraces.size();
        if (size > e) {
            e = size;
        }
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
        int i4 = 0;
        int i5 = 0;
        while (it.hasNext()) {
            Map.Entry<Thread, StackTraceElement[]> next = it.next();
            i5 += i2;
            Thread key = next.getKey();
            StackTraceElement[] value = next.getValue();
            StringBuilder sb = new StringBuilder("\n");
            if (zB) {
                sb.append("Thread Name is : " + key.getName());
                sb.append("\n");
            }
            String str = null;
            int length = value.length;
            int i6 = 0;
            while (i6 < length) {
                String string = value[i6].toString();
                Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = it;
                if (zB) {
                    sb.append(string + "\n");
                }
                if (TextUtils.isEmpty(str) && (a(string, f248b) || a(key.getName(), c))) {
                    i4++;
                    str = string;
                }
                i6++;
                it = it2;
            }
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it3 = it;
            if (zB) {
                if (TextUtils.isEmpty(str)) {
                    i = 1;
                } else {
                    String str2 = str + "&" + key.getName();
                    a aVar = (a) map.get(str2);
                    if (aVar != null) {
                        i = 1;
                        aVar.a(aVar.a() + 1);
                    } else {
                        i = 1;
                        aVar = new a(str2, 1, sb.toString(), key.getName());
                    }
                    map.put(str2, aVar);
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    Log.e("PoolTaskStatistics", "Thread index = " + i5 + "   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    Log.w("PoolTaskStatistics", sb.toString());
                }
            } else {
                i = 1;
            }
            i2 = i;
            it = it3;
        }
        if (i4 > d) {
            d = i4;
        }
        if (zB) {
            Log.e("PoolTaskStatistics", "SDK current threads=" + i4 + ", SDK Max threads=" + d + ", Application threads = " + size + ", Application max threads = " + e);
            Iterator it4 = map.entrySet().iterator();
            while (it4.hasNext()) {
                Log.i("PoolTaskStatistics", ((a) ((Map.Entry) it4.next()).getValue()).toString());
            }
        }
        cVarG.a(new b.b.a.a.k.j.a(i4, d, size, e));
    }

    private static boolean a(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
