package com.ifwaxtel.newsapp.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.ifwaxtel.newsapp.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

/**
 * The type Upload pic activity.
 */
public class UploadPicActivity extends AppCompatActivity {
    /**
     * The Menu but.
     */
    ImageView menuBut, /**
     * The Image button 1.
     */
    imageButton1, /**
     * The Image button 2.
     */
    imageButton2, /**
     * The Image button 3.
     */
    imageButton3, /**
     * The Image button 4.
     */
    imageButton4;
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
     * The Image decode.
     */
    String ImageDecode;
    /**
     * The File.
     */
    String[] file;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePath = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePath, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePath[0]);
                    ImageDecode = cursor.getString(columnIndex);
                    imageButton1.setImageBitmap(BitmapFactory.decodeFile(ImageDecode));
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePath = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePath, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePath[0]);
                    ImageDecode = cursor.getString(columnIndex);
                    imageButton2.setImageBitmap(BitmapFactory.decodeFile(ImageDecode));
                }
                break;
            case 3:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePath = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePath, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePath[0]);
                    ImageDecode = cursor.getString(columnIndex);
                    imageButton3.setImageBitmap(BitmapFactory.decodeFile(ImageDecode));
                }
                break;
            case 4:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePath = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePath, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePath[0]);
                    ImageDecode = cursor.getString(columnIndex);
                    imageButton4.setImageBitmap(BitmapFactory.decodeFile(ImageDecode));
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_upload_pic);

        setUpViews();

    }

    private void checkPermission(int pickNum) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(UploadPicActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(UploadPicActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

                } else {
                    ActivityCompat.requestPermissions(UploadPicActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, pickNum);
                }

            } else {
                Intent inte = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(inte, pickNum);
            }
        } else {
            Intent inte = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(inte, pickNum);
        }
    }

    private void setUpViews() {
        menuBut = (ImageView) findViewById(R.id.home);
        imageButton1 = (ImageView) findViewById(R.id.imageButton1);
        imageButton2 = (ImageView) findViewById(R.id.imageButton2);
        imageButton3 = (ImageView) findViewById(R.id.imageButton3);
        imageButton4 = (ImageView) findViewById(R.id.imageButton4);
        reportName = (TextInputEditText) findViewById(R.id.reportName);
        reportLocation = (TextInputEditText) findViewById(R.id.reportLocation);
        reportDescription = (TextInputEditText) findViewById(R.id.reportDescription);
        submitBut = (Button) findViewById(R.id.submit);

        menuBut.setOnClickListener(clickManager);
        imageButton1.setOnClickListener(clickManager);
        imageButton2.setOnClickListener(clickManager);
        imageButton3.setOnClickListener(clickManager);
        imageButton4.setOnClickListener(clickManager);
        submitBut.setOnClickListener(clickManager);

    }

    private View.OnClickListener clickManager = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.home:
                    finish();
                    break;
                case R.id.imageButton1:
                    checkPermission(1);
                    break;
                case R.id.imageButton2:
                    checkPermission(2);
                    break;
                case R.id.imageButton3:
                    checkPermission(3);
                    break;
                case R.id.imageButton4:
                    checkPermission(4);
                    break;
                case R.id.submit:

                    break;

            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent inte = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(inte, requestCode);
        }
    }

}
