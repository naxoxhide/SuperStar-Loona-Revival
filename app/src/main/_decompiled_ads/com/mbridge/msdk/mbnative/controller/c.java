package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.List;

/* JADX INFO: compiled from: NativeVideoTrackingReport.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final String a = "com.mbridge.msdk.mbnative.controller.c";

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                q qVarA = q.a(h.a(context));
                if (TextUtils.isEmpty(str) || qVarA == null || qVarA.a() <= 0) {
                    return;
                }
                List<n> listA = qVarA.a("2000022");
                List<n> listA2 = qVarA.a("2000021");
                List<n> listA3 = qVarA.a("2000043");
                String strA = n.a(listA2);
                String strB = n.b(listA);
                String strC = n.c(listA3);
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(strA)) {
                    sb.append(strA);
                }
                if (!TextUtils.isEmpty(strB)) {
                    sb.append(strB);
                }
                if (!TextUtils.isEmpty(strC)) {
                    sb.append(strC);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    return;
                }
                String string = sb.toString();
                if (context == null || TextUtils.isEmpty(string) || TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, com.mbridge.msdk.foundation.same.report.q.a(string, context, str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.mbnative.controller.c.1
                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void onSuccess(String str2) {
                            aa.d(c.a, str2);
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void onFailed(String str2) {
                            aa.d(c.a, str2);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    aa.d(a, e.getMessage());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
