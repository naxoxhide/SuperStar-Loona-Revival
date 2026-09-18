package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import com.fyber.inneractive.sdk.player.exoplayer2.i;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<C0287a> f1073b;
    public final List<C0287a> c;
    public final List<C0287a> d;
    public final i e;
    public final List<i> f;

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a, reason: collision with other inner class name */
    public static final class C0287a {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f1074b;

        public C0287a(String str, i iVar) {
            this.a = str;
            this.f1074b = iVar;
        }
    }

    public a(String str, List<C0287a> list, List<C0287a> list2, List<C0287a> list3, i iVar, List<i> list4) {
        super(str);
        this.f1073b = Collections.unmodifiableList(list);
        this.c = Collections.unmodifiableList(list2);
        this.d = Collections.unmodifiableList(list3);
        this.e = iVar;
        this.f = list4 != null ? Collections.unmodifiableList(list4) : null;
    }
}
