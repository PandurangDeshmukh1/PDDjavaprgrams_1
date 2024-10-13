import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.*;

public class Snackgame extends JPanel implements ActionListener {
    private final int TILE_SIZE = 25, WIDTH = 600, HEIGHT = 400;
    private int score = 0, level = 1;
    private ArrayList<Point> snake = new ArrayList<>();
    private ArrayList<Point> aiSnake = new ArrayList<>();
    private Point food, powerUp;
    private char direction = 'R', aiDirection = 'L';
    private Timer timer, gameTimer;
    private Color snakeColor, foodColor, powerUpColor;
    private Random random = new Random();
    private Clip clip, backgroundClip, specialClip;
    private boolean specialMusicPlaying = false, isEating = false, gamePaused = false, timedMode = false;
    private int[] highScores = new int[5];
    private boolean gameStarted = false;
    private boolean speedBoostActive = false, scoreMultiplierActive = false;
    private ArrayList<Point> obstacles = new ArrayList<>();
    private int gameTimeRemaining = 60;  // For timed mode
    private boolean isTimedMode = false;
    private int speedBoostDuration = 5;  // Duration of speed boost in seconds
    private int scoreMultiplierDuration = 5;  // Duration of score multiplier in seconds
    private JFrame frame; // Declare frame here

    public Snackgame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        snake.add(new Point(5, 5));  // Initialize snake position
        aiSnake.add(new Point(20, 20));  // Initialize AI snake position
        snakeColor = Color.GREEN;
        spawnFood();
        spawnObstacles(5);  // Place 5 random obstacles

        timer = new Timer(150, this);
        gameTimer = new Timer(1000, e -> updateTime());  // Timer for timed mode
        
