package com.tapjoy.internal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public final class e3 {
    public final File a;

    public e3(File file) {
        this.a = file;
    }

    public final void a() throws IOException {
        try {
            File file = this.a;
            String string = UUID.randomUUID().toString();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, k0.a);
                outputStreamWriter.write(string);
                outputStreamWriter.flush();
            } finally {
                l8.a(fileOutputStream);
            }
        } catch (IOException e) {
            this.a.delete();
            throw e;
        }
    }
}
