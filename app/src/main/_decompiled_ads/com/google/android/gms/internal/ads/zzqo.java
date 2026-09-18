package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzqo extends zzse implements zzkt {
    private final Context zzb;
    private final zzpb zzc;
    private final zzpi zzd;
    private int zze;
    private boolean zzf;
    private zzam zzg;
    private zzam zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private zzlq zzl;

    public zzqo(Context context, zzrv zzrvVar, zzsg zzsgVar, boolean z, Handler handler, zzpc zzpcVar, zzpi zzpiVar) {
        super(1, zzrvVar, zzsgVar, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzpiVar;
        this.zzc = new zzpb(handler, zzpcVar);
        zzpiVar.zzp(new zzqn(this, null));
    }

    private final int zzaH(zzrz zzrzVar, zzam zzamVar) {
        if (!"OMX.google.raw.decoder".equals(zzrzVar.zza) || zzfk.zza >= 24 || (zzfk.zza == 23 && zzfk.zzH(this.zzb))) {
            return zzamVar.zzn;
        }
        return -1;
    }

    private static List zzaI(zzsg zzsgVar, zzam zzamVar, boolean z, zzpi zzpiVar) throws zzsn {
        zzrz zzrzVarZzd;
        if (zzamVar.zzm == null) {
            return zzfvs.zzl();
        }
        return (!zzpiVar.zzz(zzamVar) || (zzrzVarZzd = zzst.zzd()) == null) ? zzst.zzh(zzsgVar, zzamVar, false, false) : zzfvs.zzm(zzrzVarZzd);
    }

    private final void zzaJ() {
        long jZzb = this.zzd.zzb(zzT());
        if (jZzb != Long.MIN_VALUE) {
            if (!this.zzj) {
                jZzb = Math.max(this.zzi, jZzb);
            }
            this.zzi = jZzb;
            this.zzj = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzic
    protected final void zzA() {
        try {
            super.zzA();
            if (this.zzk) {
            }
        } finally {
            if (this.zzk) {
                this.zzk = false;
                this.zzd.zzk();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzB() {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzC() {
        zzaJ();
        this.zzd.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzlr, com.google.android.gms.internal.ads.zzlt
    public final String zzR() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzlr
    public final boolean zzT() {
        return super.zzT() && this.zzd.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzlr
    public final boolean zzU() {
        return this.zzd.zzx() || super.zzU();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final float zzW(float f, zzam zzamVar, zzam[] zzamVarArr) {
        int iMax = -1;
        for (zzam zzamVar2 : zzamVarArr) {
            int i = zzamVar2.zzA;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final int zzX(zzsg zzsgVar, zzam zzamVar) throws zzsn {
        int i;
        boolean z;
        int i2;
        if (!zzcb.zzf(zzamVar.zzm)) {
            return 128;
        }
        int i3 = zzfk.zza >= 21 ? 32 : 0;
        int i4 = zzamVar.zzH;
        boolean zZzaG = zzaG(zzamVar);
        if (zZzaG && (i4 == 0 || zzst.zzd() != null)) {
            zzoq zzoqVarZzd = this.zzd.zzd(zzamVar);
            if (zzoqVarZzd.zzb) {
                i = true != zzoqVarZzd.zzc ? 512 : 1536;
                if (zzoqVarZzd.zzd) {
                    i |= 2048;
                }
            } else {
                i = 0;
            }
            if (this.zzd.zzz(zzamVar)) {
                i2 = i3 | 140;
            }
            return i2 | i;
        }
        i = 0;
        if (("audio/raw".equals(zzamVar.zzm) && !this.zzd.zzz(zzamVar)) || !this.zzd.zzz(zzfk.zzx(2, zzamVar.zzz, zzamVar.zzA))) {
            return 129;
        }
        List listZzaI = zzaI(zzsgVar, zzamVar, false, this.zzd);
        if (listZzaI.isEmpty()) {
            return 129;
        }
        if (!zZzaG) {
            return 130;
        }
        zzrz zzrzVar = (zzrz) listZzaI.get(0);
        boolean zZze = zzrzVar.zze(zzamVar);
        if (!zZze) {
            int i5 = 1;
            while (true) {
                if (i5 >= listZzaI.size()) {
                    z = true;
                    break;
                }
                zzrz zzrzVar2 = (zzrz) listZzaI.get(i5);
                if (zzrzVar2.zze(zzamVar)) {
                    z = false;
                    zZze = true;
                    zzrzVar = zzrzVar2;
                    break;
                }
                i5++;
            }
        } else {
            z = true;
            break;
        }
        int i6 = true != zZze ? 3 : 4;
        int i7 = 8;
        if (zZze && zzrzVar.zzf(zzamVar)) {
            i7 = 16;
        }
        i2 = i6 | i7 | i3 | (true != zzrzVar.zzg ? 0 : 64) | (true != z ? 0 : 128);
        return i2 | i;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final zzie zzY(zzrz zzrzVar, zzam zzamVar, zzam zzamVar2) {
        int i;
        int i2;
        zzie zzieVarZzb = zzrzVar.zzb(zzamVar, zzamVar2);
        int i3 = zzieVarZzb.zze;
        if (zzaE(zzamVar2)) {
            i3 |= 32768;
        }
        if (zzaH(zzrzVar, zzamVar2) > this.zze) {
            i3 |= 64;
        }
        String str = zzrzVar.zza;
        if (i3 != 0) {
            i2 = 0;
            i = i3;
        } else {
            i = 0;
            i2 = zzieVarZzb.zzd;
        }
        return new zzie(str, zzamVar, zzamVar2, i2, i);
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final long zza() {
        if (zzbc() == 2) {
            zzaJ();
        }
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final zzru zzac(zzrz zzrzVar, zzam zzamVar, MediaCrypto mediaCrypto, float f) {
        zzam[] zzamVarArrZzQ = zzQ();
        int length = zzamVarArrZzQ.length;
        int iZzaH = zzaH(zzrzVar, zzamVar);
        if (length != 1) {
            for (zzam zzamVar2 : zzamVarArrZzQ) {
                if (zzrzVar.zzb(zzamVar, zzamVar2).zzd != 0) {
                    iZzaH = Math.max(iZzaH, zzaH(zzrzVar, zzamVar2));
                }
            }
        }
        this.zze = iZzaH;
        this.zzf = zzfk.zza < 24 && "OMX.SEC.aac.dec".equals(zzrzVar.zza) && "samsung".equals(zzfk.zzc) && (zzfk.zzb.startsWith("zeroflte") || zzfk.zzb.startsWith("herolte") || zzfk.zzb.startsWith("heroqlte"));
        String str = zzrzVar.zzc;
        int i = this.zze;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", zzamVar.zzz);
        mediaFormat.setInteger("sample-rate", zzamVar.zzA);
        zzeu.zzb(mediaFormat, zzamVar.zzo);
        zzeu.zza(mediaFormat, "max-input-size", i);
        if (zzfk.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && (zzfk.zza != 23 || (!"ZTE B2017G".equals(zzfk.zzd) && !"AXON 7 mini".equals(zzfk.zzd)))) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (zzfk.zza <= 28 && "audio/ac4".equals(zzamVar.zzm)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (zzfk.zza >= 24 && this.zzd.zza(zzfk.zzx(4, zzamVar.zzz, zzamVar.zzA)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (zzfk.zza >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        this.zzh = (!"audio/raw".equals(zzrzVar.zzb) || "audio/raw".equals(zzamVar.zzm)) ? null : zzamVar;
        return zzru.zza(zzrzVar, mediaFormat, zzamVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final List zzad(zzsg zzsgVar, zzam zzamVar, boolean z) throws zzsn {
        return zzst.zzi(zzaI(zzsgVar, zzamVar, false, this.zzd), zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzae(zzht zzhtVar) {
        zzam zzamVar;
        if (zzfk.zza < 29 || (zzamVar = zzhtVar.zza) == null) {
            return;
        }
        String str = zzamVar.zzm;
        if ((str == "audio/opus" || (str != null && str.equals("audio/opus"))) && zzaD()) {
            ByteBuffer byteBuffer = zzhtVar.zzf;
            Objects.requireNonNull(byteBuffer);
            zzam zzamVar2 = zzhtVar.zza;
            Objects.requireNonNull(zzamVar2);
            if (byteBuffer.remaining() == 8) {
                this.zzd.zzq(zzamVar2.zzC, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzaf(Exception exc) {
        zzer.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzag(String str, zzru zzruVar, long j, long j2) {
        this.zzc.zzc(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzah(String str) {
        this.zzc.zzd(str);
    }

    protected final void zzaj() {
        this.zzj = true;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzak() {
        this.zzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final boolean zzan(zzam zzamVar) {
        zzm();
        return this.zzd.zzz(zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final zzcg zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final void zzg(zzcg zzcgVar) {
        this.zzd.zzr(zzcgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlr
    public final zzkt zzk() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlm
    public final void zzt(int i, Object obj) throws zzil {
        if (i == 2) {
            zzpi zzpiVar = this.zzd;
            Objects.requireNonNull(obj);
            zzpiVar.zzv(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            zzk zzkVar = (zzk) obj;
            zzpi zzpiVar2 = this.zzd;
            Objects.requireNonNull(zzkVar);
            zzpiVar2.zzl(zzkVar);
            return;
        }
        if (i == 6) {
            zzl zzlVar = (zzl) obj;
            zzpi zzpiVar3 = this.zzd;
            Objects.requireNonNull(zzlVar);
            zzpiVar3.zzn(zzlVar);
            return;
        }
        switch (i) {
            case 9:
                zzpi zzpiVar4 = this.zzd;
                Objects.requireNonNull(obj);
                zzpiVar4.zzu(((Boolean) obj).booleanValue());
                break;
            case 10:
                zzpi zzpiVar5 = this.zzd;
                Objects.requireNonNull(obj);
                zzpiVar5.zzm(((Integer) obj).intValue());
                break;
            case 11:
                this.zzl = (zzlq) obj;
                break;
            case 12:
                if (zzfk.zza >= 23) {
                    zzql.zza(this.zzd, obj);
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzic
    protected final void zzw() {
        this.zzk = true;
        this.zzg = null;
        try {
            this.zzd.zzf();
            try {
                super.zzw();
            } finally {
                this.zzc.zze(this.zza);
            }
        } catch (Throwable th) {
            try {
                super.zzw();
                throw th;
            } finally {
                this.zzc.zze(this.zza);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzic
    protected final void zzx(boolean z, boolean z2) throws zzil {
        super.zzx(z, z2);
        this.zzc.zzf(this.zza);
        zzm();
        this.zzd.zzs(zzn());
        this.zzd.zzo(zzh());
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzic
    protected final void zzy(long j, boolean z) throws zzil {
        super.zzy(j, z);
        this.zzd.zzf();
        this.zzi = j;
        this.zzj = true;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzz() {
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzal() throws zzil {
        try {
            this.zzd.zzj();
        } catch (zzph e) {
            throw zzi(e, e.zzc, e.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final zzie zzZ(zzkn zzknVar) throws zzil {
        zzam zzamVar = zzknVar.zza;
        Objects.requireNonNull(zzamVar);
        this.zzg = zzamVar;
        zzie zzieVarZzZ = super.zzZ(zzknVar);
        this.zzc.zzg(zzamVar, zzieVarZzZ);
        return zzieVarZzZ;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final boolean zzam(long j, long j2, zzrw zzrwVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzam zzamVar) throws zzil {
        Objects.requireNonNull(byteBuffer);
        if (this.zzh != null && (i2 & 2) != 0) {
            Objects.requireNonNull(zzrwVar);
            zzrwVar.zzn(i, false);
            return true;
        }
        if (z) {
            if (zzrwVar != null) {
                zzrwVar.zzn(i, false);
            }
            this.zza.zzf += i3;
            this.zzd.zzg();
            return true;
        }
        try {
            if (!this.zzd.zzw(byteBuffer, j3, i3)) {
                return false;
            }
            if (zzrwVar != null) {
                zzrwVar.zzn(i, false);
            }
            this.zza.zze += i3;
            return true;
        } catch (zzpe e) {
            throw zzi(e, this.zzg, e.zzb, 5001);
        } catch (zzph e2) {
            throw zzi(e2, zzamVar, e2.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzai(zzam zzamVar, MediaFormat mediaFormat) throws zzil {
        int iZzk;
        int i;
        zzam zzamVar2 = this.zzh;
        int[] iArr = null;
        if (zzamVar2 != null) {
            zzamVar = zzamVar2;
        } else if (zzar() != null) {
            Objects.requireNonNull(mediaFormat);
            if ("audio/raw".equals(zzamVar.zzm)) {
                iZzk = zzamVar.zzB;
            } else if (zzfk.zza < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                iZzk = mediaFormat.containsKey("v-bits-per-sample") ? zzfk.zzk(mediaFormat.getInteger("v-bits-per-sample")) : 2;
            } else {
                iZzk = mediaFormat.getInteger("pcm-encoding");
            }
            zzak zzakVar = new zzak();
            zzakVar.zzU("audio/raw");
            zzakVar.zzP(iZzk);
            zzakVar.zzE(zzamVar.zzC);
            zzakVar.zzF(zzamVar.zzD);
            zzakVar.zzO(zzamVar.zzk);
            zzakVar.zzJ(zzamVar.zzb);
            zzakVar.zzL(zzamVar.zzc);
            zzakVar.zzM(zzamVar.zzd);
            zzakVar.zzW(zzamVar.zze);
            int i2 = zzamVar.zzf;
            zzakVar.zzy(mediaFormat.getInteger("channel-count"));
            zzakVar.zzV(mediaFormat.getInteger("sample-rate"));
            zzam zzamVarZzac = zzakVar.zzac();
            if (this.zzf && zzamVarZzac.zzz == 6 && (i = zzamVar.zzz) < 6) {
                iArr = new int[i];
                for (int i3 = 0; i3 < zzamVar.zzz; i3++) {
                    iArr[i3] = i3;
                }
            }
            zzamVar = zzamVarZzac;
        }
        try {
            if (zzfk.zza >= 29) {
                if (zzaD()) {
                    zzm();
                }
                zzdx.zzf(zzfk.zza >= 29);
            }
            this.zzd.zze(zzamVar, 0, iArr);
        } catch (zzpd e) {
            throw zzi(e, e.zza, false, 5001);
        }
    }
}
