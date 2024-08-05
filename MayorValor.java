import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MayorValor {
    private JFrame frame;
    private JTextField cantidadNumerosField;
    private JTextArea numerosTextArea;
    private JLabel resultadoLabel;

    public MayorValor() {
        frame = new JFrame("Encontrar el Mayor Valor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        JLabel labelCantidad = new JLabel("Cantidad de números:");
        cantidadNumerosField = new JTextField();
        JButton calcularButton = new JButton("Calcular");

        inputPanel.add(labelCantidad);
        inputPanel.add(cantidadNumerosField);
        inputPanel.add(new JLabel()); 
        inputPanel.add(calcularButton);

        numerosTextArea = new JTextArea();
        numerosTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(numerosTextArea);

        resultadoLabel = new JLabel();

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int cantidadNumeros = Integer.parseInt(cantidadNumerosField.getText());

                    if (cantidadNumeros <= 0) {
                        resultadoLabel.setText("Debe ingresar al menos un número.");
                        return;
                    }

                    double mayorValor = Double.NEGATIVE_INFINITY;

                    for (int i = 1; i <= cantidadNumeros; i++) {
                        String numeroStr = JOptionPane.showInputDialog("Ingrese el número " + i + ":");
                        double numero = Double.parseDouble(numeroStr);

                        if (numero > mayorValor) {
                            mayorValor = numero;
                        }

                        numerosTextArea.append(numeroStr + "\n");
                    }

                    resultadoLabel.setText("El mayor valor ingresado es: " + mayorValor);
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Ingresa un número válido.");
                }
            }
        });

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(resultadoLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MayorValor());
    }
}
