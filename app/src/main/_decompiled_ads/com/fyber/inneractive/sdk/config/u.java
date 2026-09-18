package com.fyber.inneractive.sdk.config;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.tapjoy.TapjoyConstants;

/* JADX INFO: loaded from: classes2.dex */
public class u implements Runnable {
    public final /* synthetic */ Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f900b;

    public u(Context context, v vVar) {
        this.a = context;
        this.f900b = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (InneractiveAdManager.isCurrentUserAChild()) {
            return;
        }
        boolean z = false;
        try {
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            w.a(this.a, this.f900b);
            if (TextUtils.isEmpty(l.a())) {
                Context context = this.a;
                v vVar = this.f900b;
                String string = null;
                try {
                    ContentResolver contentResolver = context.getContentResolver();
                    z = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0;
                    string = Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ADVERTISING_ID);
                } catch (Settings.SettingNotFoundException unused) {
                }
                if (string != null) {
                    l lVar = (l) vVar;
                    synchronized (lVar) {
                        l.c cVar = lVar.f887b;
                        cVar.a = string;
                        cVar.f888b = z;
                        cVar.c = true;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            IAlog.b("SDK internal error: Make sure that Google Play Services for Mobile Ads is added to the compile dependencies of your project" + e.toString(), new Object[0]);
        }
    }
}
