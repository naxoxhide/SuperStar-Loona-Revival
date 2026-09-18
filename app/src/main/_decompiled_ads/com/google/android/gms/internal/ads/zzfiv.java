package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfiv implements zzfit {
    private final Context zza;
    private final int zzo;
    private long zzb = 0;
    private long zzc = -1;
    private boolean zzd = false;
    private int zzp = 2;
    private int zzq = 2;
    private int zze = 0;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private boolean zzm = false;
    private boolean zzn = false;

    zzfiv(Context context, int i) {
        this.zza = context;
        this.zzo = i;
    }

    public final synchronized zzfiv zzH(int i) {
        this.zzp = i;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final /* bridge */ /* synthetic */ zzfit zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzq(zzeVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final /* bridge */ /* synthetic */ zzfit zzb(zzfdd zzfddVar) {
        zzr(zzfddVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final /* bridge */ /* synthetic */ zzfit zzc(String str) {
        zzs(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final /* bridge */ /* synthetic */ zzfit zzd(String str) {
        zzt(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final /* bridge */ /* synthetic */ zzfit zze(String str) {
        zzu(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final /* bridge */ /* synthetic */ zzfit zzf(boolean z) {
        zzv(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final /* bridge */ /* synthetic */ zzfit zzg(Throwable th) {
        zzw(th);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final /* bridge */ /* synthetic */ zzfit zzh() {
        zzx();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final /* bridge */ /* synthetic */ zzfit zzi() {
        zzy();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final synchronized boolean zzj() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final boolean zzk() {
        return !TextUtils.isEmpty(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final synchronized zzfix zzl() {
        zzfiw zzfiwVar = null;
        if (this.zzm) {
            return null;
        }
        this.zzm = true;
        if (!this.zzn) {
            zzx();
        }
        if (this.zzc < 0) {
            zzy();
        }
        return new zzfix(this, zzfiwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfit
    public final /* bridge */ /* synthetic */ zzfit zzm(int i) {
        zzH(i);
        return this;
    }

    public final synchronized zzfiv zzq(com.google.android.gms.ads.internal.client.zze zzeVar) {
        IBinder iBinder = zzeVar.zze;
        if (iBinder == null) {
            return this;
        }
        zzcxe zzcxeVar = (zzcxe) iBinder;
        String strZzk = zzcxeVar.zzk();
        if (!TextUtils.isEmpty(strZzk)) {
            this.zzf = strZzk;
        }
        String strZzi = zzcxeVar.zzi();
        if (!TextUtils.isEmpty(strZzi)) {
            this.zzg = strZzi;
        }
        return this;
    }

    public final synchronized zzfiv zzr(zzfdd zzfddVar) {
        if (!TextUtils.isEmpty(zzfddVar.zzb.zzb)) {
            this.zzf = zzfddVar.zzb.zzb;
        }
        for (zzfcr zzfcrVar : zzfddVar.zza) {
            if (!TextUtils.isEmpty(zzfcrVar.zzad)) {
                this.zzg = zzfcrVar.zzad;
                break;
            }
        }
        return this;
    }

    public final synchronized zzfiv zzs(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziA)).booleanValue()) {
            this.zzl = str;
        }
        return this;
    }

    public final synchronized zzfiv zzt(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzfiv zzu(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfiv zzv(boolean z) {
        this.zzd = z;
        return this;
    }

    public final synchronized zzfiv zzw(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziA)).booleanValue()) {
            this.zzk = zzbty.zzd(th);
            this.zzj = (String) zzftj.zzc(zzfsh.zzc('\n')).zzd(zzbty.zzc(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzfiv zzx() {
        Configuration configuration;
        this.zze = com.google.android.gms.ads.internal.zzt.zzq().zzn(this.zza);
        Resources resources = this.zza.getResources();
        int i = 2;
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            i = configuration.orientation == 2 ? 4 : 3;
        }
        this.zzq = i;
        this.zzb = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        this.zzn = true;
        return this;
    }

    public final synchronized zzfiv zzy() {
        this.zzc = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        return this;
    }
}
