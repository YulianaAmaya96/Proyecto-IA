package vista;

import Model.Busqueda;
import Model.Nodo;
import controlador.CTRLBusqueda;
import controlador.CTRLFabrica;
import controlador.CTRLMatriz;
import controlador.CTRLNodo;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author FREDYAG
 */
public class vBusquedaPuzzle extends javax.swing.JFrame {
    
    private CTRLBusqueda cTRLBusqueda; 
    private final CTRLMatriz cTRLMatriz; 
    private final CTRLNodo cTRLNodo; 
    private final CTRLFabrica cTRLFabrica; 
    private javax.swing.JTextField[][] lstControlesEstadoInicial = null;
    private javax.swing.JTextField[][] lstControlesEstadoFinal = null;


    public vBusquedaPuzzle() {
        initComponents();
        this.cTRLMatriz = new CTRLMatriz();
        this.cTRLFabrica = new CTRLFabrica();
        this.cTRLNodo = new CTRLNodo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstrucEstadoInicial = new javax.swing.JPanel();
        lblEstructEstadoFinal = new javax.swing.JLabel();
        lblEstructEstadoInicial = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEstrucEstadoFinal = new javax.swing.JPanel();
        lblEstadoFinal = new javax.swing.JLabel();
        txtDireccionEstadoInicial = new javax.swing.JTextField();
        btnExaminarArchivoEstadoInicial = new javax.swing.JButton();
        btnExaminarEstadoFinal = new javax.swing.JButton();
        txtDireccionEstadoFinal = new javax.swing.JTextField();
        lblArchivoExterno = new javax.swing.JLabel();
        lblEstadoInicial4 = new javax.swing.JLabel();
        lblTipoBusqueda = new javax.swing.JLabel();
        cmbTipoBusqueda = new javax.swing.JComboBox<>();
        btnBusqueda = new javax.swing.JButton();
        lblEstructEstadoInicial1 = new javax.swing.JLabel();
        cmbGenerarPuzzle = new javax.swing.JComboBox<>();
        btnGenerar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblEstructEstadoFinal1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblProfundidad1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Busqueda para Puzzle 8");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblEstrucEstadoInicial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEstrucEstadoInicial.setLayout(new java.awt.GridLayout(3, 3));
        jScrollPane1.setViewportView(tblEstrucEstadoInicial);

        lblEstructEstadoFinal.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        lblEstructEstadoFinal.setText("Estado final");

        lblEstructEstadoInicial.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        lblEstructEstadoInicial.setText("Estado inicial");

        tblEstrucEstadoFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEstrucEstadoFinal.setLayout(new java.awt.GridLayout(3, 3));
        jScrollPane2.setViewportView(tblEstrucEstadoFinal);

        lblEstadoFinal.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        lblEstadoFinal.setText("Cargar archivo estado inicial: ");

        btnExaminarArchivoEstadoInicial.setText("Examinar...");
        btnExaminarArchivoEstadoInicial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExaminarArchivoEstadoInicialMouseClicked(evt);
            }
        });
        btnExaminarArchivoEstadoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarArchivoEstadoInicialActionPerformed(evt);
            }
        });

        btnExaminarEstadoFinal.setText("Examinar...");
        btnExaminarEstadoFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExaminarEstadoFinalMouseClicked(evt);
            }
        });
        btnExaminarEstadoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarEstadoFinalActionPerformed(evt);
            }
        });

        txtDireccionEstadoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionEstadoFinalActionPerformed(evt);
            }
        });

        lblArchivoExterno.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        lblArchivoExterno.setText("Cargar archivo estado final: ");

        lblEstadoInicial4.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        lblEstadoInicial4.setText("Configuración de búsqueda");

        lblTipoBusqueda.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        lblTipoBusqueda.setText("Tipo de búsqueda:");

        cmbTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amplitud", "Profundidad", "Ascenso en colina", "Ramificación y acotamiento", "Ramificación y acotamiento con subestimación", "A*" }));
        cmbTipoBusqueda.setToolTipText("");

        btnBusqueda.setText("Buscar");
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        lblEstructEstadoInicial1.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        lblEstructEstadoInicial1.setText("Generar PUZZLE:");

        cmbGenerarPuzzle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3 x 3", "4 x 4", "5 x 5" }));
        cmbGenerarPuzzle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenerarPuzzleActionPerformed(evt);
            }
        });

        btnGenerar.setText("Generar");
        btnGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarMouseClicked(evt);
            }
        });
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoFinal)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(txtDireccionEstadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnExaminarArchivoEstadoInicial))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEstructEstadoInicial, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(lblEstadoInicial4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtDireccionEstadoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExaminarEstadoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstructEstadoFinal)
                                    .addComponent(lblArchivoExterno))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235)))
                .addGap(22, 22, 22))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(lblEstructEstadoInicial1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbGenerarPuzzle, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(lblTipoBusqueda)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstructEstadoInicial1)
                    .addComponent(cmbGenerarPuzzle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstructEstadoFinal)
                            .addComponent(lblEstructEstadoInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(lblEstadoFinal)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblArchivoExterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionEstadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExaminarArchivoEstadoInicial)
                    .addComponent(txtDireccionEstadoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExaminarEstadoFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstadoInicial4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoBusqueda)
                    .addComponent(cmbTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBusqueda)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        lblEstructEstadoFinal.getAccessibleContext().setAccessibleName("Estado Final");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        lblEstructEstadoFinal1.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        lblEstructEstadoFinal1.setText("Pasos realizados");

        jTextField1.setEditable(false);
        jTextField1.setText(" ");

        lblProfundidad1.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        lblProfundidad1.setText("Numero de nodos generados: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEstructEstadoFinal1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProfundidad1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblEstructEstadoFinal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProfundidad1))
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExaminarArchivoEstadoInicialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExaminarArchivoEstadoInicialMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExaminarArchivoEstadoInicialMouseClicked

    private void btnExaminarEstadoFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExaminarEstadoFinalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExaminarEstadoFinalMouseClicked

    private void btnExaminarArchivoEstadoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarArchivoEstadoInicialActionPerformed
        cargarArchivo(0);
    }//GEN-LAST:event_btnExaminarArchivoEstadoInicialActionPerformed

    private void btnExaminarEstadoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarEstadoFinalActionPerformed
        cargarArchivo(1);
    }//GEN-LAST:event_btnExaminarEstadoFinalActionPerformed

    /**
     * Metodo encargado de validar datos para realizar la busqueda
     *
     * @return Retorna string
     */
    private String datosRequeridos() {
        String cadena = "";
        if (!(this.lstControlesEstadoInicial == null || this.lstControlesEstadoFinal == null)) {
            if (this.lstControlesEstadoInicial.length != this.lstControlesEstadoFinal.length) {
                cadena = "La matriz ingresada no posee el mismo número de filas";
            } else {
                if (this.lstControlesEstadoInicial[0].length != this.lstControlesEstadoFinal[0].length) {
                    cadena = "La matriz ingresada no posee el mismo número de columnas";
                }
            }
        } else {
            cadena = "Debe cargar un archivo plano o iniciar un nuevo ordenamiento.";
        }
        return cadena;
    }

    /**
     * Metodo encargado de recuperar matriz inicial/final
     *
     * @param xTipoArchivo
     * @return
     */
    private int[][] recuperarMatriz(int xTipoArchivo) {
        JTextField[][] controlesCargados;
        if (xTipoArchivo == 0) {
            controlesCargados = lstControlesEstadoInicial;
        } else {
            controlesCargados = lstControlesEstadoFinal;
        }
        int[][] matriz = new int[controlesCargados.length][controlesCargados[0].length];
        for (int i = 0; i < controlesCargados.length; i++) {
            for (int j = 0; j < controlesCargados.length; j++) {
                matriz[i][j] = Integer.parseInt((controlesCargados[i][j]).getText());
            }
        }
        return matriz;
    }

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        this.jTextArea1.setText(null);
        String CadenaDatos = datosRequeridos();
        if ("".equals(CadenaDatos)) {
            int[][] estadoInicial = recuperarMatriz(0);
            int[][] estadoFinal = recuperarMatriz(1);
            String itemSelect = this.cmbTipoBusqueda.getSelectedItem().toString().trim();
            itemSelect = itemSelect.replace(" ", ""); 
            Busqueda objBusqueda = this.cTRLFabrica.crearBusqueda(itemSelect.trim()); 
            if (objBusqueda != null) {
                objBusqueda.setEstadoInicial(estadoInicial);
                objBusqueda.setEstadoFinal(estadoFinal);
                this.cTRLBusqueda = new CTRLBusqueda(objBusqueda);
                Nodo objNodoSalida = this.cTRLBusqueda.iniciarBusqueda();
                if (objNodoSalida != null) {
                    this.cTRLBusqueda.generarPasosDelPuzzle(objNodoSalida, jTextArea1);
                    this.jTextField1.setText((this.cTRLBusqueda.nodosGenerados()+2 )+ "");
                    JOptionPane.showMessageDialog(null, "Exitoso");
                } else {
                    JOptionPane.showMessageDialog(null, "Fracaso");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } else {
            JOptionPane.showMessageDialog(null, CadenaDatos);
        }
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String direccionEstadoInicial = this.txtDireccionEstadoInicial.getText();
        if(this.cTRLMatriz.existeArchivoInicial(direccionEstadoInicial)){
            int matriz[][] = this.cTRLMatriz.cargarMatriz(direccionEstadoInicial);
            generarPuzzle(matriz, 0);
        }
        String direccionEstadoFinal = this.txtDireccionEstadoFinal.getText();
        if(this.cTRLMatriz.existeArchivoInicial(direccionEstadoFinal)){
            int matrizFinal[][] = this.cTRLMatriz.cargarMatriz(direccionEstadoFinal);
            generarPuzzle(matrizFinal, 1);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnGenerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMouseClicked
        int[][] matrizBoseto;
        switch (this.cmbGenerarPuzzle.getSelectedItem().toString()) {
            case "3 x 3":
                matrizBoseto = new int[3][3];
                break;
            case "4 x 4":
                matrizBoseto = new int[4][4];
                break;
            case "5 x 5":
                matrizBoseto = new int[5][5];
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no valida.");
                matrizBoseto = new int[2][3];
                break;
        }
        this.cTRLMatriz.llenarMatrizOrdenada(matrizBoseto);
        generarPuzzle(matrizBoseto, 1);
        this.cTRLMatriz.desordenarMatriz(matrizBoseto);
        generarPuzzle(matrizBoseto, 0);
    }//GEN-LAST:event_btnGenerarMouseClicked

    private void txtDireccionEstadoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionEstadoFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionEstadoFinalActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void cmbGenerarPuzzleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenerarPuzzleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenerarPuzzleActionPerformed

    /**
     * Metodo encargado de cargar archivo a matriz
     *
     * @param xTipoArchivo
     */
    private void cargarArchivo(int xTipoArchivo) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT FILES", "txt", "text");
        chooser.setFileFilter(filter);
        chooser.setToolTipText("Archivo plano");
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String direccion = chooser.getSelectedFile().getAbsolutePath();
            if (xTipoArchivo == 0) {
                this.txtDireccionEstadoInicial.setText(direccion);
            } else {
                this.txtDireccionEstadoFinal.setText(direccion);
            }
            int matriz[][] = this.cTRLMatriz.cargarMatriz(direccion);
            generarPuzzle(matriz, xTipoArchivo);
        }
    }

    /**
     * Metodo encargado de generar interfaz de puzzle
     *
     * @param matriz matriz
     * @param xTipoArchivo tipo de estado
     */
    private void generarPuzzle(int[][] matriz, int xTipoArchivo) {
        javax.swing.JPanel objTemporal;
        if (xTipoArchivo == 0) {
            objTemporal = tblEstrucEstadoInicial;
            lstControlesEstadoInicial = new JTextField[matriz.length][matriz[0].length];
        } else {
            objTemporal = tblEstrucEstadoFinal;
            lstControlesEstadoFinal = new JTextField[matriz.length][matriz[0].length];
        }
        objTemporal.setLayout(new java.awt.GridLayout(matriz.length, matriz[0].length));
        objTemporal.removeAll();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                javax.swing.JTextField txtObjeto = new javax.swing.JTextField();
                formatearTextBox(txtObjeto);
                txtObjeto.setText(Integer.toString(matriz[i][j]));
                objTemporal.add(txtObjeto);
                if (xTipoArchivo == 0) {
                    lstControlesEstadoInicial[i][j] = txtObjeto;
                } else {
                    lstControlesEstadoFinal[i][j] = txtObjeto;
                }
            }
        }
        objTemporal.updateUI();
    }

    /**
     * Metodo encargado de aplicar diseño a cajas dinamicas
     *
     * @param txtCajaTexto
     */
    private void formatearTextBox(javax.swing.JTextField txtCajaTexto) {
        txtCajaTexto.setBackground(new java.awt.Color(61, 130, 208));
        txtCajaTexto.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtCajaTexto.setForeground(new java.awt.Color(255, 255, 255));
        txtCajaTexto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new vBusquedaPuzzle().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnExaminarArchivoEstadoInicial;
    private javax.swing.JButton btnExaminarEstadoFinal;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> cmbGenerarPuzzle;
    private javax.swing.JComboBox<String> cmbTipoBusqueda;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblArchivoExterno;
    private javax.swing.JLabel lblEstadoFinal;
    private javax.swing.JLabel lblEstadoInicial4;
    private javax.swing.JLabel lblEstructEstadoFinal;
    private javax.swing.JLabel lblEstructEstadoFinal1;
    private javax.swing.JLabel lblEstructEstadoInicial;
    private javax.swing.JLabel lblEstructEstadoInicial1;
    private javax.swing.JLabel lblProfundidad1;
    private javax.swing.JLabel lblTipoBusqueda;
    private javax.swing.JPanel tblEstrucEstadoFinal;
    public static javax.swing.JPanel tblEstrucEstadoInicial;
    private javax.swing.JTextField txtDireccionEstadoFinal;
    private javax.swing.JTextField txtDireccionEstadoInicial;
    // End of variables declaration//GEN-END:variables
}
