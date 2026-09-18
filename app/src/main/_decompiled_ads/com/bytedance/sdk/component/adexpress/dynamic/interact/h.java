package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;

/* JADX INFO: compiled from: InteractViewFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v0 int, still in use, count: 8, list:
      (r6v0 int) from 0x0018: IF  (r6v0 int) != (48 int)  -> B:9:0x001a A[HIDDEN]
      (r6v0 int) from 0x001c: IF  (r6v0 int) != (50 int)  -> B:11:0x001e A[HIDDEN]
      (r6v0 int) from 0x0020: IF  (r6v0 int) != (1598 int)  -> B:13:0x0022 A[HIDDEN]
      (r6v0 int) from 0x0024: IF  (r6v0 int) != (1600 int)  -> B:15:0x0026 A[HIDDEN]
      (r6v0 int) from 0x0028: IF  (r6v0 int) != (1602 int)  -> B:17:0x002a A[HIDDEN]
      (r6v0 int) from 0x002c: IF  (r6v0 int) != (1607 int)  -> B:19:0x002e A[HIDDEN]
      (r6v0 int) from 0x0031: SWITCH (r6v0 int)
     case 1567: goto B:51:0x009b
     case 1568: goto B:47:0x008d
     case 1569: goto B:43:0x007f
     case 1570: goto B:39:0x0071
     case 1571: goto B:35:0x0063
     default: goto B:21:0x0034 A[RegionRef:SW:20]
      (r6v0 int) from 0x0034: SWITCH (r6v0 int)
     case 1573: goto B:31:0x0055
     case 1574: goto B:27:0x0047
     case 1575: goto B:23:0x0039
     default: goto B:99:0x012a A[RegionRef:SW:21]
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
    public static f a(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar, int i, int i2, int i3, int i4) {
        if (context == null || dynamicBaseWidget == null || gVar == null) {
            return null;
        }
        String strD = gVar.D();
        strD.hashCode();
        byte b2 = -1;
        if (iHashCode != 48) {
            if (iHashCode != 50) {
                if (iHashCode != 1598) {
                    if (iHashCode != 1600) {
                        if (iHashCode != 1602) {
                            if (iHashCode != 1607) {
                                switch (strD) {
                                    case "5":
                                        b2 = 2;
                                        break;
                                    case "6":
                                        b2 = 3;
                                        break;
                                    case "7":
                                        b2 = 4;
                                        break;
                                    case "8":
                                        b2 = 5;
                                        break;
                                    case "9":
                                        b2 = 6;
                                        break;
                                    default:
                                        switch (strD) {
                                            case 1567:
                                                if (strD.equals("10")) {
                                                    b2 = 7;
                                                }
                                                break;
                                            case 1568:
                                                if (strD.equals("11")) {
                                                    b2 = 8;
                                                }
                                                break;
                                            case 1569:
                                                if (strD.equals("12")) {
                                                    b2 = 9;
                                                }
                                                break;
                                            case 1570:
                                                if (strD.equals("13")) {
                                                    b2 = 10;
                                                }
                                                break;
                                            case 1571:
                                                if (strD.equals("14")) {
                                                    b2 = 11;
                                                }
                                                break;
                                            default:
                                                switch (iHashCode) {
                                                    case 1573:
                                                        if (strD.equals("16")) {
                                                            b2 = 12;
                                                        }
                                                        break;
                                                    case 1574:
                                                        if (strD.equals("17")) {
                                                            b2 = 13;
                                                        }
                                                        break;
                                                    case 1575:
                                                        if (strD.equals("18")) {
                                                            b2 = 14;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                }
                            } else if (strD.equals("29")) {
                                b2 = 18;
                            }
                        } else if (strD.equals("24")) {
                            b2 = 17;
                        }
                    } else if (strD.equals("22")) {
                        b2 = 16;
                    }
                } else if (strD.equals("20")) {
                    b2 = 15;
                }
            } else if (strD.equals("2")) {
                b2 = 1;
            }
        } else if (strD.equals("0")) {
            b2 = 0;
        }
        switch (b2) {
            case 0:
                return new c(context, dynamicBaseWidget, gVar);
            case 1:
                return new b(context, dynamicBaseWidget, gVar);
            case 2:
                return gVar.A() == 1 ? new o(context, dynamicBaseWidget, gVar, gVar.C()) : new m(context, dynamicBaseWidget, gVar);
            case 3:
            case 8:
                return new k(context, dynamicBaseWidget, gVar);
            case 4:
            case 11:
                return new i(context, dynamicBaseWidget, gVar);
            case 5:
                return new j(context, dynamicBaseWidget, gVar);
            case 6:
            case 12:
                return new l(context, dynamicBaseWidget, gVar, strD, i, i2, i4);
            case 7:
                return new d(context, dynamicBaseWidget, gVar);
            case 9:
                return new m(context, dynamicBaseWidget, gVar);
            case 10:
                return new o(context, dynamicBaseWidget, gVar);
            case 13:
            case 14:
                return new q(context, dynamicBaseWidget, gVar, strD, i3);
            case 15:
                return new a(context, dynamicBaseWidget, gVar);
            case 16:
                return b.b.a.a.d.c.c() ? new n(context, dynamicBaseWidget, gVar) : new p(context, dynamicBaseWidget, gVar);
            case 17:
                return new n(context, dynamicBaseWidget, gVar);
            case 18:
                return new e(context, dynamicBaseWidget, gVar, i, i2, i4);
            default:
                return null;
        }
    }
}
