package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: TTNetworkUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class w {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<b, Object> f331b = new ConcurrentHashMap();
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static volatile int d = -1;
    private static volatile long e = 0;
    private static volatile int f = 60000;
    private static q g = null;
    private static final AtomicBoolean h = new AtomicBoolean(false);

    /* JADX INFO: compiled from: TTNetworkUtils.java */
    static class a extends b.b.a.a.k.g {
        final /* synthetic */ boolean c;
        final /* synthetic */ Context d;
        final /* synthetic */ boolean e;
        final /* synthetic */ Intent f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, Context context, boolean z2, Intent intent) {
            super(str);
            this.c = z;
            this.d = context;
            this.e = z2;
            this.f = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            int unused = w.d = this.c ? 0 : w.c(this.d);
            w.h.set(false);
            if (this.e) {
                w.b(this.d, this.f, w.d, this.c);
            }
        }
    }

    /* JADX INFO: compiled from: TTNetworkUtils.java */
    public interface b {
        void a(Context context, Intent intent, boolean z, int i);
    }

    /* JADX INFO: compiled from: TTNetworkUtils.java */
    private static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (w.f331b != null && w.f331b.size() > 0) {
                z = true;
            }
            w.b(context, intent, z, booleanExtra);
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, Intent intent, boolean z, boolean z2) {
        if (!z && z2) {
            d = 0;
        } else if (h.compareAndSet(false, true)) {
            b.b.a.a.k.e.c(new a("getNetworkType", z2, context, z, intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(Context context) {
        d = b(context);
        e = SystemClock.elapsedRealtime();
        return d;
    }

    public static int a(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (e + j <= jElapsedRealtime) {
            return c(context);
        }
        if (d == -1) {
            return c(context);
        }
        if (jElapsedRealtime - e >= f) {
            b(context, (Intent) null, false, false);
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, Intent intent, int i, boolean z) {
        Map<b, Object> map = f331b;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (b bVar : map.keySet()) {
            if (bVar != null) {
                bVar.a(context, intent, !z, i);
            }
        }
    }

    private static int b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        q qVar = g;
                        return (qVar == null || !qVar.a(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static void a(b bVar, Context context) {
        if (bVar == null) {
            return;
        }
        if (!c.get()) {
            try {
                context.registerReceiver(new c(null), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                c.set(true);
            } catch (Throwable unused) {
            }
        }
        f331b.put(bVar, a);
    }

    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        f331b.remove(bVar);
    }
}
