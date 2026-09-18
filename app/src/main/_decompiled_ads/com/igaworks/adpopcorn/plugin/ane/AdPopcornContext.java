package com.igaworks.adpopcorn.plugin.ane;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdPopcornContext extends FREContext {
    public void dispose() {
    }

    public Map<String, FREFunction> getFunctions() {
        HashMap map = new HashMap();
        map.put("IgawAdpopcorn", new AdpopcornFunction());
        return map;
    }
}
