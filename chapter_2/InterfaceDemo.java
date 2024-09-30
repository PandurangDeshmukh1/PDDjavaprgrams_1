interface Playable {
    void start();
    void stop();
}

class Game implements Playable {
    private String name;

    Game(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("Starting the game: " + name);
    }

    @Override
    public void stop() {
        System.out.println("Stopping the game: " + name);
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Game myGame = new Game("Chess");
        myGame.start();
        myGame.stop();

        Game anotherGame = new Game("Tennis");
        anotherGame.start();
        anotherGame.stop();
    }
}
