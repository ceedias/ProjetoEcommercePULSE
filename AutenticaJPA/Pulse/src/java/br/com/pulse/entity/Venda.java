/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pulse.entity;

import br.com.pulse.enums.StatusVenda;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cesardias
 */
@Entity
@Table
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false)
    @NotNull
    private Date data;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private StatusVenda status = StatusVenda.INICIADA;
    
    @NotNull
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Valid
    private Pessoa pessoa;
    
    @NotNull
    @Min(0)
    @Column(nullable = false)
    private BigDecimal valorTotal;
    
    @NotNull
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Valid
    private Endereco enderecoEntrega;
    
    @NotNull
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Valid
    private CartaoCredito cartaoCredito; 

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "venda")
    private List<ItemdeVenda> itensdevenda = new LinkedList<ItemdeVenda>();

    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public StatusVenda getStatus() {
        return status;
    }

    public void setStatus(StatusVenda status) {
        this.status = status;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public List<ItemdeVenda> getItensdevenda() {
        return itensdevenda;
    }

    public void setItensdevenda(List<ItemdeVenda> itensdevenda) {
        this.itensdevenda = itensdevenda;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.pulse.entity.Venda[ id=" + id + " ]";
    }
    
}
