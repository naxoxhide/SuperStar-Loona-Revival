package com.RenderHeads.AVProVideo;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CustomDefaultRenderersFactory implements RenderersFactory {
    private CustomMediaCodecSelector m_CodecSelector;
    private Context m_Context;
    private RenderersFactory m_DefaultRenderersFactory;
    private DrmSessionManager<FrameworkMediaCrypto> m_DrmSessionManager;
    private int m_ExtensionRenderersMode;
    private boolean m_PreferSoftware;

    public CustomDefaultRenderersFactory(Context context, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i, boolean z) {
        this.m_PreferSoftware = z;
        this.m_CodecSelector = new CustomMediaCodecSelector(this.m_PreferSoftware);
        this.m_DefaultRenderersFactory = new DefaultRenderersFactory(context, drmSessionManager, i);
        this.m_Context = context;
        this.m_ExtensionRenderersMode = i;
        this.m_DrmSessionManager = drmSessionManager;
    }

    @Override // com.google.android.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        Renderer[] rendererArrCreateRenderers = this.m_DefaultRenderersFactory.createRenderers(handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput, drmSessionManager);
        if (!this.m_PreferSoftware) {
            return rendererArrCreateRenderers;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(rendererArrCreateRenderers));
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            if (((Renderer) arrayList.get(i)).getTrackType() != 2) {
                arrayList2.add(arrayList.get(i));
            }
        }
        arrayList2.add(new MediaCodecVideoRenderer(this.m_Context, this.m_CodecSelector, 5000L, this.m_DrmSessionManager, false, handler, videoRendererEventListener, 50));
        if (this.m_ExtensionRenderersMode != 0) {
            int size = arrayList2.size();
            if (this.m_ExtensionRenderersMode == 2) {
                size--;
            }
            try {
                arrayList2.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(true, 5000, handler, videoRendererEventListener, 50));
            } catch (ClassNotFoundException unused) {
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating VP9 extension", e);
            }
        }
        return (Renderer[]) arrayList2.toArray(new Renderer[arrayList2.size()]);
    }
}
