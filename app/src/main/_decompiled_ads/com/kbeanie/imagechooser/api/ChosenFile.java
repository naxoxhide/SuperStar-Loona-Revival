package com.kbeanie.imagechooser.api;

/* JADX INFO: loaded from: classes2.dex */
public class ChosenFile {
    private String extension;
    private String fileName;
    private String filePath;
    private long fileSize;
    private String mimeType;
    private String[] imagesExtensions = {".jpg", ".jpeg", ".bpm", ".png", "gif"};
    private String[] videoExtensions = {".mp4", ".mpeg", ".3gp"};

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public String getMimeType() {
        if (this.mimeType == null) {
            for (String str : this.imagesExtensions) {
                if (this.extension.startsWith(str)) {
                    this.mimeType = "image";
                    break;
                }
            }
            if (this.mimeType == null) {
                for (String str2 : this.videoExtensions) {
                    if (this.extension.startsWith(str2)) {
                        this.mimeType = "video";
                        break;
                    }
                }
            }
        }
        return this.mimeType;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String str) {
        this.extension = str;
    }
}
