package projectconverter.mainapp;

import java.awt.EventQueue;

import projectconverter.view.View;


public class App {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frmCurrencyConverterApplication.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


