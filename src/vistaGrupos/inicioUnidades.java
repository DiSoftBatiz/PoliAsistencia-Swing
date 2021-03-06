/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaGrupos;

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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author Alexis
 */
public class inicioUnidades implements ActionListener, MouseListener {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    JButton materias, grupos, profesor, modificacion, configuracion, cerrar;

    public inicioUnidades() {
        ventana = new JFrame("Unidades - PoliAsistencia");
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
        titulo = new JLabel("Unidades");
        titulo.setBounds(500, 5, 400, 100);
        titulo.setFont(titulop);
        titulo.setForeground(blanco);
        ventana.add(titulo);
        
//        configuracion = new JButton("Configuración");
//        configuracion.setBounds(1070, 23, 200, 50);
//        configuracion.setBackground(azulAcento);
//        configuracion.setBorder(BorderFactory.createLineBorder(blanco, 2));
//        configuracion.setFont(new java.awt.Font("Arial", 0, 17));
//        configuracion.setForeground(blanco);
//        configuracion.addActionListener(this);
//        ventana.add(configuracion);
        
        cerrar = new JButton("Regresar");
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

        ImageIcon iconProfe = new ImageIcon(new ImageIcon(getClass().getResource("/img/books.png")).getImage());
        profesor = new JButton("<html><center>Asignar horario<br>a unidades</center></html>", iconProfe);
        profesor.setBounds(170, 150, 380, 150);
        profesor.setBackground(blanco);
        profesor.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        profesor.setFont(new java.awt.Font("Arial", 0, 25));
        profesor.setForeground(azulAcento);
        profesor.setFocusPainted(false);
        profesor.addMouseListener(this);
        profesor.addActionListener(this);
        ventana.add(profesor);

        
//        //Ya no va aqui
//        /*ImageIcon iconProfe = new ImageIcon(new ImageIcon(getClass().getResource("/img/books.png")).getImage());
//        profesor = new JButton("<html><center>Registro de <br>profesores</center></html>", iconProfe);
//        profesor.setBounds(170, 150, 380, 150);
//        profesor.setBackground(blanco);
//        profesor.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
//        profesor.setFont(new java.awt.Font("Arial", 0, 25));
//        profesor.setForeground(azulAcento);
//        profesor.setFocusPainted(false);
//        profesor.addMouseListener(this);
//        profesor.addActionListener(this);
//        ventana.add(profesor);*/

        ImageIcon iconMod = new ImageIcon(new ImageIcon(getClass().getResource("/img/folder.png")).getImage());
        modificacion = new JButton("<html><center>Modificación<br>de horarios</center></html>", iconMod);
        modificacion.setBounds(700, 150, 380, 150);
        modificacion.setBackground(blanco);
        modificacion.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        modificacion.setFont(new java.awt.Font("Arial", 0, 25));
        modificacion.setForeground(azulAcento);
        modificacion.setFocusPainted(false);
        modificacion.addMouseListener(this);
        modificacion.addActionListener(this);
        ventana.add(modificacion);
        
        
        ImageIcon iconMat = new ImageIcon(new ImageIcon(getClass().getResource("/img/materias.png")).getImage());
        materias = new JButton("<html><center>Crear <br> nuevas unidades</center></html>", iconMat);
        materias.setBounds(170, 400, 380, 150);
        materias.setBackground(blanco);
        materias.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        materias.setFont(new java.awt.Font("Arial", 0, 25));
        materias.setForeground(azulAcento);
        materias.setFocusPainted(false);
        materias.addMouseListener(this);
        materias.addActionListener(this);
        ventana.add(materias);

        ImageIcon iconGrupo = new ImageIcon(new ImageIcon(getClass().getResource("/img/grupo.png")).getImage());
        grupos = new JButton("<html><center>Modificación de<br>unidades</center></html>", iconGrupo);
        grupos.setBounds(700, 400, 380, 150);
        grupos.setBackground(blanco);
        grupos.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        grupos.setFont(new java.awt.Font("Arial", 0, 25));
        grupos.setForeground(azulAcento);
        grupos.setFocusPainted(false);
        grupos.addMouseListener(this);
        grupos.addActionListener(this);
        ventana.add(grupos);
        
        abajo = new JPanel();
        abajo.setBounds(0, 100, 1300, 550);
        abajo.setBackground(blanco);
        ventana.add(abajo);

        ventana.setVisible(permiso);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        ventana.dispose();
        if(a.getSource() == cerrar){
            inicio abrir = new inicio();
            abrir.crearComponentes(true);
        }
        if(a.getSource() == configuracion){
            configuracion abrir = new configuracion();
            abrir.crearComponentes(true);
        }
        if(a.getSource() == profesor){
            agregarUnidad abrir = new agregarUnidad();
            abrir.crearComponentes(true);
        }
        if(a.getSource() == modificacion){
            modificarHorarios abrir = new modificarHorarios();
            abrir.crearComponentes(true);
        }
        if(a.getSource() == materias){
            nuevaMateria abrir = new nuevaMateria();
            abrir.crearComponentes(true);
        }
        if(a.getSource() == grupos){
            mostrarUnidades abrir = new mostrarUnidades();
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
        if(me.getSource() == materias)
            materias.setBorder(BorderFactory.createLineBorder(azulAcento, 3));
        if(me.getSource() == grupos)
            grupos.setBorder(BorderFactory.createLineBorder(azulAcento, 3));
        if(me.getSource() == profesor)
            profesor.setBorder(BorderFactory.createLineBorder(azulAcento, 3));
        if(me.getSource() == modificacion)
            modificacion.setBorder(BorderFactory.createLineBorder(azulAcento, 3));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource() == materias)
            materias.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        if(me.getSource() == grupos)
            grupos.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        if(me.getSource() == profesor)
            profesor.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        if(me.getSource() == modificacion)
            modificacion.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
    }
}

