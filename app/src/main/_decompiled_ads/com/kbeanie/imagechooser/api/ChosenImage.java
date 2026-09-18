package com.kbeanie.imagechooser.api;

/* JADX INFO: loaded from: classes2.dex */
public class ChosenImage extends ChosenMedia {
    private String filePathOriginal;
    private String fileThumbnail;
    private String fileThumbnailSmall;

    public String getFilePathOriginal() {
        return this.filePathOriginal;
    }

    public void setFilePathOriginal(String str) {
        this.filePathOriginal = str;
    }

    public String getFileThumbnail() {
        return this.fileThumbnail;
    }

    public void setFileThumbnail(String str) {
        this.fileThumbnail = str;
    }

    public String getFileThumbnailSmall() {
        return this.fileThumbnailSmall;
    }

    public void setFileThumbnailSmall(String str) {
        this.fileThumbnailSmall = str;
    }

    @Override // com.kbeanie.imagechooser.api.ChosenMedia
    public String getMediaHeight() {
        return getHeight(this.filePathOriginal);
    }

    @Override // com.kbeanie.imagechooser.api.ChosenMedia
    public String getMediaWidth() {
        return getWidth(this.filePathOriginal);
    }

    public String getExtension() {
        return getFileExtension(this.filePathOriginal);
    }
}
