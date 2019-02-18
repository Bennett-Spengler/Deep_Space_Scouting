package com.cgw.deep_space_scouting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class PitPictureTab extends Fragment {

    ImageView robot_picture;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pit_picture_tab, container, false);

        robot_picture = view.findViewById(R.id.robot_picture);
        cameraBtn(view);
        submitPicture(view);

        return view;
    }

    public void cameraBtn(View view){
        Button camera_btn = view.findViewById(R.id.camera_btn);
        camera_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        robot_picture.setImageBitmap(bitmap);
    }

    public File createImageFile(View view) throws IOException {
        EditText picture_team_number_box = view.findViewById(R.id.picture_team_number_box);

        final File path = getActivity().getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        final File picture_file = File.createTempFile(picture_team_number_box.getText().toString() + "_", ".png", path);

        return picture_file;
    }

    public void submitPicture(final View view){
        final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Button submit_pic_btn = view.findViewById(R.id.submit_pic_btn);
        submit_pic_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File photoFile = null;
                try {
                    photoFile = createImageFile(view);
                } catch (IOException ex) {

                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(getContext(), "com.zoftino.android.fileprovider", photoFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                    startActivityForResult(intent, REQUEST_PICTURE_CAPTURE);
                }
            }
        });

    }
}
