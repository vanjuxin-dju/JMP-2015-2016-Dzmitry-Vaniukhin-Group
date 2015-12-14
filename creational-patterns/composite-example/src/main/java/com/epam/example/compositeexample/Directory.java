/**
 * 
 */
package com.epam.example.compositeexample;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class Directory implements FSEntity {
	private Map<String, FSEntity> fsItems;
	private String name;
	
	public Directory() {
		fsItems = new HashMap<>();
	}
	
	public Directory(String name) {
		this();
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Long getSize() {
		long size = 0L;
		for(FSEntity entity: fsItems.values()) {
			size += entity.getSize();
		}
		return size;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void add(FSEntity entity) {
		fsItems.put(entity.getName(), entity);
	}
	
	public void remove(String name) {
		fsItems.remove(name);
	}
	
	public Map<String, FSEntity> list() {
		return fsItems;
	}

}
