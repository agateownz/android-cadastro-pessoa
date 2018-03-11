package com.agateownz.testapplication.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.agateownz.testapplication.R;
import com.agateownz.testapplication.data.PessoaRepository;
import com.agateownz.testapplication.model.Pessoa;

import java.text.DateFormat;
import java.util.Calendar;

public class ActivityDetalhesPessoa extends AppCompatActivity implements Dialog.OnClickListener {

    private Pessoa pessoa;
    private PessoaRepository pessoaRepository;

    private TextView txtNome;
    private TextView txtEmail;
    private TextView txtTelefone;
    private TextView txtEndereco;
    private TextView txtObservacoes;
    private TextView txtDataNascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pessoa);

        pessoaRepository = new PessoaRepository(this);
        pessoa = (Pessoa)getIntent().getSerializableExtra("pessoa");

        txtNome = (TextView)findViewById(R.id.lbl_pessoa_nome);
        txtEmail = (TextView)findViewById(R.id.lbl_pessoa_email);
        txtTelefone = (TextView)findViewById(R.id.lbl_pessoa_telefone);
        txtEndereco = (TextView)findViewById(R.id.lbl_pessoa_endereco);
        txtObservacoes = (TextView)findViewById(R.id.lbl_pessoa_observacoes);
        txtDataNascimento = (TextView)findViewById(R.id.lbl_pessoa_data_nasc);

        txtNome.setText(pessoa.getNome());
        txtEmail.setText(pessoa.getEmail());
        txtTelefone.setText(pessoa.getTelefone());
        txtEndereco.setText(pessoa.getEndereco());
        txtObservacoes.setText(pessoa.getObservacao());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(pessoa.getDataNascimento());
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        txtDataNascimento.setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.menu_detalhes_pessoa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_excluir:
                mostrarConfirmacaoExcluirPessoa();
                return true;

            case R.id.menu_alterar:
                irParaEdicaoPessoa();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mostrarConfirmacaoExcluirPessoa() {
        new AlertDialog.Builder(this)
                .setMessage("Deseja realmente excluir?")
                .setCancelable(false)
                .setPositiveButton("Sim", this)
                .setNegativeButton("Não", null)
                .show();
    }
    private void irParaEdicaoPessoa() {
        Intent intent = new Intent(this, ActivityCadastroPessoas.class);
        intent.putExtra("pessoa", pessoa);
        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        pessoaRepository.delete(pessoa);
        finish();
        Toast.makeText(this, "Usuário excluído com sucesso.", Toast.LENGTH_SHORT).show();
    }
}
