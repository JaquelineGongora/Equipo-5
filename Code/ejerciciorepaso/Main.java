package ejerciciorepaso;

import Controlador.ControladorEstudiante;
import Modelo.Consultas;
import Vista.NewJFrame;
import java.awt.event.ActionEvent;
import Modelo.Estudiante;
import Vista.Inicio;

public class Main {

    
    public static void main(String[] args) {
        Estudiante producto = new Estudiante();
        NewJFrame vista = new NewJFrame();
        Consultas consultas = new Consultas();
        ControladorEstudiante controlador = new ControladorEstudiante(vista, consultas, producto);
        vista.setVisible(true);

    }
/*
