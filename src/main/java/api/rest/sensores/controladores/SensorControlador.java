package api.rest.sensores.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rest.sensores.entidades.Sensor;
import api.rest.sensores.servicios.SensorServicio;

@CrossOrigin
@RestController
@RequestMapping("/sensores")
public class SensorControlador {

    @Autowired
    private SensorServicio sensorServicio;

    @GetMapping()
    public ArrayList<Sensor> obtenerSensores(){
        return sensorServicio.obtenerSensores();
    }
    
    @PostMapping()
    public Sensor guardarSensor(@RequestBody Sensor sensor){
        return sensorServicio.guardarSensor(sensor);
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        try {
            sensorServicio.eliminarSensor(id);
            return "Se elimino el sensor con id " + id;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
