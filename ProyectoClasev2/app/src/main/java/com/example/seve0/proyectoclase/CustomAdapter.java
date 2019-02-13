package com.example.seve0.proyectoclase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter para la lista de entradas de la base de datos asociada al layout lv_item.xml
 */
public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ModeloUsuario> userModelArrayList;

    public CustomAdapter(Context context, ArrayList<ModeloUsuario> userModelArrayList) {
        this.context = context;
        this.userModelArrayList = userModelArrayList;
    }


    @Override
    public int getCount() {
        return userModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);

            holder.tvnombre = (TextView) convertView.findViewById(R.id.name);
            holder.tvmusica = (TextView) convertView.findViewById(R.id.musica);
            holder.tvciudad = (TextView) convertView.findViewById(R.id.city);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvnombre.setText("Nombre: "+userModelArrayList.get(position).getName());
        holder.tvmusica.setText("Género Musical Favorito: "+userModelArrayList.get(position).getMusica());
        holder.tvciudad.setText("Ciudad: "+userModelArrayList.get(position).getCity());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvnombre, tvmusica, tvciudad;
    }
}
