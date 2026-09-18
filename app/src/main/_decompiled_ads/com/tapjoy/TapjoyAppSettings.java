package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class TapjoyAppSettings {
    public static final String TAG = "TapjoyAppSettings";
    public static TapjoyAppSettings c;
    public final SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2705b;

    public TapjoyAppSettings(Context context) {
        this.a = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
        a();
    }

    public static TapjoyAppSettings getInstance() {
        return c;
    }

    public static void init(Context context) {
        TapjoyLog.d(TAG, "initializing app settings");
        c = new TapjoyAppSettings(context);
    }

    public final void a() {
        String string = this.a.getString(TapjoyConstants.PREF_LOG_LEVEL, null);
        this.f2705b = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        TapjoyLog.d(TAG, "restoreLoggingLevel from sharedPref -- loggingLevel=" + this.f2705b);
        TapjoyLog.a(this.f2705b, true);
    }

    public void clearLoggingLevel() {
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.remove(TapjoyConstants.PREF_LOG_LEVEL);
        editorEdit.apply();
        this.f2705b = null;
        boolean zIsLoggingEnabled = TapjoyLog.isLoggingEnabled();
        TapjoyLog.i(TAG, "Tapjoy remote device debugging 'Disabled'. The SDK Debug-setting is: ".concat(zIsLoggingEnabled ? "'Enabled'" : "'Disabled'"));
        TapjoyLog.setDebugEnabled(zIsLoggingEnabled);
    }

    public String getConnectResult(String str, long j) {
        String string = this.a.getString(TapjoyConstants.PREF_LAST_CONNECT_RESULT, null);
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(str) && str.equals(this.a.getString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, null))) {
            long j2 = this.a.getLong(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES, -1L);
            if (j2 < 0 || j2 >= j) {
                return string;
            }
        }
        return null;
    }

    public void removeConnectResult() {
        if (this.a.getString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, null) != null) {
            SharedPreferences.Editor editorEdit = this.a.edit();
            editorEdit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT);
            editorEdit.remove(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH);
            editorEdit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES);
            TapjoyLog.i(TAG, "Removed connect result");
            editorEdit.apply();
        }
    }

    public void saveConnectResultAndParams(String str, String str2, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.putString(TapjoyConstants.PREF_LAST_CONNECT_RESULT, str);
        editorEdit.putString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, str2);
        if (j >= 0) {
            editorEdit.putLong(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES, j);
        } else {
            editorEdit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES);
        }
        TapjoyLog.i(TAG, "Stored connect result");
        editorEdit.apply();
    }

    public void saveLoggingLevel(String str) {
        if (TextUtils.isEmpty(str)) {
            TapjoyLog.d(TAG, "saveLoggingLevel -- server logging level is NULL or Empty string");
            return;
        }
        String str2 = TAG;
        TapjoyLog.d(str2, "saveLoggingLevel -- currentLevel=" + this.f2705b + ";newLevel=" + str);
        if (TextUtils.isEmpty(this.f2705b) || !this.f2705b.equals(str)) {
            SharedPreferences.Editor editorEdit = this.a.edit();
            editorEdit.putString(TapjoyConstants.PREF_LOG_LEVEL, str);
            editorEdit.apply();
            this.f2705b = str;
            TapjoyLog.a(str, true);
        }
        TapjoyLog.i(str2, "Tapjoy remote device debugging set to '" + str + "'. The SDK Debug-setting is: " + (TapjoyLog.isLoggingEnabled() ? "'Enabled'" : "'Disabled'"));
    }
}
