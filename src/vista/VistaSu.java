/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import modelo.*;

/**
 *C
 * Se realizo cambios
 */
public class VistaSu extends javax.swing.JFrame {

    /**
     * Creates new form VistaSu
     */
    private DefaultComboBoxModel modelo;
    private DefaultComboBoxModel modelo2;
    private DefaultComboBoxModel modelo3;
    private DefaultComboBoxModel modelo4;
    private DefaultComboBoxModel modelo5;
    private ArrayList<String>funcionGeneral = new ArrayList<String>();
    private ArrayList<String>funcionesEspesificas = new ArrayList<String>();
    // NO BORRAR ESTAS LISTAS SON IMPORTANTES
    private ArrayList<Experiencia> listaExp;
    int indiceExp = 0;
    public int idPuesto =-1; //Variable exclusiva para la insercion en otra tabla creada por erick
    public int idDescripcionPuesto=0;
    
    int idCurriculum;
    int idActividadDocente;
    int idActividadPofesional;
    int idCargosDesempeñados;
    int idEstudiosAcademicos;
    
    int idEscolaridad ;
    int idAptitud;
    int idEsfuerzo;
    int codExperiencia; 
     int codExperiencia1;
    int idHabilidadDestreza;
    int indiceActual=0;
    
    PreparedStatement psSU, psAux ; 
    ResultSet rsSU, rsAux ;
    //Conexion prueba;
    ArrayList<Puesto>lista;
    ArrayList<DepartamentoRecursivo>Lista;
    Conexion prueba;
    public VistaSu() {
        initComponents();
        jTextField5.setVisible(false);
        jButton3.setVisible(false);
        funcionalidadesInvisibles();
        this.setLocationRelativeTo(null);
        llenarComboBoxPuestosDisponibles();
        llenarComboBoxPuestos();
        
        llenarComboBoxDepartamento();
        llenarComboBoxBusquedaDepartamento();
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
    public void verificarRegistro(){
        
    }
    public void funcionalidadesInvisibles(){
        jTextField7.setVisible(false);
        cajaIDPuesto.setVisible(false);
        cajaNombrePuesto.setVisible(false);
        jTextField12.setVisible(false);
        btnSiguienteBuscar.setVisible(false);
       btnContinuarBuscar.setVisible(false);
        jButton3.setContentAreaFilled(false); // Desactiva el relleno del botón
        jButton3.setBorderPainted(false); // Desactiva el borde del botón
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setBorderPainted(false);
        
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
        jButton58 = new javax.swing.JButton();
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
        cajaNombrePuesto = new javax.swing.JTextField();
        cajaIDPuesto = new javax.swing.JTextField();
        btnSiguienteBuscar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
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
        jLabel40 = new javax.swing.JLabel();
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
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
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
        btnContinuarBuscar = new javax.swing.JButton();
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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargos.png"))); // NOI18N
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

        jButton58.setText("jButton58");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton58)
                .addContainerGap())
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
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton58)
                .addGap(13, 13, 13))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, 430));

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
        jPanel4.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 170, -1));

        jButton35.setText("Siguiente");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 80, 30));

        btnCerrarSesionSU.setBackground(new java.awt.Color(255, 204, 0));
        btnCerrarSesionSU.setText("Cerrar Sesion");
        btnCerrarSesionSU.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCerrarSesionSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionSUActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesionSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 120, -1));
        jPanel4.add(cajaNombrePuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 190, -1));
        jPanel4.add(cajaIDPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 80, -1));

        btnSiguienteBuscar.setText("Siguiente");
        btnSiguienteBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btnSiguienteBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, -1));

        jTabbedPane1.addTab("tab1", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
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

        btnAnt.setText("Guardar");
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel8)
                                .addGap(48, 48, 48))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10))))
                                        .addGap(44, 44, 44))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(btnSig, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(22, 22, 22)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnBuscarN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(362, 362, 362))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(218, 218, 218)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jButton26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSig, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(27, 27, 27)
                                        .addComponent(jButton44))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(26, 26, 26)
                                        .addComponent(jButton45))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton37)
                                .addGap(54, 54, 54)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton38)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarN, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        jTabbedPane1.addTab("tab3", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
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
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 170, -1));

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

        jButton13.setText("REGISTRAR");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 140, 40));

        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 420, 20));

        jButton22.setText("ACTUALIZAR DATOS");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 170, 40));

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
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
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton54)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jButton53))))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(jLabel30)
                    .addComponent(jLabel32))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        jTabbedPane1.addTab("tab5", jPanel8);

        jPanel9.setBackground(new java.awt.Color(0, 204, 153));
        jPanel9.setForeground(new java.awt.Color(0, 153, 102));
        jPanel9.setLayout(null);

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nombre de Departamento");
        jPanel9.add(jLabel18);
        jLabel18.setBounds(350, 270, 145, 27);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Departamento Superior");
        jPanel9.add(jLabel19);
        jLabel19.setBounds(370, 320, 135, 16);

        jButton15.setText("Buscar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton15);
        jButton15.setBounds(370, 180, 100, 30);

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
        jTextField11.setBounds(490, 270, 320, 30);

        jPanel9.add(jComboBox4);
        jComboBox4.setBounds(470, 180, 340, 30);

        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox5);
        jComboBox5.setBounds(490, 310, 320, 30);

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
        jLabel39.setBounds(0, 80, 470, 350);
        jPanel9.add(jLabel40);
        jLabel40.setBounds(10, 0, 820, 260);

        jTabbedPane1.addTab("tab6", jPanel9);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setText("Nombre del puesto:");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, -1));
        jPanel10.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 280, -1));

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

        jLabel25.setText("Seleccione nuevo departamento");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jLabel26.setText("Seleccione nuevo puesto superior");
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 160, -1));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel10.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 280, -1));

        jButton21.setText("Actualizar Nombre");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 140, -1));
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
        jPanel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 680, 10));

        jButton25.setText("Regresar Atras");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, -1, -1));

        jLabel34treintaYcuatro.setText("Funcion general:");
        jPanel10.add(jLabel34treintaYcuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel35treintaYcinco.setText("Funcion especifica:");
        jPanel10.add(jLabel35treintaYcinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, -1));
        jPanel10.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 520, -1));
        jPanel10.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 520, -1));

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox12ActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 550, -1));

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
        jPanel10.add(jTextField500, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 490, 30));

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

        jButton52.setText("Eliminar F.E");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 100, 30));

        jTabbedPane1.addTab("tab7", jPanel10);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab8", jPanel11);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab10", jPanel13);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

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

        btnContinuarBuscar.setText("Continuar (user existente)");
        btnContinuarBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarBuscarActionPerformed(evt);
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnContinuarBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(4, 4, 4)
                .addComponent(btnContinuarBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab9", jPanel12);

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
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
           try{
           Connection  conexion = new Conexion().getConexion();
           psSU = conexion.prepareStatement("delete from funcionario where IDFUNCIONARIO=?");
           psSU.setString(1,jTextField7.getText());
           int res = psSU.executeUpdate();
           if(res>0){
           JOptionPane.showMessageDialog(null, "registro eliminado");
           limpiar();
           }else{
           JOptionPane.showMessageDialog(null, "error al eliminar al registro");
           limpiar();
           }
           conexion.close();    
           }catch(Exception ex){
           System.err.println("Error, "+ex);
           }
        
    }//GEN-LAST:event_jButton4ActionPerformed
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String nombreF = "";
        String ci = "" ; 
        try {
             Connection conexion = new Conexion().getConexion();
             psSU = conexion.prepareStatement("insert into funcionario (nombreFuncionario,IDPUESTO,CI,telefono,fechaNacimiento)values(?,?,?,?,?)");
             psSU.setString(1,jTextField2.getText());
             psSU.setInt(2,jComboBox1.getSelectedIndex());
             psSU.setString(3, jTextField6.getText());
             psSU.setString(4,jTextField4.getText());
             psSU.setDate(5,Date.valueOf(jTextField3.getText()));
             int resultado = psSU.executeUpdate();
            psAux = conexion.prepareStatement("SELECT MAX(IDFUNCIONARIO) FROM FUNCIONARIO");
            rsAux = psAux.executeQuery();
            int idFuncionario = 0; 
            if (rsAux.next()) {
                idFuncionario = rsAux.getInt(1); // Obtener el valor de la columna 1 (la única columna en este caso)
           
            }
            conexion.close();
            nombreF = jTextField2.getText();
            ci = jTextField6.getText();
             crearCuenta(idFuncionario,nombreF,ci);
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
        // TODO add your handling code here:
        try {
             Connection conexion = new Conexion().getConexion();
             
             psSU = conexion.prepareStatement("update funcionario set nombreFuncionario=?,idPuesto=?,telefono=?,fechaNacimiento=? where IDFUNCIONARIO=?");
             psSU.setString(1,jTextField2.getText());
             psSU.setInt(2,jComboBox1.getSelectedIndex());
             psSU.setString(3,jTextField4.getText());
             psSU.setDate(4,Date.valueOf(jTextField3.getText()));
             psSU.setInt(5,Integer.parseInt(jTextField5.getText()));

            int resultado = psSU.executeUpdate();
            if(resultado > 0 ){
                JOptionPane.showMessageDialog(null,"Modificación realizada");
            }else{
                JOptionPane.showMessageDialog(null,"Error en la modificación");
            }
            conexion.close();
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            //Estos botones son para el caso en que encontrar
            jButton3.setEnabled(false);
            jButton35.setVisible(false);
            btnContinuarBuscar.setVisible(true);
            jButton35.setVisible(false);
            cajaNombrePuesto.setVisible(true);
            btnSiguienteBuscar.setVisible(true);
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select IDFUNCIONARIO,PT.IDPUESTO,ci,nombreFuncionario,telefono,fechaNacimiento,NOMBREPUESTO from funcionario f, puestoTrabajo pt where f.idpuesto = pt.idpuesto AND CI = ?"); 
            psSU.setString(1,jTextField1.getText());
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                jTextField2.setText(rsSU.getString("nombreFuncionario"));
                jTextField4.setText(rsSU.getString("telefono"));
                jTextField6.setText(rsSU.getString("ci"));
                jTextField3.setText(String.valueOf(rsSU.getDate("fechaNacimiento")));
                //jComboBox1
                //jComboBox1.setSelectedIndex(rsSU.getInt("idPuesto"));
                jTextField7.setText(rsSU.getString("IDFUNCIONARIO"));
                llenarComboBoxPuestosDisponibles(rsSU.getInt("IDPUESTO"),rsSU.getString("NOMBREPUESTO"));

                //cajaIDPuesto.setText(rsSU.getString("IDPUESTO"));
                //jComboBox1.setVisible(true);
                //obtenerNombreDelPuesto();
                //obtenerDescripcionPuesto();
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    private void obtenerNombreDelPuesto(){
         try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("select NOMBREPUESTO from PuestoTrabajo where idPuesto = ?"); 
            psSU.setString(1,cajaIDPuesto.getText());
            rsSU = psSU.executeQuery(); 
            if(rsSU.next()){
                cajaNombrePuesto.setText(rsSU.getString("NOMBREPUESTO"));
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");                
            }
            conexion.close();
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
    }
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
            
            dpt.insertarPuesto(jTextField8.getText(),idPuestoSuperior,dep.getIdDepartamento());
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
         jButton15.setEnabled(true);
    try{
        Connection conexion = new Conexion().getConexion();
        psSU = (PreparedStatement) conexion.prepareStatement("select * from departamento where NOMBREDEPARTAMENTO = ? "); 
        
        String departamentoSeleccionado = (String) jComboBox4.getSelectedItem();
        if(departamentoSeleccionado != null){
            psSU.setString(1, departamentoSeleccionado);
            rsSU = psSU.executeQuery(); 
            
            if(rsSU.next()){
                jTextField11.setText(rsSU.getString("NOMBREDEPARTAMENTO"));
                jComboBox5.setSelectedIndex(rsSU.getInt("DEP_IDDEPARTAMENTO"));
                jTextField12.setText(rsSU.getString("IDDEPARTAMENTO"));
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
        if(jTextField11.getText().isEmpty() || jComboBox5.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"campo vacio");
        }else{
        try {
             Connection conexion = new Conexion().getConexion();
             psSU = conexion.prepareStatement("insert into departamento (DEP_IDDEPARTAMENTO,NOMBREDEPARTAMENTO)values(?,?)");
             psSU.setString(2,jTextField11.getText());
             psSU.setInt(1,jComboBox5.getSelectedIndex());
             
             
            int resultado = psSU.executeUpdate();
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
        String departamento = (String) jComboBox5.getSelectedItem();
        if(departamento == "Selecione un departamento"){
            JOptionPane.showMessageDialog(null,"Seleccione un departamento valido");

        }
        //jTabbedPane1.setSelectedIndex(4);
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        limpiarDepartamento();
    }//GEN-LAST:event_jButton19ActionPerformed

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
             Connection conexion = new Conexion().getConexion();
             
             psSU = conexion.prepareStatement("update departamento set NOMBREDEPARTAMENTO=?,DEP_IDDEPARTAMENTO=? where IDDEPARTAMENTO=?");
             psSU.setString(1,jTextField11.getText());
             psSU.setInt(2,jComboBox5.getSelectedIndex());
             psSU.setString(3,jTextField12.getText());
             

            int resultado = psSU.executeUpdate();
            if(resultado > 0 ){
                JOptionPane.showMessageDialog(null,"Modificación realizada");
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
    Connection conexion = new Conexion().getConexion();
    PreparedStatement ps = conexion.prepareStatement("SELECT NOMBREDEPARTAMENTO FROM departamento");
    ResultSet rs = ps.executeQuery();

    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    while (rs.next()) {
        model.addElement(rs.getString("NOMBREDEPARTAMENTO"));
    }
    llenarComboBoxDepartamento();
    llenarComboBoxBusquedaDepartamento();
    //limpiarDepartamento();
    JOptionPane.showMessageDialog(null, "Base de datos actualizada", "Actualizacion", JOptionPane.INFORMATION_MESSAGE);
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
         if(jTextField2.getText().isEmpty() || jTextField6.getText().isEmpty() || jTextField4.getText().isEmpty() || jTextField3.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Por favor Registre todos los datos", "ERROR",JOptionPane.INFORMATION_MESSAGE );
        }else{
            int respuesta=JOptionPane.showOptionDialog(this, "Si esta seguro que su informacion es correcta haz click en Guardar Datos de lo contrario haz click en Cancelar", "Confirma tu Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Guardar Datos","Cancelar"}, "Guardar Datos");
            if (respuesta == JOptionPane.YES_OPTION) {
                new Funcionario().insercionFuncionario(jTextField2.getText(),idPuesto,jTextField6.getText(),jTextField4.getText(),Date.valueOf(jTextField3.getText()));
                DescripcionPuesto inserciones = new DescripcionPuesto();
                inserciones.insertarDescripcionPuesto(idPuesto);
                idDescripcionPuesto = inserciones.getIdDescripcionPuesto();
                JOptionPane.showMessageDialog(null,"Se registro correctamente","Registro",JOptionPane.INFORMATION_MESSAGE );
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
       psSU = conexion.prepareStatement("delete from actividaddocente where IDACTIVIDADDOCENTE="+idActividadDocente);
       
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
                jTabbedPane1.setSelectedIndex(0);
                //jComboBox1.removeAllItems();
                llenarComboBoxPuestosDisponibles();
            }
        }
    }//GEN-LAST:event_jButton48ActionPerformed
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
    private void btnContinuarBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarBuscarActionPerformed
        jTabbedPane1.setSelectedIndex(4);
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
    }//GEN-LAST:event_btnContinuarBuscarActionPerformed

    private void btnSiguienteBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteBuscarActionPerformed
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_btnSiguienteBuscarActionPerformed

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
        //boton siuiente
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
            if(indiceActual< resultados.size()){
                String resultado=resultados.get(indiceActual);
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
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);

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
        }catch(Exception ex ){
            System.err.println("ERROR, "+ex);
        }
        mostrarExperienciaDP();
    }//GEN-LAST:event_btnAntActionPerformed
    private void mostrarSiguienteDatoCargosOficialesDesempenado(){
          ArrayList<String> resultados=new ArrayList<>();
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("SELECT cd.DATOSDESEMPENADO\n" +
"FROM funcionario f\n" +
"LEFT JOIN curriculum c ON f.IDFUNCIONARIO = c.IDFUNCIONARIO\n" +
"LEFT JOIN cargosoficialesdesempenados cd ON c.IDCURRICULUM = cd.IDCURRICULUM\n" +
"WHERE f.CI =? "); 
            
            psSU.setString(1,jTextField14.getText());
            rsSU = psSU.executeQuery(); 
            while(rsSU.next()){
                String  datosEstudiosAcademicos=rsSU.getString("cd.DATOSDESEMPENADO");
                resultados.add(datosEstudiosAcademicos);
            }
            if(indiceActual< resultados.size()){
                String resultado=resultados.get(indiceActual);
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
        try{
            Connection conexion = new Conexion().getConexion();
            psSU = (PreparedStatement) conexion.prepareStatement("SELECT a.ACTIVIDADDOCENTE\n" +
"FROM funcionario f \n" +
"LEFT JOIN curriculum c ON f.IDFUNCIONARIO = c.IDFUNCIONARIO\n" +
"LEFT JOIN actividaddocente a ON c.IDCURRICULUM = a.IDCURRICULUM\n" +
"WHERE f.CI =? "); 
            
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
    private void mostrarSiguienteDatoEstudiosAcademicos(){
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
            if(indiceActual< resultados.size()){
                String resultado=resultados.get(indiceActual);
                jTextArea9.setText(resultado);
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
    
    public void limpiarDepartamento(){
        jTextField11.setText(null);
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jTextField9.setText(null);
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
        
        jComboBox8.setModel(modelo); //para actualizar implementar solo esta linea
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
    private javax.swing.JLabel ImagenFondo;
    private javax.swing.JButton btnAnt;
    private javax.swing.JButton btnBuscarN;
    private javax.swing.JButton btnCerrarSesionSU;
    private javax.swing.JButton btnContinuarBuscar;
    private javax.swing.JButton btnSig;
    private javax.swing.JButton btnSiguienteBuscar;
    private javax.swing.JTextField cajaIDPuesto;
    private javax.swing.JTextField cajaNombrePuesto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
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
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox11once;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea10;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField500;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
