package br.devisis.mvcjpa.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "DOCUMENTOS")
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCUMENTO")
    private Long id;

    @Column(name = "CPF", nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(name = "RG", unique = true)
    private Integer rg;

    public Documento(){
        super();
    }

    public Documento(String cpf, Integer rg){
        this.cpf = cpf;
        this.rg = rg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", rg=" + rg +
                '}';
    }
}
