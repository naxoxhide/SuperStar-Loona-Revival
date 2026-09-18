package com.tapjoy;

import android.content.Context;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class TJPrivacyPolicy {
    public static TJPrivacyPolicy f;
    public TJStatus a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TJStatus f2700b = null;
    public TJStatus c = null;
    public String d = null;
    public Context e;

    public static TJPrivacyPolicy getInstance() {
        if (f == null) {
            f = new TJPrivacyPolicy();
        }
        return f;
    }

    public final synchronized void a(Context context) {
        String str;
        if (context != null) {
            if (this.e == null) {
                this.e = context;
            }
        }
        TJPrivacyPolicy tJPrivacyPolicy = getInstance();
        Context context2 = tJPrivacyPolicy.e;
        if (context2 != null) {
            TJKeyValueStorage tJKeyValueStorage = new TJKeyValueStorage(context2, TapjoyConstants.TJC_PREFERENCE);
            if (tJPrivacyPolicy.a == null && tJKeyValueStorage.contains("gdpr")) {
                if (tJKeyValueStorage.getValueType("gdpr") == Boolean.class) {
                    tJPrivacyPolicy.a = tJKeyValueStorage.getBoolean("gdpr", false) ? TJStatus.TRUE : TJStatus.FALSE;
                } else if (tJKeyValueStorage.getValueType("gdpr") == Integer.class) {
                    tJPrivacyPolicy.a = TJStatus.valueOf(tJKeyValueStorage.getInt("gdpr", TJStatus.UNKNOWN.getValue()));
                }
            }
            if (tJPrivacyPolicy.f2700b == null && tJKeyValueStorage.contains("cgdpr")) {
                if (tJKeyValueStorage.getValueType("cgdpr") == String.class) {
                    tJPrivacyPolicy.f2700b = Objects.equals(tJKeyValueStorage.getString("cgdpr", ""), "1") ? TJStatus.TRUE : TJStatus.FALSE;
                } else if (tJKeyValueStorage.getValueType("cgdpr") == Integer.class) {
                    tJPrivacyPolicy.f2700b = TJStatus.valueOf(tJKeyValueStorage.getInt("cgdpr", TJStatus.UNKNOWN.getValue()));
                }
            }
            if (tJPrivacyPolicy.c == null && tJKeyValueStorage.contains("below_consent_age")) {
                if (tJKeyValueStorage.getValueType("below_consent_age") == Boolean.class) {
                    tJPrivacyPolicy.c = tJKeyValueStorage.getBoolean("below_consent_age", false) ? TJStatus.TRUE : TJStatus.FALSE;
                } else if (tJKeyValueStorage.getValueType("below_consent_age") == Integer.class) {
                    tJPrivacyPolicy.c = TJStatus.valueOf(tJKeyValueStorage.getInt("below_consent_age", TJStatus.UNKNOWN.getValue()));
                }
            }
            if (tJPrivacyPolicy.d == null) {
                tJPrivacyPolicy.d = tJKeyValueStorage.getString("us_privacy", "");
            }
        }
        TJPrivacyPolicy tJPrivacyPolicy2 = getInstance();
        if (tJPrivacyPolicy2.e != null) {
            tJPrivacyPolicy2.b();
            tJPrivacyPolicy2.c();
            tJPrivacyPolicy2.a();
            if (tJPrivacyPolicy2.e != null && (str = tJPrivacyPolicy2.d) != null) {
                if (str.isEmpty()) {
                    new TJKeyValueStorage(tJPrivacyPolicy2.e, TapjoyConstants.TJC_PREFERENCE).remove("us_privacy");
                } else {
                    new TJKeyValueStorage(tJPrivacyPolicy2.e, TapjoyConstants.TJC_PREFERENCE).setValue("us_privacy", tJPrivacyPolicy2.d);
                }
            }
        }
    }

    public final void b() {
        TJStatus tJStatus;
        Context context = this.e;
        if (context == null || (tJStatus = this.a) == null) {
            return;
        }
        if (tJStatus == TJStatus.UNKNOWN) {
            new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE).remove("gdpr");
        } else {
            new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE).setValue("gdpr", Integer.valueOf(this.a.getValue()));
        }
    }

    public final void c() {
        TJStatus tJStatus;
        Context context = this.e;
        if (context == null || (tJStatus = this.f2700b) == null) {
            return;
        }
        if (tJStatus == TJStatus.UNKNOWN) {
            new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE).remove("cgdpr");
        } else {
            new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE).setValue("cgdpr", Integer.valueOf(this.f2700b.getValue()));
        }
    }

    public TJStatus getBelowConsentAge() {
        return this.c;
    }

    public TJStatus getSubjectToGDPR() {
        return this.a;
    }

    public String getUSPrivacy() {
        return this.d;
    }

    public TJStatus getUserConsent() {
        return this.f2700b;
    }

    public void setBelowConsentAge(TJStatus tJStatus) {
        this.c = tJStatus;
        a();
    }

    public void setSubjectToGDPR(TJStatus tJStatus) {
        this.a = tJStatus;
        b();
    }

    public void setUSPrivacy(String str) {
        this.d = str;
        if (this.e == null || str == null) {
            return;
        }
        if (str.isEmpty()) {
            new TJKeyValueStorage(this.e, TapjoyConstants.TJC_PREFERENCE).remove("us_privacy");
        } else {
            new TJKeyValueStorage(this.e, TapjoyConstants.TJC_PREFERENCE).setValue("us_privacy", this.d);
        }
    }

    public void setUserConsent(TJStatus tJStatus) {
        this.f2700b = tJStatus;
        c();
    }

    public void setBelowConsentAge(boolean z) {
        this.c = z ? TJStatus.TRUE : TJStatus.FALSE;
        a();
    }

    public void setSubjectToGDPR(Boolean bool) {
        this.a = bool.booleanValue() ? TJStatus.TRUE : TJStatus.FALSE;
        b();
    }

    public void setUserConsent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f2700b = str.equals("1") ? TJStatus.TRUE : TJStatus.FALSE;
        c();
    }

    public final void a() {
        TJStatus tJStatus;
        Context context = this.e;
        if (context == null || (tJStatus = this.c) == null) {
            return;
        }
        if (tJStatus == TJStatus.UNKNOWN) {
            new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE).remove("below_consent_age");
        } else {
            new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE).setValue("below_consent_age", Integer.valueOf(this.c.getValue()));
        }
    }
}
