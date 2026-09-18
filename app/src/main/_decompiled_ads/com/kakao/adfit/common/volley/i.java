package com.kakao.adfit.common.volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: WaitingRequestManager.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements e.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.kakao.adfit.m.e f1730b;
    private final b d;
    private final BlockingQueue<e<?>> e;
    private final Map<String, List<e<?>>> a = new HashMap();
    private final f c = null;

    i(b bVar, BlockingQueue<e<?>> blockingQueue, com.kakao.adfit.m.e eVar) {
        this.f1730b = eVar;
        this.d = bVar;
        this.e = blockingQueue;
    }

    @Override // com.kakao.adfit.common.volley.e.b
    public void a(e<?> eVar, g<?> gVar) {
        List<e<?>> listRemove;
        a.C0448a c0448a = gVar.f1726b;
        if (c0448a == null || c0448a.a()) {
            a(eVar);
            return;
        }
        String strE = eVar.e();
        synchronized (this) {
            listRemove = this.a.remove(strE);
        }
        if (listRemove != null) {
            if (h.f1727b) {
                h.d("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(listRemove.size()), strE);
            }
            Iterator<e<?>> it = listRemove.iterator();
            while (it.hasNext()) {
                this.f1730b.a(it.next(), gVar);
            }
        }
    }

    synchronized boolean b(e<?> eVar) {
        String strE = eVar.e();
        if (!this.a.containsKey(strE)) {
            this.a.put(strE, null);
            eVar.a((e.b) this);
            if (h.f1727b) {
                h.b("new request, sending to network %s", strE);
            }
            return false;
        }
        List<e<?>> arrayList = this.a.get(strE);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        eVar.a("waiting-for-response");
        arrayList.add(eVar);
        this.a.put(strE, arrayList);
        if (h.f1727b) {
            h.b("Request for cacheKey=%s is in flight, putting on hold.", strE);
        }
        return true;
    }

    @Override // com.kakao.adfit.common.volley.e.b
    public synchronized void a(e<?> eVar) {
        BlockingQueue<e<?>> blockingQueue;
        String strE = eVar.e();
        List<e<?>> listRemove = this.a.remove(strE);
        if (listRemove != null && !listRemove.isEmpty()) {
            if (h.f1727b) {
                h.d("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(listRemove.size()), strE);
            }
            e<?> eVarRemove = listRemove.remove(0);
            this.a.put(strE, listRemove);
            eVarRemove.a((e.b) this);
            f fVar = this.c;
            if (fVar != null) {
                fVar.d(eVarRemove);
            } else if (this.d != null && (blockingQueue = this.e) != null) {
                try {
                    blockingQueue.put(eVarRemove);
                } catch (InterruptedException e) {
                    h.c("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.d.b();
                }
            }
        }
    }
}
