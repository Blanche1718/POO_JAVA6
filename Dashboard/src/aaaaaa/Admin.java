package aaaaaa;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    private static List<Category> categories;
    private static List<User> users;
    private static List<Images> images;
    private static List<Images> images_soumises;
    private boolean connected;
    private final String userFilePath = "users.csv";
    private final String categoryFilePath = "categories.csv";
    private final String imageFilePath = "images.csv";
    private final String imagesoumisesFilePath = "images_soumises.csv";

    public Admin(String username, String email) {
        super(username, email);
        categories = new ArrayList<>();
        users = new ArrayList<>();
        images = new ArrayList<>();
        images_soumises = new ArrayList<>();
        connected = false;
        initializeFiles();
        initData();
    }
    public void initData() {
        loadUsersFromCSV();
        loadCategoriesFromCSV();
        loadImagesFromCSV();
        loadImagesSoumisesFromCSV();
    }
    
    public void saveAllData() {
        saveUsersToCSV();
        saveCategoriesToCSV();
        saveImagesToCSV();
        saveImagesSoumisesToCSV();
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
            saveAllData();
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
        saveAllData();
    }

    // Delete Category
    public void DeleteCategory(Scanner scanner) {
    	
    	System.out.println("Liste des catégories disponibles :");
        for (Category category : categories) {
            System.out.println("- " + category.getName());
        }
        
        System.out.print("Entrez le nom de la catégorie que vous souhaitez supprimer : ");
        String deletedCategoryName = scanner.nextLine();

        Category categoryToDelete = findCategoryByName(deletedCategoryName);
        if (categoryToDelete != null) {
            categories.remove(categoryToDelete);
            System.out.println("Catégorie supprimée : " + deletedCategoryName);
            saveAllData();
        } else {
            System.out.println("La catégorie '" + deletedCategoryName + "' n'existe pas.");
        }
    }

    // List Categories
    public void CategoryList() {
        System.out.println("Liste des catégories disponibles :");
        if (categories.isEmpty()) {
            System.out.println("Aucune catégorie trouvée.");
        } else {
            for (Category category : categories) {
                System.out.printf("Nom: %s, Description: %s%n", category.getName(), category.getDescription());
            }
        }
    }
    
    //Put Images in categories
    public void AddImagetoCategory(Scanner scanner)
    {
    	CategoryList();
    	System.out.println("Choisissez la categorie");
    	String catName = scanner.nextLine();
    	Category newCategory = findCategoryByName(catName);
    	
    	if(newCategory == null)
    	{
    		System.out.println("Cette categorie n'existe pas");
    		return;
    	}
    	
    	ImagesList();
    	System.out.println("Choisissez l'image");
    	String ImgName = scanner.nextLine();
    	Images newImage = findImageByName(ImgName);
    	
    	if(newImage == null)
    	{
    		System.out.println("Cette image n'existe pas");
    		return;
    	}
    	
    	List<Images> liImage = newCategory.getImages(); 
    	
    	boolean imageExists = false;
    	for(Images image : liImage)
    	{
    		if(image.getName().equals(ImgName)) {
    			imageExists = true;
            	break; 
            	}
    	}
    		
    	if (imageExists) {
            System.out.println("L'image est déjà dans la catégorie.");
        } else {
            newCategory.addImage(newImage);
            System.out.println("Image " + newImage.getName() + " ajoutée à " + newCategory.getName() );
        	saveAllData();
        	}
    	
    }
    
    //Afficher les images d'une categorie
    public void ShowImageinCategory(Scanner scanner)
    {
    	CategoryList();
    	System.out.println("Entrez le nom de  la categorie");
    	String catName = scanner.nextLine();
    	Category newCategory = findCategoryByName(catName);
    	
    	if(newCategory == null)
    	{
    		System.out.println("Cette categorie n'existe pas");
    	}
    	
    	System.out.println("Liste des images dans " + newCategory.getName());
    	
    	for(Images image : newCategory.getImages())
    	{
    		System.out.println("-" + image.getName());
    	}
    }

    
    
    
      
    // Create User
    public void CreateUser(Scanner scanner) {
        System.out.print("Entrez le nom du nouvel utilisateur : ");
        String newUsername = scanner.nextLine();
        
        System.out.println("Entrez l'email : ");
        String email = scanner.nextLine();

        if (findUserByEmail(email) == null && findUserByUsername(newUsername) == null)  { 
            User newUser = new User(newUsername, email);
            users.add(newUser);
            
            System.out.println("Utilisateur créé : " + newUser.getUsername());
            saveAllData();
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
        saveAllData();
    }

    // Delete User
    public void DeleteUser(Scanner scanner) {
        System.out.print("Entrez le nom de l'utilisateur que vous souhaitez supprimer : ");
        String deletedUserName = scanner.nextLine();

        User userToDelete = findUserByUsername(deletedUserName);
        if (userToDelete != null) {
            users.remove(userToDelete);
            System.out.println("Utilisateur supprimé : " + deletedUserName);
            saveAllData();
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
    public void ImagesList() {
        System.out.println("Liste des images disponibles :");
        for (Images image : images) {
            System.out.println("- " + image.getName());
        }
    }
    
 // List Images soumises
    public void ImagessoumisesList() {
    	System.out.println("Liste des Images soumises :");
        for (Images image : images_soumises) {
            System.out.println("- " + image.getName());
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
            userToSuspend.setRestricted(true);
            System.out.println("L'utilisateur " + userToSuspend.getUsername() + " est suspendu.");
            saveAllData();
        } else {
            System.out.println("Cet utilisateur n'existe pas");
        }
    }
    
    public void removeSuspension(Scanner scanner) {
    	System.out.println("Liste des utilisateurs disponibles :");
        for (User user : users) {
            System.out.println("- " + user.getUsername() + " - " + user.getEmail());
        }

        System.out.print("Entrez l'email de l'utilisateur à desuspendre : ");
        String desuspEmail = scanner.nextLine();

        User userTodesuspend = findUserByEmail(desuspEmail);
        if (userTodesuspend == null) {
            System.out.println("Utilisateur introuvable.");
            return;
        }
        
        if (!userTodesuspend.isRestricted()) {
            System.out.println("Cet utilisateur n'est pas suspendu.");
            return;
        }
        
        userTodesuspend.setRestricted(false); // Lever la suspension
        System.out.println("La suspension de l'utilisateur " + desuspEmail + " a été levée.");
        
        saveUsersToCSV(); // Sauvegarder les modifications dans le fichier CSV
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
            saveAllData();
        } else {
            System.out.println("L'image existe déjà.");
        }
    }

    //Submit Image User
    public void SubmitImage(Scanner scanner,User connectuser) {
    	System.out.println("Entrez le nom de la nouvelle image : ");
        String name = scanner.nextLine();

        System.out.print("Entrez le titre de l'image : ");
        String title = scanner.nextLine();

        System.out.println("Entrez la description de l'image : ");
        String description = scanner.nextLine();

        Images newImage = new Images(name, title, description, false);
        
        if (!images_soumises.contains(newImage)) {
        	connectuser.subImages(newImage);
        	images_soumises.add(newImage);
        	System.out.println("Cette image a été bien soumise.");
        	saveAllData();
        } else {
            System.out.println("Cette image a déjà été soumise.");
        }
    	
    }
    
    //Approuver image 
    void Approve_image(Scanner scanner) {
    	boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Images soumises ---");
            System.out.println("1. Approuver une image");
            System.out.println("2. Desapprouver une image");
            System.out.println("0. Quitter");

            System.out.print("Sélectionnez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            
            switch (choix) {
            case 1:
            	ImagessoumisesList();
            	System.out.print("Entrez le nom de l'image a approuver : ");
            	String aproImage = scanner.nextLine();
            	Images imagetoEdit = findImageSoumiseByName(aproImage); 
            	
            	if ( imagetoEdit == null) {
                    System.out.println("L'image '" + aproImage + "' n'existe pas.");
                    return;
                }
            	
            	images.add(imagetoEdit);
            	images_soumises.remove(imagetoEdit);
            	System.out.println("L'image " + imagetoEdit.getName() + " a été bien approuvée");
            	saveAllData();
            	break;
            case 2:
            	ImagessoumisesList();
            	System.out.print("Entrez le nom de l\'image a rejeter : ");
            	String aprovImage = scanner.nextLine();
            	Images imgtoEdit = findImageSoumiseByName(aprovImage); 
            	
            	if ( imgtoEdit == null) {
                    System.out.println("L'image '" + aprovImage + "' n'existe pas.");
                    return;
                }
            	
            	images_soumises.remove(imgtoEdit);
            	System.out.println("L'image " + imgtoEdit.getName() + " a été bien rejetée");
            	saveAllData();
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

    
    // User Login
    public void Connect(Scanner scanner) {
        System.out.println("Entrez votre email");
        String mail = scanner.nextLine();
        User connectedUser = findUserByEmail(mail);

        if (connectedUser == null) {
            System.out.println("Cet utilisateur n'existe pas");
            return;
        } else if (connectedUser.isRestricted()==true) {
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
            System.out.println("6. Soummettre une image");
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
                case 6:
                	SubmitImage(scanner,connectedUser);
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
    
    private Images findImageSoumiseByName(String name) {
        for (Images image : images_soumises) {
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
            System.out.println("L'image a été bien télécharger");
        } else {
            System.out.println("Cette image n'existe pas");
        }
    }

    private void addImageToFavorites(Scanner scanner, User user) {
    	 System.out.println("Liste des images disponibles :");
         for (Images image : images) {
             System.out.println("- " + image.getName());
         }
        System.out.print("Entrez le nom de l'image à ajouter aux favoris : ");
        String favoriteImageName = scanner.nextLine();

        Images imageToFavorite = findImageByName(favoriteImageName);
        if (imageToFavorite != null) {
            user.addFavorite(imageToFavorite);
            System.out.println("L'image a été bien ajouté aux favoris");
        } else {
            System.out.println("Cette image n'existe pas");
        }
    }

    private void likeImage(Scanner scanner, User user) {
    	 System.out.println("Liste des images disponibles :");
         for (Images image : images) {
             System.out.println("- " + image.getName());
         }
        System.out.print("Entrez le nom de l'image à liker : ");
        String likeImageName = scanner.nextLine();

        Images likeToFavorite = findImageByName(likeImageName);
        if (likeToFavorite != null) {
            user.addLike(likeToFavorite);
            
        } else {
            System.out.println("Cette image n'existe pas");
        }
    }
    
    
    
    public void saveUsersToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("users.csv"))) {
            writer.println("ID,Username,Email,Restricted"); // En-tête du fichier CSV
            for (User user : users) {
                writer.write(user.getIdUser() + "," + user.getUsername() + "," +
                             user.getEmail() + "," + user.isRestricted() + "\n");
            }
            System.out.println("Les utilisateurs ont été sauvegardés dans users.csv.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des utilisateurs : " + e.getMessage());
        }
    }
    
    public void saveCategoriesToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("categories.csv"))) {
            writer.println("Name,Description,Images"); // En-tête avec une colonne pour les images
            for (Category category : categories) {
                StringBuilder imageNames = new StringBuilder();
                List<Images> images = category.getImages();
                for (Images image : images) {
                    imageNames.append(image.getName()).append(";"); // Séparer les noms d'images par un point-virgule
                }
                if (imageNames.length() > 0) {
                    imageNames.deleteCharAt(imageNames.length() - 1); // Supprimer le dernier point-virgule
                }

                writer.printf("%s,%s,%s%n", category.getName(), category.getDescription(), imageNames.toString());
            }
            System.out.println("Les catégories et les images ont été sauvegardées dans categories.csv.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des catégories : " + e.getMessage());
        }
    }


    
    public void saveImagesToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("images.csv"))) {
            writer.println("Name,Title,Description"); // En-tête
            for (Images image : images) {
                writer.printf("%s,%s,%s%n", image.getName(), image.getTitle(), image.getDescription());
            }
            System.out.println("Les images ont été sauvegardées dans images.csv.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des images : " + e.getMessage());
        }
    }
    
    public void saveImagesSoumisesToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("images_soumises.csv"))) {
            writer.println("Name,Title,Description"); // En-tête
            for (Images image : images_soumises) {
                writer.printf("%s,%s,%s%n", image.getName(), image.getTitle(), image.getDescription());
            }
            System.out.println("Les images ont été sauvegardées dans images_soumises.csv.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des images : " + e.getMessage());
        }
    }
    
    
    public void loadUsersFromCSV() {
    	users.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("users.csv"))) {
            String line = reader.readLine(); // Ignorer l'en-tête
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String username = fields[1];
                String email = fields[2];
                boolean restricted = Boolean.parseBoolean(fields[3]);
                
                User user = new User(username, email);
                user.setRestricted(restricted); // Ajuster en fonction de ta classe
                users.add(user);
            }
            //System.out.println("Les utilisateurs ont été chargés depuis users.csv.");
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des utilisateurs : " + e.getMessage());
        }
    }
    
    public void loadCategoriesFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader("categories.csv"))) {
            String line = reader.readLine(); // Lire l'en-tête
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1); // -1 pour inclure les champs vides
                String name = parts[0];
                String description = parts[1];
                String[] imageNames = parts.length > 2 ? parts[2].split(";") : new String[0];

                // Vérifier si la catégorie existe déjà dans la liste
                boolean categoryExists = false;
                for (Category category : categories) {
                    if (category.getName().equals(name)) {
                        categoryExists = true;
                        break;
                    }
                }

                // Si la catégorie n'existe pas, on l'ajoute
                Category category;
                if (!categoryExists) {
                    category = new Category(name, description);
                    categories.add(category);
                } else {
                    // Si la catégorie existe déjà, on récupère l'instance existante
                    category = findCategoryByName(name);
                }

                // Ajouter les images associées à la catégorie
                for (String imageName : imageNames) {
                    Images image = findImageByName(imageName);
                    if (image != null && !category.getImages().contains(image)) {
                        category.addImage(image);
                    }
                }
            }

            System.out.println("Les catégories et les images ont été chargées depuis categories.csv.");
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des catégories : " + e.getMessage());
        }
    }


    
    public void loadImagesFromCSV() {
    	images.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("images.csv"))) {
            String line = reader.readLine(); // Ignorer l'en-tête
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String title = fields[1];
                String description = fields[2];
                
                Images image = new Images(name, title, description, true); // Ajuster selon ton constructeur
                images.add(image);
            }
           // System.out.println("Les images ont été chargées depuis images.csv.");
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des images : " + e.getMessage());
        }
    }
    
    
    public void loadImagesSoumisesFromCSV() {
    	images_soumises.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("images_soumises.csv"))) {
            String line = reader.readLine(); // Ignorer l'en-tête
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String title = fields[1];
                String description = fields[2];
                
                Images image = new Images(name, title, description, true); // Ajuster selon ton constructeur
                images_soumises.add(image);
            }
           // System.out.println("Les images ont été chargées depuis images.csv.");
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des images soumises : " + e.getMessage());
        }
    }


    
    public void initializeFiles() {
        createFileIfNotExists(userFilePath);
        createFileIfNotExists(categoryFilePath);
        createFileIfNotExists(imageFilePath);
        createFileIfNotExists(imagesoumisesFilePath);
    }

    private void createFileIfNotExists(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile(); // Crée le fichier s'il n'existe pas
                //System.out.println("Fichier créé : " + filePath);
            } else {
                //System.out.println("Fichier déjà existant : " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + filePath);
            e.printStackTrace();
        }
    }
    
    
    public void disconnect() {
        saveAllData(); // Sauvegarde toutes les données avant de se déconnecter
        connected = false;
        System.out.println("Déconnecté avec succès.");
    }
    
   

}



















