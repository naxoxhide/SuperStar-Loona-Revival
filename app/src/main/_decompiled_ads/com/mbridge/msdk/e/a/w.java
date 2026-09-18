package com.mbridge.msdk.e.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: WaitingRequestManager.java */
/* JADX INFO: loaded from: classes4.dex */
final class w implements m.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f2037b;
    private final b d;
    private final BlockingQueue<m<?>> e;
    private final Map<String, List<m<?>>> a = new HashMap();
    private final n c = null;

    w(b bVar, BlockingQueue<m<?>> blockingQueue, q qVar) {
        this.f2037b = qVar;
        this.d = bVar;
        this.e = blockingQueue;
    }

    @Override // com.mbridge.msdk.e.a.m.a
    public final void a(m<?> mVar, o<?> oVar) {
        List<m<?>> listRemove;
        if (oVar.f2032b == null || oVar.f2032b.a(System.currentTimeMillis())) {
            a(mVar);
            return;
        }
        String strI = mVar.i();
        synchronized (this) {
            listRemove = this.a.remove(strI);
        }
        if (listRemove != null) {
            Iterator<m<?>> it = listRemove.iterator();
            while (it.hasNext()) {
                this.f2037b.a(it.next(), oVar);
            }
        }
    }

    @Override // com.mbridge.msdk.e.a.m.a
    public final synchronized void a(m<?> mVar) {
        BlockingQueue<m<?>> blockingQueue;
        try {
            String strI = mVar.i();
            List<m<?>> listRemove = this.a.remove(strI);
            if (listRemove != null && !listRemove.isEmpty()) {
                m<?> mVarRemove = listRemove.remove(0);
                this.a.put(strI, listRemove);
                mVarRemove.a((m.a) this);
                n nVar = this.c;
                if (nVar != null) {
                    nVar.c(mVarRemove);
                } else if (this.d != null && (blockingQueue = this.e) != null) {
                    try {
                        blockingQueue.put(mVarRemove);
                    } catch (InterruptedException e) {
                        v.c("Couldn't add request to queue. %s", e.toString());
                        Thread.currentThread().interrupt();
                        this.d.a();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized boolean b(m<?> mVar) {
        String strI = mVar.i();
        if (this.a.containsKey(strI)) {
            List<m<?>> arrayList = this.a.get(strI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(mVar);
            this.a.put(strI, arrayList);
            return true;
        }
        this.a.put(strI, null);
        mVar.a((m.a) this);
        return false;
    }
}
