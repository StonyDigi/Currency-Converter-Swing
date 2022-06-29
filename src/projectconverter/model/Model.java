package projectconverter.model;



import javax.swing.JOptionPane;

import projectconverter.view.View;

public class Model extends View implements IModel {
	
	public void currencyExhange() {
		Double convert;
		Double amount = Double.parseDouble(txtAmount.getText());

		if (txtFrom.getSelectedItem().toString() == "EUR" && txtTo.getSelectedItem().toString() == "HUF") {
			convert = amount * 398.4373414510401;
			JOptionPane.showMessageDialog(btnConvert, "Az összeg: " + convert.toString() + " Ft");

		} else if (txtFrom.getSelectedItem().toString() == "HUF" && txtTo.getSelectedItem().toString() == "EUR") {
			convert = amount * 0.0025098049202872713;
			JOptionPane.showMessageDialog(btnConvert, "Az összeg: " + convert.toString() + " EUR");

		} else if (txtFrom.getSelectedItem().toString() == "HUF" && txtTo.getSelectedItem().toString() == "USD") {
			convert = amount * 0.002624001022441799;
			JOptionPane.showMessageDialog(btnConvert, "Az összeg: " + convert.toString() + " USD");

		} else if (txtFrom.getSelectedItem().toString() == "USD" && txtTo.getSelectedItem().toString() == "HUF") {
//			double usdHuf = 381.0974124809741;
//			double roundOff = Math.round(usdHuf * 100.0) / 100.0; //két tizedesre kerekítés!!!
//          convert = amount * roundOff
			convert = amount * 381.0974124809741;
			JOptionPane.showMessageDialog(btnConvert, "Amount: " + convert.toString() + " Ft");

		} else if (txtFrom.getSelectedItem().toString() == "EUR" && txtTo.getSelectedItem().toString() == "USD") {
			convert = amount * 1.0454999913465213;
			JOptionPane.showMessageDialog(btnConvert, "Amount: " + convert.toString() + " USD");

		} else if (txtFrom.getSelectedItem().toString() == "USD" && txtTo.getSelectedItem().toString() == "EUR") {
			convert = amount * 0.9564801609534966;
			JOptionPane.showMessageDialog(btnConvert, "Amount: " + convert.toString() + " EUR");
		}
		
	}
}