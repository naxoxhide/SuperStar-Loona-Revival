package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzfys extends zzfyy {
    private static final Logger zza = Logger.getLogger(zzfys.class.getName());

    @CheckForNull
    private zzfvn zzb;
    private final boolean zzc;
    private final boolean zze;

    zzfys(zzfvn zzfvnVar, boolean z, boolean z2) {
        super(zzfvnVar.size());
        Objects.requireNonNull(zzfvnVar);
        this.zzb = zzfvnVar;
        this.zzc = z;
        this.zze = z2;
    }

    private final void zzG(int i, Future future) {
        try {
            zzf(i, zzfzt.zzp(future));
        } catch (Error e) {
            e = e;
            zzI(e);
        } catch (RuntimeException e2) {
            e = e2;
            zzI(e);
        } catch (ExecutionException e3) {
            zzI(e3.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final void zzx(@CheckForNull zzfvn zzfvnVar) {
        int iZzA = zzA();
        int i = 0;
        zzfsw.zzj(iZzA >= 0, "Less than 0 remaining futures");
        if (iZzA == 0) {
            if (zzfvnVar != null) {
                zzfxs it = zzfvnVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzG(i, future);
                    }
                    i++;
                }
            }
            zzF();
            zzu();
            zzy(2);
        }
    }

    private static void zzJ(Throwable th) {
        zza.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private static boolean zzK(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    @CheckForNull
    protected final String zza() {
        zzfvn zzfvnVar = this.zzb;
        return zzfvnVar != null ? "futures=".concat(zzfvnVar.toString()) : super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    protected final void zzb() {
        zzfvn zzfvnVar = this.zzb;
        zzy(1);
        if ((zzfvnVar != null) && isCancelled()) {
            boolean zZzt = zzt();
            zzfxs it = zzfvnVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zZzt);
            }
        }
    }

    abstract void zzf(int i, Object obj);

    abstract void zzu();

    final void zzv() {
        zzfvn zzfvnVar = this.zzb;
        zzfvnVar.getClass();
        if (zzfvnVar.isEmpty()) {
            zzu();
            return;
        }
        if (!this.zzc) {
            final zzfvn zzfvnVar2 = this.zze ? this.zzb : null;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfyr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzx(zzfvnVar2);
                }
            };
            zzfxs it = this.zzb.iterator();
            while (it.hasNext()) {
                ((ListenableFuture) it.next()).addListener(runnable, zzfzh.INSTANCE);
            }
            return;
        }
        zzfxs it2 = this.zzb.iterator();
        final int i = 0;
        while (it2.hasNext()) {
            final ListenableFuture listenableFuture = (ListenableFuture) it2.next();
            listenableFuture.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfyq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzw(listenableFuture, i);
                }
            }, zzfzh.INSTANCE);
            i++;
        }
    }

    final /* synthetic */ void zzw(ListenableFuture listenableFuture, int i) {
        try {
            if (listenableFuture.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i, listenableFuture);
            }
        } finally {
            zzx(null);
        }
    }

    void zzy(int i) {
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfyy
    final void zze(Set set) {
        Objects.requireNonNull(set);
        if (isCancelled()) {
            return;
        }
        Throwable thZzl = zzl();
        thZzl.getClass();
        zzK(set, thZzl);
    }

    private final void zzI(Throwable th) {
        Objects.requireNonNull(th);
        if (this.zzc && !zzd(th) && zzK(zzC(), th)) {
            zzJ(th);
        } else if (th instanceof Error) {
            zzJ(th);
        }
    }
}
