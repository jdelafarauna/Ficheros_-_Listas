public class Main {
    public static void main(String[] args) {

        Coche coche1 = new Coche("azul",5,20000);
        Coche coche2 = new Coche("rojo",3,50000);
        Coche coche3 = new Coche("amarillo",9,10000);

        Concesionario concesionario = new Concesionario("Madrid");
        concesionario.anadir(coche1);
        concesionario.anadir(coche2);
        concesionario.anadir(coche3);

        System.out.println("Ordenado por precio minimo");
        concesionario.ordenarPrecioMin();
        concesionario.ImprimirListado();

        System.out.println();

        System.out.println("Ordenado por precio maximo");
        concesionario.ordenarPrecioMax();
        concesionario.ImprimirListado();

        System.out.println();

        System.out.println("Ordenado por tamaño minimo");
        concesionario.ordenarTamanoMin();
        concesionario.ImprimirListado();

        System.out.println();

        System.out.println("Ordenado por tamaño maximo");
        concesionario.ordenarTamanoMax();
        concesionario.ImprimirListado();

        System.out.println();

        System.out.println("Escritura en fichero Binario");
        concesionario.escrbirFicheroBinario("Salida.dat");

        System.out.println();

        System.out.println("Lectura en fichero Binario");
        concesionario.leerFicheroBinario("Salida.dat");

        System.out.println();

        System.out.println("Escritura en fichero de Texto");
        concesionario.escribirFicheroTexto("Salida.txt");

        System.out.println();

        System.out.println("Lectura en fichero de Texto");
        concesionario.lecturaFicheroTexto("Salida.txt");

        System.out.println();

        System.out.println("Imprimir Iterando");
        concesionario.imprimirIterando();

    }
}