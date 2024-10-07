import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Snackgame extends JPanel implements ActionListener {
    private final int TILE_SIZE = 25, WIDTH = 600, HEIGHT = 400;
    private int score = 0;
    private ArrayList<Point> snake = new ArrayList<>();
    private Point food;
    private char direction = 'R';
    private Timer timer;
    private Color snakeColor, foodColor;
    private Random random = new Random();

    public Snackgame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        snake.add(new Point(5, 5));
        snakeColor = getRandomColor();
        spawnFood();
        timer = new Timer(150, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT && direction != 'R') direction = 'L';
                else if (key == KeyEvent.VK_RIGHT && direction != 'L') direction = 'R';
                else if (key == KeyEvent.VK_UP && direction != 'D') direction = 'U';
                else if (key == KeyEvent.VK_DOWN && direction != 'U') direction = 'D';
            }
        });
    }

    private void spawnFood() {
        food = new Point((int) (Math.random() * (WIDTH / TILE_SIZE)), (int) (Math.random() * (HEIGHT / TILE_SIZE)));
        foodColor = getRandomColor();
    }

    private Color getRandomColor() {
        return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }

    private boolean checkCollision() {
        Point head = snake.get(0);
        if (head.x < 0 || head.x >= WIDTH / TILE_SIZE || head.y < 0 || head.y >= HEIGHT / TILE_SIZE) return false;
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(snakeColor);
        for (Point p : snake) g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        g.setColor(foodColor);
        g.fillOval(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);
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
        if (head.equals(food)) {
            snake.add(0, head);
            spawnFood(); score++;
        } else {
            snake.add(0, head);
            snake.remove(snake.size() - 1);
        }
        if (checkCollision()) {
            timer.stop();
            showPerformance();
            System.exit(0);
        }
        repaint();
    }

    private void showPerformance() {
        String performanceMessage = score < 5 ? "Bad performance 😢" : score <= 10 ? "Average performance 🙁" : "Good performance 😊";
        JOptionPane.showMessageDialog(this, "Game Over!\nScore: " + score + "\n" + performanceMessage, "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Snackgame game = new Snackgame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
