package com.igaworks.adpopcorn.plugin.ane;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

/* JADX INFO: loaded from: classes2.dex */
public class AdPopcornExtension implements FREExtension {
    public FREContext createContext(String str) {
        return new AdPopcornContext();
    }

    public void dispose() {
    }

    public void initialize() {
    }
}
