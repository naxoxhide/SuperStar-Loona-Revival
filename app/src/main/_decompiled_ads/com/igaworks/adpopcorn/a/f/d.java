package com.igaworks.adpopcorn.a.f;

import android.content.Context;
import androidx.webkit.ProxyConfig;
import com.adxcorp.util.ADXLogUtil;
import com.google.common.net.HttpHeaders;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.j;
import com.igaworks.adpopcorn.cores.model.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    /* JADX WARN: Code duplicated, block: B:115:0x01ec A[Catch: Exception -> 0x0210, TRY_LEAVE, TryCatch #10 {Exception -> 0x0210, blocks: (B:100:0x01c5, B:102:0x01cb, B:104:0x01d1, B:106:0x01d7, B:108:0x01dd, B:110:0x01e5, B:113:0x01e9, B:115:0x01ec), top: B:796:0x01c5 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x026e A[Catch: Exception -> 0x0288, TRY_LEAVE, TryCatch #22 {Exception -> 0x0288, blocks: (B:40:0x00de, B:42:0x00e4, B:44:0x00ee, B:45:0x0103, B:47:0x0109, B:49:0x011a, B:51:0x0120, B:53:0x012c, B:55:0x0132, B:57:0x0138, B:58:0x013f, B:60:0x0145, B:62:0x014b, B:63:0x0154, B:65:0x015a, B:67:0x0160, B:125:0x0210, B:127:0x0216, B:129:0x021c, B:130:0x0223, B:132:0x0229, B:134:0x022f, B:135:0x0236, B:137:0x023e, B:139:0x0246, B:140:0x024f, B:142:0x0257, B:144:0x025f, B:145:0x0268, B:147:0x026e, B:157:0x02a6, B:159:0x02ac, B:161:0x02b6, B:163:0x02c1, B:166:0x02ca, B:168:0x02d0, B:170:0x02df, B:172:0x02e5, B:174:0x02f1, B:176:0x02f9, B:178:0x0301, B:179:0x030a, B:181:0x0310, B:183:0x0316, B:184:0x031d, B:186:0x0325, B:188:0x032d, B:189:0x0336, B:191:0x033c, B:193:0x0342, B:194:0x0349, B:196:0x034f, B:198:0x0355, B:199:0x035d, B:201:0x0365, B:203:0x036b, B:205:0x037d, B:207:0x0385, B:209:0x038d, B:210:0x0396, B:212:0x039e, B:214:0x03a6, B:285:0x0499, B:287:0x049f, B:289:0x04a5, B:290:0x04ac, B:292:0x04b2, B:294:0x04b8, B:295:0x04c6, B:297:0x04ce, B:299:0x04d6, B:300:0x04df, B:302:0x04e7, B:304:0x04ef, B:305:0x0501, B:307:0x0509, B:309:0x0511, B:310:0x051a, B:312:0x0522, B:314:0x052a, B:315:0x0533, B:317:0x053b, B:319:0x0543, B:320:0x054c, B:322:0x0554, B:324:0x055c, B:326:0x056f, B:328:0x0577, B:329:0x0580, B:331:0x0588, B:333:0x0590, B:334:0x0599, B:336:0x05a1, B:338:0x05a9, B:339:0x05b2, B:341:0x05ba, B:343:0x05c2, B:344:0x05cb, B:346:0x05d3, B:348:0x05db, B:349:0x05e4, B:351:0x05ec, B:353:0x05f4, B:354:0x05fd, B:356:0x0605, B:358:0x060d, B:359:0x0616, B:361:0x061e, B:363:0x0626, B:364:0x062f, B:366:0x0637, B:368:0x063f, B:369:0x0648, B:371:0x0650, B:373:0x0658, B:406:0x06f4, B:408:0x06fb, B:412:0x0704), top: B:820:0x00de }] */
    /* JADX WARN: Code duplicated, block: B:152:0x028e  */
    /* JADX WARN: Code duplicated, block: B:284:0x0497  */
    /* JADX WARN: Code duplicated, block: B:386:0x069a A[Catch: Exception -> 0x06b7, TryCatch #28 {Exception -> 0x06b7, blocks: (B:374:0x0661, B:376:0x0669, B:378:0x0671, B:380:0x0679, B:382:0x067f, B:383:0x068a, B:385:0x0690, B:391:0x06b4, B:386:0x069a, B:388:0x06a7, B:390:0x06b1, B:389:0x06af), top: B:832:0x0661 }] */
    /* JADX WARN: Code duplicated, block: B:388:0x06a7 A[Catch: Exception -> 0x06b7, TryCatch #28 {Exception -> 0x06b7, blocks: (B:374:0x0661, B:376:0x0669, B:378:0x0671, B:380:0x0679, B:382:0x067f, B:383:0x068a, B:385:0x0690, B:391:0x06b4, B:386:0x069a, B:388:0x06a7, B:390:0x06b1, B:389:0x06af), top: B:832:0x0661 }] */
    /* JADX WARN: Code duplicated, block: B:389:0x06af A[Catch: Exception -> 0x06b7, TryCatch #28 {Exception -> 0x06b7, blocks: (B:374:0x0661, B:376:0x0669, B:378:0x0671, B:380:0x0679, B:382:0x067f, B:383:0x068a, B:385:0x0690, B:391:0x06b4, B:386:0x069a, B:388:0x06a7, B:390:0x06b1, B:389:0x06af), top: B:832:0x0661 }] */
    /* JADX WARN: Code duplicated, block: B:394:0x06bf A[Catch: Exception -> 0x06f3, TryCatch #1 {Exception -> 0x06f3, blocks: (B:392:0x06b7, B:394:0x06bf, B:396:0x06c7, B:398:0x06cf, B:400:0x06d5, B:401:0x06e0, B:403:0x06e6, B:404:0x06f0), top: B:778:0x06b7 }] */
    /* JADX WARN: Code duplicated, block: B:403:0x06e6 A[Catch: Exception -> 0x06f3, LOOP:4: B:401:0x06e0->B:403:0x06e6, LOOP_END, TryCatch #1 {Exception -> 0x06f3, blocks: (B:392:0x06b7, B:394:0x06bf, B:396:0x06c7, B:398:0x06cf, B:400:0x06d5, B:401:0x06e0, B:403:0x06e6, B:404:0x06f0), top: B:778:0x06b7 }] */
    /* JADX WARN: Code duplicated, block: B:408:0x06fb A[Catch: Exception -> 0x0288, TryCatch #22 {Exception -> 0x0288, blocks: (B:40:0x00de, B:42:0x00e4, B:44:0x00ee, B:45:0x0103, B:47:0x0109, B:49:0x011a, B:51:0x0120, B:53:0x012c, B:55:0x0132, B:57:0x0138, B:58:0x013f, B:60:0x0145, B:62:0x014b, B:63:0x0154, B:65:0x015a, B:67:0x0160, B:125:0x0210, B:127:0x0216, B:129:0x021c, B:130:0x0223, B:132:0x0229, B:134:0x022f, B:135:0x0236, B:137:0x023e, B:139:0x0246, B:140:0x024f, B:142:0x0257, B:144:0x025f, B:145:0x0268, B:147:0x026e, B:157:0x02a6, B:159:0x02ac, B:161:0x02b6, B:163:0x02c1, B:166:0x02ca, B:168:0x02d0, B:170:0x02df, B:172:0x02e5, B:174:0x02f1, B:176:0x02f9, B:178:0x0301, B:179:0x030a, B:181:0x0310, B:183:0x0316, B:184:0x031d, B:186:0x0325, B:188:0x032d, B:189:0x0336, B:191:0x033c, B:193:0x0342, B:194:0x0349, B:196:0x034f, B:198:0x0355, B:199:0x035d, B:201:0x0365, B:203:0x036b, B:205:0x037d, B:207:0x0385, B:209:0x038d, B:210:0x0396, B:212:0x039e, B:214:0x03a6, B:285:0x0499, B:287:0x049f, B:289:0x04a5, B:290:0x04ac, B:292:0x04b2, B:294:0x04b8, B:295:0x04c6, B:297:0x04ce, B:299:0x04d6, B:300:0x04df, B:302:0x04e7, B:304:0x04ef, B:305:0x0501, B:307:0x0509, B:309:0x0511, B:310:0x051a, B:312:0x0522, B:314:0x052a, B:315:0x0533, B:317:0x053b, B:319:0x0543, B:320:0x054c, B:322:0x0554, B:324:0x055c, B:326:0x056f, B:328:0x0577, B:329:0x0580, B:331:0x0588, B:333:0x0590, B:334:0x0599, B:336:0x05a1, B:338:0x05a9, B:339:0x05b2, B:341:0x05ba, B:343:0x05c2, B:344:0x05cb, B:346:0x05d3, B:348:0x05db, B:349:0x05e4, B:351:0x05ec, B:353:0x05f4, B:354:0x05fd, B:356:0x0605, B:358:0x060d, B:359:0x0616, B:361:0x061e, B:363:0x0626, B:364:0x062f, B:366:0x0637, B:368:0x063f, B:369:0x0648, B:371:0x0650, B:373:0x0658, B:406:0x06f4, B:408:0x06fb, B:412:0x0704), top: B:820:0x00de }] */
    /* JADX WARN: Code duplicated, block: B:410:0x0701  */
    /* JADX WARN: Code duplicated, block: B:411:0x0702 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:412:0x0704 A[Catch: Exception -> 0x0288, TRY_LEAVE, TryCatch #22 {Exception -> 0x0288, blocks: (B:40:0x00de, B:42:0x00e4, B:44:0x00ee, B:45:0x0103, B:47:0x0109, B:49:0x011a, B:51:0x0120, B:53:0x012c, B:55:0x0132, B:57:0x0138, B:58:0x013f, B:60:0x0145, B:62:0x014b, B:63:0x0154, B:65:0x015a, B:67:0x0160, B:125:0x0210, B:127:0x0216, B:129:0x021c, B:130:0x0223, B:132:0x0229, B:134:0x022f, B:135:0x0236, B:137:0x023e, B:139:0x0246, B:140:0x024f, B:142:0x0257, B:144:0x025f, B:145:0x0268, B:147:0x026e, B:157:0x02a6, B:159:0x02ac, B:161:0x02b6, B:163:0x02c1, B:166:0x02ca, B:168:0x02d0, B:170:0x02df, B:172:0x02e5, B:174:0x02f1, B:176:0x02f9, B:178:0x0301, B:179:0x030a, B:181:0x0310, B:183:0x0316, B:184:0x031d, B:186:0x0325, B:188:0x032d, B:189:0x0336, B:191:0x033c, B:193:0x0342, B:194:0x0349, B:196:0x034f, B:198:0x0355, B:199:0x035d, B:201:0x0365, B:203:0x036b, B:205:0x037d, B:207:0x0385, B:209:0x038d, B:210:0x0396, B:212:0x039e, B:214:0x03a6, B:285:0x0499, B:287:0x049f, B:289:0x04a5, B:290:0x04ac, B:292:0x04b2, B:294:0x04b8, B:295:0x04c6, B:297:0x04ce, B:299:0x04d6, B:300:0x04df, B:302:0x04e7, B:304:0x04ef, B:305:0x0501, B:307:0x0509, B:309:0x0511, B:310:0x051a, B:312:0x0522, B:314:0x052a, B:315:0x0533, B:317:0x053b, B:319:0x0543, B:320:0x054c, B:322:0x0554, B:324:0x055c, B:326:0x056f, B:328:0x0577, B:329:0x0580, B:331:0x0588, B:333:0x0590, B:334:0x0599, B:336:0x05a1, B:338:0x05a9, B:339:0x05b2, B:341:0x05ba, B:343:0x05c2, B:344:0x05cb, B:346:0x05d3, B:348:0x05db, B:349:0x05e4, B:351:0x05ec, B:353:0x05f4, B:354:0x05fd, B:356:0x0605, B:358:0x060d, B:359:0x0616, B:361:0x061e, B:363:0x0626, B:364:0x062f, B:366:0x0637, B:368:0x063f, B:369:0x0648, B:371:0x0650, B:373:0x0658, B:406:0x06f4, B:408:0x06fb, B:412:0x0704), top: B:820:0x00de }] */
    /* JADX WARN: Code duplicated, block: B:415:0x0726  */
    /* JADX WARN: Code duplicated, block: B:446:0x07b1 A[Catch: Exception -> 0x07b9, TRY_LEAVE, TryCatch #44 {Exception -> 0x07b9, blocks: (B:444:0x07ab, B:446:0x07b1), top: B:864:0x07ab }] */
    /* JADX WARN: Code duplicated, block: B:451:0x07c9  */
    /* JADX WARN: Code duplicated, block: B:457:0x07d9 A[Catch: Exception -> 0x07e1, TRY_LEAVE, TryCatch #9 {Exception -> 0x07e1, blocks: (B:455:0x07d3, B:457:0x07d9), top: B:794:0x07d3 }] */
    /* JADX WARN: Code duplicated, block: B:466:0x07fa A[Catch: Exception -> 0x0802, TRY_LEAVE, TryCatch #23 {Exception -> 0x0802, blocks: (B:464:0x07f4, B:466:0x07fa, B:472:0x0816, B:474:0x081e, B:477:0x082f, B:479:0x0837, B:481:0x0848, B:482:0x0852, B:484:0x0858, B:485:0x0862, B:490:0x0872, B:492:0x087a, B:494:0x088b, B:495:0x0891, B:497:0x0897, B:498:0x08a1, B:501:0x08aa, B:503:0x08b0, B:506:0x08bd, B:508:0x08c3), top: B:822:0x07f4 }] */
    /* JADX WARN: Code duplicated, block: B:470:0x080e A[Catch: Exception -> 0x0a68, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x0a68, blocks: (B:462:0x07ee, B:470:0x080e, B:475:0x0827, B:488:0x086a, B:499:0x08a4, B:504:0x08b7), top: B:792:0x07ee }] */
    /* JADX WARN: Code duplicated, block: B:472:0x0816 A[Catch: Exception -> 0x0802, TRY_ENTER, TryCatch #23 {Exception -> 0x0802, blocks: (B:464:0x07f4, B:466:0x07fa, B:472:0x0816, B:474:0x081e, B:477:0x082f, B:479:0x0837, B:481:0x0848, B:482:0x0852, B:484:0x0858, B:485:0x0862, B:490:0x0872, B:492:0x087a, B:494:0x088b, B:495:0x0891, B:497:0x0897, B:498:0x08a1, B:501:0x08aa, B:503:0x08b0, B:506:0x08bd, B:508:0x08c3), top: B:822:0x07f4 }] */
    /* JADX WARN: Code duplicated, block: B:477:0x082f A[Catch: Exception -> 0x0802, TRY_ENTER, TryCatch #23 {Exception -> 0x0802, blocks: (B:464:0x07f4, B:466:0x07fa, B:472:0x0816, B:474:0x081e, B:477:0x082f, B:479:0x0837, B:481:0x0848, B:482:0x0852, B:484:0x0858, B:485:0x0862, B:490:0x0872, B:492:0x087a, B:494:0x088b, B:495:0x0891, B:497:0x0897, B:498:0x08a1, B:501:0x08aa, B:503:0x08b0, B:506:0x08bd, B:508:0x08c3), top: B:822:0x07f4 }] */
    /* JADX WARN: Code duplicated, block: B:487:0x0866  */
    /* JADX WARN: Code duplicated, block: B:490:0x0872 A[Catch: Exception -> 0x0802, TRY_ENTER, TryCatch #23 {Exception -> 0x0802, blocks: (B:464:0x07f4, B:466:0x07fa, B:472:0x0816, B:474:0x081e, B:477:0x082f, B:479:0x0837, B:481:0x0848, B:482:0x0852, B:484:0x0858, B:485:0x0862, B:490:0x0872, B:492:0x087a, B:494:0x088b, B:495:0x0891, B:497:0x0897, B:498:0x08a1, B:501:0x08aa, B:503:0x08b0, B:506:0x08bd, B:508:0x08c3), top: B:822:0x07f4 }] */
    /* JADX WARN: Code duplicated, block: B:494:0x088b A[Catch: Exception -> 0x0802, TryCatch #23 {Exception -> 0x0802, blocks: (B:464:0x07f4, B:466:0x07fa, B:472:0x0816, B:474:0x081e, B:477:0x082f, B:479:0x0837, B:481:0x0848, B:482:0x0852, B:484:0x0858, B:485:0x0862, B:490:0x0872, B:492:0x087a, B:494:0x088b, B:495:0x0891, B:497:0x0897, B:498:0x08a1, B:501:0x08aa, B:503:0x08b0, B:506:0x08bd, B:508:0x08c3), top: B:822:0x07f4 }] */
    /* JADX WARN: Code duplicated, block: B:497:0x0897 A[Catch: Exception -> 0x0802, LOOP:9: B:495:0x0891->B:497:0x0897, LOOP_END, TryCatch #23 {Exception -> 0x0802, blocks: (B:464:0x07f4, B:466:0x07fa, B:472:0x0816, B:474:0x081e, B:477:0x082f, B:479:0x0837, B:481:0x0848, B:482:0x0852, B:484:0x0858, B:485:0x0862, B:490:0x0872, B:492:0x087a, B:494:0x088b, B:495:0x0891, B:497:0x0897, B:498:0x08a1, B:501:0x08aa, B:503:0x08b0, B:506:0x08bd, B:508:0x08c3), top: B:822:0x07f4 }] */
    /* JADX WARN: Code duplicated, block: B:501:0x08aa A[Catch: Exception -> 0x0802, TRY_ENTER, TryCatch #23 {Exception -> 0x0802, blocks: (B:464:0x07f4, B:466:0x07fa, B:472:0x0816, B:474:0x081e, B:477:0x082f, B:479:0x0837, B:481:0x0848, B:482:0x0852, B:484:0x0858, B:485:0x0862, B:490:0x0872, B:492:0x087a, B:494:0x088b, B:495:0x0891, B:497:0x0897, B:498:0x08a1, B:501:0x08aa, B:503:0x08b0, B:506:0x08bd, B:508:0x08c3), top: B:822:0x07f4 }] */
    /* JADX WARN: Code duplicated, block: B:506:0x08bd A[Catch: Exception -> 0x0802, TRY_ENTER, TryCatch #23 {Exception -> 0x0802, blocks: (B:464:0x07f4, B:466:0x07fa, B:472:0x0816, B:474:0x081e, B:477:0x082f, B:479:0x0837, B:481:0x0848, B:482:0x0852, B:484:0x0858, B:485:0x0862, B:490:0x0872, B:492:0x087a, B:494:0x088b, B:495:0x0891, B:497:0x0897, B:498:0x08a1, B:501:0x08aa, B:503:0x08b0, B:506:0x08bd, B:508:0x08c3), top: B:822:0x07f4 }] */
    /* JADX WARN: Code duplicated, block: B:514:0x08d8 A[Catch: Exception -> 0x08e0, TRY_LEAVE, TryCatch #3 {Exception -> 0x08e0, blocks: (B:512:0x08d2, B:514:0x08d8), top: B:782:0x08d2 }] */
    /* JADX WARN: Code duplicated, block: B:518:0x08ea  */
    /* JADX WARN: Code duplicated, block: B:523:0x08f8 A[Catch: Exception -> 0x0900, TRY_LEAVE, TryCatch #20 {Exception -> 0x0900, blocks: (B:521:0x08f2, B:523:0x08f8), top: B:816:0x08f2 }] */
    /* JADX WARN: Code duplicated, block: B:528:0x0908  */
    /* JADX WARN: Code duplicated, block: B:533:0x0916 A[Catch: Exception -> 0x091e, TRY_LEAVE, TryCatch #32 {Exception -> 0x091e, blocks: (B:531:0x0910, B:533:0x0916), top: B:840:0x0910 }] */
    /* JADX WARN: Code duplicated, block: B:537:0x0923  */
    /* JADX WARN: Code duplicated, block: B:542:0x0931  */
    /* JADX WARN: Code duplicated, block: B:550:0x094b  */
    /* JADX WARN: Code duplicated, block: B:556:0x095b  */
    /* JADX WARN: Code duplicated, block: B:562:0x0973  */
    /* JADX WARN: Code duplicated, block: B:565:0x097d A[Catch: Exception -> 0x098f, TRY_ENTER, TryCatch #11 {Exception -> 0x098f, blocks: (B:557:0x095d, B:565:0x097d, B:567:0x0985, B:573:0x0999, B:575:0x09a1, B:578:0x09b2, B:580:0x09ba), top: B:798:0x095d }] */
    /* JADX WARN: Code duplicated, block: B:573:0x0999 A[Catch: Exception -> 0x098f, TRY_ENTER, TryCatch #11 {Exception -> 0x098f, blocks: (B:557:0x095d, B:565:0x097d, B:567:0x0985, B:573:0x0999, B:575:0x09a1, B:578:0x09b2, B:580:0x09ba), top: B:798:0x095d }] */
    /* JADX WARN: Code duplicated, block: B:578:0x09b2 A[Catch: Exception -> 0x098f, TRY_ENTER, TryCatch #11 {Exception -> 0x098f, blocks: (B:557:0x095d, B:565:0x097d, B:567:0x0985, B:573:0x0999, B:575:0x09a1, B:578:0x09b2, B:580:0x09ba), top: B:798:0x095d }] */
    /* JADX WARN: Code duplicated, block: B:586:0x09d1  */
    /* JADX WARN: Code duplicated, block: B:594:0x09e5  */
    /* JADX WARN: Code duplicated, block: B:598:0x09ef A[Catch: Exception -> 0x0a3e, TryCatch #40 {Exception -> 0x0a3e, blocks: (B:596:0x09e9, B:598:0x09ef, B:600:0x09f5, B:603:0x0a00, B:608:0x0a18, B:609:0x0a1b, B:606:0x0a0a, B:607:0x0a14), top: B:856:0x09e9 }] */
    /* JADX WARN: Code duplicated, block: B:603:0x0a00 A[Catch: Exception -> 0x0a3e, TryCatch #40 {Exception -> 0x0a3e, blocks: (B:596:0x09e9, B:598:0x09ef, B:600:0x09f5, B:603:0x0a00, B:608:0x0a18, B:609:0x0a1b, B:606:0x0a0a, B:607:0x0a14), top: B:856:0x09e9 }] */
    /* JADX WARN: Code duplicated, block: B:604:0x0a06  */
    /* JADX WARN: Code duplicated, block: B:606:0x0a0a A[Catch: Exception -> 0x0a3e, TryCatch #40 {Exception -> 0x0a3e, blocks: (B:596:0x09e9, B:598:0x09ef, B:600:0x09f5, B:603:0x0a00, B:608:0x0a18, B:609:0x0a1b, B:606:0x0a0a, B:607:0x0a14), top: B:856:0x09e9 }] */
    /* JADX WARN: Code duplicated, block: B:607:0x0a14 A[Catch: Exception -> 0x0a3e, TryCatch #40 {Exception -> 0x0a3e, blocks: (B:596:0x09e9, B:598:0x09ef, B:600:0x09f5, B:603:0x0a00, B:608:0x0a18, B:609:0x0a1b, B:606:0x0a0a, B:607:0x0a14), top: B:856:0x09e9 }] */
    /* JADX WARN: Code duplicated, block: B:640:0x0aae  */
    /* JADX WARN: Code duplicated, block: B:646:0x0ad8 A[Catch: Exception -> 0x0c9c, TryCatch #33 {Exception -> 0x0c9c, blocks: (B:644:0x0ad0, B:646:0x0ad8, B:648:0x0ae0, B:650:0x0aec, B:652:0x0af9), top: B:842:0x0ad0 }] */
    /* JADX WARN: Code duplicated, block: B:751:0x0ca1 A[PHI: r17
      0x0ca1: PHI (r17v8 java.util.ArrayList) = (r17v9 java.util.ArrayList), (r17v7 java.util.ArrayList), (r17v7 java.util.ArrayList), (r17v7 java.util.ArrayList) binds: [B:750:0x0c9e, B:645:0x0ad6, B:647:0x0ade, B:649:0x0aea] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:776:0x0955 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:782:0x08d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:786:0x09cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:794:0x07d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:796:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:804:0x043b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:816:0x08f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:822:0x07f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:840:0x0910 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:864:0x07ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:870:0x092b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:882:0x0707 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:883:0x0707 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:906:0x0271 A[SYNTHETIC] */
    public static com.igaworks.adpopcorn.cores.model.e a(Context context, String str) {
        com.igaworks.adpopcorn.cores.model.e eVar;
        Exception exc;
        boolean z;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        ArrayList arrayList;
        String str6;
        boolean z2;
        String string;
        String[] strArrSplit;
        int i2;
        String string2;
        String str7;
        String str8;
        String str9;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str10;
        String str11;
        String str12;
        Exception exc2;
        Exception exc3;
        ArrayList arrayList2;
        JSONArray jSONArray;
        ArrayList arrayList3;
        int i3;
        String str13;
        String str14;
        String str15;
        boolean z3;
        JSONArray jSONArray2;
        ArrayList arrayList4;
        int i4;
        int i5;
        String str16;
        String str17;
        JSONObject jSONObject3;
        boolean zD;
        String string3;
        String str18;
        String string4;
        JSONArray jSONArray3;
        ArrayList arrayList5;
        int i6;
        ArrayList arrayList6;
        g gVarA;
        String str19;
        JSONObject jSONObject4;
        String str20 = "Campaigns";
        com.igaworks.adpopcorn.cores.model.e eVar2 = new com.igaworks.adpopcorn.cores.model.e();
        try {
            JSONObject jSONObject5 = new JSONObject(str);
            if (jSONObject5.has("IsTest")) {
                try {
                    com.igaworks.adpopcorn.a.d.E = jSONObject5.getBoolean("IsTest");
                    eVar2.a(jSONObject5.getBoolean("IsTest"));
                } catch (Exception e) {
                    exc = e;
                    eVar = eVar2;
                }
            }
            String str21 = "ConditionText";
            if (jSONObject5.has("Result")) {
                z = jSONObject5.getBoolean("Result");
                eVar2.a(z);
            } else {
                z = false;
            }
            if (jSONObject5.has("ResultCode")) {
                eVar2.a(jSONObject5.getInt("ResultCode"));
            }
            if (!z) {
                return eVar2;
            }
            if (jSONObject5.has("TotalPageIdx")) {
                eVar2.b(jSONObject5.getInt("TotalPageIdx"));
            }
            if (jSONObject5.has("TotalRewardQuantity")) {
                eVar2.a(jSONObject5.getLong("TotalRewardQuantity"));
            }
            if (jSONObject5.has("RewardCurrency")) {
                eVar2.a(jSONObject5.getString("RewardCurrency"));
            }
            if (jSONObject5.has("ResetSgn") && jSONObject5.getBoolean("ResetSgn")) {
                j.f(context);
            }
            String str22 = "DetargetPackageName";
            String str23 = "IntegrationTypeCode";
            String str24 = "TargetPackageName";
            String str25 = "PackageName";
            String str26 = "ImageUrl";
            String str27 = "IconImgURL";
            String str28 = "IconUrl";
            String str29 = "CTA";
            String str30 = "PartiTypeCode";
            String str31 = "ClickUrl";
            String str32 = "Key";
            String str33 = "Description";
            String str34 = "Id";
            if (!jSONObject5.has("ScheduledCampaigns")) {
                str2 = "Campaigns";
                str3 = "PartiTypeCode";
                str4 = "TargetPackageName";
                str5 = "";
                arrayList = null;
                i = 0;
                str7 = str2;
                String str35 = "Auth";
                if (jSONObject5.has(str7)) {
                    str8 = "Auth";
                    str9 = "Key";
                    jSONObject = jSONObject5;
                } else {
                    str8 = "Auth";
                    str9 = "Key";
                    jSONObject = jSONObject5;
                }
                jSONObject2 = jSONObject;
                if (jSONObject2.has("CPMCampaigns")) {
                    str21 = str21;
                    str23 = str23;
                    str31 = str31;
                    str33 = str33;
                    str10 = str34;
                    str11 = str9;
                    str12 = str3;
                } else {
                    str21 = str21;
                    str23 = str23;
                    str31 = str31;
                    str33 = str33;
                    str10 = str34;
                    str11 = str9;
                    str12 = str3;
                }
                if (jSONObject2.has("NewsCampaigns")) {
                    arrayList2 = arrayList;
                } else {
                    arrayList2 = arrayList;
                }
                eVar = eVar2;
                eVar.a(arrayList2);
                return eVar;
            }
            try {
                if (jSONObject5.isNull("ScheduledCampaigns") || jSONObject5.getJSONArray("ScheduledCampaigns").length() <= 0) {
                    str2 = "Campaigns";
                    str3 = "PartiTypeCode";
                    str4 = "TargetPackageName";
                    str5 = "";
                    arrayList = null;
                    i = 0;
                } else {
                    JSONArray jSONArray4 = new JSONArray(jSONObject5.getString("ScheduledCampaigns"));
                    ArrayList arrayList7 = new ArrayList();
                    String str36 = "";
                    int i7 = 0;
                    i = 0;
                    while (i7 < jSONArray4.length()) {
                        com.igaworks.adpopcorn.cores.model.g gVar = new com.igaworks.adpopcorn.cores.model.g();
                        String str37 = str20;
                        JSONObject jSONObject6 = jSONArray4.getJSONObject(i7);
                        if (jSONObject6.has("IconImgURL") && !jSONObject6.isNull("IconImgURL")) {
                            gVar.t(jSONObject6.getString("IconImgURL"));
                        }
                        if (jSONObject6.has("Key") && !jSONObject6.isNull("Key")) {
                            gVar.b(jSONObject6.getString("Key"));
                        }
                        if (jSONObject6.has("PackageName") && !jSONObject6.isNull("PackageName")) {
                            String string5 = jSONObject6.getString("PackageName");
                            gVar.C(string5);
                            str36 = string5;
                        }
                        if (jSONObject6.has(str30) && !jSONObject6.isNull(str30)) {
                            int i8 = jSONObject6.getInt(str30);
                            gVar.k(i8);
                            i = i8;
                        }
                        try {
                            if (!jSONObject6.has(str24) || jSONObject6.isNull(str24) || (string2 = jSONObject6.getString(str24)) == null || string2.length() <= 0) {
                                str6 = str24;
                            } else {
                                str6 = str24;
                                try {
                                    String[] strArrSplit2 = string2.split(",");
                                    if (strArrSplit2 != null && strArrSplit2.length > 0) {
                                        str30 = str30;
                                        z2 = false;
                                        for (int i9 = 0; i9 < strArrSplit2.length; i9++) {
                                            try {
                                                strArrSplit2[i9] = strArrSplit2[i9].trim();
                                                try {
                                                    if (strArrSplit2[i9] != null && strArrSplit2[i9].length() > 0) {
                                                        boolean zD2 = d(context, strArrSplit2[i9]);
                                                        z2 = zD2;
                                                        if (zD2) {
                                                            break;
                                                        }
                                                    }
                                                } catch (Exception unused) {
                                                    z2 = false;
                                                }
                                            } catch (Exception unused2) {
                                            }
                                        }
                                    }
                                } catch (Exception unused3) {
                                }
                                if (z2) {
                                    try {
                                        if (jSONObject6.has("DetargetPackageName") && !jSONObject6.isNull("DetargetPackageName") && (string = jSONObject6.getString("DetargetPackageName")) != null && string.length() > 0 && (strArrSplit = string.split(",")) != null && strArrSplit.length > 0) {
                                            for (i2 = 0; i2 < strArrSplit.length; i2++) {
                                                strArrSplit[i2] = strArrSplit[i2].trim();
                                                try {
                                                    if (strArrSplit[i2] != null && strArrSplit[i2].length() > 0 && d(context, strArrSplit[i2])) {
                                                        z2 = false;
                                                        break;
                                                    }
                                                } catch (Exception unused4) {
                                                    z2 = true;
                                                }
                                            }
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }
                                if (jSONObject6.has(ADXLogUtil.EVENT_REWARD) && !jSONObject6.isNull(ADXLogUtil.EVENT_REWARD)) {
                                    gVar.G(jSONObject6.getString(ADXLogUtil.EVENT_REWARD));
                                }
                                if (jSONObject6.has("Title") && !jSONObject6.isNull("Title")) {
                                    gVar.J(jSONObject6.getString("Title"));
                                }
                                if (jSONObject6.has("ScheduleTime") && !jSONObject6.isNull("ScheduleTime")) {
                                    gVar.H(jSONObject6.getString("ScheduleTime"));
                                }
                                if (jSONObject6.has("ScheduleTypeCode") && !jSONObject6.isNull("ScheduleTypeCode")) {
                                    gVar.l(jSONObject6.getInt("ScheduleTypeCode"));
                                }
                                gVar.k(true);
                                if (z2) {
                                    arrayList7.add(gVar);
                                }
                                i7++;
                                str20 = str37;
                                jSONArray4 = jSONArray4;
                                str24 = str6;
                                str30 = str30;
                            }
                        } catch (Exception unused6) {
                        }
                        z2 = true;
                        if (z2) {
                            if (jSONObject6.has("DetargetPackageName")) {
                                while (i2 < strArrSplit.length) {
                                    strArrSplit[i2] = strArrSplit[i2].trim();
                                    if (strArrSplit[i2] != null) {
                                        continue;
                                    }
                                }
                            }
                        }
                        if (jSONObject6.has(ADXLogUtil.EVENT_REWARD)) {
                            gVar.G(jSONObject6.getString(ADXLogUtil.EVENT_REWARD));
                        }
                        if (jSONObject6.has("Title")) {
                            gVar.J(jSONObject6.getString("Title"));
                        }
                        if (jSONObject6.has("ScheduleTime")) {
                            gVar.H(jSONObject6.getString("ScheduleTime"));
                        }
                        if (jSONObject6.has("ScheduleTypeCode")) {
                            gVar.l(jSONObject6.getInt("ScheduleTypeCode"));
                        }
                        gVar.k(true);
                        if (z2) {
                            arrayList7.add(gVar);
                        }
                        i7++;
                        str20 = str37;
                        jSONArray4 = jSONArray4;
                        str24 = str6;
                        str30 = str30;
                    }
                    str2 = str20;
                    str3 = str30;
                    str4 = str24;
                    str5 = str36;
                    arrayList = arrayList7;
                }
                str7 = str2;
                try {
                    String str38 = "Auth";
                    if (jSONObject5.has(str7) || jSONObject5.isNull(str7) || jSONObject5.getJSONArray(str7).length() <= 0) {
                        str8 = "Auth";
                        str9 = "Key";
                        jSONObject = jSONObject5;
                    } else {
                        JSONArray jSONArray5 = new JSONArray(jSONObject5.getString(str7));
                        ArrayList arrayList8 = arrayList == null ? new ArrayList() : arrayList;
                        int i10 = 0;
                        while (i10 < jSONArray5.length()) {
                            com.igaworks.adpopcorn.cores.model.g gVar2 = new com.igaworks.adpopcorn.cores.model.g();
                            JSONObject jSONObject7 = jSONArray5.getJSONObject(i10);
                            if (jSONObject7.has(str38) && !jSONObject7.isNull(str38)) {
                                gVar2.a(jSONObject7.getString(str38));
                            }
                            if (jSONObject7.has("Desc") && !jSONObject7.isNull("Desc")) {
                                gVar2.l(jSONObject7.getString("Desc"));
                            }
                            if (jSONObject7.has(str27) && !jSONObject7.isNull(str27)) {
                                gVar2.t(jSONObject7.getString(str27));
                            }
                            if (jSONObject7.has("IsChoiceOffer") && !jSONObject7.isNull("IsChoiceOffer")) {
                                gVar2.a(jSONObject7.getBoolean("IsChoiceOffer"));
                            }
                            if (jSONObject7.has(str32) && !jSONObject7.isNull(str32)) {
                                gVar2.b(jSONObject7.getString(str32));
                            }
                            if (jSONObject7.has(str25) && !jSONObject7.isNull(str25)) {
                                String string6 = jSONObject7.getString(str25);
                                gVar2.C(string6);
                                str5 = string6;
                            }
                            str3 = str3;
                            if (!jSONObject7.has(str3) || jSONObject7.isNull(str3)) {
                                i5 = i;
                            } else {
                                i5 = jSONObject7.getInt(str3);
                                gVar2.k(i5);
                            }
                            if (jSONObject7.has("BadgeTypeCode") && !jSONObject7.isNull("BadgeTypeCode")) {
                                gVar2.a(jSONObject7.getInt("BadgeTypeCode"));
                            }
                            if (jSONObject7.has("IsOverseaOffer") && !jSONObject7.isNull("IsOverseaOffer")) {
                                gVar2.i(jSONObject7.getBoolean("IsOverseaOffer"));
                            }
                            String str39 = str4;
                            try {
                                try {
                                    try {
                                        if (!jSONObject7.has(str39) || jSONObject7.isNull(str39)) {
                                            str16 = str32;
                                        } else {
                                            str16 = str32;
                                            try {
                                                String string7 = jSONObject7.getString(str39);
                                                if (string7 != null && string7.length() > 0) {
                                                    str17 = str39;
                                                    try {
                                                        JSONArray jSONArray6 = new JSONArray(string7);
                                                        int length = jSONArray6.length();
                                                        str3 = str3;
                                                        try {
                                                            String[] strArr = new String[length];
                                                            str38 = str38;
                                                            jSONObject3 = jSONObject5;
                                                            for (int i11 = 0; i11 < jSONArray6.length(); i11++) {
                                                                try {
                                                                    strArr[i11] = jSONArray6.getString(i11);
                                                                } catch (Exception unused7) {
                                                                }
                                                            }
                                                            if (length > 0) {
                                                                zD = false;
                                                                for (int i12 = 0; i12 < length; i12++) {
                                                                    try {
                                                                        strArr[i12] = strArr[i12].trim();
                                                                        try {
                                                                            if (strArr[i12] != null && strArr[i12].length() > 0 && (zD = d(context, strArr[i12]))) {
                                                                                break;
                                                                            }
                                                                        } catch (Exception unused8) {
                                                                            zD = false;
                                                                        }
                                                                    } catch (Exception unused9) {
                                                                    }
                                                                }
                                                            } else {
                                                                zD = true;
                                                            }
                                                        } catch (Exception unused10) {
                                                            str38 = str38;
                                                            jSONObject3 = jSONObject5;
                                                        }
                                                    } catch (Exception unused11) {
                                                        str3 = str3;
                                                    }
                                                }
                                            } catch (Exception unused12) {
                                                str17 = str39;
                                            }
                                            if (!zD) {
                                                try {
                                                    if (jSONObject7.has(str22) || jSONObject7.isNull(str22) || (string3 = jSONObject7.getString(str22)) == null || string3.length() <= 0) {
                                                        str18 = str22;
                                                    } else {
                                                        JSONArray jSONArray7 = new JSONArray(string3);
                                                        int length2 = jSONArray7.length();
                                                        String[] strArr2 = new String[length2];
                                                        str18 = str22;
                                                        for (int i13 = 0; i13 < jSONArray7.length(); i13++) {
                                                            try {
                                                                strArr2[i13] = jSONArray7.getString(i13);
                                                            } catch (Exception unused13) {
                                                            }
                                                        }
                                                        if (length2 > 0) {
                                                            for (int i14 = 0; i14 < length2; i14++) {
                                                                strArr2[i14] = strArr2[i14].trim();
                                                                try {
                                                                    if (strArr2[i14] != null && strArr2[i14].length() > 0 && d(context, strArr2[i14])) {
                                                                        zD = false;
                                                                        break;
                                                                    }
                                                                } catch (Exception unused14) {
                                                                    zD = true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } catch (Exception unused15) {
                                                }
                                            } else {
                                                str18 = str22;
                                            }
                                            if (jSONObject7.has(ADXLogUtil.EVENT_REWARD) && !jSONObject7.isNull(ADXLogUtil.EVENT_REWARD)) {
                                                gVar2.G(jSONObject7.getString(ADXLogUtil.EVENT_REWARD));
                                            }
                                            if (jSONObject7.has("Title") && !jSONObject7.isNull("Title")) {
                                                gVar2.J(jSONObject7.getString("Title"));
                                                gVar2.s(jSONObject7.getString("Title"));
                                            }
                                            if (jSONObject7.has("IsSpecialOffer") && !jSONObject7.isNull("IsSpecialOffer")) {
                                                gVar2.l(jSONObject7.getBoolean("IsSpecialOffer"));
                                            }
                                            if (jSONObject7.has("SpecialOfferImgURL") && !jSONObject7.isNull("SpecialOfferImgURL")) {
                                                gVar2.I(jSONObject7.getString("SpecialOfferImgURL"));
                                                gVar2.o(jSONObject7.getString("SpecialOfferImgURL"));
                                            }
                                            if (jSONObject7.has("RewardCondition") && !jSONObject7.isNull("RewardCondition")) {
                                                gVar2.E(jSONObject7.getString("RewardCondition"));
                                            }
                                            if (jSONObject7.has("UseRedirectURL") && !jSONObject7.isNull("UseRedirectURL")) {
                                                gVar2.n(jSONObject7.getBoolean("UseRedirectURL"));
                                            }
                                            if (jSONObject7.has("RedirectURL") && !jSONObject7.isNull("RedirectURL")) {
                                                gVar2.D(jSONObject7.getString("RedirectURL"));
                                            }
                                            if (jSONObject7.has("RewardDetail") && !jSONObject7.isNull("RewardDetail")) {
                                                jSONObject4 = new JSONObject(jSONObject7.getString("RewardDetail"));
                                                if (jSONObject4.has("Quantity") && !jSONObject4.isNull("Quantity")) {
                                                    gVar2.a(jSONObject4.getLong("Quantity"));
                                                }
                                                if (jSONObject4.has("Unit") && !jSONObject4.isNull("Unit")) {
                                                    gVar2.F(jSONObject4.getString("Unit"));
                                                }
                                            }
                                            if (jSONObject7.has("FeedTitle") && !jSONObject7.isNull("FeedTitle")) {
                                                gVar2.s(jSONObject7.getString("FeedTitle"));
                                            }
                                            if (jSONObject7.has("FeedDesc") && !jSONObject7.isNull("FeedDesc")) {
                                                gVar2.m(jSONObject7.getString("FeedDesc"));
                                            }
                                            if (jSONObject7.has("FeedMainImgURL") && !jSONObject7.isNull("FeedMainImgURL")) {
                                                gVar2.o(jSONObject7.getString("FeedMainImgURL"));
                                            }
                                            if (jSONObject7.has("FeedDetailImgURL") && !jSONObject7.isNull("FeedDetailImgURL")) {
                                                gVar2.n(jSONObject7.getString("FeedDetailImgURL"));
                                            }
                                            if (jSONObject7.has("FeedParticipationStep") && !jSONObject7.isNull("FeedParticipationStep")) {
                                                gVar2.r(jSONObject7.getString("FeedParticipationStep"));
                                            }
                                            if (jSONObject7.has("FeedParticipationImgURL") && !jSONObject7.isNull("FeedParticipationImgURL")) {
                                                gVar2.q(jSONObject7.getString("FeedParticipationImgURL"));
                                            }
                                            if (jSONObject7.has("FeedMustReadDesc") && !jSONObject7.isNull("FeedMustReadDesc")) {
                                                gVar2.p(jSONObject7.getString("FeedMustReadDesc"));
                                            }
                                            if (jSONObject7.has("SubTabNo") && !jSONObject7.isNull("SubTabNo")) {
                                                gVar2.m(jSONObject7.getInt("SubTabNo"));
                                            }
                                            if (jSONObject7.has("DetailRewardConditionMessageList") || jSONObject7.isNull("DetailRewardConditionMessageList")) {
                                                arrayList6 = new ArrayList();
                                                gVarA = g.a();
                                                if (i5 == 35) {
                                                    arrayList6.add(gVarA.J2);
                                                    str19 = gVarA.K2;
                                                } else {
                                                    str19 = gVarA.I2;
                                                }
                                                arrayList6.add(str19);
                                            } else {
                                                String string8 = jSONObject7.getString("DetailRewardConditionMessageList");
                                                if (string8 != null && string8.length() > 0) {
                                                    JSONArray jSONArray8 = new JSONArray(string8);
                                                    arrayList6 = new ArrayList();
                                                    for (int i15 = 0; i15 < jSONArray8.length(); i15++) {
                                                        arrayList6.add(jSONArray8.getString(i15));
                                                    }
                                                }
                                                if (jSONObject7.has("ParticipationStepMessageList") && !jSONObject7.isNull("ParticipationStepMessageList") && (string4 = jSONObject7.getString("ParticipationStepMessageList")) != null && string4.length() > 0) {
                                                    jSONArray3 = new JSONArray(string4);
                                                    arrayList5 = new ArrayList();
                                                    for (i6 = 0; i6 < jSONArray3.length(); i6++) {
                                                        arrayList5.add(jSONArray3.getString(i6));
                                                    }
                                                    gVar2.d(arrayList5);
                                                }
                                                gVar2.k(false);
                                                if (i5 == 10) {
                                                    if (d(context, str5)) {
                                                        arrayList8.add(gVar2);
                                                    }
                                                } else if (zD) {
                                                    arrayList8.add(gVar2);
                                                }
                                                i10++;
                                                jSONArray5 = jSONArray5;
                                                i = i5;
                                                str27 = str27;
                                                str25 = str25;
                                                str32 = str16;
                                                str38 = str38;
                                                jSONObject5 = jSONObject3;
                                                str22 = str18;
                                                str4 = str17;
                                            }
                                            gVar2.c(arrayList6);
                                            if (jSONObject7.has("ParticipationStepMessageList")) {
                                                jSONArray3 = new JSONArray(string4);
                                                arrayList5 = new ArrayList();
                                                while (i6 < jSONArray3.length()) {
                                                    arrayList5.add(jSONArray3.getString(i6));
                                                }
                                                gVar2.d(arrayList5);
                                            }
                                            gVar2.k(false);
                                            if (i5 == 10) {
                                                if (d(context, str5)) {
                                                    arrayList8.add(gVar2);
                                                }
                                            } else if (zD) {
                                                arrayList8.add(gVar2);
                                            }
                                            i10++;
                                            jSONArray5 = jSONArray5;
                                            i = i5;
                                            str27 = str27;
                                            str25 = str25;
                                            str32 = str16;
                                            str38 = str38;
                                            jSONObject5 = jSONObject3;
                                            str22 = str18;
                                            str4 = str17;
                                        }
                                        if (jSONObject7.has("ParticipationStepMessageList")) {
                                            jSONArray3 = new JSONArray(string4);
                                            arrayList5 = new ArrayList();
                                            while (i6 < jSONArray3.length()) {
                                                arrayList5.add(jSONArray3.getString(i6));
                                            }
                                            gVar2.d(arrayList5);
                                        }
                                    } catch (Exception unused16) {
                                    }
                                    str17 = str39;
                                } catch (Exception unused17) {
                                    str16 = str32;
                                }
                                if (jSONObject7.has("DetailRewardConditionMessageList")) {
                                    arrayList6 = new ArrayList();
                                    gVarA = g.a();
                                    if (i5 == 35) {
                                        arrayList6.add(gVarA.J2);
                                        str19 = gVarA.K2;
                                    } else {
                                        str19 = gVarA.I2;
                                    }
                                    arrayList6.add(str19);
                                    gVar2.c(arrayList6);
                                } else {
                                    arrayList6 = new ArrayList();
                                    gVarA = g.a();
                                    if (i5 == 35) {
                                        arrayList6.add(gVarA.J2);
                                        str19 = gVarA.K2;
                                    } else {
                                        str19 = gVarA.I2;
                                    }
                                    arrayList6.add(str19);
                                    gVar2.c(arrayList6);
                                }
                            } catch (Exception unused18) {
                            }
                            jSONObject3 = jSONObject5;
                            zD = true;
                            if (!zD) {
                                str18 = str22;
                            } else if (jSONObject7.has(str22)) {
                                str18 = str22;
                            } else {
                                str18 = str22;
                            }
                            if (jSONObject7.has(ADXLogUtil.EVENT_REWARD)) {
                                gVar2.G(jSONObject7.getString(ADXLogUtil.EVENT_REWARD));
                            }
                            if (jSONObject7.has("Title")) {
                                gVar2.J(jSONObject7.getString("Title"));
                                gVar2.s(jSONObject7.getString("Title"));
                            }
                            if (jSONObject7.has("IsSpecialOffer")) {
                                gVar2.l(jSONObject7.getBoolean("IsSpecialOffer"));
                            }
                            if (jSONObject7.has("SpecialOfferImgURL")) {
                                gVar2.I(jSONObject7.getString("SpecialOfferImgURL"));
                                gVar2.o(jSONObject7.getString("SpecialOfferImgURL"));
                            }
                            if (jSONObject7.has("RewardCondition")) {
                                gVar2.E(jSONObject7.getString("RewardCondition"));
                            }
                            if (jSONObject7.has("UseRedirectURL")) {
                                gVar2.n(jSONObject7.getBoolean("UseRedirectURL"));
                            }
                            if (jSONObject7.has("RedirectURL")) {
                                gVar2.D(jSONObject7.getString("RedirectURL"));
                            }
                            if (jSONObject7.has("RewardDetail")) {
                                jSONObject4 = new JSONObject(jSONObject7.getString("RewardDetail"));
                                if (jSONObject4.has("Quantity")) {
                                    gVar2.a(jSONObject4.getLong("Quantity"));
                                }
                                if (jSONObject4.has("Unit")) {
                                    gVar2.F(jSONObject4.getString("Unit"));
                                }
                            }
                            if (jSONObject7.has("FeedTitle")) {
                                gVar2.s(jSONObject7.getString("FeedTitle"));
                            }
                            if (jSONObject7.has("FeedDesc")) {
                                gVar2.m(jSONObject7.getString("FeedDesc"));
                            }
                            if (jSONObject7.has("FeedMainImgURL")) {
                                gVar2.o(jSONObject7.getString("FeedMainImgURL"));
                            }
                            if (jSONObject7.has("FeedDetailImgURL")) {
                                gVar2.n(jSONObject7.getString("FeedDetailImgURL"));
                            }
                            if (jSONObject7.has("FeedParticipationStep")) {
                                gVar2.r(jSONObject7.getString("FeedParticipationStep"));
                            }
                            if (jSONObject7.has("FeedParticipationImgURL")) {
                                gVar2.q(jSONObject7.getString("FeedParticipationImgURL"));
                            }
                            if (jSONObject7.has("FeedMustReadDesc")) {
                                gVar2.p(jSONObject7.getString("FeedMustReadDesc"));
                            }
                            if (jSONObject7.has("SubTabNo")) {
                                gVar2.m(jSONObject7.getInt("SubTabNo"));
                            }
                            gVar2.k(false);
                            if (i5 == 10) {
                                if (d(context, str5)) {
                                    arrayList8.add(gVar2);
                                }
                            } else if (zD) {
                                arrayList8.add(gVar2);
                            }
                            i10++;
                            jSONArray5 = jSONArray5;
                            i = i5;
                            str27 = str27;
                            str25 = str25;
                            str32 = str16;
                            str38 = str38;
                            jSONObject5 = jSONObject3;
                            str22 = str18;
                            str4 = str17;
                        }
                        str8 = str38;
                        str9 = str32;
                        jSONObject = jSONObject5;
                        arrayList = arrayList8;
                    }
                    jSONObject2 = jSONObject;
                    try {
                        if (jSONObject2.has("CPMCampaigns") || jSONObject2.isNull("CPMCampaigns") || jSONObject2.getJSONArray("CPMCampaigns").length() <= 0) {
                            str21 = str21;
                            str23 = str23;
                            str31 = str31;
                            str33 = str33;
                            str10 = str34;
                            str11 = str9;
                            str12 = str3;
                        } else {
                            if (arrayList == null) {
                                try {
                                    arrayList3 = new ArrayList();
                                } catch (Exception e2) {
                                    exc2 = e2;
                                    str21 = str21;
                                    str23 = str23;
                                    str31 = str31;
                                    str33 = str33;
                                    str10 = str34;
                                    str11 = str9;
                                    str12 = str3;
                                    exc2.printStackTrace();
                                    if (jSONObject2.has("NewsCampaigns")) {
                                        arrayList2 = arrayList;
                                    } else {
                                        arrayList2 = arrayList;
                                    }
                                    eVar = eVar2;
                                    eVar.a(arrayList2);
                                    return eVar;
                                }
                            } else {
                                arrayList3 = arrayList;
                            }
                            int i16 = 0;
                            for (JSONArray jSONArray9 = new JSONArray(jSONObject2.getString("CPMCampaigns")); i16 < jSONArray9.length(); jSONArray9 = jSONArray9) {
                                try {
                                    com.igaworks.adpopcorn.cores.model.g gVar3 = new com.igaworks.adpopcorn.cores.model.g();
                                    JSONObject jSONObject8 = jSONArray9.getJSONObject(i16);
                                    str8 = str8;
                                    if (jSONObject8.has(str8)) {
                                        try {
                                            if (!jSONObject8.isNull(str8)) {
                                                gVar3.a(jSONObject8.getString(str8));
                                            }
                                            str12 = str3;
                                            try {
                                                if (!jSONObject8.has(str12)) {
                                                    try {
                                                        if (jSONObject8.isNull(str12)) {
                                                            i3 = i;
                                                        } else {
                                                            i3 = jSONObject8.getInt(str12);
                                                            gVar3.k(i3);
                                                        }
                                                    } catch (Exception e3) {
                                                        exc2 = e3;
                                                        str10 = str34;
                                                        str11 = str9;
                                                        arrayList = arrayList3;
                                                        exc2.printStackTrace();
                                                        if (jSONObject2.has("NewsCampaigns")) {
                                                            arrayList2 = arrayList;
                                                        } else {
                                                            arrayList2 = arrayList;
                                                        }
                                                        eVar = eVar2;
                                                        eVar.a(arrayList2);
                                                        return eVar;
                                                    }
                                                } else {
                                                    i3 = i;
                                                }
                                                str10 = str34;
                                                try {
                                                    if (jSONObject8.has(str10)) {
                                                        try {
                                                            if (!jSONObject8.isNull(str10)) {
                                                                gVar3.c(jSONObject8.getInt(str10));
                                                            }
                                                        } catch (Exception e4) {
                                                            exc2 = e4;
                                                            str11 = str9;
                                                            arrayList = arrayList3;
                                                            exc2.printStackTrace();
                                                            if (jSONObject2.has("NewsCampaigns")) {
                                                                arrayList2 = arrayList;
                                                            } else {
                                                                arrayList2 = arrayList;
                                                            }
                                                            eVar = eVar2;
                                                            eVar.a(arrayList2);
                                                            return eVar;
                                                        }
                                                    }
                                                    str11 = str9;
                                                    try {
                                                        if (jSONObject8.has(str11)) {
                                                            try {
                                                                if (!jSONObject8.isNull(str11)) {
                                                                    gVar3.d(jSONObject8.getString(str11));
                                                                }
                                                                if (jSONObject8.has("Name") && !jSONObject8.isNull("Name")) {
                                                                    gVar3.j(jSONObject8.getString("Name"));
                                                                }
                                                                if (!jSONObject8.has("ImpressionURLs") && !jSONObject8.isNull("ImpressionURLs")) {
                                                                    JSONArray jSONArray10 = new JSONArray(jSONObject8.getString("ImpressionURLs"));
                                                                    if (jSONArray10.length() > 0) {
                                                                        ArrayList arrayList9 = new ArrayList();
                                                                        for (int i17 = 0; i17 < jSONArray10.length(); i17++) {
                                                                            arrayList9.add(jSONArray10.getString(i17));
                                                                        }
                                                                        gVar3.b(arrayList9);
                                                                    }
                                                                }
                                                                if (jSONObject8.has("ClickTrackingURLs") && !jSONObject8.isNull("ClickTrackingURLs")) {
                                                                    jSONArray2 = new JSONArray(jSONObject8.getString("ClickTrackingURLs"));
                                                                    if (jSONArray2.length() > 0) {
                                                                        arrayList4 = new ArrayList();
                                                                        for (i4 = 0; i4 < jSONArray2.length(); i4++) {
                                                                            arrayList4.add(jSONArray2.getString(i4));
                                                                        }
                                                                        gVar3.a(arrayList4);
                                                                    }
                                                                }
                                                                if (jSONObject8.has(ADXLogUtil.EVENT_REWARD) && !jSONObject8.isNull(ADXLogUtil.EVENT_REWARD)) {
                                                                    gVar3.e(jSONObject8.getInt(ADXLogUtil.EVENT_REWARD));
                                                                }
                                                                if (jSONObject8.has("Title") && !jSONObject8.isNull("Title")) {
                                                                    gVar3.k(jSONObject8.getString("Title"));
                                                                }
                                                                str33 = str33;
                                                                try {
                                                                    if (jSONObject8.has(str33)) {
                                                                        try {
                                                                            if (!jSONObject8.isNull(str33)) {
                                                                                gVar3.g(jSONObject8.getString(str33));
                                                                            }
                                                                            str31 = str31;
                                                                            try {
                                                                                if (jSONObject8.has(str31)) {
                                                                                    try {
                                                                                        if (!jSONObject8.isNull(str31)) {
                                                                                            gVar3.e(jSONObject8.getString(str31));
                                                                                        }
                                                                                        str13 = str29;
                                                                                        try {
                                                                                            if (jSONObject8.has(str13)) {
                                                                                                try {
                                                                                                    if (!jSONObject8.isNull(str13)) {
                                                                                                        gVar3.c(jSONObject8.getString(str13));
                                                                                                    }
                                                                                                    str14 = str28;
                                                                                                    try {
                                                                                                        if (!jSONObject8.has(str14)) {
                                                                                                            try {
                                                                                                                if (jSONObject8.isNull(str14)) {
                                                                                                                    str29 = str13;
                                                                                                                } else {
                                                                                                                    str29 = str13;
                                                                                                                    try {
                                                                                                                        gVar3.h(jSONObject8.getString(str14));
                                                                                                                        gVar3.t(jSONObject8.getString(str14));
                                                                                                                    } catch (Exception e5) {
                                                                                                                        e = e5;
                                                                                                                        exc2 = e;
                                                                                                                        str28 = str14;
                                                                                                                        str21 = str21;
                                                                                                                        str23 = str23;
                                                                                                                        arrayList = arrayList3;
                                                                                                                        exc2.printStackTrace();
                                                                                                                        if (jSONObject2.has("NewsCampaigns")) {
                                                                                                                            arrayList2 = arrayList;
                                                                                                                        } else {
                                                                                                                            arrayList2 = arrayList;
                                                                                                                        }
                                                                                                                        eVar = eVar2;
                                                                                                                        eVar.a(arrayList2);
                                                                                                                        return eVar;
                                                                                                                    }
                                                                                                                }
                                                                                                            } catch (Exception e6) {
                                                                                                                e = e6;
                                                                                                                str29 = str13;
                                                                                                            }
                                                                                                        } else {
                                                                                                            str29 = str13;
                                                                                                        }
                                                                                                        str15 = str26;
                                                                                                        try {
                                                                                                            if (!jSONObject8.has(str15)) {
                                                                                                                try {
                                                                                                                    if (jSONObject8.isNull(str15)) {
                                                                                                                        str28 = str14;
                                                                                                                    } else {
                                                                                                                        str28 = str14;
                                                                                                                        try {
                                                                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                                                                        } catch (Exception e7) {
                                                                                                                            e = e7;
                                                                                                                            exc2 = e;
                                                                                                                            str26 = str15;
                                                                                                                            str21 = str21;
                                                                                                                            str23 = str23;
                                                                                                                            arrayList = arrayList3;
                                                                                                                            exc2.printStackTrace();
                                                                                                                            if (jSONObject2.has("NewsCampaigns")) {
                                                                                                                                arrayList2 = arrayList;
                                                                                                                            } else {
                                                                                                                                arrayList2 = arrayList;
                                                                                                                            }
                                                                                                                            eVar = eVar2;
                                                                                                                            eVar.a(arrayList2);
                                                                                                                            return eVar;
                                                                                                                        }
                                                                                                                    }
                                                                                                                } catch (Exception e8) {
                                                                                                                    e = e8;
                                                                                                                    str28 = str14;
                                                                                                                }
                                                                                                            } else {
                                                                                                                str28 = str14;
                                                                                                            }
                                                                                                            try {
                                                                                                                if (jSONObject8.has(HttpHeaders.WIDTH) && !jSONObject8.isNull(HttpHeaders.WIDTH)) {
                                                                                                                    gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                                                                }
                                                                                                                if (jSONObject8.has("Height") && !jSONObject8.isNull("Height")) {
                                                                                                                    gVar3.b(jSONObject8.getInt("Height"));
                                                                                                                }
                                                                                                                if (jSONObject8.has("IsDeeplink") && !jSONObject8.isNull("IsDeeplink")) {
                                                                                                                    gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                                                                }
                                                                                                                str23 = str23;
                                                                                                                try {
                                                                                                                    if (!jSONObject8.has(str23)) {
                                                                                                                        try {
                                                                                                                            if (jSONObject8.isNull(str23)) {
                                                                                                                                str26 = str15;
                                                                                                                            } else {
                                                                                                                                str26 = str15;
                                                                                                                                try {
                                                                                                                                    gVar3.d(jSONObject8.getInt(str23));
                                                                                                                                } catch (Exception e9) {
                                                                                                                                    e = e9;
                                                                                                                                    exc2 = e;
                                                                                                                                    str21 = str21;
                                                                                                                                    arrayList = arrayList3;
                                                                                                                                    exc2.printStackTrace();
                                                                                                                                    if (jSONObject2.has("NewsCampaigns")) {
                                                                                                                                        arrayList2 = arrayList;
                                                                                                                                    } else {
                                                                                                                                        arrayList2 = arrayList;
                                                                                                                                    }
                                                                                                                                    eVar = eVar2;
                                                                                                                                    eVar.a(arrayList2);
                                                                                                                                    return eVar;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } catch (Exception e10) {
                                                                                                                            e = e10;
                                                                                                                            str26 = str15;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str26 = str15;
                                                                                                                    }
                                                                                                                    str21 = str21;
                                                                                                                    try {
                                                                                                                        if (jSONObject8.has(str21) && !jSONObject8.isNull(str21)) {
                                                                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                                                                        }
                                                                                                                        if (i3 == 43) {
                                                                                                                            gVar3.f(true);
                                                                                                                            z3 = false;
                                                                                                                        } else {
                                                                                                                            if (i3 == 48) {
                                                                                                                                gVar3.f(false);
                                                                                                                                gVar3.b(true);
                                                                                                                                z3 = false;
                                                                                                                            } else {
                                                                                                                                z3 = false;
                                                                                                                                gVar3.f(false);
                                                                                                                            }
                                                                                                                            gVar3.k(z3);
                                                                                                                            gVar3.F(eVar2.c());
                                                                                                                            arrayList3.add(gVar3);
                                                                                                                            i16++;
                                                                                                                            str33 = str33;
                                                                                                                            str31 = str31;
                                                                                                                            str3 = str12;
                                                                                                                            i = i3;
                                                                                                                            str34 = str10;
                                                                                                                            str9 = str11;
                                                                                                                            str21 = str21;
                                                                                                                            str23 = str23;
                                                                                                                        }
                                                                                                                        gVar3.b(z3);
                                                                                                                        gVar3.k(z3);
                                                                                                                        gVar3.F(eVar2.c());
                                                                                                                        arrayList3.add(gVar3);
                                                                                                                        i16++;
                                                                                                                        str33 = str33;
                                                                                                                        str31 = str31;
                                                                                                                        str3 = str12;
                                                                                                                        i = i3;
                                                                                                                        str34 = str10;
                                                                                                                        str9 = str11;
                                                                                                                        str21 = str21;
                                                                                                                        str23 = str23;
                                                                                                                    } catch (Exception e11) {
                                                                                                                        e = e11;
                                                                                                                        exc2 = e;
                                                                                                                        arrayList = arrayList3;
                                                                                                                        exc2.printStackTrace();
                                                                                                                        if (jSONObject2.has("NewsCampaigns")) {
                                                                                                                            arrayList2 = arrayList;
                                                                                                                        } else {
                                                                                                                            arrayList2 = arrayList;
                                                                                                                        }
                                                                                                                        eVar = eVar2;
                                                                                                                        eVar.a(arrayList2);
                                                                                                                        return eVar;
                                                                                                                    }
                                                                                                                } catch (Exception e12) {
                                                                                                                    e = e12;
                                                                                                                    str26 = str15;
                                                                                                                    str21 = str21;
                                                                                                                }
                                                                                                            } catch (Exception e13) {
                                                                                                                e = e13;
                                                                                                                str26 = str15;
                                                                                                                str21 = str21;
                                                                                                                str23 = str23;
                                                                                                                exc2 = e;
                                                                                                                arrayList = arrayList3;
                                                                                                                exc2.printStackTrace();
                                                                                                                if (jSONObject2.has("NewsCampaigns")) {
                                                                                                                    arrayList2 = arrayList;
                                                                                                                } else {
                                                                                                                    arrayList2 = arrayList;
                                                                                                                }
                                                                                                                eVar = eVar2;
                                                                                                                eVar.a(arrayList2);
                                                                                                                return eVar;
                                                                                                            }
                                                                                                        } catch (Exception e14) {
                                                                                                            e = e14;
                                                                                                            str26 = str15;
                                                                                                            str28 = str14;
                                                                                                            str21 = str21;
                                                                                                            str23 = str23;
                                                                                                            exc2 = e;
                                                                                                            arrayList = arrayList3;
                                                                                                            exc2.printStackTrace();
                                                                                                            if (jSONObject2.has("NewsCampaigns")) {
                                                                                                                arrayList2 = arrayList;
                                                                                                            } else {
                                                                                                                arrayList2 = arrayList;
                                                                                                            }
                                                                                                            eVar = eVar2;
                                                                                                            eVar.a(arrayList2);
                                                                                                            return eVar;
                                                                                                        }
                                                                                                    } catch (Exception e15) {
                                                                                                        e = e15;
                                                                                                        str29 = str13;
                                                                                                    }
                                                                                                } catch (Exception e16) {
                                                                                                    exc2 = e16;
                                                                                                    str29 = str13;
                                                                                                    str21 = str21;
                                                                                                    str23 = str23;
                                                                                                    arrayList = arrayList3;
                                                                                                    exc2.printStackTrace();
                                                                                                    if (jSONObject2.has("NewsCampaigns")) {
                                                                                                        arrayList2 = arrayList;
                                                                                                    } else {
                                                                                                        arrayList2 = arrayList;
                                                                                                    }
                                                                                                    eVar = eVar2;
                                                                                                    eVar.a(arrayList2);
                                                                                                    return eVar;
                                                                                                }
                                                                                            } else {
                                                                                                str14 = str28;
                                                                                                if (!jSONObject8.has(str14)) {
                                                                                                    str29 = str13;
                                                                                                } else if (jSONObject8.isNull(str14)) {
                                                                                                    str29 = str13;
                                                                                                    gVar3.h(jSONObject8.getString(str14));
                                                                                                    gVar3.t(jSONObject8.getString(str14));
                                                                                                } else {
                                                                                                    str29 = str13;
                                                                                                }
                                                                                                str15 = str26;
                                                                                                if (!jSONObject8.has(str15)) {
                                                                                                    str28 = str14;
                                                                                                } else if (jSONObject8.isNull(str15)) {
                                                                                                    str28 = str14;
                                                                                                    gVar3.i(jSONObject8.getString(str15));
                                                                                                    gVar3.o(jSONObject8.getString(str15));
                                                                                                } else {
                                                                                                    str28 = str14;
                                                                                                }
                                                                                                if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                                                    gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                                                }
                                                                                                if (jSONObject8.has("Height")) {
                                                                                                    gVar3.b(jSONObject8.getInt("Height"));
                                                                                                }
                                                                                                if (jSONObject8.has("IsDeeplink")) {
                                                                                                    gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                                                }
                                                                                                str23 = str23;
                                                                                                if (!jSONObject8.has(str23)) {
                                                                                                    str26 = str15;
                                                                                                } else if (jSONObject8.isNull(str23)) {
                                                                                                    str26 = str15;
                                                                                                    gVar3.d(jSONObject8.getInt(str23));
                                                                                                } else {
                                                                                                    str26 = str15;
                                                                                                }
                                                                                                str21 = str21;
                                                                                                if (jSONObject8.has(str21)) {
                                                                                                    gVar3.f(jSONObject8.getString(str21));
                                                                                                }
                                                                                                if (i3 == 43) {
                                                                                                    gVar3.f(true);
                                                                                                    z3 = false;
                                                                                                } else {
                                                                                                    if (i3 == 48) {
                                                                                                        gVar3.f(false);
                                                                                                        gVar3.b(true);
                                                                                                        z3 = false;
                                                                                                    } else {
                                                                                                        z3 = false;
                                                                                                        gVar3.f(false);
                                                                                                    }
                                                                                                    gVar3.k(z3);
                                                                                                    gVar3.F(eVar2.c());
                                                                                                    arrayList3.add(gVar3);
                                                                                                    i16++;
                                                                                                    str33 = str33;
                                                                                                    str31 = str31;
                                                                                                    str3 = str12;
                                                                                                    i = i3;
                                                                                                    str34 = str10;
                                                                                                    str9 = str11;
                                                                                                    str21 = str21;
                                                                                                    str23 = str23;
                                                                                                }
                                                                                                gVar3.b(z3);
                                                                                                gVar3.k(z3);
                                                                                                gVar3.F(eVar2.c());
                                                                                                arrayList3.add(gVar3);
                                                                                                i16++;
                                                                                                str33 = str33;
                                                                                                str31 = str31;
                                                                                                str3 = str12;
                                                                                                i = i3;
                                                                                                str34 = str10;
                                                                                                str9 = str11;
                                                                                                str21 = str21;
                                                                                                str23 = str23;
                                                                                            }
                                                                                        } catch (Exception e17) {
                                                                                            e = e17;
                                                                                            str29 = str13;
                                                                                        }
                                                                                    } catch (Exception e18) {
                                                                                        exc2 = e18;
                                                                                        str21 = str21;
                                                                                        str23 = str23;
                                                                                        arrayList = arrayList3;
                                                                                        exc2.printStackTrace();
                                                                                        if (jSONObject2.has("NewsCampaigns")) {
                                                                                            arrayList2 = arrayList;
                                                                                        } else {
                                                                                            arrayList2 = arrayList;
                                                                                        }
                                                                                        eVar = eVar2;
                                                                                        eVar.a(arrayList2);
                                                                                        return eVar;
                                                                                    }
                                                                                } else {
                                                                                    str13 = str29;
                                                                                    if (jSONObject8.has(str13)) {
                                                                                        if (!jSONObject8.isNull(str13)) {
                                                                                            gVar3.c(jSONObject8.getString(str13));
                                                                                        }
                                                                                        str14 = str28;
                                                                                        if (!jSONObject8.has(str14)) {
                                                                                            str29 = str13;
                                                                                        } else if (jSONObject8.isNull(str14)) {
                                                                                            str29 = str13;
                                                                                            gVar3.h(jSONObject8.getString(str14));
                                                                                            gVar3.t(jSONObject8.getString(str14));
                                                                                        } else {
                                                                                            str29 = str13;
                                                                                        }
                                                                                        str15 = str26;
                                                                                        if (!jSONObject8.has(str15)) {
                                                                                            str28 = str14;
                                                                                        } else if (jSONObject8.isNull(str15)) {
                                                                                            str28 = str14;
                                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                                        } else {
                                                                                            str28 = str14;
                                                                                        }
                                                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                                        }
                                                                                        if (jSONObject8.has("Height")) {
                                                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                                                        }
                                                                                        if (jSONObject8.has("IsDeeplink")) {
                                                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                                        }
                                                                                        str23 = str23;
                                                                                        if (!jSONObject8.has(str23)) {
                                                                                            str26 = str15;
                                                                                        } else if (jSONObject8.isNull(str23)) {
                                                                                            str26 = str15;
                                                                                            gVar3.d(jSONObject8.getInt(str23));
                                                                                        } else {
                                                                                            str26 = str15;
                                                                                        }
                                                                                        str21 = str21;
                                                                                        if (jSONObject8.has(str21)) {
                                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                                        }
                                                                                        if (i3 == 43) {
                                                                                            gVar3.f(true);
                                                                                            z3 = false;
                                                                                        } else {
                                                                                            if (i3 == 48) {
                                                                                                gVar3.f(false);
                                                                                                gVar3.b(true);
                                                                                                z3 = false;
                                                                                            } else {
                                                                                                z3 = false;
                                                                                                gVar3.f(false);
                                                                                            }
                                                                                            gVar3.k(z3);
                                                                                            gVar3.F(eVar2.c());
                                                                                            arrayList3.add(gVar3);
                                                                                            i16++;
                                                                                            str33 = str33;
                                                                                            str31 = str31;
                                                                                            str3 = str12;
                                                                                            i = i3;
                                                                                            str34 = str10;
                                                                                            str9 = str11;
                                                                                            str21 = str21;
                                                                                            str23 = str23;
                                                                                        }
                                                                                        gVar3.b(z3);
                                                                                        gVar3.k(z3);
                                                                                        gVar3.F(eVar2.c());
                                                                                        arrayList3.add(gVar3);
                                                                                        i16++;
                                                                                        str33 = str33;
                                                                                        str31 = str31;
                                                                                        str3 = str12;
                                                                                        i = i3;
                                                                                        str34 = str10;
                                                                                        str9 = str11;
                                                                                        str21 = str21;
                                                                                        str23 = str23;
                                                                                    } else {
                                                                                        str14 = str28;
                                                                                        if (!jSONObject8.has(str14)) {
                                                                                            str29 = str13;
                                                                                        } else if (jSONObject8.isNull(str14)) {
                                                                                            str29 = str13;
                                                                                            gVar3.h(jSONObject8.getString(str14));
                                                                                            gVar3.t(jSONObject8.getString(str14));
                                                                                        } else {
                                                                                            str29 = str13;
                                                                                        }
                                                                                        str15 = str26;
                                                                                        if (!jSONObject8.has(str15)) {
                                                                                            str28 = str14;
                                                                                        } else if (jSONObject8.isNull(str15)) {
                                                                                            str28 = str14;
                                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                                        } else {
                                                                                            str28 = str14;
                                                                                        }
                                                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                                        }
                                                                                        if (jSONObject8.has("Height")) {
                                                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                                                        }
                                                                                        if (jSONObject8.has("IsDeeplink")) {
                                                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                                        }
                                                                                        str23 = str23;
                                                                                        if (!jSONObject8.has(str23)) {
                                                                                            str26 = str15;
                                                                                        } else if (jSONObject8.isNull(str23)) {
                                                                                            str26 = str15;
                                                                                            gVar3.d(jSONObject8.getInt(str23));
                                                                                        } else {
                                                                                            str26 = str15;
                                                                                        }
                                                                                        str21 = str21;
                                                                                        if (jSONObject8.has(str21)) {
                                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                                        }
                                                                                        if (i3 == 43) {
                                                                                            gVar3.f(true);
                                                                                            z3 = false;
                                                                                        } else {
                                                                                            if (i3 == 48) {
                                                                                                gVar3.f(false);
                                                                                                gVar3.b(true);
                                                                                                z3 = false;
                                                                                            } else {
                                                                                                z3 = false;
                                                                                                gVar3.f(false);
                                                                                            }
                                                                                            gVar3.k(z3);
                                                                                            gVar3.F(eVar2.c());
                                                                                            arrayList3.add(gVar3);
                                                                                            i16++;
                                                                                            str33 = str33;
                                                                                            str31 = str31;
                                                                                            str3 = str12;
                                                                                            i = i3;
                                                                                            str34 = str10;
                                                                                            str9 = str11;
                                                                                            str21 = str21;
                                                                                            str23 = str23;
                                                                                        }
                                                                                        gVar3.b(z3);
                                                                                        gVar3.k(z3);
                                                                                        gVar3.F(eVar2.c());
                                                                                        arrayList3.add(gVar3);
                                                                                        i16++;
                                                                                        str33 = str33;
                                                                                        str31 = str31;
                                                                                        str3 = str12;
                                                                                        i = i3;
                                                                                        str34 = str10;
                                                                                        str9 = str11;
                                                                                        str21 = str21;
                                                                                        str23 = str23;
                                                                                    }
                                                                                }
                                                                            } catch (Exception e19) {
                                                                                e = e19;
                                                                            }
                                                                        } catch (Exception e20) {
                                                                            exc2 = e20;
                                                                            str21 = str21;
                                                                            str23 = str23;
                                                                            str31 = str31;
                                                                            arrayList = arrayList3;
                                                                            exc2.printStackTrace();
                                                                            if (jSONObject2.has("NewsCampaigns")) {
                                                                                arrayList2 = arrayList;
                                                                            } else {
                                                                                arrayList2 = arrayList;
                                                                            }
                                                                            eVar = eVar2;
                                                                            eVar.a(arrayList2);
                                                                            return eVar;
                                                                        }
                                                                    } else {
                                                                        str31 = str31;
                                                                        if (jSONObject8.has(str31)) {
                                                                            if (!jSONObject8.isNull(str31)) {
                                                                                gVar3.e(jSONObject8.getString(str31));
                                                                            }
                                                                            str13 = str29;
                                                                            if (jSONObject8.has(str13)) {
                                                                                if (!jSONObject8.isNull(str13)) {
                                                                                    gVar3.c(jSONObject8.getString(str13));
                                                                                }
                                                                                str14 = str28;
                                                                                if (!jSONObject8.has(str14)) {
                                                                                    str29 = str13;
                                                                                } else if (jSONObject8.isNull(str14)) {
                                                                                    str29 = str13;
                                                                                    gVar3.h(jSONObject8.getString(str14));
                                                                                    gVar3.t(jSONObject8.getString(str14));
                                                                                } else {
                                                                                    str29 = str13;
                                                                                }
                                                                                str15 = str26;
                                                                                if (!jSONObject8.has(str15)) {
                                                                                    str28 = str14;
                                                                                } else if (jSONObject8.isNull(str15)) {
                                                                                    str28 = str14;
                                                                                    gVar3.i(jSONObject8.getString(str15));
                                                                                    gVar3.o(jSONObject8.getString(str15));
                                                                                } else {
                                                                                    str28 = str14;
                                                                                }
                                                                                if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                                    gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                                }
                                                                                if (jSONObject8.has("Height")) {
                                                                                    gVar3.b(jSONObject8.getInt("Height"));
                                                                                }
                                                                                if (jSONObject8.has("IsDeeplink")) {
                                                                                    gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                                }
                                                                                str23 = str23;
                                                                                if (!jSONObject8.has(str23)) {
                                                                                    str26 = str15;
                                                                                } else if (jSONObject8.isNull(str23)) {
                                                                                    str26 = str15;
                                                                                    gVar3.d(jSONObject8.getInt(str23));
                                                                                } else {
                                                                                    str26 = str15;
                                                                                }
                                                                                str21 = str21;
                                                                                if (jSONObject8.has(str21)) {
                                                                                    gVar3.f(jSONObject8.getString(str21));
                                                                                }
                                                                                if (i3 == 43) {
                                                                                    gVar3.f(true);
                                                                                    z3 = false;
                                                                                } else {
                                                                                    if (i3 == 48) {
                                                                                        gVar3.f(false);
                                                                                        gVar3.b(true);
                                                                                        z3 = false;
                                                                                    } else {
                                                                                        z3 = false;
                                                                                        gVar3.f(false);
                                                                                    }
                                                                                    gVar3.k(z3);
                                                                                    gVar3.F(eVar2.c());
                                                                                    arrayList3.add(gVar3);
                                                                                    i16++;
                                                                                    str33 = str33;
                                                                                    str31 = str31;
                                                                                    str3 = str12;
                                                                                    i = i3;
                                                                                    str34 = str10;
                                                                                    str9 = str11;
                                                                                    str21 = str21;
                                                                                    str23 = str23;
                                                                                }
                                                                                gVar3.b(z3);
                                                                                gVar3.k(z3);
                                                                                gVar3.F(eVar2.c());
                                                                                arrayList3.add(gVar3);
                                                                                i16++;
                                                                                str33 = str33;
                                                                                str31 = str31;
                                                                                str3 = str12;
                                                                                i = i3;
                                                                                str34 = str10;
                                                                                str9 = str11;
                                                                                str21 = str21;
                                                                                str23 = str23;
                                                                            } else {
                                                                                str14 = str28;
                                                                                if (!jSONObject8.has(str14)) {
                                                                                    str29 = str13;
                                                                                } else if (jSONObject8.isNull(str14)) {
                                                                                    str29 = str13;
                                                                                    gVar3.h(jSONObject8.getString(str14));
                                                                                    gVar3.t(jSONObject8.getString(str14));
                                                                                } else {
                                                                                    str29 = str13;
                                                                                }
                                                                                str15 = str26;
                                                                                if (!jSONObject8.has(str15)) {
                                                                                    str28 = str14;
                                                                                } else if (jSONObject8.isNull(str15)) {
                                                                                    str28 = str14;
                                                                                    gVar3.i(jSONObject8.getString(str15));
                                                                                    gVar3.o(jSONObject8.getString(str15));
                                                                                } else {
                                                                                    str28 = str14;
                                                                                }
                                                                                if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                                    gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                                }
                                                                                if (jSONObject8.has("Height")) {
                                                                                    gVar3.b(jSONObject8.getInt("Height"));
                                                                                }
                                                                                if (jSONObject8.has("IsDeeplink")) {
                                                                                    gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                                }
                                                                                str23 = str23;
                                                                                if (!jSONObject8.has(str23)) {
                                                                                    str26 = str15;
                                                                                } else if (jSONObject8.isNull(str23)) {
                                                                                    str26 = str15;
                                                                                    gVar3.d(jSONObject8.getInt(str23));
                                                                                } else {
                                                                                    str26 = str15;
                                                                                }
                                                                                str21 = str21;
                                                                                if (jSONObject8.has(str21)) {
                                                                                    gVar3.f(jSONObject8.getString(str21));
                                                                                }
                                                                                if (i3 == 43) {
                                                                                    gVar3.f(true);
                                                                                    z3 = false;
                                                                                } else {
                                                                                    if (i3 == 48) {
                                                                                        gVar3.f(false);
                                                                                        gVar3.b(true);
                                                                                        z3 = false;
                                                                                    } else {
                                                                                        z3 = false;
                                                                                        gVar3.f(false);
                                                                                    }
                                                                                    gVar3.k(z3);
                                                                                    gVar3.F(eVar2.c());
                                                                                    arrayList3.add(gVar3);
                                                                                    i16++;
                                                                                    str33 = str33;
                                                                                    str31 = str31;
                                                                                    str3 = str12;
                                                                                    i = i3;
                                                                                    str34 = str10;
                                                                                    str9 = str11;
                                                                                    str21 = str21;
                                                                                    str23 = str23;
                                                                                }
                                                                                gVar3.b(z3);
                                                                                gVar3.k(z3);
                                                                                gVar3.F(eVar2.c());
                                                                                arrayList3.add(gVar3);
                                                                                i16++;
                                                                                str33 = str33;
                                                                                str31 = str31;
                                                                                str3 = str12;
                                                                                i = i3;
                                                                                str34 = str10;
                                                                                str9 = str11;
                                                                                str21 = str21;
                                                                                str23 = str23;
                                                                            }
                                                                        } else {
                                                                            str13 = str29;
                                                                            if (jSONObject8.has(str13)) {
                                                                                if (!jSONObject8.isNull(str13)) {
                                                                                    gVar3.c(jSONObject8.getString(str13));
                                                                                }
                                                                                str14 = str28;
                                                                                if (!jSONObject8.has(str14)) {
                                                                                    str29 = str13;
                                                                                } else if (jSONObject8.isNull(str14)) {
                                                                                    str29 = str13;
                                                                                    gVar3.h(jSONObject8.getString(str14));
                                                                                    gVar3.t(jSONObject8.getString(str14));
                                                                                } else {
                                                                                    str29 = str13;
                                                                                }
                                                                                str15 = str26;
                                                                                if (!jSONObject8.has(str15)) {
                                                                                    str28 = str14;
                                                                                } else if (jSONObject8.isNull(str15)) {
                                                                                    str28 = str14;
                                                                                    gVar3.i(jSONObject8.getString(str15));
                                                                                    gVar3.o(jSONObject8.getString(str15));
                                                                                } else {
                                                                                    str28 = str14;
                                                                                }
                                                                                if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                                    gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                                }
                                                                                if (jSONObject8.has("Height")) {
                                                                                    gVar3.b(jSONObject8.getInt("Height"));
                                                                                }
                                                                                if (jSONObject8.has("IsDeeplink")) {
                                                                                    gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                                }
                                                                                str23 = str23;
                                                                                if (!jSONObject8.has(str23)) {
                                                                                    str26 = str15;
                                                                                } else if (jSONObject8.isNull(str23)) {
                                                                                    str26 = str15;
                                                                                    gVar3.d(jSONObject8.getInt(str23));
                                                                                } else {
                                                                                    str26 = str15;
                                                                                }
                                                                                str21 = str21;
                                                                                if (jSONObject8.has(str21)) {
                                                                                    gVar3.f(jSONObject8.getString(str21));
                                                                                }
                                                                                if (i3 == 43) {
                                                                                    gVar3.f(true);
                                                                                    z3 = false;
                                                                                } else {
                                                                                    if (i3 == 48) {
                                                                                        gVar3.f(false);
                                                                                        gVar3.b(true);
                                                                                        z3 = false;
                                                                                    } else {
                                                                                        z3 = false;
                                                                                        gVar3.f(false);
                                                                                    }
                                                                                    gVar3.k(z3);
                                                                                    gVar3.F(eVar2.c());
                                                                                    arrayList3.add(gVar3);
                                                                                    i16++;
                                                                                    str33 = str33;
                                                                                    str31 = str31;
                                                                                    str3 = str12;
                                                                                    i = i3;
                                                                                    str34 = str10;
                                                                                    str9 = str11;
                                                                                    str21 = str21;
                                                                                    str23 = str23;
                                                                                }
                                                                                gVar3.b(z3);
                                                                                gVar3.k(z3);
                                                                                gVar3.F(eVar2.c());
                                                                                arrayList3.add(gVar3);
                                                                                i16++;
                                                                                str33 = str33;
                                                                                str31 = str31;
                                                                                str3 = str12;
                                                                                i = i3;
                                                                                str34 = str10;
                                                                                str9 = str11;
                                                                                str21 = str21;
                                                                                str23 = str23;
                                                                            } else {
                                                                                str14 = str28;
                                                                                if (!jSONObject8.has(str14)) {
                                                                                    str29 = str13;
                                                                                } else if (jSONObject8.isNull(str14)) {
                                                                                    str29 = str13;
                                                                                    gVar3.h(jSONObject8.getString(str14));
                                                                                    gVar3.t(jSONObject8.getString(str14));
                                                                                } else {
                                                                                    str29 = str13;
                                                                                }
                                                                                str15 = str26;
                                                                                if (!jSONObject8.has(str15)) {
                                                                                    str28 = str14;
                                                                                } else if (jSONObject8.isNull(str15)) {
                                                                                    str28 = str14;
                                                                                    gVar3.i(jSONObject8.getString(str15));
                                                                                    gVar3.o(jSONObject8.getString(str15));
                                                                                } else {
                                                                                    str28 = str14;
                                                                                }
                                                                                if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                                    gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                                }
                                                                                if (jSONObject8.has("Height")) {
                                                                                    gVar3.b(jSONObject8.getInt("Height"));
                                                                                }
                                                                                if (jSONObject8.has("IsDeeplink")) {
                                                                                    gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                                }
                                                                                str23 = str23;
                                                                                if (!jSONObject8.has(str23)) {
                                                                                    str26 = str15;
                                                                                } else if (jSONObject8.isNull(str23)) {
                                                                                    str26 = str15;
                                                                                    gVar3.d(jSONObject8.getInt(str23));
                                                                                } else {
                                                                                    str26 = str15;
                                                                                }
                                                                                str21 = str21;
                                                                                if (jSONObject8.has(str21)) {
                                                                                    gVar3.f(jSONObject8.getString(str21));
                                                                                }
                                                                                if (i3 == 43) {
                                                                                    gVar3.f(true);
                                                                                    z3 = false;
                                                                                } else {
                                                                                    if (i3 == 48) {
                                                                                        gVar3.f(false);
                                                                                        gVar3.b(true);
                                                                                        z3 = false;
                                                                                    } else {
                                                                                        z3 = false;
                                                                                        gVar3.f(false);
                                                                                    }
                                                                                    gVar3.k(z3);
                                                                                    gVar3.F(eVar2.c());
                                                                                    arrayList3.add(gVar3);
                                                                                    i16++;
                                                                                    str33 = str33;
                                                                                    str31 = str31;
                                                                                    str3 = str12;
                                                                                    i = i3;
                                                                                    str34 = str10;
                                                                                    str9 = str11;
                                                                                    str21 = str21;
                                                                                    str23 = str23;
                                                                                }
                                                                                gVar3.b(z3);
                                                                                gVar3.k(z3);
                                                                                gVar3.F(eVar2.c());
                                                                                arrayList3.add(gVar3);
                                                                                i16++;
                                                                                str33 = str33;
                                                                                str31 = str31;
                                                                                str3 = str12;
                                                                                i = i3;
                                                                                str34 = str10;
                                                                                str9 = str11;
                                                                                str21 = str21;
                                                                                str23 = str23;
                                                                            }
                                                                        }
                                                                    }
                                                                } catch (Exception e21) {
                                                                    e = e21;
                                                                    str21 = str21;
                                                                    str23 = str23;
                                                                    str31 = str31;
                                                                }
                                                            } catch (Exception e22) {
                                                                exc2 = e22;
                                                                str21 = str21;
                                                                str23 = str23;
                                                                str31 = str31;
                                                                str33 = str33;
                                                                arrayList = arrayList3;
                                                                exc2.printStackTrace();
                                                                if (jSONObject2.has("NewsCampaigns")) {
                                                                    arrayList2 = arrayList;
                                                                } else {
                                                                    arrayList2 = arrayList;
                                                                }
                                                                eVar = eVar2;
                                                                eVar.a(arrayList2);
                                                                return eVar;
                                                            }
                                                        } else {
                                                            if (jSONObject8.has("Name")) {
                                                                gVar3.j(jSONObject8.getString("Name"));
                                                            }
                                                            if (!jSONObject8.has("ImpressionURLs")) {
                                                            }
                                                            if (jSONObject8.has("ClickTrackingURLs")) {
                                                                jSONArray2 = new JSONArray(jSONObject8.getString("ClickTrackingURLs"));
                                                                if (jSONArray2.length() > 0) {
                                                                    arrayList4 = new ArrayList();
                                                                    while (i4 < jSONArray2.length()) {
                                                                        arrayList4.add(jSONArray2.getString(i4));
                                                                    }
                                                                    gVar3.a(arrayList4);
                                                                }
                                                            }
                                                            if (jSONObject8.has(ADXLogUtil.EVENT_REWARD)) {
                                                                gVar3.e(jSONObject8.getInt(ADXLogUtil.EVENT_REWARD));
                                                            }
                                                            if (jSONObject8.has("Title")) {
                                                                gVar3.k(jSONObject8.getString("Title"));
                                                            }
                                                            str33 = str33;
                                                            if (jSONObject8.has(str33)) {
                                                                if (!jSONObject8.isNull(str33)) {
                                                                    gVar3.g(jSONObject8.getString(str33));
                                                                }
                                                                str31 = str31;
                                                                if (jSONObject8.has(str31)) {
                                                                    if (!jSONObject8.isNull(str31)) {
                                                                        gVar3.e(jSONObject8.getString(str31));
                                                                    }
                                                                    str13 = str29;
                                                                    if (jSONObject8.has(str13)) {
                                                                        if (!jSONObject8.isNull(str13)) {
                                                                            gVar3.c(jSONObject8.getString(str13));
                                                                        }
                                                                        str14 = str28;
                                                                        if (!jSONObject8.has(str14)) {
                                                                            str29 = str13;
                                                                        } else if (jSONObject8.isNull(str14)) {
                                                                            str29 = str13;
                                                                            gVar3.h(jSONObject8.getString(str14));
                                                                            gVar3.t(jSONObject8.getString(str14));
                                                                        } else {
                                                                            str29 = str13;
                                                                        }
                                                                        str15 = str26;
                                                                        if (!jSONObject8.has(str15)) {
                                                                            str28 = str14;
                                                                        } else if (jSONObject8.isNull(str15)) {
                                                                            str28 = str14;
                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                        } else {
                                                                            str28 = str14;
                                                                        }
                                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                        }
                                                                        if (jSONObject8.has("Height")) {
                                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                                        }
                                                                        if (jSONObject8.has("IsDeeplink")) {
                                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                        }
                                                                        str23 = str23;
                                                                        if (!jSONObject8.has(str23)) {
                                                                            str26 = str15;
                                                                        } else if (jSONObject8.isNull(str23)) {
                                                                            str26 = str15;
                                                                            gVar3.d(jSONObject8.getInt(str23));
                                                                        } else {
                                                                            str26 = str15;
                                                                        }
                                                                        str21 = str21;
                                                                        if (jSONObject8.has(str21)) {
                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                        }
                                                                        if (i3 == 43) {
                                                                            gVar3.f(true);
                                                                            z3 = false;
                                                                        } else {
                                                                            if (i3 == 48) {
                                                                                gVar3.f(false);
                                                                                gVar3.b(true);
                                                                                z3 = false;
                                                                            } else {
                                                                                z3 = false;
                                                                                gVar3.f(false);
                                                                            }
                                                                            gVar3.k(z3);
                                                                            gVar3.F(eVar2.c());
                                                                            arrayList3.add(gVar3);
                                                                            i16++;
                                                                            str33 = str33;
                                                                            str31 = str31;
                                                                            str3 = str12;
                                                                            i = i3;
                                                                            str34 = str10;
                                                                            str9 = str11;
                                                                            str21 = str21;
                                                                            str23 = str23;
                                                                        }
                                                                        gVar3.b(z3);
                                                                        gVar3.k(z3);
                                                                        gVar3.F(eVar2.c());
                                                                        arrayList3.add(gVar3);
                                                                        i16++;
                                                                        str33 = str33;
                                                                        str31 = str31;
                                                                        str3 = str12;
                                                                        i = i3;
                                                                        str34 = str10;
                                                                        str9 = str11;
                                                                        str21 = str21;
                                                                        str23 = str23;
                                                                    } else {
                                                                        str14 = str28;
                                                                        if (!jSONObject8.has(str14)) {
                                                                            str29 = str13;
                                                                        } else if (jSONObject8.isNull(str14)) {
                                                                            str29 = str13;
                                                                            gVar3.h(jSONObject8.getString(str14));
                                                                            gVar3.t(jSONObject8.getString(str14));
                                                                        } else {
                                                                            str29 = str13;
                                                                        }
                                                                        str15 = str26;
                                                                        if (!jSONObject8.has(str15)) {
                                                                            str28 = str14;
                                                                        } else if (jSONObject8.isNull(str15)) {
                                                                            str28 = str14;
                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                        } else {
                                                                            str28 = str14;
                                                                        }
                                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                        }
                                                                        if (jSONObject8.has("Height")) {
                                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                                        }
                                                                        if (jSONObject8.has("IsDeeplink")) {
                                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                        }
                                                                        str23 = str23;
                                                                        if (!jSONObject8.has(str23)) {
                                                                            str26 = str15;
                                                                        } else if (jSONObject8.isNull(str23)) {
                                                                            str26 = str15;
                                                                            gVar3.d(jSONObject8.getInt(str23));
                                                                        } else {
                                                                            str26 = str15;
                                                                        }
                                                                        str21 = str21;
                                                                        if (jSONObject8.has(str21)) {
                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                        }
                                                                        if (i3 == 43) {
                                                                            gVar3.f(true);
                                                                            z3 = false;
                                                                        } else {
                                                                            if (i3 == 48) {
                                                                                gVar3.f(false);
                                                                                gVar3.b(true);
                                                                                z3 = false;
                                                                            } else {
                                                                                z3 = false;
                                                                                gVar3.f(false);
                                                                            }
                                                                            gVar3.k(z3);
                                                                            gVar3.F(eVar2.c());
                                                                            arrayList3.add(gVar3);
                                                                            i16++;
                                                                            str33 = str33;
                                                                            str31 = str31;
                                                                            str3 = str12;
                                                                            i = i3;
                                                                            str34 = str10;
                                                                            str9 = str11;
                                                                            str21 = str21;
                                                                            str23 = str23;
                                                                        }
                                                                        gVar3.b(z3);
                                                                        gVar3.k(z3);
                                                                        gVar3.F(eVar2.c());
                                                                        arrayList3.add(gVar3);
                                                                        i16++;
                                                                        str33 = str33;
                                                                        str31 = str31;
                                                                        str3 = str12;
                                                                        i = i3;
                                                                        str34 = str10;
                                                                        str9 = str11;
                                                                        str21 = str21;
                                                                        str23 = str23;
                                                                    }
                                                                } else {
                                                                    str13 = str29;
                                                                    if (jSONObject8.has(str13)) {
                                                                        if (!jSONObject8.isNull(str13)) {
                                                                            gVar3.c(jSONObject8.getString(str13));
                                                                        }
                                                                        str14 = str28;
                                                                        if (!jSONObject8.has(str14)) {
                                                                            str29 = str13;
                                                                        } else if (jSONObject8.isNull(str14)) {
                                                                            str29 = str13;
                                                                            gVar3.h(jSONObject8.getString(str14));
                                                                            gVar3.t(jSONObject8.getString(str14));
                                                                        } else {
                                                                            str29 = str13;
                                                                        }
                                                                        str15 = str26;
                                                                        if (!jSONObject8.has(str15)) {
                                                                            str28 = str14;
                                                                        } else if (jSONObject8.isNull(str15)) {
                                                                            str28 = str14;
                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                        } else {
                                                                            str28 = str14;
                                                                        }
                                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                        }
                                                                        if (jSONObject8.has("Height")) {
                                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                                        }
                                                                        if (jSONObject8.has("IsDeeplink")) {
                                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                        }
                                                                        str23 = str23;
                                                                        if (!jSONObject8.has(str23)) {
                                                                            str26 = str15;
                                                                        } else if (jSONObject8.isNull(str23)) {
                                                                            str26 = str15;
                                                                            gVar3.d(jSONObject8.getInt(str23));
                                                                        } else {
                                                                            str26 = str15;
                                                                        }
                                                                        str21 = str21;
                                                                        if (jSONObject8.has(str21)) {
                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                        }
                                                                        if (i3 == 43) {
                                                                            gVar3.f(true);
                                                                            z3 = false;
                                                                        } else {
                                                                            if (i3 == 48) {
                                                                                gVar3.f(false);
                                                                                gVar3.b(true);
                                                                                z3 = false;
                                                                            } else {
                                                                                z3 = false;
                                                                                gVar3.f(false);
                                                                            }
                                                                            gVar3.k(z3);
                                                                            gVar3.F(eVar2.c());
                                                                            arrayList3.add(gVar3);
                                                                            i16++;
                                                                            str33 = str33;
                                                                            str31 = str31;
                                                                            str3 = str12;
                                                                            i = i3;
                                                                            str34 = str10;
                                                                            str9 = str11;
                                                                            str21 = str21;
                                                                            str23 = str23;
                                                                        }
                                                                        gVar3.b(z3);
                                                                        gVar3.k(z3);
                                                                        gVar3.F(eVar2.c());
                                                                        arrayList3.add(gVar3);
                                                                        i16++;
                                                                        str33 = str33;
                                                                        str31 = str31;
                                                                        str3 = str12;
                                                                        i = i3;
                                                                        str34 = str10;
                                                                        str9 = str11;
                                                                        str21 = str21;
                                                                        str23 = str23;
                                                                    } else {
                                                                        str14 = str28;
                                                                        if (!jSONObject8.has(str14)) {
                                                                            str29 = str13;
                                                                        } else if (jSONObject8.isNull(str14)) {
                                                                            str29 = str13;
                                                                            gVar3.h(jSONObject8.getString(str14));
                                                                            gVar3.t(jSONObject8.getString(str14));
                                                                        } else {
                                                                            str29 = str13;
                                                                        }
                                                                        str15 = str26;
                                                                        if (!jSONObject8.has(str15)) {
                                                                            str28 = str14;
                                                                        } else if (jSONObject8.isNull(str15)) {
                                                                            str28 = str14;
                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                        } else {
                                                                            str28 = str14;
                                                                        }
                                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                        }
                                                                        if (jSONObject8.has("Height")) {
                                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                                        }
                                                                        if (jSONObject8.has("IsDeeplink")) {
                                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                        }
                                                                        str23 = str23;
                                                                        if (!jSONObject8.has(str23)) {
                                                                            str26 = str15;
                                                                        } else if (jSONObject8.isNull(str23)) {
                                                                            str26 = str15;
                                                                            gVar3.d(jSONObject8.getInt(str23));
                                                                        } else {
                                                                            str26 = str15;
                                                                        }
                                                                        str21 = str21;
                                                                        if (jSONObject8.has(str21)) {
                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                        }
                                                                        if (i3 == 43) {
                                                                            gVar3.f(true);
                                                                            z3 = false;
                                                                        } else {
                                                                            if (i3 == 48) {
                                                                                gVar3.f(false);
                                                                                gVar3.b(true);
                                                                                z3 = false;
                                                                            } else {
                                                                                z3 = false;
                                                                                gVar3.f(false);
                                                                            }
                                                                            gVar3.k(z3);
                                                                            gVar3.F(eVar2.c());
                                                                            arrayList3.add(gVar3);
                                                                            i16++;
                                                                            str33 = str33;
                                                                            str31 = str31;
                                                                            str3 = str12;
                                                                            i = i3;
                                                                            str34 = str10;
                                                                            str9 = str11;
                                                                            str21 = str21;
                                                                            str23 = str23;
                                                                        }
                                                                        gVar3.b(z3);
                                                                        gVar3.k(z3);
                                                                        gVar3.F(eVar2.c());
                                                                        arrayList3.add(gVar3);
                                                                        i16++;
                                                                        str33 = str33;
                                                                        str31 = str31;
                                                                        str3 = str12;
                                                                        i = i3;
                                                                        str34 = str10;
                                                                        str9 = str11;
                                                                        str21 = str21;
                                                                        str23 = str23;
                                                                    }
                                                                }
                                                            } else {
                                                                str31 = str31;
                                                                if (jSONObject8.has(str31)) {
                                                                    if (!jSONObject8.isNull(str31)) {
                                                                        gVar3.e(jSONObject8.getString(str31));
                                                                    }
                                                                    str13 = str29;
                                                                    if (jSONObject8.has(str13)) {
                                                                        if (!jSONObject8.isNull(str13)) {
                                                                            gVar3.c(jSONObject8.getString(str13));
                                                                        }
                                                                        str14 = str28;
                                                                        if (!jSONObject8.has(str14)) {
                                                                            str29 = str13;
                                                                        } else if (jSONObject8.isNull(str14)) {
                                                                            str29 = str13;
                                                                            gVar3.h(jSONObject8.getString(str14));
                                                                            gVar3.t(jSONObject8.getString(str14));
                                                                        } else {
                                                                            str29 = str13;
                                                                        }
                                                                        str15 = str26;
                                                                        if (!jSONObject8.has(str15)) {
                                                                            str28 = str14;
                                                                        } else if (jSONObject8.isNull(str15)) {
                                                                            str28 = str14;
                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                        } else {
                                                                            str28 = str14;
                                                                        }
                                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                        }
                                                                        if (jSONObject8.has("Height")) {
                                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                                        }
                                                                        if (jSONObject8.has("IsDeeplink")) {
                                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                        }
                                                                        str23 = str23;
                                                                        if (!jSONObject8.has(str23)) {
                                                                            str26 = str15;
                                                                        } else if (jSONObject8.isNull(str23)) {
                                                                            str26 = str15;
                                                                            gVar3.d(jSONObject8.getInt(str23));
                                                                        } else {
                                                                            str26 = str15;
                                                                        }
                                                                        str21 = str21;
                                                                        if (jSONObject8.has(str21)) {
                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                        }
                                                                        if (i3 == 43) {
                                                                            gVar3.f(true);
                                                                            z3 = false;
                                                                        } else {
                                                                            if (i3 == 48) {
                                                                                gVar3.f(false);
                                                                                gVar3.b(true);
                                                                                z3 = false;
                                                                            } else {
                                                                                z3 = false;
                                                                                gVar3.f(false);
                                                                            }
                                                                            gVar3.k(z3);
                                                                            gVar3.F(eVar2.c());
                                                                            arrayList3.add(gVar3);
                                                                            i16++;
                                                                            str33 = str33;
                                                                            str31 = str31;
                                                                            str3 = str12;
                                                                            i = i3;
                                                                            str34 = str10;
                                                                            str9 = str11;
                                                                            str21 = str21;
                                                                            str23 = str23;
                                                                        }
                                                                        gVar3.b(z3);
                                                                        gVar3.k(z3);
                                                                        gVar3.F(eVar2.c());
                                                                        arrayList3.add(gVar3);
                                                                        i16++;
                                                                        str33 = str33;
                                                                        str31 = str31;
                                                                        str3 = str12;
                                                                        i = i3;
                                                                        str34 = str10;
                                                                        str9 = str11;
                                                                        str21 = str21;
                                                                        str23 = str23;
                                                                    } else {
                                                                        str14 = str28;
                                                                        if (!jSONObject8.has(str14)) {
                                                                            str29 = str13;
                                                                        } else if (jSONObject8.isNull(str14)) {
                                                                            str29 = str13;
                                                                            gVar3.h(jSONObject8.getString(str14));
                                                                            gVar3.t(jSONObject8.getString(str14));
                                                                        } else {
                                                                            str29 = str13;
                                                                        }
                                                                        str15 = str26;
                                                                        if (!jSONObject8.has(str15)) {
                                                                            str28 = str14;
                                                                        } else if (jSONObject8.isNull(str15)) {
                                                                            str28 = str14;
                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                        } else {
                                                                            str28 = str14;
                                                                        }
                                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                        }
                                                                        if (jSONObject8.has("Height")) {
                                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                                        }
                                                                        if (jSONObject8.has("IsDeeplink")) {
                                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                        }
                                                                        str23 = str23;
                                                                        if (!jSONObject8.has(str23)) {
                                                                            str26 = str15;
                                                                        } else if (jSONObject8.isNull(str23)) {
                                                                            str26 = str15;
                                                                            gVar3.d(jSONObject8.getInt(str23));
                                                                        } else {
                                                                            str26 = str15;
                                                                        }
                                                                        str21 = str21;
                                                                        if (jSONObject8.has(str21)) {
                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                        }
                                                                        if (i3 == 43) {
                                                                            gVar3.f(true);
                                                                            z3 = false;
                                                                        } else {
                                                                            if (i3 == 48) {
                                                                                gVar3.f(false);
                                                                                gVar3.b(true);
                                                                                z3 = false;
                                                                            } else {
                                                                                z3 = false;
                                                                                gVar3.f(false);
                                                                            }
                                                                            gVar3.k(z3);
                                                                            gVar3.F(eVar2.c());
                                                                            arrayList3.add(gVar3);
                                                                            i16++;
                                                                            str33 = str33;
                                                                            str31 = str31;
                                                                            str3 = str12;
                                                                            i = i3;
                                                                            str34 = str10;
                                                                            str9 = str11;
                                                                            str21 = str21;
                                                                            str23 = str23;
                                                                        }
                                                                        gVar3.b(z3);
                                                                        gVar3.k(z3);
                                                                        gVar3.F(eVar2.c());
                                                                        arrayList3.add(gVar3);
                                                                        i16++;
                                                                        str33 = str33;
                                                                        str31 = str31;
                                                                        str3 = str12;
                                                                        i = i3;
                                                                        str34 = str10;
                                                                        str9 = str11;
                                                                        str21 = str21;
                                                                        str23 = str23;
                                                                    }
                                                                } else {
                                                                    str13 = str29;
                                                                    if (jSONObject8.has(str13)) {
                                                                        if (!jSONObject8.isNull(str13)) {
                                                                            gVar3.c(jSONObject8.getString(str13));
                                                                        }
                                                                        str14 = str28;
                                                                        if (!jSONObject8.has(str14)) {
                                                                            str29 = str13;
                                                                        } else if (jSONObject8.isNull(str14)) {
                                                                            str29 = str13;
                                                                            gVar3.h(jSONObject8.getString(str14));
                                                                            gVar3.t(jSONObject8.getString(str14));
                                                                        } else {
                                                                            str29 = str13;
                                                                        }
                                                                        str15 = str26;
                                                                        if (!jSONObject8.has(str15)) {
                                                                            str28 = str14;
                                                                        } else if (jSONObject8.isNull(str15)) {
                                                                            str28 = str14;
                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                        } else {
                                                                            str28 = str14;
                                                                        }
                                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                        }
                                                                        if (jSONObject8.has("Height")) {
                                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                                        }
                                                                        if (jSONObject8.has("IsDeeplink")) {
                                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                        }
                                                                        str23 = str23;
                                                                        if (!jSONObject8.has(str23)) {
                                                                            str26 = str15;
                                                                        } else if (jSONObject8.isNull(str23)) {
                                                                            str26 = str15;
                                                                            gVar3.d(jSONObject8.getInt(str23));
                                                                        } else {
                                                                            str26 = str15;
                                                                        }
                                                                        str21 = str21;
                                                                        if (jSONObject8.has(str21)) {
                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                        }
                                                                        if (i3 == 43) {
                                                                            gVar3.f(true);
                                                                            z3 = false;
                                                                        } else {
                                                                            if (i3 == 48) {
                                                                                gVar3.f(false);
                                                                                gVar3.b(true);
                                                                                z3 = false;
                                                                            } else {
                                                                                z3 = false;
                                                                                gVar3.f(false);
                                                                            }
                                                                            gVar3.k(z3);
                                                                            gVar3.F(eVar2.c());
                                                                            arrayList3.add(gVar3);
                                                                            i16++;
                                                                            str33 = str33;
                                                                            str31 = str31;
                                                                            str3 = str12;
                                                                            i = i3;
                                                                            str34 = str10;
                                                                            str9 = str11;
                                                                            str21 = str21;
                                                                            str23 = str23;
                                                                        }
                                                                        gVar3.b(z3);
                                                                        gVar3.k(z3);
                                                                        gVar3.F(eVar2.c());
                                                                        arrayList3.add(gVar3);
                                                                        i16++;
                                                                        str33 = str33;
                                                                        str31 = str31;
                                                                        str3 = str12;
                                                                        i = i3;
                                                                        str34 = str10;
                                                                        str9 = str11;
                                                                        str21 = str21;
                                                                        str23 = str23;
                                                                    } else {
                                                                        str14 = str28;
                                                                        if (!jSONObject8.has(str14)) {
                                                                            str29 = str13;
                                                                        } else if (jSONObject8.isNull(str14)) {
                                                                            str29 = str13;
                                                                            gVar3.h(jSONObject8.getString(str14));
                                                                            gVar3.t(jSONObject8.getString(str14));
                                                                        } else {
                                                                            str29 = str13;
                                                                        }
                                                                        str15 = str26;
                                                                        if (!jSONObject8.has(str15)) {
                                                                            str28 = str14;
                                                                        } else if (jSONObject8.isNull(str15)) {
                                                                            str28 = str14;
                                                                            gVar3.i(jSONObject8.getString(str15));
                                                                            gVar3.o(jSONObject8.getString(str15));
                                                                        } else {
                                                                            str28 = str14;
                                                                        }
                                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                                        }
                                                                        if (jSONObject8.has("Height")) {
                                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                                        }
                                                                        if (jSONObject8.has("IsDeeplink")) {
                                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                                        }
                                                                        str23 = str23;
                                                                        if (!jSONObject8.has(str23)) {
                                                                            str26 = str15;
                                                                        } else if (jSONObject8.isNull(str23)) {
                                                                            str26 = str15;
                                                                            gVar3.d(jSONObject8.getInt(str23));
                                                                        } else {
                                                                            str26 = str15;
                                                                        }
                                                                        str21 = str21;
                                                                        if (jSONObject8.has(str21)) {
                                                                            gVar3.f(jSONObject8.getString(str21));
                                                                        }
                                                                        if (i3 == 43) {
                                                                            gVar3.f(true);
                                                                            z3 = false;
                                                                        } else {
                                                                            if (i3 == 48) {
                                                                                gVar3.f(false);
                                                                                gVar3.b(true);
                                                                                z3 = false;
                                                                            } else {
                                                                                z3 = false;
                                                                                gVar3.f(false);
                                                                            }
                                                                            gVar3.k(z3);
                                                                            gVar3.F(eVar2.c());
                                                                            arrayList3.add(gVar3);
                                                                            i16++;
                                                                            str33 = str33;
                                                                            str31 = str31;
                                                                            str3 = str12;
                                                                            i = i3;
                                                                            str34 = str10;
                                                                            str9 = str11;
                                                                            str21 = str21;
                                                                            str23 = str23;
                                                                        }
                                                                        gVar3.b(z3);
                                                                        gVar3.k(z3);
                                                                        gVar3.F(eVar2.c());
                                                                        arrayList3.add(gVar3);
                                                                        i16++;
                                                                        str33 = str33;
                                                                        str31 = str31;
                                                                        str3 = str12;
                                                                        i = i3;
                                                                        str34 = str10;
                                                                        str9 = str11;
                                                                        str21 = str21;
                                                                        str23 = str23;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } catch (Exception e23) {
                                                        e = e23;
                                                        str21 = str21;
                                                        str23 = str23;
                                                        str31 = str31;
                                                        str33 = str33;
                                                    }
                                                } catch (Exception e24) {
                                                    e = e24;
                                                    str11 = str9;
                                                    exc2 = e;
                                                    arrayList = arrayList3;
                                                    exc2.printStackTrace();
                                                    if (jSONObject2.has("NewsCampaigns")) {
                                                        arrayList2 = arrayList;
                                                    } else {
                                                        arrayList2 = arrayList;
                                                    }
                                                    eVar = eVar2;
                                                    eVar.a(arrayList2);
                                                    return eVar;
                                                }
                                            } catch (Exception e25) {
                                                e = e25;
                                                str10 = str34;
                                            }
                                        } catch (Exception e26) {
                                            exc2 = e26;
                                            str21 = str21;
                                            str23 = str23;
                                            str31 = str31;
                                            str33 = str33;
                                            str10 = str34;
                                            str11 = str9;
                                            str12 = str3;
                                            arrayList = arrayList3;
                                            exc2.printStackTrace();
                                            if (jSONObject2.has("NewsCampaigns")) {
                                                arrayList2 = arrayList;
                                            } else {
                                                arrayList2 = arrayList;
                                            }
                                            eVar = eVar2;
                                            eVar.a(arrayList2);
                                            return eVar;
                                        }
                                    } else {
                                        str12 = str3;
                                        if (!jSONObject8.has(str12)) {
                                            i3 = i;
                                        } else if (jSONObject8.isNull(str12)) {
                                            i3 = jSONObject8.getInt(str12);
                                            gVar3.k(i3);
                                        } else {
                                            i3 = i;
                                        }
                                        str10 = str34;
                                        if (jSONObject8.has(str10)) {
                                            if (!jSONObject8.isNull(str10)) {
                                                gVar3.c(jSONObject8.getInt(str10));
                                            }
                                        }
                                        str11 = str9;
                                        if (jSONObject8.has(str11)) {
                                            if (!jSONObject8.isNull(str11)) {
                                                gVar3.d(jSONObject8.getString(str11));
                                            }
                                            if (jSONObject8.has("Name")) {
                                                gVar3.j(jSONObject8.getString("Name"));
                                            }
                                            if (!jSONObject8.has("ImpressionURLs")) {
                                            }
                                            if (jSONObject8.has("ClickTrackingURLs")) {
                                                jSONArray2 = new JSONArray(jSONObject8.getString("ClickTrackingURLs"));
                                                if (jSONArray2.length() > 0) {
                                                    arrayList4 = new ArrayList();
                                                    while (i4 < jSONArray2.length()) {
                                                        arrayList4.add(jSONArray2.getString(i4));
                                                    }
                                                    gVar3.a(arrayList4);
                                                }
                                            }
                                            if (jSONObject8.has(ADXLogUtil.EVENT_REWARD)) {
                                                gVar3.e(jSONObject8.getInt(ADXLogUtil.EVENT_REWARD));
                                            }
                                            if (jSONObject8.has("Title")) {
                                                gVar3.k(jSONObject8.getString("Title"));
                                            }
                                            str33 = str33;
                                            if (jSONObject8.has(str33)) {
                                                if (!jSONObject8.isNull(str33)) {
                                                    gVar3.g(jSONObject8.getString(str33));
                                                }
                                                str31 = str31;
                                                if (jSONObject8.has(str31)) {
                                                    if (!jSONObject8.isNull(str31)) {
                                                        gVar3.e(jSONObject8.getString(str31));
                                                    }
                                                    str13 = str29;
                                                    if (jSONObject8.has(str13)) {
                                                        if (!jSONObject8.isNull(str13)) {
                                                            gVar3.c(jSONObject8.getString(str13));
                                                        }
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    } else {
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    }
                                                } else {
                                                    str13 = str29;
                                                    if (jSONObject8.has(str13)) {
                                                        if (!jSONObject8.isNull(str13)) {
                                                            gVar3.c(jSONObject8.getString(str13));
                                                        }
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    } else {
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    }
                                                }
                                            } else {
                                                str31 = str31;
                                                if (jSONObject8.has(str31)) {
                                                    if (!jSONObject8.isNull(str31)) {
                                                        gVar3.e(jSONObject8.getString(str31));
                                                    }
                                                    str13 = str29;
                                                    if (jSONObject8.has(str13)) {
                                                        if (!jSONObject8.isNull(str13)) {
                                                            gVar3.c(jSONObject8.getString(str13));
                                                        }
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    } else {
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    }
                                                } else {
                                                    str13 = str29;
                                                    if (jSONObject8.has(str13)) {
                                                        if (!jSONObject8.isNull(str13)) {
                                                            gVar3.c(jSONObject8.getString(str13));
                                                        }
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    } else {
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    }
                                                }
                                            }
                                        } else {
                                            if (jSONObject8.has("Name")) {
                                                gVar3.j(jSONObject8.getString("Name"));
                                            }
                                            if (!jSONObject8.has("ImpressionURLs")) {
                                            }
                                            if (jSONObject8.has("ClickTrackingURLs")) {
                                                jSONArray2 = new JSONArray(jSONObject8.getString("ClickTrackingURLs"));
                                                if (jSONArray2.length() > 0) {
                                                    arrayList4 = new ArrayList();
                                                    while (i4 < jSONArray2.length()) {
                                                        arrayList4.add(jSONArray2.getString(i4));
                                                    }
                                                    gVar3.a(arrayList4);
                                                }
                                            }
                                            if (jSONObject8.has(ADXLogUtil.EVENT_REWARD)) {
                                                gVar3.e(jSONObject8.getInt(ADXLogUtil.EVENT_REWARD));
                                            }
                                            if (jSONObject8.has("Title")) {
                                                gVar3.k(jSONObject8.getString("Title"));
                                            }
                                            str33 = str33;
                                            if (jSONObject8.has(str33)) {
                                                if (!jSONObject8.isNull(str33)) {
                                                    gVar3.g(jSONObject8.getString(str33));
                                                }
                                                str31 = str31;
                                                if (jSONObject8.has(str31)) {
                                                    if (!jSONObject8.isNull(str31)) {
                                                        gVar3.e(jSONObject8.getString(str31));
                                                    }
                                                    str13 = str29;
                                                    if (jSONObject8.has(str13)) {
                                                        if (!jSONObject8.isNull(str13)) {
                                                            gVar3.c(jSONObject8.getString(str13));
                                                        }
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    } else {
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    }
                                                } else {
                                                    str13 = str29;
                                                    if (jSONObject8.has(str13)) {
                                                        if (!jSONObject8.isNull(str13)) {
                                                            gVar3.c(jSONObject8.getString(str13));
                                                        }
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    } else {
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    }
                                                }
                                            } else {
                                                str31 = str31;
                                                if (jSONObject8.has(str31)) {
                                                    if (!jSONObject8.isNull(str31)) {
                                                        gVar3.e(jSONObject8.getString(str31));
                                                    }
                                                    str13 = str29;
                                                    if (jSONObject8.has(str13)) {
                                                        if (!jSONObject8.isNull(str13)) {
                                                            gVar3.c(jSONObject8.getString(str13));
                                                        }
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    } else {
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    }
                                                } else {
                                                    str13 = str29;
                                                    if (jSONObject8.has(str13)) {
                                                        if (!jSONObject8.isNull(str13)) {
                                                            gVar3.c(jSONObject8.getString(str13));
                                                        }
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    } else {
                                                        str14 = str28;
                                                        if (!jSONObject8.has(str14)) {
                                                            str29 = str13;
                                                        } else if (jSONObject8.isNull(str14)) {
                                                            str29 = str13;
                                                            gVar3.h(jSONObject8.getString(str14));
                                                            gVar3.t(jSONObject8.getString(str14));
                                                        } else {
                                                            str29 = str13;
                                                        }
                                                        str15 = str26;
                                                        if (!jSONObject8.has(str15)) {
                                                            str28 = str14;
                                                        } else if (jSONObject8.isNull(str15)) {
                                                            str28 = str14;
                                                            gVar3.i(jSONObject8.getString(str15));
                                                            gVar3.o(jSONObject8.getString(str15));
                                                        } else {
                                                            str28 = str14;
                                                        }
                                                        if (jSONObject8.has(HttpHeaders.WIDTH)) {
                                                            gVar3.f(jSONObject8.getInt(HttpHeaders.WIDTH));
                                                        }
                                                        if (jSONObject8.has("Height")) {
                                                            gVar3.b(jSONObject8.getInt("Height"));
                                                        }
                                                        if (jSONObject8.has("IsDeeplink")) {
                                                            gVar3.d(jSONObject8.getBoolean("IsDeeplink"));
                                                        }
                                                        str23 = str23;
                                                        if (!jSONObject8.has(str23)) {
                                                            str26 = str15;
                                                        } else if (jSONObject8.isNull(str23)) {
                                                            str26 = str15;
                                                            gVar3.d(jSONObject8.getInt(str23));
                                                        } else {
                                                            str26 = str15;
                                                        }
                                                        str21 = str21;
                                                        if (jSONObject8.has(str21)) {
                                                            gVar3.f(jSONObject8.getString(str21));
                                                        }
                                                        if (i3 == 43) {
                                                            gVar3.f(true);
                                                            z3 = false;
                                                        } else {
                                                            if (i3 == 48) {
                                                                gVar3.f(false);
                                                                gVar3.b(true);
                                                                z3 = false;
                                                            } else {
                                                                z3 = false;
                                                                gVar3.f(false);
                                                            }
                                                            gVar3.k(z3);
                                                            gVar3.F(eVar2.c());
                                                            arrayList3.add(gVar3);
                                                            i16++;
                                                            str33 = str33;
                                                            str31 = str31;
                                                            str3 = str12;
                                                            i = i3;
                                                            str34 = str10;
                                                            str9 = str11;
                                                            str21 = str21;
                                                            str23 = str23;
                                                        }
                                                        gVar3.b(z3);
                                                        gVar3.k(z3);
                                                        gVar3.F(eVar2.c());
                                                        arrayList3.add(gVar3);
                                                        i16++;
                                                        str33 = str33;
                                                        str31 = str31;
                                                        str3 = str12;
                                                        i = i3;
                                                        str34 = str10;
                                                        str9 = str11;
                                                        str21 = str21;
                                                        str23 = str23;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e27) {
                                    e = e27;
                                    str21 = str21;
                                    str23 = str23;
                                    str31 = str31;
                                    str33 = str33;
                                    str10 = str34;
                                    str11 = str9;
                                    str12 = str3;
                                }
                            }
                            str21 = str21;
                            str23 = str23;
                            str31 = str31;
                            str33 = str33;
                            str10 = str34;
                            str11 = str9;
                            str12 = str3;
                            arrayList = arrayList3;
                        }
                    } catch (Exception e28) {
                        str21 = str21;
                        str23 = str23;
                        str31 = str31;
                        str33 = str33;
                        str10 = str34;
                        str11 = str9;
                        str12 = str3;
                        exc2 = e28;
                    }
                    try {
                        if (jSONObject2.has("NewsCampaigns") || jSONObject2.isNull("NewsCampaigns") || jSONObject2.getJSONArray("NewsCampaigns").length() <= 0) {
                            arrayList2 = arrayList;
                        } else {
                            JSONArray jSONArray11 = new JSONArray(jSONObject2.getString("NewsCampaigns"));
                            arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                            int i18 = 0;
                            while (i18 < jSONArray11.length()) {
                                try {
                                    com.igaworks.adpopcorn.cores.model.g gVar4 = new com.igaworks.adpopcorn.cores.model.g();
                                    JSONObject jSONObject9 = jSONArray11.getJSONObject(i18);
                                    if (jSONObject9.has(str12) && !jSONObject9.isNull(str12)) {
                                        gVar4.k(jSONObject9.getInt(str12));
                                    }
                                    if (jSONObject9.has(str10) && !jSONObject9.isNull(str10)) {
                                        gVar4.z(jSONObject9.getString(str10));
                                    }
                                    if (jSONObject9.has(str11) && !jSONObject9.isNull(str11)) {
                                        gVar4.v(jSONObject9.getString(str11));
                                    }
                                    if (jSONObject9.has(ADXLogUtil.EVENT_REWARD) && !jSONObject9.isNull(ADXLogUtil.EVENT_REWARD)) {
                                        gVar4.h(jSONObject9.getInt(ADXLogUtil.EVENT_REWARD));
                                    }
                                    if (jSONObject9.has("Title") && !jSONObject9.isNull("Title")) {
                                        gVar4.B(jSONObject9.getString("Title"));
                                    }
                                    if (jSONObject9.has(str33) && !jSONObject9.isNull(str33)) {
                                        gVar4.y(jSONObject9.getString(str33));
                                    }
                                    if (!jSONObject9.has(str31) || jSONObject9.isNull(str31)) {
                                        jSONArray = jSONArray11;
                                        str33 = str33;
                                    } else {
                                        String string9 = jSONObject9.getString(str31);
                                        if (string9 != null) {
                                            jSONArray = jSONArray11;
                                            if (!string9.contains("https://")) {
                                            }
                                            gVar4.w(string9);
                                        } else {
                                            jSONArray = jSONArray11;
                                        }
                                        string9 = string9.replace(ProxyConfig.MATCH_HTTP, "https");
                                        gVar4.w(string9);
                                    }
                                    str29 = str29;
                                    if (jSONObject9.has(str29) && !jSONObject9.isNull(str29)) {
                                        gVar4.u(jSONObject9.getString(str29));
                                    }
                                    String str40 = str26;
                                    if (jSONObject9.has(str40) && !jSONObject9.isNull(str40)) {
                                        gVar4.A(jSONObject9.getString(str40));
                                        gVar4.o(jSONObject9.getString(str40));
                                    }
                                    String str41 = str28;
                                    if (jSONObject9.has(str41) && !jSONObject9.isNull(str41)) {
                                        gVar4.t(jSONObject9.getString(str41));
                                    }
                                    if (jSONObject9.has(str23) && !jSONObject9.isNull(str23)) {
                                        gVar4.g(jSONObject9.getInt(str23));
                                    }
                                    if (jSONObject9.has(str21) && !jSONObject9.isNull(str21)) {
                                        gVar4.x(jSONObject9.getString(str21));
                                    }
                                    if (!jSONObject9.has("RewardConditionSec") || jSONObject9.isNull("RewardConditionSec")) {
                                        gVar4.i(31);
                                    } else {
                                        gVar4.i(jSONObject9.getInt("RewardConditionSec"));
                                    }
                                    if (jSONObject9.has("UseWebViewCache") && !jSONObject9.isNull("UseWebViewCache")) {
                                        gVar4.m(jSONObject9.getBoolean("UseWebViewCache"));
                                    }
                                    if (jSONObject9.has("WebViewScrollThreshold") && !jSONObject9.isNull("WebViewScrollThreshold")) {
                                        gVar4.j(jSONObject9.getInt("WebViewScrollThreshold"));
                                    }
                                    gVar4.h(true);
                                    gVar4.k(false);
                                    gVar4.F(eVar2.c());
                                    arrayList2.add(gVar4);
                                    i18++;
                                    jSONArray11 = jSONArray;
                                    str26 = str40;
                                    str28 = str41;
                                    str33 = str33;
                                } catch (Exception e29) {
                                    exc3 = e29;
                                    arrayList = arrayList2;
                                    exc3.printStackTrace();
                                    arrayList2 = arrayList;
                                }
                            }
                        }
                    } catch (Exception e30) {
                        exc3 = e30;
                    }
                    eVar = eVar2;
                    try {
                        eVar.a(arrayList2);
                        return eVar;
                    } catch (Exception e31) {
                        e = e31;
                    }
                } catch (Exception e32) {
                    e = e32;
                    eVar = eVar2;
                }
            } catch (Exception e33) {
                exc = e33;
                eVar = eVar2;
            }
            exc.printStackTrace();
            return eVar;
        } catch (Exception e34) {
            e = e34;
            eVar = eVar2;
        }
        exc = e;
        exc.printStackTrace();
        return eVar;
    }

    public static com.igaworks.adpopcorn.cores.model.g b(Context context, String str) {
        String string;
        String string2;
        com.igaworks.adpopcorn.cores.model.g gVar = new com.igaworks.adpopcorn.cores.model.g();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("Auth") && !jSONObject.isNull("Auth")) {
                gVar.a(jSONObject.getString("Auth"));
            }
            if (jSONObject.has("Desc") && !jSONObject.isNull("Desc")) {
                gVar.l(jSONObject.getString("Desc"));
            }
            if (jSONObject.has("IconImgURL") && !jSONObject.isNull("IconImgURL")) {
                gVar.t(jSONObject.getString("IconImgURL"));
            }
            if (jSONObject.has("IsChoiceOffer") && !jSONObject.isNull("IsChoiceOffer")) {
                gVar.a(jSONObject.getBoolean("IsChoiceOffer"));
            }
            if (jSONObject.has("Key") && !jSONObject.isNull("Key")) {
                gVar.b(jSONObject.getString("Key"));
            }
            if (jSONObject.has("PackageName") && !jSONObject.isNull("PackageName")) {
                gVar.C(jSONObject.getString("PackageName"));
            }
            if (jSONObject.has("PartiTypeCode") && !jSONObject.isNull("PartiTypeCode")) {
                gVar.k(jSONObject.getInt("PartiTypeCode"));
            }
            if (jSONObject.has("BadgeTypeCode") && !jSONObject.isNull("BadgeTypeCode")) {
                gVar.a(jSONObject.getInt("BadgeTypeCode"));
            }
            if (jSONObject.has("IsOverseaOffer") && !jSONObject.isNull("IsOverseaOffer")) {
                gVar.i(jSONObject.getBoolean("IsOverseaOffer"));
            }
            boolean zD = true;
            try {
                if (jSONObject.has("TargetPackageName") && !jSONObject.isNull("TargetPackageName") && (string2 = jSONObject.getString("TargetPackageName")) != null && string2.length() > 0) {
                    JSONArray jSONArray = new JSONArray(string2);
                    int length = jSONArray.length();
                    String[] strArr = new String[length];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.getString(i);
                    }
                    if (length > 0) {
                        zD = false;
                        for (int i2 = 0; i2 < length; i2++) {
                            strArr[i2] = strArr[i2].trim();
                            try {
                                if (strArr[i2] != null && strArr[i2].length() > 0 && (zD = d(context, strArr[i2]))) {
                                    break;
                                }
                            } catch (Exception unused) {
                                zD = false;
                            }
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            if (zD) {
                try {
                    if (jSONObject.has("DetargetPackageName") && !jSONObject.isNull("DetargetPackageName") && (string = jSONObject.getString("DetargetPackageName")) != null && string.length() > 0) {
                        JSONArray jSONArray2 = new JSONArray(string);
                        int length2 = jSONArray2.length();
                        String[] strArr2 = new String[length2];
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            strArr2[i3] = jSONArray2.getString(i3);
                        }
                        if (length2 > 0) {
                            for (int i4 = 0; i4 < length2; i4++) {
                                strArr2[i4] = strArr2[i4].trim();
                                try {
                                    if (strArr2[i4] != null && strArr2[i4].length() > 0 && d(context, strArr2[i4])) {
                                        break;
                                    }
                                } catch (Exception unused3) {
                                }
                            }
                        }
                    }
                } catch (Exception unused4) {
                }
            }
            if (jSONObject.has(ADXLogUtil.EVENT_REWARD) && !jSONObject.isNull(ADXLogUtil.EVENT_REWARD)) {
                gVar.G(jSONObject.getString(ADXLogUtil.EVENT_REWARD));
            }
            if (jSONObject.has("Title") && !jSONObject.isNull("Title")) {
                gVar.J(jSONObject.getString("Title"));
                gVar.s(jSONObject.getString("Title"));
            }
            if (jSONObject.has("IsSpecialOffer") && !jSONObject.isNull("IsSpecialOffer")) {
                gVar.l(jSONObject.getBoolean("IsSpecialOffer"));
            }
            if (jSONObject.has("SpecialOfferImgURL") && !jSONObject.isNull("SpecialOfferImgURL")) {
                gVar.I(jSONObject.getString("SpecialOfferImgURL"));
                gVar.o(jSONObject.getString("SpecialOfferImgURL"));
            }
            if (jSONObject.has("RewardCondition") && !jSONObject.isNull("RewardCondition")) {
                gVar.E(jSONObject.getString("RewardCondition"));
            }
            if (jSONObject.has("UseRedirectURL") && !jSONObject.isNull("UseRedirectURL")) {
                gVar.n(jSONObject.getBoolean("UseRedirectURL"));
            }
            if (jSONObject.has("RedirectURL") && !jSONObject.isNull("RedirectURL")) {
                gVar.D(jSONObject.getString("RedirectURL"));
            }
            if (jSONObject.has("RewardDetail") && !jSONObject.isNull("RewardDetail")) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("RewardDetail"));
                if (jSONObject2.has("Quantity") && !jSONObject2.isNull("Quantity")) {
                    gVar.a(jSONObject2.getLong("Quantity"));
                }
                if (jSONObject2.has("Unit") && !jSONObject2.isNull("Unit")) {
                    gVar.F(jSONObject2.getString("Unit"));
                }
            }
            if (jSONObject.has("FeedTitle") && !jSONObject.isNull("FeedTitle")) {
                gVar.s(jSONObject.getString("FeedTitle"));
            }
            if (jSONObject.has("FeedDesc") && !jSONObject.isNull("FeedDesc")) {
                gVar.m(jSONObject.getString("FeedDesc"));
            }
            if (jSONObject.has("FeedMainImgURL") && !jSONObject.isNull("FeedMainImgURL")) {
                gVar.o(jSONObject.getString("FeedMainImgURL"));
            }
            if (jSONObject.has("FeedDetailImgURL") && !jSONObject.isNull("FeedDetailImgURL")) {
                gVar.n(jSONObject.getString("FeedDetailImgURL"));
            }
            if (jSONObject.has("FeedParticipationStep") && !jSONObject.isNull("FeedParticipationStep")) {
                gVar.r(jSONObject.getString("FeedParticipationStep"));
            }
            if (jSONObject.has("FeedParticipationImgURL") && !jSONObject.isNull("FeedParticipationImgURL")) {
                gVar.q(jSONObject.getString("FeedParticipationImgURL"));
            }
            if (jSONObject.has("FeedMustReadDesc") && !jSONObject.isNull("FeedMustReadDesc")) {
                gVar.p(jSONObject.getString("FeedMustReadDesc"));
            }
            gVar.k(false);
            return gVar;
        } catch (Exception unused5) {
            return null;
        }
    }

    public static List<i> c(Context context, String str) {
        i iVar;
        JSONArray jSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SubTabInfos") && !jSONObject.isNull("SubTabInfos") && (jSONArray = jSONObject.getJSONArray("SubTabInfos")) != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        i iVar2 = new i();
                        if (jSONObject2.has("SubTabNo") && !jSONObject2.isNull("SubTabNo")) {
                            iVar2.a(jSONObject2.getInt("SubTabNo"));
                        }
                        if (jSONObject2.has("SubTabTitle") && !jSONObject2.isNull("SubTabTitle")) {
                            iVar2.a(jSONObject2.getString("SubTabTitle"));
                        }
                        arrayList.add(iVar2);
                    }
                }
                if (arrayList.size() == 0) {
                    iVar = new i();
                    iVar.a("전체");
                    iVar.a(0);
                    arrayList.add(iVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (arrayList.size() == 0) {
                    iVar = new i();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (arrayList.size() == 0) {
                i iVar3 = new i();
                iVar3.a("전체");
                iVar3.a(0);
                arrayList.add(iVar3);
            }
            throw th;
        }
    }

    private static boolean d(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
