package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzada implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzacz
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzada.zza;
            return new zzabm[]{new zzada(0)};
        }
    };
    private static final int[] zzb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final int zzf;
    private final byte[] zzg;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private zzabp zzp;
    private zzacs zzq;
    private zzacm zzr;
    private boolean zzs;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        zzc = iArr;
        int i = zzfk.zza;
        zzd = "#!AMR\n".getBytes(zzfsi.zzc);
        zze = "#!AMR-WB\n".getBytes(zzfsi.zzc);
        zzf = iArr[8];
    }

    public zzada() {
        this(0);
    }

    public zzada(int i) {
        this.zzg = new byte[1];
        this.zzm = -1;
    }

    private static boolean zzf(zzabn zzabnVar, byte[] bArr) throws IOException {
        zzabnVar.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ((zzabc) zzabnVar).zzm(bArr2, 0, length, false);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzg(zzabn zzabnVar) throws IOException {
        byte[] bArr = zzd;
        if (zzf(zzabnVar, bArr)) {
            this.zzh = false;
            ((zzabc) zzabnVar).zzo(bArr.length, false);
            return true;
        }
        byte[] bArr2 = zze;
        if (!zzf(zzabnVar, bArr2)) {
            return false;
        }
        this.zzh = true;
        ((zzabc) zzabnVar).zzo(bArr2.length, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        zzdx.zzb(this.zzq);
        int i = zzfk.zza;
        if (zzabnVar.zzf() == 0 && !zzg(zzabnVar)) {
            throw zzcc.zza("Could not find AMR header.", null);
        }
        if (!this.zzs) {
            this.zzs = true;
            boolean z = this.zzh;
            String str = true != z ? "audio/3gpp" : "audio/amr-wb";
            int i2 = true != z ? 8000 : 16000;
            zzacs zzacsVar = this.zzq;
            zzak zzakVar = new zzak();
            zzakVar.zzU(str);
            zzakVar.zzN(zzf);
            zzakVar.zzy(1);
            zzakVar.zzV(i2);
            zzacsVar.zzl(zzakVar.zzac());
        }
        int iZza = zza(zzabnVar);
        if (this.zzl) {
            return iZza;
        }
        zzacl zzaclVar = new zzacl(-9223372036854775807L, 0L);
        this.zzr = zzaclVar;
        this.zzp.zzO(zzaclVar);
        this.zzl = true;
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzp = zzabpVar;
        this.zzq = zzabpVar.zzw(0, 1);
        zzabpVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        this.zzi = 0L;
        this.zzj = 0;
        this.zzk = 0;
        this.zzo = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        return zzg(zzabnVar);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    @RequiresNonNull({"trackOutput"})
    private final int zza(zzabn zzabnVar) throws IOException {
        int i = this.zzk;
        if (i == 0) {
            try {
                zzabnVar.zzj();
                ((zzabc) zzabnVar).zzm(this.zzg, 0, 1, false);
                byte b2 = this.zzg[0];
                if ((b2 & 131) > 0) {
                    throw zzcc.zza("Invalid padding bits for frame header " + ((int) b2), null);
                }
                boolean z = this.zzh;
                int i2 = (b2 >> 3) & 15;
                if (!z) {
                    if (!z) {
                        if (i2 >= 12 && i2 <= 14) {
                        }
                    }
                    throw zzcc.zza("Illegal AMR " + (true != z ? "NB" : "WB") + " frame type " + i2, null);
                }
                if (i2 >= 10 && i2 <= 13) {
                    if (!z) {
                        if (i2 >= 12) {
                        }
                    }
                    if (true != z) {
                    }
                    throw zzcc.zza("Illegal AMR " + (true != z ? "NB" : "WB") + " frame type " + i2, null);
                }
                i = z ? zzc[i2] : zzb[i2];
                this.zzj = i;
                this.zzk = i;
                int i3 = this.zzm;
                if (i3 == -1) {
                    this.zzm = i;
                    i3 = i;
                }
                if (i3 == i) {
                    this.zzn++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iZza = zzacq.zza(this.zzq, zzabnVar, i, true);
        if (iZza == -1) {
            return -1;
        }
        int i4 = this.zzk - iZza;
        this.zzk = i4;
        if (i4 > 0) {
            return 0;
        }
        this.zzq.zzt(this.zzi, 1, this.zzj, 0, null);
        this.zzi += 20000;
        return 0;
    }
}
