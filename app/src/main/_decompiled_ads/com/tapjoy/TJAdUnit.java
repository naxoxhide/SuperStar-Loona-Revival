package com.tapjoy;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import com.tapjoy.internal.i8;
import com.tapjoy.internal.r7;
import com.tapjoy.internal.s6;
import com.tapjoy.internal.s7;
import com.tapjoy.internal.t7;
import com.tapjoy.internal.u7;
import com.tapjoy.internal.v7;
import com.tapjoy.internal.v8;
import com.tapjoy.internal.w7;
import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes4.dex */
public class TJAdUnit implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnInfoListener {
    public static TJVideoListener J;
    public boolean A;
    public s6 B;
    public i8 C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TJAdUnitWebViewListener f2683b;
    public TJAdUnitVideoListener c;
    public TJAdUnitActivity d;
    public TJAdUnitJSBridge e;
    public c f;
    public View g;
    public TJWebView h;
    public VideoView i;
    public MediaPlayer j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public ScheduledFuture o;
    public AudioManager p;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public volatile boolean x;
    public boolean y;
    public boolean z;
    public final Handler a = new Handler(Looper.getMainLooper());
    public int q = 0;
    public final r7 D = new r7(this);
    public final s7 E = new s7(this);
    public final t7 F = new t7(this);
    public final u7 G = new u7(this);
    public final b H = new b(this);
    public final w7 I = new w7(this);

    public interface TJAdUnitVideoListener {
        void onVideoCompleted();

        void onVideoError(String str);

        void onVideoStart();
    }

    public interface TJAdUnitWebViewListener {
        void onClick();

        void onClosed();

        void onContentReady();
    }

    public void closeRequested(boolean z) {
        this.e.closeRequested(Boolean.valueOf(z));
    }

