package aaaaaa;

public class Images {
		
		private final int id;//final pour rendre id imodifiable
		private String name;
		private String title;
		private String description;
		//private int likes;
		private boolean approuved; 
		//private int nb_downloads=0;
		private static int next_id=1;//


		
		
		//Constructor
		public Images (String name,String title,String description,boolean approuved) {
		
			this.id = next_id++;
			this.name = name;//on affecte la valeur du paramètre name à l'attribut name
			this.title = title;
			this.description = description;
			this.approuved=approuved;
		}


		//Les attributs immodifiables n'auront pas de setters
		//systaxe:getA() return a;
		
		public int getId() {
			return id;
		}
		
		/*public int getOwner_id() {
			return owner_id;
		}*/
		
		
		//Methode pour afficher les détails de l'image
		public void showDetails() {
			System.out.println ("ID: " + id );

			System.out.println ("Nom :" + name);
			
			System.out.println ("Titre :"+ title);
			
			System.out.println ("Description :"+ description);

			//System.out.println ("Nombres de Likes:"+ likes);

			System.out.println ("Statut: "+ approuved );
		}
		
		//Getters et Setters pour l'atribut Name
		
		public String getName() {
			return name;
		}
		
		 //systaxe:void setA() this.a =a (ne retoune rien );
		
		public void setName(String name) {
			this.name = name;
		}
		
		//Getters et Setters pour l'atribut Title
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
	
		//Getters et Setters pour l'atribut description
				
		public String getDescription() {
			return description;
		}
		
		public void setDescription(String description) {
			this.description = description;
		}
		
		
		/*public int getLikes() {
			return likes;
		}
		
		public void setLikes() {
			this.likes++ ;
		}*/
		
		public boolean getApprouved() {
			return approuved;
		}
		
		public void setApprouved(Boolean approuved) {
			this.approuved = approuved;
		}
		
		/*public void set_download(){
			nb_downloads++;
		}
		public int getDownload(){
			return nb_downloads;
		}*/
				
		
		
}
