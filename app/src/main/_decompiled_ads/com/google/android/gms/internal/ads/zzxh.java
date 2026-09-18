package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzxh extends zzxe {
    private final boolean zze;
    private final zzww zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final boolean zzo;
    private final boolean zzp;
    private final int zzq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:111:0x0154  */
    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    /* JADX WARN: Code duplicated, block: B:29:0x004a  */
    /* JADX WARN: Code duplicated, block: B:31:0x004e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0052  */
    /* JADX WARN: Code duplicated, block: B:35:0x0058  */
    /* JADX WARN: Code duplicated, block: B:37:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0063  */
    /* JADX WARN: Code duplicated, block: B:42:0x0069  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d3  */
    public zzxh(int i, zzcx zzcxVar, int i2, zzww zzwwVar, int i3, int i4, boolean z) {
        boolean z2;
        boolean z3;
        byte b2;
        boolean z4;
        int i5;
        float f;
        int i6;
        super(i, zzcxVar, 0);
        int i7 = 0;
        this.zzf = zzwwVar;
        int i8 = true != zzwwVar.zzJ ? 16 : 24;
        boolean z5 = zzwwVar.zzI;
        if (z) {
            zzam zzamVar = this.zzd;
            if (zzamVar.zzr != -1) {
                int i9 = zzwwVar.zzd;
            }
            if (zzamVar.zzs != -1) {
                int i10 = zzwwVar.zze;
            }
            float f2 = zzamVar.zzt;
            if (f2 != -1.0f) {
                int i11 = zzwwVar.zzf;
                if (f2 > 2.1474836E9f) {
                    z2 = false;
                }
            }
            if (zzamVar.zzi != -1) {
                int i12 = zzwwVar.zzg;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        this.zze = z2;
        if (z) {
            zzam zzamVar2 = this.zzd;
            int i13 = zzamVar2.zzr;
            if (i13 != -1) {
                int i14 = zzwwVar.zzh;
                if (i13 >= 0) {
                    i5 = zzamVar2.zzs;
                    if (i5 != -1) {
                        int i15 = zzwwVar.zzi;
                        if (i5 >= 0) {
                            f = zzamVar2.zzt;
                            if (f != -1.0f) {
                                int i16 = zzwwVar.zzj;
                                if (f >= 0.0f) {
                                    i6 = zzamVar2.zzi;
                                    if (i6 != -1) {
                                        int i17 = zzwwVar.zzk;
                                        if (i6 >= 0) {
                                            z3 = false;
                                        }
                                    }
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            } else {
                                i6 = zzamVar2.zzi;
                                if (i6 != -1) {
                                    int i18 = zzwwVar.zzk;
                                    if (i6 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            }
                        } else {
                            z3 = false;
                        }
                    } else {
                        f = zzamVar2.zzt;
                        if (f != -1.0f) {
                            int i19 = zzwwVar.zzj;
                            if (f >= 0.0f) {
                                i6 = zzamVar2.zzi;
                                if (i6 != -1) {
                                    int i110 = zzwwVar.zzk;
                                    if (i6 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            i6 = zzamVar2.zzi;
                            if (i6 != -1) {
                                int i111 = zzwwVar.zzk;
                                if (i6 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        }
                    }
                } else {
                    z3 = false;
                }
            } else {
                i5 = zzamVar2.zzs;
                if (i5 != -1) {
                    int i112 = zzwwVar.zzi;
                    if (i5 >= 0) {
                        f = zzamVar2.zzt;
                        if (f != -1.0f) {
                            int i113 = zzwwVar.zzj;
                            if (f >= 0.0f) {
                                i6 = zzamVar2.zzi;
                                if (i6 != -1) {
                                    int i114 = zzwwVar.zzk;
                                    if (i6 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            i6 = zzamVar2.zzi;
                            if (i6 != -1) {
                                int i115 = zzwwVar.zzk;
                                if (i6 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                    }
                } else {
                    f = zzamVar2.zzt;
                    if (f != -1.0f) {
                        int i116 = zzwwVar.zzj;
                        if (f >= 0.0f) {
                            i6 = zzamVar2.zzi;
                            if (i6 != -1) {
                                int i117 = zzwwVar.zzk;
                                if (i6 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        i6 = zzamVar2.zzi;
                        if (i6 != -1) {
                            int i118 = zzwwVar.zzk;
                            if (i6 >= 0) {
                                z3 = false;
                            }
                        }
                        z3 = true;
                    }
                }
            }
        } else {
            z3 = false;
        }
        this.zzg = z3;
        this.zzh = zzxi.zzn(i3, false);
        zzam zzamVar3 = this.zzd;
        this.zzi = zzamVar3.zzi;
        this.zzj = zzamVar3.zza();
        int i20 = this.zzd.zzf;
        int i21 = zzwwVar.zzp;
        this.zzl = Integer.bitCount(0);
        int i22 = this.zzd.zzf;
        this.zzm = true;
        int i23 = 0;
        while (true) {
            if (i23 >= zzwwVar.zzo.size()) {
                i23 = Integer.MAX_VALUE;
                break;
            }
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzwwVar.zzo.get(i23))) {
                break;
            } else {
                i23++;
            }
        }
        this.zzk = i23;
        this.zzo = (i3 & 384) == 128;
        this.zzp = (i3 & 64) == 64;
        zzam zzamVar4 = this.zzd;
        String str2 = zzamVar4.zzm;
        int i24 = 4;
        if (str2 == null) {
            i24 = 0;
        } else {
            switch (str2) {
                case "video/dolby-vision":
                    b2 = 0;
                    break;
                case "video/av01":
                    b2 = 1;
                    break;
                case "video/hevc":
                    b2 = 2;
                    break;
                case "video/avc":
                    b2 = 4;
                    break;
                case "video/x-vnd.on2.vp9":
                    b2 = 3;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                i24 = 5;
            } else if (b2 != 1) {
                if (b2 == 2) {
                    i24 = 3;
                } else if (b2 == 3) {
                    i24 = 2;
                } else if (b2 != 4) {
                    i24 = 0;
                } else {
                    i24 = 1;
                }
            }
        }
        this.zzq = i24;
        int i25 = zzamVar4.zzf;
        zzww zzwwVar2 = this.zzf;
        if (zzxi.zzn(i3, zzwwVar2.zzR) && ((z4 = this.zze) || zzwwVar2.zzH)) {
            if (zzxi.zzn(i3, false) && this.zzg && z4 && zzamVar4.zzi != -1) {
                boolean z6 = zzwwVar2.zzB;
                boolean z7 = zzwwVar2.zzA;
                if ((i8 & i3) != 0) {
                    i7 = 2;
                } else {
                    i7 = 1;
                }
            } else {
                i7 = 1;
            }
        }
        this.zzn = i7;
    }

    public static /* synthetic */ int zza(zzxh zzxhVar, zzxh zzxhVar2) {
        zzfxb zzfxbVarZza = (zzxhVar.zze && zzxhVar.zzh) ? zzxi.zzc : zzxi.zzc.zza();
        zzfvh zzfvhVarZzj = zzfvh.zzj();
        Integer numValueOf = Integer.valueOf(zzxhVar.zzi);
        Integer numValueOf2 = Integer.valueOf(zzxhVar2.zzi);
        boolean z = zzxhVar.zzf.zzA;
        return zzfvhVarZzj.zzc(numValueOf, numValueOf2, zzxi.zzd).zzc(Integer.valueOf(zzxhVar.zzj), Integer.valueOf(zzxhVar2.zzj), zzfxbVarZza).zzc(Integer.valueOf(zzxhVar.zzi), Integer.valueOf(zzxhVar2.zzi), zzfxbVarZza).zza();
    }

    public static /* synthetic */ int zzd(zzxh zzxhVar, zzxh zzxhVar2) {
        zzfvh zzfvhVarZzb = zzfvh.zzj().zzd(zzxhVar.zzh, zzxhVar2.zzh).zzb(zzxhVar.zzl, zzxhVar2.zzl);
        boolean z = zzxhVar.zzm;
        boolean z2 = zzxhVar2.zzm;
        zzfvh zzfvhVarZzc = zzfvhVarZzb.zzd(true, true).zzd(zzxhVar.zze, zzxhVar2.zze).zzd(zzxhVar.zzg, zzxhVar2.zzg).zzc(Integer.valueOf(zzxhVar.zzk), Integer.valueOf(zzxhVar2.zzk), zzfxb.zzc().zza());
        boolean z3 = zzxhVar.zzo;
        zzfvh zzfvhVarZzd = zzfvhVarZzc.zzd(z3, zzxhVar2.zzo);
        boolean z4 = zzxhVar.zzp;
        zzfvh zzfvhVarZzd2 = zzfvhVarZzd.zzd(z4, zzxhVar2.zzp);
        if (z3 && z4) {
            zzfvhVarZzd2 = zzfvhVarZzd2.zzb(zzxhVar.zzq, zzxhVar2.zzq);
        }
        return zzfvhVarZzd2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final int zzb() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final /* bridge */ /* synthetic */ boolean zzc(zzxe zzxeVar) {
        zzxh zzxhVar = (zzxh) zzxeVar;
        if (!zzfk.zzE(this.zzd.zzm, zzxhVar.zzd.zzm)) {
            return false;
        }
        boolean z = this.zzf.zzK;
        return this.zzo == zzxhVar.zzo && this.zzp == zzxhVar.zzp;
    }
}
