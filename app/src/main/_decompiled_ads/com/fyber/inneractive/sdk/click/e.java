package com.fyber.inneractive.sdk.click;

import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.w;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e implements w<c> {
    public final /* synthetic */ List a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f857b;
    public final /* synthetic */ f c;

    public e(f fVar, List list, Uri uri) {
        this.c = fVar;
        this.a = list;
        this.f857b = uri;
    }

    @Override // com.fyber.inneractive.sdk.network.w
    public void a(c cVar, Exception exc, boolean z) {
        c cVar2 = cVar;
        if (exc != null || cVar2 == null) {
            IAConfigManager.a(this.f857b.toString(), null);
            Uri uri = this.f857b;
            this.c.getClass();
            b bVarA = l.a(uri.toString(), "IgniteGooglePlay", "failed getting redirects");
            List list = this.a;
            if (list != null) {
                list.add(new i(this.f857b.toString(), false, l.d.INTERNAL_REDIRECT, "failed getting redirects. ignite click handler"));
                bVarA.f = this.a;
            }
            f fVar = this.c;
            fVar.c.a(bVarA, fVar.d, fVar.e);
            return;
        }
        if (cVar2.a.size() > 0) {
            List<String> list2 = cVar2.a;
            String str = list2.get(list2.size() - 1);
            if (this.a != null) {
                for (String str2 : cVar2.a) {
                    if (!TextUtils.equals(str2, str)) {
                        this.a.add(new i(str2, true, l.d.INTERNAL_REDIRECT, null));
                    }
                }
                List list3 = this.a;
                l.d dVar = l.d.OPEN_INTERNAL_STORE;
                list3.add(new i(str, true, dVar, null));
                this.c.getClass();
                b bVarA2 = l.a(str, dVar, "IgniteGooglePlay");
                bVarA2.f = this.a;
                f fVar2 = this.c;
                fVar2.c.a(bVarA2, fVar2.d, fVar2.e);
            }
            if (str.startsWith("market")) {
                IAConfigManager.a(str.replace("market://details?id=", "https://play.google.com/store/apps/details?id="), null);
            } else {
                IAConfigManager.a(str, cVar2.f856b);
            }
        }
    }
}
