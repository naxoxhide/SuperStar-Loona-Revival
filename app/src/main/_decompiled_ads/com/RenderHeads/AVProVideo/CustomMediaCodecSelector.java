package com.RenderHeads.AVProVideo;

import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CustomMediaCodecSelector implements MediaCodecSelector {
    private boolean m_PreferSoftware;

    public CustomMediaCodecSelector(boolean z) {
        this.m_PreferSoftware = z;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
    public MediaCodecInfo getDecoderInfo(String str, boolean z) throws MediaCodecUtil.DecoderQueryException {
        if (str.contains("video") && this.m_PreferSoftware) {
            List<MediaCodecInfo> decoderInfos = MediaCodecUtil.getDecoderInfos(str, z);
            MediaCodecInfo mediaCodecInfo = null;
            for (int i = 0; i < decoderInfos.size(); i++) {
                if (decoderInfos.get(i).name.toLowerCase().startsWith("omx.google")) {
                    mediaCodecInfo = decoderInfos.get(i);
                }
            }
            return mediaCodecInfo;
        }
        return MediaCodecSelector.DEFAULT.getDecoderInfo(str, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
    public MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecSelector.DEFAULT.getPassthroughDecoderInfo();
    }
}
