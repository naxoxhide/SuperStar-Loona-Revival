package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzpn extends zzdr {
    private int[] zzd;
    private int[] zze;

    zzpn() {
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        Objects.requireNonNull(iArr);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferZzj = zzj(((iLimit - iPosition) / this.zzb.zze) * this.zzc.zze);
        while (iPosition < iLimit) {
            for (int i : iArr) {
                byteBufferZzj.putShort(byteBuffer.getShort(i + i + iPosition));
            }
            iPosition += this.zzb.zze;
        }
        byteBuffer.position(iLimit);
        byteBufferZzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzdr
    public final zzdo zzi(zzdo zzdoVar) throws zzdp {
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzdo.zza;
        }
        if (zzdoVar.zzd != 2) {
            throw new zzdp("Unhandled input format:", zzdoVar);
        }
        boolean z = zzdoVar.zzc != iArr.length;
        int i = 0;
        while (true) {
            int length = iArr.length;
            if (i >= length) {
                return z ? new zzdo(zzdoVar.zzb, length, 2) : zzdo.zza;
            }
            int i2 = iArr[i];
            if (i2 >= zzdoVar.zzc) {
                throw new zzdp("Unhandled input format:", zzdoVar);
            }
            z |= i2 != i;
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdr
    protected final void zzk() {
        this.zze = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdr
    protected final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(int[] iArr) {
        this.zzd = iArr;
    }
}
