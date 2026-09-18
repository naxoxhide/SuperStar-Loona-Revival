package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.internal.s8;
import com.tapjoy.internal.t8;
import com.tapjoy.internal.u8;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class TJCurrency {
    public static TJEarnedCurrencyListener c;
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f2689b;

    public TJCurrency(Context context) {
        this.a = context;
    }

    public final boolean a() {
        if (this.f2689b == null) {
            SharedPreferences sharedPreferences = this.a.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
            if (!sharedPreferences.contains(TapjoyConstants.PREF_CURRENCY_SELF_MANAGED)) {
                return false;
            }
            this.f2689b = Boolean.valueOf(sharedPreferences.getBoolean(TapjoyConstants.PREF_CURRENCY_SELF_MANAGED, false));
        }
        return this.f2689b.booleanValue();
    }

    public void awardCurrency(int i, TJAwardCurrencyListener tJAwardCurrencyListener) {
        if (i < 0) {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Amount must be a positive number for the awardCurrency API"));
            if (tJAwardCurrencyListener != null) {
                tJAwardCurrencyListener.onAwardCurrencyResponseFailure("Amount must be a positive number for the awardCurrency API");
                return;
            }
            return;
        }
        if (a()) {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "awardCurrency is not supported with self managed currency"));
            if (tJAwardCurrencyListener != null) {
                tJAwardCurrencyListener.onAwardCurrencyResponseFailure("awardCurrency is not supported with self managed currency");
                return;
            }
            return;
        }
        String string = UUID.randomUUID().toString();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Map<String, String> genericURLParams = TapjoyConnectCore.getGenericURLParams();
        TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_CURRENCY, String.valueOf(i), true);
        TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_GUID, string, true);
        TapjoyUtil.safePut(genericURLParams, "timestamp", String.valueOf(jCurrentTimeMillis), true);
        TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_VERIFIER, TapjoyConnectCore.getAwardCurrencyVerifier(jCurrentTimeMillis, i, string), true);
        new Thread(new u8(this, genericURLParams, tJAwardCurrencyListener)).start();
    }

    public void getCurrencyBalance(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        if (!a()) {
            new Thread(new s8(this, TapjoyConnectCore.getURLParams(), tJGetCurrencyBalanceListener)).start();
            return;
        }
        TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "getCurrencyBalance is not supported with self managed currency"));
        if (tJGetCurrencyBalanceListener != null) {
            tJGetCurrencyBalanceListener.onGetCurrencyBalanceResponseFailure("getCurrencyBalance is not supported with self managed currency");
        }
    }

    public int getLocalCurrencyBalance() {
        return this.a.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).getInt(TapjoyConstants.PREF_SERVER_CURRENCY_BALANCE, -9999);
    }

    public void saveCurrencyBalance(int i) {
        SharedPreferences.Editor editorEdit = this.a.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        editorEdit.putInt(TapjoyConstants.PREF_SERVER_CURRENCY_BALANCE, i);
        editorEdit.apply();
    }

    public void setEarnedCurrencyListener(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        c = tJEarnedCurrencyListener;
    }

    public void spendCurrency(int i, TJSpendCurrencyListener tJSpendCurrencyListener) {
        if (i < 0) {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Amount must be a positive number for the spendCurrency API"));
            if (tJSpendCurrencyListener != null) {
                tJSpendCurrencyListener.onSpendCurrencyResponseFailure("Amount must be a positive number for the spendCurrency API");
                return;
            }
            return;
        }
        if (a()) {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "spendCurrency is not supported with self managed currency"));
            if (tJSpendCurrencyListener != null) {
                tJSpendCurrencyListener.onSpendCurrencyResponseFailure("spendCurrency is not supported with self managed currency");
                return;
            }
            return;
        }
        Map<String, String> uRLParams = TapjoyConnectCore.getURLParams();
        TapjoyUtil.safePut(uRLParams, TapjoyConstants.TJC_CURRENCY, "" + i, true);
        new Thread(new t8(this, uRLParams, tJSpendCurrencyListener)).start();
    }
}
