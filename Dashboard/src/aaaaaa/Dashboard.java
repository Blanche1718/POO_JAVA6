package aaaaaa;

import java.util.Scanner;

public class Dashboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Admin admin = new Admin("Admin", "admin@gmail.com");
        Statistics stats = new Statistics(admin);
        admin.loadUsersFromCSV();
        admin.loadCategoriesFromCSV();
        admin.loadImagesFromCSV();
        admin.initializeFiles();

        boolean exit = false;
        while (!exit) {
        	System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        	System.out.println("\n***********************************Bienvenue sur la plateforme d'administration de notre site de téléchargement d'images. Voici les options qui sont disponibles:****************************************");
            System.out.println("\n--------------- Menu ----------------");
            System.out.println("\n1. Gestion de catégories");
            System.out.println("\n2. Gestion des utilisateurs");
            System.out.println("\n3. Ajouter une image sur la plateforme");
            System.out.println("\n4. Supprimer une image sur la plateforme");
            System.out.println("\n5. Gérer les images soumises par les utilisateurs");
            System.out.println("\n6. Afficher les statistiques de la plateforme");
            System.out.println("\n0. Quitter");

            System.out.print("\nSélectionnez une option : ");
            int choix = getValidChoice(scanner, 0, 6);  // Utilisation de la méthode getValidChoice

            switch (choix) {
                case 1:
                    gestionCategories(scanner, admin);
                    break;
                case 2:
                    gestionUtilisateurs(scanner, admin);
                    break;
                case 3:
                    admin.CreateImage(scanner);
                    break;
                case 4:
                    admin.DeleteImage(scanner);
                    break;
                case 5:
                    admin.Approve_image(scanner);
                    break;
                case 6:
                	gestionStatistiques(scanner,stats);
                	break;
                case 0:
                	admin.disconnect();
                    System.out.println("\nAu revoir !");
                    exit = true;
                    break;
                default:
                    System.out.println("\nOption invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }

    // Méthode pour gérer les catégories
    private static void gestionCategories(Scanner scanner, Admin admin) {
        System.out.println("\n1. Ajouter une catégorie");
        System.out.println("\n2. Editer une catégorie");
        System.out.println("\n3. Supprimer une catégorie");
        System.out.println("\n4. Consulter la liste des catégories");
        System.out.println("\n5. Ajouter une image a une catégorie");
        System.out.println("\n6. Consulter les images dans une catégorie");
        System.out.println("\n0. Quitter");

        int option1 = getValidChoice(scanner, 0, 6);
        
        switch (option1) {
            case 1: admin.CreateCategory(scanner); break;
            case 2: admin.EditCategory(scanner); break;
            case 3: admin.DeleteCategory(scanner); break;
            case 4: admin.CategoryList(); break;
            case 5: admin.AddImagetoCategory(scanner); break;
            case 6: admin.ShowImageinCategory(scanner); break;
            case 0: break;
        }
    }

    // Méthode pour gérer les utilisateurs
    private static void gestionUtilisateurs(Scanner scanner, Admin admin) {
        System.out.println("\n1. Ajouter un utilisateur");
        System.out.println("\n2. Editer un utilisateur");
        System.out.println("\n3. Supprimer un utilisateur");
        System.out.println("\n4. Suspendre un utilisateur");
        System.out.println("\n5. Lever la suspension d'un utilisateur");
        System.out.println("\n6. Consulter la liste des utilisateurs");
        System.out.println("\n7. Connecter un utilisateur");
        System.out.println("\n0. Quitter");

        int option2 = getValidChoice(scanner, 0, 7);

        switch (option2) {
            case 1: admin.CreateUser(scanner); break;
            case 2: admin.EditUser(scanner); break;
            case 3: admin.DeleteUser(scanner); break;
            case 4: admin.Suspend(scanner); break;
            case 5: admin.removeSuspension(scanner); break;
            case 6: admin.UserList(); break;
            case 7: admin.Connect(scanner); break;
            case 0: break;
        }
    }
    


    private static void gestionStatistiques(Scanner scanner, Statistics stats) {
       

            System.out.println("\n1. Afficher le nombre total de téléchargements");
            System.out.println("\n2. Afficher le nombre total d'utilisateurs");
            System.out.println("\n3. Afficher les images les plus téléchargées");
            System.out.println("\n4. Afficher les téléchargements par catégorie");
            System.out.println("\n5. Afficher l'activité des utilisateurs");
            System.out.println("\n0. Déconnexion");

            int option3=getValidChoice(scanner, 0, 5);

            switch (option3) {
                case 1:
                   System.out.println("\nTotal des téléchargements : " + stats.getTotalDownload());
                    break;
                case 2:
                    System.out.println("\nNombre total d'utilisateurs : " + stats.getTotalUsers());
                    break;
                case 3:
                    stats.showTop5Images();
                    break;
                case 4:
                   stats.afficherImagesTelechargeesParCategorie();
                    break;
                case 5:
                    stats.showUserActivity();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOption invalide. Veuillez réessayer.");
            }
        
    }
     
    
    private static int getValidChoice(Scanner scanner, int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                System.out.print("\nVeuillez bien à entrer un nombre entre " + min + " et " + max + ": ");
                choice = scanner.nextInt();
                if (choice < min || choice > max) {
                    System.out.println("\nVeuillez entrer un nombre valide.");
                }
            } catch (Exception e) {
                System.out.println("\nEntrée invalide. Veuillez entrer un nombre.");
                scanner.nextLine();  // Consomme l'entrée invalide
            }
        }
        scanner.nextLine();  // Consomme le caractère de nouvelle ligne laissé par nextInt()
        return choice;
    }

}
