package edu.mv;
/*
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
 */
import edu.mv.models.RocketDTO;
import edu.mv.persistence.PersistenceService;
import edu.mv.persistence.RocketNotFoundException;
import edu.mv.service.RocketService;
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
public class AppTest {
    @Mock
    private PersistenceService persistenceService;

    @InjectMocks
    private RocketService rocketService;

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
    public void testApp()
    {
        assertTrue( true );
    }
}
/*

 */