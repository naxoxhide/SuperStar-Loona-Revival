package b.b.a.a.h.x;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import androidx.core.view.PointerIconCompat;
import b.b.a.a.h.i;
import b.b.a.a.h.j;
import b.b.a.a.h.k;
import b.b.a.a.h.o;
import b.b.a.a.h.s;
import b.b.a.a.h.t;
import b.b.a.a.h.u;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: ImageRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements i {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f169b;
    private String c;
    private o d;
    private ImageView.ScaleType e;
    private Bitmap.Config f;
    private int g;
    private int h;
    private b.b.a.a.h.h i;
    private u j;
    private WeakReference<ImageView> k;
    private volatile boolean l;
    private boolean m;
    private boolean n;
    private s o;
    private t p;
    private Queue<b.b.a.a.h.y.i> q;
    private final Handler r;
    private boolean s;
    private b.b.a.a.h.g t;
    private int u;
    private f v;
    private b.b.a.a.h.x.a w;
    private b.b.a.a.h.b x;
    private int y;
    private int z;

    /* JADX INFO: compiled from: ImageRequest.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.a.h.y.i iVar;
            while (!c.this.l && (iVar = (b.b.a.a.h.y.i) c.this.q.poll()) != null) {
                try {
                    if (c.this.o != null) {
                        c.this.o.b(iVar.a(), c.this);
                    }
                    iVar.a(c.this);
                    if (c.this.o != null) {
                        c.this.o.a(iVar.a(), c.this);
                    }
                } catch (Throwable th) {
                    c.this.a(2000, th.getMessage(), th);
                    if (c.this.o != null) {
                        c.this.o.a("exception", c.this);
                        return;
                    }
                    return;
                }
            }
            if (c.this.l) {
                c.this.a(PointerIconCompat.TYPE_HELP, "canceled", null);
            }
        }
    }

    /* JADX INFO: compiled from: ImageRequest.java */
    private class b implements o {
        private o a;

        /* JADX INFO: compiled from: ImageRequest.java */
        class a implements Runnable {
            final /* synthetic */ ImageView a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bitmap f171b;

            a(b bVar, ImageView imageView, Bitmap bitmap) {
                this.a = imageView;
                this.f171b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.setImageBitmap(this.f171b);
            }
        }

        /* JADX INFO: renamed from: b.b.a.a.h.x.c$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImageRequest.java */
        class RunnableC0034b implements Runnable {
            final /* synthetic */ k a;

            RunnableC0034b(k kVar) {
                this.a = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a != null) {
                    b.this.a.a(this.a);
                }
            }
        }

        /* JADX INFO: renamed from: b.b.a.a.h.x.c$b$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImageRequest.java */
        class RunnableC0035c implements Runnable {
            final /* synthetic */ int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f173b;
            final /* synthetic */ Throwable c;

            RunnableC0035c(int i, String str, Throwable th) {
                this.a = i;
                this.f173b = str;
                this.c = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a != null) {
                    b.this.a.a(this.a, this.f173b, this.c);
                }
            }
        }

        public b(o oVar) {
            this.a = oVar;
        }

        @Override // b.b.a.a.h.o
        public void a(k kVar) {
            Bitmap bitmapA;
            ImageView imageView = (ImageView) c.this.k.get();
            if (imageView != null && c.this.j != u.RAW && a(imageView) && (kVar.c() instanceof Bitmap)) {
                c.this.r.post(new a(this, imageView, (Bitmap) kVar.c()));
            }
            try {
                if (c.this.i != null && (kVar.c() instanceof Bitmap) && (bitmapA = c.this.i.a((Bitmap) kVar.c())) != null) {
                    kVar.a(bitmapA);
                }
            } catch (Throwable unused) {
            }
            if (c.this.p == t.MAIN) {
                c.this.r.postAtFrontOfQueue(new RunnableC0034b(kVar));
                return;
            }
            o oVar = this.a;
            if (oVar != null) {
                oVar.a(kVar);
            }
        }

        private boolean a(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(c.this.f169b)) ? false : true;
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
            if (c.this.p == t.MAIN) {
                c.this.r.post(new RunnableC0035c(i, str, th));
                return;
            }
            o oVar = this.a;
            if (oVar != null) {
                oVar.a(i, str, th);
            }
        }
    }

    /* JADX INFO: renamed from: b.b.a.a.h.x.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageRequest.java */
    public static class C0036c implements j {
        private o a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ImageView f174b;
        private String c;
        private String d;
        private ImageView.ScaleType e;
        private Bitmap.Config f;
        private int g;
        private int h;
        private u i;
        private t j;
        private s k;
        private boolean l;
        private boolean m;
        private String n;
        private b.b.a.a.h.b o;
        private f p;
        private b.b.a.a.h.h q;
        private int r;
        private int s;

        public C0036c(f fVar) {
            this.p = fVar;
        }

        @Override // b.b.a.a.h.j
        public j a(String str) {
            this.c = str;
            return this;
        }

        @Override // b.b.a.a.h.j
        public j b(int i) {
            this.g = i;
            return this;
        }

        public j c(String str) {
            this.d = str;
            return this;
        }

        @Override // b.b.a.a.h.j
        public j d(int i) {
            this.s = i;
            return this;
        }

        @Override // b.b.a.a.h.j
        public j a(ImageView.ScaleType scaleType) {
            this.e = scaleType;
            return this;
        }

        @Override // b.b.a.a.h.j
        public j b(String str) {
            this.n = str;
            return this;
        }

        @Override // b.b.a.a.h.j
        public j c(int i) {
            this.r = i;
            return this;
        }

        @Override // b.b.a.a.h.j
        public j a(Bitmap.Config config) {
            this.f = config;
            return this;
        }

        @Override // b.b.a.a.h.j
        public j a(int i) {
            this.h = i;
            return this;
        }

        @Override // b.b.a.a.h.j
        public j a(u uVar) {
            this.i = uVar;
            return this;
        }

        @Override // b.b.a.a.h.j
        public j a(s sVar) {
            this.k = sVar;
            return this;
        }

        @Override // b.b.a.a.h.j
        public j a(boolean z) {
            this.m = z;
            return this;
        }

        @Override // b.b.a.a.h.j
        public i a(o oVar, t tVar) {
            this.j = tVar;
            return a(oVar);
        }

        @Override // b.b.a.a.h.j
        public i a(o oVar) {
            this.a = oVar;
            return new c(this, null).u();
        }

        @Override // b.b.a.a.h.j
        public i a(ImageView imageView) {
            this.f174b = imageView;
            return new c(this, null).u();
        }

        @Override // b.b.a.a.h.j
        public j a(b.b.a.a.h.h hVar) {
            this.q = hVar;
            return this;
        }
    }

    /* synthetic */ c(C0036c c0036c, a aVar) {
        this(c0036c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i u() {
        try {
            f fVar = this.v;
            if (fVar == null) {
                o oVar = this.d;
                if (oVar != null) {
                    oVar.a(1005, "not init !", null);
                }
                return this;
            }
            ExecutorService executorServiceK = fVar.k();
            if (executorServiceK != null) {
                executorServiceK.submit(new a());
            }
            return this;
        } catch (Exception e) {
            Log.e("ImageRequest", e.getMessage());
        }
    }

    public b.b.a.a.h.g k() {
        return this.t;
    }

    public o l() {
        return this.d;
    }

    public int m() {
        return this.z;
    }

    public int n() {
        return this.y;
    }

    public String o() {
        return this.c;
    }

    public String p() {
        return e() + q();
    }

    public u q() {
        return this.j;
    }

    public boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.n;
    }

    public boolean t() {
        return this.m;
    }

    private c(C0036c c0036c) {
        this.q = new LinkedBlockingQueue();
        this.r = new Handler(Looper.getMainLooper());
        this.s = true;
        this.a = c0036c.d;
        this.d = new b(c0036c.a);
        this.k = new WeakReference<>(c0036c.f174b);
        this.e = c0036c.e;
        this.f = c0036c.f;
        this.g = c0036c.g;
        this.h = c0036c.h;
        this.j = c0036c.i == null ? u.AUTO : c0036c.i;
        this.p = c0036c.j == null ? t.MAIN : c0036c.j;
        this.o = c0036c.k;
        this.x = a(c0036c);
        if (!TextUtils.isEmpty(c0036c.c)) {
            a(c0036c.c);
            b(c0036c.c);
        }
        this.m = c0036c.l;
        this.n = c0036c.m;
        this.v = c0036c.p;
        this.i = c0036c.q;
        this.z = c0036c.s;
        this.y = c0036c.r;
        this.q.add(new b.b.a.a.h.y.c());
    }

    public void b(String str) {
        this.c = str;
    }

    @Override // b.b.a.a.h.i
    public int c() {
        return this.h;
    }

    @Override // b.b.a.a.h.i
    public ImageView.ScaleType d() {
        return this.e;
    }

    @Override // b.b.a.a.h.i
    public String e() {
        return this.f169b;
    }

    public b.b.a.a.h.b f() {
        return this.x;
    }

    public Bitmap.Config g() {
        return this.f;
    }

    public f h() {
        return this.v;
    }

    public b.b.a.a.h.x.a i() {
        return this.w;
    }

    public int j() {
        return this.u;
    }

    private b.b.a.a.h.b a(C0036c c0036c) {
        if (c0036c.o != null) {
            return c0036c.o;
        }
        if (!TextUtils.isEmpty(c0036c.n)) {
            return b.b.a.a.h.x.i.a.a(new File(c0036c.n));
        }
        return b.b.a.a.h.x.i.a.h();
    }

    @Override // b.b.a.a.h.i
    public int b() {
        return this.g;
    }

    @Override // b.b.a.a.h.i
    public String a() {
        return this.a;
    }

    public void a(String str) {
        WeakReference<ImageView> weakReference = this.k;
        if (weakReference != null && weakReference.get() != null) {
            this.k.get().setTag(1094453505, str);
        }
        this.f169b = str;
    }

    public void a(boolean z) {
        this.s = z;
    }

    public void a(b.b.a.a.h.g gVar) {
        this.t = gVar;
    }

    public void a(int i) {
        this.u = i;
    }

    public void a(b.b.a.a.h.x.a aVar) {
        this.w = aVar;
    }

    public boolean a(b.b.a.a.h.y.i iVar) {
        if (this.l) {
            return false;
        }
        return this.q.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Throwable th) {
        new b.b.a.a.h.y.h(i, str, th).a(this);
        this.q.clear();
    }
}
