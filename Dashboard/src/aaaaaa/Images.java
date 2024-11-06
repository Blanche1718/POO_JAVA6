package aaaaaa;

public class Images {
		
		private final int id;//final pour rendre id imodifiable
		private final int owner_id;
		private String name;
		private String title;
		private String description;
		private int likes;
		private boolean approuved; 


		
		
		//Constructor
		public Images (int id, int owner_id ,String name,String title,String description,int likes,boolean approuved) {
			this.id = id;//le id des attributs prends la valeur du paramètre id
			this.owner_id = owner_id;
			this.name = name;//on affecte la valeur du paramètre name à l'attribut name
			this.title = title;
			this.description = description;
		}


		//Les attributs immodifiables n'auront pas de setters
		//systaxe:getA() return a;
		
		public int getId() {
			return id;
		}
		
		public int getOwner_id() {
			return owner_id;
		}
		
		
		//Methode pour afficher les détails de l'image
		public void showDetails() {
			System.out.println ("ID: " + id );
			
			System.out.println ("Propriétaire :" + owner_id);

			System.out.println ("Nom :" + name);

			System.out.println ("Titre: "+ title);

			System.out.println ("Description :"+ description);

			System.out.println ("Nombres de Likes:"+ likes);

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
		
		
		public int getLikes() {
			return likes;
		}
		
		public void setLikes(int likes) {
			this.likes++ ;
		}
		
		public boolean getApprouved() {
			return approuved;
		}
		
		public void setApprouved(Boolean approuved) {
			this.approuved = approuved;
		}
		
		
}
