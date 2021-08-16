import java.awt.EventQueue;

import view.VistaRequerimientosReto4;

public class App {
	
    public static void main( String[] args ){        


    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRequerimientosReto4 frame = new VistaRequerimientosReto4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

    	
    }
}