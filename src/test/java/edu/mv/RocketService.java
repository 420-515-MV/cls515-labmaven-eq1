package edu.mv;
/*
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
 */
import edu.mv.models.RocketDTO;
import edu.mv.persistence.PersistenceService;
import edu.mv.persistence.RocketNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */

@ExtendWith(MockitoExtension.class)
public class RocketService {
    @Mock
    private PersistenceService persistenceService;

    @InjectMocks
    private edu.mv.service.RocketService rocketService;

    @Test
    public void testGetRocket() throws RocketNotFoundException {
        RocketDTO rocketDTO = new RocketDTO();
        rocketDTO.setId(1);
        rocketDTO.setName("Maindy");
        rocketDTO.setType("F1 Rocket");
        when(persistenceService.retrieve(1)).thenReturn(rocketDTO);
        RocketDTO result = rocketService.getRocket(1);
        assertEquals("Maindy", result.getName());
    }
    @Test
    public void testPutRocket() {
        RocketDTO rocketDTO = new RocketDTO();
        rocketDTO.setId(1);
        rocketDTO.setName("Maindy");
        rocketDTO.setType("F1 Rocket");
        rocketService.putRocket(rocketDTO);
        verify(persistenceService).save(rocketDTO);
    }

    @Test
    public void testGetId() {
        RocketDTO rocketDTO = new RocketDTO();
        rocketDTO.setId(1);
        int id = rocketDTO.getId();
        assertEquals(1, id);
    }

    @Test
    public void testGetType() {
        RocketDTO rocketDTO = new RocketDTO();
        rocketDTO.setType("rocket");
        String type = rocketDTO.getType();
        assertEquals("rocket", type);
    }



    public void testApp()
    {
        assertTrue( true );
    }
}
/*

 */