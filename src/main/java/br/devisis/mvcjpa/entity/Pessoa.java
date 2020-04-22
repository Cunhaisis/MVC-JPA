package br.devisis.mvcjpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PESSOAS",

  indexes = {@Index(columnList = "PRIMEIRO_NOME, ULTIMO_NOME", name = "IDX_PESSOA_NOME", unique = true)}
)
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column (name = "PRIMEIRO_NOME", nullable = false, length = 30)
    private String primeiroNome;

    @Column(name = "ULTIMO_NOME", nullable = false, length = 60)
    private String ultimoNome;

    @Column(name = "IDADE", nullable = false)
    private Integer idade;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "DOCUMENTO_ID")
    private Documento documento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", idade=" + idade +
                ", documento=" + documento +
                '}';
    }
}

