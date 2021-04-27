import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Menu extends JFrame{

    static JFrame ventana;

    JPanel panel;

    JLabel etiqueta1, etiqueta2;

    JButton boton1, boton2, boton3;
    
    JComboBox<String> botonLista1;


    public Menu(){

        this.setExtendedState(MAXIMIZED_BOTH); //Hacemos que la ventana aparezca en pantalla completa de manera predeterminada

        this.setTitle("GeoTalk - Conversa y comparte con los demás");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Hacemos que se pare de ejecutar cuando se aprete el botón X

        iniciarComponentes();
    }


    public void iniciarComponentes(){
        paneles();
        etiquetas();
        boton1();
        boton2();
        botonLista1();
        boton3();
    }


    private void paneles(){

        panel = new JPanel();  //El panel se puede explicar como la analogía de que el JFrame es una mesa y para escribir algo necesitamos un papel, porque sería malo rayar encima de la mesa, por ende el JPanel es ese papel que ponemos encima de la mesa, y allí si podríamos escribir a gusto.

        panel.setLayout(null); //Descativamos el diseño default
        panel.setBackground(new Color(7, 153, 146)); //Coloreamos el panel 

        this.getContentPane().add(panel); //Agreagamos el panel a la ventana

    }

    private void etiquetas(){


        //Etiqueta TITULO
        etiqueta1 = new JLabel("GeoTalk", SwingConstants.CENTER);

        etiqueta1.setForeground(Color.WHITE); //Le ponemos el color blanco
        etiqueta1.setFont(new Font("Cooper Black", Font.BOLD, 50)); //Editamos la fuiente de texto 
        etiqueta1.setBounds(568, 100, 230, 60); //Le damos una ubicación a ese texto.

        panel.add(etiqueta1); //Añadimos el texto al panel



        //Etiqueta IMAGEN

        etiqueta2 = new JLabel(new ImageIcon("Tierra.png"));

        etiqueta2.setBounds(583, 220, 200, 200); //Le damos una ubicación y el tamaño a la imagen.

        panel.add(etiqueta2);

    }

    private void boton1(){


        //Primer Botón ---- icono ---- BOTON TRES BARRAS
        ImageIcon icono1 = new ImageIcon("barras.png");

        boton1 = new JButton(icono1);

        boton1.setBounds(40, 50, 70, 70);
        icono1.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH);

        panel.add(boton1);

    }

    public void boton2(){

        //Segundo botón ---- icono ---- BOTÓN PERFIL

        ImageIcon icono2 = new ImageIcon("usuario.png");

        boton2 = new JButton(icono2);

        boton2.setBounds(1256, 50, 70, 70);
        icono2.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH);

        panel.add(boton2);

    }

    public void botonLista1(){

        //Tercer botón ---- lista ---- BOTÓN ESCOGER

        String[] lista = {"Elegir modo de conversación","Chat", "Llamada", "Videollamada"};

        botonLista1 = new JComboBox<String>(lista);

        botonLista1.setBounds(533, 500, 300, 40);
        botonLista1.setFont(new Font("Cooper Black", Font.PLAIN, 15));

        panel.add(botonLista1);

    }

    public void boton3(){
        //Cuarto botón ---- texto ---- BOTÓN INICIAR

        boton3 = new JButton("Iniciar conversación");

        boton3.setBounds(533, 580, 300, 40);
        boton3.setFont(new Font("Cooper Black", Font.PLAIN, 15));

        panel.add(boton3);
    }

    public static void main(String[] args) {
        
        ventana = new Menu();

        ventana.setVisible(true);
    }

}
