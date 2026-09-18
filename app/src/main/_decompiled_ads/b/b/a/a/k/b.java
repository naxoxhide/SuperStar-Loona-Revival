package b.b.a.a.k;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.m;

/* JADX INFO: compiled from: DelegateRunnable.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Runnable, Comparable {
    private g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f247b;
    private long c;

    public b(g gVar, a aVar) {
        this.a = null;
        this.f247b = null;
        this.c = 0L;
        this.a = gVar;
        this.f247b = aVar;
        this.c = SystemClock.uptimeMillis();
    }

    private void a(String str, String str2, long j) {
        m.b("DelegateRunnable", "pool is " + str + "  name is " + str2 + "is timeout,cost " + j);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof b) {
            return this.a.compareTo(((b) obj).a());
        }
        return 0;
    }

    public boolean equals(Object obj) {
        g gVar;
        return (obj instanceof b) && (gVar = this.a) != null && gVar.equals(((b) obj).a());
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Runnable
    public void run() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.c;
        Thread.currentThread();
        g gVar = this.a;
        if (gVar != null) {
            gVar.run();
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
        if (this.f247b != null) {
            d.a();
        }
        if (m.b()) {
            Object[] objArr = new Object[8];
            byte b2 = 0;
            objArr[0] = "run: pool  = ";
            a aVar = this.f247b;
            objArr[1] = aVar != null ? aVar.a() : "null";
            objArr[2] = " waitTime =";
            objArr[3] = Long.valueOf(j);
            objArr[4] = " taskCost = ";
            objArr[5] = Long.valueOf(jUptimeMillis2);
            objArr[6] = " name=";
            g gVar2 = this.a;
            objArr[7] = gVar2 != null ? gVar2.getName() : "null";
            m.c("DelegateRunnable", objArr);
            String strA = this.f247b.a();
            strA.hashCode();
            strA.hashCode();
            switch (strA.hashCode()) {
                case 3107:
                    if (!strA.equals("ad")) {
                        b2 = -1;
                    }
                    break;
                case 3366:
                    b2 = !strA.equals("io") ? (byte) -1 : (byte) 1;
                    break;
                case 107332:
                    b2 = !strA.equals("log") ? (byte) -1 : (byte) 2;
                    break;
                case 3237136:
                    b2 = !strA.equals("init") ? (byte) -1 : (byte) 3;
                    break;
                case 212371911:
                    b2 = !strA.equals("computation") ? (byte) -1 : (byte) 4;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                case 3:
                    if (jUptimeMillis2 > 2000) {
                        a aVar2 = this.f247b;
                        String strA2 = aVar2 != null ? aVar2.a() : "null";
                        g gVar3 = this.a;
                        a(strA2, gVar3 != null ? gVar3.getName() : "null", jUptimeMillis2);
                    }
                    break;
                case 1:
                    if (jUptimeMillis2 > 5000) {
                        a aVar3 = this.f247b;
                        String strA3 = aVar3 != null ? aVar3.a() : "null";
                        g gVar4 = this.a;
                        a(strA3, gVar4 != null ? gVar4.getName() : "null", jUptimeMillis2);
                    }
                    break;
                case 2:
                    if (jUptimeMillis2 > 3000) {
                        a aVar4 = this.f247b;
                        String strA4 = aVar4 != null ? aVar4.a() : "null";
                        g gVar5 = this.a;
                        a(strA4, gVar5 != null ? gVar5.getName() : "null", jUptimeMillis2);
                    }
                    break;
                case 4:
                    if (jUptimeMillis2 > 1000) {
                        a aVar5 = this.f247b;
                        String strA5 = aVar5 != null ? aVar5.a() : "null";
                        g gVar6 = this.a;
                        a(strA5, gVar6 != null ? gVar6.getName() : "null", jUptimeMillis2);
                    }
                    break;
            }
        }
    }

    public g a() {
        return this.a;
    }
}
