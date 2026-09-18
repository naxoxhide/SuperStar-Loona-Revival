package com.kakao.adfit.n;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.kakao.adfit.common.volley.VolleyError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ImageLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    private final com.kakao.adfit.common.volley.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f1859b;
    private final HashMap<String, d> c = new HashMap<>();
    private final HashMap<String, d> d = new HashMap<>();
    private final Handler e = new Handler(Looper.getMainLooper());
    private Runnable f;

    /* JADX INFO: compiled from: ImageLoader.java */
    class a implements com.kakao.adfit.common.volley.g.b<Bitmap> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.kakao.adfit.common.volley.g.b
        public void a(Bitmap bitmap) {
            h.this.a(this.a, bitmap);
        }
    }

    /* JADX INFO: compiled from: ImageLoader.java */
    class b implements com.kakao.adfit.common.volley.g.a {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // com.kakao.adfit.common.volley.g.a
        public void a(VolleyError volleyError) {
            h.this.a(this.a, volleyError);
        }
    }

    /* JADX INFO: compiled from: ImageLoader.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = h.this.d.values().iterator();
            while (it.hasNext()) {
                h.this.a((d) it.next());
            }
            h.this.d.clear();
            h.this.f = null;
        }
    }

    /* JADX INFO: compiled from: ImageLoader.java */
    private static class d {
        private final com.kakao.adfit.common.volley.e<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap f1862b;
        private VolleyError c;
        private final List<f> d;

        public d(com.kakao.adfit.common.volley.e<?> eVar, f fVar) {
            ArrayList arrayList = new ArrayList();
            this.d = arrayList;
            this.a = eVar;
            arrayList.add(fVar);
        }

        public boolean b(f fVar) {
            this.d.remove(fVar);
            if (this.d.size() != 0) {
                return false;
            }
            this.a.a();
            return true;
        }

        public void a(VolleyError volleyError) {
            this.c = volleyError;
        }

        public VolleyError a() {
            return this.c;
        }

        public void a(f fVar) {
            this.d.add(fVar);
        }
    }

    /* JADX INFO: compiled from: ImageLoader.java */
    public interface e {
        Bitmap a(String str);

        void a(String str, Bitmap bitmap);
    }

    /* JADX INFO: compiled from: ImageLoader.java */
    public class f {
        private Bitmap a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f1863b;
        private final String c;
        private final String d;

        public f(Bitmap bitmap, String str, String str2, g gVar) {
            this.a = bitmap;
            this.d = str;
            this.c = str2;
            this.f1863b = gVar;
        }

        public Bitmap b() {
            return this.a;
        }

        public void a() {
            h.this.a();
            if (this.f1863b == null) {
                return;
            }
            d dVar = (d) h.this.c.get(this.c);
            if (dVar == null) {
                d dVar2 = (d) h.this.d.get(this.c);
                if (dVar2 != null) {
                    dVar2.b(this);
                    if (dVar2.d.size() == 0) {
                        h.this.d.remove(this.c);
                        return;
                    }
                    return;
                }
                return;
            }
            if (dVar.b(this)) {
                h.this.c.remove(this.c);
            }
        }
    }

    /* JADX INFO: compiled from: ImageLoader.java */
    public interface g extends com.kakao.adfit.common.volley.g.a {
        void a(f fVar, boolean z);
    }

    public h(com.kakao.adfit.common.volley.f fVar, e eVar) {
        this.a = fVar;
        this.f1859b = eVar;
    }

    public f a(String str, g gVar) {
        return a(str, gVar, 0, 0);
    }

    public f a(String str, g gVar, int i, int i2) {
        return a(str, gVar, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public f a(String str, g gVar, int i, int i2, ImageView.ScaleType scaleType) {
        a();
        String strA = a(str, i, i2, scaleType);
        Bitmap bitmapA = this.f1859b.a(strA);
        if (bitmapA != null) {
            f fVar = new f(bitmapA, str, null, null);
            gVar.a(fVar, true);
            return fVar;
        }
        f fVar2 = new f(null, str, strA, gVar);
        gVar.a(fVar2, true);
        d dVar = this.c.get(strA);
        if (dVar == null) {
            dVar = this.d.get(strA);
        }
        if (dVar != null) {
            dVar.a(fVar2);
            return fVar2;
        }
        com.kakao.adfit.common.volley.e<Bitmap> eVarA = a(str, i, i2, scaleType, strA);
        this.a.a(eVarA);
        this.c.put(strA, new d(eVarA, fVar2));
        return fVar2;
    }

    protected com.kakao.adfit.common.volley.e<Bitmap> a(String str, int i, int i2, ImageView.ScaleType scaleType, String str2) {
        return new i(str, new a(str2), i, i2, scaleType, Bitmap.Config.ARGB_8888, new b(str2));
    }

    protected void a(String str, Bitmap bitmap) {
        this.f1859b.a(str, bitmap);
        d dVarRemove = this.c.remove(str);
        if (dVarRemove != null) {
            dVarRemove.f1862b = bitmap;
            a(str, dVarRemove);
        }
    }

    protected void a(String str, VolleyError volleyError) {
        d dVarRemove = this.c.remove(str);
        if (dVarRemove != null) {
            dVarRemove.a(volleyError);
            a(str, dVarRemove);
        }
    }

    private void a(String str, d dVar) {
        if (Thread.currentThread() == this.e.getLooper().getThread()) {
            Runnable runnable = this.f;
            if (runnable != null) {
                runnable.run();
            }
            a(dVar);
            return;
        }
        this.d.put(str, dVar);
        if (this.f == null) {
            c cVar = new c();
            this.f = cVar;
            this.e.postDelayed(cVar, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        for (f fVar : dVar.d) {
            if (fVar.f1863b != null) {
                if (dVar.a() != null) {
                    fVar.f1863b.a(dVar.a());
                } else {
                    fVar.a = dVar.f1862b;
                    fVar.f1863b.a(fVar, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    private static String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        return new StringBuilder(str.length() + 12).append("#W").append(i).append("#H").append(i2).append("#S").append(scaleType.ordinal()).append(str).toString();
    }
}
