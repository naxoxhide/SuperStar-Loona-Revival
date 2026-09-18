package com.RenderHeads.AVProVideo;

import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class EventLogger implements Player.EventListener, AudioRendererEventListener, DefaultDrmSessionManager.EventListener, MetadataRenderer.Output, AdaptiveMediaSourceEventListener, ExtractorMediaSource.EventListener, VideoRendererEventListener {
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final String TAG = "AVProVideo: EventLogger";
    private static final NumberFormat TIME_FORMAT;
    private final MappingTrackSelector trackSelector;
    private final Timeline.Window window = new Timeline.Window();
    private final Timeline.Period period = new Timeline.Period();
    private final long startTimeMs = SystemClock.elapsedRealtime();

    private static String getAdaptiveSupportString(int i, int i2) {
        if (i < 2) {
            return "N/A";
        }
        if (i2 == 0) {
            return "NO";
        }
        if (i2 != 8) {
            return i2 != 16 ? "?" : "YES";
        }
        return "YES_NOT_SEAMLESS";
    }

    private static String getFormatSupportString(int i) {
        if (i == 0) {
            return "NO";
        }
        if (i == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i != 3) {
            return i != 4 ? "?" : "YES";
        }
        return "NO_EXCEEDS_CAPABILITIES";
    }

    private static String getRepeatModeString(int i) {
        if (i == 0) {
            return "OFF";
        }
        if (i != 1) {
            return i != 2 ? "?" : "ALL";
        }
        return "ONE";
    }

    private static String getStateString(int i) {
        if (i == 1) {
            return "I";
        }
        if (i == 2) {
            return "B";
        }
        if (i != 3) {
            return i != 4 ? "?" : "E";
        }
        return "R";
    }

    private static String getTrackStatusString(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onMediaPeriodReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPositionDiscontinuity(int i) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onReadingStarted(int i, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onSeekProcessed() {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onShuffleModeEnabledChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector) {
        this.trackSelector = mappingTrackSelector;
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onLoadingChanged(boolean z) {
        new StringBuilder("loading [").append(z).append("]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerStateChanged(boolean z, int i) {
        new StringBuilder("state [").append(getSessionTimeString()).append(", ").append(z).append(", ").append(getStateString(i)).append("]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onRepeatModeChanged(int i) {
        new StringBuilder("repeatMode [").append(getRepeatModeString(i)).append("]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        new StringBuilder("playbackParameters ").append(String.format("[speed=%.2f, pitch=%.2f]", Float.valueOf(playbackParameters.speed), Float.valueOf(playbackParameters.pitch)));
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onTimelineChanged(Timeline timeline, Object obj, int i) {
        int periodCount = timeline.getPeriodCount();
        int windowCount = timeline.getWindowCount();
        new StringBuilder("sourceInfo [periodCount=").append(periodCount).append(", windowCount=").append(windowCount);
        for (int i2 = 0; i2 < Math.min(periodCount, 3); i2++) {
            timeline.getPeriod(i2, this.period);
            new StringBuilder("  period [").append(getTimeString(this.period.getDurationMs())).append("]");
        }
        for (int i3 = 0; i3 < Math.min(windowCount, 3); i3++) {
            timeline.getWindow(i3, this.window);
            new StringBuilder("  window [").append(getTimeString(this.window.getDurationMs())).append(", ").append(this.window.isSeekable).append(", ").append(this.window.isDynamic).append("]");
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerError(ExoPlaybackException exoPlaybackException) {
        Log.e(TAG, "playerFailed [" + getSessionTimeString() + "]", exoPlaybackException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [int] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.exoplayer2.source.TrackGroupArray] */
    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        ?? currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo == 0) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (i < currentMappedTrackInfo.length) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
            TrackSelection trackSelection = trackSelectionArray.get(i);
            if (trackGroups.length > 0) {
                new StringBuilder("  Renderer:").append(i).append(" [");
                ?? r4 = trackGroups;
                for (?? r13 = z; r13 < r4.length; r13++) {
                    TrackGroup trackGroup = r4.get(r13);
                    ?? r17 = r4;
                    new StringBuilder("    Group:").append(r13).append(", adaptive_supported=").append(getAdaptiveSupportString(trackGroup.length, currentMappedTrackInfo.getAdaptiveSupport(i, r13, z))).append(" [");
                    for (int i2 = 0; i2 < trackGroup.length; i2++) {
                        new StringBuilder("      ").append(getTrackStatusString(trackSelection, trackGroup, i2)).append(" Track:").append(i2).append(", ").append(Format.toLogString(trackGroup.getFormat(i2))).append(", supported=").append(getFormatSupportString(currentMappedTrackInfo.getTrackFormatSupport(i, r13, i2)));
                    }
                    r4 = r17;
                    z = false;
                }
                if (trackSelection != null) {
                    for (int i3 = 0; i3 < trackSelection.length(); i3++) {
                        Metadata metadata = trackSelection.getFormat(i3).metadata;
                        if (metadata != null) {
                            printMetadata(metadata, "      ");
                            break;
                        }
                    }
                }
            }
            i++;
            z = false;
        }
        TrackGroupArray unassociatedTrackGroups = currentMappedTrackInfo.getUnassociatedTrackGroups();
        if (unassociatedTrackGroups.length > 0) {
            for (int i4 = 0; i4 < unassociatedTrackGroups.length; i4++) {
                new StringBuilder("    Group:").append(i4).append(" [");
                TrackGroup trackGroup2 = unassociatedTrackGroups.get(i4);
                for (int i5 = 0; i5 < trackGroup2.length; i5++) {
                    new StringBuilder("      ").append(getTrackStatusString(false)).append(" Track:").append(i5).append(", ").append(Format.toLogString(trackGroup2.getFormat(i5))).append(", supported=").append(getFormatSupportString(0));
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataOutput
    public final void onMetadata(Metadata metadata) {
        printMetadata(metadata, "  ");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        new StringBuilder("audioEnabled [").append(getSessionTimeString()).append("]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSessionId(int i) {
        new StringBuilder("audioSessionId [").append(i).append("]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDecoderInitialized(String str, long j, long j2) {
        new StringBuilder("audioDecoderInitialized [").append(getSessionTimeString()).append(", ").append(str).append("]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioInputFormatChanged(Format format) {
        new StringBuilder("audioFormatChanged [").append(getSessionTimeString()).append(", ").append(Format.toLogString(format)).append("]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        new StringBuilder("audioDisabled [").append(getSessionTimeString()).append("]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSinkUnderrun(int i, long j, long j2) {
        printInternalError("audioTrackUnderrun [" + i + ", " + j + ", " + j2 + "]", null);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        new StringBuilder("videoEnabled [").append(getSessionTimeString()).append("]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderInitialized(String str, long j, long j2) {
        new StringBuilder("videoDecoderInitialized [").append(getSessionTimeString()).append(", ").append(str).append("]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoInputFormatChanged(Format format) {
        new StringBuilder("videoFormatChanged [").append(getSessionTimeString()).append(", ").append(Format.toLogString(format)).append("]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        new StringBuilder("videoDisabled [").append(getSessionTimeString()).append("]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onDroppedFrames(int i, long j) {
        new StringBuilder("droppedFrames [").append(getSessionTimeString()).append(", ").append(i).append("]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoSizeChanged(int i, int i2, int i3, float f) {
        new StringBuilder("videoSizeChanged [").append(i).append(", ").append(i2).append("]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onRenderedFirstFrame(Surface surface) {
        new StringBuilder("renderedFirstFrame [").append(surface).append("]");
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmSessionManagerError(Exception exc) {
        printInternalError("drmSessionManagerError", exc);
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmKeysRestored() {
        new StringBuilder("drmKeysRestored [").append(getSessionTimeString()).append("]");
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmKeysRemoved() {
        new StringBuilder("drmKeysRemoved [").append(getSessionTimeString()).append("]");
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmKeysLoaded() {
        new StringBuilder("drmKeysLoaded [").append(getSessionTimeString()).append("]");
    }

    @Override // com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener
    public final void onLoadError(IOException iOException) {
        printInternalError("loadError", iOException);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        printInternalError("loadError", iOException);
    }

    private void printInternalError(String str, Exception exc) {
        Log.e(TAG, "internalError [" + getSessionTimeString() + ", " + str + "]", exc);
    }

    private void printMetadata(Metadata metadata, String str) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                new StringBuilder().append(str).append(String.format("%s: value=%s", textInformationFrame.id, textInformationFrame.value));
            } else if (entry instanceof UrlLinkFrame) {
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) entry;
                new StringBuilder().append(str).append(String.format("%s: url=%s", urlLinkFrame.id, urlLinkFrame.url));
            } else if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                new StringBuilder().append(str).append(String.format("%s: owner=%s", privFrame.id, privFrame.owner));
            } else if (entry instanceof GeobFrame) {
                GeobFrame geobFrame = (GeobFrame) entry;
                new StringBuilder().append(str).append(String.format("%s: mimeType=%s, filename=%s, description=%s", geobFrame.id, geobFrame.mimeType, geobFrame.filename, geobFrame.description));
            } else if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                new StringBuilder().append(str).append(String.format("%s: mimeType=%s, description=%s", apicFrame.id, apicFrame.mimeType, apicFrame.description));
            } else if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                new StringBuilder().append(str).append(String.format("%s: language=%s, description=%s", commentFrame.id, commentFrame.language, commentFrame.description));
            } else if (entry instanceof Id3Frame) {
                new StringBuilder().append(str).append(String.format("%s", ((Id3Frame) entry).id));
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                new StringBuilder().append(str).append(String.format("EMSG: scheme=%s, id=%d, value=%s", eventMessage.schemeIdUri, Long.valueOf(eventMessage.id), eventMessage.value));
            }
        }
    }

    private String getSessionTimeString() {
        return getTimeString(SystemClock.elapsedRealtime() - this.startTimeMs);
    }

    private static String getTimeString(long j) {
        return j == -9223372036854775807L ? "?" : TIME_FORMAT.format(j / 1000.0f);
    }

    private static String getTrackStatusString(TrackSelection trackSelection, TrackGroup trackGroup, int i) {
        return getTrackStatusString((trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i) == -1) ? false : true);
    }
}
