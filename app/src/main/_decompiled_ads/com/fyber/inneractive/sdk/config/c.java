package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.Track;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.util.IAlog;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.fyber.inneractive.sdk.cache.a<IAConfigManager.c> {
    public boolean a = false;

    @Override // com.fyber.inneractive.sdk.cache.a
    public String a() {
        String str = IAConfigManager.M.c;
        StringBuilder sb = new StringBuilder("https://");
        int i = f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.baseConfigUrl");
        if (TextUtils.isEmpty(property)) {
            sb.append("cdn2.inner-active.mobi/ia-sdk-config/apps/");
        } else {
            sb.append(property);
        }
        String string = sb.append(str).append('/').append(str).append(".json").toString();
        int i2 = IAlog.a;
        IAlog.a(1, null, "%s: %s", "APP_CONFIG_REQUEST", string);
        return string;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public String b() {
        return "IALastModifiedFromHeader";
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public String c() {
        return "inneractive.config";
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public boolean d() {
        String string = com.fyber.inneractive.sdk.util.l.a.getSharedPreferences("IAConfigurationPreferences", 0).getString("cached.config.appid", null);
        return string != null && string.equalsIgnoreCase(IAConfigManager.M.c);
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public void a(IAConfigManager.c cVar) {
        IAConfigManager.c cVar2 = cVar;
        if (cVar2 == null || cVar2.a == null) {
            return;
        }
        com.fyber.inneractive.sdk.util.l.a.getSharedPreferences("IAConfigurationPreferences", 0).edit().putString("cached.config.appid", cVar2.a).apply();
    }

    public final void a(Throwable th, String str) {
        String strSubstring;
        String name;
        String localizedMessage;
        if (this.a) {
            return;
        }
        this.a = true;
        if (TextUtils.isEmpty(str)) {
            strSubstring = "Empty Json Data";
        } else {
            strSubstring = str.substring(0, str.length() > 501 ? 500 : str.length() - 1);
        }
        if (th != null) {
            name = th.getClass().getName();
            localizedMessage = th.getLocalizedMessage();
        } else {
            name = "Bad remote configuration";
            localizedMessage = "Internal error";
        }
        String str2 = IAConfigManager.M.c;
        com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(com.fyber.inneractive.sdk.network.q.FATAL_CONFIGURATION_ERROR);
        Object[] objArr = new Object[8];
        objArr[0] = "exception";
        objArr[1] = name;
        objArr[2] = "message";
        if (localizedMessage == null) {
            localizedMessage = "No message";
        }
        objArr[3] = localizedMessage;
        objArr[4] = "data";
        objArr[5] = strSubstring;
        objArr[6] = "appId";
        if (TextUtils.isEmpty(str2)) {
            str2 = "EMPTY_APP_ID";
        }
        objArr[7] = str2;
        aVar.a(objArr).a((String) null);
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01da  */
    /* JADX WARN: Code duplicated, block: B:115:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:116:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:119:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:120:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:125:0x0214  */
    /* JADX WARN: Code duplicated, block: B:126:0x0217  */
    /* JADX WARN: Code duplicated, block: B:129:0x021e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0221  */
    /* JADX WARN: Code duplicated, block: B:133:0x023c  */
    /* JADX WARN: Code duplicated, block: B:134:0x023f  */
    /* JADX WARN: Code duplicated, block: B:137:0x0245  */
    /* JADX WARN: Code duplicated, block: B:138:0x0248  */
    /* JADX WARN: Code duplicated, block: B:141:0x0258  */
    /* JADX WARN: Code duplicated, block: B:142:0x025a  */
    /* JADX WARN: Code duplicated, block: B:145:0x0270  */
    /* JADX WARN: Code duplicated, block: B:146:0x0273  */
    /* JADX WARN: Code duplicated, block: B:149:0x0279  */
    /* JADX WARN: Code duplicated, block: B:150:0x027c  */
    /* JADX WARN: Code duplicated, block: B:153:0x0294  */
    /* JADX WARN: Code duplicated, block: B:154:0x0297  */
    /* JADX WARN: Code duplicated, block: B:157:0x029d  */
    /* JADX WARN: Code duplicated, block: B:158:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:161:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:162:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:165:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:166:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:169:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:170:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:173:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:174:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:177:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:178:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:181:0x0314  */
    /* JADX WARN: Code duplicated, block: B:184:0x0324  */
    /* JADX WARN: Code duplicated, block: B:185:0x0327  */
    /* JADX WARN: Code duplicated, block: B:188:0x032d  */
    /* JADX WARN: Code duplicated, block: B:189:0x0330  */
    /* JADX WARN: Code duplicated, block: B:192:0x0348  */
    /* JADX WARN: Code duplicated, block: B:193:0x034b  */
    /* JADX WARN: Code duplicated, block: B:196:0x0351  */
    /* JADX WARN: Code duplicated, block: B:197:0x0354  */
    /* JADX WARN: Code duplicated, block: B:200:0x036d  */
    /* JADX WARN: Code duplicated, block: B:202:0x0375  */
    /* JADX WARN: Code duplicated, block: B:213:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:214:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:217:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:218:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:221:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:222:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:225:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:226:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:229:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:230:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:233:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:234:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:241:0x041b  */
    /* JADX WARN: Code duplicated, block: B:244:0x0427  */
    /* JADX WARN: Code duplicated, block: B:245:0x042a  */
    /* JADX WARN: Code duplicated, block: B:248:0x042f  */
    /* JADX WARN: Code duplicated, block: B:249:0x0432  */
    /* JADX WARN: Code duplicated, block: B:252:0x0438  */
    /* JADX WARN: Code duplicated, block: B:253:0x043b  */
    /* JADX WARN: Code duplicated, block: B:260:0x045a  */
    /* JADX WARN: Code duplicated, block: B:263:0x0466  */
    /* JADX WARN: Code duplicated, block: B:264:0x0469  */
    /* JADX WARN: Code duplicated, block: B:267:0x046f  */
    /* JADX WARN: Code duplicated, block: B:268:0x0473  */
    /* JADX WARN: Code duplicated, block: B:271:0x0479  */
    /* JADX WARN: Code duplicated, block: B:272:0x047d  */
    /* JADX WARN: Code duplicated, block: B:279:0x0499  */
    /* JADX WARN: Code duplicated, block: B:297:0x0397 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:298:0x01ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:303:0x038b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x0382 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x009c  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:57:0x010b  */
    /* JADX WARN: Code duplicated, block: B:58:0x010e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0115  */
    /* JADX WARN: Code duplicated, block: B:62:0x0118  */
    /* JADX WARN: Code duplicated, block: B:65:0x0138  */
    /* JADX WARN: Code duplicated, block: B:66:0x013b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0141  */
    /* JADX WARN: Code duplicated, block: B:70:0x0144  */
    /* JADX WARN: Code duplicated, block: B:88:0x017d  */
    /* JADX WARN: Code duplicated, block: B:91:0x0187  */
    public IAConfigManager.c a(com.fyber.inneractive.sdk.config.remote.e eVar) {
        boolean z;
        com.fyber.inneractive.sdk.config.remote.b bVar;
        Iterator<com.fyber.inneractive.sdk.config.remote.h> it;
        Iterator<com.fyber.inneractive.sdk.config.remote.i> it2;
        com.fyber.inneractive.sdk.config.remote.j jVar;
        Map<String, z> map;
        com.fyber.inneractive.sdk.config.remote.f fVar;
        Set<Track> set;
        com.fyber.inneractive.sdk.config.remote.f fVar2;
        Set<Track> set2;
        com.fyber.inneractive.sdk.config.remote.f fVar3;
        Set<Track> set3;
        e0 e0Var;
        com.fyber.inneractive.sdk.config.remote.k kVar;
        com.fyber.inneractive.sdk.config.remote.k kVar2;
        com.fyber.inneractive.sdk.config.remote.k kVar3;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        Set<Vendor> set4;
        char c;
        Set<Vendor> set5;
        char c2;
        Set<Vendor> set6;
        Set<Vendor> set7;
        UnitDisplayType unitDisplayType;
        UnitDisplayType unitDisplayType2;
        c0 c0Var;
        com.fyber.inneractive.sdk.config.remote.j jVar2;
        com.fyber.inneractive.sdk.config.remote.j jVar3;
        com.fyber.inneractive.sdk.config.remote.j jVar4;
        UnitDisplayType unitDisplayType3;
        Boolean bool;
        Boolean bool2;
        Object objA;
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        int iIntValue;
        Boolean bool3;
        Boolean bool4;
        Orientation orientation;
        Orientation orientation2;
        Integer num14;
        Integer num15;
        Integer num16;
        int iIntValue2;
        Integer num17;
        Integer num18;
        Integer num19;
        Skip skip;
        Skip skip2;
        TapAction tapAction;
        int i;
        TapAction tapAction2;
        com.fyber.inneractive.sdk.config.remote.d[] dVarArr;
        int i2;
        com.fyber.inneractive.sdk.config.remote.j jVarA;
        List<Integer> list;
        UnitDisplayType unitDisplayType4;
        com.fyber.inneractive.sdk.config.remote.b bVar2;
        com.fyber.inneractive.sdk.config.remote.b bVar3;
        t tVar;
        UnitDisplayType unitDisplayType5;
        Integer num20;
        Integer num21;
        Integer num22;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Integer num23;
        Integer num24;
        Integer num25;
        UnitDisplayType unitDisplayType6;
        String strB;
        com.fyber.inneractive.sdk.config.remote.e eVar2 = eVar;
        IAConfigManager.c cVar = new IAConfigManager.c();
        cVar.c = eVar2.c;
        com.fyber.inneractive.sdk.config.remote.a aVar = eVar2.a;
        cVar.f865b = aVar.f891b;
        cVar.a = aVar.a;
        Iterator<com.fyber.inneractive.sdk.config.remote.h> it3 = eVar2.f893b.iterator();
        while (it3.hasNext()) {
            com.fyber.inneractive.sdk.config.remote.h next = it3.next();
            Map<String, z> map2 = cVar.d;
            String str = next.a;
            com.fyber.inneractive.sdk.config.remote.a aVar2 = eVar2.a;
            Map<String, a0> map3 = cVar.e;
            IAConfigManager.e eVar3 = cVar.f;
            z zVar = new z();
            int i3 = 2;
            com.fyber.inneractive.sdk.config.remote.c[] cVarArr = {aVar2, next};
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z = true;
                    break;
                }
                com.fyber.inneractive.sdk.config.remote.c cVar2 = cVarArr[i4];
                if (cVar2 != null && (strB = cVar2.b()) != null && strB.equals(TJAdUnitConstants.String.FALSE)) {
                    z = false;
                    break;
                }
                i4++;
                i3 = 2;
            }
            zVar.f901b = z;
            Iterator<com.fyber.inneractive.sdk.config.remote.i> it4 = next.g.iterator();
            while (it4.hasNext()) {
                com.fyber.inneractive.sdk.config.remote.i next2 = it4.next();
                a0 a0Var = new a0();
                String str2 = next2.a;
                if (str2 != null) {
                    String str3 = next2.f895b;
                    if (str3 != null) {
                        a0Var.a = str2;
                        a0Var.f866b = str3;
                        com.fyber.inneractive.sdk.config.remote.g gVar = next2.e;
                        if (gVar != null) {
                            y yVar = new y();
                            UnitDisplayType unitDisplayType7 = gVar.a;
                            if (unitDisplayType7 == UnitDisplayType.DEFAULT) {
                                yVar.a = unitDisplayType7;
                                a0Var.e = yVar;
                                bVar = next2.c;
                                if (bVar != null) {
                                    bVar2 = next.c;
                                    bVar3 = aVar2.e;
                                    tVar = new t();
                                    it = it3;
                                    unitDisplayType5 = bVar.a;
                                    it2 = it4;
                                    if (unitDisplayType5 != UnitDisplayType.BANNER || unitDisplayType5 == UnitDisplayType.MRECT || unitDisplayType5.isFullscreenUnit()) {
                                        tVar.f899b = bVar.a;
                                        Object[] objArr = new Object[3];
                                        objArr[0] = bVar.c;
                                        if (bVar2 != null) {
                                            num20 = bVar2.c;
                                        } else {
                                            num20 = null;
                                        }
                                        objArr[1] = num20;
                                        if (bVar3 != null) {
                                            num21 = bVar3.c;
                                        } else {
                                            num21 = null;
                                        }
                                        objArr[2] = num21;
                                        num22 = (Integer) a((Object) null, objArr);
                                        if (num22 != null && num22.intValue() >= 5 && num22.intValue() <= 60) {
                                            tVar.a = num22;
                                        }
                                        bool5 = Boolean.TRUE;
                                        Object[] objArr2 = new Object[3];
                                        objArr2[0] = bVar.f892b;
                                        if (bVar2 != null) {
                                            bool6 = bVar2.f892b;
                                        } else {
                                            bool6 = null;
                                        }
                                        objArr2[1] = bool6;
                                        if (bVar3 != null) {
                                            bool7 = bVar3.f892b;
                                        } else {
                                            bool7 = null;
                                        }
                                        objArr2[2] = bool7;
                                        tVar.c = Boolean.valueOf(((Boolean) a(bool5, objArr2)).booleanValue());
                                        Object[] objArr3 = new Object[3];
                                        objArr3[0] = bVar.d;
                                        if (bVar2 != null) {
                                            num23 = bVar2.d;
                                        } else {
                                            num23 = null;
                                        }
                                        objArr3[1] = num23;
                                        if (bVar3 != null) {
                                            num24 = bVar3.d;
                                        } else {
                                            num24 = null;
                                        }
                                        objArr3[2] = num24;
                                        num25 = (Integer) a((Object) null, objArr3);
                                        if (num25 != null && num25.intValue() >= 5 && num25.intValue() <= 60) {
                                            tVar.d = num25;
                                        }
                                        if (tVar.d == null && !tVar.c.booleanValue() && ((unitDisplayType6 = bVar.a) == UnitDisplayType.INTERSTITIAL || unitDisplayType6 == UnitDisplayType.REWARDED)) {
                                            tVar.c = bool5;
                                        }
                                        a0Var.c = tVar;
                                    } else {
                                        it3 = it;
                                        it4 = it2;
                                    }
                                } else {
                                    it = it3;
                                    it2 = it4;
                                }
                                jVar = next2.f;
                                if (jVar != null) {
                                    unitDisplayType = jVar.j;
                                    unitDisplayType2 = UnitDisplayType.REWARDED;
                                    if (unitDisplayType == unitDisplayType2 && next2.c == null) {
                                        t tVar2 = new t();
                                        a0Var.c = tVar2;
                                        tVar2.c = Boolean.FALSE;
                                        tVar2.d = -1;
                                        t tVar3 = a0Var.c;
                                        tVar3.f899b = unitDisplayType2;
                                        tVar3.a = -1;
                                    }
                                    c0Var = new c0();
                                    jVar2 = next2.f;
                                    jVar3 = next.e;
                                    jVar4 = aVar2.d;
                                    unitDisplayType3 = jVar2.j;
                                    if (unitDisplayType3 != UnitDisplayType.LANDSCAPE || unitDisplayType3 == UnitDisplayType.SQUARE || unitDisplayType3 == (unitDisplayType4 = UnitDisplayType.INTERSTITIAL)) {
                                        map = map2;
                                    } else {
                                        map = map2;
                                        if (unitDisplayType3 != UnitDisplayType.VERTICAL && unitDisplayType3 != unitDisplayType2 && unitDisplayType3 != UnitDisplayType.MRECT) {
                                            if (a0Var.e != null) {
                                                c0Var.j = unitDisplayType4;
                                            }
                                            it3 = it;
                                            it4 = it2;
                                            map2 = map;
                                            cVar = cVar;
                                        }
                                        Object[] objArr4 = new Object[3];
                                        objArr4[0] = jVar2.a;
                                        if (jVar3 != null) {
                                            bool = jVar3.a;
                                        } else {
                                            bool = null;
                                        }
                                        objArr4[1] = bool;
                                        if (jVar4 != null) {
                                            bool2 = jVar4.a;
                                        } else {
                                            bool2 = null;
                                        }
                                        objArr4[2] = bool2;
                                        objA = a((Object) null, objArr4);
                                        if (objA != null) {
                                            c0Var.a = (Boolean) objA;
                                            Object[] objArr5 = new Object[3];
                                            objArr5[0] = jVar2.f896b;
                                            if (jVar3 != null) {
                                                num9 = jVar3.f896b;
                                            } else {
                                                num9 = null;
                                            }
                                            objArr5[1] = num9;
                                            if (jVar4 != null) {
                                                num10 = jVar4.f896b;
                                            } else {
                                                num10 = null;
                                            }
                                            objArr5[2] = num10;
                                            c0Var.f868b = (Integer) a((Object) 5000, objArr5);
                                            Object[] objArr6 = new Object[3];
                                            objArr6[0] = jVar2.c;
                                            if (jVar3 != null) {
                                                num11 = jVar3.c;
                                            } else {
                                                num11 = null;
                                            }
                                            objArr6[1] = num11;
                                            if (jVar4 != null) {
                                                num12 = jVar4.c;
                                            } else {
                                                num12 = null;
                                            }
                                            objArr6[2] = num12;
                                            num13 = (Integer) a((Object) 0, objArr6);
                                            if (num13.intValue() < 0) {
                                                iIntValue = 0;
                                            } else {
                                                iIntValue = num13.intValue();
                                            }
                                            c0Var.c = Integer.valueOf(iIntValue);
                                            Boolean bool8 = Boolean.TRUE;
                                            Object[] objArr7 = new Object[3];
                                            objArr7[0] = jVar2.e;
                                            if (jVar3 != null) {
                                                bool3 = jVar3.e;
                                            } else {
                                                bool3 = null;
                                            }
                                            objArr7[1] = bool3;
                                            if (jVar4 != null) {
                                                bool4 = jVar4.e;
                                            } else {
                                                bool4 = null;
                                            }
                                            objArr7[2] = bool4;
                                            c0Var.d = (Boolean) a(bool8, objArr7);
                                            Orientation orientation3 = Orientation.USER;
                                            Object[] objArr8 = new Object[3];
                                            objArr8[0] = jVar2.g;
                                            if (jVar3 != null) {
                                                orientation = jVar3.g;
                                            } else {
                                                orientation = null;
                                            }
                                            objArr8[1] = orientation;
                                            if (jVar4 != null) {
                                                orientation2 = jVar4.g;
                                            } else {
                                                orientation2 = null;
                                            }
                                            objArr8[2] = orientation2;
                                            c0Var.e = (Orientation) a(orientation3, objArr8);
                                            Object[] objArr9 = new Object[3];
                                            objArr9[0] = jVar2.i;
                                            if (jVar3 != null) {
                                                num14 = jVar3.i;
                                            } else {
                                                num14 = null;
                                            }
                                            objArr9[1] = num14;
                                            if (jVar4 != null) {
                                                num15 = jVar4.i;
                                            } else {
                                                num15 = null;
                                            }
                                            objArr9[2] = num15;
                                            num16 = (Integer) a((Object) 0, objArr9);
                                            if (num16.intValue() < 0) {
                                                iIntValue2 = 0;
                                            } else {
                                                iIntValue2 = num16.intValue();
                                            }
                                            c0Var.f = Integer.valueOf(iIntValue2);
                                            Object[] objArr10 = new Object[3];
                                            objArr10[0] = jVar2.h;
                                            if (jVar3 != null) {
                                                num17 = jVar3.h;
                                            } else {
                                                num17 = null;
                                            }
                                            objArr10[1] = num17;
                                            if (jVar4 != null) {
                                                num18 = jVar4.h;
                                            } else {
                                                num18 = null;
                                            }
                                            objArr10[2] = num18;
                                            num19 = (Integer) a((Object) 2048, objArr10);
                                            if (num19.intValue() > c0Var.f868b.intValue()) {
                                                num19 = c0Var.f868b;
                                            }
                                            c0Var.g = num19;
                                            Skip skip3 = Skip._0;
                                            Object[] objArr11 = new Object[3];
                                            objArr11[0] = jVar2.d;
                                            if (jVar3 != null) {
                                                skip = jVar3.d;
                                            } else {
                                                skip = null;
                                            }
                                            objArr11[1] = skip;
                                            if (jVar4 != null) {
                                                skip2 = jVar4.d;
                                            } else {
                                                skip2 = null;
                                            }
                                            objArr11[2] = skip2;
                                            c0Var.h = (Skip) a(skip3, objArr11);
                                            TapAction tapAction3 = TapAction.DO_NOTHING;
                                            Object[] objArr12 = new Object[3];
                                            objArr12[0] = jVar2.f;
                                            if (jVar3 != null) {
                                                tapAction = jVar3.f;
                                            } else {
                                                tapAction = null;
                                            }
                                            objArr12[1] = tapAction;
                                            if (jVar4 != null) {
                                                tapAction2 = jVar4.f;
                                            } else {
                                                tapAction2 = null;
                                            }
                                            objArr12[2] = tapAction2;
                                            c0Var.i = (TapAction) a(tapAction3, objArr12);
                                            List<Integer> arrayList = new ArrayList<>();
                                            dVarArr = new com.fyber.inneractive.sdk.config.remote.d[]{next2};
                                            i2 = 0;
                                            for (i = 1; i2 < i; i = 1) {
                                                jVarA = dVarArr[i2].a();
                                                if (jVarA == null && (list = jVarA.k) != null && list.size() > 0) {
                                                    arrayList = jVarA.k;
                                                    break;
                                                }
                                                i2++;
                                            }
                                            c0Var.k = arrayList;
                                            a0Var.f = c0Var;
                                        } else {
                                            it3 = it;
                                            it4 = it2;
                                            map2 = map;
                                            cVar = cVar;
                                        }
                                    }
                                    c0Var.j = unitDisplayType3;
                                    Object[] objArr13 = new Object[3];
                                    objArr13[0] = jVar2.a;
                                    if (jVar3 != null) {
                                        bool = jVar3.a;
                                    } else {
                                        bool = null;
                                    }
                                    objArr13[1] = bool;
                                    if (jVar4 != null) {
                                        bool2 = jVar4.a;
                                    } else {
                                        bool2 = null;
                                    }
                                    objArr13[2] = bool2;
                                    objA = a((Object) null, objArr13);
                                    if (objA != null) {
                                        c0Var.a = (Boolean) objA;
                                        Object[] objArr14 = new Object[3];
                                        objArr14[0] = jVar2.f896b;
                                        if (jVar3 != null) {
                                            num9 = jVar3.f896b;
                                        } else {
                                            num9 = null;
                                        }
                                        objArr14[1] = num9;
                                        if (jVar4 != null) {
                                            num10 = jVar4.f896b;
                                        } else {
                                            num10 = null;
                                        }
                                        objArr14[2] = num10;
                                        c0Var.f868b = (Integer) a((Object) 5000, objArr14);
                                        Object[] objArr15 = new Object[3];
                                        objArr15[0] = jVar2.c;
                                        if (jVar3 != null) {
                                            num11 = jVar3.c;
                                        } else {
                                            num11 = null;
                                        }
                                        objArr15[1] = num11;
                                        if (jVar4 != null) {
                                            num12 = jVar4.c;
                                        } else {
                                            num12 = null;
                                        }
                                        objArr15[2] = num12;
                                        num13 = (Integer) a((Object) 0, objArr15);
                                        if (num13.intValue() < 0) {
                                            iIntValue = 0;
                                        } else {
                                            iIntValue = num13.intValue();
                                        }
                                        c0Var.c = Integer.valueOf(iIntValue);
                                        Boolean bool9 = Boolean.TRUE;
                                        Object[] objArr16 = new Object[3];
                                        objArr16[0] = jVar2.e;
                                        if (jVar3 != null) {
                                            bool3 = jVar3.e;
                                        } else {
                                            bool3 = null;
                                        }
                                        objArr16[1] = bool3;
                                        if (jVar4 != null) {
                                            bool4 = jVar4.e;
                                        } else {
                                            bool4 = null;
                                        }
                                        objArr16[2] = bool4;
                                        c0Var.d = (Boolean) a(bool9, objArr16);
                                        Orientation orientation4 = Orientation.USER;
                                        Object[] objArr17 = new Object[3];
                                        objArr17[0] = jVar2.g;
                                        if (jVar3 != null) {
                                            orientation = jVar3.g;
                                        } else {
                                            orientation = null;
                                        }
                                        objArr17[1] = orientation;
                                        if (jVar4 != null) {
                                            orientation2 = jVar4.g;
                                        } else {
                                            orientation2 = null;
                                        }
                                        objArr17[2] = orientation2;
                                        c0Var.e = (Orientation) a(orientation4, objArr17);
                                        Object[] objArr18 = new Object[3];
                                        objArr18[0] = jVar2.i;
                                        if (jVar3 != null) {
                                            num14 = jVar3.i;
                                        } else {
                                            num14 = null;
                                        }
                                        objArr18[1] = num14;
                                        if (jVar4 != null) {
                                            num15 = jVar4.i;
                                        } else {
                                            num15 = null;
                                        }
                                        objArr18[2] = num15;
                                        num16 = (Integer) a((Object) 0, objArr18);
                                        if (num16.intValue() < 0) {
                                            iIntValue2 = 0;
                                        } else {
                                            iIntValue2 = num16.intValue();
                                        }
                                        c0Var.f = Integer.valueOf(iIntValue2);
                                        Object[] objArr19 = new Object[3];
                                        objArr19[0] = jVar2.h;
                                        if (jVar3 != null) {
                                            num17 = jVar3.h;
                                        } else {
                                            num17 = null;
                                        }
                                        objArr19[1] = num17;
                                        if (jVar4 != null) {
                                            num18 = jVar4.h;
                                        } else {
                                            num18 = null;
                                        }
                                        objArr19[2] = num18;
                                        num19 = (Integer) a((Object) 2048, objArr19);
                                        if (num19.intValue() > c0Var.f868b.intValue()) {
                                            num19 = c0Var.f868b;
                                        }
                                        c0Var.g = num19;
                                        Skip skip4 = Skip._0;
                                        Object[] objArr110 = new Object[3];
                                        objArr110[0] = jVar2.d;
                                        if (jVar3 != null) {
                                            skip = jVar3.d;
                                        } else {
                                            skip = null;
                                        }
                                        objArr110[1] = skip;
                                        if (jVar4 != null) {
                                            skip2 = jVar4.d;
                                        } else {
                                            skip2 = null;
                                        }
                                        objArr110[2] = skip2;
                                        c0Var.h = (Skip) a(skip4, objArr110);
                                        TapAction tapAction4 = TapAction.DO_NOTHING;
                                        Object[] objArr111 = new Object[3];
                                        objArr111[0] = jVar2.f;
                                        if (jVar3 != null) {
                                            tapAction = jVar3.f;
                                        } else {
                                            tapAction = null;
                                        }
                                        objArr111[1] = tapAction;
                                        if (jVar4 != null) {
                                            tapAction2 = jVar4.f;
                                        } else {
                                            tapAction2 = null;
                                        }
                                        objArr111[2] = tapAction2;
                                        c0Var.i = (TapAction) a(tapAction4, objArr111);
                                        List<Integer> arrayList2 = new ArrayList<>();
                                        dVarArr = new com.fyber.inneractive.sdk.config.remote.d[]{next2};
                                        i2 = 0;
                                        while (i2 < i) {
                                            jVarA = dVarArr[i2].a();
                                            if (jVarA == null) {
                                            }
                                            i2++;
                                        }
                                        c0Var.k = arrayList2;
                                        a0Var.f = c0Var;
                                    } else {
                                        it3 = it;
                                        it4 = it2;
                                        map2 = map;
                                        cVar = cVar;
                                    }
                                } else {
                                    map = map2;
                                }
                                x xVar = new x();
                                HashSet hashSet = new HashSet();
                                Object[] objArr20 = new Object[3];
                                fVar = next2.d;
                                if (fVar != null) {
                                    set = fVar.a;
                                } else {
                                    set = null;
                                }
                                objArr20[0] = set;
                                fVar2 = next.d;
                                if (fVar2 != null) {
                                    set2 = fVar2.a;
                                } else {
                                    set2 = null;
                                }
                                objArr20[1] = set2;
                                fVar3 = aVar2.c;
                                if (fVar3 != null) {
                                    set3 = fVar3.a;
                                } else {
                                    set3 = null;
                                }
                                objArr20[2] = set3;
                                xVar.a = (Set) a(hashSet, objArr20);
                                a0Var.d = xVar;
                                e0Var = new e0();
                                kVar = next2.g;
                                kVar2 = next.f;
                                kVar3 = aVar2.f;
                                Object[] objArr21 = new Object[3];
                                if (kVar != null) {
                                    num = kVar.a;
                                } else {
                                    num = null;
                                }
                                objArr21[0] = num;
                                if (kVar2 != null) {
                                    num2 = kVar2.a;
                                } else {
                                    num2 = null;
                                }
                                objArr21[1] = num2;
                                if (kVar3 != null) {
                                    num3 = kVar3.a;
                                } else {
                                    num3 = null;
                                }
                                objArr21[2] = num3;
                                num4 = (Integer) a((Object) 1, objArr21);
                                if (num4.intValue() > 0 && num4.intValue() > 100) {
                                    e0Var.a = 1;
                                } else {
                                    e0Var.a = num4;
                                }
                                Object[] objArr22 = new Object[3];
                                if (kVar != null) {
                                    num5 = kVar.f897b;
                                } else {
                                    num5 = null;
                                }
                                objArr22[0] = num5;
                                if (kVar2 != null) {
                                    num6 = kVar2.f897b;
                                } else {
                                    num6 = null;
                                }
                                objArr22[1] = num6;
                                if (kVar3 != null) {
                                    num7 = kVar3.f897b;
                                } else {
                                    num7 = null;
                                }
                                objArr22[2] = num7;
                                num8 = (Integer) a((Object) 0, objArr22);
                                if (num8.intValue() >= 0 && num8.intValue() > 100) {
                                    e0Var.f871b = 0;
                                } else {
                                    e0Var.f871b = num8;
                                }
                                HashSet hashSet2 = new HashSet();
                                Object[] objArr23 = new Object[3];
                                if (kVar != null) {
                                    set4 = kVar.c;
                                } else {
                                    set4 = null;
                                }
                                objArr23[0] = set4;
                                if (kVar2 != null) {
                                    set5 = kVar2.c;
                                    c = 1;
                                } else {
                                    c = 1;
                                    set5 = null;
                                }
                                objArr23[c] = set5;
                                if (kVar3 != null) {
                                    set6 = kVar3.c;
                                    c2 = 2;
                                } else {
                                    c2 = 2;
                                    set6 = null;
                                }
                                objArr23[c2] = set6;
                                set7 = (Set) a(hashSet2, objArr23);
                                e0Var.c = set7;
                                a0Var.g = e0Var;
                                if (eVar3 != null && set7 != null) {
                                    for (Vendor vendor : set7) {
                                        if (vendor == null && !eVar3.a.contains(vendor)) {
                                            eVar3.a.add(vendor);
                                        }
                                    }
                                }
                                zVar.a.add(a0Var);
                                map3.put(a0Var.a, a0Var);
                                it3 = it;
                                it4 = it2;
                                map2 = map;
                                cVar = cVar;
                            }
                        } else {
                            bVar = next2.c;
                            if (bVar != null) {
                                bVar2 = next.c;
                                bVar3 = aVar2.e;
                                tVar = new t();
                                it = it3;
                                unitDisplayType5 = bVar.a;
                                it2 = it4;
                                if (unitDisplayType5 != UnitDisplayType.BANNER) {
                                }
                                tVar.f899b = bVar.a;
                                Object[] objArr24 = new Object[3];
                                objArr24[0] = bVar.c;
                                if (bVar2 != null) {
                                    num20 = bVar2.c;
                                } else {
                                    num20 = null;
                                }
                                objArr24[1] = num20;
                                if (bVar3 != null) {
                                    num21 = bVar3.c;
                                } else {
                                    num21 = null;
                                }
                                objArr24[2] = num21;
                                num22 = (Integer) a((Object) null, objArr24);
                                if (num22 != null) {
                                    tVar.a = num22;
                                }
                                bool5 = Boolean.TRUE;
                                Object[] objArr25 = new Object[3];
                                objArr25[0] = bVar.f892b;
                                if (bVar2 != null) {
                                    bool6 = bVar2.f892b;
                                } else {
                                    bool6 = null;
                                }
                                objArr25[1] = bool6;
                                if (bVar3 != null) {
                                    bool7 = bVar3.f892b;
                                } else {
                                    bool7 = null;
                                }
                                objArr25[2] = bool7;
                                tVar.c = Boolean.valueOf(((Boolean) a(bool5, objArr25)).booleanValue());
                                Object[] objArr26 = new Object[3];
                                objArr26[0] = bVar.d;
                                if (bVar2 != null) {
                                    num23 = bVar2.d;
                                } else {
                                    num23 = null;
                                }
                                objArr26[1] = num23;
                                if (bVar3 != null) {
                                    num24 = bVar3.d;
                                } else {
                                    num24 = null;
                                }
                                objArr26[2] = num24;
                                num25 = (Integer) a((Object) null, objArr26);
                                if (num25 != null) {
                                    tVar.d = num25;
                                }
                                if (tVar.d == null) {
                                    tVar.c = bool5;
                                }
                                a0Var.c = tVar;
                            } else {
                                it = it3;
                                it2 = it4;
                            }
                            jVar = next2.f;
                            if (jVar != null) {
                                unitDisplayType = jVar.j;
                                unitDisplayType2 = UnitDisplayType.REWARDED;
                                if (unitDisplayType == unitDisplayType2) {
                                    t tVar4 = new t();
                                    a0Var.c = tVar4;
                                    tVar4.c = Boolean.FALSE;
                                    tVar4.d = -1;
                                    t tVar5 = a0Var.c;
                                    tVar5.f899b = unitDisplayType2;
                                    tVar5.a = -1;
                                }
                                c0Var = new c0();
                                jVar2 = next2.f;
                                jVar3 = next.e;
                                jVar4 = aVar2.d;
                                unitDisplayType3 = jVar2.j;
                                if (unitDisplayType3 != UnitDisplayType.LANDSCAPE) {
                                    map = map2;
                                    c0Var.j = unitDisplayType3;
                                    Object[] objArr112 = new Object[3];
                                    objArr112[0] = jVar2.a;
                                    if (jVar3 != null) {
                                        bool = jVar3.a;
                                    } else {
                                        bool = null;
                                    }
                                    objArr112[1] = bool;
                                    if (jVar4 != null) {
                                        bool2 = jVar4.a;
                                    } else {
                                        bool2 = null;
                                    }
                                    objArr112[2] = bool2;
                                    objA = a((Object) null, objArr112);
                                    if (objA != null) {
                                        c0Var.a = (Boolean) objA;
                                        Object[] objArr113 = new Object[3];
                                        objArr113[0] = jVar2.f896b;
                                        if (jVar3 != null) {
                                            num9 = jVar3.f896b;
                                        } else {
                                            num9 = null;
                                        }
                                        objArr113[1] = num9;
                                        if (jVar4 != null) {
                                            num10 = jVar4.f896b;
                                        } else {
                                            num10 = null;
                                        }
                                        objArr113[2] = num10;
                                        c0Var.f868b = (Integer) a((Object) 5000, objArr113);
                                        Object[] objArr114 = new Object[3];
                                        objArr114[0] = jVar2.c;
                                        if (jVar3 != null) {
                                            num11 = jVar3.c;
                                        } else {
                                            num11 = null;
                                        }
                                        objArr114[1] = num11;
                                        if (jVar4 != null) {
                                            num12 = jVar4.c;
                                        } else {
                                            num12 = null;
                                        }
                                        objArr114[2] = num12;
                                        num13 = (Integer) a((Object) 0, objArr114);
                                        if (num13.intValue() < 0) {
                                            iIntValue = 0;
                                        } else {
                                            iIntValue = num13.intValue();
                                        }
                                        c0Var.c = Integer.valueOf(iIntValue);
                                        Boolean bool10 = Boolean.TRUE;
                                        Object[] objArr115 = new Object[3];
                                        objArr115[0] = jVar2.e;
                                        if (jVar3 != null) {
                                            bool3 = jVar3.e;
                                        } else {
                                            bool3 = null;
                                        }
                                        objArr115[1] = bool3;
                                        if (jVar4 != null) {
                                            bool4 = jVar4.e;
                                        } else {
                                            bool4 = null;
                                        }
                                        objArr115[2] = bool4;
                                        c0Var.d = (Boolean) a(bool10, objArr115);
                                        Orientation orientation5 = Orientation.USER;
                                        Object[] objArr116 = new Object[3];
                                        objArr116[0] = jVar2.g;
                                        if (jVar3 != null) {
                                            orientation = jVar3.g;
                                        } else {
                                            orientation = null;
                                        }
                                        objArr116[1] = orientation;
                                        if (jVar4 != null) {
                                            orientation2 = jVar4.g;
                                        } else {
                                            orientation2 = null;
                                        }
                                        objArr116[2] = orientation2;
                                        c0Var.e = (Orientation) a(orientation5, objArr116);
                                        Object[] objArr117 = new Object[3];
                                        objArr117[0] = jVar2.i;
                                        if (jVar3 != null) {
                                            num14 = jVar3.i;
                                        } else {
                                            num14 = null;
                                        }
                                        objArr117[1] = num14;
                                        if (jVar4 != null) {
                                            num15 = jVar4.i;
                                        } else {
                                            num15 = null;
                                        }
                                        objArr117[2] = num15;
                                        num16 = (Integer) a((Object) 0, objArr117);
                                        if (num16.intValue() < 0) {
                                            iIntValue2 = 0;
                                        } else {
                                            iIntValue2 = num16.intValue();
                                        }
                                        c0Var.f = Integer.valueOf(iIntValue2);
                                        Object[] objArr118 = new Object[3];
                                        objArr118[0] = jVar2.h;
                                        if (jVar3 != null) {
                                            num17 = jVar3.h;
                                        } else {
                                            num17 = null;
                                        }
                                        objArr118[1] = num17;
                                        if (jVar4 != null) {
                                            num18 = jVar4.h;
                                        } else {
                                            num18 = null;
                                        }
                                        objArr118[2] = num18;
                                        num19 = (Integer) a((Object) 2048, objArr118);
                                        if (num19.intValue() > c0Var.f868b.intValue()) {
                                            num19 = c0Var.f868b;
                                        }
                                        c0Var.g = num19;
                                        Skip skip5 = Skip._0;
                                        Object[] objArr119 = new Object[3];
                                        objArr119[0] = jVar2.d;
                                        if (jVar3 != null) {
                                            skip = jVar3.d;
                                        } else {
                                            skip = null;
                                        }
                                        objArr119[1] = skip;
                                        if (jVar4 != null) {
                                            skip2 = jVar4.d;
                                        } else {
                                            skip2 = null;
                                        }
                                        objArr119[2] = skip2;
                                        c0Var.h = (Skip) a(skip5, objArr119);
                                        TapAction tapAction5 = TapAction.DO_NOTHING;
                                        Object[] objArr1110 = new Object[3];
                                        objArr1110[0] = jVar2.f;
                                        if (jVar3 != null) {
                                            tapAction = jVar3.f;
                                        } else {
                                            tapAction = null;
                                        }
                                        objArr1110[1] = tapAction;
                                        if (jVar4 != null) {
                                            tapAction2 = jVar4.f;
                                        } else {
                                            tapAction2 = null;
                                        }
                                        objArr1110[2] = tapAction2;
                                        c0Var.i = (TapAction) a(tapAction5, objArr1110);
                                        List<Integer> arrayList3 = new ArrayList<>();
                                        dVarArr = new com.fyber.inneractive.sdk.config.remote.d[]{next2};
                                        i2 = 0;
                                        while (i2 < i) {
                                            jVarA = dVarArr[i2].a();
                                            if (jVarA == null) {
                                            }
                                            i2++;
                                        }
                                        c0Var.k = arrayList3;
                                        a0Var.f = c0Var;
                                    }
                                } else {
                                    map = map2;
                                    c0Var.j = unitDisplayType3;
                                    Object[] objArr1111 = new Object[3];
                                    objArr1111[0] = jVar2.a;
                                    if (jVar3 != null) {
                                        bool = jVar3.a;
                                    } else {
                                        bool = null;
                                    }
                                    objArr1111[1] = bool;
                                    if (jVar4 != null) {
                                        bool2 = jVar4.a;
                                    } else {
                                        bool2 = null;
                                    }
                                    objArr1111[2] = bool2;
                                    objA = a((Object) null, objArr1111);
                                    if (objA != null) {
                                        c0Var.a = (Boolean) objA;
                                        Object[] objArr1112 = new Object[3];
                                        objArr1112[0] = jVar2.f896b;
                                        if (jVar3 != null) {
                                            num9 = jVar3.f896b;
                                        } else {
                                            num9 = null;
                                        }
                                        objArr1112[1] = num9;
                                        if (jVar4 != null) {
                                            num10 = jVar4.f896b;
                                        } else {
                                            num10 = null;
                                        }
                                        objArr1112[2] = num10;
                                        c0Var.f868b = (Integer) a((Object) 5000, objArr1112);
                                        Object[] objArr1113 = new Object[3];
                                        objArr1113[0] = jVar2.c;
                                        if (jVar3 != null) {
                                            num11 = jVar3.c;
                                        } else {
                                            num11 = null;
                                        }
                                        objArr1113[1] = num11;
                                        if (jVar4 != null) {
                                            num12 = jVar4.c;
                                        } else {
                                            num12 = null;
                                        }
                                        objArr1113[2] = num12;
                                        num13 = (Integer) a((Object) 0, objArr1113);
                                        if (num13.intValue() < 0) {
                                            iIntValue = 0;
                                        } else {
                                            iIntValue = num13.intValue();
                                        }
                                        c0Var.c = Integer.valueOf(iIntValue);
                                        Boolean bool11 = Boolean.TRUE;
                                        Object[] objArr1114 = new Object[3];
                                        objArr1114[0] = jVar2.e;
                                        if (jVar3 != null) {
                                            bool3 = jVar3.e;
                                        } else {
                                            bool3 = null;
                                        }
                                        objArr1114[1] = bool3;
                                        if (jVar4 != null) {
                                            bool4 = jVar4.e;
                                        } else {
                                            bool4 = null;
                                        }
                                        objArr1114[2] = bool4;
                                        c0Var.d = (Boolean) a(bool11, objArr1114);
                                        Orientation orientation6 = Orientation.USER;
                                        Object[] objArr1115 = new Object[3];
                                        objArr1115[0] = jVar2.g;
                                        if (jVar3 != null) {
                                            orientation = jVar3.g;
                                        } else {
                                            orientation = null;
                                        }
                                        objArr1115[1] = orientation;
                                        if (jVar4 != null) {
                                            orientation2 = jVar4.g;
                                        } else {
                                            orientation2 = null;
                                        }
                                        objArr1115[2] = orientation2;
                                        c0Var.e = (Orientation) a(orientation6, objArr1115);
                                        Object[] objArr1116 = new Object[3];
                                        objArr1116[0] = jVar2.i;
                                        if (jVar3 != null) {
                                            num14 = jVar3.i;
                                        } else {
                                            num14 = null;
                                        }
                                        objArr1116[1] = num14;
                                        if (jVar4 != null) {
                                            num15 = jVar4.i;
                                        } else {
                                            num15 = null;
                                        }
                                        objArr1116[2] = num15;
                                        num16 = (Integer) a((Object) 0, objArr1116);
                                        if (num16.intValue() < 0) {
                                            iIntValue2 = 0;
                                        } else {
                                            iIntValue2 = num16.intValue();
                                        }
                                        c0Var.f = Integer.valueOf(iIntValue2);
                                        Object[] objArr1117 = new Object[3];
                                        objArr1117[0] = jVar2.h;
                                        if (jVar3 != null) {
                                            num17 = jVar3.h;
                                        } else {
                                            num17 = null;
                                        }
                                        objArr1117[1] = num17;
                                        if (jVar4 != null) {
                                            num18 = jVar4.h;
                                        } else {
                                            num18 = null;
                                        }
                                        objArr1117[2] = num18;
                                        num19 = (Integer) a((Object) 2048, objArr1117);
                                        if (num19.intValue() > c0Var.f868b.intValue()) {
                                            num19 = c0Var.f868b;
                                        }
                                        c0Var.g = num19;
                                        Skip skip6 = Skip._0;
                                        Object[] objArr1118 = new Object[3];
                                        objArr1118[0] = jVar2.d;
                                        if (jVar3 != null) {
                                            skip = jVar3.d;
                                        } else {
                                            skip = null;
                                        }
                                        objArr1118[1] = skip;
                                        if (jVar4 != null) {
                                            skip2 = jVar4.d;
                                        } else {
                                            skip2 = null;
                                        }
                                        objArr1118[2] = skip2;
                                        c0Var.h = (Skip) a(skip6, objArr1118);
                                        TapAction tapAction6 = TapAction.DO_NOTHING;
                                        Object[] objArr1119 = new Object[3];
                                        objArr1119[0] = jVar2.f;
                                        if (jVar3 != null) {
                                            tapAction = jVar3.f;
                                        } else {
                                            tapAction = null;
                                        }
                                        objArr1119[1] = tapAction;
                                        if (jVar4 != null) {
                                            tapAction2 = jVar4.f;
                                        } else {
                                            tapAction2 = null;
                                        }
                                        objArr1119[2] = tapAction2;
                                        c0Var.i = (TapAction) a(tapAction6, objArr1119);
                                        List<Integer> arrayList4 = new ArrayList<>();
                                        dVarArr = new com.fyber.inneractive.sdk.config.remote.d[]{next2};
                                        i2 = 0;
                                        while (i2 < i) {
                                            jVarA = dVarArr[i2].a();
                                            if (jVarA == null) {
                                            }
                                            i2++;
                                        }
                                        c0Var.k = arrayList4;
                                        a0Var.f = c0Var;
                                    }
                                }
                                it3 = it;
                                it4 = it2;
                                map2 = map;
                                cVar = cVar;
                            } else {
                                map = map2;
                            }
                            x xVar2 = new x();
                            HashSet hashSet3 = new HashSet();
                            Object[] objArr27 = new Object[3];
                            fVar = next2.d;
                            if (fVar != null) {
                                set = fVar.a;
                            } else {
                                set = null;
                            }
                            objArr27[0] = set;
                            fVar2 = next.d;
                            if (fVar2 != null) {
                                set2 = fVar2.a;
                            } else {
                                set2 = null;
                            }
                            objArr27[1] = set2;
                            fVar3 = aVar2.c;
                            if (fVar3 != null) {
                                set3 = fVar3.a;
                            } else {
                                set3 = null;
                            }
                            objArr27[2] = set3;
                            xVar2.a = (Set) a(hashSet3, objArr27);
                            a0Var.d = xVar2;
                            e0Var = new e0();
                            kVar = next2.g;
                            kVar2 = next.f;
                            kVar3 = aVar2.f;
                            Object[] objArr28 = new Object[3];
                            if (kVar != null) {
                                num = kVar.a;
                            } else {
                                num = null;
                            }
                            objArr28[0] = num;
                            if (kVar2 != null) {
                                num2 = kVar2.a;
                            } else {
                                num2 = null;
                            }
                            objArr28[1] = num2;
                            if (kVar3 != null) {
                                num3 = kVar3.a;
                            } else {
                                num3 = null;
                            }
                            objArr28[2] = num3;
                            num4 = (Integer) a((Object) 1, objArr28);
                            if (num4.intValue() > 0) {
                                e0Var.a = num4;
                            } else {
                                e0Var.a = num4;
                            }
                            Object[] objArr29 = new Object[3];
                            if (kVar != null) {
                                num5 = kVar.f897b;
                            } else {
                                num5 = null;
                            }
                            objArr29[0] = num5;
                            if (kVar2 != null) {
                                num6 = kVar2.f897b;
                            } else {
                                num6 = null;
                            }
                            objArr29[1] = num6;
                            if (kVar3 != null) {
                                num7 = kVar3.f897b;
                            } else {
                                num7 = null;
                            }
                            objArr29[2] = num7;
                            num8 = (Integer) a((Object) 0, objArr29);
                            if (num8.intValue() >= 0) {
                                e0Var.f871b = num8;
                            } else {
                                e0Var.f871b = num8;
                            }
                            HashSet hashSet4 = new HashSet();
                            Object[] objArr210 = new Object[3];
                            if (kVar != null) {
                                set4 = kVar.c;
                            } else {
                                set4 = null;
                            }
                            objArr210[0] = set4;
                            if (kVar2 != null) {
                                set5 = kVar2.c;
                                c = 1;
                            } else {
                                c = 1;
                                set5 = null;
                            }
                            objArr210[c] = set5;
                            if (kVar3 != null) {
                                set6 = kVar3.c;
                                c2 = 2;
                            } else {
                                c2 = 2;
                                set6 = null;
                            }
                            objArr210[c2] = set6;
                            set7 = (Set) a(hashSet4, objArr210);
                            e0Var.c = set7;
                            a0Var.g = e0Var;
                            if (eVar3 != null) {
                                while (r0.hasNext()) {
                                    if (vendor == null) {
                                    }
                                }
                            }
                            zVar.a.add(a0Var);
                            map3.put(a0Var.a, a0Var);
                            it3 = it;
                            it4 = it2;
                            map2 = map;
                            cVar = cVar;
                        }
                    }
                }
            }
            map2.put(str, zVar);
            eVar2 = eVar;
        }
        return cVar;
    }

    public static Object a(Object obj, Object... objArr) {
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                return obj2;
            }
        }
        return obj;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public IAConfigManager.c a(String str) throws Exception {
        try {
            IAConfigManager iAConfigManager = IAConfigManager.M;
            iAConfigManager.D.b();
            com.fyber.inneractive.sdk.config.remote.e eVarA = com.fyber.inneractive.sdk.config.remote.e.a(new JSONObject(str));
            String str2 = iAConfigManager.c;
            if (eVarA != null && str2.equals(eVarA.a.a)) {
                eVarA.d = str;
                return a(eVarA);
            }
            IAlog.b("internal error while parsing local configuration", new Object[0]);
            if (eVarA != null && !str2.equals(eVarA.a.a)) {
                throw new InvalidAppIdException();
            }
            a((Throwable) null, str);
            return null;
        } catch (Throwable th) {
            a(th, str);
            IAlog.b("Exception Error while parsing local configuration", new Object[0]);
            throw th;
        }
    }
}
