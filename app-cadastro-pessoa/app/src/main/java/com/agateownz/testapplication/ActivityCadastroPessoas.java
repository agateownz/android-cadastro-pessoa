package com.agateownz.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.agateownz.testapplication.data.PessoaRepository;
import com.agateownz.testapplication.model.Pessoa;

public class ActivityCadastroPessoas extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtTelefone;
    private EditText txtEndereco;
    private EditText txtObservacoes;
    private EditText txtDataNascimento;

    private Spinner spinnerTelefone;
    private Spinner spinnerEndereco;

    private ArrayAdapter<String> adapterTipoTelefone;
    private ArrayAdapter<String> adapterTipoEndereco;

    private PessoaRepository pessoaRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize Repository
        pessoaRepository = new PessoaRepository(this);

        // Assign view fields
        txtNome = (EditText)findViewById(R.id.txt_nome);
        txtEmail = (EditText)findViewById(R.id.txt_email);
        txtTelefone = (EditText)findViewById(R.id.txt_telefone);
        txtEndereco = (EditText)findViewById(R.id.txt_endereco);
        txtObservacoes = (EditText)findViewById(R.id.txt_observacoes);
        txtDataNascimento = (EditText)findViewById(R.id.txt_data_nasc);

        spinnerTelefone = (Spinner)findViewById(R.id.spinner_telefone);
        spinnerEndereco = (Spinner)findViewById(R.id.spinner_endereco);

        adapterTipoEndereco = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapterTipoEndereco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterTipoTelefone = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapterTipoTelefone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerTelefone.setAdapter(adapterTipoTelefone);
        spinnerEndereco.setAdapter(adapterTipoEndereco);

        adapterTipoTelefone.add("Fixo");
        adapterTipoTelefone.add("Celular");

        adapterTipoEndereco.add("Residencial");
        adapterTipoEndereco.add("Comercial");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.menu_cadastro_pessoas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_salvar:
                pessoaRepository.saveOrUpdate(parsePessoaFromView());
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private Pessoa parsePessoaFromView() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(-1L);
        pessoa.setNome(txtNome.getText().toString());
        pessoa.setEmail(txtEmail.getText().toString());
        pessoa.setEndereco(txtEndereco.getText().toString());
        pessoa.setTelefone(txtTelefone.getText().toString());
        pessoa.setObservacao(txtObservacoes.getText().toString());
        return pessoa;
    }
}
