package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface v {

    public static final class a {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f1144b;

        public a(String str, int i, byte[] bArr) {
            this.a = str;
            this.f1144b = bArr;
        }
    }

    public static final class b {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<a> f1145b;
        public final byte[] c;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.a = str;
            this.f1145b = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.c = bArr;
        }
    }

    public interface c {
        SparseArray<v> a();

        v a(int i, b bVar);
    }

    public static final class d {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1146b;
        public final int c;
        public int d;
        public String e;

        public d(int i, int i2, int i3) {
            this.a = i != Integer.MIN_VALUE ? i + RemoteSettings.FORWARD_SLASH_STRING : "";
            this.f1146b = i2;
            this.c = i3;
            this.d = Integer.MIN_VALUE;
        }

        public void a() {
            int i = this.d;
            this.d = i == Integer.MIN_VALUE ? this.f1146b : i + this.c;
            this.e = this.a + this.d;
        }

        public String b() {
            if (this.d != Integer.MIN_VALUE) {
                return this.e;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public int c() {
            int i = this.d;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    void a();

    void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, boolean z);

    void a(com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, d dVar);
}
