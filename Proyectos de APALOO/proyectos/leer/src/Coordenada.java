public class Coordenada {
    int ren, col;

    public Coordenada(int ren, int col){
        this.ren = ren;
        this.col = col;
    }

    public String toString(){
        return String.format("[%2d,%2d]", ren,col);
    }
}
