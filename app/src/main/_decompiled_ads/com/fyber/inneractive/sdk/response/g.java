package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.model.vast.o;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends e {
    public long J;
    public com.fyber.inneractive.sdk.model.vast.b K;
    public final List<com.fyber.inneractive.sdk.measurement.f> N = new ArrayList();
    public Map<o, com.fyber.inneractive.sdk.flow.vast.g> L = new LinkedHashMap();
    public List<com.fyber.inneractive.sdk.model.vast.g> M = new ArrayList();
    public LinkedHashMap<String, String> O = new LinkedHashMap<>();

    @Override // com.fyber.inneractive.sdk.response.e
    public InneractiveErrorCode a(InneractiveAdRequest inneractiveAdRequest) {
        return a(null, null);
    }

    public List<com.fyber.inneractive.sdk.measurement.f> d() {
        return this.N;
    }

    public com.fyber.inneractive.sdk.model.vast.b e() {
        return this.K;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x002c A[PHI: r0 r4
      0x002c: PHI (r0v8 com.fyber.inneractive.sdk.external.InneractiveErrorCode) = 
      (r0v3 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
      (r0v4 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
      (r0v5 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
      (r0v7 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
      (r0v7 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
      (r0v7 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
      (r0v7 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
      (r0v37 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
     binds: [B:44:0x010a, B:41:0x00fc, B:38:0x00ee, B:12:0x0042, B:14:0x0048, B:16:0x004e, B:31:0x00b2, B:5:0x001c] A[DONT_GENERATE, DONT_INLINE]
      0x002c: PHI (r4v17 com.fyber.inneractive.sdk.network.q) = 
      (r4v12 com.fyber.inneractive.sdk.network.q)
      (r4v13 com.fyber.inneractive.sdk.network.q)
      (r4v14 com.fyber.inneractive.sdk.network.q)
      (r4v16 com.fyber.inneractive.sdk.network.q)
      (r4v16 com.fyber.inneractive.sdk.network.q)
      (r4v16 com.fyber.inneractive.sdk.network.q)
      (r4v16 com.fyber.inneractive.sdk.network.q)
      (r4v21 com.fyber.inneractive.sdk.network.q)
     binds: [B:44:0x010a, B:41:0x00fc, B:38:0x00ee, B:12:0x0042, B:14:0x0048, B:16:0x004e, B:31:0x00b2, B:5:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fyber.inneractive.sdk.response.e
    public InneractiveErrorCode a(InneractiveAdRequest inneractiveAdRequest, s sVar) {
        q qVar;
        InneractiveErrorCode inneractiveErrorCode;
        com.fyber.inneractive.sdk.network.s.b bVarA;
        InneractiveErrorCode inneractiveErrorCode2;
        q qVar2;
        Set<o> setKeySet;
        String str;
        com.fyber.inneractive.sdk.flow.vast.k kVar = new com.fyber.inneractive.sdk.flow.vast.k();
        String str2 = this.i;
        if ("VastErrorInvalidFile".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            qVar2 = q.VAST_ERROR_INVALID_RESPONSE;
            if (this.j != null) {
                bVarA = new com.fyber.inneractive.sdk.network.s.b().a("exception", this.j);
            } else {
                bVarA = null;
            }
            q qVar3 = qVar2;
            inneractiveErrorCode = inneractiveErrorCode2;
            qVar = qVar3;
        } else if ("ErrorNoCompatibleMediaFile".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            qVar2 = q.VAST_ERROR_NO_COMPATIBLE_MEDIA_FILE;
            Map<o, com.fyber.inneractive.sdk.flow.vast.g> map = this.L;
            if (map == null || (setKeySet = map.keySet()) == null || setKeySet.size() <= 0) {
                bVarA = null;
            } else {
                com.fyber.inneractive.sdk.network.s.b bVar = new com.fyber.inneractive.sdk.network.s.b();
                JSONArray jSONArray = new JSONArray();
                for (o oVar : setKeySet) {
                    try {
                        com.fyber.inneractive.sdk.flow.vast.g gVar = map.get(oVar);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", oVar.g);
                        jSONObject.put("bitrate", oVar.e);
                        jSONObject.put("mime", TextUtils.isEmpty(oVar.d) ? "na" : oVar.d);
                        jSONObject.put("delivery", oVar.a);
                        com.fyber.inneractive.sdk.flow.vast.g.a aVar = gVar.a;
                        jSONObject.put("reason", aVar != null ? aVar.value : 0);
                        jSONObject.put("required_value", gVar.f937b);
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                        IAlog.a("VastResponseValidator: Failed converting media file data to Extra data json!", new Object[0]);
                    }
                }
                bVar.a("media_files", jSONArray);
                bVarA = bVar;
            }
            q qVar4 = qVar2;
            inneractiveErrorCode = inneractiveErrorCode2;
            qVar = qVar4;
        } else if ("VastErrorTooManyWrappers".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            qVar2 = q.VAST_ERROR_TOO_MANY_WRAPPERS;
            bVarA = new com.fyber.inneractive.sdk.network.s.b().a("max", Integer.valueOf(IAConfigManager.M.i.f898b));
            q qVar5 = qVar2;
            inneractiveErrorCode = inneractiveErrorCode2;
            qVar = qVar5;
        } else {
            if ("ErrorNoMediaFiles".equals(str2)) {
                inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
                qVar2 = q.VAST_ERROR_NO_MEDIA_FILES;
            } else if ("ErrorConfigurationMismatch".equals(str2)) {
                inneractiveErrorCode2 = InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH;
                qVar2 = q.INTERNAL_CONFIG_MISMATCH;
            } else if ("VastErrorUnsecure".equals(str2)) {
                inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
                qVar2 = q.VAST_ERROR_UNSECURE_URL;
            } else {
                qVar = null;
                inneractiveErrorCode = null;
                bVarA = null;
            }
            bVarA = null;
            q qVar6 = qVar2;
            inneractiveErrorCode = inneractiveErrorCode2;
            qVar = qVar6;
        }
        if (qVar != null) {
            JSONArray jSONArrayC = sVar == null ? null : sVar.c();
            com.fyber.inneractive.sdk.network.s.a aVar2 = new com.fyber.inneractive.sdk.network.s.a(this);
            aVar2.f992b = qVar;
            aVar2.a = inneractiveAdRequest;
            aVar2.d = jSONArrayC;
            if (bVarA != null) {
                aVar2.f.put(bVarA.a);
            }
            aVar2.a((String) null);
        }
        List<com.fyber.inneractive.sdk.model.vast.g> list = this.M;
        if (list != null && list.size() > 0) {
            com.fyber.inneractive.sdk.network.s.a aVar3 = new com.fyber.inneractive.sdk.network.s.a(r.VAST_EVENT_COMPANION_FILTERED, inneractiveAdRequest, this, sVar == null ? null : sVar.c());
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (com.fyber.inneractive.sdk.model.vast.g gVar2 : list) {
                gVar2.getClass();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("w", gVar2.a);
                    jSONObject3.put("h", gVar2.f964b);
                    jSONObject3.put("ctr", gVar2.g);
                    jSONObject3.put("clt", gVar2.h);
                    String str3 = gVar2.f;
                    if (str3 != null) {
                        jSONObject3.put("content", str3);
                        str = "HTMLResource";
                    } else {
                        str = null;
                    }
                    com.fyber.inneractive.sdk.model.vast.j jVar = gVar2.d;
                    if (jVar != null) {
                        jSONObject3.put("content", jVar.f965b);
                        jSONObject3.put("creativeType", gVar2.d.a);
                        str = "StaticResource";
                    }
                    if (!TextUtils.isEmpty(gVar2.e)) {
                        jSONObject3.put("content", gVar2.e);
                        str = "iFrameResource";
                    }
                    if (str != null) {
                        jSONObject3.put("type", str);
                    }
                    com.fyber.inneractive.sdk.flow.vast.d.a aVar4 = gVar2.i;
                    if (aVar4 != null) {
                        jSONObject3.put("reason", aVar4.a);
                    }
                } catch (JSONException e) {
                    IAlog.a("Failed creating Companion json object: %s", e.getMessage());
                    jSONObject3 = null;
                }
                jSONArray2.put(jSONObject3);
            }
            try {
                jSONObject2.put("companion_data", jSONArray2);
            } catch (Exception unused2) {
                IAlog.e("Got exception adding param to json object: %s, %s", "companion_data", jSONArray2);
            }
            aVar3.f.put(jSONObject2);
            aVar3.a((String) null);
        }
        com.fyber.inneractive.sdk.model.vast.b bVar2 = this.K;
        int size = bVar2 != null ? bVar2.g.size() : 0;
        List<com.fyber.inneractive.sdk.model.vast.g> list2 = this.M;
        int size2 = list2 != null ? list2.size() : 0;
        com.fyber.inneractive.sdk.network.s.a aVar5 = new com.fyber.inneractive.sdk.network.s.a(r.NUMBER_OF_COMPANIONS, inneractiveAdRequest, this, sVar == null ? null : sVar.c());
        JSONObject jSONObject4 = new JSONObject();
        Integer numValueOf = Integer.valueOf(size + size2);
        try {
            jSONObject4.put("number_of_endcards", numValueOf);
        } catch (Exception unused3) {
            IAlog.e("Got exception adding param to json object: %s, %s", "number_of_endcards", numValueOf);
        }
        aVar5.f.put(jSONObject4);
        aVar5.a((String) null);
        if (this.K != null) {
            com.fyber.inneractive.sdk.flow.vast.j jVar2 = new com.fyber.inneractive.sdk.flow.vast.j(kVar, this);
            if (jVar2.size() > 0) {
                JSONObject jSONObject5 = new JSONObject();
                JSONArray jSONArray3 = new JSONArray();
                com.fyber.inneractive.sdk.network.s.a aVar6 = new com.fyber.inneractive.sdk.network.s.a(r.OMID_VAST_DETECTION, inneractiveAdRequest, this, sVar == null ? null : sVar.c());
                for (com.fyber.inneractive.sdk.measurement.f fVar : jVar2) {
                    fVar.getClass();
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.put("success", String.valueOf(fVar.b()));
                        if (!fVar.b()) {
                            jSONObject6.put("error_reason", fVar.a());
                        }
                    } catch (JSONException unused4) {
                        jSONObject6 = null;
                    }
                    if (jSONObject6 != null) {
                        jSONArray3.put(jSONObject6);
                    }
                }
                try {
                    jSONObject5.put("verifications", jSONArray3);
                } catch (Exception unused5) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "verifications", jSONArray3);
                }
                aVar6.f.put(jSONObject5);
                aVar6.a((String) null);
            }
        }
        return inneractiveErrorCode;
    }
}
