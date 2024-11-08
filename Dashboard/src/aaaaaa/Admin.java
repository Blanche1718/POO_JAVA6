package aaaaaa;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;


public class Admin extends User {
    private static List<Category> categories;
    private static List<User> users;
    private static List<Images> images;
    private boolean connected;

    public Admin(String username, String email) {
        super(username, email);
        categories = new ArrayList<>();
        users = new ArrayList<>();
        images = new ArrayList<>();
        connected = false;
    }

    // Create Category
    public void CreateCategory(Scanner scanner) {
        System.out.println("Entrez le nom de la nouvelle catégorie : ");
        String name = scanner.nextLine();
        
        System.out.println("Entrez la description de la nouvelle catégorie : ");
        String description = scanner.nextLine();

        Category newCategory = new Category(name, description);
        if (!categories.contains(newCategory)) {
            categories.add(newCategory);
            System.out.println("Catégorie créée : " + newCategory.getName());
        } else {
            System.out.println("La catégorie existe déjà.");
        }
    }

    // Edit Category
    public void EditCategory(Scanner scanner) {
        System.out.println("Liste des catégories disponibles :");
        for (Category category : categories) {
            System.out.println("- " + category.getName());
        }
        
        System.out.print("Entrez le nom de la catégorie que vous souhaitez modifier : ");
        String modName = scanner.nextLine();

        Category categoryToEdit = findCategoryByName(modName);
        if (categoryToEdit == null) {
            System.out.println("La catégorie '" + modName + "' n'existe pas.");
            return;
        }

        System.out.print("Entrez le nouveau nom de la catégorie (laisser vide pour conserver le nom actuel) : ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            categoryToEdit.set_name(newName);
        }

        System.out.print("Entrez la nouvelle description de la catégorie (laisser vide pour conserver la description actuelle) : ");
        String newDescription = scanner.nextLine();
        if (!newDescription.isEmpty()) {
            categoryToEdit.set_description(newDescription);
        }

        System.out.println("Les modifications ont été enregistrées pour la catégorie : " + categoryToEdit.getName());
    }

    // Delete Category
    public void DeleteCategory(Scanner scanner) {
        System.out.print("Entrez le nom de la catégorie que vous souhaitez supprimer : ");
        String deletedCategoryName = scanner.nextLine();

        Category categoryToDelete = findCategoryByName(deletedCategoryName);
        if (categoryToDelete != null) {
            categories.remove(categoryToDelete);
            System.out.println("Catégorie supprimée : " + deletedCategoryName);
        } else {
            System.out.println("La catégorie '" + deletedCategoryName + "' n'existe pas.");
        }
    }

    // List Categories
    public void CategoryList() {
        System.out.println("Liste des catégories disponibles :");
        for (Category category : categories) {
            System.out.println("- " + category.getName());
        }
    }

    // Create User
    public void CreateUser(Scanner scanner) {
        System.out.print("Entrez le nom du nouvel utilisateur : ");
        String newUsername = scanner.nextLine();
        
        System.out.println("Entrez l'email : ");
        String email = scanner.nextLine();

        if (findUserByEmail(email) == null) { 
            User newUser = new User(newUsername, email);
            users.add(newUser);
            System.out.println("Utilisateur créé : " + newUser.getUsername());
        } else {
            System.out.println("L'utilisateur existe déjà.");
        }
    }

    // Edit User
    public void EditUser(Scanner scanner) {
        System.out.println("Liste des utilisateurs disponibles :");
        for (User user : users) {
            System.out.println("- " + user.getUsername());
        }

        System.out.print("Entrez le nom de l'utilisateur que vous souhaitez modifier : ");
        String modUsername = scanner.nextLine();

        User userToEdit = findUserByUsername(modUsername);
        if (userToEdit == null) {
            System.out.println("L'utilisateur '" + modUsername + "' n'existe pas.");
            return;
        }

        System.out.print("Entrez le nouveau nom de l'utilisateur (laisser vide pour conserver le nom actuel) : ");
        String newUsername = scanner.nextLine();
        if (!newUsername.isEmpty()) {
            userToEdit.setUsername(newUsername);
        }

        System.out.print("Entrez le nouveau email de l'utilisateur (laisser vide pour conserver l'email actuel) : ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            userToEdit.setEmail(newEmail);
        }

        System.out.println("Les modifications ont été enregistrées pour l'utilisateur : " + userToEdit.getUsername());
    }

    // Delete User
    public void DeleteUser(Scanner scanner) {
        System.out.print("Entrez le nom de l'utilisateur que vous souhaitez supprimer : ");
        String deletedUserName = scanner.nextLine();

        User userToDelete = findUserByUsername(deletedUserName);
        if (userToDelete != null) {
            users.remove(userToDelete);
            System.out.println("Utilisateur supprimé : " + deletedUserName);
        } else {
            System.out.println("L'utilisateur '" + deletedUserName + "' n'existe pas.");
        }
    }

    // List Users
    public void UserList() {
        System.out.println("Liste des utilisateurs disponibles :");
        for (User user : users) {
            System.out.println("- " + user.getUsername());
        }
    }

