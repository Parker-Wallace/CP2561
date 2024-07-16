package Projects.CardGameTest;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteLoader {

    private BufferedImage[] sprites;

    public SpriteLoader() {
        int spriteIndex = 0;
        int numSprites = 52;
        sprites = new BufferedImage[numSprites];

        try {
            for (int i = 0; i < 13; i++) {
                sprites[spriteIndex] = ImageIO.read(new File("src/main/java/Projects/CardGameTest/Assets/PlayingCards/card-hearts-" + (i + 1) + ".png"));
                spriteIndex++;
            }
            for (int i = 0; i < 13; i++) {
                sprites[spriteIndex] = ImageIO.read(new File("src/main/java/Projects/CardGameTest/Assets/PlayingCards/card-clubs-" + (i + 1) + ".png"));
                spriteIndex++;
            }
            for (int i = 0; i < 13; i++) {
                sprites[spriteIndex] = ImageIO.read(new File("src/main/java/Projects/CardGameTest/Assets/PlayingCards/card-diamonds-" + (i + 1) + ".png"));
                spriteIndex++;
            }
            for (int i = 0; i < 13; i++) {
                sprites[spriteIndex] = ImageIO.read(new File("src/main/java/Projects/CardGameTest/Assets/PlayingCards/card-spades-" + (i + 1) + ".png"));
                spriteIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int index) {
        if (index >= 0 && index < sprites.length) {
            return sprites[index];
        }
        return null;
    }

    public int getNumSprites() {
        return sprites.length;
    }

    public static void main(String[] args) {
        SpriteLoader loader = new SpriteLoader();

        // Example: Retrieve and use a sprite
        BufferedImage sprite = loader.getSprite(0); // Get the first sprite (index 0)
        if (sprite != null) {
            // Use the sprite, e.g., draw it on a canvas or display it
        }
    }
}
