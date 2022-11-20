package kodlama.io.DevsDemo.dataAccess.abstracts;

import kodlama.io.DevsDemo.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TechnologyDao extends JpaRepository<Technology,Integer> {
    boolean  existsByNameContainingIgnoreCase(String name);
    boolean existsById(int id);
}
