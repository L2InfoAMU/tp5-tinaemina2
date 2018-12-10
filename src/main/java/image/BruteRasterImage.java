package image;

import image.Image;
import javafx.scene.paint.Color;
import util.Matrices;

import static util.Matrices.requiresNonNull;

public class
BruteRasterImage implements Image {

    public int width ;
    public int height ;
    public Color[][] colors ;


    public BruteRasterImage(Color color, int width, int height) {

        this.width = width ;
        this.height = height ;
        colors = new Color[width][height];

        for(int x=0;x<width;x++) {
            for(int y=0;y<height;y++) {
                colors[x][y]=color ;
            }
        }

    }
    public BruteRasterImage(Color[][] colors) {
        requiresNonNull(colors) ;
        this.colors=colors.clone() ;
        this.height= Matrices.getColumnCount(colors);
        this.width =  Matrices.getRowCount(colors);
    }

    @Override
    public Color getPixelColor(int x, int y) {

        return colors[x][y];
    }

    @Override
    public int getWidth() {

        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void createRepresentation() {
        colors = new Color[width][height];


    }
    public void setPixelColor(Color color, int x, int y) {

        colors[x][y] = color ;
    }

    private void setPixelsColor(Color[][] pixels){
        for(int x=0;x<width;x++) {
            for (int y = 0; y < height; y++) {
                setPixelColor(pixels[x][y],x,y);
            }
        }
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

