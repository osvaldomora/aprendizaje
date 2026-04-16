package osvaldo.morales.company.demo.practice;

import osvaldo.morales.company.demo.animals.Animal;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.valueOf;

public class ObjectCreation{

    private String name;
    private String surname;
    public ObjectCreation(){

    }


    public void setName(String name){
        this.name=name;
        ObjectCreation ob= new ObjectCreation();
        ob.surname="d0";
        ob.getSurname();
    }

    public void setSurname(String surname){
        this.surname=surname;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public void typesObject(){
        String string = new String();
        Animal animal = new Animal();
        Double doble = Double.valueOf(4.4);
        Integer[] array = new Integer[10];
    }

    public void ejemploWrappers(){
        // --- NÚMEROS ENTEROS ---
        // Se requiere (byte) y (short) porque los números enteros literales son 'int' por defecto
        Byte miByte = Byte.valueOf((byte) 10);
        Short miShort = Short.valueOf((short) 100);
        Integer miInteger = Integer.valueOf(1000);
        Long miLong = Long.valueOf(10000L); // Requiere sufijo L

        // --- NÚMEROS DECIMALES ---
        Float miFloat = Float.valueOf(10.5f); // Requiere sufijo f
        Double miDouble = Double.valueOf(20.99);

        // --- OTROS TIPOS ---
        Character miChar = Character.valueOf('A');
        Boolean miBoolean = Boolean.valueOf(true);

        // --- CONVERSIÓN DESDE STRING (TEXTO) ---
        // Útil cuando recibes datos de un formulario o base de datos
        Integer id = Integer.valueOf("500");
        Double precio = Double.valueOf("45.50");
        Boolean esActivo = Boolean.valueOf("true");

        // Character NO acepta String en valueOf, solo el tipo primitivo char
        // Character miError = Character.valueOf("A"); // Esto daría error
    }

    public void defineArray(){

        // Arreglo de Integers con tamaño de 5 (todos inician como null)
        Integer[] misEnteros = new Integer[5];

// Arreglo de Doubles inicializado con valores
        Double[] misPrecios = {10.5, 20.99, 30.0};

// Arreglo de Booleans
        Boolean[] respuestas = new Boolean[2];

        Character[] character = new Character[5];
        character[0] = '4';
        char[] caract = {'4'};
        List<Character> chares = new ArrayList<>();
        Integer x= Integer.valueOf(4);

        Character[] character2 = {'t','g'};

        // Lista de Integers
        List<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(100); // Agrega un elemento

// Lista de Doubles
        List<Double> listaPrecios = new ArrayList<>();
        listaPrecios.add(Double.valueOf(45.99));

// Lista de Characters
        List<Character> iniciales = new ArrayList<>();
        iniciales.add('J');
    }

    }
