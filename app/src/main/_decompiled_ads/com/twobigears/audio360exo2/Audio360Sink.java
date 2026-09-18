package com.twobigears.audio360exo2;

import android.util.Log;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioSink;
import com.twobigears.audio360.Audio360;
import com.twobigears.audio360.ChannelMap;
import com.twobigears.audio360.PlayState;
import com.twobigears.audio360.SpatDecoderQueue;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class Audio360Sink implements AudioSink {
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int NUM_BITS = 16;
    private static final int NUM_BYTES_PER_SAMPLE = 2;
    private static final int SAMPLE_RATE = 48000;
    private static final int START_IN_SYNC = 1;
    private static final int START_NEED_SYNC = 2;
    private static final int START_NOT_SET = 0;
    private static final String TAG = "Audio360Sink";
    private ChannelMap channelMap;
    private long lastPlayheadSampleTimeUs;
    private long latencyUs;
    private AudioSink.Listener listener;
    private int nextPlayheadOffsetIndex;
    private int numChannels;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long smoothedPlayheadOffsetUs;
    private SpatDecoderQueue spat;
    private long startMediaTimeUs;
    private long submittedPcmBytes;
    private int syncState;

    private long msToUs(double d) {
        return (long) (d * 1000.0d);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int i) {
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEncodingSupported(int i) {
        return i == 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i) {
    }

    public Audio360Sink(SpatDecoderQueue spatDecoderQueue, ChannelMap channelMap) {
        this(spatDecoderQueue, channelMap, 0.0d);
    }

    public Audio360Sink(SpatDecoderQueue spatDecoderQueue, ChannelMap channelMap, double d) {
        this.spat = spatDecoderQueue;
        this.channelMap = channelMap;
        this.startMediaTimeUs = 0L;
        this.syncState = 0;
        this.playheadOffsets = new long[10];
        this.latencyUs = msToUs(d);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void configure(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        if (i != 2) {
            throw new AudioSink.ConfigurationException("Incompatible bit depth");
        }
        if (i3 != SAMPLE_RATE) {
            throw new AudioSink.ConfigurationException("Incompatible sample rate");
        }
        int numChannelsForMap = Audio360.getNumChannelsForMap(this.channelMap);
        if (numChannelsForMap != i2) {
            throw new AudioSink.ConfigurationException("Incorrect number of channels for defined ChannelMap. The stream has " + i2 + " channels, expected " + numChannelsForMap + " channels.");
        }
        this.numChannels = i2;
        reset();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        reset();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        this.spat.flushQueue();
        this.startMediaTimeUs = 0L;
        this.syncState = 0;
        this.submittedPcmBytes = 0L;
        this.submittedPcmBytes = 0L;
        resetClockParams();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j) throws AudioSink.WriteException, AudioSink.InitializationException {
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        if (this.syncState == 0) {
            this.startMediaTimeUs = Math.max(0L, j);
            this.syncState = 1;
        } else {
            long jAudioSamplesToUs = this.startMediaTimeUs + audioSamplesToUs(getSubmittedFrames());
            if (this.syncState == 1 && Math.abs(jAudioSamplesToUs - j) > 200000) {
                Log.e(TAG, "Discontinuity detected [expected " + jAudioSamplesToUs + ", got " + j + "]");
                this.syncState = 2;
            }
            if (this.syncState == 2) {
                this.startMediaTimeUs += j - jAudioSamplesToUs;
                this.syncState = 1;
                AudioSink.Listener listener = this.listener;
                if (listener != null) {
                    listener.onPositionDiscontinuity();
                }
            }
        }
        int iRemaining = byteBuffer.remaining() / 2;
        if (this.spat.getFreeSpaceInQueue(this.channelMap) < iRemaining) {
            return false;
        }
        this.submittedPcmBytes += (long) byteBuffer.remaining();
        this.spat.enqueueDataInt16(byteBuffer, iRemaining, this.channelMap);
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.spat.play();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.spat.pause();
        resetClockParams();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        this.spat.setVolume(f, 0.0f);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        long spatDequeuedInUs;
        if (!hasCurrentPositionUs()) {
            return Long.MIN_VALUE;
        }
        if (this.spat.getPlayState() == PlayState.PLAYING) {
            maybeInterpolateClock();
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (this.playheadOffsetCount == 0) {
            spatDequeuedInUs = getSpatDequeuedInUs();
        } else {
            spatDequeuedInUs = jNanoTime + this.smoothedPlayheadOffsetUs;
        }
        if (!z) {
            spatDequeuedInUs -= this.latencyUs;
        }
        return this.startMediaTimeUs + spatDequeuedInUs;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        if (this.syncState == 1) {
            this.syncState = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        this.spat.setEndOfStream(true);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return this.spat.getEndOfStreamStatus() && !hasPendingData();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return this.spat.getFreeSpaceInQueue(this.channelMap) != this.spat.getQueueSize(this.channelMap);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
        this.listener = listener;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        return PlaybackParameters.DEFAULT;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        return PlaybackParameters.DEFAULT;
    }

    public void setChannelMap(ChannelMap channelMap) {
        this.channelMap = channelMap;
    }

    public ChannelMap getChannelMap() {
        return this.channelMap;
    }

    public int getNumDecoderChannels() {
        return this.numChannels;
    }

    private long audioSamplesToUs(long j) {
        return (j * 1000000) / 48000;
    }

    private long getSubmittedFrames() {
        return (this.submittedPcmBytes / ((long) this.numChannels)) / 2;
    }

    private boolean hasCurrentPositionUs() {
        return this.syncState != 0;
    }

    private long getSpatDequeuedInUs() {
        return audioSamplesToUs(this.spat.getNumSamplesDequeuedPerChannel().longValue());
    }

    private void maybeInterpolateClock() {
        long spatDequeuedInUs = getSpatDequeuedInUs();
        if (spatDequeuedInUs == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.lastPlayheadSampleTimeUs < 30000) {
            return;
        }
        long[] jArr = this.playheadOffsets;
        int i = this.nextPlayheadOffsetIndex;
        jArr[i] = spatDequeuedInUs - jNanoTime;
        this.nextPlayheadOffsetIndex = (i + 1) % 10;
        int i2 = this.playheadOffsetCount;
        if (i2 < 10) {
            this.playheadOffsetCount = i2 + 1;
        }
        this.lastPlayheadSampleTimeUs = jNanoTime;
        this.smoothedPlayheadOffsetUs = 0L;
        int i3 = 0;
        while (true) {
            int i4 = this.playheadOffsetCount;
            if (i3 >= i4) {
                return;
            }
            this.smoothedPlayheadOffsetUs += this.playheadOffsets[i3] / ((long) i4);
            i3++;
        }
    }

    private void resetClockParams() {
        this.smoothedPlayheadOffsetUs = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0L;
    }
}
