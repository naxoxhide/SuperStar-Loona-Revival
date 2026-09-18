package com.adxcorp.ads.unity;

import android.widget.PopupWindow;
import com.adxcorp.ads.BannerAd;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.mediation.util.DisplayUtil;
import com.kbeanie.imagechooser.api.ChooserType;
import com.unity3d.player.UnityPlayer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class UnityBannerAd {
    private static final int POSITION_BOTTOM = 1;
    private static final int POSITION_BOTTOM_LEFT = 4;
    private static final int POSITION_BOTTOM_RIGHT = 5;
    private static final int POSITION_CENTER = 6;
    private static final int POSITION_TOP = 0;
    private static final int POSITION_TOP_LEFT = 2;
    private static final int POSITION_TOP_RIGHT = 3;
    private BannerAd mBannerAd;
    private PopupWindow mPopupWindow;

    public UnityBannerAd(final String str, final int i, final int i2, final BannerAd.BannerListener bannerListener) {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityBannerAd.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                AdConstants.BANNER_AD_SIZE banner_ad_size;
                int i4 = i;
                int i5 = 320;
                if (i4 == 1) {
                    i5 = 728;
                    i3 = 90;
                    banner_ad_size = AdConstants.BANNER_AD_SIZE.AD_SIZE_728x90;
                } else if (i4 == 2) {
                    i3 = 100;
                    banner_ad_size = AdConstants.BANNER_AD_SIZE.AD_SIZE_320x100;
                } else if (i4 == 3) {
                    i5 = ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO;
                    i3 = 250;
                    banner_ad_size = AdConstants.BANNER_AD_SIZE.AD_SIZE_300x250;
                } else {
                    i3 = 50;
                    banner_ad_size = AdConstants.BANNER_AD_SIZE.AD_SIZE_320x50;
                }
                UnityBannerAd.this.mBannerAd = new BannerAd(UnityPlayer.currentActivity, str, banner_ad_size);
                UnityBannerAd.this.mBannerAd.setBannerListener(bannerListener);
                UnityBannerAd.this.mPopupWindow = new PopupWindow(UnityBannerAd.this.mBannerAd, DisplayUtil.dpToPx(UnityPlayer.currentActivity, i5), DisplayUtil.dpToPx(UnityPlayer.currentActivity, i3));
                UnityBannerAd.this.mPopupWindow.getContentView().setSystemUiVisibility(UnityPlayer.currentActivity.getWindow().getAttributes().flags);
                UnityBannerAd unityBannerAd = UnityBannerAd.this;
                unityBannerAd.setPopUpWindowLayoutType(unityBannerAd.mPopupWindow, 1002);
                UnityBannerAd.this.showPopUpWindow(i2);
            }
        });
    }

    public void loadAd() {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityBannerAd.2
            @Override // java.lang.Runnable
            public void run() {
                if (UnityBannerAd.this.mBannerAd != null) {
                    UnityBannerAd.this.mBannerAd.loadAd();
                }
            }
        });
    }

    public void destroy() {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityBannerAd.3
            @Override // java.lang.Runnable
            public void run() {
                if (UnityBannerAd.this.mBannerAd != null) {
                    UnityBannerAd.this.mBannerAd.destroy();
                    UnityBannerAd.this.mBannerAd = null;
                }
                if (UnityBannerAd.this.mPopupWindow != null) {
                    UnityBannerAd.this.mPopupWindow.dismiss();
                    UnityBannerAd.this.mPopupWindow = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPopUpWindowLayoutType(PopupWindow popupWindow, int i) {
        try {
            Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(popupWindow, Integer.valueOf(i));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopUpWindow(int i) {
        switch (i) {
            case 1:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 80, 0, 0);
                break;
            case 2:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 51, 0, 0);
                break;
            case 3:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 53, 0, 0);
                break;
            case 4:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 83, 0, 0);
                break;
            case 5:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 85, 0, 0);
                break;
            case 6:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 17, 0, 0);
                break;
            default:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 48, 0, 0);
                break;
        }
    }
}
