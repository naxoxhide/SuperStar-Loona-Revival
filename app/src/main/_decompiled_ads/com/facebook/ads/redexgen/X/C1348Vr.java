package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35.PrivateCommand;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35.SpliceInsertCommand;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35.SpliceNullCommand;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35.SpliceScheduleCommand;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35.TimeSignalCommand;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1348Vr implements DE {
    public C0992Ht A00;
    public final C0980Hh A02 = new C0980Hh();
    public final C0979Hg A01 = new C0979Hg();

    @Override // com.facebook.ads.redexgen.X.DE
    public final Metadata A4x(D1 d1) throws DF {
        if (this.A00 == null || d1.A00 != this.A00.A05()) {
            C0992Ht c0992Ht = new C0992Ht(((XE) d1).A00);
            this.A00 = c0992Ht;
            c0992Ht.A06(((XE) d1).A00 - d1.A00);
        }
        ByteBuffer buffer = d1.A01;
        byte[] bArrArray = buffer.array();
        int iLimit = buffer.limit();
        this.A02.A0b(bArrArray, iLimit);
        this.A01.A0C(bArrArray, iLimit);
        this.A01.A08(39);
        long jA04 = (((long) this.A01.A04(1)) << 32) | ((long) this.A01.A04(32));
        this.A01.A08(20);
        int spliceCommandType = this.A01.A04(12);
        int iA04 = this.A01.A04(8);
        Metadata.Entry spliceNullCommand = null;
        this.A02.A0Z(14);
        switch (iA04) {
            case 0:
                spliceNullCommand = new SpliceNullCommand();
                break;
            case 4:
                spliceNullCommand = SpliceScheduleCommand.A00(this.A02);
                break;
            case 5:
                spliceNullCommand = SpliceInsertCommand.A00(this.A02, jA04, this.A00);
                break;
            case 6:
                spliceNullCommand = TimeSignalCommand.A01(this.A02, jA04, this.A00);
                break;
            case 255:
                spliceNullCommand = PrivateCommand.A00(this.A02, spliceCommandType, jA04);
                break;
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}
