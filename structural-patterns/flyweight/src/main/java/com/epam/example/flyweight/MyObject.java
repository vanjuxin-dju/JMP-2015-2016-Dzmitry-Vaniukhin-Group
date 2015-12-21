package com.epam.example.flyweight;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class MyObject {
	private Integer id;
	private String name;
	private Boolean worker;

	public MyObject(Integer id, String name, Boolean worker) {
		super();
		this.id = id;
		this.name = name;
		this.worker = worker;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Boolean getWorker() {
		return worker;
	}

	@Override
	public String toString() {
		return "MyObject [id=" + id + ", name=" + name + ", worker=" + worker
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((worker == null) ? 0 : worker.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyObject other = (MyObject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (worker == null) {
			if (other.worker != null)
				return false;
		} else if (!worker.equals(other.worker))
			return false;
		return true;
	}

}
