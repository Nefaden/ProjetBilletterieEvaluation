package modele.metier;

import modele.metier.Representation;
import modele.metier.Client;
import java.io.Serializable;

/**
 * Classe représentant les reservation faites par les clients pour une représentation du festival dans un lieu précis
 * 
 * @author ydurand
 * v1.0
 */
public class Reservation {
    
    private int id;
    private int place_reservee;
    private Representation uneRepresentation;
    private Client unClient;
    
    /**
     * Constructeur avec les 4 attributs
     * @param id : identifiant DB de la reservation
     * @param place_reservee
     * @param uneRepresentation
     * @param unClient
     */
    public Reservation(int id, int place_reservee, Representation uneRepresentation, Client unClient) {
        this.id = id;
        this.place_reservee = place_reservee;
        this.uneRepresentation = uneRepresentation;
        this.unClient = unClient;
    }
    
    /**
     *
     * @return String attributs de la reservation
     */
    @Override
    public String toString() {
        return ("Reservation{place_reservee: " + this.getPlaceReservee() + "\trepresentation: " + this.getRepresentation() + "\tclient: " + this.getClient() + "}");
    }
    
    //Getter / Setter de la classe Reservation
    
    /**
     *
     * @return int id de la reservation dans la DB
     */
    public int getIdReservation() {
        return id;
    }
    
    /**
     * 
     * @param id : identifiant de la reservation dans la DB
     */
    public void setIdReservation(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @return int place_reservee le nombre de places réservées par le client
     */
    public int getPlaceReservee() {
        return place_reservee;
    }
    
    /**
     * 
     * @param place_reservee : int nombre de places réservées
     */
    public void setPlaceReservée(int place_reservee) {
        this.place_reservee = place_reservee;
    }
   
    /**
     * 
     * @return Representation la representation à laquelle on réserve les places
     */    
    public Representation getRepresentation() {
        return uneRepresentation;
    }
    
    /**
     * 
     * @param uneRepresentation : la représentation sélectionner au préalable
     */
    public void setRepresentation(Representation uneRepresentation) {
        this.uneRepresentation = uneRepresentation;
    }
    
    /**
     * 
     * @return Client le client qui réserve les places
     */
    public Client getClient() {
        return unClient;
    }
    
    /**
     * 
     * @param unClient : le client dont on aura saisie les données
     */
    public void setClient(Client unClient) {
        this.unClient = unClient;
    }
    
}
