package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonObjectRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends e<JSONObject> {
    private static final String c = "d";

    public d(int i, String str, String str2, com.mbridge.msdk.foundation.same.net.e<JSONObject> eVar) {
        super(i, str, str2, eVar);
    }

    public d(int i, String str, String str2, com.mbridge.msdk.foundation.same.net.e<JSONObject> eVar, boolean z) {
        super(i, str, str2, eVar, z);
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    protected final k<JSONObject> a(com.mbridge.msdk.foundation.same.net.e.c cVar) {
        try {
            String str = new String(cVar.f2144b, com.mbridge.msdk.foundation.same.net.f.b.a(cVar.d));
            if (cVar.a == 204) {
                return k.a(new JSONObject(), cVar);
            }
            return k.a(new JSONObject(str), cVar);
        } catch (UnsupportedEncodingException e) {
            aa.d(c, e.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(8, cVar));
        } catch (JSONException e2) {
            aa.d(c, e2.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(8, cVar));
        }
    }
}
