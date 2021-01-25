/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.controller.interfaces.IprojectController;
import tn.esprit.spring.entity.Project;
import tn.esprit.spring.service.interfaces.IClientInfoService;


/**
 * 
 * Cette classe sert a implémenter les méthodes qui permettent de gérer un projet.
 * Cette classe représente une implémentation de l'interface <code>IidentityController</code>
 * 
 * @author Walid YAICH
 *
 */
@Component
public class ProjectControllerImpl implements IprojectController  {

	//TODO Injecter le service (il faut utiliser l'interface)
	@Autowired
	IClientInfoService clientService;
	/**
	 * Récupérer les titres des projets en ayant l'id du client
	 * @param clientId l'identifiant du client
	 * @return les titres des projets 
	 */
	// http://localhost:8081/SpringMVC/servlet/retrieve-user-fullName/{user-id}
		@ResponseBody
		@GetMapping("/retrieve-title/{id}")
	@Override
	public String getProjectsTitlesByClientId(@PathVariable("id") Long clientId){
		return clientService.getProjectsTitlesByClientId(clientId);
	}

	/**
	 * Ajouter un projet dans la base
	 * @param project l'object a insérer dans la base
	 */
		@PostMapping("/add-project")
		@ResponseBody
	@Override
	public void addProject(@RequestBody Project project) {
		clientService.addProject(project);
	}

	/**
	 * Récupérer le titre d'un projet en ayant son ID
	 * @param projectid
	 * @return String le titre du projet
	 */
		@ResponseBody
		@GetMapping("/retrieve-project/{id}")
	@Override
	public String getProjectTitle(@PathVariable("id") Long projectid) {
		return clientService.getProjectTitle(projectid);
	} 
	
	
	/**
	 * Supprimer tous les projets
	 */
		@DeleteMapping("/delete-projects")
	@Override
	public void deleteAllProjects() {
		clientService.deleteAllProjects();
	}
	
}
