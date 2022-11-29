package dev.costas.dam.entities;

import dev.costas.dam.enums.CardType;
import jakarta.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq_generator")
	@SequenceGenerator(name = "card_seq_generator", allocationSize = 5000)
	@Column(name = "idcard", nullable = false)
	private Long id;

	@Column(name="code", nullable = false, unique = true)
	private String code;

	@Transient
	private CardType type;

	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "student_idstudent", unique = true)
	private Student student;

	public Card() {
	}

	public Card(String code, CardType type, Student student) {
		this.code = code;
		this.type = type;
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Card{" +
			"id=" + id +
			", code='" + code + '\'' +
			", type=" + type +
			'}';
	}
}
