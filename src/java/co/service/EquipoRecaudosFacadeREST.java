/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.service;

import com.model.EquipoRecaudos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Kevin
 */
@Stateless
@Path("com.model.equiporecaudos")
public class EquipoRecaudosFacadeREST extends AbstractFacade<EquipoRecaudos> {

    @PersistenceContext(unitName = "SALDOPU")
    private EntityManager em;

    public EquipoRecaudosFacadeREST() {
        super(EquipoRecaudos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void create(EquipoRecaudos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, EquipoRecaudos entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public EquipoRecaudos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EquipoRecaudos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EquipoRecaudos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    @POST
    @Path("consulta")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<EquipoRecaudos> consulta(@FormParam("idTipoEquipoRecaudo") int idTipoEquipoRecaudo) {
         List<EquipoRecaudos> retorno=obtenersaldo(idTipoEquipoRecaudo);
         return retorno;
    }
            
    public List<EquipoRecaudos> obtenersaldo(int valor) {
        TypedQuery<EquipoRecaudos> qry;
        qry = getEntityManager().createQuery("SELECT e FROM EquipoRecaudos e WHERE e.idTipoEquipoRecaudo = :idTipoEquipoRecaudo ",EquipoRecaudos.class);
        qry.setParameter("idTipoEquipoRecaudo", valor);
        try {
            return qry.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }        
           
}
