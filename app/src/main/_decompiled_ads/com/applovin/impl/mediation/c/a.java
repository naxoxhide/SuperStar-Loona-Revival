package com.applovin.impl.mediation.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private final String advertiser;
    private final String auX;
    private final int auY;
    private final int auZ;
    private final String ava;
    private final JSONArray avb;
    private final List<String> avc;
    private final String body;
    private final List<String> jsTrackers;
    private final String title;
    private final String version;

    /* JADX INFO: Access modifiers changed from: private */
    public static String yR() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String yS() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String yT() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String yU() {
        return "";
    }

    /* JADX INFO: renamed from: com.applovin.impl.mediation.c.a$a, reason: collision with other inner class name */
    public static class C0118a {
        private String auX;
        private int auY;
        private int auZ;
        private String ava;
        private boolean avd;
        private String ave;
        private boolean avf;
        private String avg;
        private boolean avh;
        private String avi;
        private boolean avj;
        private String avk;
        private boolean avl;
        private JSONArray avm;
        private boolean avn;
        private List<String> avo;
        private boolean avp;
        private List<String> avq;

        C0118a() {
        }

        public C0118a D(List<String> list) {
            this.avo = list;
            this.avn = true;
            return this;
        }

        public C0118a E(List<String> list) {
            this.avq = list;
            this.avp = true;
            return this;
        }

        public C0118a b(JSONArray jSONArray) {
            this.avm = jSONArray;
            this.avl = true;
            return this;
        }

        public C0118a cb(String str) {
            this.ave = str;
            this.avd = true;
            return this;
        }

        public C0118a cc(String str) {
            this.avg = str;
            this.avf = true;
            return this;
        }

        public C0118a cd(String str) {
            this.avi = str;
            this.avh = true;
            return this;
        }

        public C0118a ce(String str) {
            this.avk = str;
            this.avj = true;
            return this;
        }

        public C0118a cf(String str) {
            this.auX = str;
            return this;
        }

        public C0118a cg(String str) {
            this.ava = str;
            return this;
        }

        public C0118a gs(int i) {
            this.auY = i;
            return this;
        }

        public C0118a gt(int i) {
            this.auZ = i;
            return this;
        }

        public String toString() {
            return "OpenRtbAdConfiguration.Builder(version$value=" + this.ave + ", title$value=" + this.avg + ", advertiser$value=" + this.avi + ", body$value=" + this.avk + ", mainImageUrl=" + this.auX + ", mainImageWidth=" + this.auY + ", mainImageHeight=" + this.auZ + ", clickDestinationUrl=" + this.ava + ", clickTrackingUrls$value=" + this.avm + ", jsTrackers$value=" + this.avo + ", impressionUrls$value=" + this.avq + ")";
        }

        public a zn() {
            String strYR = this.ave;
            if (!this.avd) {
                strYR = a.yR();
            }
            String str = strYR;
            String strYS = this.avg;
            if (!this.avf) {
                strYS = a.yS();
            }
            String str2 = strYS;
            String strYT = this.avi;
            if (!this.avh) {
                strYT = a.yT();
            }
            String str3 = strYT;
            String strYU = this.avk;
            if (!this.avj) {
                strYU = a.yU();
            }
            String str4 = strYU;
            JSONArray jSONArrayYV = this.avm;
            if (!this.avl) {
                jSONArrayYV = a.yV();
            }
            JSONArray jSONArray = jSONArrayYV;
            List<String> listYW = this.avo;
            if (!this.avn) {
                listYW = a.yW();
            }
            List<String> list = listYW;
            List<String> listYX = this.avq;
            if (!this.avp) {
                listYX = a.yX();
            }
            return new a(str, str2, str3, str4, this.auX, this.auY, this.auZ, this.ava, jSONArray, list, listYX);
        }
    }

    a(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, JSONArray jSONArray, List<String> list, List<String> list2) {
        this.version = str;
        this.title = str2;
        this.advertiser = str3;
        this.body = str4;
        this.auX = str5;
        this.auY = i;
        this.auZ = i2;
        this.ava = str6;
        this.avb = jSONArray;
        this.jsTrackers = list;
        this.avc = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONArray yV() {
        return new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> yW() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> yX() {
        return new ArrayList();
    }

    public static C0118a yY() {
        return new C0118a();
    }

    public String getVersion() {
        return this.version;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAdvertiser() {
        return this.advertiser;
    }

    public String getBody() {
        return this.body;
    }

    public String yZ() {
        return this.auX;
    }

    public int za() {
        return this.auY;
    }

    public int zb() {
        return this.auZ;
    }

    public String zc() {
        return this.ava;
    }

    public JSONArray zd() {
        return this.avb;
    }

    public List<String> ze() {
        return this.jsTrackers;
    }

    public List<String> zf() {
        return this.avc;
    }
}
