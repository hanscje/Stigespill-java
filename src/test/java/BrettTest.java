import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class BrettTest {
    Brett brett;
    int SQUARESIZE = 4;
    int OBSTACLES = 2;


    /*@BeforeEach
    public void setBrett(){
        brett = new Brett(SQUARESIZE);
    }*/


    @Test
    public void generateBoard_NoObstacles_NoObstaclesCreated(){
        Brett brett = new Brett(SQUARESIZE,0);
        assertEquals(0,brett.numberOfObstacles);
    }

    @Test
    public void GenerateBoard_OneObstacle_OneObstacleCreated(){
        Brett brett = new Brett(SQUARESIZE, 1);
        assertEquals(1,brett.numberOfObstacles);
    }

    @Test
    public void GenerateBoard_MaxObstacles_EverySquareHasObstacle(){
        int maxObstacles = SQUARESIZE * SQUARESIZE -1;
        Brett brett = new Brett(SQUARESIZE, maxObstacles);
        assertEquals(maxObstacles,brett.numberOfObstacles);
    }

    @Test
    public void GenerateBoard_TooManyObstacles_ThrowsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            int maxObstacles = SQUARESIZE * SQUARESIZE;
            Brett brett = new Brett(SQUARESIZE, maxObstacles);
        });
    }

    @Test
    public void GenerateBoard_NegativeNumberOfObstacles_ThrowsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Brett brett = new Brett(-1, OBSTACLES);
        });
    }


}