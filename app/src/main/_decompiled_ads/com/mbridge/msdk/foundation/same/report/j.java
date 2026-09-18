package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.aa;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventLibraryReport.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j implements o {
    private com.mbridge.msdk.e.m a;

    @Override // com.mbridge.msdk.foundation.same.report.o
    public final void a(Context context, b.InterfaceC0486b interfaceC0486b, b bVar, com.mbridge.msdk.foundation.same.net.g.d dVar) throws Exception {
        com.mbridge.msdk.c.f fVarE;
        if (this.a == null) {
            this.a = m.a().d();
        }
        if (this.a == null) {
            return;
        }
        if (bVar == null) {
            aa.d("EventLibraryReport", "reportEvent is null, report failed");
            if (interfaceC0486b != null) {
                interfaceC0486b.a(null, 0, "reportEvent is null");
                return;
            }
            return;
        }
        try {
            String strP = bVar.p();
            com.mbridge.msdk.e.e eVar = new com.mbridge.msdk.e.e(bVar.i());
            JSONObject jSONObjectA = a(strP);
            if (jSONObjectA == null) {
                jSONObjectA = new JSONObject();
            }
            try {
                long[] jArrF = this.a.f();
                jSONObjectA.put("track_time", jArrF[0]);
                jSONObjectA.put("track_count", jArrF[1]);
                jSONObjectA.put("session_id", this.a.b());
            } catch (Exception unused) {
            }
            String strG = bVar.g();
            if (!TextUtils.isEmpty(strG) && (fVarE = com.mbridge.msdk.c.d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), strG)) != null && !TextUtils.isEmpty(fVarE.a())) {
                jSONObjectA.put("u_stid", fVarE.a());
            }
            eVar.a(jSONObjectA);
            eVar.b(0);
            eVar.a(0);
            this.a.a(eVar);
            if (interfaceC0486b != null) {
                interfaceC0486b.a(bVar);
            }
        } catch (Exception e) {
            aa.d("EventLibraryReport", "report failed, exception: " + e.getMessage());
            if (interfaceC0486b != null) {
                interfaceC0486b.a(bVar, 0, e.getMessage());
            }
        }
    }

    private static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    jSONObject.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
