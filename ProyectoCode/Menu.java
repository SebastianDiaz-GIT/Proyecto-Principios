import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;


public class Menu extends JFrame{

		private JFrame ventana;

    protected JPanel panel;

    private JLabel etiqueta1, etiqueta2;

    private JToggleButton boton1, boton2;

    private JButton boton3;
    
    private JComboBox<String> botonLista1;



    public void iniciarComponentes(){
	ventanaMenu();
        paneles();
        etiquetas();
        botones();
    }



    public void ventanaMenu(){

				ventana = new JFrame();

        ventana.setExtendedState(MAXIMIZED_BOTH); //Hacemos que la ventana aparezca en pantalla completa de manera predeterminada
        ventana.setTitle("GeoTalk - Conversa y comparte con los demás");
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE); //Hacemos que se pare de ejecutar cuando se aprete el botón X

				ventana.setVisible(true);
    }



    public void paneles(){

        panel = new JPanel();  

        panel.setLayout(null); 
        panel.setBackground(new Color(7, 153, 146));  

        ventana.getContentPane().add(panel);

    }



    public void etiquetas(){


        //Etiqueta TITULO
        etiqueta1 = new JLabel("GeoTalk", SwingConstants.CENTER);

        etiqueta1.setForeground(Color.WHITE);
        etiqueta1.setFont(new Font("Cooper Black", Font.BOLD, 50)); 
        etiqueta1.setBounds(568, 100, 230, 60); 

        panel.add(etiqueta1); 



        //Etiqueta IMAGEN
        etiqueta2 = new JLabel(new ImageIcon("Tierra.png"));

        etiqueta2.setBounds(583, 220, 200, 200); 

        panel.add(etiqueta2);

    }



    public void botones(){

        //Primer Botón ---- icono ---- BOTON TRES BARRAS
        ImageIcon icono1 = new ImageIcon("barras.png");

        boton1 = new JToggleButton(icono1, false);

        boton1.setBounds(40, 50, 70, 70);
        icono1.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH);

        panel.add(boton1);



        //Segundo botón ---- icono ---- BOTÓN PERFIL
        ImageIcon icono2 = new ImageIcon("usuario.png");

        boton2 = new JToggleButton(icono2, false);

        boton2.setBounds(1256, 50, 70, 70);
        icono2.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH);

        panel.add(boton2);



        //Tercer botón ---- texto ---- BOTÓN INICIAR CONVERSACIÓN
        boton3 = new JButton("Iniciar conversación");

        boton3.setBounds(533, 580, 300, 40);
        boton3.setFont(new Font("Cooper Black", Font.PLAIN, 15));

        panel.add(boton3);



        //Cuarto boton ---- lista ---- BOTÓN ESCOGER

        String[] lista = {"Elegir modo de conversación","Chat", "Llamada", "Videollamada"};

        botonLista1 = new JComboBox<String>(lista);

        botonLista1.setBounds(533, 500, 300, 40);
        botonLista1.setFont(new Font("Cooper Black", Font.PLAIN, 15));

        panel.add(botonLista1);



        //Acción de los botones:
        ActionListener oyente = new ActionListener(){

            public void actionPerformed(ActionEvent evento){

                if((botonLista1.getSelectedIndex() == 1) && (evento.getSource() == boton3)){

                    Chat chat = new Chat();
                    chat.iniciarInterfaz();
       System.out.println("Entro a la accion boton");             
                }
            }

        };
        boton3.addActionListener(oyente);
    }



    public static void main(String[] args) {
        
        Menu menu = new Menu();

        menu.iniciarComponentes();
    }
}
