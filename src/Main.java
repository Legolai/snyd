public class Main {
    public static void main(String[] args) {
        String[] players = {"Michael", "Nicolai", "Jesper"};
        Snyd game = new Snyd(6, players);
        game.begin();
        game.play();
    }
    public static void clearConsole()
    {
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }

        //System.out.print("\033[H\033[2J");
        //System.out.flush();
    }
}