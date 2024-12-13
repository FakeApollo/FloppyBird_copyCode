import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int boarWidth = 360;
    int boardHeight = 640;

    //Bird
    int birdX = boarWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img){
            this.img = img;
        }
    }

    //Pipes

    int pipeX = boarWidth;
    int pipeY = 0;
    int pipeWidth = 64; // Scaled bye 1/6
    int pipeHeight = 512;

    //Logic
    Bird bird;
    Timer gameloop;
    int velocityY = 0;
    int gravity = 1;


    //Images
    Image backgroundImg;
    Image birdImg;
    Image topPipImg;
    Image bottomPipeImg;



    FlappyBird(){
        setPreferredSize(new Dimension(boarWidth, boardHeight));
        //setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);

        // Loading the Images
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();
        
        //bird
        bird = new Bird(birdImg);

        //Game-Timer
        gameloop = new Timer(1000/60, this); // 1000/60 = 16.6
        gameloop.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        
        //BG
        g.drawImage(backgroundImg, 0, 0, boarWidth, boardHeight, null);
        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
        
    }

    public void move(){
        //bird
        velocityY += gravity;
        bird.y +=velocityY;
        bird.y = Math.max(bird.y, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocityY = -6;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) { }


}
