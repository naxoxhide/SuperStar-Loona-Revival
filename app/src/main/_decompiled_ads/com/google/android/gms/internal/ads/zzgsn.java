package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzgsn extends zzgsm {
    protected final byte[] zza;

    zzgsn(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgsr) || zzd() != ((zzgsr) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgsn)) {
            return obj.equals(this);
        }
        zzgsn zzgsnVar = (zzgsn) obj;
        int iZzr = zzr();
        int iZzr2 = zzgsnVar.zzr();
        if (iZzr == 0 || iZzr2 == 0 || iZzr == iZzr2) {
            return zzg(zzgsnVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgsm
    final boolean zzg(zzgsr zzgsrVar, int i, int i2) {
        if (i2 > zzgsrVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzd());
        }
        int i3 = i + i2;
        if (i3 > zzgsrVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzgsrVar.zzd());
        }
        if (!(zzgsrVar instanceof zzgsn)) {
            return zzgsrVar.zzk(i, i3).equals(zzk(0, i2));
        }
        zzgsn zzgsnVar = (zzgsn) zzgsrVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzgsnVar.zza;
        int iZzc = zzc() + i2;
        int iZzc2 = zzc();
        int iZzc3 = zzgsnVar.zzc() + i;
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    protected final int zzi(int i, int i2, int i3) {
        return zzguj.zzb(i, this.zza, zzc() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    protected final int zzj(int i, int i2, int i3) {
        int iZzc = zzc() + i2;
        return zzgxi.zzf(i, this.zza, iZzc, i3 + iZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    public final zzgsr zzk(int i, int i2) {
        int iZzq = zzq(i, i2, zzd());
        return iZzq == 0 ? zzgsr.zzb : new zzgsk(this.zza, zzc() + i, iZzq);
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    public final zzgsz zzl() {
        return zzgsz.zzI(this.zza, zzc(), zzd(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    protected final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    final void zzo(zzgsg zzgsgVar) throws IOException {
        zzgsgVar.zza(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgsr
    public final boolean zzp() {
        int iZzc = zzc();
        return zzgxi.zzj(this.zza, iZzc, zzd() + iZzc);
    }
}
