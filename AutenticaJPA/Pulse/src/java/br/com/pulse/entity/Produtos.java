/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pulse.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author cesardias
 */
@Entity
@Table
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    @NotEmpty
    @Column(unique = true, nullable = false)
    private String nome;
   
     @NotNull
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Categoria categoria;
     
     @NotNull
     @Column(nullable = false)
    private BigDecimal custo;
     
     @NotNull
     @NotEmpty
     @Column(nullable = false)
    private String descricao;

     @Min(0)
     @Column(nullable = false)
     @NotNull
     private int estoque;
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtos")
     private List<ItemdeVenda> itensdeVendas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public List<ItemdeVenda> getItensdeVendas() {
        return itensdeVendas;
    }

    public void setItensdeVendas(List<ItemdeVenda> itensdeVendas) {
        this.itensdeVendas = itensdeVendas;
    }
    

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
     
     
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.pulse.entity.Produtos[ id=" + id + " ]";
    }
    
}
