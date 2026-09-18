package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaiw implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzaiv
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzaiw.zza;
            return new zzabm[]{new zzaiw()};
        }
    };
    private final zzaix zzb = new zzaix(null);
    private final zzfb zzc = new zzfb(16384);
    private boolean zzd;

    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        int iZza = zzabnVar.zza(this.zzc.zzI(), 0, 16384);
        if (iZza == -1) {
            return -1;
        }
        this.zzc.zzG(0);
        this.zzc.zzF(iZza);
        if (!this.zzd) {
            this.zzb.zzd(0L, 4);
            this.zzd = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzb.zzb(zzabpVar, new zzakq(Integer.MIN_VALUE, 0, 1));
        zzabpVar.zzD();
        zzabpVar.zzO(new zzacl(-9223372036854775807L, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        this.zzd = false;
        this.zzb.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        zzabc zzabcVar;
        int i;
        zzfb zzfbVar = new zzfb(10);
        int i2 = 0;
        while (true) {
            zzabcVar = (zzabc) zzabnVar;
            zzabcVar.zzm(zzfbVar.zzI(), 0, 10, false);
            zzfbVar.zzG(0);
            if (zzfbVar.zzn() != 4801587) {
                break;
            }
            zzfbVar.zzH(3);
            int iZzk = zzfbVar.zzk();
            i2 += iZzk + 10;
            zzabcVar.zzl(iZzk, false);
        }
        zzabnVar.zzj();
        zzabcVar.zzl(i2, false);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = 7;
            zzabcVar.zzm(zzfbVar.zzI(), 0, 7, false);
            zzfbVar.zzG(0);
            int iZzp = zzfbVar.zzp();
            if (iZzp == 44096 || iZzp == 44097) {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArrZzI = zzfbVar.zzI();
                int i6 = zzaaq.zza;
                if (bArrZzI.length < 7) {
                    i = -1;
                } else {
                    int i7 = ((bArrZzI[2] & 255) << 8) | (bArrZzI[3] & 255);
                    if (i7 == 65535) {
                        i7 = ((bArrZzI[4] & 255) << 16) | ((bArrZzI[5] & 255) << 8) | (bArrZzI[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (iZzp == 44097) {
                        i5 += 2;
                    }
                    i = i7 + i5;
                }
                if (i == -1) {
                    return false;
                }
                zzabcVar.zzl(i - 7, false);
            } else {
                zzabnVar.zzj();
                i4++;
                if (i4 - i2 >= 8192) {
                    return false;
                }
                zzabcVar.zzl(i4, false);
                i3 = 0;
            }
        }
    }
}
