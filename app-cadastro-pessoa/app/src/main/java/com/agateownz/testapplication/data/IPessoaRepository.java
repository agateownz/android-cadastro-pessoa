package com.agateownz.testapplication.data;

import com.agateownz.testapplication.model.Pessoa;

import java.util.List;

/**
 * Created by luisg on 11/03/2018.
 */

public interface IPessoaRepository extends IRepository<Pessoa, Long> {

    List<String> getAllNames();

    Pessoa getByName(String nome);
}
