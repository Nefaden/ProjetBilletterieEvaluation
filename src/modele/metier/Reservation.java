package modele.metier;

import modele.metier.Representation;
import modele.metier.Client;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe représentant les reservation faites par les clients pour une représentation du festival dans un lieu précis
 * 
 * @author ydurand
 * v1.0
 */
@Entity
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long l_Id;
    @Column(name="place_reservee")
    private int i_PlaceReservee;
    @JoinColumn(name = "REPRESENTATION_ID")
    @Column(name="Representation")
    private Representation o_Representation;
    @JoinColumn(name = "Client")
    private Client o_Client;
    
    /**
     * 
     * Default constructor for mapping JPA
     */
    public Reservation() {        
    }
    
    /**
     * Constructeur avec les 3 attributs
     * @param intPlaceReservee
     * @param objRepresentation
     * @param objClient
     */
    public Reservation(int intPlaceReservee, Representation objRepresentation, Client objClient) {
        this.i_PlaceReservee = intPlaceReservee;
        this.o_Representation = objRepresentation;
        this.o_Client = objClient;
    }
    
    /**
     * 
     * @return Long l_Id : l_Id générée par la persistence
     */
    public Long getL_Id() {
        return l_Id;
    }

    /**
     * 
     * @param l_Id : Long valeur générée par la persistence
     */
    public void setL_Id(Long l_Id) {
        this.l_Id = l_Id;
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
     * @return int place_reservee le nombre de places réservées par le client
     */
    public int getPlaceReservee() {
        return i_PlaceReservee;
    }
    
    /**
     * 
     * @param intPlaceReservee : int nombre de places réservées
     */
    public void setPlaceReservee(int intPlaceReservee) {
        this.i_PlaceReservee = intPlaceReservee;
    }
   
    /**
     * 
     * @return Representation la representation à laquelle on réserve les places
     */    
    public Representation getRepresentation() {
        return o_Representation;
    }
    
    /**
     * 
     * @param objRepresentation : la représentation sélectionner au préalable
     */
    public void setRepresentation(Representation objRepresentation) {
        this.o_Representation = objRepresentation;
    }
    
    /**
     * 
     * @return Client le client qui réserve les places
     */
    public Client getClient() {
        return o_Client;
    }
    
    /**
     * 
     * @param objClient : le client dont on aura saisie les données
     */
    public void setClient(Client objClient) {
        this.o_Client = objClient;
    }
    
}
