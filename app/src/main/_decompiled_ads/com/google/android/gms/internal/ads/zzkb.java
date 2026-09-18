package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.core.view.PointerIconCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkb extends zzm implements zziw {
    public static final /* synthetic */ int zzd = 0;
    private final zzma zzA;
    private final long zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private int zzF;
    private zzlv zzG;
    private zzck zzH;
    private zzbv zzI;
    private zzbv zzJ;
    private zzam zzK;
    private zzam zzL;
    private AudioTrack zzM;
    private Object zzN;
    private Surface zzO;
    private int zzP;
    private zzfc zzQ;
    private zzid zzR;
    private zzid zzS;
    private int zzT;
    private zzk zzU;
    private float zzV;
    private boolean zzW;
    private zzdw zzX;
    private boolean zzY;
    private boolean zzZ;
    private zzz zzaa;
    private zzdm zzab;
    private zzbv zzac;
    private zzlk zzad;
    private int zzae;
    private long zzaf;
    private final zzix zzag;
    private zzvr zzah;
    final zzxr zzb;
    final zzck zzc;
    private final zzea zze;
    private final Context zzf;
    private final zzco zzg;
    private final zzlr[] zzh;
    private final zzxq zzi;
    private final zzei zzj;
    private final zzkl zzk;
    private final zzeo zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzcs zzn;
    private final List zzo;
    private final boolean zzp;
    private final zztv zzq;
    private final zzmb zzr;
    private final Looper zzs;
    private final zzxy zzt;
    private final zzdy zzu;
    private final zzjx zzv;
    private final zzjz zzw;
    private final zzhx zzx;
    private final zzib zzy;
    private final zzlz zzz;

    static {
        zzbq.zzb("media3.exoplayer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzmb, com.google.android.gms.internal.ads.zzxx, java.lang.Object] */
    public zzkb(zziv zzivVar, zzco zzcoVar) {
        Object obj;
        zzea zzeaVar = new zzea(zzdy.zza);
        this.zze = zzeaVar;
        try {
            zzer.zze("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.2.0-alpha01] [" + zzfk.zze + "]");
            Context applicationContext = zzivVar.zza.getApplicationContext();
            this.zzf = applicationContext;
            ?? Apply = zzivVar.zzh.apply(zzivVar.zzb);
            this.zzr = Apply;
            this.zzU = zzivVar.zzj;
            this.zzP = zzivVar.zzk;
            this.zzW = false;
            this.zzB = zzivVar.zzo;
            zzjx zzjxVar = new zzjx(this, null);
            this.zzv = zzjxVar;
            zzjz zzjzVar = new zzjz(null);
            this.zzw = zzjzVar;
            Handler handler = new Handler(zzivVar.zzi);
            zzlr[] zzlrVarArrZza = ((zzio) zzivVar.zzc).zza.zza(handler, zzjxVar, zzjxVar, zzjxVar, zzjxVar);
            this.zzh = zzlrVarArrZza;
            int length = zzlrVarArrZza.length;
            zzxq zzxqVar = (zzxq) zzivVar.zze.zza();
            this.zzi = zzxqVar;
            this.zzq = zziv.zza(((zzip) zzivVar.zzd).zza);
            zzyc zzycVarZzg = zzyc.zzg(((zzis) zzivVar.zzg).zza);
            this.zzt = zzycVarZzg;
            this.zzp = zzivVar.zzl;
            this.zzG = zzivVar.zzm;
            Looper looper = zzivVar.zzi;
            this.zzs = looper;
            zzdy zzdyVar = zzivVar.zzb;
            this.zzu = zzdyVar;
            this.zzg = zzcoVar;
            zzeo zzeoVar = new zzeo(looper, zzdyVar, new zzem() { // from class: com.google.android.gms.internal.ads.zzjr
                @Override // com.google.android.gms.internal.ads.zzem
                public final void zza(Object obj2, zzah zzahVar) {
                }
            });
            this.zzl = zzeoVar;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzm = copyOnWriteArraySet;
            this.zzo = new ArrayList();
            this.zzah = new zzvr(0);
            int length2 = zzlrVarArrZza.length;
            zzxr zzxrVar = new zzxr(new zzlu[2], new zzxk[2], zzdg.zza, null);
            this.zzb = zzxrVar;
            this.zzn = new zzcs();
            zzci zzciVar = new zzci();
            zzciVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 24, 27, 28, 32);
            zzxqVar.zzm();
            zzciVar.zzd(29, true);
            zzciVar.zzd(23, false);
            zzciVar.zzd(25, false);
            zzciVar.zzd(33, false);
            zzciVar.zzd(26, false);
            zzciVar.zzd(34, false);
            zzck zzckVarZze = zzciVar.zze();
            this.zzc = zzckVarZze;
            zzci zzciVar2 = new zzci();
            zzciVar2.zzb(zzckVarZze);
            zzciVar2.zza(4);
            zzciVar2.zza(10);
            this.zzH = zzciVar2.zze();
            this.zzj = zzdyVar.zzb(looper, null);
            zzix zzixVar = new zzix(this);
            this.zzag = zzixVar;
            this.zzad = zzlk.zzi(zzxrVar);
            Apply.zzP(zzcoVar, looper);
            this.zzk = new zzkl(zzlrVarArrZza, zzxqVar, zzxrVar, (zzko) zzivVar.zzf.zza(), zzycVarZzg, 0, false, Apply, this.zzG, zzivVar.zzr, zzivVar.zzn, false, looper, zzdyVar, zzixVar, zzfk.zza < 31 ? new zzol() : zzjs.zza(applicationContext, this, zzivVar.zzp), null);
            this.zzV = 1.0f;
            this.zzI = zzbv.zza;
            zzbv zzbvVar = zzbv.zza;
            this.zzJ = zzbvVar;
            this.zzac = zzbvVar;
            int iGenerateAudioSessionId = -1;
            this.zzae = -1;
            if (zzfk.zza >= 21) {
                AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
                if (audioManager != null) {
                    iGenerateAudioSessionId = audioManager.generateAudioSessionId();
                }
                this.zzT = iGenerateAudioSessionId;
                obj = null;
            } else {
                AudioTrack audioTrack = this.zzM;
                if (audioTrack == null || audioTrack.getAudioSessionId() == 0) {
                    obj = null;
                } else {
                    this.zzM.release();
                    obj = null;
                    this.zzM = null;
                }
                if (this.zzM == null) {
                    this.zzM = new AudioTrack(3, 4000, 4, 2, 2, 0, 0);
                }
                this.zzT = this.zzM.getAudioSessionId();
            }
            this.zzX = zzdw.zza;
            this.zzY = true;
            Objects.requireNonNull(Apply);
            zzeoVar.zzb(Apply);
            zzycVarZzg.zze(new Handler(looper), Apply);
            copyOnWriteArraySet.add(zzjxVar);
            this.zzx = new zzhx(zzivVar.zza, handler, zzjxVar);
            this.zzy = new zzib(zzivVar.zza, handler, zzjxVar);
            zzfk.zzE(obj, obj);
            this.zzz = new zzlz(zzivVar.zza);
            this.zzA = new zzma(zzivVar.zza);
            this.zzaa = new zzx(0).zza();
            this.zzab = zzdm.zza;
            this.zzQ = zzfc.zza;
            zzxqVar.zzj(this.zzU);
            zzah(1, 10, Integer.valueOf(this.zzT));
            zzah(2, 10, Integer.valueOf(this.zzT));
            zzah(1, 3, this.zzU);
            zzah(2, 4, Integer.valueOf(this.zzP));
            zzah(2, 5, 0);
            zzah(1, 9, Boolean.valueOf(this.zzW));
            zzah(2, 7, zzjzVar);
            zzah(6, 8, zzjzVar);
            zzeaVar.zze();
        } catch (Throwable th) {
            this.zze.zze();
            throw th;
        }
    }

    static /* bridge */ /* synthetic */ void zzP(zzkb zzkbVar, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzkbVar.zzaj(surface);
        zzkbVar.zzO = surface;
    }

    private final int zzX(zzlk zzlkVar) {
        return zzlkVar.zza.zzo() ? this.zzae : zzlkVar.zza.zzn(zzlkVar.zzb.zza, this.zzn).zzd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzY(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    private final long zzZ(zzlk zzlkVar) {
        if (!zzlkVar.zzb.zzb()) {
            return zzfk.zzs(zzaa(zzlkVar));
        }
        zzlkVar.zza.zzn(zzlkVar.zzb.zza, this.zzn);
        if (zzlkVar.zzc == -9223372036854775807L) {
            long j = zzlkVar.zza.zze(zzX(zzlkVar), this.zza, 0L).zzn;
            return zzfk.zzs(0L);
        }
        int i = zzfk.zza;
        return zzfk.zzs(0L) + zzfk.zzs(zzlkVar.zzc);
    }

    private final long zzaa(zzlk zzlkVar) {
        if (zzlkVar.zza.zzo()) {
            return zzfk.zzq(this.zzaf);
        }
        long jZza = zzlkVar.zzo ? zzlkVar.zza() : zzlkVar.zzr;
        if (zzlkVar.zzb.zzb()) {
            return jZza;
        }
        zzac(zzlkVar.zza, zzlkVar.zzb, jZza);
        return jZza;
    }

    private static long zzab(zzlk zzlkVar) {
        zzcu zzcuVar = new zzcu();
        zzcs zzcsVar = new zzcs();
        zzlkVar.zza.zzn(zzlkVar.zzb.zza, zzcsVar);
        long j = zzlkVar.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzlkVar.zza.zze(zzcsVar.zzd, zzcuVar, 0L).zzn;
        return 0L;
    }

    private final long zzac(zzcv zzcvVar, zztw zztwVar, long j) {
        zzcvVar.zzn(zztwVar.zza, this.zzn);
        return j;
    }

    private final Pair zzad(zzcv zzcvVar, int i, long j) {
        if (zzcvVar.zzo()) {
            this.zzae = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzaf = j;
            return null;
        }
        if (i == -1 || i >= zzcvVar.zzc()) {
            i = zzcvVar.zzg(false);
            long j2 = zzcvVar.zze(i, this.zza, 0L).zzn;
            j = zzfk.zzs(0L);
        }
        return zzcvVar.zzl(this.zza, this.zzn, i, zzfk.zzq(j));
    }

    private final zzlk zzae(zzlk zzlkVar, zzcv zzcvVar, Pair pair) {
        zzdx.zzd(zzcvVar.zzo() || pair != null);
        zzcv zzcvVar2 = zzlkVar.zza;
        long jZzZ = zzZ(zzlkVar);
        zzlk zzlkVarZzh = zzlkVar.zzh(zzcvVar);
        if (zzcvVar.zzo()) {
            zztw zztwVarZzj = zzlk.zzj();
            long jZzq = zzfk.zzq(this.zzaf);
            zzlk zzlkVarZzc = zzlkVarZzh.zzd(zztwVarZzj, jZzq, jZzq, jZzq, 0L, zzvx.zza, this.zzb, zzfvs.zzl()).zzc(zztwVarZzj);
            zzlkVarZzc.zzp = zzlkVarZzc.zzr;
            return zzlkVarZzc;
        }
        Object obj = zzlkVarZzh.zzb.zza;
        int i = zzfk.zza;
        boolean z = !obj.equals(pair.first);
        zztw zztwVar = z ? new zztw(pair.first, -1L) : zzlkVarZzh.zzb;
        long jLongValue = ((Long) pair.second).longValue();
        long jZzq2 = zzfk.zzq(jZzZ);
        if (!zzcvVar2.zzo()) {
            zzcvVar2.zzn(obj, this.zzn);
        }
        if (z || jLongValue < jZzq2) {
            zzdx.zzf(!zztwVar.zzb());
            zzlk zzlkVarZzc2 = zzlkVarZzh.zzd(zztwVar, jLongValue, jLongValue, jLongValue, 0L, z ? zzvx.zza : zzlkVarZzh.zzh, z ? this.zzb : zzlkVarZzh.zzi, z ? zzfvs.zzl() : zzlkVarZzh.zzj).zzc(zztwVar);
            zzlkVarZzc2.zzp = jLongValue;
            return zzlkVarZzc2;
        }
        if (jLongValue != jZzq2) {
            zzdx.zzf(!zztwVar.zzb());
            long jMax = Math.max(0L, zzlkVarZzh.zzq - (jLongValue - jZzq2));
            long j = zzlkVarZzh.zzp;
            if (zzlkVarZzh.zzk.equals(zzlkVarZzh.zzb)) {
                j = jLongValue + jMax;
            }
            zzlk zzlkVarZzd = zzlkVarZzh.zzd(zztwVar, jLongValue, jLongValue, jLongValue, jMax, zzlkVarZzh.zzh, zzlkVarZzh.zzi, zzlkVarZzh.zzj);
            zzlkVarZzd.zzp = j;
            return zzlkVarZzd;
        }
        int iZza = zzcvVar.zza(zzlkVarZzh.zzk.zza);
        if (iZza != -1 && zzcvVar.zzd(iZza, this.zzn, false).zzd == zzcvVar.zzn(zztwVar.zza, this.zzn).zzd) {
            return zzlkVarZzh;
        }
        zzcvVar.zzn(zztwVar.zza, this.zzn);
        long jZzh = zztwVar.zzb() ? this.zzn.zzh(zztwVar.zzb, zztwVar.zzc) : this.zzn.zze;
        zzlk zzlkVarZzc3 = zzlkVarZzh.zzd(zztwVar, zzlkVarZzh.zzr, zzlkVarZzh.zzr, zzlkVarZzh.zzd, jZzh - zzlkVarZzh.zzr, zzlkVarZzh.zzh, zzlkVarZzh.zzi, zzlkVarZzh.zzj).zzc(zztwVar);
        zzlkVarZzc3.zzp = jZzh;
        return zzlkVarZzc3;
    }

    private final zzln zzaf(zzlm zzlmVar) {
        int iZzX = zzX(this.zzad);
        zzcv zzcvVar = this.zzad.zza;
        if (iZzX == -1) {
            iZzX = 0;
        }
        zzdy zzdyVar = this.zzu;
        zzkl zzklVar = this.zzk;
        return new zzln(zzklVar, zzlmVar, zzcvVar, iZzX, zzdyVar, zzklVar.zzb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzag(final int i, final int i2) {
        if (i == this.zzQ.zzb() && i2 == this.zzQ.zza()) {
            return;
        }
        this.zzQ = new zzfc(i, i2);
        zzeo zzeoVar = this.zzl;
        zzeoVar.zzd(24, new zzel() { // from class: com.google.android.gms.internal.ads.zzjo
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                int i3 = zzkb.zzd;
                ((zzcl) obj).zzo(i, i2);
            }
        });
        zzeoVar.zzc();
        zzah(2, 14, new zzfc(i, i2));
    }

    private final void zzah(int i, int i2, Object obj) {
        zzlr[] zzlrVarArr = this.zzh;
        int length = zzlrVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzlr zzlrVar = zzlrVarArr[i3];
            if (zzlrVar.zzb() == i) {
                zzln zzlnVarZzaf = zzaf(zzlrVar);
                zzlnVarZzaf.zzf(i2);
                zzlnVarZzaf.zze(obj);
                zzlnVarZzaf.zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzai() {
        zzah(1, 2, Float.valueOf(this.zzV * this.zzy.zza()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaj(Object obj) {
        ArrayList arrayList = new ArrayList();
        zzlr[] zzlrVarArr = this.zzh;
        int length = zzlrVarArr.length;
        boolean z = false;
        for (int i = 0; i < 2; i++) {
            zzlr zzlrVar = zzlrVarArr[i];
            if (zzlrVar.zzb() == 2) {
                zzln zzlnVarZzaf = zzaf(zzlrVar);
                zzlnVarZzaf.zzf(1);
                zzlnVarZzaf.zze(obj);
                zzlnVarZzaf.zzd();
                arrayList.add(zzlnVarZzaf);
            }
        }
        Object obj2 = this.zzN;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((zzln) it.next()).zzi(this.zzB);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z = true;
            }
            Object obj3 = this.zzN;
            Surface surface = this.zzO;
            if (obj3 == surface) {
                surface.release();
                this.zzO = null;
            }
        }
        this.zzN = obj;
        if (z) {
            zzak(zzil.zzd(new zzkm(3), PointerIconCompat.TYPE_HELP));
        }
    }

    private final void zzak(zzil zzilVar) {
        zzlk zzlkVar = this.zzad;
        zzlk zzlkVarZzc = zzlkVar.zzc(zzlkVar.zzb);
        zzlkVarZzc.zzp = zzlkVarZzc.zzr;
        zzlkVarZzc.zzq = 0L;
        zzlk zzlkVarZzg = zzlkVarZzc.zzg(1);
        if (zzilVar != null) {
            zzlkVarZzg = zzlkVarZzg.zzf(zzilVar);
        }
        this.zzC++;
        this.zzk.zzo();
        zzam(zzlkVarZzg, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzal(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        zzlk zzlkVarZzb = this.zzad;
        if (zzlkVarZzb.zzl == z2 && zzlkVarZzb.zzm == i3) {
            return;
        }
        this.zzC++;
        if (zzlkVarZzb.zzo) {
            zzlkVarZzb = zzlkVarZzb.zzb();
        }
        zzlk zzlkVarZze = zzlkVarZzb.zze(z2, i3);
        this.zzk.zzn(z2, i3);
        zzam(zzlkVarZze, 0, i2, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:102:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:104:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:105:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:108:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:110:0x030c  */
    /* JADX WARN: Code duplicated, block: B:113:0x031c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0330  */
    /* JADX WARN: Code duplicated, block: B:117:0x0340  */
    /* JADX WARN: Code duplicated, block: B:120:0x034f  */
    /* JADX WARN: Code duplicated, block: B:123:0x035d  */
    /* JADX WARN: Code duplicated, block: B:126:0x036a  */
    /* JADX WARN: Code duplicated, block: B:129:0x037d  */
    /* JADX WARN: Code duplicated, block: B:132:0x0392  */
    /* JADX WARN: Code duplicated, block: B:135:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:141:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:144:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:145:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:147:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:148:0x0402  */
    /* JADX WARN: Code duplicated, block: B:151:0x040e  */
    /* JADX WARN: Code duplicated, block: B:152:0x0410  */
    /* JADX WARN: Code duplicated, block: B:154:0x0420  */
    /* JADX WARN: Code duplicated, block: B:157:0x042b  */
    /* JADX WARN: Code duplicated, block: B:159:0x043f  */
    /* JADX WARN: Code duplicated, block: B:160:0x0441  */
    /* JADX WARN: Code duplicated, block: B:164:0x0450  */
    /* JADX WARN: Code duplicated, block: B:167:0x0460  */
    /* JADX WARN: Code duplicated, block: B:170:0x0478 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:172:0x047c  */
    /* JADX WARN: Code duplicated, block: B:175:0x0482 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:177:0x0486  */
    /* JADX WARN: Code duplicated, block: B:180:0x048d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:185:0x0497  */
    /* JADX WARN: Code duplicated, block: B:188:0x049e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:190:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:193:0x04aa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:198:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:201:0x04c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:203:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:206:0x04cf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:208:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:211:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:214:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:217:0x0508 A[LOOP:2: B:215:0x0502->B:217:0x0508, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:218:0x0514 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:40:0x010d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0113  */
    /* JADX WARN: Code duplicated, block: B:45:0x011e  */
    /* JADX WARN: Code duplicated, block: B:48:0x012d  */
    /* JADX WARN: Code duplicated, block: B:51:0x013a A[LOOP:1: B:49:0x0134->B:51:0x013a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x015a  */
    /* JADX WARN: Code duplicated, block: B:57:0x015d  */
    /* JADX WARN: Code duplicated, block: B:60:0x018a  */
    /* JADX WARN: Code duplicated, block: B:61:0x018c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0193  */
    /* JADX WARN: Code duplicated, block: B:65:0x0195  */
    /* JADX WARN: Code duplicated, block: B:68:0x019a  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:81:0x0206  */
    /* JADX WARN: Code duplicated, block: B:83:0x020e  */
    /* JADX WARN: Code duplicated, block: B:84:0x021d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0224  */
    /* JADX WARN: Code duplicated, block: B:87:0x022b  */
    /* JADX WARN: Code duplicated, block: B:88:0x022e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0236  */
    /* JADX WARN: Code duplicated, block: B:91:0x023d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0269  */
    /* JADX WARN: Code duplicated, block: B:96:0x029c  */
    /* JADX WARN: Code duplicated, block: B:99:0x02b4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r50v0 */
    /* JADX WARN: Type inference failed for: r50v1 */
    /* JADX WARN: Type inference failed for: r50v2 */
    /* JADX WARN: Type inference failed for: r50v3 */
    /* JADX WARN: Type inference failed for: r50v4 */
    /* JADX WARN: Type inference failed for: r50v5 */
    /* JADX WARN: Type inference failed for: r50v6 */
    /* JADX WARN: Type inference failed for: r8v23, types: [com.google.android.gms.internal.ads.zzcv] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v29 */
    private final void zzam(final zzlk zzlkVar, final int i, final int i2, boolean z, int i3, long j, int i4, boolean z2) {
        int i5;
        boolean z3;
        boolean z4;
        Pair pair;
        boolean z5;
        int i6;
        boolean zBooleanValue;
        final int iIntValue;
        final zzbp zzbpVar;
        zzcv zzcvVarZzn;
        zzbv zzbvVarZzu;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        zzxr zzxrVar;
        zzxr zzxrVar2;
        zzck zzckVar;
        zzm zzmVar;
        zzcv zzcvVarZzn2;
        boolean z10;
        zzcv zzcvVarZzn3;
        ?? r10;
        int iZzk;
        int i7;
        boolean z11;
        ?? Zzn;
        int iZzd;
        ?? r8;
        zzcv zzcvVarZzn4;
        ?? r50;
        long j2;
        boolean z12;
        ?? r51;
        zzcv zzcvVarZzn5;
        boolean z13;
        boolean zZzo;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        int i8;
        boolean z19;
        boolean z20;
        zzck zzckVarZze;
        Iterator it;
        ?? r52;
        zzcs zzcsVar;
        int i9;
        Object obj;
        zzbp zzbpVar2;
        Object obj2;
        int i10;
        long jZzab;
        long jZzab2;
        int iZzd2;
        Object obj3;
        zzbp zzbpVar3;
        Object obj4;
        int iZza;
        long jZzs;
        long jZzs2;
        zzbt zzbtVarZza;
        List list;
        int i11;
        zzby zzbyVar;
        int i12;
        final int i13 = i3;
        zzlk zzlkVar2 = this.zzad;
        this.zzad = zzlkVar;
        boolean z21 = !zzlkVar2.zza.equals(zzlkVar.zza);
        zzcv zzcvVar = zzlkVar2.zza;
        zzcv zzcvVar2 = zzlkVar.zza;
        if (!zzcvVar2.zzo() || !zzcvVar.zzo()) {
            if (zzcvVar2.zzo() != zzcvVar.zzo()) {
                pair = new Pair(true, 3);
            } else if (zzcvVar.zze(zzcvVar.zzn(zzlkVar2.zzb.zza, this.zzn).zzd, this.zza, 0L).zzc.equals(zzcvVar2.zze(zzcvVar2.zzn(zzlkVar.zzb.zza, this.zzn).zzd, this.zza, 0L).zzc)) {
                if (!z) {
                    i5 = i13;
                    z3 = false;
                } else if (i13 != 0) {
                    i5 = i13;
                    z3 = true;
                } else if (zzlkVar2.zzb.zzd < zzlkVar.zzb.zzd) {
                    pair = new Pair(true, 0);
                    z4 = true;
                    i13 = 0;
                } else {
                    z3 = true;
                    i5 = 0;
                }
                z4 = z3;
                i13 = i5;
                pair = new Pair(false, -1);
            } else {
                if (z) {
                    if (i13 == 0) {
                        z4 = true;
                        i6 = 1;
                        i13 = 0;
                    } else {
                        z4 = true;
                        z5 = true;
                    }
                    pair = new Pair(true, Integer.valueOf(i6));
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (z4 && i13 == 1) {
                    z4 = z5;
                    i6 = 2;
                } else {
                    if (!z21) {
                        throw new IllegalStateException();
                    }
                    i6 = 3;
                }
                pair = new Pair(true, Integer.valueOf(i6));
            }
            zBooleanValue = ((Boolean) pair.first).booleanValue();
            iIntValue = ((Integer) pair.second).intValue();
            if (zBooleanValue) {
                if (zzlkVar.zza.zzo()) {
                    zzbpVar = null;
                } else {
                    zzbpVar = zzlkVar.zza.zze(zzlkVar.zza.zzn(zzlkVar.zzb.zza, this.zzn).zzd, this.zza, 0L).zze;
                }
                this.zzac = zzbv.zza;
            } else {
                zzbpVar = null;
            }
            if (!zzlkVar2.zzj.equals(zzlkVar.zzj)) {
                zzbtVarZza = this.zzac.zza();
                list = zzlkVar.zzj;
                for (i11 = 0; i11 < list.size(); i11++) {
                    zzbyVar = (zzby) list.get(i11);
                    for (i12 = 0; i12 < zzbyVar.zza(); i12++) {
                        zzbyVar.zzb(i12).zza(zzbtVarZza);
                    }
                }
                this.zzac = zzbtVarZza.zzu();
            }
            zzcvVarZzn = zzn();
            if (zzcvVarZzn.zzo()) {
                zzbvVarZzu = this.zzac;
            } else {
                zzbp zzbpVar4 = zzcvVarZzn.zze(zzd(), this.zza, 0L).zze;
                zzbt zzbtVarZza2 = this.zzac.zza();
                zzbtVarZza2.zzb(zzbpVar4.zzg);
                zzbvVarZzu = zzbtVarZza2.zzu();
            }
            z6 = !zzbvVarZzu.equals(this.zzI);
            this.zzI = zzbvVarZzu;
            if (zzlkVar2.zzl != zzlkVar.zzl) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (zzlkVar2.zze != zzlkVar.zze) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8 || z7) {
                zzan();
            }
            if (zzlkVar2.zzg != zzlkVar.zzg) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z21) {
                this.zzl.zzd(0, new zzel() { // from class: com.google.android.gms.internal.ads.zziz
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj5) {
                        int i14 = zzkb.zzd;
                        ((zzcl) obj5).zzp(zzlkVar.zza, i);
                    }
                });
            }
            if (z4) {
                zzcsVar = new zzcs();
                if (zzlkVar2.zza.zzo()) {
                    i9 = i4;
                    obj = null;
                    zzbpVar2 = null;
                    obj2 = null;
                    i10 = -1;
                } else {
                    Object obj5 = zzlkVar2.zzb.zza;
                    zzlkVar2.zza.zzn(obj5, zzcsVar);
                    int i14 = zzcsVar.zzd;
                    int iZza2 = zzlkVar2.zza.zza(obj5);
                    obj2 = obj5;
                    obj = zzlkVar2.zza.zze(i14, this.zza, 0L).zzc;
                    zzbpVar2 = this.zza.zze;
                    i9 = i14;
                    i10 = iZza2;
                }
                if (i13 == 0) {
                    if (zzlkVar2.zzb.zzb()) {
                        zztw zztwVar = zzlkVar2.zzb;
                        jZzab = zzcsVar.zzh(zztwVar.zzb, zztwVar.zzc);
                        jZzab2 = zzab(zzlkVar2);
                    } else {
                        if (zzlkVar2.zzb.zze != -1) {
                            jZzab = zzab(this.zzad);
                        } else {
                            jZzab = zzcsVar.zze;
                        }
                        jZzab2 = jZzab;
                    }
                } else if (zzlkVar2.zzb.zzb()) {
                    jZzab = zzlkVar2.zzr;
                    jZzab2 = zzab(zzlkVar2);
                } else {
                    jZzab = zzlkVar2.zzr;
                    jZzab2 = jZzab;
                }
                int i15 = zzfk.zza;
                zztw zztwVar2 = zzlkVar2.zzb;
                final zzcn zzcnVar = new zzcn(obj, i9, zzbpVar2, obj2, i10, zzfk.zzs(jZzab), zzfk.zzs(jZzab2), zztwVar2.zzb, zztwVar2.zzc);
                iZzd2 = zzd();
                if (this.zzad.zza.zzo()) {
                    obj3 = null;
                    zzbpVar3 = null;
                    obj4 = null;
                    iZza = -1;
                } else {
                    zzlk zzlkVar3 = this.zzad;
                    Object obj6 = zzlkVar3.zzb.zza;
                    zzlkVar3.zza.zzn(obj6, this.zzn);
                    iZza = this.zzad.zza.zza(obj6);
                    obj3 = this.zzad.zza.zze(iZzd2, this.zza, 0L).zzc;
                    zzbpVar3 = this.zza.zze;
                    obj4 = obj6;
                }
                jZzs = zzfk.zzs(j);
                if (this.zzad.zzb.zzb()) {
                    jZzs2 = zzfk.zzs(zzab(this.zzad));
                } else {
                    jZzs2 = jZzs;
                }
                zztw zztwVar3 = this.zzad.zzb;
                final zzcn zzcnVar2 = new zzcn(obj3, iZzd2, zzbpVar3, obj4, iZza, jZzs, jZzs2, zztwVar3.zzb, zztwVar3.zzc);
                this.zzl.zzd(11, new zzel() { // from class: com.google.android.gms.internal.ads.zzje
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zzm(zzcnVar, zzcnVar2, i13);
                    }
                });
            } else {
                z8 = z8;
                z9 = z9;
            }
            if (zBooleanValue) {
                this.zzl.zzd(1, new zzel() { // from class: com.google.android.gms.internal.ads.zzjg
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zzd(zzbpVar, iIntValue);
                    }
                });
            }
            if (zzlkVar2.zzf != zzlkVar.zzf) {
                this.zzl.zzd(10, new zzel() { // from class: com.google.android.gms.internal.ads.zzjh
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zzk(zzlkVar.zzf);
                    }
                });
                if (zzlkVar.zzf != null) {
                    this.zzl.zzd(10, new zzel() { // from class: com.google.android.gms.internal.ads.zzji
                        @Override // com.google.android.gms.internal.ads.zzel
                        public final void zza(Object obj7) {
                            int i16 = zzkb.zzd;
                            ((zzcl) obj7).zzj(zzlkVar.zzf);
                        }
                    });
                }
            }
            zzxrVar = zzlkVar2.zzi;
            zzxrVar2 = zzlkVar.zzi;
            if (zzxrVar != zzxrVar2) {
                this.zzi.zzp(zzxrVar2.zze);
                this.zzl.zzd(2, new zzel() { // from class: com.google.android.gms.internal.ads.zzjj
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zzq(zzlkVar.zzi.zzd);
                    }
                });
            }
            if (z6) {
                final zzbv zzbvVar = this.zzI;
                this.zzl.zzd(14, new zzel() { // from class: com.google.android.gms.internal.ads.zzjk
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zze(zzbvVar);
                    }
                });
            }
            if (z9) {
                this.zzl.zzd(3, new zzel() { // from class: com.google.android.gms.internal.ads.zzjl
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zzb(zzlkVar.zzg);
                    }
                });
            }
            if (z8 || z7) {
                this.zzl.zzd(-1, new zzel() { // from class: com.google.android.gms.internal.ads.zzjm
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        zzlk zzlkVar4 = zzlkVar;
                        ((zzcl) obj7).zzl(zzlkVar4.zzl, zzlkVar4.zze);
                    }
                });
            }
            if (z8) {
                this.zzl.zzd(4, new zzel() { // from class: com.google.android.gms.internal.ads.zzjn
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zzh(zzlkVar.zze);
                    }
                });
            }
            if (z7) {
                this.zzl.zzd(5, new zzel() { // from class: com.google.android.gms.internal.ads.zzja
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zzf(zzlkVar.zzl, i2);
                    }
                });
            }
            if (zzlkVar2.zzm != zzlkVar.zzm) {
                this.zzl.zzd(6, new zzel() { // from class: com.google.android.gms.internal.ads.zzjb
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zzi(zzlkVar.zzm);
                    }
                });
            }
            if (zzlkVar2.zzk() != zzlkVar.zzk()) {
                this.zzl.zzd(7, new zzel() { // from class: com.google.android.gms.internal.ads.zzjc
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zzc(zzlkVar.zzk());
                    }
                });
            }
            if (!zzlkVar2.zzn.equals(zzlkVar.zzn)) {
                this.zzl.zzd(12, new zzel() { // from class: com.google.android.gms.internal.ads.zzjd
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        int i16 = zzkb.zzd;
                        ((zzcl) obj7).zzg(zzlkVar.zzn);
                    }
                });
            }
            zzckVar = this.zzH;
            zzco zzcoVar = this.zzg;
            zzck zzckVar2 = this.zzc;
            int i16 = zzfk.zza;
            boolean zZzx = zzcoVar.zzx();
            zzmVar = (zzm) zzcoVar;
            zzcvVarZzn2 = zzmVar.zzn();
            if (zzcvVarZzn2.zzo() && zzcvVarZzn2.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzi) {
                z10 = true;
            } else {
                z10 = false;
            }
            zzcvVarZzn3 = zzmVar.zzn();
            if (zzcvVarZzn3.zzo()) {
                i7 = -1;
                r10 = 0;
                z11 = false;
            } else {
                int iZzd3 = zzmVar.zzd();
                zzmVar.zzh();
                zzmVar.zzw();
                r10 = 0;
                r10 = 0;
                iZzk = zzcvVarZzn3.zzk(iZzd3, 0, false);
                i7 = -1;
                if (iZzk != -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
            Zzn = zzmVar.zzn();
            if (Zzn.zzo()) {
                r8 = r10;
            } else {
                iZzd = zzmVar.zzd();
                zzmVar.zzh();
                zzmVar.zzw();
                if (Zzn.zzj(iZzd, r10, r10) != i7) {
                    r8 = 1;
                } else {
                    r8 = r10;
                }
            }
            zzcvVarZzn4 = zzmVar.zzn();
            if (!zzcvVarZzn4.zzo()) {
                r52 = r8;
                j2 = 0;
                if (zzcvVarZzn4.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzb()) {
                    r50 = r52;
                    z12 = true;
                    r51 = r52;
                }
                zzcvVarZzn5 = zzmVar.zzn();
                if (zzcvVarZzn5.zzo() && zzcvVarZzn5.zze(zzmVar.zzd(), zzmVar.zza, j2).zzj) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                zZzo = zzcoVar.zzn().zzo();
                zzci zzciVar = new zzci();
                zzciVar.zzb(zzckVar2);
                boolean z22 = !zZzx;
                zzciVar.zzd(4, z22);
                if (z10 || zZzx) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                zzciVar.zzd(5, z14);
                if (z11 || zZzx) {
                    z15 = false;
                } else {
                    z15 = true;
                }
                zzciVar.zzd(6, z15);
                if (!zZzo || (!(z11 || !z12 || z10) || zZzx)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                zzciVar.zzd(7, z16);
                if (r51 != 0 || zZzx) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                zzciVar.zzd(8, z17);
                if (!zZzo || ((r51 == 0 && !(z12 && z13)) || zZzx)) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                zzciVar.zzd(9, z18);
                zzciVar.zzd(10, z22);
                if (z10 || zZzx) {
                    i8 = 11;
                    z19 = false;
                } else {
                    i8 = 11;
                    z19 = true;
                }
                zzciVar.zzd(i8, z19);
                if (z10 || zZzx) {
                    z20 = false;
                } else {
                    z20 = true;
                }
                zzciVar.zzd(12, z20);
                zzckVarZze = zzciVar.zze();
                this.zzH = zzckVarZze;
                if (!zzckVarZze.equals(zzckVar)) {
                    this.zzl.zzd(13, new zzel() { // from class: com.google.android.gms.internal.ads.zziy
                        @Override // com.google.android.gms.internal.ads.zzel
                        public final void zza(Object obj7) {
                            this.zza.zzV((zzcl) obj7);
                        }
                    });
                }
                this.zzl.zzc();
                if (zzlkVar2.zzo != zzlkVar.zzo) {
                    it = this.zzm.iterator();
                    while (it.hasNext()) {
                        ((zzim) it.next()).zza(zzlkVar.zzo);
                    }
                }
            }
            r50 = r8;
            j2 = 0;
            r50 = r52;
            z12 = false;
            r51 = r50;
            zzcvVarZzn5 = zzmVar.zzn();
            if (zzcvVarZzn5.zzo()) {
                z13 = false;
            } else {
                z13 = false;
            }
            zZzo = zzcoVar.zzn().zzo();
            zzci zzciVar2 = new zzci();
            zzciVar2.zzb(zzckVar2);
            boolean z23 = !zZzx;
            zzciVar2.zzd(4, z23);
            if (z10) {
                z14 = false;
            } else {
                z14 = false;
            }
            zzciVar2.zzd(5, z14);
            if (z11) {
                z15 = false;
            } else {
                z15 = false;
            }
            zzciVar2.zzd(6, z15);
            if (zZzo) {
                z16 = false;
            } else {
                z16 = false;
            }
            zzciVar2.zzd(7, z16);
            if (r51 != 0) {
                z17 = false;
            } else {
                z17 = false;
            }
            zzciVar2.zzd(8, z17);
            if (zZzo) {
                z18 = false;
            } else {
                z18 = false;
            }
            zzciVar2.zzd(9, z18);
            zzciVar2.zzd(10, z23);
            if (z10) {
                i8 = 11;
                z19 = false;
            } else {
                i8 = 11;
                z19 = false;
            }
            zzciVar2.zzd(i8, z19);
            if (z10) {
                z20 = false;
            } else {
                z20 = false;
            }
            zzciVar2.zzd(12, z20);
            zzckVarZze = zzciVar2.zze();
            this.zzH = zzckVarZze;
            if (!zzckVarZze.equals(zzckVar)) {
                this.zzl.zzd(13, new zzel() { // from class: com.google.android.gms.internal.ads.zziy
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj7) {
                        this.zza.zzV((zzcl) obj7);
                    }
                });
            }
            this.zzl.zzc();
            if (zzlkVar2.zzo != zzlkVar.zzo) {
                it = this.zzm.iterator();
                while (it.hasNext()) {
                    ((zzim) it.next()).zza(zzlkVar.zzo);
                }
            }
        }
        pair = new Pair(false, -1);
        z4 = z;
        zBooleanValue = ((Boolean) pair.first).booleanValue();
        iIntValue = ((Integer) pair.second).intValue();
        if (zBooleanValue) {
            if (zzlkVar.zza.zzo()) {
                zzbpVar = zzlkVar.zza.zze(zzlkVar.zza.zzn(zzlkVar.zzb.zza, this.zzn).zzd, this.zza, 0L).zze;
            } else {
                zzbpVar = null;
            }
            this.zzac = zzbv.zza;
        } else {
            zzbpVar = null;
        }
        if (!zzlkVar2.zzj.equals(zzlkVar.zzj)) {
            zzbtVarZza = this.zzac.zza();
            list = zzlkVar.zzj;
            while (i11 < list.size()) {
                zzbyVar = (zzby) list.get(i11);
                while (i12 < zzbyVar.zza()) {
                    zzbyVar.zzb(i12).zza(zzbtVarZza);
                }
            }
            this.zzac = zzbtVarZza.zzu();
        }
        zzcvVarZzn = zzn();
        if (zzcvVarZzn.zzo()) {
            zzbvVarZzu = this.zzac;
        } else {
            zzbp zzbpVar5 = zzcvVarZzn.zze(zzd(), this.zza, 0L).zze;
            zzbt zzbtVarZza3 = this.zzac.zza();
            zzbtVarZza3.zzb(zzbpVar5.zzg);
            zzbvVarZzu = zzbtVarZza3.zzu();
        }
        z6 = !zzbvVarZzu.equals(this.zzI);
        this.zzI = zzbvVarZzu;
        if (zzlkVar2.zzl != zzlkVar.zzl) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (zzlkVar2.zze != zzlkVar.zze) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            zzan();
        } else {
            zzan();
        }
        if (zzlkVar2.zzg != zzlkVar.zzg) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z21) {
            this.zzl.zzd(0, new zzel() { // from class: com.google.android.gms.internal.ads.zziz
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj7) {
                    int i17 = zzkb.zzd;
                    ((zzcl) obj7).zzp(zzlkVar.zza, i);
                }
            });
        }
        if (z4) {
            zzcsVar = new zzcs();
            if (zzlkVar2.zza.zzo()) {
                Object obj7 = zzlkVar2.zzb.zza;
                zzlkVar2.zza.zzn(obj7, zzcsVar);
                int i17 = zzcsVar.zzd;
                int iZza3 = zzlkVar2.zza.zza(obj7);
                obj2 = obj7;
                obj = zzlkVar2.zza.zze(i17, this.zza, 0L).zzc;
                zzbpVar2 = this.zza.zze;
                i9 = i17;
                i10 = iZza3;
            } else {
                i9 = i4;
                obj = null;
                zzbpVar2 = null;
                obj2 = null;
                i10 = -1;
            }
            if (i13 == 0) {
                if (zzlkVar2.zzb.zzb()) {
                    zztw zztwVar4 = zzlkVar2.zzb;
                    jZzab = zzcsVar.zzh(zztwVar4.zzb, zztwVar4.zzc);
                    jZzab2 = zzab(zzlkVar2);
                } else {
                    if (zzlkVar2.zzb.zze != -1) {
                        jZzab = zzab(this.zzad);
                    } else {
                        jZzab = zzcsVar.zze;
                    }
                    jZzab2 = jZzab;
                }
            } else if (zzlkVar2.zzb.zzb()) {
                jZzab = zzlkVar2.zzr;
                jZzab2 = zzab(zzlkVar2);
            } else {
                jZzab = zzlkVar2.zzr;
                jZzab2 = jZzab;
            }
            int i18 = zzfk.zza;
            zztw zztwVar5 = zzlkVar2.zzb;
            final zzcn zzcnVar3 = new zzcn(obj, i9, zzbpVar2, obj2, i10, zzfk.zzs(jZzab), zzfk.zzs(jZzab2), zztwVar5.zzb, zztwVar5.zzc);
            iZzd2 = zzd();
            if (this.zzad.zza.zzo()) {
                zzlk zzlkVar4 = this.zzad;
                Object obj8 = zzlkVar4.zzb.zza;
                zzlkVar4.zza.zzn(obj8, this.zzn);
                iZza = this.zzad.zza.zza(obj8);
                obj3 = this.zzad.zza.zze(iZzd2, this.zza, 0L).zzc;
                zzbpVar3 = this.zza.zze;
                obj4 = obj8;
            } else {
                obj3 = null;
                zzbpVar3 = null;
                obj4 = null;
                iZza = -1;
            }
            jZzs = zzfk.zzs(j);
            if (this.zzad.zzb.zzb()) {
                jZzs2 = zzfk.zzs(zzab(this.zzad));
            } else {
                jZzs2 = jZzs;
            }
            zztw zztwVar6 = this.zzad.zzb;
            final zzcn zzcnVar4 = new zzcn(obj3, iZzd2, zzbpVar3, obj4, iZza, jZzs, jZzs2, zztwVar6.zzb, zztwVar6.zzc);
            this.zzl.zzd(11, new zzel() { // from class: com.google.android.gms.internal.ads.zzje
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zzm(zzcnVar3, zzcnVar4, i13);
                }
            });
        } else {
            z8 = z8;
            z9 = z9;
        }
        if (zBooleanValue) {
            this.zzl.zzd(1, new zzel() { // from class: com.google.android.gms.internal.ads.zzjg
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zzd(zzbpVar, iIntValue);
                }
            });
        }
        if (zzlkVar2.zzf != zzlkVar.zzf) {
            this.zzl.zzd(10, new zzel() { // from class: com.google.android.gms.internal.ads.zzjh
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zzk(zzlkVar.zzf);
                }
            });
            if (zzlkVar.zzf != null) {
                this.zzl.zzd(10, new zzel() { // from class: com.google.android.gms.internal.ads.zzji
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj9) {
                        int i19 = zzkb.zzd;
                        ((zzcl) obj9).zzj(zzlkVar.zzf);
                    }
                });
            }
        }
        zzxrVar = zzlkVar2.zzi;
        zzxrVar2 = zzlkVar.zzi;
        if (zzxrVar != zzxrVar2) {
            this.zzi.zzp(zzxrVar2.zze);
            this.zzl.zzd(2, new zzel() { // from class: com.google.android.gms.internal.ads.zzjj
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zzq(zzlkVar.zzi.zzd);
                }
            });
        }
        if (z6) {
            final zzbv zzbvVar2 = this.zzI;
            this.zzl.zzd(14, new zzel() { // from class: com.google.android.gms.internal.ads.zzjk
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zze(zzbvVar2);
                }
            });
        }
        if (z9) {
            this.zzl.zzd(3, new zzel() { // from class: com.google.android.gms.internal.ads.zzjl
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zzb(zzlkVar.zzg);
                }
            });
        }
        if (z8) {
            this.zzl.zzd(-1, new zzel() { // from class: com.google.android.gms.internal.ads.zzjm
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    zzlk zzlkVar5 = zzlkVar;
                    ((zzcl) obj9).zzl(zzlkVar5.zzl, zzlkVar5.zze);
                }
            });
        } else {
            this.zzl.zzd(-1, new zzel() { // from class: com.google.android.gms.internal.ads.zzjm
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    zzlk zzlkVar5 = zzlkVar;
                    ((zzcl) obj9).zzl(zzlkVar5.zzl, zzlkVar5.zze);
                }
            });
        }
        if (z8) {
            this.zzl.zzd(4, new zzel() { // from class: com.google.android.gms.internal.ads.zzjn
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zzh(zzlkVar.zze);
                }
            });
        }
        if (z7) {
            this.zzl.zzd(5, new zzel() { // from class: com.google.android.gms.internal.ads.zzja
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zzf(zzlkVar.zzl, i2);
                }
            });
        }
        if (zzlkVar2.zzm != zzlkVar.zzm) {
            this.zzl.zzd(6, new zzel() { // from class: com.google.android.gms.internal.ads.zzjb
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zzi(zzlkVar.zzm);
                }
            });
        }
        if (zzlkVar2.zzk() != zzlkVar.zzk()) {
            this.zzl.zzd(7, new zzel() { // from class: com.google.android.gms.internal.ads.zzjc
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zzc(zzlkVar.zzk());
                }
            });
        }
        if (!zzlkVar2.zzn.equals(zzlkVar.zzn)) {
            this.zzl.zzd(12, new zzel() { // from class: com.google.android.gms.internal.ads.zzjd
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    int i19 = zzkb.zzd;
                    ((zzcl) obj9).zzg(zzlkVar.zzn);
                }
            });
        }
        zzckVar = this.zzH;
        zzco zzcoVar2 = this.zzg;
        zzck zzckVar3 = this.zzc;
        int i19 = zzfk.zza;
        boolean zZzx2 = zzcoVar2.zzx();
        zzmVar = (zzm) zzcoVar2;
        zzcvVarZzn2 = zzmVar.zzn();
        if (zzcvVarZzn2.zzo()) {
            z10 = false;
        } else {
            z10 = false;
        }
        zzcvVarZzn3 = zzmVar.zzn();
        if (zzcvVarZzn3.zzo()) {
            i7 = -1;
            r10 = 0;
            z11 = false;
        } else {
            int iZzd4 = zzmVar.zzd();
            zzmVar.zzh();
            zzmVar.zzw();
            r10 = 0;
            r10 = 0;
            iZzk = zzcvVarZzn3.zzk(iZzd4, 0, false);
            i7 = -1;
            if (iZzk != -1) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        Zzn = zzmVar.zzn();
        if (Zzn.zzo()) {
            r8 = r10;
        } else {
            iZzd = zzmVar.zzd();
            zzmVar.zzh();
            zzmVar.zzw();
            if (Zzn.zzj(iZzd, r10, r10) != i7) {
                r8 = 1;
            } else {
                r8 = r10;
            }
        }
        zzcvVarZzn4 = zzmVar.zzn();
        if (!zzcvVarZzn4.zzo()) {
            r52 = r8;
            j2 = 0;
            if (zzcvVarZzn4.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzb()) {
                r50 = r52;
                z12 = true;
                r51 = r52;
            }
            zzcvVarZzn5 = zzmVar.zzn();
            if (zzcvVarZzn5.zzo()) {
                z13 = false;
            } else {
                z13 = false;
            }
            zZzo = zzcoVar2.zzn().zzo();
            zzci zzciVar3 = new zzci();
            zzciVar3.zzb(zzckVar3);
            boolean z24 = !zZzx2;
            zzciVar3.zzd(4, z24);
            if (z10) {
                z14 = false;
            } else {
                z14 = false;
            }
            zzciVar3.zzd(5, z14);
            if (z11) {
                z15 = false;
            } else {
                z15 = false;
            }
            zzciVar3.zzd(6, z15);
            if (zZzo) {
                z16 = false;
            } else {
                z16 = false;
            }
            zzciVar3.zzd(7, z16);
            if (r51 != 0) {
                z17 = false;
            } else {
                z17 = false;
            }
            zzciVar3.zzd(8, z17);
            if (zZzo) {
                z18 = false;
            } else {
                z18 = false;
            }
            zzciVar3.zzd(9, z18);
            zzciVar3.zzd(10, z24);
            if (z10) {
                i8 = 11;
                z19 = false;
            } else {
                i8 = 11;
                z19 = false;
            }
            zzciVar3.zzd(i8, z19);
            if (z10) {
                z20 = false;
            } else {
                z20 = false;
            }
            zzciVar3.zzd(12, z20);
            zzckVarZze = zzciVar3.zze();
            this.zzH = zzckVarZze;
            if (!zzckVarZze.equals(zzckVar)) {
                this.zzl.zzd(13, new zzel() { // from class: com.google.android.gms.internal.ads.zziy
                    @Override // com.google.android.gms.internal.ads.zzel
                    public final void zza(Object obj9) {
                        this.zza.zzV((zzcl) obj9);
                    }
                });
            }
            this.zzl.zzc();
            if (zzlkVar2.zzo != zzlkVar.zzo) {
                it = this.zzm.iterator();
                while (it.hasNext()) {
                    ((zzim) it.next()).zza(zzlkVar.zzo);
                }
            }
        }
        r50 = r8;
        j2 = 0;
        r50 = r52;
        z12 = false;
        r51 = r50;
        zzcvVarZzn5 = zzmVar.zzn();
        if (zzcvVarZzn5.zzo()) {
            z13 = false;
        } else {
            z13 = false;
        }
        zZzo = zzcoVar2.zzn().zzo();
        zzci zzciVar4 = new zzci();
        zzciVar4.zzb(zzckVar3);
        boolean z25 = !zZzx2;
        zzciVar4.zzd(4, z25);
        if (z10) {
            z14 = false;
        } else {
            z14 = false;
        }
        zzciVar4.zzd(5, z14);
        if (z11) {
            z15 = false;
        } else {
            z15 = false;
        }
        zzciVar4.zzd(6, z15);
        if (zZzo) {
            z16 = false;
        } else {
            z16 = false;
        }
        zzciVar4.zzd(7, z16);
        if (r51 != 0) {
            z17 = false;
        } else {
            z17 = false;
        }
        zzciVar4.zzd(8, z17);
        if (zZzo) {
            z18 = false;
        } else {
            z18 = false;
        }
        zzciVar4.zzd(9, z18);
        zzciVar4.zzd(10, z25);
        if (z10) {
            i8 = 11;
            z19 = false;
        } else {
            i8 = 11;
            z19 = false;
        }
        zzciVar4.zzd(i8, z19);
        if (z10) {
            z20 = false;
        } else {
            z20 = false;
        }
        zzciVar4.zzd(12, z20);
        zzckVarZze = zzciVar4.zze();
        this.zzH = zzckVarZze;
        if (!zzckVarZze.equals(zzckVar)) {
            this.zzl.zzd(13, new zzel() { // from class: com.google.android.gms.internal.ads.zziy
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj9) {
                    this.zza.zzV((zzcl) obj9);
                }
            });
        }
        this.zzl.zzc();
        if (zzlkVar2.zzo != zzlkVar.zzo) {
            it = this.zzm.iterator();
            while (it.hasNext()) {
                ((zzim) it.next()).zza(zzlkVar.zzo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzan() {
        int iZzf = zzf();
        if (iZzf == 2 || iZzf == 3) {
            zzao();
            boolean z = this.zzad.zzo;
            zzv();
            zzv();
        }
    }

    private final void zzao() {
        this.zze.zzb();
        if (Thread.currentThread() != this.zzs.getThread()) {
            String str = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.zzs.getThread().getName());
            if (this.zzY) {
                throw new IllegalStateException(str);
            }
            zzer.zzg("ExoPlayerImpl", str, this.zzZ ? null : new IllegalStateException());
            this.zzZ = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zziw
    public final void zzA(zzme zzmeVar) {
        zzao();
        this.zzr.zzO(zzmeVar);
    }

    @Override // com.google.android.gms.internal.ads.zziw
    public final void zzB(zzty zztyVar) {
        zzao();
        List listSingletonList = Collections.singletonList(zztyVar);
        zzao();
        zzao();
        zzX(this.zzad);
        zzk();
        this.zzC++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i = size - 1; i >= 0; i--) {
                this.zzo.remove(i);
            }
            this.zzah = this.zzah.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listSingletonList.size(); i2++) {
            zzlh zzlhVar = new zzlh((zzty) listSingletonList.get(i2), this.zzp);
            arrayList.add(zzlhVar);
            this.zzo.add(i2, new zzka(zzlhVar.zzb, zzlhVar.zza));
        }
        this.zzah = this.zzah.zzg(0, arrayList.size());
        zzlp zzlpVar = new zzlp(this.zzo, this.zzah);
        if (!zzlpVar.zzo() && zzlpVar.zzc() < 0) {
            throw new zzan(zzlpVar, -1, -9223372036854775807L);
        }
        int iZzg = zzlpVar.zzg(false);
        zzlk zzlkVarZzae = zzae(this.zzad, zzlpVar, zzad(zzlpVar, iZzg, -9223372036854775807L));
        int i3 = zzlkVarZzae.zze;
        if (iZzg != -1 && i3 != 1) {
            i3 = (zzlpVar.zzo() || iZzg >= zzlpVar.zzc()) ? 4 : 2;
        }
        zzlk zzlkVarZzg = zzlkVarZzae.zzg(i3);
        this.zzk.zzq(arrayList, iZzg, zzfk.zzq(-9223372036854775807L), this.zzah);
        zzam(zzlkVarZzg, 0, 1, (this.zzad.zzb.zza.equals(zzlkVarZzg.zzb.zza) || this.zzad.zza.zzo()) ? false : true, 4, zzaa(zzlkVarZzg), -1, false);
    }

    public final zzil zzE() {
        zzao();
        return this.zzad.zzf;
    }

    final /* synthetic */ void zzT(zzkj zzkjVar) {
        long j;
        boolean z;
        int i = this.zzC - zzkjVar.zzb;
        this.zzC = i;
        boolean z2 = true;
        if (zzkjVar.zzc) {
            this.zzD = zzkjVar.zzd;
            this.zzE = true;
        }
        if (zzkjVar.zze) {
            this.zzF = zzkjVar.zzf;
        }
        if (i == 0) {
            zzcv zzcvVar = zzkjVar.zza.zza;
            if (!this.zzad.zza.zzo() && zzcvVar.zzo()) {
                this.zzae = -1;
                this.zzaf = 0L;
            }
            if (!zzcvVar.zzo()) {
                List listZzw = ((zzlp) zzcvVar).zzw();
                zzdx.zzf(listZzw.size() == this.zzo.size());
                for (int i2 = 0; i2 < listZzw.size(); i2++) {
                    ((zzka) this.zzo.get(i2)).zzc((zzcv) listZzw.get(i2));
                }
            }
            if (this.zzE) {
                if (zzkjVar.zza.zzb.equals(this.zzad.zzb) && zzkjVar.zza.zzd == this.zzad.zzr) {
                    z2 = false;
                }
                if (!z2) {
                    j = -9223372036854775807L;
                } else if (zzcvVar.zzo() || zzkjVar.zza.zzb.zzb()) {
                    j = zzkjVar.zza.zzd;
                } else {
                    zzlk zzlkVar = zzkjVar.zza;
                    zztw zztwVar = zzlkVar.zzb;
                    j = zzlkVar.zzd;
                    zzac(zzcvVar, zztwVar, j);
                }
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.zzE = false;
            zzam(zzkjVar.zza, 1, this.zzF, z, this.zzD, j, -1, false);
        }
    }

    final /* synthetic */ void zzU(final zzkj zzkjVar) {
        this.zzj.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzT(zzkjVar);
            }
        });
    }

    final /* synthetic */ void zzV(zzcl zzclVar) {
        zzclVar.zza(this.zzH);
    }

    @Override // com.google.android.gms.internal.ads.zzm
    public final void zza(int i, long j, int i2, boolean z) {
        zzao();
        zzdx.zzd(i >= 0);
        this.zzr.zzu();
        zzcv zzcvVar = this.zzad.zza;
        if (zzcvVar.zzo() || i < zzcvVar.zzc()) {
            this.zzC++;
            if (zzx()) {
                zzer.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzkj zzkjVar = new zzkj(this.zzad);
                zzkjVar.zza(1);
                this.zzag.zza.zzU(zzkjVar);
                return;
            }
            zzlk zzlkVarZzg = this.zzad;
            int i3 = zzlkVarZzg.zze;
            if (i3 == 3 || (i3 == 4 && !zzcvVar.zzo())) {
                zzlkVarZzg = this.zzad.zzg(2);
            }
            int iZzd = zzd();
            zzlk zzlkVarZzae = zzae(zzlkVarZzg, zzcvVar, zzad(zzcvVar, i, j));
            this.zzk.zzl(zzcvVar, i, zzfk.zzq(j));
            zzam(zzlkVarZzae, 0, 1, true, 1, zzaa(zzlkVarZzae), iZzd, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzb() {
        zzao();
        if (zzx()) {
            return this.zzad.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzc() {
        zzao();
        if (zzx()) {
            return this.zzad.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzd() {
        zzao();
        int iZzX = zzX(this.zzad);
        if (iZzX == -1) {
            return 0;
        }
        return iZzX;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zze() {
        zzao();
        if (this.zzad.zza.zzo()) {
            return 0;
        }
        zzlk zzlkVar = this.zzad;
        return zzlkVar.zza.zza(zzlkVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzf() {
        zzao();
        return this.zzad.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzg() {
        zzao();
        return this.zzad.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzh() {
        zzao();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzi() {
        zzao();
        if (zzx()) {
            zzlk zzlkVar = this.zzad;
            return zzlkVar.zzk.equals(zzlkVar.zzb) ? zzfk.zzs(this.zzad.zzp) : zzl();
        }
        zzao();
        if (this.zzad.zza.zzo()) {
            return this.zzaf;
        }
        zzlk zzlkVar2 = this.zzad;
        long j = 0;
        if (zzlkVar2.zzk.zzd != zzlkVar2.zzb.zzd) {
            return zzfk.zzs(zzlkVar2.zza.zze(zzd(), this.zza, 0L).zzo);
        }
        long j2 = zzlkVar2.zzp;
        if (this.zzad.zzk.zzb()) {
            zzlk zzlkVar3 = this.zzad;
            zzlkVar3.zza.zzn(zzlkVar3.zzk.zza, this.zzn).zzi(this.zzad.zzk.zzb);
        } else {
            j = j2;
        }
        zzlk zzlkVar4 = this.zzad;
        zzac(zzlkVar4.zza, zzlkVar4.zzk, j);
        return zzfk.zzs(j);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzj() {
        zzao();
        return zzZ(this.zzad);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzk() {
        zzao();
        return zzfk.zzs(zzaa(this.zzad));
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzl() {
        zzao();
        if (zzx()) {
            zzlk zzlkVar = this.zzad;
            zztw zztwVar = zzlkVar.zzb;
            zzlkVar.zza.zzn(zztwVar.zza, this.zzn);
            return zzfk.zzs(this.zzn.zzh(zztwVar.zzb, zztwVar.zzc));
        }
        zzcv zzcvVarZzn = zzn();
        if (zzcvVarZzn.zzo()) {
            return -9223372036854775807L;
        }
        return zzfk.zzs(zzcvVarZzn.zze(zzd(), this.zza, 0L).zzo);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzm() {
        zzao();
        return zzfk.zzs(this.zzad.zzq);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcv zzn() {
        zzao();
        return this.zzad.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzdg zzo() {
        zzao();
        return this.zzad.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzp() {
        zzao();
        zzib zzibVar = this.zzy;
        boolean zZzv = zzv();
        int iZzb = zzibVar.zzb(zZzv, 2);
        zzal(zZzv, iZzb, zzY(zZzv, iZzb));
        zzlk zzlkVar = this.zzad;
        if (zzlkVar.zze != 1) {
            return;
        }
        zzlk zzlkVarZzf = zzlkVar.zzf(null);
        zzlk zzlkVarZzg = zzlkVarZzf.zzg(true == zzlkVarZzf.zza.zzo() ? 4 : 2);
        this.zzC++;
        this.zzk.zzk();
        zzam(zzlkVarZzg, 1, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzq() {
        AudioTrack audioTrack;
        zzer.zze("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.2.0-alpha01] [" + zzfk.zze + "] [" + zzbq.zza() + "]");
        zzao();
        if (zzfk.zza < 21 && (audioTrack = this.zzM) != null) {
            audioTrack.release();
            this.zzM = null;
        }
        this.zzy.zzd();
        if (!this.zzk.zzp()) {
            zzeo zzeoVar = this.zzl;
            zzeoVar.zzd(10, new zzel() { // from class: com.google.android.gms.internal.ads.zzjp
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj) {
                    ((zzcl) obj).zzj(zzil.zzd(new zzkm(1), PointerIconCompat.TYPE_HELP));
                }
            });
            zzeoVar.zzc();
        }
        this.zzl.zze();
        this.zzj.zze(null);
        this.zzt.zzf(this.zzr);
        zzlk zzlkVar = this.zzad;
        if (zzlkVar.zzo) {
            this.zzad = zzlkVar.zzb();
        }
        zzlk zzlkVarZzg = this.zzad.zzg(1);
        this.zzad = zzlkVarZzg;
        zzlk zzlkVarZzc = zzlkVarZzg.zzc(zzlkVarZzg.zzb);
        this.zzad = zzlkVarZzc;
        zzlkVarZzc.zzp = zzlkVarZzc.zzr;
        this.zzad.zzq = 0L;
        this.zzr.zzN();
        this.zzi.zzi();
        Surface surface = this.zzO;
        if (surface != null) {
            surface.release();
            this.zzO = null;
        }
        this.zzX = zzdw.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzr(boolean z) {
        zzao();
        int iZzb = this.zzy.zzb(z, zzf());
        zzal(z, iZzb, zzY(z, iZzb));
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzs(Surface surface) {
        zzao();
        zzaj(surface);
        int i = surface == null ? 0 : -1;
        zzag(i, i);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzt(float f) {
        zzao();
        final float fMax = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzV == fMax) {
            return;
        }
        this.zzV = fMax;
        zzai();
        zzeo zzeoVar = this.zzl;
        zzeoVar.zzd(22, new zzel() { // from class: com.google.android.gms.internal.ads.zzjf
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                int i = zzkb.zzd;
                ((zzcl) obj).zzs(fMax);
            }
        });
        zzeoVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzu() {
        zzao();
        this.zzy.zzb(zzv(), 1);
        zzak(null);
        this.zzX = new zzdw(zzfvs.zzl(), this.zzad.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzv() {
        zzao();
        return this.zzad.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzw() {
        zzao();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzx() {
        zzao();
        return this.zzad.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zziw
    public final int zzy() {
        zzao();
        int length = this.zzh.length;
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zziw
    public final void zzz(zzme zzmeVar) {
        this.zzr.zzt(zzmeVar);
    }
}
