package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CambiarDorsal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public CambiarDorsal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLayout(new BorderLayout());

		JLabel titleLabel = new JLabel("CAMBIAR DORSAL");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add(titleLabel, BorderLayout.NORTH);

		JPanel buttonsPanel = new JPanel(new GridLayout(5, 5, 10, 10));
		for (int i = 1; i <= 25; i++) {
			JButton button = new JButton(Integer.toString(i));
			button.setEnabled(true);
			button.addActionListener(this);
			button.setBackground(Color.WHITE);
			buttonsPanel.add(button);
		}
		add(buttonsPanel, BorderLayout.CENTER);

		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		String buttonText = clickedButton.getText();
		int dialogResult = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas cambiar el dorsal?",
				"Confirmar", JOptionPane.YES_NO_OPTION);
		if (dialogResult == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Has confirmado cambiar el dorsal " + buttonText);
		} else {
			JOptionPane.showMessageDialog(null, "No has confirmado cambiar el dorsal " + buttonText);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			CambiarDorsal ventana = new CambiarDorsal();
			ventana.setVisible(true);
		});
	}
}
