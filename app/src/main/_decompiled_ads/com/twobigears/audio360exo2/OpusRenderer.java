package com.twobigears.audio360exo2;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;

/* JADX INFO: loaded from: classes4.dex */
public final class OpusRenderer extends SimpleDecoderAudioRenderer {
    private static final int INITIAL_INPUT_BUFFER_SIZE = 5760;
    private static final int NUM_BUFFERS = 16;

    public OpusRenderer(AudioSink audioSink) {
        super(null, null, null, false, audioSink);
    }

    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    protected int supportsFormatInternal(DrmSessionManager<ExoMediaCrypto> drmSessionManager, Format format) {
        boolean z = OpusJNI.IS_AVAILABLE;
        boolean zEqualsIgnoreCase = "audio/opus".equalsIgnoreCase(format.sampleMimeType);
        if (z && zEqualsIgnoreCase) {
            return 4;
        }
        return format.drmInitData != null ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    public OpusDecoder createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws OpusDecoderException {
        return new OpusDecoder(16, 16, INITIAL_INPUT_BUFFER_SIZE, format.initializationData);
    }

    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer, com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        return PlaybackParameters.DEFAULT;
    }

    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer, com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return PlaybackParameters.DEFAULT;
    }
}
