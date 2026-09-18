package com.tapjoy;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class TJUserParameters {
    public static TJUserParameters f;
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2702b = 0;
    public int c = 0;
    public String d = null;
    public TJSegment e = null;

    public static TJUserParameters getInstance() {
        if (f == null) {
            f = new TJUserParameters();
        }
        return f;
    }

    public final HashMap a() {
        String str;
        HashMap map = new HashMap();
        boolean z = false;
        if (this.f2702b > 0) {
            String appVersion = getAppVersion();
            int prevMaxLevel = getPrevMaxLevel();
            this.c = this.f2702b;
            Context context = this.a;
            if (context != null) {
                try {
                    this.d = context.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("", e.getMessage());
                }
            }
            if ((appVersion != null && !this.d.equals(appVersion)) || prevMaxLevel != this.f2702b) {
                Context context2 = this.a;
                if (context2 != null && this.c > 0) {
                    new TJKeyValueStorage(context2, TapjoyConstants.TJC_PREFERENCE).setValue(TapjoyConstants.PREF_USER_MAX_LEVEL_CACHE, Integer.valueOf(this.c));
                }
                if (this.a != null && (str = this.d) != null && !str.isEmpty()) {
                    new TJKeyValueStorage(this.a, TapjoyConstants.TJC_PREFERENCE).setValue(TapjoyConstants.PREF_APP_VERSION_CACHE, this.d);
                }
                z = true;
            }
        }
        if (z) {
            TapjoyUtil.safePut(map, TapjoyConstants.TJC_USER_MAX_LEVEL, this.f2702b + "", true);
        }
        return map;
    }

    public String getAppVersion() {
        return this.d;
    }

    public int getPrevMaxLevel() {
        return this.c;
    }

    public int getUserMaxLevel() {
        return this.f2702b;
    }

    public TJSegment getUserSegment() {
        TJSegment tJSegment = this.e;
        return tJSegment == null ? TJSegment.UNKNOWN : tJSegment;
    }

    public synchronized void setContext(Context context) {
        TJSegment tJSegment;
        if (context != null) {
            if (this.a == null) {
                this.a = context;
                TJUserParameters tJUserParameters = getInstance();
                TJKeyValueStorage tJKeyValueStorage = new TJKeyValueStorage(tJUserParameters.a, TapjoyConstants.TJC_PREFERENCE);
                if (tJUserParameters.f2702b <= 0 && tJKeyValueStorage.contains(TapjoyConstants.PREF_USER_MAX_LEVEL)) {
                    tJUserParameters.f2702b = tJKeyValueStorage.getInt(TapjoyConstants.PREF_USER_MAX_LEVEL, -1);
                }
                if (tJUserParameters.c <= 0 && tJKeyValueStorage.contains(TapjoyConstants.PREF_USER_MAX_LEVEL_CACHE)) {
                    tJUserParameters.c = tJKeyValueStorage.getInt(TapjoyConstants.PREF_USER_MAX_LEVEL_CACHE, -1);
                }
                if (tJUserParameters.d == null && tJKeyValueStorage.contains(TapjoyConstants.PREF_APP_VERSION_CACHE)) {
                    tJUserParameters.d = tJKeyValueStorage.getString(TapjoyConstants.PREF_APP_VERSION_CACHE, null);
                }
                if (tJUserParameters.e == null && tJKeyValueStorage.contains(TapjoyConstants.PREF_USER_SEGMENT)) {
                    tJUserParameters.e = TJSegment.valueOf(tJKeyValueStorage.getInt(TapjoyConstants.PREF_USER_SEGMENT, TJSegment.UNKNOWN.getValue()));
                }
                TJUserParameters tJUserParameters2 = getInstance();
                Context context2 = tJUserParameters2.a;
                if (context2 != null && tJUserParameters2.f2702b > 0) {
                    new TJKeyValueStorage(context2, TapjoyConstants.TJC_PREFERENCE).setValue(TapjoyConstants.PREF_USER_MAX_LEVEL, Integer.valueOf(tJUserParameters2.f2702b));
                }
                TJUserParameters tJUserParameters3 = getInstance();
                Context context3 = tJUserParameters3.a;
                if (context3 != null && (tJSegment = tJUserParameters3.e) != null) {
                    if (tJSegment == TJSegment.UNKNOWN) {
                        new TJKeyValueStorage(context3, TapjoyConstants.TJC_PREFERENCE).remove(TapjoyConstants.PREF_USER_SEGMENT);
                    } else {
                        new TJKeyValueStorage(context3, TapjoyConstants.TJC_PREFERENCE).setValue(TapjoyConstants.PREF_USER_SEGMENT, Integer.valueOf(tJUserParameters3.e.getValue()));
                    }
                }
            }
        }
    }

    public void setUserMaxLevel(int i) {
        if (i <= 0) {
            return;
        }
        this.f2702b = i;
        Context context = this.a;
        if (context == null || i <= 0) {
            return;
        }
        new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE).setValue(TapjoyConstants.PREF_USER_MAX_LEVEL, Integer.valueOf(this.f2702b));
    }

    public void setUserSegment(TJSegment tJSegment) {
        this.e = tJSegment;
        Context context = this.a;
        if (context == null || tJSegment == null) {
            return;
        }
        if (tJSegment == TJSegment.UNKNOWN) {
            new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE).remove(TapjoyConstants.PREF_USER_SEGMENT);
        } else {
            new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE).setValue(TapjoyConstants.PREF_USER_SEGMENT, Integer.valueOf(this.e.getValue()));
        }
    }
}
