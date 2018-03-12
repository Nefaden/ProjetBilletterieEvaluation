# Billetterie2017_Groupe4
2e projet en JAVA - Une application pour les billets des représentations du premier projet. Groupe 4 composé de Grégory Cormier, Grégory Doucet, Yann Durand et Maxime Roux.

Projet Billetterie (Festival Folklores du Monde de Saint Malo) en Java pour le module de PPE 2SLAM à La Joliverie (2017-2018)
- Le script de création de la base de données MySql sont dans un sous-répertoire "sql".
- Le projet est architecturé en couche MVC et la gestion des données sont gérées via le Framework Orm et l'API JPA
- Tous les codes sont dans le sous-dossier "src"
- Le sous-dossier "controleur" contiendra tous les contrôleur utile au développement de l'application
- Le sous-dossier "modele" représenta la couche Modèle du MVC avec deux autres sous-dossier "métier" et "Orm"
- Le sous-dossier "test" contient toutes les classes de tests nécessaire pour tester les classes métier et DAO
- Le sous-dossier "vue" servira à stockés nos interfaces graphique


Le développement de l'application se déroulera suivant les étapes suivantes :
    - Itération n°1 : Choisir une représentation
    - Itération 2 : cas d'utilisation "Vendre des places"
    - Itération 3 : cas d'utilisation "s'authentifier sur l'application locale"
    - Itération 4 : cas d'utilisation "s'authentifier sur la base distante"
    - Itération 5 : cas d'utilisation "Mettre à jour la base distante"
    - Itération 6 : cas d'utilisation "Importer la base distante vers la base locale"
    
    
    --------------------------------------------Règle de nommage pour les développeurs-------------------------------------------------------

---------- Propriétés d'une classe ----------

	Les propriétés d'une classe seront déclarés ainsi :

1) Le type de la propriétés par sa première lettre
2) Underscore
3) Nom de la variable adéquat à la BDD (Commençant par une majuscule)

Ex : 

Id de type int  →  i_Id;
Nom du client de type String  →  s_NomClient;
Valeur d'un solde en Float  →  f_Solde;
Une date de type date  →  dt_DateRetrait; 
// (seule variable avec 2 lettres, pour pas confondre avec le type Double)
Une propriétés de type objet  →  o_Compte;
Une liste d'objet  →  a_LesComptes; 
// (déterminant « les » pour dissocier l'objet à la liste)


---------- Variable internes et paramètre d'une fonction ou procédure ----------

	Les variables d'une méthode seront déclarés suivant ces instructions :

1) Le type de la variable sera écrite en 3 lettres
2) Nom de la variable, en cohérence avec la BDD, commençant par une majuscule

Ex : 

Id de type int  →  intId;
Nom du client de type String  →  strNomClient;
Valeur d'un solde en Float  →  fltSolde;
Une date de type date  →  dateDateRetrait; 
Une propriétés de type objet  →  objCompte;
Une liste d'objet  →  arrObjComptes; 
// (« Obj » au lieu de « les » pour comprendre que c'est une liste d'objet)


---------- Déclaration des Getter / Setter ----------

	Les méthodes Getter et Setter  seront déclarer sous cette forme :

Getter :

public int getId() {
	return this.i_Id;
}


Setter : 

public void setId(int intId) {
	this.i_Id = intId;
}


---------- Signature d'une méthode ----------

	Les signatures des méthodes seront déclarés sous cette forme : 

public Client (int intIdClient, String strNomClient, Float fltSolde, date dateDateRetrait, Compte objCompte, array<Compte> arrObjComptes) {

	…..
}

1) La signature boit ses propriétés déclarer sur la même ligne
2) Les propriétés sont déclarer dans l'ordre de déclaration de la classe


---------- ATTENTION ----------



1) Attention au pointage ! On sélectionne la propriétés de la classe (this.i_Id) pour le pointer vers la variable locale (intId) !
2) Attention aux espacements !
3) Attention à l'indentation !
4) Attention à l'ordre de priorité lors des déclaration de paramètres ! On suit l'ordre des colonnes dans la table de la BDD !
