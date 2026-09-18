package com.kakao.adfit.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: compiled from: AdIdClient.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static volatile b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f1820b;

    private static b a(Context context) {
        try {
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            b bVar = new b(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
            f.c("Get Advertising Id from Google Play services. [id = " + bVar.a() + "] [isLimitAdTrackingEnabled = " + bVar.b() + "]");
            return bVar;
        } catch (ClassNotFoundException unused) {
            f.b("Failed to get Advertising Id from Google Play services. [error = Could not find API class]");
            return null;
        } catch (Exception e) {
            f.b("Failed to get Advertising Id from Google Play services: [error = " + e.getMessage() + "]");
            return null;
        }
    }

    public static e b(Context context) {
        b bVarE = a;
        if (bVarE == null && (bVarE = e(context)) != null) {
            a = bVarE;
        }
        if (bVarE != null) {
            long jC = bVarE.c();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jC <= jCurrentTimeMillis && jCurrentTimeMillis < jC + 60000) {
                return bVarE;
            }
        }
        f(context);
        b bVar = a;
        return bVar != null ? bVar : new e("", true);
    }

    public static void c(Context context) {
        if (a == null) {
            f(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Context context) {
        if (a == null) {
            a = e(context);
        }
        b bVarA = a(context);
        if (bVarA == null) {
            bVarA = new b("", true);
        }
        a = bVarA;
        a(context, bVarA);
    }

    private static b e(Context context) {
        SharedPreferences sharedPreferencesA = a0.a(context);
        if (sharedPreferencesA.contains("adfit_adid") && sharedPreferencesA.contains("adfit_limited")) {
            return new b(sharedPreferencesA.getString("adfit_adid", ""), sharedPreferencesA.getBoolean("adfit_limited", true), sharedPreferencesA.getLong("adfit_cached_time", 0L));
        }
        return null;
    }

    private static void f(final Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (f1820b > jElapsedRealtime) {
            return;
        }
        f1820b = jElapsedRealtime + 10000;
        new Thread(new Runnable() { // from class: com.kakao.adfit.k.-$$Lambda$d$zqoFJrXx2coVrG_9mEqxNmJ2kGs
            @Override // java.lang.Runnable
            public final void run() {
                d.d(context);
            }
        }).start();
    }

    /* JADX INFO: compiled from: AdIdClient.java */
    private static class b extends e {
        private final long c;

        public long c() {
            return this.c;
        }

        private b(String str, boolean z) {
            this(str, z, System.currentTimeMillis());
        }

        private b(String str, boolean z, long j) {
            super(str, z);
            this.c = j;
        }
    }

    private static void a(Context context, b bVar) {
        SharedPreferences.Editor editorEdit = a0.a(context).edit();
        editorEdit.putString("adfit_adid", bVar.a());
        editorEdit.putBoolean("adfit_limited", bVar.b());
        editorEdit.putLong("adfit_cached_time", bVar.c());
        editorEdit.apply();
    }
}
