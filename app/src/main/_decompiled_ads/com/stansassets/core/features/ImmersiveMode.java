package com.stansassets.core.features;

import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class ImmersiveMode {
    private static boolean IsImmersiveModeEnabled = false;
    private static int SYSTEM_UI_HIDE_DELAY = 2000;
    private static Runnable checkSystemUiRunnable = null;
    private static Handler handler = null;
    private static boolean isSystemUiShown = true;

    public static void EnableImmersiveMode() {
        if (IsImmersiveModeEnabled) {
            return;
        }
        checkSystemUiRunnable = new Runnable() { // from class: com.stansassets.core.features.ImmersiveMode.1
            @Override // java.lang.Runnable
            public void run() {
                ImmersiveMode.checkHideSystemUI();
            }
        };
        handler = new Handler();
        if (IsValidOSVersion()) {
            IsImmersiveModeEnabled = true;
            onWindowFocusChanged(true);
            UiChangeListener();
            try {
                AN_UnityBridge.currentActivity.getWindow().getDecorView().getRootView().getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.stansassets.core.features.ImmersiveMode.2
                    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                    public void onWindowFocusChanged(boolean z) {
                        ImmersiveMode.onWindowFocusChanged(z);
                    }
                });
            } catch (Exception e) {
                Log.d("AndroidNative", "Adding  OnWindowFocusChangeListener observer has failed: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onWindowFocusChanged(boolean z) {
        if (z && IsImmersiveModeEnabled) {
            ApplyImmersive();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkHideSystemUI() {
        if (isSystemUiShown) {
            ApplyImmersive();
            handler.postDelayed(checkSystemUiRunnable, SYSTEM_UI_HIDE_DELAY);
        }
    }

    private static void UiChangeListener() {
        AN_Logger.Log("UiChangeListener");
        try {
            AN_UnityBridge.currentActivity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.stansassets.core.features.ImmersiveMode.3
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if ((i & 4) == 0) {
                        ImmersiveMode.handler.postDelayed(ImmersiveMode.checkSystemUiRunnable, ImmersiveMode.SYSTEM_UI_HIDE_DELAY);
                        boolean unused = ImmersiveMode.isSystemUiShown = true;
                        ImmersiveMode.ApplyImmersive();
                    } else {
                        boolean unused2 = ImmersiveMode.isSystemUiShown = false;
                    }
                    AN_Logger.Log("UiChangeListener isSystemUiShown: " + ImmersiveMode.isSystemUiShown);
                }
            });
        } catch (Exception e) {
            AN_Logger.Log("UiChangeListener Failed: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ApplyImmersive() {
        if (IsValidOSVersion()) {
            AN_UnityBridge.currentActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    private static boolean IsValidOSVersion() {
        return Build.VERSION.SDK_INT >= 19;
    }
}
