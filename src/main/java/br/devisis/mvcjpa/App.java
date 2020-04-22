package br.devisis.mvcjpa;

import br.devisis.mvcjpa.dao.PessoaDAO;
import br.devisis.mvcjpa.entity.Documento;
import br.devisis.mvcjpa.entity.Pessoa;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Olá Mundo!");

        //insertPessoa();
        //findPessoaById();
        //findAllPessoas();
        //countPessoas();
        //findByUltimoNome();
        //findByIdade();
        //updatePessoa();
        //deletePessoa();

        inserirDocumento();
    }


    private static void inserirDocumento(){

        Pessoa p1 = new Pessoa();
        p1.setPrimeiroNome("Noah");
        p1.setUltimoNome("Bustamanrte");
        p1.setIdade(28);
        p1.setDocumento(new Documento("123.584.897-99", 48789521));

        new PessoaDAO().save(p1);

        System.out.println(p1.toString());
    }



    private static void deletePessoa(){
        new PessoaDAO().delete(4L);
    }

    private static void updatePessoa(){

        Pessoa p1 = new PessoaDAO().findById(3L);

        System.out.println(p1.toString());

        p1.setUltimoNome("Peralta");

        new PessoaDAO().update(p1);
    }

    private static void findByIdade(){
        List<Pessoa> pessoas = new PessoaDAO().findAgeIsBetween(27, 35);

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
        }

    }

    private static void findByUltimoNome(){
        List<Pessoa> pessoas = new PessoaDAO().findByUltimoNome("Gutemberg");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
        }

    }

    private static void countPessoas() {
        long total = new PessoaDAO().count();

        System.out.println("Total de Pessoas: " + total);
    }

    private static void findAllPessoas() {
        List<Pessoa> pessoas = new PessoaDAO().findall();
        for (Pessoa p : pessoas) {
            System.out.println(p.toString());
        }
    }

    private static void findPessoaById() {
        Pessoa p1 = new PessoaDAO().findById(2L);

        Pessoa p2 = new PessoaDAO().findById(4l);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }

    private static void insertPessoa() {
        Pessoa p1 = new Pessoa();
        p1.setPrimeiroNome("Amy ");
        p1.setUltimoNome("Santiago");
        p1.setIdade(27);

        new PessoaDAO().save(p1);

        System.out.println(p1.toString());

        Pessoa p2 = new Pessoa();
        p2.setPrimeiroNome("Augusto");
        p2.setUltimoNome("Gutemberg");
        p2.setIdade(34);

        new PessoaDAO().save(p2);

        System.out.println(p2.toString());

        Pessoa p3 = new Pessoa();
        p3.setPrimeiroNome("Jacob");
        p3.setUltimoNome("Peralta");
        p3.setIdade(38);

        new PessoaDAO().save(p3);

        System.out.println(p2.toString());

    }
}
