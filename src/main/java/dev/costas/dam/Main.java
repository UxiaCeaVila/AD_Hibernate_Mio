package dev.costas.dam;

import dev.costas.dam.entities.Card;
import dev.costas.dam.entities.Course;
import dev.costas.dam.entities.Student;
import dev.costas.dam.enums.CardType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		System.out.print("Unidad de persistencia a usar [default]: ");
		var persistenceUnitName= sc.nextLine();
		if (persistenceUnitName.equals("")) {
			persistenceUnitName = "default";
		}

		EntityManager em;
		try {
			em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
		} catch (Exception ex) {
			System.out.println("Excepción iniciando gestor de persistencia: " + ex.getMessage());
			return;
		}

		var s1 = new Student("Ariel", "11111111A", "+34600123456");
		var s2 = new Student("Abel", "22222222B", "+34700112233");
		var s3 = new Student("Adrian", "33333333C", "+34986999999");
		var ca1 = new Card("1111222233334444", CardType.FP, s1);
		var ca2 = new Card("4444333322221111", CardType.ESO, s2);
		var co1 = new Course("2º DAM");
		var co2 = new Course("2º ASIR");
		var co3 = new Course("1º ESO");
		s1.getCourses().add(co1);
		s1.getCourses().add(co2);
		s3.getCourses().add(co3);

		persistAll(em, s1, s2, s3, ca1, ca2, co1, co2, co3);
	}

	public static void persistAll(EntityManager em, Object ...objects) {
		em.getTransaction().begin();
		for (Object o : objects) {
			em.persist(o);
		}
		em.getTransaction().commit();
	}
}
