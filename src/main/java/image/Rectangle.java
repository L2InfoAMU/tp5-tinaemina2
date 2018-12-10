package image;
import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    int x,y,width,height ;
    Color[][] pixelColor ;
    Rectangle(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y ;
        this.width = width ;
        this.height = height ;
        pixelColor = new Color[width][height];
        for(int i = 0 ; i < width ; i++){
            for(int j = 0; j < height ;j++){
                pixelColor[i][j]= color ;
            }
        }
    }
    public boolean contains(Point point){
        if(point.x < this.width + this.x && point.x > this.x && point.y < this.height && point.y > this.y)
            return true ;
        return false ;
    }
    public Color getColor(){
        return pixelColor[0][0];
    }
}
