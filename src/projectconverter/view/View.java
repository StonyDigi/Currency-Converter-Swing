package projectconverter.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class View {

	public ArrayList<IViewListener> listeners;

	public JFrame frmCurrencyConverterApplication;
	public JTextField txtAmount;
	@SuppressWarnings("rawtypes")
	public JComboBox txtFrom;
	@SuppressWarnings("rawtypes")
	public JComboBox txtTo;
	public JButton btnConvert;

	/**
	 * Create the application.
	 */

	public View() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmCurrencyConverterApplication = new JFrame();
		frmCurrencyConverterApplication.setTitle("Currency Converter Application (EUR, USD, HUF)");
		frmCurrencyConverterApplication.setBounds(100, 100, 582, 600);
		frmCurrencyConverterApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCurrencyConverterApplication.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 535, 549);
		frmCurrencyConverterApplication.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("Amount *: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtAmount = new JTextField();
		txtAmount.setColumns(10);

		txtFrom = new JComboBox();
		txtFrom.setModel(new DefaultComboBoxModel(new String[] { "EUR", "USD", "HUF" }));
		txtFrom.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtTo = new JComboBox();
		txtTo.setModel(new DefaultComboBoxModel(new String[] { "HUF", "USD", "EUR" }));
		txtTo.setFont(new Font("Tahoma", Font.BOLD, 14));

		JButton btnCurrencyConverterApp = new JButton();
		btnCurrencyConverterApp.setText("Currency Converter");
		btnCurrencyConverterApp.setFont(new Font("Tahoma", Font.BOLD, 18));

		btnConvert = new JButton();
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("katt");
				notifyListenersOnButtonClickedConvert();

			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConvert.setText("CONVERT");
		btnConvert.setBackground(new Color(255, 204, 102));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								Alignment.LEADING,
								gl_panel.createSequentialGroup().addGap(192)
										.addComponent(
												btnConvert, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(258, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup().addGap(16)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(txtTo, GroupLayout.PREFERRED_SIZE, 249,
														GroupLayout.PREFERRED_SIZE)
												.addGap(243))
										.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
														.addGroup(Alignment.TRAILING,
																gl_panel.createSequentialGroup()
																		.addComponent(txtFrom, 0, 249, Short.MAX_VALUE)
																		.addPreferredGap(ComponentPlacement.RELATED))
														.addComponent(txtAmount, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
														.addComponent(btnCurrencyConverterApp, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
												.addGap(243)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addComponent(btnCurrencyConverterApp, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				.addGap(81)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
				.addGap(98).addComponent(txtFrom, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE).addGap(36)
				.addComponent(txtTo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
				.addComponent(btnConvert, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE).addGap(28)));
		panel.setLayout(gl_panel);
	}

	public void addListener(IViewListener listener) {
		listeners.add(listener);
	}
	
	public void notifyListenersOnButtonClickedConvert1() {
		for (IViewListener listener : listeners) {
			notifyListenersOnButtonClickedConvert1();
			
		}
	}

	public void notifyListenersOnButtonClickedConvert() {
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
			double usdHuf = 381.0974124809741;
			double roundOff = Math.round(usdHuf * 100.0) / 100.0; //két tizedesre kerekítés!!!
          convert = amount + roundOff;
//			convert = amount * 381.0974124809741;
			JOptionPane.showMessageDialog(btnConvert, "Az összeg: " + convert.toString() + " Ft");

		} else if (txtFrom.getSelectedItem().toString() == "EUR" && txtTo.getSelectedItem().toString() == "USD") {
			convert = amount * 1.0454999913465213;
			JOptionPane.showMessageDialog(btnConvert, "Az összeg: " + convert.toString() + " USD");

		} else if (txtFrom.getSelectedItem().toString() == "USD" && txtTo.getSelectedItem().toString() == "EUR") {
			convert = amount * 0.9564801609534966;
			JOptionPane.showMessageDialog(btnConvert, "Az összeg: " + convert.toString() + " EUR");
		}
	}
}