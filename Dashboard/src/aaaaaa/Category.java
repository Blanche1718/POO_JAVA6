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
	private static int next_id=1;
	
	//Constructeurs
	public Category(String nom,String titre,String desc,int etr) {
		name = nom;
		title = titre;
		description = desc;
		created_by = etr;
		id = next_id++;
		images = new ArrayList<>();
	}
	
	
	//Setters
	
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
		
		/*Scanner sc = new Scanner(System.in);
		
		Category cat1 = new Category("Voiture","voiture_courses","blabla",2);
		Category cat2 = new Category("Maison","Appartement","blabla",2);
		int id1 = cat1.get_id();
		int id2 = cat2.get_id();
		
		System.out.println(id1);
		System.out.println(id2);*/
		 
	}

}
