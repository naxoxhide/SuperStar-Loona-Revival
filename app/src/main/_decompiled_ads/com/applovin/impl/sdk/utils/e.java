package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static e aVr;
    private static final Object aVs = new Object();
    private final Bundle aVt;
    private final int aVu;
    private final boolean aVv;

    public static e V(Context context) {
        e eVar;
        synchronized (aVs) {
            if (aVr == null) {
                aVr = new e(context);
            }
            eVar = aVr;
        }
        return eVar;
    }

    private e(Context context) {
        boolean zBooleanValue;
        Bundle bundle = null;
        try {
            try {
                bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                com.applovin.impl.sdk.x.e("AndroidManifest", "Failed to get meta data.", e);
            }
            this.aVt = bundle;
            int i = 0;
            try {
                XmlResourceParser xmlResourceParserOpenXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
                int eventType = xmlResourceParserOpenXmlResourceParser.getEventType();
                int iIntValue = 0;
                zBooleanValue = false;
                do {
                    if (2 == eventType) {
                        try {
                            if (xmlResourceParserOpenXmlResourceParser.getName().equals("application")) {
                                for (int i2 = 0; i2 < xmlResourceParserOpenXmlResourceParser.getAttributeCount(); i2++) {
                                    String attributeName = xmlResourceParserOpenXmlResourceParser.getAttributeName(i2);
                                    String attributeValue = xmlResourceParserOpenXmlResourceParser.getAttributeValue(i2);
                                    if (attributeName.equals("networkSecurityConfig")) {
                                        iIntValue = Integer.valueOf(attributeValue.substring(1)).intValue();
                                    } else if (attributeName.equals("usesCleartextTraffic")) {
                                        zBooleanValue = Boolean.valueOf(attributeValue).booleanValue();
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            i = iIntValue;
                            try {
                                com.applovin.impl.sdk.x.e("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
                                this.aVu = i;
                            } finally {
                                this.aVu = i;
                                this.aVv = zBooleanValue;
                            }
                        }
                    }
                    eventType = xmlResourceParserOpenXmlResourceParser.next();
                } while (eventType != 1);
                this.aVu = iIntValue;
            } catch (Throwable th2) {
                th = th2;
                zBooleanValue = false;
            }
        } catch (Throwable th3) {
            this.aVt = bundle;
            throw th3;
        }
    }

    public boolean dC(String str) {
        Bundle bundle = this.aVt;
        if (bundle != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    public String L(String str, String str2) {
        Bundle bundle = this.aVt;
        return bundle != null ? bundle.getString(str, str2) : str2;
    }

    public boolean e(String str, boolean z) {
        Bundle bundle = this.aVt;
        return bundle != null ? bundle.getBoolean(str, z) : z;
    }
}
