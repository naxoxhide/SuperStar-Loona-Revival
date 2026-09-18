package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajg implements zzaje {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzacs zzc;
    private final zzakt zzd;
    private final zzfb zze;
    private final zzajt zzf;
    private final boolean[] zzg;
    private final zzajf zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;

    public zzajg() {
        this(null);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:68:0x01aa  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzfb zzfbVar) {
        long j;
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long j2;
        double d;
        int i5;
        int i6;
        zzdx.zzb(this.zzc);
        int iZzc = zzfbVar.zzc();
        int iZzd = zzfbVar.zzd();
        byte[] bArrZzI = zzfbVar.zzI();
        this.zzi += (long) zzfbVar.zza();
        this.zzc.zzr(zzfbVar, zzfbVar.zza());
        while (true) {
            int iZza = zzfy.zza(bArrZzI, iZzc, iZzd, this.zzg);
            if (iZza == iZzd) {
                break;
            }
            int i7 = iZza + 3;
            int i8 = zzfbVar.zzI()[i7] & 255;
            int i9 = iZza - iZzc;
            if (!this.zzk) {
                if (i9 > 0) {
                    this.zzh.zza(bArrZzI, iZzc, iZza);
                }
                if (this.zzh.zzc(i8, i9 < 0 ? -i9 : 0)) {
                    zzajf zzajfVar = this.zzh;
                    String str = this.zzb;
                    Objects.requireNonNull(str);
                    byte[] bArrCopyOf = Arrays.copyOf(zzajfVar.zzc, zzajfVar.zza);
                    int i10 = bArrCopyOf[4] & 255;
                    int i11 = bArrCopyOf[5] & 255;
                    int i12 = bArrCopyOf[6] & 255;
                    int i13 = i11 & 15;
                    int i14 = (i11 >> 4) | (i10 << 4);
                    int i15 = (bArrCopyOf[7] & 240) >> 4;
                    int i16 = (i13 << 8) | i12;
                    if (i15 == 2) {
                        i2 = i16 * 4;
                        i3 = i14 * 3;
                    } else if (i15 != 3) {
                        if (i15 != 4) {
                            f = 1.0f;
                        } else {
                            i2 = i16 * 121;
                            i3 = i14 * 100;
                        }
                        zzak zzakVar = new zzak();
                        zzakVar.zzJ(str);
                        zzakVar.zzU("video/mpeg2");
                        zzakVar.zzab(i14);
                        zzakVar.zzH(i16);
                        zzakVar.zzR(f);
                        zzakVar.zzK(Collections.singletonList(bArrCopyOf));
                        zzam zzamVarZzac = zzakVar.zzac();
                        i4 = (bArrCopyOf[7] & 15) - 1;
                        j2 = 0;
                        if (i4 >= 0 && i4 < 8) {
                            d = zza[i4];
                            byte b2 = bArrCopyOf[zzajfVar.zzb + 9];
                            i5 = (b2 & 96) >> 5;
                            i6 = b2 & 31;
                            if (i5 != i6) {
                                d *= (((double) i5) + 1.0d) / ((double) (i6 + 1));
                            }
                            j2 = (long) (1000000.0d / d);
                        }
                        Pair pairCreate = Pair.create(zzamVarZzac, Long.valueOf(j2));
                        this.zzc.zzl((zzam) pairCreate.first);
                        this.zzl = ((Long) pairCreate.second).longValue();
                        this.zzk = true;
                    } else {
                        i2 = i16 * 16;
                        i3 = i14 * 9;
                    }
                    f = i2 / i3;
                    zzak zzakVar2 = new zzak();
                    zzakVar2.zzJ(str);
                    zzakVar2.zzU("video/mpeg2");
                    zzakVar2.zzab(i14);
                    zzakVar2.zzH(i16);
                    zzakVar2.zzR(f);
                    zzakVar2.zzK(Collections.singletonList(bArrCopyOf));
                    zzam zzamVarZzac2 = zzakVar2.zzac();
                    i4 = (bArrCopyOf[7] & 15) - 1;
                    j2 = 0;
                    if (i4 >= 0) {
                        d = zza[i4];
                        byte b3 = bArrCopyOf[zzajfVar.zzb + 9];
                        i5 = (b3 & 96) >> 5;
                        i6 = b3 & 31;
                        if (i5 != i6) {
                            d *= (((double) i5) + 1.0d) / ((double) (i6 + 1));
                        }
                        j2 = (long) (1000000.0d / d);
                    }
                    Pair pairCreate2 = Pair.create(zzamVarZzac2, Long.valueOf(j2));
                    this.zzc.zzl((zzam) pairCreate2.first);
                    this.zzl = ((Long) pairCreate2.second).longValue();
                    this.zzk = true;
                }
            }
            zzajt zzajtVar = this.zzf;
            if (zzajtVar != null) {
                if (i9 > 0) {
                    zzajtVar.zza(bArrZzI, iZzc, iZza);
                    i = 0;
                } else {
                    i = -i9;
                }
                if (this.zzf.zzd(i)) {
                    zzajt zzajtVar2 = this.zzf;
                    int iZzb = zzfy.zzb(zzajtVar2.zza, zzajtVar2.zzb);
                    zzfb zzfbVar2 = this.zze;
                    int i17 = zzfk.zza;
                    zzfbVar2.zzE(this.zzf.zza, iZzb);
                    this.zzd.zza(this.zzo, this.zze);
                }
                if (i8 == 178) {
                    if (zzfbVar.zzI()[iZza + 2] == 1) {
                        this.zzf.zzc(178);
                    }
                    i8 = 178;
                }
            }
            if (i8 == 0 || i8 == 179) {
                int i18 = iZzd - iZza;
                if (this.zzq && this.zzk) {
                    long j3 = this.zzo;
                    if (j3 != -9223372036854775807L) {
                        j = -9223372036854775807L;
                        this.zzc.zzt(j3, this.zzp ? 1 : 0, ((int) (this.zzi - this.zzn)) - i18, i18, null);
                    } else {
                        j = -9223372036854775807L;
                    }
                } else {
                    j = -9223372036854775807L;
                }
                if (!this.zzj || this.zzq) {
                    this.zzn = this.zzi - ((long) i18);
                    long j4 = this.zzm;
                    if (j4 == j) {
                        long j5 = this.zzo;
                        j4 = j5 != j ? j5 + this.zzl : j;
                    }
                    this.zzo = j4;
                    z = false;
                    this.zzp = false;
                    this.zzm = j;
                    z2 = true;
                    this.zzj = true;
                } else {
                    z = false;
                    z2 = true;
                }
                this.zzq = i8 == 0 ? z2 : z;
            } else {
                if (i8 == 184) {
                    this.zzp = true;
                }
                iZzd = iZzd;
                bArrZzI = bArrZzI;
            }
            iZzd = iZzd;
            bArrZzI = bArrZzI;
            iZzc = i7;
        }
        if (!this.zzk) {
            this.zzh.zza(bArrZzI, iZzc, iZzd);
        }
        zzajt zzajtVar3 = this.zzf;
        if (zzajtVar3 != null) {
            zzajtVar3.zza(bArrZzI, iZzc, iZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzb(zzabp zzabpVar, zzakq zzakqVar) {
        zzakqVar.zzc();
        this.zzb = zzakqVar.zzb();
        this.zzc = zzabpVar.zzw(zzakqVar.zza(), 2);
        zzakt zzaktVar = this.zzd;
        if (zzaktVar != null) {
            zzaktVar.zzb(zzabpVar, zzakqVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzc(boolean z) {
        zzdx.zzb(this.zzc);
        if (z) {
            boolean z2 = this.zzp;
            long j = this.zzi - this.zzn;
            this.zzc.zzt(this.zzo, z2 ? 1 : 0, (int) j, 0, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zze() {
        zzfy.zzf(this.zzg);
        this.zzh.zzb();
        zzajt zzajtVar = this.zzf;
        if (zzajtVar != null) {
            zzajtVar.zzb();
        }
        this.zzi = 0L;
        this.zzj = false;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }

    zzajg(zzakt zzaktVar) {
        zzfb zzfbVar;
        this.zzd = zzaktVar;
        this.zzg = new boolean[4];
        this.zzh = new zzajf(128);
        if (zzaktVar != null) {
            this.zzf = new zzajt(178, 128);
            zzfbVar = new zzfb();
        } else {
            zzfbVar = null;
            this.zzf = null;
        }
        this.zze = zzfbVar;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }
}
