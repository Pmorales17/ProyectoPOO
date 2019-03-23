package ar.edu.unnoba.poo2018.ods.converter;

import ar.edu.unnoba.poo2018.model.Impacto;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Impacto.class)
public class ImpactoConverter extends AbstractConverter<Impacto>{

    @Override
    public String getDAOName() {
        return "ImpactoDAO";
    }    
}
