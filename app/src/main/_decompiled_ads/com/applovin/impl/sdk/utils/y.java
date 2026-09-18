package com.applovin.impl.sdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class y {
    public static final y aWu = new y();
    protected String JN;
    protected final List<y> SG;
    private final y aWv;
    private final String aWw;
    private final Map<String, String> aWx;

    public y(String str, Map<String, String> map, y yVar) {
        this.aWv = yVar;
        this.aWw = str;
        this.aWx = Collections.unmodifiableMap(map);
        this.SG = new ArrayList();
    }

    private y() {
        this.aWv = null;
        this.aWw = "";
        this.aWx = Collections.emptyMap();
        this.JN = "";
        this.SG = Collections.emptyList();
    }

    public String LG() {
        return this.aWw;
    }

    public Map<String, String> LH() {
        return this.aWx;
    }

    public String LI() {
        return this.JN;
    }

    public List<y> LJ() {
        return Collections.unmodifiableList(this.SG);
    }

    public List<y> dN(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        ArrayList arrayList = new ArrayList(this.SG.size());
        for (y yVar : this.SG) {
            if (str.equalsIgnoreCase(yVar.LG())) {
                arrayList.add(yVar);
            }
        }
        return arrayList;
    }

    public y dO(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        for (y yVar : this.SG) {
            if (str.equalsIgnoreCase(yVar.LG())) {
                return yVar;
            }
        }
        return null;
    }

    public y dP(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        if (this.SG.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        while (!arrayList.isEmpty()) {
            y yVar = (y) arrayList.get(0);
            arrayList.remove(0);
            if (str.equalsIgnoreCase(yVar.LG())) {
                return yVar;
            }
            arrayList.addAll(yVar.LJ());
        }
        return null;
    }

    public String toString() {
        return "XmlNode{elementName='" + this.aWw + "', text='" + this.JN + "', attributes=" + this.aWx + '}';
    }
}
