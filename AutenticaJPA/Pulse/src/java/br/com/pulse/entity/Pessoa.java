/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pulse.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author cesardias
 */
@Entity
@Table
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    @NotEmpty(message = "Você não pode ficar sem nome! ")
    @Column(nullable = false)
    private String nome;
    
    @NotNull
    @NotEmpty(message = "Você precisa de um usuario para que possa logar! ")
    @Column(nullable = false)
    private String usuario;
    
    @NotNull
    @NotEmpty(message = "Você precisa de uma senha para logar! ")
    @Column(nullable = false)
    private String senha;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<CartaoCredito> cartoescredito = new LinkedList<CartaoCredito>();

 
    
    @NotNull
    @NotEmpty(message = "Precisamos do seu email para realizar um cadastro! ")
    @Email
    @Column(nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Endereco> enderecos = new LinkedList<Endereco>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Venda> vendas = new LinkedList<Venda>();

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
       public List<CartaoCredito> getCartoescredito() {
        return cartoescredito;
    }

    public void setCartoescredito(List<CartaoCredito> cartoescredito) {
        this.cartoescredito = cartoescredito;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.pulse.entity.User[ id=" + id + " ]";
    }
    
}
