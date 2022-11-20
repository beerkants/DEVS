package kodlama.io.DevsDemo.dataAccess.abstracts;

import kodlama.io.DevsDemo.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageDao extends JpaRepository<Language,Integer> {

    boolean  existsByNameContainingIgnoreCase(String name);
    boolean existsById(int id);
}
