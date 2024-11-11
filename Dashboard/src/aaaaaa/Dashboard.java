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
            System.out.println("\n┌───────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│               BIENVENUE SUR LE TABLEAU DE BORD DE NOTRE PLATEFORME            │");
            System.out.println("├───────────────────────────────────────────────────────────────────────────────┤");
            System.out.println("│ Menu Principal                                                               	│");
            System.out.println("├───────────────────────────────────────────────────────────────────────────────┤");
            System.out.println("│ 1. Gestion de catégories                                                      │");
            System.out.println("│ 2. Gestion des utilisateurs                                                   │");
            System.out.println("│ 3. Ajouter une image sur la plateforme                                        │");
            System.out.println("│ 4. Supprimer une image sur la plateforme                                      │");
            System.out.println("│ 5. Gérer les images soumises par les utilisateurs                             │");
            System.out.println("│ 6. Afficher les statistiques de la plateforme                                 │");
            System.out.println("│ 0. Déconnexion                                                                │");
            System.out.println("└───────────────────────────────────────────────────────────────────────────────┘");

            System.out.print("\nSélectionnez une option : ");
            int choix = getValidChoice(scanner, 0, 6);

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
                    gestionStatistiques(scanner, stats);
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
    	boolean exit2 = false;
    	while(!exit2) {
    		System.out.println("\n┌─────────────── GESTION DES CATÉGORIES ───────────────┐");
            System.out.println("│ 1. Ajouter une catégorie                             │");
            System.out.println("│ 2. Editer une catégorie                              │");
            System.out.println("│ 3. Supprimer une catégorie                           │");
            System.out.println("│ 4. Consulter la liste des catégories                 │");
            System.out.println("│ 5. Ajouter une image à une catégorie                 │");
            System.out.println("│ 6. Consulter les images dans une catégorie           │");
            System.out.println("│ 0. Quitter                                           │");
            System.out.println("└──────────────────────────────────────────────────────┘");

            int option1 = getValidChoice(scanner, 0, 6);

            switch (option1) {
                case 1: admin.CreateCategory(scanner); break;
                case 2: admin.EditCategory(scanner); break;
                case 3: admin.DeleteCategory(scanner); break;
                case 4: admin.CategoryList(); break;
                case 5: admin.AddImagetoCategory(scanner); break;
                case 6: admin.ShowImageinCategory(scanner); break;
                case 0:
                	System.out.println("\nVous êtes de retour au menu principal !");
                	exit2=true; 
                	break;
            }
    	}
        
    }

    // Méthode pour gérer les utilisateurs
    private static void gestionUtilisateurs(Scanner scanner, Admin admin) {
    	boolean exit3 = false;
    	while(!exit3){
    		System.out.println("\n┌─────────────── GESTION DES UTILISATEURS ───────────────┐");
            System.out.println("│ 1. Ajouter un utilisateur                              │");
            System.out.println("│ 2. Editer un utilisateur                               │");
            System.out.println("│ 3. Supprimer un utilisateur                            │");
            System.out.println("│ 4. Suspendre un utilisateur                            │");
            System.out.println("│ 5. Lever la suspension d'un utilisateur                │");
            System.out.println("│ 6. Consulter la liste des utilisateurs                 │");
            System.out.println("│ 7. Connecter un utilisateur                            │");
            System.out.println("│ 0. Quitter                                             │");
            System.out.println("└────────────────────────────────────────────────────────┘");

            int option2 = getValidChoice(scanner, 0, 7);

            switch (option2) {
                case 1: admin.CreateUser(scanner); break;
                case 2: admin.EditUser(scanner); break;
                case 3: admin.DeleteUser(scanner); break;
                case 4: admin.Suspend(scanner); break;
                case 5: admin.removeSuspension(scanner); break;
                case 6: admin.UserList(); break;
                case 7: admin.Connect(scanner); break;
                case 0:
                	System.out.println("\nVous êtes de retour au menu principal !");
                	exit3=true; 
                	break;
            }
    	}
        
    }

    // Méthode pour afficher les statistiques
    private static void gestionStatistiques(Scanner scanner, Statistics stats) {
    	boolean exit4 = false;
    	while(!exit4) {
    		 System.out.println("\n┌─────────────── STATISTIQUES ──────────────────┐");
    	        System.out.println("│ 1. Afficher le nombre total de téléchargements│");
    	        System.out.println("│ 2. Afficher le nombre total d'utilisateurs    │");
    	        System.out.println("│ 3. Afficher les images les plus téléchargées  │");
    	        System.out.println("│ 4. Afficher les téléchargements par catégorie │");
    	        System.out.println("│ 5. Afficher l'activité des utilisateurs       │");
    	        System.out.println("│ 0. Quitter                                    │");
    	        System.out.println("└───────────────────────────────────────────────┘");

    	        int option3 = getValidChoice(scanner, 0, 5);

    	        switch (option3) {
    	            case 1: System.out.println("\nTotal des téléchargements : " + stats.getTotalDownload()); break;
    	            case 2: System.out.println("\nNombre total d'utilisateurs : " + stats.getTotalUsers()); break;
    	            case 3: stats.showTop5Images(); break;
    	            case 4: stats.afficherImagesTelechargeesParCategorie(); break;
    	            case 5: stats.showUserActivity(); break;
    	            case 0:
                    	System.out.println("\nVous êtes de retour au menu principal !");
                    	exit4=true; 
                    	break;
    	            default: System.out.println("\nOption invalide. Veuillez réessayer.");
    	        }
    	}
       
    }

    // Méthode pour valider les choix utilisateur
    private static int getValidChoice(Scanner scanner, int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                System.out.print("\nVeuillez entrer un nombre entre " + min + " et " + max + ": ");
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