package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzamg implements Comparable {
    private final zzamr zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzamk zzf;
    private Integer zzg;
    private zzamj zzh;
    private boolean zzi;
    private zzalp zzj;
    private zzamf zzk;
    private final zzalu zzl;

    public zzamg(int i, String str, zzamk zzamkVar) {
        Uri uri;
        String host;
        this.zza = zzamr.zza ? new zzamr() : null;
        this.zze = new Object();
        int iHashCode = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzamkVar;
        this.zzl = new zzalu();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.zzd = iHashCode;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzamg) obj).zzg.intValue();
    }

    public final String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        return "[ ] " + this.zzc + " " + "0x".concat(strValueOf) + " NORMAL " + this.zzg;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzalp zzd() {
        return this.zzj;
    }

    public final zzamg zze(zzalp zzalpVar) {
        this.zzj = zzalpVar;
        return this;
    }

    public final zzamg zzf(zzamj zzamjVar) {
        this.zzh = zzamjVar;
        return this;
    }

    public final zzamg zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    protected abstract zzamm zzh(zzamc zzamcVar);

    public final String zzj() {
        int i = this.zzb;
        String str = this.zzc;
        if (i == 0) {
            return str;
        }
        return Integer.toString(1) + "-" + str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzalo {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzamr.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzamp zzampVar) {
        zzamk zzamkVar;
        synchronized (this.zze) {
            zzamkVar = this.zzf;
        }
        zzamkVar.zza(zzampVar);
    }

    protected abstract void zzo(Object obj);

    final void zzp(String str) {
        zzamj zzamjVar = this.zzh;
        if (zzamjVar != null) {
            zzamjVar.zzb(this);
        }
        if (zzamr.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzame(this, str, id));
            } else {
                this.zza.zza(str, id);
                this.zza.zzb(toString());
            }
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    final void zzr() {
        zzamf zzamfVar;
        synchronized (this.zze) {
            zzamfVar = this.zzk;
        }
        if (zzamfVar != null) {
            zzamfVar.zza(this);
        }
    }

    final void zzs(zzamm zzammVar) {
        zzamf zzamfVar;
        synchronized (this.zze) {
            zzamfVar = this.zzk;
        }
        if (zzamfVar != null) {
            zzamfVar.zzb(this, zzammVar);
        }
    }

    final void zzt(int i) {
        zzamj zzamjVar = this.zzh;
        if (zzamjVar != null) {
            zzamjVar.zzc(this, i);
        }
    }

    final void zzu(zzamf zzamfVar) {
        synchronized (this.zze) {
            this.zzk = zzamfVar;
        }
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzalo {
        return null;
    }

    public final zzalu zzy() {
        return this.zzl;
    }
}
