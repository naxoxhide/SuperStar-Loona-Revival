package com.applovin.exoplayer2.k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class y {
    private static final Comparator<a> abn = new Comparator() { // from class: com.applovin.exoplayer2.k.-$$Lambda$y$8n_Lcv9p7v-SWefFmW29wK0TXJk
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return y.b((y.a) obj, (y.a) obj2);
        }
    };
    private static final Comparator<a> abo = new Comparator() { // from class: com.applovin.exoplayer2.k.-$$Lambda$y$bHlr1BkRNrxHEFlPWWns3ysS0ow
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return y.a((y.a) obj, (y.a) obj2);
        }
    };
    private final int abp;
    private int abt;
    private int abu;
    private int abv;
    private final a[] abr = new a[5];
    private final ArrayList<a> abq = new ArrayList<>();
    private int abs = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(a aVar, a aVar2) {
        return aVar.Y - aVar2.Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(a aVar, a aVar2) {
        return Float.compare(aVar.abx, aVar2.abx);
    }

    public y(int i) {
        this.abp = i;
    }

    public void Y() {
        this.abq.clear();
        this.abs = -1;
        this.abt = 0;
        this.abu = 0;
    }

    public void e(int i, float f) {
        a aVar;
        oF();
        int i2 = this.abv;
        if (i2 > 0) {
            a[] aVarArr = this.abr;
            int i3 = i2 - 1;
            this.abv = i3;
            aVar = aVarArr[i3];
        } else {
            aVar = new a();
        }
        int i4 = this.abt;
        this.abt = i4 + 1;
        aVar.Y = i4;
        aVar.abw = i;
        aVar.abx = f;
        this.abq.add(aVar);
        this.abu += i;
        while (true) {
            int i5 = this.abu;
            int i6 = this.abp;
            if (i5 <= i6) {
                return;
            }
            int i7 = i5 - i6;
            a aVar2 = this.abq.get(0);
            if (aVar2.abw <= i7) {
                this.abu -= aVar2.abw;
                this.abq.remove(0);
                int i8 = this.abv;
                if (i8 < 5) {
                    a[] aVarArr2 = this.abr;
                    this.abv = i8 + 1;
                    aVarArr2[i8] = aVar2;
                }
            } else {
                aVar2.abw -= i7;
                this.abu -= i7;
            }
        }
    }

    public float x(float f) {
        oG();
        float f2 = f * this.abu;
        int i = 0;
        for (int i2 = 0; i2 < this.abq.size(); i2++) {
            a aVar = this.abq.get(i2);
            i += aVar.abw;
            if (i >= f2) {
                return aVar.abx;
            }
        }
        if (this.abq.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<a> arrayList = this.abq;
        return arrayList.get(arrayList.size() - 1).abx;
    }

    private void oF() {
        if (this.abs != 1) {
            Collections.sort(this.abq, abn);
            this.abs = 1;
        }
    }

    private void oG() {
        if (this.abs != 0) {
            Collections.sort(this.abq, abo);
            this.abs = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a {
        public int Y;
        public int abw;
        public float abx;

        private a() {
        }
    }
}
