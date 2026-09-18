package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.aa;
import org.json.JSONArray;

/* JADX INFO: compiled from: DomainReport.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static String a = "DomainReport";

    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    public static boolean a(com.mbridge.msdk.c.c cVar, String str) {
        boolean z = false;
        if (cVar != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    z = true;
                } else {
                    int iAq = cVar.aq();
                    JSONArray jSONArrayW = cVar.w();
                    JSONArray jSONArrayX = cVar.x();
                    if (jSONArrayX != null) {
                        for (int i = 0; i < jSONArrayX.length(); i++) {
                            if (str.contains(jSONArrayX.getString(i))) {
                                return false;
                            }
                        }
                    }
                    if (iAq != 2) {
                        z = true;
                    } else if (jSONArrayW != null) {
                        for (int i2 = 0; i2 < jSONArrayW.length(); i2++) {
                            if (str.contains(jSONArrayW.getString(i2))) {
                                return true;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                aa.d(a, e.getMessage());
                return true;
            }
        } else {
            z = true;
        }
        return z;
    }
}
