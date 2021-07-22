package dordonez.servers.fotos_rest_srv;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FotoRepository extends CrudRepository<Foto, Long> {
    @Query("SELECT f.id, f.titulo, f.descripcion FROM Foto f")
    public List<Object[]> getList();
}
