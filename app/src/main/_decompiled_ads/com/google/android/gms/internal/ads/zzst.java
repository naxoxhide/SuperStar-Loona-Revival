package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzst {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();
    private static int zzd = -1;

    public static int zza() throws zzsn {
        int i;
        int iMax = zzd;
        if (iMax == -1) {
            zzrz zzrzVarZzc = zzc("video/avc", false, false);
            if (zzrzVarZzc != null) {
                int iMax2 = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzrzVarZzc.zzh()) {
                    int i2 = codecProfileLevel.level;
                    if (i2 != 1 && i2 != 2) {
                        switch (i2) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i = 35651584;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    iMax2 = Math.max(i, iMax2);
                }
                iMax = Math.max(iMax2, zzfk.zza >= 21 ? 345600 : 172800);
            } else {
                iMax = 0;
            }
            zzd = iMax;
        }
        return iMax;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:139:0x024a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0065  */
    /* JADX WARN: Code duplicated, block: B:177:0x02c1 A[Catch: NumberFormatException -> 0x02d1, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x02d1, blocks: (B:148:0x026a, B:150:0x027c, B:161:0x0298, B:177:0x02c1), top: B:491:0x026a }] */
    /* JADX WARN: Code duplicated, block: B:254:0x0429  */
    /* JADX WARN: Code duplicated, block: B:336:0x055a  */
    /* JADX WARN: Code duplicated, block: B:460:0x0782  */
    /* JADX WARN: Code duplicated, block: B:461:0x0797  */
    /* JADX WARN: Code duplicated, block: B:462:0x079a  */
    /* JADX WARN: Code duplicated, block: B:463:0x079d  */
    /* JADX WARN: Code duplicated, block: B:464:0x07a0  */
    /* JADX WARN: Code duplicated, block: B:465:0x07a3  */
    /* JADX WARN: Code duplicated, block: B:466:0x07a6  */
    /* JADX WARN: Code duplicated, block: B:467:0x07a8  */
    /* JADX WARN: Code duplicated, block: B:468:0x07ab  */
    /* JADX WARN: Code duplicated, block: B:469:0x07af  */
    /* JADX WARN: Code duplicated, block: B:470:0x07b2  */
    /* JADX WARN: Code duplicated, block: B:471:0x07b5  */
    /* JADX WARN: Code duplicated, block: B:472:0x07b7  */
    /* JADX WARN: Code duplicated, block: B:473:0x07ba  */
    /* JADX WARN: Code duplicated, block: B:474:0x07bc  */
    /* JADX WARN: Code duplicated, block: B:475:0x07be  */
    /* JADX WARN: Code duplicated, block: B:476:0x07c0  */
    /* JADX WARN: Code duplicated, block: B:477:0x07c2  */
    /* JADX WARN: Code duplicated, block: B:478:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:479:0x07c7  */
    /* JADX WARN: Code duplicated, block: B:480:0x07c9  */
    /* JADX WARN: Code duplicated, block: B:481:0x07cb  */
    /* JADX WARN: Code duplicated, block: B:482:0x07cd  */
    /* JADX WARN: Code duplicated, block: B:485:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:486:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:67:0x0122  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v106 int, still in use, count: 1, list:
      (r1v106 int) from 0x012c: SWITCH (r1v106 int)
     case 1567: goto B:81:0x015e
     case 1568: goto B:78:0x014e
     case 1569: goto B:75:0x013e
     case 1570: goto B:72:0x0130
     default: goto B:67:0x0122 A[RegionRef:SW:70]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Instruction removed from duplicated block: B:460:0x0782, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:485:0x07d1, please report this as an issue */
    public static Pair zzb(zzam zzamVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Integer num;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Integer num2;
        Integer num3;
        String str = zzamVar.zzj;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        int i14 = 2;
        int i15 = 1;
        if ("video/dolby-vision".equals(zzamVar.zzm)) {
            String str2 = zzamVar.zzj;
            if (strArrSplit.length < 3) {
                zzer.zzf("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str2)));
            } else {
                Matcher matcher = zzb.matcher(strArrSplit[1]);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    if (strGroup != null) {
                        switch (strGroup) {
                            case "00":
                                num2 = 1;
                                break;
                            case "01":
                                num2 = 2;
                                break;
                            case "02":
                                num2 = 4;
                                break;
                            case "03":
                                num2 = 8;
                                break;
                            case "04":
                                num2 = 16;
                                break;
                            case "05":
                                num2 = 32;
                                break;
                            case "06":
                                num2 = 64;
                                break;
                            case "07":
                                num2 = 128;
                                break;
                            case "08":
                                num2 = 256;
                                break;
                            case "09":
                                num2 = 512;
                                break;
                            default:
                                num2 = null;
                                break;
                        }
                    } else {
                        num2 = null;
                    }
                    if (num2 == null) {
                        zzer.zzf("MediaCodecUtil", "Unknown Dolby Vision profile string: ".concat(String.valueOf(strGroup)));
                    } else {
                        String str3 = strArrSplit[2];
                        if (str3 != null) {
                            switch (str3) {
                                case "01":
                                    num3 = 1;
                                    break;
                                case "02":
                                    num3 = 2;
                                    break;
                                case "03":
                                    num3 = 4;
                                    break;
                                case "04":
                                    num3 = 8;
                                    break;
                                case "05":
                                    num3 = 16;
                                    break;
                                case "06":
                                    num3 = 32;
                                    break;
                                case "07":
                                    num3 = 64;
                                    break;
                                case "08":
                                    num3 = 128;
                                    break;
                                case "09":
                                    num3 = 256;
                                    break;
                                default:
                                    switch (str3) {
                                        case 1567:
                                            if (!str3.equals("10")) {
                                                num3 = null;
                                            } else {
                                                num3 = 512;
                                            }
                                            break;
                                        case 1568:
                                            if (!str3.equals("11")) {
                                                num3 = null;
                                            } else {
                                                num3 = 1024;
                                            }
                                            break;
                                        case 1569:
                                            if (!str3.equals("12")) {
                                                num3 = null;
                                            } else {
                                                num3 = 2048;
                                            }
                                            break;
                                        case 1570:
                                            if (!str3.equals("13")) {
                                                num3 = null;
                                            } else {
                                                num3 = 4096;
                                            }
                                            break;
                                        default:
                                            num3 = null;
                                            break;
                                    }
                            }
                        } else {
                            num3 = null;
                        }
                        if (num3 != null) {
                            return new Pair(num2, num3);
                        }
                        zzer.zzf("MediaCodecUtil", "Unknown Dolby Vision level string: ".concat(String.valueOf(str3)));
                    }
                } else {
                    zzer.zzf("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str2)));
                }
            }
            return null;
        }
        switch (strArrSplit[0]) {
            case "avc1":
            case "avc2":
                String str4 = zzamVar.zzj;
                int length = strArrSplit.length;
                if (length < 2) {
                    zzer.zzf("MediaCodecUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str4)));
                } else {
                    try {
                        if (strArrSplit[1].length() == 6) {
                            i = 16;
                            i2 = Integer.parseInt(strArrSplit[1].substring(0, 2), 16);
                            i3 = Integer.parseInt(strArrSplit[1].substring(4), 16);
                        } else {
                            i = 16;
                            if (length >= 3) {
                                i2 = Integer.parseInt(strArrSplit[1]);
                                i3 = Integer.parseInt(strArrSplit[2]);
                            } else {
                                zzer.zzf("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str4);
                            }
                        }
                        if (i2 != 66) {
                            if (i2 != 77) {
                                if (i2 == 88) {
                                    i14 = 4;
                                } else if (i2 == 100) {
                                    i14 = 8;
                                } else if (i2 == 110) {
                                    i14 = i;
                                } else if (i2 == 122) {
                                    i14 = 32;
                                } else if (i2 != 244) {
                                    i4 = -1;
                                    i14 = -1;
                                } else {
                                    i14 = 64;
                                }
                            }
                            if (i14 == i4) {
                                zzer.zzf("MediaCodecUtil", "Unknown AVC profile: " + i2);
                            } else {
                                switch (i3) {
                                    case 10:
                                        i5 = 1;
                                        break;
                                    case 11:
                                        i5 = 4;
                                        break;
                                    case 12:
                                        i5 = 8;
                                        break;
                                    case 13:
                                        i5 = i;
                                        break;
                                    default:
                                        switch (i3) {
                                            case 20:
                                                i5 = 32;
                                                break;
                                            case 21:
                                                i5 = 64;
                                                break;
                                            case 22:
                                                i5 = 128;
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 30:
                                                        i5 = 256;
                                                        break;
                                                    case 31:
                                                        i5 = 512;
                                                        break;
                                                    case 32:
                                                        i5 = 1024;
                                                        break;
                                                    default:
                                                        switch (i3) {
                                                            case 40:
                                                                i5 = 2048;
                                                                break;
                                                            case 41:
                                                                i5 = 4096;
                                                                break;
                                                            case 42:
                                                                i5 = 8192;
                                                                break;
                                                            default:
                                                                switch (i3) {
                                                                    case 50:
                                                                        i5 = 16384;
                                                                        break;
                                                                    case 51:
                                                                        i5 = 32768;
                                                                        break;
                                                                    case 52:
                                                                        i5 = 65536;
                                                                        break;
                                                                    default:
                                                                        i5 = -1;
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                if (i5 == -1) {
                                    return new Pair(Integer.valueOf(i14), Integer.valueOf(i5));
                                }
                                zzer.zzf("MediaCodecUtil", "Unknown AVC level: " + i3);
                            }
                        } else {
                            i14 = 1;
                        }
                        i4 = -1;
                        if (i14 == i4) {
                            zzer.zzf("MediaCodecUtil", "Unknown AVC profile: " + i2);
                        } else {
                            switch (i3) {
                                case 10:
                                    i5 = 1;
                                    break;
                                case 11:
                                    i5 = 4;
                                    break;
                                case 12:
                                    i5 = 8;
                                    break;
                                case 13:
                                    i5 = i;
                                    break;
                                default:
                                    switch (i3) {
                                        case 20:
                                            i5 = 32;
                                            break;
                                        case 21:
                                            i5 = 64;
                                            break;
                                        case 22:
                                            i5 = 128;
                                            break;
                                        default:
                                            switch (i3) {
                                                case 30:
                                                    i5 = 256;
                                                    break;
                                                case 31:
                                                    i5 = 512;
                                                    break;
                                                case 32:
                                                    i5 = 1024;
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 40:
                                                            i5 = 2048;
                                                            break;
                                                        case 41:
                                                            i5 = 4096;
                                                            break;
                                                        case 42:
                                                            i5 = 8192;
                                                            break;
                                                        default:
                                                            switch (i3) {
                                                                case 50:
                                                                    i5 = 16384;
                                                                    break;
                                                                case 51:
                                                                    i5 = 32768;
                                                                    break;
                                                                case 52:
                                                                    i5 = 65536;
                                                                    break;
                                                                default:
                                                                    i5 = -1;
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            if (i5 == -1) {
                                return new Pair(Integer.valueOf(i14), Integer.valueOf(i5));
                            }
                            zzer.zzf("MediaCodecUtil", "Unknown AVC level: " + i3);
                        }
                    } catch (NumberFormatException unused) {
                        zzer.zzf("MediaCodecUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str4)));
                    }
                }
                return null;
            case "vp09":
                String str5 = zzamVar.zzj;
                if (strArrSplit.length < 3) {
                    zzer.zzf("MediaCodecUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str5)));
                } else {
                    try {
                        int i16 = Integer.parseInt(strArrSplit[1]);
                        int i17 = Integer.parseInt(strArrSplit[2]);
                        if (i16 == 0) {
                            i6 = 1;
                        } else if (i16 == 1) {
                            i6 = 2;
                        } else if (i16 != 2) {
                            i6 = i16 != 3 ? -1 : 8;
                        } else {
                            i6 = 4;
                        }
                        if (i6 == -1) {
                            zzer.zzf("MediaCodecUtil", "Unknown VP9 profile: " + i16);
                        } else {
                            if (i17 == 10) {
                                i7 = -1;
                            } else {
                                if (i17 == 11) {
                                    i15 = 2;
                                } else if (i17 == 20) {
                                    i15 = 4;
                                } else if (i17 == 21) {
                                    i15 = 8;
                                } else if (i17 == 30) {
                                    i7 = -1;
                                    i15 = 16;
                                } else if (i17 == 31) {
                                    i15 = 32;
                                } else if (i17 == 40) {
                                    i15 = 64;
                                } else if (i17 == 41) {
                                    i15 = 128;
                                } else if (i17 == 50) {
                                    i15 = 256;
                                } else if (i17 != 51) {
                                    switch (i17) {
                                        case 60:
                                            i7 = -1;
                                            i15 = 2048;
                                            break;
                                        case 61:
                                            i15 = 4096;
                                            break;
                                        case 62:
                                            i15 = 8192;
                                            break;
                                        default:
                                            i7 = -1;
                                            i15 = -1;
                                            break;
                                    }
                                } else {
                                    i15 = 512;
                                }
                                i7 = -1;
                            }
                            if (i15 != i7) {
                                return new Pair(Integer.valueOf(i6), Integer.valueOf(i15));
                            }
                            zzer.zzf("MediaCodecUtil", "Unknown VP9 level: " + i17);
                        }
                    } catch (NumberFormatException unused2) {
                        zzer.zzf("MediaCodecUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str5)));
                    }
                }
                return null;
            case "hev1":
            case "hvc1":
                String str6 = zzamVar.zzj;
                zzs zzsVar = zzamVar.zzy;
                if (strArrSplit.length < 4) {
                    zzer.zzf("MediaCodecUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str6)));
                } else {
                    Matcher matcher2 = zzb.matcher(strArrSplit[1]);
                    if (matcher2.matches()) {
                        String strGroup2 = matcher2.group(1);
                        if ("1".equals(strGroup2)) {
                            i8 = 1;
                        } else if ("2".equals(strGroup2)) {
                            i8 = (zzsVar == null || zzsVar.zzf != 6) ? 2 : 4096;
                        } else {
                            zzer.zzf("MediaCodecUtil", "Unknown HEVC profile string: ".concat(String.valueOf(strGroup2)));
                        }
                        String str7 = strArrSplit[3];
                        if (str7 != null) {
                            switch (str7) {
                                case "L30":
                                    num = 1;
                                    break;
                                case "L60":
                                    num = 4;
                                    break;
                                case "L63":
                                    num = 16;
                                    break;
                                case "L90":
                                    num = 64;
                                    break;
                                case "L93":
                                    num = 256;
                                    break;
                                case "L120":
                                    num = 1024;
                                    break;
                                case "L123":
                                    num = 4096;
                                    break;
                                case "L150":
                                    num = 16384;
                                    break;
                                case "L153":
                                    num = 65536;
                                    break;
                                case "L156":
                                    num = 262144;
                                    break;
                                case "L180":
                                    num = 1048576;
                                    break;
                                case "L183":
                                    num = 4194304;
                                    break;
                                case "L186":
                                    num = 16777216;
                                    break;
                                case "H30":
                                    num = 2;
                                    break;
                                case "H60":
                                    num = 8;
                                    break;
                                case "H63":
                                    num = 32;
                                    break;
                                case "H90":
                                    num = 128;
                                    break;
                                case "H93":
                                    num = 512;
                                    break;
                                case "H120":
                                    num = 2048;
                                    break;
                                case "H123":
                                    num = 8192;
                                    break;
                                case "H150":
                                    num = 32768;
                                    break;
                                case "H153":
                                    num = 131072;
                                    break;
                                case "H156":
                                    num = 524288;
                                    break;
                                case "H180":
                                    num = 2097152;
                                    break;
                                case "H183":
                                    num = 8388608;
                                    break;
                                case "H186":
                                    num = 33554432;
                                    break;
                                default:
                                    num = null;
                                    break;
                            }
                        } else {
                            num = null;
                        }
                        if (num != null) {
                            return new Pair(Integer.valueOf(i8), num);
                        }
                        zzer.zzf("MediaCodecUtil", "Unknown HEVC level string: ".concat(String.valueOf(str7)));
                    } else {
                        zzer.zzf("MediaCodecUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str6)));
                    }
                }
                return null;
            case "av01":
                String str8 = zzamVar.zzj;
                zzs zzsVar2 = zzamVar.zzy;
                if (strArrSplit.length < 4) {
                    zzer.zzf("MediaCodecUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str8)));
                } else {
                    try {
                        int i18 = Integer.parseInt(strArrSplit[1]);
                        int i19 = Integer.parseInt(strArrSplit[2].substring(0, 2));
                        int i20 = Integer.parseInt(strArrSplit[3]);
                        if (i18 != 0) {
                            zzer.zzf("MediaCodecUtil", "Unknown AV1 profile: " + i18);
                        } else {
                            if (i20 == 8) {
                                i9 = 1;
                            } else if (i20 != 10) {
                                zzer.zzf("MediaCodecUtil", "Unknown AV1 bit depth: " + i20);
                            } else {
                                i9 = (zzsVar2 == null || !(zzsVar2.zzg != null || (i11 = zzsVar2.zzf) == 7 || i11 == 6)) ? 2 : 4096;
                            }
                            switch (i19) {
                                case 0:
                                    i10 = 1;
                                    break;
                                case 1:
                                    i10 = 2;
                                    break;
                                case 2:
                                    i10 = 4;
                                    break;
                                case 3:
                                    i10 = 8;
                                    break;
                                case 4:
                                    i10 = 16;
                                    break;
                                case 5:
                                    i10 = 32;
                                    break;
                                case 6:
                                    i10 = 64;
                                    break;
                                case 7:
                                    i10 = 128;
                                    break;
                                case 8:
                                    i10 = 256;
                                    break;
                                case 9:
                                    i10 = 512;
                                    break;
                                case 10:
                                    i10 = 1024;
                                    break;
                                case 11:
                                    i10 = 2048;
                                    break;
                                case 12:
                                    i10 = 4096;
                                    break;
                                case 13:
                                    i10 = 8192;
                                    break;
                                case 14:
                                    i10 = 16384;
                                    break;
                                case 15:
                                    i10 = 32768;
                                    break;
                                case 16:
                                    i10 = 65536;
                                    break;
                                case 17:
                                    i10 = 131072;
                                    break;
                                case 18:
                                    i10 = 262144;
                                    break;
                                case 19:
                                    i10 = 524288;
                                    break;
                                case 20:
                                    i10 = 1048576;
                                    break;
                                case 21:
                                    i10 = 2097152;
                                    break;
                                case 22:
                                    i10 = 4194304;
                                    break;
                                case 23:
                                    i10 = 8388608;
                                    break;
                                default:
                                    i10 = -1;
                                    break;
                            }
                            if (i10 != -1) {
                                return new Pair(Integer.valueOf(i9), Integer.valueOf(i10));
                            }
                            zzer.zzf("MediaCodecUtil", "Unknown AV1 level: " + i19);
                        }
                    } catch (NumberFormatException unused3) {
                        zzer.zzf("MediaCodecUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str8)));
                    }
                }
                return null;
            case "mp4a":
                String str9 = zzamVar.zzj;
                if (strArrSplit.length != 3) {
                    zzer.zzf("MediaCodecUtil", "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str9)));
                } else {
                    try {
                        if ("audio/mp4a-latm".equals(zzcb.zzd(Integer.parseInt(strArrSplit[1], 16)))) {
                            int i21 = Integer.parseInt(strArrSplit[2]);
                            if (i21 == 17) {
                                i12 = 17;
                            } else if (i21 == 20) {
                                i12 = 20;
                            } else if (i21 == 23) {
                                i12 = 23;
                            } else if (i21 == 29) {
                                i12 = 29;
                            } else if (i21 == 39) {
                                i12 = 39;
                            } else if (i21 != 42) {
                                switch (i21) {
                                    case 1:
                                        i12 = 1;
                                        break;
                                    case 2:
                                        i12 = 2;
                                        break;
                                    case 3:
                                        i13 = -1;
                                        i12 = 3;
                                        break;
                                    case 4:
                                        i12 = 4;
                                        break;
                                    case 5:
                                        i13 = -1;
                                        i12 = 5;
                                        break;
                                    case 6:
                                        i13 = -1;
                                        i12 = 6;
                                        break;
                                    default:
                                        i13 = -1;
                                        i12 = -1;
                                        break;
                                }
                                if (i12 != i13) {
                                    return new Pair(Integer.valueOf(i12), 0);
                                }
                            } else {
                                i12 = 42;
                            }
                            i13 = -1;
                            if (i12 != i13) {
                                return new Pair(Integer.valueOf(i12), 0);
                            }
                        }
                    } catch (NumberFormatException unused4) {
                        zzer.zzf("MediaCodecUtil", "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str9)));
                    }
                }
                return null;
            default:
                return null;
        }
    }

    public static zzrz zzc(String str, boolean z, boolean z2) throws zzsn {
        List listZzg = zzg(str, false, false);
        if (listZzg.isEmpty()) {
            return null;
        }
        return (zzrz) listZzg.get(0);
    }

    public static zzrz zzd() throws zzsn {
        return zzc("audio/raw", false, false);
    }

    public static String zze(zzam zzamVar) {
        Pair pairZzb;
        if ("audio/eac3-joc".equals(zzamVar.zzm)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(zzamVar.zzm) || (pairZzb = zzb(zzamVar)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairZzb.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return "video/hevc";
        }
        if (iIntValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static List zzf(zzsg zzsgVar, zzam zzamVar, boolean z, boolean z2) throws zzsn {
        String strZze = zze(zzamVar);
        return strZze == null ? zzfvs.zzl() : zzg(strZze, z, z2);
    }

    public static synchronized List zzg(String str, boolean z, boolean z2) throws zzsn {
        int i;
        zzsl zzslVar = new zzsl(str, z, z2);
        HashMap map = zzc;
        List list = (List) map.get(zzslVar);
        if (list != null) {
            return list;
        }
        ArrayList arrayListZzj = zzj(zzslVar, zzfk.zza >= 21 ? new zzsr(z, z2) : new zzsq(null));
        if (z && arrayListZzj.isEmpty() && (i = zzfk.zza) >= 21 && i <= 23) {
            arrayListZzj = zzj(zzslVar, new zzsq(null));
            if (!arrayListZzj.isEmpty()) {
                zzer.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((zzrz) arrayListZzj.get(0)).zza);
            }
        }
        if ("audio/raw".equals(str)) {
            if (zzfk.zza < 26 && zzfk.zzb.equals("R9") && arrayListZzj.size() == 1 && ((zzrz) arrayListZzj.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayListZzj.add(zzrz.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            zzk(arrayListZzj, new zzss() { // from class: com.google.android.gms.internal.ads.zzsi
                @Override // com.google.android.gms.internal.ads.zzss
                public final int zza(Object obj) {
                    int i2 = zzst.zza;
                    String str2 = ((zzrz) obj).zza;
                    if (str2.startsWith("OMX.google") || str2.startsWith("c2.android")) {
                        return 1;
                    }
                    return (zzfk.zza >= 26 || !str2.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
                }
            });
        }
        if (zzfk.zza < 21 && arrayListZzj.size() > 1) {
            String str2 = ((zzrz) arrayListZzj.get(0)).zza;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                zzk(arrayListZzj, new zzss() { // from class: com.google.android.gms.internal.ads.zzsj
                    @Override // com.google.android.gms.internal.ads.zzss
                    public final int zza(Object obj) {
                        int i2 = zzst.zza;
                        return ((zzrz) obj).zza.startsWith("OMX.google") ? 1 : 0;
                    }
                });
            }
        }
        if (zzfk.zza < 32 && arrayListZzj.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzrz) arrayListZzj.get(0)).zza)) {
            arrayListZzj.add((zzrz) arrayListZzj.remove(0));
        }
        zzfvs zzfvsVarZzj = zzfvs.zzj(arrayListZzj);
        map.put(zzslVar, zzfvsVarZzj);
        return zzfvsVarZzj;
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zzh(zzsg zzsgVar, zzam zzamVar, boolean z, boolean z2) throws zzsn {
        List listZzg = zzg(zzamVar.zzm, z, z2);
        List listZzf = zzf(zzsgVar, zzamVar, z, z2);
        zzfvp zzfvpVar = new zzfvp();
        zzfvpVar.zzh(listZzg);
        zzfvpVar.zzh(listZzf);
        return zzfvpVar.zzi();
    }

    public static List zzi(List list, final zzam zzamVar) {
        ArrayList arrayList = new ArrayList(list);
        zzk(arrayList, new zzss() { // from class: com.google.android.gms.internal.ads.zzsk
            @Override // com.google.android.gms.internal.ads.zzss
            public final int zza(Object obj) {
                int i = zzst.zza;
                return ((zzrz) obj).zzd(zzamVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x01d7 A[EDGE_INSN: B:116:0x01d7->B:117:0x01d8 BREAK  A[LOOP:1: B:85:0x0167->B:89:0x0173]] */
    /* JADX WARN: Code duplicated, block: B:126:0x01ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0201  */
    /* JADX WARN: Code duplicated, block: B:128:0x0202 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x0204  */
    /* JADX WARN: Code duplicated, block: B:132:0x020c A[Catch: Exception -> 0x02b9, TryCatch #2 {Exception -> 0x02b9, blocks: (B:118:0x01da, B:124:0x01f1, B:130:0x0206, B:132:0x020c, B:137:0x021d, B:139:0x0227, B:149:0x0253, B:140:0x022c, B:142:0x023c, B:144:0x0244, B:133:0x0212), top: B:192:0x01da }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0212 A[Catch: Exception -> 0x02b9, TryCatch #2 {Exception -> 0x02b9, blocks: (B:118:0x01da, B:124:0x01f1, B:130:0x0206, B:132:0x020c, B:137:0x021d, B:139:0x0227, B:149:0x0253, B:140:0x022c, B:142:0x023c, B:144:0x0244, B:133:0x0212), top: B:192:0x01da }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0218  */
    /* JADX WARN: Code duplicated, block: B:136:0x021b  */
    /* JADX WARN: Code duplicated, block: B:139:0x0227 A[Catch: Exception -> 0x02b9, TryCatch #2 {Exception -> 0x02b9, blocks: (B:118:0x01da, B:124:0x01f1, B:130:0x0206, B:132:0x020c, B:137:0x021d, B:139:0x0227, B:149:0x0253, B:140:0x022c, B:142:0x023c, B:144:0x0244, B:133:0x0212), top: B:192:0x01da }] */
    /* JADX WARN: Code duplicated, block: B:140:0x022c A[Catch: Exception -> 0x02b9, TryCatch #2 {Exception -> 0x02b9, blocks: (B:118:0x01da, B:124:0x01f1, B:130:0x0206, B:132:0x020c, B:137:0x021d, B:139:0x0227, B:149:0x0253, B:140:0x022c, B:142:0x023c, B:144:0x0244, B:133:0x0212), top: B:192:0x01da }] */
    /* JADX WARN: Code duplicated, block: B:142:0x023c A[Catch: Exception -> 0x02b9, TryCatch #2 {Exception -> 0x02b9, blocks: (B:118:0x01da, B:124:0x01f1, B:130:0x0206, B:132:0x020c, B:137:0x021d, B:139:0x0227, B:149:0x0253, B:140:0x022c, B:142:0x023c, B:144:0x0244, B:133:0x0212), top: B:192:0x01da }] */
    /* JADX WARN: Code duplicated, block: B:147:0x024f  */
    /* JADX WARN: Code duplicated, block: B:149:0x0253 A[Catch: Exception -> 0x02b9, TRY_LEAVE, TryCatch #2 {Exception -> 0x02b9, blocks: (B:118:0x01da, B:124:0x01f1, B:130:0x0206, B:132:0x020c, B:137:0x021d, B:139:0x0227, B:149:0x0253, B:140:0x022c, B:142:0x023c, B:144:0x0244, B:133:0x0212), top: B:192:0x01da }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0257 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x025d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0285  */
    /* JADX WARN: Code duplicated, block: B:162:0x028e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:178:0x02c8 A[Catch: Exception -> 0x0316, TRY_ENTER, TryCatch #4 {Exception -> 0x0316, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:10:0x0034, B:14:0x0042, B:16:0x0048, B:18:0x004e, B:20:0x0056, B:22:0x005e, B:24:0x0066, B:26:0x006e, B:28:0x0076, B:30:0x007e, B:33:0x0086, B:35:0x008e, B:37:0x0096, B:39:0x009e, B:41:0x00a8, B:43:0x00b2, B:45:0x00bc, B:47:0x00c6, B:49:0x00d0, B:51:0x00da, B:53:0x00e4, B:55:0x00ee, B:58:0x00f6, B:60:0x00fe, B:62:0x0106, B:64:0x0110, B:66:0x011a, B:68:0x0122, B:70:0x012c, B:72:0x0136, B:74:0x013a, B:76:0x0142, B:78:0x014a, B:80:0x0150, B:82:0x0158, B:84:0x0160, B:86:0x0169, B:175:0x02c0, B:178:0x02c8, B:180:0x02ce, B:181:0x02e8, B:182:0x0309, B:89:0x0173, B:90:0x0178, B:92:0x0180, B:95:0x018b, B:97:0x0193, B:100:0x019e, B:102:0x01a6, B:105:0x01b1, B:107:0x01b9, B:110:0x01c4, B:112:0x01cc), top: B:196:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x0259 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x02e8 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:206:0x030a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x002d  */
    private static ArrayList zzj(zzsl zzslVar, zzso zzsoVar) throws zzsn {
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        String str4;
        boolean zZzd;
        boolean zZzc;
        boolean zIsHardwareAccelerated;
        boolean zZzl;
        String strZza;
        boolean zIsVendor;
        String str5;
        zzsl zzslVar2 = zzslVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str6 = zzslVar2.zza;
            boolean zZze = zzsoVar.zze();
            int i3 = 0;
            for (int iZza = zzsoVar.zza(); i3 < iZza; iZza = i2) {
                MediaCodecInfo mediaCodecInfoZzb = zzsoVar.zzb(i3);
                if (zzfk.zza < 29 || !mediaCodecInfoZzb.isAlias()) {
                    String name = mediaCodecInfoZzb.getName();
                    if (mediaCodecInfoZzb.isEncoder() || ((!zZze && name.endsWith(".secure")) || ((zzfk.zza < 21 && ("CIPAACDecoder".equals(name) || "CIPMP3Decoder".equals(name) || "CIPVorbisDecoder".equals(name) || "CIPAMRNBDecoder".equals(name) || "AACDecoder".equals(name) || "MP3Decoder".equals(name))) || ((zzfk.zza < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && "samsung".equals(zzfk.zzc) && (zzfk.zzb.startsWith("zeroflte") || zzfk.zzb.startsWith("zerolte") || zzfk.zzb.startsWith("zenlte") || "SC-05G".equals(zzfk.zzb) || "marinelteatt".equals(zzfk.zzb) || "404SC".equals(zzfk.zzb) || "SC-04G".equals(zzfk.zzb) || "SCV31".equals(zzfk.zzb)))) || ((zzfk.zza <= 19 && "OMX.SEC.vp8.dec".equals(name) && "samsung".equals(zzfk.zzc) && (zzfk.zzb.startsWith("d2") || zzfk.zzb.startsWith("serrano") || zzfk.zzb.startsWith("jflte") || zzfk.zzb.startsWith("santos") || zzfk.zzb.startsWith("t0"))) || ((zzfk.zza <= 19 && zzfk.zzb.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(name)) || (zzfk.zza <= 23 && "audio/eac3-joc".equals(str6) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(name)))))))) {
                        i = i3;
                        i2 = iZza;
                        str4 = str6;
                    } else {
                        String[] supportedTypes = mediaCodecInfoZzb.getSupportedTypes();
                        int length = supportedTypes.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 < length) {
                                str = supportedTypes[i4];
                                if (!str.equalsIgnoreCase(str6)) {
                                    i4++;
                                }
                            } else if (str6.equals("video/dolby-vision")) {
                                if (!"OMX.MS.HEVCDV.Decoder".equals(name)) {
                                    if (!"OMX.RTK.video.decoder".equals(name) && !"OMX.realtek.video.decoder.tunneled".equals(name)) {
                                        str2 = null;
                                        break;
                                    }
                                    str = "video/dv_hevc";
                                } else {
                                    str = "video/hevcdv";
                                }
                            } else if (str6.equals("audio/alac") && "OMX.lge.alac.decoder".equals(name)) {
                                str = "audio/x-lg-alac";
                            } else if (str6.equals("audio/flac") && "OMX.lge.flac.decoder".equals(name)) {
                                str = "audio/x-lg-flac";
                            } else {
                                if (!str6.equals("audio/ac3") || !"OMX.lge.ac3.decoder".equals(name)) {
                                    str2 = null;
                                    break;
                                }
                                str = "audio/lg-ac3";
                            }
                            str2 = str;
                            break;
                        }
                        if (str2 != null) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoZzb.getCapabilitiesForType(str2);
                                boolean zZzd2 = zzsoVar.zzd("tunneled-playback", str2, capabilitiesForType);
                                boolean zZzc2 = zzsoVar.zzc("tunneled-playback", str2, capabilitiesForType);
                                if (zzslVar2.zzc) {
                                    if (zZzd2) {
                                        zZzd = zzsoVar.zzd("secure-playback", str2, capabilitiesForType);
                                        zZzc = zzsoVar.zzc("secure-playback", str2, capabilitiesForType);
                                        if (zzslVar2.zzb) {
                                            if (zZzd) {
                                                zZzd = true;
                                                if (zzfk.zza >= 29) {
                                                    zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                                } else if (zzl(mediaCodecInfoZzb, str6)) {
                                                    zIsHardwareAccelerated = false;
                                                } else {
                                                    zIsHardwareAccelerated = true;
                                                }
                                                zZzl = zzl(mediaCodecInfoZzb, str6);
                                                if (zzfk.zza >= 29) {
                                                    zIsVendor = mediaCodecInfoZzb.isVendor();
                                                } else {
                                                    strZza = zzfsc.zza(mediaCodecInfoZzb.getName());
                                                    if (strZza.startsWith("omx.google.")) {
                                                        zIsVendor = false;
                                                    } else {
                                                        zIsVendor = false;
                                                    }
                                                }
                                                if (!zZze) {
                                                    if (!zZze) {
                                                        str5 = name;
                                                        i = i3;
                                                        i2 = iZza;
                                                        str4 = str6;
                                                        if (!zZze) {
                                                            continue;
                                                        }
                                                    } else if (zzslVar2.zzb) {
                                                        str5 = name;
                                                        i = i3;
                                                        i2 = iZza;
                                                        str4 = str6;
                                                        if (!zZze) {
                                                            continue;
                                                        }
                                                    } else {
                                                        str5 = name;
                                                        i = i3;
                                                        i2 = iZza;
                                                        str4 = str6;
                                                        arrayList.add(zzrz.zzc(name, str6, str2, capabilitiesForType, zIsHardwareAccelerated, zZzl, zIsVendor, false, false));
                                                    }
                                                } else if (!zZze) {
                                                    str5 = name;
                                                    i = i3;
                                                    i2 = iZza;
                                                    str4 = str6;
                                                    if (!zZze) {
                                                        continue;
                                                    }
                                                } else if (zzslVar2.zzb) {
                                                    str5 = name;
                                                    i = i3;
                                                    i2 = iZza;
                                                    str4 = str6;
                                                    arrayList.add(zzrz.zzc(name, str6, str2, capabilitiesForType, zIsHardwareAccelerated, zZzl, zIsVendor, false, false));
                                                } else {
                                                    str5 = name;
                                                    i = i3;
                                                    i2 = iZza;
                                                    str4 = str6;
                                                    if (!zZze) {
                                                        continue;
                                                    }
                                                }
                                            }
                                        } else if (!zZzc) {
                                            if (zzfk.zza >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzl(mediaCodecInfoZzb, str6)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzl = zzl(mediaCodecInfoZzb, str6);
                                            if (zzfk.zza >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfsc.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (!zZze) {
                                                if (!zZze) {
                                                    str5 = name;
                                                    i = i3;
                                                    i2 = iZza;
                                                    str4 = str6;
                                                    if (!zZze) {
                                                        continue;
                                                    }
                                                } else if (zzslVar2.zzb) {
                                                    str5 = name;
                                                    i = i3;
                                                    i2 = iZza;
                                                    str4 = str6;
                                                    arrayList.add(zzrz.zzc(name, str6, str2, capabilitiesForType, zIsHardwareAccelerated, zZzl, zIsVendor, false, false));
                                                } else {
                                                    str5 = name;
                                                    i = i3;
                                                    i2 = iZza;
                                                    str4 = str6;
                                                    if (!zZze) {
                                                        continue;
                                                    }
                                                }
                                            } else if (!zZze) {
                                                str5 = name;
                                                i = i3;
                                                i2 = iZza;
                                                str4 = str6;
                                                if (!zZze) {
                                                    continue;
                                                }
                                            } else if (zzslVar2.zzb) {
                                                str5 = name;
                                                i = i3;
                                                i2 = iZza;
                                                str4 = str6;
                                                arrayList.add(zzrz.zzc(name, str6, str2, capabilitiesForType, zIsHardwareAccelerated, zZzl, zIsVendor, false, false));
                                            } else {
                                                str5 = name;
                                                i = i3;
                                                i2 = iZza;
                                                str4 = str6;
                                                if (!zZze) {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                } else if (!zZzc2) {
                                    zZzd = zzsoVar.zzd("secure-playback", str2, capabilitiesForType);
                                    zZzc = zzsoVar.zzc("secure-playback", str2, capabilitiesForType);
                                    if (zzslVar2.zzb) {
                                        if (!zZzc) {
                                            if (zzfk.zza >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzl(mediaCodecInfoZzb, str6)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzl = zzl(mediaCodecInfoZzb, str6);
                                            if (zzfk.zza >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfsc.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = true;
                                                }
                                            }
                                            if (!zZze && zzslVar2.zzb == zZzd) {
                                                str5 = name;
                                                i = i3;
                                                i2 = iZza;
                                                str4 = str6;
                                                arrayList.add(zzrz.zzc(name, str6, str2, capabilitiesForType, zIsHardwareAccelerated, zZzl, zIsVendor, false, false));
                                            } else if (!zZze) {
                                                try {
                                                    if (zzslVar2.zzb) {
                                                        str5 = name;
                                                        i = i3;
                                                        i2 = iZza;
                                                        str4 = str6;
                                                        try {
                                                            arrayList.add(zzrz.zzc(name, str6, str2, capabilitiesForType, zIsHardwareAccelerated, zZzl, zIsVendor, false, false));
                                                        } catch (Exception e) {
                                                            e = e;
                                                            str3 = str5;
                                                            if (zzfk.zza <= 23) {
                                                            }
                                                            zzer.zzc("MediaCodecUtil", "Failed to query codec " + str3 + " (" + str2 + ")");
                                                            throw e;
                                                        }
                                                    } else {
                                                        str5 = name;
                                                        i = i3;
                                                        i2 = iZza;
                                                        str4 = str6;
                                                        if (!zZze && zZzd) {
                                                            StringBuilder sb = new StringBuilder();
                                                            try {
                                                                sb.append(str5);
                                                                sb.append(".secure");
                                                                str3 = str5;
                                                                try {
                                                                    arrayList.add(zzrz.zzc(sb.toString(), str4, str2, capabilitiesForType, zIsHardwareAccelerated, zZzl, zIsVendor, false, true));
                                                                    return arrayList;
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    if (zzfk.zza <= 23) {
                                                                    }
                                                                    zzer.zzc("MediaCodecUtil", "Failed to query codec " + str3 + " (" + str2 + ")");
                                                                    throw e;
                                                                }
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                str3 = str5;
                                                            }
                                                        }
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    i = i3;
                                                    i2 = iZza;
                                                    str4 = str6;
                                                    str3 = name;
                                                    if (zzfk.zza <= 23 || arrayList.isEmpty()) {
                                                        zzer.zzc("MediaCodecUtil", "Failed to query codec " + str3 + " (" + str2 + ")");
                                                        throw e;
                                                    }
                                                    zzer.zzc("MediaCodecUtil", "Skipping codec " + str3 + " (failed to query capabilities)");
                                                    i3 = i + 1;
                                                    zzslVar2 = zzslVar;
                                                    str6 = str4;
                                                }
                                            } else {
                                                str5 = name;
                                                i = i3;
                                                i2 = iZza;
                                                str4 = str6;
                                                if (!zZze) {
                                                    continue;
                                                }
                                            }
                                        }
                                    } else if (zZzd) {
                                        zZzd = true;
                                        if (zzfk.zza >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzl(mediaCodecInfoZzb, str6)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzl = zzl(mediaCodecInfoZzb, str6);
                                        if (zzfk.zza >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfsc.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (!zZze) {
                                            if (!zZze) {
                                                str5 = name;
                                                i = i3;
                                                i2 = iZza;
                                                str4 = str6;
                                                if (!zZze) {
                                                    continue;
                                                }
                                            } else if (zzslVar2.zzb) {
                                                str5 = name;
                                                i = i3;
                                                i2 = iZza;
                                                str4 = str6;
                                                arrayList.add(zzrz.zzc(name, str6, str2, capabilitiesForType, zIsHardwareAccelerated, zZzl, zIsVendor, false, false));
                                            } else {
                                                str5 = name;
                                                i = i3;
                                                i2 = iZza;
                                                str4 = str6;
                                                if (!zZze) {
                                                    continue;
                                                }
                                            }
                                        } else if (!zZze) {
                                            str5 = name;
                                            i = i3;
                                            i2 = iZza;
                                            str4 = str6;
                                            if (!zZze) {
                                                continue;
                                            }
                                        } else if (zzslVar2.zzb) {
                                            str5 = name;
                                            i = i3;
                                            i2 = iZza;
                                            str4 = str6;
                                            arrayList.add(zzrz.zzc(name, str6, str2, capabilitiesForType, zIsHardwareAccelerated, zZzl, zIsVendor, false, false));
                                        } else {
                                            str5 = name;
                                            i = i3;
                                            i2 = iZza;
                                            str4 = str6;
                                            if (!zZze) {
                                                continue;
                                            }
                                        }
                                    }
                                }
                                i = i3;
                                i2 = iZza;
                                str4 = str6;
                            } catch (Exception e5) {
                                e = e5;
                                str3 = name;
                                i = i3;
                                i2 = iZza;
                                str4 = str6;
                            }
                        } else {
                            i = i3;
                            i2 = iZza;
                            str4 = str6;
                        }
                    }
                } else {
                    i = i3;
                    i2 = iZza;
                    str4 = str6;
                }
                i3 = i + 1;
                zzslVar2 = zzslVar;
                str6 = str4;
            }
            return arrayList;
        } catch (Exception e6) {
            throw new zzsn(e6, null);
        }
    }

    private static void zzk(List list, final zzss zzssVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzsh
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i = zzst.zza;
                zzss zzssVar2 = zzssVar;
                return zzssVar2.zza(obj2) - zzssVar2.zza(obj);
            }
        });
    }

    private static boolean zzl(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzfk.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzcb.zzf(str)) {
            return true;
        }
        String strZza = zzfsc.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }
}
