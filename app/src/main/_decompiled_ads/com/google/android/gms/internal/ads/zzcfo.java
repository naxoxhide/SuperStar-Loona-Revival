package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcfo extends zzcct implements zzhk, zzme {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcez zzc;
    private final zzxi zzd;
    private final zzcdb zze;
    private final WeakReference zzf;
    private final zzvd zzg;
    private zziw zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzccs zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcfb zzt;
    private final Object zzq = new Object();
    private final Set zzu = new HashSet();

    /* JADX WARN: Code duplicated, block: B:21:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:23:0x00e9  */
    public zzcfo(Context context, zzcdb zzcdbVar, zzcdc zzcdcVar, Integer num) {
        final boolean z;
        final zzgh zzghVar;
        this.zzb = context;
        this.zze = zzcdbVar;
        this.zzr = num;
        this.zzf = new WeakReference(zzcdcVar);
        zzcez zzcezVar = new zzcez();
        this.zzc = zzcezVar;
        zzxi zzxiVar = new zzxi(context);
        this.zzd = zzxiVar;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter initialize ".concat(toString()));
        }
        zzD().incrementAndGet();
        zzlw zzlwVar = new zzlw(context, new zzcfl(this));
        zzlwVar.zzb(zzxiVar);
        zzlwVar.zza(zzcezVar);
        zzlx zzlxVarZzc = zzlwVar.zzc();
        this.zzh = zzlxVarZzc;
        zzlxVarZzc.zzz(this);
        this.zzl = 0;
        this.zzn = 0L;
        this.zzm = 0;
        this.zzs = new ArrayList();
        this.zzt = null;
        this.zzo = (String) zzfss.zzd(zzcdcVar != null ? zzcdcVar.zzbl() : null).zzb("");
        this.zzp = zzcdcVar != null ? zzcdcVar.zzf() : 0;
        final String strZzc = com.google.android.gms.ads.internal.zzt.zzp().zzc(context, zzcdcVar.zzn().zza);
        if (!this.zzj || this.zzi.limit() <= 0) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbW)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbO)).booleanValue()) {
                    z = zzcdbVar.zzj ? false : true;
                }
            } else if (zzcdbVar.zzj) {
            }
            final zzgh zzghVar2 = zzcdbVar.zzm ? new zzgh() { // from class: com.google.android.gms.internal.ads.zzcff
                @Override // com.google.android.gms.internal.ads.zzgh
                public final zzgi zza() {
                    return this.zza.zzW(strZzc, z);
                }
            } : zzcdbVar.zzi > 0 ? new zzgh() { // from class: com.google.android.gms.internal.ads.zzcfg
                @Override // com.google.android.gms.internal.ads.zzgh
                public final zzgi zza() {
                    return this.zza.zzX(strZzc, z);
                }
            } : new zzgh() { // from class: com.google.android.gms.internal.ads.zzcfh
                @Override // com.google.android.gms.internal.ads.zzgh
                public final zzgi zza() {
                    return this.zza.zzY(strZzc, z);
                }
            };
            zzghVar = zzcdbVar.zzj ? new zzgh() { // from class: com.google.android.gms.internal.ads.zzcfi
                @Override // com.google.android.gms.internal.ads.zzgh
                public final zzgi zza() {
                    return this.zza.zzZ(zzghVar2);
                }
            } : zzghVar2;
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && byteBuffer.limit() > 0) {
                final byte[] bArr = new byte[this.zzi.limit()];
                this.zzi.get(bArr);
                zzghVar = new zzgh() { // from class: com.google.android.gms.internal.ads.zzcfj
                    @Override // com.google.android.gms.internal.ads.zzgh
                    public final zzgi zza() {
                        int i = zzcfo.zza;
                        zzgi zzgiVarZza = zzghVar.zza();
                        byte[] bArr2 = bArr;
                        return new zzcfc(new zzgd(bArr2), bArr2.length, zzgiVarZza);
                    }
                };
            }
        } else {
            final byte[] bArr2 = new byte[this.zzi.limit()];
            this.zzi.get(bArr2);
            zzghVar = new zzgh() { // from class: com.google.android.gms.internal.ads.zzcfd
                @Override // com.google.android.gms.internal.ads.zzgh
                public final zzgi zza() {
                    return new zzgd(bArr2);
                }
            };
        }
        this.zzg = new zzvd(zzghVar, new zzvc(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzo)).booleanValue() ? new zzabt() { // from class: com.google.android.gms.internal.ads.zzcfn
            @Override // com.google.android.gms.internal.ads.zzabt
            public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
                int i = zzabs.zza;
                int i2 = zzcfo.zza;
                return new zzabm[]{new zzahr(0), new zzagj(0), new zzahm(0, null)};
            }
        } : new zzabt() { // from class: com.google.android.gms.internal.ads.zzcfe
            @Override // com.google.android.gms.internal.ads.zzabt
            public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
                int i = zzabs.zza;
                int i2 = zzcfo.zza;
                return new zzabm[]{new zzahr(0), new zzagj(0)};
            }
        }));
    }

    private final boolean zzad() {
        return this.zzt != null && this.zzt.zzq();
    }

    public final void finalize() {
        zzD().decrementAndGet();
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final long zzA() {
        if (zzad()) {
            return 0L;
        }
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (!this.zzs.isEmpty()) {
                long j = this.zzn;
                Map mapZze = ((zzhf) this.zzs.remove(0)).zze();
                long j2 = 0;
                if (mapZze != null) {
                    for (Map.Entry entry : mapZze.entrySet()) {
                        if (entry != null) {
                            try {
                                if (entry.getKey() != null && zzfsc.zzc("content-length", (CharSequence) entry.getKey()) && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                    j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzn = j + j2;
            }
        }
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final Integer zzC() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzH() {
        zziw zziwVar = this.zzh;
        if (zziwVar != null) {
            zziwVar.zzA(this);
            this.zzh.zzq();
            this.zzh = null;
            zzE().decrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzI(long j) {
        zzm zzmVar = (zzm) this.zzh;
        zzmVar.zza(zzmVar.zzd(), j, 5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzJ(int i) {
        this.zzc.zzk(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzK(int i) {
        this.zzc.zzl(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzL(zzccs zzccsVar) {
        this.zzk = zzccsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzM(int i) {
        this.zzc.zzm(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzN(int i) {
        this.zzc.zzn(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzO(boolean z) {
        this.zzh.zzr(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzP(Integer num) {
        this.zzr = num;
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzQ(boolean z) {
        if (this.zzh == null) {
            return;
        }
        int i = 0;
        while (true) {
            this.zzh.zzy();
            if (i >= 2) {
                return;
            }
            zzxi zzxiVar = this.zzd;
            zzwu zzwuVarZzc = zzxiVar.zzd().zzc();
            zzwuVarZzc.zzo(i, !z);
            zzxiVar.zzk(zzwuVarZzc);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzR(int i) {
        Iterator it = this.zzu.iterator();
        while (it.hasNext()) {
            zzcey zzceyVar = (zzcey) ((WeakReference) it.next()).get();
            if (zzceyVar != null) {
                zzceyVar.zzm(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzS(Surface surface, boolean z) {
        zziw zziwVar = this.zzh;
        if (zziwVar != null) {
            zziwVar.zzs(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzT(float f, boolean z) {
        zziw zziwVar = this.zzh;
        if (zziwVar != null) {
            zziwVar.zzt(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzU() {
        this.zzh.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final boolean zzV() {
        return this.zzh != null;
    }

    final /* synthetic */ zzgi zzW(String str, boolean z) {
        zzcfo zzcfoVar = true != z ? null : this;
        zzcdb zzcdbVar = this.zze;
        return new zzcfr(str, zzcfoVar, zzcdbVar.zzd, zzcdbVar.zzf, zzcdbVar.zzn, zzcdbVar.zzo);
    }

    final /* synthetic */ zzgi zzX(String str, boolean z) {
        zzcfo zzcfoVar = true != z ? null : this;
        zzcdb zzcdbVar = this.zze;
        zzcey zzceyVar = new zzcey(str, zzcfoVar, zzcdbVar.zzd, zzcdbVar.zzf, zzcdbVar.zzi);
        this.zzu.add(new WeakReference(zzceyVar));
        return zzceyVar;
    }

    final /* synthetic */ zzgi zzY(String str, boolean z) {
        zzgq zzgqVar = new zzgq();
        zzgqVar.zzf(str);
        zzgqVar.zze(true != z ? null : this);
        zzgqVar.zzc(this.zze.zzd);
        zzgqVar.zzd(this.zze.zzf);
        zzgqVar.zzb(true);
        return zzgqVar.zza();
    }

    final /* synthetic */ zzgi zzZ(zzgh zzghVar) {
        zzgi zzgiVarZza = zzghVar.zza();
        zzcfm zzcfmVar = new zzcfm(this);
        return new zzcfb(this.zzb, zzgiVarZza, this.zzo, this.zzp, this, zzcfmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhk
    public final void zza(zzgi zzgiVar, zzgn zzgnVar, boolean z, int i) {
        this.zzl += i;
    }

    final zzty zzaa(Uri uri) {
        zzar zzarVar = new zzar();
        zzarVar.zzb(uri);
        zzbp zzbpVarZzc = zzarVar.zzc();
        zzvd zzvdVar = this.zzg;
        zzvdVar.zza(this.zze.zzg);
        return zzvdVar.zzb(zzbpVarZzc);
    }

    final /* synthetic */ void zzab(boolean z, long j) {
        zzccs zzccsVar = this.zzk;
        if (zzccsVar != null) {
            zzccsVar.zzi(z, j);
        }
    }

    final /* synthetic */ zzlr[] zzac(Handler handler, zzaad zzaadVar, zzpc zzpcVar, zzwa zzwaVar, zzsw zzswVar) {
        zzsg zzsgVar = zzsg.zzb;
        zzon zzonVar = zzon.zza;
        zzdq[] zzdqVarArr = new zzdq[0];
        zzpw zzpwVar = new zzpw();
        zzon zzonVar2 = zzon.zza;
        if (zzonVar == null) {
            Objects.requireNonNull(zzonVar2, "Both parameters are null");
            zzonVar = zzonVar2;
        }
        Context context = this.zzb;
        zzpwVar.zzc(zzonVar);
        zzpwVar.zzd(zzdqVarArr);
        return new zzlr[]{new zzqo(context, zzrv.zza, zzsgVar, false, handler, zzpcVar, zzpwVar.zze()), new zzzf(this.zzb, zzrv.zza, zzsg.zzb, 0L, false, handler, zzaadVar, -1, 30.0f)};
    }

    @Override // com.google.android.gms.internal.ads.zzhk
    public final void zzb(zzgi zzgiVar, zzgn zzgnVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhk
    public final void zzc(zzgi zzgiVar, zzgn zzgnVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhk
    public final void zzd(zzgi zzgiVar, zzgn zzgnVar, boolean z) {
        if (zzgiVar instanceof zzhf) {
            synchronized (this.zzq) {
                this.zzs.add((zzhf) zzgiVar);
            }
        } else if (zzgiVar instanceof zzcfb) {
            this.zzt = (zzcfb) zzgiVar;
            final zzcdc zzcdcVar = (zzcdc) this.zzf.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbO)).booleanValue() && zzcdcVar != null && this.zzt.zzn()) {
                final HashMap map = new HashMap();
                map.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                map.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = zzcfo.zza;
                        zzcdcVar.zzd("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zze(zzmc zzmcVar, zzam zzamVar, zzie zzieVar) {
        zzcdc zzcdcVar = (zzcdc) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbO)).booleanValue() || zzcdcVar == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = zzamVar.zzl;
        if (str != null) {
            map.put("audioMime", str);
        }
        String str2 = zzamVar.zzm;
        if (str2 != null) {
            map.put("audioSampleMime", str2);
        }
        String str3 = zzamVar.zzj;
        if (str3 != null) {
            map.put("audioCodec", str3);
        }
        zzcdcVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final /* synthetic */ void zzf(zzmc zzmcVar, int i, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final /* synthetic */ void zzg(zzmc zzmcVar, zzts zztsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzh(zzmc zzmcVar, int i, long j) {
        this.zzm += i;
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final /* synthetic */ void zzi(zzco zzcoVar, zzmd zzmdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzj(zzmc zzmcVar, zztn zztnVar, zzts zztsVar, IOException iOException, boolean z) {
        zzccs zzccsVar = this.zzk;
        if (zzccsVar != null) {
            if (this.zze.zzk) {
                zzccsVar.zzl("onLoadException", iOException);
            } else {
                zzccsVar.zzk("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzk(zzmc zzmcVar, int i) {
        zzccs zzccsVar = this.zzk;
        if (zzccsVar != null) {
            zzccsVar.zzm(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzl(zzmc zzmcVar, zzce zzceVar) {
        zzccs zzccsVar = this.zzk;
        if (zzccsVar != null) {
            zzccsVar.zzk("onPlayerError", zzceVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final /* synthetic */ void zzm(zzmc zzmcVar, zzcn zzcnVar, zzcn zzcnVar2, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzn(zzmc zzmcVar, Object obj, long j) {
        zzccs zzccsVar = this.zzk;
        if (zzccsVar != null) {
            zzccsVar.zzv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final /* synthetic */ void zzo(zzmc zzmcVar, zzid zzidVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzp(zzmc zzmcVar, zzam zzamVar, zzie zzieVar) {
        zzcdc zzcdcVar = (zzcdc) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbO)).booleanValue() || zzcdcVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("frameRate", String.valueOf(zzamVar.zzt));
        map.put("bitRate", String.valueOf(zzamVar.zzi));
        map.put("resolution", zzamVar.zzr + "x" + zzamVar.zzs);
        String str = zzamVar.zzl;
        if (str != null) {
            map.put("videoMime", str);
        }
        String str2 = zzamVar.zzm;
        if (str2 != null) {
            map.put("videoSampleMime", str2);
        }
        String str3 = zzamVar.zzj;
        if (str3 != null) {
            map.put("videoCodec", str3);
        }
        zzcdcVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzq(zzmc zzmcVar, zzdm zzdmVar) {
        zzccs zzccsVar = this.zzk;
        if (zzccsVar != null) {
            zzccsVar.zzD(zzdmVar.zzc, zzdmVar.zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final int zzr() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final int zzt() {
        return this.zzh.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final long zzv() {
        return this.zzh.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final long zzw() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min(this.zzl, this.zzt.zzk());
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final long zzy() {
        return this.zzh.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final long zzz() {
        return this.zzh.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzty zzuoVar;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z;
            int length = uriArr.length;
            if (length == 1) {
                zzuoVar = zzaa(uriArr[0]);
            } else {
                zzty[] zztyVarArr = new zzty[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zztyVarArr[i] = zzaa(uriArr[i]);
                }
                zzuoVar = new zzuo(false, false, zztyVarArr);
            }
            this.zzh.zzB(zzuoVar);
            this.zzh.zzp();
            zzE().incrementAndGet();
        }
    }
}
