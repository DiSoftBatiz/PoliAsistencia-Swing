/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaUsuarios;

import controlador.sesion;
import poliasistencia.login;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import poliasistencia.Guarda21;

/**
 *
 * @author PoliAsistencia
 */
public class inicio implements ActionListener, MouseListener {

    JFrame ventana;
    Font titulop;
    Font titulopb;
    Font subtitulos;
    Color azul;
    Color azulAcento;
    Color blanco;
    JLabel titulo, tituloBold, dusuario, dcontrasena;
    JPanel arriba, abajo;
    JTextField usuario;
    JPasswordField contrasena;
    JSeparator lineaUsr, lineaCont;
    JButton alumnos, grupos, profesor, modificacion, configuracion, cerrar;

    public inicio() {
        ventana = new JFrame("Inicio - PoliAsistencia");
        ventana.setBounds(30, 30, 1300, 650);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/img/poliAsistencia.png")).getImage();
        ventana.setIconImage(icono);
        ventana.setResizable(false);
        ventana.setLayout(null);
    }

    public void crearComponentes(boolean permiso) {

        blanco = new Color(255, 255, 255);
        azulAcento = new Color(0, 145, 234);
        azul = new Color(0, 176, 255);
        subtitulos = new Font("Arial", 0, 25);
        titulopb = new Font("Calibri", 1, 93);
        titulop = new Font("Calibri", 0, 80);

        //Titulos
        titulo = new JLabel("Inicio");
        titulo.setBounds(550, 5, 400, 100);
        titulo.setFont(titulop);
        titulo.setForeground(blanco);
        ventana.add(titulo);
        
        configuracion = new JButton("Configuración");
        configuracion.setBounds(1070, 23, 200, 50);
        configuracion.setBackground(azulAcento);
        configuracion.setBorder(BorderFactory.createLineBorder(blanco, 2));
        configuracion.setFont(new java.awt.Font("Arial", 0, 17));
        configuracion.setForeground(blanco);
        configuracion.addActionListener(this);
        ventana.add(configuracion);
        
        cerrar = new JButton("Cerrar Sesión");
        cerrar.setBounds(20, 23, 200, 50);
        cerrar.setBackground(azulAcento);
        cerrar.setBorder(BorderFactory.createLineBorder(blanco, 2));
        cerrar.setFont(new java.awt.Font("Arial", 0, 17));
        cerrar.setForeground(blanco);
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

        ImageIcon iconAlumno = new ImageIcon(new ImageIcon(getClass().getResource("/img/mortarboard.png")).getImage());
        alumnos = new JButton("Registro de Alumnos", iconAlumno);
        alumnos.setBounds(170, 150, 380, 150);
        alumnos.setBackground(blanco);
        alumnos.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        alumnos.setFont(new java.awt.Font("Arial", 0, 25));
        alumnos.setForeground(azulAcento);
        alumnos.setFocusPainted(false);
        alumnos.addMouseListener(this);
        alumnos.addActionListener(this);
        ventana.add(alumnos);

        ImageIcon iconGrupo = new ImageIcon(new ImageIcon(getClass().getResource("/img/grupo.png")).getImage());
        grupos = new JButton("Inscribir a Grupos", iconGrupo);
        grupos.setBounds(700, 150, 380, 150);
        grupos.setBackground(blanco);
        grupos.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        grupos.setFont(new java.awt.Font("Arial", 0, 25));
        grupos.setForeground(azulAcento);
        grupos.setFocusPainted(false);
        grupos.addMouseListener(this);
        grupos.addActionListener(this);
        ventana.add(grupos);


        ImageIcon iconMod = new ImageIcon(new ImageIcon(getClass().getResource("/img/folder.png")).getImage());
        modificacion = new JButton("<html><center>Modificación de <br>datos</center></html>", iconMod);
        modificacion.setBounds(430, 400, 380, 150);
        modificacion.setBackground(blanco);
        modificacion.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        modificacion.setFont(new java.awt.Font("Arial", 0, 25));
        modificacion.setForeground(azulAcento);
        modificacion.setFocusPainted(false);
        modificacion.addMouseListener(this);
        modificacion.addActionListener(this);
        ventana.add(modificacion);

        abajo = new JPanel();
        abajo.setBounds(0, 100, 1300, 550);
        abajo.setBackground(blanco);
        ventana.add(abajo);

        ventana.setVisible(permiso);
        
        sesion ses = new sesion();
        if(!ses.checaHuella()){
            int evaluar = JOptionPane.showConfirmDialog(ventana, "Usted no tiene una huella para iniciar sesion ¿desea"
                    + " registrar su huella para iniciar sesion con ella?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(evaluar == 0){
                Guarda21 g21 = new Guarda21();
                g21.setVisible(true);
            }else{
                System.out.println("No");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if(a.getSource() == cerrar){
            int seg = JOptionPane.showConfirmDialog(ventana, "¿Seguro de cerrar sesión?", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
            if(seg==0){
                ventana.dispose();
                poliasistencia.login abrir = new poliasistencia.login();
                abrir.crearComponentes(true);
            }
        }
        if(a.getSource() == configuracion){
            ventana.dispose();
            configuracion abrir = new configuracion();
            abrir.crearComponentes(true);
        }
        if(a.getSource() == alumnos){
            ventana.dispose();
            registroAlumnos abrir = new registroAlumnos();
            abrir.crearComponentes(true);
        }
        if(a.getSource() == modificacion){
            ventana.dispose();
            editarAlumnos abrir = new editarAlumnos();
            abrir.crearComponentes(true);
        }
        if(a.getSource() == grupos){
            ventana.dispose();
            elegirOpcion abrir = new elegirOpcion();
            abrir.crearComponentes(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(me.getSource() == alumnos)
            alumnos.setBorder(BorderFactory.createLineBorder(azulAcento, 3));
        if(me.getSource() == grupos)
            grupos.setBorder(BorderFactory.createLineBorder(azulAcento, 3));
        if(me.getSource() == modificacion)
            modificacion.setBorder(BorderFactory.createLineBorder(azulAcento, 3));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource() == alumnos)
            alumnos.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        if(me.getSource() == grupos)
            grupos.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        if(me.getSource() == modificacion)
            modificacion.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
    }
}
