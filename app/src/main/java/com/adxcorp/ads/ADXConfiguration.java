package com.adxcorp.ads;

public class ADXConfiguration {
    public static Object getGdprType(int i) { return "NONE"; }
    public static Object getGdprType() { return "NONE"; }
    public static Object setGdprType(String s) { return null; }
    public Object setGdprType(int i) { return this; }

    public static class Builder {
        public Builder() {}
        public Builder setAppId(String s) { return this; }
        public Builder setGdprType(String s) { return this; }
        public Builder setGdprType(int i) { return this; }
        public Builder setGdprType(Object o) { return this; }
        public ADXConfiguration build() { return new ADXConfiguration(); }
    }
}
