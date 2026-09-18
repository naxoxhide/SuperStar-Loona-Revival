package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.k0;
import com.tapjoy.TJAdUnitConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p extends b {
    public p(Map<String, String> map, com.fyber.inneractive.sdk.web.i iVar, k0 k0Var) {
        super(map, iVar, k0Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.b
    public void a() {
        Map<String, String> map = this.f974b;
        this.c.setOrientationProperties((map != null && map.containsKey("allowOrientationChange") && TJAdUnitConstants.String.FALSE.equals(this.f974b.get("allowOrientationChange"))) ? false : true, this.f974b.get("forceOrientation"));
    }

    @Override // com.fyber.inneractive.sdk.mraid.b
    public boolean b() {
        return false;
    }
}
