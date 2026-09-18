package com.mbridge.msdk.mbbid.common.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.HashMap;

/* JADX INFO: compiled from: BidReport.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String a = "com.mbridge.msdk.mbbid.common.c.a";

    public static void a(Context context, String str, String str2, String str3, String str4) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (ac.a().a("r_l_b_m_t_b_l", true)) {
            try {
                HashMap map = new HashMap();
                map.put("result", "1");
                map.put("network_type", w.r(context) + "");
                map.put("bidid", str2);
                map.put("bid_tk", str4);
                m.a().a("2000064", str3, BidResponsed.KEY_BID_ID, str, "", map);
                return;
            } catch (Exception unused) {
            }
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("key=").append("2000064").append("&").append("result=").append("1").append("&").append("network_type=").append(w.r(context)).append("&").append("bidid=").append(str2).append("&").append("ts=").append(System.currentTimeMillis()).append("&").append("lrid=").append(str3).append("&").append("bid_tk=").append(str4).append("&").append("unit_id=").append(str);
            if (k.a().c()) {
                k.a().a(sb.toString());
                return;
            }
            new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, d.a().a, q.a(sb.toString(), context, str), new b() { // from class: com.mbridge.msdk.mbbid.common.c.a.1
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onSuccess(String str5) {
                    aa.d(a.a, str5);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onFailed(String str5) {
                    aa.d(a.a, str5);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            aa.d(a, e.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (ac.a().a("r_l_b_m_t_b_l", true)) {
            try {
                HashMap map = new HashMap();
                map.put("result", "2");
                map.put("network_type", w.r(context) + "");
                map.put("reason", str2);
                m.a().a("2000064", str3, BidResponsed.KEY_BID_ID, str, "", map);
                return;
            } catch (Exception unused) {
            }
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("key=").append("2000064").append("&").append("result=").append("2").append("&").append("network_type=").append(w.r(context)).append("&").append("reason=").append(str2).append("&").append("ts=").append(System.currentTimeMillis()).append("&").append("lrid=").append(str3).append("&").append("unit_id=").append(str);
            new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, d.a().a, q.a(sb.toString(), context, str), new b() { // from class: com.mbridge.msdk.mbbid.common.c.a.2
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onSuccess(String str4) {
                    aa.d(a.a, str4);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onFailed(String str4) {
                    aa.d(a.a, str4);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            aa.d(a, e.getMessage());
        }
    }
}
