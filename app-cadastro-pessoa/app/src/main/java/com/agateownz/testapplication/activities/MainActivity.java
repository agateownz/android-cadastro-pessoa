package com.agateownz.testapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.agateownz.testapplication.adapters.PessoaAdapter;
import com.agateownz.testapplication.R;
import com.agateownz.testapplication.data.PessoaRepository;
import com.agateownz.testapplication.model.Pessoa;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener {

    private ImageButton btn_adicionar;
    private EditText txt_pesquisar;
    private ListView listViewPessoas;

    private PessoaRepository pessoaRepository;
    private PessoaAdapter pessoaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoaRepository = new PessoaRepository(this);

        btn_adicionar = (ImageButton)findViewById(R.id.btn_adicionar);
        btn_adicionar.setOnClickListener(this);

        txt_pesquisar = (EditText) findViewById(R.id.txt_pesquisar);
        listViewPessoas = (ListView) findViewById(R.id.listview_pessoas);

        pessoaAdapter = new PessoaAdapter(this, pessoaRepository.getAll());
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
        pessoaAdapter = new PessoaAdapter(this, pessoaRepository.getAll());
        listViewPessoas.setAdapter(pessoaAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Pessoa pessoa = (Pessoa)adapterView.getItemAtPosition(i);
        Intent intent = new Intent(this, ActivityDetalhesPessoa.class);
        intent.putExtra("pessoa", pessoa);
        startActivity(intent);
    }
}
