import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel {
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

    //Logic
    Bird bird; 

    //Images
    Image backgroundImg;
    Image birdImg;
    Image topPipImg;
    Image bottomPipeImg;



    FlappyBird(){
        setPreferredSize(new Dimension(boarWidth, boardHeight));
        //setBackground(Color.blue);
        
        // Loading the Images
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();
        
        //bird
        bird = new Bird(birdImg);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //BG
        g.drawImage(backgroundImg, 0, 0, boarWidth, boardHeight, null);
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
        
    }


}
