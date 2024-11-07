package aaaaaa;

import java.util.ArrayList; 
import java.util.List;

public class Category {
	
	//Attributs
	
	private int id;
	private String name;
	//private String title;
	private String description;
	private List<Images> images;

	private static int next_id=1;

	
	//Constructeurs
	public Category(String nom,String desc) {
		this.name = nom;
		//title = titre;
		this.description = desc;
		this.id = next_id++;
		this.images = new ArrayList<>();
	}
	
	
	//Setters
	
	public void set_name(String nom) {
		name = nom;
	}
	
	/*public void set_title(String titre) {
		title = titre;
	}*/
	
	public void set_description(String desc) {
		description = desc;
	}
	
	
	
	
	//Getters
	public int get_id()
	{
		return id;
	}

    public String getName() {
        return name;
    }

    /*public String getTitle() {
        return title;
    }*/

    public String getDescription() {
        return description;
    }

    
	
	//Autres méthodes
	public void addImage(Images image) {
        images.add(image);
    }
	
	public List<Images> getImages() {
        return images;
    }
	

	

	public static void main(String[] args) {
		
		
		
		 
	}

}
