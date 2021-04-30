import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Chat extends JFrame{

    private JPanel panelChat, areaChat;

    private JButton botonEnviar, botonFinalizar;



    public Chat(){
        this.setTitle("GeoTalk - Chat");

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        this.setExtendedState(MAXIMIZED_BOTH);

        this.setVisible(true);

        iniciarInterfaz();
    }



    public void iniciarInterfaz(){
        paneles();
        botones();
        cajaTexto();
    }


    
    public void paneles(){

        //Panel 1
        panelChat = new JPanel();

        panelChat.setLayout(null);

        panelChat.setBackground(new Color(7, 153, 146));

        this.getContentPane().add(panelChat);


        //Panel 2
        areaChat = new JPanel();

        areaChat.setLayout(null);

        areaChat.setBounds(50, 50, 1050, 600);

        panelChat.add(areaChat);

        panelChat.revalidate();

        panelChat.repaint();
    }



    public void botones(){

        botonFinalizar = new JButton("Finalizar conversación");

        botonFinalizar.setBounds(1135, 50, 200, 60);
        botonFinalizar.setBackground(Color.red);
        botonFinalizar.setForeground(Color.white);
        botonFinalizar.setFont(new Font("Cooper Black", Font.PLAIN, 13));

        panelChat.add(botonFinalizar);




        botonEnviar = new JButton("Enviar");

        botonEnviar.setBounds(900, 530, 100, 50);
        
        areaChat.add(botonEnviar);



        //Añadimos acción a los botones.
        ActionListener oyente = new ActionListener(){

            public void actionPerformed(ActionEvent evento){
                if(evento.getSource() == botonFinalizar) finalizarInterfaz();
            }

        };
        botonFinalizar.addActionListener(oyente);
    }



    public void cajaTexto(){

        JTextField cajaTexto = new JTextField();
        cajaTexto.setBounds(100, 530, 750, 50);

        areaChat.add(cajaTexto);
    }



    public void finalizarInterfaz(){
        
        JOptionPane.showMessageDialog(null, "En el momento que oprima el botón ACEPTAR comenzará una cuenta regresiva de 5 segundos y luego será regresado al menú principal");

        esperar(5);

        this.dispose();
    }


public void esperar(int segundos){
        
        try {
            Thread.sleep(segundos * 1000);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

}
