package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgxa extends zzgxc {
    zzgxa(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzgxc
    public final byte zza(long j) {
        return Memory.peekByte((int) j);
    }

    @Override // com.google.android.gms.internal.ads.zzgxc
    public final double zzb(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzgxc
    public final float zzc(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzgxc
    public final void zzd(long j, byte[] bArr, long j2, long j3) {
        Memory.peekByteArray((int) j, bArr, (int) j2, (int) j3);
    }

    @Override // com.google.android.gms.internal.ads.zzgxc
    public final void zze(Object obj, long j, boolean z) {
        if (zzgxd.zzb) {
            zzgxd.zzG(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            zzgxd.zzH(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxc
    public final void zzf(Object obj, long j, byte b2) {
        if (zzgxd.zzb) {
            zzgxd.zzG(obj, j, b2);
        } else {
            zzgxd.zzH(obj, j, b2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxc
    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.ads.zzgxc
    public final void zzh(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.ads.zzgxc
    public final boolean zzi(Object obj, long j) {
        return zzgxd.zzb ? zzgxd.zzw(obj, j) : zzgxd.zzx(obj, j);
    }
}
