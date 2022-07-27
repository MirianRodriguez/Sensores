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

import api.rest.sensores.entidades.Medicion;
import api.rest.sensores.servicios.MedicionServicio;

@CrossOrigin
@RestController
@RequestMapping("/mediciones")
public class MedicionControlador {
    @Autowired
    private MedicionServicio medicionServicio;

    @GetMapping()
    public ArrayList<Medicion> obtenerMediciones(){
        return medicionServicio.obtenerMediciones();
    }

    @GetMapping("/{sensorId}")
    public ArrayList<Medicion> obtenerMedicionesPorSensor(@PathVariable("sensorId") Integer sensorId){
        return medicionServicio.obtenerMedicionesPorSensor(sensorId);
    }
    
    @PostMapping()
    public Medicion guardarMedicion(@RequestBody Medicion medicion){
        return medicionServicio.guardarMedicion(medicion);
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        try {
            medicionServicio.eliminarMedicion(id);
            return "Se elimino la medicion con id " + id;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
