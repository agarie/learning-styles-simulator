/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Fabiano Dorca
 */
public class TelaPrincipalEmIngles extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalEmIngles
     */
    public TelaPrincipalEmIngles() {
        initComponents();
        setTitle("SPSP - Students Performances Simulation Process");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        forca1 = new javax.swing.JComboBox();
        forca2 = new javax.swing.JComboBox();
        tam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        forca3 = new javax.swing.JComboBox();
        forca4 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        EAr_ativo = new javax.swing.JRadioButton();
        EAr_reflexivo = new javax.swing.JRadioButton();
        EAr_sensitivo = new javax.swing.JRadioButton();
        EAr_intuitivo = new javax.swing.JRadioButton();
        EAr_visual = new javax.swing.JRadioButton();
        EAr_verbal = new javax.swing.JRadioButton();
        EAr_sequencial = new javax.swing.JRadioButton();
        EAr_global = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        k = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        m = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lim = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        ag = new javax.swing.JRadioButton();
        markov = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        MEsequencial = new javax.swing.JTextField();
        MEglobal = new javax.swing.JTextField();
        MEvisual = new javax.swing.JTextField();
        MEverbal = new javax.swing.JTextField();
        MEsensitivo = new javax.swing.JTextField();
        MEintuitivo = new javax.swing.JTextField();
        MEativo = new javax.swing.JTextField();
        MEreflexivo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        arquivo = new javax.swing.JTextField();
        portugues = new javax.swing.JRadioButton();
        ingles = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        forca1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strong", "Moderada", "Leve" }));
        forca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forca1ActionPerformed(evt);
            }
        });

        forca2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strong", "Moderada", "Leve" }));

        tam.setText("30");

        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Active:");

        forca3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strong", "Moderada", "Leve" }));

        forca4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strong", "Moderada", "Leve" }));

        jLabel13.setText("Visual:");

        jLabel12.setText("Intuitive:");

        jLabel11.setText("Sensitive:");

        jLabel10.setText("Reflective:");

        EAr_ativo.setText("Active");
        EAr_ativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EAr_ativoActionPerformed(evt);
            }
        });

        EAr_reflexivo.setSelected(true);
        EAr_reflexivo.setText("Reflective");

        EAr_sensitivo.setText("Sensitive");
        EAr_sensitivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EAr_sensitivoActionPerformed(evt);
            }
        });

        EAr_intuitivo.setSelected(true);
        EAr_intuitivo.setText("Intuitive");

        EAr_visual.setText("Visual");

        EAr_verbal.setSelected(true);
        EAr_verbal.setText("Verbal");

        EAr_sequencial.setText("Sequential");

        EAr_global.setSelected(true);
        EAr_global.setText("Global");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Parameters:");

        jLabel4.setText("Rmax");

        k.setText("0.8");

        jLabel3.setText("PFM threshold:");

        jLabel2.setText("Learning Rate:");

        m.setText("60");

        lim.setText("0.2");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Student's real LS:");

        ag.setText("AG");
        ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agActionPerformed(evt);
            }
        });

        markov.setSelected(true);
        markov.setText("Markov");

        jLabel22.setText("Approach:");

        MEsequencial.setText("0.70");

        MEglobal.setText("0.30");

        MEvisual.setText("0.70");

        MEverbal.setText("0.30");

        MEsensitivo.setText("0.70");

        MEintuitivo.setText("0.30");

        MEativo.setText("0.70");
        MEativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MEativoActionPerformed(evt);
            }
        });

        MEreflexivo.setText("0.30");

        jLabel9.setText("Active-Reflective         ");

        jLabel8.setText("Learning goals:");

        jLabel19.setText("Sequential-Global");

        jLabel18.setText("Visual-Verbal");

        jLabel15.setText("Sequential:");

        jLabel14.setText("Verbal:");

        jLabel17.setText("Sensitive-Intuitive");

        jLabel16.setText("Global:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Initial probabilistic LS ");

        arquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivoActionPerformed(evt);
            }
        });

        portugues.setSelected(true);
        portugues.setText("Portuguese");

        ingles.setText("English");

        jLabel21.setText("Language:");

        jLabel20.setText("Save Experiment As");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel4)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel2)))
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lim)
                                        .addComponent(m)
                                        .addComponent(k)
                                        .addComponent(tam, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel22)
                                    .addGap(18, 18, 18)
                                    .addComponent(markov)
                                    .addGap(18, 18, 18)
                                    .addComponent(ag))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel10))
                                            .addGap(34, 34, 34)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(MEreflexivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel12)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(MEintuitivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(MEativo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel11)
                                                    .addGap(33, 33, 33)
                                                    .addComponent(MEsensitivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel14))
                                            .addGap(21, 21, 21)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(MEverbal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel16))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(MEvisual, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel15)))
                                            .addGap(28, 28, 28)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(MEglobal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(MEsequencial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                                                            .addComponent(jSeparator1)
                                                            .addComponent(jLabel1)
                                                            .addComponent(jLabel6)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabel5)))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGap(31, 31, 31)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(EAr_ativo)
                                                                .addComponent(EAr_reflexivo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(forca1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(54, 54, 54)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(43, 43, 43))
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(EAr_sensitivo)
                                                                        .addComponent(EAr_intuitivo)
                                                                        .addComponent(forca2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                                                .addComponent(EAr_visual)
                                                                .addComponent(EAr_verbal)
                                                                .addComponent(forca3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addGap(68, 68, 68)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(EAr_global)
                                                                    .addComponent(EAr_sequencial)
                                                                    .addComponent(forca4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                            .addContainerGap()
                                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                    .addComponent(jLabel21)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                    .addComponent(portugues)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                    .addComponent(ingles)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                    .addComponent(jButton1)
                                                                                    .addGap(74, 74, 74)
                                                                                    .addComponent(jLabel20)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addGap(12, 12, 12))
                                                                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                .addContainerGap())
                                                                                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(20, 20, 20))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(k, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGap(4, 4, 4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(tam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)
                        .addComponent(markov)
                        .addComponent(ag))
                    .addGap(21, 21, 21)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EAr_ativo)
                            .addComponent(EAr_sensitivo)
                            .addComponent(EAr_visual)
                            .addComponent(EAr_sequencial))
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EAr_reflexivo)
                            .addComponent(EAr_intuitivo)
                            .addComponent(EAr_verbal)
                            .addComponent(EAr_global))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(forca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forca3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forca4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel6)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MEativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MEsensitivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MEvisual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MEsequencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(MEreflexivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(MEintuitivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(MEverbal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(MEglobal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                    .addGap(10, 10, 10))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(3, 3, 3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(ingles)
                            .addComponent(portugues)
                            .addComponent(jLabel21))
                    .addContainerGap())
                    );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LearningStyle EA = new LearningStyle();
        LearningStylesCombination cea_r = new LearningStylesCombination();

        //inicializar estilos de aprendizagem no ME
        double ativo = Double.parseDouble(MEativo.getText());
        double reflexivo = Double.parseDouble(MEreflexivo.getText());
        double sensitivo = Double.parseDouble(MEsensitivo.getText());
        double intuitivo = Double.parseDouble(MEintuitivo.getText());
        double visual = Double.parseDouble(MEvisual.getText());
        double verbal = Double.parseDouble(MEverbal.getText());
        double sequencial = Double.parseDouble(MEsequencial.getText());
        double global = Double.parseDouble(MEglobal.getText());

        EA.set(0, ativo, reflexivo); //(0)ativo-(1)reflexivo
        EA.set(1, sensitivo, intuitivo); //(0)sensitivo-(1)intuitivo
        EA.set(2, visual, verbal); //(0)visual-(1)verbal
        EA.set(3, sequencial, global); //(0)sequencial-(1)global

        //configurar CEA real do estudante
        String f1 = (String) forca1.getSelectedItem();
        String f2 = (String) forca2.getSelectedItem();
        String f3 = (String) forca3.getSelectedItem();
        String f4 = (String) forca4.getSelectedItem();

        cea_r.setStrength(f1.charAt(0), f2.charAt(0), f3.charAt(0), f4.charAt(0));  //F = forte; M = moderada; L = leve

        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;

        if (EAr_reflexivo.isSelected()) {
            d1 = 1;
        }
        if (EAr_intuitivo.isSelected()) {
            d2 = 1;
        }
        if (EAr_verbal.isSelected()) {
            d3 = 1;
        }
        if (EAr_global.isSelected()) {
            d4 = 1;
        }

        cea_r.set(d1, d2, d3, d4);   //Experimento 1

        StudentModel ME = new StudentModel(EA, Integer.parseInt(tam.getText()),
                Double.parseDouble(k.getText()), Double.parseDouble(lim.getText()));

        //inicializar objetivos de aprendizagem do estudante
        ME.setOA();

        //inicializar estado cognitivo do estudante
        ME.setEC();

        byte idioma;
        if (portugues.isSelected()) {
            idioma = 0;
        } else {
            idioma = 1;
        }

        byte abordagem = 0;
        if (ag.isSelected()) {
            abordagem = 1;
        }

        LearningProcess.executar(cea_r, ME, Double.parseDouble(m.getText()), arquivo.getText(), idioma, abordagem);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void EAr_ativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EAr_ativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EAr_ativoActionPerformed

    private void EAr_sensitivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EAr_sensitivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EAr_sensitivoActionPerformed

    private void agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agActionPerformed

    private void MEativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MEativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MEativoActionPerformed

    private void arquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arquivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arquivoActionPerformed

    private void forca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forca1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forca1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalEmIngles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalEmIngles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalEmIngles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalEmIngles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaPrincipalEmIngles().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton EAr_ativo;
    private javax.swing.JRadioButton EAr_global;
    private javax.swing.JRadioButton EAr_intuitivo;
    private javax.swing.JRadioButton EAr_reflexivo;
    private javax.swing.JRadioButton EAr_sensitivo;
    private javax.swing.JRadioButton EAr_sequencial;
    private javax.swing.JRadioButton EAr_verbal;
    private javax.swing.JRadioButton EAr_visual;
    private javax.swing.JTextField MEativo;
    private javax.swing.JTextField MEglobal;
    private javax.swing.JTextField MEintuitivo;
    private javax.swing.JTextField MEreflexivo;
    private javax.swing.JTextField MEsensitivo;
    private javax.swing.JTextField MEsequencial;
    private javax.swing.JTextField MEverbal;
    private javax.swing.JTextField MEvisual;
    private javax.swing.JRadioButton ag;
    private javax.swing.JTextField arquivo;
    private javax.swing.JComboBox forca1;
    private javax.swing.JComboBox forca2;
    private javax.swing.JComboBox forca3;
    private javax.swing.JComboBox forca4;
    private javax.swing.JRadioButton ingles;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField k;
    private javax.swing.JTextField lim;
    private javax.swing.JTextField m;
    private javax.swing.JRadioButton markov;
    private javax.swing.JRadioButton portugues;
    private javax.swing.JTextField tam;
    // End of variables declaration//GEN-END:variables
}
