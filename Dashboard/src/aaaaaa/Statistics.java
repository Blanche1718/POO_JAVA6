package Stats;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




public class Statistics {
   
	//Attributs
	
    private int totalDownloads; // Nombre total de téléchargements
    private int totalUsers; // Nombre total d'utilisateurs

    private List <Image> mostDownloadedImages =  new ArrayList<>();
    private Map<String, Integer> downloadsByCategory;     // Map qui stocke le nombre de téléchargements par catégorie
    private Map<Image, Integer> likePerImage;
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
        this.likesPerImage = 0.0;
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
    
    public List<Image> getMostDownloadedImages() {  // Accéder à la liste des 5 images les plus téléchargées
        return mostDownloadedImages;
    }
    
    public int getTotalDownloads() {
        // Récupérer toutes les images (supposons qu'il existe une méthode getAllImages())
        List<Image> listImages = Image.getAllImages(); 
    
        // Calculer la somme des téléchargements pour toutes les images
        int totalDownloads = 0;
        for (Image image : listImages) {
        totalDownloads += image.getDownloads(); // Ajouter les téléchargements de chaque image
        }
    
        return totalDownloads; // Retourner le total des téléchargements
    }
    
    public int getTotalUsers() {
        // Récupérer toutes les Users(supposons qu'il existe une méthode getAllUsers())
        List<User> listUsers = User.getAllUsers(); 
        totalUsers = listUsers.size();

    }
    
    public Map<String, Integer> getDownloadsByCategory() {
        return new HashMap<>(downloadsByCategory);
    }
    
    public double getLikesPerImage() {
        return likesPerImage;
    }
    
    
    //Autres méthodes
    
    public void updateMostDownloadedImages() {  // Mettre à jour la liste des 5 images les plus téléchargées
    	// Récupérer toutes les images
    	List<Image> listImages = Image.getAllImages();  // getAllImages est une méthode de la classe Image
    	 // Trier les images par nombre de téléchargements (en ordre décroissant)
    	mostDownloadedImages = listImages.stream()  // Crée un Stream des images pour mieux pouvoir les manipuler
    			            .sorted(Comparator.comparingInt(Image::getDownloads).reversed()) //Trie par téléchargements (décroissant)
    			            .limit(5)  // Garde seulement les 5 premières images
    			            .collect(Collectors.toList()); // Convertit le Stream en une liste
    	
   }
    
   public void displayAllImages() {
    for (Image image : Image.getAllImages()) {
        System.out.println("Image ID :" +Image.getID() + ", Name :" + Image.getName());
    }
} 

    
    
    
    
  
    
    
}
