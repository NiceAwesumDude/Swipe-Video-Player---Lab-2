package com.example.swipevideo_lab2;

import android.os.Bundle;
import android.provider.MediaStore;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPage = findViewById(R.id.videosViewPage);

        List<VideoItem> videoItems = new ArrayList<>();

        videoItems = new ArrayList<>();
        VideoItem videoCheeseburgerKitty = new VideoItem();
        videoCheeseburgerKitty.videoURL = "https://firebasestorage.googleapis.com/v0/b/test-project-52eb5.appspot.com/o/here%20kitty%20you%20can%20have%20cheese%20burger.mp4?alt=media&token=a5af8dce-0686-43ca-9b6d-d659345c6ec0";
        videoCheeseburgerKitty.videoTitle = "Here Kitty";
        videoCheeseburgerKitty.videoDescription = "Giving a kitty a cheeseburger";
        videoItems.add(videoCheeseburgerKitty);

        VideoItem videoIceLake = new VideoItem();
        videoIceLake.videoURL = "https://firebasestorage.googleapis.com/v0/b/test-project-52eb5.appspot.com/o/throwing%20ice%20on%20a%20frozen%20lake%20%23shorts%20%23satisfying%20%23fortheboys.mp4?alt=media&token=5d0e0040-36e6-4b8b-af4c-9e6633d31311";
        videoIceLake.videoTitle = "Frozen Lake";
        videoIceLake.videoDescription = "Satisfying sound of throwing ice on a frozen lake";
        videoItems.add(videoIceLake);

        VideoItem videoRabbit = new VideoItem();
        videoRabbit.videoURL = "https://firebasestorage.googleapis.com/v0/b/test-project-52eb5.appspot.com/o/Rabbit%20Thumps%20for%20Lettuce.mp4?alt=media&token=06384848-4fcf-43cb-b6a0-9553c4b9c48f";
        videoRabbit.videoTitle = "Rabbit Thump";
        videoRabbit.videoDescription = "Rabbit stomps when it wants lettuce";
        videoItems.add(videoRabbit);

        videoViewPage.setAdapter(new VideoAdapter(videoItems));
    }
}