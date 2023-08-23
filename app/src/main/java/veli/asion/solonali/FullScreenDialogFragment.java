package veli.asion.solonali;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import veli.asion.solonali.databinding.FragmentFullScreenDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Objects;

public class FullScreenDialogFragment extends BottomSheetDialogFragment {

    RecyclerView a_rcView;
    BottomSheetBehavior bottomSheetBehavior;
    BottomSheetDialog dialog;
    FragmentFullScreenDialogBinding binding;
    AdapterLeaderBoardItem adapter;
    private int animal;
    public FullScreenDialogFragment(int animal) {
        this.animal = animal;
        // Пустой конструктор обязателен для BottomSheetDialogFragment
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.FullScreenBottomSheetDialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Здесь вы можете создать и настроить макет вашего BottomSheetDialogFragment
        binding = FragmentFullScreenDialogBinding.inflate(inflater, container, false);
        // Настройка взаимодействия с элементами макета
        init();
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        CoordinatorLayout layout = dialog.findViewById(R.id.bottomSheetLayout);
        assert layout != null;
        layout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        init();
        // Добавьте здесь обработчики событий для кнопок, полей ввода и т. д.
    }

    private void init() {

        a_rcView = binding.aRcView;
        NickNamePreferences nickNamePreferences = new NickNamePreferences(Objects.requireNonNull(getContext()));
        String[] nicks = new String[]{};
        if (animal == 0){
            nicks = nickNamePreferences.getPlaces_squirrel();
        }else if (animal == 1){
            nicks = nickNamePreferences.getPlaces_fawn();
        } else if (animal == 2){
            nicks = nickNamePreferences.getPlaces_eagle();
        }


        AppPreferences appPreferences = new AppPreferences(getContext());
        int[] point = new int[]{};
        if (animal == 0){
            point = appPreferences.getAllSquirrels();
        }else if (animal == 1){
            point = appPreferences.getAllFawns();
        }else if (animal == 2){
            point = appPreferences.getAllEagles();
        }
        ArrayList<ModelofTen> arr = new ArrayList<>();
        for (int i = 0; i < nicks.length; i++) {
            arr.add(new ModelofTen(i+1, nicks[i], point[point.length-1-i]));
        }
//        for (ModelofTen m: arr
//        ) {
//            Log.d("LOL", m.nickname+" =1");
//        }
        for (int i = point.length-4; i >=0 ; i--) {
            arr.add(new ModelofTen(point.length-i, "nickname", point[i]));
        }

        for (ModelofTen m: arr
        ) {
            Log.d("LOL", m.nickname+" "+m.points+" =2");
        }
        adapter = new AdapterLeaderBoardItem(arr);
        a_rcView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        a_rcView.setLayoutManager(layoutManager);
    }

}