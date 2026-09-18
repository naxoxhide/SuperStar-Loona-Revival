package b.b.a.a.h.x.i;

import android.util.Log;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: SoftLruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class c<K, V> {
    private final LinkedHashMap<K, SoftReference<V>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f180b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    protected V a(K k) {
        return null;
    }

    public final V a(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V v2 = null;
        synchronized (this) {
            this.d++;
            this.f180b += b(k, v);
            SoftReference<V> softReferencePut = this.a.put(k, new SoftReference<>(v));
            if (softReferencePut != null && (v2 = softReferencePut.get()) != null) {
                this.f180b -= b(k, v2);
            }
        }
        if (v2 != null) {
            a(false, k, v2, v);
        }
        a(this.c);
        return v2;
    }

    protected void a(boolean z, K k, V v, V v2) {
    }

    protected int c(K k, V v) {
        throw null;
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.g;
        i2 = this.h + i;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public void a(int i) {
        K key;
        V v;
        while (true) {
            synchronized (this) {
                if (this.f180b < 0 || (this.a.isEmpty() && this.f180b != 0)) {
                    break;
                    break;
                }
                if (this.f180b <= i) {
                    return;
                }
                Map.Entry<K, SoftReference<V>> next = this.a.entrySet().iterator().next();
                if (next == null) {
                    return;
                }
                key = next.getKey();
                SoftReference<V> value = next.getValue();
                this.a.remove(key);
                if (value != null) {
                    v = value.get();
                    this.f180b -= b(key, v);
                } else {
                    v = null;
                }
                this.f++;
            }
            a(true, key, v, null);
        }
        Log.e("LruCache", "oom maybe occured, clear cache. size= " + this.f180b + ", maxSize: " + i);
        this.f180b = 0;
        this.a.clear();
    }

    public final V b(K k) {
        V v;
        Objects.requireNonNull(k, "key == null");
        synchronized (this) {
            SoftReference<V> softReference = this.a.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.g++;
                    return v;
                }
                this.a.remove(k);
            } else {
                v = null;
            }
            this.h++;
            V vA = a(k);
            if (vA == null) {
                return null;
            }
            synchronized (this) {
                this.e++;
                SoftReference<V> softReferencePut = this.a.put(k, new SoftReference<>(vA));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.a.put(k, softReferencePut);
                } else {
                    this.f180b += b(k, vA);
                }
            }
            if (v != null) {
                a(false, k, vA, v);
                return v;
            }
            a(this.c);
            return vA;
        }
    }

    private int b(K k, V v) {
        int iC = c(k, v);
        if (iC >= 0) {
            return iC;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }
}
