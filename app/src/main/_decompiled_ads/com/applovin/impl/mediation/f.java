package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private final Map<String, g> alZ = Collections.synchronizedMap(new HashMap(16));
    private final Object ama = new Object();
    private final Map<String, Class<? extends MaxAdapter>> amb = new HashMap();
    private final Set<String> amc = new HashSet();
    private final Object amd = new Object();
    private final Set<a> ame = new HashSet();
    private final x mLogger;
    private final n mSdk;

    public f(n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.mSdk = nVar;
        this.mLogger = nVar.BL();
    }

    public Collection<String> tX() {
        Set setUnmodifiableSet;
        synchronized (this.ama) {
            HashSet hashSet = new HashSet(this.amb.size());
            Iterator<Class<? extends MaxAdapter>> it = this.amb.values().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getName());
            }
            setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return setUnmodifiableSet;
    }

    public Collection<String> tY() {
        Set setUnmodifiableSet;
        synchronized (this.ama) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.amc);
        }
        return setUnmodifiableSet;
    }

    public Collection<JSONObject> tZ() {
        ArrayList arrayList;
        synchronized (this.amd) {
            arrayList = new ArrayList(this.ame.size());
            Iterator<a> it = this.ame.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().ua());
            }
        }
        return arrayList;
    }

    g c(com.applovin.impl.mediation.b.f fVar) {
        return a(fVar, false);
    }

    g a(com.applovin.impl.mediation.b.f fVar, boolean z) {
        Class<? extends MaxAdapter> clsBB;
        g gVar;
        if (fVar == null) {
            throw new IllegalArgumentException("No adapter spec specified");
        }
        String strYz = fVar.yz();
        String strVt = fVar.vt();
        if (TextUtils.isEmpty(strYz)) {
            if (x.Fk()) {
                this.mLogger.i("MediationAdapterManager", "No adapter name provided for " + strVt + ", not loading the adapter ");
            }
            return null;
        }
        if (TextUtils.isEmpty(strVt)) {
            if (x.Fk()) {
                this.mLogger.i("MediationAdapterManager", "Unable to find default className for '" + strYz + "'");
            }
            return null;
        }
        if (z && (gVar = this.alZ.get(strVt)) != null) {
            return gVar;
        }
        synchronized (this.ama) {
            if (!this.amc.contains(strVt)) {
                if (this.amb.containsKey(strVt)) {
                    clsBB = this.amb.get(strVt);
                } else {
                    clsBB = bB(strVt);
                    if (clsBB == null) {
                        this.amc.add(strVt);
                        return null;
                    }
                }
                g gVarA = a(fVar, clsBB, z);
                if (gVarA != null) {
                    if (x.Fk()) {
                        this.mLogger.f("MediationAdapterManager", "Loaded " + strYz);
                    }
                    this.amb.put(strVt, clsBB);
                    if (z) {
                        this.alZ.put(fVar.vt(), gVarA);
                    }
                    return gVarA;
                }
                if (x.Fk()) {
                    this.mLogger.i("MediationAdapterManager", "Failed to load " + strYz);
                }
                this.amc.add(strVt);
                return null;
            }
            if (x.Fk()) {
                this.mLogger.f("MediationAdapterManager", "Not attempting to load " + strYz + " due to prior errors");
            }
            return null;
        }
    }

    public void a(String str, String str2, com.applovin.impl.mediation.b.a aVar) {
        synchronized (this.amd) {
            this.mSdk.BL();
            if (x.Fk()) {
                this.mSdk.BL().i("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
            }
            this.ame.add(new a(str, str2, aVar, this.mSdk));
        }
    }

    private g a(com.applovin.impl.mediation.b.f fVar, Class<? extends MaxAdapter> cls, boolean z) {
        try {
            return new g(fVar, (MediationAdapterBase) cls.getConstructor(AppLovinSdk.class).newInstance(this.mSdk.getWrappingSdk()), z, this.mSdk);
        } catch (Throwable th) {
            x.e("MediationAdapterManager", "Failed to load adapter: " + fVar, th);
            return null;
        }
    }

    private Class<? extends MaxAdapter> bB(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return cls.asSubclass(MaxAdapter.class);
            }
            x.H("MediationAdapterManager", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class a {
        private final String amf;
        private final JSONObject amg;
        private final String className;
        private final MaxAdFormat format;

        a(String str, String str2, com.applovin.impl.mediation.b.a aVar, n nVar) {
            this.className = str;
            this.amf = str2;
            JSONObject jSONObject = new JSONObject();
            this.amg = jSONObject;
            JsonUtils.putString(jSONObject, "class", str);
            JsonUtils.putString(jSONObject, "operation", str2);
            if (aVar != null) {
                this.format = aVar.getFormat();
                JsonUtils.putString(jSONObject, "format", aVar.getFormat().getLabel());
            } else {
                this.format = null;
            }
        }

        JSONObject ua() {
            return this.amg;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.className.equals(aVar.className) || !this.amf.equals(aVar.amf)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.format;
            MaxAdFormat maxAdFormat2 = aVar.format;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int iHashCode = ((this.className.hashCode() * 31) + this.amf.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.format;
            return iHashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.className + "', operationTag='" + this.amf + "', format=" + this.format + '}';
        }
    }
}
