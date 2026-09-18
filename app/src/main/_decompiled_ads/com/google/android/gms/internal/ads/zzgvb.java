package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgvb implements zzgwd {
    private static final zzgvh zza = new zzguz();
    private final zzgvh zzb;

    public zzgvb() {
        zzgvh zzgvhVar;
        zzgvh[] zzgvhVarArr = new zzgvh[2];
        zzgvhVarArr[0] = zzgtu.zza();
        try {
            zzgvhVar = (zzgvh) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzgvhVar = zza;
        }
        zzgvhVarArr[1] = zzgvhVar;
        zzgva zzgvaVar = new zzgva(zzgvhVarArr);
        byte[] bArr = zzguj.zzd;
        this.zzb = zzgvaVar;
    }

    private static boolean zzb(zzgvg zzgvgVar) {
        return zzgvgVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgwd
    public final zzgwc zza(Class cls) {
        zzgwe.zzr(cls);
        zzgvg zzgvgVarZzb = this.zzb.zzb(cls);
        if (zzgvgVarZzb.zzb()) {
            return zzgtz.class.isAssignableFrom(cls) ? zzgvn.zzc(zzgwe.zzn(), zzgto.zzb(), zzgvgVarZzb.zza()) : zzgvn.zzc(zzgwe.zzm(), zzgto.zza(), zzgvgVarZzb.zza());
        }
        if (zzgtz.class.isAssignableFrom(cls)) {
            return zzb(zzgvgVarZzb) ? zzgvm.zzl(cls, zzgvgVarZzb, zzgvp.zzb(), zzgux.zze(), zzgwe.zzn(), zzgto.zzb(), zzgvf.zzb()) : zzgvm.zzl(cls, zzgvgVarZzb, zzgvp.zzb(), zzgux.zze(), zzgwe.zzn(), null, zzgvf.zzb());
        }
        return zzb(zzgvgVarZzb) ? zzgvm.zzl(cls, zzgvgVarZzb, zzgvp.zza(), zzgux.zzd(), zzgwe.zzm(), zzgto.zza(), zzgvf.zza()) : zzgvm.zzl(cls, zzgvgVarZzb, zzgvp.zza(), zzgux.zzd(), zzgwe.zzm(), null, zzgvf.zza());
    }
}
