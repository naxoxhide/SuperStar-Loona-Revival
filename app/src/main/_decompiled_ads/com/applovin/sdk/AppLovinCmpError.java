package com.applovin.sdk;

/* JADX INFO: loaded from: classes2.dex */
public interface AppLovinCmpError {
    int getCmpCode();

    String getCmpMessage();

    Code getCode();

    String getMessage();

    public enum Code {
        UNSPECIFIED(-1),
        INTEGRATION_ERROR(1),
        FORM_UNAVAILABLE(2),
        FORM_NOT_REQUIRED(3);

        private final int ahF;

        Code(int i) {
            this.ahF = i;
        }

        public int getValue() {
            return this.ahF;
        }
    }
}
