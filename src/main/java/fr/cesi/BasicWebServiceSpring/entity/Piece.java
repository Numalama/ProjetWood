package fr.cesi.BasicWebServiceSpring.entity;

;
// Generated 20 juin 2017 19:05:55 by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */


@Entity
@Table(name = "piece",
         catalog = "wood_db"
)
public class Piece implements java.io.Serializable {

    private int id;
    private Buyer buyer;
    private String label;
    private Set<Composant> composants = new HashSet<Composant>(0);

    public Piece() {
    }

    public Piece(int id, Buyer buyer) {
        this.id = id;
        this.buyer = buyer;
    }

    public Piece(int id, Buyer buyer, Piece category, String label, Set<Composant> composants) {
        this.id = id;
        this.buyer = buyer;
        this.label = label;
        this.composants = composants;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buy_id", nullable = false)
    public Buyer getBuyer() {
        return this.buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Column(name = "label")
    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "piece")
    public Set<Composant> getComposants() {
        return this.composants;
    }

    public void setComposants(Set<Piece> categories) {
        this.composants = composants;
    }

}
