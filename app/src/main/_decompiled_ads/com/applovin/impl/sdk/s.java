package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class s {
    private final Map<String, Object> aEM;
    private final long aEN;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private final String f13do = UUID.randomUUID().toString();
    private final String name;

    public s(String str, Map<String, String> map, Map<String, Object> map2) {
        this.name = str;
        HashMap map3 = new HashMap();
        this.aEM = map3;
        map3.putAll(map);
        map3.put("applovin_sdk_super_properties", map2);
        this.aEN = System.currentTimeMillis();
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Object> ER() {
        return this.aEM;
    }

    public long ES() {
        return this.aEN;
    }

    public String mQ() {
        return this.f13do;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.aEN != sVar.aEN) {
            return false;
        }
        String str = this.name;
        if (str == null ? sVar.name != null : !str.equals(sVar.name)) {
            return false;
        }
        Map<String, Object> map = this.aEM;
        if (map == null ? sVar.aEM != null : !map.equals(sVar.aEM)) {
            return false;
        }
        String str2 = this.f13do;
        String str3 = sVar.f13do;
        if (str2 != null) {
            if (str2.equals(str3)) {
                return true;
            }
        } else if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Object> map = this.aEM;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        long j = this.aEN;
        int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f13do;
        return i + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Event{name='" + this.name + "', id='" + this.f13do + "', creationTimestampMillis=" + this.aEN + ", parameters=" + this.aEM + '}';
    }
}
