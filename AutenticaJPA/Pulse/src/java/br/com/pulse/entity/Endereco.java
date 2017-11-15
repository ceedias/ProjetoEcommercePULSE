/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pulse.entity;

import br.com.pulse.validadores.ValidaCEP;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author cesardias
 */
@Entity
@Table //para nao ter problemas com qualquer outro framework
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    @JoinColumn(referencedColumnName = "id") //Coluna de id no qual referencia o id la da entity user
    @ManyToOne(optional = false) //Varios Enderecos pra uma pessoa
    @Valid
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstadoDoEndereco() {
        return estadoDoEndereco;
    }

    public void setEstadoDoEndereco(String estadoDoEndereco) {
        this.estadoDoEndereco = estadoDoEndereco;
    }


    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
  
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String nick;
  
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String endereco;
  
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String estadoDoEndereco;
   
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String pais;
  
    @NotNull
    @Min(0)
    @NotEmpty
    @Column(nullable = false)
    private int numero;
  
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    @ValidaCEP
    private String cep;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enderecoEntrega")
    private List<Venda> vendas = new LinkedList<Venda>();

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.pulse.entity.Endereco[ id=" + id + " ]";
    }
    
}
