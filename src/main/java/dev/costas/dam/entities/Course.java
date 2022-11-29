package dev.costas.dam.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcourse")
	private Long id;

	@Column(name="description", nullable = false, length = 100)
	private String description;

	@Column(name="begindate", nullable = false)
	private Instant beginDate = Instant.now();

	@Column(name="enddate")
	private Instant endDate;

	@ManyToMany(mappedBy = "courses")
	private Collection<Student> students = new ArrayList<>();

	public Course() {
	}

	public Course(String description) {
		this.description = description;
		this.beginDate = Instant.now();
		this.students = Collections.emptyList();
	}

	public Course(String description, Instant beginDate, Instant endDate) {
		this.description = description;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.students = Collections.emptyList();
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Instant beginDate) {
		this.beginDate = beginDate;
	}

	public Instant getEndDate() {
		return endDate;
	}

	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Course course = (Course) o;

		if (!Objects.equals(id, course.id)) return false;
		if (!Objects.equals(description, course.description))
			return false;
		if (!Objects.equals(beginDate, course.beginDate))
			return false;
		return Objects.equals(endDate, course.endDate);
	}

	@Override
	public String toString() {
		return "Course{" +
			"id=" + id +
			", description='" + description + '\'' +
			", beginDate=" + beginDate +
			", endDate=" + endDate +
			'}';
	}
}
