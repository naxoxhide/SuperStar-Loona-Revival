package b.b.a.a.d.d.i;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FlexComputeRuler.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public static float a(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<a.C0024a> a(float f, List<a.C0024a> list) {
        ArrayList<a.C0024a> arrayList = new ArrayList();
        Iterator<a.C0024a> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((a.C0024a) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (a.C0024a c0024a : arrayList) {
            if (c0024a.f94b) {
                i = (int) (i + c0024a.a);
            } else {
                i2 = (int) (i2 + c0024a.a);
                z = false;
            }
        }
        if (z && f > i) {
            return arrayList;
        }
        float f2 = i;
        float f3 = f < f2 ? f / f2 : 1.0f;
        float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (a.C0024a c0024a2 : arrayList) {
                if (!c0024a2.f94b) {
                    float f5 = c0024a2.c;
                    if (f5 != 0.0f && c0024a2.a * f4 > f5) {
                        c0024a2.a = f5;
                        c0024a2.f94b = true;
                        z2 = true;
                    }
                }
                arrayList2.add(c0024a2);
            }
            if (z2) {
                return a(f, arrayList2);
            }
        }
        int i3 = 0;
        for (a.C0024a c0024a3 : arrayList) {
            if (c0024a3.f94b) {
                c0024a3.a = a(c0024a3.a * f3);
            } else {
                c0024a3.a = a(c0024a3.a * f4);
            }
            i3 = (int) (i3 + c0024a3.a);
        }
        float f6 = i3;
        if (f6 < f) {
            float f7 = f - f6;
            for (int size = 0; size < arrayList.size() && f7 > 0.0f; size = (size + 1) % arrayList.size()) {
                a.C0024a c0024a4 = (a.C0024a) arrayList.get(size);
                if ((f < f2 && c0024a4.f94b) || (f > f2 && !c0024a4.f94b)) {
                    c0024a4.a += 0.0625f;
                    f7 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
