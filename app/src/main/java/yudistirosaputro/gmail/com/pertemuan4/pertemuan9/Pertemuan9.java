package yudistirosaputro.gmail.com.pertemuan4.pertemuan9;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import yudistirosaputro.gmail.com.pertemuan4.R;

public class Pertemuan9 extends AppCompatActivity implements View.OnClickListener {


    Button button1;
    ImageView imageView;
    private Uri mCapturedImageURI;
    private static final int REQUEST_IMAGE_CAPTURE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertemuan9);
        button1 = findViewById(R.id.btnKamera);
        imageView = findViewById(R.id.imageView);
        button1.setOnClickListener(this);
        isStoragePermissionGranted();
    }
    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
//                Log.v(TAG,"Permission is granted");
                return true;
            } else {

//                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
//            Log.v(TAG,"Permission is granted");
            return true;
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnKamera:
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    String fileName = "temp.jpg";
                    ContentValues values = new ContentValues();
                    values.put(MediaStore.Images.Media.TITLE, fileName);
                    mCapturedImageURI = getContentResolver()
                            .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                    values);
                    takePictureIntent
                            .putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI);
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_IMAGE_CAPTURE:
                if (requestCode == REQUEST_IMAGE_CAPTURE &&
                        resultCode == RESULT_OK) {
                    String[] projection = {MediaStore.Images.Media.DATA};
                    Cursor cursor =
                            managedQuery(mCapturedImageURI, projection, null,
                                    null, null);
                    int column_index_data = cursor.getColumnIndexOrThrow(
                            MediaStore.Images.Media.DATA);
                    cursor.moveToFirst();
                    String picturePath = cursor.getString(column_index_data);
                    MyImage image = new MyImage();
                    image.setTitle("Test");
                    image.setDescription(
                            "test take a photo and add it to list view");
                    image.setDatetime(System.currentTimeMillis());
                    image.setPath(picturePath);
                    imageView.setImageURI(Uri.fromFile(new File(picturePath)));
                }
        }
    }
}
