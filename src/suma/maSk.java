package suma;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.CommunicationException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mayola
 */
public class maSk extends javax.swing.JFrame {

    com.mysql.jdbc.Connection sql = new conexion().getConexion();

    public int verifCon() {
        try {
            if (sql.isClosed()) {
                System.out.println("asdas");
                return 1;
            }
        } catch (Exception ex) {
            return 1;
        }
        return 0;
    }
    public String resANt;
    int resLen;
    int flag = 1;
    int flagRep = 1;
    int flagPar = 1;
    int flagP = 1;
    int flagPor = 0;
    int tableDis = verifCon();

    public boolean invChar(String last) {
        if (!imp.isEmpty()) {
            resLen = imp.length();
            resANt = imp.substring(resLen - 1, resLen);
            System.out.println(resANt);
            return !resANt.equals(last);
        } else {
            return false;
        }
    }

    public PreparedStatement prst() {
        PreparedStatement pr = null; //para poder realizar la consultax
        try {
            pr = (PreparedStatement) sql.prepareStatement("SELECT * FROM calculos ");
            return pr;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ha habido un Error: \n" + "Revise la conexion a la tabla.", "ERROR", 0, 0);
            return pr;
        }
    }

    public void setTable() {
        ResultSet rs = null; // sirve para obtener los resultados
        ResultSetMetaData rsmt = null; //sirve para obtener informacion de la base de datos
        //preparamos las variables que vamos a utiliza
        try {
            DefaultTableModel model = new DefaultTableModel(); //para poder modificar la tabla un modelo de jtable
            tabla.setModel(model);
            model.addColumn("id");
            model.addColumn("calculo");
            model.addColumn("resultado"); //definimos los nombres de las columnas, tambien se puede hacer por meta datos
            PreparedStatement pr = prst();
            rs = pr.executeQuery();
            rsmt = pr.getMetaData();
            //obtenemos la conexion, realizamos la consulta y guardamos los datos
            int cols = rsmt.getColumnCount(); //obtenemos columnas
            Object filas[] = new Object[cols]; // definimos el numero de columnas para rellenar datos
            while (rs.next()) {
                for (int i = 0; i < cols; i++) {
                    filas[i] = rs.getObject(i + 1); //almacenamos los datos en objetos
                }
                model.addRow(filas);
            }
        } catch (Exception e) {
            tableDis = verifCon();
            JOptionPane.showConfirmDialog(null, "Ha habido un Error: \n" + "Revise la conexion a la base de datos, o a la tabla.", "ERROR", 0, 0);
        }
    }

