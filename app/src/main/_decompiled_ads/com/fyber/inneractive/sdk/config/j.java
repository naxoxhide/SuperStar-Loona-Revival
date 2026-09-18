package com.fyber.inneractive.sdk.config;

import android.content.Context;
import com.fyber.inneractive.sdk.network.q0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f886b = new i();
    public List<b> c = new CopyOnWriteArrayList();
    public boolean d = false;
    public final com.fyber.inneractive.sdk.cache.d e = new com.fyber.inneractive.sdk.cache.d();

    public class a implements com.fyber.inneractive.sdk.network.w<i> {
        public a() {
        }

        @Override // com.fyber.inneractive.sdk.network.w
        public void a(i iVar, Exception exc, boolean z) {
            i iVar2 = iVar;
            if (iVar2 != null) {
                j jVar = j.this;
                jVar.getClass();
                if (iVar2.equals(jVar.f886b)) {
                    return;
                }
                jVar.d = true;
                jVar.f886b = iVar2;
                Iterator<b> it = jVar.c.iterator();
                while (it.hasNext()) {
                    it.next().onGlobalConfigChanged(jVar, jVar.f886b);
                }
            }
        }
    }

    public interface b {
        void onGlobalConfigChanged(j jVar, i iVar);
    }

    public j(Context context) {
        this.a = context;
    }

    public i a() {
        return this.f886b;
    }

    public void b() {
        com.fyber.inneractive.sdk.network.g0 g0Var = new com.fyber.inneractive.sdk.network.g0(new a(), this.a, this.e);
        IAConfigManager.M.s.a.offer(g0Var);
        g0Var.a(q0.QUEUED);
    }
}
