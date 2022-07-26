package api.rest.sensores.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.rest.sensores.entidades.Sensor;

@Repository
public interface SensorRepositorio extends JpaRepository<Sensor, Integer>{
    
}
