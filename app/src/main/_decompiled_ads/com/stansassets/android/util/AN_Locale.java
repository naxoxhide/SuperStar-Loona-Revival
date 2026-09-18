package com.stansassets.android.util;

import com.stansassets.core.utility.AN_UnityBridge;
import java.util.Currency;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Locale {
    public String m_CountryCode;
    public String m_CurrencyCode;
    public String m_CurrencySymbol;
    public String m_LanguageCode;

    public static String GetDefault() {
        Locale locale = Locale.getDefault();
        AN_Locale aN_Locale = new AN_Locale();
        aN_Locale.m_CountryCode = locale.getISO3Country();
        aN_Locale.m_LanguageCode = locale.getISO3Language();
        Currency currency = Currency.getInstance(locale);
        aN_Locale.m_CurrencyCode = currency.getCurrencyCode();
        aN_Locale.m_CurrencySymbol = currency.getSymbol();
        return AN_UnityBridge.toJson(aN_Locale);
    }
}
