package com.fyber.inneractive.sdk.flow.vast;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f937b;

    public enum a {
        BITRATE_NOT_IN_RANGE(1),
        UNSUPPORTED_MIME_TYPE(2),
        UNSUPPORTED_DELIVERY(3),
        UNSECURED_VIDEO_URL(4),
        VERTICAL_VIDEO_EXPECTED(5),
        FILTERED_BY_APP_OR_UNIT(6),
        NO_CONTENT(7);

        public int value;

        a(int i) {
            this.value = i;
        }
    }

    public g(a aVar, Object obj) {
        this.a = aVar;
        this.f937b = obj;
    }

    public String toString() {
        return "Media File inc error::  type = " + this.a + " expected value = " + this.f937b;
    }
}
