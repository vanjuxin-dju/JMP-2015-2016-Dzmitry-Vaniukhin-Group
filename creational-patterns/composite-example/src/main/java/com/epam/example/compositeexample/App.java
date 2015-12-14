package com.epam.example.compositeexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class App {

	public static void main(String[] args) {
		/*
		 * root (2861470 bytes)
		 * |-bin 
		 * | |-ls (8832 bytes)
		 * | |-cp (9456 bytes)
		 * |-home 
		 * | |-user 
		 * |   |-documentation.docx (1357911 bytes)
		 * |   |-documentation version 2.1.docx (1471013 bytes)
		 * |-opt 
		 *   |-audiojs.zip (14258 bytes)
		 * 
		 */
		Directory root = new Directory("root");
		
		Directory bin = new Directory("bin");
		Directory home = new Directory("home");
		Directory opt = new Directory("opt");
		
		bin.add(new File("ls", 8832L));
		bin.add(new File("cp", 9456L));
		
		Directory user = new Directory("user");
		user.add(new File("documentation.docx", 1357911L));
		user.add(new File("documentation version 2.1.docx", 1471013L));
		home.add(user);
		
		opt.add(new File("audiojs.zip", 14258L));
		
		root.add(bin);
		root.add(home);
		root.add(opt);
		
		System.out.println("size of root: " + root.getSize());
		System.out.println("folders under root");
		for(FSEntity entity: root.list().values()) {
			System.out.println(entity.getName() + " " + entity.getSize() + " bytes");
		}
		
		Directory dir = (Directory)((Directory)(root.list().get("home"))).list().get("user");
		dir.remove("documentation.docx");
		System.out.println("size of /home/user: " + dir.getSize());
	}

}
