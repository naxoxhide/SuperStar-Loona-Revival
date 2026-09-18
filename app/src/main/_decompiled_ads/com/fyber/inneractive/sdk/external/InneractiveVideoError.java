package com.fyber.inneractive.sdk.external;

/* JADX INFO: loaded from: classes2.dex */
public class InneractiveVideoError extends InneractiveError {
    public final Error a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f914b;

    public enum Error {
        ERROR_NO_MEDIA_FILES("ErrorNoMediaFiles", true),
        ERROR_FAILED_PLAYING_MEDIA_FILE("ErrorPlayingMediaFile", false),
        ERROR_FAILED_PLAYING_ALL_MEDIA_FILES("ErrorPlayingAllMediaFile", true),
        ERROR_PRE_BUFFER_TIMEOUT("ErrorPreBufferTimeout", false),
        ERROR_BUFFER_TIMEOUT("ErrorBufferTimeout", false);

        private String errorString;
        private boolean isFatal;

        Error(String str, boolean z) {
            this.errorString = str;
            this.isFatal = z;
        }

        public String getErrorString() {
            return this.errorString;
        }

        public boolean isFatal() {
            return this.isFatal;
        }
    }

    public InneractiveVideoError(Error error) {
        this.a = error;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveError
    public String description() {
        return this.f914b != null ? this.a.getErrorString() + ": " + this.f914b : this.a.getErrorString();
    }

    public Throwable getCause() {
        return this.f914b;
    }

    public Error getPlayerError() {
        return this.a;
    }

    public InneractiveVideoError(Error error, Throwable th) {
        this(error);
        this.f914b = th;
    }
}
