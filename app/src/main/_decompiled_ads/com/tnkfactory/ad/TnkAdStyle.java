package com.tnkfactory.ad;

import com.tnkfactory.ad.pub.a.h;

/* JADX INFO: loaded from: classes4.dex */
public class TnkAdStyle extends h {
    public static InterstitialStyle AdInterstitial = new InterstitialStyle();

    public static class InterstitialStyle extends h {
        public void setActionButtonLabel(String str) {
            h.adStyle.set(h.ENC_ACTION_BUTTON_LABEL, str);
        }

        public void setCloseButtonLabel(String str) {
            h.adStyle.set(h.ENC_CLOSE_BUTTON_LABEL, str);
        }

        public void setExitButtonLabel(String str) {
            h.adStyle.set(h.ENC_EXIT_BUTTON_LABEL, str);
        }

        public void setFrameTitle(String str) {
            h.adStyle.set(h.ENC_FRAME_TITLE, str);
        }

        public void useTestMode(String str) {
            h.adStyle.set(h.ENC_USE_WINDOW_MODE, str);
        }
    }
}
