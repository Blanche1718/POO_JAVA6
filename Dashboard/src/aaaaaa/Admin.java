package aaaaaa;

import java.util.List;

public class Admin extends User {

	public Admin(int idUser, String username, String email) {
		super(idUser, username, email);
		
	}
	
	//Create Category
	public void CreateCategory(List<String> categories, String newCategory) {
        if (!categories.contains(newCategory)) {
            categories.add(newCategory);
            System.out.println("Catégorie créée : " + newCategory);
        } else {
            System.out.println("La catégorie existe déjà.");
        }
    }

    // Delete Category
    public void DeleteCategory(List<String> categories, String deletedCategory) {
        if (categories.contains(deletedCategory)) {
            categories.remove(deletedCategory);
            System.out.println("Catégorie supprimée : " + deletedCategory);
        } else {
            System.out.println("La catégorie n'existe pas.");
        }
    }

    // Accepted Image
    public void AcceptedImage(Images image) {
        
        System.out.println("Image approuvée : " + image.getTitle());
    }

    // 	Reject image
    public void RejectedImage(Images image) {
    	
        System.out.println("Image rejetée : " + image.getTitle());
    }

    // Show Statistics
    public void ShowStatistics(List<Images> images) {
        System.out.println("Statistiques de la plateforme :");
        System.out.println("Nombre total d'images : " + images.size());

        // Total likes
        int totalLikes = 0;
        for (Images image : images) {
            totalLikes += image.getLikes();
        }
        System.out.println("Nombre total de likes : " + totalLikes);
    }

}
