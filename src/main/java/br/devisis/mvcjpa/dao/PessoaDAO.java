package br.devisis.mvcjpa.dao;

import br.devisis.mvcjpa.entity.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PessoaDAO extends GenericDAO<Pessoa>{

    public PessoaDAO(){
        super(Pessoa.class);
    }

    public List<Pessoa> findByUltimoNome(String ultimoNome){

        String jpql = ("SELECT p FROM Pessoa p where p.ultimoNome = 'Peralta'");

        return find(jpql);

    }
       public List<Pessoa> findAgeIsBetween(int min, int max){

        String jpql = "SELECT p From Pessoa p where p.idade between 27 and 34 ";


        return find(jpql);
       }
}
