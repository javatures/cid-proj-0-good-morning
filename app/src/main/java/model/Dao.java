package model;

import java.util.List;

/**
 * The Dao interface manages database-entity interaction.
 */

public interface Dao<Entity> {
    void insert(Entity entity);
    List<Entity> getAll();
    void update(Entity entity);
    void delete(Entity entity);
}
