package aaaaaa;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;



public class Statistics {
    
	//Attributs
	
    private int totalDownloads; // Nombre total de téléchargements
    private int totalUsers; // Nombre total d'utilisateurs

    private List <Images> mostDownloadedImages =  new ArrayList<>();
    private Map<String, Integer> downloadsByCategory;     // Map qui stocke le nombre de téléchargements par catégorie
    private Map<String, Integer> likePerImage;
    private static Statistics instance;  // Attribut static pour stocker l'instance unique de la classe
    /* L'attribut "instance" est un attribut static qui contient l'instance unique de la classe Statistics.
     *  Il est déclaré private pour empêcher l'accès direct en dehors de la classe.
     */
    
    
    
    
    // Constructeur
     
    private Statistics() {  // Le constructeur est privé pour empêcher l'instanciation directe en dehors de la classe
        this.totalDownloads = 0;
        this.totalUsers = 0;
        this.mostDownloadedImages = new ArrayList<>();
        this.downloadsByCategory = new HashMap<>(); 
        this.likePerImage = new HashMap<>();
    }
    
   
    
    //Getteurs-Acesseurs
    
   
    public static Statistics getInstance() { // Méthode pour récupérer l'instance unique de Statistics
        // Si l'instance n'existe pas encore, on la crée
        if (instance == null) {
            instance = new Statistics();
        }
        // Retourne l'instance unique
        return instance;
    }
    
    public List<Images> getMostDownloadedImages() {  // Accéder à la liste des 5 images les plus téléchargées
    	// Récupérer toutes les images
    	List<Images> listImages = Images.getAllImages();  // getAllImages est une méthode de la classe Image
    	 // Trier les images par nombre de téléchargements (en ordre décroissant)
    	mostDownloadedImages = listImages.stream()  // Crée un Stream des images pour mieux pouvoir les manipuler
    			            .sorted(Comparator.comparingInt(Images::getDownloads).reversed()) //Trie par téléchargements (décroissant)
    			            .limit(5)  // Garde seulement les 5 premières images
    			            .collect(Collectors.toList()); // Convertit le Stream en une liste
    	
        return mostDownloadedImages;
    }
    
    public int getTotalDownloads() {
        List<Images> listImages = Images.getAllImages();
        this.totalDownloads = listImages.stream().mapToInt(Images::getDownloads).sum();
        return this.totalDownloads;
    }
   
    
    public int getTotalUsers() {
        // Récupérer toutes les Users(supposons qu'il existe une méthode getAllUsers())
        List<User> listUsers = User.getAllUsers(); 
        totalUsers = listUsers.size();
        return totalUsers;
    }
    
    // Méthode pour calculer et mettre à jour les téléchargements pour chaque catégorie
    public Map<String, Integer> getDownloadsByCategory(List<Category> categories) {
        //downloadsByCategory.clear(); // Effacer les anciennes valeurs

        // Parcourir chaque catégorie
        for (Category category : categories) {
            int totalUploads = 0; // Initialiser le compteur de téléchargements pour cette catégorie

            // Parcourir toutes les images de la catégorie pour accumuler les téléchargements
            for (Images image : category.getImages()) {
                totalUploads += image.getDownloads(); // Ajouter les téléchargements de cette image
            } 

            // Associer la catégorie avec son total de téléchargements dans la HashMap
            downloadsByCategory.put(category.getName(), totalUploads);
        }
        
        // Retourner la HashMap avec tous les résultats
        return downloadsByCategory;
    }
    
    public Map<String, Integer> getLikesPerImage() {
        // Récupérer toutes les images
        List<Images> listImages = Images.getAllImages();

        // Parcourir les images et remplir la map avec le nom de chaque image et son nombre de likes
        for (Images image : listImages) {
            likePerImage.put(image.getName(), image.getLikes());
        }

        return likePerImage;
    }
    
    
    
    //Autres méthodes 
    
    
    public void displayAllImages() { //Afficher toutes les images
    	for (Images image : Images.getAllImages()) {
    		image.showDetails();
    	}
    }
    
    public void displayAllUsers() { // Afficher tous les utilisateurs
    	for (User user : User.getAllUsers()) {
    		user.showUserDetails();
    	}
    }
    
  
 
    
    
    public void displayLikesByImage() {// Afficher toutes les images et leur nombres de likes
        // Parcourir chaque entrée dans la Map likesByImageName
        for (Map.Entry<String, Integer> entry : likePerImage.entrySet()) {
            // entry représente chaque "paire clé-valeur" de la Map
            // entry.getKey() est le nom de l'image (la clé)
            // entry.getValue() est le nombre de likes de cette image (la valeur)
            
            // Afficher le nom de l'image et son nombre de likes
            System.out.println("Image Name: " + entry.getKey() + ", Likes: " + entry.getValue());
        }
    }

     
   
} 
   

    
    
    
    
  
    
    

