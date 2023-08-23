package veli.asion.solonali;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLeaderBoardItem extends RecyclerView.Adapter<AdapterLeaderBoardItem.ViewHolder>{

    private static ArrayList<ModelofTen> modelofTenArrayList= new ArrayList<>();

    public AdapterLeaderBoardItem(ArrayList<ModelofTen> modelofTenArrayList) {
        this.modelofTenArrayList = modelofTenArrayList;
    }

    @NonNull
    @Override
    public AdapterLeaderBoardItem.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leader_item_layout,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLeaderBoardItem.ViewHolder holder, int position) {
        ModelofTen placeModel = modelofTenArrayList.get(position);
        holder.number.setText(String.valueOf(placeModel.getNumber()));
        holder.nickname.setText(placeModel.getNickname());
        holder.points.setText(String.valueOf(placeModel.getPoints()));
    }

    @Override
    public int getItemCount() {
        return modelofTenArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView number;
        public TextView nickname;
        public TextView points;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            nickname = itemView.findViewById(R.id.nickname);
            points = itemView.findViewById(R.id.points);
    }
}
    }
