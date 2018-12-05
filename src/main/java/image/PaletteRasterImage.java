package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static util.Matrices.requiresNonNull;
import static util.Matrices.requiresNonZeroDimensions;

public class PaletteRasterImage implements Image {

    List<Color> palette ;
    private int[][] indexesOfColors ;
    private int width ;
    private int height ;


    public PaletteRasterImage (Color color, int width, int height) {

        this.width = width ;
        this.height = height ;
        indexesOfColors = new int [width][height];

        for(int x=0;x<width;x++) {
            for(int y=0;y<height;y++) {
                setPixelColor(color,x,y);
            }
        }

    }

    public PaletteRasterImage(Color[][] pixels) {

        requiresNonNull(pixels) ;
        requiresNonZeroDimensions(pixels);
        this.width=pixels.length;
        this.height=pixels[0].length;
        createRepresentation();
        setPixelsColor( pixels);


    }

    private void setPixelsColor(Color[][] pixels){
        for(int x=0;x<width;x++) {
            for (int y = 0; y < height; y++) {
                setPixelColor(pixels[x][y],x,y);
            }
        }
    }

    public void setPixelColor(Color color, int x, int y) {
       if (! palette.contains(color) )
        palette.add(color) ;
       indexesOfColors[x][y] = palette.indexOf(color) ;


    }

    @Override
    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColors[x][y]);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void createRepresentation(){
        palette= new ArrayList<>();
        indexesOfColors=new int[width][height];
    }

    private void setPixelsColor(Color color){
        for(int x=0;x<width;x++) {
            for (int y = 0; y < height; y++) {
                setPixelColor(color,x,y);

            }

        }
    }

    protected void setWidth(int width){
        this.width=width;
    }

    protected void setHeight(int height){
        this.height=height;
    }
}
