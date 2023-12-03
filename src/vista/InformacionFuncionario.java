/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import manualProcedimiento.DatosProcedimientos;
import manualProcedimiento.Procedimiento;
import modelo.Conexion;
import modelo.DatosPuestoTrabajo;
import modelo.Departamento;
import modelo.Esfuerzo;
import modelo.Funcionario;
import modelo.Subordinados;

/**
 *
 * @author DavidH
 */
public class InformacionFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form InformacionFuncionario
     */
    private int ejeX,ejeY;
    private String usuario;
    private String contraseña;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<Departamento>deps;
    private ArrayList<String>puestos;
    private DefaultComboBoxModel modelo;
    private DefaultComboBoxModel modelo2;
    private BufferedImage imagenDepartamento;
    private boolean existeProcedimiento = false;
    private int n = 1;
    private int idDepartamento;
    private String nombreDep;
    private int idProcedimiento;
    public InformacionFuncionario(String usuario,String contraseña) {
        setUndecorated(true);
        this.usuario = usuario;
        this.contraseña = contraseña;
        initComponents();
        setLocationRelativeTo(null);
        cargarDatos();
        activarFondoDeEtiquetas();
        desaparecerBotonesDePaneles();
        cargarComboDepartamento();
        tipoDeDatoProcedimiento();
        visibilidadProcedimientos();
        obtenerIDdepartamentoDelFuncionario();
        funcionalidadesInvisibles();
        FEyFGsubordinados();
    }
    
    
    private void FEyFGsubordinados(){
        ArrayList<Subordinados>contenido = new Funcionario(usuario,contraseña).getNombreEidSubordinados();
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea6.append("\n");
                jTextArea6.append("Nombre del puesto.-" + contenido.get(i).getNombrePuesto() + "\n");
                FuncionGeneralSubordinados(contenido.get(i).getIdPuesto());
                FuncionEspecificasSubordinados(contenido.get(i).getIdPuesto());
            }
        }else{
            jTextArea6.append(" - NO TIENE SUBORDINADOS");
        }
        jTextArea6.moveCaretPosition(0);
    }
    private void FuncionGeneralSubordinados(int id){
        ArrayList<String>contenido = new Funcionario().FuncionGeneralSubordinados(id);
        jTextArea6.append("FUNCION GENERAL\n");
        jTextArea6.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea6.append(" - " + contenido.get(i) + "\n");
            }
        }else{
            jTextArea6.append(" - " + "Ninguno!\n");
        }
    }
    
    private void FuncionEspecificasSubordinados(int id){
        ArrayList<String>contenido = new Funcionario().FuncionesEspecificasSubordinados(id);
        jTextArea6.append("\n FUNCIONES ESPECIFICAS\n");
        jTextArea6.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea6.append(" - " + contenido.get(i) + "\n");
            }
        }else{
            jTextArea6.append(" - " + "Ninguno!\n");
        }
    }
    
    
    
    
    
    
    
    
    private void obtenerIDdepartamentoDelFuncionario(){
        //ID departamento
        idDepartamento = new Funcionario(usuario,contraseña).getIdDepartamentoDelFuncionario();
    }
    private void visibilidadProcedimientos(){
        if(esJefe() == 0){
            jLabel33.setVisible(false);
        }else{
            jLabel33.setVisible(true);
            jLabel33.setText("Procedimiento");
        }
    }
    private void funcionalidadesInvisibles(){
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
    }
    private void cargarComboDepartamento(){
        modelo = new DefaultComboBoxModel();
        ArrayList<Departamento>contenido = new DatosPuestoTrabajo().getDepartamentosConProcedimientos();
        for(int i=0;i<contenido.size();i++){
            modelo.addElement(contenido.get(i));
        }
        jComboBox2.setModel(modelo);
        cargarComboProcedimientos();
    }
    private void cargarComboProcedimientos(){
        modelo2 = new DefaultComboBoxModel();
        Departamento dep = (Departamento)jComboBox2.getSelectedItem();
        ArrayList<Procedimiento>contenido = new DatosProcedimientos().getProcedimientosDelDepartamento(dep.getIdDepartamento());
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                modelo2.addElement(contenido.get(i));
            }
        
        }else{
            modelo2.addElement("No tiene ningun Procedimiento");
        }
        jComboBox3.setModel(modelo2);
    }
    private void tipoDeDatoProcedimiento(){
        Object seleccionado = jComboBox3.getSelectedItem();
        if(seleccionado instanceof Procedimiento){
            existeProcedimiento = true;
        }else if(seleccionado instanceof String){
            existeProcedimiento = false;
        }else{
            System.out.println("Hay un error en el tipo de dato al seleccionar un procedimiento");
        }
        
        System.out.println(existeProcedimiento);
    }
    
    private void cargarDatos(){
        jLabel4.setText(new Funcionario(usuario, contraseña).getNombre());
        jLabel6.setText(new Funcionario(usuario, contraseña).getCargoOficial());
        jLabel20.setText(new Funcionario(usuario,contraseña).getTelefonoOficial());
        jLabel21.setText(new Funcionario(usuario,contraseña).getFechaDeNacimiento());
        jLabel23.setText(new Funcionario(usuario, contraseña).getJefeInmediato());
        cargarPersonal(new Funcionario(usuario, contraseña).getPersonalBajoSuMando());
        jLabel27.setText(new Funcionario(usuario, contraseña).getDepatamento());
        jLabel29.setText(new Funcionario(usuario, contraseña).getDepartamentoSuperior());
        
        cargarCurriculum();
        cargarFunciones();
        cargarRequisitos();
    }
    
    private void activarFondoDeEtiquetas(){
        jLabel7.setOpaque(true);
        jLabel8.setOpaque(true);
        jLabel15.setOpaque(true);
        jLabel16.setOpaque(true);
        jLabel17.setOpaque(true);
        jLabel13.setOpaque(true);
        Buscar_Organigrama.setOpaque(true);
        jLabel33.setOpaque(true);
    }
    public int esJefe(){
        int estado=0;
        try{
        Connection conexion = new Conexion().getConexion();
        ps = conexion.prepareStatement("select tipoEmp from cuenta as c, funcionario f, puestotrabajo pt where c.idfuncionario = f.idfuncionario and f.idpuesto = pt.idpuesto and c.usuario = ? and c.contrasena = ? ");
        ps.setString(1, usuario);
        ps.setString(2, contraseña);
        rs = ps.executeQuery();
        if(rs.next()){
           estado = rs.getInt("tipoEmp");
        }
        ps.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return estado;
    }
    private void cargarPersonal(ArrayList<String>personal){
        jTextArea1.setEditable(false);
        if(personal.size() > 0){
            for(int i=0;i<personal.size();i++){
                jTextArea1.append((i+1) + ".-" + personal.get(i) + "\n");
            }
        }else{
            jTextArea1.append("Ninguno!\n");
        }
    }
    
    private void cargarCurriculum(){
        jTextArea2.setEditable(false);
        estudiosAcademicos();
        cargosOficialesDesempeñados();
        actividadesDocentes();
        actividadesProfesionales();
        jTextArea2.moveCaretPosition(0); // hace que la barra de desplazamiento inicie desde el inicio del texto
    }
    
    private void cargarRequisitos(){
        jTextArea5.setEditable(false);
        escolaridad();
        experiencia();
        habilidad();
        aptitudes();
        esfuerzo();
        jTextArea5.moveCaretPosition(0); // hace que la barra de desplazamiento inicie desde el inicio del texto
    }
    
    
    
    private void estudiosAcademicos(){
        ArrayList<String>contenido = new Funcionario(usuario,contraseña).getEstudiosAcademicos();
        jTextArea2.append("ESTUDIOS ACADEMICOS\n");
        jTextArea2.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea2.append(" - " + contenido.get(i) + "\n");
            }
        }else{
            jTextArea2.append(" - " + "Ninguno!\n");
        }
        jTextArea2.append("\n");
    }
    
    private void cargosOficialesDesempeñados(){
        ArrayList<String>contenido = new Funcionario(usuario,contraseña).getCargosOficialesDesempeñados();
        jTextArea2.append("CARGOS OFICIALES DESEMPEÑADOS\n");
        jTextArea2.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea2.append(" - " + contenido.get(i) + "\n");
            }
        }else{
            jTextArea2.append(" - " + "Ninguno!\n");
        }
        jTextArea2.append("\n");
    }
    
    private void actividadesDocentes(){
        ArrayList<String>contenido = new Funcionario(usuario,contraseña).getActividadesDocentes();
        jTextArea2.append("ACTIVIDADES ACADEMICAS\n");
        jTextArea2.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea2.append(" - " + contenido.get(i) + "\n");
            }
        }else{
            jTextArea2.append(" - " + "Ninguno!\n");
        }
        jTextArea2.append("\n");
    }
    
    private void actividadesProfesionales(){
        ArrayList<String>contenido = new Funcionario(usuario,contraseña).getActividadesProfesionales();
        jTextArea2.append("ACTIVIDADES PROFESIONALES\n");
        jTextArea2.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea2.append(" - " + contenido.get(i) + "\n");
            }
        }else{
            jTextArea2.append(" - " + "Ninguno!\n");
        }
    }
    
    private void cargarFunciones(){
        jTextArea3.setEditable(false);
        FuncionGeneral();
        FuncionEspecificas();
        jTextArea3.moveCaretPosition(0); // hace que la barra de desplazamiento inicie desde el inicio del texto
    }
    private void FuncionGeneral(){
        ArrayList<String>contenido = new Funcionario(usuario,contraseña).getFuncionGeneralBD();
        jTextArea3.append("FUNCION GENERAL\n");
        jTextArea3.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea3.append(" - " + contenido.get(i) + "\n");
            }
        }else{
            jTextArea3.append(" - " + "Ninguno!\n");
        }
    }
    
    private void FuncionEspecificas(){
        ArrayList<String>contenido = new Funcionario(usuario,contraseña).getFuncionesEspecificasBD();
        jTextArea3.append("\n FUNCIONES ESPECIFICAS\n");
        jTextArea3.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea3.append(" - " + contenido.get(i) + "\n");
            }
        }else{
            jTextArea3.append(" - " + "Ninguno!\n");
        }
    }
    
    
    private void escolaridad(){
        ArrayList<String>contenido = new Funcionario(usuario, contraseña).getEscolaridad();
        jTextArea5.append("ESCOLARIDAD\n");
        jTextArea5.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea5.append(" - " + contenido.get(i)+"\n");             
            }      
        }else{
            jTextArea5.append("Ninguno!\n");
        
        }
        jTextArea5.append("\n");
    
    }
    
    private void experiencia(){
        ArrayList<String>contenido = new Funcionario(usuario, contraseña).getExperiencia();
        jTextArea5.append("EXPERIENCIA\n");
        jTextArea5.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea5.append(" - " + contenido.get(i)+"\n");             
            }      
        }else{
            jTextArea5.append("Ninguno!\n");
        
        }
        jTextArea5.append("\n");
    
    }
    
    private void habilidad(){
        ArrayList<String>contenido = new Funcionario(usuario, contraseña).getHabilidades();
        jTextArea5.append("HABILIDADES Y DESTREZAS\n");
        jTextArea5.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea5.append(" - " + contenido.get(i)+"\n");             
            }      
        }else{
            jTextArea5.append("Ninguno!\n");
        
        }
        jTextArea5.append("\n");
    
    }
    private void aptitudes(){
        ArrayList<String>contenido = new Funcionario(usuario, contraseña).getAptitudes();
        jTextArea5.append("APTITUDES\n");
        jTextArea5.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea5.append(" - " + contenido.get(i)+"\n");             
            }      
        }else{
            jTextArea5.append("Ninguno!\n");
        
        }
        jTextArea5.append("\n");
    
    }
    
    private void esfuerzo(){
        ArrayList<Esfuerzo>contenido = new Funcionario(usuario, contraseña).getEsfuerzo();
        jTextArea5.append("ESFUERZO\n");
        jTextArea5.append("\n");
        if(contenido.size()>0){
            for(int i=0;i<contenido.size();i++){
                jTextArea5.append(" - " + contenido.get(i).getTipoEsfuerzo()+": "+ contenido.get(i).getDescripcionEsfuerzo()+"\n");             
            }      
        }else{
            jTextArea5.append("Ninguno!\n");
        }
    
    }
    
    
    
    
    private void desaparecerBotonesDePaneles(){
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

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        Buscar_Organigrama = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        Ver_Diagrama = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        Foto_Procedimiento = new javax.swing.JLabel();
        txt_nombreImagenDiagrama = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        Foto = new javax.swing.JLabel();
        txt_nombreImagen = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(102, 0, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cerrar Sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 110, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cinta de colores RGB 800x40.jpg"))); // NOI18N
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 800, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 40, -1, 40));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel7MouseDragged(evt);
            }
        });
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel7MousePressed(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CUENTA USUARIO");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 250, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nivel.png"))); // NOI18N
        jLabel13.setText("NIVELES");
        jLabel13.setToolTipText("");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 170, 40));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_jefePNG30X30.png"))); // NOI18N
        jLabel7.setText("FUNCIONARIO");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 170, 40));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_subordinadosPNG30X19.png"))); // NOI18N
        jLabel8.setText("SUBORDINADOS");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 170, 40));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_curriculumPNG30X30.png"))); // NOI18N
        jLabel15.setText("CURRICULUM");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 170, 40));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Diseño sin título.png"))); // NOI18N
        jLabel16.setText("FUNCIONES");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 170, 40));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/requisitosssPNG30x41.png"))); // NOI18N
        jLabel17.setText("REQUISITOS");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 170, 40));

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon-procedimeintos (1).png"))); // NOI18N
        jLabel33.setText("PROCEDIMIENTOS");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel33MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel33MouseExited(evt);
            }
        });
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 170, 40));

        Buscar_Organigrama.setBackground(new java.awt.Color(0, 0, 0));
        Buscar_Organigrama.setForeground(new java.awt.Color(255, 255, 255));
        Buscar_Organigrama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Buscar_Organigrama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Organigrama.png"))); // NOI18N
        Buscar_Organigrama.setText("ORGANIGRAMA");
        Buscar_Organigrama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Buscar_OrganigramaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Buscar_OrganigramaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Buscar_OrganigramaMouseExited(evt);
            }
        });
        jPanel2.add(Buscar_Organigrama, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 170, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 450));

        jTabbedPane1.setEnabled(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 220, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel5.setText("Cargo oficial:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 90, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 300, 20));

        jLabel18.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 102, 255));
        jLabel18.setText("DATOS Y DESCRIPCION DEL PUESTO");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 310, 10));

        jLabel10.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel10.setText("Telefono:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 20));

        jLabel19.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel19.setText("Fecha de nacimiento:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 20));

        jLabel20.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 220, 20));

        jLabel21.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 170, 20));

        jLabel22.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel22.setText("Jefe inmediato:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, 20));

        jLabel23.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 320, 20));

        jLabel26.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel26.setText("Pertenece al depatamento:");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 180, 20));

        jLabel27.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 270, 20));

        jLabel28.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel28.setText("Departamento superior:");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 20));

        jLabel29.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 290, 20));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_jefePNG180x180.png"))); // NOI18N
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 180, 180));

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 102, 255));
        jLabel24.setText("PERSONAL BAJO SU MANDO");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 51, 255));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 240, 10));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 310, 300));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_subordinadosPNG260x166.png"))); // NOI18N
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 260, 166));

        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setText("*Acceder a funciones generales y especificas");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 260, -1));

        jButton4.setText("Acceder");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 102, 255));
        jLabel31.setText("CURRICULUM DEL FUNCIONARIO");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 51, 255));
        jPanel5.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 280, 10));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 630, 300));

        jTabbedPane1.addTab("tab3", jPanel5);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 102, 255));
        jLabel11.setText("FUNCIONES GENERALES Y ESPECIFICAS");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 490, -1));

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setName(""); // NOI18N
        jScrollPane3.setViewportView(jTextArea3);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 630, 310));

        jSeparator4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel8.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 370, 10));

        jTabbedPane1.addTab("tab4", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 102, 255));
        jLabel12.setText("REQUISITOS DEL PUESTO DE TRABAJO");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 20));

        jSeparator5.setBackground(new java.awt.Color(0, 51, 255));
        jPanel9.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 330, 10));

        jScrollPane5.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);

        jPanel9.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 630, 310));

        jTabbedPane1.addTab("tab5", jPanel9);

        jLabel14.setText("Niveles de la Empresa");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        jComboBox1.setToolTipText("");
        jComboBox1.setName(""); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jLabel32.setText("Nivel");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174)
                                .addComponent(jLabel14))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 282, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab6", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER PROCEDIMIENTO.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 255));
        jLabel35.setText("Procedimientos y funciones");

        Ver_Diagrama.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Ver_Diagrama.setText("Ver Diagrama");
        Ver_Diagrama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ver_DiagramaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(Ver_Diagrama, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(161, 161, 161))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel35)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel35)
                .addGap(27, 27, 27)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ver_Diagrama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab7", jPanel11);

        Foto_Procedimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Foto_Procedimiento.setText("DIAGRAMA");
        Foto_Procedimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Foto_Procedimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Foto_ProcedimientoMouseClicked(evt);
            }
        });

        jLabel36.setText("Nombre Diagrama:");

        jButton3.setText("ATRAS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Foto_Procedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombreImagenDiagrama, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreImagenDiagrama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Foto_Procedimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(61, 61, 61))))
        );

        jTabbedPane1.addTab("tab8", jPanel12);

        Foto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Foto.setText("ORGANIGRAMA");
        Foto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FotoMouseClicked(evt);
            }
        });

        jLabel38.setText("Nombre Organigrama:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombreImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(1, 1, 1)
                .addComponent(Foto, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab9", jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 255));
        jLabel37.setText("ACCESO A DATOS DE SUBORDINADOS POR NIVEL");
        jPanel14.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 350, 30));

        jSeparator6.setBackground(new java.awt.Color(51, 51, 255));
        jPanel14.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 370, 10));

        jTextArea6.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jTextArea6.setRows(5);
        jScrollPane6.setViewportView(jTextArea6);

        jPanel14.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 610, 260));

        jButton5.setText("Regresar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, -1));

        jTabbedPane1.addTab("tab10", jPanel14);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 630, 370));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 450));

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

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel8.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        ejeX = evt.getX();
        ejeY = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - ejeX,y - ejeY);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        jLabel15.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        jLabel15.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        jLabel16.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        jLabel16.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jLabel13.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        jLabel13.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLabel13MouseExited
    
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        
       if(n==1){ cargarNiveles();
        int nivel = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        jTextArea4.setText("Departamentos del nivel: " +nivel +" \n");
        listaDepartamentosNivel();
        llenarDepartamentos();
        jTextArea4.append("\npuestos del nivel: " +nivel +"\n");
       llenadoListaPuesto();
        llenarPuestos();
        jTextArea4.setEditable(false);
        jComboBox1.removeItem("1");
        n++;
       }
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jLabel13MouseClicked
    private void cargarNiveles(){
      try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select distinct nivel from departamento");
            rs = ps.executeQuery();
            while(rs.next()){
                jComboBox1.addItem(rs.getString("nivel"));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
    
    }
    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(6);
        
        
    }//GEN-LAST:event_jLabel33MouseClicked

    private void Ver_DiagramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ver_DiagramaActionPerformed
        txt_nombreImagenDiagrama.setEditable(false);
        BuscarDiagrama();
    }//GEN-LAST:event_Ver_DiagramaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(existeProcedimiento){
            abrirProcedimientos();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        cargarComboProcedimientos();
        tipoDeDatoProcedimiento();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jTextArea4.setText("");
        int nivel = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        jTextArea4.setText("Departamentos del nivel: " +nivel +" \n");
        listaDepartamentosNivel();
        llenarDepartamentos();
        jTextArea4.append("\npuestos del nivel: " +nivel +"\n");
        llenadoListaPuesto();
        llenarPuestos();
        jTextArea4.setEditable(false);

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txt_nombreImagenDiagrama.setText("");
        Foto_Procedimiento.setText("Diagrama");
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Buscar_OrganigramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buscar_OrganigramaMouseClicked
        // TODO add your handling code here:
        txt_nombreImagen.setEditable(false);
        BuscarImagen(idDepartamento);
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_Buscar_OrganigramaMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Buscar_OrganigramaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buscar_OrganigramaMouseEntered
        Buscar_Organigrama.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_Buscar_OrganigramaMouseEntered

    private void Buscar_OrganigramaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buscar_OrganigramaMouseExited
        Buscar_Organigrama.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_Buscar_OrganigramaMouseExited

    private void jLabel33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseEntered
        jLabel33.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_jLabel33MouseEntered

    private void jLabel33MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseExited
        jLabel33.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLabel33MouseExited

    private void FotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FotoMouseClicked
       
       // Obtiene la imagen actual del JLabel
       ImageIcon icono = (ImageIcon) Foto.getIcon();
       Image img = icono.getImage();

       // Llama al método para mostrar la ventana ampliada
       mostrarVentanaAmpliada(icono);
    }//GEN-LAST:event_FotoMouseClicked

    private void Foto_ProcedimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Foto_ProcedimientoMouseClicked
        // Obtiene la imagen actual del JLabel
        ImageIcon icono = (ImageIcon) Foto_Procedimiento.getIcon();
        Image img = icono.getImage();

        // Llama al método para mostrar la ventana ampliada
        mostrarVentanaAmpliada(icono);
    }//GEN-LAST:event_Foto_ProcedimientoMouseClicked
    
    private void mostrarVentanaAmpliada(ImageIcon imagenIcono) {
        // Crea una nueva ventana (JFrame) para mostrar la imagen ampliada
        JFrame ventanaAmpliada = new JFrame("Imagen Ampliada");
        ventanaAmpliada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Escala la imagen al tamaño deseado con mejor calidad
        int nuevoAncho = 500; 
        int nuevoAlto = 700; 

        Image imagenOriginal = imagenIcono.getImage();
        BufferedImage imagenEscalada = escalarImagen(imagenOriginal, nuevoAncho, nuevoAlto);

        // Crea un nuevo ImageIcon con la imagen escalada
        ImageIcon imagenNueva = new ImageIcon(imagenEscalada);

        // Crea un JLabel con la nueva imagen
        JLabel fotoAmpliada = new JLabel(imagenNueva);

        // Agrega el JLabel a la ventana ampliada
        ventanaAmpliada.getContentPane().add(fotoAmpliada);

        // Establece el tamaño de la ventana
        ventanaAmpliada.setSize(nuevoAncho, nuevoAlto);

        // Centra la ventana en la pantalla
        ventanaAmpliada.setLocationRelativeTo(null);

        // Muestra la ventana ampliada
        ventanaAmpliada.setVisible(true);
    }
    
    private BufferedImage escalarImagen(Image imagen, int ancho, int alto) {
        BufferedImage bufferedImage = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(imagen, 0, 0, ancho, alto, null);
        g2d.dispose();

        return bufferedImage;
    }

    public void BuscarImagen(int IdDepartamento){
            //casting
            int ID = IdDepartamento;
            try {
                Connection conexion = new Conexion().getConexion();
                PreparedStatement psSU = conexion.prepareStatement("select * from imagen where IDDEPARTAMENTO='"+ID+"'");
                ResultSet rsSU = psSU.executeQuery();
                
                if(rsSU.next()){
                    //Datos consultados
                    txt_nombreImagen.setText(rsSU.getString("nomImagen"));
                    //leer binario
                    Blob blob = rsSU.getBlob(3);
                    //para el binario a imagen
                    byte[] data = blob.getBytes(1,(int) blob.length());
                    //lee la imagen
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (Exception e) {
                        Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE,null,e);
                    }
                    ImageIcon icono = new ImageIcon(img);
                    Icon imagen = new ImageIcon(icono.getImage().getScaledInstance(Foto.getWidth(),Foto.getHeight(), Image.SCALE_DEFAULT));
                    Foto.setIcon(imagen);
                    Foto.setText("");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "¡¡Error al cargar!!");
                System.out.println("Error al cargar Foto");
            }
        
    }
    
    public void BuscarDiagrama() {
        Object i = jComboBox3.getSelectedItem();  
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
                    jTabbedPane1.setSelectedIndex(7);
                    
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
    
    private void abrirProcedimientos(){
            Procedimiento pro = (Procedimiento)jComboBox3.getSelectedItem();
            nombreDep= "" +(Procedimiento)jComboBox3.getSelectedItem();
            Procedimientos p = new Procedimientos(pro.getIdProcedimiento(),this);
            idProcedimiento = pro.getIdProcedimiento();
            p.setVisible(true);
            //dispose();
            this.setVisible(false);
   }
   public ArrayList<Departamento>listaDepartamentosNivel(){
        deps = new ArrayList<Departamento>();
         int nivel = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select * from departamento where nivel ="+nivel);
            rs = ps.executeQuery();
            while(rs.next()){
                deps.add(new Departamento(rs.getInt("IDDEPARTAMENTO"),rs.getString("NOMBREDEPARTAMENTO")));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return deps;
    }
    private void llenarDepartamentos(){
        
       for(int i = 0;i<deps.size();i++){
          jTextArea4.append(deps.get(i).getNombreDepartamento()+"\n");
        }
    }
    private ArrayList<String> listaPuestosNivel(){
     
      for(int i = 1;i<deps.size();i++){ 
         llenadoListaPuesto();
        
      } 
        
    return puestos;
    }
    private void llenarPuestos(){
      for(int i = 0;i<puestos.size();i++){
          jTextArea4.append(puestos.get(i)+"\n");
        } 
    }
    private void llenadoListaPuesto(){
       puestos = new ArrayList<>();
       int nivel = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select * from departamento d, puestotrabajo p where " +
              "d.IDDEPARTAMENTO= p.IDDEPARTAMENTO and nivel="+nivel); 
            rs = ps.executeQuery();
            while(rs.next()){
                puestos.add(rs.getString("NOMBREPUESTO")); 
            }
            con.close();
        
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
            java.util.logging.Logger.getLogger(InformacionFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new InformacionFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Buscar_Organigrama;
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel Foto_Procedimiento;
    private javax.swing.JButton Ver_Diagrama;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextField txt_nombreImagen;
    private javax.swing.JTextField txt_nombreImagenDiagrama;
    // End of variables declaration//GEN-END:variables
}
