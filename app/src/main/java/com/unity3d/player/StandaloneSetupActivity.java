package com.unity3d.player;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class StandaloneSetupActivity extends Activity {
    private static final String TAG = "SSLOStandalone";
    private static final String STANDALONE_ZIP = "standalone_files.zip";
    private static final String STANDALONE_VER_ASSET = "standalone_pack_version.txt";
    private static final String STANDALONE_VER_MARKER = ".standalone_pack_version";

    private String readAssetVersion() {
        try (InputStream is = getAssets().open(STANDALONE_VER_ASSET);
             BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line = br.readLine();
            return line != null ? line.trim() : "";
        } catch (IOException ignored) {
            return null;
        }
    }

    private String readMarkerVersion(File markerFile) {
        if (!markerFile.exists()) return "";
        try (InputStream is = new FileInputStream(markerFile);
             BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line = br.readLine();
            return line != null ? line.trim() : "";
        } catch (IOException ignored) {
            return "";
        }
    }

    private boolean hasStandaloneBundle() {
        try (InputStream is = getAssets().open(STANDALONE_ZIP)) {
            return true;
        } catch (IOException ignored) {
            return false;
        }
    }

    private void launchGame() {
        if (isFinishing() || isDestroyed()) return;
        Intent intent = new Intent(this, UnityPlayerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    private void extractAndLaunch(final File targetRoot, final String packVersion) {
        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setGravity(Gravity.CENTER);
        container.setBackgroundColor(Color.parseColor("#11131D"));
        int pad = (int) (32 * getResources().getDisplayMetrics().density);
        container.setPadding(pad, pad, pad, pad);

        TextView titleView = new TextView(this);
        titleView.setText("SuperStar LOONA Offline");
        titleView.setTextColor(Color.WHITE);
        titleView.setTextSize(20);
        titleView.setGravity(Gravity.CENTER);
        container.addView(titleView);

        final TextView statusView = new TextView(this);
        statusView.setText("Preparing offline assets (first launch only)...");
        statusView.setTextColor(Color.parseColor("#B8C0D8"));
        statusView.setTextSize(14);
        statusView.setGravity(Gravity.CENTER);
        statusView.setPadding(0, pad / 2, 0, pad / 2);
        container.addView(statusView);

        final ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setIndeterminate(true);
        LinearLayout.LayoutParams pbParams = new LinearLayout.LayoutParams(
                (int) (320 * getResources().getDisplayMetrics().density),
                LinearLayout.LayoutParams.WRAP_CONTENT);
        container.addView(progressBar, pbParams);

        setContentView(container);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (!targetRoot.exists()) {
                        targetRoot.mkdirs();
                    }
                    String canonicalRoot = targetRoot.getCanonicalPath() + File.separator;
                    byte[] buf = new byte[65536];
                    int count = 0;
                    long totalBytes = 0;

                    try (ZipInputStream zis = new ZipInputStream(
                            new BufferedInputStream(getAssets().open(STANDALONE_ZIP), 65536))) {
                        ZipEntry entry;
                        while ((entry = zis.getNextEntry()) != null) {
                            String name = entry.getName();
                            File outFile = new File(targetRoot, name);
                            String canonicalOut = outFile.getCanonicalPath();
                            if (!canonicalOut.startsWith(canonicalRoot)) {
                                throw new SecurityException("Blocked invalid zip entry: " + name);
                            }

                            if (entry.isDirectory()) {
                                outFile.mkdirs();
                            } else {
                                File parent = outFile.getParentFile();
                                if (parent != null && !parent.exists()) {
                                    parent.mkdirs();
                                }
                                if ("player_profile.json".equals(name) && outFile.exists() && outFile.length() > 0) {
                                    zis.closeEntry();
                                    count++;
                                    continue;
                                }
                                try (FileOutputStream fos = new FileOutputStream(outFile)) {
                                    int len;
                                    while ((len = zis.read(buf)) > 0) {
                                        fos.write(buf, 0, len);
                                        totalBytes += len;
                                    }
                                }
                            }
                            zis.closeEntry();
                            count++;
                            if (count % 150 == 0) {
                                final int extractedCount = count;
                                final long extractedMb = totalBytes / (1024 * 1024);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        statusView.setText("Extracting assets... " + extractedCount + " files (" + extractedMb + " MB)");
                                    }
                                });
                            }
                        }
                    }

                    File markerFile = new File(targetRoot, STANDALONE_VER_MARKER);
                    try (FileOutputStream mOut = new FileOutputStream(markerFile)) {
                        mOut.write((packVersion != null ? packVersion : "1").getBytes(StandardCharsets.UTF_8));
                    }
                    Log.i(TAG, "Extracted " + count + " standalone files (" + (totalBytes / (1024 * 1024)) + " MB) to " + targetRoot.getAbsolutePath());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            launchGame();
                        }
                    });
                } catch (final Throwable t) {
                    Log.e(TAG, "Failed extracting standalone bundle", t);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (isFinishing() || isDestroyed()) return;
                            progressBar.setIndeterminate(false);
                            statusView.setText("Failed to extract offline assets: " + t.getMessage());
                        }
                    });
                }
            }
        }, "SSLOAssetExtractor").start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);

        File extRoot = getExternalFilesDir(null);
        String packVer = readAssetVersion();
        if (extRoot != null && packVer != null && hasStandaloneBundle()) {
            File markerFile = new File(extRoot, STANDALONE_VER_MARKER);
            String currentVer = readMarkerVersion(markerFile);
            if (!packVer.equals(currentVer)) {
                extractAndLaunch(extRoot, packVer);
                return;
            }
        }
        launchGame();
    }
}
