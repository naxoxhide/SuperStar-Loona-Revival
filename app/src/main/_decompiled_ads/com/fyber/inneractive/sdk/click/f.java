package com.fyber.inneractive.sdk.click;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InternalStoreWebpageActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.flow.p;
import com.fyber.inneractive.sdk.network.p0;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.util.k0;
import com.fyber.inneractive.sdk.util.x;
import com.fyber.inneractive.sdk.web.t;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f implements com.fyber.inneractive.sdk.click.a {
    public t a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f858b;
    public final a c;
    public final k0 d;
    public final com.fyber.inneractive.sdk.util.e e;

    public interface a {
        void a(b bVar, k0 k0Var, com.fyber.inneractive.sdk.util.e eVar);
    }

    public f(a aVar, k0 k0Var, com.fyber.inneractive.sdk.util.e eVar) {
        this.c = aVar;
        this.d = k0Var;
        this.e = eVar;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public boolean a(Uri uri, l lVar) {
        com.fyber.inneractive.sdk.ignite.k kVar = com.fyber.inneractive.sdk.ignite.k.NONE;
        com.fyber.inneractive.sdk.ignite.k kVar2 = lVar.k;
        this.f858b = lVar.j;
        this.a = lVar.i;
        if (kVar2 != kVar && IAConfigManager.M.E.d()) {
            t tVar = this.a;
            if (tVar != null && tVar.l) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public b a(Context context, Uri uri, List<i> list) {
        String name;
        PackageInfo packageInfo;
        x.a aVar;
        t tVar = this.a;
        if (tVar != null) {
            boolean z = this.f858b;
            if (tVar.C) {
                aVar = new x.a(x.d.FAILED, new IllegalStateException("Store controller is already open"), context.getClass().getName());
            } else {
                tVar.C = true;
                try {
                    name = context.getClass().getName();
                } catch (Throwable unused) {
                    name = "failed";
                }
                tVar.D = true;
                if (tVar.j.equals("invalid_task_id") && !tVar.z) {
                    tVar.d = z ? com.fyber.inneractive.sdk.ignite.k.TRUE_SINGLE_TAP : com.fyber.inneractive.sdk.ignite.k.SINGLE_TAP;
                }
                tVar.B = z;
                if (tVar.A) {
                    tVar.f("onInstallationSuccess();");
                } else if (!tVar.z) {
                    String str = tVar.c;
                    try {
                        packageInfo = !TextUtils.isEmpty(str) ? com.fyber.inneractive.sdk.util.l.a.getPackageManager().getPackageInfo(str, 0) : null;
                    } catch (Exception unused2) {
                    }
                    if (packageInfo != null) {
                        tVar.f("onInstallationSuccess();");
                    } else if (z) {
                        tVar.f1368b.a(tVar.c, new com.fyber.inneractive.sdk.ignite.c.d(tVar.f, tVar.d, p.this));
                        tVar.f("onShowInstallStarted();");
                    }
                }
                try {
                    InternalStoreWebpageActivity.startActivity(context, tVar.e);
                    aVar = new x.a(x.d.OPENED_INTERNAL_STORE, null, name);
                } catch (ActivityNotFoundException e) {
                    aVar = new x.a(x.d.FAILED, e, name);
                }
            }
            Throwable th = aVar.f1351b;
            if (th == null) {
                p0 p0Var = new p0(new e(this, list, uri), uri.toString(), com.fyber.inneractive.sdk.network.x.c.b());
                IAConfigManager.M.s.a.offer(p0Var);
                p0Var.a(q0.QUEUED);
                return l.a(uri.toString(), l.d.OPEN_INTERNAL_STORE, "IgniteGooglePlay");
            }
            if (list != null) {
                list.add(new i(this.a.k, false, l.d.OPEN_INTERNAL_STORE, th.toString()));
            }
            return l.a(uri.toString(), "IgniteGooglePlay", "mInternalStoreWebpageController.show has failed");
        }
        return l.a(uri.toString(), "IgniteGooglePlay", "mInternalStoreWebpageController is null");
    }
}
