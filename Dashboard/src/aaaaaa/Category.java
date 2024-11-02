package aaaaaa;

import java.util.Scanner;
import java.util.ArrayList; 
import java.util.List;

public class Category {
	
	//Attributs
	
	private int id;
	private String name;
	private String title;
	private String description;
	private int created_by;
	private List<Image> images;
	
	//Constructeurs
	public Category(int ident,String nom,String titre,String desc,int etr) {
		id = ident;
		name = nom;
		title = titre;
		description = desc;
		created_by = etr;
		images = new ArrayList<>();
	}
	
	
	//Setters
	public void set_id(int ident) {
		id = ident;
	}
	
	public void set_name(String nom) {
		name = nom;
	}
	
	public void set_title(String titre) {
		title = titre;
	}
	
	public void set_description(String desc) {
		description = desc;
	}
	
	public void set_created_by(int etr) {
		created_by = etr;
	}
	
	//Getters
	public int get_id()
	{
		return id;
	}

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCreatedBy() {
        return created_by;
    }
	
	//Autres méthodes
	public void addImage(Image image) {
        images.add(image);
    }
	
	public List<Image> getImages() {
        return images;
    }
	
	public static void main(String[] args) {

	}

}
