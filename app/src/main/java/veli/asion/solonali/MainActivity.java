package veli.asion.solonali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import veli.asion.solonali.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Установка корневого представления активности с использованием связующего класса
        setContentView(binding.getRoot());
        init();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    private void init() {

        AppPreferences appPreferences = new AppPreferences(this);

        binding.scoreEagle.setText("Max score: " + String.valueOf(appPreferences.getMaxEagles()));
        binding.scoreFawn.setText("Max score: " + String.valueOf(appPreferences.getMaxFawn()));
        binding.scoreSquirrel.setText("Max score: " + String.valueOf(appPreferences.getMaxSquirrel()));

        Intent intent = getIntent();
        int animal=0;
        int points=0;
        int place =0;
        if (intent != null) {
            animal = intent.getIntExtra("animal", 3);
            points = intent.getIntExtra("points", 0);
            Log.d("LOL", "Очки из gameview "+String.valueOf(points));
            switch (animal){
                case 0:
                    int[] nums = appPreferences.getAllSquirrels();
                    for (int i: nums
                    ) {
                        Log.d("getAllSquirrels", String.valueOf(i)+" Squirrel");
                    }
                    if (points>=nums[nums.length-1]){
                        place =1;
                        NicknameBottomFragment dialogFragment = new NicknameBottomFragment(animal, place);
                        dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");
                    }else if (points>=nums[nums.length-2]){
                        place =2;
                        NicknameBottomFragment dialogFragment = new NicknameBottomFragment(animal, place);
                        dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");}
                    else if (points>=nums[nums.length-3]){
                        place =3;
                        NicknameBottomFragment dialogFragment = new NicknameBottomFragment(animal, place);
                        dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");}
                    break;
                case 1:
                    int[] nums1 = appPreferences.getAllFawns();
                    for (int i: nums1
                         ) {
                        Log.d("getAllFawns", String.valueOf(i)+" Fawn");
                    }

                    if (points>=nums1[nums1.length-1]){
                        place =1;
                        NicknameBottomFragment dialogFragment = new NicknameBottomFragment(animal, place);
                        dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");
                    }else if (points>=nums1[nums1.length-2]){
                        place =2;
                        NicknameBottomFragment dialogFragment = new NicknameBottomFragment(animal, place);
                        dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");}
                    else if (points>=nums1[nums1.length-3]){
                        place =3;
                        NicknameBottomFragment dialogFragment = new NicknameBottomFragment(animal, place);
                        dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");}
                    break;
                case 2:
                    int[] nums2 = appPreferences.getAllEagles();
                    for (int i: nums2
                    ) {
                        Log.d("getAllEagles", String.valueOf(i)+" Eagles");
                    }
                    if (points>=nums2[nums2.length-1]){
                        place =1;
                        NicknameBottomFragment dialogFragment = new NicknameBottomFragment(animal, place);
                        dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");
                    }else if (points>=nums2[nums2.length-2]){
                        place =2;
                        NicknameBottomFragment dialogFragment = new NicknameBottomFragment(animal, place);
                        dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");}
                    else if (points>=nums2[nums2.length-3]){
                        place =3;
                        NicknameBottomFragment dialogFragment = new NicknameBottomFragment(animal, place);
                        dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");}
                    break;
            }

        }

//

        binding.chooseSquirrel.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, GameActivity.class);
            intent1.putExtra("animal", 0);
            startActivity(intent1);
        });
        binding.chooseFawn.setOnClickListener(view -> {
            Intent intent2 = new Intent(this, GameActivity.class);
            intent2.putExtra("animal", 1);
            startActivity(intent2);
        });
        binding.chooseEagle.setOnClickListener(view -> {
            Intent intent3 = new Intent(this, GameActivity.class);
            intent3.putExtra("animal", 2);
            startActivity(intent3);
        });




        binding.leaderboardSquirrel.setOnClickListener(view -> {
            FullScreenDialogFragment dialogFragment = new FullScreenDialogFragment(0);
            dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");
        });
        binding.leaderboardFawn.setOnClickListener(view -> {
            FullScreenDialogFragment dialogFragment = new FullScreenDialogFragment(1);
            dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");
        });
        binding.leaderboardEagle.setOnClickListener(view -> {
            FullScreenDialogFragment dialogFragment = new FullScreenDialogFragment(2);
            dialogFragment.show(getSupportFragmentManager(), "fullscreen_dialog");
        });
    }
}