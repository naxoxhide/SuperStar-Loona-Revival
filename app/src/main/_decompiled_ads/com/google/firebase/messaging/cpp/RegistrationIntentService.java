package com.google.firebase.messaging.cpp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.JobIntentService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.flatbuffers.FlatBufferBuilder;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes3.dex */
public class RegistrationIntentService extends JobIntentService {
    private static final String TAG = "FirebaseRegService";

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() { // from class: com.google.firebase.messaging.cpp.RegistrationIntentService.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w(RegistrationIntentService.TAG, "Fetching FCM registration token failed", task.getException());
                    return;
                }
                String result = task.getResult();
                DebugLogging.log(RegistrationIntentService.TAG, String.format("onHandleWork token=%s", result));
                if (result != null) {
                    RegistrationIntentService.writeTokenToInternalStorage(this, result);
                }
            }
        });
    }

    public static void writeTokenToInternalStorage(Context context, String str) {
        byte[] bArrGenerateTokenByteBuffer = generateTokenByteBuffer(str);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(bArrGenerateTokenByteBuffer.length);
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("FIREBASE_CLOUD_MESSAGING_LOCKFILE", 0);
            try {
                FileLock fileLockLock = fileOutputStreamOpenFileOutput.getChannel().lock();
                try {
                    FileOutputStream fileOutputStreamOpenFileOutput2 = context.openFileOutput("FIREBASE_CLOUD_MESSAGING_LOCAL_STORAGE", 32768);
                    try {
                        fileOutputStreamOpenFileOutput2.write(byteBufferAllocate.array());
                        fileOutputStreamOpenFileOutput2.write(bArrGenerateTokenByteBuffer);
                        if (fileOutputStreamOpenFileOutput2 != null) {
                            fileOutputStreamOpenFileOutput2.close();
                        }
                        if (fileLockLock != null) {
                            fileLockLock.close();
                        }
                        if (fileOutputStreamOpenFileOutput != null) {
                            fileOutputStreamOpenFileOutput.close();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (fileOutputStreamOpenFileOutput2 != null) {
                                if (th != null) {
                                    try {
                                        fileOutputStreamOpenFileOutput2.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                } else {
                                    fileOutputStreamOpenFileOutput2.close();
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        if (fileLockLock != null) {
                            if (th4 != null) {
                                try {
                                    fileLockLock.close();
                                } catch (Throwable th6) {
                                    th4.addSuppressed(th6);
                                }
                            } else {
                                fileLockLock.close();
                            }
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        if (th7 != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (Throwable th9) {
                                th7.addSuppressed(th9);
                            }
                        } else {
                            fileOutputStreamOpenFileOutput.close();
                        }
                    }
                    throw th8;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] generateTokenByteBuffer(String str) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(0);
        if (str == null) {
            str = "";
        }
        int iCreateString = flatBufferBuilder.createString(str);
        SerializedTokenReceived.startSerializedTokenReceived(flatBufferBuilder);
        SerializedTokenReceived.addToken(flatBufferBuilder, iCreateString);
        int iEndSerializedTokenReceived = SerializedTokenReceived.endSerializedTokenReceived(flatBufferBuilder);
        SerializedEvent.startSerializedEvent(flatBufferBuilder);
        SerializedEvent.addEventType(flatBufferBuilder, (byte) 2);
        SerializedEvent.addEvent(flatBufferBuilder, iEndSerializedTokenReceived);
        flatBufferBuilder.finish(SerializedEvent.endSerializedEvent(flatBufferBuilder));
        return flatBufferBuilder.sizedByteArray();
    }
}
