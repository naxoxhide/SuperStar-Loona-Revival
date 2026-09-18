package com.facebook.ads.redexgen.X;

import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class VN extends GR {
    public static String[] A01 = {"JXADnguvwbjBsYgslHoSHgr2xxMnawNn", "", "jNEAQ3UZ70aM1hHDYV2CS20ieNSkmYbb", "bnkACY5tQbsoiCdyBJgaOjSRI0w0kmrQ", "gVGuKveDeddXJzh5PaouiQlIwgfOoZnh", "qzMEUGGJ0FpDLYRljtzJ24rj8XT6rBKz", "LijUR", "ZVB7ZDT4TSe2rtQPBLBW6RwhtV59NTLq"};
    public GM A00;

    public abstract Pair<C08069t[], GO[]> A0V(GM gm, int[][][] iArr, int[] iArr2) throws C9K;

    public static int A0Q(InterfaceC08059s[] interfaceC08059sArr, TrackGroup trackGroup) throws C9K {
        int formatSupportLevel = interfaceC08059sArr.length;
        int trackIndex = 0;
        for (int i = 0; i < bestRendererIndex; i++) {
            InterfaceC08059s interfaceC08059s = interfaceC08059sArr[i];
            for (int bestFormatSupportLevel = 0; bestFormatSupportLevel < bestRendererIndex; bestFormatSupportLevel++) {
                int bestRendererIndex = interfaceC08059s.AFt(trackGroup.A01(bestFormatSupportLevel));
                int bestRendererIndex2 = bestRendererIndex & 7;
                if (bestRendererIndex2 > trackIndex) {
                    formatSupportLevel = i;
                    trackIndex = bestRendererIndex2;
                    if (trackIndex == 4) {
                        return formatSupportLevel;
                    }
                }
            }
        }
        return formatSupportLevel;
    }

    public static int[] A0R(InterfaceC08059s interfaceC08059s, TrackGroup trackGroup) throws C9K {
        int[] iArr = new int[trackGroup.A01];
        for (int i = 0; i < trackGroup.A01; i++) {
            iArr[i] = interfaceC08059s.AFt(trackGroup.A01(i));
        }
        return iArr;
    }

    public static int[] A0S(InterfaceC08059s[] interfaceC08059sArr) throws C9K {
        int[] iArr = new int[interfaceC08059sArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = interfaceC08059sArr[i].AFv();
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0067  */
    /* JADX WARN: Code duplicated, block: B:22:0x008d  */
    /* JADX WARN: Code duplicated, block: B:24:0x009d  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a2  */
    @Override // com.facebook.ads.redexgen.X.GR
    public final GS A0T(InterfaceC08059s[] interfaceC08059sArr, TrackGroupArray trackGroupArray) throws C9K {
        InterfaceC08059s interfaceC08059s;
        int[] iArrA0R;
        int[] iArr = new int[interfaceC08059sArr.length + 1];
        TrackGroup[][] trackGroupArr = new TrackGroup[interfaceC08059sArr.length + 1][];
        int[][][] iArr2 = new int[interfaceC08059sArr.length + 1][][];
        for (int i = 0; i < trackGroupArr.length; i++) {
            trackGroupArr[i] = new TrackGroup[trackGroupArray.A01];
            iArr2[i] = new int[trackGroupArray.A01][];
            if (A01[2].charAt(17) != 'V') {
                throw new RuntimeException();
            }
            A01[1] = "";
        }
        int[] iArrA0S = A0S(interfaceC08059sArr);
        for (int i2 = 0; i2 < trackGroupArray.A01; i2++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i2);
            int iA0Q = A0Q(interfaceC08059sArr, trackGroupA01);
            int groupIndex = interfaceC08059sArr.length;
            if (A01[4].charAt(3) != 'u') {
                A01[6] = "flHuZy9qfiSfYNp536tqdaojA4";
                if (iA0Q == groupIndex) {
                    iArrA0R = new int[trackGroupA01.A01];
                } else {
                    interfaceC08059s = interfaceC08059sArr[iA0Q];
                    if (A01[4].charAt(3) != 'u') {
                        iArrA0R = A0R(interfaceC08059s, trackGroupA01);
                    } else {
                        A01[1] = "";
                        iArrA0R = A0R(interfaceC08059s, trackGroupA01);
                    }
                }
            } else {
                String[] strArr = A01;
                strArr[7] = "D4rc1OneeydPNAn3BWDV4yQ6n9XdhHzA";
                strArr[3] = "1lNTPVAxZlA71NpHB66K3LVNnVnwQcNq";
                if (iA0Q == groupIndex) {
                    iArrA0R = new int[trackGroupA01.A01];
                } else {
                    interfaceC08059s = interfaceC08059sArr[iA0Q];
                    if (A01[4].charAt(3) != 'u') {
                        iArrA0R = A0R(interfaceC08059s, trackGroupA01);
                    } else {
                        A01[1] = "";
                        iArrA0R = A0R(interfaceC08059s, trackGroupA01);
                    }
                }
            }
            int i3 = iArr[iA0Q];
            trackGroupArr[iA0Q][i3] = trackGroupA01;
            iArr2[iA0Q][i3] = iArrA0R;
            iArr[iA0Q] = iArr[iA0Q] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[interfaceC08059sArr.length];
        int[] iArr3 = new int[interfaceC08059sArr.length];
        for (int i4 = 0; i4 < interfaceC08059sArr.length; i4++) {
            int i5 = iArr[i4];
            trackGroupArrayArr[i4] = new TrackGroupArray((TrackGroup[]) C0996Hx.A0k(trackGroupArr[i4], i5));
            iArr2[i4] = (int[][]) C0996Hx.A0k(iArr2[i4], i5);
            iArr3[i4] = interfaceC08059sArr[i4].A83();
        }
        GM gm = new GM(iArr3, trackGroupArrayArr, iArrA0S, iArr2, new TrackGroupArray((TrackGroup[]) C0996Hx.A0k(trackGroupArr[interfaceC08059sArr.length], iArr[interfaceC08059sArr.length])));
        Pair<C08069t[], GO[]> pairA0V = A0V(gm, iArr2, iArrA0S);
        return new GS((C08069t[]) pairA0V.first, (GO[]) pairA0V.second, gm);
    }

    @Override // com.facebook.ads.redexgen.X.GR
    public final void A0U(Object obj) {
        this.A00 = (GM) obj;
    }
}
