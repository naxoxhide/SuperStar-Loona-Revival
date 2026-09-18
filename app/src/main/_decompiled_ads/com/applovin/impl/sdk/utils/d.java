package com.applovin.impl.sdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.tapjoy.TapjoyConstants;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static boolean aVe = true;
    private static final Object aVf = new Object();
    private static final Collection<CountDownLatch> aVg = new HashSet();
    private static boolean aVh = false;
    private static a aVi = null;

    public static a S(Context context) {
        return T(context);
    }

    private static a T(Context context) {
        a aVar;
        HashSet hashSet;
        u.LC();
        Object obj = aVf;
        synchronized (obj) {
            if (aVh) {
                return aVi;
            }
            Collection<CountDownLatch> collection = aVg;
            boolean zIsEmpty = collection.isEmpty();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            collection.add(countDownLatch);
            if (zIsEmpty) {
                a aVarU = U(context);
                synchronized (obj) {
                    aVh = true;
                    aVi = aVarU;
                    hashSet = new HashSet(collection);
                    collection.clear();
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((CountDownLatch) it.next()).countDown();
                }
            }
            try {
                if (!countDownLatch.await(60L, TimeUnit.SECONDS)) {
                    com.applovin.impl.sdk.x.H("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }: collection timeout");
                }
            } catch (InterruptedException e) {
                com.applovin.impl.sdk.x.e("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", e);
            }
            synchronized (aVf) {
                aVar = aVi;
            }
            return aVar;
        }
    }

    private static a U(Context context) {
        a aVarCollectGoogleAdvertisingInfo = collectGoogleAdvertisingInfo(context);
        if (aVarCollectGoogleAdvertisingInfo == null) {
            aVarCollectGoogleAdvertisingInfo = collectFireOSAdvertisingInfo(context);
        }
        return aVarCollectGoogleAdvertisingInfo == null ? new a() : aVarCollectGoogleAdvertisingInfo;
    }

    private static a collectGoogleAdvertisingInfo(Context context) {
        u.LC();
        if (KN()) {
            try {
                a aVar = new a();
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                boolean zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                aVar.bi(zIsLimitAdTrackingEnabled);
                aVar.a(zIsLimitAdTrackingEnabled ? a.EnumC0140a.ON : a.EnumC0140a.OFF);
                aVar.dB(advertisingIdInfo.getId());
                return aVar;
            } catch (Throwable th) {
                if (AppLovinSdkUtils.isFireOS(context)) {
                    return null;
                }
                com.applovin.impl.sdk.x.e("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th);
                return null;
            }
        }
        if (AppLovinSdkUtils.isFireOS(context)) {
            return null;
        }
        com.applovin.impl.sdk.x.H("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
        return null;
    }

    public static boolean KN() {
        return u.dI("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    private static a collectFireOSAdvertisingInfo(Context context) {
        if (aVe) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                a aVar = new a();
                aVar.dB(StringUtils.emptyIfNull(Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ADVERTISING_ID)));
                boolean z = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0;
                aVar.bi(z);
                aVar.a(z ? a.EnumC0140a.ON : a.EnumC0140a.OFF);
                return aVar;
            } catch (Settings.SettingNotFoundException e) {
                com.applovin.impl.sdk.x.e("DataCollector", "Unable to determine if Fire OS limited ad tracking is turned on", e);
            } catch (Throwable th) {
                com.applovin.impl.sdk.x.e("DataCollector", "Unable to collect Fire OS IDFA", th);
            }
        }
        aVe = false;
        return null;
    }

    public static class a {
        private boolean aVj;
        private String aVk = "";
        private EnumC0140a aVl = EnumC0140a.NOT_SET;

        public void a(EnumC0140a enumC0140a) {
            this.aVl = enumC0140a;
        }

        public void bi(boolean z) {
            this.aVj = z;
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof a;
        }

        public void dB(String str) {
            this.aVk = str;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.canEqual(this) || KO() != aVar.KO()) {
                return false;
            }
            String strKP = KP();
            String strKP2 = aVar.KP();
            if (strKP != null ? !strKP.equals(strKP2) : strKP2 != null) {
                return false;
            }
            EnumC0140a enumC0140aKQ = KQ();
            EnumC0140a enumC0140aKQ2 = aVar.KQ();
            return enumC0140aKQ != null ? enumC0140aKQ.equals(enumC0140aKQ2) : enumC0140aKQ2 == null;
        }

        public int hashCode() {
            int i = KO() ? 79 : 97;
            String strKP = KP();
            int iHashCode = ((i + 59) * 59) + (strKP == null ? 43 : strKP.hashCode());
            EnumC0140a enumC0140aKQ = KQ();
            return (iHashCode * 59) + (enumC0140aKQ != null ? enumC0140aKQ.hashCode() : 43);
        }

        public String toString() {
            return "AdvertisingInfoCollector.AdvertisingIdInformation(adTrackingLimited=" + KO() + ", advertisingId=" + KP() + ", dntCode=" + KQ() + ")";
        }

        /* JADX INFO: renamed from: com.applovin.impl.sdk.utils.d$a$a, reason: collision with other inner class name */
        public enum EnumC0140a {
            NOT_SET("dnt_not_set"),
            ON("dnt_on"),
            OFF("dnt_off");

            private final String aVp;

            EnumC0140a(String str) {
                this.aVp = str;
            }

            public String KR() {
                return this.aVp;
            }
        }

        public boolean KO() {
            return this.aVj;
        }

        public String KP() {
            return this.aVk;
        }

        public EnumC0140a KQ() {
            return this.aVl;
        }
    }
}
