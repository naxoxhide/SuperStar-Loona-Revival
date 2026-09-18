package com.applovin.impl.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private static n aRP;
    private static SharedPreferences aRQ;
    private final SharedPreferences ays;

    public e(n nVar) {
        this.ays = n.getApplicationContext().getSharedPreferences("com.applovin.sdk.preferences." + nVar.getSdkKey(), 0);
        if (nVar.Bo()) {
            return;
        }
        aRP = nVar;
    }

    public <T> void a(d<T> dVar, T t) {
        a(dVar, t, this.ays);
    }

    public <T> void a(String str, T t, SharedPreferences.Editor editor) {
        a(str, t, (SharedPreferences) null, editor);
    }

    public <T> void a(d<T> dVar, T t, SharedPreferences sharedPreferences) {
        a(dVar.getName(), t, sharedPreferences);
    }

    public <T> void a(String str, T t, SharedPreferences sharedPreferences) {
        a(str, t, sharedPreferences, (SharedPreferences.Editor) null);
    }

    public static <T> void a(d<T> dVar, T t, Context context) {
        a(dVar.getName(), t, Q(context), (SharedPreferences.Editor) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(String str, T t, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        boolean z = true;
        boolean z2 = editor != null;
        if (!z2) {
            editor = sharedPreferences.edit();
        }
        if (t != 0) {
            if (t instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t).booleanValue());
            } else if (t instanceof Float) {
                editor.putFloat(str, ((Float) t).floatValue());
            } else if (t instanceof Integer) {
                editor.putInt(str, ((Integer) t).intValue());
            } else if (t instanceof Long) {
                editor.putLong(str, ((Long) t).longValue());
            } else if (t instanceof Double) {
                editor.putLong(str, Double.doubleToRawLongBits(((Double) t).doubleValue()));
            } else if (t instanceof String) {
                editor.putString(str, (String) t);
            } else if (t instanceof Set) {
                editor.putStringSet(str, (Set) t);
            } else {
                x.H("SharedPreferencesManager", "Unable to put default value of invalid type: " + t);
                z = false;
            }
        } else {
            editor.remove(str);
        }
        if (!z || z2) {
            return;
        }
        a(editor);
    }

    public <T> T b(d<T> dVar, T t) {
        return (T) b(dVar, t, this.ays);
    }

    public <T> T b(d<T> dVar, T t, SharedPreferences sharedPreferences) {
        return (T) a(dVar.getName(), t, dVar.JH(), sharedPreferences);
    }

    public static <T> T b(d<T> dVar, T t, Context context) {
        return (T) a(dVar.getName(), t, dVar.JH(), Q(context));
    }

    public static <T> T a(d<T> dVar, T t, SharedPreferences sharedPreferences, boolean z) {
        return (T) a(dVar.getName(), t, dVar.JH(), sharedPreferences, z);
    }

    public static <T> T a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        return (T) a(str, t, cls, sharedPreferences, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(String str, T t, Class cls, SharedPreferences sharedPreferences, boolean z) {
        Object objValueOf;
        Object stringSet;
        Object string;
        Object objValueOf2;
        Object objValueOf3;
        Object objValueOf4;
        long jLongValue;
        Object objValueOf5;
        int iIntValue;
        Object objValueOf6;
        Object objValueOf7;
        Object objValueOf8;
        Object objValueOf9;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!sharedPreferences.contains(str)) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return t;
            }
            if (Boolean.class.equals(cls)) {
                if (t != 0) {
                    objValueOf9 = Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()));
                } else {
                    objValueOf8 = Boolean.valueOf(sharedPreferences.getBoolean(str, false));
                }
            } else if (Float.class.equals(cls)) {
                if (t != 0) {
                    objValueOf7 = Float.valueOf(sharedPreferences.getFloat(str, ((Float) t).floatValue()));
                } else {
                    objValueOf6 = Float.valueOf(sharedPreferences.getFloat(str, 0.0f));
                }
            } else if (Integer.class.equals(cls)) {
                if (t != 0) {
                    if (t.getClass().equals(Long.class)) {
                        iIntValue = ((Long) t).intValue();
                    } else {
                        iIntValue = ((Integer) t).intValue();
                    }
                    objValueOf = Integer.valueOf(sharedPreferences.getInt(str, iIntValue));
                } else {
                    objValueOf5 = Integer.valueOf(sharedPreferences.getInt(str, 0));
                }
            } else if (Long.class.equals(cls)) {
                if (t != 0) {
                    if (t.getClass().equals(Integer.class)) {
                        jLongValue = ((Integer) t).longValue();
                    } else {
                        jLongValue = ((Long) t).longValue();
                    }
                    objValueOf = Long.valueOf(sharedPreferences.getLong(str, jLongValue));
                } else {
                    objValueOf4 = Long.valueOf(sharedPreferences.getLong(str, 0L));
                }
            } else if (Double.class.equals(cls)) {
                if (t != 0) {
                    objValueOf3 = Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, Double.doubleToRawLongBits(((Double) t).doubleValue()))));
                } else {
                    objValueOf2 = Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, 0L)));
                }
            } else if (String.class.equals(cls)) {
                string = sharedPreferences.getString(str, (String) t);
            } else if (Set.class.isAssignableFrom(cls)) {
                stringSet = sharedPreferences.getStringSet(str, (Set) t);
            } else {
                objValueOf = t;
            }
            if (objValueOf == null) {
                objValueOf = stringSet;
                objValueOf = string;
                objValueOf = objValueOf2;
                objValueOf = objValueOf3;
                objValueOf = objValueOf4;
                objValueOf = objValueOf5;
                objValueOf = objValueOf6;
                objValueOf = objValueOf7;
                objValueOf = objValueOf8;
                objValueOf = objValueOf9;
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return t;
            }
            objValueOf = stringSet;
            objValueOf = string;
            objValueOf = objValueOf2;
            objValueOf = objValueOf3;
            objValueOf = objValueOf4;
            objValueOf = objValueOf5;
            objValueOf = objValueOf6;
            objValueOf = objValueOf7;
            objValueOf = objValueOf8;
            objValueOf = objValueOf9;
            T t2 = (T) cls.cast(objValueOf);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return t2;
        } catch (Throwable th) {
            if (z) {
                try {
                    x.e("SharedPreferencesManager", "Error getting value for key: " + str, th);
                } finally {
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                }
            }
            return t;
        }
    }

    public <T> void b(d<T> dVar) {
        a(this.ays.edit().remove(dVar.getName()));
    }

    public void a(SharedPreferences sharedPreferences) {
        a(sharedPreferences.edit().clear());
    }

    private static void a(final SharedPreferences.Editor editor) {
        try {
            if (u.Lv()) {
                n nVar = aRP;
                if (nVar != null && nVar.BM() != null) {
                    q qVarBM = aRP.BM();
                    n nVar2 = aRP;
                    Objects.requireNonNull(editor);
                    qVarBM.a(new ab(nVar2, "commitSharedPreferencesChanges", new Runnable() { // from class: com.applovin.impl.sdk.c.-$$Lambda$gelGHbCcdP-JQrJn_-gdfBc_VT0
                        @Override // java.lang.Runnable
                        public final void run() {
                            editor.commit();
                        }
                    }), q.b.BACKGROUND);
                } else {
                    editor.apply();
                }
            } else {
                editor.commit();
            }
        } catch (Throwable th) {
            x.e("SharedPreferencesManager", "Unable to apply changes", th);
        }
    }

    private static SharedPreferences Q(Context context) {
        if (aRQ == null) {
            aRQ = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return aRQ;
    }
}
