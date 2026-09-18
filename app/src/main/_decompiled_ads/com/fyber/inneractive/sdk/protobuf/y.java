package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    public static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1314b;

    public interface a extends j<Boolean> {
    }

    public interface b extends j<Double> {
    }

    public interface c {
        int a();
    }

    public interface d<T extends c> {
        T a(int i);
    }

    public interface e {
        boolean a(int i);
    }

    public interface f extends j<Float> {
    }

    public interface g extends j<Integer> {
    }

    public static class h<F, T> extends AbstractList<T> {
        public final List<F> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<F, T> f1315b;

        public interface a<F, T> {
        }

        public h(List<F> list, a<F, T> aVar) {
            this.a = list;
            this.f1315b = aVar;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            a<F, T> aVar = this.f1315b;
            F f = this.a.get(i);
            ((TokenParametersOuterClass$TokenParameters.a) aVar).getClass();
            T t = (T) TokenParametersOuterClass$TokenParameters.k.a(((Integer) f).intValue());
            return t == null ? (T) TokenParametersOuterClass$TokenParameters.k.UNRECOGNIZED : t;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.a.size();
        }
    }

    public interface i extends j<Long> {
    }

    public interface j<E> extends List<E>, RandomAccess {
        j<E> b(int i);

        void b();

        boolean d();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f1314b = bArr;
        ByteBuffer.wrap(bArr);
        com.fyber.inneractive.sdk.protobuf.j.a(bArr, 0, 0, false);
    }

    public static int a(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static <T> T a(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static Object a(Object obj, Object obj2) {
        o0 o0Var = (o0) obj2;
        com.fyber.inneractive.sdk.protobuf.a.AbstractC0300a abstractC0300a = (com.fyber.inneractive.sdk.protobuf.a.AbstractC0300a) ((o0) obj).toBuilder();
        abstractC0300a.getClass();
        GeneratedMessageLite.b bVar = (GeneratedMessageLite.b) abstractC0300a;
        if (!bVar.a.getClass().isInstance(o0Var)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        bVar.c();
        bVar.a(bVar.f1272b, (GeneratedMessageLite) ((com.fyber.inneractive.sdk.protobuf.a) o0Var));
        return bVar.b();
    }
}