    // Suspend User
    public void Suspend(Scanner scanner) {
        System.out.println("Liste des utilisateurs disponibles :");
        for (User user : users) {
            System.out.println("- " + user.getUsername() + " - " + user.getEmail());
        }

        System.out.print("Entrez l'email de l'utilisateur à suspendre : ");
        String suspEmail = scanner.nextLine();

        User userToSuspend = findUserByEmail(suspEmail);
        if (userToSuspend != null) {
            userToSuspend.setRestricted();
            System.out.println("L'utilisateur " + userToSuspend.getUsername() + " est suspendu.");
        } else {
            System.out.println("Cet utilisateur n'existe pas");
        }
    }

    // Create Image
    public void CreateImage(Scanner scanner) {
        System.out.println("Entrez le nom de la nouvelle image : ");
        String name = scanner.nextLine();

        System.out.print("Entrez le titre de l'image : ");
        String title = scanner.nextLine();

        System.out.println("Entrez la description de l'image : ");
        String description = scanner.nextLine();

        Images newImage = new Images(name, title, description, true);
        if (!images.contains(newImage)) {
            images.add(newImage);
            System.out.println("Image créée : " + newImage.getName());
        } else {
            System.out.println("L'image existe déjà.");
        }
    }

    // User Login
    public void Connect(Scanner scanner) {
        System.out.println("Entrez votre email");
        String mail = scanner.nextLine();
        User connectedUser = findUserByEmail(mail);

        if (connectedUser == null) {
            System.out.println("Cet utilisateur n'existe pas");
            return;
        } else if (connectedUser.isRestricted()) {
            System.out.println("L'utilisateur est suspendu");
            return;
        }

        System.out.println("L'utilisateur '" + connectedUser.getEmail() + "' est connecté.");
        connected = true;

        while (connected) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Télécharger une image");
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
                    downloadImage(scanner, connectedUser);
                    break;
                case 2:
                    addImageToFavorites(scanner, connectedUser);
                    break;
                case 3:
                    likeImage(scanner, connectedUser);
                    break;
                case 4:
                    connectedUser.showGalerie();
                    break;
                case 5:
                    connectedUser.showFavorites();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    connected = false;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    // Helper methods
    private Category findCategoryByName(String name) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(name)) {
                return category;
            }
        }
        return null;
    }

    private User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    private User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    private Images findImageByName(String name) {
        for (Images image : images) {
            if (image.getName().equalsIgnoreCase(name)) {
                return image;
            }
        }
        return null;
    }

    private void downloadImage(Scanner scanner, User user) {
        System.out.println("Liste des images disponibles :");
        for (Images image : images) {
            System.out.println("- " + image.getName());
        }
        System.out.print("Entrez le nom de l'image à télécharger : ");
        String downloadImageName = scanner.nextLine();

        Images imageToDownload = findImageByName(downloadImageName);
        if (imageToDownload != null) {
            user.addImage(imageToDownload);
        } else {
            System.out.println("Cette image n'existe pas");
        }
    }

    private void addImageToFavorites(Scanner scanner, User user) {
        System.out.print("Entrez le nom de l'image à ajouter aux favoris : ");
        String favoriteImageName = scanner.nextLine();

        Images imageToFavorite = findImageByName(favoriteImageName);
        if (imageToFavorite != null) {
            user.addFavorite(imageToFavorite);
        } else {
            System.out.println("Cette image n'existe pas");
        }
    }

    private void likeImage(Scanner scanner, User user) {
        System.out.print("Entrez le nom de l'image à liker : ");
        String likeImageName = scanner.nextLine();

        Images likeToFavorite = findImageByName(likeImageName);
        if (likeToFavorite != null) {
            user.addLike(likeToFavorite);
        } else {
            System.out.println("Cette image n'existe pas");
        }
    }
    
    
    
    
    // Méthode pour afficher les statistiques de manière stylisée
    public void displayStatistics() {
        Statistics stats = Statistics.getInstance();  // Obtenir l'instance unique de Statistics

        // Début de l'encadré
        System.out.println("********** STATISTICS **********");

        // Afficher le nombre total de téléchargements
        System.out.println("* Total Downloads: " + stats.getTotalDownloads() + "          *");

        // Afficher le nombre total d'utilisateurs
        System.out.println("* Total Users: " + stats.getTotalUsers() + "                  *");

        // Afficher les cinq images les plus téléchargées
        System.out.println("* Most Downloaded Images:        *");
        for (Images img : stats.getMostDownloadedImages()) {
            System.out.println("* - " + img.getName() + ": " + img.getDownloads() + " downloads    *");
        }

        // Afficher les téléchargements par catégorie
        System.out.println("* Downloads by Category:         *");
        for (Map.Entry<String, Integer> entry : stats.getDownloadsByCategory(Category.getAllCategories()).entrySet()) {
            System.out.println("* - " + entry.getKey() + ": " + entry.getValue() + " downloads    *");
        }

        // Afficher les likes par image
        System.out.println("* Likes per Image:               *");
        for (Map.Entry<String, Integer> entry : stats.getLikesPerImage().entrySet()) {
            System.out.println("* - " + entry.getKey() + ": " + entry.getValue() + " likes       *");
        }

        // Fin de l'encadré
        System.out.println("**********************************");
    }
}
