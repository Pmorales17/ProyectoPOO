package ar.edu.unnoba.poo2018.ods.converter;

import ar.edu.unnoba.poo2018.model.Actividad;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Actividad.class)
public class ActividadConverter extends AbstractConverter<Actividad> {

    @Override
    public String getDAOName() {
        return "ActividadDAO";
    }

}
