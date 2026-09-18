package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Do, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC0885Do implements Runnable {
    public final /* synthetic */ RunnableC0886Dp A00;
    public final /* synthetic */ DownloadAction[] A01;

    public RunnableC0885Do(RunnableC0886Dp runnableC0886Dp, DownloadAction[] downloadActionArr) {
        this.A00 = runnableC0886Dp;
        this.A01 = downloadActionArr;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            if (this.A00.A00.A03) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.A00.A00.A0C);
            this.A00.A00.A0C.clear();
            for (DownloadAction downloadAction : this.A01) {
                this.A00.A00.A02(downloadAction);
            }
            this.A00.A00.A02 = true;
            Iterator it = this.A00.A00.A0D.iterator();
            while (it.hasNext()) {
                ((InterfaceC0888Dr) it.next()).ABa(this.A00.A00);
            }
            if (!arrayList.isEmpty()) {
                this.A00.A00.A0C.addAll(arrayList);
                this.A00.A00.A0B();
            }
            this.A00.A00.A0A();
            for (int i = 0; i < this.A00.A00.A0C.size(); i++) {
                RunnableC0892Dv runnableC0892Dv = (RunnableC0892Dv) this.A00.A00.A0C.get(i);
                if (runnableC0892Dv.A06 == 0) {
                    this.A00.A00.A0D(runnableC0892Dv);
                }
            }
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
