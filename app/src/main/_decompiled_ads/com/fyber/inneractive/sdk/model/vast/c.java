package com.fyber.inneractive.sdk.model.vast;

import com.facebook.appevents.integrity.IntegrityManager;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.fyber.inneractive.sdk.response.i {
    public h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f960b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public Map<t, List<String>> h = new HashMap();

    public c(h hVar, int i, int i2, String str) {
        this.a = hVar;
        this.c = i;
        this.d = i2;
        this.e = str;
    }

    public void a(t tVar, String str) {
        List<String> arrayList = this.h.get(tVar);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.h.put(tVar, arrayList);
        }
        arrayList.add(str);
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Companion: ").append(" w:").append(this.c).append(" h:").append(this.d).append(" type:").append(this.a.toString()).append(" creativeType: ");
        i iVar = this.f960b;
        return sbAppend.append(iVar != null ? iVar.e() : IntegrityManager.INTEGRITY_TYPE_NONE).append(" ctr:").append(this.g).append(" events:").append(this.h).toString();
    }

    @Override // com.fyber.inneractive.sdk.response.i
    public List<String> a(t tVar) {
        Map<t, List<String>> map = this.h;
        if (map == null) {
            return null;
        }
        return map.get(tVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("w", this.c);
            jSONObject.put("h", this.d);
            jSONObject.put("type", this.a.toString());
            i iVar = this.f960b;
            jSONObject.put("creativeType", iVar != null ? iVar.e() : IntegrityManager.INTEGRITY_TYPE_NONE);
            jSONObject.put("content", this.f);
        } catch (JSONException e) {
            IAlog.a("Vast Parser: Failed creating Companion json object: %s", e.getMessage());
        }
        return jSONObject;
    }
}