    //NOTA TECNICA
    /* 
        LA BASE DE DATOS DEBE DE LLAMARSE calculadora
     */
    public maSk() {
        initComponents();
        this.setLocationRelativeTo(null); // para que este centrado en medio de la pantalla
        playSound(); // el sonido se ejecutara una sola vez
        ImageIcon icono = new ImageIcon(new ImageIcon("src/suma/loading.gif").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)); //100, 100 add your own size
        imagen.setIcon(icono);
    }

    // la integracion de los apartados de sonido viene de parte de un foto de stackoverflow, junto con un wav que viene de freesound.com
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/suma/success-48018.wav").getAbsoluteFile());
            Mixer.Info[] mixers = AudioSystem.getMixerInfo(); //declaramos opciones de mixer, depende del tipo de salida
            Clip clip = AudioSystem.getClip(); //este es el mixer de mis auriculares, los tres primeros son de la placa
            //probablemente se deba de cambiar de mixer para poder verse
            clip.open(audioInputStream);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            System.out.println("Error mientras se reproducia el archivo.");
        }
    }
    String imp = "";
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript"); //motor de javascript que interpreta strings

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        num1 = new javax.swing.JTextField();
        dividir = new javax.swing.JButton();
        sumar = new javax.swing.JButton();
        restar = new javax.swing.JButton();
        multiplicar = new javax.swing.JButton();
        dividir1 = new javax.swing.JButton();
        sumar1 = new javax.swing.JButton();
        multiplicar1 = new javax.swing.JButton();
        dividir2 = new javax.swing.JButton();
        sumar2 = new javax.swing.JButton();
        multiplicar2 = new javax.swing.JButton();
        dividir3 = new javax.swing.JButton();
        sumar3 = new javax.swing.JButton();
        multiplicar3 = new javax.swing.JButton();
        restar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        restar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        punto = new javax.swing.JButton();
        coma = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        restar3 = new javax.swing.JButton();
        restar4 = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(102, 102, 102));
        panel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelFocusGained(evt);
            }
        });
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelMouseEntered(evt);
            }
        });

        dividir.setText("/");
        dividir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dividirMouseClicked(evt);
            }
        });

        sumar.setText("+");
        sumar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sumarMouseClicked(evt);
            }
        });

        restar.setText("-");
        restar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restarMouseClicked(evt);
            }
        });

        multiplicar.setText("*");
        multiplicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multiplicarMouseClicked(evt);
            }
        });

        dividir1.setText("4");
        dividir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dividir1MouseClicked(evt);
            }
        });

        sumar1.setText("1");
        sumar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sumar1MouseClicked(evt);
            }
        });

        multiplicar1.setText("7");
        multiplicar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multiplicar1MouseClicked(evt);
            }
        });

        dividir2.setText("5");
        dividir2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dividir2MouseClicked(evt);
            }
        });

        sumar2.setText("2");
        sumar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sumar2MouseClicked(evt);
            }
        });

        multiplicar2.setText("8");
        multiplicar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multiplicar2MouseClicked(evt);
            }
        });

        dividir3.setText("6");
        dividir3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dividir3MouseClicked(evt);
            }
        });

        sumar3.setText("3");
        sumar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sumar3MouseClicked(evt);
            }
        });

        multiplicar3.setText("9");
        multiplicar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multiplicar3MouseClicked(evt);
            }
        });

        restar1.setText("0");
        restar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restar1MouseClicked(evt);
            }
        });

        jButton1.setText("N");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        restar2.setText("=");
        restar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restar2MouseClicked(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "calculo", "resultado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton2.setText("X");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Pow");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Sqrt");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        punto.setText(".");
        punto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                puntoMouseClicked(evt);
            }
        });

        coma.setText(",");
        coma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comaMouseClicked(evt);
            }
        });

        borrar.setText("C");
        borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarMouseClicked(evt);
            }
        });

        restar3.setText("(");
        restar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restar3MouseClicked(evt);
            }
        });

        restar4.setText(")");
        restar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restar4MouseClicked(evt);
            }
        });

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suma/loading.gif"))); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(multiplicar1)
                                        .addGap(12, 12, 12)
                                        .addComponent(multiplicar2)
                                        .addGap(12, 12, 12)
                                        .addComponent(multiplicar3))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(dividir1)
                                        .addGap(12, 12, 12)
                                        .addComponent(dividir2)
                                        .addGap(12, 12, 12)
                                        .addComponent(dividir3))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(sumar1)
                                        .addGap(12, 12, 12)
                                        .addComponent(sumar2)
                                        .addGap(12, 12, 12)
                                        .addComponent(sumar3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addComponent(borrar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(coma)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(punto))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(restar1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(restar3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(restar4)))
                                .addGap(12, 12, 12)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dividir)
                                    .addComponent(sumar)
                                    .addComponent(restar)
                                    .addComponent(restar2)
                                    .addComponent(multiplicar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(num1)
                                .addGap(18, 18, 18)
                                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(86, 86, 86))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(num1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(multiplicar)
                            .addComponent(punto)
                            .addComponent(coma)
                            .addComponent(borrar))
                        .addGap(6, 6, 6)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(multiplicar1)
                                    .addComponent(multiplicar2)
                                    .addComponent(multiplicar3))
                                .addGap(6, 6, 6)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dividir1)
                                    .addComponent(dividir2)
                                    .addComponent(dividir3))
                                .addGap(6, 6, 6)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sumar1)
                                    .addComponent(sumar2)
                                    .addComponent(sumar3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(restar1)
                                    .addComponent(restar3)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(dividir)
                                .addGap(6, 6, 6)
                                .addComponent(sumar)
                                .addGap(6, 6, 6)
                                .addComponent(restar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(restar2)
                                    .addComponent(restar4)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restar4MouseClicked
        // TODO add your handling code here:
        if (flag == 0 && flagPar == 0 && flagPor == 1) {
            imp = imp + restar4.getText();
            num1.setText(imp);
            flagPar = 1;
            flagP = 1;
        }
    }//GEN-LAST:event_restar4MouseClicked

    private void restar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restar3MouseClicked
        // TODO add your handling code here:
        if (flag == 1 && flagPar == 1) {
            imp = imp + restar3.getText();
            num1.setText(imp);
            flagPar = 0;
            flagPor = 1;
        }
    }//GEN-LAST:event_restar3MouseClicked

    private void borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarMouseClicked
        // TODO add your handling code here:
        flag = 1;
        flagRep = 1;
        flagPar = 1;
        flagP = 1;
        try {
            imp = "";
            num1.setText(imp);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ha habido un Error: \n" + "Revise que el campo no este vacio.", "ERROR", 0, 0);

        }

    }//GEN-LAST:event_borrarMouseClicked

    private void comaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comaMouseClicked
        // TODO add your handling code here:
        if (flag == 0 && invChar(coma.getText())) {
            imp = imp + coma.getText();
            num1.setText(imp);
        }
    }//GEN-LAST:event_comaMouseClicked

    private void puntoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_puntoMouseClicked
        // TODO add your handling code here:
        if (flag == 0 && invChar(coma.getText())) {
            imp = imp + punto.getText();
            num1.setText(imp);
            flag = 1;
        }
    }//GEN-LAST:event_puntoMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        if (flag == 1 && flagP == 1) {
            imp += "Math.sqrt(";
            num1.setText(imp);
            flagP = 0;
            flagPar = 0;

        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        if (flag == 1 && flagP == 1 && flagPor == 0) {
            imp += "Math.pow(";
            num1.setText(imp);
            flagP = 0;
            flagPar = 0;
            flagPor = 1;
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2MouseClicked

    private void restar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restar2MouseClicked
        // TODO add your handling code here:
        // RESULTADO ====
        try {
            if (!imp.isEmpty()) {
                tableDis = 0;
                if (imp.endsWith(",")) {
                    imp = imp.substring(0, imp.length() - 1) + ".0";
                }
                String result = String.valueOf(engine.eval(imp));
                num1.setText(result);
                System.out.println(result);
                java.sql.Connection sql = new conexion().getConexion();
                PreparedStatement pr = null;
                ResultSet rs = null;
                pr = (PreparedStatement) sql.prepareStatement("INSERT INTO calculos VALUES(null, ?, ?)");
                pr.setString(1, imp);
                pr.setString(2, result);
                pr.execute();
                setTable();
            }
            else{
                            JOptionPane.showConfirmDialog(null, "Ha habido un Error: \n" + "Ingrese un Valor a calcular.", "ERROR", 0, 0);
            }
        } catch (ScriptException e) {
            if (e.toString().contains("Expected l-value but found")) {
                JOptionPane.showConfirmDialog(null, "Ha habido un Error: \n" + "Ingrese un Valor a calcular.", "ERROR", 0, 0);
            }
            if (e.toString().contains("Expected an operand but found eof")) {
                imp = imp.substring(0, imp.length() - 1);
                num1.setText(imp);
            }
            if (e.toString().contains("Expected , but found eof")) {
                imp = imp + ")";
                num1.setText(imp);
            }
            if(e.toString().contains("Expected ) but found eof")){
                imp = imp + ")";
                num1.setText(imp);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ha habido un Error: \n" + "Error en la base de Datos.", "ERROR", 0, 0);
            System.err.println("error: " + e);
        }
    }//GEN-LAST:event_restar2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if (panel.getBackground() == Color.WHITE) {
            panel.setBackground(Color.GRAY);
        } else {
            panel.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void restar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restar1MouseClicked
        // TODO add your handling code here:
        imp = imp + restar.getText();
        num1.setText(imp);
        flag = 0;

    }//GEN-LAST:event_restar1MouseClicked

    private void multiplicar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiplicar3MouseClicked
        // TODO add your handling code here:
        imp += multiplicar3.getText();
        num1.setText(imp);
        flag = 0;

    }//GEN-LAST:event_multiplicar3MouseClicked

    private void sumar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sumar3MouseClicked
        // TODO add your handling code here:
        imp += sumar3.getText();
        num1.setText(imp);
        flag = 0;

    }//GEN-LAST:event_sumar3MouseClicked

    private void dividir3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dividir3MouseClicked
        // TODO add your handling code here:
        imp += dividir3.getText();
        num1.setText(imp);
        flag = 0;

    }//GEN-LAST:event_dividir3MouseClicked

    private void multiplicar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiplicar2MouseClicked
        // TODO add your handling code here:
        imp += multiplicar2.getText();
        num1.setText(imp);
        flag = 0;

    }//GEN-LAST:event_multiplicar2MouseClicked

    private void sumar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sumar2MouseClicked
        // TODO add your handling code here:
        imp += sumar2.getText();
        num1.setText(imp);
        flag = 0;

    }//GEN-LAST:event_sumar2MouseClicked

    private void dividir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dividir2MouseClicked
        // TODO add your handling code here:
        imp += dividir2.getText();
        num1.setText(imp);
        flag = 0;

    }//GEN-LAST:event_dividir2MouseClicked

    private void multiplicar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiplicar1MouseClicked
        // TODO add your handling code here:
        imp += multiplicar1.getText();
        num1.setText(imp);
        flag = 0;

    }//GEN-LAST:event_multiplicar1MouseClicked

    private void sumar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sumar1MouseClicked
        // TODO add your handling code here:
        imp += sumar1.getText();
        num1.setText(imp);
        flag = 0;

    }//GEN-LAST:event_sumar1MouseClicked

    private void dividir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dividir1MouseClicked
        // TODO add your handling code here:
        imp += dividir1.getText();
        num1.setText(imp);
        flag = 0;
    }//GEN-LAST:event_dividir1MouseClicked

    private void multiplicarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiplicarMouseClicked
        // TODO add your handling code here:
        if (flag == 0 && invChar(multiplicar.getText())) {
            imp += multiplicar.getText();
            num1.setText(imp);
            flag = 1;
        }
    }//GEN-LAST:event_multiplicarMouseClicked

    private void restarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restarMouseClicked
        // TODO add your handling code here:
        if (flag == 0 && invChar(restar.getText())) {
            imp += restar.getText();
            num1.setText(imp);
            flag = 1;
        }
    }//GEN-LAST:event_restarMouseClicked

    private void sumarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sumarMouseClicked
        // TODO add your handling code here:
        if (flag == 0 && invChar(sumar.getText())) {
            imp += sumar.getText();
            num1.setText(imp);
            flag = 1;
        }
    }//GEN-LAST:event_sumarMouseClicked

    private void dividirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dividirMouseClicked
        // TODO add your handling code here:
        if (flag == 0 && invChar(dividir.getText())) {
            imp += dividir.getText(); //al string, le sumamos el valor del boton que estamos tocando
            num1.setText(imp);
            flag = 1;
        } // y lo imprimrimos en pantalla
    }//GEN-LAST:event_dividirMouseClicked

    private void panelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_panelFocusGained

    private void panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseEntered
        // TODO add your handling code here:
        if (tableDis == 0) {
            setTable(); // pre seleccionamos los calculos anteriores de la base de datos
        }

    }//GEN-LAST:event_panelMouseEntered

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
            java.util.logging.Logger.getLogger(maSk.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(maSk.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(maSk.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(maSk.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new maSk().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton coma;
    private javax.swing.JButton dividir;
    private javax.swing.JButton dividir1;
    private javax.swing.JButton dividir2;
    private javax.swing.JButton dividir3;
    private javax.swing.JLabel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton multiplicar;
    private javax.swing.JButton multiplicar1;
    private javax.swing.JButton multiplicar2;
    private javax.swing.JButton multiplicar3;
    private javax.swing.JTextField num1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton punto;
    private javax.swing.JButton restar;
    private javax.swing.JButton restar1;
    private javax.swing.JButton restar2;
    private javax.swing.JButton restar3;
    private javax.swing.JButton restar4;
    private javax.swing.JButton sumar;
    private javax.swing.JButton sumar1;
    private javax.swing.JButton sumar2;
    private javax.swing.JButton sumar3;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
