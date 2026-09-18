package com.fyber.inneractive.sdk.config.global;

import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class j implements d {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f881b;

    public j(String str, boolean z) {
        this.a = str;
        this.f881b = z;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0108  */
    /* JADX WARN: Code duplicated, block: B:48:0x010b  */
    /* JADX WARN: Code duplicated, block: B:50:0x010f  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.config.global.d
    public boolean a(e eVar) {
        boolean z;
        boolean z2;
        if (TextUtils.isEmpty(this.a)) {
            return false;
        }
        String version = InneractiveAdManager.getVersion();
        IAlog.a("%s: shouldApply - running version: %s", "j", version);
        IAlog.a("%s: shouldApply - filter version: %s", "j", this.a);
        String[] strArrSplit = version.split("\\.", 4);
        String[] strArrSplit2 = this.a.split("\\.", 4);
        String str = strArrSplit2[strArrSplit2.length - 1];
        if (str.equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
            int i = 0;
            while (true) {
                if (i >= strArrSplit2.length - 1) {
                    IAlog.a("%s: shouldApplyByAsterix - version aligned with filter. do not apply", "j");
                    z2 = false;
                    break;
                }
                if (strArrSplit.length < i) {
                    IAlog.a("%s: shouldApplyByAsterix - running version is shorter than filter. applying", "j");
                } else if (strArrSplit[i].equals(strArrSplit2[i])) {
                    i++;
                } else {
                    IAlog.a("%s: shouldApplyByAsterix - running version does not comply with filter. applying", "j");
                }
                z2 = true;
                break;
            }
            IAlog.a("%s: shouldApply - * version match: %b", "j", Boolean.valueOf(!z2));
            if (z2) {
                return this.f881b;
            }
            return !this.f881b;
        }
        if (!str.equals("+")) {
            boolean z3 = !this.a.equalsIgnoreCase(version);
            IAlog.a("%s: shouldApply - exact version match: %b", "j", Boolean.valueOf(!z3));
            if (z3) {
                return this.f881b;
            }
            return !this.f881b;
        }
        int i2 = 0;
        while (true) {
            if (i2 < strArrSplit2.length - 1) {
                if (strArrSplit.length < i2) {
                    IAlog.a("%s: shouldApplyByPlus - running version is shorter than filter. applying", "j");
                } else {
                    try {
                        int iIntValue = Integer.valueOf(strArrSplit2[i2]).intValue();
                        int iIntValue2 = Integer.valueOf(strArrSplit[i2]).intValue();
                        if (iIntValue2 > iIntValue) {
                            IAlog.a("%s: shouldApplyByPlus - running version is greater than the filter's version. no filter needed", "j");
                        } else if (iIntValue2 < iIntValue) {
                            IAlog.a("%s: shouldApplyByPlus - running version is lower than the filter's version. applying filter ", "j");
                        } else {
                            i2++;
                        }
                    } catch (NumberFormatException e) {
                        IAlog.a("%s: shouldApplyByPlus - Error in version string! Not a number. %s", "j", e.getMessage());
                    }
                }
                z = true;
                IAlog.a("%s: shouldApply - + version match: %b", "j", Boolean.valueOf(!z));
                if (z) {
                    return this.f881b;
                }
                if (this.f881b) {
                    return false;
                }
                return true;
            }
            IAlog.a("%s: shouldApplyByAsterix - version aligned with filter. do not apply", "j");
            z = false;
            IAlog.a("%s: shouldApply - + version match: %b", "j", Boolean.valueOf(!z));
            if (z) {
                return this.f881b;
            }
            if (this.f881b) {
                return true;
            }
            return false;
        }
    }

    public String toString() {
        return String.format("%s - %s include: %b", "sdk", this.a, Boolean.valueOf(this.f881b));
    }
}
