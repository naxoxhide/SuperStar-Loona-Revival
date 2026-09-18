package com.applovin.exoplayer2.e.e;

import android.util.Pair;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.k.g;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.r;
import com.applovin.exoplayer2.l.v;
import com.applovin.exoplayer2.l.y;
import com.google.firebase.FirebaseError;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class d implements h {
    public static final l vq = new l() { // from class: com.applovin.exoplayer2.e.e.-$$Lambda$d$uLsuGX8BexrYtmM04saPiX_jpSM
        @Override // com.applovin.exoplayer2.e.l
        public final h[] createExtractors() {
            return d.ih();
        }
    };
    private static final byte[] wR = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] wS = ai.bk("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] wT = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final UUID wU = new UUID(72057594037932032L, -9223371306706625679L);
    private static final Map<String, Integer> wV;
    private long fH;
    private final y uO;
    private j vG;
    private final f wL;
    private final com.applovin.exoplayer2.e.e.c wW;
    private final SparseArray<b> wX;
    private final boolean wY;
    private final y wZ;
    private final y wm;
    private final y wn;
    private int xA;
    private int xB;
    private int[] xC;
    private int xD;
    private int xE;
    private int xF;
    private int xG;
    private boolean xH;
    private int xI;
    private int xJ;
    private int xK;
    private boolean xL;
    private boolean xM;
    private boolean xN;
    private int xO;
    private byte xP;
    private boolean xQ;
    private final y xa;
    private final y xb;
    private final y xc;
    private final y xd;
    private final y xe;
    private final y xf;
    private ByteBuffer xg;
    private long xh;
    private long xi;
    private long xj;
    private long xk;
    private b xl;
    private boolean xm;
    private int xn;
    private long xo;
    private boolean xp;
    private long xq;
    private long xr;
    private long xs;
    private r xt;
    private r xu;
    private boolean xv;
    private boolean xw;
    private int xx;
    private long xy;
    private long xz;

    protected int bX(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected boolean bY(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @Override // com.applovin.exoplayer2.e.h
    public final void release() {
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        wV = Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new d()};
    }

    public d() {
        this(0);
    }

    public d(int i) {
        this(new com.applovin.exoplayer2.e.e.a(), i);
    }

    d(com.applovin.exoplayer2.e.e.c cVar, int i) {
        this.xi = -1L;
        this.xj = -9223372036854775807L;
        this.xk = -9223372036854775807L;
        this.fH = -9223372036854775807L;
        this.xq = -1L;
        this.xr = -1L;
        this.xs = -9223372036854775807L;
        this.wW = cVar;
        cVar.a(new a());
        this.wY = (i & 1) == 0;
        this.wL = new f();
        this.wX = new SparseArray<>();
        this.uO = new y(4);
        this.wZ = new y(ByteBuffer.allocate(4).putInt(-1).array());
        this.xa = new y(4);
        this.wm = new y(v.abK);
        this.wn = new y(4);
        this.xb = new y();
        this.xc = new y();
        this.xd = new y(8);
        this.xe = new y();
        this.xf = new y();
        this.xC = new int[1];
    }

    @Override // com.applovin.exoplayer2.e.h
    public final boolean a(i iVar) throws IOException {
        return new e().a(iVar);
    }

    @Override // com.applovin.exoplayer2.e.h
    public final void a(j jVar) {
        this.vG = jVar;
    }

    @Override // com.applovin.exoplayer2.e.h
    public void o(long j, long j2) {
        this.xs = -9223372036854775807L;
        this.xx = 0;
        this.wW.Y();
        this.wL.Y();
        ix();
        for (int i = 0; i < this.wX.size(); i++) {
            this.wX.valueAt(i).Y();
        }
    }

    @Override // com.applovin.exoplayer2.e.h
    public final int b(i iVar, u uVar) throws IOException {
        this.xw = false;
        boolean zY = true;
        while (zY && !this.xw) {
            zY = this.wW.y(iVar);
            if (zY && a(uVar, iVar.ie())) {
                return 1;
            }
        }
        if (zY) {
            return 0;
        }
        for (int i = 0; i < this.wX.size(); i++) {
            b bVarValueAt = this.wX.valueAt(i);
            bVarValueAt.iD();
            bVarValueAt.iB();
        }
        return -1;
    }

    protected void f(int i, long j, long j2) throws com.applovin.exoplayer2.ai {
        io();
        if (i == 160) {
            this.xH = false;
            return;
        }
        if (i == 174) {
            this.xl = new b();
            return;
        }
        if (i == 187) {
            this.xv = false;
            return;
        }
        if (i == 19899) {
            this.xn = -1;
            this.xo = -1L;
            return;
        }
        if (i == 20533) {
            cc(i).xX = true;
            return;
        }
        if (i == 21968) {
            cc(i).yi = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.xi;
            if (j3 != -1 && j3 != j) {
                throw com.applovin.exoplayer2.ai.c("Multiple Segment elements not supported", null);
            }
            this.xi = j;
            this.xh = j2;
            return;
        }
        if (i == 475249515) {
            this.xt = new r();
            this.xu = new r();
        } else if (i == 524531317 && !this.xm) {
            if (this.wY && this.xq != -1) {
                this.xp = true;
            } else {
                this.vG.a(new com.applovin.exoplayer2.e.v.b(this.fH));
                this.xm = true;
            }
        }
    }

    protected void bZ(int i) throws com.applovin.exoplayer2.ai {
        io();
        if (i == 160) {
            if (this.xx != 2) {
                return;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.xB; i3++) {
                i2 += this.xC[i3];
            }
            b bVar = this.wX.get(this.xD);
            bVar.iD();
            for (int i4 = 0; i4 < this.xB; i4++) {
                long j = ((long) ((bVar.xU * i4) / 1000)) + this.xy;
                int i5 = this.xF;
                if (i4 == 0 && !this.xH) {
                    i5 |= 1;
                }
                int i6 = this.xC[i4];
                i2 -= i6;
                a(bVar, j, i5, i6, i2);
            }
            this.xx = 0;
            return;
        }
        if (i == 174) {
            b bVar2 = (b) com.applovin.exoplayer2.l.a.N(this.xl);
            if (bVar2.xS == null) {
                throw com.applovin.exoplayer2.ai.c("CodecId is missing in TrackEntry element", null);
            }
            if (G(bVar2.xS)) {
                bVar2.a(this.vG, bVar2.xT);
                this.wX.put(bVar2.xT, bVar2);
            }
            this.xl = null;
            return;
        }
        if (i == 19899) {
            int i7 = this.xn;
            if (i7 != -1) {
                long j2 = this.xo;
                if (j2 != -1) {
                    if (i7 == 475249515) {
                        this.xq = j2;
                        return;
                    }
                    return;
                }
            }
            throw com.applovin.exoplayer2.ai.c("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i == 25152) {
            ca(i);
            if (this.xl.xX) {
                if (this.xl.xZ == null) {
                    throw com.applovin.exoplayer2.ai.c("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                this.xl.dC = new com.applovin.exoplayer2.d.e(new com.applovin.exoplayer2.d.e.a(com.applovin.exoplayer2.h.aj, "video/webm", this.xl.xZ.uV));
                return;
            }
            return;
        }
        if (i == 28032) {
            ca(i);
            if (this.xl.xX && this.xl.xY != null) {
                throw com.applovin.exoplayer2.ai.c("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i == 357149030) {
            if (this.xj == -9223372036854775807L) {
                this.xj = 1000000L;
            }
            long j3 = this.xk;
            if (j3 != -9223372036854775807L) {
                this.fH = ap(j3);
                return;
            }
            return;
        }
        if (i != 374648427) {
            if (i != 475249515) {
                return;
            }
            if (!this.xm) {
                this.vG.a(a(this.xt, this.xu));
                this.xm = true;
            }
            this.xt = null;
            this.xu = null;
        } else {
            if (this.wX.size() == 0) {
                throw com.applovin.exoplayer2.ai.c("No valid tracks were found", null);
            }
            this.vG.ig();
        }
    }

    protected void e(int i, long j) throws com.applovin.exoplayer2.ai {
        if (i == 20529) {
            if (j != 0) {
                throw com.applovin.exoplayer2.ai.c("ContentEncodingOrder " + j + " not supported", null);
            }
            return;
        }
        if (i == 20530) {
            if (j != 1) {
                throw com.applovin.exoplayer2.ai.c("ContentEncodingScope " + j + " not supported", null);
            }
            return;
        }
        switch (i) {
            case 131:
                cc(i).bs = (int) j;
                return;
            case 136:
                cc(i).yE = j == 1;
                return;
            case 155:
                this.xz = ap(j);
                return;
            case 159:
                cc(i).dL = (int) j;
                return;
            case 176:
                cc(i).dE = (int) j;
                return;
            case 179:
                cb(i);
                this.xt.bo(ap(j));
                return;
            case 186:
                cc(i).height = (int) j;
                return;
            case 215:
                cc(i).xT = (int) j;
                return;
            case 231:
                this.xs = ap(j);
                return;
            case 238:
                this.xG = (int) j;
                return;
            case 241:
                if (this.xv) {
                    return;
                }
                cb(i);
                this.xu.bo(j);
                this.xv = true;
                return;
            case 251:
                this.xH = true;
                return;
            case 16871:
                cc(i).xW = (int) j;
                return;
            case 16980:
                if (j != 3) {
                    throw com.applovin.exoplayer2.ai.c("ContentCompAlgo " + j + " not supported", null);
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    throw com.applovin.exoplayer2.ai.c("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j != 1) {
                    throw com.applovin.exoplayer2.ai.c("EBMLReadVersion " + j + " not supported", null);
                }
                return;
            case 18401:
                if (j != 5) {
                    throw com.applovin.exoplayer2.ai.c("ContentEncAlgo " + j + " not supported", null);
                }
                return;
            case 18408:
                if (j != 1) {
                    throw com.applovin.exoplayer2.ai.c("AESSettingsCipherMode " + j + " not supported", null);
                }
                return;
            case 21420:
                this.xo = j + this.xi;
                return;
            case 21432:
                int i2 = (int) j;
                ca(i);
                if (i2 == 0) {
                    this.xl.dJ = 0;
                    return;
                }
                if (i2 == 1) {
                    this.xl.dJ = 2;
                    return;
                } else if (i2 == 3) {
                    this.xl.dJ = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.xl.dJ = 3;
                    return;
                }
            case 21680:
                cc(i).yb = (int) j;
                return;
            case 21682:
                cc(i).yd = (int) j;
                return;
            case 21690:
                cc(i).yc = (int) j;
                return;
            case 21930:
                cc(i).yD = j == 1;
                return;
            case 21998:
                cc(i).xV = (int) j;
                return;
            case 22186:
                cc(i).yA = j;
                return;
            case 22203:
                cc(i).yB = j;
                return;
            case 25188:
                cc(i).yz = (int) j;
                return;
            case 30321:
                ca(i);
                int i3 = (int) j;
                if (i3 == 0) {
                    this.xl.ye = 0;
                    return;
                }
                if (i3 == 1) {
                    this.xl.ye = 1;
                    return;
                } else if (i3 == 2) {
                    this.xl.ye = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.xl.ye = 3;
                    return;
                }
            case 2352003:
                cc(i).xU = (int) j;
                return;
            case 2807729:
                this.xj = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        ca(i);
                        int i4 = (int) j;
                        if (i4 == 1) {
                            this.xl.yl = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.xl.yl = 1;
                            return;
                        }
                    case 21946:
                        ca(i);
                        int iFO = com.applovin.exoplayer2.m.b.fO((int) j);
                        if (iFO != -1) {
                            this.xl.yk = iFO;
                            return;
                        }
                        return;
                    case 21947:
                        ca(i);
                        this.xl.yi = true;
                        int iFN = com.applovin.exoplayer2.m.b.fN((int) j);
                        if (iFN != -1) {
                            this.xl.yj = iFN;
                            return;
                        }
                        return;
                    case 21948:
                        cc(i).ym = (int) j;
                        return;
                    case 21949:
                        cc(i).yn = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    protected void b(int i, double d) throws com.applovin.exoplayer2.ai {
        if (i == 181) {
            cc(i).dM = (int) d;
        }
        if (i == 17545) {
            this.xk = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                cc(i).yo = (float) d;
                break;
            case 21970:
                cc(i).yp = (float) d;
                break;
            case 21971:
                cc(i).yq = (float) d;
                break;
            case 21972:
                cc(i).yr = (float) d;
                break;
            case 21973:
                cc(i).ys = (float) d;
                break;
            case 21974:
                cc(i).yt = (float) d;
                break;
            case 21975:
                cc(i).yu = (float) d;
                break;
            case 21976:
                cc(i).yv = (float) d;
                break;
            case 21977:
                cc(i).yw = (float) d;
                break;
            case 21978:
                cc(i).yx = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        cc(i).yf = (float) d;
                        break;
                    case 30324:
                        cc(i).yg = (float) d;
                        break;
                    case 30325:
                        cc(i).yh = (float) d;
                        break;
                }
                break;
        }
    }

    protected void b(int i, String str) throws com.applovin.exoplayer2.ai {
        if (i == 134) {
            cc(i).xS = str;
            return;
        }
        if (i == 17026) {
            if (!"webm".equals(str) && !"matroska".equals(str)) {
                throw com.applovin.exoplayer2.ai.c("DocType " + str + " not supported", null);
            }
        } else if (i == 21358) {
            cc(i).name = str;
        } else {
            if (i != 2274716) {
                return;
            }
            cc(i).dq = str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:98:0x02a0  */
    protected void a(int i, int i2, i iVar) throws IOException {
        b bVar;
        int i3;
        b bVar2;
        long j;
        long j2;
        int i4;
        int i5;
        int[] iArr;
        int i6;
        int i7 = 0;
        int i8 = 1;
        if (i != 161 && i != 163) {
            if (i == 165) {
                if (this.xx != 2) {
                    return;
                }
                a(this.wX.get(this.xD), this.xG, iVar, i2);
                return;
            }
            if (i == 16877) {
                a(cc(i), iVar, i2);
                return;
            }
            if (i == 16981) {
                ca(i);
                this.xl.xY = new byte[i2];
                iVar.a(this.xl.xY, 0, i2);
                return;
            }
            if (i == 18402) {
                byte[] bArr = new byte[i2];
                iVar.a(bArr, 0, i2);
                cc(i).xZ = new x.a(1, bArr, 0, 0);
                return;
            }
            if (i == 21419) {
                Arrays.fill(this.xa.hO(), (byte) 0);
                iVar.a(this.xa.hO(), 4 - i2, i2);
                this.xa.fx(0);
                this.xn = (int) this.xa.pv();
                return;
            }
            if (i == 25506) {
                ca(i);
                this.xl.ya = new byte[i2];
                iVar.a(this.xl.ya, 0, i2);
                return;
            }
            if (i == 30322) {
                ca(i);
                this.xl.dI = new byte[i2];
                iVar.a(this.xl.dI, 0, i2);
                return;
            }
            throw com.applovin.exoplayer2.ai.c("Unexpected id: " + i, null);
        }
        if (this.xx == 0) {
            this.xD = (int) this.wL.a(iVar, false, true, 8);
            this.xE = this.wL.iE();
            this.xz = -9223372036854775807L;
            this.xx = 1;
            this.uO.U(0);
        }
        b bVar3 = this.wX.get(this.xD);
        if (bVar3 == null) {
            iVar.bH(i2 - this.xE);
            this.xx = 0;
            return;
        }
        bVar3.iD();
        if (this.xx == 1) {
            h(iVar, 3);
            int i9 = (this.uO.hO()[2] & 6) >> 1;
            byte b2 = 255;
            if (i9 == 0) {
                this.xB = 1;
                int[] iArrA = a(this.xC, 1);
                this.xC = iArrA;
                iArrA[0] = (i2 - this.xE) - 3;
            } else {
                int i10 = 4;
                h(iVar, 4);
                int i11 = (this.uO.hO()[3] & 255) + 1;
                this.xB = i11;
                int[] iArrA2 = a(this.xC, i11);
                this.xC = iArrA2;
                if (i9 == 2) {
                    int i12 = (i2 - this.xE) - 4;
                    int i13 = this.xB;
                    Arrays.fill(iArrA2, 0, i13, i12 / i13);
                } else {
                    if (i9 == 1) {
                        int i14 = 0;
                        int i15 = 0;
                        while (true) {
                            i4 = this.xB;
                            if (i14 >= i4 - 1) {
                                break;
                            }
                            this.xC[i14] = 0;
                            do {
                                i10++;
                                h(iVar, i10);
                                i5 = this.uO.hO()[i10 - 1] & 255;
                                iArr = this.xC;
                                iArr[i14] = iArr[i14] + i5;
                            } while (i5 == 255);
                            i15 += iArr[i14];
                            i14++;
                        }
                        this.xC[i4 - 1] = ((i2 - this.xE) - i10) - i15;
                    } else {
                        if (i9 != 3) {
                            throw com.applovin.exoplayer2.ai.c("Unexpected lacing value: " + i9, null);
                        }
                        int i16 = 0;
                        int i17 = 0;
                        while (true) {
                            int i18 = this.xB;
                            if (i16 < i18 - 1) {
                                this.xC[i16] = i7;
                                i10++;
                                h(iVar, i10);
                                int i19 = i10 - 1;
                                if (this.uO.hO()[i19] == 0) {
                                    throw com.applovin.exoplayer2.ai.c("No valid varint length mask found", null);
                                }
                                int i20 = i7;
                                while (true) {
                                    if (i20 >= 8) {
                                        j = 0;
                                        break;
                                    }
                                    int i21 = i8 << (7 - i20);
                                    if ((this.uO.hO()[i19] & i21) != 0) {
                                        int i22 = i10 + i20;
                                        h(iVar, i22);
                                        long j3 = (~i21) & this.uO.hO()[i19] & b2;
                                        int i23 = i19 + 1;
                                        while (true) {
                                            j2 = j3;
                                            if (i23 >= i22) {
                                                break;
                                            }
                                            j3 = (j2 << 8) | ((long) (this.uO.hO()[i23] & b2));
                                            i23++;
                                            i22 = i22;
                                            b2 = 255;
                                        }
                                        int i24 = i22;
                                        if (i16 > 0) {
                                            j2 -= (1 << ((i20 * 7) + 6)) - 1;
                                        }
                                        j = j2;
                                        i10 = i24;
                                        break;
                                    }
                                    i20++;
                                    i8 = 1;
                                    b2 = 255;
                                }
                                if (j < -2147483648L || j > 2147483647L) {
                                    throw com.applovin.exoplayer2.ai.c("EBML lacing sample size out of range.", null);
                                }
                                int i25 = (int) j;
                                int[] iArr2 = this.xC;
                                if (i16 != 0) {
                                    i25 += iArr2[i16 - 1];
                                }
                                iArr2[i16] = i25;
                                i17 += iArr2[i16];
                                i16++;
                                bVar3 = bVar3;
                                i7 = 0;
                                i8 = 1;
                                b2 = 255;
                            } else {
                                bVar2 = bVar3;
                                this.xC[i18 - 1] = ((i2 - this.xE) - i10) - i17;
                                break;
                            }
                        }
                    }
                    this.xy = this.xs + ap((this.uO.hO()[0] << 8) | (this.uO.hO()[1] & 255));
                    bVar = bVar2;
                    if (bVar.bs != 2 || (i == 163 && (this.uO.hO()[2] & 128) == 128)) {
                        i6 = 1;
                    } else {
                        i6 = 0;
                    }
                    this.xF = i6;
                    this.xx = 2;
                    this.xA = 0;
                    i3 = 163;
                }
            }
            bVar2 = bVar3;
            this.xy = this.xs + ap((this.uO.hO()[0] << 8) | (this.uO.hO()[1] & 255));
            bVar = bVar2;
            if (bVar.bs != 2) {
                i6 = 1;
            } else {
                i6 = 1;
            }
            this.xF = i6;
            this.xx = 2;
            this.xA = 0;
            i3 = 163;
        } else {
            bVar = bVar3;
            i3 = 163;
        }
        if (i == i3) {
            while (true) {
                int i26 = this.xA;
                if (i26 < this.xB) {
                    a(bVar, ((long) ((this.xA * bVar.xU) / 1000)) + this.xy, this.xF, a(iVar, bVar, this.xC[i26]), 0);
                    this.xA++;
                } else {
                    this.xx = 0;
                    return;
                }
            }
        } else {
            while (true) {
                int i27 = this.xA;
                if (i27 >= this.xB) {
                    return;
                }
                int[] iArr3 = this.xC;
                iArr3[i27] = a(iVar, bVar, iArr3[i27]);
                this.xA++;
            }
        }
    }

    protected void a(b bVar, i iVar, int i) throws IOException {
        if (bVar.xW == 1685485123 || bVar.xW == 1685480259) {
            bVar.yy = new byte[i];
            iVar.a(bVar.yy, 0, i);
        } else {
            iVar.bH(i);
        }
    }

    protected void a(b bVar, int i, i iVar, int i2) throws IOException {
        if (i == 4 && "V_VP9".equals(bVar.xS)) {
            this.xf.U(i2);
            iVar.a(this.xf.hO(), 0, i2);
        } else {
            iVar.bH(i2);
        }
    }

    private void ca(int i) throws com.applovin.exoplayer2.ai {
        if (this.xl == null) {
            throw com.applovin.exoplayer2.ai.c("Element " + i + " must be in a TrackEntry", null);
        }
    }

    private void cb(int i) throws com.applovin.exoplayer2.ai {
        if (this.xt == null || this.xu == null) {
            throw com.applovin.exoplayer2.ai.c("Element " + i + " must be in a Cues", null);
        }
    }

    private b cc(int i) throws com.applovin.exoplayer2.ai {
        ca(i);
        return this.xl;
    }

    private void a(b bVar, long j, int i, int i2, int i3) {
        if (bVar.yC != null) {
            bVar.yC.b(bVar, j, i, i2, i3);
        } else {
            if ("S_TEXT/UTF8".equals(bVar.xS) || "S_TEXT/ASS".equals(bVar.xS)) {
                if (this.xB > 1) {
                    q.h("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else if (this.xz == -9223372036854775807L) {
                    q.h("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                } else {
                    a(bVar.xS, this.xz, this.xc.hO());
                    for (int iIl = this.xc.il(); iIl < this.xc.pk(); iIl++) {
                        if (this.xc.hO()[iIl] == 0) {
                            this.xc.fA(iIl);
                            break;
                        }
                    }
                    x xVar = bVar.wl;
                    y yVar = this.xc;
                    xVar.c(yVar, yVar.pk());
                    i2 += this.xc.pk();
                }
            }
            if ((268435456 & i) != 0) {
                if (this.xB > 1) {
                    i &= -268435457;
                } else {
                    int iPk = this.xf.pk();
                    bVar.wl.a(this.xf, iPk, 2);
                    i2 += iPk;
                }
            }
            bVar.wl.a(j, i, i2, i3, bVar.xZ);
        }
        this.xw = true;
    }

    private void h(i iVar, int i) throws IOException {
        if (this.uO.pk() >= i) {
            return;
        }
        if (this.uO.pl() < i) {
            y yVar = this.uO;
            yVar.bj(Math.max(yVar.pl() * 2, i));
        }
        iVar.a(this.uO.hO(), this.uO.pk(), i - this.uO.pk());
        this.uO.fA(i);
    }

    private int a(i iVar, b bVar, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(bVar.xS)) {
            a(iVar, wR, i);
            return iw();
        }
        if ("S_TEXT/ASS".equals(bVar.xS)) {
            a(iVar, wT, i);
            return iw();
        }
        x xVar = bVar.wl;
        if (!this.xL) {
            if (bVar.xX) {
                this.xF &= -1073741825;
                if (!this.xM) {
                    iVar.a(this.uO.hO(), 0, 1);
                    this.xI++;
                    if ((this.uO.hO()[0] & 128) == 128) {
                        throw com.applovin.exoplayer2.ai.c("Extension bit is set in signal byte", null);
                    }
                    this.xP = this.uO.hO()[0];
                    this.xM = true;
                }
                byte b2 = this.xP;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.xF |= 1073741824;
                    if (!this.xQ) {
                        iVar.a(this.xd.hO(), 0, 8);
                        this.xI += 8;
                        this.xQ = true;
                        this.uO.hO()[0] = (byte) ((z ? 128 : 0) | 8);
                        this.uO.fx(0);
                        xVar.a(this.uO, 1, 1);
                        this.xJ++;
                        this.xd.fx(0);
                        xVar.a(this.xd, 8, 1);
                        this.xJ += 8;
                    }
                    if (z) {
                        if (!this.xN) {
                            iVar.a(this.uO.hO(), 0, 1);
                            this.xI++;
                            this.uO.fx(0);
                            this.xO = this.uO.po();
                            this.xN = true;
                        }
                        int i3 = this.xO * 4;
                        this.uO.U(i3);
                        iVar.a(this.uO.hO(), 0, i3);
                        this.xI += i3;
                        short s = (short) ((this.xO / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.xg;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.xg = ByteBuffer.allocate(i4);
                        }
                        this.xg.position(0);
                        this.xg.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.xO;
                            if (i5 >= i2) {
                                break;
                            }
                            int iPD = this.uO.pD();
                            if (i5 % 2 == 0) {
                                this.xg.putShort((short) (iPD - i6));
                            } else {
                                this.xg.putInt(iPD - i6);
                            }
                            i5++;
                            i6 = iPD;
                        }
                        int i7 = (i - this.xI) - i6;
                        if (i2 % 2 == 1) {
                            this.xg.putInt(i7);
                        } else {
                            this.xg.putShort((short) i7);
                            this.xg.putInt(0);
                        }
                        this.xe.l(this.xg.array(), i4);
                        xVar.a(this.xe, i4, 1);
                        this.xJ += i4;
                    }
                }
            } else if (bVar.xY != null) {
                this.xb.l(bVar.xY, bVar.xY.length);
            }
            if (bVar.xV > 0) {
                this.xF |= 268435456;
                this.xf.U(0);
                this.uO.U(4);
                this.uO.hO()[0] = (byte) ((i >> 24) & 255);
                this.uO.hO()[1] = (byte) ((i >> 16) & 255);
                this.uO.hO()[2] = (byte) ((i >> 8) & 255);
                this.uO.hO()[3] = (byte) (i & 255);
                xVar.a(this.uO, 4, 2);
                this.xJ += 4;
            }
            this.xL = true;
        }
        int iPk = i + this.xb.pk();
        if ("V_MPEG4/ISO/AVC".equals(bVar.xS) || "V_MPEGH/ISO/HEVC".equals(bVar.xS)) {
            byte[] bArrHO = this.wn.hO();
            bArrHO[0] = 0;
            bArrHO[1] = 0;
            bArrHO[2] = 0;
            int i8 = bVar.wo;
            int i9 = 4 - bVar.wo;
            while (this.xI < iPk) {
                int i10 = this.xK;
                if (i10 == 0) {
                    c(iVar, bArrHO, i9, i8);
                    this.xI += i8;
                    this.wn.fx(0);
                    this.xK = this.wn.pD();
                    this.wm.fx(0);
                    xVar.c(this.wm, 4);
                    this.xJ += 4;
                } else {
                    int iA = a(iVar, xVar, i10);
                    this.xI += iA;
                    this.xJ += iA;
                    this.xK -= iA;
                }
            }
        } else {
            if (bVar.yC != null) {
                com.applovin.exoplayer2.l.a.checkState(this.xb.pk() == 0);
                bVar.yC.A(iVar);
            }
            while (true) {
                int i11 = this.xI;
                if (i11 >= iPk) {
                    break;
                }
                int iA2 = a(iVar, xVar, iPk - i11);
                this.xI += iA2;
                this.xJ += iA2;
            }
        }
        if ("A_VORBIS".equals(bVar.xS)) {
            this.wZ.fx(0);
            xVar.c(this.wZ, 4);
            this.xJ += 4;
        }
        return iw();
    }

    private int iw() {
        int i = this.xJ;
        ix();
        return i;
    }

    private void ix() {
        this.xI = 0;
        this.xJ = 0;
        this.xK = 0;
        this.xL = false;
        this.xM = false;
        this.xN = false;
        this.xO = 0;
        this.xP = (byte) 0;
        this.xQ = false;
        this.xb.U(0);
    }

    private void a(i iVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        if (this.xc.pl() < length) {
            this.xc.I(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, this.xc.hO(), 0, bArr.length);
        }
        iVar.a(this.xc.hO(), bArr.length, i);
        this.xc.fx(0);
        this.xc.fA(length);
    }

    private static void a(String str, long j, byte[] bArr) {
        byte[] bArrA;
        int i;
        str.hashCode();
        if (str.equals("S_TEXT/ASS")) {
            bArrA = a(j, "%01d:%02d:%02d:%02d", 10000L);
            i = 21;
        } else if (str.equals("S_TEXT/UTF8")) {
            bArrA = a(j, "%02d:%02d:%02d,%03d", 1000L);
            i = 19;
        } else {
            throw new IllegalArgumentException();
        }
        System.arraycopy(bArrA, 0, bArr, i, bArrA.length);
    }

    private static byte[] a(long j, String str, long j2) {
        com.applovin.exoplayer2.l.a.checkArgument(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) (i * 3600)) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) (i2 * 60)) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return ai.bk(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))));
    }

    private void c(i iVar, byte[] bArr, int i, int i2) throws IOException {
        int iMin = Math.min(i2, this.xb.pj());
        iVar.a(bArr, i + iMin, i2 - iMin);
        if (iMin > 0) {
            this.xb.r(bArr, i, iMin);
        }
    }

    private int a(i iVar, x xVar, int i) throws IOException {
        int iPj = this.xb.pj();
        if (iPj > 0) {
            int iMin = Math.min(i, iPj);
            xVar.c(this.xb, iMin);
            return iMin;
        }
        return xVar.a((g) iVar, i, false);
    }

    private com.applovin.exoplayer2.e.v a(r rVar, r rVar2) {
        int i;
        if (this.xi == -1 || this.fH == -9223372036854775807L || rVar == null || rVar.size() == 0 || rVar2 == null || rVar2.size() != rVar.size()) {
            return new com.applovin.exoplayer2.e.v.b(this.fH);
        }
        int size = rVar.size();
        int[] iArrCopyOf = new int[size];
        long[] jArrCopyOf = new long[size];
        long[] jArrCopyOf2 = new long[size];
        long[] jArrCopyOf3 = new long[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jArrCopyOf3[i3] = rVar.fu(i3);
            jArrCopyOf[i3] = this.xi + rVar2.fu(i3);
        }
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArrCopyOf[i2] = (int) (jArrCopyOf[i4] - jArrCopyOf[i2]);
            jArrCopyOf2[i2] = jArrCopyOf3[i4] - jArrCopyOf3[i2];
            i2 = i4;
        }
        iArrCopyOf[i] = (int) ((this.xi + this.xh) - jArrCopyOf[i]);
        jArrCopyOf2[i] = this.fH - jArrCopyOf3[i];
        long j = jArrCopyOf2[i];
        if (j <= 0) {
            q.h("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i);
        }
        return new com.applovin.exoplayer2.e.c(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    private boolean a(u uVar, long j) {
        if (this.xp) {
            this.xr = j;
            uVar.uc = this.xq;
            this.xp = false;
            return true;
        }
        if (this.xm) {
            long j2 = this.xr;
            if (j2 != -1) {
                uVar.uc = j2;
                this.xr = -1L;
                return true;
            }
        }
        return false;
    }

    private long ap(long j) throws com.applovin.exoplayer2.ai {
        long j2 = this.xj;
        if (j2 == -9223372036854775807L) {
            throw com.applovin.exoplayer2.ai.c("Can't scale timecode prior to timecodeScale being set.", null);
        }
        return ai.e(j, j2, 1000L);
    }

    private static boolean G(String str) {
        str.hashCode();
        switch (str) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                return true;
            default:
                return false;
        }
    }

    private static int[] a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    private void io() {
        com.applovin.exoplayer2.l.a.N(this.vG);
    }

    private final class a implements com.applovin.exoplayer2.e.e.b {
        private a() {
        }

        @Override // com.applovin.exoplayer2.e.e.b
        public int bX(int i) {
            return d.this.bX(i);
        }

        @Override // com.applovin.exoplayer2.e.e.b
        public boolean bY(int i) {
            return d.this.bY(i);
        }

        @Override // com.applovin.exoplayer2.e.e.b
        public void f(int i, long j, long j2) throws com.applovin.exoplayer2.ai {
            d.this.f(i, j, j2);
        }

        @Override // com.applovin.exoplayer2.e.e.b
        public void bZ(int i) throws com.applovin.exoplayer2.ai {
            d.this.bZ(i);
        }

        @Override // com.applovin.exoplayer2.e.e.b
        public void e(int i, long j) throws com.applovin.exoplayer2.ai {
            d.this.e(i, j);
        }

        @Override // com.applovin.exoplayer2.e.e.b
        public void b(int i, double d) throws com.applovin.exoplayer2.ai {
            d.this.b(i, d);
        }

        @Override // com.applovin.exoplayer2.e.e.b
        public void b(int i, String str) throws com.applovin.exoplayer2.ai {
            d.this.b(i, str);
        }

        @Override // com.applovin.exoplayer2.e.e.b
        public void a(int i, int i2, i iVar) throws IOException {
            d.this.a(i, i2, iVar);
        }
    }

    private static final class c {
        private final byte[] yF = new byte[10];
        private boolean yG;
        private int yH;
        private long yI;
        private int yJ;
        private int yK;
        private int yL;

        public void Y() {
            this.yG = false;
            this.yH = 0;
        }

        public void A(i iVar) throws IOException {
            if (this.yG) {
                return;
            }
            iVar.c(this.yF, 0, 10);
            iVar.ic();
            if (com.applovin.exoplayer2.b.b.d(this.yF) == 0) {
                return;
            }
            this.yG = true;
        }

        public void b(b bVar, long j, int i, int i2, int i3) {
            if (this.yG) {
                int i4 = this.yH;
                int i5 = i4 + 1;
                this.yH = i5;
                if (i4 == 0) {
                    this.yI = j;
                    this.yJ = i;
                    this.yK = 0;
                }
                this.yK += i2;
                this.yL = i3;
                if (i5 >= 16) {
                    c(bVar);
                }
            }
        }

        public void c(b bVar) {
            if (this.yH > 0) {
                bVar.wl.a(this.yI, this.yJ, this.yK, this.yL, bVar.xZ);
                this.yH = 0;
            }
        }
    }

    private static final class b {
        public int bs;
        public com.applovin.exoplayer2.d.e dC;
        public int dE;
        public byte[] dI;
        public int dJ;
        public int dL;
        public int dM;
        private String dq;
        public int height;
        public String name;
        public x wl;
        public int wo;
        public String xS;
        public int xT;
        public int xU;
        public int xV;
        private int xW;
        public boolean xX;
        public byte[] xY;
        public x.a xZ;
        public long yA;
        public long yB;
        public c yC;
        public boolean yD;
        public boolean yE;
        public byte[] ya;
        public int yb;
        public int yc;
        public int yd;
        public int ye;
        public float yf;
        public float yg;
        public float yh;
        public boolean yi;
        public int yj;
        public int yk;
        public int yl;
        public int ym;
        public int yn;
        public float yo;
        public float yp;
        public float yq;
        public float yr;
        public float ys;
        public float yt;
        public float yu;
        public float yv;
        public float yw;
        public float yx;
        public byte[] yy;
        public int yz;

        private b() {
            this.dE = -1;
            this.height = -1;
            this.yb = -1;
            this.yc = -1;
            this.yd = 0;
            this.ye = -1;
            this.yf = 0.0f;
            this.yg = 0.0f;
            this.yh = 0.0f;
            this.dI = null;
            this.dJ = -1;
            this.yi = false;
            this.yj = -1;
            this.yk = -1;
            this.yl = -1;
            this.ym = 1000;
            this.yn = 200;
            this.yo = -1.0f;
            this.yp = -1.0f;
            this.yq = -1.0f;
            this.yr = -1.0f;
            this.ys = -1.0f;
            this.yt = -1.0f;
            this.yu = -1.0f;
            this.yv = -1.0f;
            this.yw = -1.0f;
            this.yx = -1.0f;
            this.dL = 1;
            this.yz = -1;
            this.dM = 8000;
            this.yA = 0L;
            this.yB = 0L;
            this.yE = true;
            this.dq = "eng";
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:147:0x028f A[PHI: r7
          0x028f: PHI (r7v5 int) = (r7v1 int), (r7v0 int), (r7v3 int), (r7v4 int), (r7v6 int) binds: [B:185:0x03c3, B:155:0x02c4, B:152:0x029b, B:150:0x0297, B:145:0x026b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:196:0x0414  */
        /* JADX WARN: Code duplicated, block: B:201:0x042e  */
        /* JADX WARN: Code duplicated, block: B:202:0x0430  */
        /* JADX WARN: Code duplicated, block: B:205:0x043d  */
        /* JADX WARN: Code duplicated, block: B:206:0x044f  */
        /* JADX WARN: Code duplicated, block: B:208:0x0455  */
        /* JADX WARN: Code duplicated, block: B:210:0x0459  */
        /* JADX WARN: Code duplicated, block: B:212:0x045e  */
        /* JADX WARN: Code duplicated, block: B:215:0x0466  */
        /* JADX WARN: Code duplicated, block: B:217:0x046b  */
        /* JADX WARN: Code duplicated, block: B:220:0x0472  */
        /* JADX WARN: Code duplicated, block: B:225:0x0483  */
        /* JADX WARN: Code duplicated, block: B:228:0x0496  */
        /* JADX WARN: Code duplicated, block: B:233:0x04b6  */
        /* JADX WARN: Code duplicated, block: B:252:0x0502  */
        /* JADX WARN: Code duplicated, block: B:254:0x0528  */
        /* JADX WARN: Code duplicated, block: B:256:0x052e  */
        /* JADX WARN: Code duplicated, block: B:269:0x0552  */
        /* JADX WARN: Code duplicated, block: B:4:0x0015  */
        public void a(j jVar, int i) throws com.applovin.exoplayer2.ai {
            byte b2;
            List<byte[]> listSingletonList;
            int i2;
            String str;
            List<byte[]> list;
            String str2;
            String str3;
            int i3;
            com.applovin.exoplayer2.v.a aVar;
            int iIntValue;
            float f;
            int i4;
            int i5;
            int i6;
            int i7;
            com.applovin.exoplayer2.m.c cVarAu;
            String str4 = this.xS;
            str4.hashCode();
            int iFI = 4;
            int i8 = 3;
            int i9 = 0;
            switch (str4) {
                case "V_MPEG4/ISO/AP":
                    b2 = 0;
                    break;
                case "V_MPEG4/ISO/SP":
                    b2 = 1;
                    break;
                case "A_MS/ACM":
                    b2 = 2;
                    break;
                case "A_TRUEHD":
                    b2 = 3;
                    break;
                case "A_VORBIS":
                    b2 = 4;
                    break;
                case "A_MPEG/L2":
                    b2 = 5;
                    break;
                case "A_MPEG/L3":
                    b2 = 6;
                    break;
                case "V_MS/VFW/FOURCC":
                    b2 = 7;
                    break;
                case "S_DVBSUB":
                    b2 = 8;
                    break;
                case "V_MPEG4/ISO/ASP":
                    b2 = 9;
                    break;
                case "V_MPEG4/ISO/AVC":
                    b2 = 10;
                    break;
                case "S_VOBSUB":
                    b2 = 11;
                    break;
                case "A_DTS/LOSSLESS":
                    b2 = 12;
                    break;
                case "A_AAC":
                    b2 = 13;
                    break;
                case "A_AC3":
                    b2 = 14;
                    break;
                case "A_DTS":
                    b2 = 15;
                    break;
                case "V_AV1":
                    b2 = 16;
                    break;
                case "V_VP8":
                    b2 = 17;
                    break;
                case "V_VP9":
                    b2 = 18;
                    break;
                case "S_HDMV/PGS":
                    b2 = 19;
                    break;
                case "V_THEORA":
                    b2 = 20;
                    break;
                case "A_DTS/EXPRESS":
                    b2 = 21;
                    break;
                case "A_PCM/FLOAT/IEEE":
                    b2 = 22;
                    break;
                case "A_PCM/INT/BIG":
                    b2 = 23;
                    break;
                case "A_PCM/INT/LIT":
                    b2 = 24;
                    break;
                case "S_TEXT/ASS":
                    b2 = 25;
                    break;
                case "V_MPEGH/ISO/HEVC":
                    b2 = 26;
                    break;
                case "S_TEXT/UTF8":
                    b2 = 27;
                    break;
                case "V_MPEG2":
                    b2 = 28;
                    break;
                case "A_EAC3":
                    b2 = 29;
                    break;
                case "A_FLAC":
                    b2 = 30;
                    break;
                case "A_OPUS":
                    b2 = 31;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            String str5 = "audio/raw";
            switch (b2) {
                case 0:
                case 1:
                case 9:
                    byte[] bArr = this.ya;
                    listSingletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str5 = "video/mp4v-es";
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null && (cVarAu = com.applovin.exoplayer2.m.c.au(new y(this.yy))) != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i10 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i11 = i10 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue && (i5 = this.yc) != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        com.applovin.exoplayer2.m.b bVar = this.yi ? new com.applovin.exoplayer2.m.b(this.yj, this.yl, this.yk, iC()) : null;
                        if (this.name != null && d.wV.containsKey(this.name)) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0 || Float.compare(this.yf, 0.0f) != 0 || Float.compare(this.yg, 0.0f) != 0) {
                            i9 = iIntValue;
                        } else if (Float.compare(this.yh, 0.0f) != 0) {
                            if (Float.compare(this.yg, 90.0f) == 0) {
                                i9 = 90;
                            } else if (Float.compare(this.yg, -180.0f) == 0 || Float.compare(this.yg, 180.0f) == 0) {
                                i9 = 180;
                            } else if (Float.compare(this.yg, -90.0f) == 0) {
                                i9 = 270;
                            } else {
                                i9 = iIntValue;
                            }
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3) && !"text/x-ssa".equals(str3) && !"application/vobsub".equals(str3) && !"application/pgs".equals(str3) && !"application/dvbsubs".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null && !d.wV.containsKey(this.name)) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT = aVar.D(i).m(str3).I(i2).j(this.dq).E(i11).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY = jVar.y(this.xT, i8);
                    this.wl = xVarY;
                    xVarY.j(vVarBT);
                    return;
                case 2:
                    if (o(new y(H(this.xS)))) {
                        iFI = ai.fI(this.yz);
                        if (iFI == 0) {
                            q.h("MatroskaExtractor", "Unsupported PCM bit depth: " + this.yz + ". Setting mimeType to audio/x-unknown");
                        } else {
                            listSingletonList = null;
                            str = null;
                        }
                        i2 = -1;
                        if (this.yy != null) {
                            str = cVarAu.dw;
                            str5 = "video/dolby-vision";
                        }
                        str3 = str5;
                        int i12 = (this.yE ? 1 : 0) | 0;
                        if (this.yD) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i13 = i12 | i3;
                        aVar = new com.applovin.exoplayer2.v.a();
                        if (com.applovin.exoplayer2.l.u.aW(str3)) {
                            aVar.N(this.dL).O(this.dM).P(iFI);
                            i8 = 1;
                        } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                            if (this.yd == 0) {
                                i6 = this.yb;
                                iIntValue = -1;
                                if (i6 == -1) {
                                    i6 = this.dE;
                                }
                                this.yb = i6;
                                i7 = this.yc;
                                if (i7 == -1) {
                                    i7 = this.height;
                                }
                                this.yc = i7;
                            } else {
                                iIntValue = -1;
                            }
                            f = -1.0f;
                            i4 = this.yb;
                            if (i4 != iIntValue) {
                                f = (this.height * i4) / (this.dE * i5);
                            }
                            if (this.yi) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                            }
                            if (this.ye == 0) {
                                i9 = iIntValue;
                            } else {
                                i9 = iIntValue;
                            }
                            aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                            i8 = 2;
                        } else if (!"application/x-subrip".equals(str3)) {
                            throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                        }
                        if (this.name != null) {
                            aVar.h(this.name);
                        }
                        com.applovin.exoplayer2.v vVarBT2 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i13).c(listSingletonList).k(str).a(this.dC).bT();
                        x xVarY2 = jVar.y(this.xT, i8);
                        this.wl = xVarY2;
                        xVarY2.j(vVarBT2);
                        return;
                    }
                    q.h("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    listSingletonList = null;
                    str = null;
                    str5 = "audio/x-unknown";
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i14 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i15 = i14 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT3 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i15).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY3 = jVar.y(this.xT, i8);
                    this.wl = xVarY3;
                    xVarY3.j(vVarBT3);
                    return;
                case 3:
                    this.yC = new c();
                    str5 = "audio/true-hd";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i16 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i17 = i16 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT4 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i17).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY4 = jVar.y(this.xT, i8);
                    this.wl = xVarY4;
                    xVarY4.j(vVarBT4);
                    return;
                case 4:
                    i2 = 8192;
                    listSingletonList = v(H(this.xS));
                    str5 = "audio/vorbis";
                    str = null;
                    iFI = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i18 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i19 = i18 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT5 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i19).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY5 = jVar.y(this.xT, i8);
                    this.wl = xVarY5;
                    xVarY5.j(vVarBT5);
                    return;
                case 5:
                    str5 = "audio/mpeg-L2";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = 4096;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i110 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i111 = i110 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT6 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i111).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY6 = jVar.y(this.xT, i8);
                    this.wl = xVarY6;
                    xVarY6.j(vVarBT6);
                    return;
                case 6:
                    str5 = "audio/mpeg";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = 4096;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i112 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i113 = i112 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT7 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i113).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY7 = jVar.y(this.xT, i8);
                    this.wl = xVarY7;
                    xVarY7.j(vVarBT7);
                    return;
                case 7:
                    Pair<String, List<byte[]>> pairN = n(new y(H(this.xS)));
                    str5 = (String) pairN.first;
                    listSingletonList = (List) pairN.second;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i114 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i115 = i114 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT8 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i115).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY8 = jVar.y(this.xT, i8);
                    this.wl = xVarY8;
                    xVarY8.j(vVarBT8);
                    return;
                case 8:
                    byte[] bArr2 = new byte[4];
                    System.arraycopy(H(this.xS), 0, bArr2, 0, 4);
                    listSingletonList = s.u(bArr2);
                    str5 = "application/dvbsubs";
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i116 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i117 = i116 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT9 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i117).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY9 = jVar.y(this.xT, i8);
                    this.wl = xVarY9;
                    xVarY9.j(vVarBT9);
                    return;
                case 10:
                    com.applovin.exoplayer2.m.a aVarAs = com.applovin.exoplayer2.m.a.as(new y(H(this.xS)));
                    list = aVarAs.dB;
                    this.wo = aVarAs.wo;
                    str2 = aVarAs.dw;
                    str5 = "video/avc";
                    iFI = -1;
                    i2 = -1;
                    List<byte[]> list2 = list;
                    str = str2;
                    listSingletonList = list2;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i118 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i119 = i118 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT10 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i119).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY10 = jVar.y(this.xT, i8);
                    this.wl = xVarY10;
                    xVarY10.j(vVarBT10);
                    return;
                case 11:
                    listSingletonList = s.u(H(this.xS));
                    str = null;
                    str5 = "application/vobsub";
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1110 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i1111 = i1110 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT11 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i1111).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY11 = jVar.y(this.xT, i8);
                    this.wl = xVarY11;
                    xVarY11.j(vVarBT11);
                    return;
                case 12:
                    str5 = "audio/vnd.dts.hd";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1112 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i1113 = i1112 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT12 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i1113).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY12 = jVar.y(this.xT, i8);
                    this.wl = xVarY12;
                    xVarY12.j(vVarBT12);
                    return;
                case 13:
                    listSingletonList = Collections.singletonList(H(this.xS));
                    com.applovin.exoplayer2.b.a.C0076a c0076aB = com.applovin.exoplayer2.b.a.b(this.ya);
                    this.dM = c0076aB.js;
                    this.dL = c0076aB.dL;
                    str = c0076aB.dw;
                    str5 = "audio/mp4a-latm";
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1114 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i1115 = i1114 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT13 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i1115).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY13 = jVar.y(this.xT, i8);
                    this.wl = xVarY13;
                    xVarY13.j(vVarBT13);
                    return;
                case 14:
                    str5 = "audio/ac3";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1116 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i1117 = i1116 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT14 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i1117).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY14 = jVar.y(this.xT, i8);
                    this.wl = xVarY14;
                    xVarY14.j(vVarBT14);
                    return;
                case 15:
                case 21:
                    str5 = "audio/vnd.dts";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1118 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i1119 = i1118 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT15 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i1119).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY15 = jVar.y(this.xT, i8);
                    this.wl = xVarY15;
                    xVarY15.j(vVarBT15);
                    return;
                case 16:
                    str5 = MimeTypes.VIDEO_AV1;
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11110 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i11111 = i11110 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT16 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i11111).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY16 = jVar.y(this.xT, i8);
                    this.wl = xVarY16;
                    xVarY16.j(vVarBT16);
                    return;
                case 17:
                    str5 = "video/x-vnd.on2.vp8";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11112 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i11113 = i11112 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT17 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i11113).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY17 = jVar.y(this.xT, i8);
                    this.wl = xVarY17;
                    xVarY17.j(vVarBT17);
                    return;
                case 18:
                    str5 = "video/x-vnd.on2.vp9";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11114 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i11115 = i11114 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT18 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i11115).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY18 = jVar.y(this.xT, i8);
                    this.wl = xVarY18;
                    xVarY18.j(vVarBT18);
                    return;
                case 19:
                    listSingletonList = null;
                    str = null;
                    str5 = "application/pgs";
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11116 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i11117 = i11116 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT19 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i11117).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY19 = jVar.y(this.xT, i8);
                    this.wl = xVarY19;
                    xVarY19.j(vVarBT19);
                    return;
                case 20:
                    str5 = "video/x-unknown";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11118 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i11119 = i11118 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT110 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i11119).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY110 = jVar.y(this.xT, i8);
                    this.wl = xVarY110;
                    xVarY110.j(vVarBT110);
                    return;
                case 22:
                    if (this.yz == 32) {
                        listSingletonList = null;
                        str = null;
                    } else {
                        q.h("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + this.yz + ". Setting mimeType to audio/x-unknown");
                        listSingletonList = null;
                        str = null;
                        str5 = "audio/x-unknown";
                        iFI = -1;
                    }
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i111110 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i111111 = i111110 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT111 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i111111).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY111 = jVar.y(this.xT, i8);
                    this.wl = xVarY111;
                    xVarY111.j(vVarBT111);
                    return;
                case 23:
                    int i20 = this.yz;
                    if (i20 == 8) {
                        iFI = 3;
                    } else {
                        if (i20 != 16) {
                            q.h("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + this.yz + ". Setting mimeType to audio/x-unknown");
                            listSingletonList = null;
                            str = null;
                            str5 = "audio/x-unknown";
                            iFI = -1;
                            i2 = -1;
                            if (this.yy != null) {
                                str = cVarAu.dw;
                                str5 = "video/dolby-vision";
                            }
                            str3 = str5;
                            int i111112 = (this.yE ? 1 : 0) | 0;
                            if (this.yD) {
                                i3 = 2;
                            } else {
                                i3 = 0;
                            }
                            int i111113 = i111112 | i3;
                            aVar = new com.applovin.exoplayer2.v.a();
                            if (com.applovin.exoplayer2.l.u.aW(str3)) {
                                aVar.N(this.dL).O(this.dM).P(iFI);
                                i8 = 1;
                            } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                                if (this.yd == 0) {
                                    i6 = this.yb;
                                    iIntValue = -1;
                                    if (i6 == -1) {
                                        i6 = this.dE;
                                    }
                                    this.yb = i6;
                                    i7 = this.yc;
                                    if (i7 == -1) {
                                        i7 = this.height;
                                    }
                                    this.yc = i7;
                                } else {
                                    iIntValue = -1;
                                }
                                f = -1.0f;
                                i4 = this.yb;
                                if (i4 != iIntValue) {
                                    f = (this.height * i4) / (this.dE * i5);
                                }
                                if (this.yi) {
                                }
                                if (this.name != null) {
                                    iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                                }
                                if (this.ye == 0) {
                                    i9 = iIntValue;
                                } else {
                                    i9 = iIntValue;
                                }
                                aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                                i8 = 2;
                            } else if (!"application/x-subrip".equals(str3)) {
                                throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                            }
                            if (this.name != null) {
                                aVar.h(this.name);
                            }
                            com.applovin.exoplayer2.v vVarBT112 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i111113).c(listSingletonList).k(str).a(this.dC).bT();
                            x xVarY112 = jVar.y(this.xT, i8);
                            this.wl = xVarY112;
                            xVarY112.j(vVarBT112);
                            return;
                        }
                        iFI = 268435456;
                    }
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i111114 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i111115 = i111114 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT113 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i111115).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY113 = jVar.y(this.xT, i8);
                    this.wl = xVarY113;
                    xVarY113.j(vVarBT113);
                    return;
                case 24:
                    iFI = ai.fI(this.yz);
                    if (iFI == 0) {
                        q.h("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.yz + ". Setting mimeType to audio/x-unknown");
                        listSingletonList = null;
                        str = null;
                        str5 = "audio/x-unknown";
                        iFI = -1;
                    } else {
                        listSingletonList = null;
                        str = null;
                    }
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i111116 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i111117 = i111116 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT114 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i111117).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY114 = jVar.y(this.xT, i8);
                    this.wl = xVarY114;
                    xVarY114.j(vVarBT114);
                    return;
                case 25:
                    listSingletonList = s.k(d.wS, H(this.xS));
                    str = null;
                    str5 = "text/x-ssa";
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i111118 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i111119 = i111118 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT115 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i111119).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY115 = jVar.y(this.xT, i8);
                    this.wl = xVarY115;
                    xVarY115.j(vVarBT115);
                    return;
                case 26:
                    com.applovin.exoplayer2.m.f fVarAv = com.applovin.exoplayer2.m.f.av(new y(H(this.xS)));
                    list = fVarAv.dB;
                    this.wo = fVarAv.wo;
                    str2 = fVarAv.dw;
                    str5 = "video/hevc";
                    iFI = -1;
                    i2 = -1;
                    List<byte[]> list3 = list;
                    str = str2;
                    listSingletonList = list3;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111110 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i1111111 = i1111110 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT116 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i1111111).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY116 = jVar.y(this.xT, i8);
                    this.wl = xVarY116;
                    xVarY116.j(vVarBT116);
                    return;
                case 27:
                    listSingletonList = null;
                    str = null;
                    str5 = "application/x-subrip";
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111112 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i1111113 = i1111112 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT117 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i1111113).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY117 = jVar.y(this.xT, i8);
                    this.wl = xVarY117;
                    xVarY117.j(vVarBT117);
                    return;
                case 28:
                    str5 = "video/mpeg2";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111114 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i1111115 = i1111114 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT118 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i1111115).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY118 = jVar.y(this.xT, i8);
                    this.wl = xVarY118;
                    xVarY118.j(vVarBT118);
                    return;
                case 29:
                    str5 = "audio/eac3";
                    listSingletonList = null;
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111116 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i1111117 = i1111116 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT119 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i1111117).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY119 = jVar.y(this.xT, i8);
                    this.wl = xVarY119;
                    xVarY119.j(vVarBT119);
                    return;
                case 30:
                    listSingletonList = Collections.singletonList(H(this.xS));
                    str5 = "audio/flac";
                    str = null;
                    iFI = -1;
                    i2 = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i1111118 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i1111119 = i1111118 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT1110 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i1111119).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY1110 = jVar.y(this.xT, i8);
                    this.wl = xVarY1110;
                    xVarY1110.j(vVarBT1110);
                    return;
                case 31:
                    i2 = 5760;
                    listSingletonList = new ArrayList<>(3);
                    listSingletonList.add(H(this.xS));
                    listSingletonList.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.yA).array());
                    listSingletonList.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.yB).array());
                    str5 = "audio/opus";
                    str = null;
                    iFI = -1;
                    if (this.yy != null) {
                        str = cVarAu.dw;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i11111110 = (this.yE ? 1 : 0) | 0;
                    if (this.yD) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    int i11111111 = i11111110 | i3;
                    aVar = new com.applovin.exoplayer2.v.a();
                    if (com.applovin.exoplayer2.l.u.aW(str3)) {
                        aVar.N(this.dL).O(this.dM).P(iFI);
                        i8 = 1;
                    } else if (com.applovin.exoplayer2.l.u.aX(str3)) {
                        if (this.yd == 0) {
                            i6 = this.yb;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.dE;
                            }
                            this.yb = i6;
                            i7 = this.yc;
                            if (i7 == -1) {
                                i7 = this.height;
                            }
                            this.yc = i7;
                        } else {
                            iIntValue = -1;
                        }
                        f = -1.0f;
                        i4 = this.yb;
                        if (i4 != iIntValue) {
                            f = (this.height * i4) / (this.dE * i5);
                        }
                        if (this.yi) {
                        }
                        if (this.name != null) {
                            iIntValue = ((Integer) d.wV.get(this.name)).intValue();
                        }
                        if (this.ye == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        aVar.J(this.dE).K(this.height).e(f).L(i9).a(this.dI).M(this.dJ).a(bVar);
                        i8 = 2;
                    } else if (!"application/x-subrip".equals(str3)) {
                        throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", null);
                    }
                    if (this.name != null) {
                        aVar.h(this.name);
                    }
                    com.applovin.exoplayer2.v vVarBT1111 = aVar.D(i).m(str3).I(i2).j(this.dq).E(i11111111).c(listSingletonList).k(str).a(this.dC).bT();
                    x xVarY1111 = jVar.y(this.xT, i8);
                    this.wl = xVarY1111;
                    xVarY1111.j(vVarBT1111);
                    return;
                default:
                    throw com.applovin.exoplayer2.ai.c("Unrecognized codec identifier.", null);
            }
        }

        public void iB() {
            c cVar = this.yC;
            if (cVar != null) {
                cVar.c(this);
            }
        }

        public void Y() {
            c cVar = this.yC;
            if (cVar != null) {
                cVar.Y();
            }
        }

        private byte[] iC() {
            if (this.yo == -1.0f || this.yp == -1.0f || this.yq == -1.0f || this.yr == -1.0f || this.ys == -1.0f || this.yt == -1.0f || this.yu == -1.0f || this.yv == -1.0f || this.yw == -1.0f || this.yx == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.yo * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.yp * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.yq * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.yr * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.ys * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.yt * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.yu * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.yv * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.yw + 0.5f));
            byteBufferOrder.putShort((short) (this.yx + 0.5f));
            byteBufferOrder.putShort((short) this.ym);
            byteBufferOrder.putShort((short) this.yn);
            return bArr;
        }

        private static Pair<String, List<byte[]>> n(y yVar) throws com.applovin.exoplayer2.ai {
            try {
                yVar.fz(16);
                long jPw = yVar.pw();
                if (jPw == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (jPw == 859189832) {
                    return new Pair<>("video/3gpp", null);
                }
                if (jPw == 826496599) {
                    byte[] bArrHO = yVar.hO();
                    for (int iIl = yVar.il() + 20; iIl < bArrHO.length - 4; iIl++) {
                        if (bArrHO[iIl] == 0 && bArrHO[iIl + 1] == 0 && bArrHO[iIl + 2] == 1 && bArrHO[iIl + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrHO, iIl, bArrHO.length)));
                        }
                    }
                    throw com.applovin.exoplayer2.ai.c("Failed to find FourCC VC1 initialization data", null);
                }
                q.h("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw com.applovin.exoplayer2.ai.c("Error parsing FourCC private data", null);
            }
        }

        private static List<byte[]> v(byte[] bArr) throws com.applovin.exoplayer2.ai {
            try {
                if (bArr[0] != 2) {
                    throw com.applovin.exoplayer2.ai.c("Error parsing vorbis codec private", null);
                }
                int i = 0;
                int i2 = 1;
                while ((bArr[i2] & 255) == 255) {
                    i += 255;
                    i2++;
                }
                int i3 = i2 + 1;
                int i4 = i + (bArr[i2] & 255);
                int i5 = 0;
                while ((bArr[i3] & 255) == 255) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + (bArr[i3] & 255);
                if (bArr[i6] != 1) {
                    throw com.applovin.exoplayer2.ai.c("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i6, bArr2, 0, i4);
                int i8 = i6 + i4;
                if (bArr[i8] != 3) {
                    throw com.applovin.exoplayer2.ai.c("Error parsing vorbis codec private", null);
                }
                int i9 = i8 + i7;
                if (bArr[i9] != 5) {
                    throw com.applovin.exoplayer2.ai.c("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i9];
                System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw com.applovin.exoplayer2.ai.c("Error parsing vorbis codec private", null);
            }
        }

        private static boolean o(y yVar) throws com.applovin.exoplayer2.ai {
            try {
                int iPq = yVar.pq();
                if (iPq == 1) {
                    return true;
                }
                if (iPq != 65534) {
                    return false;
                }
                yVar.fx(24);
                return yVar.pz() == d.wU.getMostSignificantBits() && yVar.pz() == d.wU.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw com.applovin.exoplayer2.ai.c("Error parsing MS/ACM codec private", null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iD() {
            com.applovin.exoplayer2.l.a.checkNotNull(this.wl);
        }

        private byte[] H(String str) throws com.applovin.exoplayer2.ai {
            byte[] bArr = this.ya;
            if (bArr != null) {
                return bArr;
            }
            throw com.applovin.exoplayer2.ai.c("Missing CodecPrivate for codec " + str, null);
        }
    }
}
