package aaaaaa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class User {
	Scanner scanner = new Scanner(System.in);

	private int idUser;
	private String email;
	private String username;
	private List<Images>galerie;
	private List<Images>favoris;
	private List<Images>like;
	private static int next_idUser=1;
	private boolean restricted=false;
	
    //Constructors
	
	public User(String username, String email) {
		this.idUser = next_idUser++;
        this.username = username;
        this.email = email;
        this.galerie = new ArrayList<>();
        this.favoris = new ArrayList<>();
    }
	
	// Getters 
	
	public int getIdUser(){
		return idUser;
	}
	
	public String getUsername() {
		return username;
	}			
			
	public String getEmail() {
		return email;
	}
	
	public boolean get_restricted()
	{
		return restricted;
	}
	
	//Setters
	public void set_username(String name) {
		username = name;
	}
	public void setEmail(String email) {
		if (email.contains("@")) {
	        this.email = email;
	    } else {
	        System.out.println("Adresse email invalide.");
	    }
	}
	
	public void set_restricted()
	{
		restricted = true;
		System.out.println("L'utilisateur a été suspendu");
	}
	

	//Method

	public void AddImage(Images image){
		galerie.add(image);
		System.out.println("Image ajoutée à la galerie :"+image.getTitle());
	}

	public void AddFavorites(Images image){
		favoris.add(image);
		System.out.println("Image ajoutée aux Favoris :"+image.getTitle());
	}
	
	public void AddLike(Images image){
		like.add(image);
		System.out.println("Image ajoutée aux Likes :"+image.getTitle());
	}

	/*public void ShowGalerie(){
		System.out.println("Galerie de  :"+username);
		for (Images image : galerie){
			image.showDetails();
			System.out.println("***********************************");
		}
	}*/
	
	public void ShowGalerie() {
		System.out.println("Contenu de la galerie  :" );
		if (galerie.isEmpty()) {
			System.out.println("Aucune images dans les galeries.");
			} else {
				for (Images image : galerie) {
					System.out.println("-"+ image.getTitle() + "(" + image.getName()+")");
					System.out.println("***********************************");
				}
			}
	}
	
	public void ShowFavorites() {
		System.out.println("Images favorites de l'utilisateur:");
		if (favoris.isEmpty()) {
			System.out.println("Aucune image dans les favoris.");
			} else {
				for (Images image : favoris) {
					System.out.println("-"+ image.getTitle() + "(" + image.getName()+")");
					System.out.println("***********************************");
				}
			}
	}
	
	

	/*@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return email.equalsIgnoreCase(user.email);
    }

    @Override
    public int hashCode() {
        return email.toLowerCase().hashCode();
    }*/
}
