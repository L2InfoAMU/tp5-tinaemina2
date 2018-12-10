package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;



public class SparseRasterImage extends RasterImage implements Image  {
    private   Map<Point, Color> pixelMap;

    public Point[][] colors;

    public SparseRasterImage(Color color, int width, int height) {
        super(width, height);
        this.createRepresentation();
        for(int x = 0 ;x < width ; x++ ){
            for(int y = 0 ; y < height ; y++){
                colors[x][y] = new Point(x,y);
                this.setPixelColor(color,x,y) ;
            }
        }

    }
    public SparseRasterImage(Color[][] pixels) {
        super(pixels.length, pixels[0].length);
        this.createRepresentation();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.colors[x][y] = new Point(x, y);
                this.setPixelColor(pixels[x][y], x, y);
            }
        }
    }
        public void createRepresentation(){
            colors = new Point[width][height];
            pixelMap = new HashMap<Point, Color>();

        }
        public void setPixelColor(Color color, int x, int y){

            pixelMap.put(colors[x][y], color);


        }
        public Color getPixelColor(int x, int y){
            return pixelMap.get(colors[x][y]);
        }
        private void setPixelsColor(Color[][] pixels){
            if(width < pixels.length || height < pixels[0].length)
                throw new ArithmeticException("erreur");
            for(int x = 0 ;x < width ; x++ ){
                for(int y = 0 ; y < height ; y++){

                    this.setPixelColor(pixels[x][y],x,y);
                }
            }
        }
        private void setPixelsColor(Color color){
            for(int x = 0 ;x < width ; x++ ){
                for(int y = 0 ; y < height ; y++){

                    this.setPixelColor(color,x,y);
                }
            }
        }



}
