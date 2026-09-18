package com.applovin.impl.privacy.b;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final SharedPreferences ays;
    private Integer ayt;
    private Integer ayu;
    private Integer ayv;
    private String ayw;
    private String ayx;
    private String ayy;
    private final List<c> ayz;
    private final n sdk;

    public Integer An() {
        return this.ayt;
    }

    public Integer Ao() {
        return this.ayu;
    }

    public Integer Ap() {
        return this.ayv;
    }

    public String Aq() {
        return this.ayw;
    }

    public String Ar() {
        return this.ayx;
    }

    public List<c> As() {
        return this.ayz;
    }

    public b(n nVar) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(n.getApplicationContext());
        this.ays = defaultSharedPreferences;
        this.ayz = new ArrayList();
        this.sdk = nVar;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.ayt = cr(com.applovin.impl.sdk.c.d.aRp.getName());
        this.ayu = cr(com.applovin.impl.sdk.c.d.aRq.getName());
        this.ayv = Al();
        this.ayw = (String) e.a((com.applovin.impl.sdk.c.d<Object>) com.applovin.impl.sdk.c.d.aRs, (Object) null, defaultSharedPreferences, false);
        this.ayx = (String) e.a((com.applovin.impl.sdk.c.d<Object>) com.applovin.impl.sdk.c.d.aRt, (Object) null, defaultSharedPreferences, false);
        this.ayy = (String) e.a((com.applovin.impl.sdk.c.d<Object>) com.applovin.impl.sdk.c.d.aRu, (Object) null, defaultSharedPreferences, false);
        cs(this.ayx);
    }

    public void F(List<com.applovin.impl.mediation.debugger.b.c.b> list) {
        Iterator<com.applovin.impl.mediation.debugger.b.c.b> it = list.iterator();
        while (it.hasNext()) {
            this.ayz.add(new c(it.next()));
        }
        ct(this.ayy);
        cu(this.ayx);
    }

    public String Ak() {
        return a.l(this.ayt);
    }

    public String uI() {
        return b("CMP Name", Ak()) + b("CMP SDK ID", this.ayt) + b("CMP SDK Version", this.ayu) + b(com.applovin.impl.sdk.c.d.aRr.getName(), this.ayv) + b(com.applovin.impl.sdk.c.d.aRs.getName(), this.ayw) + b(com.applovin.impl.sdk.c.d.aRt.getName(), this.ayx);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreferences are cleared - setting all stored TC data to null");
            }
            Am();
            return;
        }
        if (str.equals(com.applovin.impl.sdk.c.d.aRp.getName())) {
            this.ayt = cr(str);
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.ayt);
            }
            this.sdk.Bs();
            return;
        }
        if (str.equals(com.applovin.impl.sdk.c.d.aRq.getName())) {
            this.ayu = cr(str);
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.ayu);
                return;
            }
            return;
        }
        if (str.equals(com.applovin.impl.sdk.c.d.aRr.getName())) {
            this.ayv = Al();
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.ayv);
                return;
            }
            return;
        }
        if (str.equals(com.applovin.impl.sdk.c.d.aRs.getName())) {
            this.ayw = (String) e.a(str, (Object) null, String.class, sharedPreferences);
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreference entry updated - key: " + str + ", value: " + this.ayw);
            }
            this.sdk.Bs();
            return;
        }
        if (str.equals(com.applovin.impl.sdk.c.d.aRt.getName())) {
            this.ayx = (String) e.a(str, (Object) null, String.class, sharedPreferences);
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.ayx);
            }
            cs(this.ayx);
            cu(this.ayx);
            return;
        }
        if (str.equals(com.applovin.impl.sdk.c.d.aRu.getName())) {
            this.ayy = (String) e.a(str, (Object) null, String.class, sharedPreferences);
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.ayy);
            }
            ct(this.ayy);
            return;
        }
        if (str.equals(com.applovin.impl.sdk.c.d.aRv.getName())) {
            String str2 = (String) e.a(str, (Object) null, String.class, sharedPreferences);
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str2);
                return;
            }
            return;
        }
        if (str.equals(com.applovin.impl.sdk.c.d.aRw.getName())) {
            String str3 = (String) e.a(str, (Object) null, String.class, sharedPreferences);
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str3);
                return;
            }
            return;
        }
        if (str.equals(com.applovin.impl.sdk.c.d.aRx.getName())) {
            String str4 = (String) e.a(str, (Object) null, String.class, sharedPreferences);
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str4);
                return;
            }
            return;
        }
        if (str.contains("IABTCF_PublisherRestrictions")) {
            String str5 = (String) e.a(str, (Object) null, String.class, sharedPreferences);
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str5);
            }
        }
    }

    private Integer cr(String str) {
        if (this.ays.contains(str)) {
            Integer num = (Integer) e.a(str, null, Integer.class, this.ays, false);
            if (num != null) {
                return num;
            }
            Long l = (Long) e.a(str, null, Long.class, this.ays, false);
            if (l != null && l.longValue() >= -2147483648L && l.longValue() <= 2147483647L) {
                return Integer.valueOf(l.intValue());
            }
            String str2 = (String) e.a(str, null, String.class, this.ays, false);
            if (str2 != null) {
                if (StringUtils.isNumeric(str2)) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().i("TcfManager", "String value (" + str2 + ") for " + str + " is not numeric - storing value as null");
                }
            }
        }
        return null;
    }

    private Integer Al() {
        String name = com.applovin.impl.sdk.c.d.aRr.getName();
        if (this.ays.contains(name)) {
            Integer num = (Integer) e.a(name, null, Integer.class, this.ays, false);
            if (num != null) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    return num;
                }
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().i("TcfManager", "Integer value (" + num + ") for " + name + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Long l = (Long) e.a(name, null, Long.class, this.ays, false);
            if (l != null) {
                if (l.longValue() == 1 || l.longValue() == 0) {
                    return Integer.valueOf(l.intValue());
                }
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().i("TcfManager", "Long value (" + l + ") for " + name + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Boolean bool = (Boolean) e.a(name, null, Boolean.class, this.ays, false);
            if (bool != null) {
                return Integer.valueOf(bool.booleanValue() ? 1 : 0);
            }
            String str = (String) e.a(name, null, String.class, this.ays, false);
            if (str != null) {
                if ("1".equals(str) || "true".equals(str)) {
                    return 1;
                }
                if ("0".equals(str) || TJAdUnitConstants.String.FALSE.equals(str)) {
                    return 0;
                }
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().i("TcfManager", "String value (" + str + ") for " + name + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
        }
        return null;
    }

    private void cs(String str) {
        x.D("TcfManager", "Attempting to update consent from Additional Consent string: " + str);
        if (d.cx(str)) {
            if (d.b(str, a.cp("APPLOVIN_NETWORK"))) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("TcfManager", "Found AppLovin ID - setting user consent to true");
                }
                AppLovinPrivacySettings.setHasUserConsent(true, n.getApplicationContext());
            } else {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("TcfManager", "Could not find AppLovin ID - setting user consent to false");
                }
                AppLovinPrivacySettings.setHasUserConsent(false, n.getApplicationContext());
            }
            this.sdk.Bs();
        }
    }

    private void ct(String str) {
        if (str != null) {
            for (c cVar : this.ayz) {
                if (cVar.At() == c.a.TCF_VENDOR && cVar.Av() != null) {
                    cVar.c(Boolean.valueOf(d.e(str, cVar.Av().intValue() - 1)));
                }
            }
            return;
        }
        Iterator<c> it = this.ayz.iterator();
        while (it.hasNext()) {
            it.next().c(null);
        }
    }

    private void cu(String str) {
        boolean zCx = d.cx(str);
        List listAsList = zCx ? Arrays.asList(str.substring(2).split("\\.")) : null;
        for (c cVar : this.ayz) {
            if (cVar.At() == c.a.ATP_NETWORK && cVar.Av() != null) {
                if (zCx) {
                    cVar.c(Boolean.valueOf(listAsList.contains(cVar.Av().toString())));
                } else {
                    cVar.c(null);
                }
            }
        }
    }

    private void Am() {
        this.ayt = null;
        this.ayv = null;
        this.ayw = null;
        this.ayx = null;
        this.ayy = null;
        Iterator<c> it = this.ayz.iterator();
        while (it.hasNext()) {
            it.next().c(null);
        }
    }

    private String b(String str, Object obj) {
        return "\n" + str + " - " + (obj != null ? obj.toString() : "No value set");
    }
}
