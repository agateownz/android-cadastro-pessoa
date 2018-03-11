package com.agateownz.testapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.agateownz.testapplication.adapters.PessoaAdapter;
import com.agateownz.testapplication.R;
import com.agateownz.testapplication.data.IPessoaRepository;
import com.agateownz.testapplication.data.PessoaRepository;
import com.agateownz.testapplication.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener {

    private ImageButton btn_adicionar;
    private AutoCompleteTextView txt_pesquisar;
    private ListView listViewPessoas;

    private IPessoaRepository pessoaRepository;
    private PessoaAdapter pessoaAdapter;
    private ArrayAdapter<String> pessoaNomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoaRepository = new PessoaRepository(this);

        btn_adicionar = (ImageButton)findViewById(R.id.btn_adicionar);
        btn_adicionar.setOnClickListener(this);

        txt_pesquisar = (AutoCompleteTextView) findViewById(R.id.txt_pesquisar);
        listViewPessoas = (ListView) findViewById(R.id.listview_pessoas);

        pessoaAdapter = new PessoaAdapter(this, pessoaRepository.getAll());

        // Autocomplete
        pessoaNomeAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,
                pessoaRepository.getAllNames());
        txt_pesquisar.setAdapter(pessoaNomeAdapter);
        txt_pesquisar.setThreshold(1);
        txt_pesquisar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                pessoaAdapter.getFilter().filter(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
//        txt_pesquisar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
//                String pessoaName = (String)adapterView.getItemAtPosition(i);
//                Pessoa pessoa = pessoaRepository.getByName(pessoaName);
//                Intent intent = new Intent(getApplicationContext(), ActivityDetalhesPessoa.class);
//                intent.putExtra("pessoa", pessoa);
//                startActivity(intent);
//            }
//        });

        // List View
        listViewPessoas.setAdapter(pessoaAdapter);
        listViewPessoas.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ActivityCadastroPessoas.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        pessoaAdapter.clear();
        pessoaAdapter.addAll(pessoaRepository.getAll());


        // Autocomplete
        pessoaNomeAdapter.clear();
        pessoaNomeAdapter.addAll(pessoaRepository.getAllNames());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Pessoa pessoa = (Pessoa)adapterView.getItemAtPosition(i);
        Intent intent = new Intent(this, ActivityDetalhesPessoa.class);
        intent.putExtra("pessoa", pessoa);
        startActivity(intent);
    }
}
