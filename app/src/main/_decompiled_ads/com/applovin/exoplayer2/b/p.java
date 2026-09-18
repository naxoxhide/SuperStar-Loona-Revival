package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.l.ai;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class p extends l {
    private static final int mn = Float.floatToIntBits(Float.NaN);

    p() {
    }

    @Override // com.applovin.exoplayer2.b.l
    public f.a b(f.a aVar) throws f.b {
        int i = aVar.jQ;
        if (!ai.fK(i)) {
            throw new f.b(aVar);
        }
        if (i != 4) {
            return new f.a(aVar.dM, aVar.dL, 4);
        }
        return f.a.jP;
    }

    @Override // com.applovin.exoplayer2.b.f
    public void d(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAz;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.kO.jQ;
        if (i2 == 536870912) {
            byteBufferAz = az((i / 3) * 4);
            while (iPosition < iLimit) {
                b(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferAz);
                iPosition += 3;
            }
        } else if (i2 == 805306368) {
            byteBufferAz = az(i);
            while (iPosition < iLimit) {
                b((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferAz);
                iPosition += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferAz.flip();
    }

    private static void b(int i, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i) * 4.656612875245797E-10d));
        if (iFloatToIntBits == mn) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }
}
