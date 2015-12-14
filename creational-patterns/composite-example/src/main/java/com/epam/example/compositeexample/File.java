package com.epam.example.compositeexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class File implements FSEntity {
	private String name;
	private Long size;
	
	public File() {}
	
	public File(String name, Long size) {
		this.name = name;
		this.size = size;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Long getSize() {
		return size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(Long size) {
		this.size = size;
	}
}
