package com.RenderHeads.AVProVideo;

import android.os.Handler;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.twobigears.audio360exo2.OpusRenderer;

/* JADX INFO: loaded from: classes.dex */
public class OpusRenderersFactory implements RenderersFactory {
    private RenderersFactory m_RenderersFactory;
    private AudioSink m_Sink;

    public OpusRenderersFactory(AudioSink audioSink, RenderersFactory renderersFactory) {
        this.m_Sink = audioSink;
        this.m_RenderersFactory = renderersFactory;
    }

    @Override // com.google.android.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        Renderer[] rendererArrCreateRenderers = this.m_RenderersFactory.createRenderers(handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput, drmSessionManager);
        for (int i = 0; i < rendererArrCreateRenderers.length; i++) {
            if (rendererArrCreateRenderers[i].getTrackType() == 1) {
                rendererArrCreateRenderers[i] = new OpusRenderer(this.m_Sink);
            }
        }
        return rendererArrCreateRenderers;
    }
}
