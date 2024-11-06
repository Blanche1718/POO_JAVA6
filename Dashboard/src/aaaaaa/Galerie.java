package aaaaaa;
 

import java.util.ArrayList;
import java.util.List;


public class Galerie {
		//Attributs
		private int idGalerie; //Attribut id de la Galerie
		private String nameGalerie; //Attribut nom de la galerie
		private List<Images> images; //Liste des images de la galerie
		
		//Constructeurs
		public Galerie(int idGalerie, String nameGalerie, List<Images> images) {
			this.idGalerie = idGalerie;
			this.nameGalerie = nameGalerie;
			this.images = new ArrayList<>(); //Initialise la liste (vide) des images
		}

		// Getters
		public int getIdGalerie() {
			return idGalerie; //Affiche l'Id de la galerie
		}
		
		public String getNameGalerie() {
			return nameGalerie; //Affiche le nom de la galerie
		}
		
		public List<Images> getImages(){
			return images; //Affiche les images de la galerie
		}
		
		//Setters
		public void setIdGalerie(int idGalerie) {
			this.idGalerie = idGalerie; //Modifie l'Id de la galerie
		}
		
		public void setNameGalerie(String nameGalerie) {
			this.nameGalerie = nameGalerie; // Modifie le nom de la galerie
		}
		
		//Méthode
		public void ShowImages() {
			System.out.println("Contenu de la galerie '" +nameGalerie+ "' :" );
			for (Images image : images) {
				System.out.println("- " +image.getTitle()+ " (" +image.getName()+ ")");
			}
		}
		
}
