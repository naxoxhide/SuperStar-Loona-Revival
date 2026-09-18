package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzoy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaa extends zzku {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzaa(zzlh zzlhVar) {
        super(zzlhVar);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzuVar = new zzu(this, this.zza, null);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }

    private final boolean zzf(int i, int i2) {
        zzu zzuVar = (zzu) this.zzc.get(Integer.valueOf(i));
        if (zzuVar == null) {
            return false;
        }
        return zzuVar.zze.get(i2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x025c  */
    /* JADX WARN: Code duplicated, block: B:102:0x0264  */
    /* JADX WARN: Code duplicated, block: B:104:0x026f  */
    /* JADX WARN: Code duplicated, block: B:110:0x02a2 A[Catch: all -> 0x02db, SQLiteException -> 0x02de, LOOP:11: B:110:0x02a2->B:117:0x02d2, LOOP_START, PHI: r7
      0x02a2: PHI (r7v6 int) = (r7v5 int), (r7v10 int) binds: [B:109:0x02a0, B:117:0x02d2] A[DONT_GENERATE, DONT_INLINE], TryCatch #6 {SQLiteException -> 0x02de, blocks: (B:108:0x029c, B:110:0x02a2, B:112:0x02b2, B:113:0x02ba, B:118:0x02d4), top: B:444:0x029c }] */
    /* JADX WARN: Code duplicated, block: B:112:0x02b2 A[Catch: all -> 0x02db, SQLiteException -> 0x02de, TryCatch #6 {SQLiteException -> 0x02de, blocks: (B:108:0x029c, B:110:0x02a2, B:112:0x02b2, B:113:0x02ba, B:118:0x02d4), top: B:444:0x029c }] */
    /* JADX WARN: Code duplicated, block: B:116:0x02ce A[PHI: r0 r5
      0x02ce: PHI (r0v56 java.util.Map) = (r0v45 java.util.Map), (r0v58 java.util.Map), (r0v39 java.util.Map) binds: [B:133:0x0301, B:119:0x02d8, B:115:0x02cc] A[DONT_GENERATE, DONT_INLINE]
      0x02ce: PHI (r5v25 android.database.Cursor) = (r5v9 android.database.Cursor), (r5v26 android.database.Cursor), (r5v26 android.database.Cursor) binds: [B:133:0x0301, B:119:0x02d8, B:115:0x02cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:117:0x02d2 A[LOOP:11: B:110:0x02a2->B:117:0x02d2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:118:0x02d4 A[Catch: all -> 0x02db, SQLiteException -> 0x02de, TRY_ENTER, TRY_LEAVE, TryCatch #6 {SQLiteException -> 0x02de, blocks: (B:108:0x029c, B:110:0x02a2, B:112:0x02b2, B:113:0x02ba, B:118:0x02d4), top: B:444:0x029c }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0317  */
    /* JADX WARN: Code duplicated, block: B:141:0x0325  */
    /* JADX WARN: Code duplicated, block: B:143:0x0341  */
    /* JADX WARN: Code duplicated, block: B:168:0x0410  */
    /* JADX WARN: Code duplicated, block: B:172:0x041d  */
    /* JADX WARN: Code duplicated, block: B:174:0x0442  */
    /* JADX WARN: Code duplicated, block: B:180:0x0457  */
    /* JADX WARN: Code duplicated, block: B:184:0x0471  */
    /* JADX WARN: Code duplicated, block: B:185:0x047a  */
    /* JADX WARN: Code duplicated, block: B:189:0x0486  */
    /* JADX WARN: Code duplicated, block: B:195:0x049b  */
    /* JADX WARN: Code duplicated, block: B:202:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:205:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:207:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:209:0x0508  */
    /* JADX WARN: Code duplicated, block: B:210:0x050c  */
    /* JADX WARN: Code duplicated, block: B:215:0x0529 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:240:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:243:0x05d6  */
    /* JADX WARN: Code duplicated, block: B:247:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:248:0x0639  */
    /* JADX WARN: Code duplicated, block: B:251:0x0685  */
    /* JADX WARN: Code duplicated, block: B:259:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:266:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:268:0x0706  */
    /* JADX WARN: Code duplicated, block: B:275:0x072a  */
    /* JADX WARN: Code duplicated, block: B:277:0x072f A[LOOP:8: B:260:0x06d5->B:277:0x072f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:280:0x0736  */
    /* JADX WARN: Code duplicated, block: B:283:0x0740 A[PHI: r0 r5 r22 r28 r29
      0x0740: PHI (r0v79 java.util.Map) = (r0v81 java.util.Map), (r0v88 java.util.Map) binds: [B:301:0x0778, B:282:0x073e] A[DONT_GENERATE, DONT_INLINE]
      0x0740: PHI (r5v42 android.database.Cursor) = (r5v43 android.database.Cursor), (r5v45 android.database.Cursor) binds: [B:301:0x0778, B:282:0x073e] A[DONT_GENERATE, DONT_INLINE]
      0x0740: PHI (r22v14 com.google.android.gms.measurement.internal.zzaq) = (r22v15 com.google.android.gms.measurement.internal.zzaq), (r22v19 com.google.android.gms.measurement.internal.zzaq) binds: [B:301:0x0778, B:282:0x073e] A[DONT_GENERATE, DONT_INLINE]
      0x0740: PHI (r28v6 java.lang.String) = (r28v7 java.lang.String), (r28v10 java.lang.String) binds: [B:301:0x0778, B:282:0x073e] A[DONT_GENERATE, DONT_INLINE]
      0x0740: PHI (r29v7 java.lang.String) = (r29v8 java.lang.String), (r29v10 java.lang.String) binds: [B:301:0x0778, B:282:0x073e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:307:0x0785  */
    /* JADX WARN: Code duplicated, block: B:311:0x079b  */
    /* JADX WARN: Code duplicated, block: B:317:0x07d0  */
    /* JADX WARN: Code duplicated, block: B:319:0x07f9 A[LOOP:10: B:315:0x07ca->B:319:0x07f9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:327:0x082e  */
    /* JADX WARN: Code duplicated, block: B:330:0x083d  */
    /* JADX WARN: Code duplicated, block: B:332:0x0850  */
    /* JADX WARN: Code duplicated, block: B:340:0x0896 A[Catch: SQLiteException -> 0x08f7, all -> 0x0926, LOOP:4: B:340:0x0896->B:493:?, LOOP_START, TRY_LEAVE, TryCatch #2 {all -> 0x0926, blocks: (B:338:0x0890, B:340:0x0896, B:341:0x089b, B:343:0x08ac, B:345:0x08bc, B:347:0x08c7, B:350:0x08e0, B:349:0x08cc, B:355:0x08ed, B:369:0x090a), top: B:438:0x0890 }] */
    /* JADX WARN: Code duplicated, block: B:345:0x08bc A[Catch: SQLiteException -> 0x08f7, all -> 0x0926, TryCatch #2 {all -> 0x0926, blocks: (B:338:0x0890, B:340:0x0896, B:341:0x089b, B:343:0x08ac, B:345:0x08bc, B:347:0x08c7, B:350:0x08e0, B:349:0x08cc, B:355:0x08ed, B:369:0x090a), top: B:438:0x0890 }] */
    /* JADX WARN: Code duplicated, block: B:346:0x08c5  */
    /* JADX WARN: Code duplicated, block: B:353:0x08e8  */
    /* JADX WARN: Code duplicated, block: B:355:0x08ed A[Catch: SQLiteException -> 0x08f7, all -> 0x0926, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0926, blocks: (B:338:0x0890, B:340:0x0896, B:341:0x089b, B:343:0x08ac, B:345:0x08bc, B:347:0x08c7, B:350:0x08e0, B:349:0x08cc, B:355:0x08ed, B:369:0x090a), top: B:438:0x0890 }] */
    /* JADX WARN: Code duplicated, block: B:357:0x08f3 A[PHI: r0 r3 r65
      0x08f3: PHI (r0v132 java.util.Map) = (r0v130 java.util.Map), (r0v139 java.util.Map) binds: [B:370:0x091f, B:356:0x08f1] A[DONT_GENERATE, DONT_INLINE]
      0x08f3: PHI (r3v53 android.database.Cursor) = (r3v52 android.database.Cursor), (r3v57 android.database.Cursor) binds: [B:370:0x091f, B:356:0x08f1] A[DONT_GENERATE, DONT_INLINE]
      0x08f3: PHI (r65v10 java.util.Iterator) = (r65v9 java.util.Iterator), (r65v12 java.util.Iterator) binds: [B:370:0x091f, B:356:0x08f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:378:0x092e  */
    /* JADX WARN: Code duplicated, block: B:382:0x0942  */
    /* JADX WARN: Code duplicated, block: B:385:0x0967  */
    /* JADX WARN: Code duplicated, block: B:388:0x0978  */
    /* JADX WARN: Code duplicated, block: B:390:0x098f  */
    /* JADX WARN: Code duplicated, block: B:392:0x09a3  */
    /* JADX WARN: Code duplicated, block: B:393:0x09ac  */
    /* JADX WARN: Code duplicated, block: B:395:0x09dc  */
    /* JADX WARN: Code duplicated, block: B:398:0x09e4  */
    /* JADX WARN: Code duplicated, block: B:407:0x0a35  */
    /* JADX WARN: Code duplicated, block: B:408:0x0a3e  */
    /* JADX WARN: Code duplicated, block: B:412:0x0a4d A[PHI: r66
      0x0a4d: PHI (r66v6 java.util.Map) = (r66v7 java.util.Map), (r0v109 java.util.Map) binds: [B:411:0x0a4b, B:409:0x0a3f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:418:0x0a7c  */
    /* JADX WARN: Code duplicated, block: B:423:0x0adc A[Catch: SQLiteException -> 0x0af0, TRY_LEAVE, TryCatch #13 {SQLiteException -> 0x0af0, blocks: (B:421:0x0ad2, B:423:0x0adc), top: B:452:0x0ad2 }] */
    /* JADX WARN: Code duplicated, block: B:487:0x0b07 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:494:0x0958 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:496:0x0a56 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:497:0x0a49 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:498:0x0a1f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:502:0x05e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:504:0x05d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:506:0x0728 A[EDGE_INSN: B:506:0x0728->B:274:0x0728 BREAK  A[LOOP:8: B:260:0x06d5->B:277:0x072f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:508:0x07bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:509:0x0810 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:510:0x07b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:512:0x0795 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:516:0x0805 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:517:0x02cc A[EDGE_INSN: B:517:0x02cc->B:115:0x02cc BREAK  A[LOOP:11: B:110:0x02a2->B:117:0x02d2], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:521:0x03fb A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:534:0x0587 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:541:0x0463 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:543:0x0451 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:546:0x04a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:549:0x0495 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:559:0x0215 A[EDGE_INSN: B:559:0x0215->B:79:0x0215 BREAK  A[LOOP:20: B:68:0x01c9->B:82:0x021d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x017a  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b4 A[Catch: SQLiteException -> 0x0228, all -> 0x0b0c, TRY_LEAVE, TryCatch #10 {SQLiteException -> 0x0228, blocks: (B:61:0x01ae, B:63:0x01b4, B:67:0x01c4, B:68:0x01c9, B:69:0x01d3, B:70:0x01e3, B:72:0x01f2), top: B:447:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c4 A[Catch: SQLiteException -> 0x0228, all -> 0x0b0c, TRY_ENTER, TryCatch #10 {SQLiteException -> 0x0228, blocks: (B:61:0x01ae, B:63:0x01b4, B:67:0x01c4, B:68:0x01c9, B:69:0x01d3, B:70:0x01e3, B:72:0x01f2), top: B:447:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0217  */
    /* JADX WARN: Code duplicated, block: B:82:0x021d A[LOOP:20: B:68:0x01c9->B:82:0x021d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x0251  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v62 */
    /* JADX WARN: Type inference failed for: r5v64, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v71 */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    final List zza(String str, List list, List list2, Long l, Long l2) throws Throwable {
        int i;
        int i2;
        boolean z;
        ?? r5;
        Map map;
        Cursor cursor;
        String str2;
        Cursor cursorQuery;
        Map map2;
        Map map3;
        Iterator it;
        String str3;
        int iIntValue;
        com.google.android.gms.internal.measurement.zzgi zzgiVar;
        BitSet bitSet;
        BitSet bitSet2;
        ArrayMap arrayMap;
        List<com.google.android.gms.internal.measurement.zzek> list3;
        int i3;
        String str4;
        Long lValueOf;
        String str5;
        Map arrayMap2;
        ?? Zzh;
        Cursor cursorRawQuery;
        ArrayMap arrayMap3;
        Iterator it2;
        com.google.android.gms.internal.measurement.zzgi zzgiVar2;
        List list4;
        Iterator it3;
        int i4;
        Integer numValueOf;
        List arrayList;
        String str6;
        String str7;
        zzw zzwVar;
        ArrayMap arrayMap4;
        Iterator it4;
        com.google.android.gms.internal.measurement.zzft zzftVar;
        com.google.android.gms.internal.measurement.zzft zzftVarZza;
        zzak zzakVarZzh;
        String str8;
        String strZzh;
        zzaq zzaqVarZzn;
        zzaq zzaqVar;
        long j;
        String strZzh2;
        Map mapEmptyMap;
        zzaq zzaqVar2;
        Iterator it5;
        int iIntValue2;
        Set set;
        Integer numValueOf2;
        boolean zZzd;
        zzx zzxVar;
        zzak zzakVarZzh2;
        String str9;
        ArrayMap arrayMap5;
        String str10;
        String str11;
        Cursor cursorQuery2;
        Integer numValueOf3;
        List list5;
        List arrayList2;
        String str12;
        ArrayMap arrayMap6;
        Iterator it6;
        String strZzf;
        Map mapEmptyMap2;
        Iterator it7;
        String str13;
        String str14;
        Iterator it8;
        int iIntValue3;
        Set set2;
        Integer numValueOf4;
        Iterator it9;
        boolean zZzd2;
        com.google.android.gms.internal.measurement.zzet zzetVar;
        Integer numValueOf5;
        zzz zzzVar;
        Integer numValueOf6;
        zzak zzakVarZzh3;
        String str15;
        ArrayMap arrayMap7;
        Cursor cursor2;
        Cursor cursorQuery3;
        Integer numValueOf7;
        List list6;
        List arrayList3;
        String str16;
        ArrayList arrayList4;
        Iterator it10;
        zzak zzakVarZzh4;
        String str17;
        ContentValues contentValues;
        ArrayMap arrayMap8;
        int i5;
        Cursor cursorQuery4;
        List arrayList5;
        String str18 = "current_results";
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator it11 = list.iterator();
        while (true) {
            i = 0;
            i2 = 1;
            if (!it11.hasNext()) {
                z = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzft) it11.next()).zzh())) {
                z = true;
                break;
            }
        }
        zzoy.zzc();
        boolean zZzs = this.zzt.zzf().zzs(this.zza, zzeg.zzY);
        zzoy.zzc();
        boolean zZzs2 = this.zzt.zzf().zzs(this.zza, zzeg.zzX);
        if (z) {
            zzak zzakVarZzh5 = this.zzf.zzh();
            String str19 = this.zza;
            zzakVarZzh5.zzW();
            zzakVarZzh5.zzg();
            Preconditions.checkNotEmpty(str19);
            ContentValues contentValues2 = new ContentValues();
            String str20 = "current_session_count";
            contentValues2.put("current_session_count", (Integer) 0);
            try {
                str20 = "events";
                zzakVarZzh5.zzh().update("events", contentValues2, "app_id = ?", new String[]{str19});
                r5 = "events";
            } catch (SQLiteException e) {
                zzakVarZzh5.zzt.zzaA().zzd().zzc("Error resetting session-scoped event counts. appId", zzet.zzn(str19), e);
                r5 = str20;
            }
        }
        Map mapEmptyMap3 = Collections.emptyMap();
        String str21 = "Failed to merge filter. appId";
        String str22 = "data";
        String str23 = "audience_id";
        if (zZzs2 && zZzs) {
            zzak zzakVarZzh6 = this.zzf.zzh();
            String str24 = this.zza;
            Preconditions.checkNotEmpty(str24);
            ArrayMap arrayMap9 = new ArrayMap();
            try {
                try {
                    cursorQuery4 = zzakVarZzh6.zzh().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str24}, null, null, null);
                    try {
                        if (cursorQuery4.moveToFirst()) {
                            while (true) {
                                try {
                                    com.google.android.gms.internal.measurement.zzek zzekVar = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzlj.zzm(com.google.android.gms.internal.measurement.zzek.zzc(), cursorQuery4.getBlob(i2))).zzaD();
                                    if (zzekVar.zzo()) {
                                        Integer numValueOf8 = Integer.valueOf(cursorQuery4.getInt(i));
                                        List list7 = (List) arrayMap9.get(numValueOf8);
                                        if (list7 == null) {
                                            arrayList5 = new ArrayList();
                                            arrayMap9.put(numValueOf8, arrayList5);
                                        } else {
                                            arrayList5 = list7;
                                        }
                                        arrayList5.add(zzekVar);
                                    }
                                } catch (IOException e2) {
                                    zzakVarZzh6.zzt.zzaA().zzd().zzc("Failed to merge filter. appId", zzet.zzn(str24), e2);
                                }
                                if (!cursorQuery4.moveToNext()) {
                                    break;
                                }
                                i = 0;
                                i2 = 1;
                            }
                            if (cursorQuery4 != null) {
                                cursorQuery4.close();
                            }
                            map = arrayMap9;
                        } else {
                            mapEmptyMap3 = Collections.emptyMap();
                            if (cursorQuery4 != null) {
                                cursorQuery4.close();
                            }
                            map = mapEmptyMap3;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        zzakVarZzh6.zzt.zzaA().zzd().zzc("Database error querying filters. appId", zzet.zzn(str24), e);
                        mapEmptyMap3 = Collections.emptyMap();
                        if (cursorQuery4 != null) {
                        }
                        map = mapEmptyMap3;
                        zzak zzakVarZzh7 = this.zzf.zzh();
                        String str25 = this.zza;
                        zzakVarZzh7.zzW();
                        zzakVarZzh7.zzg();
                        Preconditions.checkNotEmpty(str25);
                        cursorQuery = zzakVarZzh7.zzh().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str25}, null, null, null);
                        try {
                            if (cursorQuery.moveToFirst()) {
                                arrayMap8 = new ArrayMap();
                                while (true) {
                                    i5 = cursorQuery.getInt(0);
                                    try {
                                        arrayMap8.put(Integer.valueOf(i5), (com.google.android.gms.internal.measurement.zzgi) ((com.google.android.gms.internal.measurement.zzgh) zzlj.zzm(com.google.android.gms.internal.measurement.zzgi.zze(), cursorQuery.getBlob(1))).zzaD());
                                        str2 = str23;
                                    } catch (IOException e4) {
                                        str2 = str23;
                                        try {
                                            zzakVarZzh7.zzt.zzaA().zzd().zzd("Failed to merge filter results. appId, audienceId, error", zzet.zzn(str25), Integer.valueOf(i5), e4);
                                        } catch (SQLiteException e5) {
                                            e = e5;
                                            str22 = str22;
                                            zzakVarZzh7.zzt.zzaA().zzd().zzc("Database error querying filter results. appId", zzet.zzn(str25), e);
                                            Map mapEmptyMap4 = Collections.emptyMap();
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                            map2 = mapEmptyMap4;
                                            if (map2.isEmpty()) {
                                                str3 = "Failed to merge filter. appId";
                                            } else {
                                                HashSet hashSet = new HashSet(map2.keySet());
                                                if (z) {
                                                    String str26 = this.zza;
                                                    zzak zzakVarZzh8 = this.zzf.zzh();
                                                    str5 = this.zza;
                                                    zzakVarZzh8.zzW();
                                                    zzakVarZzh8.zzg();
                                                    Preconditions.checkNotEmpty(str5);
                                                    arrayMap2 = new ArrayMap();
                                                    Zzh = zzakVarZzh8.zzh();
                                                    try {
                                                        try {
                                                            i4 = 0;
                                                            cursorRawQuery = Zzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str5, str5});
                                                            try {
                                                                if (cursorRawQuery.moveToFirst()) {
                                                                    while (true) {
                                                                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(i4));
                                                                        arrayList = (List) arrayMap2.get(numValueOf);
                                                                        if (arrayList == null) {
                                                                            arrayList = new ArrayList();
                                                                            arrayMap2.put(numValueOf, arrayList);
                                                                        }
                                                                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                                                        if (!cursorRawQuery.moveToNext()) {
                                                                            break;
                                                                        }
                                                                        i4 = 0;
                                                                    }
                                                                    if (cursorRawQuery != null) {
                                                                        cursorRawQuery.close();
                                                                    }
                                                                } else {
                                                                    arrayMap2 = Collections.emptyMap();
                                                                    if (cursorRawQuery != null) {
                                                                        cursorRawQuery.close();
                                                                    }
                                                                }
                                                            } catch (SQLiteException e6) {
                                                                e = e6;
                                                                zzakVarZzh8.zzt.zzaA().zzd().zzc("Database error querying scoped filters. appId", zzet.zzn(str5), e);
                                                                arrayMap2 = Collections.emptyMap();
                                                                if (cursorRawQuery != null) {
                                                                }
                                                                Preconditions.checkNotEmpty(str26);
                                                                Preconditions.checkNotNull(map2);
                                                                arrayMap3 = new ArrayMap();
                                                                if (!map2.isEmpty()) {
                                                                    it2 = map2.keySet().iterator();
                                                                    while (it2.hasNext()) {
                                                                        int iIntValue4 = ((Integer) it2.next()).intValue();
                                                                        Integer numValueOf9 = Integer.valueOf(iIntValue4);
                                                                        zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf9);
                                                                        list4 = (List) arrayMap2.get(numValueOf9);
                                                                        if (list4 != null) {
                                                                        }
                                                                        it3 = it2;
                                                                        arrayMap3.put(numValueOf9, zzgiVar2);
                                                                        arrayMap2 = arrayMap2;
                                                                        it2 = it3;
                                                                    }
                                                                }
                                                                map3 = arrayMap3;
                                                                it = hashSet.iterator();
                                                                while (it.hasNext()) {
                                                                    iIntValue = ((Integer) it.next()).intValue();
                                                                    zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map3.get(Integer.valueOf(iIntValue));
                                                                    bitSet = new BitSet();
                                                                    bitSet2 = new BitSet();
                                                                    arrayMap = new ArrayMap();
                                                                    if (zzgiVar != null) {
                                                                        for (com.google.android.gms.internal.measurement.zzfr zzfrVar : zzgiVar.zzh()) {
                                                                            if (zzfrVar.zzh()) {
                                                                                Integer numValueOf10 = Integer.valueOf(zzfrVar.zza());
                                                                                if (zzfrVar.zzg()) {
                                                                                    lValueOf = Long.valueOf(zzfrVar.zzb());
                                                                                } else {
                                                                                    lValueOf = null;
                                                                                }
                                                                                arrayMap.put(numValueOf10, lValueOf);
                                                                            }
                                                                        }
                                                                    }
                                                                    ArrayMap arrayMap10 = new ArrayMap();
                                                                    if (zzgiVar != null) {
                                                                        for (com.google.android.gms.internal.measurement.zzgk zzgkVar : zzgiVar.zzj()) {
                                                                            if (!zzgkVar.zzi()) {
                                                                            }
                                                                        }
                                                                    }
                                                                    Map map4 = map3;
                                                                    if (zzgiVar != null) {
                                                                        i3 = 0;
                                                                        while (i3 < zzgiVar.zzd() * 64) {
                                                                            if (zzlj.zzw(zzgiVar.zzk(), i3)) {
                                                                                str4 = str21;
                                                                                this.zzt.zzaA().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i3));
                                                                                bitSet2.set(i3);
                                                                                if (zzlj.zzw(zzgiVar.zzi(), i3)) {
                                                                                    bitSet.set(i3);
                                                                                }
                                                                                i3++;
                                                                                str21 = str4;
                                                                            } else {
                                                                                str4 = str21;
                                                                            }
                                                                            arrayMap.remove(Integer.valueOf(i3));
                                                                            i3++;
                                                                            str21 = str4;
                                                                        }
                                                                    }
                                                                    String str27 = str21;
                                                                    Integer numValueOf11 = Integer.valueOf(iIntValue);
                                                                    com.google.android.gms.internal.measurement.zzgi zzgiVar3 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf11);
                                                                    if (!zZzs2) {
                                                                    }
                                                                    this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzgiVar3, bitSet, bitSet2, arrayMap, arrayMap10, null));
                                                                    str21 = str27;
                                                                    map = map;
                                                                    map3 = map4;
                                                                    map2 = map2;
                                                                }
                                                                str3 = str21;
                                                                str6 = str2;
                                                                str7 = str22;
                                                                if (!list.isEmpty()) {
                                                                    zzwVar = new zzw(this, null);
                                                                    arrayMap4 = new ArrayMap();
                                                                    it4 = list.iterator();
                                                                    while (it4.hasNext()) {
                                                                        zzftVar = (com.google.android.gms.internal.measurement.zzft) it4.next();
                                                                        zzftVarZza = zzwVar.zza(this.zza, zzftVar);
                                                                        if (zzftVarZza != null) {
                                                                            zzakVarZzh = this.zzf.zzh();
                                                                            str8 = this.zza;
                                                                            strZzh = zzftVarZza.zzh();
                                                                            zzaqVarZzn = zzakVarZzh.zzn(str8, zzftVar.zzh());
                                                                            if (zzaqVarZzn == null) {
                                                                                zzakVarZzh.zzt.zzaA().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzet.zzn(str8), zzakVarZzh.zzt.zzj().zzd(strZzh));
                                                                                zzaqVar = new zzaq(str8, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                                                            } else {
                                                                                zzaqVar = new zzaq(zzaqVarZzn.zza, zzaqVarZzn.zzb, zzaqVarZzn.zzc + 1, zzaqVarZzn.zzd + 1, zzaqVarZzn.zze + 1, zzaqVarZzn.zzf, zzaqVarZzn.zzg, zzaqVarZzn.zzh, zzaqVarZzn.zzi, zzaqVarZzn.zzj, zzaqVarZzn.zzk);
                                                                            }
                                                                            this.zzf.zzh().zzE(zzaqVar);
                                                                            j = zzaqVar.zzc;
                                                                            strZzh2 = zzftVarZza.zzh();
                                                                            mapEmptyMap = (Map) arrayMap4.get(strZzh2);
                                                                            if (mapEmptyMap == null) {
                                                                                zzakVarZzh2 = this.zzf.zzh();
                                                                                str9 = this.zza;
                                                                                zzakVarZzh2.zzW();
                                                                                zzakVarZzh2.zzg();
                                                                                Preconditions.checkNotEmpty(str9);
                                                                                Preconditions.checkNotEmpty(strZzh2);
                                                                                arrayMap5 = new ArrayMap();
                                                                                str10 = str6;
                                                                                str11 = str7;
                                                                                try {
                                                                                    try {
                                                                                        str7 = str11;
                                                                                        try {
                                                                                            cursorQuery2 = zzakVarZzh2.zzh().query("event_filters", new String[]{str10, str11}, "app_id=? AND event_name=?", new String[]{str9, strZzh2}, null, null, null);
                                                                                            try {
                                                                                                try {
                                                                                                    if (cursorQuery2.moveToFirst()) {
                                                                                                        str6 = str10;
                                                                                                        while (true) {
                                                                                                            try {
                                                                                                                try {
                                                                                                                    com.google.android.gms.internal.measurement.zzek zzekVar2 = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzlj.zzm(com.google.android.gms.internal.measurement.zzek.zzc(), cursorQuery2.getBlob(1))).zzaD();
                                                                                                                    numValueOf3 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                                                                    list5 = (List) arrayMap5.get(numValueOf3);
                                                                                                                    if (list5 == null) {
                                                                                                                        zzaqVar2 = zzaqVar;
                                                                                                                        try {
                                                                                                                            arrayList2 = new ArrayList();
                                                                                                                            arrayMap5.put(numValueOf3, arrayList2);
                                                                                                                        } catch (SQLiteException e7) {
                                                                                                                            e = e7;
                                                                                                                            zzakVarZzh2.zzt.zzaA().zzd().zzc(r8, zzet.zzn(str9), e);
                                                                                                                            mapEmptyMap = Collections.emptyMap();
                                                                                                                            if (cursorQuery2 != null) {
                                                                                                                                cursorQuery2.close();
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        zzaqVar2 = zzaqVar;
                                                                                                                        arrayList2 = list5;
                                                                                                                    }
                                                                                                                    arrayList2.add(zzekVar2);
                                                                                                                } catch (IOException e8) {
                                                                                                                    zzaqVar2 = zzaqVar;
                                                                                                                    zzakVarZzh2.zzt.zzaA().zzd().zzc(str3, zzet.zzn(str9), e8);
                                                                                                                }
                                                                                                                if (!cursorQuery2.moveToNext()) {
                                                                                                                    break;
                                                                                                                }
                                                                                                                zzaqVar = zzaqVar2;
                                                                                                            } catch (SQLiteException e9) {
                                                                                                                e = e9;
                                                                                                                zzaqVar2 = zzaqVar;
                                                                                                            }
                                                                                                        }
                                                                                                        if (cursorQuery2 != null) {
                                                                                                            cursorQuery2.close();
                                                                                                        }
                                                                                                        mapEmptyMap = arrayMap5;
                                                                                                    } else {
                                                                                                        zzaqVar2 = zzaqVar;
                                                                                                        str6 = str10;
                                                                                                        mapEmptyMap = Collections.emptyMap();
                                                                                                        if (cursorQuery2 != null) {
                                                                                                            cursorQuery2.close();
                                                                                                        }
                                                                                                    }
                                                                                                } catch (SQLiteException e10) {
                                                                                                    e = e10;
                                                                                                    zzaqVar2 = zzaqVar;
                                                                                                    str6 = str10;
                                                                                                }
                                                                                                arrayMap4.put(strZzh2, mapEmptyMap);
                                                                                            } catch (Throwable th) {
                                                                                                th = th;
                                                                                                if (cursorQuery2 != null) {
                                                                                                    cursorQuery2.close();
                                                                                                }
                                                                                                throw th;
                                                                                            }
                                                                                        } catch (SQLiteException e11) {
                                                                                            e = e11;
                                                                                            zzaqVar2 = zzaqVar;
                                                                                            str6 = str10;
                                                                                            cursorQuery2 = null;
                                                                                            zzakVarZzh2.zzt.zzaA().zzd().zzc(r8, zzet.zzn(str9), e);
                                                                                            mapEmptyMap = Collections.emptyMap();
                                                                                            if (cursorQuery2 != null) {
                                                                                                cursorQuery2.close();
                                                                                            }
                                                                                            arrayMap4.put(strZzh2, mapEmptyMap);
                                                                                            it5 = mapEmptyMap.keySet().iterator();
                                                                                            while (it5.hasNext()) {
                                                                                                iIntValue2 = ((Integer) it5.next()).intValue();
                                                                                                set = this.zzb;
                                                                                                numValueOf2 = Integer.valueOf(iIntValue2);
                                                                                                if (set.contains(numValueOf2)) {
                                                                                                    this.zzt.zzaA().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                                                } else {
                                                                                                    zZzd = true;
                                                                                                    for (com.google.android.gms.internal.measurement.zzek zzekVar3 : (List) mapEmptyMap.get(numValueOf2)) {
                                                                                                        zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                                                                                        zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j, zzaqVar2, zzf(iIntValue2, zzekVar3.zzb()));
                                                                                                        if (!zZzd) {
                                                                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                            break;
                                                                                                        }
                                                                                                        zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                                                                    }
                                                                                                    if (!zZzd) {
                                                                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            zzwVar = zzwVar;
                                                                                            it4 = it4;
                                                                                            str18 = str18;
                                                                                        }
                                                                                    } catch (SQLiteException e12) {
                                                                                        e = e12;
                                                                                        str7 = str11;
                                                                                    }
                                                                                } catch (Throwable th2) {
                                                                                    th = th2;
                                                                                    cursorQuery2 = null;
                                                                                }
                                                                            } else {
                                                                                zzaqVar2 = zzaqVar;
                                                                            }
                                                                            it5 = mapEmptyMap.keySet().iterator();
                                                                            while (it5.hasNext()) {
                                                                                iIntValue2 = ((Integer) it5.next()).intValue();
                                                                                set = this.zzb;
                                                                                numValueOf2 = Integer.valueOf(iIntValue2);
                                                                                if (set.contains(numValueOf2)) {
                                                                                    this.zzt.zzaA().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                                } else {
                                                                                    zZzd = true;
                                                                                    while (r5.hasNext()) {
                                                                                        zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                                                                        zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j, zzaqVar2, zzf(iIntValue2, zzekVar3.zzb()));
                                                                                        if (!zZzd) {
                                                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                            break;
                                                                                        }
                                                                                        zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                                                    }
                                                                                    if (!zZzd) {
                                                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                    }
                                                                                }
                                                                            }
                                                                            zzwVar = zzwVar;
                                                                            it4 = it4;
                                                                            str18 = str18;
                                                                        }
                                                                    }
                                                                }
                                                                str12 = str18;
                                                                if (!list2.isEmpty()) {
                                                                    arrayMap6 = new ArrayMap();
                                                                    it6 = list2.iterator();
                                                                    while (it6.hasNext()) {
                                                                        com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) it6.next();
                                                                        strZzf = zzgmVar.zzf();
                                                                        mapEmptyMap2 = (Map) arrayMap6.get(strZzf);
                                                                        if (mapEmptyMap2 == null) {
                                                                            zzakVarZzh3 = this.zzf.zzh();
                                                                            str15 = this.zza;
                                                                            zzakVarZzh3.zzW();
                                                                            zzakVarZzh3.zzg();
                                                                            Preconditions.checkNotEmpty(str15);
                                                                            Preconditions.checkNotEmpty(strZzf);
                                                                            arrayMap7 = new ArrayMap();
                                                                            str13 = str6;
                                                                            str14 = str7;
                                                                            try {
                                                                                try {
                                                                                    it7 = it6;
                                                                                    try {
                                                                                        cursorQuery3 = zzakVarZzh3.zzh().query("property_filters", new String[]{str13, str14}, "app_id=? AND property_name=?", new String[]{str15, strZzf}, null, null, null);
                                                                                        try {
                                                                                            try {
                                                                                                if (cursorQuery3.moveToFirst()) {
                                                                                                    do {
                                                                                                        try {
                                                                                                            com.google.android.gms.internal.measurement.zzet zzetVar2 = (com.google.android.gms.internal.measurement.zzet) ((com.google.android.gms.internal.measurement.zzes) zzlj.zzm(com.google.android.gms.internal.measurement.zzet.zzc(), cursorQuery3.getBlob(1))).zzaD();
                                                                                                            numValueOf7 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                                                            list6 = (List) arrayMap7.get(numValueOf7);
                                                                                                            if (list6 == null) {
                                                                                                                arrayList3 = new ArrayList();
                                                                                                                arrayMap7.put(numValueOf7, arrayList3);
                                                                                                            } else {
                                                                                                                arrayList3 = list6;
                                                                                                            }
                                                                                                            arrayList3.add(zzetVar2);
                                                                                                        } catch (IOException e13) {
                                                                                                            zzakVarZzh3.zzt.zzaA().zzd().zzc("Failed to merge filter", zzet.zzn(str15), e13);
                                                                                                        }
                                                                                                    } while (cursorQuery3.moveToNext());
                                                                                                    if (cursorQuery3 != null) {
                                                                                                        cursorQuery3.close();
                                                                                                    }
                                                                                                    mapEmptyMap2 = arrayMap7;
                                                                                                } else {
                                                                                                    mapEmptyMap2 = Collections.emptyMap();
                                                                                                    if (cursorQuery3 != null) {
                                                                                                        cursorQuery3.close();
                                                                                                    }
                                                                                                }
                                                                                            } catch (SQLiteException e14) {
                                                                                                e = e14;
                                                                                                zzakVarZzh3.zzt.zzaA().zzd().zzc("Database error querying filters. appId", zzet.zzn(str15), e);
                                                                                                mapEmptyMap2 = Collections.emptyMap();
                                                                                                if (cursorQuery3 != null) {
                                                                                                    cursorQuery3.close();
                                                                                                }
                                                                                            }
                                                                                            arrayMap6.put(strZzf, mapEmptyMap2);
                                                                                        } catch (Throwable th3) {
                                                                                            th = th3;
                                                                                            cursor2 = cursorQuery3;
                                                                                            if (cursor2 != null) {
                                                                                                cursor2.close();
                                                                                            }
                                                                                            throw th;
                                                                                        }
                                                                                    } catch (SQLiteException e15) {
                                                                                        e = e15;
                                                                                        cursorQuery3 = null;
                                                                                        zzakVarZzh3.zzt.zzaA().zzd().zzc("Database error querying filters. appId", zzet.zzn(str15), e);
                                                                                        mapEmptyMap2 = Collections.emptyMap();
                                                                                        if (cursorQuery3 != null) {
                                                                                            cursorQuery3.close();
                                                                                        }
                                                                                        arrayMap6.put(strZzf, mapEmptyMap2);
                                                                                        it8 = mapEmptyMap2.keySet().iterator();
                                                                                        while (it8.hasNext()) {
                                                                                            iIntValue3 = ((Integer) it8.next()).intValue();
                                                                                            set2 = this.zzb;
                                                                                            numValueOf4 = Integer.valueOf(iIntValue3);
                                                                                            if (set2.contains(numValueOf4)) {
                                                                                                this.zzt.zzaA().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                                                                                break;
                                                                                            }
                                                                                            it9 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                                                                            zZzd2 = true;
                                                                                            while (true) {
                                                                                                if (it9.hasNext()) {
                                                                                                    zzetVar = (com.google.android.gms.internal.measurement.zzet) it9.next();
                                                                                                    if (Log.isLoggable(this.zzt.zzaA().zzr(), 2)) {
                                                                                                        zzer zzerVarZzj = this.zzt.zzaA().zzj();
                                                                                                        Integer numValueOf12 = Integer.valueOf(iIntValue3);
                                                                                                        if (zzetVar.zzj()) {
                                                                                                            numValueOf6 = Integer.valueOf(zzetVar.zza());
                                                                                                        } else {
                                                                                                            numValueOf6 = null;
                                                                                                        }
                                                                                                        zzerVarZzj.zzd("Evaluating filter. audience, filter, property", numValueOf12, numValueOf6, this.zzt.zzj().zzf(zzetVar.zze()));
                                                                                                        this.zzt.zzaA().zzj().zzb("Filter definition", this.zzf.zzu().zzq(zzetVar));
                                                                                                    }
                                                                                                    if (zzetVar.zzj()) {
                                                                                                    }
                                                                                                    zzer zzerVarZzk = this.zzt.zzaA().zzk();
                                                                                                    Object objZzn = zzet.zzn(this.zza);
                                                                                                    if (zzetVar.zzj()) {
                                                                                                        numValueOf5 = Integer.valueOf(zzetVar.zza());
                                                                                                    } else {
                                                                                                        numValueOf5 = null;
                                                                                                    }
                                                                                                    zzerVarZzk.zzc("Invalid property filter ID. appId, id", objZzn, String.valueOf(numValueOf5));
                                                                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                                                } else {
                                                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                                                }
                                                                                                if (!zZzd2) {
                                                                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                                                                }
                                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                                                zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                                            }
                                                                                        }
                                                                                        it6 = it7;
                                                                                        str7 = str14;
                                                                                        str6 = str13;
                                                                                    }
                                                                                } catch (SQLiteException e16) {
                                                                                    e = e16;
                                                                                    it7 = it6;
                                                                                }
                                                                            } catch (Throwable th4) {
                                                                                th = th4;
                                                                                cursor2 = null;
                                                                            }
                                                                        } else {
                                                                            it7 = it6;
                                                                            str13 = str6;
                                                                            str14 = str7;
                                                                        }
                                                                        it8 = mapEmptyMap2.keySet().iterator();
                                                                        while (it8.hasNext()) {
                                                                            iIntValue3 = ((Integer) it8.next()).intValue();
                                                                            set2 = this.zzb;
                                                                            numValueOf4 = Integer.valueOf(iIntValue3);
                                                                            if (set2.contains(numValueOf4)) {
                                                                                this.zzt.zzaA().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                                                                break;
                                                                                break;
                                                                            }
                                                                            it9 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                                                            zZzd2 = true;
                                                                            while (true) {
                                                                                if (it9.hasNext()) {
                                                                                    zzetVar = (com.google.android.gms.internal.measurement.zzet) it9.next();
                                                                                    if (Log.isLoggable(this.zzt.zzaA().zzr(), 2)) {
                                                                                        zzer zzerVarZzj2 = this.zzt.zzaA().zzj();
                                                                                        Integer numValueOf13 = Integer.valueOf(iIntValue3);
                                                                                        if (zzetVar.zzj()) {
                                                                                            numValueOf6 = Integer.valueOf(zzetVar.zza());
                                                                                        } else {
                                                                                            numValueOf6 = null;
                                                                                        }
                                                                                        zzerVarZzj2.zzd("Evaluating filter. audience, filter, property", numValueOf13, numValueOf6, this.zzt.zzj().zzf(zzetVar.zze()));
                                                                                        this.zzt.zzaA().zzj().zzb("Filter definition", this.zzf.zzu().zzq(zzetVar));
                                                                                    }
                                                                                    if (zzetVar.zzj()) {
                                                                                    }
                                                                                    zzer zzerVarZzk2 = this.zzt.zzaA().zzk();
                                                                                    Object objZzn2 = zzet.zzn(this.zza);
                                                                                    if (zzetVar.zzj()) {
                                                                                        numValueOf5 = Integer.valueOf(zzetVar.zza());
                                                                                    } else {
                                                                                        numValueOf5 = null;
                                                                                    }
                                                                                    zzerVarZzk2.zzc("Invalid property filter ID. appId, id", objZzn2, String.valueOf(numValueOf5));
                                                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                                } else {
                                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                                }
                                                                                if (!zZzd2) {
                                                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                                                }
                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                                zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                            }
                                                                        }
                                                                        it6 = it7;
                                                                        str7 = str14;
                                                                        str6 = str13;
                                                                    }
                                                                }
                                                                str16 = str6;
                                                                arrayList4 = new ArrayList();
                                                                Set setKeySet = this.zzc.keySet();
                                                                setKeySet.removeAll(this.zzb);
                                                                it10 = setKeySet.iterator();
                                                                while (it10.hasNext()) {
                                                                    int iIntValue5 = ((Integer) it10.next()).intValue();
                                                                    Map map5 = this.zzc;
                                                                    Integer numValueOf14 = Integer.valueOf(iIntValue5);
                                                                    zzu zzuVar = (zzu) map5.get(numValueOf14);
                                                                    Preconditions.checkNotNull(zzuVar);
                                                                    com.google.android.gms.internal.measurement.zzfp zzfpVarZza = zzuVar.zza(iIntValue5);
                                                                    arrayList4.add(zzfpVarZza);
                                                                    zzakVarZzh4 = this.zzf.zzh();
                                                                    str17 = this.zza;
                                                                    com.google.android.gms.internal.measurement.zzgi zzgiVarZzd = zzfpVarZza.zzd();
                                                                    zzakVarZzh4.zzW();
                                                                    zzakVarZzh4.zzg();
                                                                    Preconditions.checkNotEmpty(str17);
                                                                    Preconditions.checkNotNull(zzgiVarZzd);
                                                                    byte[] bArrZzbx = zzgiVarZzd.zzbx();
                                                                    contentValues = new ContentValues();
                                                                    contentValues.put("app_id", str17);
                                                                    contentValues.put(str16, numValueOf14);
                                                                    String str28 = str12;
                                                                    contentValues.put(str28, bArrZzbx);
                                                                    try {
                                                                        try {
                                                                            if (zzakVarZzh4.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                                                zzakVarZzh4.zzt.zzaA().zzd().zzb("Failed to insert filter results (got -1). appId", zzet.zzn(str17));
                                                                            }
                                                                        } catch (SQLiteException e17) {
                                                                            e = e17;
                                                                            zzakVarZzh4.zzt.zzaA().zzd().zzc("Error storing filter results. appId", zzet.zzn(str17), e);
                                                                        }
                                                                    } catch (SQLiteException e18) {
                                                                        e = e18;
                                                                    }
                                                                    str12 = str28;
                                                                }
                                                                return arrayList4;
                                                            }
                                                        } catch (SQLiteException e19) {
                                                            e = e19;
                                                            cursorRawQuery = null;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            Zzh = 0;
                                                            if (Zzh != 0) {
                                                                Zzh.close();
                                                            }
                                                            throw th;
                                                        }
                                                        Preconditions.checkNotEmpty(str26);
                                                        Preconditions.checkNotNull(map2);
                                                        arrayMap3 = new ArrayMap();
                                                        if (!map2.isEmpty()) {
                                                            it2 = map2.keySet().iterator();
                                                            while (it2.hasNext()) {
                                                                int iIntValue6 = ((Integer) it2.next()).intValue();
                                                                Integer numValueOf15 = Integer.valueOf(iIntValue6);
                                                                zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf15);
                                                                list4 = (List) arrayMap2.get(numValueOf15);
                                                                if (list4 != null) {
                                                                }
                                                                it3 = it2;
                                                                arrayMap3.put(numValueOf15, zzgiVar2);
                                                                arrayMap2 = arrayMap2;
                                                                it2 = it3;
                                                            }
                                                        }
                                                        map3 = arrayMap3;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                    }
                                                } else {
                                                    map3 = map2;
                                                }
                                                it = hashSet.iterator();
                                                while (it.hasNext()) {
                                                    iIntValue = ((Integer) it.next()).intValue();
                                                    zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map3.get(Integer.valueOf(iIntValue));
                                                    bitSet = new BitSet();
                                                    bitSet2 = new BitSet();
                                                    arrayMap = new ArrayMap();
                                                    if (zzgiVar != null) {
                                                        while (r2.hasNext()) {
                                                            if (zzfrVar.zzh()) {
                                                                Integer numValueOf16 = Integer.valueOf(zzfrVar.zza());
                                                                if (zzfrVar.zzg()) {
                                                                    lValueOf = Long.valueOf(zzfrVar.zzb());
                                                                } else {
                                                                    lValueOf = null;
                                                                }
                                                                arrayMap.put(numValueOf16, lValueOf);
                                                            }
                                                        }
                                                    }
                                                    ArrayMap arrayMap11 = new ArrayMap();
                                                    if (zzgiVar != null) {
                                                        while (r2.hasNext()) {
                                                            if (!zzgkVar.zzi()) {
                                                            }
                                                        }
                                                    }
                                                    Map map6 = map3;
                                                    if (zzgiVar != null) {
                                                        i3 = 0;
                                                        while (i3 < zzgiVar.zzd() * 64) {
                                                            if (zzlj.zzw(zzgiVar.zzk(), i3)) {
                                                                str4 = str21;
                                                                this.zzt.zzaA().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i3));
                                                                bitSet2.set(i3);
                                                                if (zzlj.zzw(zzgiVar.zzi(), i3)) {
                                                                    bitSet.set(i3);
                                                                }
                                                                i3++;
                                                                str21 = str4;
                                                            } else {
                                                                str4 = str21;
                                                            }
                                                            arrayMap.remove(Integer.valueOf(i3));
                                                            i3++;
                                                            str21 = str4;
                                                        }
                                                    }
                                                    String str29 = str21;
                                                    Integer numValueOf17 = Integer.valueOf(iIntValue);
                                                    com.google.android.gms.internal.measurement.zzgi zzgiVar4 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf17);
                                                    if (!zZzs2) {
                                                    }
                                                    this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzgiVar4, bitSet, bitSet2, arrayMap, arrayMap11, null));
                                                    str21 = str29;
                                                    map = map;
                                                    map3 = map6;
                                                    map2 = map2;
                                                }
                                                str3 = str21;
                                            }
                                            str6 = str2;
                                            str7 = str22;
                                            if (!list.isEmpty()) {
                                                zzwVar = new zzw(this, null);
                                                arrayMap4 = new ArrayMap();
                                                it4 = list.iterator();
                                                while (it4.hasNext()) {
                                                    zzftVar = (com.google.android.gms.internal.measurement.zzft) it4.next();
                                                    zzftVarZza = zzwVar.zza(this.zza, zzftVar);
                                                    if (zzftVarZza != null) {
                                                        zzakVarZzh = this.zzf.zzh();
                                                        str8 = this.zza;
                                                        strZzh = zzftVarZza.zzh();
                                                        zzaqVarZzn = zzakVarZzh.zzn(str8, zzftVar.zzh());
                                                        if (zzaqVarZzn == null) {
                                                            zzakVarZzh.zzt.zzaA().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzet.zzn(str8), zzakVarZzh.zzt.zzj().zzd(strZzh));
                                                            zzaqVar = new zzaq(str8, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                                        } else {
                                                            zzaqVar = new zzaq(zzaqVarZzn.zza, zzaqVarZzn.zzb, zzaqVarZzn.zzc + 1, zzaqVarZzn.zzd + 1, zzaqVarZzn.zze + 1, zzaqVarZzn.zzf, zzaqVarZzn.zzg, zzaqVarZzn.zzh, zzaqVarZzn.zzi, zzaqVarZzn.zzj, zzaqVarZzn.zzk);
                                                        }
                                                        this.zzf.zzh().zzE(zzaqVar);
                                                        j = zzaqVar.zzc;
                                                        strZzh2 = zzftVarZza.zzh();
                                                        mapEmptyMap = (Map) arrayMap4.get(strZzh2);
                                                        if (mapEmptyMap == null) {
                                                            zzakVarZzh2 = this.zzf.zzh();
                                                            str9 = this.zza;
                                                            zzakVarZzh2.zzW();
                                                            zzakVarZzh2.zzg();
                                                            Preconditions.checkNotEmpty(str9);
                                                            Preconditions.checkNotEmpty(strZzh2);
                                                            arrayMap5 = new ArrayMap();
                                                            str10 = str6;
                                                            str11 = str7;
                                                            str7 = str11;
                                                            cursorQuery2 = zzakVarZzh2.zzh().query("event_filters", new String[]{str10, str11}, "app_id=? AND event_name=?", new String[]{str9, strZzh2}, null, null, null);
                                                            if (cursorQuery2.moveToFirst()) {
                                                                str6 = str10;
                                                                while (true) {
                                                                    com.google.android.gms.internal.measurement.zzek zzekVar4 = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzlj.zzm(com.google.android.gms.internal.measurement.zzek.zzc(), cursorQuery2.getBlob(1))).zzaD();
                                                                    numValueOf3 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                    list5 = (List) arrayMap5.get(numValueOf3);
                                                                    if (list5 == null) {
                                                                        zzaqVar2 = zzaqVar;
                                                                        arrayList2 = new ArrayList();
                                                                        arrayMap5.put(numValueOf3, arrayList2);
                                                                    } else {
                                                                        zzaqVar2 = zzaqVar;
                                                                        arrayList2 = list5;
                                                                    }
                                                                    arrayList2.add(zzekVar4);
                                                                    if (!cursorQuery2.moveToNext()) {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    zzaqVar = zzaqVar2;
                                                                }
                                                                if (cursorQuery2 != null) {
                                                                    cursorQuery2.close();
                                                                }
                                                                mapEmptyMap = arrayMap5;
                                                            } else {
                                                                zzaqVar2 = zzaqVar;
                                                                str6 = str10;
                                                                mapEmptyMap = Collections.emptyMap();
                                                                if (cursorQuery2 != null) {
                                                                    cursorQuery2.close();
                                                                }
                                                            }
                                                            arrayMap4.put(strZzh2, mapEmptyMap);
                                                        } else {
                                                            zzaqVar2 = zzaqVar;
                                                        }
                                                        it5 = mapEmptyMap.keySet().iterator();
                                                        while (it5.hasNext()) {
                                                            iIntValue2 = ((Integer) it5.next()).intValue();
                                                            set = this.zzb;
                                                            numValueOf2 = Integer.valueOf(iIntValue2);
                                                            if (set.contains(numValueOf2)) {
                                                                this.zzt.zzaA().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                            } else {
                                                                zZzd = true;
                                                                while (r5.hasNext()) {
                                                                    zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                                                    zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j, zzaqVar2, zzf(iIntValue2, zzekVar3.zzb()));
                                                                    if (!zZzd) {
                                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                                        break;
                                                                    }
                                                                    zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                                }
                                                                if (!zZzd) {
                                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                                }
                                                            }
                                                        }
                                                        zzwVar = zzwVar;
                                                        it4 = it4;
                                                        str18 = str18;
                                                    }
                                                }
                                            }
                                            str12 = str18;
                                            if (!list2.isEmpty()) {
                                                arrayMap6 = new ArrayMap();
                                                it6 = list2.iterator();
                                                while (it6.hasNext()) {
                                                    com.google.android.gms.internal.measurement.zzgm zzgmVar2 = (com.google.android.gms.internal.measurement.zzgm) it6.next();
                                                    strZzf = zzgmVar2.zzf();
                                                    mapEmptyMap2 = (Map) arrayMap6.get(strZzf);
                                                    if (mapEmptyMap2 == null) {
                                                        zzakVarZzh3 = this.zzf.zzh();
                                                        str15 = this.zza;
                                                        zzakVarZzh3.zzW();
                                                        zzakVarZzh3.zzg();
                                                        Preconditions.checkNotEmpty(str15);
                                                        Preconditions.checkNotEmpty(strZzf);
                                                        arrayMap7 = new ArrayMap();
                                                        str13 = str6;
                                                        str14 = str7;
                                                        it7 = it6;
                                                        cursorQuery3 = zzakVarZzh3.zzh().query("property_filters", new String[]{str13, str14}, "app_id=? AND property_name=?", new String[]{str15, strZzf}, null, null, null);
                                                        if (cursorQuery3.moveToFirst()) {
                                                            do {
                                                                com.google.android.gms.internal.measurement.zzet zzetVar3 = (com.google.android.gms.internal.measurement.zzet) ((com.google.android.gms.internal.measurement.zzes) zzlj.zzm(com.google.android.gms.internal.measurement.zzet.zzc(), cursorQuery3.getBlob(1))).zzaD();
                                                                numValueOf7 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                list6 = (List) arrayMap7.get(numValueOf7);
                                                                if (list6 == null) {
                                                                    arrayList3 = new ArrayList();
                                                                    arrayMap7.put(numValueOf7, arrayList3);
                                                                } else {
                                                                    arrayList3 = list6;
                                                                }
                                                                arrayList3.add(zzetVar3);
                                                            } while (cursorQuery3.moveToNext());
                                                            if (cursorQuery3 != null) {
                                                                cursorQuery3.close();
                                                            }
                                                            mapEmptyMap2 = arrayMap7;
                                                        } else {
                                                            mapEmptyMap2 = Collections.emptyMap();
                                                            if (cursorQuery3 != null) {
                                                                cursorQuery3.close();
                                                            }
                                                        }
                                                        arrayMap6.put(strZzf, mapEmptyMap2);
                                                    } else {
                                                        it7 = it6;
                                                        str13 = str6;
                                                        str14 = str7;
                                                    }
                                                    it8 = mapEmptyMap2.keySet().iterator();
                                                    while (it8.hasNext()) {
                                                        iIntValue3 = ((Integer) it8.next()).intValue();
                                                        set2 = this.zzb;
                                                        numValueOf4 = Integer.valueOf(iIntValue3);
                                                        if (set2.contains(numValueOf4)) {
                                                            this.zzt.zzaA().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                                            break;
                                                            break;
                                                        }
                                                        it9 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                                        zZzd2 = true;
                                                        while (true) {
                                                            if (it9.hasNext()) {
                                                                zzetVar = (com.google.android.gms.internal.measurement.zzet) it9.next();
                                                                if (Log.isLoggable(this.zzt.zzaA().zzr(), 2)) {
                                                                    zzer zzerVarZzj3 = this.zzt.zzaA().zzj();
                                                                    Integer numValueOf18 = Integer.valueOf(iIntValue3);
                                                                    if (zzetVar.zzj()) {
                                                                        numValueOf6 = Integer.valueOf(zzetVar.zza());
                                                                    } else {
                                                                        numValueOf6 = null;
                                                                    }
                                                                    zzerVarZzj3.zzd("Evaluating filter. audience, filter, property", numValueOf18, numValueOf6, this.zzt.zzj().zzf(zzetVar.zze()));
                                                                    this.zzt.zzaA().zzj().zzb("Filter definition", this.zzf.zzu().zzq(zzetVar));
                                                                }
                                                                if (zzetVar.zzj()) {
                                                                }
                                                                zzer zzerVarZzk3 = this.zzt.zzaA().zzk();
                                                                Object objZzn3 = zzet.zzn(this.zza);
                                                                if (zzetVar.zzj()) {
                                                                    numValueOf5 = Integer.valueOf(zzetVar.zza());
                                                                } else {
                                                                    numValueOf5 = null;
                                                                }
                                                                zzerVarZzk3.zzc("Invalid property filter ID. appId, id", objZzn3, String.valueOf(numValueOf5));
                                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                                mapEmptyMap2 = mapEmptyMap2;
                                                            } else {
                                                                mapEmptyMap2 = mapEmptyMap2;
                                                            }
                                                            if (!zZzd2) {
                                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                            }
                                                            mapEmptyMap2 = mapEmptyMap2;
                                                            zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                                            mapEmptyMap2 = mapEmptyMap2;
                                                        }
                                                    }
                                                    it6 = it7;
                                                    str7 = str14;
                                                    str6 = str13;
                                                }
                                            }
                                            str16 = str6;
                                            arrayList4 = new ArrayList();
                                            Set setKeySet2 = this.zzc.keySet();
                                            setKeySet2.removeAll(this.zzb);
                                            it10 = setKeySet2.iterator();
                                            while (it10.hasNext()) {
                                                int iIntValue7 = ((Integer) it10.next()).intValue();
                                                Map map7 = this.zzc;
                                                Integer numValueOf19 = Integer.valueOf(iIntValue7);
                                                zzu zzuVar2 = (zzu) map7.get(numValueOf19);
                                                Preconditions.checkNotNull(zzuVar2);
                                                com.google.android.gms.internal.measurement.zzfp zzfpVarZza2 = zzuVar2.zza(iIntValue7);
                                                arrayList4.add(zzfpVarZza2);
                                                zzakVarZzh4 = this.zzf.zzh();
                                                str17 = this.zza;
                                                com.google.android.gms.internal.measurement.zzgi zzgiVarZzd2 = zzfpVarZza2.zzd();
                                                zzakVarZzh4.zzW();
                                                zzakVarZzh4.zzg();
                                                Preconditions.checkNotEmpty(str17);
                                                Preconditions.checkNotNull(zzgiVarZzd2);
                                                byte[] bArrZzbx2 = zzgiVarZzd2.zzbx();
                                                contentValues = new ContentValues();
                                                contentValues.put("app_id", str17);
                                                contentValues.put(str16, numValueOf19);
                                                String str210 = str12;
                                                contentValues.put(str210, bArrZzbx2);
                                                if (zzakVarZzh4.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                    zzakVarZzh4.zzt.zzaA().zzd().zzb("Failed to insert filter results (got -1). appId", zzet.zzn(str17));
                                                }
                                                str12 = str210;
                                            }
                                            return arrayList4;
                                        }
                                    }
                                    try {
                                        if (!cursorQuery.moveToNext()) {
                                            break;
                                        }
                                        arrayMap8 = arrayMap8;
                                        str23 = str2;
                                        str22 = str22;
                                    } catch (SQLiteException e20) {
                                        e = e20;
                                        zzakVarZzh7.zzt.zzaA().zzd().zzc("Database error querying filter results. appId", zzet.zzn(str25), e);
                                        Map mapEmptyMap5 = Collections.emptyMap();
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        map2 = mapEmptyMap5;
                                    }
                                }
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = arrayMap8;
                            } else {
                                Map mapEmptyMap6 = Collections.emptyMap();
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = mapEmptyMap6;
                                str2 = "audience_id";
                                str22 = "data";
                            }
                            if (map2.isEmpty()) {
                                str3 = "Failed to merge filter. appId";
                            } else {
                                HashSet hashSet2 = new HashSet(map2.keySet());
                                if (z) {
                                    String str211 = this.zza;
                                    zzak zzakVarZzh9 = this.zzf.zzh();
                                    str5 = this.zza;
                                    zzakVarZzh9.zzW();
                                    zzakVarZzh9.zzg();
                                    Preconditions.checkNotEmpty(str5);
                                    arrayMap2 = new ArrayMap();
                                    Zzh = zzakVarZzh9.zzh();
                                    i4 = 0;
                                    cursorRawQuery = Zzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str5, str5});
                                    if (cursorRawQuery.moveToFirst()) {
                                        while (true) {
                                            numValueOf = Integer.valueOf(cursorRawQuery.getInt(i4));
                                            arrayList = (List) arrayMap2.get(numValueOf);
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                                arrayMap2.put(numValueOf, arrayList);
                                            }
                                            arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                            if (!cursorRawQuery.moveToNext()) {
                                                break;
                                                break;
                                            }
                                            i4 = 0;
                                        }
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                    } else {
                                        arrayMap2 = Collections.emptyMap();
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                    }
                                    Preconditions.checkNotEmpty(str211);
                                    Preconditions.checkNotNull(map2);
                                    arrayMap3 = new ArrayMap();
                                    if (!map2.isEmpty()) {
                                        it2 = map2.keySet().iterator();
                                        while (it2.hasNext()) {
                                            int iIntValue8 = ((Integer) it2.next()).intValue();
                                            Integer numValueOf110 = Integer.valueOf(iIntValue8);
                                            zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf110);
                                            list4 = (List) arrayMap2.get(numValueOf110);
                                            if (list4 != null) {
                                            }
                                            it3 = it2;
                                            arrayMap3.put(numValueOf110, zzgiVar2);
                                            arrayMap2 = arrayMap2;
                                            it2 = it3;
                                        }
                                    }
                                    map3 = arrayMap3;
                                } else {
                                    map3 = map2;
                                }
                                it = hashSet2.iterator();
                                while (it.hasNext()) {
                                    iIntValue = ((Integer) it.next()).intValue();
                                    zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map3.get(Integer.valueOf(iIntValue));
                                    bitSet = new BitSet();
                                    bitSet2 = new BitSet();
                                    arrayMap = new ArrayMap();
                                    if (zzgiVar != null) {
                                        while (r2.hasNext()) {
                                            if (zzfrVar.zzh()) {
                                                Integer numValueOf111 = Integer.valueOf(zzfrVar.zza());
                                                if (zzfrVar.zzg()) {
                                                    lValueOf = Long.valueOf(zzfrVar.zzb());
                                                } else {
                                                    lValueOf = null;
                                                }
                                                arrayMap.put(numValueOf111, lValueOf);
                                            }
                                        }
                                    }
                                    ArrayMap arrayMap12 = new ArrayMap();
                                    if (zzgiVar != null) {
                                        while (r2.hasNext()) {
                                            if (!zzgkVar.zzi()) {
                                            }
                                        }
                                    }
                                    Map map8 = map3;
                                    if (zzgiVar != null) {
                                        i3 = 0;
                                        while (i3 < zzgiVar.zzd() * 64) {
                                            if (zzlj.zzw(zzgiVar.zzk(), i3)) {
                                                str4 = str21;
                                                this.zzt.zzaA().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i3));
                                                bitSet2.set(i3);
                                                if (zzlj.zzw(zzgiVar.zzi(), i3)) {
                                                    bitSet.set(i3);
                                                }
                                                i3++;
                                                str21 = str4;
                                            } else {
                                                str4 = str21;
                                            }
                                            arrayMap.remove(Integer.valueOf(i3));
                                            i3++;
                                            str21 = str4;
                                        }
                                    }
                                    String str212 = str21;
                                    Integer numValueOf112 = Integer.valueOf(iIntValue);
                                    com.google.android.gms.internal.measurement.zzgi zzgiVar5 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf112);
                                    if (!zZzs2) {
                                    }
                                    this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzgiVar5, bitSet, bitSet2, arrayMap, arrayMap12, null));
                                    str21 = str212;
                                    map = map;
                                    map3 = map8;
                                    map2 = map2;
                                }
                                str3 = str21;
                            }
                            str6 = str2;
                            str7 = str22;
                            if (!list.isEmpty()) {
                                zzwVar = new zzw(this, null);
                                arrayMap4 = new ArrayMap();
                                it4 = list.iterator();
                                while (it4.hasNext()) {
                                    zzftVar = (com.google.android.gms.internal.measurement.zzft) it4.next();
                                    zzftVarZza = zzwVar.zza(this.zza, zzftVar);
                                    if (zzftVarZza != null) {
                                        zzakVarZzh = this.zzf.zzh();
                                        str8 = this.zza;
                                        strZzh = zzftVarZza.zzh();
                                        zzaqVarZzn = zzakVarZzh.zzn(str8, zzftVar.zzh());
                                        if (zzaqVarZzn == null) {
                                            zzakVarZzh.zzt.zzaA().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzet.zzn(str8), zzakVarZzh.zzt.zzj().zzd(strZzh));
                                            zzaqVar = new zzaq(str8, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                        } else {
                                            zzaqVar = new zzaq(zzaqVarZzn.zza, zzaqVarZzn.zzb, zzaqVarZzn.zzc + 1, zzaqVarZzn.zzd + 1, zzaqVarZzn.zze + 1, zzaqVarZzn.zzf, zzaqVarZzn.zzg, zzaqVarZzn.zzh, zzaqVarZzn.zzi, zzaqVarZzn.zzj, zzaqVarZzn.zzk);
                                        }
                                        this.zzf.zzh().zzE(zzaqVar);
                                        j = zzaqVar.zzc;
                                        strZzh2 = zzftVarZza.zzh();
                                        mapEmptyMap = (Map) arrayMap4.get(strZzh2);
                                        if (mapEmptyMap == null) {
                                            zzakVarZzh2 = this.zzf.zzh();
                                            str9 = this.zza;
                                            zzakVarZzh2.zzW();
                                            zzakVarZzh2.zzg();
                                            Preconditions.checkNotEmpty(str9);
                                            Preconditions.checkNotEmpty(strZzh2);
                                            arrayMap5 = new ArrayMap();
                                            str10 = str6;
                                            str11 = str7;
                                            str7 = str11;
                                            cursorQuery2 = zzakVarZzh2.zzh().query("event_filters", new String[]{str10, str11}, "app_id=? AND event_name=?", new String[]{str9, strZzh2}, null, null, null);
                                            if (cursorQuery2.moveToFirst()) {
                                                str6 = str10;
                                                while (true) {
                                                    com.google.android.gms.internal.measurement.zzek zzekVar5 = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzlj.zzm(com.google.android.gms.internal.measurement.zzek.zzc(), cursorQuery2.getBlob(1))).zzaD();
                                                    numValueOf3 = Integer.valueOf(cursorQuery2.getInt(0));
                                                    list5 = (List) arrayMap5.get(numValueOf3);
                                                    if (list5 == null) {
                                                        zzaqVar2 = zzaqVar;
                                                        arrayList2 = new ArrayList();
                                                        arrayMap5.put(numValueOf3, arrayList2);
                                                    } else {
                                                        zzaqVar2 = zzaqVar;
                                                        arrayList2 = list5;
                                                    }
                                                    arrayList2.add(zzekVar5);
                                                    if (!cursorQuery2.moveToNext()) {
                                                        break;
                                                        break;
                                                    }
                                                    zzaqVar = zzaqVar2;
                                                }
                                                if (cursorQuery2 != null) {
                                                    cursorQuery2.close();
                                                }
                                                mapEmptyMap = arrayMap5;
                                            } else {
                                                zzaqVar2 = zzaqVar;
                                                str6 = str10;
                                                mapEmptyMap = Collections.emptyMap();
                                                if (cursorQuery2 != null) {
                                                    cursorQuery2.close();
                                                }
                                            }
                                            arrayMap4.put(strZzh2, mapEmptyMap);
                                        } else {
                                            zzaqVar2 = zzaqVar;
                                        }
                                        it5 = mapEmptyMap.keySet().iterator();
                                        while (it5.hasNext()) {
                                            iIntValue2 = ((Integer) it5.next()).intValue();
                                            set = this.zzb;
                                            numValueOf2 = Integer.valueOf(iIntValue2);
                                            if (set.contains(numValueOf2)) {
                                                this.zzt.zzaA().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                            } else {
                                                zZzd = true;
                                                while (r5.hasNext()) {
                                                    zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                                    zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j, zzaqVar2, zzf(iIntValue2, zzekVar3.zzb()));
                                                    if (!zZzd) {
                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                        break;
                                                    }
                                                    zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                }
                                                if (!zZzd) {
                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                }
                                            }
                                        }
                                        zzwVar = zzwVar;
                                        it4 = it4;
                                        str18 = str18;
                                    }
                                }
                            }
                            str12 = str18;
                            if (!list2.isEmpty()) {
                                arrayMap6 = new ArrayMap();
                                it6 = list2.iterator();
                                while (it6.hasNext()) {
                                    com.google.android.gms.internal.measurement.zzgm zzgmVar3 = (com.google.android.gms.internal.measurement.zzgm) it6.next();
                                    strZzf = zzgmVar3.zzf();
                                    mapEmptyMap2 = (Map) arrayMap6.get(strZzf);
                                    if (mapEmptyMap2 == null) {
                                        zzakVarZzh3 = this.zzf.zzh();
                                        str15 = this.zza;
                                        zzakVarZzh3.zzW();
                                        zzakVarZzh3.zzg();
                                        Preconditions.checkNotEmpty(str15);
                                        Preconditions.checkNotEmpty(strZzf);
                                        arrayMap7 = new ArrayMap();
                                        str13 = str6;
                                        str14 = str7;
                                        it7 = it6;
                                        cursorQuery3 = zzakVarZzh3.zzh().query("property_filters", new String[]{str13, str14}, "app_id=? AND property_name=?", new String[]{str15, strZzf}, null, null, null);
                                        if (cursorQuery3.moveToFirst()) {
                                            do {
                                                com.google.android.gms.internal.measurement.zzet zzetVar4 = (com.google.android.gms.internal.measurement.zzet) ((com.google.android.gms.internal.measurement.zzes) zzlj.zzm(com.google.android.gms.internal.measurement.zzet.zzc(), cursorQuery3.getBlob(1))).zzaD();
                                                numValueOf7 = Integer.valueOf(cursorQuery3.getInt(0));
                                                list6 = (List) arrayMap7.get(numValueOf7);
                                                if (list6 == null) {
                                                    arrayList3 = new ArrayList();
                                                    arrayMap7.put(numValueOf7, arrayList3);
                                                } else {
                                                    arrayList3 = list6;
                                                }
                                                arrayList3.add(zzetVar4);
                                            } while (cursorQuery3.moveToNext());
                                            if (cursorQuery3 != null) {
                                                cursorQuery3.close();
                                            }
                                            mapEmptyMap2 = arrayMap7;
                                        } else {
                                            mapEmptyMap2 = Collections.emptyMap();
                                            if (cursorQuery3 != null) {
                                                cursorQuery3.close();
                                            }
                                        }
                                        arrayMap6.put(strZzf, mapEmptyMap2);
                                    } else {
                                        it7 = it6;
                                        str13 = str6;
                                        str14 = str7;
                                    }
                                    it8 = mapEmptyMap2.keySet().iterator();
                                    while (it8.hasNext()) {
                                        iIntValue3 = ((Integer) it8.next()).intValue();
                                        set2 = this.zzb;
                                        numValueOf4 = Integer.valueOf(iIntValue3);
                                        if (set2.contains(numValueOf4)) {
                                            this.zzt.zzaA().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                            break;
                                            break;
                                        }
                                        it9 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                        zZzd2 = true;
                                        while (true) {
                                            if (it9.hasNext()) {
                                                zzetVar = (com.google.android.gms.internal.measurement.zzet) it9.next();
                                                if (Log.isLoggable(this.zzt.zzaA().zzr(), 2)) {
                                                    zzer zzerVarZzj4 = this.zzt.zzaA().zzj();
                                                    Integer numValueOf113 = Integer.valueOf(iIntValue3);
                                                    if (zzetVar.zzj()) {
                                                        numValueOf6 = Integer.valueOf(zzetVar.zza());
                                                    } else {
                                                        numValueOf6 = null;
                                                    }
                                                    zzerVarZzj4.zzd("Evaluating filter. audience, filter, property", numValueOf113, numValueOf6, this.zzt.zzj().zzf(zzetVar.zze()));
                                                    this.zzt.zzaA().zzj().zzb("Filter definition", this.zzf.zzu().zzq(zzetVar));
                                                }
                                                if (zzetVar.zzj()) {
                                                }
                                                zzer zzerVarZzk4 = this.zzt.zzaA().zzk();
                                                Object objZzn4 = zzet.zzn(this.zza);
                                                if (zzetVar.zzj()) {
                                                    numValueOf5 = Integer.valueOf(zzetVar.zza());
                                                } else {
                                                    numValueOf5 = null;
                                                }
                                                zzerVarZzk4.zzc("Invalid property filter ID. appId, id", objZzn4, String.valueOf(numValueOf5));
                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                mapEmptyMap2 = mapEmptyMap2;
                                            } else {
                                                mapEmptyMap2 = mapEmptyMap2;
                                            }
                                            if (!zZzd2) {
                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                            }
                                            mapEmptyMap2 = mapEmptyMap2;
                                            zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                            mapEmptyMap2 = mapEmptyMap2;
                                        }
                                    }
                                    it6 = it7;
                                    str7 = str14;
                                    str6 = str13;
                                }
                            }
                            str16 = str6;
                            arrayList4 = new ArrayList();
                            Set setKeySet3 = this.zzc.keySet();
                            setKeySet3.removeAll(this.zzb);
                            it10 = setKeySet3.iterator();
                            while (it10.hasNext()) {
                                int iIntValue9 = ((Integer) it10.next()).intValue();
                                Map map9 = this.zzc;
                                Integer numValueOf114 = Integer.valueOf(iIntValue9);
                                zzu zzuVar3 = (zzu) map9.get(numValueOf114);
                                Preconditions.checkNotNull(zzuVar3);
                                com.google.android.gms.internal.measurement.zzfp zzfpVarZza3 = zzuVar3.zza(iIntValue9);
                                arrayList4.add(zzfpVarZza3);
                                zzakVarZzh4 = this.zzf.zzh();
                                str17 = this.zza;
                                com.google.android.gms.internal.measurement.zzgi zzgiVarZzd3 = zzfpVarZza3.zzd();
                                zzakVarZzh4.zzW();
                                zzakVarZzh4.zzg();
                                Preconditions.checkNotEmpty(str17);
                                Preconditions.checkNotNull(zzgiVarZzd3);
                                byte[] bArrZzbx3 = zzgiVarZzd3.zzbx();
                                contentValues = new ContentValues();
                                contentValues.put("app_id", str17);
                                contentValues.put(str16, numValueOf114);
                                String str213 = str12;
                                contentValues.put(str213, bArrZzbx3);
                                if (zzakVarZzh4.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                    zzakVarZzh4.zzt.zzaA().zzd().zzb("Failed to insert filter results (got -1). appId", zzet.zzn(str17));
                                }
                                str12 = str213;
                            }
                            return arrayList4;
                        } catch (Throwable th7) {
                            th = th7;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteException e21) {
                    e = e21;
                    cursorQuery4 = null;
                } catch (Throwable th8) {
                    th = th8;
                    r5 = 0;
                    if (r5 != 0) {
                        r5.close();
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                if (r5 != 0) {
                    r5.close();
                }
                throw th;
            }
        } else {
            map = mapEmptyMap3;
        }
        zzak zzakVarZzh10 = this.zzf.zzh();
        String str214 = this.zza;
        zzakVarZzh10.zzW();
        zzakVarZzh10.zzg();
        Preconditions.checkNotEmpty(str214);
        try {
            cursorQuery = zzakVarZzh10.zzh().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str214}, null, null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    Map mapEmptyMap7 = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    map2 = mapEmptyMap7;
                    str2 = "audience_id";
                    str22 = "data";
                } else {
                    arrayMap8 = new ArrayMap();
                    while (true) {
                        i5 = cursorQuery.getInt(0);
                        arrayMap8.put(Integer.valueOf(i5), (com.google.android.gms.internal.measurement.zzgi) ((com.google.android.gms.internal.measurement.zzgh) zzlj.zzm(com.google.android.gms.internal.measurement.zzgi.zze(), cursorQuery.getBlob(1))).zzaD());
                        str2 = str23;
                        if (!cursorQuery.moveToNext()) {
                            break;
                            break;
                        }
                        arrayMap8 = arrayMap8;
                        str23 = str2;
                        str22 = str22;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    map2 = arrayMap8;
                }
            } catch (SQLiteException e22) {
                e = e22;
                str2 = "audience_id";
            }
        } catch (SQLiteException e23) {
            e = e23;
            str2 = "audience_id";
            str22 = "data";
            cursorQuery = null;
        } catch (Throwable th10) {
            th = th10;
            cursor = null;
        }
        if (map2.isEmpty()) {
            str3 = "Failed to merge filter. appId";
        } else {
            HashSet hashSet3 = new HashSet(map2.keySet());
            if (z) {
                String str215 = this.zza;
                zzak zzakVarZzh11 = this.zzf.zzh();
                str5 = this.zza;
                zzakVarZzh11.zzW();
                zzakVarZzh11.zzg();
                Preconditions.checkNotEmpty(str5);
                arrayMap2 = new ArrayMap();
                Zzh = zzakVarZzh11.zzh();
                i4 = 0;
                cursorRawQuery = Zzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str5, str5});
                if (cursorRawQuery.moveToFirst()) {
                    while (true) {
                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(i4));
                        arrayList = (List) arrayMap2.get(numValueOf);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap2.put(numValueOf, arrayList);
                        }
                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                        if (!cursorRawQuery.moveToNext()) {
                            break;
                            break;
                        }
                        i4 = 0;
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } else {
                    arrayMap2 = Collections.emptyMap();
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
                Preconditions.checkNotEmpty(str215);
                Preconditions.checkNotNull(map2);
                arrayMap3 = new ArrayMap();
                if (!map2.isEmpty()) {
                    it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        int iIntValue10 = ((Integer) it2.next()).intValue();
                        Integer numValueOf115 = Integer.valueOf(iIntValue10);
                        zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf115);
                        list4 = (List) arrayMap2.get(numValueOf115);
                        if (list4 != null || list4.isEmpty()) {
                            it3 = it2;
                            arrayMap3.put(numValueOf115, zzgiVar2);
                            arrayMap2 = arrayMap2;
                            it2 = it3;
                        } else {
                            List listZzr = this.zzf.zzu().zzr(zzgiVar2.zzi(), list4);
                            if (!listZzr.isEmpty()) {
                                com.google.android.gms.internal.measurement.zzgh zzghVar = (com.google.android.gms.internal.measurement.zzgh) zzgiVar2.zzbB();
                                zzghVar.zzf();
                                zzghVar.zzb(listZzr);
                                List listZzr2 = this.zzf.zzu().zzr(zzgiVar2.zzk(), list4);
                                zzghVar.zzh();
                                zzghVar.zzd(listZzr2);
                                ArrayList arrayList6 = new ArrayList();
                                Iterator it12 = zzgiVar2.zzh().iterator();
                                while (it12.hasNext()) {
                                    Iterator it13 = it2;
                                    com.google.android.gms.internal.measurement.zzfr zzfrVar2 = (com.google.android.gms.internal.measurement.zzfr) it12.next();
                                    Iterator it14 = it12;
                                    if (!list4.contains(Integer.valueOf(zzfrVar2.zza()))) {
                                        arrayList6.add(zzfrVar2);
                                    }
                                    it2 = it13;
                                    it12 = it14;
                                }
                                it3 = it2;
                                zzghVar.zze();
                                zzghVar.zza(arrayList6);
                                ArrayList arrayList7 = new ArrayList();
                                for (com.google.android.gms.internal.measurement.zzgk zzgkVar2 : zzgiVar2.zzj()) {
                                    if (!list4.contains(Integer.valueOf(zzgkVar2.zzb()))) {
                                        arrayList7.add(zzgkVar2);
                                    }
                                }
                                zzghVar.zzg();
                                zzghVar.zzc(arrayList7);
                                arrayMap3.put(Integer.valueOf(iIntValue10), (com.google.android.gms.internal.measurement.zzgi) zzghVar.zzaD());
                                arrayMap2 = arrayMap2;
                                it2 = it3;
                            }
                        }
                    }
                }
                map3 = arrayMap3;
            } else {
                map3 = map2;
            }
            it = hashSet3.iterator();
            while (it.hasNext()) {
                iIntValue = ((Integer) it.next()).intValue();
                zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map3.get(Integer.valueOf(iIntValue));
                bitSet = new BitSet();
                bitSet2 = new BitSet();
                arrayMap = new ArrayMap();
                if (zzgiVar != null && zzgiVar.zza() != 0) {
                    while (r2.hasNext()) {
                        if (zzfrVar.zzh()) {
                            Integer numValueOf116 = Integer.valueOf(zzfrVar.zza());
                            if (zzfrVar.zzg()) {
                                lValueOf = Long.valueOf(zzfrVar.zzb());
                            } else {
                                lValueOf = null;
                            }
                            arrayMap.put(numValueOf116, lValueOf);
                        }
                    }
                }
                ArrayMap arrayMap13 = new ArrayMap();
                if (zzgiVar != null && zzgiVar.zzc() != 0) {
                    while (r2.hasNext()) {
                        if (!zzgkVar.zzi() && zzgkVar.zza() > 0) {
                            arrayMap13.put(Integer.valueOf(zzgkVar.zzb()), Long.valueOf(zzgkVar.zzc(zzgkVar.zza() - 1)));
                            map3 = map3;
                        }
                    }
                }
                Map map10 = map3;
                if (zzgiVar != null) {
                    i3 = 0;
                    while (i3 < zzgiVar.zzd() * 64) {
                        if (zzlj.zzw(zzgiVar.zzk(), i3)) {
                            str4 = str21;
                            this.zzt.zzaA().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i3));
                            bitSet2.set(i3);
                            if (zzlj.zzw(zzgiVar.zzi(), i3)) {
                                bitSet.set(i3);
                            }
                            i3++;
                            str21 = str4;
                        } else {
                            str4 = str21;
                        }
                        arrayMap.remove(Integer.valueOf(i3));
                        i3++;
                        str21 = str4;
                    }
                }
                String str216 = str21;
                Integer numValueOf117 = Integer.valueOf(iIntValue);
                com.google.android.gms.internal.measurement.zzgi zzgiVar6 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf117);
                if (!zZzs2 && zZzs && (list3 = (List) map.get(numValueOf117)) != null && this.zze != null && this.zzd != null) {
                    for (com.google.android.gms.internal.measurement.zzek zzekVar6 : list3) {
                        int iZzb = zzekVar6.zzb();
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzekVar6.zzm()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        Integer numValueOf20 = Integer.valueOf(iZzb);
                        if (arrayMap.containsKey(numValueOf20)) {
                            arrayMap.put(numValueOf20, Long.valueOf(jLongValue));
                        }
                        if (arrayMap13.containsKey(numValueOf20)) {
                            arrayMap13.put(numValueOf20, Long.valueOf(jLongValue));
                        }
                    }
                }
                this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzgiVar6, bitSet, bitSet2, arrayMap, arrayMap13, null));
                str21 = str216;
                map = map;
                map3 = map10;
                map2 = map2;
            }
            str3 = str21;
        }
        str6 = str2;
        str7 = str22;
        if (!list.isEmpty()) {
            zzwVar = new zzw(this, null);
            arrayMap4 = new ArrayMap();
            it4 = list.iterator();
            while (it4.hasNext()) {
                zzftVar = (com.google.android.gms.internal.measurement.zzft) it4.next();
                zzftVarZza = zzwVar.zza(this.zza, zzftVar);
                if (zzftVarZza != null) {
                    zzakVarZzh = this.zzf.zzh();
                    str8 = this.zza;
                    strZzh = zzftVarZza.zzh();
                    zzaqVarZzn = zzakVarZzh.zzn(str8, zzftVar.zzh());
                    if (zzaqVarZzn == null) {
                        zzakVarZzh.zzt.zzaA().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzet.zzn(str8), zzakVarZzh.zzt.zzj().zzd(strZzh));
                        zzaqVar = new zzaq(str8, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                    } else {
                        zzaqVar = new zzaq(zzaqVarZzn.zza, zzaqVarZzn.zzb, zzaqVarZzn.zzc + 1, zzaqVarZzn.zzd + 1, zzaqVarZzn.zze + 1, zzaqVarZzn.zzf, zzaqVarZzn.zzg, zzaqVarZzn.zzh, zzaqVarZzn.zzi, zzaqVarZzn.zzj, zzaqVarZzn.zzk);
                    }
                    this.zzf.zzh().zzE(zzaqVar);
                    j = zzaqVar.zzc;
                    strZzh2 = zzftVarZza.zzh();
                    mapEmptyMap = (Map) arrayMap4.get(strZzh2);
                    if (mapEmptyMap == null) {
                        zzakVarZzh2 = this.zzf.zzh();
                        str9 = this.zza;
                        zzakVarZzh2.zzW();
                        zzakVarZzh2.zzg();
                        Preconditions.checkNotEmpty(str9);
                        Preconditions.checkNotEmpty(strZzh2);
                        arrayMap5 = new ArrayMap();
                        str10 = str6;
                        str11 = str7;
                        str7 = str11;
                        cursorQuery2 = zzakVarZzh2.zzh().query("event_filters", new String[]{str10, str11}, "app_id=? AND event_name=?", new String[]{str9, strZzh2}, null, null, null);
                        if (cursorQuery2.moveToFirst()) {
                            str6 = str10;
                            while (true) {
                                com.google.android.gms.internal.measurement.zzek zzekVar7 = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzlj.zzm(com.google.android.gms.internal.measurement.zzek.zzc(), cursorQuery2.getBlob(1))).zzaD();
                                numValueOf3 = Integer.valueOf(cursorQuery2.getInt(0));
                                list5 = (List) arrayMap5.get(numValueOf3);
                                if (list5 == null) {
                                    zzaqVar2 = zzaqVar;
                                    arrayList2 = new ArrayList();
                                    arrayMap5.put(numValueOf3, arrayList2);
                                } else {
                                    zzaqVar2 = zzaqVar;
                                    arrayList2 = list5;
                                }
                                arrayList2.add(zzekVar7);
                                if (!cursorQuery2.moveToNext()) {
                                    break;
                                    break;
                                }
                                zzaqVar = zzaqVar2;
                            }
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                            mapEmptyMap = arrayMap5;
                        } else {
                            zzaqVar2 = zzaqVar;
                            str6 = str10;
                            mapEmptyMap = Collections.emptyMap();
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                        }
                        arrayMap4.put(strZzh2, mapEmptyMap);
                    } else {
                        zzaqVar2 = zzaqVar;
                    }
                    it5 = mapEmptyMap.keySet().iterator();
                    while (it5.hasNext()) {
                        iIntValue2 = ((Integer) it5.next()).intValue();
                        set = this.zzb;
                        numValueOf2 = Integer.valueOf(iIntValue2);
                        if (set.contains(numValueOf2)) {
                            this.zzt.zzaA().zzj().zzb("Skipping failed audience ID", numValueOf2);
                        } else {
                            zZzd = true;
                            while (r5.hasNext()) {
                                zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j, zzaqVar2, zzf(iIntValue2, zzekVar3.zzb()));
                                if (!zZzd) {
                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                    break;
                                }
                                zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                            }
                            if (!zZzd) {
                                this.zzb.add(Integer.valueOf(iIntValue2));
                            }
                        }
                    }
                    zzwVar = zzwVar;
                    it4 = it4;
                    str18 = str18;
                }
            }
        }
        str12 = str18;
        if (!list2.isEmpty()) {
            arrayMap6 = new ArrayMap();
            it6 = list2.iterator();
            while (it6.hasNext()) {
                com.google.android.gms.internal.measurement.zzgm zzgmVar4 = (com.google.android.gms.internal.measurement.zzgm) it6.next();
                strZzf = zzgmVar4.zzf();
                mapEmptyMap2 = (Map) arrayMap6.get(strZzf);
                if (mapEmptyMap2 == null) {
                    zzakVarZzh3 = this.zzf.zzh();
                    str15 = this.zza;
                    zzakVarZzh3.zzW();
                    zzakVarZzh3.zzg();
                    Preconditions.checkNotEmpty(str15);
                    Preconditions.checkNotEmpty(strZzf);
                    arrayMap7 = new ArrayMap();
                    str13 = str6;
                    str14 = str7;
                    it7 = it6;
                    cursorQuery3 = zzakVarZzh3.zzh().query("property_filters", new String[]{str13, str14}, "app_id=? AND property_name=?", new String[]{str15, strZzf}, null, null, null);
                    if (cursorQuery3.moveToFirst()) {
                        do {
                            com.google.android.gms.internal.measurement.zzet zzetVar5 = (com.google.android.gms.internal.measurement.zzet) ((com.google.android.gms.internal.measurement.zzes) zzlj.zzm(com.google.android.gms.internal.measurement.zzet.zzc(), cursorQuery3.getBlob(1))).zzaD();
                            numValueOf7 = Integer.valueOf(cursorQuery3.getInt(0));
                            list6 = (List) arrayMap7.get(numValueOf7);
                            if (list6 == null) {
                                arrayList3 = new ArrayList();
                                arrayMap7.put(numValueOf7, arrayList3);
                            } else {
                                arrayList3 = list6;
                            }
                            arrayList3.add(zzetVar5);
                        } while (cursorQuery3.moveToNext());
                        if (cursorQuery3 != null) {
                            cursorQuery3.close();
                        }
                        mapEmptyMap2 = arrayMap7;
                    } else {
                        mapEmptyMap2 = Collections.emptyMap();
                        if (cursorQuery3 != null) {
                            cursorQuery3.close();
                        }
                    }
                    arrayMap6.put(strZzf, mapEmptyMap2);
                } else {
                    it7 = it6;
                    str13 = str6;
                    str14 = str7;
                }
                it8 = mapEmptyMap2.keySet().iterator();
                while (it8.hasNext()) {
                    iIntValue3 = ((Integer) it8.next()).intValue();
                    set2 = this.zzb;
                    numValueOf4 = Integer.valueOf(iIntValue3);
                    if (set2.contains(numValueOf4)) {
                        this.zzt.zzaA().zzj().zzb("Skipping failed audience ID", numValueOf4);
                        break;
                        break;
                    }
                    it9 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                    zZzd2 = true;
                    while (true) {
                        if (it9.hasNext()) {
                            zzetVar = (com.google.android.gms.internal.measurement.zzet) it9.next();
                            if (Log.isLoggable(this.zzt.zzaA().zzr(), 2)) {
                                zzer zzerVarZzj5 = this.zzt.zzaA().zzj();
                                Integer numValueOf118 = Integer.valueOf(iIntValue3);
                                if (zzetVar.zzj()) {
                                    numValueOf6 = Integer.valueOf(zzetVar.zza());
                                } else {
                                    numValueOf6 = null;
                                }
                                zzerVarZzj5.zzd("Evaluating filter. audience, filter, property", numValueOf118, numValueOf6, this.zzt.zzj().zzf(zzetVar.zze()));
                                this.zzt.zzaA().zzj().zzb("Filter definition", this.zzf.zzu().zzq(zzetVar));
                            }
                            if (zzetVar.zzj() || zzetVar.zza() > 256) {
                                zzer zzerVarZzk5 = this.zzt.zzaA().zzk();
                                Object objZzn5 = zzet.zzn(this.zza);
                                if (zzetVar.zzj()) {
                                    numValueOf5 = Integer.valueOf(zzetVar.zza());
                                } else {
                                    numValueOf5 = null;
                                }
                                zzerVarZzk5.zzc("Invalid property filter ID. appId, id", objZzn5, String.valueOf(numValueOf5));
                                this.zzb.add(Integer.valueOf(iIntValue3));
                                mapEmptyMap2 = mapEmptyMap2;
                            } else {
                                zzzVar = new zzz(this, this.zza, iIntValue3, zzetVar);
                                zZzd2 = zzzVar.zzd(this.zzd, this.zze, zzgmVar4, zzf(iIntValue3, zzetVar.zza()));
                                if (zZzd2) {
                                    zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                    mapEmptyMap2 = mapEmptyMap2;
                                } else {
                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                }
                            }
                        } else {
                            mapEmptyMap2 = mapEmptyMap2;
                        }
                        if (!zZzd2) {
                            this.zzb.add(Integer.valueOf(iIntValue3));
                        }
                        mapEmptyMap2 = mapEmptyMap2;
                    }
                }
                it6 = it7;
                str7 = str14;
                str6 = str13;
            }
        }
        str16 = str6;
        arrayList4 = new ArrayList();
        Set setKeySet4 = this.zzc.keySet();
        setKeySet4.removeAll(this.zzb);
        it10 = setKeySet4.iterator();
        while (it10.hasNext()) {
            int iIntValue11 = ((Integer) it10.next()).intValue();
            Map map11 = this.zzc;
            Integer numValueOf119 = Integer.valueOf(iIntValue11);
            zzu zzuVar4 = (zzu) map11.get(numValueOf119);
            Preconditions.checkNotNull(zzuVar4);
            com.google.android.gms.internal.measurement.zzfp zzfpVarZza4 = zzuVar4.zza(iIntValue11);
            arrayList4.add(zzfpVarZza4);
            zzakVarZzh4 = this.zzf.zzh();
            str17 = this.zza;
            com.google.android.gms.internal.measurement.zzgi zzgiVarZzd4 = zzfpVarZza4.zzd();
            zzakVarZzh4.zzW();
            zzakVarZzh4.zzg();
            Preconditions.checkNotEmpty(str17);
            Preconditions.checkNotNull(zzgiVarZzd4);
            byte[] bArrZzbx4 = zzgiVarZzd4.zzbx();
            contentValues = new ContentValues();
            contentValues.put("app_id", str17);
            contentValues.put(str16, numValueOf119);
            String str217 = str12;
            contentValues.put(str217, bArrZzbx4);
            if (zzakVarZzh4.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                zzakVarZzh4.zzt.zzaA().zzd().zzb("Failed to insert filter results (got -1). appId", zzet.zzn(str17));
            }
            str12 = str217;
        }
        return arrayList4;
    }

    @Override // com.google.android.gms.measurement.internal.zzku
    protected final boolean zzb() {
        return false;
    }
}
