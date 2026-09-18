package com.applovin.impl.mediation.d;

import android.net.Uri;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.applovin.impl.sdk.e.d {
    private final com.applovin.impl.mediation.b.f amh;
    private final String awr;
    private final String aws;
    private final Map<String, String> awt;
    private final Map<String, String> awu;
    private final MaxError awv;

    public d(String str, Map<String, String> map, MaxError maxError, com.applovin.impl.mediation.b.f fVar, n nVar, boolean z) {
        super("TaskFireMediationPostbacks", nVar);
        this.awr = str;
        this.aws = str + "_urls";
        this.awt = u.a(map, nVar);
        this.awv = maxError != null ? maxError : new MaxErrorImpl(-1);
        this.amh = fVar;
        HashMap map2 = new HashMap(7);
        map2.put("AppLovin-Event-Type", str);
        if (z) {
            map2.put("AppLovin-Ad-Network-Name", fVar.yz());
        }
        if (fVar instanceof com.applovin.impl.mediation.b.a) {
            com.applovin.impl.mediation.b.a aVar = (com.applovin.impl.mediation.b.a) fVar;
            map2.put("AppLovin-Ad-Unit-Id", aVar.getAdUnitId());
            map2.put("AppLovin-Ad-Format", aVar.getFormat().getLabel());
            if (z) {
                map2.put("AppLovin-Third-Party-Ad-Placement-ID", aVar.getThirdPartyAdPlacementId());
            }
        }
        if (maxError != null) {
            map2.put("AppLovin-Error-Code", String.valueOf(maxError.getCode()));
            map2.put("AppLovin-Error-Message", maxError.getMessage());
        }
        this.awu = map2;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> listBZ = this.amh.bZ(this.aws);
        Map<String, String> mapZE = zE();
        Iterator<String> it = listBZ.iterator();
        while (it.hasNext()) {
            Uri uri = Uri.parse(c(c(it.next(), this.awt), this.awv));
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            HashMap map = new HashMap(mapZE.size());
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str);
                if (mapZE.containsKey(queryParameter)) {
                    map.put(str, this.amh.ca(mapZE.get(queryParameter)));
                } else {
                    builderClearQuery.appendQueryParameter(str, queryParameter);
                }
            }
            b(builderClearQuery.build().toString(), map);
        }
    }

    private void b(String str, Map<String, Object> map) {
        getSdk().Cs().a(com.applovin.impl.sdk.network.h.IB().dh(str).dg("POST").o(this.awu).aV(false).p(map).aW(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aKc)).booleanValue()).ID());
    }

    private Map<String, String> zE() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) this.sdk.a(com.applovin.impl.sdk.c.a.aJi)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    private String c(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            str = str.replace(str2, StringUtils.emptyIfNull(map.get(str2)));
        }
        return str;
    }

    private String c(String str, MaxError maxError) {
        int mediatedNetworkErrorCode;
        String mediatedNetworkErrorMessage;
        if (maxError instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) maxError;
            mediatedNetworkErrorCode = maxAdapterError.getMediatedNetworkErrorCode();
            mediatedNetworkErrorMessage = maxAdapterError.getMediatedNetworkErrorMessage();
        } else {
            mediatedNetworkErrorCode = 0;
            mediatedNetworkErrorMessage = "";
        }
        return str.replace("{ERROR_CODE}", String.valueOf(maxError.getCode())).replace("{ERROR_MESSAGE}", StringUtils.encodeUriString(maxError.getMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(mediatedNetworkErrorCode)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", StringUtils.encodeUriString(mediatedNetworkErrorMessage));
    }
}
