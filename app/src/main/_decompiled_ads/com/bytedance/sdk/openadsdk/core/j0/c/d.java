package com.bytedance.sdk.openadsdk.core.j0.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SupportReplayMediaPlayer.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends b.a.a.a.a.a.b.e.d {
    private final List<c> K = Collections.synchronizedList(new ArrayList());
    private int L = 1;
    private int M = 1;
    private final b N;

    /* JADX INFO: compiled from: SupportReplayMediaPlayer.java */
    public interface c extends b.a.a.a.a.a.a.a.InterfaceC0007a {
        void a(int i, int i2);
    }

    public d() {
        b bVar = new b();
        this.N = bVar;
        super.a(bVar);
        b(500);
    }

    static /* synthetic */ int b(d dVar) {
        int i = dVar.M;
        dVar.M = i + 1;
        return i;
    }

    public int E() {
        return this.M;
    }

    @Override // b.a.a.a.a.a.b.e.d
    public long n() {
        return super.n() + (((long) (this.M - 1)) * super.r());
    }

    @Override // b.a.a.a.a.a.b.e.d
    public long r() {
        return super.r() * ((long) this.L);
    }

    /* JADX INFO: compiled from: SupportReplayMediaPlayer.java */
    private class b implements b.a.a.a.a.a.a.a.InterfaceC0007a {
        private b() {
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, long j) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(aVar, j);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void b(b.a.a.a.a.a.a.a aVar) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).b(aVar);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void c(b.a.a.a.a.a.a.a aVar) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).c(aVar);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void d(b.a.a.a.a.a.a.a aVar) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(aVar);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void e(b.a.a.a.a.a.a.a aVar) {
            d.b(d.this);
            if (d.this.M > d.this.L) {
                Iterator it = d.this.K.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).e(aVar);
                }
            } else {
                Iterator it2 = d.this.K.iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).a(d.this.M, d.this.L);
                }
                d.this.D();
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, b.a.a.a.a.a.a.f.a aVar2) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(aVar, aVar2);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void b(b.a.a.a.a.a.a.a aVar, int i) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).b(aVar, i);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, boolean z) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(aVar, z);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, int i, int i2) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(aVar, i, i2);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, int i, int i2, int i3) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(aVar, i, i2, i3);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, int i) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(aVar, i);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, long j, long j2) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(aVar, j, j2);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar) {
            Iterator it = d.this.K.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(aVar);
            }
        }
    }

    @Override // b.a.a.a.a.a.b.e.d
    public void a(b.a.a.a.a.a.a.a.InterfaceC0007a interfaceC0007a) {
        if (!(interfaceC0007a instanceof c)) {
            super.a(interfaceC0007a);
        } else {
            if (this.K.contains(interfaceC0007a)) {
                return;
            }
            this.K.add((c) interfaceC0007a);
        }
    }

    public void c(int i) {
        this.L = Math.max(1, i);
    }
}
