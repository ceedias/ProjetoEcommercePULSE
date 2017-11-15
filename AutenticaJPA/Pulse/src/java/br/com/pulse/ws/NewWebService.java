/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pulse.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.registry.infomodel.User;

/**
 *
 * @author cesardias
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {
    @PersistenceContext
    private EntityManager em;
  
    public User ping() {
        return em.find(User.class, 1);
    }
}
