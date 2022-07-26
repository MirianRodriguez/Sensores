package api.rest.sensores.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.rest.sensores.entidades.Medicion;
import api.rest.sensores.repositorios.MedicionRepositorio;

@Service
public class MedicionServicio {
    
    @Autowired
    private MedicionRepositorio medicionRepositorio;

    @Transactional
    public Medicion guardarMedicion(Medicion medicion){
        return medicionRepositorio.save(medicion);
    }

    @Transactional
    public void eliminarMedicion(Integer id) throws Exception{
        try{
            medicionRepositorio.deleteById(id);
        }catch(Exception error){
            throw new Exception("No se pudo eliminar la medicion");
        }
    }

    @Transactional(readOnly = true)
    public ArrayList<Medicion> obtenerMediciones(){
        return (ArrayList<Medicion>) medicionRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public ArrayList<Medicion> obtenerMedicionesPorSensor(Integer sensorId) {
        return medicionRepositorio.findBySensor(sensorId);
    }
}
