package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes2.dex */
final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 3;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_text = Util.getIntegerCodeForString("text");
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_meta = Util.getIntegerCodeForString("meta");

    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    public static final class UnhandledEditListException extends ParserException {
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
        int hdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (hdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        long j2 = j == -9223372036854775807L ? tkhd.duration : j;
        long mvhd = parseMvhd(leafAtom.data);
        long jScaleLargeTimestamp = j2 != -9223372036854775807L ? Util.scaleLargeTimestamp(j2, 1000000L, mvhd) : -9223372036854775807L;
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> mdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData stsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, tkhd.id, tkhd.rotationDegrees, (String) mdhd.second, drmInitData, z2);
        if (z) {
            jArr = null;
            jArr2 = null;
        } else {
            Pair<long[], long[]> edts = parseEdts(containerAtom.getContainerAtomOfType(Atom.TYPE_edts));
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        return new Track(tkhd.id, hdlr, ((Long) mdhd.first).longValue(), mvhd, jScaleLargeTimestamp, stsd.format, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    /* JADX WARN: Code duplicated, block: B:136:0x034e  */
    /* JADX WARN: Code duplicated, block: B:137:0x0350  */
    /* JADX WARN: Code duplicated, block: B:141:0x035c  */
    /* JADX WARN: Code duplicated, block: B:143:0x0364  */
    /* JADX WARN: Code duplicated, block: B:145:0x0388  */
    /* JADX WARN: Code duplicated, block: B:146:0x038a  */
    /* JADX WARN: Code duplicated, block: B:148:0x038e  */
    /* JADX WARN: Code duplicated, block: B:152:0x039f  */
    /* JADX WARN: Code duplicated, block: B:153:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:156:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:157:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:159:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:160:0x03af  */
    /* JADX WARN: Code duplicated, block: B:162:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:164:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:165:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:169:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:171:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:173:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:174:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:184:0x0425  */
    /* JADX WARN: Code duplicated, block: B:191:0x0462  */
    /* JADX WARN: Code duplicated, block: B:210:0x0399 A[EDGE_INSN: B:210:0x0399->B:150:0x0399 BREAK  A[LOOP:5: B:139:0x0355->B:149:0x0392], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:48:0x0103 A[ADDED_TO_REGION, LOOP:1: B:48:0x0103->B:49:0x0105, LOOP_START, PHI: r14 r15 r23 r27
      0x0103: PHI (r14v7 int) = (r14v4 int), (r14v12 int) binds: [B:47:0x0101, B:49:0x0105] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r15v7 int) = (r15v5 int), (r15v12 int) binds: [B:47:0x0101, B:49:0x0105] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r23v7 int) = (r23v6 int), (r23v10 int) binds: [B:47:0x0101, B:49:0x0105] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r27v10 long) = (r27v9 long), (r27v12 long) binds: [B:47:0x0101, B:49:0x0105] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x0105 A[LOOP:1: B:48:0x0103->B:49:0x0105, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x0123 A[ADDED_TO_REGION, LOOP:2: B:52:0x0123->B:54:0x0127, LOOP_START, PHI: r16 r21 r22
      0x0123: PHI (r16v16 int) = (r16v12 int), (r16v17 int) binds: [B:51:0x0121, B:54:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r21v12 int) = (r21v10 int), (r21v14 int) binds: [B:51:0x0121, B:54:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r22v6 int) = (r22v1 int), (r22v7 int) binds: [B:51:0x0121, B:54:0x0127] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x0142  */
    /* JADX WARN: Code duplicated, block: B:61:0x014e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0150  */
    /* JADX WARN: Code duplicated, block: B:65:0x0155  */
    /* JADX WARN: Code duplicated, block: B:67:0x015c  */
    /* JADX WARN: Code duplicated, block: B:75:0x019f  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:82:0x01af  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:94:0x021a  */
    /* JADX WARN: Code duplicated, block: B:97:0x022a A[LOOP:8: B:95:0x0224->B:97:0x022a, LOOP_END] */
    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        boolean z2;
        Track track2;
        String str;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i;
        long[] jArr3;
        int[] iArr3;
        long j;
        long jScaleLargeTimestamp;
        String str2;
        int i2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        long j2;
        long[] jArr4;
        int[] iArr4;
        boolean z5;
        boolean z6;
        long[] jArr5;
        int[] iArr5;
        int[] iArr6;
        long[] jArr6;
        int i6;
        int i7;
        long j3;
        long j4;
        String str3;
        long[] jArr7;
        int[] iArr7;
        int iBinarySearchCeil;
        int iBinarySearchCeil2;
        long j5;
        int iBinarySearchCeil3;
        boolean z7;
        long[] jArr8;
        int[] iArr8;
        long[] jArr9;
        int[] iArr9;
        int i8;
        long j6;
        long j7;
        int i9;
        int i10;
        int i11;
        int unsignedIntToInt3;
        int i12;
        int i13;
        int i14;
        int unsignedIntToInt4;
        int i15;
        int i16;
        boolean z8;
        int i17;
        boolean z9;
        int i18;
        int unsignedIntToInt5;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
            if (leafAtomOfType2 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stco);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_co64);
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stsc).data;
        ParsableByteArray parsableByteArray3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stts).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stss);
        ParsableByteArray parsableByteArray4 = null;
        ParsableByteArray parsableByteArray5 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
        ParsableByteArray parsableByteArray6 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int unsignedIntToInt6 = parsableByteArray3.readUnsignedIntToInt() - 1;
        int unsignedIntToInt7 = parsableByteArray3.readUnsignedIntToInt();
        int unsignedIntToInt8 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray6 != null) {
            parsableByteArray6.setPosition(12);
            unsignedIntToInt = parsableByteArray6.readUnsignedIntToInt();
        } else {
            unsignedIntToInt = 0;
        }
        int unsignedIntToInt9 = -1;
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            unsignedIntToInt2 = parsableByteArray5.readUnsignedIntToInt();
            unsignedIntToInt9 = unsignedIntToInt2 > 0 ? parsableByteArray5.readUnsignedIntToInt() - 1 : -1;
            if (!stz2SampleSizeBox.isFixedSampleSize() && "audio/raw".equals(track.format.sampleMimeType) && unsignedIntToInt6 == 0 && unsignedIntToInt == 0 && unsignedIntToInt2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j8 = 0;
            if (!z2) {
                jArr8 = new long[sampleCount];
                iArr8 = new int[sampleCount];
                int i19 = unsignedIntToInt2;
                jArr9 = new long[sampleCount];
                iArr9 = new int[sampleCount];
                i8 = unsignedIntToInt8;
                j6 = 0;
                j7 = 0;
                i9 = unsignedIntToInt6;
                i10 = 0;
                i11 = 0;
                unsignedIntToInt3 = 0;
                i12 = 0;
                i13 = 0;
                i14 = i19;
                unsignedIntToInt4 = unsignedIntToInt9;
                i15 = unsignedIntToInt;
                i16 = unsignedIntToInt7;
                while (i10 < sampleCount) {
                    while (i13 == 0) {
                        Assertions.checkState(chunkIterator.moveNext());
                        j7 = chunkIterator.offset;
                        i13 = chunkIterator.numSamples;
                        i9 = i9;
                        i16 = i16;
                    }
                    int i20 = i9;
                    int i21 = i16;
                    if (parsableByteArray6 != null) {
                        while (unsignedIntToInt3 == 0 && i15 > 0) {
                            unsignedIntToInt3 = parsableByteArray6.readUnsignedIntToInt();
                            i12 = parsableByteArray6.readInt();
                            i15--;
                        }
                        unsignedIntToInt3--;
                    }
                    int i22 = i12;
                    jArr8[i10] = j7;
                    iArr8[i10] = stz2SampleSizeBox.readNextSampleSize();
                    if (iArr8[i10] > i11) {
                        i11 = iArr8[i10];
                    }
                    SampleSizeBox sampleSizeBox = stz2SampleSizeBox;
                    long[] jArr10 = jArr8;
                    jArr9[i10] = j6 + ((long) i22);
                    if (parsableByteArray4 == null) {
                        i18 = 1;
                    } else {
                        i18 = 0;
                    }
                    iArr9[i10] = i18;
                    if (i10 == unsignedIntToInt4) {
                        iArr9[i10] = 1;
                        i14--;
                        if (i14 > 0) {
                            unsignedIntToInt4 = parsableByteArray4.readUnsignedIntToInt() - 1;
                        }
                    }
                    j6 += (long) i8;
                    unsignedIntToInt5 = i21 - 1;
                    if (unsignedIntToInt5 != 0 && i20 > 0) {
                        i20--;
                        unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt();
                        i8 = parsableByteArray3.readInt();
                    }
                    int i23 = unsignedIntToInt5;
                    j7 += (long) iArr8[i10];
                    i13--;
                    i10++;
                    stz2SampleSizeBox = sampleSizeBox;
                    jArr8 = jArr10;
                    i16 = i23;
                    i12 = i22;
                    i9 = i20;
                }
                int i24 = i9;
                int i25 = i16;
                int i26 = i12;
                long[] jArr11 = jArr8;
                j = j6 + ((long) i26);
                if (unsignedIntToInt3 == 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                Assertions.checkArgument(z8);
                while (i15 > 0) {
                    if (parsableByteArray6.readUnsignedIntToInt() == 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    Assertions.checkArgument(z9);
                    parsableByteArray6.readInt();
                    i15--;
                }
                if (i14 == 0 || i25 != 0) {
                    i17 = i13;
                } else {
                    i17 = i13;
                    if (i17 == 0 && i24 == 0) {
                        track2 = track;
                        str = TAG;
                    }
                    jArr3 = jArr9;
                    iArr2 = iArr8;
                    iArr3 = iArr9;
                    i = i11;
                    jArr2 = jArr11;
                }
                track2 = track;
                String str4 = "Inconsistent stbl box for track " + track2.id + ": remainingSynchronizationSamples " + i14 + ", remainingSamplesAtTimestampDelta " + i25 + ", remainingSamplesInChunk " + i17 + ", remainingTimestampDeltaChanges " + i24;
                str = TAG;
                Log.w(str, str4);
                jArr3 = jArr9;
                iArr2 = iArr8;
                iArr3 = iArr9;
                i = i11;
                jArr2 = jArr11;
            } else {
                track2 = track;
                str = TAG;
                jArr = new long[chunkIterator.length];
                iArr = new int[chunkIterator.length];
                while (chunkIterator.moveNext()) {
                    jArr[chunkIterator.index] = chunkIterator.offset;
                    iArr[chunkIterator.index] = chunkIterator.numSamples;
                }
                FixedSampleSizeRechunker.Results resultsRechunk = FixedSampleSizeRechunker.rechunk(Util.getPcmFrameSize(track2.format.pcmEncoding, track2.format.channelCount), jArr, iArr, unsignedIntToInt8);
                jArr2 = resultsRechunk.offsets;
                iArr2 = resultsRechunk.sizes;
                i = resultsRechunk.maximumSize;
                jArr3 = resultsRechunk.timestamps;
                iArr3 = resultsRechunk.flags;
                j = resultsRechunk.duration;
            }
            jScaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, track2.timescale);
            if (track2.editListDurations != null || gaplessInfoHolder.hasGaplessInfo()) {
                Util.scaleLargeTimestampsInPlace(jArr3, 1000000L, track2.timescale);
                return new TrackSampleTable(track, jArr2, iArr2, i, jArr3, iArr3, jScaleLargeTimestamp);
            }
            if (track2.editListDurations.length == 1 && track2.type == 1 && jArr3.length >= 2) {
                long j9 = track2.editListMediaTimes[0];
                long jScaleLargeTimestamp2 = j9 + Util.scaleLargeTimestamp(track2.editListDurations[0], track2.timescale, track2.movieTimescale);
                str2 = str;
                if (canApplyEditWithGaplessInfo(jArr3, j, j9, jScaleLargeTimestamp2)) {
                    long jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(j9 - jArr3[0], track2.format.sampleRate, track2.timescale);
                    i2 = i;
                    long jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j - jScaleLargeTimestamp2, track2.format.sampleRate, track2.timescale);
                    if ((jScaleLargeTimestamp3 != 0 || jScaleLargeTimestamp4 != 0) && jScaleLargeTimestamp3 <= 2147483647L && jScaleLargeTimestamp4 <= 2147483647L) {
                        gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp3;
                        gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp4;
                        Util.scaleLargeTimestampsInPlace(jArr3, 1000000L, track2.timescale);
                        return new TrackSampleTable(track, jArr2, iArr2, i2, jArr3, iArr3, jScaleLargeTimestamp);
                    }
                }
                if (track2.editListDurations.length != 1 && track2.editListDurations[0] == 0) {
                    long j10 = track2.editListMediaTimes[0];
                    for (int i27 = 0; i27 < jArr3.length; i27++) {
                        jArr3[i27] = Util.scaleLargeTimestamp(jArr3[i27] - j10, 1000000L, track2.timescale);
                    }
                    return new TrackSampleTable(track, jArr2, iArr2, i2, jArr3, iArr3, Util.scaleLargeTimestamp(j - j10, 1000000L, track2.timescale));
                }
                if (track2.type == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = false;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                while (true) {
                    j2 = -1;
                    if (i4 < track2.editListDurations.length) {
                        break;
                    }
                    j5 = track2.editListMediaTimes[i4];
                    if (j5 != -1) {
                        long jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(track2.editListDurations[i4], track2.timescale, track2.movieTimescale);
                        iBinarySearchCeil3 = Util.binarySearchCeil(jArr3, j5, true, true);
                        int iBinarySearchCeil4 = Util.binarySearchCeil(jArr3, j5 + jScaleLargeTimestamp5, z3, false);
                        i3 += iBinarySearchCeil4 - iBinarySearchCeil3;
                        if (i5 != iBinarySearchCeil3) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z4 |= z7;
                        i5 = iBinarySearchCeil4;
                    }
                    i4++;
                    jArr2 = jArr2;
                    iArr2 = iArr2;
                }
                jArr4 = jArr2;
                iArr4 = iArr2;
                if (i3 != sampleCount) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z4 | z5;
                if (z6) {
                    jArr5 = new long[i3];
                } else {
                    jArr5 = jArr4;
                }
                if (z6) {
                    iArr5 = new int[i3];
                } else {
                    iArr5 = iArr4;
                }
                if (z6) {
                    i2 = 0;
                }
                if (z6) {
                    iArr6 = new int[i3];
                } else {
                    iArr6 = iArr3;
                }
                jArr6 = new long[i3];
                i6 = 0;
                i7 = 0;
                while (i6 < track2.editListDurations.length) {
                    j3 = track2.editListMediaTimes[i6];
                    j4 = track2.editListDurations[i6];
                    if (j3 != j2) {
                        jArr7 = jArr6;
                        long jScaleLargeTimestamp6 = Util.scaleLargeTimestamp(j4, track2.timescale, track2.movieTimescale) + j3;
                        iBinarySearchCeil = Util.binarySearchCeil(jArr3, j3, true, true);
                        iBinarySearchCeil2 = Util.binarySearchCeil(jArr3, jScaleLargeTimestamp6, z3, false);
                        if (z6) {
                            int i28 = iBinarySearchCeil2 - iBinarySearchCeil;
                            System.arraycopy(jArr4, iBinarySearchCeil, jArr5, i7, i28);
                            iArr7 = iArr4;
                            System.arraycopy(iArr7, iBinarySearchCeil, iArr5, i7, i28);
                            System.arraycopy(iArr3, iBinarySearchCeil, iArr6, i7, i28);
                        } else {
                            iArr7 = iArr4;
                        }
                        if (iBinarySearchCeil >= iBinarySearchCeil2 && (iArr6[i7] & 1) == 0) {
                            Log.w(str2, "Ignoring edit list: edit does not start with a sync sample.");
                            throw new UnhandledEditListException();
                        }
                        int i29 = i2;
                        while (iBinarySearchCeil < iBinarySearchCeil2) {
                            int i30 = iBinarySearchCeil2;
                            String str5 = str2;
                            long j11 = j3;
                            jArr7[i7] = Util.scaleLargeTimestamp(j8, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(jArr3[iBinarySearchCeil] - j3, 1000000L, track2.timescale);
                            if (!z6 && iArr5[i7] > i29) {
                                i29 = iArr7[iBinarySearchCeil];
                            }
                            i7++;
                            iBinarySearchCeil++;
                            iBinarySearchCeil2 = i30;
                            j3 = j11;
                            str2 = str5;
                        }
                        str3 = str2;
                        i2 = i29;
                    } else {
                        str3 = str2;
                        jArr7 = jArr6;
                        iArr7 = iArr4;
                    }
                    j8 += j4;
                    i6++;
                    jArr6 = jArr7;
                    z3 = z3;
                    str2 = str3;
                    iArr4 = iArr7;
                    j2 = -1;
                }
                return new TrackSampleTable(track, jArr5, iArr5, i2, jArr6, iArr6, Util.scaleLargeTimestamp(j8, 1000000L, track2.timescale));
            }
            str2 = str;
            i2 = i;
            if (track2.editListDurations.length != 1) {
            }
            if (track2.type == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = false;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (true) {
                j2 = -1;
                if (i4 < track2.editListDurations.length) {
                    break;
                    break;
                }
                j5 = track2.editListMediaTimes[i4];
                if (j5 != -1) {
                    long jScaleLargeTimestamp7 = Util.scaleLargeTimestamp(track2.editListDurations[i4], track2.timescale, track2.movieTimescale);
                    iBinarySearchCeil3 = Util.binarySearchCeil(jArr3, j5, true, true);
                    int iBinarySearchCeil5 = Util.binarySearchCeil(jArr3, j5 + jScaleLargeTimestamp7, z3, false);
                    i3 += iBinarySearchCeil5 - iBinarySearchCeil3;
                    if (i5 != iBinarySearchCeil3) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z4 |= z7;
                    i5 = iBinarySearchCeil5;
                }
                i4++;
                jArr2 = jArr2;
                iArr2 = iArr2;
            }
            jArr4 = jArr2;
            iArr4 = iArr2;
            if (i3 != sampleCount) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 = z4 | z5;
            if (z6) {
                jArr5 = new long[i3];
            } else {
                jArr5 = jArr4;
            }
            if (z6) {
                iArr5 = new int[i3];
            } else {
                iArr5 = iArr4;
            }
            if (z6) {
                i2 = 0;
            }
            if (z6) {
                iArr6 = new int[i3];
            } else {
                iArr6 = iArr3;
            }
            jArr6 = new long[i3];
            i6 = 0;
            i7 = 0;
            while (i6 < track2.editListDurations.length) {
                j3 = track2.editListMediaTimes[i6];
                j4 = track2.editListDurations[i6];
                if (j3 != j2) {
                    jArr7 = jArr6;
                    long jScaleLargeTimestamp8 = Util.scaleLargeTimestamp(j4, track2.timescale, track2.movieTimescale) + j3;
                    iBinarySearchCeil = Util.binarySearchCeil(jArr3, j3, true, true);
                    iBinarySearchCeil2 = Util.binarySearchCeil(jArr3, jScaleLargeTimestamp8, z3, false);
                    if (z6) {
                        int i210 = iBinarySearchCeil2 - iBinarySearchCeil;
                        System.arraycopy(jArr4, iBinarySearchCeil, jArr5, i7, i210);
                        iArr7 = iArr4;
                        System.arraycopy(iArr7, iBinarySearchCeil, iArr5, i7, i210);
                        System.arraycopy(iArr3, iBinarySearchCeil, iArr6, i7, i210);
                    } else {
                        iArr7 = iArr4;
                    }
                    if (iBinarySearchCeil >= iBinarySearchCeil2) {
                    }
                    int i211 = i2;
                    while (iBinarySearchCeil < iBinarySearchCeil2) {
                        int i31 = iBinarySearchCeil2;
                        String str6 = str2;
                        long j12 = j3;
                        jArr7[i7] = Util.scaleLargeTimestamp(j8, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(jArr3[iBinarySearchCeil] - j3, 1000000L, track2.timescale);
                        if (!z6) {
                        }
                        i7++;
                        iBinarySearchCeil++;
                        iBinarySearchCeil2 = i31;
                        j3 = j12;
                        str2 = str6;
                    }
                    str3 = str2;
                    i2 = i211;
                } else {
                    str3 = str2;
                    jArr7 = jArr6;
                    iArr7 = iArr4;
                }
                j8 += j4;
                i6++;
                jArr6 = jArr7;
                z3 = z3;
                str2 = str3;
                iArr4 = iArr7;
                j2 = -1;
            }
            return new TrackSampleTable(track, jArr5, iArr5, i2, jArr6, iArr6, Util.scaleLargeTimestamp(j8, 1000000L, track2.timescale));
        }
        unsignedIntToInt2 = 0;
        parsableByteArray4 = parsableByteArray5;
        if (!stz2SampleSizeBox.isFixedSampleSize()) {
            z2 = false;
        } else {
            z2 = false;
        }
        long j13 = 0;
        if (!z2) {
            jArr8 = new long[sampleCount];
            iArr8 = new int[sampleCount];
            int i110 = unsignedIntToInt2;
            jArr9 = new long[sampleCount];
            iArr9 = new int[sampleCount];
            i8 = unsignedIntToInt8;
            j6 = 0;
            j7 = 0;
            i9 = unsignedIntToInt6;
            i10 = 0;
            i11 = 0;
            unsignedIntToInt3 = 0;
            i12 = 0;
            i13 = 0;
            i14 = i110;
            unsignedIntToInt4 = unsignedIntToInt9;
            i15 = unsignedIntToInt;
            i16 = unsignedIntToInt7;
            while (i10 < sampleCount) {
                while (i13 == 0) {
                    Assertions.checkState(chunkIterator.moveNext());
                    j7 = chunkIterator.offset;
                    i13 = chunkIterator.numSamples;
                    i9 = i9;
                    i16 = i16;
                }
                int i212 = i9;
                int i213 = i16;
                if (parsableByteArray6 != null) {
                    while (unsignedIntToInt3 == 0) {
                        unsignedIntToInt3 = parsableByteArray6.readUnsignedIntToInt();
                        i12 = parsableByteArray6.readInt();
                        i15--;
                    }
                    unsignedIntToInt3--;
                }
                int i214 = i12;
                jArr8[i10] = j7;
                iArr8[i10] = stz2SampleSizeBox.readNextSampleSize();
                if (iArr8[i10] > i11) {
                    i11 = iArr8[i10];
                }
                SampleSizeBox sampleSizeBox2 = stz2SampleSizeBox;
                long[] jArr12 = jArr8;
                jArr9[i10] = j6 + ((long) i214);
                if (parsableByteArray4 == null) {
                    i18 = 1;
                } else {
                    i18 = 0;
                }
                iArr9[i10] = i18;
                if (i10 == unsignedIntToInt4) {
                    iArr9[i10] = 1;
                    i14--;
                    if (i14 > 0) {
                        unsignedIntToInt4 = parsableByteArray4.readUnsignedIntToInt() - 1;
                    }
                }
                j6 += (long) i8;
                unsignedIntToInt5 = i213 - 1;
                if (unsignedIntToInt5 != 0) {
                }
                int i215 = unsignedIntToInt5;
                j7 += (long) iArr8[i10];
                i13--;
                i10++;
                stz2SampleSizeBox = sampleSizeBox2;
                jArr8 = jArr12;
                i16 = i215;
                i12 = i214;
                i9 = i212;
            }
            int i216 = i9;
            int i217 = i16;
            int i218 = i12;
            long[] jArr13 = jArr8;
            j = j6 + ((long) i218);
            if (unsignedIntToInt3 == 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            Assertions.checkArgument(z8);
            while (i15 > 0) {
                if (parsableByteArray6.readUnsignedIntToInt() == 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                Assertions.checkArgument(z9);
                parsableByteArray6.readInt();
                i15--;
            }
            if (i14 == 0) {
                i17 = i13;
                track2 = track;
                String str7 = "Inconsistent stbl box for track " + track2.id + ": remainingSynchronizationSamples " + i14 + ", remainingSamplesAtTimestampDelta " + i217 + ", remainingSamplesInChunk " + i17 + ", remainingTimestampDeltaChanges " + i216;
                str = TAG;
                Log.w(str, str7);
            } else {
                i17 = i13;
                track2 = track;
                String str8 = "Inconsistent stbl box for track " + track2.id + ": remainingSynchronizationSamples " + i14 + ", remainingSamplesAtTimestampDelta " + i217 + ", remainingSamplesInChunk " + i17 + ", remainingTimestampDeltaChanges " + i216;
                str = TAG;
                Log.w(str, str8);
            }
            jArr3 = jArr9;
            iArr2 = iArr8;
            iArr3 = iArr9;
            i = i11;
            jArr2 = jArr13;
        } else {
            track2 = track;
            str = TAG;
            jArr = new long[chunkIterator.length];
            iArr = new int[chunkIterator.length];
            while (chunkIterator.moveNext()) {
                jArr[chunkIterator.index] = chunkIterator.offset;
                iArr[chunkIterator.index] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results resultsRechunk2 = FixedSampleSizeRechunker.rechunk(Util.getPcmFrameSize(track2.format.pcmEncoding, track2.format.channelCount), jArr, iArr, unsignedIntToInt8);
            jArr2 = resultsRechunk2.offsets;
            iArr2 = resultsRechunk2.sizes;
            i = resultsRechunk2.maximumSize;
            jArr3 = resultsRechunk2.timestamps;
            iArr3 = resultsRechunk2.flags;
            j = resultsRechunk2.duration;
        }
        jScaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, track2.timescale);
        if (track2.editListDurations != null) {
        }
        Util.scaleLargeTimestampsInPlace(jArr3, 1000000L, track2.timescale);
        return new TrackSampleTable(track, jArr2, iArr2, i, jArr3, iArr3, jScaleLargeTimestamp);
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                parsableByteArray.setPosition(position);
                return parseMetaAtom(parsableByteArray, position + i);
            }
            parsableByteArray.skipBytes(i - 8);
        }
        return null;
    }

    private static Metadata parseMetaAtom(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + i2);
            }
            parsableByteArray.skipBytes(i2 - 8);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        parsableByteArray.skipBytes(Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0 ? 16 : 8);
        return parsableByteArray.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        int i = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i2 = fullAtomVersion == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                z = true;
                break;
            }
            if (parsableByteArray.data[position + i4] != -1) {
                z = false;
                break;
            }
            i4++;
        }
        long j = -9223372036854775807L;
        if (z) {
            parsableByteArray.skipBytes(i2);
        } else {
            long unsignedInt = fullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (unsignedInt != 0) {
                j = unsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int i5 = parsableByteArray.readInt();
        int i6 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i7 = parsableByteArray.readInt();
        int i8 = parsableByteArray.readInt();
        if (i5 == 0 && i6 == 65536 && i7 == -65536 && i8 == 0) {
            i3 = 90;
        } else if (i5 == 0 && i6 == -65536 && i7 == 65536 && i8 == 0) {
            i3 = 270;
        } else if (i5 == -65536 && i6 == 0 && i7 == 0 && i8 == -65536) {
            i3 = 180;
        }
        return new TkhdData(i, j, i3);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        int i = parsableByteArray.readInt();
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp) {
            return 3;
        }
        return i == TYPE_meta ? 4 : -1;
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 4 : 8);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(unsignedInt), "" + ((char) (((unsignedShort >> 10) & 31) + 96)) + ((char) (((unsignedShort >> 5) & 31) + 96)) + ((char) ((unsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        parsableByteArray.setPosition(12);
        int i3 = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            int position = parsableByteArray.getPosition();
            int i5 = parsableByteArray.readInt();
            Assertions.checkArgument(i5 > 0, "childAtomSize should be positive");
            int i6 = parsableByteArray.readInt();
            if (i6 == Atom.TYPE_avc1 || i6 == Atom.TYPE_avc3 || i6 == Atom.TYPE_encv || i6 == Atom.TYPE_mp4v || i6 == Atom.TYPE_hvc1 || i6 == Atom.TYPE_hev1 || i6 == Atom.TYPE_s263 || i6 == Atom.TYPE_vp08 || i6 == Atom.TYPE_vp09) {
                parseVideoSampleEntry(parsableByteArray, i6, position, i5, i, i2, drmInitData, stsdData, i4);
            } else if (i6 == Atom.TYPE_mp4a || i6 == Atom.TYPE_enca || i6 == Atom.TYPE_ac_3 || i6 == Atom.TYPE_ec_3 || i6 == Atom.TYPE_dtsc || i6 == Atom.TYPE_dtse || i6 == Atom.TYPE_dtsh || i6 == Atom.TYPE_dtsl || i6 == Atom.TYPE_samr || i6 == Atom.TYPE_sawb || i6 == Atom.TYPE_lpcm || i6 == Atom.TYPE_sowt || i6 == Atom.TYPE__mp3 || i6 == Atom.TYPE_alac) {
                parseAudioSampleEntry(parsableByteArray, i6, position, i5, i, str, z, drmInitData, stsdData, i4);
            } else if (i6 == Atom.TYPE_TTML || i6 == Atom.TYPE_tx3g || i6 == Atom.TYPE_wvtt || i6 == Atom.TYPE_stpp || i6 == Atom.TYPE_c608) {
                parseTextSampleEntry(parsableByteArray, i6, position, i5, i, str, stsdData);
            } else if (i6 == Atom.TYPE_camm) {
                stsdData.format = Format.createSampleFormat(Integer.toString(i), "application/x-camera-motion", null, -1, null);
            }
            parsableByteArray.setPosition(position + i5);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) throws ParserException {
        parsableByteArray.setPosition(i2 + 8 + 8);
        String str2 = "application/ttml+xml";
        List listSingletonList = null;
        long j = Long.MAX_VALUE;
        if (i != Atom.TYPE_TTML) {
            if (i == Atom.TYPE_tx3g) {
                int i5 = (i3 - 8) - 8;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                listSingletonList = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == Atom.TYPE_wvtt) {
                str2 = "application/x-mp4-vtt";
            } else if (i == Atom.TYPE_stpp) {
                j = 0;
            } else if (i == Atom.TYPE_c608) {
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = Format.createTextSampleFormat(Integer.toString(i4), str2, null, -1, 0, str, -1, null, j, listSingletonList);
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i2 + 8 + 8);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        String str = null;
        int iIntValue = i;
        if (iIntValue == Atom.TYPE_encv) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i2, i3);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i6] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        DrmInitData drmInitData2 = drmInitDataCopyWithSchemeType;
        int i7 = -1;
        List<byte[]> listSingletonList = null;
        byte[] projFromParent = null;
        float paspFromParent = 1.0f;
        boolean z = false;
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int i8 = parsableByteArray.readInt();
            if (i8 == 0 && parsableByteArray.getPosition() - i2 == i3) {
                break;
            }
            Assertions.checkArgument(i8 > 0, "childAtomSize should be positive");
            int i9 = parsableByteArray.readInt();
            if (i9 == Atom.TYPE_avcC) {
                Assertions.checkState(str == null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                listSingletonList = avcConfig.initializationData;
                stsdData.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = avcConfig.pixelWidthAspectRatio;
                }
                str = "video/avc";
            } else if (i9 == Atom.TYPE_hvcC) {
                Assertions.checkState(str == null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                listSingletonList = hevcConfig.initializationData;
                stsdData.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                str = "video/hevc";
            } else if (i9 == Atom.TYPE_vpcC) {
                Assertions.checkState(str == null);
                str = iIntValue == Atom.TYPE_vp08 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (i9 == Atom.TYPE_d263) {
                Assertions.checkState(str == null);
                str = "video/3gpp";
            } else if (i9 == Atom.TYPE_esds) {
                Assertions.checkState(str == null);
                Pair<String, byte[]> esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                str = (String) esdsFromParent.first;
                listSingletonList = Collections.singletonList(esdsFromParent.second);
            } else if (i9 == Atom.TYPE_pasp) {
                paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                z = true;
            } else if (i9 == Atom.TYPE_sv3d) {
                projFromParent = parseProjFromParent(parsableByteArray, position2, i8);
            } else if (i9 == Atom.TYPE_st3d) {
                int unsignedByte = parsableByteArray.readUnsignedByte();
                parsableByteArray.skipBytes(3);
                if (unsignedByte == 0) {
                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                    if (unsignedByte2 == 0) {
                        i7 = 0;
                    } else if (unsignedByte2 == 1) {
                        i7 = 1;
                    } else if (unsignedByte2 == 2) {
                        i7 = 2;
                    } else if (unsignedByte2 == 3) {
                        i7 = 3;
                    }
                }
            }
            position += i8;
        }
        if (str == null) {
            return;
        }
        stsdData.format = Format.createVideoSampleFormat(Integer.toString(i4), str, null, -1, -1, unsignedShort, unsignedShort2, -1.0f, listSingletonList, i5, paspFromParent, projFromParent, i7, null, drmInitData2);
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) == null) {
            return Pair.create(null, null);
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i = 0; i < unsignedIntToInt; i++) {
            jArr[i] = fullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = fullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int unsignedShort;
        int unsignedFixedPoint1616;
        int unsignedIntToInt;
        String str2;
        int i6;
        int i7;
        String str3;
        String str4;
        DrmInitData drmInitData2;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11 = i2;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i11 + 8 + 8);
        int i12 = 0;
        if (z) {
            unsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            unsignedShort = 0;
        }
        int i13 = 2;
        boolean z3 = true;
        if (unsignedShort == 0 || unsignedShort == 1) {
            int unsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            if (unsignedShort == 1) {
                parsableByteArray.skipBytes(16);
            }
            unsignedIntToInt = unsignedShort2;
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            unsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(20);
        }
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == Atom.TYPE_enca) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i11, i3);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        DrmInitData drmInitData3 = drmInitDataCopyWithSchemeType;
        String str5 = "audio/raw";
        if (iIntValue == Atom.TYPE_ac_3) {
            str2 = "audio/ac3";
        } else if (iIntValue == Atom.TYPE_ec_3) {
            str2 = "audio/eac3";
        } else if (iIntValue == Atom.TYPE_dtsc) {
            str2 = "audio/vnd.dts";
        } else if (iIntValue == Atom.TYPE_dtsh || iIntValue == Atom.TYPE_dtsl) {
            str2 = "audio/vnd.dts.hd";
        } else if (iIntValue == Atom.TYPE_dtse) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (iIntValue == Atom.TYPE_samr) {
            str2 = "audio/3gpp";
        } else if (iIntValue == Atom.TYPE_sawb) {
            str2 = "audio/amr-wb";
        } else if (iIntValue == Atom.TYPE_lpcm || iIntValue == Atom.TYPE_sowt) {
            str2 = "audio/raw";
        } else if (iIntValue == Atom.TYPE__mp3) {
            str2 = "audio/mpeg";
        } else {
            str2 = iIntValue == Atom.TYPE_alac ? "audio/alac" : null;
        }
        String str6 = str2;
        int iIntValue2 = unsignedFixedPoint1616;
        int iIntValue3 = unsignedIntToInt;
        int i14 = position;
        byte[] bArr = null;
        while (i14 - i11 < i3) {
            parsableByteArray.setPosition(i14);
            int i15 = parsableByteArray.readInt();
            Assertions.checkArgument(i15 > 0 ? z3 : i12, "childAtomSize should be positive");
            int i16 = parsableByteArray.readInt();
            if (i16 == Atom.TYPE_esds || (z && i16 == Atom.TYPE_wave)) {
                i6 = i15;
                i7 = i14;
                str3 = str6;
                str4 = str5;
                drmInitData2 = drmInitData3;
                z2 = z3;
                i8 = i13;
                i9 = i12;
                int iFindEsdsPosition = i16 == Atom.TYPE_esds ? i7 : findEsdsPosition(parsableByteArray, i7, i6);
                if (iFindEsdsPosition != -1) {
                    Pair<String, byte[]> esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindEsdsPosition);
                    str6 = (String) esdsFromParent.first;
                    bArr = (byte[]) esdsFromParent.second;
                    if ("audio/mp4a-latm".equals(str6)) {
                        Pair<Integer, Integer> aacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
                        iIntValue2 = ((Integer) aacAudioSpecificConfig.first).intValue();
                        iIntValue3 = ((Integer) aacAudioSpecificConfig.second).intValue();
                    }
                }
                i14 = i7 + i6;
                i12 = i9;
                drmInitData3 = drmInitData2;
                z3 = z2;
                i13 = i8;
                str5 = str4;
                i11 = i2;
            } else {
                if (i16 == Atom.TYPE_dac3) {
                    parsableByteArray.setPosition(i14 + 8);
                    stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData3);
                } else if (i16 == Atom.TYPE_dec3) {
                    parsableByteArray.setPosition(i14 + 8);
                    stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData3);
                } else {
                    if (i16 == Atom.TYPE_ddts) {
                        i10 = i14;
                        str3 = str6;
                        str4 = str5;
                        drmInitData2 = drmInitData3;
                        z2 = z3;
                        i8 = i13;
                        i9 = i12;
                        stsdData.format = Format.createAudioSampleFormat(Integer.toString(i4), str6, null, -1, -1, iIntValue3, iIntValue2, null, drmInitData2, 0, str);
                        i6 = i15;
                    } else {
                        i10 = i14;
                        str3 = str6;
                        str4 = str5;
                        drmInitData2 = drmInitData3;
                        z2 = z3;
                        i8 = i13;
                        i9 = i12;
                        i6 = i15;
                        if (i16 == Atom.TYPE_alac) {
                            byte[] bArr2 = new byte[i6];
                            i7 = i10;
                            parsableByteArray.setPosition(i7);
                            parsableByteArray.readBytes(bArr2, i9, i6);
                            bArr = bArr2;
                        }
                    }
                    i7 = i10;
                }
                i6 = i15;
                i7 = i14;
                str3 = str6;
                str4 = str5;
                drmInitData2 = drmInitData3;
                z2 = z3;
                i8 = i13;
                i9 = i12;
            }
            str6 = str3;
            i14 = i7 + i6;
            i12 = i9;
            drmInitData3 = drmInitData2;
            z3 = z2;
            i13 = i8;
            str5 = str4;
            i11 = i2;
        }
        String str7 = str6;
        String str8 = str5;
        DrmInitData drmInitData4 = drmInitData3;
        int i17 = i13;
        if (stsdData.format != null || str7 == null) {
            return;
        }
        stsdData.format = Format.createAudioSampleFormat(Integer.toString(i4), str7, null, -1, -1, iIntValue3, iIntValue2, str8.equals(str7) ? i17 : -1, bArr != null ? Collections.singletonList(bArr) : null, drmInitData4, 0, str);
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            Assertions.checkArgument(i3 > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += i3;
        }
        return -1;
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            Assertions.checkArgument(i3 > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, i3)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position += i3;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        int i4 = -1;
        String string = null;
        Integer numValueOf = null;
        int i5 = 0;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i6 = parsableByteArray.readInt();
            int i7 = parsableByteArray.readInt();
            if (i7 == Atom.TYPE_frma) {
                numValueOf = Integer.valueOf(parsableByteArray.readInt());
            } else if (i7 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                string = parsableByteArray.readString(4);
            } else if (i7 == Atom.TYPE_schi) {
                i4 = i3;
                i5 = i6;
            }
            i3 += i6;
        }
        if (!"cenc".equals(string) && !"cbc1".equals(string) && !"cens".equals(string) && !"cbcs".equals(string)) {
            return null;
        }
        Assertions.checkArgument(numValueOf != null, "frma atom is mandatory");
        Assertions.checkArgument(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox schiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, string);
        Assertions.checkArgument(schiFromParent != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, schiFromParent);
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int i6 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = unsignedByte & 15;
                    i4 = (unsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && unsignedByte2 == 0) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z, str, unsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += i6;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i4 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i3, i4 + i3);
            }
            i3 += i4;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = unsignedByte & WorkQueueKt.MASK;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (unsignedByte & WorkQueueKt.MASK);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(3, 0, length)] && jArr[Util.constrainValue(jArr.length - 3, 0, length)] < j3 && j3 <= j;
    }

    private AtomParsers() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fixedSampleSize = parsableByteArray.readUnsignedIntToInt();
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == 0 ? this.data.readUnsignedIntToInt() : i;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return false;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 == 0) {
                int unsignedByte = this.data.readUnsignedByte();
                this.currentByte = unsignedByte;
                return (unsignedByte & 240) >> 4;
            }
            return this.currentByte & 15;
        }
    }
}
