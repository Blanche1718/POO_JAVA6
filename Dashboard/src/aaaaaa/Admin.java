package aaaaaa;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
	private static List<Category>categories;
	private static List<User>users;
	private static List<Images>images;
	private boolean connected;

	public Admin( String username, String email) {
		super( username, email);
		categories = new ArrayList<>();
		users = new ArrayList<>();
		images = new ArrayList<>();
		connected= false;
		
	}
	
	
	//Create Category
	public void CreateCategory(Scanner scanner) {
		
		System.out.println("Entrez le nom de la nouvelle catégorie : ");
		String name = scanner.nextLine();
		/*System.out.println("Nom saisi : " + name);*/
        
        /*System.out.print("Entrez le titre de la nouvelle catégorie : ");
        String title = scanner.nextLine();*/

        System.out.println("Entrez la description de la nouvelle catégorie : ");
        String description = scanner.nextLine();
        /*System.out.println("Description saisie : " + description)*/

            // Créer l'instance de Category
        Category newCategory = new Category(name, description);

        if (!categories.contains(newCategory)) {
        	categories.add(newCategory);
            System.out.println("Catégorie créée : " + newCategory.getName());
        } else {
            System.out.println("La catégorie existe déjà.");
        }
        
    }
	
	//Edit Category
	public void EditCategory(Scanner scanner)
	{
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
	        
	        return;
	        
	    }
	    else {
	    	
	    	System.out.print("Entrez le nouveau nom de la catégorie (laisser vide pour conserver le nom actuel) : ");
		    String newName = scanner.nextLine();
		    
		    if (!newName.isEmpty()) {
		        categoryToEdit.set_name(newName);
		    }
		    
		    /*System.out.print("Entrez le nouveau titre de la catégorie (laisser vide pour conserver le titre actuel) : ");
		    String newTitle = scanner.nextLine();
		    
		    if (!newTitle.isEmpty()) {
		        categoryToEdit.set_title(newTitle);
		    }*/

		    System.out.print("Entrez la nouvelle description de la catégorie (laisser vide pour conserver la description actuelle) : ");
		    String newDescription = scanner.nextLine();
		    if (!newDescription.isEmpty()) {
		        categoryToEdit.set_description(newDescription);
		    }

		    System.out.println("Les modifications ont été enregistrées pour la catégorie : " + categoryToEdit);
	    }
	    
	}
	

    // Delete Category
	public void DeleteCategory(Scanner scanner) {
		 System.out.print("Entrez le nom de la catégorie que vous souhaitez supprimer : ");
		 String deletedCategory_name = scanner.nextLine();
	    // Variable pour stocker la catégorie à supprimer
	    Category categoryToDelete = null;

	    for (Category category : categories) {
	        if (category.getName().equalsIgnoreCase(deletedCategory_name)) {
	            categoryToDelete = category;
	            break;
	        }
	    }

	    // Suppression de la catégorie si elle a été trouvée
	    if (categoryToDelete != null) {
	        categories.remove(categoryToDelete);
	        System.out.println("Catégorie supprimée : " + deletedCategory_name);
	    } else {
	        System.out.println("La catégorie '" + deletedCategory_name + "' n'existe pas.");
	    }
	}
	
	public void CategoryList() {

		System.out.println("Liste des catégories disponibles :");
	    for (Category category : categories) {
	        System.out.println("- " + category.getName());
	       
	    }
	}
	
	
	//Create User
		public void CreateUser(Scanner scanner) {
			System.out.print("Entrez le nom du nouveau utilisateur : ");
		
	        String newUsername = scanner.nextLine();
	        
	        System.out.println("Entrez l'email: ");
	        String email = scanner.nextLine();

	        boolean userExists = false;
	        for (User user : users) {
	            if (user.getEmail().equalsIgnoreCase(email)) {
	                userExists = true;
	                break;
	            }
	        }

	        if (!userExists) { 
	            User newUser = new User(newUsername, email);
	            users.add(newUser);
	            System.out.println("Utilisateur créé : " + newUser.getUsername());
	        } else {
	            System.out.println("L'utilisateur existe déjà.");
	        }
	        
	    }
		
		//Edit User
		
		public void EditUser(Scanner scanner)
		{
		
			
			System.out.println("Liste des utilisateurs disponibles :");
		    for (User user : users) {
		        System.out.println("- " + user.getUsername());
		    }
		    
		    System.out.print("Entrez le nom de l'utilisateur que vous souhaitez modifier : ");
		    String mod_username = scanner.nextLine();

		    User userToEdit = null;
		    
		    for (User user : users) {
		        if (user.getUsername().equalsIgnoreCase(mod_username)) {
		            userToEdit = user;
		            break;
		        }
		    }
		    
		    if (userToEdit == null) {
		        System.out.println("La catégorie '" + mod_username + "' n'existe pas.");
		        
		        return;
		        
		    }
		    else {
		    	
		    	System.out.print("Entrez le nouveau nom de l'utilisateur (laisser vide pour conserver le nom actuel) : ");
			    String newUserame = scanner.nextLine();
			    
			    if (!newUserame.isEmpty()) {
			        userToEdit.set_username(newUserame);
			    }
			    
			    System.out.print("Entrez le nouveau email de l'utilisateur (laisser vide pour conserver le titre actuel) : ");
			    String newEmail = scanner.nextLine();
			    
			    if (!newEmail.isEmpty()) {
			        userToEdit.setEmail(newEmail);
			    }

			    System.out.println("Les modifications ont été enregistrées pour l'utilisateur : " + userToEdit.getUsername());
		    }
		    
		}
		
		// Delete Category
		public void DeleteUser(Scanner scanner) {
			 System.out.print("Entrez le nom de l'utilisateur que vous souhaitez supprimer : ");
			 String deletedUser_name = scanner.nextLine();
		    // Variable pour stocker la catégorie à supprimer
		    User userToDelete = null;

		    for (User user : users) {
		        if (user.getUsername().equalsIgnoreCase(deletedUser_name)) {
		            userToDelete = user;
		            break;
		        }
		    }

		    // Suppression de la catégorie si elle a été trouvée
		    if (userToDelete != null) {
		        users.remove(userToDelete);
		        System.out.println("Utilisateur supprimé : " + deletedUser_name);
		    } else {
		        System.out.println("L'utilisateur '" + deletedUser_name + "' n'existe pas.");
		    }
		}
		
		// Liste de catégories
		
		
		public void UserList() {

			System.out.println("Liste des utilisateurs disponibles :");
		    for (User user : users) {
		        System.out.println("- " + user.getUsername());
		        
		    }
		}
		public void Suspend(Scanner scanner) {

			System.out.println("Liste des utilisateurs disponibles :");
		    for (User user : users) {
		        System.out.println("- " + user.getUsername()+'-'+user.getEmail());
		        
		    }
		    
		    System.out.print("Entrez l'email de l'utilisateur à suspendre : ");
		    String susp_email = scanner.nextLine();

		    User userTosuspend = null;
		    
		    for (User user : users) {
		        if (user.getEmail().equalsIgnoreCase(susp_email)) {
		            userTosuspend = user;
		            userTosuspend.set_restricted();
		            break;
		         
		        }else {
		        	System.out.print("Cet utilisateur n'existe pas");
		        }
		    }
		}
		
		
		public void CreateImage(Scanner scanner) {
			
			System.out.println("Entrez le nom de la nouvelle image : ");
			String name = scanner.nextLine();
			/*System.out.println("Nom saisi : " + name);*/
	        
	        System.out.print("Entrez le titre de l'image : ");
	        String title = scanner.nextLine();

	        System.out.println("Entrez la description de l'image : ");
	        String description = scanner.nextLine();
	        /*System.out.println("Description saisie : " + description)*/
	        Images newImage = new Images(name,title, description, true);

	        if (!images.contains(newImage)) {
	        	images.add(newImage);
	            System.out.println("Image créée : " + newImage.getName());
	        } else {
	            System.out.println("L'image existe déjà.");
	        }
	        
	    }
		
		//Se connecter
		public void Connect(Scanner scanner)
		{
			System.out.println("Entrez votre email");
			String mail = scanner.nextLine();
			for (User user : users) {
	            if (user.getEmail().equalsIgnoreCase(mail) &&  user.get_restricted() == false)
	            {
	            	System.out.println("L'utilisateur '" + user.getEmail() + "' est connectée.");
	            	connected=true;
	            	 while (connected) {
	                     System.out.println("\n--- Menu ---");
	                     System.out.println("1. Télecharger une image");
	                     System.out.println("2. Ajouter une image aux favoris");
	                     System.out.println("3. Liker une image");
	                     System.out.println("4. Afficher la galerie");
	                     System.out.println("5. Afficher les favoris");
	                     System.out.println("0. Quitter");

	                     System.out.print("Sélectionnez une option : ");
	                     int choix = scanner.nextInt();
	                     scanner.nextLine();

	                     switch (choix) {
	                         case 1:
	                        	 System.out.println("Liste des images disponibles :");
	                     	    for (Images image : images) {
	                     	        System.out.println("- " + image.getName());
	                     	    }
	                     	   System.out.print("Entrez le nom de l'image à télécharger : ");
	                  		   String downloadImage_name = scanner.nextLine();
	                  	    // Variable pour stocker l'image à telecharger
	                  	    Images imageToDownload = null;

	                  	    for (Images image : images) {
	                  	        if (image.getName().equalsIgnoreCase(downloadImage_name)) {
	                  	            imageToDownload = image;
	                  	            user.AddImage(image);
	                  	            break;   
	                  	        }
	                  	        else {
	                  	        	System.out.println("Cette image n'existe pas");
	                  	        }
	                         	
	                             break;
	                  	    }
	                         case 2:
	                        	 System.out.println("Liste des images disponibles :");
		                     	    for (Images image : images) {
		                     	        System.out.println("- " + image.getName());
		                     	    }
		                     	   System.out.print("Entrez le nom de l'image à ajouter aux favoris : ");
		                  		   String favoriteImage_name = scanner.nextLine();
		                  	    // Variable pour stocker l'image à ajouter aux favoris
		                  	    Images imageToFavorite = null;

		                  	    for (Images image : images) {
		                  	        if (image.getName().equalsIgnoreCase(favoriteImage_name)) {
		                  	            imageToFavorite = image;
		                  	            user.AddFavorites(image);
		                  	            break;   
		                  	        }
		                  	        else {
		                  	        	System.out.println("Cette image n'existe pas");
		                  	        }
		                  	    }
		                           
	                         	break;
		                  	  
		                  	  case 3:
		                        	 System.out.println("Liste des images disponibles :");
			                     	    for (Images image : images) {
			                     	        System.out.println("- " + image.getName());
			                     	    }
			                     	   System.out.print("Entrez le nom de l'image à liker : ");
			                  		   String likeImage_name = scanner.nextLine();
			                  	    // Variable pour stocker l'image à ajouter aux favoris
			                  	    Images likeToFavorite = null;

			                  	    for (Images image : images) {
			                  	        if (image.getName().equalsIgnoreCase(likeImage_name)) {
			                  	            likeToFavorite = image;
			                  	            user.AddLike(image);
			                  	            break;   
			                  	        }
			                  	        else {
			                  	        	System.out.println("Cette image n'existe pas");
			                  	        }
			                  	    }	
			                           
		                        break;
		                        case 4:
		                        	user.ShowGalerie();
		                        	break;
		                        	
		                        case 5:
		                        	user.ShowFavorites();
		                        	break;
		                        case 0:
		                            // Quitter le programme
		                            System.out.println("Au revoir !");
		                            connected = false;
		                            break;
		                        default:
		                            System.out.println("Option invalide. Veuillez réessayer.");     	
	                     
	                  }
	                
	                
	            }
			
	          }else if (user.getEmail().equalsIgnoreCase(mail) &&  user.get_restricted() == true) {
	        	  System.out.println("L'utilisateur est suspendu"); 
	   
	          }else {
	        	  System.out.println("Cet utilisateur n'existe pas"); 
	       	   
	          
	          }
		}
			
			
			
		
		


    /* Accepted Image
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
    }*/

}
