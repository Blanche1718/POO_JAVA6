package aaaaaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    //private static int next_idUser = 0;
    
    private int idUser=0;
    private String email;
    private String username;
    private List<Images> galerie;
    private List<Images> favoris;
    private List<Images> like;
    private List<Images> soumisesImg;
    private boolean restricted = false;
    private List<Images> downloadedImages;

    Scanner scanner = new Scanner(System.in);

    // Constructor
    public User(String username, String email) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.galerie = new ArrayList<>();
        this.favoris = new ArrayList<>();
        this.like = new ArrayList<>();
        this.soumisesImg = new ArrayList<>();
        this.downloadedImages = new ArrayList<>();
    }

    // Getters
    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isRestricted() {
        return restricted;
    }

    // Setters
    public void setUsername(String name) {
        this.username = name;
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Adresse email invalide.");
        }
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
        //System.out.println("L'utilisateur a été suspendu");
    }

    // Methods

    public void addImage(Images image) {
        galerie.add(image);
        System.out.println("Image ajoutée à la galerie : " + image.getTitle());
    }

    public void addFavorite(Images image) {
        if (!favoris.contains(image)) {
            favoris.add(image);
            System.out.println("Image ajoutée aux Favoris : " + image.getTitle());
        } else {
            System.out.println("L'image est déjà dans les favoris.");
        }
    }

    public void addLike(Images image) {
        if (!like.contains(image)) {
            like.add(image);
            System.out.println("Image ajoutée aux Likes : " + image.getTitle());
        } else {
            System.out.println("L'image est déjà likée.");
        }
    }

    public void showGalerie() {
        System.out.println("Contenu de la galerie de " + username + " :");
        if (galerie.isEmpty()) {
            System.out.println("Aucune image dans la galerie.");
        } else {
            for (Images image : galerie) {
                System.out.println("- " + image.getTitle() + " (" + image.getName() + ")");
                System.out.println("***********************************");
            }
        }
    }

    public void showFavorites() {
        System.out.println("Images favorites de " + username + " :");
        if (favoris.isEmpty()) {
            System.out.println("Aucune image dans les favoris.");
        } else {
            for (Images image : favoris) {
                System.out.println("- " + image.getTitle() + " (" + image.getName() + ")");
                System.out.println("***********************************");
            }
        }
    }

    public void showLikes() {
        System.out.println("Images likées par " + username + " :");
        if (like.isEmpty()) {
            System.out.println("Aucune image likée.");
        } else {
            for (Images image : like) {
                System.out.println("- " + image.getTitle() + " (" + image.getName() + ")");
                System.out.println("***********************************");
            }
        }
    }
    
    public void subImages(Images imagesub)
    {
    	soumisesImg.add(imagesub);
    	System.out.println("Image soumise avec succès :Elle sera ajoutée à la plateforme une fois confirmation de l'administrateur.");
    }
    
    public void downloadImage(Images image) {
        downloadedImages.add(image);
    }

    public List<Images> getDownloadedImages() {
        return downloadedImages;
    }



    // Override equals and hashCode for User based on email
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return email.equalsIgnoreCase(user.email);
    }

    @Override
    public int hashCode() {
        return email.toLowerCase().hashCode();
    }

	public void setIdUser(int id) {
		// TODO Auto-generated method stub
		
	}
}
