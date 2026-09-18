package com.tapjoy.internal;

import com.tapjoy.TapjoyConfig;
import com.tapjoy.TapjoyConnectFlag;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes4.dex */
public final class ka extends Hashtable {
    public ka() {
        put(TapjoyConnectFlag.SERVICE_URL, TapjoyConfig.TJC_SERVICE_URL);
        put(TapjoyConnectFlag.PLACEMENT_URL, TapjoyConfig.TJC_PLACEMENT_SERVICE_URL);
    }
}
