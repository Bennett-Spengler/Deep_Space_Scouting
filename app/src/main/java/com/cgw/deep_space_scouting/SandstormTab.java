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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SandstormTab extends Fragment {
    public static final String TAG = "Sandstorm";

    public static final String [] ss_hab_array = {"HAB Level", "the robot did not move", "1", "2"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sandstorm_tab, container, false);



        getSpinnerValues(view);

        sets(view);

        enterData(view);

        return view;
    }

    public void getSpinnerValues(View view){
        final Spinner team_number_spinner = view.findViewById(R.id.team_number_spinner);
        final Spinner sandstorm_hab_spinner = view.findViewById(R.id.sandstorm_hab_spinner);

        team_number_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.team_number = team_number_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sandstorm_hab_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.sandstorm_hab = sandstorm_hab_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void enterData(final View view){
        Button set_match_btn = view.findViewById(R.id.set_match_btn);
        set_match_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setTeamSpinners(view); //this has to be in this method since only one onClick method can exist

                //these lines must be inside an onClick method since onCreateView only runs when window is created.
                EditText scout_name_box = view.findViewById(R.id.scout_name_box);
                EditText match_number_box = view.findViewById(R.id.match_number_box);

                MainActivity.scout_name = String.valueOf(scout_name_box.getText().toString());
                MainActivity.match_number = String.valueOf(match_number_box.getText().toString());
            }
        });
    }

    public void setTeamSpinners(View view){
        EditText match_number_box = view.findViewById(R.id.match_number_box);
        String match_number = String.valueOf(match_number_box.getText());
        Spinner team_number_spinner = view.findViewById(R.id.team_number_spinner);

        ArrayAdapter<String> team_number_spinner_adapter;

        switch (match_number){
            case "1":
                team_number_spinner_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[0]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "2":
                team_number_spinner_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "3":
                team_number_spinner_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[2]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "4":
                team_number_spinner_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[3]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "5":
                team_number_spinner_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[4]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "6":
                team_number_spinner_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[5]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
        }
    }

    public void sets(final View view){

        Spinner sandstorm_hab_spinner = view.findViewById(R.id.sandstorm_hab_spinner);

        ArrayAdapter<CharSequence> sandstorm_hab_spinner_adapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, ss_hab_array);
        sandstorm_hab_spinner_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sandstorm_hab_spinner.setAdapter(sandstorm_hab_spinner_adapter);

        EditText scout_name_box = view.findViewById(R.id.scout_name_box);
        scout_name_box.setText(MainActivity.scout_name);

        TextView match_number_box = view.findViewById(R.id.match_number_box);
        match_number_box.setText(MainActivity.scout_name);

        TextView ss_hatch_count_box = view.findViewById(R.id.ss_hatch_count_box);
        ss_hatch_count_box.setText(MainActivity.sandstorm_hatch_count);
        TextView ss_cargo_count_box = view.findViewById(R.id.ss_cargo_count_box);
        ss_cargo_count_box.setText(MainActivity.sandstorm_cargo_count);

    }

    public static void reset(){
        MainActivity.team_number = "";
        MainActivity.sandstorm_hatch_count = "0";
        MainActivity.sandstorm_hatch_counter = 0;
        MainActivity.sandstorm_cargo_count = "0";
        MainActivity.sandstorm_cargo_counter = 0;
    }
}