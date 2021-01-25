/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Project;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.ProjectRepository;
import tn.esprit.spring.service.interfaces.IClientInfoService;

/**
 * 
 * Cette classe permet de gérer les informations client.
 * 
 * @author Walid YAICH
 *
 */
@Component
public class ClientInfoMySQLServiceImpl implements IClientInfoService{
	
	//TODO Injection des différents repository
	
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ProjectRepository projectRepository;
	/**
	 * Récupérer les titres des projets en ayant l'id du client
	 * @param clientId l'identifiant du client
	 * @return les titres des projets 
	 * 
	 */
	@Override
	public String getProjectsTitlesByClientId(Long clientId){
		return null; //TODO
	}
	
	
	/**
	 * Récupérer le prénom du client en ayant son Id
	 * @param clientId l'identifiant du client
	 * @return le prénom du client
	 */
	@Override
	public String getFirstNameByClientId(Long clientId){
		return clientRepository.findById(clientId).get().getFirstName();
	}
	
	
	/**
	 * Récupérer le nom du client en ayant son Id
	 * @param clientId l'identifiant du client
	 * @return String le nom du client
	 */
	@Override
	public String getLastNameByClientId(Long clientId){
		return clientRepository.findById(clientId).get().getLastName();
	}
	
	/**
	 * Ajouter un client dans la base
	 * @param client  l'objet client a rajouter dans la base
	 * @return Client l'entité client sychronisée avec la base
	 */
	@Override
	public Client addClient(Client client) {
	
		return 	clientRepository.save(client);
	}
	
	
	/**
	 * Ajouter un projet dans la base
	 * @param project l'object a insérer dans la base
	 */
	@Override
	public void addProject(Project project) {
		projectRepository.save(project);
	}
	
	/**
	 * Récupérer le titre d'un projet en ayant son ID
	 * @param projectid
	 * @return String le titre du projet
	 */
	@Override
	public String getProjectTitle(Long projectid) {
		return projectRepository.getProjectTitle(projectid);
	}
	
	
	/**
	 * Supprimer un client
	 * @param le client a supprimer
	 */
	@Override
	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}

	
	/**
	 * Calculer le nombre de clients dans la base
	 */
	@Override
	public Long countClients() {
		return clientRepository.count();
	}
	
	
	/**
	 * Récupérer le nombre de client ayant le nom {@code lastName}
	 * @param lastName
	 * @return le nombre de client ayant le nom {@code lastName}
	 */
	@Override
	public Long countClientsByName(String lastName) {
		return clientRepository.countClientsByName(lastName);
	}

	
	/**
	 * Supprimer tous les projets
	 */
	@Override
	public void deleteAllProjects() {
		projectRepository.deleteAll();
	}
	
	/**
	 * Récupérer l'id d'un client en ayant son nom et prénom
	 * return Long l'id du client
	 */
	@Override
	public Long findIdByFirstNameAndLastName(String firstName, String lastName) {
		return clientRepository.findIdByFirstNameAndLastName(firstName, lastName);
	}
	
}