        loadHighScores();
        setupAudio();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT && direction != 'R') direction = 'L';
                else if (key == KeyEvent.VK_RIGHT && direction != 'L') direction = 'R';
                else if (key == KeyEvent.VK_UP && direction != 'D') direction = 'U';
                else if (key == KeyEvent.VK_DOWN && direction != 'U') direction = 'D';
                else if (key == KeyEvent.VK_P) togglePause();
            }
        });
    }

    private void setupAudio() {
        try {
            File soundFile = new File("C:\\Users\\HP\\Desktop\\PDDjavaprgrams_1\\chapter_4\\zapsplat_animals_snake_lunge_14694.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File backgroundMusicFile = new File("C:\\Users\\HP\\Desktop\\PDDjavaprgrams_1\\chapter_4\\dark_harmonics_taiko_fury_09_night_of_the_kitsune.wav");
            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(AudioSystem.getAudioInputStream(backgroundMusicFile));
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File specialMusicFile = new File("C:\\Users\\HP\\Desktop\\PDDjavaprgrams_1\\chapter_4\\WhatsApp Audio 2024-10-12 at 11.02.38 AM (online-audio-converter.com) (1).wav");
            specialClip = AudioSystem.getClip();
            specialClip.open(AudioSystem.getAudioInputStream(specialMusicFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void togglePause() {
        if (gamePaused) {
            timer.start();
            if (isTimedMode) gameTimer.start();
        } else {
            timer.stop();
            if (isTimedMode) gameTimer.stop();
        }
        gamePaused = !gamePaused;
    }

    private void updateTime() {
        if (isTimedMode) {
            gameTimeRemaining--;
            if (gameTimeRemaining <= 0) {
                gameOver(); // Use the frame variable
            }
        }
    }

    private void spawnFood() {
        food = new Point(random.nextInt(WIDTH / TILE_SIZE), random.nextInt(HEIGHT / TILE_SIZE));
        foodColor = getRandomColor();
    }

    private void spawnPowerUp() {
        powerUp = new Point(random.nextInt(WIDTH / TILE_SIZE), random.nextInt(HEIGHT / TILE_SIZE));
        powerUpColor = Color.YELLOW; // Power-up color
    }

    private void spawnObstacles(int count) {
        for (int i = 0; i < count; i++) {
            Point obstacle = new Point(random.nextInt(WIDTH / TILE_SIZE), random.nextInt(HEIGHT / TILE_SIZE));
            obstacles.add(obstacle);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!gameStarted) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Press ENTER to Start", 150, HEIGHT / 2);
            return;
        }

        g.setColor(snakeColor);
        for (Point p : snake) {
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        for (Point p : aiSnake) {
            g.setColor(Color.RED); // Different color for AI snake
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        g.setColor(foodColor);
        g.fillOval(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        if (powerUp != null) {
            g.setColor(powerUpColor);
            g.fillRect(powerUp.x * TILE_SIZE, powerUp.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        g.setColor(Color.RED);
        for (Point obstacle : obstacles) {
            g.fillRect(obstacle.x * TILE_SIZE, obstacle.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);
        if (isTimedMode) {
            g.drawString("Time Left: " + gameTimeRemaining, WIDTH - 150, 30);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameStarted) return;

        Point head = new Point(snake.get(0));
        moveSnake(head, direction, snake);

        if (checkCollision(head)) {
            gameOver(); // Use the frame variable
        }

        // Check if the snake has eaten food
        if (head.equals(food)) {
            score += scoreMultiplierActive ? 2 : 1;  // Double points if multiplier is active
            spawnFood();  // Respawn food
            if (random.nextBoolean()) spawnPowerUp(); // Randomly spawn power-up
            playSound(clip); // Play sound on eating food
        }

        // Check if the snake has eaten a power-up
        if (powerUp != null && head.equals(powerUp)) {
            if (random.nextBoolean()) {
                speedBoostActive = true; // Activate speed boost
                timer.setDelay(timer.getDelay() / 2); // Increase speed
                new Timer(speedBoostDuration * 1000, e1 -> deactivateSpeedBoost()).start();
            } else {
                scoreMultiplierActive = true; // Activate score multiplier
                new Timer(scoreMultiplierDuration * 1000, e1 -> deactivateScoreMultiplier()).start();
            }
            powerUp = null; // Remove power-up after eating
        }

        // AI movement
        moveAI();

        repaint();
    }

    private void moveAI() {
        Point aiHead = new Point(aiSnake.get(0));
        moveSnake(aiHead, aiDirection, aiSnake);

        if (checkCollision(aiHead)) {
            gameOver(); // Use the frame variable
        }
    }

    private void moveSnake(Point head, char direction, ArrayList<Point> snake) {
        switch (direction) {
            case 'R': head.x++; break;
            case 'L': head.x--; break;
            case 'U': head.y--; break;
            case 'D': head.y++; break;
        }

        // Wrap around the edges
        if (head.x < 0) head.x = WIDTH / TILE_SIZE - 1;
        else if (head.x >= WIDTH / TILE_SIZE) head.x = 0;
        if (head.y < 0) head.y = HEIGHT / TILE_SIZE - 1;
        else if (head.y >= HEIGHT / TILE_SIZE) head.y = 0;

        snake.add(0, head); // Add new head
        if (!isEating) {
            snake.remove(snake.size() - 1); // Remove last segment
        } else {
            isEating = false;
        }
    }

    private boolean checkCollision(Point head) {
        for (Point part : snake.subList(1, snake.size())) {
            if (head.equals(part)) return true;  // Snake collides with itself
        }

        for (Point obstacle : obstacles) {
            if (obstacle.equals(head)) return true;  // Snake collides with an obstacle
        }

        return false;  // No collision detected
    }

    private void gameOver() {
        timer.stop();
        if (isTimedMode) gameTimer.stop();
        JOptionPane.showMessageDialog(frame, "Game Over! Your Score: " + score);
        saveHighScore();
        System.exit(0);
    }

    private void saveHighScore() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("highscores.txt", true))) {
            writer.println(score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadHighScores() {
        try (BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < highScores.length) {
                highScores[index++] = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Color getRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private void playSound(Clip clip) {
        if (clip.isRunning()) clip.stop(); // Stop any currently playing clip
        clip.setFramePosition(0); // Rewind to the beginning
        clip.start(); // Play the clip
    }

    private void deactivateSpeedBoost() {
        speedBoostActive = false;  // Deactivate speed boost
        timer.setDelay(150); // Reset speed
    }

    private void deactivateScoreMultiplier() {
        scoreMultiplierActive = false;  // Deactivate score multiplier
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Snackgame game = new Snackgame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.frame = frame; // Initialize the frame in the game instance

        // Start the game when ENTER is pressed
        game.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    game.gameStarted = true;
                    game.timer.start();
                    game.gameTimeRemaining = 60;  // Reset time for timed mode
                    game.isTimedMode = true;  // Start in timed mode for demo
                    game.gameTimer.start();
                    game.frame.requestFocus();
                }
            }
        });
    }
}
