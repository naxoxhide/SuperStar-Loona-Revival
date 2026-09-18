package com.applovin.impl.b;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final List<String> aXf = Arrays.asList("video/mp4", "video/webm", "video/3gpp", "video/x-matroska");
    private final JSONObject aXh;
    private final JSONObject awx;
    private final com.applovin.impl.sdk.n sdk;
    private final com.applovin.impl.sdk.ad.b source;
    protected List<y> aXg = new ArrayList();
    private final long createdAtMillis = System.currentTimeMillis();

    public e(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.n nVar) {
        this.sdk = nVar;
        this.aXh = jSONObject;
        this.awx = jSONObject2;
        this.source = bVar;
    }

    public int Mp() {
        return this.aXg.size();
    }

    public List<y> Mq() {
        return this.aXg;
    }

    public JSONObject Mr() {
        return this.aXh;
    }

    public JSONObject FP() {
        return this.awx;
    }

    public com.applovin.impl.sdk.ad.b getSource() {
        return this.source;
    }

    public long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public List<String> Ms() {
        List<String> listExplode = CollectionUtils.explode(JsonUtils.getString(this.aXh, "vast_preferred_video_types", null));
        return !listExplode.isEmpty() ? listExplode : aXf;
    }

    public int GC() {
        return u.U(this.aXh);
    }
}
