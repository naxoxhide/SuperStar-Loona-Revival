package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfdn {
    public final com.google.android.gms.ads.internal.client.zzfl zza;
    public final zzbls zzb;
    public final zzemk zzc;
    public final com.google.android.gms.ads.internal.client.zzl zzd;
    public final com.google.android.gms.ads.internal.client.zzq zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbfc zzi;
    public final com.google.android.gms.ads.internal.client.zzw zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final com.google.android.gms.ads.internal.client.zzcb zzn;
    public final zzfda zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final com.google.android.gms.ads.internal.client.zzcf zzr;

    /* synthetic */ zzfdn(zzfdl zzfdlVar, zzfdm zzfdmVar) {
        this.zze = zzfdlVar.zzb;
        this.zzf = zzfdlVar.zzc;
        this.zzr = zzfdlVar.zzs;
        int i = zzfdlVar.zza.zza;
        long j = zzfdlVar.zza.zzb;
        Bundle bundle = zzfdlVar.zza.zzc;
        int i2 = zzfdlVar.zza.zzd;
        List list = zzfdlVar.zza.zze;
        boolean z = zzfdlVar.zza.zzf;
        int i3 = zzfdlVar.zza.zzg;
        boolean z2 = true;
        if (!zzfdlVar.zza.zzh && !zzfdlVar.zze) {
            z2 = false;
        }
        this.zzd = new com.google.android.gms.ads.internal.client.zzl(i, j, bundle, i2, list, z, i3, z2, zzfdlVar.zza.zzi, zzfdlVar.zza.zzj, zzfdlVar.zza.zzk, zzfdlVar.zza.zzl, zzfdlVar.zza.zzm, zzfdlVar.zza.zzn, zzfdlVar.zza.zzo, zzfdlVar.zza.zzp, zzfdlVar.zza.zzq, zzfdlVar.zza.zzr, zzfdlVar.zza.zzs, zzfdlVar.zza.zzt, zzfdlVar.zza.zzu, zzfdlVar.zza.zzv, com.google.android.gms.ads.internal.util.zzt.zza(zzfdlVar.zza.zzw), zzfdlVar.zza.zzx, zzfdlVar.zza.zzy);
        this.zza = zzfdlVar.zzd != null ? zzfdlVar.zzd : zzfdlVar.zzh != null ? zzfdlVar.zzh.zzf : null;
        this.zzg = zzfdlVar.zzf;
        this.zzh = zzfdlVar.zzg;
        this.zzi = zzfdlVar.zzf == null ? null : zzfdlVar.zzh == null ? new zzbfc(new NativeAdOptions.Builder().build()) : zzfdlVar.zzh;
        this.zzj = zzfdlVar.zzi;
        this.zzk = zzfdlVar.zzm;
        this.zzl = zzfdlVar.zzj;
        this.zzm = zzfdlVar.zzk;
        this.zzn = zzfdlVar.zzl;
        this.zzb = zzfdlVar.zzn;
        this.zzo = new zzfda(zzfdlVar.zzo, null);
        this.zzp = zzfdlVar.zzp;
        this.zzc = zzfdlVar.zzq;
        this.zzq = zzfdlVar.zzr;
    }

    public final zzbhf zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        return publisherAdViewOptions != null ? publisherAdViewOptions.zzb() : this.zzl.zza();
    }

    public final boolean zzb() {
        return this.zzf.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcT));
    }
}
