package good.morning.controller;

import java.util.List;

/**
 * The Dao interface manages database-entity interaction.
 */

public interface Dao<Entity> {
    void insert();
    List<Entity> getAll();
    void update(Entity entity);
    void delete(Entity entity);
}
