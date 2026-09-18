package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdt implements zzdq {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzdo zze = zzdo.zza;
    private zzdo zzf;
    private zzdo zzg;
    private zzdo zzh;
    private boolean zzi;
    private zzds zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzdt() {
        zzdo zzdoVar = zzdo.zza;
        this.zzf = zzdoVar;
        this.zzg = zzdoVar;
        this.zzh = zzdoVar;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final zzdo zza(zzdo zzdoVar) throws zzdp {
        if (zzdoVar.zzd != 2) {
            throw new zzdp("Unhandled input format:", zzdoVar);
        }
        int i = this.zzb;
        if (i == -1) {
            i = zzdoVar.zzb;
        }
        this.zze = zzdoVar;
        zzdo zzdoVar2 = new zzdo(i, zzdoVar.zzc, 2);
        this.zzf = zzdoVar2;
        this.zzi = true;
        return zzdoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final ByteBuffer zzb() {
        int iZza;
        zzds zzdsVar = this.zzj;
        if (zzdsVar != null && (iZza = zzdsVar.zza()) > 0) {
            if (this.zzk.capacity() < iZza) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iZza).order(ByteOrder.nativeOrder());
                this.zzk = byteBufferOrder;
                this.zzl = byteBufferOrder.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzdsVar.zzd(this.zzl);
            this.zzo += (long) iZza;
            this.zzk.limit(iZza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final void zzc() {
        if (zzg()) {
            this.zzg = this.zze;
            this.zzh = this.zzf;
            if (this.zzi) {
                zzdo zzdoVar = this.zzg;
                this.zzj = new zzds(zzdoVar.zzb, zzdoVar.zzc, this.zzc, this.zzd, this.zzh.zzb);
            } else {
                zzds zzdsVar = this.zzj;
                if (zzdsVar != null) {
                    zzdsVar.zzc();
                }
            }
        }
        this.zzm = zza;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final void zzd() {
        zzds zzdsVar = this.zzj;
        if (zzdsVar != null) {
            zzdsVar.zze();
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzds zzdsVar = this.zzj;
            Objects.requireNonNull(zzdsVar);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.zzn += (long) iRemaining;
            zzdsVar.zzf(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        this.zze = zzdo.zza;
        zzdo zzdoVar = zzdo.zza;
        this.zzf = zzdoVar;
        this.zzg = zzdoVar;
        this.zzh = zzdoVar;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final boolean zzg() {
        if (this.zzf.zzb == -1) {
            return false;
        }
        if (Math.abs(this.zzc - 1.0f) >= 1.0E-4f || Math.abs(this.zzd - 1.0f) >= 1.0E-4f) {
            return true;
        }
        return this.zzf.zzb != this.zze.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final boolean zzh() {
        zzds zzdsVar;
        return this.zzp && ((zzdsVar = this.zzj) == null || zzdsVar.zza() == 0);
    }

    public final long zzi(long j) {
        long j2 = this.zzo;
        if (j2 < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return (long) (((double) this.zzc) * j);
        }
        long j3 = this.zzn;
        zzds zzdsVar = this.zzj;
        Objects.requireNonNull(zzdsVar);
        long jZzb = j3 - ((long) zzdsVar.zzb());
        int i = this.zzh.zzb;
        int i2 = this.zzg.zzb;
        return i == i2 ? zzfk.zzr(j, jZzb, j2) : zzfk.zzr(j, jZzb * ((long) i), j2 * ((long) i2));
    }

    public final void zzj(float f) {
        if (this.zzd != f) {
            this.zzd = f;
            this.zzi = true;
        }
    }

    public final void zzk(float f) {
        if (this.zzc != f) {
            this.zzc = f;
            this.zzi = true;
        }
    }
}
