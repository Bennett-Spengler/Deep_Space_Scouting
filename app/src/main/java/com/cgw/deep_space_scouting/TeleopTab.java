package com.cgw.deep_space_scouting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class TeleopTab extends Fragment {

    public static final String[] hab_level_array = {"please select", "the robot did not climb", "1", "2", "3", "not sure"};

    public static Spinner hab_level_spinner;
    private static TextView cargoship_hatch_count_box;
    private static TextView cargoship_cargo_count_box;
    private static TextView high_rocket_hatch_count_box;
    private static TextView high_rocket_cargo_count_box;
    private static TextView mid_rocket_hatch_count_box;
    private static TextView mid_rocket_cargo_count_box;
    private static TextView low_rocket_hatch_count_box;
    private static TextView low_rocket_cargo_count_box;

    private static View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.teleop_tab, container, false);

        sets(view);
        getSpinnerValues(view);
        enterData(view);

        return view;
    }

    public void getSpinnerValues(View view){
        hab_level_spinner = view.findViewById(R.id.hab_level_spinner);

        hab_level_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(hab_level_spinner.getSelectedItem().toString().equals("the robot did not climb") || hab_level_spinner.getSelectedItem().toString().equals("not sure")){
                    MainActivity.hab_climb_level = "0";
                } else {
                    MainActivity.hab_climb_level = hab_level_spinner.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void enterData(View view){
    }

    public void sets(View view){

        hab_level_spinner = view.findViewById(R.id.hab_level_spinner);
        ArrayAdapter<CharSequence> hab_level_spinner_adapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, hab_level_array);
        hab_level_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hab_level_spinner.setAdapter(hab_level_spinner_adapter); //maybe try putting these functions in the setMatch button thing instead of running it during every create...

        cargoship_hatch_count_box = view.findViewById(R.id.cargoship_hatch_count_box);
        cargoship_hatch_count_box.setText(MainActivity.cargoship_hatch_count);

        cargoship_cargo_count_box = view.findViewById(R.id.cargoship_cargo_count_box);
        cargoship_cargo_count_box.setText(MainActivity.cargoship_cargo_count);

        high_rocket_hatch_count_box = view.findViewById(R.id.high_rocket_hatch_count_box);
        high_rocket_hatch_count_box.setText(MainActivity.high_rocket_hatch_count);

        high_rocket_cargo_count_box = view.findViewById(R.id.high_rocket_cargo_count_box);
        high_rocket_cargo_count_box.setText(MainActivity.high_rocket_cargo_count);

        mid_rocket_hatch_count_box = view.findViewById(R.id.mid_rocket_hatch_count_box);
        mid_rocket_hatch_count_box.setText(MainActivity.mid_rocket_hatch_count);

        mid_rocket_cargo_count_box = view.findViewById(R.id.mid_rocket_cargo_count_box);
        mid_rocket_cargo_count_box.setText(MainActivity.mid_rocket_cargo_count);

        low_rocket_hatch_count_box = view.findViewById(R.id.low_rocket_hatch_count_box);
        low_rocket_hatch_count_box.setText(MainActivity.low_rocket_hatch_count);

        low_rocket_cargo_count_box = view.findViewById(R.id.low_rocket_cargo_count_box);
        low_rocket_cargo_count_box.setText(MainActivity.low_rocket_cargo_count);
    }

    public static void reset(){
        cargoship_hatch_count_box.setText("");
        cargoship_cargo_count_box.setText("");
        high_rocket_hatch_count_box.setText("");
        high_rocket_cargo_count_box.setText("");
        mid_rocket_hatch_count_box.setText("");
        mid_rocket_cargo_count_box.setText("");
        low_rocket_hatch_count_box.setText("");
        low_rocket_cargo_count_box.setText("");

        MainActivity.cargoship_hatch_count = "0";
        MainActivity.cargoship_hatch_counter = 0;
        MainActivity.cargoship_cargo_count = "0";
        MainActivity.cargoship_cargo_counter = 0;

        MainActivity.high_rocket_hatch_count = "0";
        MainActivity.high_rocket_hatch_counter = 0;
        MainActivity.high_rocket_cargo_count = "0";
        MainActivity.high_rocket_cargo_counter = 0;
        MainActivity.mid_rocket_hatch_count = "0";
        MainActivity.mid_rocket_hatch_counter = 0;
        MainActivity.mid_rocket_cargo_count = "0";
        MainActivity.mid_rocket_cargo_counter = 0;
        MainActivity.low_rocket_hatch_count = "0";
        MainActivity.low_rocket_hatch_counter = 0;
        MainActivity.low_rocket_cargo_count = "0";
        MainActivity.low_rocket_cargo_counter = 0;

        MainActivity.penalties = "0";
    }
}
