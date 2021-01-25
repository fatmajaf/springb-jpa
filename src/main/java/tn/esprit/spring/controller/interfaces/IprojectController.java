/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.controller.interfaces;

import tn.esprit.spring.entity.Project;

/**
 * 
 * Cette interface sert a lister les méthodes qui permettent de gérer un projet.
 * 
 * @author Walid YAICH
 *
 */
public interface IprojectController {
	String getProjectsTitlesByClientId(Long clientId);
	void addProject(Project project);
	default String getProjectTitle(Long projectid){throw new UnsupportedOperationException();}
	default void deleteAllProjects(){throw new UnsupportedOperationException();}
}