import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class AnimalBase implements Animal {
    private String nombre;

    public AnimalBase(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Leon extends AnimalBase {
    public Leon(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerRuido() {
        System.out.println("El león ruge");
    }

    @Override
    public void moverse() {
        System.out.println("El león corre");
    }
}

class Elefante extends AnimalBase {
    public Elefante(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerRuido() {
        System.out.println("El elefante barrita");
    }

    @Override
    public void moverse() {
        System.out.println("El elefante camina");
    }
}

class Pajaro extends AnimalBase {
    public Pajaro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerRuido() {
        System.out.println("El pájaro canta");
    }

    @Override
    public void moverse() {
        System.out.println("El pájaro vuela");
    }
}

class Zoologico {
    private List<Animal> animales;

    public Zoologico() {
        this.animales = new ArrayList<>();
    }

    public void añadirAnimal(Animal animal) {
        animales.add(animal);
    }

    public void mostrarAnimales() {
        for (Animal animal : animales) {
            System.out.println("Tipo de animal: " + animal.getClass().getSimpleName());
            animal.hacerRuido();
            animal.moverse();
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Añadir animal");
            System.out.println("2. Mostrar animales");
            System.out.println("3. Salir");


            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Selecciona el tipo de animal (1: León, 2: Elefante, 3: Pájaro): ");
                    int tipoAnimal = scanner.nextInt();
                    Animal animal;
                    switch (tipoAnimal) {
                        case 1:
                            animal = new Leon("Simba");
                            break;
                        case 2:
                            animal = new Elefante("Dumbo");
                            break;
                        case 3:
                            animal = new Pajaro("Piolín");
                            break;
                        default:
                            animal = null;
                            break;
                    }
                    zoologico.añadirAnimal(animal);
                    break;
                case 2:
                    zoologico.mostrarAnimales();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3);
        System.out.println("Hasta Luego!");

        scanner.close();
    }
}