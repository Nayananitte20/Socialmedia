package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView ivWhatsApp,ivFacebook,ivInstagram,ivTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivWhatsApp = findViewById(R.id.wp);
        ivFacebook=findViewById(R.id.fb);
        ivInstagram=findViewById(R.id.insta);
        ivTwitter=findViewById(R.id.tw);

        ivWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sNumber="+7760500278";
                Uri uri = Uri.parse(String.format(
                        "https://api.whatsapp.com/send?phone=%s",sNumber

                )) ;

                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        ivFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAppLink = "fb://page/237564710351658";
                String sPackage = "com.facebook.katana";
                String sWebLink = "https://www.facebook.com/12H1rDeveloper";
                openLink(sAppLink,sPackage,sWebLink);
            }
        });

        ivInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAppLink = "https://www.instagram.com/nayana._r._";
                String sPackage = "com.instagram.android";
                openLink(sAppLink,sPackage,sAppLink);
            }
        });

        ivTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAppLink = "twitter://user?screen_name=@imVkohli";
                String sPackage = "com.twitter.android";
                String sWebLink = "https://twitter.com/@imVkohli";
                openLink(sAppLink,sPackage,sWebLink);
            }
        });
    }

    private void openLink(String sAppLink, String sPackage, String sWebLink) {

        try {

            Uri uri= Uri.parse(sAppLink);
            Intent intent= new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(sPackage);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException activityNotFoundException){
            Uri uri = Uri.parse(sWebLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}