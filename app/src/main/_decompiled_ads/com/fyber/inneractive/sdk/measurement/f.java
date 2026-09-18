package com.fyber.inneractive.sdk.measurement;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.response.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f implements i {
    public URL a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f950b;
    public String d;
    public String e;
    public String f;
    public Map<t, List<String>> c = new HashMap();
    public boolean g = false;

    public void a(t tVar, String str) {
        List<String> arrayList = this.c.get(tVar);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.c.put(tVar, arrayList);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        arrayList.add(str);
    }

    public boolean b() {
        String str;
        return this.g && this.a != null && ((str = this.f950b) == null || (!TextUtils.isEmpty(str) && this.f950b.equalsIgnoreCase(CampaignEx.KEY_OMID)));
    }

    public String toString() {
        return "Verification{mJavaScriptResource=" + this.a + ", mTrackingEvents=" + this.c + ", mVerificationParameters='" + this.d + "', mVendor='" + this.e + "'}";
    }

    @Override // com.fyber.inneractive.sdk.response.i
    public List<String> a(t tVar) {
        Map<t, List<String>> map;
        if (tVar == null || (map = this.c) == null) {
            return null;
        }
        return map.get(tVar);
    }

    public String a() {
        if (!this.g) {
            return "JavaScriptResource = ";
        }
        if (TextUtils.isEmpty(this.f950b)) {
            return "apiFramework = ";
        }
        if (!this.f950b.equalsIgnoreCase(CampaignEx.KEY_OMID)) {
            return String.format("apiFramework = %s", this.f950b);
        }
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(this.f) ? "" : this.f;
        return String.format("JavaScriptResource_url = %s", objArr);
    }
}
