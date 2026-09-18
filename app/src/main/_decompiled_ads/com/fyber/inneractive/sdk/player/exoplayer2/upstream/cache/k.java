package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f1210b;
    public final i d;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a g;
    public long f = 0;
    public final HashMap<String, g> c = new HashMap<>();
    public final HashMap<String, ArrayList<com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.b>> e = new HashMap<>();

    public class a extends Thread {
        public final /* synthetic */ ConditionVariable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.a = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (k.this) {
                this.a.open();
                try {
                    k.a(k.this);
                } catch (com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a e) {
                    k.this.g = e;
                }
                k.this.f1210b.getClass();
            }
        }
    }

    public k(File file, f fVar, byte[] bArr) {
        this.a = file;
        this.f1210b = fVar;
        this.d = new i(file, null);
        ConditionVariable conditionVariable = new ConditionVariable();
        new a("SimpleCache.initialize()", conditionVariable).start();
        conditionVariable.block();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a
    public synchronized long a() {
        return this.f;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a
    public g b(String str, long j) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a, InterruptedException {
        l lVarC;
        synchronized (this) {
            while (true) {
                lVarC = c(str, j);
                if (lVarC == null) {
                    wait();
                }
            }
        }
        return lVarC;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public synchronized l c(String str, long j) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a {
        l lVarFloor;
        l lVar;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a c0298a = this.g;
        if (c0298a != null) {
            throw c0298a;
        }
        h hVar = this.d.a.get(str);
        if (hVar == null) {
            lVar = new l(str, j, -1L, -9223372036854775807L, null);
        } else {
            while (true) {
                l lVar2 = new l(hVar.f1207b, j, -1L, -9223372036854775807L, null);
                lVarFloor = hVar.c.floor(lVar2);
                if (lVarFloor == null || lVarFloor.f1206b + lVarFloor.c <= j) {
                    l lVarCeiling = hVar.c.ceiling(lVar2);
                    lVarFloor = lVarCeiling == null ? new l(hVar.f1207b, j, -1L, -9223372036854775807L, null) : new l(hVar.f1207b, j, lVarCeiling.f1206b - j, -9223372036854775807L, null);
                }
                if (!lVarFloor.d || lVarFloor.e.length() == lVarFloor.c) {
                    break;
                }
                b();
            }
            lVar = lVarFloor;
        }
        if (!lVar.d) {
            if (this.c.containsKey(str)) {
                return null;
            }
            this.c.put(str, lVar);
            return lVar;
        }
        h hVar2 = this.d.a.get(str);
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(hVar2.c.remove(lVar));
        int i = hVar2.a;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(lVar.d);
        long jCurrentTimeMillis = System.currentTimeMillis();
        File fileA = l.a(lVar.e.getParentFile(), i, lVar.f1206b, jCurrentTimeMillis);
        l lVar3 = new l(lVar.a, lVar.f1206b, lVar.c, jCurrentTimeMillis, fileA);
        if (!lVar.e.renameTo(fileA)) {
            throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a("Renaming of " + lVar.e + " to " + fileA + " failed.");
        }
        hVar2.c.add(lVar3);
        ArrayList<com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.b> arrayList = this.e.get(lVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(this, lVar, lVar3);
            }
        }
        j jVar = (j) this.f1210b;
        jVar.a.remove(lVar);
        jVar.f1209b -= lVar.c;
        jVar.b(this, lVar3);
        return lVar3;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a
    public synchronized File a(String str, long j, long j2) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a {
        File file;
        h hVarA;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.c.containsKey(str));
        if (!this.a.exists()) {
            b();
            this.a.mkdirs();
        }
        ((j) this.f1210b).a(this, j2);
        file = this.a;
        i iVar = this.d;
        hVarA = iVar.a.get(str);
        if (hVarA == null) {
            hVarA = iVar.a(str, -1L);
        }
        return l.a(file, hVarA.a, j, System.currentTimeMillis());
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a
    public synchronized void b(g gVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(gVar == this.c.remove(gVar.a));
        notifyAll();
    }

    public final void b() throws Throwable {
        LinkedList linkedList = new LinkedList();
        Iterator<h> it = this.d.a.values().iterator();
        while (it.hasNext()) {
            for (l lVar : it.next().c) {
                if (lVar.e.length() != lVar.c) {
                    linkedList.add(lVar);
                }
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            a((g) it2.next(), false);
        }
        this.d.b();
        this.d.c();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a
    public synchronized void a(File file) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a {
        l lVarA = l.a(file, this.d);
        boolean z = true;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(lVarA != null);
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.c.containsKey(lVarA.a));
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            String str = lVarA.a;
            synchronized (this) {
                h hVar = this.d.a.get(str);
                Long lValueOf = Long.valueOf(hVar == null ? -1L : hVar.d);
                if (lValueOf.longValue() != -1) {
                    if (lVarA.f1206b + lVarA.c > lValueOf.longValue()) {
                        z = false;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z);
                }
                a(lVarA);
                this.d.c();
                notifyAll();
            }
        }
    }

    public static void a(k kVar) throws Throwable {
        if (!kVar.a.exists()) {
            kVar.a.mkdirs();
            return;
        }
        i iVar = kVar.d;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(!iVar.f);
        if (!iVar.a()) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.b bVar = iVar.c;
            bVar.a.delete();
            bVar.f1227b.delete();
            iVar.a.clear();
            iVar.f1208b.clear();
        }
        File[] fileArrListFiles = kVar.a.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (!file.getName().equals("cached_content_index.exi")) {
                l lVarA = file.length() > 0 ? l.a(file, kVar.d) : null;
                if (lVarA != null) {
                    kVar.a(lVarA);
                } else {
                    file.delete();
                }
            }
        }
        kVar.d.b();
        kVar.d.c();
    }

    public final void a(l lVar) {
        i iVar = this.d;
        String str = lVar.a;
        h hVarA = iVar.a.get(str);
        if (hVarA == null) {
            hVarA = iVar.a(str, -1L);
        }
        hVarA.c.add(lVar);
        this.f += lVar.c;
        ArrayList<com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.b> arrayList = this.e.get(lVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).b(this, lVar);
            }
        }
        ((j) this.f1210b).b(this, lVar);
    }

    public final void a(g gVar, boolean z) throws Throwable {
        boolean z2;
        h hVarA = this.d.a(gVar.a);
        if (hVarA != null) {
            if (hVarA.c.remove(gVar)) {
                gVar.e.delete();
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.f -= gVar.c;
                if (z && hVarA.c.isEmpty()) {
                    this.d.b(hVarA.f1207b);
                    this.d.c();
                }
                ArrayList<com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.b> arrayList = this.e.get(gVar.a);
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        arrayList.get(size).a(this, gVar);
                    }
                }
                j jVar = (j) this.f1210b;
                jVar.a.remove(gVar);
                jVar.f1209b -= gVar.c;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a
    public synchronized void a(g gVar) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a {
        a(gVar, true);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a
    public synchronized void a(String str, long j) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a {
        i iVar = this.d;
        h hVar = iVar.a.get(str);
        if (hVar == null) {
            iVar.a(str, j);
        } else if (hVar.d != j) {
            hVar.d = j;
            iVar.f = true;
        }
        this.d.c();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a
    public synchronized long a(String str) {
        h hVar;
        hVar = this.d.a.get(str);
        return hVar == null ? -1L : hVar.d;
    }
}
