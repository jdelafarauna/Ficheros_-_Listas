import java.io.*;
import java.nio.file.Files;
import java.util.*;


public class Concesionario implements Serializable {

    private ArrayList<Coche> listado;

    private String nombre;
    private int numCoches;

    public Concesionario(String nombre) {
        this.listado = new ArrayList<>();
        this.nombre = nombre;
        this.numCoches = 0;
    }

    public ArrayList<Coche> getListado() {
        return listado;
    }

    public void setListado(ArrayList<Coche> listado) {
        this.listado = listado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Concesionario:" +
                "nombre '" + nombre + '\'' +
                "listado: " + listado +
                '}';
    }

    public void anadir(Coche coche) {
        listado.add(coche);
        this.numCoches++;
    }

    public void ordenarPrecioMin() {
        Collections.sort(listado, Comparator.comparing(Coche::getPrecio));
    }

    public void ordenarPrecioMax() {
        Collections.sort(listado, Coche::comparePreMax);
    }

    public void ordenarTamanoMax() {
        Collections.sort(listado, Coche::compareTamMax);
    }

    public void ordenarTamanoMin() {
        Collections.sort(listado, Comparator.comparing(Coche::getTamano));
    }


    public void ImprimirListado() {
        for (Coche coche : listado) {
            System.out.println(coche.toString());
        }
    }

    public void escrbirFicheroBinario(String nombreF) {

        File directorio = new File("Ficheros");
        if (!(directorio.exists())) {
            directorio.mkdir();
        }
        String ruta = directorio + "/" + nombreF;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void leerFicheroBinario(String nombreF) {
        File fichero = new File("Ficheros/" + nombreF);
        if (fichero.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                Concesionario conc = (Concesionario) ois.readObject();
                conc.ImprimirListado();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("no existe el fichero");
        }
    }

    public void escribirFicheroTexto(String nombreF) {
        File directorio = new File("Ficheros");
        if (!(directorio.exists())) {
            directorio.mkdir();
        }
        String ruta = directorio + "/" + nombreF;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Coche coche : listado) {
                bw.write(coche.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void lecturaFicheroTexto(String nombreF) {
        File directorio = new File("Ficheros");
        if (directorio.exists()) {
            String ruta = directorio + "/" + nombreF;
            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("No se encuentra el fichero");
        }
    }

    public void imprimirIterando() {
        Iterator<Coche> it = listado.iterator();
        while (it.hasNext()) {
            Coche coche = it.next();
            coche.imprimir();
        }
    }
}

