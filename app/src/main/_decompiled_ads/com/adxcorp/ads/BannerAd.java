package com.adxcorp.ads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.adxcorp.ads.adapter.AdPieBanner;
import com.adxcorp.ads.adapter.AdxAdPieBanner;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.BCustomEventListener;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.ads.common.MaxBiddingKitListener;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.NewsFeed;
import com.adxcorp.ads.mediation.MAdView;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.common.Constants;
import com.adxcorp.ads.mediation.common.DataKeys;
import com.adxcorp.ads.mediation.pref.Preference;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import com.google.ads.mediation.applovin.MaxRewardedVideo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BannerAd extends FrameLayout {
    private static final String TAG = "BannerAd";
    private MAdView.AdListener mAdEventListener;
    private int mAdIdx;
    private AdLandingListener mAdLandingListener;
    private Thread mAdThread;
    private int mAdTotalSize;
    private MAdView mAdView;
    private AdViewState mAdViewState;
    private String mAdxUnitId;
    private AdConstants.BANNER_AD_SIZE mBannerAdSize;
    private BannerListener mBannerListener;
    protected final Context mContext;
    private BannerCustomEvent mCustomEvent;
    private long mCustomEventTimeout;
    protected final Handler mHandler;
    private boolean mInRecyclerView;
    private boolean mIsAttachedToWindow;
    protected boolean mIsAvailableNextAdRequest;
    protected boolean mIsDestroyed;
    private boolean mIsDisableAutoRefresh;
    private boolean mIsInForeground;
    private boolean mIsInitialized;
    private boolean mIsLoading;
    private boolean mIsPauseAutoRefresh;
    private boolean mIsSkipLandingUrl;
    protected ArrayList<MediationData> mMediationData;
    private MediationSettings mMediationSettings;
    protected int mNetworkErrorIdx;
    protected NewsFeed mNewsFeed;
    protected BannerCustomEvent mNextAdContentView;
    private long mRefreshTime;
    private Timer mReloadTimer;
    protected long mResponseInterval;
    private BroadcastReceiver mScreenStateReceiver;

    public interface AdLandingListener {
        void onAdClicked(String str);
    }

    public interface BannerListener {
        void onAdClicked();

        void onAdError(int i);

        void onAdLoaded();
    }

    public BannerAd(Context context, String str, AdConstants.BANNER_AD_SIZE banner_ad_size) {
        super(context);
        this.mRefreshTime = 10000L;
        this.mAdIdx = 0;
        this.mAdTotalSize = 0;
        this.mCustomEventTimeout = 15000L;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.adxcorp.ads.BannerAd.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 204) {
                    BannerAd.this.failedAdNetwork();
                }
            }
        };
        this.mContext = context;
        this.mAdxUnitId = str;
        this.mBannerAdSize = banner_ad_size;
        init();
    }

    public BannerAd(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerAd(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRefreshTime = 10000L;
        this.mAdIdx = 0;
        this.mAdTotalSize = 0;
        this.mCustomEventTimeout = 15000L;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.adxcorp.ads.BannerAd.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 204) {
                    BannerAd.this.failedAdNetwork();
                }
            }
        };
        this.mContext = context;
        parsingAttribute(attributeSet);
        init();
    }

    public void setBannerListener(BannerListener bannerListener) {
        this.mBannerListener = bannerListener;
    }

    public void setInRecyclerView(boolean z) {
        this.mInRecyclerView = z;
    }

    public void setLandingEnabled(boolean z) {
        this.mIsSkipLandingUrl = !z;
    }

    public void setAdLandingListener(AdLandingListener adLandingListener) {
        this.mAdLandingListener = adLandingListener;
    }

    public void disableAutoRefresh() {
        this.mIsDisableAutoRefresh = true;
    }

    public void resumeAutoRefresh() {
        ADXLogUtil.d(TAG, "call resumeAutoRefresh()");
        this.mIsPauseAutoRefresh = false;
        stopReloadTimer();
        startReloadTimer();
    }

    public void pauseAutoRefresh() {
        ADXLogUtil.d(TAG, "call pauseAutoRefresh()");
        this.mIsPauseAutoRefresh = true;
        stopReloadTimer();
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00dc  */
    private void parsingAttribute(AttributeSet attributeSet) {
        byte b2 = 0;
        setBackgroundColor(0);
        if (isInEditMode()) {
            setBackgroundColor(Color.parseColor("#EAEAEA"));
            TextView textView = new TextView(this.mContext);
            textView.setTextColor(Color.parseColor("#82D580"));
            textView.setTextSize(20.0f);
            textView.setText("AD(X) Banner");
            textView.setGravity(17);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(textView);
        }
        if (attributeSet != null) {
            try {
                int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", "ADX_UNIT_ID", 0);
                if (attributeResourceValue != 0) {
                    this.mAdxUnitId = getContext().getResources().getString(attributeResourceValue);
                } else {
                    this.mAdxUnitId = attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "ADX_UNIT_ID");
                }
                String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "BANNER_AD_SIZE");
                if (TextUtils.isEmpty(this.mAdxUnitId)) {
                    this.mAdxUnitId = attributeSet.getAttributeValue(null, "ADX_UNIT_ID");
                }
                if (TextUtils.isEmpty(attributeValue)) {
                    attributeValue = attributeSet.getAttributeValue(null, "BANNER_AD_SIZE");
                }
                if (TextUtils.isEmpty(attributeValue)) {
                    return;
                }
                switch (attributeValue.hashCode()) {
                    case -1987837146:
                        if (!attributeValue.equals("AD_SIZE_300x250")) {
                            b2 = -1;
                        } else {
                            b2 = 6;
                        }
                        break;
                    case -1930579960:
                        if (!attributeValue.equals("AD_SIZE_320x100")) {
                            b2 = -1;
                        } else {
                            b2 = 4;
                        }
                        break;
                    case -1724844636:
                        if (!attributeValue.equals("AD_SIZE_320x50")) {
                            b2 = -1;
                        }
                        break;
                    case -1610089580:
                        if (!attributeValue.equals("AD_SIZE_728x90")) {
                            b2 = -1;
                        } else {
                            b2 = 2;
                        }
                        break;
                    case 49:
                        if (!attributeValue.equals("1")) {
                            b2 = -1;
                        } else {
                            b2 = 1;
                        }
                        break;
                    case 50:
                        if (!attributeValue.equals("2")) {
                            b2 = -1;
                        } else {
                            b2 = 3;
                        }
                        break;
                    case 51:
                        if (!attributeValue.equals("3")) {
                            b2 = -1;
                        } else {
                            b2 = 5;
                        }
                        break;
                    case 52:
                        if (!attributeValue.equals("4")) {
                            b2 = -1;
                        } else {
                            b2 = 7;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                    case 1:
                        this.mBannerAdSize = AdConstants.BANNER_AD_SIZE.AD_SIZE_320x50;
                        break;
                    case 2:
                    case 3:
                        this.mBannerAdSize = AdConstants.BANNER_AD_SIZE.AD_SIZE_728x90;
                        break;
                    case 4:
                    case 5:
                        this.mBannerAdSize = AdConstants.BANNER_AD_SIZE.AD_SIZE_320x100;
                        break;
                    case 6:
                    case 7:
                        this.mBannerAdSize = AdConstants.BANNER_AD_SIZE.AD_SIZE_300x250;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::init");
        if (isInEditMode()) {
            return;
        }
        addEventListener();
        this.mIsInitialized = true;
        this.mNetworkErrorIdx = 0;
        this.mIsAvailableNextAdRequest = false;
        this.mAdViewState = AdViewState.RESUME;
    }

    private void addEventListener() {
        this.mAdEventListener = new MAdView.AdListener() { // from class: com.adxcorp.ads.BannerAd.2
            @Override // com.adxcorp.ads.mediation.MAdView.AdListener
            public void onAdLoaded() {
                if (BannerAd.this.mIsDestroyed) {
                    return;
                }
                BannerAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.BannerAd.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onAdLoaded:::");
                        BannerAd.this.addCustomEventView(BannerAd.this.mCustomEvent);
                        BannerAd.this.mIsLoading = false;
                        if (BannerAd.this.mBannerListener != null) {
                            BannerAd.this.mBannerListener.onAdLoaded();
                        }
                    }
                });
            }

            @Override // com.adxcorp.ads.mediation.MAdView.AdListener
            public void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings, NewsFeed newsFeed) {
                ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onMediationLoaded:::");
                if (mediationSettings != null) {
                    BannerAd.this.mResponseInterval = mediationSettings.getBannerRefreshInterval();
                    Preference.putLong(BannerAd.this.mContext, DataKeys.getKeyWithSlot("RESPONSE_INTERVAL", BannerAd.this.mAdxUnitId), BannerAd.this.mResponseInterval);
                }
                if (BannerAd.this.mIsDestroyed) {
                    return;
                }
                BannerAd.this.mMediationSettings = mediationSettings;
                BannerAd.this.mMediationData = arrayList;
                BannerAd.this.mNewsFeed = newsFeed;
                if (arrayList != null) {
                    BannerAd.this.mAdIdx = 0;
                    BannerAd.this.mAdTotalSize = arrayList.size();
                    int i = 0;
                    for (int i2 = 0; i2 < BannerAd.this.mAdTotalSize; i2++) {
                        try {
                            String adNetworkName = BannerAd.this.mMediationData.get(i2).getAdNetworkName();
                            if (!TextUtils.isEmpty(adNetworkName) && !adNetworkName.equals(ADXLogUtil.PLATFORM_ADPIE)) {
                                i++;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (i == 1) {
                        BannerAd.this.mCustomEventTimeout = AdConstants.MEDIATION_CUSTOM_EVENT_TIMEOUT;
                    } else if (BannerAd.this.mMediationSettings == null || BannerAd.this.mMediationSettings.getMediationRequestTimeout() < 1000) {
                        BannerAd.this.mCustomEventTimeout = 15000L;
                    } else {
                        BannerAd bannerAd = BannerAd.this;
                        bannerAd.mCustomEventTimeout = bannerAd.mMediationSettings.getMediationRequestTimeout();
                    }
                    BannerAd.this.loadAdNetwork(0);
                    return;
                }
                ADXLogUtil.d(BannerAd.TAG, "Mediation data is null!");
                if (BannerAd.this.mAdEventListener != null) {
                    BannerAd.this.mAdEventListener.onAdFailedToLoad(111);
                }
            }

            @Override // com.adxcorp.ads.mediation.MAdView.AdListener
            public void onAdFailedToLoad(final int i) {
                if (BannerAd.this.mIsDestroyed) {
                    return;
                }
                BannerAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.BannerAd.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onAdFailedToLoad:::" + i);
                        BannerAd.this.mIsAvailableNextAdRequest = true;
                        if (i == 102) {
                            BannerAd.this.networkError();
                        } else {
                            BannerAd.this.mNetworkErrorIdx = 0;
                            BannerAd.this.setRefreshTime(BannerAd.this.mResponseInterval);
                        }
                        if (i != 106) {
                            BannerAd.this.mIsLoading = false;
                        }
                        if (BannerAd.this.mBannerListener != null) {
                            BannerAd.this.mBannerListener.onAdError(i);
                        }
                    }
                });
            }

            @Override // com.adxcorp.ads.mediation.MAdView.AdListener
            public void onAdClicked() {
                if (BannerAd.this.mIsDestroyed) {
                    return;
                }
                BannerAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.BannerAd.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onAdClicked:::");
                        if (BannerAd.this.mBannerListener != null) {
                            BannerAd.this.mBannerListener.onAdClicked();
                        }
                    }
                });
            }
        };
    }

    private void removeEventListener() {
        this.mAdEventListener = null;
    }

    public void loadAd() {
        try {
            if (this.mIsLoading) {
                ADXLogUtil.d(TAG, "AdSDK (" + this.mAdxUnitId + ") is already loading an ad. Wait for previous load to finish.");
                MAdView.AdListener adListener = this.mAdEventListener;
                if (adListener != null) {
                    adListener.onAdFailedToLoad(106);
                    return;
                }
                return;
            }
            this.mIsLoading = true;
            Thread thread = this.mAdThread;
            if (thread != null) {
                thread.interrupt();
                this.mAdThread = null;
            }
            Thread thread2 = new Thread(new Runnable() { // from class: com.adxcorp.ads.BannerAd.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::load");
                        if (!TextUtils.isEmpty(BannerAd.this.mAdxUnitId)) {
                            BannerAd bannerAd = BannerAd.this;
                            bannerAd.mResponseInterval = Preference.getLongValue(bannerAd.mContext, DataKeys.getKeyWithSlot("RESPONSE_INTERVAL", BannerAd.this.mAdxUnitId), 0L);
                        }
                        if (!BannerAd.this.mIsInitialized) {
                            BannerAd.this.init();
                        }
                        try {
                            if (BannerAd.this.mAdView == null) {
                                BannerAd.this.mAdView = new MAdView(BannerAd.this.mContext);
                            }
                            BannerAd.this.mAdView.setSlotId(BannerAd.this.mAdxUnitId);
                            BannerAd.this.mAdView.setAdListener(BannerAd.this.mAdEventListener);
                            BannerAd.this.mAdView.load();
                        } catch (Exception e) {
                            ADXLogUtil.e(BannerAd.TAG, e);
                            if (BannerAd.this.mAdEventListener != null) {
                                BannerAd.this.mAdEventListener.onAdFailedToLoad(104);
                            }
                        }
                    } catch (Exception e2) {
                        ADXLogUtil.e(BannerAd.TAG, e2);
                    }
                }
            });
            this.mAdThread = thread2;
            thread2.start();
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            MAdView.AdListener adListener2 = this.mAdEventListener;
            if (adListener2 != null) {
                adListener2.onAdFailedToLoad(104);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pause() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, this.mAdxUnitId + ":::pause");
        }
        this.mAdViewState = AdViewState.PAUSE;
        stopReloadTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, this.mAdxUnitId + ":::resume");
        }
        if (this.mAdViewState.isPause()) {
            this.mAdViewState = AdViewState.RESUME;
            stopReloadTimer();
            startReloadTimer();
        }
    }

    private void release() {
        removeAllViews();
        pause();
        destroyCustomEvent(this.mNextAdContentView);
        this.mNextAdContentView = null;
        MAdView mAdView = this.mAdView;
        if (mAdView != null) {
            mAdView.destroy();
            this.mAdView = null;
        }
        removeEventListener();
        Thread thread = this.mAdThread;
        if (thread != null) {
            thread.interrupt();
            this.mAdThread = null;
        }
    }

    public void destroy() {
        this.mIsDestroyed = true;
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::destroy");
        try {
            release();
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::onAttachedToWindow");
        this.mIsAttachedToWindow = true;
        registerBroadcastReceiver();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::onDetachedFromWindow");
        this.mIsAttachedToWindow = false;
        unregisterBroadcastReceiver();
        if (!this.mInRecyclerView) {
            try {
                release();
            } catch (Exception e) {
                ADXLogUtil.e(TAG, e);
            }
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNextAd() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "Preparing to load next ads.");
        }
        this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.BannerAd.4
            @Override // java.lang.Runnable
            public void run() {
                BannerAd.this.loadAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void networkError() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "networkError");
        }
        stopReloadTimer();
        int i = this.mNetworkErrorIdx;
        if (i < 0 || i > Constants.NETWORK_INTERVAL.length - 1) {
            this.mNetworkErrorIdx = 0;
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "NetworkErrorIdx : " + this.mNetworkErrorIdx);
        }
        int[] iArr = Constants.NETWORK_INTERVAL;
        int i2 = this.mNetworkErrorIdx;
        long j = iArr[i2];
        this.mNetworkErrorIdx = i2 + 1;
        ADXLogUtil.d(TAG, "networkError setRefreshTime : " + j);
        this.mRefreshTime = j;
        startReloadTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRefreshTime(long j) {
        if (j > 0 && j < 10000) {
            this.mRefreshTime = 10000L;
        } else if (j > 300000) {
            this.mRefreshTime = 300000L;
        } else {
            this.mRefreshTime = j;
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "setRefreshTime : " + j + " -> " + this.mRefreshTime);
        }
        if (this.mAdViewState.isPause()) {
            stopReloadTimer();
        } else {
            stopReloadTimer();
            startReloadTimer();
        }
    }

    private void startReloadTimer() {
        String str = TAG;
        ADXLogUtil.d(str, "mIsDisableAutoRefresh : " + this.mIsDisableAutoRefresh + ", mIsPauseAutoRefresh : " + this.mIsPauseAutoRefresh + ", mIsAvailableNextAdRequest : " + this.mIsAvailableNextAdRequest);
        if (this.mIsDisableAutoRefresh || this.mIsPauseAutoRefresh || !this.mIsAvailableNextAdRequest) {
            return;
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(str, "startReloadTimer (mResponseInterval : " + this.mResponseInterval + ", mRefreshTime : " + this.mRefreshTime + ")");
        }
        if (this.mResponseInterval == 0 || this.mRefreshTime < 10000) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(str, "AdView refresh is disable.");
            }
        } else if (!this.mIsAttachedToWindow) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(str, "AdView not yet attached to window.");
            }
        } else {
            if (this.mReloadTimer == null) {
                this.mReloadTimer = new Timer();
            }
            this.mReloadTimer.schedule(new ReloadTask(), this.mRefreshTime);
        }
    }

    private void stopReloadTimer() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "stopReloadTimer");
        }
        Timer timer = this.mReloadTimer;
        if (timer == null) {
            return;
        }
        timer.cancel();
        this.mReloadTimer = null;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (i == 0) {
            this.mIsInForeground = true;
            resume();
        } else {
            this.mIsInForeground = false;
            pause();
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "AdView onWindowVisibilityChanged(" + i + "): " + (i == 0 ? "VISIBLE" : "INVISIBLE"));
        }
    }

    private boolean isDeviceInteractive() {
        try {
            PowerManager powerManager = (PowerManager) this.mContext.getSystemService("power");
            if (Build.VERSION.SDK_INT >= 21) {
                return powerManager.isInteractive();
            }
            return powerManager.isScreenOn();
        } catch (Exception e) {
            if (!MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                return true;
            }
            ADXLogUtil.e(TAG, e);
            return true;
        }
    }

    private void registerBroadcastReceiver() {
        try {
            this.mScreenStateReceiver = new BroadcastReceiver() { // from class: com.adxcorp.ads.BannerAd.5
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(BannerAd.TAG, "Intent.ACTION_SCREEN_OFF : " + BannerAd.this.mIsInForeground);
                        }
                        if (BannerAd.this.mIsInForeground) {
                            BannerAd.this.pause();
                            return;
                        }
                        return;
                    }
                    if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(BannerAd.TAG, "Intent.ACTION_SCREEN_ON : " + BannerAd.this.mIsInForeground);
                        }
                        if (BannerAd.this.mIsInForeground) {
                            BannerAd.this.resume();
                            return;
                        }
                        return;
                    }
                    if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(BannerAd.TAG, "Intent.ACTION_USER_PRESENT : " + BannerAd.this.mIsInForeground);
                        }
                        if (BannerAd.this.mIsInForeground) {
                            BannerAd.this.resume();
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.mContext.registerReceiver(this.mScreenStateReceiver, intentFilter);
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    private void unregisterBroadcastReceiver() {
        try {
            this.mContext.unregisterReceiver(this.mScreenStateReceiver);
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    protected void loadAdNetwork(int i) {
        if (this.mIsDestroyed) {
            return;
        }
        final boolean[] zArr = {false};
        String customEventName = null;
        try {
            final MediationData mediationData = this.mMediationData.get(i);
            try {
                customEventName = !TextUtils.isEmpty(mediationData.getBidResponse()) ? "com.adxcorp.ads.adapter.AdPieBanner" : mediationData.getCustomEventName();
                BannerCustomEvent bannerCustomEvent = (BannerCustomEvent) instantiateClassWithEmptyConstructor(customEventName, BannerCustomEvent.class);
                this.mCustomEvent = bannerCustomEvent;
                AdConstants.BANNER_AD_SIZE banner_ad_size = this.mBannerAdSize;
                if (banner_ad_size != null) {
                    bannerCustomEvent.setBannerAdSize(banner_ad_size);
                }
                BannerCustomEvent bannerCustomEvent2 = this.mCustomEvent;
                if (bannerCustomEvent2 instanceof AdPieBanner) {
                    ((AdPieBanner) bannerCustomEvent2).setMediationData(mediationData);
                } else {
                    if (bannerCustomEvent2 instanceof AdxAdPieBanner) {
                        ((AdxAdPieBanner) bannerCustomEvent2).setFloorPrice(String.valueOf(mediationData.getEcpm()));
                    }
                    ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, ReportUtil.EVENT_TYPE_ATTEMPT);
                }
                this.mCustomEvent.internalLoadAd(this.mContext, mediationData, this.mCustomEventTimeout, new BCustomEventListener() { // from class: com.adxcorp.ads.BannerAd.6
                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdLoaded() {
                        if (BannerAd.this.mIsDestroyed) {
                            return;
                        }
                        BannerAd.this.loadMaxBiddingKit(mediationData.getEcpm(), new MaxBiddingKitListener() { // from class: com.adxcorp.ads.BannerAd.6.1
                            @Override // com.adxcorp.ads.common.MaxBiddingKitListener
                            public void onAdLoadResult(boolean z) {
                                ADXLogUtil.d(BannerAd.TAG, "loadMaxBiddingKit:::type1:::" + mediationData.getEcpm() + ":::" + z);
                                if (!z) {
                                    if (BannerAd.this.mCustomEvent != null) {
                                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, ReportUtil.EVENT_TYPE_FILL);
                                        if (BannerAd.this.mAdEventListener != null) {
                                            BannerAd.this.mAdEventListener.onAdLoaded();
                                        }
                                    } else {
                                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, ReportUtil.EVENT_TYPE_NO_FILL);
                                        BannerAd.this.mHandler.sendEmptyMessage(204);
                                    }
                                } else if (BannerAd.this.mAdEventListener != null) {
                                    BannerAd.this.mAdEventListener.onAdLoaded();
                                }
                                zArr[0] = true;
                            }
                        });
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdError() {
                        if (BannerAd.this.mIsDestroyed) {
                            return;
                        }
                        BannerAd bannerAd = BannerAd.this;
                        bannerAd.destroyCustomEvent(bannerAd.mCustomEvent);
                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, ReportUtil.EVENT_TYPE_NO_FILL);
                        BannerAd.this.mHandler.sendEmptyMessage(204);
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdClicked() {
                        if (BannerAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, "click");
                        if (BannerAd.this.mAdEventListener != null) {
                            BannerAd.this.mAdEventListener.onAdClicked();
                        }
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdImpression() {
                        if (BannerAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, "impression");
                    }
                });
            } catch (Error e) {
                ADXLogUtil.d(TAG, "Error : " + customEventName + ", AD index : " + i);
                e.printStackTrace();
                if (zArr[0]) {
                    return;
                }
                ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, ReportUtil.EVENT_TYPE_NO_FILL);
                this.mHandler.sendEmptyMessage(204);
            } catch (Exception e2) {
                ADXLogUtil.d(TAG, "Exception : " + customEventName + ", AD index : " + i);
                e2.printStackTrace();
                if (zArr[0]) {
                    return;
                }
                ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, ReportUtil.EVENT_TYPE_NO_FILL);
                this.mHandler.sendEmptyMessage(204);
            }
        } catch (Exception e3) {
            ADXLogUtil.d(TAG, "Exception - AD index : " + i + ", message : " + e3.getMessage());
            this.mHandler.sendEmptyMessage(204);
        }
    }

    protected void addCustomEventView(BannerCustomEvent bannerCustomEvent) {
        try {
            addView(bannerCustomEvent.getAdView());
            BannerCustomEvent bannerCustomEvent2 = this.mNextAdContentView;
            if (bannerCustomEvent2 != null) {
                bannerCustomEvent2.setVisibility(8);
                removeView(bannerCustomEvent2.getAdView());
                destroyCustomEvent(bannerCustomEvent2);
            }
            this.mNextAdContentView = bannerCustomEvent;
            if (bannerCustomEvent != null) {
                bannerCustomEvent.setVisibility(0);
                this.mNextAdContentView.impression();
            }
            this.mIsAvailableNextAdRequest = true;
            this.mNetworkErrorIdx = 0;
            setRefreshTime(this.mResponseInterval);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failedAdNetwork() {
        if (this.mIsDestroyed) {
            return;
        }
        int i = this.mAdIdx;
        if (i + 1 < this.mAdTotalSize) {
            int i2 = i + 1;
            this.mAdIdx = i2;
            loadAdNetwork(i2);
        } else {
            final double biddingKitEcpm = 0.05d;
            try {
                biddingKitEcpm = this.mMediationSettings.getBiddingKitEcpm();
            } catch (Exception unused) {
            }
            loadMaxBiddingKit(biddingKitEcpm, new MaxBiddingKitListener() { // from class: com.adxcorp.ads.BannerAd.7
                @Override // com.adxcorp.ads.common.MaxBiddingKitListener
                public void onAdLoadResult(boolean z) {
                    ADXLogUtil.d(BannerAd.TAG, "loadMaxBiddingKit:::type2:::" + biddingKitEcpm + ":::" + z);
                    if (!z) {
                        if (BannerAd.this.mAdEventListener != null) {
                            BannerAd.this.mAdEventListener.onAdFailedToLoad(100);
                        }
                    } else if (BannerAd.this.mAdEventListener != null) {
                        BannerAd.this.mAdEventListener.onAdLoaded();
                    }
                }
            });
        }
    }

    private <T> T instantiateClassWithEmptyConstructor(String str, Class<? extends T> cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, NullPointerException, InvocationTargetException {
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor((Class[]) null);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMaxBiddingKit(double d, final MaxBiddingKitListener maxBiddingKitListener) {
        if (this.mIsDestroyed) {
            return;
        }
        MediationSettings mediationSettings = this.mMediationSettings;
        if (mediationSettings != null && !mediationSettings.isEnableBiddingKit()) {
            ADXLogUtil.d(TAG, "MAX bidding kit not enabled on dashboard.");
            if (maxBiddingKitListener != null) {
                maxBiddingKitListener.onAdLoadResult(false);
                return;
            }
            return;
        }
        final MediationData mediationData = new MediationData();
        try {
            mediationData.setMediationId(this.mMediationSettings.getBiddingKitMediationId());
            mediationData.setEcpm(d);
            mediationData.setRequestId(this.mMediationSettings.getBiddingKitRequestId());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MaxRewardedVideo.ADUNIT_ID_EXTRA_KEY, this.mMediationSettings.getBiddingKitAdUnitId());
            jSONObject.put("enableBiddingKit", this.mMediationSettings.isEnableBiddingKit());
            jSONObject.put("ecpm", d);
            mediationData.setCustomEventParams(jSONObject.toString());
            mediationData.setMetricEndpointFormat(this.mMediationSettings.getBiddingKitMetricEndpointFormat());
            mediationData.setAdNetworkName("applovin");
            mediationData.setCustomEventName("com.adxcorp.ads.adapter.AppLovinBanner");
            ADXLogUtil.d(TAG, "[loadMaxBiddingKit] mediationData : " + mediationData);
            final BannerCustomEvent bannerCustomEvent = (BannerCustomEvent) instantiateClassWithEmptyConstructor("com.adxcorp.ads.adapter.AppLovinBanner", BannerCustomEvent.class);
            AdConstants.BANNER_AD_SIZE banner_ad_size = this.mBannerAdSize;
            if (banner_ad_size != null) {
                bannerCustomEvent.setBannerAdSize(banner_ad_size);
            }
            ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, ReportUtil.EVENT_TYPE_ATTEMPT);
            bannerCustomEvent.internalLoadAd(this.mContext, mediationData, 5000L, new BCustomEventListener() { // from class: com.adxcorp.ads.BannerAd.8
                @Override // com.adxcorp.ads.common.CustomEventListener
                public void onAdLoaded() {
                    if (BannerAd.this.mIsDestroyed) {
                        return;
                    }
                    if (bannerCustomEvent != null) {
                        BannerAd bannerAd = BannerAd.this;
                        bannerAd.destroyCustomEvent(bannerAd.mCustomEvent);
                        BannerAd.this.mCustomEvent = bannerCustomEvent;
                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, ReportUtil.EVENT_TYPE_FILL);
                        MaxBiddingKitListener maxBiddingKitListener2 = maxBiddingKitListener;
                        if (maxBiddingKitListener2 != null) {
                            maxBiddingKitListener2.onAdLoadResult(true);
                            return;
                        }
                        return;
                    }
                    ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, ReportUtil.EVENT_TYPE_NO_FILL);
                    MaxBiddingKitListener maxBiddingKitListener3 = maxBiddingKitListener;
                    if (maxBiddingKitListener3 != null) {
                        maxBiddingKitListener3.onAdLoadResult(false);
                    }
                }

                @Override // com.adxcorp.ads.common.CustomEventListener
                public void onAdError() {
                    if (BannerAd.this.mIsDestroyed) {
                        return;
                    }
                    ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, ReportUtil.EVENT_TYPE_NO_FILL);
                    MaxBiddingKitListener maxBiddingKitListener2 = maxBiddingKitListener;
                    if (maxBiddingKitListener2 != null) {
                        maxBiddingKitListener2.onAdLoadResult(false);
                    }
                }

                @Override // com.adxcorp.ads.common.CustomEventListener
                public void onAdClicked() {
                    if (BannerAd.this.mIsDestroyed) {
                        return;
                    }
                    ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, "click");
                    if (BannerAd.this.mAdEventListener != null) {
                        BannerAd.this.mAdEventListener.onAdClicked();
                    }
                }

                @Override // com.adxcorp.ads.common.CustomEventListener
                public void onAdImpression() {
                    if (BannerAd.this.mIsDestroyed) {
                        return;
                    }
                    ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_BANNER, "impression");
                }
            });
        } catch (Error e) {
            ADXLogUtil.d(TAG, "com.adxcorp.ads.adapter.AppLovinBanner - Error : " + e.getMessage());
            e.printStackTrace();
            if (maxBiddingKitListener != null) {
                maxBiddingKitListener.onAdLoadResult(false);
            }
        } catch (Exception e2) {
            ADXLogUtil.d(TAG, "com.adxcorp.ads.adapter.AppLovinBanner - Exception : " + e2.getMessage());
            e2.printStackTrace();
            if (maxBiddingKitListener != null) {
                maxBiddingKitListener.onAdLoadResult(false);
            }
        }
    }

    private enum AdViewState {
        PAUSE,
        RESUME;

        boolean isPause() {
            return this == PAUSE;
        }
    }

    class ReloadTask extends TimerTask {
        ReloadTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BannerAd bannerAd = BannerAd.this;
            if (bannerAd != null) {
                bannerAd.loadNextAd();
            }
        }
    }

    protected void destroyCustomEvent(final BannerCustomEvent bannerCustomEvent) {
        try {
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new Runnable() { // from class: com.adxcorp.ads.BannerAd.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            BannerCustomEvent bannerCustomEvent2 = bannerCustomEvent;
                            if (bannerCustomEvent2 != null) {
                                bannerCustomEvent2.destroy();
                            }
                        } catch (Exception e) {
                            ADXLogUtil.e(BannerAd.TAG, e);
                        }
                    }
                });
            } else if (bannerCustomEvent != null) {
                bannerCustomEvent.destroy();
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }
}
