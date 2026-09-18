package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahw {
    public final boolean zza;
    public final String zzb;
    public final zzacr zzc;
    public final int zzd;
    public final byte[] zze;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public zzahw(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        byte b2 = 0;
        int i4 = 1;
        zzdx.zzd((i == 0) ^ (bArr2 == null));
        this.zza = z;
        this.zzb = str;
        this.zzd = i;
        this.zze = bArr2;
        if (str != null) {
            switch (str.hashCode()) {
                case 3046605:
                    if (!str.equals("cbc1")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 3046671:
                    if (!str.equals("cbcs")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case 3049879:
                    if (!str.equals("cenc")) {
                        b2 = -1;
                    }
                    break;
                case 3049895:
                    if (!str.equals("cens")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 != 0 && b2 != 1) {
                if (b2 == 2 || b2 == 3) {
                    i4 = 2;
                } else {
                    zzer.zzf("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                }
            }
        }
        this.zzc = new zzacr(i4, bArr, i2, i3);
    }
}
