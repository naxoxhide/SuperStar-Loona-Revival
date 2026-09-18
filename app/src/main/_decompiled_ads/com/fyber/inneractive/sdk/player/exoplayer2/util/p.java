package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    public static final Comparator<c> h = new a();
    public static final Comparator<c> i = new b();
    public final int a;
    public int e;
    public int f;
    public int g;
    public final c[] c = new c[5];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f1238b = new ArrayList<>();
    public int d = -1;

    public class a implements Comparator<c> {
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar.a - cVar2.a;
        }
    }

    public class b implements Comparator<c> {
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            float f = cVar.c;
            float f2 = cVar2.c;
            if (f < f2) {
                return -1;
            }
            return f2 < f ? 1 : 0;
        }
    }

    public static class c {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1239b;
        public float c;
    }

    public p(int i2) {
        this.a = i2;
    }
}
