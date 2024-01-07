import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RacingApp extends javax.swing.JFrame {

    int secilen;
    int x1 = 0;
    int x2 = 0;
    int x3 = 0;
    int x4 = 0;
    int winner;
    Timer timer;
    double at1;
    double at2;
    double at3;
    double at4;

    boolean kontrol = true;


    public void setImg() {
        ImageIcon img1 = new ImageIcon("C:\\javademos\\horseRacing\\images\\at1.png");
        ImageIcon img2 = new ImageIcon("C:\\javademos\\horseRacing\\images\\at2.png");
        ImageIcon img3 = new ImageIcon("C:\\javademos\\horseRacing\\images\\at3.png");
        ImageIcon img4 = new ImageIcon("C:\\javademos\\horseRacing\\images\\at4.png");
        jLabel6.setIcon(img1);
        jLabel7.setIcon(img2);
        jLabel8.setIcon(img3);
        jLabel9.setIcon(img4);
    }

    public double tutarHesapla(double at) {
        String text = txtGetAmount.getText();
        double tutar = Double.parseDouble(text) * at;
        tutar = Math.floor(tutar * 100) / 100;
        return tutar;
    }


    public void raceHorse() throws InterruptedException {
        int stop = 590;
        if (kontrol) {
            int git1;
            int git2;
            int git3;
            int git4;

            if (at1 > 5) {
                git1 = 5;
            } else if (at1 > 3) {
                git1 = 6;
            } else if (at1 > 2) {
                git1 = 7;
            } else {
                git1 = 8;
            }

            if (at2 > 5) {
                git2 = 5;
            } else if (at2 > 3) {
                git2 = 6;
            } else if (at2 > 2) {
                git2 = 7;
            } else {
                git2 = 8;
            }

            if (at3 > 5) {
                git3 = 5;
            } else if (at3 > 3) {
                git3 = 6;
            } else if (at3 > 2) {
                git3 = 7;
            } else {
                git3 = 8;
            }

            if (at4 > 5) {
                git4 = 5;
            } else if (at4 > 3) {
                git4 = 6;
            } else if (at4 > 2) {
                git4 = 7;
            } else {
                git4 = 8;
            }

            x1 += (int) (Math.random() * git1);
            x2 += (int) (Math.random() * git2);
            x3 += (int) (Math.random() * git3);
            x4 += (int) (Math.random() * git4);

            jLabel6.setLocation(x1, jLabel6.getY());
            jLabel7.setLocation(x2, jLabel7.getY());
            jLabel8.setLocation(x3, jLabel8.getY());
            jLabel9.setLocation(x4, jLabel9.getY());
            jLabel6.repaint();
            jLabel7.repaint();
            jLabel8.repaint();
            jLabel9.repaint();
            if (x1 >= stop) {
                kontrol = false;
                winner = 1;
                check();
            }
            if (x2 >= stop) {
                kontrol = false;
                winner = 2;
                check();
            }
            if (x3 >= stop) {
                kontrol = false;
                winner = 3;
                check();
            }
            if (x4 >= stop) {
                kontrol = false;
                winner = 4;
                check();
            }
        }

    }


    public void check() {
        double kazanılan;
        if (winner == secilen) {
            switch (secilen) {
                case 1:
                    kazanılan = tutarHesapla(Double.parseDouble(lbl1.getText()));
                    JOptionPane.showMessageDialog(null, "Kazandınız Kazanılan Tutar = " + kazanılan);
                    restart();
                    break;
                case 2:
                    kazanılan = tutarHesapla(Double.parseDouble(lbl2.getText()));
                    JOptionPane.showMessageDialog(null, "Kazandınız Kazanılan Tutar = " + kazanılan);
                    restart();
                    break;
                case 3:
                    kazanılan = tutarHesapla(Double.parseDouble(lbl3.getText()));
                    JOptionPane.showMessageDialog(null, "Kazandınız Kazanılan Tutar = " + kazanılan);
                    restart();
                    break;
                case 4:
                    kazanılan = tutarHesapla(Double.parseDouble(lbl4.getText()));
                    JOptionPane.showMessageDialog(null, "Kazandınız Kazanılan Tutar = " + kazanılan);
                    restart();
                    break;
                default:
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kazanamadınız Kaybettiğiniz Tutar = " + txtGetAmount.getText());
            restart();
        }

    }


    public void restart() {
        oranHesapla();
        setImg();
        txtGetAmount.setText("");
        setEnableBut();
        x1 = 0;
        x2 = 0;
        x3 = 0;
        x4 = 0;
    }


    public void oranHesapla() {
        Random rnd = new Random();
        at1 = rnd.nextDouble(1, 4);
        at2 = rnd.nextDouble(1, 4);
        at3 = rnd.nextDouble(1, 4);
        at4 = rnd.nextDouble(1, 4);

        at1 = Math.floor(at1 * 100) / 100;
        at2 = Math.floor(at2 * 100) / 100;
        at3 = Math.floor(at3 * 100) / 100;
        at4 = Math.floor(at4 * 100) / 100;

        lbl1.setText(String.valueOf(at1));
        lbl2.setText(String.valueOf(at2));
        lbl3.setText(String.valueOf(at3));
        lbl4.setText(String.valueOf(at4));

    }


    public void setDisableBut() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
    }

    public void setEnableBut() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
    }

    private void initComponents() {

        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGetAmount = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnRestart = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        txtGetAmount.setText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("At Yarışı");
        setResizable(false);

        btn1.setText("1.At");
        btn1.setActionCommand("btn1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btn1ActionPerformed(evt);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btn2.setText("2.At");
        btn2.setActionCommand("btn1");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setText("3.At");
        btn3.setActionCommand("btn1");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setText("4.At");
        btn4.setActionCommand("btn1");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        lbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lbl2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lbl3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lbl4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("1.AT");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("2.AT");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("3.AT");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("4.AT");

        txtGetAmount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel6.setText("");

        jLabel7.setText("");

        jLabel8.setText("");

        jLabel9.setText("");

        setImg();
        oranHesapla();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        btnRestart.setText("Yeniden Başla");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        jLabel5.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn4)
                                .addGap(180, 180, 180)
                                .addComponent(txtGetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(32, Short.MAX_VALUE)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(txtGetAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnRestart)
                                                .addContainerGap())))
        );

        pack();
    }

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
        try {
            if (!txtGetAmount.getText().equals("") && Double.parseDouble(txtGetAmount.getText()) > 0) {
                secilen = 1;
                setDisableBut();
                kontrol = true;
                if (kontrol) {
                    timer = new Timer(30, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                raceHorse();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    timer.start();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lütfen Pozitif Bir Tutar Giriniz");
                txtGetAmount.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Lütfen Pozitif Bir Sayı Giriniz");
            txtGetAmount.setText("");
        }
    }


    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!txtGetAmount.getText().equals("") && Double.parseDouble(txtGetAmount.getText()) > 0) {
                secilen = 2;
                setDisableBut();
                kontrol = true;
                if (kontrol) {
                    timer = new Timer(30, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                raceHorse();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    timer.start();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lütfen Pozitif Bir Tutar Giriniz");
                txtGetAmount.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Lütfen Pozitif Bir Sayı Giriniz");
            txtGetAmount.setText("");
        }
    }

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!txtGetAmount.getText().equals("") && Double.parseDouble(txtGetAmount.getText()) > 0) {
                secilen = 3;
                setDisableBut();
                kontrol = true;
                if (kontrol) {
                    timer = new Timer(30, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                raceHorse();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    timer.start();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lütfen Pozitif Bir Tutar Giriniz");
                txtGetAmount.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Lütfen Pozitif Bir Sayı Giriniz");
            txtGetAmount.setText("");
        }
    }

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!txtGetAmount.getText().equals("") && Double.parseDouble(txtGetAmount.getText()) > 0) {
                secilen = 4;
                setDisableBut();
                kontrol = true;
                if (kontrol) {
                    timer = new Timer(30, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                raceHorse();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    timer.start();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lütfen Pozitif Bir Tutar Giriniz");
                txtGetAmount.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Lütfen Pozitif Bir Sayı Giriniz");
            txtGetAmount.setText("");
        }
    }

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {
        kontrol = false;
        restart();
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RacingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RacingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RacingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RacingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RacingApp().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btnRestart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JTextField txtGetAmount;

    public RacingApp() {
        initComponents();
        setResizable(false);
    }
}