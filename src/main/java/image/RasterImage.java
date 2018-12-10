package image;

public abstract class RasterImage implements Image {
    int width;
    int height;

    public RasterImage(int width ,int height){
        this.width=width;
        this.height=height;
    }

    public int  getWidth(){
        return width;
    }

    public int  getHeight(){
        return height;
    }

    protected void setWidth(int width) {
        this.width=width;
    }

    protected void setHeight(int height){
        this.height=height;
    }

}
