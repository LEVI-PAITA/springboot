/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.repository.custom.impl;

import com.vasslatam.sakila.domain.Actor;
import com.vasslatam.sakila.domain.Actor_;
import com.vasslatam.sakila.domain.Film;
import com.vasslatam.sakila.domain.FilmActor;
import com.vasslatam.sakila.domain.FilmActor_;
import com.vasslatam.sakila.domain.Film_;
import com.vasslatam.sakila.domain.Inventory;
import com.vasslatam.sakila.domain.Inventory_;
import com.vasslatam.sakila.domain.Store_;
import com.vasslatam.sakila.repository.custom.FilmRepositoryCustom;
import com.vasslatam.sakila.type.Rating;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;



/**
 *
 * @author USERVASSPERU
 */
public class FilmRepositoryCustomImpl implements FilmRepositoryCustom{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Film> findByActorName(String actorName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<FilmActor> filmActor = cq.from(FilmActor.class);
        String nameWildcard = '%' + actorName.replace(' ', '%') + '%';
        cq.select(filmActor.get(FilmActor_.film))
                .where(
                        cb.or(
                                cb.like(filmActor.get(FilmActor_.actor).get(Actor_.firstName), nameWildcard),
                                cb.like(filmActor.get(FilmActor_.actor).get(Actor_.lastName), nameWildcard)
                        )
                );
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<Film> findByStoreId(int storeId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Inventory> inventory = cq.from(Inventory.class);
        cq.select(inventory.get(Inventory_.film))
                .distinct(true)
                .where(
                        cb.equal(inventory.get(Inventory_.store).get(Store_.storeId), storeId)
                );
        TypedQuery<Film> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Film> findByFilm(String actor, String description, String title, Rating rating) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<FilmActor> filmactor = cq.from(FilmActor.class);
        
        Join<FilmActor, Actor> ac = filmactor.join(FilmActor_.ACTOR);
        Join<FilmActor, Film> f = filmactor.join(FilmActor_.FILM);
        
        String actorWildcard = '%' + actor.replace(' ', '%') + '%';
        String descripWildcard = '%' + description.replace(' ', '%') + '%';
        String titleWildcard = '%' + title.replace(' ', '%') + '%';
        
        cq.select(filmactor.get(FilmActor_.FILM))
                .where(
                        cb.like(ac.get(Actor_.FIRST_NAME),actorWildcard),
                        cb.and(cb.like(f.get(Film_.DESCRIPTION), descripWildcard)),
                        cb.and(cb.like(f.get(Film_.TITLE),titleWildcard)),
                        cb.and(cb.equal(f.get(Film_.RATING), rating))
                );
        
        TypedQuery<Film> query = em.createQuery(cq);
        return query.getResultList();
    }
    

    
}
