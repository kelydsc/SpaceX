package br.com.kely.spacex.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.kely.spacex.R;
import br.com.kely.spacex.interfaces.RecyclerViewLaunchClickListener;
import br.com.kely.spacex.model.api.Launch;

public class RecyclerViewLaunchesAdapter extends RecyclerView.Adapter<RecyclerViewLaunchesAdapter.ViewHolder> {

    private List<Launch> launches;
    private RecyclerViewLaunchClickListener listener;

    public RecyclerViewLaunchesAdapter(List<Launch> launches, RecyclerViewLaunchClickListener listener) {
        this.launches = launches;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_launch_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Launch launch = launches.get(position);

        holder.bind(launch);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(launch);
            }
        });

    }

    @Override
    public int getItemCount() {
        return launches.size();
    }

    //Método para atualizar o item
    public void updateLaunch(List<Launch> launches) {
        this.launches = launches;

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewRecyclerViewFlightNumber;
        private TextView textViewRecyclerViewMissionName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewRecyclerViewFlightNumber = itemView.findViewById(R.id.textViewRecyclerViewFlightNumber);
            textViewRecyclerViewMissionName = itemView.findViewById(R.id.textViewRecyclerViewMissionName);
        }

        public void bind(Launch launch) {

            textViewRecyclerViewFlightNumber.setText(launch.getFlightNumber());
            textViewRecyclerViewMissionName.setText(launch.getMissionName());
        }
    }
}
