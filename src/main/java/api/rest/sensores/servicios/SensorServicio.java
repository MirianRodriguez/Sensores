package api.rest.sensores.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.rest.sensores.entidades.Sensor;
import api.rest.sensores.repositorios.SensorRepositorio;

@Service
public class SensorServicio {
    @Autowired
    private SensorRepositorio sensorRepositorio;

    @Transactional
    public Sensor guardarSensor(Sensor sensor){
        return sensorRepositorio.save(sensor);
    }

    @Transactional
    public void eliminarSensor(Integer id) throws Exception{
        try{
            sensorRepositorio.deleteById(id);
        }catch(Exception error){
            throw new Exception("No se pudo eliminar el sensor");
        }
    }

    @Transactional(readOnly = true)
    public ArrayList<Sensor> obtenerSensores(){
        return (ArrayList<Sensor>) sensorRepositorio.findAll();
    }
}
