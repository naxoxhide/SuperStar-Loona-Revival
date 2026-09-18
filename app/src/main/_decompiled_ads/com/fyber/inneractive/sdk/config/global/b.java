package com.fyber.inneractive.sdk.config.global;

import com.fyber.inneractive.sdk.util.IAlog;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f874b;
    public final List<k> c = new ArrayList();
    public List<d> d = new ArrayList();

    public static void a(b bVar, JSONObject jSONObject, boolean z) throws Exception {
        d cVar;
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                next.getClass();
                next.hashCode();
                switch (next) {
                    case "demand":
                        cVar = new c(jSONObject.getJSONArray(next), z);
                        break;
                    case "pub_id":
                        cVar = new i(jSONObject.getJSONArray(next), z);
                        break;
                    case "placement_type":
                        cVar = new h(jSONObject.getJSONArray(next), z);
                        break;
                    case "os":
                        cVar = new f(jSONObject.getString(next), z);
                        break;
                    case "sdk":
                        cVar = new j(jSONObject.getString(next), z);
                        break;
                    default:
                        cVar = null;
                        break;
                }
                if (cVar != null) {
                    bVar.d.add(cVar);
                } else {
                    IAlog.a(String.format("%s: Unsupported filter type: %s", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, next), new Object[0]);
                }
            }
        }
    }

    public String toString() {
        return String.format("experiment: id=%s, variants=%s, filters=%s", this.a, this.c, this.d);
    }
}
