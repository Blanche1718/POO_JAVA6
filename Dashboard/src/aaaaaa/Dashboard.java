package aaaaaa;

import java.util.Scanner;

public class Dashboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Admin admin = new Admin("Admin", "admin@example.com");
        admin.loadUsersFromCSV();
        admin.loadCategoriesFromCSV();
        admin.loadImagesFromCSV();
        admin.initializeFiles();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Gestion de catégories");
            System.out.println("2. Gestion des utilisateurs");
            System.out.println("3. Ajouter une image");
            System.out.println("4. Afficher les statistiques de la plateforme");
            System.out.println("0. Quitter");

            System.out.print("Sélectionnez une option : ");
            int choix = getValidChoice(scanner, 0, 4);  // Utilisation de la méthode getValidChoice

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
                case 0:
                	admin.disconnect();
                    System.out.println("Au revoir !");
                    exit = true;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }

    // Méthode pour gérer les catégories
    private static void gestionCategories(Scanner scanner, Admin admin) {
        System.out.println("1. Ajouter une catégorie");
        System.out.println("2. Editer une catégorie");
        System.out.println("3. Supprimer une catégorie");
        System.out.println("4. Consulter la liste des catégories");
        System.out.println("0. Quitter");

        int option1 = getValidChoice(scanner, 0, 4);
        
        switch (option1) {
            case 1: admin.CreateCategory(scanner); break;
            case 2: admin.EditCategory(scanner); break;
            case 3: admin.DeleteCategory(scanner); break;
            case 4: admin.CategoryList(); break;
            case 0: break;
        }
    }

    // Méthode pour gérer les utilisateurs
    private static void gestionUtilisateurs(Scanner scanner, Admin admin) {
        System.out.println("1. Ajouter un utilisateur");
        System.out.println("2. Editer un utilisateur");
        System.out.println("3. Supprimer un utilisateur");
        System.out.println("4. Suspendre un utilisateur");
        System.out.println("5. Consulter la liste des utilisateurs");
        System.out.println("6. Connecter un utilisateur");
        System.out.println("0. Quitter");

        int option2 = getValidChoice(scanner, 0, 6);

        switch (option2) {
            case 1: admin.CreateUser(scanner); break;
            case 2: admin.EditUser(scanner); break;
            case 3: admin.DeleteUser(scanner); break;
            case 4: admin.Suspend(scanner); break;
            case 5: admin.UserList(); break;
            case 6: admin.Connect(scanner); break;
            case 0: break;
        }
    }
    
    private static int getValidChoice(Scanner scanner, int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                System.out.print("Entrez un nombre entre " + min + " et " + max + ": ");
                choice = scanner.nextInt();
                if (choice < min || choice > max) {
                    System.out.println("Veuillez entrer un nombre valide.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.nextLine();  // Consomme l'entrée invalide
            }
        }
        scanner.nextLine();  // Consomme le caractère de nouvelle ligne laissé par nextInt()
        return choice;
    }

}
