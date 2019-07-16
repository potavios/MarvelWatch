package com.pauloos.recyclerviewsample.activity.activity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.pauloos.recyclerviewsample.R;

public class DetailsActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    TextView overview, director, writer, runtime, release, order, youtube;
    private static final String GOOGLE_API_KEY = "AIzaSyBCQ-AWkgAG8W1K12dQ1SgJLraPTKX7fI0";
    private YouTubePlayerView ytpv;
    private String youtubeVideoId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ytpv = findViewById(R.id.myPlayer);

        overview = findViewById(R.id.tv_overview);
        director = findViewById(R.id.tv_director);
        writer = findViewById(R.id.tv_writer);
        runtime = findViewById(R.id.tv_runtime);
        release = findViewById(R.id.tv_release);
        order = findViewById(R.id.tv_order);





        ytpv.initialize( GOOGLE_API_KEY, this);


        String mOverview = getIntent().getStringExtra("overview");
        String mDirector = getIntent().getStringExtra("director");
        String mWriter = getIntent().getStringExtra("writer");
        String mRuntime = getIntent().getStringExtra("runtime");
        String mRelease = getIntent().getStringExtra("release");
        String mOrder = getIntent().getStringExtra("order");
        Boolean mSseen = getIntent().getBooleanExtra("seen", false);
        String mYoutube = getIntent().getStringExtra("youtube");


        overview.setText(mOverview);
        overview.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        director.setText(mDirector);
        writer.setText(mWriter);
        runtime.setText(mRuntime);
        release.setText(mRelease);
        order.setText(mOrder);

        youtubeVideoId = setYoutubeId(mYoutube);





    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean foiRestaurado) {
        Toast.makeText(this, "SUCESSO", Toast.LENGTH_SHORT).show();

        if ( ! foiRestaurado) {
            youTubePlayer.cueVideo(youtubeVideoId);
            youTubePlayer.addFullscreenControlFlag(1);

        }


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "NO SUCESSO", Toast.LENGTH_SHORT).show();

    }

    public String setYoutubeId(String youtube){
        return youtube;
    }
}