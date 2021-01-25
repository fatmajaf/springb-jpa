/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.controller.interfaces.IidentityController;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.interfaces.IClientInfoService;

/**
 * 
 * Cette classe représente une implémentation de l'interface <code>IidentityController</code> .
 * Cette classe implémente les méthodes qui permettent de gérer l'identité d'un client.
 * 
 * @author Walid YAICH
 *
 */

@Controller
public class IdentityControllerImpl implements IidentityController {
	
	@Autowired
	IClientInfoService clientService;
	
	/**
	 * Récupérer le nom et prénom d'un client en ayant son Id
	 * @param clientId  l'identifiant du client
	 * @return prénom et nom du client
	 */
	// http://localhost:8081/SpringMVC/servlet/retrieve-user-fullName/{user-id}
	@ResponseBody
	@GetMapping("/retrieve-user-fullName/{id}")
	@Override
	public String getFullNameByClientId(@PathVariable("id")  Long clientId){
		return clientService.getFirstNameByClientId(clientId)+ " " + clientService.getLastNameByClientId(clientId);
	}


	/**
	 * Ajouter un client dans la base
	 * @param client  l'objet client a rajouter dans la base
	 * @return Client l'entité client sychronisée avec la base
	 */
	// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-user
		@PostMapping("/add-client")
		@ResponseBody
	@Override
	public Client addClient(@RequestBody  Client client) {
		return clientService.addClient(client);
	}


	/**
	 * Supprimer un client
	 * @param le client a supprimer
	 */
		// http://localhost:8081/SpringMVC/servlet/removeuser/{user-id}
		@DeleteMapping("/delete-user")
	@Override
	public void deleteClient(@RequestBody Client client) {
		clientService.deleteClient(client);
	}


	
	/**
	 * Calculer le nombre de clients dans la base
	 */
		@ResponseBody
		@GetMapping("/retrieve-count")
	@Override
	public Long countClients() {
		return clientService.countClients();
	}

	/**
	 * Récupérer le nombre de client ayant le nom {@code lastName}
	 * @param lastName
	 * @return le nombre de client ayant le nom {@code lastName}
	 */
		@ResponseBody
		@GetMapping("/retrieve-count/{lastName}")
	@Override
	public Long countClientsByName(@PathVariable("lastName")String lastName) {
		return clientService.countClientsByName(lastName);
	}
	
	/**
	 * Récupérer l'id d'un client en ayant son nom et prénom
	 * return Long l'id du client
	 */
		@ResponseBody
		@GetMapping("/retrieve-id/{firstName}/{lastName}")
	@Override
	public Long findIdByFirstNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName")String lastName) {
		return clientService.findIdByFirstNameAndLastName(firstName, lastName);
	}

}
