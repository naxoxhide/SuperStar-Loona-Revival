package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajv implements zzakr {
    private final zzaje zza;
    private final zzfa zzb = new zzfa(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzfi zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzajv(zzaje zzajeVar) {
        this.zza = zzajeVar;
    }

    private final void zzd(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zze(zzfb zzfbVar, byte[] bArr, int i) {
        int iMin = Math.min(zzfbVar.zza(), i - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzfbVar.zzH(iMin);
        } else {
            zzfbVar.zzC(bArr, this.zzd, iMin);
        }
        int i2 = this.zzd + iMin;
        this.zzd = i2;
        return i2 == i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r8v10, types: [int] */
    /* JADX WARN: Type inference failed for: r8v16, types: [com.google.android.gms.internal.ads.zzfa] */
    /* JADX WARN: Type inference failed for: r8v9, types: [com.google.android.gms.internal.ads.zzaje] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v9, types: [int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(zzfb zzfbVar, int i) throws zzcc {
        int i2;
        ?? r5;
        int i3;
        int i4;
        int i5;
        ?? r9;
        long jZzb;
        zzdx.zzb(this.zze);
        int i6 = -1;
        int i7 = 2;
        ?? r6 = 0;
        int i8 = 1;
        if ((i & 1) != 0) {
            int i9 = this.zzc;
            if (i9 != 0 && i9 != 1) {
                if (i9 != 2) {
                    int i10 = this.zzj;
                    if (i10 != -1) {
                        zzer.zzf("PesReader", "Unexpected start indicator: expected " + i10 + " more bytes");
                    }
                    this.zza.zzc(zzfbVar.zzd() == 0);
                } else {
                    zzer.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zzd(1);
        }
        int i11 = i;
        while (zzfbVar.zza() > 0) {
            int i12 = this.zzc;
            if (i12 == 0) {
                i2 = i7;
                r5 = r6;
                i3 = i8;
                zzfbVar.zzH(zzfbVar.zza());
            } else if (i12 != i8) {
                if (i12 != i7) {
                    int iZza = zzfbVar.zza();
                    int i13 = this.zzj;
                    if (i13 == i6) {
                        r9 = r6;
                    } else {
                        i5 = iZza - i13;
                    }
                    if (r9 > 0) {
                        r9 = i5;
                        iZza -= r9;
                        zzfbVar.zzF(zzfbVar.zzc() + iZza);
                    }
                    r9 = i5;
                    this.zza.zza(zzfbVar);
                    int i14 = this.zzj;
                    if (i14 != i6) {
                        int i15 = i14 - iZza;
                        this.zzj = i15;
                        if (i15 == 0) {
                            this.zza.zzc(r6);
                            zzd(i8);
                        }
                    }
                } else {
                    if (zze(zzfbVar, this.zzb.zza, Math.min(10, this.zzi)) && zze(zzfbVar, null, this.zzi)) {
                        this.zzb.zzj(r6);
                        if (this.zzf) {
                            this.zzb.zzl(4);
                            long jZzd = this.zzb.zzd(3);
                            this.zzb.zzl(i8);
                            int iZzd = this.zzb.zzd(15) << 15;
                            this.zzb.zzl(i8);
                            long jZzd2 = this.zzb.zzd(15);
                            this.zzb.zzl(i8);
                            if (!this.zzh && this.zzg) {
                                this.zzb.zzl(4);
                                long jZzd3 = ((long) this.zzb.zzd(3)) << 30;
                                this.zzb.zzl(i8);
                                int iZzd2 = this.zzb.zzd(15) << 15;
                                this.zzb.zzl(i8);
                                long jZzd4 = this.zzb.zzd(15);
                                this.zzb.zzl(i8);
                                this.zze.zzb(jZzd3 | ((long) iZzd2) | jZzd4);
                                this.zzh = true;
                            }
                            jZzb = this.zze.zzb((jZzd << 30) | ((long) iZzd) | jZzd2);
                        } else {
                            jZzb = -9223372036854775807L;
                        }
                        i11 |= true != this.zzk ? 0 : 4;
                        this.zza.zzd(jZzb, i11);
                        zzd(3);
                        i6 = -1;
                        i7 = 2;
                        r6 = 0;
                        i8 = 1;
                    }
                }
                i2 = i7;
                r5 = r6;
                i3 = i8;
            } else if (zze(zzfbVar, this.zzb.zza, 9)) {
                r5 = 0;
                this.zzb.zzj(0);
                int iZzd3 = this.zzb.zzd(24);
                i3 = 1;
                if (iZzd3 != 1) {
                    zzer.zzf("PesReader", "Unexpected start code prefix: " + iZzd3);
                    i6 = -1;
                    this.zzj = -1;
                    i4 = 0;
                    i2 = 2;
                } else {
                    this.zzb.zzl(8);
                    zzfa zzfaVar = this.zzb;
                    int iZzd4 = zzfaVar.zzd(16);
                    zzfaVar.zzl(5);
                    this.zzk = this.zzb.zzn();
                    i2 = 2;
                    this.zzb.zzl(2);
                    this.zzf = this.zzb.zzn();
                    this.zzg = this.zzb.zzn();
                    this.zzb.zzl(6);
                    int iZzd5 = this.zzb.zzd(8);
                    this.zzi = iZzd5;
                    if (iZzd4 == 0) {
                        this.zzj = -1;
                        i6 = -1;
                    } else {
                        int i16 = (iZzd4 - 3) - iZzd5;
                        this.zzj = i16;
                        if (i16 < 0) {
                            zzer.zzf("PesReader", "Found negative packet payload size: " + i16);
                            i6 = -1;
                            this.zzj = -1;
                        } else {
                            i6 = -1;
                        }
                    }
                    i4 = 2;
                }
                zzd(i4);
            } else {
                i6 = -1;
                r5 = 0;
                i3 = 1;
                i2 = 2;
            }
            i8 = i3;
            r6 = r5;
            i7 = i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zzb(zzfi zzfiVar, zzabp zzabpVar, zzakq zzakqVar) {
        this.zze = zzfiVar;
        this.zza.zzb(zzabpVar, zzakqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }
}
