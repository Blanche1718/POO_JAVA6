package aaaaaa;

import java.util.ArrayList;
import java.util.List;

/*public class Dashboard {
    public static void main(String[] args) {
        
        Images img1 = new Images(2, 2, "photo1.jpg", "Vacances", "Photo de vacances à la plage", 23, true);
        Images img2 = new Images(4, 5,"photo2.jpg", "Montagne", "Vue de la montagne enneigée",7,false);

        
        Admin admin = new Admin(1,"Admin", "admin@example.com");

        // Création de la liste des catégories
        List<String> categories = new ArrayList<>();
        
        // Ajout et suppression de catégories
        admin.CreateCategory(categories, "Nature");
        admin.CreateCategory(categories, "Animaux");
        admin.DeleteCategory(categories, "Nature");

        // Approuver et rejeter des images
        admin.AcceptedImage(img1);
        admin.RejectedImage(img2);

        // Afficher les statistiques
        List<Images> images = new ArrayList<>();
        images.add(img1);
        images.add(img2);
        admin.ShowStatistics(images);
    }
}*/

import java.util.Scanner;

public class Dashboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Admin admin = new Admin(1,"Admin", "admin@example.com");

        // Création d'un objet Image avec un chemin fictif

        Images img1 = new Images(2, 2, "photo1.jpg", "Vacances", "Photo de vacances à la plage", 23, true);
        Images img2 = new Images(4, 5,"photo2.jpg", "Montagne", "Vue de la montagne enneigée",7,false);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("Welcome to the Dashboard of our images download application. View the option that you have : ");
            System.out.println("1. Gestion de catégories");
            System.out.println("2. Ajouter un utilisateur");
            System.out.println("3. Mofifier un utilisateur");
            System.out.println("4. Supprimer un utilisateur");
            System.out.println("5. Télecharger une image");
            System.out.println("6. Ajouter un like");
            System.out.println("7. Afficher les statistiques de la plateforme");
            System.out.println("0. Quitter");

            System.out.print("Sélectionnez une option : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                	System.out.println("1. Ajouter une catégorie");
                    System.out.println("2. Editer une catégorie");
                    System.out.println("3. Supprimer une catégorie");
                    
                    System.out.print("Sélectionnez une option : ");
                    int option = scanner.nextInt();
                    switch (option) {
                    case 1:
                    	admin.CreateCategory();	
                    	break;
                    case 2:
                    	admin.EditCategory();
                    	break;
                    }
                    break;
                /*case 2:
                    
                    break;
                case 3:
                    // Obtenir la taille du fichier
                   
                    break;
                case 4:
                    // Ajouter un like à l'image
                    User.AddLike(img1);
                    System.out.println("Like ajouté !");
                    break;
                case 5:
                    // Afficher le nombre de likes
                    System.out.println("Nombre de likes : " + image.getLikes());
                    break;
                case 0:
                    // Quitter le programme
                    System.out.println("Au revoir !");
                    exit = true;
                    break,*/
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }
}





