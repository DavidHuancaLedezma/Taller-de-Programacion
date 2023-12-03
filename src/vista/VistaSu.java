/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableModel;
import manualProcedimiento.DatosProcedimientos;
import manualProcedimiento.Procedimiento;
import manualProcedimiento.Interventores;
import manualProcedimiento.ListaProcedimientos;
import manualProcedimiento.OperationPolicy;
import modelo.*;
import manualProcedimiento.InterventorSU;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.sql.Blob;
import javax.swing.JLabel;
import javax.swing.JTable;
import manualProcedimiento.ProcedimientoSU;
import manualProcedimiento.DatosInterventor;
import manualProcedimiento.ListaDeActividades;
/**
 *C
 * Se realizo cambios
 */
@SuppressWarnings("unchecked") //ignore advertencia

public class VistaSu extends javax.swing.JFrame {

    /**
     * Creates new form VistaSu
     */
    private DefaultComboBoxModel modelo;
    private DefaultComboBoxModel modelo2;
    private DefaultComboBoxModel modelo3;
    private DefaultComboBoxModel modelo4;
    private DefaultComboBoxModel modelo5;
    private DefaultComboBoxModel modeloProcedimiento;
    private DefaultComboBoxModel modeloProcedimiento2;
    private DefaultComboBoxModel modeloPoliticasOperacion;
    private boolean existeProcedimientoP = false;
    private ArrayList<String>funcionGeneral = new ArrayList<String>();
    private ArrayList<String>funcionesEspesificas = new ArrayList<String>();
    // NO BORRAR ESTAS LISTAS SON IMPORTANTES
    private ArrayList<Experiencia> listaExp;
    int indiceExp = 0;
    public int idPuesto =-1; //Variable exclusiva para la insercion en otra tabla creada por erick
    
    //variables para imagen
    private FileInputStream fis;
    private int longitudBytes;
    //variables para ImagenProcedimiento
    private FileInputStream fiss;
    private int longitudBytess;
    
    public int idDescripcionPuesto=0;
    
    int idCurriculum;
    int idActividadDocente;
    int idActividadPofesional;
    int idCargosDesempeñados;
    int idEstudiosAcademicos;
    private int indiceGlobal = 0;
    private int idProcedimientoInter = 0; //Para idProcedimiento hecho por erick solo esta linea cree por sicaso
    private int idProcedimientoInter2 = 0; 
    ArrayList<InterventorSU> interventores;
    private DefaultComboBoxModel modelo10;
    private DefaultComboBoxModel modelo11;
    private boolean existeProcedimiento = false;
    private String nombreDep;
    private int idProcedimiento;
    ArrayList<ListaProcedimientos>listaProcedimientos;
    ArrayList<Interventores>listaInterventor;
    
    private int idProcedimientolistaActividades=0;
    private int idInterventorlistaActividades=0;
    private DefaultComboBoxModel modelo12;
    private DefaultComboBoxModel modelo13;
    private DefaultComboBoxModel modelo14;
    private boolean existelistaprocedimientos=false;
    private boolean existeinterventor=false;
    private ArrayList<ListaDeActividades> listaActividades;
    private int indiceActividades=0;
    
    int idEscolaridad ;
    int idAptitud;
    int idEsfuerzo;
    int codExperiencia; 
    int codExperiencia1;
    int idHabilidadDestreza;
    int indiceActual=0;
    int idDepartamento;
    
    PreparedStatement psSU, psAux ; 
    ResultSet rsSU, rsAux ;
    //Conexion prueba;
    ArrayList<Puesto>lista;
    ArrayList<DepartamentoRecursivo>Lista;
    Conexion prueba;
    public VistaSu() {
        initComponents();
        jTextField32.setVisible(false);
        jTextField5.setVisible(false);
        jButton3.setVisible(false);
        funcionalidadesInvisibles();
        this.setLocationRelativeTo(null);
        llenarComboBoxPuestosDisponibles();
        llenarComboBoxPuestos();
        llenarComboBoxDepartamentoImagen();
        
        cargarComboDepartamento();
        cargarComboBoxProcedimientos();
        cargarComboBoxInterventores();
        
        llenarComboBoxDepartamento();
        llenarComboBoxBusquedaDepartamento();
        cargarComboDepartamentoPocedimiento();
        tipoDeDatoProcedimiento();
        tipoDeDatoProcedimiento2();
        cargarComboDepartamentoInter();
        
        cargarComboDepartamentolistaActividades();
        cargarDatosIniciales();
        
        cargarComboDepartamentoImagen();
        cargarComboProcedimientosImagen();
        tipoDeDatoProcedimientoImagen();
    }
    /*
    @author Erick--> Inicio codigo de combo box para hacer la automatizacines
    */
   public void llenarComboBoxPuestosDisponibles(){
        //jComboBox1.removeAllItems();
        modelo = new DefaultComboBoxModel(); //se puede comentar despues
        lista = new InformacionPuesto().getListaPuestosDisponibles();
        //jComboBox1.addItem("Selecione un Puesto");

        for(int i=0; i<lista.size(); i++){
            //jComboBox1.addItem(lista.get(i).getPuesto());
            modelo.addElement(lista.get(i));
        }
        jComboBox1.setModel(modelo);
        
    }
   
   public void llenarComboBoxPuestosDisponibles(int idPuesto, String nombrePuesto){
        //jComboBox1.removeAllItems();
        modelo = new DefaultComboBoxModel(); //se puede comentar despues
        lista = new InformacionPuesto().getListaPuestosDisponibles();
        //jComboBox1.addItem("Selecione un Puesto");
        modelo.addElement(new Puesto(nombrePuesto,idPuesto));
        for(int i=0; i<lista.size(); i++){
            //jComboBox1.addItem(lista.get(i).getPuesto());
            modelo.addElement(lista.get(i));
        }
        jComboBox1.setModel(modelo);
        
    }
   
