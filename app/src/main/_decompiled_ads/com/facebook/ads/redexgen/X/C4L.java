package com.facebook.ads.redexgen.X;

import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4L, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C4L {
    public static String[] A01 = {"1CU3iw4Trc3qggngkxP7P26jEGLrLZaR", "qcH7HKgKdAybLTWn0rmK7JyCE0S9C8rn", "oNJ0dA1Zpt4CixMfeWT18n5RxX88Y0E3", "FZ8N3xW3PfzdZjJWrErZ2QIuE13XuJtD", "DvPOKoiXqOiYMgjx6IqCziqOSBLzEcJY", "MpMZeZ7xc490HXAXJonG5r1KTyiIoUHH", "NGMd8PbmdSzgSLgNcWdVjgLa", "jY1Ixh6DMe9BpV8yAbg842YJP45AQ2Eb"};
    public final C4K A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private int A00(List<C06673x> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).A00 != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final void A05(List<C06673x> list) {
        while (true) {
            int iA00 = A00(list);
            if (iA00 == -1) {
                return;
            } else {
                A01(list, iA00, iA00 + 1);
            }
        }
    }

    public C4L(C4K c4k) {
        this.A00 = c4k;
    }

    private void A01(List<C06673x> list, int i, int i2) {
        C06673x c06673x = list.get(i);
        C06673x c06673x2 = list.get(i2);
        switch (c06673x2.A00) {
            case 1:
                A02(list, i, c06673x, i2, c06673x2);
                break;
            case 2:
                A03(list, i, c06673x, i2, c06673x2);
                break;
            case 4:
                A04(list, i, c06673x, i2, c06673x2);
                break;
        }
    }

    private void A02(List<C06673x> list, int i, C06673x c06673x, int i2, C06673x c06673x2) {
        int i3 = 0;
        int i4 = c06673x.A01;
        int offset = c06673x2.A02;
        if (i4 < offset) {
            i3 = 0 - 1;
        }
        int i5 = c06673x.A02;
        int offset2 = c06673x2.A02;
        if (i5 < offset2) {
            i3++;
        }
        int i6 = c06673x2.A02;
        int offset3 = c06673x.A02;
        if (i6 <= offset3) {
            int i7 = c06673x.A02;
            int offset4 = c06673x2.A01;
            c06673x.A02 = i7 + offset4;
        }
        int i8 = c06673x2.A02;
        int offset5 = c06673x.A01;
        if (i8 <= offset5) {
            int i9 = c06673x.A01;
            int offset6 = c06673x2.A01;
            c06673x.A01 = i9 + offset6;
        }
        int offset7 = c06673x2.A02;
        c06673x2.A02 = offset7 + i3;
        list.set(i, c06673x2);
        list.set(i2, c06673x);
    }

    private final void A03(List<C06673x> list, int i, C06673x c06673x, int i2, C06673x c06673x2) {
        boolean z;
        C06673x c06673xAAI = null;
        boolean z2 = false;
        if (c06673x.A02 < c06673x.A01) {
            z = false;
            if (c06673x2.A02 == c06673x.A02 && c06673x2.A01 == c06673x.A01 - c06673x.A02) {
                z2 = true;
            }
        } else {
            z = true;
            if (c06673x2.A02 == c06673x.A01 + 1) {
                int remaining = c06673x2.A01;
                if (remaining == c06673x.A02 - c06673x.A01) {
                    z2 = true;
                }
            }
        }
        if (c06673x.A01 < c06673x2.A02) {
            c06673x2.A02--;
        } else {
            int remaining2 = c06673x.A01;
            if (remaining2 < c06673x2.A02 + c06673x2.A01) {
                c06673x2.A01--;
                c06673x.A00 = 2;
                c06673x.A01 = 1;
                int remaining3 = c06673x2.A01;
                if (A01[6].length() == 11) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[2] = "8AUTweiK2qHuqKAjuAP9RAHRjtqC9cI5";
                strArr[3] = "fxjAamJyQJjVOLb9u9QxKoC9co41mLuZ";
                if (remaining3 == 0) {
                    list.remove(i2);
                    this.A00.AEJ(c06673x2);
                    return;
                }
                return;
            }
        }
        if (c06673x.A02 <= c06673x2.A02) {
            c06673x2.A02++;
        } else if (c06673x.A02 < c06673x2.A02 + c06673x2.A01) {
            int remaining4 = (c06673x2.A02 + c06673x2.A01) - c06673x.A02;
            c06673xAAI = this.A00.AAI(2, c06673x.A02 + 1, remaining4, null);
            c06673x2.A01 = c06673x.A02 - c06673x2.A02;
        }
        if (z2) {
            list.set(i, c06673x2);
            list.remove(i2);
            this.A00.AEJ(c06673x);
            return;
        }
        if (z) {
            if (c06673xAAI != null) {
                if (c06673x.A02 > c06673xAAI.A02) {
                    c06673x.A02 -= c06673xAAI.A01;
                }
                if (c06673x.A01 > c06673xAAI.A02) {
                    c06673x.A01 -= c06673xAAI.A01;
                }
            }
            if (c06673x.A02 > c06673x2.A02) {
                c06673x.A02 -= c06673x2.A01;
            }
            if (c06673x.A01 > c06673x2.A02) {
                c06673x.A01 -= c06673x2.A01;
            }
        } else {
            if (c06673xAAI != null) {
                if (c06673x.A02 >= c06673xAAI.A02) {
                    c06673x.A02 -= c06673xAAI.A01;
                }
                if (c06673x.A01 >= c06673xAAI.A02) {
                    c06673x.A01 -= c06673xAAI.A01;
                }
            }
            if (c06673x.A02 >= c06673x2.A02) {
                c06673x.A02 -= c06673x2.A01;
            }
            if (c06673x.A01 >= c06673x2.A02) {
                c06673x.A01 -= c06673x2.A01;
            }
        }
        list.set(i, c06673x2);
        String[] strArr2 = A01;
        if (strArr2[1].charAt(7) == strArr2[5].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr3 = A01;
        strArr3[1] = "R1vl9Esi4EQuoIO0IEs3BYKA9Bp2yfIo";
        strArr3[5] = "ll7MLLjNdpT1F8Cd0W3dCYnGe1w6KT9M";
        if (c06673x.A02 != c06673x.A01) {
            list.set(i2, c06673x);
        } else {
            list.remove(i2);
        }
        if (c06673xAAI != null) {
            list.add(i, c06673xAAI);
        }
    }

    private final void A04(List<C06673x> list, int i, C06673x c06673x, int i2, C06673x c06673x2) {
        C06673x c06673xAAI = null;
        C06673x c06673xAAI2 = null;
        if (c06673x.A01 < c06673x2.A02) {
            c06673x2.A02--;
        } else {
            int remaining = c06673x.A01;
            if (remaining < c06673x2.A02 + c06673x2.A01) {
                c06673x2.A01--;
                c06673xAAI = this.A00.AAI(4, c06673x.A02, 1, c06673x2.A03);
            }
        }
        if (c06673x.A02 <= c06673x2.A02) {
            c06673x2.A02++;
        } else if (c06673x.A02 < c06673x2.A02 + c06673x2.A01) {
            int i3 = (c06673x2.A02 + c06673x2.A01) - c06673x.A02;
            c06673xAAI2 = this.A00.AAI(4, c06673x.A02 + 1, i3, c06673x2.A03);
            c06673x2.A01 -= i3;
        }
        list.set(i2, c06673x);
        if (c06673x2.A01 > 0) {
            list.set(i, c06673x2);
        } else {
            list.remove(i);
            this.A00.AEJ(c06673x2);
        }
        if (c06673xAAI != null) {
            list.add(i, c06673xAAI);
        }
        if (c06673xAAI2 != null) {
            list.add(i, c06673xAAI2);
        }
    }
}
