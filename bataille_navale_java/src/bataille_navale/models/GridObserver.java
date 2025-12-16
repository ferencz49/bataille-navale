package bataille_navale.models;

import bataille_navale.models.map.Grid;

public interface GridObserver {
    void update(Grid grid);
    void updateCell(Grid g, int x, int y);

}
