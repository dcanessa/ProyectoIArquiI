package ARM;

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private EditableTableModel modelMemory;
    private EditableTableModel modelRegister;
    private boolean byteIsSelected;
    
    public Operation operation;
    private Memory memory;
    private Register register;

    public MainFrame() {
        initComponents();
        this.memory = new Memory();
        this.register = new Register();
        this.operation = new Operation();

    }

    public void fillRegisterTable() {
        
        System.out.println("R5: "+ this.register.getR5());

        String[] columnNames = {"R0", "R1", "R2", "R3", "R4", "R5", "R6", "R7",
            "R8", "R9", "R10", "R11", "R12", "R13", "R14", "R15"};

        Object[][] data = new Object[1][16];
        data[0][0]=this.register.getR0();
        data[0][1]=this.register.getR1();
        data[0][2]=this.register.getR2();
        data[0][3]=this.register.getR3();
        data[0][4]=this.register.getR4();
        data[0][5]=this.register.getR5();
        data[0][6]=this.register.getR6();
        data[0][7]=this.register.getR7();
        data[0][8]=this.register.getR8();
        data[0][9]=this.register.getR9();
        data[0][10]=this.register.getR10();
        data[0][11]=this.register.getR11();
        data[0][12]=this.register.getR12();
        data[0][13]=this.register.getR13();
        data[0][14]=this.register.getR14();
        data[0][15]=this.register.getR15();
        
        
      
        this.modelRegister = new EditableTableModel(data, columnNames);

        this.registerTable.setModel(this.modelRegister);

    }

    public void fillMemoryTable() {

        String[] columnNames = {"Position", "Data"};

        if (this.byteIsSelected) {
            Object[][] data = new Object[1024][2];
            for (int i = 0; i < this.memory.getSize(); i++) {

                data[i][0] = "0x" + this.memory.intToHex(i);
                data[i][1] = this.memory.loadByte(i);

            }
            this.modelMemory = new EditableTableModel(data, columnNames);
        } else {
            Object[][] data = new Object[256][2];
            for (int i = 0; i < this.memory.getSize(); i += 4) {

                data[i / 4][0] = "0x" + this.memory.intToHex(i);
                data[i / 4][1] = this.memory.loadWord(i);

            }
            this.modelMemory = new EditableTableModel(data, columnNames);
        }

        this.memoryTable.setModel(this.modelMemory);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupMemory = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        checkEdit = new javax.swing.JCheckBox();
        radioButtonBytes = new javax.swing.JRadioButton();
        radioButtonWords = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        memoryTable = new javax.swing.JTable();
        saveMemoryButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        registerTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        codeText = new javax.swing.JTextArea();
        runButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        checkEdit.setText("Edit");
        checkEdit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkEditItemStateChanged(evt);
            }
        });

        buttonGroupMemory.add(radioButtonBytes);
        radioButtonBytes.setText("Byte");
        radioButtonBytes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioButtonBytesItemStateChanged(evt);
            }
        });

        buttonGroupMemory.add(radioButtonWords);
        radioButtonWords.setText("Word");
        radioButtonWords.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioButtonWordsItemStateChanged(evt);
            }
        });

        memoryTable.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        memoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Position", "Data"
            }
        ));
        memoryTable.setFillsViewportHeight(true);
        memoryTable.setFocusable(false);
        memoryTable.setGridColor(java.awt.SystemColor.controlShadow);
        memoryTable.setRowHeight(24);
        memoryTable.setSelectionBackground(new java.awt.Color(102, 102, 102));
        memoryTable.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(memoryTable);

        saveMemoryButton.setText("Save");
        saveMemoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMemoryButtonActionPerformed(evt);
            }
        });

        registerTable.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        registerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "R0", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "R12", "R13", "R14", "R15"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        registerTable.setAutoscrolls(false);
        registerTable.setFillsViewportHeight(true);
        registerTable.setFocusable(false);
        registerTable.setGridColor(java.awt.SystemColor.controlShadow);
        registerTable.setRowHeight(24);
        registerTable.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(registerTable);
        if (registerTable.getColumnModel().getColumnCount() > 0) {
            registerTable.getColumnModel().getColumn(0).setResizable(false);
            registerTable.getColumnModel().getColumn(1).setResizable(false);
            registerTable.getColumnModel().getColumn(2).setResizable(false);
            registerTable.getColumnModel().getColumn(3).setResizable(false);
            registerTable.getColumnModel().getColumn(4).setResizable(false);
            registerTable.getColumnModel().getColumn(5).setResizable(false);
            registerTable.getColumnModel().getColumn(6).setResizable(false);
            registerTable.getColumnModel().getColumn(7).setResizable(false);
            registerTable.getColumnModel().getColumn(8).setResizable(false);
            registerTable.getColumnModel().getColumn(9).setResizable(false);
            registerTable.getColumnModel().getColumn(10).setResizable(false);
            registerTable.getColumnModel().getColumn(11).setResizable(false);
            registerTable.getColumnModel().getColumn(12).setResizable(false);
            registerTable.getColumnModel().getColumn(13).setResizable(false);
            registerTable.getColumnModel().getColumn(14).setResizable(false);
            registerTable.getColumnModel().getColumn(15).setResizable(false);
        }

        codeText.setColumns(20);
        codeText.setRows(5);
        jScrollPane3.setViewportView(codeText);

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1373, Short.MAX_VALUE)
                        .addComponent(jScrollPane3))
                    .addComponent(runButton))
                .addGap(27, 27, 27)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButtonWords)
                            .addComponent(radioButtonBytes))
                        .addGap(31, 31, 31)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveMemoryButton)
                            .addComponent(checkEdit))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(runButton)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radioButtonWords)
                            .addComponent(checkEdit))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioButtonBytes)
                            .addComponent(saveMemoryButton))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveMemoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMemoryButtonActionPerformed
        if (this.byteIsSelected) {
            for (int count = 0; count < modelMemory.getRowCount(); count++) {
                String data = modelMemory.getValueAt(count, 1).toString();
                if (!"".equals(data)) {
                    this.memory.storeByte(count, data);
                }
            }
        } else {
            for (int count = 0; count < modelMemory.getRowCount(); count++) {
                String data = modelMemory.getValueAt(count, 1).toString();
                if (!"".equals(data)) {
                    this.memory.storeWord(count * 4, data);
                }

            }

        }


    }//GEN-LAST:event_saveMemoryButtonActionPerformed

    private void radioButtonWordsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioButtonWordsItemStateChanged

        this.fillMemoryTable();
        this.checkEdit.setSelected(false);
    }//GEN-LAST:event_radioButtonWordsItemStateChanged

    private void radioButtonBytesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioButtonBytesItemStateChanged
        this.byteIsSelected = this.radioButtonBytes.isSelected();
        this.fillMemoryTable();
        this.checkEdit.setSelected(false);
    }//GEN-LAST:event_radioButtonBytesItemStateChanged

    private void checkEditItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkEditItemStateChanged

        int column = 1; //Columna datos
        modelMemory.setColumnEditable(column, this.checkEdit.isSelected());
        this.memoryTable.setModel(modelMemory);


    }//GEN-LAST:event_checkEditItemStateChanged

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        String[] lines = this.codeText.getText().split("\\n");
        for(int i = 0 ; i< lines.length; i++)
        {
            System.out.println(lines[i]);
            this.operation.selectOperation(lines[i], this.register, this.memory);
            
            
            this.fillMemoryTable();
            this.fillRegisterTable();
        }
            
    }//GEN-LAST:event_runButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    private class EditableTableModel extends DefaultTableModel {

        boolean[] columnEditable;

        public EditableTableModel(Object[][] data, String[] columnNames) {
            super(data, columnNames);
            columnEditable = new boolean[columnNames.length];
            Arrays.fill(columnEditable, false);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (!columnEditable[column]) {
                return false;
            } else {
                return super.isCellEditable(row, column);
            }
        }

        public void setColumnEditable(int column, boolean editable) {
            columnEditable[column] = editable;
        }

        public boolean getColumnEditable(int column) {
            return columnEditable[column];
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupMemory;
    private javax.swing.JCheckBox checkEdit;
    private javax.swing.JTextArea codeText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable memoryTable;
    private javax.swing.JRadioButton radioButtonBytes;
    private javax.swing.JRadioButton radioButtonWords;
    private javax.swing.JTable registerTable;
    private javax.swing.JButton runButton;
    private javax.swing.JButton saveMemoryButton;
    // End of variables declaration//GEN-END:variables
}
