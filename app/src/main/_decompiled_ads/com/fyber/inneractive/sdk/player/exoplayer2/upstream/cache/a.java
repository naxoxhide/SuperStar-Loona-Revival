package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a$a, reason: collision with other inner class name */
    public static class C0298a extends IOException {
        public C0298a(String str) {
            super(str);
        }

        public C0298a(IOException iOException) {
            super(iOException);
        }
    }

    public interface b {
        void a(a aVar, g gVar);

        void a(a aVar, g gVar, g gVar2);

        void b(a aVar, g gVar);
    }

    long a();

    long a(String str);

    File a(String str, long j, long j2) throws C0298a;

    void a(g gVar) throws C0298a;

    void a(File file) throws C0298a;

    void a(String str, long j) throws C0298a;

    g b(String str, long j) throws C0298a, InterruptedException;

    void b(g gVar);

    g c(String str, long j) throws C0298a;
}
