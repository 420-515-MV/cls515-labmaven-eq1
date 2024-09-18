package edu.mv.mapping;

import edu.mv.db.models.Rocket;
import edu.mv.models.RocketDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-18T18:43:15-0400",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class RocketMapperImpl implements RocketMapper {

    @Override
    public RocketDTO RocketToRocketDTO(Rocket Rocket) {
        if ( Rocket == null ) {
            return null;
        }

        RocketDTO rocketDTO = new RocketDTO();

        rocketDTO.setType( Rocket.getSorte() );
        rocketDTO.setId( Rocket.getId() );
        rocketDTO.setName( Rocket.getName() );

        return rocketDTO;
    }

    @Override
    public Rocket RocketDTOToRocket(RocketDTO RocketDTO) {
        if ( RocketDTO == null ) {
            return null;
        }

        Rocket rocket = new Rocket();

        rocket.setSorte( RocketDTO.getType() );
        rocket.setId( RocketDTO.getId() );
        rocket.setName( RocketDTO.getName() );

        return rocket;
    }
}