    public void destroy() {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.e;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.destroy();
        }
        this.a.removeCallbacks(this.E);
        this.a.removeCallbacks(this.F);
        this.a.removeCallbacks(this.G);
        View view = this.g;
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.g);
            }
            this.g = null;
        }
        TJWebView tJWebView = this.h;
        if (tJWebView != null) {
            tJWebView.destroy();
            this.h = null;
        }
        this.z = false;
        this.x = false;
        this.u = false;
        setAdUnitActivity(null);
        TapjoyLog.d("TJAdUnit", "detachVolumeListener");
        ScheduledFuture scheduledFuture = this.o;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.o = null;
        }
        this.p = null;
        try {
            VideoView videoView = this.i;
            if (videoView != null) {
                videoView.stopPlayback();
                ViewGroup viewGroup2 = (ViewGroup) this.i.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.i);
                }
                this.i = null;
            }
        } catch (IllegalStateException e) {
            TapjoyLog.e("TJAdUnit", "Exception while clearing the video view: " + e.toString());
        }
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f2683b;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClosed();
        }
        resetContentLoadState();
    }

    public void fireContentReady() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f2683b;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onContentReady();
        }
    }

    public void fireOnClick() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f2683b;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClick();
        }
    }

    public void fireOnVideoComplete() {
        TapjoyLog.v("TJAdUnit", "Firing onVideoComplete");
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoComplete();
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.c;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoCompleted();
        }
    }

    public void fireOnVideoError(String str) {
        TapjoyLog.e("TJAdUnit", "Firing onVideoError with error: " + str);
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoError(3);
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.c;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoError(str);
        }
    }

    public void fireOnVideoStart() {
        TapjoyLog.v("TJAdUnit", "Firing onVideoStart");
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoStart();
        }
        if (this.c != null) {
            this.C.a("start", (HashMap) null);
            this.c.onVideoStart();
        }
    }

    public View getBackgroundView() {
        return this.g;
    }

    public boolean getCloseRequested() {
        return this.e.closeRequested;
    }

    public TJVideoListener getPublisherVideoListener() {
        return J;
    }

    public s6 getSdkBeacon() {
        return this.B;
    }

    public i8 getTjBeacon() {
        return this.C;
    }

    public int getVideoSeekTime() {
        return this.k;
    }

    public VideoView getVideoView() {
        return this.i;
    }

    public float getVolume() {
        return this.q / this.r;
    }

    public TJWebView getWebView() {
        return this.h;
    }

    public boolean hasCalledLoad() {
        return this.v;
    }

    public void invokeBridgeCallback(String str, Object... objArr) {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.e;
        if (tJAdUnitJSBridge == null || str == null) {
            return;
        }
        tJAdUnitJSBridge.invokeJSCallback(str, objArr);
    }

    public boolean isMuted() {
        return this.t;
    }

    public boolean isPrerendered() {
        return this.w;
    }

    public boolean isVideoComplete() {
        return this.n;
    }

    public void load(TJPlacementData tJPlacementData, boolean z, Context context) {
        this.v = false;
        TapjoyUtil.runOnMainThread(new a(this, context, tJPlacementData, z));
    }

    public void notifyOrientationChanged() {
        TJAdUnitActivity tJAdUnitActivity;
        if (this.e == null || (tJAdUnitActivity = this.d) == null) {
            return;
        }
        int iB = v8.b(tJAdUnitActivity);
        int iA = v8.a(this.d);
        this.e.notifyOrientationChanged(iB > iA ? TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT, iB, iA);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        TJAdUnitJSBridge tJAdUnitJSBridge;
        TapjoyLog.i("TJAdUnit", "video -- onCompletion");
        this.a.removeCallbacks(this.E);
        this.a.removeCallbacks(this.F);
        this.a.removeCallbacks(this.G);
        this.n = true;
        if (!this.l && (tJAdUnitJSBridge = this.e) != null) {
            tJAdUnitJSBridge.onVideoCompletion();
        }
        this.l = false;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str;
        TapjoyLog.e("TJAdUnit", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error encountered when instantiating the VideoView: " + i + " - " + i2));
        this.l = true;
        this.a.removeCallbacks(this.E);
        this.a.removeCallbacks(this.F);
        this.a.removeCallbacks(this.G);
        String strConcat = (i != 100 ? "MEDIA_ERROR_UNKNOWN" : "MEDIA_ERROR_SERVER_DIED").concat(" -- ");
        if (i2 == -1010) {
            str = strConcat + "MEDIA_ERROR_UNSUPPORTED";
        } else if (i2 == -1007) {
            str = strConcat + "MEDIA_ERROR_MALFORMED";
        } else if (i2 != -1004) {
            str = i2 != -110 ? strConcat + "MEDIA_ERROR_EXTRA_UNKNOWN" : strConcat + "MEDIA_ERROR_TIMED_OUT";
        } else {
            str = strConcat + "MEDIA_ERROR_IO";
        }
        this.e.onVideoError(str);
        return i == 1 || i2 == -1004;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        TapjoyLog.i("TJAdUnit", "video -- onPrepared");
        VideoView videoView = this.i;
        if (videoView == null) {
            return;
        }
        int duration = videoView.getDuration();
        int measuredWidth = this.i.getMeasuredWidth();
        int measuredHeight = this.i.getMeasuredHeight();
        this.j = mediaPlayer;
        boolean z = this.s;
        if (z) {
            if (mediaPlayer != null) {
                if (z) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
                if (this.t != z) {
                    this.t = z;
                    this.e.onVolumeChanged();
                }
            } else {
                this.s = z;
            }
        }
        if (this.k > 0 && this.i.getCurrentPosition() != this.k) {
            this.j.setOnSeekCompleteListener(new v7(this, duration, measuredWidth, measuredHeight));
        } else if (this.e != null) {
            this.a.removeCallbacks(this.G);
            this.e.onVideoReady(duration, measuredWidth, measuredHeight);
        }
        this.j.setOnInfoListener(this);
    }

    public void pause() {
        this.z = true;
        TJAdUnitJSBridge tJAdUnitJSBridge = this.e;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.setEnabled(false);
            this.e.pause();
        }
        this.f.pauseVideo();
    }

    public boolean preload(TJPlacementData tJPlacementData, Context context) {
        if (this.v || !tJPlacementData.isPrerenderingRequested() || !TJPlacementManager.canPreRenderPlacement() || TapjoyConnectCore.isViewOpen()) {
            fireContentReady();
            return false;
        }
        TapjoyLog.i("TJAdUnit", "Pre-rendering ad unit for placement: " + tJPlacementData.getPlacementName());
        TJPlacementManager.incrementPlacementPreRenderCount();
        load(tJPlacementData, true, context);
        return true;
    }

    public void resetContentLoadState() {
        this.v = false;
        this.y = false;
        this.w = false;
        this.s = false;
    }

    public void resume(TJAdUnitSaveStateData tJAdUnitSaveStateData) {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.e;
        if (tJAdUnitJSBridge == null) {
            TJAdUnitActivity tJAdUnitActivity = this.d;
            if (tJAdUnitActivity != null) {
                tJAdUnitActivity.finish();
                TapjoyLog.w("TJAdUnit", "Failed to resume TJAdUnit. TJAdUnitBridge is null.");
                return;
            }
            return;
        }
        if (tJAdUnitJSBridge.didLaunchOtherActivity) {
            TapjoyLog.d("TJAdUnit", "onResume bridge.didLaunchOtherActivity callbackID: " + this.e.otherActivityCallbackID);
            TJAdUnitJSBridge tJAdUnitJSBridge2 = this.e;
            tJAdUnitJSBridge2.invokeJSCallback(tJAdUnitJSBridge2.otherActivityCallbackID, Boolean.TRUE);
            this.e.didLaunchOtherActivity = false;
        }
        this.z = false;
        this.e.setEnabled(true);
        this.e.resume();
        if (tJAdUnitSaveStateData != null) {
            int i = tJAdUnitSaveStateData.seekTime;
            this.k = i;
            VideoView videoView = this.i;
            if (videoView != null) {
                videoView.seekTo(i);
            }
            if (this.j != null) {
                this.s = tJAdUnitSaveStateData.isVideoMuted;
            }
        }
        if (this.A) {
            this.A = false;
            this.a.postDelayed(this.E, 200L);
        }
    }

    public void setAdUnitActivity(TJAdUnitActivity tJAdUnitActivity) {
        this.d = tJAdUnitActivity;
    }

    public void setSdkBeacon() {
        this.C = new i8();
    }

    public void setVideoListener(TJAdUnitVideoListener tJAdUnitVideoListener) {
        this.c = tJAdUnitVideoListener;
    }

    public void setVisible(boolean z) {
        TJAdUnitJSBridge tJAdUnitJSBridge;
        TJAdUnitActivity tJAdUnitActivity;
        if (this.e != null && (tJAdUnitActivity = this.d) != null) {
            int iB = v8.b(tJAdUnitActivity);
            int iA = v8.a(this.d);
            this.e.notifyOrientationChanged(iB > iA ? TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT, iB, iA);
        }
        this.u = z;
        if (z && this.y && (tJAdUnitJSBridge = this.e) != null) {
            tJAdUnitJSBridge.display();
        }
    }

    public void setWebViewListener(TJAdUnitWebViewListener tJAdUnitWebViewListener) {
        this.f2683b = tJAdUnitWebViewListener;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str;
        if (i == 3) {
            str = "MEDIA_INFO_VIDEO_RENDERING_START";
        } else if (i != 801) {
            switch (i) {
                case 700:
                    str = "MEDIA_INFO_VIDEO_TRACK_LAGGING";
                    break;
                case 701:
                    str = "MEDIA_INFO_BUFFERING_START";
                    break;
                case 702:
                    str = "MEDIA_INFO_BUFFERING_END";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = "MEDIA_INFO_NOT_SEEKABLE";
        }
        this.e.onVideoInfo(str);
        return false;
    }
}