    public void llenarComboBoxPuestos(){
        jComboBox7.removeAllItems();
        lista = new InformacionPuesto().getlistaPuesto();
        jComboBox7.addItem("Selecione un Puesto");
        for(int i=0; i<lista.size(); i++){
            jComboBox7.addItem(lista.get(i).toString());
        }
    }
    public void llenarComboBoxDepartamento(){
        jComboBox5.removeAllItems();
        Lista = new InformacionDepartamento().getListaDepartamentos();
        jComboBox5.addItem("Selecione un Departamento");
        for(int i=0; i<Lista.size(); i++){
            jComboBox5.addItem(Lista.get(i).toString());
        }

    } 
    public void llenarComboBoxBusquedaDepartamento(){
        jComboBox4.removeAllItems();
        Lista = new InformacionDepartamento().getListaDepartamentos();
        jComboBox4.addItem("Selecione un Departamento");
        for(int i=0; i<Lista.size(); i++){
            jComboBox4.addItem(Lista.get(i).toString());
        }

    } 
    public void cargarComboBoxProcedimientos(){
        jComboBox14.removeAllItems();
        listaProcedimientos = new DatosProcedimientos().getProcedimientos();
        jComboBox14.addItem("Selecione un procedimiento");
        for(int i=0; i<listaProcedimientos.size(); i++){
            jComboBox14.addItem(listaProcedimientos.get(i).toString());
        }

    } 
    public void cargarComboBoxInterventores(){
        jComboBox15.removeAllItems();
        listaInterventor = new DatosProcedimientos().getInterventores();
        jComboBox15.addItem("Selecione un Inerventor");
        for(int i=0; i<listaInterventor.size(); i++){
            jComboBox15.addItem(listaInterventor.get(i).toString());
        }

    } 
    public void verificarRegistro(){
        
    }
    public void funcionalidadesInvisibles(){
        jTextField7.setVisible(false);
        cajaIDPuesto.setVisible(false);
       // cajaNombrePuesto.setVisible(false);
        jTextField12.setVisible(false);
        jButton3.setContentAreaFilled(false); // Desactiva el relleno del botón
        jButton3.setBorderPainted(false); // Desactiva el borde del botón
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setBorderPainted(false);
        jButton90.setContentAreaFilled(false);
        jButton90.setBorderPainted(false);
        jButton89.setContentAreaFilled(false);
        jButton89.setBorderPainted(false);
        jButton82.setContentAreaFilled(false);
        jButton82.setBorderPainted(false);
        /*
        Aca para adelante estaran las funcionalidades invisibles del panel
        */
        jLabel4.setOpaque(true);
        jTabbedPane1.setUI(new BasicTabbedPaneUI(){
            
        @Override
        protected int calculateTabAreaHeight(int tapPlacement,int horizRunCount,int maxTapHeight){
        return 0;  //Esto oculta los botones de las pestañas de los paneles
        }
        });
        
        

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jButton35 = new javax.swing.JButton();
        btnCerrarSesionSU = new javax.swing.JButton();
        cajaIDPuesto = new javax.swing.JTextField();
        jButton58 = new javax.swing.JButton();
        jButton91 = new javax.swing.JButton();
        jButton99 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jComboBox21 = new javax.swing.JComboBox<>();
        jComboBox22 = new javax.swing.JComboBox<>();
        jButton83 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea12 = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
        jButton85 = new javax.swing.JButton();
        jButton86 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jComboBox7 = new javax.swing.JComboBox<>();
        jButton26 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        btnSig = new javax.swing.JButton();
        btnAnt = new javax.swing.JButton();
        btnBuscarN = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea10 = new javax.swing.JTextArea();
        jButton65 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel75 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        FondoAgregarPT = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField12 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jButton100 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jComboBox10 = new javax.swing.JComboBox<>();
        jButton21 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton25 = new javax.swing.JButton();
        jLabel34treintaYcuatro = new javax.swing.JLabel();
        jLabel35treintaYcinco = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jComboBox12 = new javax.swing.JComboBox<>();
        jComboBox11once = new javax.swing.JComboBox<>();
        jButton35treintaYcinco = new javax.swing.JButton();
        jButton36treintaYseis = new javax.swing.JButton();
        jButton500 = new javax.swing.JButton();
        jTextField500 = new javax.swing.JTextField();
        jButton49 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton52 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        fondoActualizarPT = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton69 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox<>();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jComboBox14 = new javax.swing.JComboBox<>();
        jTextField25 = new javax.swing.JTextField();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jTextField26 = new javax.swing.JTextField();
        jButton68 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jButton77 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox<>();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jComboBox19 = new javax.swing.JComboBox<>();
        jComboBox20 = new javax.swing.JComboBox<>();
        jTextField29 = new javax.swing.JTextField();
        jButton82 = new javax.swing.JButton();
        jButton87 = new javax.swing.JButton();
        jButton88 = new javax.swing.JButton();
        jButton89 = new javax.swing.JButton();
        jButton90 = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jComboBox17 = new javax.swing.JComboBox<>();
        jComboBox18 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton79 = new javax.swing.JButton();
        jButton80 = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel58 = new javax.swing.JLabel();
        jButton81 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton36 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        Foto = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Guardar_Imagen = new javax.swing.JButton();
        Buscar_Imagen = new javax.swing.JButton();
        jButton93 = new javax.swing.JButton();
        jButton94 = new javax.swing.JButton();
        txt_nombreImagen = new javax.swing.JTextField();
        jButton_eliminarImagen = new javax.swing.JButton();
        jComboBox_Imagen = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jButton92 = new javax.swing.JButton();
        jButton95 = new javax.swing.JButton();
        jButton96 = new javax.swing.JButton();
        jButton97 = new javax.swing.JButton();
        jButton98 = new javax.swing.JButton();
        jComboBox23 = new javax.swing.JComboBox<>();
        jComboBox24 = new javax.swing.JComboBox<>();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jComboBox25 = new javax.swing.JComboBox<>();
        jPanel20 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txt_nombreImagenDiagrama = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        Foto_Procedimiento = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        guardar_Diagrama = new javax.swing.JButton();
        jComboBox26 = new javax.swing.JComboBox<>();
        jComboBox27 = new javax.swing.JComboBox<>();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        Tabla_procedimiento = new javax.swing.JButton();
        Buscar_Diagrama = new javax.swing.JButton();
        Mod_Diagrama = new javax.swing.JButton();
        Eliminar_Diagrama = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ImagenFondo = new javax.swing.JLabel();

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Funcionarios.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/procedimientos.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Descripcion.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/foto_añadir_puesto_de_trabajo (4).png"))); // NOI18N
        jButton10.setText("Añadir PT");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Departamentos.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, 430));

        jTabbedPane1.setForeground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setEnabled(false);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del funcionario");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de nacimiento");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, 20));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 190, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 170, -1));
        jPanel4.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 170, -1));
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 170, -1));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("nombre del puesto");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, 20));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificar.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        jButton5.setText("Buscar");
        jButton5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 60, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 130, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cedula de Identificacion");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 140, 30));
        jPanel4.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 170, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Limpiar.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 170, -1));

        jButton35.setText("Siguiente");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 120, 30));

        btnCerrarSesionSU.setBackground(new java.awt.Color(255, 204, 0));
        btnCerrarSesionSU.setText("Cerrar Sesion");
        btnCerrarSesionSU.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCerrarSesionSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionSUActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesionSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 120, -1));
        jPanel4.add(cajaIDPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 80, -1));

        jButton58.setText("Editar Curriculum");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton58, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, -1));

        jButton91.setText("LO BORRAN SI QUIEREN ");
        jButton91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton91ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton91, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 280, 160, 40));

        jButton99.setText("jButton99");
        jButton99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton99ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton99, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        jTabbedPane1.addTab("tab1", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox21.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox21ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 340, -1));

        jComboBox22.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item1" }));
        jComboBox22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox22ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 340, -1));

        jButton83.setText("actualizar");
        jButton83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton83ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton83, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        jButton84.setText("eliminar");
        jButton84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton84ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton84, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));

        jLabel59.setText("procedimiento");
        jPanel5.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel60.setText("departamento");
        jPanel5.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel61.setText("objetivo");
        jPanel5.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jTextArea12.setColumns(20);
        jTextArea12.setRows(5);
        jScrollPane11.setViewportView(jTextArea12);

        jPanel5.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 340, -1));

        jTextArea11.setColumns(20);
        jTextArea11.setRows(5);
        jScrollPane10.setViewportView(jTextArea11);

        jPanel5.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 340, -1));

        jButton85.setText("actualizar objetivo");
        jButton85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton85ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton85, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jButton86.setText("eliminar objetivo");
        jButton86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton86ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton86, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, -1, -1));

        jTabbedPane1.addTab("tab2", jPanel5);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Experiencia");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Habilida y Destreza");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Escolaridad");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Aptitudes");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Esfuerzo");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Esfuerzo Mental", "Esfuerzo Físico" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);

        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jButton26.setText("Añadir");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton37.setText("Añadir");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton38.setText("Añadir");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton44.setText("Añadir");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setText("Añadir");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        btnSig.setText(">");
        btnSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigActionPerformed(evt);
            }
        });

        btnAnt.setText("Modificar");
        btnAnt.setToolTipText("");
        btnAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAntActionPerformed(evt);
            }
        });

        btnBuscarN.setText("BUSCAR");
        btnBuscarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNActionPerformed(evt);
            }
        });

        jTextArea10.setColumns(20);
        jTextArea10.setRows(5);
        jScrollPane14.setViewportView(jTextArea10);

        jButton65.setText("Modificar");
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });

        jButton64.setText("Modificar");
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        jButton66.setText("Modificar");
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });

        jButton67.setText("Modificar");
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(btnAnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8)
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(btnSig, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(24, 24, 24))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jButton64)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton67)
                                .addGap(28, 28, 28)))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jButton65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton44)
                            .addComponent(jButton45))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnBuscarN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton66)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton65)))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSig, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jButton37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton64)))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton67)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarN, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(13, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("tab3", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("AÑADIR UN NUEVO PUESTO DE TRABAJO");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel7.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 170, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 170, 30));

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*pertenecera al departamento");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 180, -1));

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*su puesto superior sera");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 170, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel14.setText("Nombre del puesto:");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel15.setText("Funcion General:");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel16.setText("Funciones Especificas:");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 410, -1));

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 410, -1));
        jPanel7.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 410, 30));

        jButton11.setText("Añadir F.G");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        jButton12.setText("Añadir F.E");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, -1, -1));

        jButton13.setBackground(new java.awt.Color(51, 51, 255));
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("REGISTRAR");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 140, 40));

        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 420, 20));

        jButton22.setBackground(new java.awt.Color(51, 51, 255));
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("ACTUALIZAR DATOS");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 170, 40));

        jToggleButton1.setText("ON");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 60, -1));

        jLabel75.setForeground(new java.awt.Color(255, 0, 0));
        jLabel75.setText("*Acceso a procedimientos");
        jPanel7.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, -1, 20));

        jToggleButton2.setText("NO");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

        FondoAgregarPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_pt 810x460.jpg"))); // NOI18N
        jPanel7.add(FondoAgregarPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 460));

        jTabbedPane1.addTab("tab4", jPanel7);

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel28.setText("Curriculum");

        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel29.setText("Actividad de Docente:");

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane6.setViewportView(jTextArea6);

        jLabel30.setText("Cargos Oficiales Desempeñados:");

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane7.setViewportView(jTextArea7);

        jLabel31.setText("Actividad Profesional:");

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jScrollPane8.setViewportView(jTextArea8);

        jLabel32.setText("Estudios Academicos:");

        jTextArea9.setColumns(20);
        jTextArea9.setRows(5);
        jScrollPane9.setViewportView(jTextArea9);

        jButton27.setText("crear");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("añadir");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setText("crear");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setText("crear");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setText("crear");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setText("añadir");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setText("añadir");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setText("añadir");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jLabel33.setText("CI");

        jButton46.setText("Eliminar");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton47.setText("Eliminar");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton50.setText("Eliminar");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jButton51.setText("Eliminar");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jButton48.setText("FINALIZAR");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton53.setText("Buscar");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jButton54.setText(">");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jButton55.setText(">");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jButton56.setText(">");
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        jButton57.setText(">");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jButton59.setText("SALIR");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jButton60.setText("Modificar");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jButton61.setText("Modificar");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        jButton62.setText("Modificar");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        jButton63.setText("Modificar");
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton62))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton31)
                                    .addComponent(jButton33)
                                    .addComponent(jButton50)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButton57))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton61))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton27)
                                    .addComponent(jButton28)
                                    .addComponent(jButton46)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jButton56)))))
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton30)
                                            .addComponent(jButton34)
                                            .addComponent(jButton51)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jButton55))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton32)
                                    .addComponent(jButton29)
                                    .addComponent(jButton47)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(18, 18, 18)
                                .addComponent(jButton63)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jButton60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton54)
                .addGap(189, 189, 189))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel29)
                                .addComponent(jButton61))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel31)
                                .addComponent(jButton60))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jButton53))))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jButton62))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(jButton63)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jButton57)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("tab5", jPanel8);

        jPanel9.setBackground(new java.awt.Color(0, 204, 153));
        jPanel9.setForeground(new java.awt.Color(0, 153, 102));
        jPanel9.setLayout(null);

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nombre de Departamento");
        jPanel9.add(jLabel18);
        jLabel18.setBounds(320, 240, 145, 27);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Departamento Superior");
        jPanel9.add(jLabel19);
        jLabel19.setBounds(330, 320, 135, 16);

        jButton15.setText("Buscar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton15);
        jButton15.setBounds(340, 150, 100, 30);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton16);
        jButton16.setBounds(300, 360, 109, 47);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificar.png"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton17);
        jButton17.setBounds(420, 360, 120, 47);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton18);
        jButton18.setBounds(550, 360, 121, 49);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Limpiar.png"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton19);
        jButton19.setBounds(680, 360, 120, 49);
        jPanel9.add(jTextField11);
        jTextField11.setBounds(480, 230, 320, 30);

        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox4);
        jComboBox4.setBounds(460, 150, 340, 30);

        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox5);
        jComboBox5.setBounds(480, 310, 320, 30);

        jTextField12.setToolTipText("");
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel9.add(jTextField12);
        jTextField12.setBounds(16, 34, 43, 24);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/uni449-PhotoRoom.png"))); // NOI18N
        jLabel21.setText("DEPARTAMENTOS");
        jPanel9.add(jLabel21);
        jLabel21.setBounds(50, -3, 720, 90);

        jButton20.setText("Actualizar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton20);
        jButton20.setBounds(10, 70, 110, 30);

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/uni449-PhotoRoom (4).png"))); // NOI18N
        jLabel39.setText("jLabel39");
        jPanel9.add(jLabel39);
        jLabel39.setBounds(0, 70, 470, 350);

        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jPanel9.add(jTextField22);
        jTextField22.setBounds(480, 270, 320, 30);

        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Nivel del Departamento");
        jPanel9.add(jLabel53);
        jLabel53.setBounds(350, 280, 130, 20);

        jButton100.setText("Imagen ");
        jButton100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton100ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton100);
        jButton100.setBounds(480, 190, 75, 32);

        jTabbedPane1.addTab("tab6", jPanel9);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nombre del puesto:");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, -1));

        jTextField13.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jPanel10.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 280, -1));

        jComboBox8.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox8ActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, 30));

        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("*Buscar puesto de trabajo");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 160, -1));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Seleccione nuevo departamento");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Seleccione nuevo puesto superior");
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        jComboBox9.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 160, -1));

        jComboBox10.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel10.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 280, -1));

        jButton21.setText("Actualizar Nombre");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 140, -1));

        jLabel27.setForeground(new java.awt.Color(255, 51, 51));
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 300, 20));

        jButton23.setText("Actualizar Departamento");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 180, 30));

        jButton24.setText("Actualizar Puesto Superior");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 190, 30));
        jPanel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 810, 10));

        jButton25.setBackground(new java.awt.Color(51, 51, 255));
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Regresar Atras");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, -1, -1));

        jLabel34treintaYcuatro.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34treintaYcuatro.setText("Funcion general:");
        jPanel10.add(jLabel34treintaYcuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel35treintaYcinco.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35treintaYcinco.setText("Funcion especifica:");
        jPanel10.add(jLabel35treintaYcinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, -1));

        jTextField15.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jPanel10.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 520, -1));

        jTextField16.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jPanel10.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 520, -1));

        jComboBox12.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox12ActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 550, -1));

        jComboBox11once.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jComboBox11once.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox11once.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11onceActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox11once, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 550, -1));

        jButton35treintaYcinco.setText("Actualizar F.G");
        jButton35treintaYcinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35treintaYcincoActionPerformed(evt);
            }
        });
        jPanel10.add(jButton35treintaYcinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 110, 30));

        jButton36treintaYseis.setText("Actualizar F.E");
        jButton36treintaYseis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36treintaYseisActionPerformed(evt);
            }
        });
        jPanel10.add(jButton36treintaYseis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 110, 30));

        jButton500.setText("Adicionar Nueva F.E");
        jButton500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton500ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton500, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 150, -1));

        jTextField500.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jPanel10.add(jTextField500, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 490, 30));

        jButton49.setBackground(new java.awt.Color(255, 51, 51));
        jButton49.setForeground(new java.awt.Color(255, 255, 255));
        jButton49.setText("Eliminar");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 150, 30));

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Eliminar puesto de trabajo");
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        jButton52.setBackground(new java.awt.Color(255, 51, 51));
        jButton52.setForeground(new java.awt.Color(255, 255, 255));
        jButton52.setText("Eliminar F.E");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 100, 30));

        jLabel41.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 255));
        jLabel41.setText("ACTUALIZAR Y ELIMINAR");
        jPanel10.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, 20));

        fondoActualizarPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/update_foto 810x460.jpg"))); // NOI18N
        jPanel10.add(fondoActualizarPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 460));

        jTabbedPane1.addTab("tab7", jPanel10);

        jPanel11.setForeground(new java.awt.Color(153, 153, 153));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setText("SELECIONE UN DEPARTAMENTO");
        jPanel11.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jLabel43.setText("NUEVO PROCEDIMIENTO");
        jPanel11.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel44.setText("OBJETIVO");
        jPanel11.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jButton69.setText("GUARDAR");
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton69, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel45.setText("SEGUNDO PASO");
        jPanel11.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel46.setText("SELECCIONE UN PROCEDIMIENTO");
        jPanel11.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel47.setText("POLITICAS DE OPERACION");
        jPanel11.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel48.setText("INTERVENTOR");
        jPanel11.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox13ActionPerformed(evt);
            }
        });
        jPanel11.add(jComboBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 350, -1));
        jPanel11.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 350, -1));
        jPanel11.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 350, -1));

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox14ActionPerformed(evt);
            }
        });
        jPanel11.add(jComboBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 350, -1));
        jPanel11.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 360, -1));

        jButton70.setText("+");
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton70, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        jButton71.setText("GUARDAR INTERVENTOR");
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton71, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jButton72.setText("SIGUIENTE");
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton72, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));
        jPanel11.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 220, -1));

        jButton68.setText("Actualizar Politicas de Operacion");
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton68, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jButton75.setText("Actualizar y eliminar interventores");
        jButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton75ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton75, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        jButton76.setText("Lista de Actividades");
        jButton76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton76ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton76, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        jButton77.setText("Eliminar");
        jButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton77ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton77, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 90, -1));

        jButton78.setText("editar precedimientos y objetivo");
        jButton78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton78ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton78, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, -1, -1));

        jTabbedPane1.addTab("tab8", jPanel11);

        jLabel49.setText("REGISTRO DE DESCRIPCION DE PROCEDIMIENTOS");

        jLabel50.setText("PARTES QUE INTERVIENEN");

        jLabel51.setText("DESCRIPCION DE PROCEDIMIENTO");

        jLabel52.setText("NUMERO DE ORDEN");

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton73.setText("GUARDAR");
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton73ActionPerformed(evt);
            }
        });

        jButton74.setText("FINALIZAR");
        jButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton74ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton74)
                    .addComponent(jButton73)
                    .addComponent(jLabel49)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox15, 0, 389, Short.MAX_VALUE)
                            .addComponent(jTextField27)
                            .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel50))
                            .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51))
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton73)
                .addGap(58, 58, 58)
                .addComponent(jButton74)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab10", jPanel13);

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox19ActionPerformed(evt);
            }
        });

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox20ActionPerformed(evt);
            }
        });

        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });

        jButton82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon buscar.png"))); // NOI18N
        jButton82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton82ActionPerformed(evt);
            }
        });

        jButton87.setText(">");
        jButton87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton87ActionPerformed(evt);
            }
        });

        jButton88.setText("<");
        jButton88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton88ActionPerformed(evt);
            }
        });

        jButton89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificar.png"))); // NOI18N
        jButton89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton89ActionPerformed(evt);
            }
        });

        jButton90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jButton90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton90ActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("ELIMINAR Y MODIFICAR INTERVENTORES DE UN PROCEDIMIENTO");

        jLabel77.setBackground(new java.awt.Color(255, 255, 255));
        jLabel77.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Seleccione un departamento:");

        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Seleccione un procedimiento del departamento que eligió:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jButton89)
                        .addGap(56, 56, 56)
                        .addComponent(jButton90))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel76))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jButton82)
                                .addGap(44, 44, 44)
                                .addComponent(jButton88)
                                .addGap(44, 44, 44)
                                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jButton87))
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel77)
                                .addComponent(jLabel78)
                                .addComponent(jComboBox19, 0, 690, Short.MAX_VALUE)
                                .addComponent(jComboBox20, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel76)
                .addGap(24, 24, 24)
                .addComponent(jLabel77)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel78)
                        .addGap(8, 8, 8)
                        .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton89)
                            .addComponent(jButton90))
                        .addGap(76, 76, 76))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton87)
                            .addComponent(jButton88))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("tab11", jPanel14);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab12", jPanel15);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab13", jPanel16);

        jPanel17.setBackground(new java.awt.Color(0, 51, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox16ActionPerformed(evt);
            }
        });
        jPanel17.add(jComboBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 240, -1));

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox17ActionPerformed(evt);
            }
        });
        jPanel17.add(jComboBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 450, -1));

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox18ActionPerformed(evt);
            }
        });
        jPanel17.add(jComboBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 500, -1));

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 255, 0));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel17.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 720, 230));

        jButton79.setText("Actualizar");
        jButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton79ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton79, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 100, 40));

        jButton80.setBackground(new java.awt.Color(255, 0, 0));
        jButton80.setForeground(new java.awt.Color(255, 255, 255));
        jButton80.setText("Eliminar");
        jButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton80ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton80, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 110, 40));

        jLabel54.setForeground(new java.awt.Color(255, 0, 0));
        jPanel17.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 230, 20));

        jLabel55.setForeground(new java.awt.Color(51, 0, 255));
        jLabel55.setText("Seleccione un departamento");
        jPanel17.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, -1));

        jLabel56.setForeground(new java.awt.Color(51, 0, 255));
        jLabel56.setText("Seleccione un procedimiento");
        jPanel17.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 180, -1));

        jLabel57.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 0, 255));
        jLabel57.setText("POLITICAS DE OPERACION");
        jPanel17.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 330, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 51, 255));
        jPanel17.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 340, 10));

        jLabel58.setForeground(new java.awt.Color(51, 0, 255));
        jLabel58.setText("Politicas de operacion:");
        jPanel17.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, 20));

        jButton81.setText("Regresar");
        jButton81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton81ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton81, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 90, 40));

        jTabbedPane1.addTab("tab14", jPanel17);

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Experiencia");

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Escolaridad");

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Habilidad y destreza");

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Aptitudes");

        jButton36.setText("Continuar (nuevos user)");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Esfuerzo");

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Esfuerzo Mental", "Esfuerzo Físico" }));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });

        jButton39.setText("Agregar +");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setText("Agregar +");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton41.setText("Agregar +");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setText("Agregar +");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setText("Agregar +");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton40)
                                    .addComponent(jButton39)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField18)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jButton41)
                        .addGap(175, 175, 175))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton43)
                            .addComponent(jButton42))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jButton39)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton40))
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41))
                .addGap(24, 24, 24)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42))
                .addGap(31, 31, 31)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43))
                .addGap(26, 26, 26)
                .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab9", jPanel12);

        jLabel62.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel62.setText("Organigrama del Deparatamento");

        jLabel63.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel63.setText("Nombre Imagen:");

        jLabel64.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel64.setText("Clic en el cuadro para agregar foto");

        Foto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Foto.setText("FOTO");
        Foto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Foto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FotoMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jTable1);

        Guardar_Imagen.setText("Guardar");
        Guardar_Imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_ImagenActionPerformed(evt);
            }
        });

        Buscar_Imagen.setText("Buscar Organigrama");
        Buscar_Imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_ImagenActionPerformed(evt);
            }
        });

        jButton93.setText("Mostrar Tabla ");
        jButton93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton93ActionPerformed(evt);
            }
        });

        jButton94.setText("Modificar Organigrama");
        jButton94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton94ActionPerformed(evt);
            }
        });

        txt_nombreImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreImagenActionPerformed(evt);
            }
        });

        jButton_eliminarImagen.setText("Eliminar Organigrama");
        jButton_eliminarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarImagenActionPerformed(evt);
            }
        });

        jComboBox_Imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ImagenActionPerformed(evt);
            }
        });

        jLabel40.setText("Seleccione un departamento ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(Guardar_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Buscar_Imagen))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton_eliminarImagen)
                                    .addComponent(jComboBox_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Foto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombreImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(txt_nombreImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel40)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Guardar_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Buscar_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_eliminarImagen)
                        .addGap(44, 44, 44))))
        );

        jTabbedPane1.addTab("tab15", jPanel3);

        jLabel65.setText("PROCEDIMIENTOS");

        jLabel66.setText("PROCEDIMEITNOS");

        jLabel67.setText("INTERVENTOR");

        jLabel68.setText("LISTA DE ACTIVIDADES");

        jLabel69.setText("ORDEN DE LISTA");

        jButton92.setText("BUSCAR");
        jButton92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton92ActionPerformed(evt);
            }
        });

        jButton95.setText(">");
        jButton95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton95ActionPerformed(evt);
            }
        });

        jButton96.setText("MODIFICAR");
        jButton96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton96ActionPerformed(evt);
            }
        });

        jButton97.setText("ELIMINAR");
        jButton97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton97ActionPerformed(evt);
            }
        });

        jButton98.setText("RETROCEDER");
        jButton98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton98ActionPerformed(evt);
            }
        });

        jComboBox23.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox23ActionPerformed(evt);
            }
        });

        jComboBox24.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox24ActionPerformed(evt);
            }
        });

        jComboBox25.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(jLabel68)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jButton92)
                        .addGap(21, 21, 21)
                        .addComponent(jButton95))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jButton96)
                        .addGap(57, 57, 57)
                        .addComponent(jButton97)
                        .addGap(61, 61, 61)
                        .addComponent(jButton98))
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox25, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox23, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67)
                            .addComponent(jLabel65))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jComboBox24, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton92)
                    .addComponent(jButton95))
                .addGap(28, 28, 28)
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel68)
                .addGap(9, 9, 9)
                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel69)
                .addGap(8, 8, 8)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton96)
                    .addComponent(jButton97)
                    .addComponent(jButton98))
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("tab16", jPanel18);

        jLabel73.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel73.setText("Diagrama de Flujo de Procedimientos");

        jLabel74.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel74.setText("Nombre Diagrama:");

        txt_nombreImagenDiagrama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreImagenDiagramaActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel70.setText("Clic en el cuadro para agregar foto");

        Foto_Procedimiento.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Foto_Procedimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Foto_Procedimiento.setText("FOTO");
        Foto_Procedimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Foto_Procedimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Foto_Procedimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Foto_ProcedimientoMouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        guardar_Diagrama.setText("GUARDAR DIAGRAMA");
        guardar_Diagrama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_DiagramaActionPerformed(evt);
            }
        });

        jComboBox26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox26MouseClicked(evt);
            }
        });
        jComboBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox26ActionPerformed(evt);
            }
        });

        jLabel71.setText("Departamento");

        jLabel72.setText("Procedimiento");

        Tabla_procedimiento.setText("Mostrar diagramas");
        Tabla_procedimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tabla_procedimientoActionPerformed(evt);
            }
        });

        Buscar_Diagrama.setText("Buscar Diagrama");
        Buscar_Diagrama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_DiagramaActionPerformed(evt);
            }
        });

        Mod_Diagrama.setText("Moficar Diagrama");
        Mod_Diagrama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mod_DiagramaActionPerformed(evt);
            }
        });

        Eliminar_Diagrama.setText("Eliminar Diagrama");
        Eliminar_Diagrama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_DiagramaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(guardar_Diagrama)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(Tabla_procedimiento)
                                        .addGap(26, 26, 26)
                                        .addComponent(Mod_Diagrama)
                                        .addGap(18, 18, 18)
                                        .addComponent(Eliminar_Diagrama)))
                                .addGap(5, 5, 5))
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel70))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombreImagenDiagrama, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Foto_Procedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Buscar_Diagrama))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar_Diagrama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar_Diagrama)
                    .addComponent(jLabel74)
                    .addComponent(txt_nombreImagenDiagrama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tabla_procedimiento)
                            .addComponent(Mod_Diagrama)
                            .addComponent(Eliminar_Diagrama)))
                    .addComponent(Foto_Procedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab17", jPanel20);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 810, 460));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SUPER USUARIO.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 632, -1));

        ImagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Library-many-books-path_930-530 (1).jpg"))); // NOI18N
        ImagenFondo.setPreferredSize(new java.awt.Dimension(930, 530));
        jPanel1.add(ImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        
        //jButton4.setVisible(false);
        //jButton6.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Puesto puesto = (Puesto)(jComboBox1.getSelectedItem());
        idPuesto = puesto.getIdPuesto();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed
    private void desocuparPuestoTrabajo(){
        Integer ci = Integer.parseInt(jTextField6.getText());
          int claveFuncionario = buscarIDFuncionario(ci);
      try{
        Connection  conexion = new Conexion().getConexion();
        psSU = conexion.prepareStatement("update funcionario set IDPUESTO = null where IDFUNCIONARIO="+claveFuncionario);
       
        int res = psSU.executeUpdate();
         
         conexion.close(); 
      }catch(Exception e){
      
      
      }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            //Integer ci = Integer.parseInt(jTextField6.getText());
           String txtci=jTextField6.getText().trim();
           if(!txtci.isEmpty()){
               int ci=Integer.parseInt(txtci);
               int claveFuncionario = buscarIDFuncionario(ci);
               try{
               desocuparPuestoTrabajo();    
               Connection  conexion = new Conexion().getConexion();
           
               psSU = conexion.prepareStatement("delete from cuenta where IDFUNCIONARIO="+claveFuncionario);
          
               int res = psSU.executeUpdate();
               if(res>0){
                    JOptionPane.showMessageDialog(null, "funcionario eliminado");
                    limpiar();
               }else{
                    JOptionPane.showMessageDialog(null, "error al eliminar el funcionario");
                    limpiar();
               }
                conexion.close();    
               }catch(Exception ex){
                    System.err.println("Error, "+ex);
               }
           }else{
                JOptionPane.showMessageDialog(null, "error al eliminar el funcionario");
                limpiar();
           }

    
    }//GEN-LAST:event_jButton4ActionPerformed
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String nombreF = "";
        String ci = "" ; 
        try {
            //Establecer una conexion con la base de datos
             Connection conexion = new Conexion().getConexion();
             psSU = conexion.prepareStatement("insert into funcionario (nombreFuncionario,IDPUESTO,CI,telefono,fechaNacimiento)values(?,?,?,?,?)");
             
             // Establecer los valores de los parámetros en la consulta SQL
             psSU.setString(1,jTextField2.getText());//Nombre del funcionario
             psSU.setInt(2,jComboBox1.getSelectedIndex());// ID del puesto seleccionado en el JComboBox
             psSU.setString(3, jTextField6.getText());// CI del funcionario
             psSU.setString(4,jTextField4.getText());// Teléfono del funcionario
             psSU.setDate(5,Date.valueOf(jTextField3.getText()));// Fecha de nacimiento del funcionario
             
             // Ejecutar la consulta de inserción y obtener el resultado
             int resultado = psSU.executeUpdate();
             
             // Obtener el último ID de funcionario insertado
             psAux = conexion.prepareStatement("SELECT MAX(IDFUNCIONARIO) FROM FUNCIONARIO");
             rsAux = psAux.executeQuery();
             int idFuncionario = 0; 
             if (rsAux.next()) {
                idFuncionario = rsAux.getInt(1); // Obtener el valor de la columna 1 (la única columna en este caso)
           
            }
            conexion.close();
            
             // Almacenar datos para la creación de la cuenta
             nombreF = jTextField2.getText();
             ci = jTextField6.getText();
             crearCuenta(idFuncionario,nombreF,ci);
             // Mostrar un mensaje según el resultado de la inserción
             if(resultado > 0 ){
                JOptionPane.showMessageDialog(null,"Funcionario registrado\n"
                        + "Se creo la cuenta del funcionario con los datos siguientes : \n"
                        + "Usuario : "+nombreF+"\n"
                        + "Contraseña : "+ci);
                
             }else{
                JOptionPane.showMessageDialog(null,"Registro incorrecta");
            }
            
            //conexion.close();
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
         // Verificar si se seleccionó un puesto válido en el JComboBox
        String puesto = (String) jComboBox1.getSelectedItem();
        if(puesto == "Selecione un Puesto"){
            JOptionPane.showMessageDialog(null,"Seleccione un puesto valido");

        }
        //jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton3ActionPerformed
    private void crearCuenta(int idFuncionario , String nombreFuncionario , String ci ){
        try{
        Connection conexion = new Conexion().getConexion();
        psSU = conexion.prepareStatement("insert into cuenta (IDFUNCIONARIO,USUARIO,CONTRASENA) values(?,?,?)");
        psSU.setInt(1,idFuncionario);
        psSU.setString(2, nombreFuncionario);
         psSU.setString(3, ci);
        psSU.executeUpdate();
            psSU.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                                               
    
        try {
            // Establecer una conexión a la base de datos
             Connection conexion = new Conexion().getConexion();
            
            // Preparar una sentencia SQL de actualización para la tabla "funcionario"
            psSU = conexion.prepareStatement("update funcionario set idPuesto=?, ci = ?, nombreFuncionario=?,telefono=?,fechaNacimiento=? where IDFUNCIONARIO=?");
            
            // Obtener el objeto Puesto seleccionado del JComboBox
            Puesto p = (Puesto)jComboBox1.getSelectedItem();
            if(p!= null){
                // Establecer los parámetros en la sentencia SQL utilizando los valores de los campos de la interfaz gráfica
                String ciText = jTextField6.getText();
                String nombreFuncionarioText = jTextField2.getText();
                String telefonoText = jTextField4.getText();
                String fechaNacimientoText = jTextField3.getText();
                String idFuncionarioText = jTextField7.getText();
            if (!ciText.isEmpty()) {
                psSU.setInt(2, Integer.parseInt(ciText));
            } else {
                JOptionPane.showMessageDialog(null, "Error en la modificación,hay un campo vacío");
                return;
            }
            psSU.setInt(1,p.getIdPuesto());
            psSU.setInt(2,Integer.parseInt(jTextField6.getText()));
            psSU.setString(3,jTextField2.getText());
            psSU.setString(4,jTextField4.getText());
            psSU.setDate(5,Date.valueOf(jTextField3.getText()));
            psSU.setInt(6,Integer.parseInt(jTextField7.getText()));
            // Ejecutar la actualización en la base de datos
            int resultado = psSU.executeUpdate();
            // Mostrar un mensaje de éxito o error según el resultado de la actualización
                if(resultado > 0 ){
                    JOptionPane.showMessageDialog(null,"Modificación realizada");
                }else{
                    JOptionPane.showMessageDialog(null,"Error en la modificación");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Error en la modificación, hay un campo vacio");
            }
            
            conexion.close();
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            // Deshabilitar botones y hace invisible botones especifico al Buscar
            jButton3.setEnabled(false);
            jButton35.setVisible(false);
            //jButton35.setVisible(false);
            //cajaNombrePuesto.setVisible(true);
        try{
            //establece una conexion a la BD
            Connection conexion = new Conexion().getConexion();
            //preparacion de la consulta SQL para obtener informacion del Funcionario
            psSU = (PreparedStatement) conexion.prepareStatement("select IDFUNCIONARIO,PT.IDPUESTO,ci,nombreFuncionario,telefono,fechaNacimiento,NOMBREPUESTO from funcionario f, puestoTrabajo pt where f.idpuesto = pt.idpuesto AND CI = ?"); 
            psSU.setString(1,jTextField1.getText());
            //Ejecuta la consulta y obtiene los resultados
            rsSU = psSU.executeQuery();
            
            // Verifica si se encontró un registro
            if(rsSU.next()){
                jTextField2.setText(rsSU.getString("nombreFuncionario"));
                jTextField4.setText(rsSU.getString("telefono"));
                jTextField6.setText(rsSU.getString("ci"));
                jTextField3.setText(String.valueOf(rsSU.getDate("fechaNacimiento")));
                //jComboBox1
                //jComboBox1.setSelectedIndex(rsSU.getInt("idPuesto"));
                jTextField7.setText(rsSU.getString("IDFUNCIONARIO"));
                
                // Llenar el ComboBox de Puestos Disponibles con el respectivo metodo
                llenarComboBoxPuestosDisponibles(rsSU.getInt("IDPUESTO"),rsSU.getString("NOMBREPUESTO"));

                //cajaIDPuesto.setText(rsSU.getString("IDPUESTO"));
                //jComboBox1.setVisible(true);
                //obtenerNombreDelPuesto();
                //obtenerDescripcionPuesto();
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");
                jTextField1.setText("");
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void obtenerDescripcionPuesto(){
         llenarExperiencia();
         llenarHabilidadDestreza();
         llenarEscolaridad();
         llenarAptitudes();
         llenarEsfuerzo();
    }
    private void llenarEsfuerzo(){
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select esf.IDESFUERZO ,esf.DESCRIPCIONDELESFUERZO from esfuerzo esf , descripcionpuesto dp , puestotrabajo pt\n" +
"where pt.IDPUESTO = dp.IDPUESTO and   dp.IDDESCRIPCIONPUESTO=esf.IDDESCRIPCIONPUESTO and pt.IDPUESTO=? "); 
            
            psSU.setInt(1,Integer.parseInt(cajaIDPuesto.getText()));
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                jTextField21.setText(rsSU.getString("esf.DESCRIPCIONDELESFUERZO"));
                idEsfuerzo = rsSU.getInt("esf.IDESFUERZO");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
   }
    private void llenarAptitudes(){
       try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select a.IDAPTITUD, a.NOMBREAAPTITUD from aptitudes a , descripcionpuesto dp , puestotrabajo pt\n" +
            "where pt.IDPUESTO = dp.IDPUESTO and   dp.IDDESCRIPCIONPUESTO=a.IDDESCRIPCIONPUESTO and pt.IDPUESTO=? "); 
            
            psSU.setInt(1,Integer.parseInt(cajaIDPuesto.getText()));
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                jTextField20.setText(rsSU.getString("a.NOMBREAAPTITUD"));
                  idAptitud = rsSU.getInt("a.IDAPTITUD");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
   }
    private void llenarEscolaridad(){
        
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select esc.IDESCOLARIDAD ,esc.DATOESCOLARIDAD from escolaridad esc , descripcionpuesto dp , puestotrabajo pt\n" +
"where pt.IDPUESTO = dp.IDPUESTO and   dp.IDDESCRIPCIONPUESTO=esc.IDDESCRIPCIONPUESTO and pt.IDPUESTO=? "); 
            
            psSU.setInt(1,Integer.parseInt(cajaIDPuesto.getText()));
            
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                jTextField18.setText(rsSU.getString("esc.DATOESCOLARIDAD"));
                idEscolaridad = rsSU.getInt("esc.IDESCOLARIDAD");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    private void llenarHabilidadDestreza(){
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select hd.IDHABILIDADDESTREZA ,hd.DATOHABILIDADDESTREZA from habilidaddestreza hd , descripcionpuesto dp , puestotrabajo pt\n" +
"where pt.IDPUESTO = dp.IDPUESTO and   dp.IDDESCRIPCIONPUESTO=hd.IDDESCRIPCIONPUESTO and pt.IDPUESTO=? "); 
            
            psSU.setInt(1,Integer.parseInt(cajaIDPuesto.getText()));
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                jTextField19.setText(rsSU.getString("hd.DATOHABILIDADDESTREZA"));
                idHabilidadDestreza = rsSU.getInt("hd.IDHABILIDADDESTREZA");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    private void llenarExperiencia(){
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select ex.CODEXPERIENCIA ,ex.DESCRIPCIONEXPERIENCIA from experiencia ex , descripcionpuesto dp , puestotrabajo pt\n" +
            "where pt.IDPUESTO = dp.IDPUESTO and   dp.IDDESCRIPCIONPUESTO=ex.IDDESCRIPCIONPUESTO and pt.IDPUESTO=? "); 
            
            psSU.setInt(1,Integer.parseInt(cajaIDPuesto.getText()));
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                jTextField17.setText(rsSU.getString("ex.DESCRIPCIONEXPERIENCIA"));
                codExperiencia = rsSU.getInt("ex.CODEXPERIENCIA");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    public void limpiar(){
        jTextField5.setText(null);
        jTextField1.setText(null);
        jTextField2.setText(null);
        //jComboBox1.setSelectedIndex(0);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField6.setText(null);

    }
    //SAMKLDMSA
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jButton3.setEnabled(true);
        jButton35.setVisible(true);
        llenarComboBoxPuestosDisponibles();
        limpiar();
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton9ActionPerformed
/*
De nuevo erick y juan haciendo esta parte
    
*/
    private int generarPk(){
        int fk=0;

        try {
            Connection conexion = new Conexion().getConexion();
            String seleccionCombo = jComboBox7.getSelectedItem().toString();
            psSU = conexion.prepareStatement("select idpuesto from puestotrabajo where nombrepuesto = seleccionCombo");
            rsSU = psSU.executeQuery();
            if(rsAux.next()){
                fk = rsAux.getInt(1);
            }
         }catch(Exception ex){
                System.err.println("Error:" + ex);

         }
        System.out.println(fk);
        return fk;
    }
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //int fk = generarPk();
        int fk = jComboBox7.getSelectedIndex();

        if(jTextArea10.getText().equals("") ||jTextArea2.getText().equals("") || jTextArea3.getText().equals("")){
         JOptionPane.showMessageDialog(null, "campos vacios");
         }else{
        try {
             
            Connection conexion = new Conexion().getConexion();
            
            psSU = conexion.prepareStatement(" insert into DescripcionPuesto(IdPuesto) values(?)");
            psSU.setInt(1, fk);
            psSU.executeUpdate();
            psSU.close();
            psAux = conexion.prepareStatement("SELECT MAX(IdDescripcionPuesto) FROM DescripcionPuesto");
            rsAux = psAux.executeQuery();
            int pk = 0; // Inicializar pk

            if (rsAux.next()) {
                pk = rsAux.getInt(1); // Obtener el valor de la columna 1 (la única columna en este caso)
                //System.out.println(pk);
            }
            conexion.close();
            insertarExperiencia(pk);
            insertarHabilidadDestreza(pk);
            insertarEscolaridad(pk);
            insertarAptitudes(pk);
            insertarEsfuerzo(pk);
            JOptionPane.showMessageDialog(null,"datos registrados correctamente");
            
            }catch (Exception ex ){
                System.err.println("Error:" + ex);
            }
         }
        
    }//GEN-LAST:event_jButton7ActionPerformed
    //INICIO CODIGO DAVID
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
        cargarComboBoxDepartamentos();
        Departamento dep = (Departamento)(jComboBox2.getSelectedItem());
        cargarComboBoxPuestoTrabajo(dep.getIdDepartamento());
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(!jTextField9.getText().equals("")){
            jLabel17.setText("");
            funcionGeneral.add(jTextField9.getText());
            jTextField9.setText("");
            JOptionPane.showMessageDialog(null,"Funcion general registrada con exito");
        }else{
            jLabel17.setText("*error campo funcion general vacio");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Departamento dep = (Departamento)(jComboBox2.getSelectedItem());
        cargarComboBoxPuestoTrabajo(dep.getIdDepartamento());
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(!jTextField10.getText().equals("")){
            jLabel17.setText("");
            funcionesEspesificas.add(jTextField10.getText());
            jTextField10.setText("");
            JOptionPane.showMessageDialog(null,"Funcion especifica registrada con exito");
        }else{
            jLabel17.setText("error campo funciones especificas vacio");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if(camposLlenos()){
            int idPuest;   // linea de codigo numero 1841 clase VistaSU
            DatosPuestoTrabajo dpt = new DatosPuestoTrabajo();
            int idPuestoSuperior;
            
            if(jComboBox3.getSelectedItem() instanceof PuestoTrabajo){
               PuestoTrabajo pt = (PuestoTrabajo)(jComboBox3.getSelectedItem());
               idPuestoSuperior = pt.getIdPuesto();
            }else{
               idPuestoSuperior = 0; 
            }
            
            Departamento dep = (Departamento)(jComboBox2.getSelectedItem());
            
            if(jToggleButton1.getText().equals("ON")){
               dpt.insertarPuesto(jTextField8.getText(),idPuestoSuperior,dep.getIdDepartamento(),jToggleButton2.getText());
            }else{
                dpt.insertarPuesto(jTextField8.getText(),0,dep.getIdDepartamento(),jToggleButton2.getText());
            
            }
            idPuest = dpt.getIdUltimoPuestoInsertado();
            
            for(int i=0;i<funcionGeneral.size();i++){
                dpt.insertarFuncionGeneral(idPuest, funcionGeneral.get(i));
            }
            
            for(int i=0;i<funcionesEspesificas.size();i++){
                dpt.insertarFuncionesEspesificas(idPuest,funcionesEspesificas.get(i));
            }
            
            
            for(int i=0;i<funcionGeneral.size();i++){
                funcionGeneral.remove(i);
            }
            
            for(int i=0;i<funcionesEspesificas.size();i++){
                funcionesEspesificas.remove(i);
            }
            
            LimpiadorDespuesDeAñadirPT();
            JOptionPane.showMessageDialog(null,"Registrado con EXITO!");
            llenarComboBoxPuestosDisponibles();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        //jButton16.setEnabled(false); // desabilita el boton guardar
    try{
        //establece la conexion a la BD
        Connection conexion = new Conexion().getConexion();
        //Prepara la consulta SQL para obtener los datos de departamento
        psSU = (PreparedStatement) conexion.prepareStatement("select * from departamento where NOMBREDEPARTAMENTO = ? ");        
        // Obtener el nombre del departamento seleccionado en el JComboBox
        String departamentoSeleccionado = (String) jComboBox4.getSelectedItem();
        
        // Verificar si se seleccionó un departamento
        if(departamentoSeleccionado != null){
            // Establecer el nombre del departamento como parámetro en la consulta SQL
            psSU.setString(1, departamentoSeleccionado);
            // Ejecutar la consulta de selección y obtener el resultado en un ResultSet
            rsSU = psSU.executeQuery(); 
            // Verificar si se encontró algún registro en el ResultSet y pasa al siguiente registro hasta encontrar y poner false si no encontro
            if(rsSU.next()){
                // Llenar campos de texto y JComboBox con los datos obtenidos
                jTextField11.setText(rsSU.getString("NOMBREDEPARTAMENTO"));
                jComboBox5.setSelectedIndex(rsSU.getInt("DEP_IDDEPARTAMENTO"));
                jTextField12.setText(rsSU.getString("IDDEPARTAMENTO"));
                jTextField22.setText(rsSU.getInt("NIVEL")+"");
                idDepartamento = Integer.parseInt(jTextField12.getText());
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            
            conexion.close();
        } else {
            JOptionPane.showMessageDialog(null,"Selecciona un departamento en el JComboBox");                
        }
    } catch(Exception ex) {
        System.err.println("ERROR, "+ex);
    }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        //condicional si los campos a guardar son null o vacio
        if(jTextField11.getText().isEmpty() || jComboBox5.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"campo vacio");
        }else{
        try {
            // conexion a la base de datos
             Connection conexion = new Conexion().getConexion();
             // preparacion de la consulta SQL para la tabla departamento 
             psSU = conexion.prepareStatement("insert into departamento (DEP_IDDEPARTAMENTO,NOMBREDEPARTAMENTO, NIVEL)values(?,?,?)");
             // establecer parametros a la consulta SQL
             psSU.setString(2,jTextField11.getText());// Nombre del departamento
             psSU.setInt(1,jComboBox5.getSelectedIndex()); // ID del departamento seleccionado en el JComboBox
             psSU.setInt(3, Integer.parseInt(jTextField22.getText()));// Nivel del departamento
            
             // Ejecutar la consulta de inserción y obtener el resultado
             int resultado = psSU.executeUpdate();
            
             // Mostrar un mensaje según el resultado de la inserción
            if(resultado > 0 ){
                JOptionPane.showMessageDialog(null,"Departamento registrado");
            }else{
                JOptionPane.showMessageDialog(null,"Registro incorrecto");
            }
            conexion.close();
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
    }
         // Verificar si se seleccionó un departamento válido en el JComboBox que no sea 0
         String departamento = (String) jComboBox5.getSelectedItem();
         if(departamento == "Selecione un departamento"){
            JOptionPane.showMessageDialog(null,"Seleccione un departamento valido");
        }
        //jTabbedPane1.setSelectedIndex(4);
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
       try{
              
           Connection  conexion = new Conexion().getConexion();
           
           psSU = conexion.prepareStatement("delete from departamento where IDDEPARTAMENTO="+idDepartamento);
          
           int res = psSU.executeUpdate();
           if(res>0){
           JOptionPane.showMessageDialog(null, "departamento eliminado");
           limpiar();
           }else{
           JOptionPane.showMessageDialog(null, "error al eliminar el departamento");
           limpiar();
           }
           conexion.close();    
           }catch(Exception ex){
           System.err.println("Error, "+ex);
           }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        limpiarDepartamento();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void limpiarDepartamento(){
        jTextField11.setText(null);
        jTextField22.setText(null);
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jTextField9.setText(null);
    }
    
    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
        // texto donde aparece el iddepaartamento
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
                                         
        // TODO add your handling code here:
         try {
             // conexcion con la base de datos
             Connection conexion = new Conexion().getConexion();
             //preparar la consulta SQL para la tabla ¨departamento¨
             psSU = conexion.prepareStatement("update departamento set NOMBREDEPARTAMENTO=?,DEP_IDDEPARTAMENTO=?, NIVEL=? where IDDEPARTAMENTO=?");
             //Estableser los nuevos valores de los parametros en la consulta SQL
             psSU.setString(1,jTextField11.getText());// Nuevo nombre del departamento
             psSU.setInt(2,jComboBox5.getSelectedIndex());// Nuevo ID del departamento superior seleccionado en el JComboBox
            // psSU.setInt(3,Integer.parseInt(jTextField22.getText()));// Nuevo nivel del departamento
            String nivelText = jTextField22.getText();
            if (!nivelText.isEmpty()) {
                 psSU.setInt(3, Integer.parseInt(nivelText)); // Nuevo nivel del departamento
            } else {
                JOptionPane.showMessageDialog(null, "Error en la modificación, campos vacíos");
                return;
            }
             psSU.setString(4,jTextField12.getText());// ID del departamento a actualizar
             
            // Ejecutar la consulta de actualización y obtener el resultado
            int resultado = psSU.executeUpdate();
            // Obtener el valor seleccionado en el JComboBox
            String resCombo = (String) jComboBox5.getSelectedItem();
            // Mostrar un mensaje según el resultado de la actualización
            if(resultado > 0 ){
                JOptionPane.showMessageDialog(null,"Modificación realizada en: \n" + "Departamento:"+jTextField11.getText()+"\n Con Nivel del Departamento:"+jTextField22.getText()+"\n Con un Departamento Superior:" + resCombo );
            }else{
                JOptionPane.showMessageDialog(null,"Error en la modificación");
            }
            conexion.close();
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
    
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
                                              
        // TODO add your handling code here:
        try {
           // establece una conecion a la BD
           Connection conexion = new Conexion().getConexion();
           // Preparar una consulta SQL para seleccionar los nombres de los departamentos
           PreparedStatement ps = conexion.prepareStatement("SELECT NOMBREDEPARTAMENTO FROM departamento");
           // Ejecutar la consulta y obtener los resultados en un ResultSet
           ResultSet rs = ps.executeQuery();
           // Crear un modelo para el JComboBox
           DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
           // Llenar el modelo con los nombres de los departamentos obtenidos de la base de datos
           while (rs.next()) {
           model.addElement(rs.getString("NOMBREDEPARTAMENTO"));
          }
         llenarComboBoxDepartamento(); //metodo para llenar los datos actuales del departamento  en departamento superior
         llenarComboBoxBusquedaDepartamento();// metodo para llenar los datos actuales del departamento en buscar
         //limpiarDepartamento();
         // Mostrar un mensaje de actualización exitosa
         JOptionPane.showMessageDialog(null, "Base de datos actualizada", "Actualizacion", JOptionPane.INFORMATION_MESSAGE);
         limpiarDepartamento();
        // cerrar la conexion a la BD
         conexion.close();
    
        } catch (Exception ex) {
         System.err.println("Error al actualizar el JComboBox: " + ex);
        }
    
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        PuestoTrabajo pt = (PuestoTrabajo)(jComboBox9.getSelectedItem());   //codigo David
        
        jTextField13.setText(pt.getNombrePuesto());
        Departamento dep = new DatosPuestoTrabajo().getDepartamento(pt.getIdPuesto());
        PuestoTrabajo ptCombo = new DatosPuestoTrabajo().getPuestoSuperior(pt.getIdPuesto());
        jComboBox8.setSelectedItem(dep);
        jComboBox10.setSelectedItem(ptCombo);
        
        cargarComboFG();
        cargarComboFE();
        try{
            FuncionGeneral fg = (FuncionGeneral)jComboBox11once.getSelectedItem();
            jTextField15.setText(fg.getDescripcionFG());
            FuncionEspecifica fe = (FuncionEspecifica)jComboBox12.getSelectedItem();
            jTextField16.setText(fe.getDescripcionFE());
        }catch(Exception ex){
            System.err.println("Error de casteo:" + ex);
            jTextField15.setText("");
            jTextField16.setText("");
        }
        
        
    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void cargarComboFG(){
        modelo4 = new DefaultComboBoxModel();   //codigo David
        PuestoTrabajo pt = (PuestoTrabajo)jComboBox9.getSelectedItem();
        ArrayList<FuncionGeneral>contenido = new DatosPuestoTrabajo().getFuncinesGenerales(pt.getIdPuesto());
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                modelo4.addElement(contenido.get(i));
            
            }
        
        }else{
            modelo4.addElement("Ninguno");
        
        }
        jComboBox11once.setModel(modelo4);
    
    }
    
    private void cargarComboFE(){
        modelo5 = new DefaultComboBoxModel();  //codigo David
        PuestoTrabajo pt = (PuestoTrabajo)jComboBox9.getSelectedItem();
        ArrayList<FuncionEspecifica>contenido = new DatosPuestoTrabajo().getFuncinesEspecificas(pt.getIdPuesto());
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                modelo5.addElement(contenido.get(i));
            
            }
        
        }else{
            modelo5.addElement("Ninguno");
        
        }
        jComboBox12.setModel(modelo5);
    
    }
    
    
    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        jTabbedPane1.setSelectedIndex(6);    //implementar
        llenarBuscarPT();
        
        jComboBox2.setSelectedIndex(0);
        PuestoTrabajo pt = (PuestoTrabajo)jComboBox9.getSelectedItem();
        jTextField13.setText(pt.getNombrePuesto());
        cargarComboFG();
        cargarComboFE();
        
        FuncionGeneral fg = (FuncionGeneral)jComboBox11once.getSelectedItem();
        jTextField15.setText(fg.getDescripcionFG());
        if(jComboBox12.getSelectedItem() instanceof FuncionEspecifica){
            FuncionEspecifica fe = (FuncionEspecifica)jComboBox12.getSelectedItem();
            jTextField16.setText(fe.getDescripcionFE());
        }else{
            jTextField16.setText("Ninguno");
        }
        jTextField500.setText("");
        
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if(!jTextField13.getText().equals("")){ //implementar
            jLabel27.setText("");
             PuestoTrabajo pt = (PuestoTrabajo)(jComboBox9.getSelectedItem());   // codigo david
             int id = pt.getIdPuesto();
             String nuevoNombre = jTextField13.getText();
             
             
             if(new DatosPuestoTrabajo().actualizarNombreDepartamento(nuevoNombre, id)){
                 JOptionPane.showMessageDialog(null,"Datos Actualizados");
                 llenarBuscarPT();
                 jTextField13.setText("");
                 jComboBox8.setSelectedIndex(0);
                 
             }else{
                 JOptionPane.showMessageDialog(null,"Error al Actualizar");
        
             }
             
        
        }else{
            jLabel27.setText("*Error hay un campo vacio");
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        Departamento dep = (Departamento)jComboBox8.getSelectedItem();
        PuestoTrabajo pt = (PuestoTrabajo)jComboBox9.getSelectedItem();
        if(new DatosPuestoTrabajo().actualizarDepartamentoPertenece(dep.getIdDepartamento(),pt.getIdPuesto())){
            JOptionPane.showMessageDialog(null,"Se modifico con exito el departamento");
            jTextField13.setText("");
            jComboBox8.setSelectedIndex(0);
        }else{
            JOptionPane.showMessageDialog(null,"Error al modificar el departamento");
        }
        
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox8ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        PuestoTrabajo puestoSuperior = (PuestoTrabajo)jComboBox10.getSelectedItem();
        PuestoTrabajo pt = (PuestoTrabajo)jComboBox9.getSelectedItem();
        if(new DatosPuestoTrabajo().actualizarJefeSuperior(puestoSuperior.getIdPuesto(),pt.getIdPuesto())){
            JOptionPane.showMessageDialog(null,"Se modifico con exito el puesto de trabajo superior");
            jTextField13.setText("");
            jComboBox8.setSelectedIndex(0);
        }else{
            JOptionPane.showMessageDialog(null,"Error al modificar el puesto de trabajo superior");
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
        jComboBox2.setSelectedIndex(0);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
      if(jTextArea9.getText().equals("")){
          JOptionPane.showMessageDialog(null, "campos vacios");
        }else{
          try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into estudioacademico(IDCURRICULUM,DATOSESTUDIOACADEMICO) values(?,?)");
            psSU.setInt(1,idCurriculum );
            psSU.setString(2,jTextArea9.getText());
            psSU.executeUpdate();
            psSU.close();
            JOptionPane.showMessageDialog(null,"dato registrado correctamente");
            jButton34.setEnabled(false);  
          }catch(Exception e){
        
        }   
          
        }  
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
       jTextArea6.setText("");
       jButton28.setEnabled(true);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        jTextArea7.setText("");
        jButton33.setEnabled(true);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        jTextArea8.setText("");
        jButton32.setEnabled(true);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
       jTextArea9.setText("");
     jButton34.setEnabled(true);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
          
        if(jTextArea6.getText().equals("")){
          JOptionPane.showMessageDialog(null, "campos vacios");
        }else{
          try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into actividaddocente(IDCURRICULUM,ACTIVIDADDOCENTE) values(?,?)");
            psSU.setInt(1,idCurriculum );
            psSU.setString(2,jTextArea6.getText());
            psSU.executeUpdate();
            psSU.close();
            JOptionPane.showMessageDialog(null,"dato registrado correctamente");
            jButton28.setEnabled(false);  
          }catch(Exception e){
        
        }   
          
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
      if(jTextArea8.getText().equals("")){
          JOptionPane.showMessageDialog(null, "campos vacios");
        }else{
          try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum
            psSU = conexion.prepareStatement(" insert into actividadprofesional(IDCURRICULUM,DATOSACTIVIDADPROFESIONAL) values(?,?)");
            psSU.setInt(1,idCurriculum );
            psSU.setString(2,jTextArea8.getText());
            psSU.executeUpdate();
            psSU.close();
            JOptionPane.showMessageDialog(null,"dato registrado correctamente");
            jButton32.setEnabled(false);  
          }catch(Exception e){
        
        }   
          
        }    
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
         if(jTextArea7.getText().equals("")){
          JOptionPane.showMessageDialog(null, "campos vacios");
        }else{
          try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into cargosoficialesdesempenados(IDCURRICULUM,DATOSDESEMPENADO) values(?,?)");
            psSU.setInt(1,idCurriculum );
            psSU.setString(2,jTextArea7.getText());
            psSU.executeUpdate();
            psSU.close();
            JOptionPane.showMessageDialog(null,"dato registrado correctamente");
            jButton33.setEnabled(false);  
          }catch(Exception e){
        
        }   
          
        }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // verifica si algun campo esta vacio 
        if(jTextField2.getText().isEmpty() || jTextField6.getText().isEmpty() || jTextField4.getText().isEmpty() || jTextField3.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Por favor Registre todos los datos", "ERROR",JOptionPane.INFORMATION_MESSAGE );
        }else{
            // Mostrar un cuadro de diálogo de confirmación
            int respuesta=JOptionPane.showOptionDialog(this, "Si esta seguro que su informacion es correcta haz click en Guardar Datos de lo contrario haz click en Cancelar", "Confirma tu Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Guardar Datos","Cancelar"}, "Guardar Datos");
            // Verificar la respuesta del cuadro es YES
            if (respuesta == JOptionPane.YES_OPTION) {
                
                // Llama a la función de inserción de datos en la clase Funcionario y ejecuta el metodo InsercionFuncionario con los datos del los textField
                new Funcionario().insercionFuncionario(jTextField2.getText(),idPuesto,jTextField6.getText(),jTextField4.getText(),Date.valueOf(jTextField3.getText()));
                
                //Crear una instancia de DescripcionPuesto e insertar datos relacionados con el puesto en su IDPuesto
                DescripcionPuesto inserciones = new DescripcionPuesto();
                inserciones.insertarDescripcionPuesto(idPuesto);
                // Obtiene el ID de la descripción del puesto utilizando la clase
                idDescripcionPuesto = inserciones.getIdDescripcionPuesto();
                JOptionPane.showMessageDialog(null,"Se registro correctamente","Registro",JOptionPane.INFORMATION_MESSAGE );
                // Cambiar a una pestaña específica en el JTabbedPane
                jTabbedPane1.setSelectedIndex(13);
            }
        }    
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        if(jTextField17.getText().isEmpty() || jTextField18.getText().isEmpty() || jTextField19.getText().isEmpty() || jTextField20.getText().isEmpty()||jTextField21.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Por favor Registre todos los datos", "ERROR",JOptionPane.INFORMATION_MESSAGE );
        }else{
            int respuesta=JOptionPane.showOptionDialog(this, "Si esta seguro que su informacion es correcta haz click en Guardar Datos de lo contrario haz click en Cancelar", "Confirma tu Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Guardar Datos","Cancelar"}, "Guardar Datos");
            if (respuesta == JOptionPane.YES_OPTION){
                DescripcionPuesto inserciones = new DescripcionPuesto();
                //int idDescripcionPuesto = inserciones.getIdDescripcionPuesto();
                //if(){}
                inserciones.insertarExperiencia(idDescripcionPuesto, jTextField17.getText());
                inserciones.insertarHabilidadDestreza(idDescripcionPuesto, jTextField19.getText());
                inserciones.insertarEscolaridad(idDescripcionPuesto, jTextField18.getText());
                inserciones.insertarAptitudes(idDescripcionPuesto, jTextField20.getText());
                inserciones.insertarEsfuerzo(idDescripcionPuesto,(String)jComboBox11.getSelectedItem() ,jTextField21.getText());
                jTabbedPane1.setSelectedIndex(4);
                jButton59.setVisible(false);
                Integer cii = Integer.parseInt(jTextField6.getText());
                int claveFuncionario = buscarIDFuncionario(cii);
            try{
            Connection conexion = new Conexion().getConexion();
            psAux= conexion.prepareStatement(" insert into curriculum (IDFUNCIONARIO) values(?)");
            psAux.setInt(1, claveFuncionario);
            psAux.executeUpdate();
            psAux.close();
            
            }catch(Exception e) {
                System.err.println();
            }
        
        String  claveCurriculum = jTextField6.getText();
        jTextField14.setText(claveCurriculum);
        jButton28.setEnabled(false);
        jButton32.setEnabled(false);
        jButton33.setEnabled(false);
        jButton34.setEnabled(false);
         mostraridCurriculum();
         mostrarDatosActividadDocente(claveCurriculum);  
         mostrarActividadProfesional(claveCurriculum);
         mostrarCargosOficialesDesempeñados(claveCurriculum);
         mostrarEstudiosAcademicos(claveCurriculum);
            }
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
         if(jTextArea10.getText().equals("")){
          JOptionPane.showMessageDialog(null, "campos vacios");
        }else{
          try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into experiencia(IDDESCRIPCIONPUESTO,DESCRIPCIONEXPERIENCIA) values(?,?)");
            psSU.setInt(1,jComboBox7.getSelectedIndex());
            psSU.setString(2,jTextArea10.getText());
            psSU.executeUpdate();
            psSU.close();
            JOptionPane.showMessageDialog(null,"dato registrado correctamente");
           
          }catch(Exception e){
        
        }   
         }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
        if(jTextArea3.getText().equals("")){
          JOptionPane.showMessageDialog(null, "campos vacios");
        }else{
          try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into escolaridad(IDDESCRIPCIONPUESTO,DATOESCOLARIDAD) values(?,?)");
            psSU.setInt(1,jComboBox7.getSelectedIndex());
            psSU.setString(2,jTextArea3.getText());
            psSU.executeUpdate();
            psSU.close();
            JOptionPane.showMessageDialog(null,"dato registrado correctamente");
             
          }catch(Exception e){
        
        }   
         }
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
         if(jTextArea2.getText().equals("")){
          JOptionPane.showMessageDialog(null, "campos vacios");
        }else{
          try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into habilidaddestreza(IDDESCRIPCIONPUESTO,DATOHABILIDADDESTREZA) values(?,?)");
            psSU.setInt(1,jComboBox7.getSelectedIndex());
            psSU.setString(2,jTextArea2.getText());
            psSU.executeUpdate();
            psSU.close();
            JOptionPane.showMessageDialog(null,"dato registrado correctamente");
             
          }catch(Exception e){
        
        }   
         }
    }//GEN-LAST:event_jButton38ActionPerformed
/*
    De aca para adelante es las autimatizaciones para los botones de agregar n veces la descrpcion de puesto
    Hecho por erick--> Inicio codigo
    */
    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
         DescripcionPuesto inserciones = new DescripcionPuesto();
        inserciones.insertarExperiencia(idDescripcionPuesto, jTextField17.getText());
        jTextField17.setText("");
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
        DescripcionPuesto inserciones = new DescripcionPuesto();
        inserciones.insertarEscolaridad(idDescripcionPuesto, jTextField18.getText());
        jTextField18.setText("");
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        DescripcionPuesto inserciones = new DescripcionPuesto();
        inserciones.insertarHabilidadDestreza(idDescripcionPuesto, jTextField19.getText());
        jTextField19.setText("");
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        DescripcionPuesto inserciones = new DescripcionPuesto();
        inserciones.insertarAptitudes(idDescripcionPuesto, jTextField20.getText());
        jTextField20.setText("");
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
        DescripcionPuesto inserciones = new DescripcionPuesto();
        inserciones.insertarEsfuerzo(idDescripcionPuesto,(String)jComboBox11.getSelectedItem() ,jTextField21.getText());
        jTextField21.setText("");
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        if(jTextArea4.getText().equals("")){
          JOptionPane.showMessageDialog(null, "campos vacios");
        }else{
          try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into aptitudes(IDDESCRIPCIONPUESTO,NOMBREAAPTITUD) values(?,?)");
            psSU.setInt(1,jComboBox7.getSelectedIndex());
            psSU.setString(2,jTextArea4.getText());
            psSU.executeUpdate();
            psSU.close();
            JOptionPane.showMessageDialog(null,"dato registrado correctamente");
           
          }catch(Exception e){
        
        }   
      }
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
        if(jTextArea5.getText().equals("")){
          JOptionPane.showMessageDialog(null, "campos vacios");
        }else{
          try{Connection conexion = new Conexion().getConexion();
          //obtener el valor del combobox
          //String tipoEzfuerzo= (String) jComboBox6.getSelectedItem();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into esfuerzo(IDDESCRIPCIONPUESTO,TIPODEESFUERZO,DESCRIPCIONDELESFUERZO) values(?,?,?)");
            psSU.setInt(1,jComboBox7.getSelectedIndex());
            //psSU.setString(2,tipoEzfuerzo);
            psSU.setString(2, (String) jComboBox6.getSelectedItem());
            psSU.setString(3,jTextArea5.getText());
            psSU.executeUpdate();
            psSU.close();
            JOptionPane.showMessageDialog(null,"dato registrado correctamente");
           
          }catch(Exception e){
        
        }   
         }
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox11onceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11onceActionPerformed
        FuncionGeneral fg = (FuncionGeneral)jComboBox11once.getSelectedItem(); // Hecho por David
        jTextField15.setText(fg.getDescripcionFG());
    }//GEN-LAST:event_jComboBox11onceActionPerformed

    private void jComboBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox12ActionPerformed
        if(jComboBox12.getSelectedItem() instanceof FuncionEspecifica){
            FuncionEspecifica fe = (FuncionEspecifica)jComboBox12.getSelectedItem(); // Hecho por David
            jTextField16.setText(fe.getDescripcionFE());
        }else{
            jTextField16.setText("Ninguno");
        }
    }//GEN-LAST:event_jComboBox12ActionPerformed

    private void jButton35treintaYcincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35treintaYcincoActionPerformed
        if(!jTextField15.getText().equals("")){                                  // Hecho por David
           FuncionGeneral fg = (FuncionGeneral)jComboBox11once.getSelectedItem();
           if(new DatosPuestoTrabajo().actualizarFG(jTextField15.getText(),fg.getIdFuncion())){
               JOptionPane.showMessageDialog(null,"Funcion General actualizada");
           }else{
               JOptionPane.showMessageDialog(null,"Error al actualizar Funcion General");
           }
        }else{
            JOptionPane.showMessageDialog(null,"Error campo vacio");
        
        }
    }//GEN-LAST:event_jButton35treintaYcincoActionPerformed

    private void jButton36treintaYseisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36treintaYseisActionPerformed
       if(jComboBox12.getSelectedItem() instanceof FuncionEspecifica){
        if(!jTextField16.getText().equals("")){                                   //Hecho por David
           FuncionEspecifica fe = (FuncionEspecifica)jComboBox12.getSelectedItem();
           if(new DatosPuestoTrabajo().actualizarFE(jTextField16.getText(),fe.getIdFuncionEspecifica())){
               JOptionPane.showMessageDialog(null,"Funcion Especifica actualizada");
               cargarComboFE();
           }else{
               JOptionPane.showMessageDialog(null,"Error al actualizar Funcion Especifica");
           }
        }else{
            JOptionPane.showMessageDialog(null,"Error campo vacio");
        
        }
       }
    }//GEN-LAST:event_jButton36treintaYseisActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
      
       try{
       Connection conexion = new Conexion().getConexion();
       psSU = conexion.prepareStatement("delete from actividaddocente where IDACTIVIDADDOCENTE ="+idActividadDocente);
       
       int resultado = psSU.executeUpdate();
       if(resultado>0){
       JOptionPane.showMessageDialog(null, "dato eliminado correctamente");
       jTextArea6.setText("");
       }else{
       JOptionPane.showMessageDialog(null, "error al eliminar");
       }
       conexion.close();
       }catch(Exception e){
       } 
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
      try{
       Connection conexion = new Conexion().getConexion();
       psSU = conexion.prepareStatement("delete from actividadprofesional where IDACTIVIDADPROFESIONAL="+idActividadPofesional);
       
       int resultado = psSU.executeUpdate();
       if(resultado>0){
       JOptionPane.showMessageDialog(null, "dato eliminado correctamente");
       jTextArea8.setText("");
       }else{
       JOptionPane.showMessageDialog(null, "error al eliminar");
       }
       conexion.close();
       }catch(Exception e){
       } 
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
       try{
       Connection conexion = new Conexion().getConexion();
       psSU = conexion.prepareStatement("delete from cargosoficialesdesempenados where IDCARGODESEMPENADO="+idCargosDesempeñados);
       
       int resultado = psSU.executeUpdate();
       if(resultado>0){
       JOptionPane.showMessageDialog(null, "dato eliminado correctamente");
       jTextArea7.setText("");
       }else{
       JOptionPane.showMessageDialog(null, "error al eliminar");
       }
       conexion.close();
       }catch(Exception e){
       } 
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        try{
       Connection conexion = new Conexion().getConexion();
       psSU = conexion.prepareStatement("delete from estudioacademico where IDESTUDIOACADEMICO="+idEstudiosAcademicos);
       
       int resultado = psSU.executeUpdate();
       if(resultado>0){
       JOptionPane.showMessageDialog(null, "dato eliminado correctamente");
       jTextArea9.setText("");
       }else{
       JOptionPane.showMessageDialog(null, "error al eliminar");
       }
       conexion.close();
       }catch(Exception e){
       } 
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton500ActionPerformed
        String descripcion = jTextField500.getText();           // codigo hecho por David
        PuestoTrabajo pt = (PuestoTrabajo)jComboBox9.getSelectedItem();
        int idPuesto = pt.getIdPuesto();
        
        if(!descripcion.equals("")){
            new DatosPuestoTrabajo().insertarFuncionesEspesificas(idPuesto, descripcion);
            JOptionPane.showMessageDialog(null,"Nueva Funcion Especifica agregada con exito");
            cargarComboFE();
            if(jComboBox12.getSelectedItem() instanceof FuncionEspecifica){
                FuncionEspecifica fe = (FuncionEspecifica)jComboBox12.getSelectedItem();
                jTextField16.setText(fe.getDescripcionFE());
            }
            jTextField500.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"Error,campo vacio");
        
        }
    }//GEN-LAST:event_jButton500ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        if(jTextArea6.getText().isEmpty() || jTextArea7.getText().isEmpty()||jTextArea8.getText().isEmpty()||jTextArea7.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor Registre todos los datos", "ERROR",JOptionPane.INFORMATION_MESSAGE );
        }else{
            int respuesta=JOptionPane.showOptionDialog(this, "¿Esta Segur@ de Finalizar el registro?", "Finalizar el Registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI","NO"}, "Guardar Datos");
            if (respuesta == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Finalizado con Exito", "Salir", JOptionPane.INFORMATION_MESSAGE);
                llenarActividadDocente();
                llenarAtividadProfecional();
                cargosOficialesDesempeniados();
                llenarEstudiosAcademicos();
                limpiar();
                limpiarCurriculum();
                jTabbedPane1.setSelectedIndex(0);
                //jComboBox1.removeAllItems();
                llenarComboBoxPuestosDisponibles();
                jButton35.setVisible(true);
                jButton35.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jButton48ActionPerformed
    private void limpiarCurriculum(){
        jTextArea6.setText("");
        jTextArea7.setText("");
        jTextArea8.setText("");
        jTextArea9.setText("");
    }
    private void llenarActividadDocente(){
        try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into actividaddocente(IDCURRICULUM,ACTIVIDADDOCENTE) values(?,?)");
            psSU.setInt(1,idCurriculum );
            psSU.setString(2,jTextArea6.getText());
            psSU.executeUpdate();
            psSU.close();
            //JOptionPane.showMessageDialog(null,"dato registrado correctamente");
            //jButton28.setEnabled(false);  
          }catch(Exception e){
        
        }
    }
    private void llenarAtividadProfecional(){
        try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum
            psSU = conexion.prepareStatement(" insert into actividadprofesional(IDCURRICULUM,DATOSACTIVIDADPROFESIONAL) values(?,?)");
            psSU.setInt(1,idCurriculum );
            psSU.setString(2,jTextArea8.getText());
            psSU.executeUpdate();
            psSU.close();
            //JOptionPane.showMessageDialog(null,"dato registrado correctamente");
            //jButton32.setEnabled(false);  
          }catch(Exception e){
        
        }   
    }
    private void cargosOficialesDesempeniados(){
        try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into cargosoficialesdesempenados(IDCURRICULUM,DATOSDESEMPENADO) values(?,?)");
            psSU.setInt(1,idCurriculum );
            psSU.setString(2,jTextArea7.getText());
            psSU.executeUpdate();
            psSU.close();
            //JOptionPane.showMessageDialog(null,"dato registrado correctamente");
            //jButton33.setEnabled(false);  
          }catch(Exception e){
        
        }   
    }
    private void llenarEstudiosAcademicos(){
        try{Connection conexion = new Conexion().getConexion();
           //creamos actividades para el curriculum 
            psSU = conexion.prepareStatement(" insert into estudioacademico(IDCURRICULUM,DATOSESTUDIOACADEMICO) values(?,?)");
            psSU.setInt(1,idCurriculum );
            psSU.setString(2,jTextArea9.getText());
            psSU.executeUpdate();
            psSU.close();
            //JOptionPane.showMessageDialog(null,"dato registrado correctamente");
            //jButton34.setEnabled(false);  
          }catch(Exception e){
        
        }   
    }
    private void btnCerrarSesionSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionSUActionPerformed
         vistaPrincipal vp = new vistaPrincipal();
        vp.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCerrarSesionSUActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        PuestoTrabajo pt = (PuestoTrabajo)jComboBox9.getSelectedItem();
        int confirmacion = JOptionPane.showConfirmDialog(null,"Seguro de Eliminar?","Eliminar puesto de trabajo",0,JOptionPane.YES_NO_CANCEL_OPTION,null); // 0 = si ,  1 = no
        if(confirmacion == 0){
            if(new DatosPuestoTrabajo().eliminarPuestoTrabajo(pt.getIdPuesto())){
                JOptionPane.showMessageDialog(null,"Puesto de trabajo Eliminado con exito");
                llenarBuscarPT();
                actualizarDespuesDeEliminarPT();
                
            }else{
                JOptionPane.showMessageDialog(null,"Error al eliminar puesto de trabajo");
            }
        
        }
    }//GEN-LAST:event_jButton49ActionPerformed
    

 private void actualizarDespuesDeEliminarPT(){
        PuestoTrabajo pt = (PuestoTrabajo)(jComboBox9.getSelectedItem());   //codigo David
        //linea de codigo 2621
        jTextField13.setText(pt.getNombrePuesto());
        Departamento dep = new DatosPuestoTrabajo().getDepartamento(pt.getIdPuesto());
        PuestoTrabajo ptCombo = new DatosPuestoTrabajo().getPuestoSuperior(pt.getIdPuesto());
        jComboBox8.setSelectedItem(dep);
        jComboBox10.setSelectedItem(ptCombo);
        
        cargarComboFG();
        cargarComboFE();
        
        FuncionGeneral fg = (FuncionGeneral)jComboBox11once.getSelectedItem();
        jTextField15.setText(fg.getDescripcionFG());
        FuncionEspecifica fe = (FuncionEspecifica)jComboBox12.getSelectedItem();
        jTextField16.setText(fe.getDescripcionFE());
    }
    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // Eliminar una funcion espesifica
        if(jComboBox12.getSelectedItem() instanceof FuncionEspecifica){
            FuncionEspecifica fe = (FuncionEspecifica)jComboBox12.getSelectedItem();
            if(new DatosPuestoTrabajo().eliminarFuncionEspesifica(fe.getIdFuncionEspecifica())){
                JOptionPane.showMessageDialog(null,"Funcion Espesifica eliminada con exito");
                cargarComboFE();
                if(jComboBox12.getSelectedItem() instanceof String){
                    jTextField16.setText("Ninguno");
                }else{
                    FuncionEspecifica feRefrescar = (FuncionEspecifica)jComboBox12.getSelectedItem();
                    jTextField16.setText(feRefrescar.getDescripcionFE());
                }
            }else{
                JOptionPane.showMessageDialog(null,"Error al eliminar Funcion Espesifica");
            }
        }
    }//GEN-LAST:event_jButton52ActionPerformed

    private void btnBuscarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNActionPerformed
        // TODO add your handling code here:
         mostrarExperienciaDP();
         mostrarHabilidadDestrezaDP();
         mostrarEscolaridadDP();
         mostrarAptitudesDP();
         mostrarEsfuerzoDP();
    }//GEN-LAST:event_btnBuscarNActionPerformed

    private void btnSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigActionPerformed
        //boton siguiente
        indiceExp++;
        if(indiceExp < listaExp.size()){
        jTextArea10.setText("");
        jTextArea10.setText(listaExp.get(indiceExp).getdescripcionExperiencia());
        }else{
            indiceExp = 0;
            jTextArea10.setText(listaExp.get(indiceExp).getdescripcionExperiencia());
        }
        
    }//GEN-LAST:event_btnSigActionPerformed
    
    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        // TODO add your handling code here:
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement(" select * from funcionario where CI=?"); 
            psSU.setString(1,jTextField14.getText());
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                mostrarActividadDocente();
                
                mostrarcargosDesempenado();
                
                mostraractividadProfesional();
                mostrarEstudiosAcademios();
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // TODO add your handling code here:
        mostrarSiguienteDatoActividadProfesional();
    }//GEN-LAST:event_jButton54ActionPerformed

    private void mostrarSiguienteDatoActividadProfesional(){
          ArrayList<String> resultados=new ArrayList<>();
          ArrayList<Integer> idsAD=new ArrayList<>();
          Integer ci = Integer.parseInt(jTextField6.getText());
          int claveFuncionario = buscarIDFuncionario(ci);
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select * \n" +
"FROM funcionario f, curriculum c, actividadprofesional a \n" +
"where f.IDFUNCIONARIO= c.IDFUNCIONARIO and c.IDCURRICULUM= a.IDCURRICULUM\n" +
" and f.IDFUNCIONARIO= " + claveFuncionario); 
            
            
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                String  datosEstudiosAcademicos=rsSU.getString("DATOSACTIVIDADPROFESIONAL");
                resultados.add(datosEstudiosAcademicos);
                idsAD.add(rsSU.getInt("IDACTIVIDADPROFESIONAL"));
            }
            if(indiceActual< resultados.size()){
                String resultado=resultados.get(indiceActual);
                idActividadPofesional = idsAD.get(indiceActual);
                jTextArea8.setText(resultado);
                indiceActual++;
            }else{
                if(indiceActual>=resultados.size()){
                    indiceActual=0;
                }
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
        mostrarSiguienteDatoEstudiosAcademicos();
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        // TODO add your handling code here:
        mostrarSiguienteDatoActividadDocente();
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        // TODO add your handling code here:
        mostrarSiguienteDatoCargosOficialesDesempenado();
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        // TODO add your handling code here
        // verificacion si hay campos vacios 
        if(jTextField2.getText().isEmpty() || jTextField6.getText().isEmpty() || jTextField4.getText().isEmpty() || jTextField3.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Por favor Registre todos los datos", "ERROR",JOptionPane.INFORMATION_MESSAGE );
        }else{
            // muestra un cuadro de dialogo con informacion especifica de lo realizado
            int respuesta=JOptionPane.showOptionDialog(this, "Se Ingresara al \n Funcionario:"+jTextField2.getText()+"\n CI:"+jTextField6.getText(), "Confirma tu Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Ingresar","Cancelar"}, "Ingresar");
            // Verificar la respuesta del cuadro de diálogo
            if (respuesta == JOptionPane.YES_OPTION) {
                // Cambiar a la pestaña 4
                jTabbedPane1.setSelectedIndex(4);
                // configuracion de elementos de la interfaz grafica para curricullum
                String  claveCurriculum = jTextField6.getText();
                jTextField14.setText(claveCurriculum);
                jButton28.setEnabled(false);
                jButton32.setEnabled(false);
                jButton33.setEnabled(false);
                jButton34.setEnabled(false);
                jButton48.setVisible(false);
                // Mostrar información relacionada con el curriculum del funcionario
                mostraridCurriculum();
                mostrarDatosActividadDocente(claveCurriculum);  
                mostrarActividadProfesional(claveCurriculum);
                mostrarCargosOficialesDesempeñados(claveCurriculum);
                mostrarEstudiosAcademicos(claveCurriculum);
                if(jTextArea6.getText().equals("")){
                 jButton28.setEnabled(true);
                }
                if(jTextArea7.getText().equals("")){
                 jButton33.setEnabled(true);
                }
                if(jTextArea8.getText().equals("")){
                 jButton32.setEnabled(true);
                }
                if(jTextArea9.getText().equals("")){
                 jButton34.setEnabled(true);
                }
            }
        }
        

    }//GEN-LAST:event_jButton58ActionPerformed

    private void btnAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntActionPerformed
        int codigoAlterar = listaExp.get(indiceExp).getCodExperiencia();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("update experiencia set descripcionExperiencia = ? where CodExperiencia = ?"); 
            psSU.setString(1,jTextArea10.getText());
            psSU.setInt(2,codigoAlterar);
            psSU.executeUpdate(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Modificacion realizada en:\n"+"Experiencia:\n"+jTextArea10.getText());
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
        mostrarExperienciaDP();
    }//GEN-LAST:event_btnAntActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if(jToggleButton1.isSelected()){
            jToggleButton1.setText("OFF");
            jComboBox3.setEnabled(false);
        
        }else{
            jToggleButton1.setText("ON");
            jComboBox3.setEnabled(true);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        // TODO add your handling code here:
        int respuesta=JOptionPane.showOptionDialog(this, "¿Esta Segur@ de Salir?", "EXIT", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI","NO"}, "Guardar Datos");
        if (respuesta == JOptionPane.YES_OPTION){
        limpiar();
        limpiarCurriculum();
        jTabbedPane1.setSelectedIndex(0);
        llenarComboBoxPuestosDisponibles();
        jButton35.setEnabled(true);
        jButton35.setVisible(true);
        }
        
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        // TODO add your handling code here:
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("update estudioacademico set DATOSESTUDIOACADEMICO = ? where IDESTUDIOACADEMICO = "+idEstudiosAcademicos); 
            psSU.setString(1,jTextArea9.getText());
            
            psSU.executeUpdate(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Modificacion realizada en:\n"+"Estudios Academicos:\n"+jTextArea9.getText());
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        // TODO add your handling code here:
         try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("update actividadprofesional set DATOSACTIVIDADPROFESIONAL = ? where IDACTIVIDADPROFESIONAL = "+idActividadPofesional); 
            psSU.setString(1,jTextArea8.getText());
            
            psSU.executeUpdate(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Modificacion realizada en:\n"+"Actividad Profecional:\n"+jTextArea8.getText());
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
        try{
            // Establecer una conexión a la base de datos
            Connection conexion = new Conexion().getConexion();
            // Preparar una sentencia SQL de actualización para la tabla "actividaddocente"
            psSU = (PreparedStatement) conexion.prepareStatement("update actividaddocente set ACTIVIDADDOCENTE = ? where IDACTIVIDADDOCENTE = "+idActividadDocente); 
            // Establecer el parámetro en la sentencia SQL utilizando el valor del JTextArea6
            psSU.setString(1,jTextArea6.getText());
            // Ejecutar la actualización en la base de datos
            psSU.executeUpdate(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Modificacion realizada en:\n"+"Actividad Docente:\n"+jTextArea6.getText());
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        // TODO add your handling code here:
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("update cargosoficialesdesempenados set DATOSDESEMPENADO = ? where IDCARGODESEMPENADO = "+idCargosDesempeñados); 
            psSU.setString(1,jTextArea7.getText());
            
            psSU.executeUpdate(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Modificacion realizada en:\n"+"Cargos Oficiales Desempeñados:\n"+jTextArea7.getText());
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        // TODO add your handling code here:
        int codigoAlterar = jComboBox7.getSelectedIndex();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("update esfuerzo set DESCRIPCIONDELESFUERZO = ? where IDESFUERZO = ?"); 
            psSU.setString(1,jTextArea5.getText());
            psSU.setInt(2,codigoAlterar);
            psSU.executeUpdate(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Modificacion realizada en:\n"+"Esfuerzo:\n"+jTextArea5.getText());
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
        
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
        int codigoAlterar = jComboBox7.getSelectedIndex();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("update escolaridad set DATOESCOLARIDAD = ? where IDESCOLARIDAD = ?"); 
            psSU.setString(1,jTextArea3.getText());
            psSU.setInt(2,codigoAlterar);
            psSU.executeUpdate(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Modificacion realizada en:\n"+"Escolaridad:\n"+jTextArea3.getText());
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        // TODO add your handling code here:
        int codigoAlterar = jComboBox7.getSelectedIndex();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("update aptitudes set NOMBREAAPTITUD = ? where IDAPTITUD = ?"); 
            psSU.setString(1,jTextArea4.getText());
            psSU.setInt(2,codigoAlterar);
            psSU.executeUpdate(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Modificacion realizada en:\n"+"Aptitudes:\n"+jTextArea4.getText());
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        // TODO add your handling code here:
        int codigoAlterar = jComboBox7.getSelectedIndex();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("update habilidaddestreza set DATOHABILIDADDESTREZA = ? where IDHABILIDADDESTREZA = ?"); 
            psSU.setString(1,jTextArea2.getText());
            psSU.setInt(2,codigoAlterar);
            psSU.executeUpdate(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Modificacion realizada en:\n"+"Habilidad y Destreza:\n"+jTextArea2.getText());
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }//GEN-LAST:event_jButton67ActionPerformed

    private void cargarComboDepartamento(){
        modelo10 = new DefaultComboBoxModel();
        ArrayList<Departamento>contenido = new DatosPuestoTrabajo().getDepartamentos();
        for(int i=-0;i<contenido.size();i++){
            modelo10.addElement(contenido.get(i));
        }
        jComboBox13.setModel(modelo10);
        
         
    }
    private void jButton74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton74ActionPerformed
        // TODO add your handling code here:
        cargarComboDepartamento();
        cargarComboBoxProcedimientos();
        cargarComboBoxInterventores();
        jTextField27.setText(null);
        jTextField28.setText(null);
        jTextField26.setText(null);
        jTextField25.setText(null);
        jTextField23.setText(null);
        jTextField24.setText(null);
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton74ActionPerformed

    private void jButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73ActionPerformed
        // TODO add your handling code here:
        
        if(jTextField28.getText().isEmpty() || jTextField27.getText().isEmpty() || jComboBox15.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"campo vacio");
        }else{
        try {
             Connection conexion = new Conexion().getConexion();
             psSU = conexion.prepareStatement("insert into listadeactividades (IDINTERVENTOR,DESCRIPCIONDEACTIVIDAD, ORDENLISTA)values(?,?,?)");
             psSU.setString(2,jTextField27.getText());
             psSU.setInt(1,jComboBox15.getSelectedIndex());
             psSU.setInt(3,Integer.parseInt(jTextField28.getText()));
             
            int resultado = psSU.executeUpdate();
            if(resultado > 0 ){
                JOptionPane.showMessageDialog(null,"Procedimiento registrado");
                cargarComboBoxInterventores();
                jTextField27.setText(null);
                jTextField28.setText(null);
                
            }else{
                JOptionPane.showMessageDialog(null,"Registro incorrecto");
            }
            conexion.close();
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
        }
    }//GEN-LAST:event_jButton73ActionPerformed

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        // TODO add your handling code here:
        cargarComboBoxInterventores();
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jButton72ActionPerformed

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        // TODO add your handling code here:
        if(jTextField26.getText().isEmpty() || jComboBox14.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"campo vacio");
        }else{
        try {
             Connection conexion = new Conexion().getConexion();
             psSU = conexion.prepareStatement("insert into interventores(IDPROCIMIENTO,NOMBREINTERVENTOR) values (?,?) ");
             psSU.setInt(1,jComboBox14.getSelectedIndex());
             psSU.setString(2,jTextField26.getText());
             
            int resultado = psSU.executeUpdate();
            if(resultado > 0 ){
                JOptionPane.showMessageDialog(null,"Interventor registrado");
                jTextField26.setText(null);
            }else{
                JOptionPane.showMessageDialog(null,"Registro incorrecto");
            }
            conexion.close();
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
        }
    }//GEN-LAST:event_jButton71ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        // TODO add your handling code here:
         if(jTextField25.getText().isEmpty() || jComboBox14.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"campo vacio");
        }else{
        try {
             Connection conexion = new Conexion().getConexion();
             psSU = conexion.prepareStatement("insert into politicasdeoperacion (IDPROCIMIENTO,DESCRIPCIONPOLITICA)values(?,?)");
             psSU.setString(2,jTextField25.getText());
             psSU.setInt(1,jComboBox14.getSelectedIndex());
             
             
            int resultado = psSU.executeUpdate();
            if(resultado > 0 ){
                JOptionPane.showMessageDialog(null,"politica de procedimiento registrada");
                jTextField25.setText(null);
            }else{
                JOptionPane.showMessageDialog(null,"Registro incorrecto");
            }
            conexion.close();
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
    } 
    }//GEN-LAST:event_jButton70ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        // TODO add your handling code here:
        if(jTextField23.getText().isEmpty() || jComboBox13.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"campo vacio");
        }else{
        try {
             Connection conexion = new Conexion().getConexion();
             psSU = conexion.prepareStatement("insert into procedimiento (IDDEPARTAMENTO,NOMBREPROCEDIMIENTO, OBJETIVOPROCEDIMIENTO)values(?,?,?)");
             psSU.setString(2,jTextField23.getText());
             psSU.setInt(1,jComboBox13.getSelectedIndex()+1);
             psSU.setString(3,jTextField24.getText());
             
            int resultado = psSU.executeUpdate();
            if(resultado > 0 ){
                JOptionPane.showMessageDialog(null,"Procedimiento registrado");
                cargarComboDepartamento();
                cargarComboBoxProcedimientos();
                jTextField23.setText(null);
                jTextField24.setText(null);
                
            }else{
                JOptionPane.showMessageDialog(null,"Registro incorrecto");
            }
            conexion.close();
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
    }
    }//GEN-LAST:event_jButton69ActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        //Actualizar politicas de Operacion
        jTabbedPane1.setSelectedIndex(12);
    }//GEN-LAST:event_jButton68ActionPerformed

    private void jComboBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox16ActionPerformed
        // Actualizar politicas de Operacion
        cargarComboProcedimientos();
        tipoDeDatoProcedimiento();
    }//GEN-LAST:event_jComboBox16ActionPerformed

    private void jComboBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox17ActionPerformed
        // Actualizar Politicas de Operacion
        cargarPoliticasOperacion();
    }//GEN-LAST:event_jComboBox17ActionPerformed

    private void jComboBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox18ActionPerformed
        // Actualizar Politica de Operacion
        cargarAreaTextoPoliticaOperacion();
    }//GEN-LAST:event_jComboBox18ActionPerformed

    private void jButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton79ActionPerformed
        // Actualizar politica de Operacion
        actualizarPoliticaOperacion();
    }//GEN-LAST:event_jButton79ActionPerformed

    private void jButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton80ActionPerformed
        eliminarPoliticaDeOperacion();
    }//GEN-LAST:event_jButton80ActionPerformed

    private void jButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton81ActionPerformed
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton81ActionPerformed

    private void jButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jButton75ActionPerformed

    private void jComboBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox19ActionPerformed
        cargarComboProcedimientosInter();
        tipoDeDatoProcedimientoInter();
    }//GEN-LAST:event_jComboBox19ActionPerformed

    private void jComboBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox13ActionPerformed

    private void jComboBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox14ActionPerformed

    private void jComboBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox20ActionPerformed
        // TODO add your handling code here:
        Procedimiento procedimiento = (Procedimiento)(jComboBox20.getSelectedItem());
        idProcedimientoInter = procedimiento.getIdProcedimiento();
    }//GEN-LAST:event_jComboBox20ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jButton82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton82ActionPerformed
        // TODO add your handling code here:
        cargarInterventores(); 
    }//GEN-LAST:event_jButton82ActionPerformed

    private void jButton83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton83ActionPerformed
        actualizarProcedimiento();
    }//GEN-LAST:event_jButton83ActionPerformed

    private void jButton78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton78ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        cargarComboDepartamento();
    }//GEN-LAST:event_jButton78ActionPerformed

    private void jComboBox22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox22ActionPerformed
       cargarAreaTextoProcedimiento();
       cargarAreaTextoObjetivo();
       jTextArea11.setCaretPosition(0);
        jTextArea12.setCaretPosition(0);
    }//GEN-LAST:event_jComboBox22ActionPerformed

    private void jComboBox21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox21ActionPerformed
        cargarComboProcedimientos2();
        tipoDeDatoProcedimiento2();
    }//GEN-LAST:event_jComboBox21ActionPerformed

    private void jButton84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton84ActionPerformed
        eliminarProcedimiento();
    }//GEN-LAST:event_jButton84ActionPerformed

    private void jButton85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton85ActionPerformed
       actulizarObjetivo();
    }//GEN-LAST:event_jButton85ActionPerformed

    private void jButton86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton86ActionPerformed
        eliminarObjetivo();
    }//GEN-LAST:event_jButton86ActionPerformed

    private void jButton89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton89ActionPerformed
        // TODO add your handling code here:
         try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("update interventores set nombreinterventor = ? where idinterventor = ?"); 
            psSU.setString(1,jTextField29.getText());
            psSU.setInt(2,interventores.get(indiceGlobal).getIdInterventor());
            psSU.executeUpdate(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Modificacion realizada en:\n"+"Interventores:\n"+jTextField29.getText());
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
        cargarInterventores();
        jTextField29.setText(interventores.get(indiceGlobal).getNombreInterventor());
    }//GEN-LAST:event_jButton89ActionPerformed

    private void jButton88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton88ActionPerformed
        indiceGlobal--;
        if(indiceGlobal < 0){
            indiceGlobal= interventores.size()-1;
            jTextField29.setText("");
            jTextField29.setText(interventores.get(indiceGlobal).getNombreInterventor());
            
        }else{
            jTextField29.setText(interventores.get(indiceGlobal).getNombreInterventor());

        }
    }//GEN-LAST:event_jButton88ActionPerformed

    private void jButton90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton90ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        try{
            Connection con = new Conexion().getConexion();
            psSU = con.prepareStatement("delete from interventores where idinterventor = ?");
            psSU.setInt(1,interventores.get(indiceGlobal).getIdInterventor());
            psSU.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente: "+jTextField29.getText());
            
            if(interventores.isEmpty()){
                jTextField29.setText("No existe interventores");
                jButton83.setVisible(false);
                jButton84.setVisible(false);
                jButton85.setVisible(false);
                jButton86.setVisible(false);
            }else{
                jButton83.setVisible(true);
                jButton84.setVisible(true);
                jButton85.setVisible(true);
                jButton86.setVisible(true);
                if(indiceGlobal != 0){
                    indiceGlobal--;
                }
                jTextField29.setText(interventores.get(indiceGlobal).getNombreInterventor());
            }
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        cargarInterventores();
    }//GEN-LAST:event_jButton90ActionPerformed

    private void jButton87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton87ActionPerformed
        // TODO add your handling code here:
        indiceGlobal++;
        if(indiceGlobal < interventores.size()){
            jTextField29.setText("");
            jTextField29.setText(interventores.get(indiceGlobal).getNombreInterventor());
        }else{
            indiceGlobal = 0;
            jTextField29.setText(interventores.get(indiceGlobal).getNombreInterventor());
        }
    }//GEN-LAST:event_jButton87ActionPerformed

    private void Guardar_ImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_ImagenActionPerformed
        GuardarImagen();
    }//GEN-LAST:event_Guardar_ImagenActionPerformed
    public void GuardarImagen(){
        if (txt_nombreImagen.getText().equalsIgnoreCase("")) {
            txt_nombreImagen.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        } else {
            String nombre;
            nombre = txt_nombreImagen.getText().trim();
            int i = jComboBox_Imagen.getSelectedIndex();
            try {
                Connection conexion = new Conexion().getConexion();
                psSU = conexion.prepareStatement("insert into imagen values (?,?,?,?)");
                psSU.setInt(1, 0);
                psSU.setString(2,nombre);
                psSU.setBlob(3, fis,longitudBytes);
                psSU.setInt(4,i);
                
                psSU.executeUpdate();
                conexion.close();
                LimpiarImagen();
                txt_nombreImagen.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                Foto.setText("FOTO");
                
            } catch (Exception e) {
                System.out.println("Error al guardar la foto" + e);
                JOptionPane.showMessageDialog(null, "¡¡Error al guardar Foto!!");
          }
        }
 
    }
    
    public void LimpiarImagen(){
        txt_nombreImagen.setText("");
        Foto.setText("FOTO");
        txt_nombreImagenDiagrama.setText("");
        Foto_Procedimiento.setText("FOTO");
    }
    
    public void mostrarTabla() {
        try {
           Connection conexion = new Conexion().getConexion();
           PreparedStatement psSU = conexion.prepareStatement("SELECT * FROM imagen"); // 
           ResultSet rs = psSU.executeQuery(); // Agregué esta línea para ejecutar la consulta

           DefaultTableModel modelo = new DefaultTableModel();
           modelo.addColumn("idImagen");
           modelo.addColumn("Nombre_Imagen");
           modelo.addColumn("TIPO");
           modelo.addColumn("Departamento");
           
            while (rs.next()) {
            // Obtén los datos de la fila actual
            int idImagen = rs.getInt("idImagen");
            String nomImagen = rs.getString("nomImagen");
            // Puedes manejar la columna de imagen de la manera que necesites
         
            // Por ejemplo, si la columna es de tipo BLOB, podrías mostrar "Imagen" o algo así
            String imagen = "Imagen"; 
            
            int IDDEPARTAMENTO = rs.getInt("IDDEPARTAMENTO");
            //Buscar el departamento que vive en la pos del combobox
            String nomDepartamento = (String) jComboBox4.getItemAt(IDDEPARTAMENTO);
            
            // Añade una fila al modelo con los datos obtenidos
            modelo.addRow(new Object[]{idImagen, nomImagen, imagen,nomDepartamento});
          }

            jTable1.setModel(modelo);

           // Cierra la conexión y el conjunto de resultados
            rs.close();
            psSU.close();
            conexion.close();
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("Error al mostrar la tabla: " + e.getMessage());
        }
    }
    
    
    private void txt_nombreImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreImagenActionPerformed

    private void Buscar_ImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_ImagenActionPerformed
        Consulta consulta = new Consulta();
        consulta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Buscar_ImagenActionPerformed

    private void FotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FotoMouseClicked
        JFileChooser se = new JFileChooser();
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);
        Foto.setText("FOTO");
        Foto.setIcon(null);
        if(estado ==  JFileChooser.APPROVE_OPTION){
            try {
                fis= new FileInputStream(se.getSelectedFile());
                this.longitudBytes =  (int) se.getSelectedFile().length();
                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(Foto.getWidth(),Foto.getHeight() ,Image.SCALE_DEFAULT);
                Foto.setIcon(new ImageIcon(icono));
                Foto.updateUI();
                Foto.setText("");
                
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error en el SEGUNDO catch");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error en el PRIMER catch");
            }
        }
    }//GEN-LAST:event_FotoMouseClicked

    private void jButton93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton93ActionPerformed
        // TODO add your handling code here:
        mostrarTabla();
    }//GEN-LAST:event_jButton93ActionPerformed

    private void jButton94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton94ActionPerformed
      // Verificar si hay una fila seleccionada en la tabla
      int filaSeleccionada = jTable1.getSelectedRow();
    
      if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione una fila en la tabla para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }

      // Obtener el valor de la columna su ID
      int idModificacion = (int) jTable1.getValueAt(filaSeleccionada, 0);

      // abrir un JFileChooser y obtener la ruta de la nueva imagen
      JFileChooser fileChooser = new JFileChooser();
      int seleccion = fileChooser.showOpenDialog(null);
     
      if (seleccion == JFileChooser.APPROVE_OPTION) {
        // Obtener la ruta de la nueva imagen
        String nuevaRutaImagen = fileChooser.getSelectedFile().getAbsolutePath();
        
        // Solicitar al usuario que ingrese el nuevo nombre
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
        
        // Obtener el departamento seleccionado del JComboBox
        String nuevoDepartamento = (String) jComboBox_Imagen.getSelectedItem();

        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty() && !nuevoDepartamento.equals("Selecione un Departamento")) {
            // Si el usuario ingresó un nuevo nombre y seleccionó un departamento, continuar con la modificación
            
            // Mandar el ID del departamento con el jcombob
            int i = jComboBox_Imagen.getSelectedIndex();
            
            // Llama al nuevo método para modificar datos e imagen
            modificarDatosEImagen(idModificacion, nuevoNombre, nuevaRutaImagen, i);
        } else {
            // El usuario no ingresó un nuevo nombre o no seleccionó un departamento
            JOptionPane.showMessageDialog(null, "Debe ingresar un nuevo nombre y seleccionar un departamento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    }//GEN-LAST:event_jButton94ActionPerformed

    public void modificarDatosEImagen(int idModificacion, String nuevoNombre, String nuevaRutaImagen, int nuevoDepartamento) {
        try {
          Connection conexion = new Conexion().getConexion();

          // Obtener el contenido binario de la nueva imagen
          File file = new File(nuevaRutaImagen);
          int longitudBytes = (int) file.length();
          FileInputStream fis = new FileInputStream(file);

        
          String consulta = "UPDATE imagen SET nomImagen = ?, imagen = ?, IDDEPARTAMENTO = ? WHERE idImagen = ?";
          PreparedStatement psModificar = conexion.prepareStatement(consulta);
          psModificar.setString(1, nuevoNombre);
          psModificar.setBinaryStream(2, fis, longitudBytes);
          psModificar.setInt(3, nuevoDepartamento);
          psModificar.setInt(4, idModificacion);

          int filasAfectadas = psModificar.executeUpdate();

         if (filasAfectadas > 0) {
            System.out.println("Registro modificado correctamente");
         } else {
            System.out.println("No se pudo modificar el registro");
         }

         // Cierra el FileInputStream y la conexión
         fis.close();
         psModificar.close();
         conexion.close();
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Error al modificar los datos e imagen: " + e.getMessage());
        } 
    }

    
    private void jButton91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton91ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(14);
    }//GEN-LAST:event_jButton91ActionPerformed

    private void jButton76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton76ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(15);
    }//GEN-LAST:event_jButton76ActionPerformed

    private void jButton98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton98ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton98ActionPerformed

    private void jComboBox24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox24ActionPerformed
        // TODO add your handling code here:
        Procedimiento procedimiento = (Procedimiento)(jComboBox24.getSelectedItem());
        idProcedimientolistaActividades = procedimiento.getIdProcedimiento();
        cargarComboInterventorlistaActividades();
        tipoDeDatointerventorlistaActividades();
        cargarDatosIniciales();
    }//GEN-LAST:event_jComboBox24ActionPerformed

    private void jComboBox23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox23ActionPerformed
        // TODO add your handling code here:
         cargarComboProcedimientoslistaActividades();
         tipoDeDatoProcedimientolistaActividades();
    }//GEN-LAST:event_jComboBox23ActionPerformed

    private void jComboBox25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox25ActionPerformed
        // TODO add your handling code here:
        InterventorSU interventor = (InterventorSU)(jComboBox25.getSelectedItem());
        idInterventorlistaActividades = interventor.getIdInterventor();
    }//GEN-LAST:event_jComboBox25ActionPerformed

    private void jButton92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton92ActionPerformed
        // TODO add your handling code here:
        Procedimiento procedimiento=(Procedimiento) jComboBox24.getSelectedItem();
        ArrayList<ListaDeActividades> actividades=new DatosProcedimientos().obtenerDatosDeLaListaDeActividades(procedimiento.getIdProcedimiento());
        if(!actividades.isEmpty()){
            ListaDeActividades actividad=actividades.get(0);
            jComboBox23.setSelectedItem(new InterventorSU(actividad.getIdInterventor(),0,"NombreInterventor"));
            jTextField30.setText(actividad.getDescripcionDeActividad());
            jTextField31.setText(String.valueOf(actividad.getOrdenLista()));
            jTextField32.setText(String.valueOf(actividad.getIdLista()));
        }else{
            System.out.println("Nada");
        }
    }//GEN-LAST:event_jButton92ActionPerformed

    private void jButton95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton95ActionPerformed
        // TODO add your handling code here:
        rotarDatosDeLaListaActividades();
    }//GEN-LAST:event_jButton95ActionPerformed

    private void jButton97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton97ActionPerformed
        // TODO add your handling code here:
        int idActividadEliminar = Integer.parseInt(jTextField32.getText());
        new DatosProcedimientos().eliminarActividad(idActividadEliminar);
        cargarDatosIniciales();
    }//GEN-LAST:event_jButton97ActionPerformed

    private void jButton96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton96ActionPerformed
        // TODO add your handling code here:
        try {
        int idActividadGuardar = Integer.parseInt(jTextField32.getText());
        String nuevaDescripcion = jTextField30.getText();
        int nuevoOrden = Integer.parseInt(jTextField31.getText());
        InterventorSU nuevointerventor=(InterventorSU)jComboBox25.getSelectedItem();
        int nuevoidInterventor=nuevointerventor.getIdInterventor();
       // Llama al método para actualizar la actividad
        new DatosProcedimientos().actualizarActividad(idActividadGuardar, nuevaDescripcion, nuevoOrden);
        new DatosProcedimientos().actualizarIdInterventorActividad(idActividadGuardar, nuevoidInterventor);
        cargarComboInterventorlistaActividades();
        cargarDatosIniciales();
    } catch (NumberFormatException e) {
        System.err.println("Error al parsear datos: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton96ActionPerformed

    private void jButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton77ActionPerformed
        String seleccion = (String) jComboBox14.getSelectedItem();
        //System.out.println(""+seleccion);
        int idProcedimiento = buscarIDProcedimiento(seleccion) ;
        //System.out.println(""+idProcedimiento);
      
         try{             
           Connection  conexion = new Conexion().getConexion();
           psSU = conexion.prepareStatement("DELETE FROM procedimiento WHERE IDPROCIMIENTO = "+idProcedimiento);
           int res = psSU.executeUpdate();
           if(res>0){
           JOptionPane.showMessageDialog(null, "Procedimiento eliminado");
           limpiar();
           }else{
           JOptionPane.showMessageDialog(null, "error al eliminar el procedimiento");
           }
           conexion.close();    
           }catch(Exception ex){
           System.err.println("Error, "+ex);
           }
            actualizar();
    }//GEN-LAST:event_jButton77ActionPerformed

    private void jButton_eliminarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarImagenActionPerformed
        
         // Obtiene la fila seleccionada
                int filaSeleccionada = jTable1.getSelectedRow();

                if (filaSeleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila en la tabla para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Obtiene el idImagen de la fila seleccionada
                int idEliminar = (int) jTable1.getValueAt(filaSeleccionada, 0);
                // Llama al método para eliminar la imagen
                eliminarImagen(idEliminar);
                // Actualiza la tabla después de eliminar
                mostrarTabla();            
    }//GEN-LAST:event_jButton_eliminarImagenActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtiene el idImagen de la fila seleccionada
            int idSeleccionado = (int) jTable1.getValueAt(filaSeleccionada, 0);

            // Llama a un método para obtener la información de la imagen según el id
            mostrarImagenTabla(idSeleccionado);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox_ImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ImagenActionPerformed

    private void jButton100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton100ActionPerformed
        // TODO add your handling code here:
        Consulta consulta = new Consulta();
        consulta.setVisible(true);
        this.dispose();
        int i = jComboBox4.getSelectedIndex();
        consulta.BuscarImagen(i);
    }//GEN-LAST:event_jButton100ActionPerformed

    private void txt_nombreImagenDiagramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreImagenDiagramaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreImagenDiagramaActionPerformed

    private void Foto_ProcedimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Foto_ProcedimientoMouseClicked
        JFileChooser se = new JFileChooser();
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);
        Foto_Procedimiento.setText("FOTO");
        Foto_Procedimiento.setIcon(null);
        txt_nombreImagenDiagrama.setText("");
        if(estado ==  JFileChooser.APPROVE_OPTION){
            try {
                fiss= new FileInputStream(se.getSelectedFile());
                this.longitudBytess =  (int) se.getSelectedFile().length();
                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(Foto_Procedimiento.getWidth(),Foto_Procedimiento.getHeight() ,Image.SCALE_DEFAULT);
                Foto_Procedimiento.setIcon(new ImageIcon(icono));
                Foto_Procedimiento.updateUI();
                Foto_Procedimiento.setText("");
                
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error en el SEGUNDO catch");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error en el PRIMER catch");
            }
        }
    }//GEN-LAST:event_Foto_ProcedimientoMouseClicked

    private void jButton99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton99ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(16);
    }//GEN-LAST:event_jButton99ActionPerformed

    private void guardar_DiagramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_DiagramaActionPerformed
        // TODO add your handling code here:
        GuardarDiagrama();
    }//GEN-LAST:event_guardar_DiagramaActionPerformed

    private void jComboBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox26ActionPerformed
        // TODO add your handling code here:
        cargarComboProcedimientosImagen();
        tipoDeDatoProcedimientoImagen();
    }//GEN-LAST:event_jComboBox26ActionPerformed

    private void jComboBox26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox26MouseClicked

    private void Tabla_procedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tabla_procedimientoActionPerformed
        // TODO add your handling code here:
        mostrarTablaDiagrama();
    }//GEN-LAST:event_Tabla_procedimientoActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = jTable2.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtiene el idImagen de la fila seleccionada
            int idSeleccionado = (int) jTable2.getValueAt(filaSeleccionada, 0);

            // Llama a un método para obtener la información de la imagen según el id
            mostrarImagenTablaDiagrama(idSeleccionado);
            txt_nombreImagenDiagrama.setText("");
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void Buscar_DiagramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_DiagramaActionPerformed
        // TODO add your handling code here:
        BuscarDiagrama();
    }//GEN-LAST:event_Buscar_DiagramaActionPerformed

    private void Mod_DiagramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mod_DiagramaActionPerformed
        // Verificar si hay una fila seleccionada en la tabla
      int filaSeleccionada = jTable2.getSelectedRow();
    
      if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione una fila en la tabla para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }

      // Obtener el valor de la columna "idImagen" de la fila seleccionada
      int idModificacion = (int) jTable2.getValueAt(filaSeleccionada, 0);

      // abrir un JFileChooser y obtener la ruta de la nueva imagen
      JFileChooser fileChooser = new JFileChooser();
      int seleccion = fileChooser.showOpenDialog(null);
     
      if (seleccion == JFileChooser.APPROVE_OPTION) {
        // Obtener la ruta de la nueva imagen
        String nuevaRutaImagen = fileChooser.getSelectedFile().getAbsolutePath();
        
        // Solicitar al usuario que ingrese el nuevo nombre
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
        
        // Obtener el departamento seleccionado del JComboBox
        Object procedimiento = jComboBox27.getSelectedItem();
        Object departamento = jComboBox26.getSelectedItem();
        if (procedimiento != null && procedimiento instanceof Procedimiento && 
            nuevoNombre != null && !nuevoNombre.trim().isEmpty() && departamento != null && departamento instanceof Departamento) {
            // Si el usuario ingresó un nuevo nombre y seleccionó un departamento, continuar con la modificación
    
            
            // Llama al nuevo método para modificar datos e imagen
            modificarDatosEImagenDiagrama(idModificacion, nuevoNombre, nuevaRutaImagen, (Procedimiento) procedimiento);
        } else {
            // El usuario no ingresó un nuevo nombre o no seleccionó un departamento
            JOptionPane.showMessageDialog(null, "Debe ingresar un nuevo nombre y seleccionar un departamento , con su procedimiento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    }//GEN-LAST:event_Mod_DiagramaActionPerformed
    
    public void modificarDatosEImagenDiagrama(int idModificacion, String nuevoNombre, String nuevaRutaImagen, Procedimiento procedimiento) {
        try {
          Connection conexion = new Conexion().getConexion();

          // Obtener el contenido binario de la nueva imagen
          File file = new File(nuevaRutaImagen);
          int longitudBytes = (int) file.length();
          FileInputStream fis = new FileInputStream(file);

        
          String consulta = "UPDATE imagenprocedimiento SET nomImagen = ?, imagen = ?, IDPROCIMIENTO = ? WHERE idImagen = ?";
          PreparedStatement psModificar = conexion.prepareStatement(consulta);
          psModificar.setString(1, nuevoNombre);
          psModificar.setBinaryStream(2, fis, longitudBytes);
          psModificar.setInt(3, procedimiento.getIdProcedimiento());
          psModificar.setInt(4, idModificacion);

          int filasAfectadas = psModificar.executeUpdate();

         if (filasAfectadas > 0) {
            System.out.println("Registro modificado correctamente");
         } else {
            System.out.println("No se pudo modificar el registro");
         }

         // Cierra el FileInputStream y la conexión
         fis.close();
         psModificar.close();
         conexion.close();
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Error al modificar los datos e imagen: " + e.getMessage());
        } 
    }
    
    private void Eliminar_DiagramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_DiagramaActionPerformed
        // TODO add your handling code here:
          int filaSeleccionada = jTable2.getSelectedRow();
                if (filaSeleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila en la tabla para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Obtiene el idImagen de la fila seleccionada
                int idEliminar = (int) jTable2.getValueAt(filaSeleccionada, 0);
                // Llama al método para eliminar la imagen
                eliminarImagenDiagrama(idEliminar);
                // Actualiza la tabla después de eliminar
                mostrarTablaDiagrama();
    }//GEN-LAST:event_Eliminar_DiagramaActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if(jToggleButton2.isSelected()){
            jToggleButton2.setText("SI");
        }else{
            jToggleButton2.setText("NO");
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed
    
    private void eliminarImagenDiagrama(int idImagen) {
      try {
        Connection conexion = new Conexion().getConexion();
        String consultaEliminar = "DELETE FROM imagenprocedimiento WHERE idImagen = ?";
        PreparedStatement psEliminar = conexion.prepareStatement(consultaEliminar);
        psEliminar.setInt(1, idImagen);

        int filasAfectadas = psEliminar.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Imagen eliminada correctamente");
        } else {
            System.out.println("No se pudo eliminar la imagen");
        }

        // Cierra el PreparedStatement y la conexión
        psEliminar.close();
        conexion.close();
      } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al eliminar la imagen: " + e.getMessage());
      }
    }
    
    public void BuscarDiagrama() {
        Object i = jComboBox27.getSelectedItem();  
        if (i instanceof Procedimiento) {
            // Convertir el elemento seleccionado a una instancia de Procedimiento
            Procedimiento procedimientoSeleccionado = (Procedimiento) i;
            // Obtener el ID del Procedimiento
            int idProcedimiento = procedimientoSeleccionado.getIdProcedimiento();
            
            try {
                
                Connection conexion = new Conexion().getConexion();
                PreparedStatement psBuscar = conexion.prepareStatement("SELECT * FROM imagenprocedimiento WHERE IDPROCIMIENTO = ?");
               
                psBuscar.setInt(1, idProcedimiento);

                ResultSet rs = psBuscar.executeQuery();
                
                if (rs.next()) {
                    
                    // Si se encuentra el diagrama, puedes realizar alguna acción aquí
                    // Por ejemplo, mostrar la información o cargar la imagen en un JLabel
                    // Obtener la imagen desde la base de datos (asumiendo que la columna 'imagen' es de tipo BLOB)
                    Blob blob = rs.getBlob("imagen");
                    byte[] bytes = blob.getBytes(1, (int) blob.length());
                    
                    // Convierte los bytes a una imagen
                    ImageIcon icono = new ImageIcon(bytes);
                    // Redimensiona la imagen al tamaño del JLabel
                    Image imagenRedimensionada = icono.getImage().getScaledInstance(Foto_Procedimiento.getWidth(), Foto_Procedimiento.getHeight(), Image.SCALE_SMOOTH);

                    // Crea un nueva imagen redimensionada
                    ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                    //obtener el nombreImagen
                    String nomDiagrama = rs.getString("nomImagen");
                    txt_nombreImagenDiagrama.setText(nomDiagrama);
                    // Muestra la imagen en el JLabel
                    Foto_Procedimiento.setIcon(iconoRedimensionado);
                    Foto_Procedimiento.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el diagrama con el nombre proporcionado.");
                }

                rs.close();
                psBuscar.close();
                conexion.close();

            } catch (Exception e) {
                System.out.println("Error al buscar el diagrama: " + e);
                JOptionPane.showMessageDialog(null, "Error al buscar el diagrama");
            }
        } else {
            System.out.println("No se ha seleccionado un Procedimiento");
        }
      
    }

    
    private void mostrarImagenTablaDiagrama(int idImagen) {
    try {
        Connection conexion = new Conexion().getConexion();
        String consulta = "SELECT Imagen FROM imagenprocedimiento WHERE idImagen = ?";
        PreparedStatement ps = conexion.prepareStatement(consulta);
        ps.setInt(1, idImagen);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Obtiene la imagen desde la base de datos (asumiendo que la columna 'imagen' es de tipo BLOB)
            Blob blob = rs.getBlob("imagen");
            byte[] bytes = blob.getBytes(1, (int) blob.length());

            // Convierte los bytes a una imagen
            ImageIcon icono = new ImageIcon(bytes);
            //Escala la imagen en el Jlabel
            Image imagenEscala = icono.getImage().getScaledInstance(Foto_Procedimiento.getWidth(), Foto_Procedimiento.getHeight(), Image.SCALE_SMOOTH);
            //Crea una nueva imagen ya escalada
            ImageIcon iconoEscalado = new ImageIcon(imagenEscala);
            // Muestra la imagen en el JLabel
            Foto_Procedimiento.setIcon(iconoEscalado);
            // borra su texto
            Foto_Procedimiento.setText("");
        }

        // Cierra la conexión y el conjunto de resultados
        rs.close();
        ps.close();
        conexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al mostrar la imagen: " + e.getMessage());
    }
}
    public void mostrarTablaDiagrama() {
         try {
           Connection conexion = new Conexion().getConexion();
           PreparedStatement psSU = conexion.prepareStatement("SELECT * FROM imagenprocedimiento"); // 
           ResultSet rs = psSU.executeQuery(); // Agregué esta línea para ejecutar la consulta

           DefaultTableModel modelo = new DefaultTableModel();
           modelo.addColumn("idImagen");
           modelo.addColumn("Nombre_Imagen");
           modelo.addColumn("TIPO");
           modelo.addColumn("Procedimiento");
           
            while (rs.next()) {
            // Obtén los datos de la fila actual
            int idImagen = rs.getInt("idImagen");
            String nomImagen = rs.getString("nomImagen");
            // Puedes manejar la columna de imagen de la manera que necesites
         
            // Por ejemplo, si la columna es de tipo BLOB, podrías mostrar "Imagen" o algo así
            String imagen = "Imagen"; 
            
            int IDPROCEDIMIENTO = rs.getInt("IDPROCIMIENTO");
            //Buscar el departamento que vive en la pos del combobox
            
            String nomProcediemiento = obtenerNomProcedimiento(IDPROCEDIMIENTO,conexion);
            
            // Añade una fila al modelo con los datos obtenidos
            modelo.addRow(new Object[]{idImagen, nomImagen, imagen,nomProcediemiento});
          }
            
            jTable2.setModel(modelo);
            
            
           // Cierra la conexión y el conjunto de resultados
            rs.close();
            psSU.close();
            conexion.close();
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("Error al mostrar la tabla: " + e.getMessage());
        }
    }
    
    private String obtenerNomProcedimiento(int idProcedimiento, Connection conexion) throws SQLException{
        String consulta = "SELECT NOMBREPROCEDIMIENTO FROM procedimiento WHERE IDPROCIMIENTO = ?";
         PreparedStatement ps = conexion.prepareStatement(consulta);
         ps.setInt(1, idProcedimiento);

         ResultSet rs = ps.executeQuery();

        if (rs.next()) {
        return rs.getString("nombreProcedimiento");
        }

         // Si no se encuentra el nombre del procedimiento, puedes devolver un valor predeterminado o manejarlo según tu lógica
        return "Nombre no encontrado";
    }
    
    public void GuardarDiagrama(){
        if (txt_nombreImagenDiagrama.getText().equalsIgnoreCase("")) {
            txt_nombreImagenDiagrama.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        } else {
            String nombre;
            nombre = txt_nombreImagenDiagrama.getText().trim();
            Object i = jComboBox27.getSelectedItem();
            if (i instanceof Procedimiento){
                // Convertir el elemento seleccionado a una instancia de Procedimiento
                Procedimiento procedimientoSeleccionado = (Procedimiento) i;
                // Obtener el ID del Procedimiento
                int idProcedimiento = procedimientoSeleccionado.getIdProcedimiento();
                try {
                Connection conexion = new Conexion().getConexion();
                psSU = conexion.prepareStatement("insert into imagenprocedimiento values (?,?,?,?)");
                psSU.setInt(1, 0);
                psSU.setString(2,nombre);
                psSU.setBlob(3, fiss,longitudBytess);
                psSU.setInt(4,idProcedimiento);
                
                psSU.executeUpdate();
                conexion.close();
                LimpiarImagen();
                txt_nombreImagenDiagrama.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                Foto_Procedimiento.setText("FOTO");
                
               } catch (Exception e) {
                System.out.println("Error al guardar la foto" + e);
                JOptionPane.showMessageDialog(null, "¡¡Error al guardar Foto!!");
               }
            } else {
            System.out.println("No se ha seleccionado un Procedimiento");
            }      
        }
    }
    private void cargarComboDepartamentoImagen(){
        modelo3 = new DefaultComboBoxModel();
        ArrayList<Departamento>contenido = new DatosPuestoTrabajo().getDepartamentosConProcedimientos();
        for(int i=0;i<contenido.size();i++){
            modelo3.addElement(contenido.get(i));
        }
        jComboBox26.setModel(modelo3);
        cargarComboProcedimientosImagen();
    }
    
    private void cargarComboProcedimientosImagen(){
        modelo4 = new DefaultComboBoxModel();
        Departamento dep = (Departamento)jComboBox26.getSelectedItem();
        ArrayList<Procedimiento>contenido = new DatosProcedimientos().getProcedimientosDelDepartamento(dep.getIdDepartamento());
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                modelo4.addElement(contenido.get(i));
            }
        
        }else{
            modelo4.addElement("No tiene ningun Procedimiento");
        }
        jComboBox27.setModel(modelo4);
        
    }
    private void tipoDeDatoProcedimientoImagen(){
        Object seleccionado = jComboBox27.getSelectedItem();
        if(seleccionado instanceof Procedimiento){
            existeProcedimiento = true;
        }else if(seleccionado instanceof String){
            existeProcedimiento = false;
        }else{
            System.out.println("Hay un error en el tipo de dato al seleccionar un procedimiento");
        }
        
        System.out.println(existeProcedimiento);
    }
    
    
    public void llenarComboBoxDepartamentoImagen(){
        jComboBox_Imagen.removeAllItems();
        Lista = new InformacionDepartamento().getListaDepartamentos();
        jComboBox_Imagen.addItem("Selecione un Departamento");
        for(int i=0; i<Lista.size(); i++){
            jComboBox_Imagen.addItem(Lista.get(i).toString());
        }

    } 
    private void mostrarImagenTabla(int idImagen) {
    try {
        Connection conexion = new Conexion().getConexion();
        String consulta = "SELECT imagen FROM imagen WHERE idImagen = ?";
        PreparedStatement ps = conexion.prepareStatement(consulta);
        ps.setInt(1, idImagen);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Obtiene la imagen desde la base de datos (asumiendo que la columna 'imagen' es de tipo BLOB)
            Blob blob = rs.getBlob("imagen");
            byte[] bytes = blob.getBytes(1, (int) blob.length());

            // Convierte los bytes a una imagen
            ImageIcon icono = new ImageIcon(bytes);
            //Escala la imagen en el Jlabel
            Image imagenEscala = icono.getImage().getScaledInstance(Foto.getWidth(), Foto.getHeight(), Image.SCALE_SMOOTH);
            //Crea una nueva imagen ya escalada
            ImageIcon iconoEscalado = new ImageIcon(imagenEscala);
            // Muestra la imagen en el JLabel
            Foto.setIcon(iconoEscalado);
            // borra su texto
            Foto.setText("");
        }

        // Cierra la conexión y el conjunto de resultados
        rs.close();
        ps.close();
        conexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al mostrar la imagen: " + e.getMessage());
    }
}

    private void eliminarImagen(int idImagen) {
      try {
        Connection conexion = new Conexion().getConexion();
        String consultaEliminar = "DELETE FROM imagen WHERE idImagen = ?";
        PreparedStatement psEliminar = conexion.prepareStatement(consultaEliminar);
        psEliminar.setInt(1, idImagen);

        int filasAfectadas = psEliminar.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Imagen eliminada correctamente");
        } else {
            System.out.println("No se pudo eliminar la imagen");
        }

        // Cierra el PreparedStatement y la conexión
        psEliminar.close();
        conexion.close();
      } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al eliminar la imagen: " + e.getMessage());
      }
    }
    
    private void actualizar(){
        cargarComboBoxProcedimientos();
    }
    private int buscarIDProcedimiento(String seleccion){
        int id = 0 ;
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("SELECT IDPROCIMIENTO FROM procedimiento WHERE NOMBREPROCEDIMIENTO = ?"); 
            psSU.setString(1,seleccion);
            rsSU = psSU.executeQuery();
            // Verifica si se encontró un registro
            if(rsSU.next()){ 
                id = rsSU.getInt("IDPROCIMIENTO");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
        return id ;
    }
    private void cargarComboDepartamentolistaActividades(){ 
        modelo12 = new DefaultComboBoxModel();
        ArrayList<Departamento>contenido = new DatosPuestoTrabajo().getDepartamentosConProcedimientos();
        for(int i=0;i<contenido.size();i++){
            modelo12.addElement(contenido.get(i));
        }
        jComboBox23.setModel(modelo12);
        cargarComboProcedimientoslistaActividades();
    }
    private void tipoDeDatoProcedimientolistaActividades(){
        Object seleccionado = jComboBox24.getSelectedItem();
        if(seleccionado instanceof Procedimiento){
            existelistaprocedimientos = true;
        }else if(seleccionado instanceof String){
            existelistaprocedimientos = false;
        }else{
            System.out.println("Hay un error en el tipo de dato al seleccionar un procedimiento");
        }
        
        System.out.println(existelistaprocedimientos);
    }
    private void cargarComboProcedimientoslistaActividades(){
    modelo13 = new DefaultComboBoxModel();
        Departamento dep = (Departamento)jComboBox23.getSelectedItem();
        ArrayList<Procedimiento>con = new DatosProcedimientos().getProcedimientosDelDepartamento(dep.getIdDepartamento());
        if(con.size()>0){
            for(int i=0;i<con.size();i++){
                modelo13.addElement(con.get(i));
            }
            
        }else{
            modelo13.addElement("No tiene ningun Procedimiento");
        }
        jComboBox24.setModel(modelo13);
       cargarComboInterventorlistaActividades();
    }
    private void cargarComboInterventorlistaActividades(){
    modelo14 = new DefaultComboBoxModel();
        Procedimiento proced = (Procedimiento)jComboBox24.getSelectedItem();
        ArrayList<InterventorSU> con = new DatosProcedimientos().getInterventoreslistaActividades(proced.getIdProcedimiento());
        if(con.size()>0){
            for(int i=0;i<con.size();i++){
                modelo14.addElement(con.get(i));
            }
        
        }else{
            modelo14.addElement("No tiene ningun Procedimiento");
        }
        jComboBox25.setModel(modelo14);
       
    }
    private void tipoDeDatointerventorlistaActividades(){
        Object seleccionado = jComboBox25.getSelectedItem();
        
        if(seleccionado instanceof InterventorSU){
            existeinterventor = true;
        }else if(seleccionado instanceof String){
            existeinterventor = false;
        }else{
            System.out.println("Hay un error en el tipo de dato al seleccionar un interventor");
        }
        
        System.out.println(existeinterventor);
    }
    private void rotarDatosDeLaListaActividades() {
    if (listaActividades != null && !listaActividades.isEmpty()) {
       
        indiceActividades = (indiceActividades + 1) % listaActividades.size();
        mostrarDatosDeActividadActual();
    } else {
        System.out.println("No hay actividades que mostrar");
    }
    }
    private void cargarDatosIniciales() {
    Procedimiento procedimiento = (Procedimiento)jComboBox24.getSelectedItem();
    listaActividades = new DatosProcedimientos().obtenerDatosDeLaListaDeActividades(procedimiento.getIdProcedimiento());
    mostrarDatosDeActividadActual();
    }    
    private void mostrarDatosDeActividadActual() {
    if (listaActividades != null && !listaActividades.isEmpty()) {
        DatosInterventor datosInterventor = new DatosInterventor();

        
        indiceActividades = (indiceActividades + listaActividades.size()) % listaActividades.size();

        ListaDeActividades actividadActual = listaActividades.get(indiceActividades);
        int idInterventor = actividadActual.getIdInterventor();
        String nombreInterventor = datosInterventor.obtenerNombredeInterventor(idInterventor);

        jComboBox25.setSelectedItem(new InterventorSU(actividadActual.getIdInterventor(), 0, nombreInterventor));
        jTextField30.setText(actividadActual.getDescripcionDeActividad());
        jTextField31.setText(String.valueOf(actividadActual.getOrdenLista()));
        jTextField32.setText(String.valueOf(actividadActual.getIdLista()));
    } else {
        
        System.out.println("No hay actividades que mostrar");
    }
    }
    
    private void tipoDeDatoProcedimiento2(){
        Object seleccionado = jComboBox21.getSelectedItem();
        if(seleccionado instanceof Procedimiento){
            existeProcedimientoP = true;
        }else if(seleccionado instanceof String){
            existeProcedimientoP = false;
        }else{
            System.out.println("Hay un error en el tipo de dato al seleccionar un procedimiento");
        }
        
        System.out.println(existeProcedimientoP);
    }
    private void cargarComboProcedimientos2(){
        modeloProcedimiento2 = new DefaultComboBoxModel();
        Departamento dep = (Departamento)jComboBox21.getSelectedItem();
        ArrayList<Procedimiento>contenido = new DatosProcedimientos().getProcedimientosDelDepartamento(dep.getIdDepartamento());
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                modeloProcedimiento2.addElement(contenido.get(i));
            }
        
        }else{
            modeloProcedimiento2.addElement("No tiene ningun Procedimiento");
        }
        jComboBox22.setModel(modeloProcedimiento2);
        cargarAreaTextoProcedimiento();
        cargarAreaTextoObjetivo();
        jTextArea11.setCaretPosition(0);
        jTextArea12.setCaretPosition(0);
               
       
    }
    private void cargarAreaTextoProcedimiento(){
        try{
            Procedimiento p = (Procedimiento)jComboBox22.getSelectedItem();
            jTextArea11.setText(p.getNombreProcedimiento());
        }catch(Exception ex){
            System.err.println("No hay procedimientos:" + ex);
            jLabel54.setText("*No existen procedimientos");
            jTextArea11.setText("");
            jTextArea11.setEnabled(false);
            jButton83.setEnabled(false);
            jButton84.setEnabled(false);
        }
    }
    private void cargarAreaTextoObjetivo()
    {
     try{
            Procedimiento p = (Procedimiento)jComboBox22.getSelectedItem();
            int idProcedimiento = p.getIdProcedimiento();
            Connection conexion = new Conexion().getConexion();
            psSU = conexion.prepareStatement("select * from procedimiento p, departamento d \n" +
              "where   d.IDDEPARTAMENTO = p.IDDEPARTAMENTO \n" +
                "AND IDPROCIMIENTO ="+idProcedimiento);
            rsSU = psSU.executeQuery();
            if(rsSU.next()){
            jTextArea12.setText(rsSU.getString("OBJETIVOPROCEDIMIENTO"));
            }
            conexion.close();
        }catch(Exception ex){
            System.err.println("No hay procedimientos:" + ex);
            jLabel54.setText("*No existen procedimientos");
            jTextArea11.setText("");
            jTextArea11.setEnabled(false);
            jButton83.setEnabled(false);
            jButton84.setEnabled(false);
        }
    
    }
    private void actualizarProcedimiento(){
     Procedimiento p = (Procedimiento)jComboBox22.getSelectedItem();
            int idProcedimiento = p.getIdProcedimiento();
      if(!jTextArea11.getText().equals("")){      
       try{
            
            Connection conexion = new Conexion().getConexion();
            psSU = conexion.prepareStatement("update procedimiento set NOMBREPROCEDIMIENTO =? "  +
              " where IDPROCIMIENTO = "+idProcedimiento);
            psSU.setString(1,jTextArea11.getText()) ;
            int res = psSU.executeUpdate();
            if(res>0){   
             
            JOptionPane.showMessageDialog(null, "procedimiento actualizado");    
            }
            conexion.close();
        }catch(Exception ex){
         System.err.print("error "+ex);
        }
      }else{
       JOptionPane.showMessageDialog(null,"Error campo vacio");
      }
    }
    private void eliminarProcedimiento(){
            Procedimiento p = (Procedimiento)jComboBox22.getSelectedItem();
            int idProcedimiento = p.getIdProcedimiento();
       try{
            
            Connection conexion = new Conexion().getConexion();
            psSU = conexion.prepareStatement("delete from procedimiento " +
              "where IDPROCIMIENTO = "+idProcedimiento);
            int res = psSU.executeUpdate();
            if(res>0){
             jTextArea11.setText("");   
             jTextArea12.setText("");
             cargarComboDepartamentoPocedimiento();
            JOptionPane.showMessageDialog(null, "procedimiento eliminado");    
            }
            conexion.close();
        }catch(Exception ex){
         System.err.print("error "+ex);
        }  
    
    }
   private void actulizarObjetivo(){
   Procedimiento p = (Procedimiento)jComboBox22.getSelectedItem();
           int idProcedimiento = p.getIdProcedimiento();
       if(!jTextArea12.getText().equals("")){      
       try{
            
            Connection conexion = new Conexion().getConexion();
            psSU = conexion.prepareStatement("update procedimiento set OBJETIVOPROCEDIMIENTO =? "  +
              " where IDPROCIMIENTO = "+idProcedimiento);
            psSU.setString(1,jTextArea12.getText()) ;
            int res = psSU.executeUpdate();
            if(res>0){   
             
            JOptionPane.showMessageDialog(null, "objetivo actualizado");    
            }
            conexion.close();
        }catch(Exception ex){
         System.err.print("error "+ex);
        } 
       }else{
        JOptionPane.showMessageDialog(null,"Error campo vacio");
       } 
   
   }
    private void eliminarObjetivo(){
    Procedimiento p = (Procedimiento)jComboBox22.getSelectedItem();
            int idProcedimiento = p.getIdProcedimiento();
       try{
            
            Connection conexion = new Conexion().getConexion();
            psSU = conexion.prepareStatement("update procedimiento set OBJETIVOPROCEDIMIENTO =? "  +
              " where IDPROCIMIENTO = "+idProcedimiento);
            psSU.setString(1,"") ;
            int res = psSU.executeUpdate();
            if(res>0){   
             jTextArea12.setText("");
             
            JOptionPane.showMessageDialog(null, "objetivo eliminado");    
            }
            conexion.close();
        }catch(Exception ex){
         System.err.print("error "+ex);
        } 
    }
    private void cargarComboDepartamentoInter(){ //Para cargar los comboBox
        modeloProcedimiento = new DefaultComboBoxModel();
        ArrayList<Departamento>contenido = new DatosPuestoTrabajo().getDepartamentosConProcedimientos();
        for(int i=0;i<contenido.size();i++){
            modeloProcedimiento.addElement(contenido.get(i));
        }
        jComboBox19.setModel(modeloProcedimiento);
        cargarComboProcedimientosInter();
    }
    private void tipoDeDatoProcedimientoInter(){
         Object seleccionado = jComboBox20.getSelectedItem();
        if(seleccionado instanceof Procedimiento){
            existeProcedimientoP = true;
        }else if(seleccionado instanceof String){
            existeProcedimientoP = false;
        }else{
            System.out.println("Hay un error en el tipo de dato al seleccionar un procedimiento");
        }
        
        System.out.println(existeProcedimientoP);
    }
    private void cargarComboProcedimientosInter(){
    modeloProcedimiento2 = new DefaultComboBoxModel();
        Departamento dep = (Departamento)jComboBox19.getSelectedItem();
        ArrayList<Procedimiento>contenido = new DatosProcedimientos().getProcedimientosDelDepartamento(dep.getIdDepartamento());
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                modeloProcedimiento2.addElement(contenido.get(i));
            }
        
        }else{
            modeloProcedimiento2.addElement("No tiene ningun Procedimiento");
        }
        jComboBox20.setModel(modeloProcedimiento2);
    }
    private void cargarInterventores(){
        interventores = new ArrayList<>();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select IDINTERVENTOR, NOMBREINTERVENTOR from interventores where idprocimiento = ?");
            psSU.setInt(1, idProcedimientoInter);
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                InterventorSU interventor = new InterventorSU();
                interventor.setIdInterventor(rsSU.getInt("IDINTERVENTOR"));
                interventor.setNombreInterventor(rsSU.getString("NOMBREINTERVENTOR"));
                interventores.add(interventor);
            }
            conexion.close();
            if(interventores.isEmpty()){
                jTextField29.setText("No existe interventores");
                jButton88.setVisible(false);
                jButton87.setVisible(false);
                jButton89.setVisible(false);
                jButton90.setVisible(false);
            }else{
                jButton88.setVisible(true);
                jButton87.setVisible(true);
                jButton89.setVisible(true);
                jButton90.setVisible(true);
                indiceGlobal=0;
                jTextField29.setText(interventores.get(indiceGlobal).getNombreInterventor());
            }
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    private void mostrarSiguienteDatoCargosOficialesDesempenado(){
          ArrayList<String> resultados=new ArrayList<>();
          ArrayList<Integer> idsAD=new ArrayList<>();
          Integer ci = Integer.parseInt(jTextField6.getText());
          int claveFuncionario = buscarIDFuncionario(ci);
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select * \n" +
"FROM funcionario f, curriculum c, cargosoficialesdesempenados a \n" +
"where f.IDFUNCIONARIO= c.IDFUNCIONARIO and c.IDCURRICULUM= a.IDCURRICULUM\n" +
" and f.IDFUNCIONARIO=" + claveFuncionario); 
            
            
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                String  datosEstudiosAcademicos=rsSU.getString("DATOSDESEMPENADO");
                resultados.add(datosEstudiosAcademicos);
                idsAD.add(rsSU.getInt("IDCARGODESEMPENADO"));
            }
            if(indiceActual< resultados.size()){
                String resultado=resultados.get(indiceActual);
                idCargosDesempeñados = idsAD.get(indiceActual);
                jTextArea7.setText(resultado);
                indiceActual++;
            }else{
                if(indiceActual>=resultados.size()){
                    indiceActual=0;
                }
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    private void mostrarSiguienteDatoActividadDocente(){
          ArrayList<String> resultados=new ArrayList<>();
          ArrayList<Integer> idsAD=new ArrayList<>();
          Integer ci = Integer.parseInt(jTextField6.getText());
          int claveFuncionario = buscarIDFuncionario(ci);
          
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select * " +
    "FROM funcionario f, curriculum c,   actividaddocente a " +
    "where f.IDFUNCIONARIO = c.IDFUNCIONARIO " +" and c.IDCURRICULUM = a.IDCURRICULUM " +
    " and f.IDFUNCIONARIO="+claveFuncionario);
            
            
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                String  datosEstudiosAcademicos=rsSU.getString("ACTIVIDADDOCENTE");
                resultados.add(datosEstudiosAcademicos);
                 idsAD.add(rsSU.getInt("IDACTIVIDADDOCENTE"));
                
            }
            if(indiceActual< resultados.size()){
                String resultado=resultados.get(indiceActual);
                idActividadDocente = idsAD.get(indiceActual);
                jTextArea6.setText(resultado);
                System.out.println(idActividadDocente);
                indiceActual++;
            }else{
                if(indiceActual>=resultados.size()){
                    indiceActual=0;
                }
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    private void mostrarSiguienteDatoEstudiosAcademicos(){
          ArrayList<String> resultados=new ArrayList<>();
          ArrayList<Integer> idsAD=new ArrayList<>();
          Integer ci = Integer.parseInt(jTextField6.getText());
          int claveFuncionario = buscarIDFuncionario(ci);
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select * \n" +
"FROM funcionario f, curriculum c, estudioacademico a \n" +
"where f.IDFUNCIONARIO= c.IDFUNCIONARIO and c.IDCURRICULUM= a.IDCURRICULUM\n" +
" and f.IDFUNCIONARIO=" +claveFuncionario); 
            
            
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                String  datosEstudiosAcademicos=rsSU.getString("DATOSESTUDIOACADEMICO");
                resultados.add(datosEstudiosAcademicos);
                idsAD.add(rsSU.getInt("IDESTUDIOACADEMICO"));
            }
            if(indiceActual< resultados.size()){
                String resultado=resultados.get(indiceActual);
                jTextArea9.setText(resultado);
                idEstudiosAcademicos = idsAD.get(indiceActual);
                indiceActual++;
            }else{
                if(indiceActual>=resultados.size()){
                    indiceActual=0;
                }
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    private void mostraractividadProfesional(){
         ArrayList<String> resultados=new ArrayList<>();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("SELECT ap.DATOSACTIVIDADPROFESIONAL\n" +
"FROM funcionario f\n" +
"LEFT JOIN curriculum c ON f.IDFUNCIONARIO = c.IDFUNCIONARIO\n" +
"LEFT JOIN actividadprofesional ap ON c.IDCURRICULUM = ap.IDCURRICULUM\n" +
"WHERE f.CI =  ? "); 
            
            psSU.setString(1,jTextField14.getText());
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                String  datosEstudiosAcademicos=rsSU.getString("ap.DATOSACTIVIDADPROFESIONAL");
                resultados.add(datosEstudiosAcademicos);
            }
            if(!resultados.isEmpty()){
                String primerresultado=resultados.get(0);
                jTextArea8.setText(primerresultado);
                
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    private void mostrarActividadDocente(){
       ArrayList<String> resultados=new ArrayList<>();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("SELECT a.ACTIVIDADDOCENTE\n" +
"FROM funcionario f \n" +
"LEFT JOIN curriculum c ON f.IDFUNCIONARIO = c.IDFUNCIONARIO\n" +
"LEFT JOIN actividaddocente a ON c.IDCURRICULUM = a.IDCURRICULUM\n" +
"WHERE f.CI =  ? "); 
            
            psSU.setString(1,jTextField14.getText());
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                String  datosEstudiosAcademicos=rsSU.getString("a.ACTIVIDADDOCENTE");
                resultados.add(datosEstudiosAcademicos);
            }
            if(indiceActual< resultados.size()){
                String resultado=resultados.get(indiceActual);
                jTextArea6.setText(resultado);
                indiceActual++;
            }else{
                if(indiceActual>=resultados.size()){
                    indiceActual=0;
                }
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
     private void mostrarEstudiosAcademios(){
         ArrayList<String> resultados=new ArrayList<>();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("SELECT e.DATOSESTUDIOACADEMICO\n" +
"FROM funcionario f\n" +
"LEFT JOIN curriculum c ON f.IDFUNCIONARIO = c.IDFUNCIONARIO\n" +
"LEFT JOIN estudioacademico e ON c.IDCURRICULUM = e.IDCURRICULUM\n" +
"WHERE f.CI = ? "); 
            
            psSU.setString(1,jTextField14.getText());
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                String  datosEstudiosAcademicos=rsSU.getString("e.DATOSESTUDIOACADEMICO");
                resultados.add(datosEstudiosAcademicos);
            }
            if(!resultados.isEmpty()){
                String primerresultado=resultados.get(0);
                jTextArea9.setText(primerresultado);
                
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    
    private void mostrarcargosDesempenado(){
       ArrayList<String> resultados=new ArrayList<>();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("SELECT cd.DATOSDESEMPENADO\n" +
"FROM funcionario f\n" +
"LEFT JOIN curriculum c ON f.IDFUNCIONARIO = c.IDFUNCIONARIO\n" +
"LEFT JOIN cargosoficialesdesempenados cd ON c.IDCURRICULUM = cd.IDCURRICULUM\n" +
"WHERE f.CI = ? "); 
            
            psSU.setString(1,jTextField14.getText());
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                String  datosEstudiosAcademicos=rsSU.getString("cd.DATOSDESEMPENADO");
                resultados.add(datosEstudiosAcademicos);
            }
            if(!resultados.isEmpty()){
                String primerresultado=resultados.get(0);
                jTextArea7.setText(primerresultado);
                
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    
    private void mostrarExperienciaDP(){
         listaExp = new ArrayList<>() ;
         try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select ex.CODEXPERIENCIA ,ex.DESCRIPCIONEXPERIENCIA from experiencia ex , descripcionpuesto dp , puestotrabajo pt where pt.IDPUESTO = dp.IDPUESTO and dp.IDDESCRIPCIONPUESTO=ex.IDDESCRIPCIONPUESTO and pt.IDPUESTO=?"); 
            
            psSU.setInt(1,jComboBox7.getSelectedIndex());
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                //jTextArea1.setText(rsSU.getString("ex.DESCRIPCIONEXPERIENCIA"));
                Experiencia ex = new Experiencia();
                ex.setCodExperiencia(rsSU.getInt("ex.CODEXPERIENCIA"));
                ex.setDescripcionExperiencia(rsSU.getString("descripcionExperiencia"));
                listaExp.add(ex);   
            }
            jTextArea10.setText(listaExp.get(0).getdescripcionExperiencia());
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    private void mostrarEsfuerzoDP(){
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select esf.IDESFUERZO ,esf.DESCRIPCIONDELESFUERZO from esfuerzo esf , descripcionpuesto dp , puestotrabajo pt\n" +
"where pt.IDPUESTO = dp.IDPUESTO and   dp.IDDESCRIPCIONPUESTO=esf.IDDESCRIPCIONPUESTO and pt.IDPUESTO=? "); 
            
            psSU.setInt(1,jComboBox7.getSelectedIndex());
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                jTextArea5.setText(rsSU.getString("esf.DESCRIPCIONDELESFUERZO"));
                idEsfuerzo = rsSU.getInt("esf.IDESFUERZO");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
   }
    private void mostrarAptitudesDP(){
       try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select a.IDAPTITUD, a.NOMBREAAPTITUD from aptitudes a , descripcionpuesto dp , puestotrabajo pt\n" +
            "where pt.IDPUESTO = dp.IDPUESTO and   dp.IDDESCRIPCIONPUESTO=a.IDDESCRIPCIONPUESTO and pt.IDPUESTO=? "); 
            
            psSU.setInt(1,jComboBox7.getSelectedIndex());
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                jTextArea4.setText(rsSU.getString("a.NOMBREAAPTITUD"));
                  idAptitud = rsSU.getInt("a.IDAPTITUD");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
   }
    private void mostrarEscolaridadDP(){
        
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select esc.IDESCOLARIDAD ,esc.DATOESCOLARIDAD from escolaridad esc , descripcionpuesto dp , puestotrabajo pt\n" +
           "where pt.IDPUESTO = dp.IDPUESTO and   dp.IDDESCRIPCIONPUESTO=esc.IDDESCRIPCIONPUESTO and pt.IDPUESTO=? "); 
            
            psSU.setInt(1,jComboBox7.getSelectedIndex());
            
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                jTextArea3.setText(rsSU.getString("esc.DATOESCOLARIDAD"));
                idEscolaridad = rsSU.getInt("esc.IDESCOLARIDAD");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    private void mostrarHabilidadDestrezaDP(){
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select hd.IDHABILIDADDESTREZA ,hd.DATOHABILIDADDESTREZA from habilidaddestreza hd , descripcionpuesto dp , puestotrabajo pt\n" +
"where pt.IDPUESTO = dp.IDPUESTO and   dp.IDDESCRIPCIONPUESTO=hd.IDDESCRIPCIONPUESTO and pt.IDPUESTO=? "); 
            
            psSU.setInt(1,jComboBox7.getSelectedIndex());
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                jTextArea2.setText(rsSU.getString("hd.DATOHABILIDADDESTREZA"));
                idHabilidadDestreza = rsSU.getInt("hd.IDHABILIDADDESTREZA");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
    /**
    * Fin de codigo erick 
    */
    private void mostraridCurriculum(){
    Integer ci = Integer.parseInt(jTextField6.getText());
        int claveFuncionario = buscarIDFuncionario(ci);
        
      try{
      Connection conexion = new Conexion().getConexion();    
      psSU = conexion.prepareStatement("select * " +
    "FROM funcionario f, curriculum c,   actividadprofesional a " +
    "where f.IDFUNCIONARIO = c.IDFUNCIONARIO " +
    " and f.IDFUNCIONARIO="+claveFuncionario);
      rsSU = psSU.executeQuery();
      if(rsSU.next()){
      idCurriculum = rsSU.getInt("IDCURRICULUM");
      }
      
      
      }catch(Exception e){
      
      } 
    }
    private void mostrarActividadProfesional(String c){
    Integer ci = Integer.parseInt(jTextField6.getText());
        int claveFuncionario = buscarIDFuncionario(ci);
        
      try{
      Connection conexion = new Conexion().getConexion();    
      psSU = conexion.prepareStatement("select * " +
    "FROM funcionario f, curriculum c,   actividadprofesional a " +
    "where f.IDFUNCIONARIO = c.IDFUNCIONARIO and c.IDCURRICULUM= a.IDCURRICULUM " +
    " and f.IDFUNCIONARIO="+claveFuncionario);
      rsSU = psSU.executeQuery();
      if(rsSU.next()){
      jTextArea8.setText(""+rsSU.getString("DATOSACTIVIDADPROFESIONAL"));
      idCurriculum = rsSU.getInt("IDCURRICULUM");
      idActividadPofesional = rsSU.getInt("IDACTIVIDADPROFESIONAL");
      }
      
      
      }catch(Exception e){
      
      } 
    }
//
  private void mostrarCargosOficialesDesempeñados(String c){
    Integer ci = Integer.parseInt(jTextField6.getText());
        int claveFuncionario = buscarIDFuncionario(ci);
        
      try{
      Connection conexion = new Conexion().getConexion();    
      psSU = conexion.prepareStatement("select * " +
"FROM funcionario f, curriculum c,   cargosoficialesdesempenados a " +
"where f.IDFUNCIONARIO = c.IDFUNCIONARIO and c.IDCURRICULUM= a.IDCURRICULUM " +
" and f.IDFUNCIONARIO="+claveFuncionario);
      rsSU = psSU.executeQuery();
      if(rsSU.next()){
      jTextArea7.setText(""+rsSU.getString("DATOSDESEMPENADO"));
      idCargosDesempeñados = rsSU.getInt("IDCARGODESEMPENADO");
      }
      
      
      }catch(Exception e){
      
      } 
    }
//
 private void mostrarEstudiosAcademicos(String c){
     Integer ci = Integer.parseInt(jTextField6.getText());
        int claveFuncionario = buscarIDFuncionario(ci);
        
      try{
      Connection conexion = new Conexion().getConexion();    
      psSU = conexion.prepareStatement("select * " +
"FROM funcionario f, curriculum c,   estudioacademico a " +
"where f.IDFUNCIONARIO = c.IDFUNCIONARIO and c.IDCURRICULUM= a.IDCURRICULUM " +
" and f.IDFUNCIONARIO="+claveFuncionario);
      rsSU = psSU.executeQuery();
      if(rsSU.next()){
      jTextArea9.setText(""+rsSU.getString("DATOSESTUDIOACADEMICO"));
      idEstudiosAcademicos = rsSU.getInt("IDESTUDIOACADEMICO");
      }
      
      
      }catch(Exception e){
      
      } 
    }
//
 private void mostrarDatosActividadDocente(String c){
      Integer ci = Integer.parseInt(jTextField6.getText());
        int claveFuncionario = buscarIDFuncionario(ci);
        
      try{
      Connection conexion = new Conexion().getConexion();    
      psSU = conexion.prepareStatement("select * " +
      "FROM funcionario f, curriculum c, actividaddocente a " +
      "where f.IDFUNCIONARIO= c.IDFUNCIONARIO and c.IDCURRICULUM= a.IDCURRICULUM " +
      " and f.IDFUNCIONARIO="+claveFuncionario);
      rsSU = psSU.executeQuery();
      if(rsSU.next()){
      jTextArea6.setText(""+rsSU.getString("ACTIVIDADDOCENTE"));
      idActividadDocente = rsSU.getInt("IDACTIVIDADDOCENTE");
      }
      
      
      }catch(Exception e){
      
      }  
    
    }
//
 private int buscarIDFuncionario(int ci){
    int res = 0;    
    try{
    Connection conexion = new Conexion().getConexion();    
      psSU = conexion.prepareStatement("select IDFUNCIONARIO FROM funcionario " +
      "where funcionario.CI ="+ci);
      rsSU = psSU.executeQuery();
      if(rsSU.next()){
      res = rsSU.getInt("IDFUNCIONARIO");
      }
    }catch(Exception e){
    
    } 
    
    return res;
    }
    
    private void llenarBuscarPT(){   //implementar
        modelo3 = new DefaultComboBoxModel();
        ArrayList<PuestoTrabajo>contenido = new DatosPuestoTrabajo().getAllPuestosTrabajo();
        for(int i=0;i<contenido.size();i++){
            modelo3.addElement(contenido.get(i));
        }
        jComboBox9.setModel(modelo3);
    }
    
    public boolean camposLlenos(){
        boolean res = false;
        if(!jTextField8.getText().equals("")&&(funcionGeneral.size()>0)&&(funcionesEspesificas.size()>0)){
            jLabel17.setText("");
            res = true;
        }else{
            jLabel17.setText("*error algunos campos siguen vacios F.G o F.E o nombre del puesto");   
        }
        return res;
    }
    
    private void LimpiadorDespuesDeAñadirPT(){
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jComboBox2.setSelectedIndex(0);
    }
    
    
    private void cargarComboBoxDepartamentos(){
        modelo = new DefaultComboBoxModel();
        ArrayList<Departamento>contenido = new DatosPuestoTrabajo().getDepartamentos();
        for(int i=0;i<contenido.size();i++){
            modelo.addElement(contenido.get(i));
        }
        jComboBox2.setModel(modelo);
        
        jComboBox8.setModel(modelo);//para actualizar implementar solo esta linea
        
    }
    
    private void cargarComboBoxPuestoTrabajo(int id){
        modelo2 = new DefaultComboBoxModel();  // linea 2806 de codigo
        ArrayList<PuestoTrabajo>contenido = new DatosPuestoTrabajo(id).getPuestosTrabajo();
        if(contenido.size()>0){
           for(int i=0;i<contenido.size();i++){
               modelo2.addElement(contenido.get(i));
           }
        }else{
           modelo2.addElement("No existen puestos en el departamento");
        }
        jComboBox3.setModel(modelo2);
        
        jComboBox10.setModel(modelo2);//para actualizar actualizar solo esta linea
    
    }
    // FIN CODIGO DAVID....
    
    
    
    /**
     * @Erick 
     */
    private void insertarExperiencia(int pk){
        try{
        Connection conexion = new Conexion().getConexion();
        psSU = conexion.prepareStatement("insert into Experiencia (descripcionExperiencia,IdDescripcionPuesto) values(?,?)");
        psSU.setString(1,jTextArea10.getText());
        psSU.setInt(2, pk);
        psSU.executeUpdate();
            psSU.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
    }
    private void insertarEscolaridad(int pk){
        try{
          Connection conexion = new Conexion().getConexion();
        psSU= conexion.prepareStatement("insert into escolaridad (IdDescripcionPuesto,datoescolaridad) values(?,?)");
        psSU.setString(2,jTextArea3.getText());
        psSU.setInt(1, pk);
        psSU.executeUpdate();
            psSU.close();
        }catch(Exception ex){
          System.err.println("Error:" + ex);
        }
    }
    private void insertarAptitudes(int pk){
        try{
        Connection conexion = new Conexion().getConexion();
        psSU = conexion.prepareStatement("insert into aptitudes(IdDescripcionPuesto,NOMBREAAPTITUD) values(?,?)");
        psSU.setInt(1, pk);
        psSU.setString(2, jTextArea4.getText());
        psSU.executeUpdate();
        psSU.close();
        }catch(Exception ex){
            System.err.print("Eroor:"+ex);
        }
    }
    private void insertarEsfuerzo(int pk){
        try{
        Connection conexion = new Conexion().getConexion();
        psSU = conexion.prepareStatement("insert into esfuerzo(IdDescripcionPuesto,TipoDeEsfuerzo,DESCRIPCIONDELESFUERZO) values(?,?,?)");
        psSU.setInt(1, pk);
        psSU.setString(2,(String) jComboBox6.getSelectedItem());
        psSU.setString(3, jTextArea5.getText());
        psSU.executeUpdate();
        psSU.close();
        }catch(Exception ex){
            System.err.print("Eroor:"+ex);
        }     
    }
    
    /**
     * ----
     * @Juan 
     */
    private void insertarHabilidadDestreza(int pk){
        
        try{
          Connection conexion = new Conexion().getConexion();
        psSU= conexion.prepareStatement("insert into HabilidadDestreza (DatoHabilidadDestreza,IdDescripcionPuesto) values(?,?)");
        psSU.setString(1,jTextArea2.getText());
        psSU.setInt(2, pk);
        psSU.executeUpdate();
            psSU.close();
        }catch(Exception ex){
          System.err.println("Error:" + ex);
        }
    }
    
    
     private void cargarComboDepartamentoPocedimiento(){
        modeloProcedimiento = new DefaultComboBoxModel();
        ArrayList<Departamento>contenido = new DatosPuestoTrabajo().getDepartamentosConProcedimientos();
        for(int i=0;i<contenido.size();i++){
            modeloProcedimiento.addElement(contenido.get(i));
        }
        jComboBox16.setModel(modeloProcedimiento);
        jComboBox21.setModel(modeloProcedimiento);
        cargarComboProcedimientos();
        cargarComboProcedimientos2();
    }
    
    private void cargarComboProcedimientos(){
        modeloProcedimiento2 = new DefaultComboBoxModel();
        Departamento dep = (Departamento)jComboBox16.getSelectedItem();
        ArrayList<Procedimiento>contenido = new DatosProcedimientos().getProcedimientosDelDepartamento(dep.getIdDepartamento());
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                modeloProcedimiento2.addElement(contenido.get(i));
            }
        
        }else{
            modeloProcedimiento2.addElement("No tiene ningun Procedimiento");
        }
        jComboBox17.setModel(modeloProcedimiento2);
        cargarPoliticasOperacion();
    }
    
    private void tipoDeDatoProcedimiento(){
        Object seleccionado = jComboBox17.getSelectedItem();
        if(seleccionado instanceof Procedimiento){
            existeProcedimientoP = true;
        }else if(seleccionado instanceof String){
            existeProcedimientoP = false;
        }else{
            System.out.println("Hay un error en el tipo de dato al seleccionar un procedimiento");
        }
        
        System.out.println(existeProcedimientoP);
    }
    private void cargarPoliticasOperacion(){
        jLabel54.setText("");
        modeloPoliticasOperacion = new DefaultComboBoxModel();
        Procedimiento procedimiento = (Procedimiento)jComboBox17.getSelectedItem();
        ArrayList<OperationPolicy>contenido = new DatosProcedimientos().objetosPoliticasDeOperacion(procedimiento.getIdProcedimiento());
        for(int i=0;i<contenido.size();i++){
            modeloPoliticasOperacion.addElement(contenido.get(i));
        }
        jComboBox18.setModel(modeloPoliticasOperacion);
        jTextArea1.setEnabled(true);
        jButton80.setEnabled(true);
        jButton79.setEnabled(true);
        cargarAreaTextoPoliticaOperacion();
     
    }
    private void cargarAreaTextoPoliticaOperacion(){
        try{
            OperationPolicy politicaOperacion = (OperationPolicy)jComboBox18.getSelectedItem();
            jTextArea1.setText(politicaOperacion.getDescripcion());
        }catch(Exception ex){
            System.err.println("No hay politicas de operacion:" + ex);
            jLabel54.setText("*No existen politicas de operacion");
            jTextArea1.setText("");
            jTextArea1.setEnabled(false);
            jButton80.setEnabled(false);
            jButton79.setEnabled(false);
        }
    }
    private void actualizarPoliticaOperacion(){
        OperationPolicy politicaOperacion = (OperationPolicy)jComboBox18.getSelectedItem();
        int posicionActual = jComboBox18.getSelectedIndex();
        if(!jTextArea1.getText().equals("")){
            if(new DatosProcedimientos().actualizarPoliticasDeOperacion(jTextArea1.getText(),politicaOperacion.getIdPoliticaOpracion())){
                JOptionPane.showMessageDialog(null,"Politica de Operacion \n Actualizada con exito");
                cargarPoliticasOperacion();
                jComboBox18.setSelectedIndex(posicionActual);
                cargarAreaTextoPoliticaOperacion();
            }else{
                JOptionPane.showMessageDialog(null,"Error al actualizar \n Politica de Operacion");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Error campo vacio");
        }
        
    }
    private void eliminarPoliticaDeOperacion(){
        OperationPolicy politicaOperacion = (OperationPolicy)jComboBox18.getSelectedItem();
        if(new DatosProcedimientos().eliminarPoliticaOperacion(politicaOperacion.getIdPoliticaOpracion())){
            JOptionPane.showMessageDialog(null,"Eliminado con exito");
                cargarPoliticasOperacion();   
        }else{
            JOptionPane.showMessageDialog(null,"Error al eliminar");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaSu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar_Diagrama;
    private javax.swing.JButton Buscar_Imagen;
    private javax.swing.JButton Eliminar_Diagrama;
    private javax.swing.JLabel FondoAgregarPT;
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel Foto_Procedimiento;
    private javax.swing.JButton Guardar_Imagen;
    private javax.swing.JLabel ImagenFondo;
    private javax.swing.JButton Mod_Diagrama;
    private javax.swing.JButton Tabla_procedimiento;
    private javax.swing.JButton btnAnt;
    private javax.swing.JButton btnBuscarN;
    private javax.swing.JButton btnCerrarSesionSU;
    private javax.swing.JButton btnSig;
    private javax.swing.JTextField cajaIDPuesto;
    private javax.swing.JLabel fondoActualizarPT;
    private javax.swing.JButton guardar_Diagrama;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton100;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton35treintaYcinco;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton36treintaYseis;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton500;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton83;
    private javax.swing.JButton jButton84;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton88;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton90;
    private javax.swing.JButton jButton91;
    private javax.swing.JButton jButton92;
    private javax.swing.JButton jButton93;
    private javax.swing.JButton jButton94;
    private javax.swing.JButton jButton95;
    private javax.swing.JButton jButton96;
    private javax.swing.JButton jButton97;
    private javax.swing.JButton jButton98;
    private javax.swing.JButton jButton99;
    private javax.swing.JButton jButton_eliminarImagen;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox11once;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox19;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox20;
    private javax.swing.JComboBox<String> jComboBox21;
    private javax.swing.JComboBox<String> jComboBox22;
    private javax.swing.JComboBox<String> jComboBox23;
    private javax.swing.JComboBox<String> jComboBox24;
    private javax.swing.JComboBox<String> jComboBox25;
    private javax.swing.JComboBox<String> jComboBox26;
    private javax.swing.JComboBox<String> jComboBox27;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JComboBox<String> jComboBox_Imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel34treintaYcuatro;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel35treintaYcinco;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField500;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField txt_nombreImagen;
    private javax.swing.JTextField txt_nombreImagenDiagrama;
    // End of variables declaration//GEN-END:variables
}
