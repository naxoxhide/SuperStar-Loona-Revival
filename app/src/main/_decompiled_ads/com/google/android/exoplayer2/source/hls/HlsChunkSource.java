package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class HlsChunkSource {
    private final DataSource encryptionDataSource;
    private byte[] encryptionIv;
    private String encryptionIvString;
    private byte[] encryptionKey;
    private Uri encryptionKeyUri;
    private HlsMasterPlaylist.HlsUrl expectedPlaylistUrl;
    private final HlsExtractorFactory extractorFactory;
    private IOException fatalError;
    private boolean independentSegments;
    private boolean isTimestampMaster;
    private long liveEdgeInPeriodTimeUs = -9223372036854775807L;
    private final DataSource mediaDataSource;
    private final List<Format> muxedCaptionFormats;
    private final HlsPlaylistTracker playlistTracker;
    private byte[] scratchSpace;
    private boolean seenExpectedPlaylistError;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private TrackSelection trackSelection;
    private final HlsMasterPlaylist.HlsUrl[] variants;

    public static final class HlsChunkHolder {
        public Chunk chunk;
        public boolean endOfStream;
        public HlsMasterPlaylist.HlsUrl playlist;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlist = null;
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsMasterPlaylist.HlsUrl[] hlsUrlArr, HlsDataSourceFactory hlsDataSourceFactory, TimestampAdjusterProvider timestampAdjusterProvider, List<Format> list) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.variants = hlsUrlArr;
        this.timestampAdjusterProvider = timestampAdjusterProvider;
        this.muxedCaptionFormats = list;
        Format[] formatArr = new Format[hlsUrlArr.length];
        int[] iArr = new int[hlsUrlArr.length];
        for (int i = 0; i < hlsUrlArr.length; i++) {
            formatArr[i] = hlsUrlArr[i].format;
            iArr[i] = i;
        }
        this.mediaDataSource = hlsDataSourceFactory.createDataSource(1);
        this.encryptionDataSource = hlsDataSourceFactory.createDataSource(3);
        TrackGroup trackGroup = new TrackGroup(formatArr);
        this.trackGroup = trackGroup;
        this.trackSelection = new InitializationTrackSelection(trackGroup, iArr);
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        HlsMasterPlaylist.HlsUrl hlsUrl = this.expectedPlaylistUrl;
        if (hlsUrl == null || !this.seenExpectedPlaylistError) {
            return;
        }
        this.playlistTracker.maybeThrowPlaylistRefreshError(hlsUrl);
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public void selectTracks(TrackSelection trackSelection) {
        this.trackSelection = trackSelection;
    }

    public TrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public void reset() {
        this.fatalError = null;
    }

    public void setIsTimestampMaster(boolean z) {
        this.isTimestampMaster = z;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:59:0x010b  */
    /* JADX WARN: Code duplicated, block: B:61:0x010f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0112  */
    /* JADX WARN: Code duplicated, block: B:64:0x011a  */
    /* JADX WARN: Code duplicated, block: B:67:0x0121  */
    /* JADX WARN: Code duplicated, block: B:69:0x0132  */
    /* JADX WARN: Code duplicated, block: B:71:0x0142  */
    /* JADX WARN: Code duplicated, block: B:73:0x015b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0165  */
    /* JADX WARN: Code duplicated, block: B:76:0x016d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0174  */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x0121, please report this as an issue */
    public void getNextChunk(HlsMediaChunk hlsMediaChunk, long j, long j2, HlsChunkHolder hlsChunkHolder) {
        long jBinarySearchFloor;
        HlsMediaPlaylist hlsMediaPlaylist;
        long j3;
        HlsMasterPlaylist.HlsUrl hlsUrl;
        int i;
        HlsMediaPlaylist.Segment segment;
        Uri uriResolveToUri;
        int iIndexOf = hlsMediaChunk == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        long jMax = j2 - j;
        long jResolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j);
        if (hlsMediaChunk != null && !this.independentSegments) {
            long durationUs = hlsMediaChunk.getDurationUs();
            jMax = Math.max(0L, jMax - durationUs);
            if (jResolveTimeToLiveEdgeUs != -9223372036854775807L) {
                jResolveTimeToLiveEdgeUs = Math.max(0L, jResolveTimeToLiveEdgeUs - durationUs);
            }
        }
        this.trackSelection.updateSelectedTrack(j, jMax, jResolveTimeToLiveEdgeUs);
        int selectedIndexInTrackGroup = this.trackSelection.getSelectedIndexInTrackGroup();
        boolean z = iIndexOf != selectedIndexInTrackGroup;
        HlsMasterPlaylist.HlsUrl hlsUrl2 = this.variants[selectedIndexInTrackGroup];
        if (!this.playlistTracker.isSnapshotValid(hlsUrl2)) {
            hlsChunkHolder.playlist = hlsUrl2;
            this.seenExpectedPlaylistError &= this.expectedPlaylistUrl == hlsUrl2;
            this.expectedPlaylistUrl = hlsUrl2;
            return;
        }
        HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(hlsUrl2);
        this.independentSegments = playlistSnapshot.hasIndependentSegmentsTag;
        updateLiveEdgeTimeUs(playlistSnapshot);
        long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
        if (hlsMediaChunk == null || z) {
            long j4 = playlistSnapshot.durationUs + initialStartTimeUs;
            long j5 = (hlsMediaChunk == null || this.independentSegments) ? j2 : hlsMediaChunk.startTimeUs;
            if (!playlistSnapshot.hasEndTag && j5 >= j4) {
                jBinarySearchFloor = playlistSnapshot.mediaSequence + ((long) playlistSnapshot.segments.size());
            } else {
                jBinarySearchFloor = ((long) Util.binarySearchFloor((List<? extends Comparable<? super Long>>) playlistSnapshot.segments, Long.valueOf(j5 - initialStartTimeUs), true, !this.playlistTracker.isLive() || hlsMediaChunk == null)) + playlistSnapshot.mediaSequence;
                if (jBinarySearchFloor < playlistSnapshot.mediaSequence && hlsMediaChunk != null) {
                    hlsUrl2 = this.variants[iIndexOf];
                    HlsMediaPlaylist playlistSnapshot2 = this.playlistTracker.getPlaylistSnapshot(hlsUrl2);
                    initialStartTimeUs = playlistSnapshot2.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
                    jBinarySearchFloor = hlsMediaChunk.getNextChunkIndex();
                    playlistSnapshot = playlistSnapshot2;
                }
                hlsMediaPlaylist = playlistSnapshot;
                j3 = jBinarySearchFloor;
                hlsUrl = hlsUrl2;
                if (j3 < hlsMediaPlaylist.mediaSequence) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
                i = (int) (j3 - hlsMediaPlaylist.mediaSequence);
                if (i >= hlsMediaPlaylist.segments.size()) {
                    if (hlsMediaPlaylist.hasEndTag) {
                        hlsChunkHolder.endOfStream = true;
                        return;
                    }
                    hlsChunkHolder.playlist = hlsUrl;
                    this.seenExpectedPlaylistError &= this.expectedPlaylistUrl == hlsUrl;
                    this.expectedPlaylistUrl = hlsUrl;
                    return;
                }
                this.seenExpectedPlaylistError = false;
                this.expectedPlaylistUrl = null;
                segment = hlsMediaPlaylist.segments.get(i);
                if (segment.fullSegmentEncryptionKeyUri != null) {
                    uriResolveToUri = UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.fullSegmentEncryptionKeyUri);
                    if (!uriResolveToUri.equals(this.encryptionKeyUri)) {
                        hlsChunkHolder.chunk = newEncryptionKeyChunk(uriResolveToUri, segment.encryptionIV, iIndexOf, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData());
                        return;
                    } else if (!Util.areEqual(segment.encryptionIV, this.encryptionIvString)) {
                        setEncryptionData(uriResolveToUri, segment.encryptionIV, this.encryptionKey);
                    }
                } else {
                    clearEncryptionData();
                }
                HlsMediaPlaylist.Segment segment2 = segment.initializationSegment;
                DataSpec dataSpec = segment2 != null ? new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment2.url), segment2.byterangeOffset, segment2.byterangeLength, null) : null;
                long j6 = segment.relativeStartTimeUs + initialStartTimeUs;
                int i2 = hlsMediaPlaylist.discontinuitySequence + segment.relativeDiscontinuitySequence;
                hlsChunkHolder.chunk = new HlsMediaChunk(this.extractorFactory, this.mediaDataSource, new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null), dataSpec, hlsUrl, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), j6, j6 + segment.durationUs, j3, i2, segment.hasGapTag, this.isTimestampMaster, this.timestampAdjusterProvider.getAdjuster(i2), hlsMediaChunk, hlsMediaPlaylist.drmInitData, this.encryptionKey, this.encryptionIv);
            }
        } else {
            jBinarySearchFloor = hlsMediaChunk.getNextChunkIndex();
        }
        iIndexOf = selectedIndexInTrackGroup;
        hlsMediaPlaylist = playlistSnapshot;
        j3 = jBinarySearchFloor;
        hlsUrl = hlsUrl2;
        if (j3 < hlsMediaPlaylist.mediaSequence) {
            this.fatalError = new BehindLiveWindowException();
            return;
        }
        i = (int) (j3 - hlsMediaPlaylist.mediaSequence);
        if (i >= hlsMediaPlaylist.segments.size()) {
            if (hlsMediaPlaylist.hasEndTag) {
                hlsChunkHolder.endOfStream = true;
                return;
            }
            hlsChunkHolder.playlist = hlsUrl;
            this.seenExpectedPlaylistError &= this.expectedPlaylistUrl == hlsUrl;
            this.expectedPlaylistUrl = hlsUrl;
            return;
        }
        this.seenExpectedPlaylistError = false;
        this.expectedPlaylistUrl = null;
        segment = hlsMediaPlaylist.segments.get(i);
        if (segment.fullSegmentEncryptionKeyUri != null) {
            uriResolveToUri = UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.fullSegmentEncryptionKeyUri);
            if (!uriResolveToUri.equals(this.encryptionKeyUri)) {
                hlsChunkHolder.chunk = newEncryptionKeyChunk(uriResolveToUri, segment.encryptionIV, iIndexOf, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData());
                return;
            } else if (!Util.areEqual(segment.encryptionIV, this.encryptionIvString)) {
                setEncryptionData(uriResolveToUri, segment.encryptionIV, this.encryptionKey);
            }
        } else {
            clearEncryptionData();
        }
        HlsMediaPlaylist.Segment segment3 = segment.initializationSegment;
        DataSpec dataSpec2 = segment3 != null ? new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment3.url), segment3.byterangeOffset, segment3.byterangeLength, null) : null;
        long j7 = segment.relativeStartTimeUs + initialStartTimeUs;
        int i3 = hlsMediaPlaylist.discontinuitySequence + segment.relativeDiscontinuitySequence;
        hlsChunkHolder.chunk = new HlsMediaChunk(this.extractorFactory, this.mediaDataSource, new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null), dataSpec2, hlsUrl, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), j7, j7 + segment.durationUs, j3, i3, segment.hasGapTag, this.isTimestampMaster, this.timestampAdjusterProvider.getAdjuster(i3), hlsMediaChunk, hlsMediaPlaylist.drmInitData, this.encryptionKey, this.encryptionIv);
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            setEncryptionData(encryptionKeyChunk.dataSpec.uri, encryptionKeyChunk.iv, encryptionKeyChunk.getResult());
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z, IOException iOException) {
        if (z) {
            TrackSelection trackSelection = this.trackSelection;
            if (ChunkedTrackBlacklistUtil.maybeBlacklistTrack(trackSelection, trackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), iOException)) {
                return true;
            }
        }
        return false;
    }

    public boolean onPlaylistError(HlsMasterPlaylist.HlsUrl hlsUrl, boolean z) {
        int iIndexOf;
        int iIndexOf2 = this.trackGroup.indexOf(hlsUrl.format);
        if (iIndexOf2 == -1 || (iIndexOf = this.trackSelection.indexOf(iIndexOf2)) == -1) {
            return true;
        }
        this.seenExpectedPlaylistError = (this.expectedPlaylistUrl == hlsUrl) | this.seenExpectedPlaylistError;
        return !z || this.trackSelection.blacklist(iIndexOf, 60000L);
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        long j2 = this.liveEdgeInPeriodTimeUs;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist hlsMediaPlaylist) {
        this.liveEdgeInPeriodTimeUs = hlsMediaPlaylist.hasEndTag ? -9223372036854775807L : hlsMediaPlaylist.getEndTimeUs() - this.playlistTracker.getInitialStartTimeUs();
    }

    private EncryptionKeyChunk newEncryptionKeyChunk(Uri uri, String str, int i, int i2, Object obj) {
        return new EncryptionKeyChunk(this.encryptionDataSource, new DataSpec(uri, 0L, -1L, null, 1), this.variants[i].format, i2, obj, this.scratchSpace, str);
    }

    private void setEncryptionData(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(Util.toLowerInvariant(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (16 - byteArray.length) + length, byteArray.length - length);
        this.encryptionKeyUri = uri;
        this.encryptionKey = bArr;
        this.encryptionIvString = str;
        this.encryptionIv = bArr2;
    }

    private void clearEncryptionData() {
        this.encryptionKeyUri = null;
        this.encryptionKey = null;
        this.encryptionIvString = null;
        this.encryptionIv = null;
    }

    private static final class InitializationTrackSelection extends BaseTrackSelection {
        private int selectedIndex;

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.selectedIndex = indexOf(trackGroup.getFormat(0));
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long j, long j2, long j3) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (isBlacklisted(this.selectedIndex, jElapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!isBlacklisted(i, jElapsedRealtime)) {
                        this.selectedIndex = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return this.selectedIndex;
        }
    }

    private static final class EncryptionKeyChunk extends DataChunk {
        public final String iv;
        private byte[] result;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, byte[] bArr, String str) {
            super(dataSource, dataSpec, 3, format, i, obj, bArr);
            this.iv = str;
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        protected void consume(byte[] bArr, int i) throws IOException {
            this.result = Arrays.copyOf(bArr, i);
        }

        public byte[] getResult() {
            return this.result;
        }
    }
}
