package aaaaaa;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
	private static List<Category>categories;

	public Admin(int idUser, String username, String email) {
		super(idUser, username, email);
		categories = new ArrayList<>();
		
	}
	
	
	//Create Category
	public void CreateCategory() {
		System.out.print("Entrez le nom de la nouvelle catégorie : ");
		Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        
            System.out.print("Entrez le titre de la nouvelle catégorie : ");
            String title = scanner.nextLine();

            System.out.print("Entrez la description de la nouvelle catégorie : ");
            String description = scanner.nextLine();

            // Créer l'instance de Category
            Category newCategory = new Category(name, title, description);

        if (!categories.contains(newCategory)) {
        	categories.add(newCategory);
            System.out.println("Catégorie créée : " + newCategory.getName());
        } else {
            System.out.println("La catégorie existe déjà.");
        }
        scanner.close();
    }
	
	//Edit Category
	public void EditCategory()
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Liste des catégories disponibles :");
	    for (Category category : categories) {
	        System.out.println("- " + category.getName());
	    }
	    
	    System.out.print("Entrez le nom de la catégorie que vous souhaitez modifier : ");
	    String mod_name = scanner.nextLine();

	    Category categoryToEdit = null;
	    
	    for (Category category : categories) {
	        if (category.getName().equalsIgnoreCase(mod_name)) {
	            categoryToEdit = category;
	            break;
	        }
	    }
	    
	    if (categoryToEdit == null) {
	        System.out.println("La catégorie '" + mod_name + "' n'existe pas.");
	        scanner.close();
	        return;
	        
	    }
	    else {
	    	
	    	System.out.print("Entrez le nouveau nom de la catégorie (laisser vide pour conserver le nom actuel) : ");
		    String newName = scanner.nextLine();
		    
		    if (!newName.isEmpty()) {
		        categoryToEdit.set_name(newName);
		    }
		    
		    System.out.print("Entrez le nouveau titre de la catégorie (laisser vide pour conserver le titre actuel) : ");
		    String newTitle = scanner.nextLine();
		    
		    if (!newTitle.isEmpty()) {
		        categoryToEdit.set_title(newTitle);
		    }

		    System.out.print("Entrez la nouvelle description de la catégorie (laisser vide pour conserver la description actuelle) : ");
		    String newDescription = scanner.nextLine();
		    if (!newDescription.isEmpty()) {
		        categoryToEdit.set_description(newDescription);
		    }

		    System.out.println("Les modifications ont été enregistrées pour la catégorie : " + categoryToEdit);
	    }
	    scanner.close();
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
