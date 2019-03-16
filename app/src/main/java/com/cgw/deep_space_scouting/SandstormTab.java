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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SandstormTab extends Fragment {

    public static String [] ss_hab_array = new String[]{"please select", "the robot did not move", "1", "2", "not sure"};

    private static EditText scout_name_box;
    private static EditText match_number_box;
    private static Button set_match_btn;
    private static Spinner sandstorm_hab_spinner;
    private static TextView team_number_box;
    private static TextView ss_hatch_count_box;
    private static TextView ss_cargo_count_box;
    private static View view;

    private static ImageView cs_hatch_image;
    private static ImageView cs_cargo_image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sandstorm_tab, container, false);

        MatchList.createTeamList(); //This method call creates the team list every time.
        sets(view); //This method call sets the HAB spinner and sets the text boxes to the already saved variables so they don't
                    //disappear when the tab changes.
        getSpinnerValues(view);
        enterData(view); //This method enters all the data into the MainActivity.stuff variables.

        return view;
    }

    public void getSpinnerValues(View view){
        sandstorm_hab_spinner = view.findViewById(R.id.sandstorm_hab_spinner);
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

        scout_name_box = view.findViewById(R.id.scout_name_box);
        match_number_box = view.findViewById(R.id.match_number_box);
        team_number_box = view.findViewById(R.id.team_number_box);

        set_match_btn = view.findViewById(R.id.set_match_btn);
        set_match_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //these lines must be inside an onClick method since onCreateView only runs when window is created.
                int match_number_int = Integer.valueOf(match_number_box.getText().toString());
                String match_number_string = String.valueOf(match_number_box.getText().toString());


                if(match_number_int > MatchList.num_matches){
                    team_number_box.setText("match does not exist");
                } else if (match_number_int > 1 && match_number_int < MatchList.num_matches){
                    team_number_box.setText(MatchList.teamArray[Integer.valueOf(match_number_box.getText().toString()) - 1]);
                } else {
                    team_number_box.setText("no match selected");
                }

                MainActivity.scout_name = String.valueOf(scout_name_box.getText().toString());
                MainActivity.match_number = String.valueOf(match_number_box.getText().toString());
                MainActivity.team_number = String.valueOf(MatchList.teamArray[Integer.valueOf(match_number_box.getText().toString()) - 1]);
            }
        });
    }

    public void sets(final View view){

        cs_hatch_image = view.findViewById(R.id.cs_hatch_image);
        cs_hatch_image.setImageResource(R.drawable.hatch_panel);
        cs_cargo_image = view.findViewById(R.id.cs_cargo_image);
        cs_cargo_image.setImageResource(R.drawable.cargo_ball);

        //this sets the HAB spinner
        sandstorm_hab_spinner = view.findViewById(R.id.sandstorm_hab_spinner);
        ArrayAdapter<CharSequence> sandstorm_hab_spinner_adapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, ss_hab_array);
        sandstorm_hab_spinner_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sandstorm_hab_spinner.setAdapter(sandstorm_hab_spinner_adapter);

        scout_name_box = view.findViewById(R.id.scout_name_box);
        scout_name_box.setText(MainActivity.scout_name);

        match_number_box = view.findViewById(R.id.match_number_box);
        match_number_box.setText(MainActivity.scout_name);

        ss_hatch_count_box = view.findViewById(R.id.ss_hatch_count_box);
        ss_hatch_count_box.setText(MainActivity.sandstorm_hatch_count);
        ss_cargo_count_box = view.findViewById(R.id.ss_cargo_count_box);
        ss_cargo_count_box.setText(MainActivity.sandstorm_cargo_count);

    }

    public static void reset(){ //ASK YEH WHY THEY DON'T CHANGE TO THE DEFAULTS!!!! (setSelection(0);)
        match_number_box.setText("");
        team_number_box.setText("");
        ss_hatch_count_box.setText("");
        ss_cargo_count_box.setText("");

        MainActivity.team_number = "";
        MainActivity.sandstorm_hatch_count = "0";
        MainActivity.sandstorm_hatch_counter = 0;
        MainActivity.sandstorm_cargo_count = "0";
        MainActivity.sandstorm_cargo_counter = 0;
    }
}