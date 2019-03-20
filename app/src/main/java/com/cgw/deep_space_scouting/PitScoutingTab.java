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

public class PitScoutingTab extends Fragment {

    private static String currentPhotoPath;

    private static String[] vision_spinner_array = {"no", "yes"};
    private static String[] rocket_ability_spinner_array = {"no", "yes", "kinda..."};
    private static String[] language_spinner_array = {"Java", "C++", "LabVIEW"};

    private static String team_number = "";
    private static String can_vision = "";
    private static String vision_type = "";
    private static String can_rocket = "";
    private static String language = "";
    private static String drive_train = "";

    private static EditText team_number_box;
    private static Spinner vision_spinner;
    private static EditText vision_type_box;
    private static Spinner rocket_ability_spinner;
    private static Spinner language_spinner;
    private static EditText drive_train_box;

    private static Button no_pic_submit_btn;
    private static Button submit_pic_btn;

    private static EditText debug_window;

    String[] data = new String[6];

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pit_scouting_tab, container, false);

        sets(view);
        getSpinnerValues(view);
        submitPicture(view);
        noPicSubmit(view);

        return view;
    }

    public void sets(View view){
        vision_spinner = view.findViewById(R.id.vision_spinner);
        ArrayAdapter<CharSequence> vision_spinner_adapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, vision_spinner_array);
        vision_spinner_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        vision_spinner.setAdapter(vision_spinner_adapter);

        rocket_ability_spinner = view.findViewById(R.id.rocket_ability_spinner);
        ArrayAdapter<CharSequence> rocket_ability_spinner_adapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, rocket_ability_spinner_array);
        rocket_ability_spinner_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        rocket_ability_spinner.setAdapter(rocket_ability_spinner_adapter);

        language_spinner = view.findViewById(R.id.language_spinner);
        ArrayAdapter<CharSequence> language_spinner_adapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, language_spinner_array);
        language_spinner_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        language_spinner.setAdapter(language_spinner_adapter);
    }

    public File createImageFile(View view) throws IOException {
        team_number_box = view.findViewById(R.id.picture_team_number_box);
        team_number = team_number_box.getText().toString();

        String image_file_name = team_number + "_";

        final File path = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        final File picture_file = File.createTempFile(image_file_name, ".jpg", path);

        currentPhotoPath = picture_file.getAbsolutePath();
        return picture_file;
    }

    public void submitPicture(final View view){

        final Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        submit_pic_btn = view.findViewById(R.id.submit_pic_btn);
        submit_pic_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                team_number_box = view.findViewById(R.id.picture_team_number_box);
                team_number = team_number_box.getText().toString();

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

                    setDataArray();

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

    public void getSpinnerValues(View view) {
        vision_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                can_vision = vision_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rocket_ability_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                can_rocket = rocket_ability_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        language_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                language = language_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void enterData(View view){
//        EditText team_number_box = view.findViewById(R.id.team_number_box);
//        EditText vision_type_box = view.findViewById(R.id.vision_type_box);
//        EditText drive_train_box = view.findViewById(R.id.drive_train_box);
//
//        team_number = String.valueOf(team_number_box.getText().toString());
//        vision_type = String.valueOf(vision_type_box.getText().toString());
//        drive_train = String.valueOf(drive_train_box.getText().toString());
    }

    public void setDataArray(){
        data[0] = team_number;
        data[1] = can_vision;
        data[2] = vision_type;
        data[3] = can_rocket;
        data[4] = language;
        data[5] = drive_train;
    }

    public void writeData() throws IOException {

        final File path = getActivity().getApplicationContext().getExternalFilesDir(null);
        final File file = new File(path, "pit_scouting_data.txt");

        final FileOutputStream output_stream = new FileOutputStream(file, false);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(output_stream));

        for (int i = 0; i < data.length; i++) {
            writer.print(data[i]);
        }
        writer.println();
        writer.flush();
        writer.close();
    }

    public void noPicSubmit(final View view){
        debug_window = view.findViewById(R.id.debug_window);
        no_pic_submit_btn = view.findViewById(R.id.no_pic_submit_btn);
        no_pic_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getData(view);
                debug_window.setText(vision_type_box.getText().toString());
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
                    setDataArray();
                    team_number = String.valueOf(team_number_box.getText().toString());
                    try {
                        writeData();
                        reset(view);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public static void reset(View view){
        team_number_box = view.findViewById(R.id.picture_team_number_box);

        team_number = "";
        can_vision = "";
        vision_type = "";
        can_rocket = "";
        language = "";
        drive_train = "";

        team_number_box.setText("");
        vision_type_box.setText("");
        drive_train_box.setText("");

        vision_spinner.setSelection(0);
        rocket_ability_spinner.setSelection(0);
        language_spinner.setSelection(0);
    }
}
