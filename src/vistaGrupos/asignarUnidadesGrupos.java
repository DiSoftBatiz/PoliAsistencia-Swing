/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaGrupos;

import controlador.traerDatos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import vistaUsuarios.editarAlumnos;

/**
 *
 * @author PoliAsistencia
 */
public class asignarUnidadesGrupos implements ActionListener, MouseListener, KeyListener {

    JFrame ventana;
    Font titulop;
    Font titulopb;
    Font subtitulos;
    Color azul;
    Color azulAcento;
    Color blanco;
    JLabel titulo, tituloBold, dnombre, sub, dcontrasena, dcontrasena2, confirm = new JLabel("<html>¿Estás seguro de que deseas dar de baja a este Profesor? <br>Se necesita tu contraseña para continuar</html>");
    JPanel arriba, abajo;
    JTextField nombre, paterno, materno, boleta, buscador;
    JPasswordField contrasena, contrasenax2, contrasenaConfirmacion = new JPasswordField();; 
    JSeparator lineaNombre, lineaCont, lineaCont2;
    JButton huella, cerrar, guardar, borrar, agreg;
    JCheckBox eleccion = new JCheckBox("No mostrar este dialogo mientras se esté registrando");
    int box = 0;
    Object[] agregar;
    JComboBox genero;
    DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    JFormattedTextField nacimiento;
    String id = "";
    DefaultTableModel modelo;
    JTable tabla;
    JScrollPane scrollpane;
    String[] columnNames = { "Grupo", "Semestre", "Turno", "Especialidad"};
    Object[][] datos;
    int _tipo=0;

    public asignarUnidadesGrupos(int tipoAcc) {
        ventana = new JFrame("Asignar unidades a Grupos - PoliAsistencia");
        ventana.setBounds(30, 30, 1300, 650);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/img/poliAsistencia.png")).getImage();
        ventana.setIconImage(icono);
        ventana.setResizable(false);
        ventana.setLayout(null);
        traerDatos td = new traerDatos();
        datos = td.grupos();
        _tipo = tipoAcc;
    }

    public void crearComponentes(boolean permiso) {

        eleccion.addActionListener(this);
        agregar = new Object[]{confirm, contrasenaConfirmacion};
        
        blanco = new Color(255, 255, 255);
        azulAcento = new Color(0, 145, 234);
        azul = new Color(0, 176, 255);
        subtitulos = new Font("Arial", 0, 25);
        titulopb = new Font("Calibri", 1, 17);
        titulop = new Font("Calibri", 0, 60);

        //Titulos
        titulo = new JLabel("Asignar unidades a Grupos ");
        titulo.setBounds(500, 5, 700, 100);
        titulo.setFont(titulop);
        titulo.setForeground(blanco);
        ventana.add(titulo);

        ImageIcon atras = new ImageIcon(new ImageIcon(getClass().getResource("/img/atras.png")).getImage());
        cerrar = new JButton("<html>&nbsp;Inicio</html>", atras);
        cerrar.setBounds(20, 23, 200, 50);
        cerrar.setBackground(azulAcento);
        cerrar.setBorder(BorderFactory.createLineBorder(blanco, 2));
        cerrar.setFont(new java.awt.Font("Arial", 0, 19));
        cerrar.setForeground(blanco);
        cerrar.setFocusPainted(false);
        cerrar.addActionListener(this);
        ventana.add(cerrar);

        arriba = new JPanel();
        arriba.setBounds(0, 0, 1300, 100);
        arriba.setBackground(azulAcento);
        ventana.add(arriba);

        //Contenido

        /*
         b2.setVerticalTextPosition(AbstractButton.BOTTOM);
         b2.setHorizontalTextPosition(AbstractButton.CENTER);
         */
//        sub = new JLabel("Para agregar una un grupo, debe de llenar el siguiente formulario");
//        sub.setBounds(130, 110, 900, 40);
//        sub.setFont(subtitulos);
//        sub.setForeground(azulAcento);
//        ventana.add(sub);
//        
//        agreg = new JButton("Agregar Grupo");
//        agreg.setBounds(990, 110, 200, 40);
//        agreg.setBackground(blanco);
//        agreg.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
//        agreg.setFont(new java.awt.Font("Arial", 0, 17));
//        agreg.setForeground(Color.GREEN);
//        agreg.setFocusPainted(false);
//        agreg.addActionListener(this);
//        ventana.add(agreg);
        
        
sub = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grupos</html>");
        sub.setBounds(50, 110, 1200, 40);
        sub.setFont(subtitulos);
        sub.setForeground(blanco);
        sub.setBackground(Color.LIGHT_GRAY);
        sub.setOpaque(true);
        ventana.add(sub);
        
        sub = new JLabel("Filtrar con Semestre");
        sub.setBounds(50, 150, 1200, 30);
        sub.setFont(titulopb);
        sub.setOpaque(true);
        ventana.add(sub);
        
        buscador = new JTextField();
        buscador.setBounds(215, 155, 1000, 20);
        buscador.addKeyListener(this);
        ventana.add(buscador);
        
        modelo = new DefaultTableModel(datos, columnNames);
        tabla = new JTable(modelo);
        tabla.addMouseListener(this);
        tabla.isCellEditable(0, 0);
        scrollpane = new JScrollPane(tabla);

        scrollpane.setBounds(50, 230, 1200, 340);
        ventana.add(scrollpane);
        
        sub = new JLabel("Da clic en un grupo para editar o consultar su información");
        sub.setBounds(290, 573, 1000, 40);
        sub.setFont(subtitulos);
        sub.setForeground(Color.gray);
        ventana.add(sub);

        abajo = new JPanel();
        abajo.setBounds(0, 100, 1300, 570);
        abajo.setBackground(blanco);
        ventana.add(abajo);

        ventana.setVisible(permiso);

    }

    @Override
    public void actionPerformed(ActionEvent a) {

        if (a.getSource() == cerrar) {
            ventana.dispose();
            inicioGrupos abrir = new inicioGrupos();
            abrir.crearComponentes(true);
        }
        
        if (a.getSource() == guardar) {
            /*
            * -1 = cerrado
            * 0 = si
            * 1 = no
             */
                JOptionPane.showMessageDialog(ventana, "Datos Guardados correctamente");
                ventana.dispose();
                editarAlumnos abrir = new editarAlumnos();
                abrir.crearComponentes(true);
            }
        if(a.getSource() == agreg){
            ventana.dispose();
            agregarGrupo abrir = new agregarGrupo();
            abrir.crearComponentes(true);
        }
            
        }

    @Override
    public void mouseClicked(MouseEvent me) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (tabla.getSelectedRow() == i) {
                ventana.dispose();
                if(_tipo == 1){
                    unidadesGrupos abrir = new unidadesGrupos((String)tabla.getValueAt(i, 0));
                    abrir.crearComponentes(true);
                }else{
                    asignarHorario abrir = new asignarHorario((String)tabla.getValueAt(i, 0));
                    abrir.crearComponentes(true);
                }
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String cadena = (buscador.getText()).toUpperCase();
        controlador.filtro filtrar = new controlador.filtro();
        filtrar.buscar(cadena, tabla);
    }
        
    }





