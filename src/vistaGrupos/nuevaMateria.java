/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaGrupos;

import controlador.traerDatos;
import controlador.unidades;
import controlador.validaciones;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
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
public class nuevaMateria implements ActionListener, MouseListener, KeyListener, ItemListener {

    JFrame ventana;
    Font titulop;
    Font titulopb, mini;
    Font subtitulos;
    Color azul, whitesmoke;
    Color azulAcento;
    Color blanco;
    JLabel titulo, sub, descripcion;
    JPanel arriba, abajo, unidades;
    JTextField nombre, salon, buscarDisponible, buscarAsignar;
    JButton cerrar, guardar, agreg;
    JComboBox semestre, especialidad;
    ButtonGroup turno;
    JRadioButton matutino, vespertino;
    String nomMat;
    int semes, are;
    JScrollPane scrollpane, disponibles, asignar;
    JSeparator linea;
    DefaultTableModel modDisoponible, modAsignar, agregarAsignar, eliminarAsignar, agregarDisponible, eliminarDisponible;
    JTable tablaDisponible, tablaAsignar;
    String[] columna = { "Unidad", "Profesor", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
    Object[][] datosDisponeble
            = {
                {"Física III", "Pedrickies", "---", "11:00 - 12:00", "---", "12:00 - 14:00", "7:00 - 9:00"},
                {"Cálculo Integral", "Citlali", "8:00 - 9:00", "12:00 - 13:00", "11:00 - 13:00", "8:00 - 9:00", "---"},
            };
    private String titu;

    public nuevaMateria() {
        ventana = new JFrame("Nueva Unidad - PoliAsistencia");
        ventana.setBounds(30, 30, 1300, 650);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/img/poliAsistencia.png")).getImage();
        ventana.setIconImage(icono);
        ventana.setResizable(false);
        ventana.setLayout(null);
        nomMat = "";
        semes = 0;
        are = 0;
        titu = "Crear Unidad";
    }
    public nuevaMateria(String datos[]) {
        ventana = new JFrame("Modificar Unidad - PoliAsistencia");
        ventana.setBounds(30, 30, 1300, 650);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono = new ImageIcon(getClass().getResource("/img/poliAsistencia.png")).getImage();
        ventana.setIconImage(icono);
        ventana.setResizable(false);
        ventana.setLayout(null);
        nomMat=datos[1];
        semes = Integer.parseInt(datos[3]);
        are = Integer.parseInt(datos[2]);
        titu = "Modificar Unidad";
    }

    public void crearComponentes(boolean permiso) {
        
        blanco = new Color(255, 255, 255);
        azulAcento = new Color(0, 145, 234);
        azul = new Color(0, 176, 255);
        whitesmoke = new Color(245,245,245);
        subtitulos = new Font("Arial", 0, 25);
        titulopb = new Font("Calibri", 1, 20);
        mini = new Font("Calibri", 0, 16);
        titulop = new Font("Calibri", 0, 60);

        //Titulos
        titulo = new JLabel(titu);
        titulo.setBounds(490, 5, 700, 100);
        titulo.setFont(titulop);
        titulo.setForeground(blanco);
        ventana.add(titulo);

        ImageIcon atras = new ImageIcon(new ImageIcon(getClass().getResource("/img/atras.png")).getImage());
        cerrar = new JButton("<html>&nbsp;Regresar</html>", atras);
        cerrar.setBounds(20, 23, 200, 50);
        cerrar.setBackground(azulAcento);
        cerrar.setBorder(BorderFactory.createLineBorder(blanco, 2));
        cerrar.setFont(new java.awt.Font("Arial", 0, 19));
        cerrar.setForeground(blanco);
        cerrar.setFocusPainted(false);
        cerrar.addActionListener(this);
        ventana.add(cerrar);
        
        agreg = new JButton(titu);
        agreg.setBounds(1070, 23, 200, 50);
        agreg.setBackground(azulAcento);
        agreg.setBorder(BorderFactory.createLineBorder(blanco, 2));
        agreg.setFont(new java.awt.Font("Arial", 0, 17));
        agreg.setForeground(blanco);
        agreg.addActionListener(this);
        ventana.add(agreg);

        arriba = new JPanel();
        arriba.setBounds(0, 0, 1300, 100);
        arriba.setBackground(azulAcento);
        ventana.add(arriba);

        //Contenido

        /*
         b2.setVerticalTextPosition(AbstractButton.BOTTOM);
         b2.setHorizontalTextPosition(AbstractButton.CENTER);
         */
        

        abajo = new JPanel(new GridLayout());
        abajo.setPreferredSize(new Dimension(1300, 1000));
        //abajo.setBounds(0, 100, 1300, 570);
        abajo.setBackground(blanco);
        abajo.setLayout(null);
        
        sub = new JLabel("Para agregar una unidad de Aprendizaje, debe de llenar el siguiente formulario");
        sub.setBounds(170, 30, 900, 40);
        sub.setFont(subtitulos);
        sub.setForeground(azulAcento);
        abajo.add(sub);
        
        //nombre 260, 90, 400, 50
        descripcion = new JLabel("Nombre de la materia");
        descripcion.setBounds(280, 110, 400, 50);
        descripcion.setFont(titulopb);
        abajo.add(descripcion);
        
        
        nombre = new JTextField(nomMat);
        nombre.setBounds(470, 120, 530, 30);
        nombre.setBorder(BorderFactory.createLineBorder(azul, 1));
        nombre.setBackground(blanco);
        nombre.setFont(titulopb);
        abajo.add(nombre);
        
        
        
        descripcion = new JLabel("Semestre");
        descripcion.setBounds(380, 180, 400, 50);
        descripcion.setFont(titulopb);
        abajo.add(descripcion);
        
        semestre = new JComboBox();
        semestre.addItem("Seleccione una opción");
        semestre.addItem("1");
        semestre.addItem("2");
        semestre.addItem("3");
        semestre.addItem("4");
        semestre.addItem("5");
        semestre.addItem("6");
        semestre.setBounds(470, 190, 530, 30);
        semestre.setBorder(BorderFactory.createLineBorder(azulAcento, 0));
        semestre.setBackground(blanco);
        semestre.setForeground(Color.gray);
        semestre.setFont(titulopb);
        semestre.setSelectedIndex(semes);
        semestre.addActionListener(this);
        abajo.add(semestre);
        
        //50
        
        descripcion = new JLabel("Especialidad");
        descripcion.setBounds(350, 250, 400, 50);
        descripcion.setFont(titulopb);
        abajo.add(descripcion);
        
        especialidad = new JComboBox();
        traerDatos td = new traerDatos();
        String datosAreas[] = td.traerAreas();
        especialidad.addItem("Seleccione una opción");
        for (String datosArea : datosAreas) {
            especialidad.addItem(datosArea);
        }
        especialidad.addItem("Agregar nueva especialidad");
        especialidad.setBounds(470, 260, 530, 30);
        especialidad.setBorder(BorderFactory.createLineBorder(azulAcento, 0));
        especialidad.setBackground(blanco);
        especialidad.setForeground(Color.gray);
        especialidad.setFont(titulopb);
        especialidad.setSelectedIndex(are);
        especialidad.addItemListener(this);
        abajo.add(especialidad);
        
        //50
        
//        descripcion = new JLabel("Salón");
//        descripcion.setBounds(400, 240, 400, 50);
//        descripcion.setFont(titulopb);
//        abajo.add(descripcion);
//        
//        salon = new JTextField();
//        salon.setBounds(470, 250, 530, 30);
//        salon.setBorder(BorderFactory.createLineBorder(azul, 1));
//        salon.setBackground(blanco);
//        salon.setFont(titulopb);
//        abajo.add(salon);
        
        
        
        //50
//        descripcion = new JLabel("Turno");
//        descripcion.setBounds(610, 320, 400, 50);
//        descripcion.setFont(titulopb);
//        abajo.add(descripcion);
//        
//        turno = new ButtonGroup();
//        matutino = new JRadioButton("Matutino");
//        matutino.setBounds(500, 350, 120, 50);
//        matutino.setFont(titulopb);
//        matutino.setBackground(blanco);
//        abajo.add(matutino);
//        
//        vespertino = new JRadioButton("Vespertino");
//        vespertino.setBounds(650, 350, 120, 50);
//        vespertino.setFont(titulopb);
//        vespertino.setBackground(blanco);
//        abajo.add(vespertino);
//            
//        turno.add(matutino);
//        turno.add(vespertino);
//        
//        descripcion = new JLabel("Unidades de Aprendizaje");
//        descripcion.setBounds(540, 370, 400, 50);
//        descripcion.setFont(titulopb);
//        abajo.add(descripcion);
//        
//        descripcion = new JLabel("Da clic en una materia para cambiarla de tabla");
//        descripcion.setBounds(400, 410, 900, 40);
//        descripcion.setFont(subtitulos);
//        descripcion.setForeground(azulAcento);
//        abajo.add(descripcion);
//        
//        unidades = new JPanel();
//        unidades.setBackground(whitesmoke);
//        unidades.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
//        unidades.setLayout(null);
//        unidades.setBounds(30, 470, 1220, 510);
//        
//        modDisoponible = new DefaultTableModel(datosDisponeble, columna);
//        tablaDisponible = new JTable(modDisoponible);
//        tablaDisponible.addMouseListener(this);
//        tablaDisponible.setDefaultEditor(Object.class, null);
//        tablaDisponible.getTableHeader().setReorderingAllowed(false);
//        
//        disponibles = new JScrollPane(tablaDisponible);
//        disponibles.setBounds(5, 50, 600, 450);
//        unidades.add(disponibles);
//        
//        sub = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Unidades de Aprendizaje Disponibles</html>");
//        sub.setBounds(5, 20, 599, 30);
//        sub.setFont(subtitulos);
//        sub.setFont(titulopb);
//        sub.setForeground(blanco);
//        sub.setBackground(Color.gray);
//        sub.setOpaque(true);
//        unidades.add(sub);
//        
//        
//        
//        modAsignar = new DefaultTableModel(null, columna);
//        tablaAsignar = new JTable(modAsignar);
//        tablaAsignar.addMouseListener(this);
//        tablaAsignar.setDefaultEditor(Object.class, null);
//        tablaAsignar.getTableHeader().setReorderingAllowed(false);
//        
//        asignar = new JScrollPane(tablaAsignar);
//        asignar.setBounds(610, 50, 600, 450);
//        unidades.add(asignar);
//        
//        sub = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Unidades de Aprendizaje a Asignar</html>");
//        sub.setBounds(610, 20, 599, 30);
//        sub.setFont(subtitulos);
//        sub.setFont(titulopb);
//        sub.setForeground(blanco);
//        sub.setBackground(azulAcento);
//        sub.setOpaque(true);
//        unidades.add(sub);
//        
//        abajo.add(unidades);
        
        
        scrollpane = new JScrollPane(abajo, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setBounds(0, 100, 1295, 523);
        scrollpane.getVerticalScrollBar().setUnitIncrement(16);
        ventana.add(scrollpane);

        ventana.setVisible(permiso);

    }

    @Override
    public void actionPerformed(ActionEvent a) {

        if (a.getSource() == cerrar) {
            if(semes>0){
                ventana.dispose();
                mostrarUnidades abrir = new mostrarUnidades();
                abrir.crearComponentes(true);
            }else{
                ventana.dispose();
                inicioUnidades abrir = new inicioUnidades();
                abrir.crearComponentes(true);
            }
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
            int semest, idAr;
            String nomMate = nombre.getText();
            semest = semestre.getSelectedIndex();
            idAr = especialidad.getSelectedIndex();
            validaciones val = new validaciones();
            if(val.sinVacios(nomMate, "el nombre de la materia",300)){
                if(semest > 0){
                    if(idAr > 0){
                        unidades uni = new unidades();
                        int correcto;
                        String mensa;
                        if(semes>0){
                            correcto=uni.modificaUnidad(nomMat, idAr, nomMate, semest);
                            mensa = "Unidad modificada con exito";
                        }else{
                            correcto = uni.nuevaUnidad(idAr, nomMate, semest);
                            mensa = "Nueva materia registrada con exito";
                        }
                        
                        if(correcto > 0){
                            JOptionPane.showMessageDialog(ventana, mensa);
                            nombre.setText("");
                            semestre.setSelectedIndex(0);
                            especialidad.setSelectedIndex(0);
                        }else{
                            JOptionPane.showMessageDialog(ventana, uni.getMsj(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(ventana, "Seleccione una especialidad", "Error", JOptionPane.ERROR_MESSAGE);
                        especialidad.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(ventana, "Seleccione un semestre", "Error", JOptionPane.ERROR_MESSAGE);
                    semestre.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(ventana, val.err(),"Error", JOptionPane.ERROR_MESSAGE);
                nombre.requestFocus();
            }
            
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
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        String cadena = (buscarDisponible.getText()).toUpperCase();
        controlador.filtro filtrar = new controlador.filtro();
        filtrar.buscar(cadena, tablaDisponible);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int maximo = especialidad.getItemCount() - 1;
        if(maximo == especialidad.getSelectedIndex()){
            String nuevo = JOptionPane.showInputDialog(ventana, "Ingrese la nueva especialidad", "Agregar especialidad", JOptionPane.DEFAULT_OPTION);
            unidades uni = new unidades();
            String retu = uni.agregarEspecialidad(nuevo);
            JOptionPane.showMessageDialog(ventana, retu);
            if(retu.equals("Guardado correctamente")){
                especialidad.removeItemAt(maximo);
                especialidad.addItem(nuevo);
                especialidad.addItem("Agregar nueva especialidad");
                especialidad.setSelectedIndex(maximo);
            }
        }
        System.out.println(especialidad.getSelectedItem().toString());
    }
        
    }





