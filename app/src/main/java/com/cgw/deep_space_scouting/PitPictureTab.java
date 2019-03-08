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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PitPictureTab extends Fragment {

    String team_number = "";
    String currentPhotoPath;
    String[] vision_spinner_string = {"NO", "YES"};
    String can_vision = "NO";
    String vision_type = "";

    Spinner vision_spinner;

    String[] data = new String[3];

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pit_picture_tab, container, false);

        vision_spinner = view.findViewById(R.id.vision_spinner);

        ArrayAdapter<CharSequence> vision_spinner_adapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, vision_spinner_string);
        vision_spinner_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        vision_spinner.setAdapter(vision_spinner_adapter);

        getData(view);
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

                    setData();

                    try {
                        writeData();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    reset(view);

                }

            }
        });
    }

    public void getData(View view) {
        EditText vision_type_box = view.findViewById(R.id.vision_type_box);

        vision_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                can_vision = vision_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vision_type = vision_type_box.getText().toString();
    }

    public void setData(){
        data[0] = team_number;
        data[1] = can_vision;
        data[2] = vision_type;
    }

    public void writeData() throws IOException {

        final File path = getActivity().getApplicationContext().getExternalFilesDir(null);
        final File file = new File(path, "pit_scouting_data.txt");

        final FileOutputStream output_stream = new FileOutputStream(file, false);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(output_stream));

        for (int i = 0; i < data.length; i++) {
            if (i != 2) {
                writer.print(data[i] + ",");
            } else {
                writer.print(data[i]);
            }
        }
        writer.println();
        writer.flush();
        writer.close();
    }

    public void reset(View view){
        EditText picture_team_number_box = view.findViewById(R.id.picture_team_number_box);

        team_number = "";
        can_vision = "";

        picture_team_number_box.setText("");
        vision_spinner.setSelection(0);
    }
}
