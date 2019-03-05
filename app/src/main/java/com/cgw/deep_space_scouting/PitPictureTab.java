package com.cgw.deep_space_scouting;

import android.content.DialogInterface;
import android.content.Intent;
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

import java.io.File;
import java.io.IOException;

public class PitPictureTab extends Fragment {

    String team_number = "";
    String currentPhotoPath;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pit_picture_tab, container, false);

        submitPicture(view);

        return view;
    }

    public File createImageFile(View view) throws IOException {
        EditText picture_team_number_box = view.findViewById(R.id.picture_team_number_box);
        team_number = picture_team_number_box.getText().toString();

        String image_file_name = team_number + "_";

        final File path = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        final File picture_file = File.createTempFile(image_file_name, ".jpg", path);

        currentPhotoPath = picture_file.getAbsolutePath();
        return picture_file;
    }

    public void submitPicture(final View view){

        final Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Button submit_pic_btn = view.findViewById(R.id.submit_pic_btn);
        submit_pic_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText picture_team_number_box = view.findViewById(R.id.picture_team_number_box);
                team_number = picture_team_number_box.getText().toString();

                if (team_number.equals("")) {
                    android.support.v7.app.AlertDialog.Builder altDial = new android.support.v7.app.AlertDialog.Builder(getActivity());
                    altDial.setMessage("please enter a team number").setCancelable(false);
                    altDial.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    android.support.v7.app.AlertDialog alert = altDial.create();
                    alert.setTitle("FINAL CHECK");
                    alert.show();

                } else {
                    File photoFile = null;
                    try {
                        photoFile = createImageFile(view);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Uri photoURI = FileProvider.getUriForFile(getContext(), "com.example.android.fileprovider", photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, 1);

                    team_number = "";
                    picture_team_number_box.setText("");
                }
            }
        });

    }
}
