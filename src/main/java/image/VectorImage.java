package image;


import javafx.scene.paint.Color;


import java.util.List;


public class VectorImage implements Image{


   private List<Shape> shapes ;

   private Color[][] pixelColor ;

  private  int height , width ;


   public VectorImage(List<Shape> shapes, int width, int height){


        this.shapes = shapes ;

        this.height = height ;

        this.width = width ;

        pixelColor = new Color[width][height];

        for(int index = 0 ; index < shapes.size() ; index ++){

            for(int x = 0 ; x < width ; x++){

                for(int y = 0 ; y < height ; y++){

                    if(shapes.get(index).contains(new Point(x,y)))

                        pixelColor[x][y] = shapes.get(index).getColor();

                }

            }

        }

    }

    public Color getPixelColor(int x, int y){

        return pixelColor[x][y] ;

    }

    public int getWidth(){

        return width ;

    }

    public int getHeight(){

        return height ;

    }

    protected void setWidth(int width){

        this.width = width ;

    }

    protected void setHeight(int height){

        this.height = height ;

    }



}