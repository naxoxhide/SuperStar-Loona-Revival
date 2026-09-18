package com.mbridge.msdk.foundation.same.e;

/* JADX INFO: compiled from: CommonTask.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f2120b;
    public EnumC0483a c = EnumC0483a.READY;
    public b d;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.same.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CommonTask.java */
    public enum EnumC0483a {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    /* JADX INFO: compiled from: CommonTask.java */
    public interface b {
        void a(EnumC0483a enumC0483a);
    }

    public abstract void a();

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.c == EnumC0483a.READY) {
                a(EnumC0483a.RUNNING);
                a();
                a(EnumC0483a.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public a() {
        f2120b++;
    }

    public final void d() {
        if (this.c != EnumC0483a.CANCEL) {
            a(EnumC0483a.CANCEL);
            b();
        }
    }

    private void a(EnumC0483a enumC0483a) {
        this.c = enumC0483a;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(enumC0483a);
        }
    }
}
