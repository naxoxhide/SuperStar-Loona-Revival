package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import com.google.common.primitives.SignedBytes;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0895Dy {
    public static byte[] A0F;
    public static String[] A0G = {"68X6mTnOwXdfZzYVO84LiBNlITu89iQX", "mcCM", "SB1U", "GkXNtRrGsWIfNkCQn88aLdXmD8Z6vhvm", "Qey5CsRmzWj382X", "n9", "Qz1jsOzCfP5BXHleCyslZPCOD1Jlt2Hf", "OEfF4KTHhKUz1ci9ksApPyeCZN0rEDYT"};
    public int A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public final int A04;
    public final int A05;
    public final Handler A06;
    public final Handler A07;
    public final HandlerThread A08;
    public final C0877De A09;
    public final E3 A0A;
    public final ArrayList<RunnableC0892Dv> A0B;
    public final ArrayList<RunnableC0892Dv> A0C;
    public final CopyOnWriteArraySet<InterfaceC0888Dr> A0D;
    public final DownloadAction.Deserializer[] A0E;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A0F = new byte[]{6, 69, 74, 71, 85, 78, 67, 85, 6, 81, 79, 82, 78, 6, 62, 36, SignedBytes.MAX_POWER_OF_TWO, 117, 33, 109, 100, 96, 114, 117, 33, 110, 111, 100, 33, 69, 100, 114, 100, 115, 104, 96, 109, 104, 123, 100, 115, 33, 104, 114, 33, 115, 100, 112, 116, 104, 115, 100, 101, 47, 82, 121, 97, 120, 122, 121, 119, 114, 91, 119, 120, 119, 113, 115, 100, 54, 112, 127, 122, 115, 54, 127, 57, 121, 42, 31, 13, 21, 94, 23, 13, 94, 31, 26, 26, 27, 26, 9, 60, 46, 54, 125, 46, 41, 60, 41, 56, 125, 52, 46, 125, 62, 53, 60, 51, 58, 56, 57};
    }

    static {
        A0C();
    }

    public C0895Dy(E3 e3, int i, int i2, File file, DownloadAction.Deserializer... deserializerArr) {
        HI.A05(deserializerArr.length > 0, A05(16, 38, 36));
        this.A0A = e3;
        this.A04 = i;
        this.A05 = i2;
        this.A09 = new C0877De(file);
        this.A0E = deserializerArr;
        this.A01 = true;
        this.A0C = new ArrayList<>();
        this.A0B = new ArrayList<>();
        Looper looperMyLooper = Looper.myLooper();
        this.A07 = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper);
        HandlerThread handlerThread = new HandlerThread(A05(54, 24, 51));
        this.A08 = handlerThread;
        handlerThread.start();
        this.A06 = new Handler(handlerThread.getLooper());
        this.A0D = new CopyOnWriteArraySet<>();
        A08();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RunnableC0892Dv A02(DownloadAction downloadAction) {
        int i = this.A00;
        this.A00 = i + 1;
        RunnableC0892Dv runnableC0892Dv = new RunnableC0892Dv(i, this, downloadAction, this.A05, null);
        this.A0C.add(runnableC0892Dv);
        A0J(A05(78, 13, 91), runnableC0892Dv);
        return runnableC0892Dv;
    }

    private void A08() {
        this.A06.post(new RunnableC0886Dp(this));
    }

    private void A09() {
        if (!A0R()) {
            return;
        }
        Iterator<InterfaceC0888Dr> it = this.A0D.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0G[3].charAt(7) == 'd') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[5] = "Uj";
            strArr[4] = "M47RheKcpZxFkBs";
            if (zHasNext) {
                it.next().ABW(this);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        DownloadAction downloadAction;
        boolean canStartTask;
        if (!this.A02 || this.A03) {
            return;
        }
        boolean skipDownloadActions = this.A01 || this.A0B.size() == this.A04;
        for (int i = 0; i < this.A0C.size(); i++) {
            RunnableC0892Dv runnableC0892Dv = this.A0C.get(i);
            boolean zA0E = runnableC0892Dv.A0E();
            if (A0G[0].charAt(7) == 'Z') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[5] = "ZZ";
            strArr[4] = "k3SOhcJE6F5rWIN";
            if (zA0E && ((canStartTask = (downloadAction = runnableC0892Dv.A04).A03) || !skipDownloadActions)) {
                boolean z = true;
                for (int i2 = 0; i2 < i; i2++) {
                    RunnableC0892Dv runnableC0892Dv2 = this.A0C.get(i2);
                    if (runnableC0892Dv2.A04.A09(downloadAction)) {
                        if (!canStartTask) {
                            if (runnableC0892Dv2.A04.A03) {
                                z = false;
                                skipDownloadActions = true;
                                break;
                            }
                        } else {
                            z = false;
                            String str = runnableC0892Dv + A05(0, 14, 3) + runnableC0892Dv2;
                            runnableC0892Dv2.A08();
                        }
                    }
                }
                if (z) {
                    runnableC0892Dv.A0A();
                    if (!canStartTask) {
                        this.A0B.add(runnableC0892Dv);
                        skipDownloadActions = this.A0B.size() == this.A04;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        if (this.A03) {
            return;
        }
        DownloadAction[] downloadActionArr = new DownloadAction[this.A0C.size()];
        for (int i = 0; i < this.A0C.size(); i++) {
            downloadActionArr[i] = this.A0C.get(i).A04;
        }
        this.A06.post(new RunnableC0887Dq(this, downloadActionArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(RunnableC0892Dv runnableC0892Dv) {
        A0J(A05(91, 21, 120), runnableC0892Dv);
        C0894Dx c0894DxA0K = runnableC0892Dv.A0K();
        Iterator<InterfaceC0888Dr> it = this.A0D.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0G[0].charAt(7) == 'Z') {
                throw new RuntimeException();
            }
            A0G[0] = "TUrgn6We5nsrVkZlQG2KUeV0nEHaGaai";
            if (zHasNext) {
                it.next().AD8(this, c0894DxA0K);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(RunnableC0892Dv runnableC0892Dv) {
        if (this.A03) {
            return;
        }
        boolean z = !runnableC0892Dv.A0L();
        if (z) {
            this.A0B.remove(runnableC0892Dv);
        }
        A0D(runnableC0892Dv);
        if (A0G[3].charAt(7) == 'd') {
            throw new RuntimeException();
        }
        A0G[6] = "xCRZPuTuqF5VhljpIGNZbvIN3H6gjFvE";
        boolean stopped = runnableC0892Dv.A0M();
        if (stopped) {
            this.A0C.remove(runnableC0892Dv);
            A0B();
        }
        if (z) {
            A0A();
            A09();
        }
    }

    public static void A0J(String str, RunnableC0892Dv runnableC0892Dv) {
        String str2 = str + A05(14, 2, 33) + runnableC0892Dv;
    }

    public final int A0O(DownloadAction downloadAction) {
        HI.A04(!this.A03);
        RunnableC0892Dv runnableC0892DvA02 = A02(downloadAction);
        if (this.A02) {
            A0B();
            A0A();
            if (runnableC0892DvA02.A06 == 0) {
                A0D(runnableC0892DvA02);
            }
        }
        return runnableC0892DvA02.A02;
    }

    public final void A0P() {
        HI.A04(!this.A03);
        if (this.A01) {
            this.A01 = false;
            A0A();
        }
    }

    public final void A0Q(InterfaceC0888Dr interfaceC0888Dr) {
        this.A0D.add(interfaceC0888Dr);
    }

    public final boolean A0R() {
        HI.A04(!this.A03);
        if (!this.A02) {
            return false;
        }
        for (int i = 0; i < i; i++) {
            if (this.A0C.get(i).A0L()) {
                return false;
            }
        }
        return true;
    }

    public final C0894Dx[] A0S() {
        HI.A04(!this.A03);
        C0894Dx[] c0894DxArr = new C0894Dx[this.A0C.size()];
        for (int i = 0; i < c0894DxArr.length; i++) {
            c0894DxArr[i] = this.A0C.get(i).A0K();
        }
        return c0894DxArr;
    }
}
