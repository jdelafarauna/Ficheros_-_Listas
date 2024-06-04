import java.io.Serializable;

public class Coche implements Serializable {

    private String color;
    private int tamano;
    private int precio;

    public Coche(String color, int tamano, int precio){
        this.color = color;
        this.tamano = tamano;
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamaño) {
        this.tamano = tamano;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int compareMax(Object o){
        Coche coche = (Coche) o;
        return Integer.max(this.getPrecio(),coche.getPrecio());
    }

    @Override
    public String toString() {
        return "Coche:" +
                "color '" + color + '\'' +
                ", tamaño " + tamano +
                ", precio " + precio;
    }


    public int compareTamMax(Object o) {
        Coche coche = (Coche) o;
        return Integer.compare(coche.getTamano(),this.getTamano());
    }

    public int comparePreMax(Object o) {
        Coche coche = (Coche) o;
        return Integer.compare(coche.getPrecio(),this.getPrecio());
    }

    public void imprimir(){
        System.out.println(this.toString());
    }
}
