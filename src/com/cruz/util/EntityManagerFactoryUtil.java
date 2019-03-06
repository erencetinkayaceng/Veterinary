package com.cruz.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VeterinaryPU");

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}
