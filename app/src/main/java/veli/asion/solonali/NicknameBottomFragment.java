package veli.asion.solonali;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import veli.asion.solonali.databinding.FragmentNicknameBottomBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;


public class NicknameBottomFragment extends BottomSheetDialogFragment {

    FragmentNicknameBottomBinding binding;
    BottomSheetBehavior bottomSheetBehavior;
    BottomSheetDialog dialog;
    int animal, place;

    public NicknameBottomFragment(int animal, int place){
        this.animal = animal;
        this.place = place;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Здесь вы можете создать и настроить макет вашего BottomSheetDialogFragment
        binding = FragmentNicknameBottomBinding.inflate(inflater, container, false);
        // Настройка взаимодействия с элементами макета
        init();
        return binding.getRoot();
    }


    private void init() {
        binding.okbutton.setOnClickListener(view -> {
            String nickname = binding.editTextTextPersonName.getText().toString();
            NickNamePreferences nickNamePreferences = new NickNamePreferences(Objects.requireNonNull(getContext()));
            switch (animal){
                case 0:
                    switch (place){
                        case 1:

                            nickNamePreferences.setPlace3_squirrel(nickNamePreferences.getPlaces_squirrel()[1]);
                            nickNamePreferences.setPlace2_squirrel(nickNamePreferences.getPlaces_squirrel()[0]);
                            nickNamePreferences.setPlace1_squirrel(nickname);

                            break;
                        case 2:
                            nickNamePreferences.setPlace3_squirrel(nickNamePreferences.getPlaces_squirrel()[1]);
                            nickNamePreferences.setPlace2_squirrel(nickname);
                            break;
                        case 3:
                            nickNamePreferences.setPlace3_squirrel(nickname);
                            break;
                    }
                    break;
                case 1:
                    switch (place){
                        case 1:
                            nickNamePreferences.setPlace3_fawn(nickNamePreferences.getPlaces_fawn()[1]);
                            nickNamePreferences.setPlace2_fawn(nickNamePreferences.getPlaces_fawn()[0]);
                            nickNamePreferences.setPlace1_fawn(nickname);
                            break;
                        case 2:
                            nickNamePreferences.setPlace3_fawn(nickNamePreferences.getPlaces_fawn()[1]);
                            nickNamePreferences.setPlace2_fawn(nickname);
                            break;
                        case 3:
                            nickNamePreferences.setPlace3_fawn(nickname);
                            break;
                    }
                    break;
                case 2:
                    switch (place){
                        case 1:
                            nickNamePreferences.setPlace3_eagle(nickNamePreferences.getPlaces_eagle()[1]);
                            nickNamePreferences.setPlace2_eagle(nickNamePreferences.getPlaces_eagle()[0]);
                            nickNamePreferences.setPlace1_eagle(nickname);
                            break;
                        case 2:
                            nickNamePreferences.setPlace3_eagle(nickNamePreferences.getPlaces_eagle()[1]);
                            nickNamePreferences.setPlace2_eagle(nickname);
                            break;
                        case 3:
                            nickNamePreferences.setPlace3_eagle(nickname);
                            break;
                    }
                    break;
            }
        dismiss();
        });
    }
}