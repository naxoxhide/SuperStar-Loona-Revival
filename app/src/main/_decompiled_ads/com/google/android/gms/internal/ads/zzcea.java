package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcea extends zzano {
    static final zzcea zzb = new zzcea();

    zzcea() {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzans zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzanu();
        }
        return "mvhd".equals(str) ? new zzanv() : new zzanw(str);
    }
}
