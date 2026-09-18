package com.fyber.inneractive.sdk.bidder;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UnitDisplayType.values().length];
            a = iArr;
            try {
                iArr[UnitDisplayType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UnitDisplayType.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[UnitDisplayType.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[UnitDisplayType.MRECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static TokenParametersOuterClass$TokenParameters.NullableBool a(Boolean bool) {
        TokenParametersOuterClass$TokenParameters.NullableBool.a aVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableBool.newBuilder();
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            aVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableBool) aVarNewBuilder.f1272b).setData(zBooleanValue);
        }
        return aVarNewBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.NullableUInt32 b(String str) {
        TokenParametersOuterClass$TokenParameters.NullableUInt32.a aVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (!TextUtils.isEmpty(str)) {
            int i = Integer.parseInt(str);
            aVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) aVarNewBuilder.f1272b).setData(i);
        }
        return aVarNewBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.NullableString c(String str) {
        TokenParametersOuterClass$TokenParameters.NullableString.a aVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableString.newBuilder();
        if (!TextUtils.isEmpty(str)) {
            aVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableString) aVarNewBuilder.f1272b).setData(str);
        }
        return aVarNewBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.NullableUInt32 a(int i) {
        TokenParametersOuterClass$TokenParameters.NullableUInt32.a aVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (i > 0) {
            aVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) aVarNewBuilder.f1272b).setData(i);
        }
        return aVarNewBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.k a(UnitDisplayType unitDisplayType) {
        int i = a.a[unitDisplayType.ordinal()];
        if (i == 1) {
            return TokenParametersOuterClass$TokenParameters.k.BANNER;
        }
        if (i == 2) {
            return TokenParametersOuterClass$TokenParameters.k.INTERSTITIAL;
        }
        if (i == 3) {
            return TokenParametersOuterClass$TokenParameters.k.REWARDED;
        }
        if (i != 4) {
            return TokenParametersOuterClass$TokenParameters.k.UNITDISPLAYTYPEUNKNOWN;
        }
        return TokenParametersOuterClass$TokenParameters.k.MRECT;
    }

    public static TokenParametersOuterClass$TokenParameters.d a(String str) {
        if (str.equals("native")) {
            return TokenParametersOuterClass$TokenParameters.d.NATIVE;
        }
        if (!str.equals("unity3d")) {
            return TokenParametersOuterClass$TokenParameters.d.UNRECOGNIZED;
        }
        return TokenParametersOuterClass$TokenParameters.d.UNITY3D;
    }
}
