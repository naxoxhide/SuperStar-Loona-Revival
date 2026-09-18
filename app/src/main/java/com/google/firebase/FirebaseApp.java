package com.google.firebase;

import android.content.Context;
import java.util.Collections;
import java.util.List;

public class FirebaseApp {
    public static FirebaseApp initializeApp(Context context) {
        return new FirebaseApp();
    }
    public static FirebaseApp initializeApp(Context context, FirebaseOptions options, String name) {
        return new FirebaseApp();
    }
    public static FirebaseApp getInstance() {
        return new FirebaseApp();
    }
    public static List<FirebaseApp> getApps(Context context) {
        return Collections.emptyList();
    }
    public String getName() { return "[DEFAULT]"; }
}
