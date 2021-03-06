package ARM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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

    private Memory memory;
    private Register register;
    private ConditionFlags conditionFlag;
    private HashLabel hashLabel;
    private ReserveInstructions reserveInstructions;
    private CodeGeneration codeGenerator;

    public MainFrame() {
        initComponents();

        TextLineNumber tln = new TextLineNumber(this.codeText);
        this.jScrollPane5.setRowHeaderView(tln);

        this.setResizable(false);
        this.memory = new Memory();
        this.register = new Register();
        this.reserveInstructions = new ReserveInstructions();
        this.hashLabel = new HashLabel(reserveInstructions);
        this.conditionFlag = new ConditionFlags();
        this.fillConditionalFlags();
        this.codeGenerator = new CodeGeneration();
        this.clean();
    }

    public void fillConditionalFlags() {
        this.ZeroText.setText(this.conditionFlag.isZero() + "");
        this.NegativeText.setText(this.conditionFlag.isNegative() + "");
        this.CarryText.setText(this.conditionFlag.isCarry() + "");
        this.OverflowText.setText(this.conditionFlag.isoVerflow() + "");
    }

    public void fillRegisterTable() {

        String[] columnNames = {"R0", "R1", "R2", "R3", "R4", "R5", "R6", "R7",
            "R8", "R9", "R10", "R11", "R12", "R13", "R14", "R15"};

        Object[][] data = new Object[1][16];
        data[0][0] = this.register.getR0();
        data[0][1] = this.register.getR1();
        data[0][2] = this.register.getR2();
        data[0][3] = this.register.getR3();
        data[0][4] = this.register.getR4();
        data[0][5] = this.register.getR5();
        data[0][6] = this.register.getR6();
        data[0][7] = this.register.getR7();
        data[0][8] = this.register.getR8();
        data[0][9] = this.register.getR9();
        data[0][10] = this.register.getR10();
        data[0][11] = this.register.getR11();
        data[0][12] = this.register.getR12();
        data[0][13] = this.register.getR13();
        data[0][14] = this.register.getR14();
        data[0][15] = this.register.getR15();

        this.modelRegister = new EditableTableModel(data, columnNames);

        this.registerTable.setModel(this.modelRegister);

    }

    public void fillMemoryTable() {

        String[] columnNames = {"Position", "Data"};

        if (this.byteIsSelected) {
            Object[][] data = new Object[2048][2];
            for (int i = 0; i < this.memory.getSize(); i++) {

                data[i][0] = "0x" + this.memory.intToHex(i);
                data[i][1] = this.memory.loadByte(i);

            }
            this.modelMemory = new EditableTableModel(data, columnNames);
        } else {
            Object[][] data = new Object[512][2];
            for (int i = 0; i < this.memory.getSize(); i += 4) {

                data[i / 4][0] = "0x" + this.memory.intToHex(i);
                data[i / 4][1] = this.memory.loadWord(i);

            }
            this.modelMemory = new EditableTableModel(data, columnNames);
        }

        this.memoryTable.setModel(this.modelMemory);

    }

    //This method is called to print the errors in the simulator
    public void showErrors() {
        if (CodeGeneration.lexicalError == 0 && CodeGeneration.syntacticError == 0
                && CodeGeneration.semanticError == 0) {
            this.OutputText.append("The code generation has been successful." + "\n");

        } else {
            int large = CodeGeneration.errorList.size();
            for (int i = 0; i < large; i++) {
                String findError = CodeGeneration.errorList.get(i);
                this.OutputText.append(findError);
            }

        }
    }

    //Aqui se imprime la lista con las instrucciones
    public void imprimeInstrucciones() {

        int large = CodeGeneration.instructionList.size();
        for (int i = 0; i < large; i++) {
            System.out.println(CodeGeneration.instructionList.get(i));
        }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        memoryTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        registerTable = new javax.swing.JTable();
        runButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        radioButtonWords = new javax.swing.JRadioButton();
        radioButtonBytes = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        checkEdit = new javax.swing.JCheckBox();
        saveMemoryButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cleanMemoryButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        NegativeLabel = new javax.swing.JLabel();
        NegativeText = new javax.swing.JLabel();
        ZeroText = new javax.swing.JLabel();
        ZeroLabel = new javax.swing.JLabel();
        CarryLabel = new javax.swing.JLabel();
        CarryText = new javax.swing.JLabel();
        oVerflowLabel = new javax.swing.JLabel();
        OverflowText = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        OutputText = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        codeText = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        ClockCyclesLabel = new javax.swing.JLabel();
        ClockCyclesText = new javax.swing.JLabel();
        runtimeLabel = new javax.swing.JLabel();
        runtimeText = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainPanel.setName("ARMSimulator"); // NOI18N

        memoryTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        memoryTable.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
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

        registerTable.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
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

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroupMemory.add(radioButtonWords);
        radioButtonWords.setText("Word");
        radioButtonWords.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioButtonWordsItemStateChanged(evt);
            }
        });

        buttonGroupMemory.add(radioButtonBytes);
        radioButtonBytes.setText("Byte");
        radioButtonBytes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioButtonBytesItemStateChanged(evt);
            }
        });

        jLabel1.setText("Data type:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioButtonWords)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioButtonBytes))
                    .addComponent(jLabel1))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButtonWords)
                    .addComponent(radioButtonBytes))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        checkEdit.setText("Edit");
        checkEdit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkEditItemStateChanged(evt);
            }
        });

        saveMemoryButton.setText("Save");
        saveMemoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMemoryButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Memory");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(checkEdit)
                        .addGap(12, 12, 12)
                        .addComponent(saveMemoryButton))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveMemoryButton)
                    .addComponent(checkEdit)))
        );

        cleanMemoryButton.setText("Clean ");
        cleanMemoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanMemoryButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NegativeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NegativeLabel.setText("Negative:");

        NegativeText.setText("jLabel3");

        ZeroText.setText("jLabel3");

        ZeroLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ZeroLabel.setText("Zero:");

        CarryLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CarryLabel.setText("Carry:");

        CarryText.setText("jLabel3");

        oVerflowLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oVerflowLabel.setText("oVerflow:");

        OverflowText.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NegativeLabel)
                .addGap(2, 2, 2)
                .addComponent(NegativeText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ZeroLabel)
                .addGap(2, 2, 2)
                .addComponent(ZeroText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CarryLabel)
                .addGap(2, 2, 2)
                .addComponent(CarryText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oVerflowLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OverflowText))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(oVerflowLabel)
                        .addComponent(OverflowText))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CarryLabel)
                        .addComponent(CarryText))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ZeroLabel)
                        .addComponent(ZeroText))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NegativeLabel)
                        .addComponent(NegativeText)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        OutputText.setColumns(20);
        OutputText.setRows(5);
        jScrollPane3.setViewportView(OutputText);

        codeText.setColumns(20);
        codeText.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        codeText.setRows(5);
        jScrollPane5.setViewportView(codeText);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ClockCyclesLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ClockCyclesLabel.setText("Clock Cycles:");

        ClockCyclesText.setText("jLabel3");

        runtimeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        runtimeLabel.setText("Runtime: ");

        runtimeText.setText("jLabel3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ClockCyclesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClockCyclesText)
                .addGap(36, 36, 36)
                .addComponent(runtimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runtimeText)
                .addGap(125, 125, 125))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClockCyclesLabel)
                    .addComponent(ClockCyclesText)
                    .addComponent(runtimeLabel)
                    .addComponent(runtimeText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1373, Short.MAX_VALUE)
                        .addComponent(jScrollPane3)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(runButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cleanMemoryButton)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cleanMemoryButton)
                                    .addComponent(runButton)))
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(null);
        jMenuBar1.setMaximumSize(new java.awt.Dimension(233, 32767));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(233, 19));

        jMenu1.setText("File");

        jMenuItem3.setText("Save");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Load");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator1);

        jMenuItem1.setText("Generate Code");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cleanMemoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanMemoryButtonActionPerformed
        this.clean();

    }//GEN-LAST:event_cleanMemoryButtonActionPerformed

    public void clean() {
        this.memory.cleanMemory();
        this.register.cleanRegister();
        this.conditionFlag.cleanFlags();
        this.OutputText.setText("Output: \r\n");
        CodeGeneration.instructionList.clear();
        this.fillConditionalFlags();
        this.fillMemoryTable();
        this.fillRegisterTable();
        this.ClockCyclesText.setText("0");
        this.runtimeText.setText("0s");

    }
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

    private void checkEditItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkEditItemStateChanged

        int column = 1; //Columna datos
        modelMemory.setColumnEditable(column, this.checkEdit.isSelected());
        this.memoryTable.setModel(modelMemory);

    }//GEN-LAST:event_checkEditItemStateChanged

    private void radioButtonBytesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioButtonBytesItemStateChanged
        this.byteIsSelected = this.radioButtonBytes.isSelected();
        this.fillMemoryTable();
        this.checkEdit.setSelected(false);
    }//GEN-LAST:event_radioButtonBytesItemStateChanged

    private void radioButtonWordsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioButtonWordsItemStateChanged

        this.fillMemoryTable();
        this.checkEdit.setSelected(false);
    }//GEN-LAST:event_radioButtonWordsItemStateChanged

    public void formatCode() {
        String[] original = this.codeText.getText().split("\\n");
        this.codeText.setText(null);
        for (String line : original) {
            line = line.replaceAll("\t", " ").replaceAll("^ +| +$|( )+", "$1").trim();
            if (line.length() > 0) {
                this.codeText.append(line + "\n");

            }
        }

    }

    public void writeTXTCode(String[] lines) {
        WriteTxtFile file = new WriteTxtFile();
        file.writeFile(lines, "codeARMJTextPane.txt");

    }

    public void fillMemoryProgram() {
        int large = CodeGeneration.instructionList.size();

        for (int i = 0; i < large; i++) {
            String instruction = CodeGeneration.instructionList.get(i);
            int lenght = instruction.length();
            if (lenght < 8) {
                String aux = "";
                for (int j = 0; j < 8 - lenght; j++) {
                    aux += "0";
                }
                instruction = aux + instruction;
            }
            this.memory.storeWord(i * 4, instruction);

        }

    }
    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        //Se limpia todos los registros y cuadro de texto de output
        this.clean();

        //Se obtiene el código del cuadro del texto, se le quitan tabs, líneas en blanco, múltiples espacios
        this.formatCode();

        //Se obtiene el codigo
        String[] lines = this.codeText.getText().split("\\n");

        //Se escribe el archivo de texto con el código
        this.writeTXTCode(lines);

        try {
            codeGenerator.generateCode();

            this.showErrors();

            if (this.OutputText.getText().length() == 51 & this.OutputText.getText().contains("The code generation has been successful.")) {
                this.fillMemoryProgram();

                for (int i = 0; i < lines.length; i++) {
                    this.hashLabel.fillHashTable(lines[i], i);
                }
                Operation operation = new Operation(this.register, this.memory, this.conditionFlag, this.hashLabel, this.reserveInstructions, this.OutputText);

                for (int i = operation.getPCCounter(); i < lines.length; i = operation.getPCCounter()) {
                    if (operation.error == false) {
                        if (operation.branchesExecute < 1000) {
                            //System.out.println("Line: " + lines[i]);
                            operation.selectOperation(lines[i]);

                            this.ClockCyclesText.setText("" + operation.clockCycles);
                            float runTime = (float) (0.00001 * operation.clockCycles);
                            
                            this.runtimeText.setText("" + runTime + "s");
                            this.fillConditionalFlags();
                            this.fillMemoryTable();
                            this.fillRegisterTable();
                        } else {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog (null, "1000 branches. Would you like to exit the execution?","Warning",dialogButton);
                            if(dialogResult  == 0)
                            {                                
                                break;
                                
                            } 
                            else
                            {
                                operation.branchesExecute=0;
                            }
                        }

                    } else {
                        break;
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_runButtonActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String[] lines = this.codeText.getText().split("\\n");
            WriteTxtFile file = new WriteTxtFile();
            file.writeFile(lines, fileChooser.getSelectedFile() + ".arm");

            // save to file
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ARM", "arm");
        fileChooser.addChoosableFileFilter(filter);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                WriteTxtFile file = new WriteTxtFile();
                this.codeText.setText(file.readFile(fileChooser.getSelectedFile().toString()));
                // load from file
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                //
                this.OutputText.setText("Output: \r\n");
                this.codeGenerator.generateCode();
                this.showErrors();
                File source = new File("out.txt");
                File dest = new File(fileChooser.getSelectedFile() + ".txt");
                //copy file conventional way using Stream
                copyFileUsingStream(source, dest);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JLabel CarryLabel;
    private javax.swing.JLabel CarryText;
    private javax.swing.JLabel ClockCyclesLabel;
    private javax.swing.JLabel ClockCyclesText;
    private javax.swing.JLabel NegativeLabel;
    private javax.swing.JLabel NegativeText;
    private javax.swing.JTextArea OutputText;
    private javax.swing.JLabel OverflowText;
    private javax.swing.JLabel ZeroLabel;
    private javax.swing.JLabel ZeroText;
    private javax.swing.ButtonGroup buttonGroupMemory;
    private javax.swing.JCheckBox checkEdit;
    private javax.swing.JButton cleanMemoryButton;
    private javax.swing.JTextArea codeText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable memoryTable;
    private javax.swing.JLabel oVerflowLabel;
    private javax.swing.JRadioButton radioButtonBytes;
    private javax.swing.JRadioButton radioButtonWords;
    private javax.swing.JTable registerTable;
    private javax.swing.JButton runButton;
    private javax.swing.JLabel runtimeLabel;
    private javax.swing.JLabel runtimeText;
    private javax.swing.JButton saveMemoryButton;
    // End of variables declaration//GEN-END:variables
}
