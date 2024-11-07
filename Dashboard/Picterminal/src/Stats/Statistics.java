package Stats;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;




public class Statistics {
   
	//Attributs
	
    private int totalDownloads; // Nombre total de téléchargements
    private int totalUsers; // Nombre total d'utilisateurs

    private List <Image> mostDownloadedImages =  new ArrayList<>();
    private Map<String, Integer> downloadsByCategory;     // Map qui stocke le nombre de téléchargements par catégorie
    private double likesPerImage;     // Moyenne des likes par image
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
        return totalDownloads;
    }
    
    public int getTotalUsers() {
        return totalUsers;
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
    
    

    /**
     * Met à jour le nombre total d'utilisateurs
     * @param count Le nouveau nombre total d'utilisateurs
     */
    public void setTotalUsers(int count) {
        this.totalUsers = count;
    }
    
    /**
     * Met à jour le nombre de téléchargements pour une catégorie
     * @param category La catégorie à mettre à jour 
     * @param count Le nombre de téléchargements
     */
    public void updateCategoryDownloads(String category, int count) {
        this.downloadsByCategory.put(category, count);
    }
    
    /**
     * Calcule la moyenne des likes par image
     * @param totalLikes Le nombre total de likes
     * @throws IllegalStateException si totalUploads est 0
     */
    public void calculateLikesPerImage(int totalLikes) {
        if (this.totalUploads == 0) {
            throw new IllegalStateException("Le nombre total d'uploads ne peut pas être 0");
        }
        this.likesPerImage = (double) totalLikes / this.totalUploads;
    }
    
    // Getters
    
  
    
    public void displayAllImages() {
    	for (Image image : Image.getAllImages()) {
    		System.out.println("Image ID :" +Image.getID() + ", Name :" + Image.getName());
    	}
    }
}
