package com.example.user.list;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SensorDescriptionAdapter extends RecyclerView.Adapter<SensorDescriptionAdapter.ViewHolder> {
    private List<SensorDescription> sensorDescriptionList;
    private LayoutInflater mInflater;
private  Context mContext;

    public SensorDescriptionAdapter(Context context, List<SensorDescription> list) {
        this.mContext=context;
        this.sensorDescriptionList = list;
        this.mInflater = LayoutInflater.from(mContext);

    }



    @Override
    public SensorDescriptionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.adapter_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position=viewHolder.getAdapterPosition();
//                Intent intent=new Intent(mContext,TwoActivity.class);
//                System.out.println(position);
//                intent.putExtra(TwoActivity.SENSORS_ITEM, (Serializable) sensorDescriptionList.get(position));
//                mContext.startActivity(intent);
//
//            }
//        }
//        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, final int positon) {
        final SensorDescription sensor=sensorDescriptionList.get(positon);
        viewHolder.name.setText(sensor.getName());
        viewHolder.type.setText(sensor.getType());
        viewHolder.vendor.setText(sensor.getVendor());
        viewHolder.version.setText(sensor.getVersion());
        viewHolder.max.setText(sensor.getMax());
        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,TwoActivity.class);
                System.out.println(positon);
                intent.putExtra(TwoActivity.SENSORS_ITEM, (Parcelable) sensor);
                mContext.startActivity(intent);
            }
        });
//        viewHolder.resolution.setText(sensor.getResolution());
    }

    @Override
    public int getItemCount() {
        return
                (sensorDescriptionList==null) ? 0 : sensorDescriptionList.size() ;
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView name;
        TextView type;
        TextView vendor;
        TextView version;
        TextView max;
        TextView resolution;
//        private List<Sensor> sensorDescriptionList;
        public ViewHolder( View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            type=(TextView) itemView.findViewById(R.id.type);
            vendor=(TextView)itemView.findViewById(R.id.vendor);
            version=(TextView) itemView.findViewById(R.id.version);
            max=(TextView) itemView.findViewById(R.id.max);

        }

//        @Override
//        public boolean onLongClick(View view) {
//            onLongClickListener(sensorDescriptionList.get(getAdapterPosition()).getID(), getAdapterPosition(),);
//        }


//        public void setSensorList(List<Sensor> sensorList) {
//        this.sensorDescriptionList = new ArrayList<Sensor>();
//        this.sensorDescriptionList.addAll(sensorList);
//        notifyDataSetChanged();
//    }
    }
}

