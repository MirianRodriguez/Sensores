package api.rest.sensores.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.rest.sensores.entidades.Medicion;

@Repository
public interface MedicionRepositorio extends JpaRepository<Medicion, Integer>{
    @Query(value = "SELECT * FROM medicion WHERE sensor_id = ?1 ORDER BY fecha_hora" , nativeQuery = true)
    ArrayList<Medicion> findBySensor(Integer sensorId);

    @Query(value = "SELECT * FROM medicion ORDER BY fecha_hora" , nativeQuery = true)
    ArrayList<Medicion> findAll();
}
