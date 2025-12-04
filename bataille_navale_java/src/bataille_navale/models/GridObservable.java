package bataille_navale.models;

public interface GridObservable {
    void addObserver(GridObserver observer);
    void removeObserver(GridObserver observer);
    void notifyObservers();
}
