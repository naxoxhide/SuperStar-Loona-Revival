package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l8 {
    public static final Logger a = Logger.getLogger(l8.class.getName());

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                try {
                    a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e);
                } catch (IOException e2) {
                    a.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable) e2);
                }
            }
        }
    }
}
