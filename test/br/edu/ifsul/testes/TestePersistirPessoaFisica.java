/*
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Telefone;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vini
 */
public class TestePersistirPessoaFisica {
    EntityManager em;
    public TestePersistirPessoaFisica() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    @Test
    public void teste(){
        Boolean exeption = false;
        try {
            PessoaFisica pf = new PessoaFisica();
            
            em.getTransaction().begin();
            pf.setCidade(em.find(Cidade.class, 1));
            pf.setCpf("02513464044");
            pf.setEmail("vinicius@metasig.com.br");
            pf.setEndereco("Bento Gonçalves");
            pf.setRg("231124124");
            
            pf.setNascimento(new GregorianCalendar(1990, Calendar.JANUARY, 23));
            pf.setNome("VInicius");
            pf.setSobrenome("Maciel"); 
            pf.setSexo("M");
            
            
            em.persist(pf);
            em.getTransaction().commit();
            
            
        } catch (Exception e) {
             exeption = true;
            e.printStackTrace();
        }
        
        
        Assert.assertEquals(false, exeption);
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
}
