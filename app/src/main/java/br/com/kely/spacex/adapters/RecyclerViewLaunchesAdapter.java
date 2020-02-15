package br.com.kely.spacex.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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

        //verificar se o launches já tem informação se não tiver 
        // adicionamos os novos dados na lista 
        // caso já possua dados na lista, adicionamos os novos dados
        // no final da lista com o método addAll() 
        // e no final notificamos que o adapter foi alterado chamando o método 
        // notifyDataSetChanged()

        if (this.launches.isEmpty()){
            this.launches = launches;
        }else {
            this.launches.addAll(launches);
        }
        notifyDataSetChanged();
    }

    public void clear(){

        this.launches.clear();

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewRecyclerViewFlightNumber;
        private TextView textViewRecyclerViewMissionName;
        private TextView textViewRecyclerViewRocketId;
        private TextView textViewRecyclerViewRocketName;
        private TextView textViewRecyclerViewRocketType;
        private ImageView imageViewMission;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewRecyclerViewFlightNumber = itemView.findViewById(R.id.textViewRecyclerViewFlightNumber);
            textViewRecyclerViewMissionName = itemView.findViewById(R.id.textViewRecyclerViewMissionName);
            textViewRecyclerViewRocketId = itemView.findViewById(R.id.textViewRecyclerViewRocketId);
            textViewRecyclerViewRocketName = itemView.findViewById(R.id.textViewRecyclerViewRocketName);
            textViewRecyclerViewRocketType = itemView.findViewById(R.id.textViewRecyclerViewRocketType);
            imageViewMission = itemView.findViewById(R.id.imageViewMission);
        }

        public void bind(Launch launch) {

            textViewRecyclerViewFlightNumber.setText(launch.getFlightNumber());
            textViewRecyclerViewMissionName.setText(launch.getMissionName());
            textViewRecyclerViewRocketId.setText(launch.getRocket().getRocketId());
            textViewRecyclerViewRocketName.setText(launch.getRocket().getRocketName());
            textViewRecyclerViewRocketType.setText(launch.getRocket().getRocketType());

            if (launch.getLinks().getMissionPatch() != null){
                Picasso.get().setIndicatorsEnabled(true);
                Picasso.get()
                        .load(launch.getLinks().getMissionPatch())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into(imageViewMission);
            }
        }
    }
}
