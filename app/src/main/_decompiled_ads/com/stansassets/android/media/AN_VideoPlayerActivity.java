package com.stansassets.android.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import com.example.an_core.R;
import com.stansassets.core.utility.AN_Logger;
import com.tapjoy.TJAdUnitConstants;

/* JADX INFO: loaded from: classes4.dex */
public class AN_VideoPlayerActivity extends Activity implements MediaPlayer.OnCompletionListener {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setContentView(R.layout.activity_vpfullscreen);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        if (getIntent().getExtras() != null) {
            string = getIntent().getExtras().getString("url");
            if (string != null) {
                videoView.setMediaController(new MediaController(this));
                videoView.setOnCompletionListener(this);
                videoView.setVideoURI(Uri.parse(string));
                int i = getIntent().getExtras().getInt(TJAdUnitConstants.String.ROTATION);
                AN_Logger.Log("you!!!: ");
                AN_Logger.Log("rotation: " + i);
                if (i == 0) {
                    setRequestedOrientation(1);
                } else if (i == 1) {
                    setRequestedOrientation(0);
                } else if (i == 2) {
                    setRequestedOrientation(9);
                } else if (i == 3) {
                    setRequestedOrientation(8);
                }
                videoView.start();
            }
        } else {
            string = null;
        }
        if (string == null) {
            throw new IllegalArgumentException("Must set url extra paremeter in intent.");
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AN_MediaPlayer.onVideoClosed();
    }

    public static void showRemoteVideo(Context context, String str, int i) {
        Intent intent = new Intent(context, (Class<?>) AN_VideoPlayerActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(TJAdUnitConstants.String.ROTATION, i);
        context.startActivity(intent);
    }
}
