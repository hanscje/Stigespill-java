public class Brett {
    int squareSize;
    int numberOfObstacles;
    Rute[] ruter;

    Brett(int squareSize){
        this.squareSize = squareSize;
        numberOfObstacles = -1;
        ruter = new Rute[this.squareSize * this.squareSize];
    }

    public void generateBoard(int numberOfObstacles) throws  IllegalArgumentException{
        setNumberOfObstacles(numberOfObstacles);
        generateObstacles();
    }

    private void generateObstacles(){

    }

    private void setNumberOfObstacles(int numberOfObstacles){
        int maxNumberOfObstacles =  squareSize*squareSize;
        if(numberOfObstacles > maxNumberOfObstacles){
            throw new IllegalArgumentException("There are too many obstacles");
        } else if (numberOfObstacles < 0){
            throw new IllegalArgumentException("Can't have negative number of obstacles");
        }
        this.numberOfObstacles = numberOfObstacles;
    }


}
