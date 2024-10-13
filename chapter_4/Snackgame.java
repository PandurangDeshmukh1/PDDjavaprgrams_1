import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Snackgame extends JPanel implements ActionListener {
    private final int TILE_SIZE = 25, WIDTH = 600, HEIGHT = 400;
    private int score = 0;
    private int highScore = 0;
    private ArrayList<Point> snake = new ArrayList<>();
    private Point food;
    private char direction = 'R';
    private Timer timer;
    private Color snakeColor;
    private Random random = new Random();
    private Clip clip;
    private Clip backgroundClip;
    private Clip specialClip;
    private boolean specialMusicPlaying = false;
    private boolean isEating = false;
    private int initialSpeed = 150;
    private int speedIncrement = 10;
    private int speed = initialSpeed;
    private boolean gameStarted = false;
    private final String HIGH_SCORE_FILE = "highscore.txt";
    private Timer colorChangeTimer;
    private long lastColorChangeTime;

    public Snackgame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER && !gameStarted) {
                    gameStarted = true;
                    initGame();
                } else if (gameStarted) {
                    if (key == KeyEvent.VK_LEFT && direction != 'R') direction = 'L';
                    else if (key == KeyEvent.VK_RIGHT && direction != 'L') direction = 'R';
                    else if (key == KeyEvent.VK_UP && direction != 'D') direction = 'U';
                    else if (key == KeyEvent.VK_DOWN && direction != 'U') direction = 'D';
                }
            }
        });
        loadHighScore();
    }

    private void initGame() {
        snake.clear();
        snake.add(new Point(5, 5));
        score = 0;
        speed = initialSpeed;
        snakeColor = getRandomSnakeColor();
        spawnFood();
        timer = new Timer(speed, this);
        timer.start();
        loadSound();
        loadBackgroundMusic();
        lastColorChangeTime = System.currentTimeMillis();
        colorChangeTimer = new Timer(100, e -> changeSnakeColor());
        colorChangeTimer.start();
        repaint();
    }

    private Color getRandomSnakeColor() {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
        return colors[random.nextInt(colors.length)];
    }

    private void changeSnakeColor() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastColorChangeTime >= 10000) {
            snakeColor = getRandomSnakeColor();
            lastColorChangeTime = currentTime;
        }
    }

    private void spawnFood() {
        food = new Point((int) (Math.random() * (WIDTH / TILE_SIZE)), (int) (Math.random() * (HEIGHT / TILE_SIZE)));
    }

    private Color getRandomFoodColor() {
        Color[] colors = {Color.YELLOW, Color.MAGENTA, Color.CYAN};
        return colors[random.nextInt(colors.length)];
    }

    private void loadSound() {
        try {
            File soundFile = new File("C:\\Users\\HP\\Desktop\\PDDjavaprgrams_1\\chapter_4\\zapsplat_animals_snake_lunge_14694.wav");
            if (soundFile.exists()) {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(soundFile));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBackgroundMusic() {
        try {
            File backgroundMusicFile = new File("C:\\Users\\HP\\Desktop\\PDDjavaprgrams_1\\chapter_4\\WhatsApp Audio 2024-10-12 at 10.55.06 AM (online-audio-converter.com).wav");
            if (backgroundMusicFile.exists()) {
                backgroundClip = AudioSystem.getClip();
                backgroundClip.open(AudioSystem.getAudioInputStream(backgroundMusicFile));
                backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
                backgroundClip.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File specialMusicFile = new File("C:\\Users\\HP\\Desktop\\PDDjavaprgrams_1\\chapter_4\\WhatsApp Audio 2024-10-12 at 11.02.38 AM (online-audio-converter.com) (1).wav");
            if (specialMusicFile.exists()) {
                specialClip = AudioSystem.getClip();
                specialClip.open(AudioSystem.getAudioInputStream(specialMusicFile));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkCollision(Point head) {
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!gameStarted) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Press Enter to Start", WIDTH / 2 - 150, HEIGHT / 2);
            return;
        }

        g.setColor(snakeColor);
        for (int i = 1; i < snake.size(); i++) {
            Point p = snake.get(i);
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        Point head = snake.get(0);
        if (isEating) {
            g.fillRect(head.x * TILE_SIZE, head.y * TILE_SIZE, TILE_SIZE, TILE_SIZE / 2);
            g.fillRect(head.x * TILE_SIZE, head.y * TILE_SIZE + TILE_SIZE / 2, TILE_SIZE, TILE_SIZE / 2);
        } else {
            g.fillRect(head.x * TILE_SIZE, head.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        g.setColor(Color.WHITE);
        g.fillOval(head.x * TILE_SIZE + 5, head.y * TILE_SIZE + 5, 5, 5);
        g.fillOval(head.x * TILE_SIZE + 15, head.y * TILE_SIZE + 5, 5, 5);
        g.setColor(getRandomFoodColor());
        g.fillOval(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);
        g.drawString("High Score: " + highScore, 10, 60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Point head = new Point(snake.get(0));

        switch (direction) {
            case 'R': head.x++; break;
            case 'L': head.x--; break;
            case 'U': head.y--; break;
            case 'D': head.y++; break;
        }

        if (head.x < 0) head.x = WIDTH / TILE_SIZE - 1;
        else if (head.x >= WIDTH / TILE_SIZE) head.x = 0;
        if (head.y < 0) head.y = HEIGHT / TILE_SIZE - 1;
        else if (head.y >= HEIGHT / TILE_SIZE) head.y = 0;

        if (checkCollision(head)) {
            timer.stop();
            colorChangeTimer.stop();
            gameOver((JFrame) SwingUtilities.getWindowAncestor(this));
            return;
        }

        snake.add(0, head);

        if (head.equals(food)) {
            spawnFood();
            score++;
            playSound();

            if (score > highScore) {
                highScore = score;
                saveHighScore();
            }

            if (score % 5 == 0) {
                speed = Math.max(50, speed - speedIncrement);
                timer.setDelay(speed);
            }
            isEating = true;
        } else {
            snake.remove(snake.size() - 1);
            isEating = false;
        }

        if (score == 25 && !specialMusicPlaying) {
            switchToSpecialMusic();
        }

        repaint();
    }

    private void playSound() {
        if (clip != null && !isEating) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    private void switchToSpecialMusic() {
        if (backgroundClip.isRunning()) {
            backgroundClip.stop();
        }
        specialClip.start();
        specialMusicPlaying = true;
    }

    private void gameOver(JFrame frame) {
        String message = "Game Over! Your score: " + score + "\nPress Enter to play again.";
        JOptionPane.showMessageDialog(frame, message);
        initGame();
    }

    private void loadHighScore() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(HIGH_SCORE_FILE));
            highScore = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (Exception e) {
            highScore = 0;
        }
    }

    private void saveHighScore() {
        try {
            FileWriter writer = new FileWriter(HIGH_SCORE_FILE);
            writer.write(String.valueOf(highScore));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Snackgame game = new Snackgame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.requestFocus();
    }
}
