package bataille_navale.models.Objects.boat;

public class BoatFactory {

    public static Boat createPorteAvion(BoatDirection direction){
        return new Boat(5, Types.PorteAvion, direction);
    }

    public static Boat createCroiseur(BoatDirection direction){
        return new Boat(4, Types.Croiseur, direction);
    }

    public static Boat createContreTorpilleur(BoatDirection direction){
        return new Boat(3, Types.ContreTorpilleur, direction);
    }

    public static Boat createSousMarin(BoatDirection direction){
        return new Boat(3, Types.SousMarin, direction);
    }

    public static Boat createTorpilleur(BoatDirection direction){
        return new Boat(2, Types.Torpilleur, direction);
    }
}
