package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgq implements Callable {
    final /* synthetic */ zzau zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgv zzc;

    zzgq(zzgv zzgvVar, zzau zzauVar, String str) {
        this.zzc = zzgvVar;
        this.zza = zzauVar;
        this.zzb = str;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0366 A[Catch: all -> 0x061f, LOOP:2: B:101:0x0360->B:103:0x0366, LOOP_END, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0405 A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x042d A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0460 A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x04af A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x051b A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0531 A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x053c A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0540 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0542 A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x055c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:134:0x059f A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x02a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x0335 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x04c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x04a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0204 A[Catch: all -> 0x061f, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0243 A[Catch: SecurityException -> 0x0603, all -> 0x061f, TryCatch #0 {SecurityException -> 0x0603, blocks: (B:66:0x023b, B:68:0x0243, B:70:0x0249), top: B:148:0x023b, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x026a A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x028f A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x02a5 A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x02a9 A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x02f3 A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0300 A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0325 A[Catch: all -> 0x061f, TryCatch #3 {all -> 0x061f, blocks: (B:11:0x007e, B:13:0x008a, B:16:0x00a6, B:18:0x00ac, B:20:0x00c0, B:22:0x00d7, B:23:0x00de, B:25:0x00e8, B:26:0x00f5, B:28:0x00ff, B:29:0x010c, B:31:0x0117, B:32:0x011f, B:34:0x013b, B:38:0x0148, B:40:0x0159, B:41:0x0160, B:43:0x0175, B:45:0x0185, B:47:0x018d, B:49:0x0193, B:50:0x0196, B:52:0x01a5, B:54:0x01ab, B:56:0x01bf, B:58:0x01c9, B:59:0x01da, B:61:0x01de, B:63:0x01eb, B:65:0x0204, B:66:0x023b, B:68:0x0243, B:70:0x0249, B:71:0x0260, B:73:0x026a, B:74:0x0277, B:75:0x0289, B:77:0x028f, B:83:0x02a5, B:86:0x02d0, B:88:0x02f3, B:90:0x0300, B:92:0x030c, B:93:0x031f, B:95:0x0325, B:97:0x0335, B:99:0x033b, B:100:0x0359, B:101:0x0360, B:103:0x0366, B:104:0x039e, B:106:0x0405, B:107:0x041f, B:109:0x042d, B:111:0x0474, B:112:0x04a9, B:114:0x04af, B:116:0x04c2, B:117:0x04cf, B:119:0x051b, B:120:0x0529, B:122:0x0531, B:123:0x0534, B:125:0x053c, B:128:0x0545, B:131:0x055e, B:132:0x0561, B:134:0x059f, B:135:0x05a8, B:127:0x0542, B:110:0x0460, B:85:0x02a9, B:142:0x0604, B:35:0x013f, B:37:0x0145), top: B:154:0x007e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0339 A[LOOP:1: B:93:0x031f->B:98:0x0339, LOOP_END] */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        byte[] bArr;
        zzlh zzlhVar;
        String strZzv;
        List listZzu;
        Iterator it;
        zzlm zzlmVar;
        zzlj zzljVarZzu;
        com.google.android.gms.internal.measurement.zzgm[] zzgmVarArr;
        int i;
        Bundle bundle;
        zzaq zzaqVarZzn;
        String str;
        zzaq zzaqVarZzc;
        long j;
        zzap zzapVar;
        com.google.android.gms.internal.measurement.zzfs zzfsVarZze;
        zzar zzarVar;
        long jZzn;
        long jZzp;
        String strZzD;
        com.google.android.gms.internal.measurement.zzfw zzfwVarZze;
        Object objZzf;
        String strZzv2;
        Iterator it2;
        this.zzc.zza.zzA();
        zzip zzipVarZzr = this.zzc.zza.zzr();
        zzau zzauVar = this.zza;
        String str2 = this.zzb;
        zzipVarZzr.zzg();
        zzgd.zzO();
        Preconditions.checkNotNull(zzauVar);
        Preconditions.checkNotEmpty(str2);
        if (!zzipVarZzr.zzt.zzf().zzs(str2, zzeg.zzU)) {
            zzipVarZzr.zzt.zzaA().zzc().zzb("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        }
        if (!"_iap".equals(zzauVar.zza) && !"_iapx".equals(zzauVar.zza)) {
            zzipVarZzr.zzt.zzaA().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str2, zzauVar.zza);
            return null;
        }
        com.google.android.gms.internal.measurement.zzga zzgaVarZza = com.google.android.gms.internal.measurement.zzgb.zza();
        zzipVarZzr.zzf.zzh().zzw();
        try {
            zzh zzhVarZzj = zzipVarZzr.zzf.zzh().zzj(str2);
            if (zzhVarZzj == null) {
                zzipVarZzr.zzt.zzaA().zzc().zzb("Log and bundle not available. package_name", str2);
                bArr = new byte[0];
                zzlhVar = zzipVarZzr.zzf;
            } else if (zzhVarZzj.zzan()) {
                com.google.android.gms.internal.measurement.zzgc zzgcVarZzu = com.google.android.gms.internal.measurement.zzgd.zzu();
                zzgcVarZzu.zzad(1);
                zzgcVarZzu.zzZ("android");
                if (!TextUtils.isEmpty(zzhVarZzj.zzv())) {
                    zzgcVarZzu.zzD(zzhVarZzj.zzv());
                }
                if (!TextUtils.isEmpty(zzhVarZzj.zzx())) {
                    zzgcVarZzu.zzF((String) Preconditions.checkNotNull(zzhVarZzj.zzx()));
                }
                if (!TextUtils.isEmpty(zzhVarZzj.zzy())) {
                    zzgcVarZzu.zzG((String) Preconditions.checkNotNull(zzhVarZzj.zzy()));
                }
                if (zzhVarZzj.zzb() != -2147483648L) {
                    zzgcVarZzu.zzH((int) zzhVarZzj.zzb());
                }
                zzgcVarZzu.zzV(zzhVarZzj.zzm());
                zzgcVarZzu.zzP(zzhVarZzj.zzk());
                String strZzA = zzhVarZzj.zzA();
                String strZzt = zzhVarZzj.zzt();
                if (!TextUtils.isEmpty(strZzA)) {
                    zzgcVarZzu.zzU(strZzA);
                } else if (!TextUtils.isEmpty(strZzt)) {
                    zzgcVarZzu.zzC(strZzt);
                }
                zzpz.zzc();
                if (zzipVarZzr.zzt.zzf().zzs(null, zzeg.zzaE)) {
                    zzgcVarZzu.zzaj(zzhVarZzj.zzr());
                }
                zzhb zzhbVarZzq = zzipVarZzr.zzf.zzq(str2);
                zzgcVarZzu.zzM(zzhVarZzj.zzj());
                if (zzipVarZzr.zzt.zzJ() && zzipVarZzr.zzt.zzf().zzt(zzgcVarZzu.zzaq()) && zzhbVarZzq.zzj(zzha.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                    zzgcVarZzu.zzO(null);
                }
                zzgcVarZzu.zzL(zzhbVarZzq.zzi());
                if (zzhbVarZzq.zzj(zzha.AD_STORAGE) && zzhVarZzj.zzam()) {
                    Pair pairZzd = zzipVarZzr.zzf.zzs().zzd(zzhVarZzj.zzv(), zzhbVarZzq);
                    if (!zzhVarZzj.zzam() || TextUtils.isEmpty((CharSequence) pairZzd.first)) {
                        zzipVarZzr.zzt.zzg().zzv();
                        zzgcVarZzu.zzN(Build.MODEL);
                        zzipVarZzr.zzt.zzg().zzv();
                        zzgcVarZzu.zzY(Build.VERSION.RELEASE);
                        zzgcVarZzu.zzak((int) zzipVarZzr.zzt.zzg().zzb());
                        zzgcVarZzu.zzao(zzipVarZzr.zzt.zzg().zzc());
                        if (zzhbVarZzq.zzj(zzha.ANALYTICS_STORAGE)) {
                            zzgcVarZzu.zzE(zzip.zza((String) Preconditions.checkNotNull(zzhVarZzj.zzw()), Long.toString(zzauVar.zzd)));
                        }
                        if (!TextUtils.isEmpty(zzhVarZzj.zzz())) {
                            zzgcVarZzu.zzT((String) Preconditions.checkNotNull(zzhVarZzj.zzz()));
                        }
                        strZzv = zzhVarZzj.zzv();
                        listZzu = zzipVarZzr.zzf.zzh().zzu(strZzv);
                        it = listZzu.iterator();
                        do {
                            if (!it.hasNext()) {
                                zzlmVar = null;
                                break;
                            }
                            zzlmVar = (zzlm) it.next();
                        } while (!"_lte".equals(zzlmVar.zzc));
                        if (zzlmVar != null) {
                            zzlm zzlmVar2 = new zzlm(strZzv, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzipVarZzr.zzt.zzax().currentTimeMillis(), 0L);
                            listZzu.add(zzlmVar2);
                            zzipVarZzr.zzf.zzh().zzL(zzlmVar2);
                        } else {
                            zzlm zzlmVar3 = new zzlm(strZzv, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzipVarZzr.zzt.zzax().currentTimeMillis(), 0L);
                            listZzu.add(zzlmVar3);
                            zzipVarZzr.zzf.zzh().zzL(zzlmVar3);
                        }
                        zzljVarZzu = zzipVarZzr.zzf.zzu();
                        zzljVarZzu.zzt.zzaA().zzj().zza("Checking account type status for ad personalization signals");
                        if (zzljVarZzu.zzt.zzg().zze()) {
                            strZzv2 = zzhVarZzj.zzv();
                            Preconditions.checkNotNull(strZzv2);
                            if (zzhVarZzj.zzam()) {
                                zzljVarZzu.zzt.zzaA().zzc().zza("Turning off ad personalization due to account type");
                                it2 = listZzu.iterator();
                                while (it2.hasNext()) {
                                    if ("_npa".equals(((zzlm) it2.next()).zzc)) {
                                        it2.remove();
                                        break;
                                    }
                                }
                                listZzu.add(new zzlm(strZzv2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_npa", zzljVarZzu.zzt.zzax().currentTimeMillis(), 1L));
                            }
                        }
                        zzgmVarArr = new com.google.android.gms.internal.measurement.zzgm[listZzu.size()];
                        for (i = 0; i < listZzu.size(); i++) {
                            com.google.android.gms.internal.measurement.zzgl zzglVarZzd = com.google.android.gms.internal.measurement.zzgm.zzd();
                            zzglVarZzd.zzf(((zzlm) listZzu.get(i)).zzc);
                            zzglVarZzd.zzg(((zzlm) listZzu.get(i)).zzd);
                            zzipVarZzr.zzf.zzu().zzv(zzglVarZzd, ((zzlm) listZzu.get(i)).zze);
                            zzgmVarArr[i] = (com.google.android.gms.internal.measurement.zzgm) zzglVarZzd.zzaD();
                        }
                        zzgcVarZzu.zzj(Arrays.asList(zzgmVarArr));
                        zzeu zzeuVarZzb = zzeu.zzb(zzauVar);
                        zzipVarZzr.zzt.zzv().zzL(zzeuVarZzb.zzd, zzipVarZzr.zzf.zzh().zzi(str2));
                        zzipVarZzr.zzt.zzv().zzN(zzeuVarZzb, zzipVarZzr.zzt.zzf().zzd(str2));
                        bundle = zzeuVarZzb.zzd;
                        bundle.putLong("_c", 1L);
                        zzipVarZzr.zzt.zzaA().zzc().zza("Marking in-app purchase as real-time");
                        bundle.putLong("_r", 1L);
                        bundle.putString("_o", zzauVar.zzc);
                        if (zzipVarZzr.zzt.zzv().zzaf(zzgcVarZzu.zzaq())) {
                            zzipVarZzr.zzt.zzv().zzP(bundle, "_dbg", 1L);
                            zzipVarZzr.zzt.zzv().zzP(bundle, "_r", 1L);
                        }
                        zzaqVarZzn = zzipVarZzr.zzf.zzh().zzn(str2, zzauVar.zza);
                        if (zzaqVarZzn == null) {
                            str = null;
                            zzaqVarZzc = new zzaq(str2, zzauVar.zza, 0L, 0L, 0L, zzauVar.zzd, 0L, null, null, null, null);
                            j = 0;
                        } else {
                            str = null;
                            long j2 = zzaqVarZzn.zzf;
                            zzaqVarZzc = zzaqVarZzn.zzc(zzauVar.zzd);
                            j = j2;
                        }
                        zzipVarZzr.zzf.zzh().zzE(zzaqVarZzc);
                        zzapVar = new zzap(zzipVarZzr.zzt, zzauVar.zzc, str2, zzauVar.zza, zzauVar.zzd, j, bundle);
                        zzfsVarZze = com.google.android.gms.internal.measurement.zzft.zze();
                        zzfsVarZze.zzm(zzapVar.zzd);
                        zzfsVarZze.zzi(zzapVar.zzb);
                        zzfsVarZze.zzl(zzapVar.zze);
                        zzarVar = new zzar(zzapVar.zzf);
                        while (zzarVar.hasNext()) {
                            String next = zzarVar.next();
                            zzfwVarZze = com.google.android.gms.internal.measurement.zzfx.zze();
                            zzfwVarZze.zzj(next);
                            objZzf = zzapVar.zzf.zzf(next);
                            if (objZzf != null) {
                                zzipVarZzr.zzf.zzu().zzu(zzfwVarZze, objZzf);
                                zzfsVarZze.zze(zzfwVarZze);
                            }
                        }
                        zzgcVarZzu.zzk(zzfsVarZze);
                        com.google.android.gms.internal.measurement.zzge zzgeVarZza = com.google.android.gms.internal.measurement.zzgg.zza();
                        com.google.android.gms.internal.measurement.zzfu zzfuVarZza = com.google.android.gms.internal.measurement.zzfv.zza();
                        zzfuVarZza.zza(zzaqVarZzc.zzc);
                        zzfuVarZza.zzb(zzauVar.zza);
                        zzgeVarZza.zza(zzfuVarZza);
                        zzgcVarZzu.zzaa(zzgeVarZza);
                        zzgcVarZzu.zzf(zzipVarZzr.zzf.zzf().zza(zzhVarZzj.zzv(), Collections.emptyList(), zzgcVarZzu.zzau(), Long.valueOf(zzfsVarZze.zzc()), Long.valueOf(zzfsVarZze.zzc())));
                        if (zzfsVarZze.zzq()) {
                            zzgcVarZzu.zzai(zzfsVarZze.zzc());
                            zzgcVarZzu.zzQ(zzfsVarZze.zzc());
                        }
                        jZzn = zzhVarZzj.zzn();
                        if (jZzn != 0) {
                            zzgcVarZzu.zzab(jZzn);
                        }
                        jZzp = zzhVarZzj.zzp();
                        if (jZzp != 0) {
                            zzgcVarZzu.zzac(jZzp);
                        } else if (jZzn != 0) {
                            zzgcVarZzu.zzac(jZzn);
                        }
                        strZzD = zzhVarZzj.zzD();
                        zzqu.zzc();
                        if (zzipVarZzr.zzt.zzf().zzs(str2, zzeg.zzao)) {
                            zzgcVarZzu.zzah(strZzD);
                        }
                        zzhVarZzj.zzG();
                        zzgcVarZzu.zzI((int) zzhVarZzj.zzo());
                        zzipVarZzr.zzt.zzf().zzh();
                        zzgcVarZzu.zzam(79000L);
                        zzgcVarZzu.zzal(zzipVarZzr.zzt.zzax().currentTimeMillis());
                        zzgcVarZzu.zzag(Boolean.TRUE.booleanValue());
                        if (zzipVarZzr.zzt.zzf().zzs(str, zzeg.zzas)) {
                            zzipVarZzr.zzf.zzC(zzgcVarZzu.zzaq(), zzgcVarZzu);
                        }
                        zzgaVarZza.zza(zzgcVarZzu);
                        zzhVarZzj.zzad(zzgcVarZzu.zzd());
                        zzhVarZzj.zzab(zzgcVarZzu.zzc());
                        zzipVarZzr.zzf.zzh().zzD(zzhVarZzj);
                        zzipVarZzr.zzf.zzh().zzC();
                        zzipVarZzr.zzf.zzh().zzx();
                        return zzipVarZzr.zzf.zzu().zzz(((com.google.android.gms.internal.measurement.zzgb) zzgaVarZza.zzaD()).zzbx());
                    }
                    try {
                        zzgcVarZzu.zzae(zzip.zza((String) pairZzd.first, Long.toString(zzauVar.zzd)));
                        if (pairZzd.second != null) {
                            zzgcVarZzu.zzX(((Boolean) pairZzd.second).booleanValue());
                        }
                        zzipVarZzr.zzt.zzg().zzv();
                        zzgcVarZzu.zzN(Build.MODEL);
                        zzipVarZzr.zzt.zzg().zzv();
                        zzgcVarZzu.zzY(Build.VERSION.RELEASE);
                        zzgcVarZzu.zzak((int) zzipVarZzr.zzt.zzg().zzb());
                        zzgcVarZzu.zzao(zzipVarZzr.zzt.zzg().zzc());
                        if (zzhbVarZzq.zzj(zzha.ANALYTICS_STORAGE)) {
                            zzgcVarZzu.zzE(zzip.zza((String) Preconditions.checkNotNull(zzhVarZzj.zzw()), Long.toString(zzauVar.zzd)));
                        }
                        if (!TextUtils.isEmpty(zzhVarZzj.zzz())) {
                            zzgcVarZzu.zzT((String) Preconditions.checkNotNull(zzhVarZzj.zzz()));
                        }
                        strZzv = zzhVarZzj.zzv();
                        listZzu = zzipVarZzr.zzf.zzh().zzu(strZzv);
                        it = listZzu.iterator();
                        do {
                            if (!it.hasNext()) {
                                zzlmVar = null;
                                break;
                            }
                            zzlmVar = (zzlm) it.next();
                        } while (!"_lte".equals(zzlmVar.zzc));
                        if (zzlmVar != null) {
                            zzlm zzlmVar4 = new zzlm(strZzv, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzipVarZzr.zzt.zzax().currentTimeMillis(), 0L);
                            listZzu.add(zzlmVar4);
                            zzipVarZzr.zzf.zzh().zzL(zzlmVar4);
                        } else {
                            zzlm zzlmVar5 = new zzlm(strZzv, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzipVarZzr.zzt.zzax().currentTimeMillis(), 0L);
                            listZzu.add(zzlmVar5);
                            zzipVarZzr.zzf.zzh().zzL(zzlmVar5);
                        }
                        zzljVarZzu = zzipVarZzr.zzf.zzu();
                        zzljVarZzu.zzt.zzaA().zzj().zza("Checking account type status for ad personalization signals");
                        if (zzljVarZzu.zzt.zzg().zze()) {
                            strZzv2 = zzhVarZzj.zzv();
                            Preconditions.checkNotNull(strZzv2);
                            if (zzhVarZzj.zzam()) {
                                zzljVarZzu.zzt.zzaA().zzc().zza("Turning off ad personalization due to account type");
                                it2 = listZzu.iterator();
                                while (it2.hasNext()) {
                                    if ("_npa".equals(((zzlm) it2.next()).zzc)) {
                                        it2.remove();
                                        break;
                                    }
                                }
                                listZzu.add(new zzlm(strZzv2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_npa", zzljVarZzu.zzt.zzax().currentTimeMillis(), 1L));
                            }
                        }
                        zzgmVarArr = new com.google.android.gms.internal.measurement.zzgm[listZzu.size()];
                        while (i < listZzu.size()) {
                            com.google.android.gms.internal.measurement.zzgl zzglVarZzd2 = com.google.android.gms.internal.measurement.zzgm.zzd();
                            zzglVarZzd2.zzf(((zzlm) listZzu.get(i)).zzc);
                            zzglVarZzd2.zzg(((zzlm) listZzu.get(i)).zzd);
                            zzipVarZzr.zzf.zzu().zzv(zzglVarZzd2, ((zzlm) listZzu.get(i)).zze);
                            zzgmVarArr[i] = (com.google.android.gms.internal.measurement.zzgm) zzglVarZzd2.zzaD();
                        }
                        zzgcVarZzu.zzj(Arrays.asList(zzgmVarArr));
                        zzeu zzeuVarZzb2 = zzeu.zzb(zzauVar);
                        zzipVarZzr.zzt.zzv().zzL(zzeuVarZzb2.zzd, zzipVarZzr.zzf.zzh().zzi(str2));
                        zzipVarZzr.zzt.zzv().zzN(zzeuVarZzb2, zzipVarZzr.zzt.zzf().zzd(str2));
                        bundle = zzeuVarZzb2.zzd;
                        bundle.putLong("_c", 1L);
                        zzipVarZzr.zzt.zzaA().zzc().zza("Marking in-app purchase as real-time");
                        bundle.putLong("_r", 1L);
                        bundle.putString("_o", zzauVar.zzc);
                        if (zzipVarZzr.zzt.zzv().zzaf(zzgcVarZzu.zzaq())) {
                            zzipVarZzr.zzt.zzv().zzP(bundle, "_dbg", 1L);
                            zzipVarZzr.zzt.zzv().zzP(bundle, "_r", 1L);
                        }
                        zzaqVarZzn = zzipVarZzr.zzf.zzh().zzn(str2, zzauVar.zza);
                        if (zzaqVarZzn == null) {
                            str = null;
                            zzaqVarZzc = new zzaq(str2, zzauVar.zza, 0L, 0L, 0L, zzauVar.zzd, 0L, null, null, null, null);
                            j = 0;
                        } else {
                            str = null;
                            long j3 = zzaqVarZzn.zzf;
                            zzaqVarZzc = zzaqVarZzn.zzc(zzauVar.zzd);
                            j = j3;
                        }
                        zzipVarZzr.zzf.zzh().zzE(zzaqVarZzc);
                        zzapVar = new zzap(zzipVarZzr.zzt, zzauVar.zzc, str2, zzauVar.zza, zzauVar.zzd, j, bundle);
                        zzfsVarZze = com.google.android.gms.internal.measurement.zzft.zze();
                        zzfsVarZze.zzm(zzapVar.zzd);
                        zzfsVarZze.zzi(zzapVar.zzb);
                        zzfsVarZze.zzl(zzapVar.zze);
                        zzarVar = new zzar(zzapVar.zzf);
                        while (zzarVar.hasNext()) {
                            String next2 = zzarVar.next();
                            zzfwVarZze = com.google.android.gms.internal.measurement.zzfx.zze();
                            zzfwVarZze.zzj(next2);
                            objZzf = zzapVar.zzf.zzf(next2);
                            if (objZzf != null) {
                                zzipVarZzr.zzf.zzu().zzu(zzfwVarZze, objZzf);
                                zzfsVarZze.zze(zzfwVarZze);
                            }
                        }
                        zzgcVarZzu.zzk(zzfsVarZze);
                        com.google.android.gms.internal.measurement.zzge zzgeVarZza2 = com.google.android.gms.internal.measurement.zzgg.zza();
                        com.google.android.gms.internal.measurement.zzfu zzfuVarZza2 = com.google.android.gms.internal.measurement.zzfv.zza();
                        zzfuVarZza2.zza(zzaqVarZzc.zzc);
                        zzfuVarZza2.zzb(zzauVar.zza);
                        zzgeVarZza2.zza(zzfuVarZza2);
                        zzgcVarZzu.zzaa(zzgeVarZza2);
                        zzgcVarZzu.zzf(zzipVarZzr.zzf.zzf().zza(zzhVarZzj.zzv(), Collections.emptyList(), zzgcVarZzu.zzau(), Long.valueOf(zzfsVarZze.zzc()), Long.valueOf(zzfsVarZze.zzc())));
                        if (zzfsVarZze.zzq()) {
                            zzgcVarZzu.zzai(zzfsVarZze.zzc());
                            zzgcVarZzu.zzQ(zzfsVarZze.zzc());
                        }
                        jZzn = zzhVarZzj.zzn();
                        if (jZzn != 0) {
                            zzgcVarZzu.zzab(jZzn);
                        }
                        jZzp = zzhVarZzj.zzp();
                        if (jZzp != 0) {
                            zzgcVarZzu.zzac(jZzp);
                        } else if (jZzn != 0) {
                            zzgcVarZzu.zzac(jZzn);
                        }
                        strZzD = zzhVarZzj.zzD();
                        zzqu.zzc();
                        if (zzipVarZzr.zzt.zzf().zzs(str2, zzeg.zzao)) {
                            zzgcVarZzu.zzah(strZzD);
                        }
                        zzhVarZzj.zzG();
                        zzgcVarZzu.zzI((int) zzhVarZzj.zzo());
                        zzipVarZzr.zzt.zzf().zzh();
                        zzgcVarZzu.zzam(79000L);
                        zzgcVarZzu.zzal(zzipVarZzr.zzt.zzax().currentTimeMillis());
                        zzgcVarZzu.zzag(Boolean.TRUE.booleanValue());
                        if (zzipVarZzr.zzt.zzf().zzs(str, zzeg.zzas)) {
                            zzipVarZzr.zzf.zzC(zzgcVarZzu.zzaq(), zzgcVarZzu);
                        }
                        zzgaVarZza.zza(zzgcVarZzu);
                        zzhVarZzj.zzad(zzgcVarZzu.zzd());
                        zzhVarZzj.zzab(zzgcVarZzu.zzc());
                        zzipVarZzr.zzf.zzh().zzD(zzhVarZzj);
                        zzipVarZzr.zzf.zzh().zzC();
                        zzipVarZzr.zzf.zzh().zzx();
                        return zzipVarZzr.zzf.zzu().zzz(((com.google.android.gms.internal.measurement.zzgb) zzgaVarZza.zzaD()).zzbx());
                    } catch (SecurityException e) {
                        zzipVarZzr.zzt.zzaA().zzc().zzb("Resettable device id encryption failed", e.getMessage());
                        bArr = new byte[0];
                        zzlhVar = zzipVarZzr.zzf;
                    }
                } else {
                    zzipVarZzr.zzt.zzg().zzv();
                    zzgcVarZzu.zzN(Build.MODEL);
                    zzipVarZzr.zzt.zzg().zzv();
                    zzgcVarZzu.zzY(Build.VERSION.RELEASE);
                    zzgcVarZzu.zzak((int) zzipVarZzr.zzt.zzg().zzb());
                    zzgcVarZzu.zzao(zzipVarZzr.zzt.zzg().zzc());
                    try {
                        if (zzhbVarZzq.zzj(zzha.ANALYTICS_STORAGE) && zzhVarZzj.zzw() != null) {
                            zzgcVarZzu.zzE(zzip.zza((String) Preconditions.checkNotNull(zzhVarZzj.zzw()), Long.toString(zzauVar.zzd)));
                        }
                        if (!TextUtils.isEmpty(zzhVarZzj.zzz())) {
                            zzgcVarZzu.zzT((String) Preconditions.checkNotNull(zzhVarZzj.zzz()));
                        }
                        strZzv = zzhVarZzj.zzv();
                        listZzu = zzipVarZzr.zzf.zzh().zzu(strZzv);
                        it = listZzu.iterator();
                        do {
                            if (!it.hasNext()) {
                                zzlmVar = null;
                                break;
                            }
                            zzlmVar = (zzlm) it.next();
                        } while (!"_lte".equals(zzlmVar.zzc));
                        if (zzlmVar != null || zzlmVar.zze == null) {
                            zzlm zzlmVar6 = new zzlm(strZzv, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzipVarZzr.zzt.zzax().currentTimeMillis(), 0L);
                            listZzu.add(zzlmVar6);
                            zzipVarZzr.zzf.zzh().zzL(zzlmVar6);
                        }
                        zzljVarZzu = zzipVarZzr.zzf.zzu();
                        zzljVarZzu.zzt.zzaA().zzj().zza("Checking account type status for ad personalization signals");
                        if (zzljVarZzu.zzt.zzg().zze()) {
                            strZzv2 = zzhVarZzj.zzv();
                            Preconditions.checkNotNull(strZzv2);
                            if (zzhVarZzj.zzam() && zzljVarZzu.zzf.zzm().zzn(strZzv2)) {
                                zzljVarZzu.zzt.zzaA().zzc().zza("Turning off ad personalization due to account type");
                                it2 = listZzu.iterator();
                                while (it2.hasNext()) {
                                    if ("_npa".equals(((zzlm) it2.next()).zzc)) {
                                        it2.remove();
                                        break;
                                    }
                                }
                                listZzu.add(new zzlm(strZzv2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_npa", zzljVarZzu.zzt.zzax().currentTimeMillis(), 1L));
                            }
                        }
                        zzgmVarArr = new com.google.android.gms.internal.measurement.zzgm[listZzu.size()];
                        while (i < listZzu.size()) {
                            com.google.android.gms.internal.measurement.zzgl zzglVarZzd3 = com.google.android.gms.internal.measurement.zzgm.zzd();
                            zzglVarZzd3.zzf(((zzlm) listZzu.get(i)).zzc);
                            zzglVarZzd3.zzg(((zzlm) listZzu.get(i)).zzd);
                            zzipVarZzr.zzf.zzu().zzv(zzglVarZzd3, ((zzlm) listZzu.get(i)).zze);
                            zzgmVarArr[i] = (com.google.android.gms.internal.measurement.zzgm) zzglVarZzd3.zzaD();
                        }
                        zzgcVarZzu.zzj(Arrays.asList(zzgmVarArr));
                        zzeu zzeuVarZzb3 = zzeu.zzb(zzauVar);
                        zzipVarZzr.zzt.zzv().zzL(zzeuVarZzb3.zzd, zzipVarZzr.zzf.zzh().zzi(str2));
                        zzipVarZzr.zzt.zzv().zzN(zzeuVarZzb3, zzipVarZzr.zzt.zzf().zzd(str2));
                        bundle = zzeuVarZzb3.zzd;
                        bundle.putLong("_c", 1L);
                        zzipVarZzr.zzt.zzaA().zzc().zza("Marking in-app purchase as real-time");
                        bundle.putLong("_r", 1L);
                        bundle.putString("_o", zzauVar.zzc);
                        if (zzipVarZzr.zzt.zzv().zzaf(zzgcVarZzu.zzaq())) {
                            zzipVarZzr.zzt.zzv().zzP(bundle, "_dbg", 1L);
                            zzipVarZzr.zzt.zzv().zzP(bundle, "_r", 1L);
                        }
                        zzaqVarZzn = zzipVarZzr.zzf.zzh().zzn(str2, zzauVar.zza);
                        if (zzaqVarZzn == null) {
                            str = null;
                            zzaqVarZzc = new zzaq(str2, zzauVar.zza, 0L, 0L, 0L, zzauVar.zzd, 0L, null, null, null, null);
                            j = 0;
                        } else {
                            str = null;
                            long j4 = zzaqVarZzn.zzf;
                            zzaqVarZzc = zzaqVarZzn.zzc(zzauVar.zzd);
                            j = j4;
                        }
                        zzipVarZzr.zzf.zzh().zzE(zzaqVarZzc);
                        zzapVar = new zzap(zzipVarZzr.zzt, zzauVar.zzc, str2, zzauVar.zza, zzauVar.zzd, j, bundle);
                        zzfsVarZze = com.google.android.gms.internal.measurement.zzft.zze();
                        zzfsVarZze.zzm(zzapVar.zzd);
                        zzfsVarZze.zzi(zzapVar.zzb);
                        zzfsVarZze.zzl(zzapVar.zze);
                        zzarVar = new zzar(zzapVar.zzf);
                        while (zzarVar.hasNext()) {
                            String next3 = zzarVar.next();
                            zzfwVarZze = com.google.android.gms.internal.measurement.zzfx.zze();
                            zzfwVarZze.zzj(next3);
                            objZzf = zzapVar.zzf.zzf(next3);
                            if (objZzf != null) {
                                zzipVarZzr.zzf.zzu().zzu(zzfwVarZze, objZzf);
                                zzfsVarZze.zze(zzfwVarZze);
                            }
                        }
                        zzgcVarZzu.zzk(zzfsVarZze);
                        com.google.android.gms.internal.measurement.zzge zzgeVarZza3 = com.google.android.gms.internal.measurement.zzgg.zza();
                        com.google.android.gms.internal.measurement.zzfu zzfuVarZza3 = com.google.android.gms.internal.measurement.zzfv.zza();
                        zzfuVarZza3.zza(zzaqVarZzc.zzc);
                        zzfuVarZza3.zzb(zzauVar.zza);
                        zzgeVarZza3.zza(zzfuVarZza3);
                        zzgcVarZzu.zzaa(zzgeVarZza3);
                        zzgcVarZzu.zzf(zzipVarZzr.zzf.zzf().zza(zzhVarZzj.zzv(), Collections.emptyList(), zzgcVarZzu.zzau(), Long.valueOf(zzfsVarZze.zzc()), Long.valueOf(zzfsVarZze.zzc())));
                        if (zzfsVarZze.zzq()) {
                            zzgcVarZzu.zzai(zzfsVarZze.zzc());
                            zzgcVarZzu.zzQ(zzfsVarZze.zzc());
                        }
                        jZzn = zzhVarZzj.zzn();
                        if (jZzn != 0) {
                            zzgcVarZzu.zzab(jZzn);
                        }
                        jZzp = zzhVarZzj.zzp();
                        if (jZzp != 0) {
                            zzgcVarZzu.zzac(jZzp);
                        } else if (jZzn != 0) {
                            zzgcVarZzu.zzac(jZzn);
                        }
                        strZzD = zzhVarZzj.zzD();
                        zzqu.zzc();
                        if (zzipVarZzr.zzt.zzf().zzs(str2, zzeg.zzao) && strZzD != null) {
                            zzgcVarZzu.zzah(strZzD);
                        }
                        zzhVarZzj.zzG();
                        zzgcVarZzu.zzI((int) zzhVarZzj.zzo());
                        zzipVarZzr.zzt.zzf().zzh();
                        zzgcVarZzu.zzam(79000L);
                        zzgcVarZzu.zzal(zzipVarZzr.zzt.zzax().currentTimeMillis());
                        zzgcVarZzu.zzag(Boolean.TRUE.booleanValue());
                        if (zzipVarZzr.zzt.zzf().zzs(str, zzeg.zzas)) {
                            zzipVarZzr.zzf.zzC(zzgcVarZzu.zzaq(), zzgcVarZzu);
                        }
                        zzgaVarZza.zza(zzgcVarZzu);
                        zzhVarZzj.zzad(zzgcVarZzu.zzd());
                        zzhVarZzj.zzab(zzgcVarZzu.zzc());
                        zzipVarZzr.zzf.zzh().zzD(zzhVarZzj);
                        zzipVarZzr.zzf.zzh().zzC();
                        zzipVarZzr.zzf.zzh().zzx();
                        try {
                            return zzipVarZzr.zzf.zzu().zzz(((com.google.android.gms.internal.measurement.zzgb) zzgaVarZza.zzaD()).zzbx());
                        } catch (IOException e2) {
                            zzipVarZzr.zzt.zzaA().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzet.zzn(str2), e2);
                            return str;
                        }
                    } catch (SecurityException e3) {
                        zzipVarZzr.zzt.zzaA().zzc().zzb("app instance id encryption failed", e3.getMessage());
                        bArr = new byte[0];
                        zzlhVar = zzipVarZzr.zzf;
                    }
                }
            } else {
                zzipVarZzr.zzt.zzaA().zzc().zzb("Log and bundle disabled. package_name", str2);
                bArr = new byte[0];
                zzlhVar = zzipVarZzr.zzf;
            }
            zzlhVar.zzh().zzx();
            return bArr;
        } catch (Throwable th) {
            zzipVarZzr.zzf.zzh().zzx();
            throw th;
        }
    }
}
