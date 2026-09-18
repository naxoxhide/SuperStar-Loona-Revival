package com.google.android.gms.internal.ads;

import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzadt extends zzady {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzadt(zzacs zzacsVar) {
        super(zzacsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzady
    protected final boolean zza(zzfb zzfbVar) throws zzadx {
        if (this.zzc) {
            zzfbVar.zzH(1);
        } else {
            int iZzl = zzfbVar.zzl();
            int i = iZzl >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(iZzl >> 2) & 3];
                zzak zzakVar = new zzak();
                zzakVar.zzU("audio/mpeg");
                zzakVar.zzy(1);
                zzakVar.zzV(i2);
                this.zza.zzl(zzakVar.zzac());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzak zzakVar2 = new zzak();
                zzakVar2.zzU(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw");
                zzakVar2.zzy(1);
                zzakVar2.zzV(8000);
                this.zza.zzl(zzakVar2.zzac());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzadx("Audio format not supported: " + i);
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzady
    protected final boolean zzb(zzfb zzfbVar, long j) throws zzcc {
        if (this.zze == 2) {
            int iZza = zzfbVar.zza();
            this.zza.zzr(zzfbVar, iZza);
            this.zza.zzt(j, 1, iZza, 0, null);
            return true;
        }
        int iZzl = zzfbVar.zzl();
        if (iZzl != 0 || this.zzd) {
            if (this.zze == 10 && iZzl != 1) {
                return false;
            }
            int iZza2 = zzfbVar.zza();
            this.zza.zzr(zzfbVar, iZza2);
            this.zza.zzt(j, 1, iZza2, 0, null);
            return true;
        }
        int iZza3 = zzfbVar.zza();
        byte[] bArr = new byte[iZza3];
        zzfbVar.zzC(bArr, 0, iZza3);
        zzaaj zzaajVarZza = zzaak.zza(bArr);
        zzak zzakVar = new zzak();
        zzakVar.zzU("audio/mp4a-latm");
        zzakVar.zzz(zzaajVarZza.zzc);
        zzakVar.zzy(zzaajVarZza.zzb);
        zzakVar.zzV(zzaajVarZza.zza);
        zzakVar.zzK(Collections.singletonList(bArr));
        this.zza.zzl(zzakVar.zzac());
        this.zzd = true;
        return false;
    }
}
