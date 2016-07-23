package usuario.app.agenda;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import usuario.app.agenda.model.Contatos;

public class ContatosAdapter extends BaseAdapter {

    Bundle params = new Bundle();
    List<Contatos> contatos ;
    public ContatosAdapter(List<Contatos> lista){
        this.contatos = lista;
    }


    @Override
    public int getCount() {
        return contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            Context context = parent.getContext();
            LinearLayout view = new LinearLayout(context);
            view.setOrientation(LinearLayout.HORIZONTAL);

            CheckBox chk = new CheckBox(context);
            chk.setClickable(true);

            chk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 //params.putInt("idContato",contatos.get(position).getId());
                 Contatos.idPassado = contatos.get(position).getId() ;
                }
            });
            view.addView(chk);

            TextView nameTextView = new TextView(context);
            nameTextView.setText(contatos.get(position).getNome());
            nameTextView.setPadding(0, 0, 10, 0);
            view.addView(nameTextView);
            TextView parTextView = new TextView(context);
            parTextView.setText(contatos.get(position).getFone());
            view.addView(parTextView);

            return view;
        }
        return convertView;
    }

}

