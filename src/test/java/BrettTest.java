import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class BrettTest {
    Brett brett;
    int SQUARESIZE = 4;


    @BeforeEach
    public void setBrett(){
        brett = new Brett(SQUARESIZE);
    }


    @Test
    public void generateBoard_NoObstacles_NoObstaclesCreated(){
        brett.generateBoard(0);
        assertEquals(0,brett.numberOfObstacles);
    }

    @Test
    public void GenerateBoard_OneObstacle_OneObstacleCreated(){
        brett.generateBoard(1);
        assertEquals(1,brett.numberOfObstacles);
    }

    @Test
    public void GenerateBoard_MaxObstacles_EverySquareHasObstacle(){
        int maxObstacles = SQUARESIZE * SQUARESIZE;
        brett.generateBoard(maxObstacles);
        assertEquals(maxObstacles,brett.numberOfObstacles);
    }

    @Test
    public void GenerateBoard_TooManyObstacles_ThrowsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            int maxObstacles = SQUARESIZE * SQUARESIZE;
            brett.generateBoard(maxObstacles + 1);
        });
    }

    @Test
    public void GenerateBoard_NegativeNumberOfExceptions_ThrowsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            brett.generateBoard(-1);
        });

    }


}