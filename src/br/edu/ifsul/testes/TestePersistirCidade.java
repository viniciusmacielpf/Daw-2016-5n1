/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vini
 */
public class TestePersistirCidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Estado e = em.find(Estado.class, 1);
        
        
        
        Cidade c = new Cidade();
        
        
        c.setNome("Passo Fundo");
        c.setEstado(e);
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
