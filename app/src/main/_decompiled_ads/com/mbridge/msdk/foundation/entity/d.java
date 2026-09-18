package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ClickTime.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2088b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;
    private String h;
    private String i;
    private int j;
    private int k;
    private String l;
    private int m;
    private int n;
    private String o;
    private int p;
    private String q;
    private int r;

    public d() {
    }

    public d(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, int i2, int i3, String str9, int i4, int i5, String str10, int i6, int i7, String str11) {
        this.a = str;
        this.f2088b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = i;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = i2;
        this.k = i3;
        this.l = str9;
        this.m = i4;
        this.n = i5;
        this.o = str10;
        this.p = i6;
        this.q = str11;
        this.r = i7;
    }

    public final void a(int i) {
        this.p = i;
    }

    public final void a(String str) {
        this.q = str;
    }

    public final void b(String str) {
        this.l = str;
    }

    public final void b(int i) {
        this.m = i;
    }

    public final void c(int i) {
        this.n = i;
    }

    public final void c(String str) {
        this.o = str;
    }

    public final void d(int i) {
        this.k = i;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final void e(int i) {
        this.f = i;
    }

    public final void e(String str) {
        this.h = str;
    }

    public final void f(String str) {
        this.i = str;
    }

    public final void f(int i) {
        this.j = i;
    }

    public final void g(String str) {
        this.e = str;
    }

    public final void h(String str) {
        this.c = str;
    }

    public final void i(String str) {
        this.d = str;
    }

    public final void j(String str) {
        this.a = str;
    }

    public final void k(String str) {
        this.f2088b = str;
    }

    public static String a(List<d> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            d next = it.next();
            String str = next.l;
            if (!TextUtils.isEmpty(str)) {
                String str2 = com.mbridge.msdk.foundation.controller.b.c.get(str);
                StringBuilder sbAppend = new StringBuilder().append("u_stid=");
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(sbAppend.append(str2).append("&").toString());
            }
            Iterator<d> it2 = it;
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                sb.append("rid=" + next.a).append("&rid_n=" + next.f2088b).append("&network_type=" + next.p).append("&network_str=" + next.q).append("&cid=" + next.c).append("&click_type=" + next.k).append("&type=" + next.j).append("&click_duration=" + next.d).append("&key=2000013").append("&unit_id=" + next.l).append("&last_url=" + next.e).append("&content=" + next.i).append("&code=" + next.f).append("&exception=" + next.g).append("&header=" + next.h).append("&landing_type=" + next.m).append("&link_type=" + next.n).append("&click_time=" + next.o + "\n");
            } else {
                sb.append("rid=" + next.a).append("&rid_n=" + next.f2088b).append("&cid=" + next.c).append("&click_type=" + next.k).append("&type=" + next.j).append("&click_duration=" + next.d).append("&key=2000013").append("&unit_id=" + next.l).append("&last_url=" + next.e).append("&content=" + next.i).append("&code=" + next.f).append("&exception=" + next.g).append("&header=" + next.h).append("&landing_type=" + next.m).append("&link_type=" + next.n).append("&click_time=" + next.o + "\n");
            }
            it = it2;
        }
        return sb.toString();
    }

    public static String a(d dVar) {
        if (dVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = dVar.e;
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            sb.append("rid=" + dVar.a).append("&rid_n=" + dVar.f2088b).append("&network_type=" + dVar.p).append("&network_str=" + dVar.q).append("&click_type=" + dVar.k).append("&type=" + dVar.j).append("&cid=" + dVar.c).append("&click_duration=" + dVar.d).append("&key=2000012").append("&unit_id=" + dVar.l).append("&last_url=" + str).append("&code=" + dVar.f).append("&exception=" + dVar.g).append("&landing_type=" + dVar.m).append("&link_type=" + dVar.n).append("&click_time=" + dVar.o + "\n");
        } else {
            sb.append("rid=" + dVar.a).append("&rid_n=" + dVar.f2088b).append("&click_type=" + dVar.k).append("&type=" + dVar.j).append("&cid=" + dVar.c).append("&click_duration=" + dVar.d).append("&key=2000012").append("&unit_id=" + dVar.l).append("&last_url=" + str).append("&code=" + dVar.f).append("&exception=" + dVar.g).append("&landing_type=" + dVar.m).append("&link_type=" + dVar.n).append("&click_time=" + dVar.o + "\n");
        }
        return sb.toString();
    }

    public final String toString() {
        return "ClickTime [campaignId=" + this.c + ", click_duration=" + this.d + ", lastUrl=" + this.e + ", code=" + this.f + ", excepiton=" + this.g + ", header=" + this.h + ", content=" + this.i + ", type=" + this.j + ", click_type=" + this.k + "]";
    }
}
