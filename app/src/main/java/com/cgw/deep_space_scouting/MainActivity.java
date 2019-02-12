package com.cgw.deep_space_scouting;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Main Activity";

    public static boolean reset = false;

    //PREEXISTING VARIABLES
    public static String scout_name = "";
    public static String match_number = "0";
    public static String team_number = "0";

    //SANDSTORM VARIABLES
    public static String sandstorm_hab = "0";
    public static String sandstorm_hatch_count = "0";
    public static String sandstorm_cargo_count = "0";
    public static int sandstorm_hatch_counter = 0;
    public static int sandstorm_cargo_counter = 0;

    //TELEOPERATED VARIABLES
        //Cargoship
    public static String cargoship_hatch_count = "0";
    public static int cargoship_hatch_counter = 0;
    public static String cargoship_cargo_count = "0";
    public static int cargoship_cargo_counter = 0;
        //Rocket
    public static String high_rocket_hatch_count = "0";
    public static int high_rocket_hatch_counter = 0;
    public static String high_rocket_cargo_count = "0";
    public static int high_rocket_cargo_counter = 0;
    public static String mid_rocket_hatch_count = "0";
    public static int mid_rocket_hatch_counter = 0;
    public static String mid_rocket_cargo_count = "0";
    public static int mid_rocket_cargo_counter = 0;
    public static String low_rocket_hatch_count = "0";
    public static int low_rocket_hatch_counter = 0;
    public static String low_rocket_cargo_count = "0";
    public static int low_rocket_cargo_counter = 0;
        //HAB
    public static String hab_climb_level = "0";
    public static String hab_climb_speed = "0";

    //OTHER VARIABLES
    public static String overall_speed = "0";
    public static String general_strategy = "0";
    public static String penalites = "";
    public static String final_score;
    public static String breakdown; //this will be a "0" for no breakdown and a "1" for a breakdown
    public static String comments;

    //ARRAY OF ALL VARIABLES LISTED ABOVE
    public static String[] all_data_array = new String[22];
    /*data stored in the following format:

    (match_number, team_number, sandstorm_hab, sandstorm_hatch_count, sandstorm_cargo_count,
    cargoship_hatch_count, cargoship_cargo_count, high_rocket_hatch_count, high_rocket_cargo_count, mid_rocket_hatch_count, mid_rocket_cargo_count,
    low_rocket_hatch_count, low_rocket_cargo_count, hab_climb_level, hab_climb_speed, overall_speed, general_strategy, penalties, final_score
    breakdown, comments)

    */


    private SectionsPageAdapter mSectionsPageAdapter;
    public static ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new CoverTab(), "Cover          ");
        adapter.addFragment(new SandstormTab(), "          Sandstorm          ");
        adapter.addFragment(new TeleopTab(), "          Teleop          ");
        adapter.addFragment(new OtherTab(), "          Other");

        viewPager.setAdapter(adapter);
    }

    //ALL SANDSTORM BUTTON METHODS
    public void ssMinusHatchBtn(View view){
        TextView ss_hatch_box = findViewById(R.id.ss_hatch_count_box);
        if (sandstorm_hatch_counter > 0) {
            sandstorm_hatch_counter --;
            sandstorm_hatch_count = String.valueOf(sandstorm_hatch_counter);
            ss_hatch_box.setText(sandstorm_hatch_count);
        }
    }

    public void ssPlusHatchBtn(View view){
        TextView ss_hatch_box = findViewById(R.id.ss_hatch_count_box);
        sandstorm_hatch_counter ++;
        sandstorm_hatch_count = String.valueOf(sandstorm_hatch_counter);
        ss_hatch_box.setText(sandstorm_hatch_count);
    }

    public void ssMinusCargoBtn(View view){
        TextView ss_cargo_box = findViewById(R.id.ss_cargo_count_box);
        if (sandstorm_cargo_counter > 0) {
            sandstorm_cargo_counter --;
            sandstorm_cargo_count = String.valueOf(sandstorm_cargo_counter);
            ss_cargo_box.setText(sandstorm_cargo_count);
        }
    }

    public void ssPlusCargoBtn(View view){
        TextView ss_cargo_box = findViewById(R.id.ss_cargo_count_box);
        sandstorm_cargo_counter ++;
        sandstorm_cargo_count = String.valueOf(sandstorm_cargo_counter);
        ss_cargo_box.setText(sandstorm_cargo_count);
    }

    //ALL TELEOP BUTTON METHODS
    public void cargoshipMinusHatchBtn(View view){
        TextView teleop_cargoship_hatch_count_box = findViewById(R.id.cargoship_hatch_count_box);
        if(cargoship_hatch_counter > 0){
            cargoship_hatch_counter --;
            cargoship_hatch_count = String.valueOf(cargoship_hatch_counter);
            teleop_cargoship_hatch_count_box.setText(cargoship_hatch_count);
        }
    }

    public void cargoshipPlusHatchBtn(View view){
        TextView teleop_cargoship_hatch_count_box = findViewById(R.id.cargoship_hatch_count_box);
        cargoship_hatch_counter ++;
        cargoship_hatch_count = String.valueOf(cargoship_hatch_counter);
        teleop_cargoship_hatch_count_box.setText(cargoship_hatch_count);
    }

    public void cargoshipMinusCargoBtn(View view){
        TextView teleop_cargoship_cargo_count_box = findViewById(R.id.cargoship_cargo_count_box);
        if(cargoship_cargo_counter > 0){
            cargoship_cargo_counter --;
            cargoship_cargo_count = String.valueOf(cargoship_cargo_counter);
            teleop_cargoship_cargo_count_box.setText(cargoship_cargo_count);
        }
    }

    public void cargoshipPlusCargoBtn(View view){
        TextView teleop_cargoship_cargo_count_box = findViewById(R.id.cargoship_cargo_count_box);
        cargoship_cargo_counter ++;
        cargoship_cargo_count = String.valueOf(cargoship_cargo_counter);
        teleop_cargoship_cargo_count_box.setText(cargoship_cargo_count);
    }

    public void highRocketHatchMinusBtn(View view){
        TextView high_rocket_hatch_count_box = findViewById(R.id.high_rocket_hatch_count_box);
        if(high_rocket_hatch_counter > 0){
            high_rocket_hatch_counter --;
            high_rocket_hatch_count = String.valueOf(high_rocket_hatch_counter);
            high_rocket_hatch_count_box.setText(high_rocket_hatch_count);
        }
    }

    public void highRocketHatchPlusBtn(View view){
        TextView high_rocket_hatch_count_box = findViewById(R.id.high_rocket_hatch_count_box);
        high_rocket_hatch_counter ++;
        high_rocket_hatch_count = String.valueOf(high_rocket_hatch_counter);
        high_rocket_hatch_count_box.setText(high_rocket_hatch_count);
    }

    public void highRocketCargoMinusBtn(View view){
        TextView high_rocket_cargo_count_box = findViewById(R.id.high_rocket_cargo_count_box);
        if(high_rocket_cargo_counter > 0){
            high_rocket_cargo_counter --;
            high_rocket_cargo_count = String.valueOf(high_rocket_cargo_counter);
            high_rocket_cargo_count_box.setText(high_rocket_cargo_count);
        }
    }

    public void highRocketCargoPlusBtn(View view){
        TextView high_rocket_cargo_count_box = findViewById(R.id.high_rocket_cargo_count_box);
        high_rocket_cargo_counter ++;
        high_rocket_cargo_count = String.valueOf(high_rocket_cargo_counter);
        high_rocket_cargo_count_box.setText(high_rocket_cargo_count);
    }

    public void midRocketHatchMinusBtn(View view){
        TextView mid_rocket_hatch_count_box = findViewById(R.id.mid_rocket_hatch_count_box);
        if (mid_rocket_hatch_counter > 0) {
            mid_rocket_hatch_counter --;
            mid_rocket_hatch_count = String.valueOf(mid_rocket_hatch_counter);
            mid_rocket_hatch_count_box.setText(mid_rocket_hatch_count);
        }
    }

    public void midRocketHatchPlusBtn(View view){
        TextView mid_rocket_hatch_count_box = findViewById(R.id.mid_rocket_hatch_count_box);
        mid_rocket_hatch_counter ++;
        mid_rocket_hatch_count = String.valueOf(mid_rocket_hatch_counter);
        mid_rocket_hatch_count_box.setText(mid_rocket_hatch_count);
    }

    public void midRocketCargoMinusBtn(View view){
        TextView mid_rocket_cargo_count_box = findViewById(R.id.mid_rocket_cargo_count_box);
        if(mid_rocket_cargo_counter > 0){
            mid_rocket_cargo_counter --;
            mid_rocket_cargo_count = String.valueOf(mid_rocket_cargo_counter);
            mid_rocket_cargo_count_box.setText(mid_rocket_cargo_count);
        }
    }

    public void midRocketCargoPlusBtn(View view){
        TextView mid_rocket_cargo_count_box = findViewById(R.id.mid_rocket_cargo_count_box);
        mid_rocket_cargo_counter ++;
        mid_rocket_cargo_count = String.valueOf(mid_rocket_cargo_counter);
        mid_rocket_cargo_count_box.setText(mid_rocket_cargo_count);
    }

    public void lowRocketHatchMinusBtn(View view){
        TextView low_rocket_hatch_count_box = findViewById(R.id.low_rocket_hatch_count_box);
        if(low_rocket_hatch_counter > 0){
            low_rocket_hatch_counter --;
            low_rocket_hatch_count = String.valueOf(low_rocket_hatch_counter);
            low_rocket_hatch_count_box.setText(low_rocket_hatch_count);
        }
    }

    public void lowRocketHatchPlusBtn(View view){
        TextView low_rocket_hatch_count_box = findViewById(R.id.low_rocket_hatch_count_box);
        low_rocket_hatch_counter ++;
        low_rocket_hatch_count = String.valueOf(low_rocket_hatch_counter);
        low_rocket_hatch_count_box.setText(low_rocket_hatch_count);
    }

    public void lowRocketCargoMinusBtn(View view){
        TextView low_rocket_cargo_count_box = findViewById(R.id.low_rocket_cargo_count_box);
        if(low_rocket_cargo_counter > 0){
            low_rocket_cargo_counter --;
            low_rocket_cargo_count = String.valueOf(low_rocket_cargo_counter);
            low_rocket_cargo_count_box.setText(low_rocket_cargo_count);
        }
    }

    public void lowRocketCargoPlusBtn(View view){
        TextView low_rocket_cargo_count_box = findViewById(R.id.low_rocket_cargo_count_box);
        low_rocket_cargo_counter ++;
        low_rocket_cargo_count = String.valueOf(low_rocket_cargo_counter);
        low_rocket_cargo_count_box.setText(low_rocket_cargo_count);
    }

    //OTHER METHODS

    public static void enterData(){
        all_data_array[0] = match_number;
        all_data_array[1] = team_number;
        all_data_array[2] = sandstorm_hab;
        all_data_array[3] = sandstorm_hatch_count;
        all_data_array[4] = sandstorm_cargo_count;
        all_data_array[5] = cargoship_hatch_count;
        all_data_array[6] = cargoship_cargo_count;
        all_data_array[7] = high_rocket_hatch_count;
        all_data_array[8] = high_rocket_cargo_count;
        all_data_array[9] = mid_rocket_hatch_count;
        all_data_array[10] = mid_rocket_cargo_count;
        all_data_array[11] = low_rocket_hatch_count;
        all_data_array[12] = low_rocket_cargo_count;
        all_data_array[13] = hab_climb_level;
        all_data_array[14] = hab_climb_speed;
        all_data_array[15] = overall_speed;
        all_data_array[16] = general_strategy;
        all_data_array[17] = penalites;
        all_data_array[18] = final_score;
        all_data_array[19] = breakdown;
        all_data_array[20] = comments;
        all_data_array[21] = scout_name;
    }

}