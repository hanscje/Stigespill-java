public class Brett {
    int squareSize;
    int numberOfSquares;
    int numberOfObstacles;
    private Rute[] ruter;

    Brett(int squareSize, int numberOfObstacles) throws IllegalArgumentException {
        if(squareSize <= 1) {
            throw new IllegalArgumentException("For faa ruter til brettet. Maa vaere over 1 rute. antal ruter sendt med: " + squareSize);
        } else if(numberOfObstacles >= Math.pow(squareSize,2)) {
            throw new IllegalArgumentException("for mange obstacles til antall ruter. <antall ruter, antall obstacles>"
                    + numberOfObstacles + ","  + Math.pow(squareSize,2));
        } else if(numberOfObstacles < 0){
            throw new IllegalArgumentException("negativt antall barrierer sendt med.");
        }

        generateBoard(squareSize, numberOfObstacles);
    }


    public void generateBoard(int squareSize, int numberOfObstacles){
        this.numberOfSquares = squareSize * squareSize;
        ruter = new Rute[numberOfSquares];
        settInnRuter();
        setNumberOfObstacles(numberOfObstacles);
        generateObstacles();
    }

    private void settInnRuter(){
        for (int i = 0; i < numberOfSquares; i++) {
            ruter[i] = new Rute();
        }
        ruter[numberOfSquares-1] = new VinnerRute();
    }

    //TODO: lag obstacles og sett inn i brettet
    private void generateObstacles(){

    }

    private void setNumberOfObstacles(int numberOfObstacles){
        this.numberOfObstacles = numberOfObstacles;
    }

    public Rute finnSpillersNesteRute(Rute rute, int terningkast){
        int naaVaerendePos = -1;

        try{
            naaVaerendePos = finnRuteIndex(rute);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }


        if(naaVaerendePos + terningkast == numberOfSquares-1){
            return ruter[numberOfSquares - 1];
        } else if(naaVaerendePos + terningkast > numberOfSquares-1){
            int diff = numberOfSquares - (naaVaerendePos + terningkast);
            return ruter[numberOfSquares + diff - 1];
        } else {
            return ruter[naaVaerendePos + terningkast];

        }

    }



    public int finnRuteIndex(Rute rute) throws IndexOutOfBoundsException{
        for (int i = 0; i < ruter.length; i++) {
            if(ruter[i] == rute){
                return i;
            }
        }
        throw new IndexOutOfBoundsException("Fant ikke Ruten i listen");
    }

    public Rute faaStartRute(){
        return ruter[0];
    }

}
