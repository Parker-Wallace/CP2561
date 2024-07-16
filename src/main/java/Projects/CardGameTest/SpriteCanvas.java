package Projects.CardGameTest;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class SpriteCanvas extends Canvas {

    private BufferedImage[] sprites;
    private int currentSpriteIndex;

    public SpriteCanvas(BufferedImage[] sprites) {
        this.sprites = sprites;
        this.currentSpriteIndex = 0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        // Example: Draw the current sprite at (50, 50)
        BufferedImage currentSprite = sprites[currentSpriteIndex];
        g.drawImage(currentSprite, 50, 50, null);
    }

    public static void main(String[] args) {
        SpriteLoader loader = new SpriteLoader();
        BufferedImage[] sprites = new BufferedImage[loader.getNumSprites()];

        // Copy loaded sprites from loader to sprites array
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = loader.getSprite(i);
        }

        SpriteCanvas canvas = new SpriteCanvas(sprites);
        canvas.setSize(400, 400);

        // Set up a JFrame and add the canvas
        JFrame frame = new JFrame("Sprite Canvas Example");
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
