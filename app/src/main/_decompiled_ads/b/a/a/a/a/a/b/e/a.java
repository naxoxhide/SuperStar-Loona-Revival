package b.a.a.a.a.a.b.e;

/* JADX INFO: compiled from: AbstractMediaPlayer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements c {
    private c.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c.b f59b;
    private c.a c;
    private c.f d;
    private c.g e;
    private c.InterfaceC0019c f;
    private c.d g;
    protected boolean h = false;

    @Override // b.a.a.a.a.a.b.e.c
    public final void a(c.e eVar) {
        this.a = eVar;
    }

    protected final boolean b(int i, int i2) {
        try {
            c.d dVar = this.g;
            return dVar != null && dVar.a(this, i, i2);
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // b.a.a.a.a.a.b.e.c
    public void d(boolean z) {
        this.h = z;
    }

    protected final void j() {
        try {
            c.b bVar = this.f59b;
            if (bVar != null) {
                bVar.c(this);
            }
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    protected final void k() {
        try {
            c.e eVar = this.a;
            if (eVar != null) {
                eVar.a(this);
            }
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    protected final void l() {
        try {
            c.f fVar = this.d;
            if (fVar != null) {
                fVar.b(this);
            }
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    public void m() {
        this.a = null;
        this.c = null;
        this.f59b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    @Override // b.a.a.a.a.a.b.e.c
    public final void a(c.b bVar) {
        this.f59b = bVar;
    }

    @Override // b.a.a.a.a.a.b.e.c
    public final void a(c.a aVar) {
        this.c = aVar;
    }

    @Override // b.a.a.a.a.a.b.e.c
    public final void a(c.f fVar) {
        this.d = fVar;
    }

    @Override // b.a.a.a.a.a.b.e.c
    public final void a(c.InterfaceC0019c interfaceC0019c) {
        this.f = interfaceC0019c;
    }

    @Override // b.a.a.a.a.a.b.e.c
    public final void a(c.d dVar) {
        this.g = dVar;
    }

    @Override // b.a.a.a.a.a.b.e.c
    public final void a(c.g gVar) {
        this.e = gVar;
    }

    protected final void a(int i) {
        try {
            c.a aVar = this.c;
            if (aVar != null) {
                aVar.a(this, i);
            }
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    protected final void a(int i, int i2, int i3, int i4) {
        try {
            c.g gVar = this.e;
            if (gVar != null) {
                gVar.a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    protected final boolean a(int i, int i2) {
        try {
            c.InterfaceC0019c interfaceC0019c = this.f;
            return interfaceC0019c != null && interfaceC0019c.b(this, i, i2);
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
