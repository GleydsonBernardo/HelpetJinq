package br.com.helpet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person extends BaseEntity implements Cloneable{

	private String name;
	private Address address;
	private String email;
	private String cpf;
	private String phone;
	
	public Person() {
	}

	public Person(String name, Address address, String email, String cpf, String phone) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.cpf = cpf;
		this.phone = phone;
	}

	@Column(name="name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne
	@JoinColumn(name="address_id", nullable=false, updatable=true)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name="email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="cpf", nullable = false)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name="phone", nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString(){
		return "Nome: "+this.name+" Endereço(Rua: "+this.address.getStreet()+" Cidade: "+this.address
				.getCity()+") Email: "+this.email+" CPF: "+this.cpf+" Telefone: "+this.phone;
	}
	
	@Override
	public Person clone() {
		try {
			return (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}
}
