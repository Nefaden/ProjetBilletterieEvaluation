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
    private Long id;
    @Column(length=11)
    private int place_reservee;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "REPRESENTATION_ID")
    private Representation uneRepresentation;
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "CLIENT_ID")
    private Client unClient;
    
    /**
     * Constructeur avec les 3 attributs
     * @param place_reservee
     * @param uneRepresentation
     * @param unClient
     */
    public Reservation(int place_reservee, Representation uneRepresentation, Client unClient) {
        this.place_reservee = place_reservee;
        this.uneRepresentation = uneRepresentation;
        this.unClient = unClient;
    }
    
    /**
     * 
     * @return Long id : id générée par la persistence
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id : Long valeur générée par la persistence
     */
    public void setId(Long id) {
        this.id = id;
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
