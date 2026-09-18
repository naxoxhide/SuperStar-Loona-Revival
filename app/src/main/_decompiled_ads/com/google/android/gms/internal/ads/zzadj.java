package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzadj implements zzadb {
    public final zzfvs zza;
    private final int zzb;

    private zzadj(int i, zzfvs zzfvsVar) {
        this.zzb = i;
        this.zza = zzfvsVar;
    }

    public static zzadj zzc(int i, zzfb zzfbVar) {
        String str;
        String str2;
        zzfvp zzfvpVar = new zzfvp();
        int iZzd = zzfbVar.zzd();
        int i2 = -2;
        while (zzfbVar.zza() > 8) {
            int iZzh = zzfbVar.zzh();
            int iZzc = zzfbVar.zzc() + zzfbVar.zzh();
            zzfbVar.zzF(iZzc);
            zzadb zzadkVar = null;
            if (iZzh != 1414744396) {
                switch (iZzh) {
                    case 1718776947:
                        if (i2 == 2) {
                            zzfbVar.zzH(4);
                            int iZzh2 = zzfbVar.zzh();
                            int iZzh3 = zzfbVar.zzh();
                            zzfbVar.zzH(4);
                            int iZzh4 = zzfbVar.zzh();
                            switch (iZzh4) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str2 = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str2 = "video/avc";
                                    break;
                                case 842289229:
                                    str2 = "video/mp42";
                                    break;
                                case 859066445:
                                    str2 = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str2 = "video/mjpeg";
                                    break;
                                default:
                                    str2 = null;
                                    break;
                            }
                            if (str2 != null) {
                                zzak zzakVar = new zzak();
                                zzakVar.zzab(iZzh2);
                                zzakVar.zzH(iZzh3);
                                zzakVar.zzU(str2);
                                zzadkVar = new zzadk(zzakVar.zzac());
                            } else {
                                zzer.zzf("StreamFormatChunk", "Ignoring track with unsupported compression " + iZzh4);
                            }
                        } else if (i2 != 1) {
                            zzer.zzf("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzfk.zzA(i2)));
                        } else {
                            int iZzj = zzfbVar.zzj();
                            if (iZzj == 1) {
                                str = "audio/raw";
                            } else if (iZzj == 85) {
                                str = "audio/mpeg";
                            } else if (iZzj == 255) {
                                str = "audio/mp4a-latm";
                            } else if (iZzj != 8192) {
                                str = iZzj != 8193 ? null : "audio/vnd.dts";
                            } else {
                                str = "audio/ac3";
                            }
                            if (str != null) {
                                int iZzj2 = zzfbVar.zzj();
                                int iZzh5 = zzfbVar.zzh();
                                zzfbVar.zzH(6);
                                int iZzk = zzfk.zzk(zzfbVar.zzp());
                                int iZzj3 = zzfbVar.zzj();
                                byte[] bArr = new byte[iZzj3];
                                zzfbVar.zzC(bArr, 0, iZzj3);
                                zzak zzakVar2 = new zzak();
                                zzakVar2.zzU(str);
                                zzakVar2.zzy(iZzj2);
                                zzakVar2.zzV(iZzh5);
                                if ("audio/raw".equals(str) && iZzk != 0) {
                                    zzakVar2.zzP(iZzk);
                                }
                                if ("audio/mp4a-latm".equals(str) && iZzj3 > 0) {
                                    zzakVar2.zzK(zzfvs.zzm(bArr));
                                }
                                zzadkVar = new zzadk(zzakVar2.zzac());
                            } else {
                                zzer.zzf("StreamFormatChunk", "Ignoring track with unsupported format tag " + iZzj);
                            }
                        }
                        break;
                    case 1751742049:
                        zzadkVar = zzadg.zzb(zzfbVar);
                        break;
                    case 1752331379:
                        zzadkVar = zzadh.zzb(zzfbVar);
                        break;
                    case 1852994675:
                        zzadkVar = zzadl.zzb(zzfbVar);
                        break;
                }
            } else {
                zzadkVar = zzc(zzfbVar.zzh(), zzfbVar);
            }
            if (zzadkVar != null) {
                if (zzadkVar.zza() == 1752331379) {
                    int i3 = ((zzadh) zzadkVar).zza;
                    if (i3 == 1935960438) {
                        i2 = 2;
                    } else if (i3 == 1935963489) {
                        i2 = 1;
                    } else if (i3 != 1937012852) {
                        zzer.zzf("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i3))));
                        i2 = -1;
                    } else {
                        i2 = 3;
                    }
                }
                zzfvpVar.zzf(zzadkVar);
            }
            zzfbVar.zzG(iZzc);
            zzfbVar.zzF(iZzd);
        }
        return new zzadj(i, zzfvpVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzadb
    public final int zza() {
        return this.zzb;
    }

    public final zzadb zzb(Class cls) {
        zzfvs zzfvsVar = this.zza;
        int size = zzfvsVar.size();
        int i = 0;
        while (i < size) {
            zzadb zzadbVar = (zzadb) zzfvsVar.get(i);
            i++;
            if (zzadbVar.getClass() == cls) {
                return zzadbVar;
            }
        }
        return null;
    }
}
