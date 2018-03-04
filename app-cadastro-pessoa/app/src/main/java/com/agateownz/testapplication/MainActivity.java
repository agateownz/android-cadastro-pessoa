package com.agateownz.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.agateownz.testapplication.data.PessoaRepository;
import com.agateownz.testapplication.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
}
