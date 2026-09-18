package com.mbridge.msdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.OrientationEventListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.tools.aa;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MBBaseActivity extends Activity {
    private OrientationEventListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Display f1867b;
    private int c = -1;

    public abstract void setTopControllerPadding(int i, int i2, int i3, int i4, int i5);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            b();
            a();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e) {
            aa.d("MBBaseActivity", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (b.c) {
            return;
        }
        getNotchParams();
        b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.a;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.a = null;
        }
    }

    public void getNotchParams() {
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.mbridge.msdk.activity.MBBaseActivity.1
            /* JADX WARN: Code duplicated, block: B:41:0x00e7 A[Catch: Exception -> 0x00ed, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ed, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x001a, B:9:0x0020, B:11:0x0026, B:13:0x0072, B:15:0x0083, B:17:0x008e, B:27:0x00a1, B:39:0x00da, B:41:0x00e7, B:14:0x007d), top: B:46:0x0002 }] */
            /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            public final void run() {
                int safeInsetLeft;
                int safeInsetRight;
                int safeInsetTop;
                int i;
                DisplayCutout displayCutout;
                int i2;
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        WindowInsets rootWindowInsets = MBBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                        int i3 = -1;
                        int i4 = 0;
                        if (rootWindowInsets != null && Build.VERSION.SDK_INT >= 28 && (displayCutout = rootWindowInsets.getDisplayCutout()) != null) {
                            safeInsetLeft = displayCutout.getSafeInsetLeft();
                            safeInsetRight = displayCutout.getSafeInsetRight();
                            safeInsetTop = displayCutout.getSafeInsetTop();
                            int safeInsetBottom = displayCutout.getSafeInsetBottom();
                            aa.d("MBBaseActivity", "NOTCH Left:" + safeInsetLeft + " Right:" + safeInsetRight + " Top:" + safeInsetTop + " Bottom:" + safeInsetBottom);
                            int rotation = MBBaseActivity.this.f1867b != null ? MBBaseActivity.this.f1867b.getRotation() : MBBaseActivity.this.a();
                            if (MBBaseActivity.this.c == -1) {
                                MBBaseActivity mBBaseActivity = MBBaseActivity.this;
                                if (rotation == 0) {
                                    i2 = 3;
                                } else if (rotation == 1) {
                                    i2 = 1;
                                } else if (rotation == 2) {
                                    i2 = 4;
                                } else {
                                    i2 = rotation == 3 ? 2 : -1;
                                }
                                mBBaseActivity.c = i2;
                                aa.d("MBBaseActivity", MBBaseActivity.this.c + "");
                            }
                            if (rotation != 0) {
                                if (rotation == 1) {
                                    i3 = 90;
                                } else if (rotation == 2) {
                                    i3 = 180;
                                } else if (rotation == 3) {
                                    i3 = 270;
                                }
                                i = safeInsetBottom;
                            } else {
                                i = safeInsetBottom;
                            }
                            MBBaseActivity.this.setTopControllerPadding(i4, safeInsetLeft, safeInsetRight, safeInsetTop, i);
                            if (MBBaseActivity.this.a == null) {
                                MBBaseActivity.e(MBBaseActivity.this);
                            }
                        }
                        safeInsetLeft = 0;
                        safeInsetRight = 0;
                        safeInsetTop = 0;
                        i = 0;
                        i4 = i3;
                        MBBaseActivity.this.setTopControllerPadding(i4, safeInsetLeft, safeInsetRight, safeInsetTop, i);
                        if (MBBaseActivity.this.a == null) {
                            MBBaseActivity.e(MBBaseActivity.this);
                        }
                    }
                } catch (Exception e) {
                    aa.d("MBBaseActivity", e.getMessage());
                }
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        if (this.f1867b == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f1867b = getDisplay();
            } else {
                this.f1867b = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        Display display = this.f1867b;
        if (display != null) {
            return display.getRotation();
        }
        return -1;
    }

    private void b() {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(67108864);
                getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(2);
            }
        } catch (Throwable th) {
            aa.d("MBBaseActivity", th.getMessage());
        }
    }

    static /* synthetic */ void e(MBBaseActivity mBBaseActivity) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(mBBaseActivity, 1) { // from class: com.mbridge.msdk.activity.MBBaseActivity.2
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i) {
                int rotation = MBBaseActivity.this.f1867b != null ? MBBaseActivity.this.f1867b.getRotation() : 0;
                if (rotation != 1 || MBBaseActivity.this.c == 1) {
                    if (rotation != 3 || MBBaseActivity.this.c == 2) {
                        if (rotation != 0 || MBBaseActivity.this.c == 3) {
                            if (rotation != 2 || MBBaseActivity.this.c == 4) {
                                return;
                            }
                            MBBaseActivity.this.c = 4;
                            MBBaseActivity.this.getNotchParams();
                            aa.d("MBBaseActivity", "Orientation Bottom");
                            return;
                        }
                        MBBaseActivity.this.c = 3;
                        MBBaseActivity.this.getNotchParams();
                        aa.d("MBBaseActivity", "Orientation Top");
                        return;
                    }
                    MBBaseActivity.this.c = 2;
                    MBBaseActivity.this.getNotchParams();
                    aa.d("MBBaseActivity", "Orientation Right");
                    return;
                }
                MBBaseActivity.this.c = 1;
                MBBaseActivity.this.getNotchParams();
                aa.d("MBBaseActivity", "Orientation Left");
            }
        };
        mBBaseActivity.a = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            mBBaseActivity.a.enable();
        } else {
            mBBaseActivity.a.disable();
            mBBaseActivity.a = null;
        }
    }
}
