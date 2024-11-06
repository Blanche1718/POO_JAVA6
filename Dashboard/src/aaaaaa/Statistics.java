package aaaaaa;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Statistics {
   
    private int totalUploads;
    private int totalUsers;
    
    /**
     * Classe interne pour stocker les informations d'une image
     * Implement Comparable pour pouvoir trier les images par nombre de téléchargements
     */
    private static class ImageStats implements Comparable<ImageStats> {
        private String id;
        private String title;
        private int downloads;
        
        public ImageStats(String id, String title, int downloads) {
            this.id = id;
            this.title = title;
            this.downloads = downloads;
        }
        
        @Override
        public int compareTo(ImageStats other) {
            // Ordre décroissant pour avoir les plus téléchargées en premier
            return Integer.compare(other.downloads, this.downloads);
        }
    }
    
    // File de priorité limitée aux 5 images les plus téléchargées
    private PriorityQueue<ImageStats> mostDownloadedImages;
    private static final int MAX_TOP_IMAGES = 5;
    
    // Map qui stocke le nombre de téléchargements par catégorie
    private Map<String, Integer> downloadsByCategory;
    
    // Moyenne des likes par image
    private double likesPerImage;
    
    /**
     * Constructeur de la classe Statistics
     * Initialise les différents attributs avec des valeurs par défaut
     */
    public Statistics() {
        this.totalUploads = 0;
        this.totalUsers = 0;
        this.mostDownloadedImages = new PriorityQueue<>();
        this.downloadsByCategory = new HashMap<>();
        this.likesPerImage = 0.0;
    }
    
    /**
     * Met à jour les statistiques d'une image et maintient à jour le top 5
     * @param id L'identifiant de l'image
     * @param title Le titre de l'image
     * @param downloads Le nombre de téléchargements
     */
    public void updateImageStats(String id, String title, int downloads) {
        // Créer une nouvelle instance d'ImageStats
        ImageStats newImage = new ImageStats(id, title, downloads);
        
        // Retirer l'ancienne version de cette image si elle existe
        mostDownloadedImages.removeIf(img -> img.id.equals(id));
        
        // Ajouter la nouvelle version
        mostDownloadedImages.offer(newImage);
        
        // Maintenir seulement les 5 meilleures images
        while (mostDownloadedImages.size() > MAX_TOP_IMAGES) {
            mostDownloadedImages.poll();
        }
    }
    
    /**
     * Retourne les 5 images les plus téléchargées, triées par nombre de téléchargements décroissant
     * @return Une liste de Maps contenant les informations des images
     */
    public List<Map<String, Object>> getTopDownloadedImages() {
        List<Map<String, Object>> result = new ArrayList<>();
        List<ImageStats> sortedImages = new ArrayList<>(mostDownloadedImages);
        Collections.sort(sortedImages); // Trie selon compareTo défini dans ImageStats
        
        for (ImageStats img : sortedImages) {
            Map<String, Object> imageInfo = new HashMap<>();
            imageInfo.put("id", img.id);
            imageInfo.put("title", img.title);
            imageInfo.put("downloads", img.downloads);
            result.add(imageInfo);
        }
        
        return result;
    }
    
    /**
     * Met à jour le nombre total d'uploads
     * @param count Le nouveau nombre total d'uploads
     */
    public void setTotalUploads(int count) {
        this.totalUploads = count;
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
    
    public int getTotalUploads() {
        return totalUploads;
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
}
