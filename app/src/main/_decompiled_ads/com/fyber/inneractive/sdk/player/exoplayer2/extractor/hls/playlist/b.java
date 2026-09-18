package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1075b;
    public final long c;
    public final long d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final long i;
    public final boolean j;
    public final boolean k;
    public final a l;
    public final List<a> m;
    public final List<String> n;
    public final long o;

    public static final class a implements Comparable<Long> {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1076b;
        public final int c;
        public final long d;
        public final boolean e;
        public final String f;
        public final String g;
        public final long h;
        public final long i;

        public a(String str, long j, int i, long j2, boolean z, String str2, String str3, long j3, long j4) {
            this.a = str;
            this.f1076b = j;
            this.c = i;
            this.d = j2;
            this.e = z;
            this.f = str2;
            this.g = str3;
            this.h = j3;
            this.i = j4;
        }

        @Override // java.lang.Comparable
        public int compareTo(Long l) {
            Long l2 = l;
            if (this.d > l2.longValue()) {
                return 1;
            }
            return this.d < l2.longValue() ? -1 : 0;
        }
    }

    public b(int i, String str, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, a aVar, List<a> list, List<String> list2) {
        super(str);
        this.f1075b = i;
        this.d = j2;
        this.e = z;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = j3;
        this.j = z2;
        this.k = z3;
        this.l = aVar;
        this.m = Collections.unmodifiableList(list);
        if (list.isEmpty()) {
            this.o = 0L;
        } else {
            a aVar2 = list.get(list.size() - 1);
            this.o = aVar2.d + aVar2.f1076b;
        }
        this.c = j == -9223372036854775807L ? -9223372036854775807L : j >= 0 ? j : this.o + j;
        this.n = Collections.unmodifiableList(list2);
    }
}
