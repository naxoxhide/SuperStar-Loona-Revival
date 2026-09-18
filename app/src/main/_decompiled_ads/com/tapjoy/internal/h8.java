package com.tapjoy.internal;

import com.adxcorp.util.ADXLogUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class h8 extends Thread {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f2765b;
    public final /* synthetic */ i8 c;

    public h8(i8 i8Var, String str, HashMap map) {
        this.c = i8Var;
        this.a = str;
        this.f2765b = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        TapjoyLog.i(ADXLogUtil.PLATFORM_TAPJOY, "Beacon_id = " + this.c.a);
        TapjoyURLConnection tapjoyURLConnection = this.c.f2770b;
        StringBuilder sbAppend = new StringBuilder().append(i8.c).append(RemoteSettings.FORWARD_SLASH_STRING);
        String str = (String) i8.f.get(this.a);
        if (str == null) {
            str = "";
        }
        tapjoyURLConnection.getResponseFromURL(sbAppend.append(str).toString(), (Map<String, String>) null, (Map<String, String>) null, this.f2765b);
    }
}
