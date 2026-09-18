package com.kakao.adfit.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class AdException extends Exception {
    private final AdError a;

    public AdException(AdError adError, String str) {
        super(str);
        this.a = adError;
    }

    public AdError a() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getMessage() != null) {
            sb.append(getMessage());
        } else {
            AdError adError = this.a;
            if (adError != null) {
                sb.append(adError.toString());
            }
        }
        return sb.toString();
    }
}
