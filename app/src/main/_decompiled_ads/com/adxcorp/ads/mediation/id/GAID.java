package com.adxcorp.ads.mediation.id;

import android.content.Context;
import android.text.TextUtils;
import com.adxcorp.ads.mediation.pref.Preference;
import com.adxcorp.ads.mediation.util.AsyncTaskUtil;
import com.adxcorp.util.ADXLogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class GAID {
    public static final String TAG = "GAID";
    private static GAID ourInstance = new GAID();
    private String mId;
    private boolean mIsDoNotTracking;
    private boolean mIsInitialized;

    public static GAID getInstance() {
        return ourInstance;
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public void getAdvertisingId(final Context context, final OnGAIDListener onGAIDListener) {
        this.mIsInitialized = false;
        try {
            String stringValue = Preference.getStringValue(context, "UDID_GAID", "");
            boolean booleanValue = Preference.getBooleanValue(context, "DO_NOT_TRACKING", false);
            if (!TextUtils.isEmpty(stringValue)) {
                this.mId = stringValue;
                this.mIsDoNotTracking = booleanValue;
                String str = TAG;
                ADXLogUtil.d(str, "saved gaid:" + this.mId);
                ADXLogUtil.d(str, "saved IsDoNotTracking:" + this.mIsDoNotTracking);
                this.mIsInitialized = true;
                if (onGAIDListener != null) {
                    onGAIDListener.onCompleted(this.mId, this.mIsDoNotTracking);
                }
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
        new AsyncTaskUtil() { // from class: com.adxcorp.ads.mediation.id.GAID.1
            @Override // com.adxcorp.ads.mediation.util.AsyncTaskUtil
            public void doInBackground() {
                String str2;
                Exception e2;
                InvocationTargetException e3;
                NoSuchMethodException e4;
                IllegalAccessException e5;
                ClassNotFoundException e6;
                String str3 = null;
                boolean zBooleanValue = false;
                try {
                    Object objInvoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getDeclaredMethod("getAdvertisingIdInfo", Context.class).invoke(null, context.getApplicationContext());
                    if (objInvoke != null) {
                        Method declaredMethod = objInvoke.getClass().getDeclaredMethod("getId", new Class[0]);
                        Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("isLimitAdTrackingEnabled", new Class[0]);
                        str2 = (String) declaredMethod.invoke(objInvoke, new Object[0]);
                        try {
                            zBooleanValue = ((Boolean) declaredMethod2.invoke(objInvoke, new Object[0])).booleanValue();
                            Preference.putString(context, "UDID_GAID", str2);
                            Preference.putBoolean(context, "DO_NOT_TRACKING", zBooleanValue);
                            ADXLogUtil.d(GAID.TAG, "gaid:" + str2);
                            ADXLogUtil.d(GAID.TAG, "IsDoNotTracking:" + zBooleanValue);
                        } catch (ClassNotFoundException e7) {
                            e6 = e7;
                            ADXLogUtil.e(GAID.TAG, e6);
                        } catch (IllegalAccessException e8) {
                            e5 = e8;
                            ADXLogUtil.e(GAID.TAG, e5);
                        } catch (NoSuchMethodException e9) {
                            e4 = e9;
                            ADXLogUtil.e(GAID.TAG, e4);
                        } catch (InvocationTargetException e10) {
                            e3 = e10;
                            ADXLogUtil.e(GAID.TAG, e3);
                        } catch (Exception e11) {
                            e2 = e11;
                            ADXLogUtil.e(GAID.TAG, e2);
                        }
                        str3 = str2;
                    }
                } catch (ClassNotFoundException e12) {
                    str2 = null;
                    e6 = e12;
                } catch (IllegalAccessException e13) {
                    str2 = null;
                    e5 = e13;
                } catch (NoSuchMethodException e14) {
                    str2 = null;
                    e4 = e14;
                } catch (InvocationTargetException e15) {
                    str2 = null;
                    e3 = e15;
                } catch (Exception e16) {
                    str2 = null;
                    e2 = e16;
                }
                if (GAID.this.mIsInitialized) {
                    return;
                }
                GAID.this.mIsInitialized = true;
                if (!TextUtils.isEmpty(str3)) {
                    GAID.this.mId = str3;
                    GAID.this.mIsDoNotTracking = zBooleanValue;
                    OnGAIDListener onGAIDListener2 = onGAIDListener;
                    if (onGAIDListener2 != null) {
                        onGAIDListener2.onCompleted(GAID.this.mId, GAID.this.mIsDoNotTracking);
                        return;
                    }
                    return;
                }
                OnGAIDListener onGAIDListener3 = onGAIDListener;
                if (onGAIDListener3 != null) {
                    onGAIDListener3.onFailed();
                }
            }
        }.execute();
    }

    public String getId() {
        return this.mId;
    }

    public boolean isIsDoNotTracking() {
        return this.mIsDoNotTracking;
    }
}
