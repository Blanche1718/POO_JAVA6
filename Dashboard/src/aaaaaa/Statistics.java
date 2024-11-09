package aaaaaa;
import java.util.ArrayList;
import java.util.List;




public class Statistics {
   
	//Attributs
	private Admin admin; 
    private int totalDownloads; // Nombre total de téléchargements
    private int totalUsers; // Nombre total d'utilisateurs
    private List <Images> mostDownloadedImages =  new ArrayList<>();
   // private Map<String, Integer> downloadsByCategory;     // Map qui stocke le nombre de téléchargements par catégorie
    //private Map<Images, Integer> likePerImage;
     // Attribut static pour stocker l'instance unique de la classe
    /* L'attribut "instance" est un attribut static qui contient l'instance unique de la classe Statistics.
     *  Il est déclaré private pour empêcher l'accès direct en dehors de la classe.
     */
 
    
    
    // Constructeur
    
    public Statistics(Admin admin) {  // Le constructeur est privé pour empêcher l'instanciation directe en dehors de la classe
    	this.admin = admin;
    	this.totalDownloads = 0;
        this.totalUsers = 0;
        this.mostDownloadedImages = new ArrayList<>();
        /*this.downloadsByCategory = new HashMap<>(); 
        this.likePerImage = 0.0;*/
    }
   
   
   /* public static Statistics getInstance() { // Méthode pour récupérer l'instance unique de Statistics
        // Si l'instance n'existe pas encore, on la crée
        if (instance == null) {
            instance = new Statistics(admin);
        }
        // Retourne l'instance unique
        return instance;
    }*/
    
    
    public int getTotalUsers() {
        List<User> users = admin.getTotalUsers(); 
        totalUsers = users.size(); 
        return totalUsers;
    }
    
    public int getTotalDownload() {
        // Récupérer toutes les images (supposons qu'il existe une méthode getAllImages())
        List<Images> images_téléchargées = admin.getTotalDownload(); 
        totalDownloads = images_téléchargées.size(); // Ajouter les téléchargements de chaque image
    
        return totalDownloads; // Retourner le total des téléchargements
    }
    
    
    public List<Images> getTop5Images() {
        return admin.getTop5Images();  // Appeler la méthode de Admin
    }
     
     public void showTop5Images() {
         List<Images> top5Images = getTop5Images();
         System.out.println("Top 5 des images les plus téléchargées : ");
         for (Images image : top5Images) {
             System.out.println(image);
         }
     }
    
    
   
    
    /*public Map<String, Integer> getDownloadsByCategory() {
        return new HashMap<>(downloadsByCategory);
    }
    
    public double getLikesPerImage() {
        return likePerImage;
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



public void updateUserActivity() {
	// TODO Auto-generated method stub
	
} */

    
    
    
    
  
    
    
}
