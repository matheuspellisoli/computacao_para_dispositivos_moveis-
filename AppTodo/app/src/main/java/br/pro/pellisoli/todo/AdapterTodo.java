package br.pro.pellisoli.todo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterTodo extends BaseAdapter {

    private List<Task> taskList;
    private Context context;
    private LayoutInflater inflater;

    public AdapterTodo(Context context, List<Task> listaTasks){
        this.taskList = listaTasks;
        this.context = context;
        this.inflater = LayoutInflater.from( context );
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int i) {
        return taskList.get( i );
    }

    @Override
    public long getItemId(int i) {
        return taskList.get(i).id;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ItemSuporte item;

        if( convertView == null){
            convertView = inflater.inflate(R.layout.layout_lista, null);

            item = new ItemSuporte();
            item.tvTitulo = convertView.findViewById(R.id.tvListaTitulo);
            item.tvObs = convertView.findViewById(R.id.tvListaObs);
            item.tvDateTime = convertView.findViewById(R.id.tvListaData);
            item.layout = convertView.findViewById(R.id.llFundoLista);
            convertView.setTag( item );
        }else {
            item = (ItemSuporte) convertView.getTag();
        }

        Task task = taskList.get(i);
        item.tvTitulo.setText(  task.titulo );
        item.tvObs.setText(  task.obs );
        item.tvDateTime.setText(  task.dateTime.toString() );

        if( i % 2 == 0 ){
            item.layout.setBackgroundColor(Color.rgb(230, 230, 230));
        }else {
            item.layout.setBackgroundColor( Color.WHITE );
        }
        return convertView;
    }

    private class ItemSuporte{
        TextView tvTitulo, tvObs, tvDateTime;
        LinearLayout layout;
    }
}
