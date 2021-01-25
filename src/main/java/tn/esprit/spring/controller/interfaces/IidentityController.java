/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.controller.interfaces;

import tn.esprit.spring.entity.Client;

/**
 * 
 * Cette interface sert a lister les méthodes qui permettent de gérer l'identité d'un client.
 * 
 * @author Walid YAICH
 *
 */
public interface IidentityController {
	String getFullNameByClientId(Long clientId);
	Client addClient(Client client);
	void deleteClient(Client client);
	Long countClients();
	Long countClientsByName(String lastName);
	Long findIdByFirstNameAndLastName(String firstName, String lastName);
}