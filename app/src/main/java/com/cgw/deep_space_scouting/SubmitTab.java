package com.cgw.deep_space_scouting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SubmitTab extends Fragment {

    public static final String[] overall_speed_array = {"please select", "1", "2", "3"};
    public static final String[] general_strategy_array = {"please select", "rocket and hatches", "rocket and cargo", "cargoship and hatches", "cargoship and cargo", "defense"};
    public static final String[] penalties_array = {"please select", "yellow card", "red card", "not sure"};

    Spinner overall_speed_spinner;
    Spinner general_strategy_spinner;
    Spinner penalties_spinner;
    Spinner sandstorm_hab_spinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.other_tab, container, false);

        sets(view);
        getSpinnerValues(view);
        submitBtn(view);
        deleteFile(view);

        return view;
    }

    public void getSpinnerValues(View view) {
        overall_speed_spinner = view.findViewById(R.id.overall_speed_spinner);
        general_strategy_spinner = view.findViewById(R.id.general_strategy_spinner);
        penalties_spinner = view.findViewById(R.id.penalties_spinner);

        overall_speed_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.overall_speed = overall_speed_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        general_strategy_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.general_strategy = general_strategy_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        penalties_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.penalties = penalties_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void submitBtn(final View view) {
        Button submit_btn = view.findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enterData(view); // this method call must me inside a button click since it cannot be run with onCreate;
                // it also must run before MainActivity.setDataArray() for obvious reasons
                MainActivity.setDataArray();

                android.support.v7.app.AlertDialog.Builder altDial = new android.support.v7.app.AlertDialog.Builder(getActivity());
                altDial.setMessage("Are you sure you want to submit this match's data?").setCancelable(false);
                altDial.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finalSubmit(view);
                    }
                });
                altDial.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                android.support.v7.app.AlertDialog alert = altDial.create();
                alert.setTitle("FINAL SUBMIT");
                alert.show();
            }
        });
    }

    public void writeData() throws FileNotFoundException {

        final File path = getActivity().getApplicationContext().getExternalFilesDir(null);
        final File file = new File(path, "data.txt");

        final FileOutputStream output_stream = new FileOutputStream(file, true);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(output_stream));

        for (int i = 0; i < MainActivity.all_data_array.length; i++) {
            if (i != 21) {
                writer.print(MainActivity.all_data_array[i] + ",");
            } else {
                writer.print(MainActivity.all_data_array[i]);
            }
        }
        writer.println();
        writer.flush();
        writer.close();

    }

    public void enterData(View view) {
        EditText final_score_box = view.findViewById(R.id.final_score_box);
        CheckBox break_down_checkbox = view.findViewById(R.id.break_down_checkbox);
        EditText comments_box = view.findViewById(R.id.comments_box);

        MainActivity.final_score = String.valueOf(final_score_box.getText().toString());

        if (break_down_checkbox.isChecked()) {
            MainActivity.breakdown = "1";
        } else {
            MainActivity.breakdown = "0";
        }

        MainActivity.comments = String.valueOf(comments_box.getText().toString());
    }

    public void sets(View view) {

        overall_speed_spinner = view.findViewById(R.id.overall_speed_spinner);
        general_strategy_spinner = view.findViewById(R.id.general_strategy_spinner);
        penalties_spinner = view.findViewById(R.id.penalties_spinner);

        ArrayAdapter<CharSequence> overall_speed_spinner_adapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, overall_speed_array);
        overall_speed_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        overall_speed_spinner.setAdapter(overall_speed_spinner_adapter);

        ArrayAdapter<CharSequence> general_strategy_spinner_adapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, general_strategy_array);
        general_strategy_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        general_strategy_spinner.setAdapter(general_strategy_spinner_adapter);

        ArrayAdapter<CharSequence> penalties_spinner_adapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, penalties_array);
        penalties_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        penalties_spinner.setAdapter(penalties_spinner_adapter);
    }

    public void reset(View view) {

        overall_speed_spinner.setSelection(0);
        general_strategy_spinner.setSelection(0);
        penalties_spinner.setSelection(0);

        EditText final_score_box = view.findViewById(R.id.final_score_box);
        final_score_box.setText("");
        MainActivity.final_score = "";

        CheckBox breakdown_box = view.findViewById(R.id.break_down_checkbox);
        breakdown_box.setChecked(false);

        EditText comments_box = view.findViewById(R.id.comments_box);
        comments_box.setText("");
        MainActivity.comments = "";

    }

    public void finalSubmit(View view) { //this method also checks the data to see if all fields have been filled

        int numEmpty = 0;
        for (int i = 0; i < MainActivity.all_data_array.length; i ++){
            if (MainActivity.all_data_array[i].equals("") || MainActivity.all_data_array[i].equals("please select")){
                numEmpty ++;
            }
        }

        if(numEmpty > 0) {
            android.support.v7.app.AlertDialog.Builder altDial = new android.support.v7.app.AlertDialog.Builder(getActivity());
            altDial.setMessage("It seems like you haven't filled out all fields... " +
                    "Please fill out any empty fields OR fields left labeled 'please select'." +
                    " Make sure you also click 'set match' again if you make any changes!").setCancelable(false);
            altDial.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            android.support.v7.app.AlertDialog alert = altDial.create();
            alert.setTitle("FINAL CHECK");
            alert.show();
        } else {
            try {
                writeData();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            reset(view);
            SandstormTab.reset();
            TeleopTab.reset();

            MainActivity.mViewPager.setCurrentItem(0);
        }
    }

    public void deleteFile(View view){

        final File path = getActivity().getApplicationContext().getExternalFilesDir(null);
        final File file = new File(path, "data.txt");

        Button delete_file_btn = view.findViewById(R.id.delete_file_btn);
        delete_file_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v7.app.AlertDialog.Builder altDial = new android.support.v7.app.AlertDialog.Builder(getActivity());
                altDial.setMessage("Are you sure you want to delete this file?").setCancelable(false);
                altDial.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        file.delete();
                        MainActivity.mViewPager.setCurrentItem(0);
                    }
                });
                altDial.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                android.support.v7.app.AlertDialog alert = altDial.create();
                alert.setTitle("DELETE FILE");
                alert.show();
            }
        });
    }
}