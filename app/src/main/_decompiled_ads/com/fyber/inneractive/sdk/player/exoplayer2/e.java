package com.fyber.inneractive.sdk.player.exoplayer2;

import com.fyber.inneractive.sdk.player.exoplayer2.source.s;

/* JADX INFO: loaded from: classes2.dex */
public interface e {

    public interface a {
        void a();

        void a(d dVar);

        void a(m mVar);

        void a(p pVar, Object obj);

        void a(s sVar, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.f fVar);

        void a(boolean z);

        void a(boolean z, int i);
    }

    public interface b {
        void a(int i, Object obj) throws d;
    }

    public static final class c {
        public final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1055b;
        public final Object c;

        public c(b bVar, int i, Object obj) {
            this.a = bVar;
            this.f1055b = i;
            this.c = obj;
        }
    }
}
