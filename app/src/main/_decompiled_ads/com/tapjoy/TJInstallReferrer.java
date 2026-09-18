package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.tapjoy.internal.d3;
import com.tapjoy.internal.p1;
import com.tapjoy.internal.r1;
import com.tapjoy.internal.v1;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class TJInstallReferrer implements InvocationHandler {
    public final String a = ADXLogUtil.PLATFORM_TAPJOY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2694b;
    public Context c;
    public SharedPreferences d;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Class cls, Object obj) {
        if (this.f2694b != null) {
            Log.e(this.a, "startConnection");
            try {
                try {
                    Object obj2 = this.f2694b;
                    Class[] clsArr = {cls};
                    Object[] objArr = {obj};
                    try {
                        try {
                            Method method = obj2.getClass().getMethod("startConnection", clsArr);
                            if (method != null) {
                                method.invoke(obj2, objArr);
                            }
                        } catch (Exception e) {
                            Log.e(ADXLogUtil.PLATFORM_TAPJOY, e.getMessage());
                        }
                    } catch (Exception e2) {
                        Log.e(ADXLogUtil.PLATFORM_TAPJOY, e2.getMessage());
                    }
                } catch (Exception e3) {
                    Log.e(this.a, e3.getMessage());
                }
            } catch (NoClassDefFoundError e4) {
                Log.e(this.a, e4.getMessage());
            }
        }
    }

    public void init(Context context) {
        Object objInvoke;
        Object objInvoke2;
        Class<?> cls;
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        Object objNewProxyInstance = null;
        if (applicationContext == null) {
            objInvoke2 = null;
        } else {
            try {
                try {
                    Object[] objArr = {applicationContext};
                    try {
                        Method method = Class.forName("com.android.installreferrer.api.InstallReferrerClient").getMethod("newBuilder", Context.class);
                        objInvoke = method == null ? null : method.invoke(null, objArr);
                    } catch (Exception e) {
                        Log.e(ADXLogUtil.PLATFORM_TAPJOY, e.getMessage());
                    }
                    if (objInvoke != null) {
                        Object[] objArr2 = new Object[0];
                        try {
                            try {
                                Method method2 = objInvoke.getClass().getMethod("build", null);
                                if (method2 != null) {
                                    objInvoke2 = method2.invoke(objInvoke, objArr2);
                                }
                            } catch (Exception e2) {
                                Log.e(ADXLogUtil.PLATFORM_TAPJOY, e2.getMessage());
                            }
                        } catch (Exception e3) {
                            Log.e(ADXLogUtil.PLATFORM_TAPJOY, e3.getMessage());
                        }
                    }
                } catch (NoClassDefFoundError e4) {
                    Log.e(this.a, e4.getMessage());
                }
            } catch (Exception e5) {
                Log.e(this.a, e5.getMessage());
            }
            objInvoke2 = null;
        }
        this.f2694b = objInvoke2;
        if (objInvoke2 == null) {
            Log.e(this.a, "Failed to activate InstallReferrerClient. No available InstallReferrrerClient.");
            return;
        }
        try {
            cls = Class.forName("com.android.installreferrer.api.InstallReferrerStateListener");
        } catch (Exception e6) {
            Log.e(this.a, e6.getMessage());
            cls = null;
        } catch (NoClassDefFoundError e7) {
            Log.e(this.a, e7.getMessage());
            cls = null;
        }
        if (cls == null) {
            Log.e(this.a, "InstallReferrerClient setup failed. No available InstallReferrrerStateListener.");
            return;
        }
        try {
            objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
        } catch (Exception e8) {
            Log.e(this.a, e8.getMessage());
        }
        if (objNewProxyInstance == null) {
            Log.e(this.a, "InstallReferrerClient setup failed. No available InstallReferrrerStateListener object.");
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.tapjoy.referrer", 0);
        this.d = sharedPreferences;
        if (sharedPreferences.getBoolean("TJInstallReferrerDidSetUp", false)) {
            return;
        }
        try {
            a(cls, objNewProxyInstance);
        } catch (Exception e9) {
            Log.e(this.a, e9.getMessage());
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Context context;
        if (method == null) {
            Log.e(this.a, "Failed to invoke null method");
            return null;
        }
        String name = method.getName();
        if (name == null) {
            Log.e(this.a, "Failed to invoke null method name");
            return null;
        }
        if (objArr == null) {
            Log.e(this.a, "Invoking method with null args");
            objArr = new Object[0];
        }
        if (name.equals("onInstallReferrerSetupFinished")) {
            if (objArr.length != 1) {
                Log.e(this.a, "Invalid args");
                return null;
            }
            Object obj2 = objArr[0];
            if (!(obj2 instanceof Integer)) {
                Log.e(this.a, "Invalid args type.");
                return null;
            }
            Integer num = (Integer) obj2;
            if (num == null) {
                Log.e(this.a, "onInstallReferrerSetupFinished response code can't be null");
                return null;
            }
            int iIntValue = num.intValue();
            if (iIntValue == 0) {
                try {
                    a();
                    Object obj3 = this.f2694b;
                    if (obj3 != null) {
                        try {
                            Object[] objArr2 = new Object[0];
                            try {
                                try {
                                    Method method2 = obj3.getClass().getMethod("endConnection", null);
                                    if (method2 != null) {
                                        method2.invoke(obj3, objArr2);
                                    }
                                } catch (Exception e) {
                                    Log.e(ADXLogUtil.PLATFORM_TAPJOY, e.getMessage());
                                }
                            } catch (Exception e2) {
                                Log.e(ADXLogUtil.PLATFORM_TAPJOY, e2.getMessage());
                            }
                        } catch (Exception e3) {
                            Log.e(this.a, e3.getMessage());
                        }
                    }
                } catch (Exception e4) {
                    Log.e(this.a, e4.getMessage());
                }
            } else if (iIntValue == 1 || iIntValue != 2) {
                Log.e(this.a, "Install referrer service isn't available");
            } else {
                Log.e(this.a, "Install referrer isn't supported on the current Play Store app.");
            }
        } else if (name.equals("onInstallReferrerServiceDisconnected") && (context = this.c) != null) {
            init(context);
        }
        return null;
    }

    public final void a() {
        Object objInvoke;
        String strB;
        Object objInvoke2;
        SharedPreferences.Editor editorEdit = this.d.edit();
        editorEdit.putBoolean("TJInstallReferrerDidSetUp", true);
        editorEdit.apply();
        Object obj = this.f2694b;
        String strValueOf = null;
        if (obj != null) {
            try {
                Object[] objArr = new Object[0];
                try {
                    try {
                        Method method = obj.getClass().getMethod("getInstallReferrer", null);
                        objInvoke = method == null ? null : method.invoke(obj, objArr);
                    } catch (Exception e) {
                        Log.e(ADXLogUtil.PLATFORM_TAPJOY, e.getMessage());
                    }
                } catch (Exception e2) {
                    Log.e(ADXLogUtil.PLATFORM_TAPJOY, e2.getMessage());
                }
            } catch (Exception e3) {
                Log.e(this.a, e3.getMessage());
            }
        }
        if (objInvoke == null) {
            editorEdit.putBoolean("TJInstallReferrerDidSetUp", false);
            Log.e(this.a, "Failed to get ReferrerDetails instance.");
            return;
        }
        try {
            Object[] objArr2 = new Object[0];
            try {
                try {
                    Method method2 = objInvoke.getClass().getMethod("getInstallReferrer", null);
                    objInvoke2 = method2 == null ? null : method2.invoke(objInvoke, objArr2);
                } catch (Exception e4) {
                    Log.e(ADXLogUtil.PLATFORM_TAPJOY, e4.getMessage());
                }
            } catch (Exception e5) {
                Log.e(ADXLogUtil.PLATFORM_TAPJOY, e5.getMessage());
            }
            strValueOf = String.valueOf(objInvoke2);
        } catch (Exception e6) {
            Log.e(this.a, e6.getMessage());
        }
        v1 v1Var = v1.m;
        Context context = this.c;
        v1Var.getClass();
        if (strValueOf != null) {
            v1Var.b(context);
            d3 d3Var = v1Var.e;
            synchronized (d3Var) {
                strB = d3Var.e.d.b();
            }
            if (TextUtils.isEmpty(strB)) {
                v1Var.e.a(strValueOf);
                if (strValueOf.length() > 0) {
                    p1 p1Var = v1Var.f;
                    p1Var.getClass();
                    p1Var.a(p1Var.a(r1.APP, TapjoyConstants.TJC_REFERRER));
                }
            }
        }
    }
}
