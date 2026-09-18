package com.mbridge.msdk.scheme.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;

/* JADX INFO: loaded from: classes4.dex */
public class AppletsReport {
    public static final String APPLETS_API_VALUE = "2000118";
    private static final String TAG = "com.mbridge.msdk.scheme.report.AppletsReport";

    public static void reportAppletsLoadState(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBufferAppend = new StringBuffer().append("key=2000118&");
                stringBufferAppend.append("network_type=" + w.r(context) + "&");
                stringBufferAppend.append("unit_id=" + str2 + "&");
                if (!TextUtils.isEmpty(a.l)) {
                    stringBufferAppend.append("b=" + a.l + "&");
                }
                if (!TextUtils.isEmpty(a.m)) {
                    stringBufferAppend.append("c=" + a.m + "&");
                }
                stringBufferAppend.append("hb=0&");
                if (!TextUtils.isEmpty(str3)) {
                    stringBufferAppend.append("rid_n=").append(str3).append("&");
                }
                stringBufferAppend.append("reason=" + str);
                if (k.a().c()) {
                    k.a().a(stringBufferAppend.toString());
                } else {
                    reportLoadData(context, stringBufferAppend.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void reportLoadData(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, d.a().a, q.a(str, context), new b() { // from class: com.mbridge.msdk.scheme.report.AppletsReport.1
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onSuccess(String str2) {
                    aa.d(AppletsReport.TAG, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onFailed(String str2) {
                    aa.d(AppletsReport.TAG, str2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            aa.d(TAG, e.getMessage());
        }
    }
}
