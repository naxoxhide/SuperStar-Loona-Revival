package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: VideoReportData.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {
    public static int a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f2098b;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private int J;
    private String L;
    private String M;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private String h;
    private int i;
    private int j;
    private int k;
    private String l;
    private String m;
    private int n;
    private int o;
    private String p;
    private long q;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    private int r = 0;
    private int I = 0;
    private int K = 0;

    public final String a() {
        return this.c;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final String b() {
        return this.d;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final String c() {
        return this.e;
    }

    public final void c(String str) {
        this.e = URLEncoder.encode(str);
    }

    public final int d() {
        return this.K;
    }

    public final void a(int i) {
        this.K = i;
    }

    public final String e() {
        return this.G;
    }

    public final void d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.G = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String f() {
        return this.F;
    }

    public final void e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.F = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String g() {
        return this.E;
    }

    public final void f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.E = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String h() {
        return this.D;
    }

    public final void g(String str) {
        this.D = str;
    }

    public final String i() {
        return this.H;
    }

    public final void h(String str) {
        this.H = str;
    }

    public final String j() {
        return this.x;
    }

    public final void i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.x = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public final void j(String str) {
        this.z = str;
    }

    public final int k() {
        return this.I;
    }

    public final void b(int i) {
        this.I = i;
    }

    public final int l() {
        return this.J;
    }

    public final void c(int i) {
        this.J = i;
    }

    public final String m() {
        return this.L;
    }

    public final void k(String str) {
        this.L = str;
    }

    public final String n() {
        return this.M;
    }

    public final void l(String str) {
        this.M = str;
    }

    public n(String str, int i, int i2, int i3, int i4, String str2, String str3, int i5, String str4, int i6, String str5) {
        this.f = str;
        this.g = i;
        this.h = str5;
        this.i = i2;
        this.j = i3;
        this.k = i4;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.m = str3;
        this.o = i5;
        this.p = str4;
        this.q = i6;
    }

    public n() {
    }

    public n(String str, int i, String str2, String str3, String str4) {
        this.f = str;
        this.h = str4;
        this.g = i;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.m = str3;
    }

    public n(String str, int i, int i2, String str2, int i3, String str3, int i4, String str4) {
        this.f = str;
        this.g = i;
        this.h = str4;
        this.k = i2;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.o = i3;
        this.p = str3;
        this.q = i4;
    }

    public n(Context context, CampaignEx campaignEx, int i, String str, long j, int i2) {
        if (i2 == 1 || i2 == 287 || i2 == 94) {
            this.f = "2000022";
        } else if (i2 == 95) {
            this.f = "2000025";
        }
        int iR = w.r(context);
        this.g = iR;
        this.h = w.a(context, iR);
        this.k = campaignEx.getVideoLength();
        try {
            this.l = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.o = i;
        this.p = str;
        this.q = j == 0 ? campaignEx.getVideoSize() : j;
    }

    public n(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        this.f = str;
        this.A = str2;
        this.y = str3;
        this.B = str4;
        this.v = str5;
        this.w = str6;
        this.g = i;
        this.h = str7;
    }

    public n(String str) {
        this.C = str;
    }

    public n(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f = str;
        this.o = i;
        this.p = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.E = URLEncoder.encode(str3, "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.w = str4;
        this.v = str5;
        this.m = str6;
        this.D = str7;
        if (Integer.valueOf(str2).intValue() > com.mbridge.msdk.foundation.same.a.n) {
            this.o = 2;
        }
    }

    public n(String str, String str2, String str3, String str4, String str5, int i) {
        this.f = str;
        this.w = str2;
        this.s = str3;
        this.u = str4;
        this.v = str5;
        this.g = i;
    }

    public n(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6) {
        this.f = str;
        this.w = str2;
        this.s = str3;
        this.u = str4;
        this.v = str5;
        this.g = i;
        this.m = str6;
        this.n = i2;
    }

    public final String o() {
        return this.s;
    }

    public final void m(String str) {
        this.s = str;
    }

    public final void n(String str) {
        this.t = str;
    }

    public final String p() {
        return this.u;
    }

    public final void o(String str) {
        this.u = str;
    }

    public final String q() {
        return this.v;
    }

    public final void p(String str) {
        this.v = str;
    }

    public final String r() {
        return this.w;
    }

    public final void q(String str) {
        this.w = str;
    }

    public final String s() {
        return this.f;
    }

    public final void r(String str) {
        this.f = str;
    }

    public final int t() {
        return this.j;
    }

    public final int u() {
        return this.k;
    }

    public final String v() {
        return this.l;
    }

    public final String w() {
        return TextUtils.isEmpty(this.m) ? "" : this.m;
    }

    public final void s(String str) {
        this.m = str;
    }

    public final String x() {
        return this.p;
    }

    public final void t(String str) {
        this.p = str;
    }

    public final long y() {
        return this.q;
    }

    public final int z() {
        return this.g;
    }

    public final void d(int i) {
        this.g = i;
    }

    public final String A() {
        return this.h;
    }

    public final void u(String str) {
        this.h = str;
    }

    public final int B() {
        return this.i;
    }

    public final int C() {
        return this.o;
    }

    public final void e(int i) {
        this.o = i;
    }

    public static String a(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n nVar : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + nVar.f + "&").append("network_type=" + nVar.g + "&").append("network_str=" + nVar.h + "&").append("reason=" + nVar.w() + "&").append("cid=" + nVar.w + "&").append("video_url=" + nVar.F + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("unit_id=" + nVar.v + "&").append("offer_url=" + nVar.l).append("\n");
            } else {
                stringBuffer.append("key=" + nVar.f + "&").append("reason=" + nVar.w() + "&").append("cid=" + nVar.w + "&").append("video_url=" + nVar.F + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("unit_id=" + nVar.v + "&").append("offer_url=" + nVar.l).append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String b(List<n> list) {
        StringBuffer stringBuffer;
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.c != null) {
                stringBuffer2.append("resource_type=" + next.c + "&");
            }
            if (next.e != null) {
                stringBuffer2.append("creative=" + next.e + "&");
            }
            Iterator<n> it2 = it;
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer = stringBuffer2;
                stringBuffer2.append("key=" + next.f + "&").append("network_type=" + next.g + "&").append("network_str=" + next.h + "&").append("result=" + next.o + "&").append("duration=" + next.p + "&").append("video_size=" + next.q + "&").append("video_length=" + next.k + "&").append("reason=" + next.w() + "&").append("cid=" + next.w + "&").append("video_url=" + next.F + "&").append("rid=" + next.s + "&").append("rid_n=" + next.u + "&").append("unit_id=" + next.v + "&").append("offer_url=" + next.l).append("\n");
            } else {
                stringBuffer = stringBuffer2;
                stringBuffer.append("key=" + next.f + "&").append("result=" + next.o + "&").append("duration=" + next.p + "&").append("video_size=" + next.q + "&").append("video_length=" + next.k + "&").append("reason=" + next.w() + "&").append("cid=" + next.w + "&").append("video_url=" + next.F + "&").append("rid=" + next.s + "&").append("rid_n=" + next.u + "&").append("unit_id=" + next.v + "&").append("offer_url=" + next.l).append("\n");
            }
            it = it2;
            stringBuffer2 = stringBuffer;
        }
        return stringBuffer2.toString();
    }

    public static String a(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f + "&").append("cid=" + nVar.w + "&").append("unit_id=" + nVar.v + "&").append("network_type=" + nVar.g + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("reason=" + nVar.w()).append("\n");
        return stringBuffer.toString();
    }

    public static String b(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f + "&").append("cid=" + nVar.w + "&").append("unit_id=" + nVar.v + "&").append("network_type=" + nVar.g + "&").append("mraid_type=" + nVar.I + "&").append("rid_n=" + nVar.u + "&").append("rid=" + nVar.s);
        return stringBuffer.toString();
    }

    public static String c(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f + "&").append("result=" + nVar.o + "&").append("duration=" + nVar.p + "&").append("cid=" + nVar.w + "&").append("reason=" + nVar.w() + "&").append("ad_type=" + nVar.H + "&").append("unit_id=" + nVar.v + "&").append("devid=" + nVar.d + "&").append("mraid_type=" + nVar.I + "&").append("network_type=" + nVar.g + "&");
        if (!TextUtils.isEmpty(nVar.E)) {
            stringBuffer.append("endcard_url=" + nVar.E + "&");
        }
        if (!TextUtils.isEmpty(nVar.D)) {
            stringBuffer.append("type=" + nVar.D + "&");
        }
        if (nVar.c != null) {
            stringBuffer.append("resource_type=" + nVar.c + "&");
        }
        stringBuffer.append("rid_n=" + nVar.u + "&");
        stringBuffer.append("rid=" + nVar.s);
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static String d(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f + "&").append("result=" + nVar.o + "&").append("duration=" + nVar.p + "&").append("cid=" + nVar.w + "&").append("unit_id=" + nVar.v + "&").append("reason=" + nVar.w() + "&").append("ad_type=" + nVar.H + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("network_type=" + nVar.g + "&").append("mraid_type=" + nVar.I + "&").append("devid=" + nVar.d + "&");
        if (nVar.c != null) {
            stringBuffer.append("resource_type=" + nVar.c + "&");
        }
        if (!TextUtils.isEmpty(nVar.E)) {
            stringBuffer.append("endcard_url=" + nVar.E + "&");
        }
        stringBuffer.append("type=" + nVar.D);
        return stringBuffer.toString();
    }

    public static String c(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n nVar : list) {
            stringBuffer.append("key=" + nVar.f + "&").append("result=" + nVar.o + "&").append("duration=" + nVar.p + "&").append("endcard_url=" + nVar.E + "&").append("cid=" + nVar.w + "&").append("unit_id=" + nVar.v + "&").append("reason=" + nVar.w() + "&").append("ad_type=" + nVar.H + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("type=" + nVar.D + "&").append("adspace_t=" + nVar.J).append("\n");
        }
        return stringBuffer.toString();
    }

    public static String d(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n nVar : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + nVar.f + "&").append("network_type=" + nVar.g + "&").append("result=" + nVar.o + "&").append("cid=" + nVar.w + "&").append("template_url=" + nVar.x + "&").append("reason=" + nVar.w() + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("unit_id=" + nVar.v + "&").append("\n");
            } else {
                stringBuffer.append("key=" + nVar.f + "&").append("result=" + nVar.o + "&").append("cid=" + nVar.w + "&").append("template_url=" + nVar.x + "&").append("reason=" + nVar.w() + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("unit_id=" + nVar.v + "&").append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String e(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n nVar : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + nVar.f + "&").append("network_type=" + nVar.g + "&").append("cid=" + nVar.w + "&").append("image_url=" + nVar.G + "&").append("reason=" + nVar.w() + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("unit_id=" + nVar.v + "&").append("\n");
            } else {
                stringBuffer.append("key=" + nVar.f + "&").append("cid=" + nVar.w + "&").append("image_url=" + nVar.G + "&").append("reason=" + nVar.w() + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("unit_id=" + nVar.v + "&").append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String e(n nVar) {
        if (nVar == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + nVar.f + "&").append("error=" + af.d(nVar.z) + "&").append("template_url=" + af.d(nVar.x) + "&").append("unit_id=" + af.d(nVar.v) + "&").append("cid=" + af.d(nVar.w) + "&").append("network_str=" + nVar.h + "&").append("network_type=" + nVar.g);
            } else {
                stringBuffer.append("key=" + nVar.f + "&").append("error=" + af.d(nVar.z) + "&").append("template_url=" + af.d(nVar.x) + "&").append("unit_id=" + af.d(nVar.v) + "&").append("cid=" + af.d(nVar.w) + "&");
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String f(n nVar) {
        if (nVar == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + nVar.f + "&").append("event=" + af.d(nVar.A) + "&").append("template=" + af.d(nVar.y) + "&").append("layout=" + af.d(nVar.B) + "&").append("unit_id=" + af.d(nVar.v) + "&").append("cid=" + af.d(nVar.w) + "&").append("network_str=" + nVar.h + "&").append("network_type=" + nVar.g);
            } else {
                stringBuffer.append("key=" + nVar.f + "&").append("event=" + af.d(nVar.A) + "&").append("template=" + af.d(nVar.y) + "&").append("layout=" + af.d(nVar.B) + "&").append("unit_id=" + af.d(nVar.v) + "&").append("cid=" + af.d(nVar.w) + "&");
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String f(List<n> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<n> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().C).append("\n");
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            aa.b("VideoReportData", th.getMessage(), th);
            return null;
        }
    }

    public static String g(n nVar) {
        if (nVar == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f + "&").append("cid=" + nVar.w + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("unit_id=" + nVar.v + "&").append("network_type=" + nVar.g + "&").append("mraid_type=" + nVar.I + "&").append("platform=1");
        return stringBuffer.toString();
    }

    public static String h(n nVar) {
        if (nVar == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + nVar.f + "&").append("cid=" + nVar.w + "&").append("rid=" + nVar.s + "&").append("rid_n=" + nVar.u + "&").append("unit_id=" + nVar.v + "&").append("reason=" + nVar.w() + "&").append("case=" + nVar.n + "&").append("network_type=" + nVar.g);
        return stringBuffer.toString();
    }

    public final String toString() {
        return "RewardReportData [key=" + this.f + ", networkType=" + this.g + ", isCompleteView=" + this.i + ", watchedMillis=" + this.j + ", videoLength=" + this.k + ", offerUrl=" + this.l + ", reason=" + this.m + ", result=" + this.o + ", duration=" + this.p + ", videoSize=" + this.q + "]";
    }
}
