package osvaldo.morales.company.demo.java8.finterfaces.thead;

public class Java1001 {

	public static void main(String[] args) {
     
		
		// Se instancian dos nuevos objetos Thread
        Thread hiloA = new Thread( new MiHilo(),"hiloA" );
        Thread hiloB = new Thread( new MiHilo(),"hiloB" );

        // Se arrancan los dos hilos, para que comiencen su ejecuci�n
        hiloA.start();
        hiloB.start();
    
        // Aqu� se retrasa la ejecuci�n un segundo y se captura la
        // posible excepci�n que genera el m�todo, aunque no se hace
        // nada en el caso de que se produzca
        try {
            Thread.currentThread().sleep( 1000 );
        }catch( InterruptedException e ){}

        // Presenta informaci�n acerca del Thread o hilo principal 
        // del programa
        System.out.println( Thread.currentThread() );        

        // Se detiene la ejecuci�n de los dos hilos
        hiloA.stop();
        hiloB.stop();
        }
		
		
		
	}

class NoHaceNada {
	// Esta clase existe solamente para que sea heredada por la clase
	// MiHilo, para evitar que esta clase sea capaz de heredar la clase
	// Thread, y se pueda implementar el interfaz Runnable en su
	// lugar
	}

	class MiHilo extends NoHaceNada implements Runnable {
	    public void run() {
	        // Presenta en pantalla informaci�n sobre este hilo en particular
	        System.out.println( Thread.currentThread() );
	        }
	    }
