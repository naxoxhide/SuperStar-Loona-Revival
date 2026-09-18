package com.fyber.inneractive.sdk.player.exoplayer2.source;

import android.os.Handler;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface f {

    public static final class a {
        public final Handler a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f1182b;
        public final long c;

        public a(Handler handler, f fVar) {
            this(handler, fVar, 0L);
        }

        public static long a(a aVar, long j) {
            aVar.getClass();
            long jB = com.fyber.inneractive.sdk.player.exoplayer2.b.b(j);
            if (jB == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return aVar.c + jB;
        }

        public void b(com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar, int i, long j, long j2, long j3) {
            if (this.f1182b != null) {
                this.a.post(new b(this, jVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3));
            }
        }

        public a(Handler handler, f fVar, long j) {
            this.a = fVar != null ? (Handler) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(handler) : null;
            this.f1182b = fVar;
            this.c = j;
        }

        public void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar, int i, long j, long j2, long j3) {
            if (this.f1182b != null) {
                this.a.post(new c(this, jVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3));
            }
        }

        public void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar, int i, long j, long j2, long j3, IOException iOException, boolean z) {
            if (this.f1182b != null) {
                this.a.post(new d(this, jVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z));
            }
        }
    }
}
