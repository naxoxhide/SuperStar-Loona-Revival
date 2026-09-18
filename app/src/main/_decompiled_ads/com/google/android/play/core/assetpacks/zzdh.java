package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdh {
    private static final com.google.android.play.core.internal.zzag zza = new com.google.android.play.core.internal.zzag("ExtractorTaskFinder");
    private final zzde zzb;
    private final zzbh zzc;
    private final zzbu zzd;
    private final com.google.android.play.core.common.zza zze;

    zzdh(zzde zzdeVar, zzbh zzbhVar, zzbu zzbuVar, com.google.android.play.core.common.zza zzaVar) {
        this.zzb = zzdeVar;
        this.zzc = zzbhVar;
        this.zzd = zzbuVar;
        this.zze = zzaVar;
    }

    private final boolean zzb(zzdb zzdbVar, zzdc zzdcVar) {
        zzbh zzbhVar = this.zzc;
        zzda zzdaVar = zzdbVar.zzc;
        return new zzen(zzbhVar, zzdaVar.zza, zzdbVar.zzb, zzdaVar.zzb, zzdcVar.zza).zzm();
    }

    private static boolean zzc(zzdc zzdcVar) {
        int i = zzdcVar.zzf;
        return i == 1 || i == 2;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x033e A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x035a A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:116:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:118:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:138:0x012a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x00df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:? A[LOOP:2: B:33:0x00bb->B:140:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x01b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0175 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x0131 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x023f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x01fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x01b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x01e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x01d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x01d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x0331 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x025e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x0277 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x0264 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x03e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x034e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x0338 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b1 A[PHI: r0
      0x00b1: PHI (r0v47 com.google.android.play.core.assetpacks.zzdg) = 
      (r0v11 com.google.android.play.core.assetpacks.zzdg)
      (r0v14 com.google.android.play.core.assetpacks.zzdg)
      (r0v17 com.google.android.play.core.assetpacks.zzdg)
      (r0v51 com.google.android.play.core.assetpacks.zzdg)
     binds: [B:43:0x012b, B:57:0x01b3, B:72:0x0240, B:27:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b7 A[Catch: all -> 0x03f7, TRY_ENTER, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c1 A[Catch: all -> 0x03f7, TRY_LEAVE, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x012d A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0138 A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0154 A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01af A[LOOP:4: B:50:0x014e->B:55:0x01af, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x01b5 A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x01bf A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x01db A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0242 A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x024d A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x026a A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0334 A[Catch: all -> 0x03f7, TryCatch #0 {all -> 0x03f7, blocks: (B:3:0x0002, B:4:0x001a, B:6:0x0020, B:8:0x0030, B:9:0x0034, B:15:0x0041, B:17:0x004e, B:18:0x0058, B:20:0x005e, B:22:0x0070, B:24:0x007c, B:32:0x00b7, B:33:0x00bb, B:35:0x00c1, B:36:0x00c7, B:38:0x00df, B:44:0x012d, B:45:0x0131, B:47:0x0138, B:49:0x0148, B:50:0x014e, B:52:0x0154, B:54:0x0175, B:58:0x01b5, B:59:0x01b9, B:61:0x01bf, B:63:0x01cf, B:64:0x01d5, B:66:0x01db, B:68:0x01e7, B:70:0x01fd, B:73:0x0242, B:74:0x0246, B:76:0x024d, B:78:0x025e, B:79:0x0264, B:81:0x026a, B:83:0x0277, B:84:0x0296, B:91:0x02ac, B:93:0x02b8, B:97:0x0334, B:98:0x0338, B:100:0x033e, B:102:0x034e, B:103:0x0354, B:105:0x035a, B:107:0x0366, B:109:0x0372, B:111:0x0378, B:88:0x029d, B:40:0x010c, B:41:0x0129), top: B:122:0x0002, inners: #1, #2 }] */
    final zzdg zza() {
        Iterator it;
        zzdg zzefVar;
        Iterator it2;
        Iterator it3;
        Iterator it4;
        zzde zzdeVar;
        Iterator it5;
        zzde zzdeVar2;
        zzda zzdaVar;
        zzdb zzdbVar;
        zzda zzdaVar2;
        Iterator it6;
        zzdc zzdcVar;
        int iZza;
        zzdb zzdbVar2;
        zzda zzdaVar3;
        zzbh zzbhVar;
        zzda zzdaVar4;
        zzdb zzdbVar3;
        zzda zzdaVar5;
        zzbh zzbhVar2;
        zzda zzdaVar6;
        zzdb zzdbVar4;
        zzbh zzbhVar3;
        zzda zzdaVar7;
        try {
            this.zzb.zzj();
            ArrayList arrayList = new ArrayList();
            for (zzdb zzdbVar5 : this.zzb.zzg().values()) {
                if (zzbg.zzb(zzdbVar5.zzc.zzd)) {
                    arrayList.add(zzdbVar5);
                }
            }
            zzce zzceVar = null;
            if (!arrayList.isEmpty()) {
                if (this.zze.zza("assetOnlyUpdates")) {
                    Map mapZzt = this.zzc.zzt();
                    Iterator it7 = arrayList.iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            zzefVar = null;
                            break;
                        }
                        zzdb zzdbVar6 = (zzdb) it7.next();
                        Long l = (Long) mapZzt.get(zzdbVar6.zzc.zza);
                        if (l != null && zzdbVar6.zzc.zzb == l.longValue()) {
                            zza.zza("Found promote pack task for session %s with pack %s.", Integer.valueOf(zzdbVar6.zza), zzdbVar6.zzc.zza);
                            int i = zzdbVar6.zza;
                            String str = zzdbVar6.zzc.zza;
                            zzefVar = new zzei(i, str, this.zzc.zza(str), zzdbVar6.zzb, zzdbVar6.zzc.zzb);
                            break;
                        }
                    }
                    if (zzefVar == null) {
                        it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                zzefVar = null;
                                break;
                            }
                            zzdbVar4 = (zzdb) it.next();
                            try {
                                zzbhVar3 = this.zzc;
                                zzdaVar7 = zzdbVar4.zzc;
                                if (zzbhVar3.zzb(zzdaVar7.zza, zzdbVar4.zzb, zzdaVar7.zzb) == zzdbVar4.zzc.zzf.size()) {
                                    zza.zza("Found final move task for session %s with pack %s.", Integer.valueOf(zzdbVar4.zza), zzdbVar4.zzc.zza);
                                    int i2 = zzdbVar4.zza;
                                    zzda zzdaVar8 = zzdbVar4.zzc;
                                    zzefVar = new zzdw(i2, zzdaVar8.zza, zzdbVar4.zzb, zzdaVar8.zzb, zzdaVar8.zzc);
                                    break;
                                }
                            } catch (IOException e) {
                                throw new zzck(String.format("Failed to check number of completed merges for session %s, pack %s", Integer.valueOf(zzdbVar4.zza), zzdbVar4.zzc.zza), e, zzdbVar4.zza);
                            }
                        }
                        if (zzefVar == null) {
                            it2 = arrayList.iterator();
                            loop3: while (true) {
                                if (it2.hasNext()) {
                                    zzefVar = null;
                                    break;
                                }
                                zzdbVar3 = (zzdb) it2.next();
                                zzdaVar5 = zzdbVar3.zzc;
                                if (zzbg.zzb(zzdaVar5.zzd)) {
                                    for (zzdc zzdcVar2 : zzdaVar5.zzf) {
                                        zzbhVar2 = this.zzc;
                                        zzdaVar6 = zzdbVar3.zzc;
                                        if (zzbhVar2.zzq(zzdaVar6.zza, zzdbVar3.zzb, zzdaVar6.zzb, zzdcVar2.zza).exists()) {
                                            zza.zza("Found merge task for session %s with pack %s and slice %s.", Integer.valueOf(zzdbVar3.zza), zzdbVar3.zzc.zza, zzdcVar2.zza);
                                            int i3 = zzdbVar3.zza;
                                            zzda zzdaVar9 = zzdbVar3.zzc;
                                            zzefVar = new zzdt(i3, zzdaVar9.zza, zzdbVar3.zzb, zzdaVar9.zzb, zzdcVar2.zza);
                                            break loop3;
                                        }
                                    }
                                }
                            }
                            if (zzefVar == null) {
                                it3 = arrayList.iterator();
                                loop5: while (true) {
                                    if (it3.hasNext()) {
                                        zzefVar = null;
                                        break;
                                    }
                                    zzdbVar2 = (zzdb) it3.next();
                                    zzdaVar3 = zzdbVar2.zzc;
                                    if (zzbg.zzb(zzdaVar3.zzd)) {
                                        for (zzdc zzdcVar3 : zzdaVar3.zzf) {
                                            if (zzb(zzdbVar2, zzdcVar3)) {
                                                zzbhVar = this.zzc;
                                                zzdaVar4 = zzdbVar2.zzc;
                                                if (zzbhVar.zzp(zzdaVar4.zza, zzdbVar2.zzb, zzdaVar4.zzb, zzdcVar3.zza).exists()) {
                                                    zza.zza("Found verify task for session %s with pack %s and slice %s.", Integer.valueOf(zzdbVar2.zza), zzdbVar2.zzc.zza, zzdcVar3.zza);
                                                    int i4 = zzdbVar2.zza;
                                                    zzda zzdaVar10 = zzdbVar2.zzc;
                                                    zzefVar = new zzeq(i4, zzdaVar10.zza, zzdbVar2.zzb, zzdaVar10.zzb, zzdcVar3.zza, zzdcVar3.zzb, zzdcVar3.zzc);
                                                    break loop5;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (zzefVar == null) {
                                    it4 = arrayList.iterator();
                                    loop7: while (true) {
                                        if (it4.hasNext()) {
                                            zzceVar = null;
                                            break;
                                        }
                                        zzdbVar = (zzdb) it4.next();
                                        zzdaVar2 = zzdbVar.zzc;
                                        if (zzbg.zzb(zzdaVar2.zzd)) {
                                            it6 = zzdaVar2.zzf.iterator();
                                            while (it6.hasNext()) {
                                                zzdcVar = (zzdc) it6.next();
                                                if (!zzc(zzdcVar)) {
                                                    zzbh zzbhVar4 = this.zzc;
                                                    zzda zzdaVar11 = zzdbVar.zzc;
                                                    Iterator it8 = it6;
                                                    try {
                                                        iZza = new zzen(zzbhVar4, zzdaVar11.zza, zzdbVar.zzb, zzdaVar11.zzb, zzdcVar.zza).zza();
                                                    } catch (IOException e2) {
                                                        zza.zzb("Slice checkpoint corrupt, restarting extraction. %s", e2);
                                                        iZza = 0;
                                                    }
                                                    if (iZza == -1 && ((zzcz) zzdcVar.zzd.get(iZza)).zza) {
                                                        zza.zza("Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s.", Integer.valueOf(zzdcVar.zze), Integer.valueOf(zzdbVar.zza), zzdbVar.zzc.zza, zzdcVar.zza, Integer.valueOf(iZza));
                                                        InputStream inputStreamZza = this.zzd.zza(zzdbVar.zza, zzdbVar.zzc.zza, zzdcVar.zza, iZza);
                                                        int i5 = zzdbVar.zza;
                                                        zzda zzdaVar12 = zzdbVar.zzc;
                                                        String str2 = zzdaVar12.zza;
                                                        int i6 = zzdbVar.zzb;
                                                        long j = zzdaVar12.zzb;
                                                        String str3 = zzdaVar12.zzc;
                                                        String str4 = zzdcVar.zza;
                                                        int i7 = zzdcVar.zze;
                                                        int size = zzdcVar.zzd.size();
                                                        zzda zzdaVar13 = zzdbVar.zzc;
                                                        zzceVar = new zzce(i5, str2, i6, j, str3, str4, i7, iZza, size, zzdaVar13.zze, zzdaVar13.zzd, inputStreamZza);
                                                        break loop7;
                                                    }
                                                    it6 = it8;
                                                }
                                            }
                                        }
                                    }
                                    if (zzceVar == null) {
                                        it5 = arrayList.iterator();
                                        loop9: while (true) {
                                            if (it5.hasNext()) {
                                                zzefVar = null;
                                                break;
                                            }
                                            zzdb zzdbVar7 = (zzdb) it5.next();
                                            zzdaVar = zzdbVar7.zzc;
                                            if (zzbg.zzb(zzdaVar.zzd)) {
                                                for (zzdc zzdcVar4 : zzdaVar.zzf) {
                                                    if (!zzc(zzdcVar4) && ((zzcz) zzdcVar4.zzd.get(0)).zza && !zzb(zzdbVar7, zzdcVar4)) {
                                                        zza.zza("Found patch slice task using patch format %s for session %s, pack %s, slice %s.", Integer.valueOf(zzdcVar4.zzf), Integer.valueOf(zzdbVar7.zza), zzdbVar7.zzc.zza, zzdcVar4.zza);
                                                        InputStream inputStreamZza2 = this.zzd.zza(zzdbVar7.zza, zzdbVar7.zzc.zza, zzdcVar4.zza, 0);
                                                        int i8 = zzdbVar7.zza;
                                                        String str5 = zzdbVar7.zzc.zza;
                                                        zzefVar = new zzef(i8, str5, this.zzc.zza(str5), this.zzc.zzc(zzdbVar7.zzc.zza), zzdbVar7.zzb, zzdbVar7.zzc.zzb, zzdcVar4.zzf, zzdcVar4.zza, zzdcVar4.zzc, inputStreamZza2);
                                                        break loop9;
                                                    }
                                                }
                                            }
                                        }
                                        if (zzefVar != null) {
                                            this.zzb.zzl();
                                            return null;
                                        }
                                        zzdeVar2 = this.zzb;
                                    } else {
                                        zzdeVar = this.zzb;
                                    }
                                } else {
                                    zzdeVar2 = this.zzb;
                                }
                            } else {
                                zzdeVar2 = this.zzb;
                            }
                        } else {
                            zzdeVar2 = this.zzb;
                        }
                    } else {
                        zzdeVar2 = this.zzb;
                    }
                } else {
                    it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            zzefVar = null;
                            break;
                        }
                        zzdbVar4 = (zzdb) it.next();
                        zzbhVar3 = this.zzc;
                        zzdaVar7 = zzdbVar4.zzc;
                        if (zzbhVar3.zzb(zzdaVar7.zza, zzdbVar4.zzb, zzdaVar7.zzb) == zzdbVar4.zzc.zzf.size()) {
                            zza.zza("Found final move task for session %s with pack %s.", Integer.valueOf(zzdbVar4.zza), zzdbVar4.zzc.zza);
                            int i9 = zzdbVar4.zza;
                            zzda zzdaVar14 = zzdbVar4.zzc;
                            zzefVar = new zzdw(i9, zzdaVar14.zza, zzdbVar4.zzb, zzdaVar14.zzb, zzdaVar14.zzc);
                            break;
                        }
                    }
                    if (zzefVar == null) {
                        it2 = arrayList.iterator();
                        loop3: while (true) {
                            if (it2.hasNext()) {
                                zzefVar = null;
                                break;
                            }
                            zzdbVar3 = (zzdb) it2.next();
                            zzdaVar5 = zzdbVar3.zzc;
                            if (zzbg.zzb(zzdaVar5.zzd)) {
                                while (r9.hasNext()) {
                                    zzbhVar2 = this.zzc;
                                    zzdaVar6 = zzdbVar3.zzc;
                                    if (zzbhVar2.zzq(zzdaVar6.zza, zzdbVar3.zzb, zzdaVar6.zzb, zzdcVar2.zza).exists()) {
                                        zza.zza("Found merge task for session %s with pack %s and slice %s.", Integer.valueOf(zzdbVar3.zza), zzdbVar3.zzc.zza, zzdcVar2.zza);
                                        int i10 = zzdbVar3.zza;
                                        zzda zzdaVar15 = zzdbVar3.zzc;
                                        zzefVar = new zzdt(i10, zzdaVar15.zza, zzdbVar3.zzb, zzdaVar15.zzb, zzdcVar2.zza);
                                        break loop3;
                                    }
                                }
                            }
                        }
                        if (zzefVar == null) {
                            it3 = arrayList.iterator();
                            loop5: while (true) {
                                if (it3.hasNext()) {
                                    zzefVar = null;
                                    break;
                                }
                                zzdbVar2 = (zzdb) it3.next();
                                zzdaVar3 = zzdbVar2.zzc;
                                if (zzbg.zzb(zzdaVar3.zzd)) {
                                    while (r4.hasNext()) {
                                        if (zzb(zzdbVar2, zzdcVar3)) {
                                            zzbhVar = this.zzc;
                                            zzdaVar4 = zzdbVar2.zzc;
                                            if (zzbhVar.zzp(zzdaVar4.zza, zzdbVar2.zzb, zzdaVar4.zzb, zzdcVar3.zza).exists()) {
                                                zza.zza("Found verify task for session %s with pack %s and slice %s.", Integer.valueOf(zzdbVar2.zza), zzdbVar2.zzc.zza, zzdcVar3.zza);
                                                int i11 = zzdbVar2.zza;
                                                zzda zzdaVar16 = zzdbVar2.zzc;
                                                zzefVar = new zzeq(i11, zzdaVar16.zza, zzdbVar2.zzb, zzdaVar16.zzb, zzdcVar3.zza, zzdcVar3.zzb, zzdcVar3.zzc);
                                                break loop5;
                                            }
                                        }
                                    }
                                }
                            }
                            if (zzefVar == null) {
                                it4 = arrayList.iterator();
                                loop7: while (true) {
                                    if (it4.hasNext()) {
                                        zzceVar = null;
                                        break;
                                    }
                                    zzdbVar = (zzdb) it4.next();
                                    zzdaVar2 = zzdbVar.zzc;
                                    if (zzbg.zzb(zzdaVar2.zzd)) {
                                        it6 = zzdaVar2.zzf.iterator();
                                        while (it6.hasNext()) {
                                            zzdcVar = (zzdc) it6.next();
                                            if (!zzc(zzdcVar)) {
                                                zzbh zzbhVar5 = this.zzc;
                                                zzda zzdaVar17 = zzdbVar.zzc;
                                                Iterator it9 = it6;
                                                iZza = new zzen(zzbhVar5, zzdaVar17.zza, zzdbVar.zzb, zzdaVar17.zzb, zzdcVar.zza).zza();
                                                if (iZza == -1) {
                                                }
                                                it6 = it9;
                                            }
                                        }
                                    }
                                }
                                if (zzceVar == null) {
                                    it5 = arrayList.iterator();
                                    loop9: while (true) {
                                        if (it5.hasNext()) {
                                            zzefVar = null;
                                            break;
                                        }
                                        zzdb zzdbVar8 = (zzdb) it5.next();
                                        zzdaVar = zzdbVar8.zzc;
                                        if (zzbg.zzb(zzdaVar.zzd)) {
                                            while (r3.hasNext()) {
                                                if (!zzc(zzdcVar4)) {
                                                }
                                            }
                                        }
                                    }
                                    if (zzefVar != null) {
                                        this.zzb.zzl();
                                        return null;
                                    }
                                    zzdeVar2 = this.zzb;
                                } else {
                                    zzdeVar = this.zzb;
                                }
                            } else {
                                zzdeVar2 = this.zzb;
                            }
                        } else {
                            zzdeVar2 = this.zzb;
                        }
                    } else {
                        zzdeVar2 = this.zzb;
                    }
                }
                zzdeVar2.zzl();
                return zzefVar;
            }
            zzdeVar = this.zzb;
            zzdeVar.zzl();
            return zzceVar;
        } catch (Throwable th) {
            this.zzb.zzl();
            throw th;
        }
    }
}
