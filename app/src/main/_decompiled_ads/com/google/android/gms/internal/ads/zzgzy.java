package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgzy extends zzgtz implements zzgvk {
    private static final zzgzy zzb;
    private zzgyj zzB;
    private zzgyb zzD;
    private zzgzc zzF;
    private int zzG;
    private int zzd;
    private int zze;
    private int zzf;
    private zzgyf zzj;
    private zzgzl zzn;
    private boolean zzo;
    private boolean zzr;
    private boolean zzs;
    private zzgzt zzu;
    private boolean zzv;
    private zzgzx zzz;
    private byte zzJ = 2;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzgui zzk = zzaN();
    private zzgui zzl = zzaN();
    private String zzm = "";
    private zzgui zzp = zzgtz.zzaN();
    private String zzq = "";
    private zzgsr zzt = zzgsr.zzb;
    private String zzw = "";
    private zzgui zzx = zzgtz.zzaN();
    private zzgui zzy = zzgtz.zzaN();
    private zzgui zzA = zzaN();
    private String zzC = "";
    private zzgui zzE = zzaN();
    private zzgui zzH = zzaN();
    private zzgui zzI = zzaN();

    static {
        zzgzy zzgzyVar = new zzgzy();
        zzb = zzgzyVar;
        zzgtz.zzaU(zzgzy.class, zzgzyVar);
    }

    private zzgzy() {
    }

    public static zzgyd zza() {
        return (zzgyd) zzb.zzaA();
    }

    static /* synthetic */ void zzg(zzgzy zzgzyVar, String str) {
        str.getClass();
        zzgzyVar.zzd |= 4;
        zzgzyVar.zzg = str;
    }

    static /* synthetic */ void zzh(zzgzy zzgzyVar, String str) {
        str.getClass();
        zzgzyVar.zzd |= 8;
        zzgzyVar.zzh = str;
    }

    static /* synthetic */ void zzi(zzgzy zzgzyVar, zzgyf zzgyfVar) {
        zzgyfVar.getClass();
        zzgzyVar.zzj = zzgyfVar;
        zzgzyVar.zzd |= 32;
    }

    static /* synthetic */ void zzj(zzgzy zzgzyVar, zzgzr zzgzrVar) {
        zzgzrVar.getClass();
        zzgui zzguiVar = zzgzyVar.zzk;
        if (!zzguiVar.zzc()) {
            zzgzyVar.zzk = zzgtz.zzaO(zzguiVar);
        }
        zzgzyVar.zzk.add(zzgzrVar);
    }

    static /* synthetic */ void zzk(zzgzy zzgzyVar, String str) {
        zzgzyVar.zzd |= 64;
        zzgzyVar.zzm = str;
    }

    static /* synthetic */ void zzl(zzgzy zzgzyVar) {
        zzgzyVar.zzd &= -65;
        zzgzyVar.zzm = zzb.zzm;
    }

    static /* synthetic */ void zzm(zzgzy zzgzyVar, zzgzl zzgzlVar) {
        zzgzlVar.getClass();
        zzgzyVar.zzn = zzgzlVar;
        zzgzyVar.zzd |= 128;
    }

    static /* synthetic */ void zzn(zzgzy zzgzyVar, zzgzt zzgztVar) {
        zzgztVar.getClass();
        zzgzyVar.zzu = zzgztVar;
        zzgzyVar.zzd |= 8192;
    }

    static /* synthetic */ void zzo(zzgzy zzgzyVar, Iterable iterable) {
        zzgui zzguiVar = zzgzyVar.zzx;
        if (!zzguiVar.zzc()) {
            zzgzyVar.zzx = zzgtz.zzaO(zzguiVar);
        }
        zzgsa.zzav(iterable, zzgzyVar.zzx);
    }

    static /* synthetic */ void zzp(zzgzy zzgzyVar, Iterable iterable) {
        zzgui zzguiVar = zzgzyVar.zzy;
        if (!zzguiVar.zzc()) {
            zzgzyVar.zzy = zzgtz.zzaO(zzguiVar);
        }
        zzgsa.zzav(iterable, zzgzyVar.zzy);
    }

    static /* synthetic */ void zzq(zzgzy zzgzyVar, int i) {
        zzgzyVar.zze = i - 1;
        zzgzyVar.zzd |= 1;
    }

    public final String zzd() {
        return this.zzm;
    }

    public final String zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzJ);
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u001f\u0000\u0001\u0001\u001f\u001f\u0000\t\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015\u001e\u001b\u001f\u001b", new Object[]{"zzd", "zzg", "zzh", "zzi", "zzk", zzgzr.class, "zzo", "zzp", "zzq", "zzr", "zzs", "zze", zzgzm.zza, "zzf", zzgyc.zza, "zzj", "zzm", "zzn", "zzt", "zzl", zzhac.class, "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", zzhai.class, "zzB", "zzC", "zzD", "zzE", zzgyn.class, "zzF", "zzG", zzgzv.zza, "zzH", zzgzf.class, "zzI", zzgzi.class});
        }
        if (i2 == 3) {
            return new zzgzy();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgyd(zzgxtVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzJ = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
