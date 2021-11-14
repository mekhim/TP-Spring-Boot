package com.servicetp.dao;

import com.servicetp.model.People;

import java.util.List;

public interface IPeopleDAO {

    /**
     * Recupère tous les people
     * @return liste de tous les people
     */
    List<People> findAll();

    /**
     * recupère un people
     * @param id id du people à récupérer
     * @return le people dont l'id est égale au paramètre @id
     */
    People findOneById(int id);

    /**
     * sauvegarde un changement en remplaçant
     * @param people people à sauvegarder
     */
    void save(People people);

    /**
     * ajoute un nouveau people
     * @param people nouveau people à ajouter
     */
    void add(People people);

    /**
     * supprime un people
     * @param id id du people à supprimer
     */
    void delete(int id);

}
