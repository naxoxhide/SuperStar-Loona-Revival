package com.google.common.cache;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class RemovalListeners {
    private RemovalListeners() {
    }

    public static <K, V> RemovalListener<K, V> asynchronous(final RemovalListener<K, V> removalListener, final Executor executor) {
        Preconditions.checkNotNull(removalListener);
        Preconditions.checkNotNull(executor);
        return new RemovalListener() { // from class: com.google.common.cache.-$$Lambda$RemovalListeners$xMPxPaAdb3Vu9B0uu4NdtE9sQ8k
            @Override // com.google.common.cache.RemovalListener
            public final void onRemoval(RemovalNotification removalNotification) {
                executor.execute(new Runnable() { // from class: com.google.common.cache.-$$Lambda$RemovalListeners$oU_c933hGNbwXhCVoOFlGI5KiWU
                    @Override // java.lang.Runnable
                    public final void run() {
                        removalListener.onRemoval(removalNotification);
                    }
                });
            }
        };
    }
}
