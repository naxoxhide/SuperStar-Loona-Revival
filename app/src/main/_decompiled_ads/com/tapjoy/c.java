package com.tapjoy;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.VideoView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.internal.a8;
import com.tapjoy.internal.b8;
import com.tapjoy.internal.c8;
import com.tapjoy.internal.d8;
import com.tapjoy.internal.e7;
import com.tapjoy.internal.e8;
import com.tapjoy.internal.i8;
import com.tapjoy.internal.q6;
import com.tapjoy.internal.s6;
import com.tapjoy.internal.v8;
import com.tapjoy.internal.x7;
import com.tapjoy.internal.y7;
import com.tapjoy.internal.z7;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends TJJSBridgeDelegate {
    public final /* synthetic */ TJAdUnit a;

    public c(TJAdUnit tJAdUnit) {
        this.a = tJAdUnit;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void attachVolumeListener(boolean z, int i) {
        TJAdUnit tJAdUnit;
        TJAdUnitActivity tJAdUnitActivity;
        TapjoyLog.d("TJAdUnit", "attachVolumeListener: isAttached=" + z + "; interval=" + i);
        TJAdUnit tJAdUnit2 = this.a;
        tJAdUnit2.getClass();
        TapjoyLog.d("TJAdUnit", "detachVolumeListener");
        ScheduledFuture scheduledFuture = tJAdUnit2.o;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            tJAdUnit2.o = null;
        }
        tJAdUnit2.p = null;
        if (z && (tJAdUnitActivity = (tJAdUnit = this.a).d) != null) {
            tJAdUnit.p = (AudioManager) tJAdUnitActivity.getSystemService("audio");
            TJAdUnit tJAdUnit3 = this.a;
            tJAdUnit3.q = tJAdUnit3.p.getStreamVolume(3);
            TJAdUnit tJAdUnit4 = this.a;
            tJAdUnit4.r = tJAdUnit4.p.getStreamMaxVolume(3);
            TJAdUnit tJAdUnit5 = this.a;
            long j = i;
            tJAdUnit5.o = e7.a.scheduleWithFixedDelay(tJAdUnit5.D, j, j, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void clearVideo(TJTaskHandler tJTaskHandler, boolean z) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit.i == null) {
            tJTaskHandler.onComplete(Boolean.FALSE);
            return;
        }
        tJAdUnit.a.removeCallbacks(tJAdUnit.E);
        tJAdUnit.a.removeCallbacks(tJAdUnit.F);
        tJAdUnit.a.removeCallbacks(tJAdUnit.G);
        TapjoyUtil.runOnMainThread(new b8(this, z, tJTaskHandler));
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final boolean dismiss() {
        this.a.d.finish();
        return true;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final boolean fireContentReady() {
        this.a.fireContentReady();
        return true;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void fireOnClick() {
        this.a.fireOnClick();
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void fireOnVideoComplete() {
        this.a.fireOnVideoComplete();
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void fireOnVideoError(String str) {
        this.a.fireOnVideoError(str);
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void fireOnVideoStart() {
        this.a.fireOnVideoStart();
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final String getBeaconId() {
        return this.a.getTjBeacon().a;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final Context getContext() {
        TJAdUnit tJAdUnit = this.a;
        TJAdUnitActivity tJAdUnitActivity = tJAdUnit.d;
        if (tJAdUnitActivity != null) {
            return tJAdUnitActivity;
        }
        TJWebView tJWebView = tJAdUnit.h;
        if (tJWebView != null) {
            return tJWebView.getContext();
        }
        return null;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final Map getOrientation() {
        HashMap map = new HashMap();
        TJAdUnitActivity tJAdUnitActivity = this.a.d;
        if (tJAdUnitActivity == null) {
            return map;
        }
        int iB = v8.b(tJAdUnitActivity);
        int iA = v8.a(this.a.d);
        map.put("orientation", iB > iA ? TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT);
        map.put("width", Integer.valueOf(iB));
        map.put("height", Integer.valueOf(iA));
        map.put(TJAdUnitConstants.String.ROTATION, Integer.valueOf(v8.a(this.a.d, iB, iA)));
        return map;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void getTextZoom(TJTaskHandler tJTaskHandler) {
        TapjoyUtil.runOnMainThread(new x7(this, tJTaskHandler));
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final VideoView getVideoView() {
        return this.a.i;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final Map getVolumeArgs() {
        String str = String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.a.getVolume()));
        boolean zIsMuted = this.a.isMuted();
        TapjoyLog.d("TJAdUnit", "getVolumeArgs: volume=" + str + "; isMuted=" + zIsMuted);
        HashMap map = new HashMap();
        map.put(TJAdUnitConstants.String.CURRENT_VOLUME, str);
        map.put(TJAdUnitConstants.String.IS_MUTED, Boolean.valueOf(zIsMuted));
        return map;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final WebView getWebView() {
        return this.a.h;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final boolean isMuted() {
        return this.a.isMuted();
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void loadVideoUrl(String str, TJTaskHandler tJTaskHandler) {
        TapjoyUtil.runOnMainThread(new a8(this, str, tJTaskHandler));
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void muteVideo(boolean z) {
        TJAdUnit tJAdUnit = this.a;
        MediaPlayer mediaPlayer = tJAdUnit.j;
        if (mediaPlayer == null) {
            tJAdUnit.s = z;
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
        if (tJAdUnit.t != z) {
            tJAdUnit.t = z;
            tJAdUnit.e.onVolumeChanged();
        }
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final boolean pauseVideo() {
        TJAdUnit tJAdUnit = this.a;
        tJAdUnit.a.removeCallbacks(tJAdUnit.E);
        tJAdUnit.a.removeCallbacks(tJAdUnit.F);
        tJAdUnit.a.removeCallbacks(tJAdUnit.G);
        VideoView videoView = this.a.i;
        if (videoView == null || !videoView.isPlaying()) {
            return false;
        }
        if (i8.e) {
            this.a.getTjBeacon().a(CampaignEx.JSON_NATIVE_VIDEO_PAUSE, (HashMap) null);
        }
        this.a.i.pause();
        TJAdUnit tJAdUnit2 = this.a;
        tJAdUnit2.k = tJAdUnit2.i.getCurrentPosition();
        TapjoyLog.i("TJAdUnit", "Video paused at: " + this.a.k);
        TJAdUnit tJAdUnit3 = this.a;
        tJAdUnit3.e.onVideoPaused(tJAdUnit3.k);
        return true;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final boolean playVideo() {
        TapjoyLog.i("TJAdUnit", "playVideo");
        VideoView videoView = this.a.i;
        if (videoView == null) {
            return false;
        }
        if (i8.e && !videoView.isPlaying() && this.a.i.getCurrentPosition() != 0) {
            this.a.getTjBeacon().a(CampaignEx.JSON_NATIVE_VIDEO_RESUME, (HashMap) null);
        }
        this.a.i.start();
        TJAdUnit tJAdUnit = this.a;
        tJAdUnit.n = false;
        tJAdUnit.a.postDelayed(tJAdUnit.E, 200L);
        return true;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void setBackgroundColor(String str, TJTaskHandler tJTaskHandler) {
        TapjoyUtil.runOnMainThread(new z7(this, str, tJTaskHandler));
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void setCloseButtonClickable(boolean z) {
        TapjoyUtil.runOnMainThread(new e8(this, z));
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void setCloseButtonVisible(boolean z) {
        TapjoyUtil.runOnMainThread(new d8(this, z));
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final boolean setOrientation(int i) {
        TJAdUnitActivity tJAdUnitActivity = this.a.d;
        if (tJAdUnitActivity == null) {
            return true;
        }
        tJAdUnitActivity.setRequestedOrientation(i);
        return true;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void setTextZoom(float f) {
        TapjoyUtil.runOnMainThread(new y7(this, f));
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final boolean setVideoMargins(float f, float f2, float f3, float f4) {
        if (this.a.d == null) {
            return false;
        }
        TapjoyUtil.runOnMainThread(new c8(this, f, f2, f3, f4));
        return true;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void setupSdkBeacons(s6 s6Var) {
        TJAdUnit tJAdUnit = this.a;
        tJAdUnit.B = s6Var;
        if (s6Var == null || !tJAdUnit.u || TextUtils.isEmpty(s6Var.c) || s6Var.f) {
            return;
        }
        s6Var.f = true;
        new q6(s6Var, new HashMap(s6Var.f2811b)).start();
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void shouldClose(boolean z) {
        TJAdUnitActivity tJAdUnitActivity;
        if (!z || (tJAdUnitActivity = this.a.d) == null) {
            return;
        }
        tJAdUnitActivity.finish();
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final boolean unsetOrientation() {
        TJAdUnitActivity tJAdUnitActivity = this.a.d;
        if (tJAdUnitActivity == null) {
            return true;
        }
        tJAdUnitActivity.setRequestedOrientation(-1);
        return true;
    }
}
