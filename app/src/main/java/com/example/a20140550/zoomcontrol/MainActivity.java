package com.example.a20140550.zoomcontrol;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    private ImageView im;
    private ZoomControls zc;
    private VideoView vid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im= (ImageView) findViewById(R.id.imageView);
        zc= (ZoomControls) findViewById(R.id.Zoomid);
        vid= (VideoView) findViewById(R.id.vid);
        zc.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             float x=   im.getScaleX();
             float y=   im.getScaleY();
                im.setScaleX((float) x+1);
                im.setScaleY( (float) y+1);
                Toast.makeText(MainActivity.this, "Zoom In", Toast.LENGTH_SHORT).show();
            }
        });
        zc.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x=   im.getScaleX();
                float y=   im.getScaleY();
                if(x>1 && y>1) {
                    im.setScaleX((float) x - 1);
                    im.setScaleY((float) y - 1);
                }
                Toast.makeText(MainActivity.this, "Zoom Out", Toast.LENGTH_SHORT).show();
            }
        });
        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.song);
        vid.setVideoURI(uri);
        MediaController mc=new MediaController(this);
        vid.setMediaController(mc);
        vid.start();
    }
}
