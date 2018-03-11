package com.agateownz.testapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.agateownz.testapplication.R;
import com.agateownz.testapplication.model.Pessoa;

import java.util.List;

/**
 * Created by luisg on 04/03/2018.
 */

public class PessoaAdapter extends ArrayAdapter<Pessoa> {

    private Context context;
    private List<Pessoa> pessoas;

    public PessoaAdapter(@NonNull Context context, @NonNull List<Pessoa> objects) {
        super(context, 0, objects);
        this.context = context;
        this.pessoas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.pessoa_list_item, parent, false);
        }

        Pessoa currentPessoa = pessoas.get(position);

        TextView nome = (TextView)listItem.findViewById(R.id.txt_pessoa_nome);
        nome.setText(currentPessoa.getNome());

        TextView email = (TextView)listItem.findViewById(R.id.txt_pessoa_email);
        email.setText(currentPessoa.getEmail());

        TextView telefone = (TextView)listItem.findViewById(R.id.txt_pessoa_telefone);
        telefone.setText(currentPessoa.getTelefone());

        return listItem;
    }
}
