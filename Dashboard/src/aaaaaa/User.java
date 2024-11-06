package aaaaaa;
import java.util.ArrayList;
import java.util.List;


public class User {
	private int idUser;
	private String email;
	private String username;
	private List<Images>galerie;
	private List<Images>favoris;
	private static List<Images>like;
	
    //Constructors
	
	public User(int idUser,String username, String email) {
		this.idUser=idUser;
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
	
	//Setters
	public void setEmail(String email) {
		if (email.contains("@")) {
	        this.email = email;
	    } else {
	        System.out.println("Adresse email invalide.");
	    }
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
	
	public static void AddLike(Images image){
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
		System.out.println("Contenu de la galerie '" +galerie+ "' :" );
		for (Images image : galerie) {
			System.out.println("- " +image.getTitle()+ " (" +image.getName()+ ")");
			System.out.println("***********************************");
		}
	}
	
	public void ShowFavorites() {
		System.out.println("Images favorites de l'utilisateur" + idUser + ":");
		if (favoris.isEmpty()) {
			System.out.println("Aucune images dans les favoris.");
			} else {
				for (Images image : favoris) {
					System.out.println("-"+ image.getTitle() + "(" + image.getName()+")");
					System.out.println("***********************************");
				}
			}
	}

	
}
