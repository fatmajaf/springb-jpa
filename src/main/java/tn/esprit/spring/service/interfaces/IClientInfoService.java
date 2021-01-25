/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.service.interfaces;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Project;

/**
 * Cette interface permet de lister les méthodes qui permettent de gérer les informations d'un client.
 * @author Walid YAICH
 *
 */
public interface IClientInfoService {
	public String getProjectsTitlesByClientId(Long clientId);
	public String getFirstNameByClientId(Long clientId);
	public String getLastNameByClientId(Long clientId);
	public  Client addClient(Client client);
	public  void addProject(Project project);
	public  String getProjectTitle(Long projectid);
	public  void deleteClient(Client client);
	public  Long countClients();
	public  Long countClientsByName(String lastName);
	public  void deleteAllProjects();
	public  Long findIdByFirstNameAndLastName(String firstName, String lastName);
}