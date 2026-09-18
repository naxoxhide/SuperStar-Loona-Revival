package com.google.firebase;

public class FirebaseOptions {
    public static class Builder {
        public Builder setApiKey(String s) { return this; }
        public Builder setApplicationId(String s) { return this; }
        public Builder setDatabaseUrl(String s) { return this; }
        public Builder setProjectId(String s) { return this; }
        public FirebaseOptions build() { return new FirebaseOptions(); }
    }
}
