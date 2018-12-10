package image;

import javafx.scene.paint.Color;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static util.Matrices.requiresNonNull;
import static util.Matrices.requiresNonZeroDimensions ;
public class SparseRasterImage extends RasterImage implements Image  {
    private   Map<Point, Color> PixelsMap;
    /* private int width;
    private int height; */
    public Color[][] colors;

    public SparseRasterImage(Color color, int width, int height) {


    }

    @Override
    public Color getPixelColor(int x, int y) {
        Color result = PixelsMap.get(new Point(x, y));
        if (result == null)
            return Color.WHITE;

        return result;
    }

    boolean containsKey(Object key) {
        if (key == PixelsMap)
            return true;
        else
            return false;
    }

    Color get(Object key) {
        Color getres = PixelsMap.get(key);
        if (getres == null)
            return null;
        else
            return getres;
    }

    Color getOrDefault(Object key, Color defaultValue) {
        if (get(key) != null)
            return get(key);
        else
            return PixelsMap.getOrDefault(key, defaultValue);

    }

    Color put(Point key, Color value) {
        return PixelsMap.put(key, value);
    }

    public SparseRasterImage(Color[][] pixels){
        super(pixels.length, pixels[0].length);

        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        this.width = pixels.length;
        this.height = pixels[0].length;
        createRepresentation();
        setPixelsColor(pixels);
    }

    public void createRepresentation() {
        PixelsMap = new HashMap<Point, Color>();
    }

    public void setPixelColor(Color color, int x, int y) {

    }

    private void setPixelsColor(Color color) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                setPixelColor(color, x, y);

            }

        }


    }
    private void setPixelsColor(Color[][] pixels){
        for(int x=0;x<width;x++) {
            for (int y = 0; y < height; y++) {
                setPixelColor(pixels[x][y],x,y);
            }
        }
    }
    public int getWidth(){
        return width;
    }
    public int  getHeight(){
        return height;
    }
    protected void setWidth(int width){
        this.width=width;
    }

    protected void setHeight(int height){
        this.height=height;
    }


}
