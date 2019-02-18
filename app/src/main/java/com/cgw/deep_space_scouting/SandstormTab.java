package com.cgw.deep_space_scouting;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
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

    public static final String [] ss_hab_array = {"HAB Level", "the robot did not move", "1", "2"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sandstorm_tab, container, false);

        sets(view);
        getSpinnerValues(view);
        enterData(view);
        resetSpinner(view);

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
       sandstorm_hab_spinner.setSelection(0);
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

        ArrayAdapter team_number_spinner_adapter;

        if(match_number.equals("")){
            team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[101]);
            team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
            team_number_spinner.setAdapter(team_number_spinner_adapter);
        } else if(Integer.valueOf(match_number) > MatchList.num_matches){
            team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[101]);
            team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
            team_number_spinner.setAdapter(team_number_spinner_adapter);
        }

        switch (match_number){
            case "1":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "2":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "3":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "4":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "5":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "7":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "8":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "9":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "10":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "11":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "12":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "13":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "14":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "15":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "16":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "17":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "18":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "19":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "20":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "21":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "22":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "23":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "24":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "25":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "26":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "27":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "28":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "29":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "30":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "31":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "32":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "33":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "34":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "35":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "36":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "37":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "38":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "39":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "40":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "41":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "42":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "43":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "44":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "45":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "46":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "47":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "48":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "49":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "50":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "51":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "52":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "53":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "54":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "55":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "56":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "57":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "58":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "59":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "60":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "61":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "62":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "63":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "64":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "65":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "66":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "67":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "68":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "69":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "70":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "71":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "72":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "73":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "74":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "75":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "76":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "77":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "78":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "79":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "80":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "81":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "82":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "83":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "84":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "85":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "86":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "87":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "88":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "89":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "90":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "91":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "92":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "93":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "94":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "95":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "96":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "97":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "98":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "99":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
            case "100":
                team_number_spinner_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, MatchList.teamArray[Integer.valueOf(match_number) - 1]);
                team_number_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                team_number_spinner.setAdapter(team_number_spinner_adapter);
                break;
        }
    }

    public void sets(final View view){

        //this sets the HAB spinner
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

    public void resetSpinner(View view){
        Spinner sandstorm_hab_spinner = view.findViewById(R.id.sandstorm_hab_spinner);
        sandstorm_hab_spinner.setSelection(0);
    }

}