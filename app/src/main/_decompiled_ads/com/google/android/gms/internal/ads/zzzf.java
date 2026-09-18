package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import kotlin.io.encoding.Base64;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzzf extends zzse implements zzaaf {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private int zzA;
    private long zzB;
    private zzdm zzC;
    private zzdm zzD;
    private boolean zzE;
    private boolean zzF;
    private int zzG;
    private zzzj zzH;
    private zzaah zzI;
    private final Context zze;
    private final zzzr zzf;
    private final zzyv zzg;
    private final zzaac zzh;
    private final boolean zzi;
    private zzzb zzj;
    private boolean zzk;
    private boolean zzl;
    private Surface zzm;
    private zzzi zzn;
    private boolean zzo;
    private int zzp;
    private int zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzzf(Context context, zzrv zzrvVar, zzsg zzsgVar, long j, boolean z, Handler handler, zzaad zzaadVar, int i, float f) {
        zzze zzzeVar = new zzze(null);
        super(2, zzrvVar, zzsgVar, false, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        this.zzf = new zzzr(applicationContext);
        this.zzh = new zzaac(handler, zzaadVar);
        this.zzg = new zzyv(context, zzzeVar, this);
        this.zzi = "NVIDIA".equals(zzfk.zzc);
        this.zzs = -9223372036854775807L;
        this.zzp = 1;
        this.zzC = zzdm.zza;
        this.zzG = 0;
        this.zzq = 0;
        this.zzD = null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014c  */
    /* JADX WARN: Code duplicated, block: B:102:0x0154  */
    /* JADX WARN: Code duplicated, block: B:103:0x0158  */
    /* JADX WARN: Code duplicated, block: B:105:0x0160  */
    /* JADX WARN: Code duplicated, block: B:106:0x0164  */
    /* JADX WARN: Code duplicated, block: B:108:0x016c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0170  */
    /* JADX WARN: Code duplicated, block: B:111:0x0178  */
    /* JADX WARN: Code duplicated, block: B:112:0x017c  */
    /* JADX WARN: Code duplicated, block: B:114:0x0184  */
    /* JADX WARN: Code duplicated, block: B:115:0x0188  */
    /* JADX WARN: Code duplicated, block: B:117:0x0190  */
    /* JADX WARN: Code duplicated, block: B:118:0x0194  */
    /* JADX WARN: Code duplicated, block: B:120:0x019c  */
    /* JADX WARN: Code duplicated, block: B:121:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:124:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:126:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:129:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:130:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:132:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:133:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:135:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:136:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:138:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:142:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:144:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:145:0x0200  */
    /* JADX WARN: Code duplicated, block: B:147:0x0208  */
    /* JADX WARN: Code duplicated, block: B:148:0x020c  */
    /* JADX WARN: Code duplicated, block: B:150:0x0214  */
    /* JADX WARN: Code duplicated, block: B:151:0x0218  */
    /* JADX WARN: Code duplicated, block: B:153:0x0220  */
    /* JADX WARN: Code duplicated, block: B:154:0x0224  */
    /* JADX WARN: Code duplicated, block: B:156:0x022c  */
    /* JADX WARN: Code duplicated, block: B:157:0x0230  */
    /* JADX WARN: Code duplicated, block: B:159:0x0238  */
    /* JADX WARN: Code duplicated, block: B:160:0x023c  */
    /* JADX WARN: Code duplicated, block: B:162:0x0244  */
    /* JADX WARN: Code duplicated, block: B:163:0x0248  */
    /* JADX WARN: Code duplicated, block: B:165:0x0250  */
    /* JADX WARN: Code duplicated, block: B:166:0x0254  */
    /* JADX WARN: Code duplicated, block: B:168:0x025c  */
    /* JADX WARN: Code duplicated, block: B:169:0x0260  */
    /* JADX WARN: Code duplicated, block: B:171:0x0268  */
    /* JADX WARN: Code duplicated, block: B:172:0x026c  */
    /* JADX WARN: Code duplicated, block: B:174:0x0274  */
    /* JADX WARN: Code duplicated, block: B:175:0x0278  */
    /* JADX WARN: Code duplicated, block: B:177:0x0280  */
    /* JADX WARN: Code duplicated, block: B:178:0x0284  */
    /* JADX WARN: Code duplicated, block: B:180:0x028c  */
    /* JADX WARN: Code duplicated, block: B:181:0x0290  */
    /* JADX WARN: Code duplicated, block: B:183:0x0298  */
    /* JADX WARN: Code duplicated, block: B:184:0x029c  */
    /* JADX WARN: Code duplicated, block: B:186:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:187:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:189:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:190:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:192:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:193:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:195:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:196:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:198:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:199:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:201:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:202:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:204:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:205:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:207:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:208:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:210:0x0303  */
    /* JADX WARN: Code duplicated, block: B:211:0x0307  */
    /* JADX WARN: Code duplicated, block: B:213:0x030f  */
    /* JADX WARN: Code duplicated, block: B:214:0x0313  */
    /* JADX WARN: Code duplicated, block: B:216:0x031b  */
    /* JADX WARN: Code duplicated, block: B:217:0x031f  */
    /* JADX WARN: Code duplicated, block: B:219:0x0327  */
    /* JADX WARN: Code duplicated, block: B:220:0x032b  */
    /* JADX WARN: Code duplicated, block: B:222:0x0333  */
    /* JADX WARN: Code duplicated, block: B:223:0x0337  */
    /* JADX WARN: Code duplicated, block: B:225:0x033f  */
    /* JADX WARN: Code duplicated, block: B:226:0x0343  */
    /* JADX WARN: Code duplicated, block: B:228:0x034b  */
    /* JADX WARN: Code duplicated, block: B:229:0x034f  */
    /* JADX WARN: Code duplicated, block: B:231:0x0357  */
    /* JADX WARN: Code duplicated, block: B:232:0x035b  */
    /* JADX WARN: Code duplicated, block: B:234:0x0363  */
    /* JADX WARN: Code duplicated, block: B:235:0x0367  */
    /* JADX WARN: Code duplicated, block: B:237:0x036f  */
    /* JADX WARN: Code duplicated, block: B:238:0x0373  */
    /* JADX WARN: Code duplicated, block: B:240:0x037b  */
    /* JADX WARN: Code duplicated, block: B:241:0x037f  */
    /* JADX WARN: Code duplicated, block: B:243:0x0387  */
    /* JADX WARN: Code duplicated, block: B:244:0x038b  */
    /* JADX WARN: Code duplicated, block: B:246:0x0393  */
    /* JADX WARN: Code duplicated, block: B:247:0x0397  */
    /* JADX WARN: Code duplicated, block: B:249:0x039f  */
    /* JADX WARN: Code duplicated, block: B:250:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:252:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:253:0x03af  */
    /* JADX WARN: Code duplicated, block: B:255:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:256:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:258:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:259:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:261:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:262:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:264:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:265:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:267:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:268:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:270:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:271:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:273:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:274:0x0400  */
    /* JADX WARN: Code duplicated, block: B:276:0x0408  */
    /* JADX WARN: Code duplicated, block: B:277:0x040c  */
    /* JADX WARN: Code duplicated, block: B:279:0x0414  */
    /* JADX WARN: Code duplicated, block: B:280:0x0418  */
    /* JADX WARN: Code duplicated, block: B:282:0x0420  */
    /* JADX WARN: Code duplicated, block: B:283:0x0424  */
    /* JADX WARN: Code duplicated, block: B:285:0x042c  */
    /* JADX WARN: Code duplicated, block: B:286:0x0430  */
    /* JADX WARN: Code duplicated, block: B:288:0x0438  */
    /* JADX WARN: Code duplicated, block: B:289:0x043c  */
    /* JADX WARN: Code duplicated, block: B:291:0x0444  */
    /* JADX WARN: Code duplicated, block: B:292:0x0448  */
    /* JADX WARN: Code duplicated, block: B:294:0x0450  */
    /* JADX WARN: Code duplicated, block: B:295:0x0454  */
    /* JADX WARN: Code duplicated, block: B:297:0x045c  */
    /* JADX WARN: Code duplicated, block: B:298:0x0460  */
    /* JADX WARN: Code duplicated, block: B:300:0x0468  */
    /* JADX WARN: Code duplicated, block: B:301:0x046c  */
    /* JADX WARN: Code duplicated, block: B:303:0x0474  */
    /* JADX WARN: Code duplicated, block: B:304:0x0478  */
    /* JADX WARN: Code duplicated, block: B:306:0x0480  */
    /* JADX WARN: Code duplicated, block: B:307:0x0484  */
    /* JADX WARN: Code duplicated, block: B:309:0x048c  */
    /* JADX WARN: Code duplicated, block: B:310:0x0490  */
    /* JADX WARN: Code duplicated, block: B:312:0x0498  */
    /* JADX WARN: Code duplicated, block: B:313:0x049b  */
    /* JADX WARN: Code duplicated, block: B:315:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:316:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:318:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:319:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:321:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:322:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:325:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:327:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:328:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:330:0x04da  */
    /* JADX WARN: Code duplicated, block: B:331:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:333:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:334:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:336:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:337:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:339:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:340:0x0501  */
    /* JADX WARN: Code duplicated, block: B:342:0x0509  */
    /* JADX WARN: Code duplicated, block: B:343:0x050d  */
    /* JADX WARN: Code duplicated, block: B:345:0x0515  */
    /* JADX WARN: Code duplicated, block: B:346:0x0519  */
    /* JADX WARN: Code duplicated, block: B:348:0x0521  */
    /* JADX WARN: Code duplicated, block: B:349:0x0525  */
    /* JADX WARN: Code duplicated, block: B:351:0x052d  */
    /* JADX WARN: Code duplicated, block: B:352:0x0531  */
    /* JADX WARN: Code duplicated, block: B:354:0x0539  */
    /* JADX WARN: Code duplicated, block: B:355:0x053d  */
    /* JADX WARN: Code duplicated, block: B:357:0x0545  */
    /* JADX WARN: Code duplicated, block: B:358:0x0549  */
    /* JADX WARN: Code duplicated, block: B:360:0x0551  */
    /* JADX WARN: Code duplicated, block: B:361:0x0555  */
    /* JADX WARN: Code duplicated, block: B:363:0x055d  */
    /* JADX WARN: Code duplicated, block: B:364:0x0561  */
    /* JADX WARN: Code duplicated, block: B:366:0x0569  */
    /* JADX WARN: Code duplicated, block: B:367:0x056d  */
    /* JADX WARN: Code duplicated, block: B:369:0x0575  */
    /* JADX WARN: Code duplicated, block: B:370:0x0579  */
    /* JADX WARN: Code duplicated, block: B:372:0x0581  */
    /* JADX WARN: Code duplicated, block: B:373:0x0585  */
    /* JADX WARN: Code duplicated, block: B:375:0x058d  */
    /* JADX WARN: Code duplicated, block: B:376:0x0591  */
    /* JADX WARN: Code duplicated, block: B:378:0x0599  */
    /* JADX WARN: Code duplicated, block: B:379:0x059d  */
    /* JADX WARN: Code duplicated, block: B:381:0x05a5  */
    /* JADX WARN: Code duplicated, block: B:382:0x05a9  */
    /* JADX WARN: Code duplicated, block: B:384:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:385:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:387:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:388:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:390:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:391:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:393:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:394:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:396:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:397:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:399:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:400:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:402:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:403:0x05fd  */
    /* JADX WARN: Code duplicated, block: B:405:0x0605  */
    /* JADX WARN: Code duplicated, block: B:406:0x0609  */
    /* JADX WARN: Code duplicated, block: B:408:0x0611  */
    /* JADX WARN: Code duplicated, block: B:409:0x0615  */
    /* JADX WARN: Code duplicated, block: B:411:0x061d  */
    /* JADX WARN: Code duplicated, block: B:412:0x0621  */
    /* JADX WARN: Code duplicated, block: B:414:0x0629  */
    /* JADX WARN: Code duplicated, block: B:415:0x062d  */
    /* JADX WARN: Code duplicated, block: B:417:0x0635  */
    /* JADX WARN: Code duplicated, block: B:418:0x0639  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:420:0x0641  */
    /* JADX WARN: Code duplicated, block: B:421:0x0645  */
    /* JADX WARN: Code duplicated, block: B:423:0x064d  */
    /* JADX WARN: Code duplicated, block: B:424:0x0651  */
    /* JADX WARN: Code duplicated, block: B:426:0x0659  */
    /* JADX WARN: Code duplicated, block: B:427:0x065c  */
    /* JADX WARN: Code duplicated, block: B:429:0x0664  */
    /* JADX WARN: Code duplicated, block: B:42:0x0083 A[Catch: all -> 0x07ab, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:515:0x07a3, B:42:0x0083, B:44:0x0089, B:47:0x0094, B:80:0x00ff, B:82:0x0105, B:507:0x078e, B:516:0x07a7), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:430:0x0667  */
    /* JADX WARN: Code duplicated, block: B:432:0x066f  */
    /* JADX WARN: Code duplicated, block: B:433:0x0673  */
    /* JADX WARN: Code duplicated, block: B:435:0x067b  */
    /* JADX WARN: Code duplicated, block: B:436:0x067f  */
    /* JADX WARN: Code duplicated, block: B:438:0x0687  */
    /* JADX WARN: Code duplicated, block: B:439:0x068b  */
    /* JADX WARN: Code duplicated, block: B:441:0x0693  */
    /* JADX WARN: Code duplicated, block: B:442:0x0697  */
    /* JADX WARN: Code duplicated, block: B:444:0x069f  */
    /* JADX WARN: Code duplicated, block: B:445:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:447:0x06ab  */
    /* JADX WARN: Code duplicated, block: B:448:0x06af  */
    /* JADX WARN: Code duplicated, block: B:450:0x06b7  */
    /* JADX WARN: Code duplicated, block: B:451:0x06bb  */
    /* JADX WARN: Code duplicated, block: B:453:0x06c3  */
    /* JADX WARN: Code duplicated, block: B:454:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:456:0x06cf  */
    /* JADX WARN: Code duplicated, block: B:457:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:459:0x06db  */
    /* JADX WARN: Code duplicated, block: B:460:0x06df  */
    /* JADX WARN: Code duplicated, block: B:462:0x06e7  */
    /* JADX WARN: Code duplicated, block: B:463:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:465:0x06f3  */
    /* JADX WARN: Code duplicated, block: B:466:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:468:0x06ff  */
    /* JADX WARN: Code duplicated, block: B:469:0x0703  */
    /* JADX WARN: Code duplicated, block: B:471:0x070b  */
    /* JADX WARN: Code duplicated, block: B:472:0x070f  */
    /* JADX WARN: Code duplicated, block: B:474:0x0717  */
    /* JADX WARN: Code duplicated, block: B:475:0x071b  */
    /* JADX WARN: Code duplicated, block: B:477:0x0723  */
    /* JADX WARN: Code duplicated, block: B:478:0x0727  */
    /* JADX WARN: Code duplicated, block: B:47:0x0094 A[Catch: all -> 0x07ab, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:515:0x07a3, B:42:0x0083, B:44:0x0089, B:47:0x0094, B:80:0x00ff, B:82:0x0105, B:507:0x078e, B:516:0x07a7), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:480:0x072f  */
    /* JADX WARN: Code duplicated, block: B:481:0x0732  */
    /* JADX WARN: Code duplicated, block: B:483:0x073a  */
    /* JADX WARN: Code duplicated, block: B:484:0x073d  */
    /* JADX WARN: Code duplicated, block: B:486:0x0745  */
    /* JADX WARN: Code duplicated, block: B:487:0x0748  */
    /* JADX WARN: Code duplicated, block: B:489:0x0750  */
    /* JADX WARN: Code duplicated, block: B:490:0x0753  */
    /* JADX WARN: Code duplicated, block: B:492:0x075b  */
    /* JADX WARN: Code duplicated, block: B:493:0x075e  */
    /* JADX WARN: Code duplicated, block: B:495:0x0766  */
    /* JADX WARN: Code duplicated, block: B:496:0x0769  */
    /* JADX WARN: Code duplicated, block: B:498:0x0771  */
    /* JADX WARN: Code duplicated, block: B:499:0x0774  */
    /* JADX WARN: Code duplicated, block: B:501:0x077c  */
    /* JADX WARN: Code duplicated, block: B:502:0x077f  */
    /* JADX WARN: Code duplicated, block: B:504:0x0787  */
    /* JADX WARN: Code duplicated, block: B:505:0x078a  */
    /* JADX WARN: Code duplicated, block: B:507:0x078e A[Catch: all -> 0x07ab, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:515:0x07a3, B:42:0x0083, B:44:0x0089, B:47:0x0094, B:80:0x00ff, B:82:0x0105, B:507:0x078e, B:516:0x07a7), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:511:0x0798  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:532:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:533:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:534:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:535:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:536:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:537:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:538:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:539:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:540:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:541:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:542:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:543:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:544:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:545:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:546:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:547:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:548:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:549:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:550:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:551:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:552:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:553:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:554:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:555:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:556:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:557:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:558:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:559:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:560:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:562:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:563:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:564:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:565:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:566:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:567:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:568:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:569:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:570:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:571:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:572:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:573:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:574:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:575:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:576:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:577:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:578:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:579:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:580:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:581:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:585:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:586:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:600:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:610:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:630:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:640:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:660:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:670:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:672:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:678:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:680:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00db  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ff A[Catch: all -> 0x07ab, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:515:0x07a3, B:42:0x0083, B:44:0x0089, B:47:0x0094, B:80:0x00ff, B:82:0x0105, B:507:0x078e, B:516:0x07a7), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0105 A[Catch: all -> 0x07ab, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:515:0x07a3, B:42:0x0083, B:44:0x0089, B:47:0x0094, B:80:0x00ff, B:82:0x0105, B:507:0x078e, B:516:0x07a7), top: B:522:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0110  */
    /* JADX WARN: Code duplicated, block: B:87:0x0118  */
    /* JADX WARN: Code duplicated, block: B:88:0x011c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0124  */
    /* JADX WARN: Code duplicated, block: B:91:0x0128  */
    /* JADX WARN: Code duplicated, block: B:93:0x0130  */
    /* JADX WARN: Code duplicated, block: B:94:0x0134  */
    /* JADX WARN: Code duplicated, block: B:96:0x013c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0140  */
    /* JADX WARN: Code duplicated, block: B:99:0x0148  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    protected static final boolean zzaL(String str) {
        String str2;
        byte b2;
        String str3;
        byte b3;
        boolean z = false;
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (zzzf.class) {
            if (!zzc) {
                byte b4 = 28;
                byte b5 = -1;
                if (zzfk.zza <= 28) {
                    String str4 = zzfk.zzb;
                    switch (str4.hashCode()) {
                        case -1339091551:
                            b3 = !str4.equals("dangal") ? (byte) -1 : (byte) 1;
                            break;
                        case -1220081023:
                            b3 = !str4.equals("dangalFHD") ? (byte) -1 : (byte) 3;
                            break;
                        case -1220066608:
                            b3 = !str4.equals("dangalUHD") ? (byte) -1 : (byte) 2;
                            break;
                        case -1012436106:
                            b3 = !str4.equals("oneday") ? (byte) -1 : (byte) 7;
                            break;
                        case -760312546:
                            b3 = !str4.equals("aquaman") ? (byte) -1 : (byte) 0;
                            break;
                        case -64886864:
                            b3 = !str4.equals("magnolia") ? (byte) -1 : (byte) 4;
                            break;
                        case 3415681:
                            b3 = !str4.equals("once") ? (byte) -1 : (byte) 6;
                            break;
                        case 825323514:
                            b3 = !str4.equals("machuca") ? (byte) -1 : (byte) 5;
                            break;
                        default:
                            b3 = -1;
                            break;
                    }
                    switch (b3) {
                        default:
                            if (zzfk.zza <= 27 || !"HWEML".equals(zzfk.zzb)) {
                                str2 = zzfk.zzd;
                                switch (str2.hashCode()) {
                                    case -349662828:
                                        if (!str2.equals("AFTJMST12")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 6;
                                        }
                                        break;
                                    case -321033677:
                                        if (!str2.equals("AFTKMST12")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 7;
                                        }
                                        break;
                                    case 2006354:
                                        if (!str2.equals("AFTA")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 0;
                                        }
                                        break;
                                    case 2006367:
                                        if (!str2.equals("AFTN")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 1;
                                        }
                                        break;
                                    case 2006371:
                                        if (!str2.equals("AFTR")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 2;
                                        }
                                        break;
                                    case 1785421873:
                                        if (!str2.equals("AFTEU011")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 3;
                                        }
                                        break;
                                    case 1785421876:
                                        if (!str2.equals("AFTEU014")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 4;
                                        }
                                        break;
                                    case 1798172390:
                                        if (!str2.equals("AFTSO001")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 8;
                                        }
                                        break;
                                    case 2119412532:
                                        if (!str2.equals("AFTEUFF014")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 5;
                                        }
                                        break;
                                    default:
                                        b2 = -1;
                                        break;
                                }
                                switch (b2) {
                                    default:
                                        if (zzfk.zza <= 26) {
                                            str3 = zzfk.zzb;
                                            switch (str3.hashCode()) {
                                                case -2144781245:
                                                    if (!str3.equals("GIONEE_SWW1609")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 54;
                                                    }
                                                    break;
                                                case -2144781185:
                                                    if (!str3.equals("GIONEE_SWW1627")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 55;
                                                    }
                                                    break;
                                                case -2144781160:
                                                    if (!str3.equals("GIONEE_SWW1631")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 56;
                                                    }
                                                    break;
                                                case -2097309513:
                                                    if (!str3.equals("K50a40")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 74;
                                                    }
                                                    break;
                                                case -2022874474:
                                                    if (!str3.equals("CP8676_I02")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 22;
                                                    }
                                                    break;
                                                case -1978993182:
                                                    if (!str3.equals("NX541J")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 89;
                                                    }
                                                    break;
                                                case -1978990237:
                                                    if (!str3.equals("NX573J")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 90;
                                                    }
                                                    break;
                                                case -1936688988:
                                                    if (!str3.equals("PGN528")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 101;
                                                    }
                                                    break;
                                                case -1936688066:
                                                    if (!str3.equals("PGN610")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 102;
                                                    }
                                                    break;
                                                case -1936688065:
                                                    if (!str3.equals("PGN611")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 103;
                                                    }
                                                    break;
                                                case -1931988508:
                                                    if (!str3.equals("AquaPowerM")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 13;
                                                    }
                                                    break;
                                                case -1885099851:
                                                    if (!str3.equals("RAIJIN")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 116;
                                                    }
                                                    break;
                                                case -1696512866:
                                                    if (!str3.equals("XT1663")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 137;
                                                    }
                                                    break;
                                                case -1680025915:
                                                    if (!str3.equals("ComioS1")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 21;
                                                    }
                                                    break;
                                                case -1615810839:
                                                    if (!str3.equals("Phantom6")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 104;
                                                    }
                                                    break;
                                                case -1600724499:
                                                    if (!str3.equals("pacificrim")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 95;
                                                    }
                                                    break;
                                                case -1554255044:
                                                    if (!str3.equals("vernee_M5")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 130;
                                                    }
                                                    break;
                                                case -1481772737:
                                                    if (!str3.equals("panell_dl")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 97;
                                                    }
                                                    break;
                                                case -1481772730:
                                                    if (!str3.equals("panell_ds")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 98;
                                                    }
                                                    break;
                                                case -1481772729:
                                                    if (!str3.equals("panell_dt")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 99;
                                                    }
                                                    break;
                                                case -1320080169:
                                                    if (!str3.equals("GiONEE_GBL7319")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 52;
                                                    }
                                                    break;
                                                case -1217592143:
                                                    if (!str3.equals("BRAVIA_ATV2")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 18;
                                                    }
                                                    break;
                                                case -1180384755:
                                                    if (!str3.equals("iris60")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 70;
                                                    }
                                                    break;
                                                case -1139198265:
                                                    if (!str3.equals("Slate_Pro")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 118;
                                                    }
                                                    break;
                                                case -1052835013:
                                                    if (!str3.equals("namath")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 87;
                                                    }
                                                    break;
                                                case -993250464:
                                                    if (!str3.equals("A10-70F")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 5;
                                                    }
                                                    break;
                                                case -993250458:
                                                    if (!str3.equals("A10-70L")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 6;
                                                    }
                                                    break;
                                                case -965403638:
                                                    if (!str3.equals("s905x018")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 120;
                                                    }
                                                    break;
                                                case -958336948:
                                                    if (!str3.equals("ELUGA_Ray_X")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 34;
                                                    }
                                                    break;
                                                case -879245230:
                                                    if (!str3.equals("tcl_eu")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 126;
                                                    }
                                                    break;
                                                case -842500323:
                                                    if (!str3.equals("nicklaus_f")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 88;
                                                    }
                                                    break;
                                                case -821392978:
                                                    if (!str3.equals("A7000-a")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 9;
                                                    }
                                                    break;
                                                case -797483286:
                                                    if (!str3.equals("SVP-DTV15")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 119;
                                                    }
                                                    break;
                                                case -794946968:
                                                    if (!str3.equals("watson")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 131;
                                                    }
                                                    break;
                                                case -788334647:
                                                    if (!str3.equals("whyred")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 132;
                                                    }
                                                    break;
                                                case -782144577:
                                                    if (!str3.equals("OnePlus5T")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 91;
                                                    }
                                                    break;
                                                case -575125681:
                                                    if (!str3.equals("GiONEE_CBL7513")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 51;
                                                    }
                                                    break;
                                                case -521118391:
                                                    if (!str3.equals("GIONEE_GBL7360")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 53;
                                                    }
                                                    break;
                                                case -430914369:
                                                    if (!str3.equals("Pixi4-7_3G")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 105;
                                                    }
                                                    break;
                                                case -290434366:
                                                    if (!str3.equals("taido_row")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 121;
                                                    }
                                                    break;
                                                case -282781963:
                                                    if (!str3.equals("BLACK-1X")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 17;
                                                    }
                                                    break;
                                                case -277133239:
                                                    if (!str3.equals("Z12_PRO")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 138;
                                                    }
                                                    break;
                                                case -173639913:
                                                    if (!str3.equals("ELUGA_A3_Pro")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 31;
                                                    }
                                                    break;
                                                case -56598463:
                                                    if (!str3.equals("woods_fn")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 134;
                                                    }
                                                    break;
                                                case 2126:
                                                    if (!str3.equals("C1")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 20;
                                                    }
                                                    break;
                                                case 2564:
                                                    if (!str3.equals("Q5")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 113;
                                                    }
                                                    break;
                                                case 2715:
                                                    if (!str3.equals("V1")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 127;
                                                    }
                                                    break;
                                                case 2719:
                                                    if (!str3.equals("V5")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 129;
                                                    }
                                                    break;
                                                case 3091:
                                                    if (!str3.equals("b5")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 16;
                                                    }
                                                    break;
                                                case 3483:
                                                    if (!str3.equals("mh")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 84;
                                                    }
                                                    break;
                                                case 73405:
                                                    if (!str3.equals("JGZ")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 73;
                                                    }
                                                    break;
                                                case 75537:
                                                    if (!str3.equals("M04")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 79;
                                                    }
                                                    break;
                                                case 75739:
                                                    if (!str3.equals("M5c")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 80;
                                                    }
                                                    break;
                                                case 76779:
                                                    if (!str3.equals("MX6")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 86;
                                                    }
                                                    break;
                                                case 78669:
                                                    if (!str3.equals("P85")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 94;
                                                    }
                                                    break;
                                                case 79305:
                                                    if (!str3.equals("PLE")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 107;
                                                    }
                                                    break;
                                                case 80618:
                                                    if (!str3.equals("QX1")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 115;
                                                    }
                                                    break;
                                                case 88274:
                                                    if (!str3.equals("Z80")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 139;
                                                    }
                                                    break;
                                                case 98846:
                                                    if (!str3.equals("cv1")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 26;
                                                    }
                                                    break;
                                                case 98848:
                                                    if (!str3.equals("cv3")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 27;
                                                    }
                                                    break;
                                                case 99329:
                                                    if (!str3.equals("deb")) {
                                                        b4 = -1;
                                                    }
                                                    break;
                                                case 101481:
                                                    if (!str3.equals("flo")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 49;
                                                    }
                                                    break;
                                                case 1513190:
                                                    if (!str3.equals("1601")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 0;
                                                    }
                                                    break;
                                                case 1514184:
                                                    if (!str3.equals("1713")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 1;
                                                    }
                                                    break;
                                                case 1514185:
                                                    if (!str3.equals("1714")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 2;
                                                    }
                                                    break;
                                                case 2133089:
                                                    if (!str3.equals("F01H")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 36;
                                                    }
                                                    break;
                                                case 2133091:
                                                    if (!str3.equals("F01J")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 37;
                                                    }
                                                    break;
                                                case 2133120:
                                                    if (!str3.equals("F02H")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 38;
                                                    }
                                                    break;
                                                case 2133151:
                                                    if (!str3.equals("F03H")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 39;
                                                    }
                                                    break;
                                                case 2133182:
                                                    if (!str3.equals("F04H")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 40;
                                                    }
                                                    break;
                                                case 2133184:
                                                    if (!str3.equals("F04J")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 41;
                                                    }
                                                    break;
                                                case 2436959:
                                                    if (!str3.equals("P681")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 93;
                                                    }
                                                    break;
                                                case 2463773:
                                                    if (!str3.equals("Q350")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 109;
                                                    }
                                                    break;
                                                case 2464648:
                                                    if (!str3.equals("Q427")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 111;
                                                    }
                                                    break;
                                                case 2689555:
                                                    if (!str3.equals("XE2X")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 136;
                                                    }
                                                    break;
                                                case 3154429:
                                                    if (!str3.equals("fugu")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 50;
                                                    }
                                                    break;
                                                case 3284551:
                                                    if (!str3.equals("kate")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 75;
                                                    }
                                                    break;
                                                case 3351335:
                                                    if (!str3.equals("mido")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 85;
                                                    }
                                                    break;
                                                case 3386211:
                                                    if (!str3.equals("p212")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 92;
                                                    }
                                                    break;
                                                case 41325051:
                                                    if (!str3.equals("MEIZU_M5")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 83;
                                                    }
                                                    break;
                                                case 51349633:
                                                    if (!str3.equals("601LV")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 3;
                                                    }
                                                    break;
                                                case 51350594:
                                                    if (!str3.equals("602LV")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 4;
                                                    }
                                                    break;
                                                case 55178625:
                                                    if (!str3.equals("Aura_Note_2")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 15;
                                                    }
                                                    break;
                                                case 61542055:
                                                    if (!str3.equals("A1601")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 7;
                                                    }
                                                    break;
                                                case 65355429:
                                                    if (!str3.equals("E5643")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 30;
                                                    }
                                                    break;
                                                case 66214468:
                                                    if (!str3.equals("F3111")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 42;
                                                    }
                                                    break;
                                                case 66214470:
                                                    if (!str3.equals("F3113")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 43;
                                                    }
                                                    break;
                                                case 66214473:
                                                    if (!str3.equals("F3116")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 44;
                                                    }
                                                    break;
                                                case 66215429:
                                                    if (!str3.equals("F3211")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 45;
                                                    }
                                                    break;
                                                case 66215431:
                                                    if (!str3.equals("F3213")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 46;
                                                    }
                                                    break;
                                                case 66215433:
                                                    if (!str3.equals("F3215")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 47;
                                                    }
                                                    break;
                                                case 66216390:
                                                    if (!str3.equals("F3311")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 48;
                                                    }
                                                    break;
                                                case 76402249:
                                                    if (!str3.equals("PRO7S")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 108;
                                                    }
                                                    break;
                                                case 76404105:
                                                    if (!str3.equals("Q4260")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 110;
                                                    }
                                                    break;
                                                case 76404911:
                                                    if (!str3.equals("Q4310")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 112;
                                                    }
                                                    break;
                                                case 80963634:
                                                    if (!str3.equals("V23GB")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 128;
                                                    }
                                                    break;
                                                case 82882791:
                                                    if (!str3.equals("X3_HK")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 135;
                                                    }
                                                    break;
                                                case 98715550:
                                                    if (!str3.equals("i9031")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 67;
                                                    }
                                                    break;
                                                case 101370885:
                                                    if (!str3.equals("l5460")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 76;
                                                    }
                                                    break;
                                                case 102844228:
                                                    if (!str3.equals("le_x6")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 77;
                                                    }
                                                    break;
                                                case 165221241:
                                                    if (!str3.equals("A2016a40")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 8;
                                                    }
                                                    break;
                                                case 182191441:
                                                    if (!str3.equals("CPY83_I00")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 25;
                                                    }
                                                    break;
                                                case 245388979:
                                                    if (!str3.equals("marino_f")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 82;
                                                    }
                                                    break;
                                                case 287431619:
                                                    if (!str3.equals("griffin")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 60;
                                                    }
                                                    break;
                                                case 307593612:
                                                    if (!str3.equals("A7010a48")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 11;
                                                    }
                                                    break;
                                                case 308517133:
                                                    if (!str3.equals("A7020a48")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 12;
                                                    }
                                                    break;
                                                case 316215098:
                                                    if (!str3.equals("TB3-730F")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 122;
                                                    }
                                                    break;
                                                case 316215116:
                                                    if (!str3.equals("TB3-730X")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 123;
                                                    }
                                                    break;
                                                case 316246811:
                                                    if (!str3.equals("TB3-850F")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 124;
                                                    }
                                                    break;
                                                case 316246818:
                                                    if (!str3.equals("TB3-850M")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 125;
                                                    }
                                                    break;
                                                case 407160593:
                                                    if (!str3.equals("Pixi5-10_4G")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 106;
                                                    }
                                                    break;
                                                case 507412548:
                                                    if (!str3.equals("QM16XE_U")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 114;
                                                    }
                                                    break;
                                                case 793982701:
                                                    if (!str3.equals("GIONEE_WBL5708")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 57;
                                                    }
                                                    break;
                                                case 794038622:
                                                    if (!str3.equals("GIONEE_WBL7365")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 58;
                                                    }
                                                    break;
                                                case 794040393:
                                                    if (!str3.equals("GIONEE_WBL7519")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 59;
                                                    }
                                                    break;
                                                case 835649806:
                                                    if (!str3.equals("manning")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 81;
                                                    }
                                                    break;
                                                case 917340916:
                                                    if (!str3.equals("A7000plus")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 10;
                                                    }
                                                    break;
                                                case 958008161:
                                                    if (!str3.equals("j2xlteins")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 72;
                                                    }
                                                    break;
                                                case 1060579533:
                                                    if (!str3.equals("panell_d")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 96;
                                                    }
                                                    break;
                                                case 1150207623:
                                                    if (!str3.equals("LS-5017")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 78;
                                                    }
                                                    break;
                                                case 1176899427:
                                                    if (!str3.equals("itel_S41")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 71;
                                                    }
                                                    break;
                                                case 1280332038:
                                                    if (!str3.equals("hwALE-H")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 62;
                                                    }
                                                    break;
                                                case 1306947716:
                                                    if (!str3.equals("EverStar_S")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 35;
                                                    }
                                                    break;
                                                case 1349174697:
                                                    if (!str3.equals("htc_e56ml_dtul")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = Base64.padSymbol;
                                                    }
                                                    break;
                                                case 1522194893:
                                                    if (!str3.equals("woods_f")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 133;
                                                    }
                                                    break;
                                                case 1691543273:
                                                    if (!str3.equals("CPH1609")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 23;
                                                    }
                                                    break;
                                                case 1691544261:
                                                    if (!str3.equals("CPH1715")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 24;
                                                    }
                                                    break;
                                                case 1709443163:
                                                    if (!str3.equals("iball8735_9806")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 68;
                                                    }
                                                    break;
                                                case 1865889110:
                                                    if (!str3.equals("santoni")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 117;
                                                    }
                                                    break;
                                                case 1906253259:
                                                    if (!str3.equals("PB2-670M")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 100;
                                                    }
                                                    break;
                                                case 1977196784:
                                                    if (!str3.equals("Infinix-X572")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 69;
                                                    }
                                                    break;
                                                case 2006372676:
                                                    if (!str3.equals("BRAVIA_ATV3_4K")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 19;
                                                    }
                                                    break;
                                                case 2019281702:
                                                    if (!str3.equals("DM-01K")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 29;
                                                    }
                                                    break;
                                                case 2029784656:
                                                    if (!str3.equals("HWBLN-H")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 63;
                                                    }
                                                    break;
                                                case 2030379515:
                                                    if (!str3.equals("HWCAM-H")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = SignedBytes.MAX_POWER_OF_TWO;
                                                    }
                                                    break;
                                                case 2033393791:
                                                    if (!str3.equals("ASUS_X00AD_2")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 14;
                                                    }
                                                    break;
                                                case 2047190025:
                                                    if (!str3.equals("ELUGA_Note")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 32;
                                                    }
                                                    break;
                                                case 2047252157:
                                                    if (!str3.equals("ELUGA_Prim")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 33;
                                                    }
                                                    break;
                                                case 2048319463:
                                                    if (!str3.equals("HWVNS-H")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 65;
                                                    }
                                                    break;
                                                case 2048855701:
                                                    if (!str3.equals("HWWAS-H")) {
                                                        b4 = -1;
                                                    } else {
                                                        b4 = 66;
                                                    }
                                                    break;
                                                default:
                                                    b4 = -1;
                                                    break;
                                            }
                                            switch (b4) {
                                                default:
                                                    if (str2.hashCode() == -594534941 && str2.equals("JSN-L21")) {
                                                        b5 = 0;
                                                    }
                                                    if (b5 == 0) {
                                                    }
                                                case 0:
                                                case 1:
                                                case 2:
                                                case 3:
                                                case 4:
                                                case 5:
                                                case 6:
                                                case 7:
                                                case 8:
                                                case 9:
                                                case 10:
                                                case 11:
                                                case 12:
                                                case 13:
                                                case 14:
                                                case 15:
                                                case 16:
                                                case 17:
                                                case 18:
                                                case 19:
                                                case 20:
                                                case 21:
                                                case 22:
                                                case 23:
                                                case 24:
                                                case 25:
                                                case 26:
                                                case 27:
                                                case 28:
                                                case 29:
                                                case 30:
                                                case 31:
                                                case 32:
                                                case 33:
                                                case 34:
                                                case 35:
                                                case 36:
                                                case 37:
                                                case 38:
                                                case 39:
                                                case 40:
                                                case 41:
                                                case 42:
                                                case 43:
                                                case 44:
                                                case 45:
                                                case 46:
                                                case 47:
                                                case 48:
                                                case 49:
                                                case 50:
                                                case 51:
                                                case 52:
                                                case 53:
                                                case 54:
                                                case 55:
                                                case 56:
                                                case 57:
                                                case 58:
                                                case 59:
                                                case 60:
                                                case 61:
                                                case 62:
                                                case 63:
                                                case 64:
                                                case 65:
                                                case 66:
                                                case 67:
                                                case 68:
                                                case 69:
                                                case 70:
                                                case 71:
                                                case 72:
                                                case 73:
                                                case 74:
                                                case 75:
                                                case 76:
                                                case 77:
                                                case 78:
                                                case 79:
                                                case 80:
                                                case 81:
                                                case 82:
                                                case 83:
                                                case 84:
                                                case 85:
                                                case 86:
                                                case 87:
                                                case 88:
                                                case 89:
                                                case 90:
                                                case 91:
                                                case 92:
                                                case 93:
                                                case 94:
                                                case 95:
                                                case 96:
                                                case 97:
                                                case 98:
                                                case 99:
                                                case 100:
                                                case 101:
                                                case 102:
                                                case 103:
                                                case 104:
                                                case 105:
                                                case 106:
                                                case 107:
                                                case 108:
                                                case 109:
                                                case 110:
                                                case 111:
                                                case 112:
                                                case 113:
                                                case 114:
                                                case 115:
                                                case 116:
                                                case 117:
                                                case 118:
                                                case 119:
                                                case 120:
                                                case 121:
                                                case 122:
                                                case 123:
                                                case 124:
                                                case 125:
                                                case 126:
                                                case WorkQueueKt.MASK /* 127 */:
                                                case 128:
                                                case 129:
                                                case 130:
                                                case 131:
                                                case 132:
                                                case 133:
                                                case 134:
                                                case 135:
                                                case 136:
                                                case 137:
                                                case 138:
                                                case 139:
                                                    z = true;
                                                    break;
                                            }
                                        }
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                        z = true;
                                        break;
                                }
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            z = true;
                            break;
                    }
                } else if (zzfk.zza <= 27) {
                    str2 = zzfk.zzd;
                    switch (str2.hashCode()) {
                        case -349662828:
                            if (!str2.equals("AFTJMST12")) {
                                b2 = -1;
                            } else {
                                b2 = 6;
                            }
                            break;
                        case -321033677:
                            if (!str2.equals("AFTKMST12")) {
                                b2 = -1;
                            } else {
                                b2 = 7;
                            }
                            break;
                        case 2006354:
                            if (!str2.equals("AFTA")) {
                                b2 = -1;
                            } else {
                                b2 = 0;
                            }
                            break;
                        case 2006367:
                            if (!str2.equals("AFTN")) {
                                b2 = -1;
                            } else {
                                b2 = 1;
                            }
                            break;
                        case 2006371:
                            if (!str2.equals("AFTR")) {
                                b2 = -1;
                            } else {
                                b2 = 2;
                            }
                            break;
                        case 1785421873:
                            if (!str2.equals("AFTEU011")) {
                                b2 = -1;
                            } else {
                                b2 = 3;
                            }
                            break;
                        case 1785421876:
                            if (!str2.equals("AFTEU014")) {
                                b2 = -1;
                            } else {
                                b2 = 4;
                            }
                            break;
                        case 1798172390:
                            if (!str2.equals("AFTSO001")) {
                                b2 = -1;
                            } else {
                                b2 = 8;
                            }
                            break;
                        case 2119412532:
                            if (!str2.equals("AFTEUFF014")) {
                                b2 = -1;
                            } else {
                                b2 = 5;
                            }
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    switch (b2) {
                        default:
                            if (zzfk.zza <= 26) {
                                str3 = zzfk.zzb;
                                switch (str3.hashCode()) {
                                    case -2144781245:
                                        if (!str3.equals("GIONEE_SWW1609")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 54;
                                        }
                                        break;
                                    case -2144781185:
                                        if (!str3.equals("GIONEE_SWW1627")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 55;
                                        }
                                        break;
                                    case -2144781160:
                                        if (!str3.equals("GIONEE_SWW1631")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 56;
                                        }
                                        break;
                                    case -2097309513:
                                        if (!str3.equals("K50a40")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 74;
                                        }
                                        break;
                                    case -2022874474:
                                        if (!str3.equals("CP8676_I02")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 22;
                                        }
                                        break;
                                    case -1978993182:
                                        if (!str3.equals("NX541J")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 89;
                                        }
                                        break;
                                    case -1978990237:
                                        if (!str3.equals("NX573J")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 90;
                                        }
                                        break;
                                    case -1936688988:
                                        if (!str3.equals("PGN528")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 101;
                                        }
                                        break;
                                    case -1936688066:
                                        if (!str3.equals("PGN610")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 102;
                                        }
                                        break;
                                    case -1936688065:
                                        if (!str3.equals("PGN611")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 103;
                                        }
                                        break;
                                    case -1931988508:
                                        if (!str3.equals("AquaPowerM")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 13;
                                        }
                                        break;
                                    case -1885099851:
                                        if (!str3.equals("RAIJIN")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 116;
                                        }
                                        break;
                                    case -1696512866:
                                        if (!str3.equals("XT1663")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 137;
                                        }
                                        break;
                                    case -1680025915:
                                        if (!str3.equals("ComioS1")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 21;
                                        }
                                        break;
                                    case -1615810839:
                                        if (!str3.equals("Phantom6")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 104;
                                        }
                                        break;
                                    case -1600724499:
                                        if (!str3.equals("pacificrim")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 95;
                                        }
                                        break;
                                    case -1554255044:
                                        if (!str3.equals("vernee_M5")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 130;
                                        }
                                        break;
                                    case -1481772737:
                                        if (!str3.equals("panell_dl")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 97;
                                        }
                                        break;
                                    case -1481772730:
                                        if (!str3.equals("panell_ds")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 98;
                                        }
                                        break;
                                    case -1481772729:
                                        if (!str3.equals("panell_dt")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 99;
                                        }
                                        break;
                                    case -1320080169:
                                        if (!str3.equals("GiONEE_GBL7319")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 52;
                                        }
                                        break;
                                    case -1217592143:
                                        if (!str3.equals("BRAVIA_ATV2")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 18;
                                        }
                                        break;
                                    case -1180384755:
                                        if (!str3.equals("iris60")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 70;
                                        }
                                        break;
                                    case -1139198265:
                                        if (!str3.equals("Slate_Pro")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 118;
                                        }
                                        break;
                                    case -1052835013:
                                        if (!str3.equals("namath")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 87;
                                        }
                                        break;
                                    case -993250464:
                                        if (!str3.equals("A10-70F")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 5;
                                        }
                                        break;
                                    case -993250458:
                                        if (!str3.equals("A10-70L")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 6;
                                        }
                                        break;
                                    case -965403638:
                                        if (!str3.equals("s905x018")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 120;
                                        }
                                        break;
                                    case -958336948:
                                        if (!str3.equals("ELUGA_Ray_X")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 34;
                                        }
                                        break;
                                    case -879245230:
                                        if (!str3.equals("tcl_eu")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 126;
                                        }
                                        break;
                                    case -842500323:
                                        if (!str3.equals("nicklaus_f")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 88;
                                        }
                                        break;
                                    case -821392978:
                                        if (!str3.equals("A7000-a")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 9;
                                        }
                                        break;
                                    case -797483286:
                                        if (!str3.equals("SVP-DTV15")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 119;
                                        }
                                        break;
                                    case -794946968:
                                        if (!str3.equals("watson")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 131;
                                        }
                                        break;
                                    case -788334647:
                                        if (!str3.equals("whyred")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 132;
                                        }
                                        break;
                                    case -782144577:
                                        if (!str3.equals("OnePlus5T")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 91;
                                        }
                                        break;
                                    case -575125681:
                                        if (!str3.equals("GiONEE_CBL7513")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 51;
                                        }
                                        break;
                                    case -521118391:
                                        if (!str3.equals("GIONEE_GBL7360")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 53;
                                        }
                                        break;
                                    case -430914369:
                                        if (!str3.equals("Pixi4-7_3G")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 105;
                                        }
                                        break;
                                    case -290434366:
                                        if (!str3.equals("taido_row")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 121;
                                        }
                                        break;
                                    case -282781963:
                                        if (!str3.equals("BLACK-1X")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 17;
                                        }
                                        break;
                                    case -277133239:
                                        if (!str3.equals("Z12_PRO")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 138;
                                        }
                                        break;
                                    case -173639913:
                                        if (!str3.equals("ELUGA_A3_Pro")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 31;
                                        }
                                        break;
                                    case -56598463:
                                        if (!str3.equals("woods_fn")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 134;
                                        }
                                        break;
                                    case 2126:
                                        if (!str3.equals("C1")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 20;
                                        }
                                        break;
                                    case 2564:
                                        if (!str3.equals("Q5")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 113;
                                        }
                                        break;
                                    case 2715:
                                        if (!str3.equals("V1")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 127;
                                        }
                                        break;
                                    case 2719:
                                        if (!str3.equals("V5")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 129;
                                        }
                                        break;
                                    case 3091:
                                        if (!str3.equals("b5")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 16;
                                        }
                                        break;
                                    case 3483:
                                        if (!str3.equals("mh")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 84;
                                        }
                                        break;
                                    case 73405:
                                        if (!str3.equals("JGZ")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 73;
                                        }
                                        break;
                                    case 75537:
                                        if (!str3.equals("M04")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 79;
                                        }
                                        break;
                                    case 75739:
                                        if (!str3.equals("M5c")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 80;
                                        }
                                        break;
                                    case 76779:
                                        if (!str3.equals("MX6")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 86;
                                        }
                                        break;
                                    case 78669:
                                        if (!str3.equals("P85")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 94;
                                        }
                                        break;
                                    case 79305:
                                        if (!str3.equals("PLE")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 107;
                                        }
                                        break;
                                    case 80618:
                                        if (!str3.equals("QX1")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 115;
                                        }
                                        break;
                                    case 88274:
                                        if (!str3.equals("Z80")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 139;
                                        }
                                        break;
                                    case 98846:
                                        if (!str3.equals("cv1")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 26;
                                        }
                                        break;
                                    case 98848:
                                        if (!str3.equals("cv3")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 27;
                                        }
                                        break;
                                    case 99329:
                                        if (!str3.equals("deb")) {
                                            b4 = -1;
                                        }
                                        break;
                                    case 101481:
                                        if (!str3.equals("flo")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 49;
                                        }
                                        break;
                                    case 1513190:
                                        if (!str3.equals("1601")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 0;
                                        }
                                        break;
                                    case 1514184:
                                        if (!str3.equals("1713")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 1;
                                        }
                                        break;
                                    case 1514185:
                                        if (!str3.equals("1714")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 2;
                                        }
                                        break;
                                    case 2133089:
                                        if (!str3.equals("F01H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 36;
                                        }
                                        break;
                                    case 2133091:
                                        if (!str3.equals("F01J")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 37;
                                        }
                                        break;
                                    case 2133120:
                                        if (!str3.equals("F02H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 38;
                                        }
                                        break;
                                    case 2133151:
                                        if (!str3.equals("F03H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 39;
                                        }
                                        break;
                                    case 2133182:
                                        if (!str3.equals("F04H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 40;
                                        }
                                        break;
                                    case 2133184:
                                        if (!str3.equals("F04J")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 41;
                                        }
                                        break;
                                    case 2436959:
                                        if (!str3.equals("P681")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 93;
                                        }
                                        break;
                                    case 2463773:
                                        if (!str3.equals("Q350")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 109;
                                        }
                                        break;
                                    case 2464648:
                                        if (!str3.equals("Q427")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 111;
                                        }
                                        break;
                                    case 2689555:
                                        if (!str3.equals("XE2X")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 136;
                                        }
                                        break;
                                    case 3154429:
                                        if (!str3.equals("fugu")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 50;
                                        }
                                        break;
                                    case 3284551:
                                        if (!str3.equals("kate")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 75;
                                        }
                                        break;
                                    case 3351335:
                                        if (!str3.equals("mido")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 85;
                                        }
                                        break;
                                    case 3386211:
                                        if (!str3.equals("p212")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 92;
                                        }
                                        break;
                                    case 41325051:
                                        if (!str3.equals("MEIZU_M5")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 83;
                                        }
                                        break;
                                    case 51349633:
                                        if (!str3.equals("601LV")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 3;
                                        }
                                        break;
                                    case 51350594:
                                        if (!str3.equals("602LV")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 4;
                                        }
                                        break;
                                    case 55178625:
                                        if (!str3.equals("Aura_Note_2")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 15;
                                        }
                                        break;
                                    case 61542055:
                                        if (!str3.equals("A1601")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 7;
                                        }
                                        break;
                                    case 65355429:
                                        if (!str3.equals("E5643")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 30;
                                        }
                                        break;
                                    case 66214468:
                                        if (!str3.equals("F3111")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 42;
                                        }
                                        break;
                                    case 66214470:
                                        if (!str3.equals("F3113")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 43;
                                        }
                                        break;
                                    case 66214473:
                                        if (!str3.equals("F3116")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 44;
                                        }
                                        break;
                                    case 66215429:
                                        if (!str3.equals("F3211")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 45;
                                        }
                                        break;
                                    case 66215431:
                                        if (!str3.equals("F3213")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 46;
                                        }
                                        break;
                                    case 66215433:
                                        if (!str3.equals("F3215")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 47;
                                        }
                                        break;
                                    case 66216390:
                                        if (!str3.equals("F3311")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 48;
                                        }
                                        break;
                                    case 76402249:
                                        if (!str3.equals("PRO7S")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 108;
                                        }
                                        break;
                                    case 76404105:
                                        if (!str3.equals("Q4260")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 110;
                                        }
                                        break;
                                    case 76404911:
                                        if (!str3.equals("Q4310")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 112;
                                        }
                                        break;
                                    case 80963634:
                                        if (!str3.equals("V23GB")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 128;
                                        }
                                        break;
                                    case 82882791:
                                        if (!str3.equals("X3_HK")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 135;
                                        }
                                        break;
                                    case 98715550:
                                        if (!str3.equals("i9031")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 67;
                                        }
                                        break;
                                    case 101370885:
                                        if (!str3.equals("l5460")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 76;
                                        }
                                        break;
                                    case 102844228:
                                        if (!str3.equals("le_x6")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 77;
                                        }
                                        break;
                                    case 165221241:
                                        if (!str3.equals("A2016a40")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 8;
                                        }
                                        break;
                                    case 182191441:
                                        if (!str3.equals("CPY83_I00")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 25;
                                        }
                                        break;
                                    case 245388979:
                                        if (!str3.equals("marino_f")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 82;
                                        }
                                        break;
                                    case 287431619:
                                        if (!str3.equals("griffin")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 60;
                                        }
                                        break;
                                    case 307593612:
                                        if (!str3.equals("A7010a48")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 11;
                                        }
                                        break;
                                    case 308517133:
                                        if (!str3.equals("A7020a48")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 12;
                                        }
                                        break;
                                    case 316215098:
                                        if (!str3.equals("TB3-730F")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 122;
                                        }
                                        break;
                                    case 316215116:
                                        if (!str3.equals("TB3-730X")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 123;
                                        }
                                        break;
                                    case 316246811:
                                        if (!str3.equals("TB3-850F")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 124;
                                        }
                                        break;
                                    case 316246818:
                                        if (!str3.equals("TB3-850M")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 125;
                                        }
                                        break;
                                    case 407160593:
                                        if (!str3.equals("Pixi5-10_4G")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 106;
                                        }
                                        break;
                                    case 507412548:
                                        if (!str3.equals("QM16XE_U")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 114;
                                        }
                                        break;
                                    case 793982701:
                                        if (!str3.equals("GIONEE_WBL5708")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 57;
                                        }
                                        break;
                                    case 794038622:
                                        if (!str3.equals("GIONEE_WBL7365")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 58;
                                        }
                                        break;
                                    case 794040393:
                                        if (!str3.equals("GIONEE_WBL7519")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 59;
                                        }
                                        break;
                                    case 835649806:
                                        if (!str3.equals("manning")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 81;
                                        }
                                        break;
                                    case 917340916:
                                        if (!str3.equals("A7000plus")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 10;
                                        }
                                        break;
                                    case 958008161:
                                        if (!str3.equals("j2xlteins")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 72;
                                        }
                                        break;
                                    case 1060579533:
                                        if (!str3.equals("panell_d")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 96;
                                        }
                                        break;
                                    case 1150207623:
                                        if (!str3.equals("LS-5017")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 78;
                                        }
                                        break;
                                    case 1176899427:
                                        if (!str3.equals("itel_S41")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 71;
                                        }
                                        break;
                                    case 1280332038:
                                        if (!str3.equals("hwALE-H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 62;
                                        }
                                        break;
                                    case 1306947716:
                                        if (!str3.equals("EverStar_S")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 35;
                                        }
                                        break;
                                    case 1349174697:
                                        if (!str3.equals("htc_e56ml_dtul")) {
                                            b4 = -1;
                                        } else {
                                            b4 = Base64.padSymbol;
                                        }
                                        break;
                                    case 1522194893:
                                        if (!str3.equals("woods_f")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 133;
                                        }
                                        break;
                                    case 1691543273:
                                        if (!str3.equals("CPH1609")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 23;
                                        }
                                        break;
                                    case 1691544261:
                                        if (!str3.equals("CPH1715")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 24;
                                        }
                                        break;
                                    case 1709443163:
                                        if (!str3.equals("iball8735_9806")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 68;
                                        }
                                        break;
                                    case 1865889110:
                                        if (!str3.equals("santoni")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 117;
                                        }
                                        break;
                                    case 1906253259:
                                        if (!str3.equals("PB2-670M")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 100;
                                        }
                                        break;
                                    case 1977196784:
                                        if (!str3.equals("Infinix-X572")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 69;
                                        }
                                        break;
                                    case 2006372676:
                                        if (!str3.equals("BRAVIA_ATV3_4K")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 19;
                                        }
                                        break;
                                    case 2019281702:
                                        if (!str3.equals("DM-01K")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 29;
                                        }
                                        break;
                                    case 2029784656:
                                        if (!str3.equals("HWBLN-H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 63;
                                        }
                                        break;
                                    case 2030379515:
                                        if (!str3.equals("HWCAM-H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = SignedBytes.MAX_POWER_OF_TWO;
                                        }
                                        break;
                                    case 2033393791:
                                        if (!str3.equals("ASUS_X00AD_2")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 14;
                                        }
                                        break;
                                    case 2047190025:
                                        if (!str3.equals("ELUGA_Note")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 32;
                                        }
                                        break;
                                    case 2047252157:
                                        if (!str3.equals("ELUGA_Prim")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 33;
                                        }
                                        break;
                                    case 2048319463:
                                        if (!str3.equals("HWVNS-H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 65;
                                        }
                                        break;
                                    case 2048855701:
                                        if (!str3.equals("HWWAS-H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 66;
                                        }
                                        break;
                                    default:
                                        b4 = -1;
                                        break;
                                }
                                switch (b4) {
                                    default:
                                        if (str2.hashCode() == -594534941) {
                                            b5 = 0;
                                        }
                                        if (b5 == 0) {
                                        }
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                    case 18:
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                    case 31:
                                    case 32:
                                    case 33:
                                    case 34:
                                    case 35:
                                    case 36:
                                    case 37:
                                    case 38:
                                    case 39:
                                    case 40:
                                    case 41:
                                    case 42:
                                    case 43:
                                    case 44:
                                    case 45:
                                    case 46:
                                    case 47:
                                    case 48:
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57:
                                    case 58:
                                    case 59:
                                    case 60:
                                    case 61:
                                    case 62:
                                    case 63:
                                    case 64:
                                    case 65:
                                    case 66:
                                    case 67:
                                    case 68:
                                    case 69:
                                    case 70:
                                    case 71:
                                    case 72:
                                    case 73:
                                    case 74:
                                    case 75:
                                    case 76:
                                    case 77:
                                    case 78:
                                    case 79:
                                    case 80:
                                    case 81:
                                    case 82:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case 86:
                                    case 87:
                                    case 88:
                                    case 89:
                                    case 90:
                                    case 91:
                                    case 92:
                                    case 93:
                                    case 94:
                                    case 95:
                                    case 96:
                                    case 97:
                                    case 98:
                                    case 99:
                                    case 100:
                                    case 101:
                                    case 102:
                                    case 103:
                                    case 104:
                                    case 105:
                                    case 106:
                                    case 107:
                                    case 108:
                                    case 109:
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case 120:
                                    case 121:
                                    case 122:
                                    case 123:
                                    case 124:
                                    case 125:
                                    case 126:
                                    case WorkQueueKt.MASK /* 127 */:
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                    case 136:
                                    case 137:
                                    case 138:
                                    case 139:
                                        z = true;
                                        break;
                                }
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            z = true;
                            break;
                    }
                } else {
                    str2 = zzfk.zzd;
                    switch (str2.hashCode()) {
                        case -349662828:
                            if (!str2.equals("AFTJMST12")) {
                                b2 = -1;
                            } else {
                                b2 = 6;
                            }
                            break;
                        case -321033677:
                            if (!str2.equals("AFTKMST12")) {
                                b2 = -1;
                            } else {
                                b2 = 7;
                            }
                            break;
                        case 2006354:
                            if (!str2.equals("AFTA")) {
                                b2 = -1;
                            } else {
                                b2 = 0;
                            }
                            break;
                        case 2006367:
                            if (!str2.equals("AFTN")) {
                                b2 = -1;
                            } else {
                                b2 = 1;
                            }
                            break;
                        case 2006371:
                            if (!str2.equals("AFTR")) {
                                b2 = -1;
                            } else {
                                b2 = 2;
                            }
                            break;
                        case 1785421873:
                            if (!str2.equals("AFTEU011")) {
                                b2 = -1;
                            } else {
                                b2 = 3;
                            }
                            break;
                        case 1785421876:
                            if (!str2.equals("AFTEU014")) {
                                b2 = -1;
                            } else {
                                b2 = 4;
                            }
                            break;
                        case 1798172390:
                            if (!str2.equals("AFTSO001")) {
                                b2 = -1;
                            } else {
                                b2 = 8;
                            }
                            break;
                        case 2119412532:
                            if (!str2.equals("AFTEUFF014")) {
                                b2 = -1;
                            } else {
                                b2 = 5;
                            }
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    switch (b2) {
                        default:
                            if (zzfk.zza <= 26) {
                                str3 = zzfk.zzb;
                                switch (str3.hashCode()) {
                                    case -2144781245:
                                        if (!str3.equals("GIONEE_SWW1609")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 54;
                                        }
                                        break;
                                    case -2144781185:
                                        if (!str3.equals("GIONEE_SWW1627")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 55;
                                        }
                                        break;
                                    case -2144781160:
                                        if (!str3.equals("GIONEE_SWW1631")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 56;
                                        }
                                        break;
                                    case -2097309513:
                                        if (!str3.equals("K50a40")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 74;
                                        }
                                        break;
                                    case -2022874474:
                                        if (!str3.equals("CP8676_I02")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 22;
                                        }
                                        break;
                                    case -1978993182:
                                        if (!str3.equals("NX541J")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 89;
                                        }
                                        break;
                                    case -1978990237:
                                        if (!str3.equals("NX573J")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 90;
                                        }
                                        break;
                                    case -1936688988:
                                        if (!str3.equals("PGN528")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 101;
                                        }
                                        break;
                                    case -1936688066:
                                        if (!str3.equals("PGN610")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 102;
                                        }
                                        break;
                                    case -1936688065:
                                        if (!str3.equals("PGN611")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 103;
                                        }
                                        break;
                                    case -1931988508:
                                        if (!str3.equals("AquaPowerM")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 13;
                                        }
                                        break;
                                    case -1885099851:
                                        if (!str3.equals("RAIJIN")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 116;
                                        }
                                        break;
                                    case -1696512866:
                                        if (!str3.equals("XT1663")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 137;
                                        }
                                        break;
                                    case -1680025915:
                                        if (!str3.equals("ComioS1")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 21;
                                        }
                                        break;
                                    case -1615810839:
                                        if (!str3.equals("Phantom6")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 104;
                                        }
                                        break;
                                    case -1600724499:
                                        if (!str3.equals("pacificrim")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 95;
                                        }
                                        break;
                                    case -1554255044:
                                        if (!str3.equals("vernee_M5")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 130;
                                        }
                                        break;
                                    case -1481772737:
                                        if (!str3.equals("panell_dl")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 97;
                                        }
                                        break;
                                    case -1481772730:
                                        if (!str3.equals("panell_ds")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 98;
                                        }
                                        break;
                                    case -1481772729:
                                        if (!str3.equals("panell_dt")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 99;
                                        }
                                        break;
                                    case -1320080169:
                                        if (!str3.equals("GiONEE_GBL7319")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 52;
                                        }
                                        break;
                                    case -1217592143:
                                        if (!str3.equals("BRAVIA_ATV2")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 18;
                                        }
                                        break;
                                    case -1180384755:
                                        if (!str3.equals("iris60")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 70;
                                        }
                                        break;
                                    case -1139198265:
                                        if (!str3.equals("Slate_Pro")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 118;
                                        }
                                        break;
                                    case -1052835013:
                                        if (!str3.equals("namath")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 87;
                                        }
                                        break;
                                    case -993250464:
                                        if (!str3.equals("A10-70F")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 5;
                                        }
                                        break;
                                    case -993250458:
                                        if (!str3.equals("A10-70L")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 6;
                                        }
                                        break;
                                    case -965403638:
                                        if (!str3.equals("s905x018")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 120;
                                        }
                                        break;
                                    case -958336948:
                                        if (!str3.equals("ELUGA_Ray_X")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 34;
                                        }
                                        break;
                                    case -879245230:
                                        if (!str3.equals("tcl_eu")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 126;
                                        }
                                        break;
                                    case -842500323:
                                        if (!str3.equals("nicklaus_f")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 88;
                                        }
                                        break;
                                    case -821392978:
                                        if (!str3.equals("A7000-a")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 9;
                                        }
                                        break;
                                    case -797483286:
                                        if (!str3.equals("SVP-DTV15")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 119;
                                        }
                                        break;
                                    case -794946968:
                                        if (!str3.equals("watson")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 131;
                                        }
                                        break;
                                    case -788334647:
                                        if (!str3.equals("whyred")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 132;
                                        }
                                        break;
                                    case -782144577:
                                        if (!str3.equals("OnePlus5T")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 91;
                                        }
                                        break;
                                    case -575125681:
                                        if (!str3.equals("GiONEE_CBL7513")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 51;
                                        }
                                        break;
                                    case -521118391:
                                        if (!str3.equals("GIONEE_GBL7360")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 53;
                                        }
                                        break;
                                    case -430914369:
                                        if (!str3.equals("Pixi4-7_3G")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 105;
                                        }
                                        break;
                                    case -290434366:
                                        if (!str3.equals("taido_row")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 121;
                                        }
                                        break;
                                    case -282781963:
                                        if (!str3.equals("BLACK-1X")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 17;
                                        }
                                        break;
                                    case -277133239:
                                        if (!str3.equals("Z12_PRO")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 138;
                                        }
                                        break;
                                    case -173639913:
                                        if (!str3.equals("ELUGA_A3_Pro")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 31;
                                        }
                                        break;
                                    case -56598463:
                                        if (!str3.equals("woods_fn")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 134;
                                        }
                                        break;
                                    case 2126:
                                        if (!str3.equals("C1")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 20;
                                        }
                                        break;
                                    case 2564:
                                        if (!str3.equals("Q5")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 113;
                                        }
                                        break;
                                    case 2715:
                                        if (!str3.equals("V1")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 127;
                                        }
                                        break;
                                    case 2719:
                                        if (!str3.equals("V5")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 129;
                                        }
                                        break;
                                    case 3091:
                                        if (!str3.equals("b5")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 16;
                                        }
                                        break;
                                    case 3483:
                                        if (!str3.equals("mh")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 84;
                                        }
                                        break;
                                    case 73405:
                                        if (!str3.equals("JGZ")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 73;
                                        }
                                        break;
                                    case 75537:
                                        if (!str3.equals("M04")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 79;
                                        }
                                        break;
                                    case 75739:
                                        if (!str3.equals("M5c")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 80;
                                        }
                                        break;
                                    case 76779:
                                        if (!str3.equals("MX6")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 86;
                                        }
                                        break;
                                    case 78669:
                                        if (!str3.equals("P85")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 94;
                                        }
                                        break;
                                    case 79305:
                                        if (!str3.equals("PLE")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 107;
                                        }
                                        break;
                                    case 80618:
                                        if (!str3.equals("QX1")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 115;
                                        }
                                        break;
                                    case 88274:
                                        if (!str3.equals("Z80")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 139;
                                        }
                                        break;
                                    case 98846:
                                        if (!str3.equals("cv1")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 26;
                                        }
                                        break;
                                    case 98848:
                                        if (!str3.equals("cv3")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 27;
                                        }
                                        break;
                                    case 99329:
                                        if (!str3.equals("deb")) {
                                            b4 = -1;
                                        }
                                        break;
                                    case 101481:
                                        if (!str3.equals("flo")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 49;
                                        }
                                        break;
                                    case 1513190:
                                        if (!str3.equals("1601")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 0;
                                        }
                                        break;
                                    case 1514184:
                                        if (!str3.equals("1713")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 1;
                                        }
                                        break;
                                    case 1514185:
                                        if (!str3.equals("1714")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 2;
                                        }
                                        break;
                                    case 2133089:
                                        if (!str3.equals("F01H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 36;
                                        }
                                        break;
                                    case 2133091:
                                        if (!str3.equals("F01J")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 37;
                                        }
                                        break;
                                    case 2133120:
                                        if (!str3.equals("F02H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 38;
                                        }
                                        break;
                                    case 2133151:
                                        if (!str3.equals("F03H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 39;
                                        }
                                        break;
                                    case 2133182:
                                        if (!str3.equals("F04H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 40;
                                        }
                                        break;
                                    case 2133184:
                                        if (!str3.equals("F04J")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 41;
                                        }
                                        break;
                                    case 2436959:
                                        if (!str3.equals("P681")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 93;
                                        }
                                        break;
                                    case 2463773:
                                        if (!str3.equals("Q350")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 109;
                                        }
                                        break;
                                    case 2464648:
                                        if (!str3.equals("Q427")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 111;
                                        }
                                        break;
                                    case 2689555:
                                        if (!str3.equals("XE2X")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 136;
                                        }
                                        break;
                                    case 3154429:
                                        if (!str3.equals("fugu")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 50;
                                        }
                                        break;
                                    case 3284551:
                                        if (!str3.equals("kate")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 75;
                                        }
                                        break;
                                    case 3351335:
                                        if (!str3.equals("mido")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 85;
                                        }
                                        break;
                                    case 3386211:
                                        if (!str3.equals("p212")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 92;
                                        }
                                        break;
                                    case 41325051:
                                        if (!str3.equals("MEIZU_M5")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 83;
                                        }
                                        break;
                                    case 51349633:
                                        if (!str3.equals("601LV")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 3;
                                        }
                                        break;
                                    case 51350594:
                                        if (!str3.equals("602LV")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 4;
                                        }
                                        break;
                                    case 55178625:
                                        if (!str3.equals("Aura_Note_2")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 15;
                                        }
                                        break;
                                    case 61542055:
                                        if (!str3.equals("A1601")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 7;
                                        }
                                        break;
                                    case 65355429:
                                        if (!str3.equals("E5643")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 30;
                                        }
                                        break;
                                    case 66214468:
                                        if (!str3.equals("F3111")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 42;
                                        }
                                        break;
                                    case 66214470:
                                        if (!str3.equals("F3113")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 43;
                                        }
                                        break;
                                    case 66214473:
                                        if (!str3.equals("F3116")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 44;
                                        }
                                        break;
                                    case 66215429:
                                        if (!str3.equals("F3211")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 45;
                                        }
                                        break;
                                    case 66215431:
                                        if (!str3.equals("F3213")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 46;
                                        }
                                        break;
                                    case 66215433:
                                        if (!str3.equals("F3215")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 47;
                                        }
                                        break;
                                    case 66216390:
                                        if (!str3.equals("F3311")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 48;
                                        }
                                        break;
                                    case 76402249:
                                        if (!str3.equals("PRO7S")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 108;
                                        }
                                        break;
                                    case 76404105:
                                        if (!str3.equals("Q4260")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 110;
                                        }
                                        break;
                                    case 76404911:
                                        if (!str3.equals("Q4310")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 112;
                                        }
                                        break;
                                    case 80963634:
                                        if (!str3.equals("V23GB")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 128;
                                        }
                                        break;
                                    case 82882791:
                                        if (!str3.equals("X3_HK")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 135;
                                        }
                                        break;
                                    case 98715550:
                                        if (!str3.equals("i9031")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 67;
                                        }
                                        break;
                                    case 101370885:
                                        if (!str3.equals("l5460")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 76;
                                        }
                                        break;
                                    case 102844228:
                                        if (!str3.equals("le_x6")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 77;
                                        }
                                        break;
                                    case 165221241:
                                        if (!str3.equals("A2016a40")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 8;
                                        }
                                        break;
                                    case 182191441:
                                        if (!str3.equals("CPY83_I00")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 25;
                                        }
                                        break;
                                    case 245388979:
                                        if (!str3.equals("marino_f")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 82;
                                        }
                                        break;
                                    case 287431619:
                                        if (!str3.equals("griffin")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 60;
                                        }
                                        break;
                                    case 307593612:
                                        if (!str3.equals("A7010a48")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 11;
                                        }
                                        break;
                                    case 308517133:
                                        if (!str3.equals("A7020a48")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 12;
                                        }
                                        break;
                                    case 316215098:
                                        if (!str3.equals("TB3-730F")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 122;
                                        }
                                        break;
                                    case 316215116:
                                        if (!str3.equals("TB3-730X")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 123;
                                        }
                                        break;
                                    case 316246811:
                                        if (!str3.equals("TB3-850F")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 124;
                                        }
                                        break;
                                    case 316246818:
                                        if (!str3.equals("TB3-850M")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 125;
                                        }
                                        break;
                                    case 407160593:
                                        if (!str3.equals("Pixi5-10_4G")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 106;
                                        }
                                        break;
                                    case 507412548:
                                        if (!str3.equals("QM16XE_U")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 114;
                                        }
                                        break;
                                    case 793982701:
                                        if (!str3.equals("GIONEE_WBL5708")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 57;
                                        }
                                        break;
                                    case 794038622:
                                        if (!str3.equals("GIONEE_WBL7365")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 58;
                                        }
                                        break;
                                    case 794040393:
                                        if (!str3.equals("GIONEE_WBL7519")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 59;
                                        }
                                        break;
                                    case 835649806:
                                        if (!str3.equals("manning")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 81;
                                        }
                                        break;
                                    case 917340916:
                                        if (!str3.equals("A7000plus")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 10;
                                        }
                                        break;
                                    case 958008161:
                                        if (!str3.equals("j2xlteins")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 72;
                                        }
                                        break;
                                    case 1060579533:
                                        if (!str3.equals("panell_d")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 96;
                                        }
                                        break;
                                    case 1150207623:
                                        if (!str3.equals("LS-5017")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 78;
                                        }
                                        break;
                                    case 1176899427:
                                        if (!str3.equals("itel_S41")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 71;
                                        }
                                        break;
                                    case 1280332038:
                                        if (!str3.equals("hwALE-H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 62;
                                        }
                                        break;
                                    case 1306947716:
                                        if (!str3.equals("EverStar_S")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 35;
                                        }
                                        break;
                                    case 1349174697:
                                        if (!str3.equals("htc_e56ml_dtul")) {
                                            b4 = -1;
                                        } else {
                                            b4 = Base64.padSymbol;
                                        }
                                        break;
                                    case 1522194893:
                                        if (!str3.equals("woods_f")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 133;
                                        }
                                        break;
                                    case 1691543273:
                                        if (!str3.equals("CPH1609")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 23;
                                        }
                                        break;
                                    case 1691544261:
                                        if (!str3.equals("CPH1715")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 24;
                                        }
                                        break;
                                    case 1709443163:
                                        if (!str3.equals("iball8735_9806")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 68;
                                        }
                                        break;
                                    case 1865889110:
                                        if (!str3.equals("santoni")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 117;
                                        }
                                        break;
                                    case 1906253259:
                                        if (!str3.equals("PB2-670M")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 100;
                                        }
                                        break;
                                    case 1977196784:
                                        if (!str3.equals("Infinix-X572")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 69;
                                        }
                                        break;
                                    case 2006372676:
                                        if (!str3.equals("BRAVIA_ATV3_4K")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 19;
                                        }
                                        break;
                                    case 2019281702:
                                        if (!str3.equals("DM-01K")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 29;
                                        }
                                        break;
                                    case 2029784656:
                                        if (!str3.equals("HWBLN-H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 63;
                                        }
                                        break;
                                    case 2030379515:
                                        if (!str3.equals("HWCAM-H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = SignedBytes.MAX_POWER_OF_TWO;
                                        }
                                        break;
                                    case 2033393791:
                                        if (!str3.equals("ASUS_X00AD_2")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 14;
                                        }
                                        break;
                                    case 2047190025:
                                        if (!str3.equals("ELUGA_Note")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 32;
                                        }
                                        break;
                                    case 2047252157:
                                        if (!str3.equals("ELUGA_Prim")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 33;
                                        }
                                        break;
                                    case 2048319463:
                                        if (!str3.equals("HWVNS-H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 65;
                                        }
                                        break;
                                    case 2048855701:
                                        if (!str3.equals("HWWAS-H")) {
                                            b4 = -1;
                                        } else {
                                            b4 = 66;
                                        }
                                        break;
                                    default:
                                        b4 = -1;
                                        break;
                                }
                                switch (b4) {
                                    default:
                                        if (str2.hashCode() == -594534941) {
                                            b5 = 0;
                                        }
                                        if (b5 == 0) {
                                        }
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                    case 18:
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                    case 31:
                                    case 32:
                                    case 33:
                                    case 34:
                                    case 35:
                                    case 36:
                                    case 37:
                                    case 38:
                                    case 39:
                                    case 40:
                                    case 41:
                                    case 42:
                                    case 43:
                                    case 44:
                                    case 45:
                                    case 46:
                                    case 47:
                                    case 48:
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57:
                                    case 58:
                                    case 59:
                                    case 60:
                                    case 61:
                                    case 62:
                                    case 63:
                                    case 64:
                                    case 65:
                                    case 66:
                                    case 67:
                                    case 68:
                                    case 69:
                                    case 70:
                                    case 71:
                                    case 72:
                                    case 73:
                                    case 74:
                                    case 75:
                                    case 76:
                                    case 77:
                                    case 78:
                                    case 79:
                                    case 80:
                                    case 81:
                                    case 82:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case 86:
                                    case 87:
                                    case 88:
                                    case 89:
                                    case 90:
                                    case 91:
                                    case 92:
                                    case 93:
                                    case 94:
                                    case 95:
                                    case 96:
                                    case 97:
                                    case 98:
                                    case 99:
                                    case 100:
                                    case 101:
                                    case 102:
                                    case 103:
                                    case 104:
                                    case 105:
                                    case 106:
                                    case 107:
                                    case 108:
                                    case 109:
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case 120:
                                    case 121:
                                    case 122:
                                    case 123:
                                    case 124:
                                    case 125:
                                    case 126:
                                    case WorkQueueKt.MASK /* 127 */:
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                    case 136:
                                    case 137:
                                    case 138:
                                    case 139:
                                        z = true;
                                        break;
                                }
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            z = true;
                            break;
                    }
                }
                zzd = z;
                zzc = true;
            }
        }
        return zzd;
    }

    private static List zzaM(Context context, zzsg zzsgVar, zzam zzamVar, boolean z, boolean z2) throws zzsn {
        if (zzamVar.zzm == null) {
            return zzfvs.zzl();
        }
        if (zzfk.zza >= 26 && "video/dolby-vision".equals(zzamVar.zzm) && !zzza.zza(context)) {
            List listZzf = zzst.zzf(zzsgVar, zzamVar, z, z2);
            if (!listZzf.isEmpty()) {
                return listZzf;
            }
        }
        return zzst.zzh(zzsgVar, zzamVar, z, z2);
    }

    private final void zzaN(int i) {
        this.zzq = Math.min(this.zzq, i);
        int i2 = zzfk.zza;
    }

    private final void zzaO() {
        Surface surface = this.zzm;
        if (surface == null || this.zzq == 3) {
            return;
        }
        this.zzq = 3;
        this.zzh.zzq(surface);
        this.zzo = true;
    }

    private final void zzaP(zzdm zzdmVar) {
        if (zzdmVar.equals(zzdm.zza) || zzdmVar.equals(this.zzD)) {
            return;
        }
        this.zzD = zzdmVar;
        this.zzh.zzt(zzdmVar);
    }

    private final void zzaQ() {
        zzdm zzdmVar = this.zzD;
        if (zzdmVar != null) {
            this.zzh.zzt(zzdmVar);
        }
    }

    private final void zzaR() {
        Surface surface = this.zzm;
        zzzi zzziVar = this.zzn;
        if (surface == zzziVar) {
            this.zzm = null;
        }
        if (zzziVar != null) {
            zzziVar.release();
            this.zzn = null;
        }
    }

    private static boolean zzaS(long j) {
        return j < -30000;
    }

    private final boolean zzaT(zzrz zzrzVar) {
        return zzfk.zza >= 23 && !zzaL(zzrzVar.zza) && (!zzrzVar.zzf || zzzi.zzb(this.zze));
    }

    public static int zzaa(zzrz zzrzVar, zzam zzamVar) {
        int iIntValue;
        int i = zzamVar.zzr;
        int i2 = zzamVar.zzs;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        String str = zzamVar.zzm;
        Objects.requireNonNull(str);
        if ("video/dolby-vision".equals(str)) {
            Pair pairZzb = zzst.zzb(zzamVar);
            str = (pairZzb == null || !((iIntValue = ((Integer) pairZzb.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
        }
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/av01":
            case "video/x-vnd.on2.vp8":
                return ((i * i2) * 3) / 4;
            case "video/hevc":
                return Math.max(2097152, ((i * i2) * 3) / 4);
            case "video/avc":
                if ("BRAVIA 4K 2015".equals(zzfk.zzd) || ("Amazon".equals(zzfk.zzc) && ("KFSOWI".equals(zzfk.zzd) || ("AFTS".equals(zzfk.zzd) && zzrzVar.zzf)))) {
                    return -1;
                }
                return ((((i + 15) / 16) * ((i2 + 15) / 16)) * 768) / 4;
            case "video/x-vnd.on2.vp9":
                return ((i * i2) * 3) / 8;
            default:
                return -1;
        }
    }

    protected static int zzab(zzrz zzrzVar, zzam zzamVar) {
        if (zzamVar.zzn == -1) {
            return zzaa(zzrzVar, zzamVar);
        }
        int size = zzamVar.zzo.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += ((byte[]) zzamVar.zzo.get(i)).length;
        }
        return zzamVar.zzn + length;
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzic
    protected final void zzA() {
        try {
            super.zzA();
            this.zzF = false;
            if (this.zzn != null) {
            }
        } finally {
            this.zzF = false;
            if (this.zzn != null) {
                zzaR();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzB() {
        this.zzu = 0;
        zzh();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.zzt = jElapsedRealtime;
        this.zzy = zzfk.zzq(jElapsedRealtime);
        this.zzz = 0L;
        this.zzA = 0;
        this.zzf.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzC() {
        this.zzs = -9223372036854775807L;
        if (this.zzu > 0) {
            zzh();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.zzh.zzd(this.zzu, jElapsedRealtime - this.zzt);
            this.zzu = 0;
            this.zzt = jElapsedRealtime;
        }
        int i = this.zzA;
        if (i != 0) {
            this.zzh.zzr(this.zzz, i);
            this.zzz = 0L;
            this.zzA = 0;
        }
        this.zzf.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlr
    public final void zzK(float f, float f2) throws zzil {
        super.zzK(f, f2);
        this.zzf.zze(f);
        if (this.zzI != null) {
            zzdx.zzd(((double) f) >= 0.0d);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlr, com.google.android.gms.internal.ads.zzlt
    public final String zzR() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzlr
    public final boolean zzT() {
        return super.zzT() && this.zzI == null;
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzlr
    public final boolean zzU() {
        zzaah zzaahVar;
        zzzi zzziVar;
        if (super.zzU() && (((zzaahVar = this.zzI) == null || zzaahVar.zzg()) && (this.zzq == 3 || (((zzziVar = this.zzn) != null && this.zzm == zzziVar) || zzar() == null)))) {
            this.zzs = -9223372036854775807L;
            return true;
        }
        if (this.zzs == -9223372036854775807L) {
            return false;
        }
        zzh();
        if (SystemClock.elapsedRealtime() < this.zzs) {
            return true;
        }
        this.zzs = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final float zzW(float f, zzam zzamVar, zzam[] zzamVarArr) {
        float fMax = -1.0f;
        for (zzam zzamVar2 : zzamVarArr) {
            float f2 = zzamVar2.zzt;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final int zzX(zzsg zzsgVar, zzam zzamVar) throws zzsn {
        boolean z;
        if (!zzcb.zzg(zzamVar.zzm)) {
            return 128;
        }
        int i = 0;
        boolean z2 = zzamVar.zzp != null;
        List listZzaM = zzaM(this.zze, zzsgVar, zzamVar, z2, false);
        if (z2 && listZzaM.isEmpty()) {
            listZzaM = zzaM(this.zze, zzsgVar, zzamVar, false, false);
        }
        if (listZzaM.isEmpty()) {
            return 129;
        }
        if (!zzaG(zzamVar)) {
            return 130;
        }
        zzrz zzrzVar = (zzrz) listZzaM.get(0);
        boolean zZze = zzrzVar.zze(zzamVar);
        if (!zZze) {
            int i2 = 1;
            while (true) {
                if (i2 >= listZzaM.size()) {
                    z = true;
                    break;
                }
                zzrz zzrzVar2 = (zzrz) listZzaM.get(i2);
                if (zzrzVar2.zze(zzamVar)) {
                    zZze = true;
                    z = false;
                    zzrzVar = zzrzVar2;
                    break;
                }
                i2++;
            }
        } else {
            z = true;
            break;
        }
        int i3 = true != zZze ? 3 : 4;
        int i4 = true != zzrzVar.zzf(zzamVar) ? 8 : 16;
        int i5 = true != zzrzVar.zzg ? 0 : 64;
        int i6 = true != z ? 0 : 128;
        if (zzfk.zza >= 26 && "video/dolby-vision".equals(zzamVar.zzm) && !zzza.zza(this.zze)) {
            i6 = 256;
        }
        if (zZze) {
            List listZzaM2 = zzaM(this.zze, zzsgVar, zzamVar, z2, true);
            if (!listZzaM2.isEmpty()) {
                zzrz zzrzVar3 = (zzrz) zzst.zzi(listZzaM2, zzamVar).get(0);
                if (zzrzVar3.zze(zzamVar) && zzrzVar3.zzf(zzamVar)) {
                    i = 32;
                }
            }
        }
        return i3 | i4 | i | i5 | i6;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final zzie zzY(zzrz zzrzVar, zzam zzamVar, zzam zzamVar2) {
        int i;
        int i2;
        zzie zzieVarZzb = zzrzVar.zzb(zzamVar, zzamVar2);
        int i3 = zzieVarZzb.zze;
        zzzb zzzbVar = this.zzj;
        Objects.requireNonNull(zzzbVar);
        if (zzamVar2.zzr > zzzbVar.zza || zzamVar2.zzs > zzzbVar.zzb) {
            i3 |= 256;
        }
        if (zzab(zzrzVar, zzamVar2) > zzzbVar.zzc) {
            i3 |= 64;
        }
        String str = zzrzVar.zza;
        if (i3 != 0) {
            i2 = 0;
            i = i3;
        } else {
            i = 0;
            i2 = zzieVarZzb.zzd;
        }
        return new zzie(str, zzamVar, zzamVar2, i2, i);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final zzie zzZ(zzkn zzknVar) throws zzil {
        zzie zzieVarZzZ = super.zzZ(zzknVar);
        zzam zzamVar = zzknVar.zza;
        Objects.requireNonNull(zzamVar);
        this.zzh.zzf(zzamVar, zzieVarZzZ);
        return zzieVarZzZ;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final boolean zzaF(zzrz zzrzVar) {
        return this.zzm != null || zzaT(zzrzVar);
    }

    protected final void zzaH(zzrw zzrwVar, int i, long j, long j2) {
        int i2 = zzfk.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzrwVar.zzm(i, j2);
        Trace.endSection();
        this.zza.zze++;
        this.zzv = 0;
        if (this.zzI == null) {
            zzh();
            this.zzy = zzfk.zzq(SystemClock.elapsedRealtime());
            zzaP(this.zzC);
            zzaO();
        }
    }

    protected final void zzaI(zzrw zzrwVar, int i, long j) {
        int i2 = zzfk.zza;
        Trace.beginSection("skipVideoBuffer");
        zzrwVar.zzn(i, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    protected final void zzaJ(int i, int i2) {
        zzid zzidVar = this.zza;
        zzidVar.zzh += i;
        int i3 = i + i2;
        zzidVar.zzg += i3;
        this.zzu += i3;
        int i4 = this.zzv + i3;
        this.zzv = i4;
        zzidVar.zzi = Math.max(i4, zzidVar.zzi);
    }

    protected final void zzaK(long j) {
        zzid zzidVar = this.zza;
        zzidVar.zzk += j;
        zzidVar.zzl++;
        this.zzz += j;
        this.zzA++;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final zzru zzac(zzrz zzrzVar, zzam zzamVar, MediaCrypto mediaCrypto, float f) {
        String str;
        zzzb zzzbVar;
        Point point;
        int i;
        int i2;
        Pair pairZzb;
        int iZzaa;
        zzzi zzziVar = this.zzn;
        if (zzziVar != null) {
            if (zzziVar.zza != zzrzVar.zzf) {
                zzaR();
            }
        }
        String str2 = zzrzVar.zzc;
        zzam[] zzamVarArrZzQ = zzQ();
        int iMax = zzamVar.zzr;
        int iMax2 = zzamVar.zzs;
        int iZzab = zzab(zzrzVar, zzamVar);
        int length = zzamVarArrZzQ.length;
        if (length == 1) {
            if (iZzab != -1 && (iZzaa = zzaa(zzrzVar, zzamVar)) != -1) {
                iZzab = Math.min((int) (iZzab * 1.5f), iZzaa);
            }
            zzzbVar = new zzzb(iMax, iMax2, iZzab);
            str = str2;
        } else {
            boolean z = false;
            for (int i3 = 0; i3 < length; i3++) {
                zzam zzamVarZzac = zzamVarArrZzQ[i3];
                if (zzamVar.zzy != null && zzamVarZzac.zzy == null) {
                    zzak zzakVarZzb = zzamVarZzac.zzb();
                    zzakVarZzb.zzA(zzamVar.zzy);
                    zzamVarZzac = zzakVarZzb.zzac();
                }
                if (zzrzVar.zzb(zzamVar, zzamVarZzac).zzd != 0) {
                    int i4 = zzamVarZzac.zzr;
                    z |= i4 == -1 || zzamVarZzac.zzs == -1;
                    iMax = Math.max(iMax, i4);
                    iMax2 = Math.max(iMax2, zzamVarZzac.zzs);
                    iZzab = Math.max(iZzab, zzab(zzrzVar, zzamVarZzac));
                }
            }
            if (z) {
                zzer.zzf("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
                int i5 = zzamVar.zzs;
                int i6 = zzamVar.zzr;
                boolean z2 = i5 > i6;
                int i7 = z2 ? i5 : i6;
                if (true == z2) {
                    i5 = i6;
                }
                int[] iArr = zzb;
                int i8 = 0;
                while (true) {
                    if (i8 < 9) {
                        float f2 = i5;
                        float f3 = i7;
                        str = str2;
                        int i9 = iArr[i8];
                        int[] iArr2 = iArr;
                        float f4 = i9;
                        if (i9 > i7 && (i = (int) (f4 * (f2 / f3))) > i5) {
                            if (zzfk.zza < 21) {
                                i2 = i5;
                                try {
                                    int i10 = ((i9 + 15) / 16) * 16;
                                    int i11 = ((i + 15) / 16) * 16;
                                    if (i10 * i11 <= zzst.zza()) {
                                        int i12 = true != z2 ? i10 : i11;
                                        if (true != z2) {
                                            i10 = i11;
                                        }
                                        point = new Point(i12, i10);
                                        break;
                                    }
                                    i8++;
                                    str2 = str;
                                    iArr = iArr2;
                                    i5 = i2;
                                } catch (zzsn unused) {
                                    point = null;
                                    break;
                                }
                            } else {
                                int i13 = true != z2 ? i9 : i;
                                if (true != z2) {
                                    i9 = i;
                                }
                                point = zzrzVar.zza(i13, i9);
                                float f5 = zzamVar.zzt;
                                if (point != null) {
                                    i2 = i5;
                                    if (zzrzVar.zzg(point.x, point.y, f5)) {
                                        break;
                                    }
                                } else {
                                    i2 = i5;
                                }
                                i8++;
                                str2 = str;
                                iArr = iArr2;
                                i5 = i2;
                            }
                        }
                    } else {
                        str = str2;
                    }
                    point = null;
                    break;
                }
                if (point != null) {
                    iMax = Math.max(iMax, point.x);
                    iMax2 = Math.max(iMax2, point.y);
                    zzak zzakVarZzb2 = zzamVar.zzb();
                    zzakVarZzb2.zzab(iMax);
                    zzakVarZzb2.zzH(iMax2);
                    iZzab = Math.max(iZzab, zzaa(zzrzVar, zzakVarZzb2.zzac()));
                    zzer.zzf("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
                }
            } else {
                str = str2;
            }
            zzzbVar = new zzzb(iMax, iMax2, iZzab);
        }
        this.zzj = zzzbVar;
        boolean z3 = this.zzi;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", zzamVar.zzr);
        mediaFormat.setInteger("height", zzamVar.zzs);
        zzeu.zzb(mediaFormat, zzamVar.zzo);
        float f6 = zzamVar.zzt;
        if (f6 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f6);
        }
        zzeu.zza(mediaFormat, "rotation-degrees", zzamVar.zzu);
        zzs zzsVar = zzamVar.zzy;
        if (zzsVar != null) {
            zzeu.zza(mediaFormat, "color-transfer", zzsVar.zzf);
            zzeu.zza(mediaFormat, "color-standard", zzsVar.zzd);
            zzeu.zza(mediaFormat, "color-range", zzsVar.zze);
            byte[] bArr = zzsVar.zzg;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzamVar.zzm) && (pairZzb = zzst.zzb(zzamVar)) != null) {
            zzeu.zza(mediaFormat, Scopes.PROFILE, ((Integer) pairZzb.first).intValue());
        }
        mediaFormat.setInteger("max-width", zzzbVar.zza);
        mediaFormat.setInteger("max-height", zzzbVar.zzb);
        zzeu.zza(mediaFormat, "max-input-size", zzzbVar.zzc);
        if (zzfk.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z3) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (this.zzm == null) {
            if (!zzaT(zzrzVar)) {
                throw new IllegalStateException();
            }
            if (this.zzn == null) {
                this.zzn = zzzi.zza(this.zze, zzrzVar.zzf);
            }
            this.zzm = this.zzn;
        }
        zzaah zzaahVar = this.zzI;
        if (zzaahVar != null && !zzaahVar.zzf()) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        if (this.zzI == null) {
            return zzru.zzb(zzrzVar, mediaFormat, zzamVar, this.zzm, null);
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final List zzad(zzsg zzsgVar, zzam zzamVar, boolean z) throws zzsn {
        return zzst.zzi(zzaM(this.zze, zzsgVar, zzamVar, false, false), zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzae(zzht zzhtVar) throws zzil {
        if (this.zzl) {
            ByteBuffer byteBuffer = zzhtVar.zzf;
            Objects.requireNonNull(byteBuffer);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4) {
                    if (b4 == 0 || b4 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzrw zzrwVarZzar = zzar();
                        Objects.requireNonNull(zzrwVarZzar);
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzrwVarZzar.zzp(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzaf(Exception exc) {
        zzer.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzh.zzs(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzag(String str, zzru zzruVar, long j, long j2) {
        this.zzh.zza(str, j, j2);
        this.zzk = zzaL(str);
        zzrz zzrzVarZzat = zzat();
        Objects.requireNonNull(zzrzVarZzat);
        boolean z = false;
        if (zzfk.zza >= 29 && "video/x-vnd.on2.vp9".equals(zzrzVarZzat.zzb)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzrzVarZzat.zzh()) {
                if (codecProfileLevel.profile == 16384) {
                    z = true;
                    break;
                }
            }
        }
        this.zzl = z;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzah(String str) {
        this.zzh.zzb(str);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzai(zzam zzamVar, MediaFormat mediaFormat) {
        zzrw zzrwVarZzar = zzar();
        if (zzrwVarZzar != null) {
            zzrwVarZzar.zzq(this.zzp);
        }
        Objects.requireNonNull(mediaFormat);
        int i = 0;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer2 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        float f = zzamVar.zzv;
        if (zzfk.zza >= 21) {
            int i2 = zzamVar.zzu;
            if (i2 == 90 || i2 == 270) {
                f = 1.0f / f;
                int i3 = integer2;
                integer2 = integer;
                integer = i3;
            }
        } else if (this.zzI == null) {
            i = zzamVar.zzu;
        }
        this.zzC = new zzdm(integer, integer2, i, f);
        this.zzf.zzc(zzamVar.zzt);
        zzaah zzaahVar = this.zzI;
        if (zzaahVar != null) {
            zzak zzakVarZzb = zzamVar.zzb();
            zzakVarZzb.zzab(integer);
            zzakVarZzb.zzH(integer2);
            zzakVarZzb.zzT(i);
            zzakVarZzb.zzR(f);
            zzaahVar.zza(1, zzakVarZzb.zzac());
        }
    }

    protected final void zzaj(zzrw zzrwVar, int i, long j) {
        int i2 = zzfk.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzrwVar.zzn(i, true);
        Trace.endSection();
        this.zza.zze++;
        this.zzv = 0;
        if (this.zzI == null) {
            zzh();
            this.zzy = zzfk.zzq(SystemClock.elapsedRealtime());
            zzaP(this.zzC);
            zzaO();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzak() {
        zzaN(2);
        if (this.zzg.zzi()) {
            this.zzg.zzf(zzap());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final zzrx zzas(Throwable th, zzrz zzrzVar) {
        return new zzyy(th, zzrzVar, this.zzm);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzav(long j) {
        super.zzav(j);
        this.zzw--;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzaw(zzht zzhtVar) throws zzil {
        this.zzw++;
        int i = zzfk.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzax(zzam zzamVar) throws zzil {
        if (this.zzE && !this.zzF && !this.zzg.zzi()) {
            try {
                this.zzg.zzc(zzamVar);
                this.zzg.zzf(zzap());
                zzzj zzzjVar = this.zzH;
                if (zzzjVar != null) {
                    this.zzg.zzh(zzzjVar);
                }
            } catch (zzaag e) {
                throw zzi(e, zzamVar, false, 7000);
            }
        }
        if (this.zzI == null && this.zzg.zzi()) {
            zzaah zzaahVarZza = this.zzg.zza();
            this.zzI = zzaahVarZza;
            zzaahVarZza.zzb(new zzyz(this), zzgaj.zzb());
        }
        this.zzF = true;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    protected final void zzaz() {
        super.zzaz();
        this.zzw = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlr
    public final void zzs() {
        if (this.zzq == 0) {
            this.zzq = 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzic
    protected final void zzw() {
        this.zzD = null;
        zzaN(0);
        this.zzo = false;
        try {
            super.zzw();
        } finally {
            this.zzh.zzc(this.zza);
            this.zzh.zzt(zzdm.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzic
    protected final void zzx(boolean z, boolean z2) throws zzil {
        super.zzx(z, z2);
        zzm();
        this.zzh.zze(this.zza);
        this.zzq = z2 ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzse, com.google.android.gms.internal.ads.zzic
    protected final void zzy(long j, boolean z) throws zzil {
        super.zzy(j, z);
        if (this.zzI != null) {
            throw null;
        }
        if (this.zzg.zzi()) {
            this.zzg.zzf(zzap());
        }
        zzaN(1);
        this.zzf.zzf();
        this.zzx = -9223372036854775807L;
        this.zzr = -9223372036854775807L;
        this.zzv = 0;
        this.zzs = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzz() {
        if (this.zzg.zzi()) {
            this.zzg.zzd();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzrw] */
    /* JADX WARN: Type inference failed for: r6v13, types: [com.google.android.gms.internal.ads.zzyv] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.google.android.gms.internal.ads.zzzr] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.google.android.gms.internal.ads.zzzi] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
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
    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlm
    public final void zzt(int i, Object obj) throws zzil {
        ?? Zza;
        ?? r7;
        ?? r8;
        Surface surface;
        Surface surface2;
        if (i != 1) {
            if (i == 7) {
                Objects.requireNonNull(obj);
                zzzj zzzjVar = (zzzj) obj;
                this.zzH = zzzjVar;
                this.zzg.zzh(zzzjVar);
                return;
            }
            if (i == 10) {
                Objects.requireNonNull(obj);
                int iIntValue = ((Integer) obj).intValue();
                if (this.zzG != iIntValue) {
                    this.zzG = iIntValue;
                    return;
                }
                return;
            }
            if (i == 4) {
                Objects.requireNonNull(obj);
                int iIntValue2 = ((Integer) obj).intValue();
                this.zzp = iIntValue2;
                zzrw zzrwVarZzar = zzar();
                if (zzrwVarZzar != null) {
                    zzrwVarZzar.zzq(iIntValue2);
                    return;
                }
                return;
            }
            if (i == 5) {
                zzzr zzzrVar = this.zzf;
                Objects.requireNonNull(obj);
                zzzrVar.zzj(((Integer) obj).intValue());
                return;
            }
            if (i == 13) {
                Objects.requireNonNull(obj);
                this.zzg.zzg((List) obj);
                this.zzE = true;
                return;
            } else {
                if (i != 14) {
                    return;
                }
                Objects.requireNonNull(obj);
                zzfc zzfcVar = (zzfc) obj;
                if (!this.zzg.zzi() || zzfcVar.zzb() == 0 || zzfcVar.zza() == 0 || (surface2 = this.zzm) == null) {
                    return;
                }
                this.zzg.zze(surface2, zzfcVar);
                return;
            }
        }
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            Zza = 0;
        }
        if (Zza == 0) {
            zzzi zzziVar = this.zzn;
            if (zzziVar != null) {
                Zza = surface;
                Zza = zzziVar;
            } else {
                zzrz zzrzVarZzat = zzat();
                if (zzrzVarZzat != null && zzaT(zzrzVarZzat)) {
                    Zza = surface;
                    Zza = zzzi.zza(this.zze, zzrzVarZzat.zzf);
                    this.zzn = Zza;
                }
            }
        }
        Zza = surface;
        Zza = surface;
        Zza = surface;
        if (this.zzm == Zza) {
            if (Zza == 0 || Zza == this.zzn) {
                return;
            }
            zzaQ();
            Surface surface3 = this.zzm;
            if (surface3 == null || !this.zzo) {
                return;
            }
            this.zzh.zzq(surface3);
            return;
        }
        this.zzm = Zza;
        this.zzf.zzi(Zza);
        this.zzo = false;
        int iZzbc = zzbc();
        ?? Zzar = zzar();
        if (Zzar != 0 && !this.zzg.zzi()) {
            if (zzfk.zza < 23) {
                r7 = Zza;
                r7 = Zza;
                r8 = Zza;
                zzay();
                zzau();
                r7 = r8;
            } else {
                if (Zza != 0) {
                    r8 = Zza;
                    if (!this.zzk) {
                        Zzar.zzo(Zza);
                        r7 = Zza;
                    }
                } else {
                    r8 = 0;
                }
                r7 = Zza;
                r7 = Zza;
                r8 = Zza;
                zzay();
                zzau();
                r7 = r8;
            }
        }
        if (r7 == 0 || r7 == this.zzn) {
            this.zzD = null;
            zzaN(1);
            if (this.zzg.zzi()) {
                this.zzg.zzb();
                return;
            }
            return;
        }
        zzaQ();
        zzaN(1);
        if (iZzbc == 2) {
            this.zzs = -9223372036854775807L;
        }
        if (this.zzg.zzi()) {
            this.zzg.zze(r7, zzfc.zza);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ab, code lost:
    
        if (r15 > 100000) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bc, code lost:
    
        if (r19 >= zzaq()) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c5, code lost:
    
        if (r13 == 2) goto L55;
     */
    @Override // com.google.android.gms.internal.ads.zzse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final boolean zzam(long r19, long r21, com.google.android.gms.internal.ads.zzrw r23, java.nio.ByteBuffer r24, int r25, int r26, int r27, long r28, boolean r30, boolean r31, com.google.android.gms.internal.ads.zzam r32) throws com.google.android.gms.internal.ads.zzil {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzf.zzam(long, long, com.google.android.gms.internal.ads.zzrw, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, com.google.android.gms.internal.ads.zzam):boolean");
    }
}
