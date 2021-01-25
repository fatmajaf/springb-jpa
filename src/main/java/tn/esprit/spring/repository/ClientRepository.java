/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entity.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {
	
	@Query("select count(c) from Client c where c.lastName = ?1 ")
	public Long countClientsByName(String lastName) ;
	
	@Query("select c.id from Client c where c.firstName = ?1  and c.lastName = ?2 ")
	public Long findIdByFirstNameAndLastName(String firstName, String lastName);
}