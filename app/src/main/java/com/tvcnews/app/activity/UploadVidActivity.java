package com.tvcnews.app.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.tvcnews.app.R;

/**
 * The type Upload vid activity.
 */
public class UploadVidActivity extends AppCompatActivity {
    /**
     * The Menu but.
     */
    ImageView menuBut, /**
     * The Play button.
     */
    playButton;
    /**
     * The Image button 1.
     */
    VideoView imageButton1;
    /**
     * The Report name.
     */
    TextInputEditText reportName, /**
     * The Report location.
     */
    reportLocation, /**
     * The Report description.
     */
    reportDescription;
    /**
     * The Submit but.
     */
    Button submitBut;

    /**
     * The Vid decode.
     */
    String vidDecode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this,R.layout.activity_upload_vid);

        setUpViews();
    }

    private void checkPermission(int pickNum){
        if(Build.VERSION.SDK_INT>=23){
            if(ContextCompat.checkSelfPermission(UploadVidActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                if (ActivityCompat.shouldShowRequestPermissionRationale(UploadVidActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){

                }
                else{
                    ActivityCompat.requestPermissions(UploadVidActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},pickNum);
                }

            }
            else{
                Intent inte = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                inte.setType("video/*");
                startActivityForResult(inte,pickNum);
            }
        }
        else{
            Intent inte = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            inte.setType("video/*");
            startActivityForResult(inte,pickNum);
        }
    }

    private void setUpViews(){
        menuBut = (ImageView) findViewById(R.id.home);
        playButton = (ImageView) findViewById(R.id.playButton);
        imageButton1 = (VideoView) findViewById(R.id.imageButton1);
        reportName = (TextInputEditText)findViewById(R.id.reportName);
        reportLocation = (TextInputEditText)findViewById(R.id.reportLocation);
        reportDescription = (TextInputEditText)findViewById(R.id.reportDescription);
        submitBut = (Button)findViewById(R.id.submit);

        menuBut.setOnClickListener(clickManager);
        playButton.setOnClickListener(clickManager);
        submitBut.setOnClickListener(clickManager);

        //String path = "android.resource://"+getPackageName()+"/"+R.raw.funny;
        //imageButton1.setVideoURI(Uri.parse(path));
        //imageButton1.start();
    }

    private View.OnClickListener clickManager = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.home:
                    finish();
                    break;
                case R.id.playButton:
                    checkPermission(1);
                    break;
                case R.id.submit:

                    break;

            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        if(Build.VERSION.SDK_INT>=21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    String[] filePath = {MediaStore.Video.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage,filePath,null,null,null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePath[0]);
                    vidDecode = cursor.getString(columnIndex);
                    imageButton1.setVideoURI(selectedImage);
                    MediaController controller = new MediaController(this);
                    controller.setAnchorView(imageButton1);
                    imageButton1.setMediaController(controller);
                    playButton.setVisibility(View.GONE);
                    //imageButton1.start();
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Intent inte = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            inte.setType("video/*");
            startActivityForResult(inte,requestCode);
        }
    }

}
