package com.twobigears.audio360exo2;

import com.google.android.exoplayer2.audio.AudioDecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class OpusDecoder extends SimpleDecoder<DecoderInputBuffer, SimpleOutputBuffer, AudioDecoderException> {
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    private static final int MAX_OPUS_CHANNELS = 255;
    private static final int SAMPLE_RATE = 48000;
    private final int channelCount;
    private final int headerSeekPreRollSamples;
    private final int headerSkipSamples;
    private final long nativeDecoderContext;
    private int skipSamples;

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "libopus";
    }

    public OpusDecoder(int i, int i2, int i3, List<byte[]> list) throws OpusDecoderException {
        int i4;
        int i5;
        super(new DecoderInputBuffer[i], new SimpleOutputBuffer[i2]);
        if (!OpusJNI.IS_AVAILABLE) {
            throw new OpusDecoderException("Failed to load decoder native libraries.");
        }
        byte[] bArr = list.get(0);
        if (bArr.length < 19) {
            throw new OpusDecoderException("Header size is too small.");
        }
        int i6 = bArr[9] & 255;
        this.channelCount = i6;
        int littleEndian16 = readLittleEndian16(bArr, 10);
        int littleEndian17 = readLittleEndian16(bArr, 16);
        byte[] bArr2 = new byte[255];
        if (bArr[18] == 0) {
            if (i6 > 2) {
                throw new OpusDecoderException("Invalid Header, missing stream map.");
            }
            i5 = i6 == 2 ? 1 : 0;
            bArr2[0] = 0;
            bArr2[1] = 1;
            i4 = 1;
        } else {
            if (bArr.length < i6 + 21) {
                throw new OpusDecoderException("Header size is too small.");
            }
            i4 = bArr[19] & 255;
            int i7 = bArr[20] & 255;
            System.arraycopy(bArr, 21, bArr2, 0, i6);
            i5 = i7;
        }
        if (list.size() == 3) {
            if (list.get(1).length != 8 || list.get(2).length != 8) {
                throw new OpusDecoderException("Invalid Codec Delay or Seek Preroll");
            }
            long j = ByteBuffer.wrap(list.get(1)).order(ByteOrder.nativeOrder()).getLong();
            long j2 = ByteBuffer.wrap(list.get(2)).order(ByteOrder.nativeOrder()).getLong();
            this.headerSkipSamples = nsToSamples(j);
            this.headerSeekPreRollSamples = nsToSamples(j2);
        } else {
            this.headerSkipSamples = littleEndian16;
            this.headerSeekPreRollSamples = DEFAULT_SEEK_PRE_ROLL_SAMPLES;
        }
        long jOpusInit = OpusJNI.opusInit(SAMPLE_RATE, i6, i4, i5, littleEndian17, bArr2);
        this.nativeDecoderContext = jOpusInit;
        if (jOpusInit == 0) {
            throw new OpusDecoderException("Failed to initialize decoder");
        }
        setInitialInputBufferSize(i3);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public DecoderInputBuffer createInputBuffer() {
        return new DecoderInputBuffer(2);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public SimpleOutputBuffer createOutputBuffer() {
        return new SimpleOutputBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public AudioDecoderException createUnexpectedDecodeException(Throwable th) {
        return new AudioDecoderException("Unexpected Opus decoder exception", th);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public OpusDecoderException decode(DecoderInputBuffer decoderInputBuffer, SimpleOutputBuffer simpleOutputBuffer, boolean z) {
        if (z) {
            OpusJNI.opusReset(this.nativeDecoderContext);
            this.skipSamples = decoderInputBuffer.timeUs == 0 ? this.headerSkipSamples : this.headerSeekPreRollSamples;
        }
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        int iOpusDecode = OpusJNI.opusDecode(this.nativeDecoderContext, decoderInputBuffer.timeUs, byteBuffer, byteBuffer.limit(), simpleOutputBuffer, SAMPLE_RATE, this.channelCount);
        if (iOpusDecode < 0) {
            return new OpusDecoderException("Decode error: " + iOpusDecode);
        }
        ByteBuffer byteBuffer2 = simpleOutputBuffer.data;
        byteBuffer2.position(0);
        byteBuffer2.limit(iOpusDecode);
        int i = this.skipSamples;
        if (i <= 0) {
            return null;
        }
        int i2 = this.channelCount * 2;
        int i3 = i * i2;
        if (iOpusDecode <= i3) {
            this.skipSamples = i - (iOpusDecode / i2);
            simpleOutputBuffer.addFlag(Integer.MIN_VALUE);
            byteBuffer2.position(iOpusDecode);
            return null;
        }
        this.skipSamples = 0;
        byteBuffer2.position(i3);
        return null;
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        super.release();
        OpusJNI.opusClose(this.nativeDecoderContext);
    }

    private static int nsToSamples(long j) {
        return (int) ((j * 48000) / 1000000000);
    }

    private static int readLittleEndian16(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }
}
