package dev.costas.dam.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_generator")
	@SequenceGenerator(name = "student_seq_generator", allocationSize = 1)
	@Column(name = "idstudent", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "identification", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "phone", nullable = false, length = 14, unique = true)
	private String phone;

	@ManyToMany
	@JoinTable(name = "students_courses",
		joinColumns = @JoinColumn(name = "student_idstudent"),
		inverseJoinColumns = @JoinColumn(name = "courses_idcourse"))
	private Collection<Course> courses = new ArrayList<>();

	@OneToOne(mappedBy = "student", orphanRemoval = true)
	private Card card;

	public Student() {
	}

	public Student(String name, String dni, String phone) {
		this.name = name;
		this.dni = dni;
		this.phone = phone;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Student student = (Student) o;

		if (!id.equals(student.id)) return false;
		if (!name.equals(student.name)) return false;
		if (!dni.equals(student.dni)) return false;
		return phone.equals(student.phone);
	}

	@Override
	public String toString() {
		return "Student{" +
			"id=" + id +
			", name='" + name + '\'' +
			", dni='" + dni + '\'' +
			", phone='" + phone + '\'' +
			'}';
	}
}
