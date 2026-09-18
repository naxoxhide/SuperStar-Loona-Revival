package com.gomfactory.adpie.sdk.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowInsets;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.common.AdData;
import com.gomfactory.adpie.sdk.event.AdBroadcast;
import com.gomfactory.adpie.sdk.event.AdEventListener;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InterstitialBaseActivity extends Activity {
    public static final String TAG = "InterstitialBaseActivity";
    protected AdData mAdData;
    protected long mBroadcastIdentifier;
    protected boolean mIsVideoAd;
    protected String mSlotId;
    protected String mSsvCustomData;
    protected String mSsvUserId;
    protected static final AtomicLong sNextGeneratedId = new AtomicLong(1);
    protected static String INTERSTITIAL_SLOT_ID_KEY = "INTERSTITIAL_SLOT_ID";
    protected static String INTERSTITIAL_AD_DATA_KEY = "INTERSTITIAL_AD_DATA";
    protected static String INTERSTITIAL_AD_BUNDLE_KEY = "INTERSTITIAL_AD_BUNDLE";
    protected static String REWARDED_AD_SSV_USER_ID_KEY = "REWARDED_AD_SSV_USER_ID";
    protected static String REWARDED_AD_SSV_CUSTOM_DATA_KEY = "REWARDED_AD_SSV_CUSTOM_DATA";
    protected static String BROADCAST_IDENTIFIER_KEY = "INTERSTITIAL_BROADCAST";

    protected static long generateUniqueId() {
        AtomicLong atomicLong;
        long j;
        long j2;
        do {
            atomicLong = sNextGeneratedId;
            j = atomicLong.get();
            j2 = j + 1;
        } while (!atomicLong.compareAndSet(j, j2 <= 9223372036854775806L ? j2 : 1L));
        return j;
    }

    public static void start(Context context, Class<?> cls, String str, AdData adData, String str2, String str3, AdEventListener adEventListener) throws Exception {
        AdBroadcast adBroadcast = null;
        try {
            long jGenerateUniqueId = generateUniqueId();
            AdBroadcast adBroadcast2 = new AdBroadcast(adEventListener, jGenerateUniqueId);
            try {
                adBroadcast2.register(context);
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "mBroadcastId : " + jGenerateUniqueId);
                }
                Intent intent = new Intent(context, cls);
                Bundle bundle = new Bundle();
                bundle.putParcelable(INTERSTITIAL_AD_DATA_KEY, adData);
                intent.putExtra(INTERSTITIAL_AD_BUNDLE_KEY, bundle);
                intent.putExtra(INTERSTITIAL_SLOT_ID_KEY, str);
                intent.putExtra(REWARDED_AD_SSV_USER_ID_KEY, str2);
                intent.putExtra(REWARDED_AD_SSV_CUSTOM_DATA_KEY, str3);
                intent.putExtra(BROADCAST_IDENTIFIER_KEY, jGenerateUniqueId);
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e = e;
                adBroadcast = adBroadcast2;
                AdPieLog.i(TAG, cls.getSimpleName() + " not found - did you declare it in AndroidManifest.xml?");
                if (adBroadcast != null) {
                    adBroadcast.unregister();
                }
                throw e;
            } catch (Exception e2) {
                e = e2;
                adBroadcast = adBroadcast2;
                AdPieLog.e(TAG, e);
                if (adBroadcast != null) {
                    adBroadcast.unregister();
                }
                throw e;
            }
        } catch (ActivityNotFoundException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = true;
        try {
            requestWindowFeature(1);
            if (Build.VERSION.SDK_INT >= 27) {
                setShowWhenLocked(true);
            } else {
                getWindow().addFlags(524288);
            }
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            this.mBroadcastIdentifier = getIntent().getLongExtra(BROADCAST_IDENTIFIER_KEY, 0L);
            this.mSlotId = getIntent().getStringExtra(INTERSTITIAL_SLOT_ID_KEY);
            this.mAdData = (AdData) getIntent().getBundleExtra(INTERSTITIAL_AD_BUNDLE_KEY).getParcelable(INTERSTITIAL_AD_DATA_KEY);
            this.mSsvUserId = getIntent().getStringExtra(REWARDED_AD_SSV_USER_ID_KEY);
            this.mSsvCustomData = getIntent().getStringExtra(REWARDED_AD_SSV_CUSTOM_DATA_KEY);
            if (this.mAdData.getIcType() != 52) {
                z = false;
            }
            this.mIsVideoAd = z;
            hideSystemUI();
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (isFinishing()) {
            notifyDismiss();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void notifyDismiss() {
        long j = this.mBroadcastIdentifier;
        if (j > 0) {
            AdBroadcast.sendBroadCast(this, j, AdBroadcast.ACTION_INTERSTITIAL_DISMISS);
        }
    }

    protected void notifyShown() {
        long j = this.mBroadcastIdentifier;
        if (j > 0) {
            AdBroadcast.sendBroadCast(this, j, AdBroadcast.ACTION_INTERSTITIAL_SHOW);
        }
    }

    protected void notifyClick() {
        long j = this.mBroadcastIdentifier;
        if (j > 0) {
            AdBroadcast.sendBroadCast(this, j, AdBroadcast.ACTION_INTERSTITIAL_CLICK);
        }
    }

    protected void notifyVideoStarted() {
        long j = this.mBroadcastIdentifier;
        if (j > 0) {
            AdBroadcast.sendBroadCast(this, j, AdBroadcast.ACTION_INTERSTITIAL_VIDEO_STARTED);
        }
    }

    protected void notifyVideoError() {
        long j = this.mBroadcastIdentifier;
        if (j > 0) {
            AdBroadcast.sendBroadCast(this, j, AdBroadcast.ACTION_INTERSTITIAL_VIDEO_ERROR);
        }
    }

    protected void notifyVideoSkipped() {
        long j = this.mBroadcastIdentifier;
        if (j > 0) {
            AdBroadcast.sendBroadCast(this, j, AdBroadcast.ACTION_INTERSTITIAL_VIDEO_SKIPPED);
        }
    }

    protected void notifyVideoCompleted() {
        long j = this.mBroadcastIdentifier;
        if (j > 0) {
            AdBroadcast.sendBroadCast(this, j, AdBroadcast.ACTION_INTERSTITIAL_VIDEO_COMPLETED);
        }
    }

    protected void notifyVideoStopped() {
        long j = this.mBroadcastIdentifier;
        if (j > 0) {
            AdBroadcast.sendBroadCast(this, j, AdBroadcast.ACTION_INTERSTITIAL_VIDEO_STOPPED);
        }
    }

    protected void notifyVideoPaused() {
        long j = this.mBroadcastIdentifier;
        if (j > 0) {
            AdBroadcast.sendBroadCast(this, j, AdBroadcast.ACTION_INTERSTITIAL_VIDEO_PAUSED);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(1024, 1024);
            return;
        }
        if (Build.VERSION.SDK_INT < 30) {
            getWindow().getDecorView().setSystemUiVisibility(4);
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.hide();
                return;
            }
            return;
        }
        getWindow().getDecorView().getWindowInsetsController().hide(WindowInsets.Type.statusBars());
        ActionBar actionBar2 = getActionBar();
        if (actionBar2 != null) {
            actionBar2.hide();
        }
    }
}
