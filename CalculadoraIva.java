package hello;

/**
 *
 * @author eri
 */
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraIva extends JFrame implements ActionListener {
    private JLabel mensaje;
    private JLabel cantidad;
    private JLabel signo;
    private JLabel iva;
    
    private JButton boton;
    
    private JTextField caja;
    
    private JComboBox listaIva;
    //private JTextField caja2;
    
    private String selectIva;
    
    public CalculadoraIva(){
        super();
        configurarVentana();
        crearComponentes();
    }
    
    private void configurarVentana(){
        this.setTitle("CALCU-IVA");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void crearComponentes(){
        mensaje = new JLabel();
        mensaje.setText("CALCULANDO IVA");
        mensaje.setBounds(65,30,150,50); //x,y,tamaño ancho, tamaño alto
        mensaje.setForeground(Color.blue);
        this.add(mensaje); //Se agrega este objeto a la superclase
        
        cantidad = new JLabel();
        cantidad.setText("Cantidad");
        cantidad.setBounds(65, 50, 80, 80);
        cantidad.setForeground(Color.black);
        this.add(cantidad);
        
        signo = new JLabel();
        signo.setText("$");
        signo.setBounds(50, 90, 50, 50);
        cantidad.setForeground(Color.black);
        this.add(signo);
        
        caja = new JTextField();
        caja.setBounds(65, 100, 60, 30); //x, y, ancho, alto.
        this.add(caja);
        
        iva = new JLabel();
        iva.setText("Iva");
        iva.setBounds(65, 110, 80, 80);
        iva.setForeground(Color.black);
        this.add(iva);
        
        String[] ivaList = new String[] {" ", "16", "8"};
        JComboBox<String> listaIva = new JComboBox<>(ivaList);
        listaIva.setBounds(65,160,60,30);
        listaIva.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(listaIva.getSelectedIndex() == 0){
                    System.out.println("Seleccione un valor para el iva");
                }
                else{
                    selectIva = listaIva.getItemAt(listaIva.getSelectedIndex());
                    System.out.println("El valor del iva es: " + selectIva);
                }
            }
        });
        this.add(listaIva);
        
        /*caja2 = new JTextField();
        caja2.setBounds(65, 160, 60, 30);
        this.add(caja2);*/
        
        boton = new JButton();
        boton.setText("Calcular");
        boton.setBounds(65,200,100,30);
        boton.setForeground(Color.black);
        boton.addActionListener(this);
        this.add(boton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String numero = caja.getText();
        //String numero2 = caja2.getText();
        float num = Float.valueOf(numero);
        double num2 = .01*(Double.parseDouble(selectIva));
        
        double resultado = calcular(num,num2);
        
        JOptionPane.showMessageDialog(this, "La cantidad con iva es: " + resultado);
    }
    
    public double calcular(float num, double num2){
        double resul = num + (num * num2);
        return resul;
    }
    
    public static void main(String[] args){
        CalculadoraIva ventana = new CalculadoraIva();
        ventana.setVisible(true);
    }
}

