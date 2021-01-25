/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import tn.esprit.spring.controller.interfaces.IidentityController;
import tn.esprit.spring.controller.interfaces.IprojectController;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Project;


/**
 * C'est la classe main, elle intéragit avec la couche controller
 * Cette classe fait appel au Spring container a travers l'ApplicationContext 
 * pour récupérer les beans controller.
 * 
 * Pour faire cet exercice il faut remplacer les TODO par du code et prendre
 * en considération ces remarques :
 * -Il faut respecter la conception en passant par toutes les couches de l'application
 * -Il ne faut pas changer les signatures des méthodes
 * -Il ne faut pas rajouter ou supprimer des méthodes, sauf dans le package repository
 *
 * @author Walid YAICH
 *
 */

@SpringBootApplication
public class ClientView {
	private static Logger logger = LoggerFactory.getLogger(ClientView.class);
	
	private static IidentityController identityController;
	private static IprojectController projectController;
	
	public static void main(String[] args) throws ParseException {
		
		//Charger la configuration
		ApplicationContext applicationContext = SpringApplication.run(ClientView.class, args);

		//TODO Instantiation des controleurs par le container
		identityController = (IidentityController) applicationContext.getBean("identityControllerImpl");
		projectController = (IprojectController) applicationContext.getBean("projectControllerImpl");
		saveData();
		readData();
	}
	
	
	public static void readData(){
		//Récupérer le nom prénom du client en ayant son ID
		Long clientId = 1L;
		String clientFullName = identityController.getFullNameByClientId(clientId);		
		logger.info("Nom et prenom : {}", clientFullName);
		
		//Récupérer l'id d'un client en ayant son nom et prénom
		Long id = identityController.findIdByFirstNameAndLastName("Bilel", "Zitouni");
		logger.info("L'id de bilel zitouni est : {}", id);
		
		Long projectid = 1L;
		//Récupérer le titre du projet en ayant son ID
		String projectTitle = projectController.getProjectTitle(projectid);
		logger.info("Titre du projet : {}", projectTitle);
		
		//calculer le nombre des clients dans la base de données
		logger.info("Le nombre de clients dans la base : {}",identityController.countClients());
		
		//calculer le nombre des clients dont leur nom est "Zitouni"
		logger.info("Le nombre de clients ayant le nom 'Zitouni' est : {}",identityController.countClientsByName("Zitouni"));
		
		//Récupérer les titres des projets d'un client en ayant son ID
		clientId = 2L;
		String projects = projectController.getProjectsTitlesByClientId(clientId);
		logger.info("Les titre des projets de ce client est : {}", projects);
		
		//Supprimer un client en ayant son ID
		Client client = new Client(1L);
		identityController.deleteClient(client);
		
		//Supprimer tout les projets
		projectController.deleteAllProjects();
	}
	

	/**
	 * Insertion des données dans la base
	 * @throws ParseException 
	 */
	public static void saveData() throws ParseException{
		//Ajouter 2 clients
		identityController.addClient(new Client("Walid", "YAICH", "walid.yaich@esprit.tn"));
		Client bilel = identityController.addClient(new Client("Bilel", "Zitouni", "bilel.zitouni@esprit.tn"));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
		//Ajouter le projet "4G" et l'affecter au client ayant l'id 1
		Project project4G = new Project("Mise en place du 4G", "étude de migration du 3G vers la 4G",
				dateFormat.parse("01/01/2018"),	dateFormat.parse("25/02/2019"));
		project4G.setClient(bilel);
		projectController.addProject(project4G);

		//Ajouter le projet "maintenance" et l'affecter au client ayant l'id 1
		Project projetMaintenance = new Project("TMA", "Maintenance corrective et évolutive d'une application web",
				dateFormat.parse("01/01/2018"),	dateFormat.parse("25/02/2019"));
		projetMaintenance.setClient(bilel);
		projectController.addProject(projetMaintenance);		
	}
	
}
