import controller.Controller;
import entites.employee.consultant.Consultant;
import entites.toy.adulttoys.AdultToys;
import entites.toy.boytoys.BoyToys;
import entites.toy.girlsboys.GirlToys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private final Controller controller;
    private JFrame frame;
    private JLabel label;
    private JPanel panel;

    public App(Controller controller) { // this class is graphical interface of application.
        this.controller = controller;
        scanner = new Scanner(System.in);
        start();
    }

    public void start() { // this method creates the window with several buttons that can call some functions from controller.
        frame = new JFrame();
        label = new JLabel("Hi user");
        JButton button = new JButton("To show all consultants");
        button.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, controller.ShowAllConsultants());
            }
        });
        JButton button1 = new JButton("To show consultants by name");
        button1.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Write the name:");
                while (name.equals("")) {
                    name = JOptionPane.showInputDialog("Write the name:");
                }
                JOptionPane.showMessageDialog(null, controller.ShowConsultantsByName(name));
            }
        });
        JButton button2 = new JButton("To show consultants by id");
        button2.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                String idS = JOptionPane.showInputDialog("Write the id:");
                while (idS.equals("")) {
                    idS = JOptionPane.showInputDialog("Write the id:");
                }
                int id = Integer.parseInt(idS);
                JOptionPane.showMessageDialog(null, controller.ShowConsultantById(id));
            }
        });

        JButton button3 = new JButton("To add the consultant");
        button3.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                int department;
                while (true) {
                    department = Integer.parseInt(JOptionPane.showInputDialog("Write number of department \n1-Department of toys for boys\n 2-Department of toys for girls \n 3-Department of toys for adults"));
                    if (department <= 3 && department >= 1) {
                        break;
                    } else {
                        continue;
                    }
                }
                String name = JOptionPane.showInputDialog("Write the name:");
                String surname = JOptionPane.showInputDialog("Write the surname:");
                String ageS = JOptionPane.showInputDialog("Write the age: ");
                while (ageS.equals("")) {
                    ageS = JOptionPane.showInputDialog("Write the age:");
                }
                int age = Integer.parseInt(ageS);
                String salaryS = JOptionPane.showInputDialog("Write the salary: ");
                while (salaryS.equals("")) {
                    salaryS = JOptionPane.showInputDialog("Write the salary: ");
                }
                int salary = Integer.parseInt(salaryS);
                DateTimeFormatter dateTimeFormatter
                        = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                String date = JOptionPane.showInputDialog("Write the date of the employment(format is yyyy/mm/dd):");
                LocalDate start_date = LocalDate.parse(date, dateTimeFormatter);
                Consultant consultant = new Consultant(name, surname, age, salary, start_date);
                if (department == 1) {
                    JOptionPane.showMessageDialog(null, controller.AddConsultantsToBoyToys(consultant));
                } else if (department == 2) {
                    JOptionPane.showMessageDialog(null, controller.AddConsultantsToGirlToys(consultant));
                } else if (department == 3) {
                    JOptionPane.showMessageDialog(null, controller.AddConsultantsToAdultToys(consultant));
                }
            }
        });
        JButton button4 = new JButton("To remove the consultant by id");
        button4.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                String idS = JOptionPane.showInputDialog("Write the id:");
                while (idS.equals("")) {
                    idS = JOptionPane.showInputDialog("Write the id:");
                }
                int id = Integer.parseInt(idS);
                JOptionPane.showMessageDialog(null, controller.RemoveConsultantByID(id));
            }
        });
        JButton button5 = new JButton("To show all toys");
        button5.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, controller.ShowAllTOYS());
            }
        });
        JButton button6 = new JButton("To show toys by id");
        button6.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                String idS = JOptionPane.showInputDialog("Write the id:");
                while (idS.equals("")) {
                    idS = JOptionPane.showInputDialog("Write the id:");
                }
                int id = Integer.parseInt(idS);
                JOptionPane.showMessageDialog(null, controller.ShowToyByID(id));
            }
        });
        JButton button7 = new JButton("To show toys by name");
        button7.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Write the id:");
                while (name.equals("")) {
                    name = JOptionPane.showInputDialog("Write the id:");
                }
                JOptionPane.showMessageDialog(null, controller.ShowToysByName(name));
            }
        });
        JButton button8 = new JButton("To show toys from department");
        button8.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                int department;
                while (true) {
                    department = Integer.parseInt(JOptionPane.showInputDialog("Write number of department \n1-Department of toys for boys\n 2-Department of toys for girls \n 3-Department of toys for adults"));
                    if (department <= 3 && department >= 1) {
                        break;
                    } else {
                        continue;
                    }
                }
                if (department == 1) {
                    JOptionPane.showMessageDialog(null, controller.ShowAllBoyToys());
                } else if (department == 2) {
                    JOptionPane.showMessageDialog(null, controller.ShowAllGirlToys());
                } else if (department == 3) {
                    JOptionPane.showMessageDialog(null, controller.ShowAllAdultToys());
                }
            }
        });
        JButton button9 = new JButton("To show toys from department by name");
        button9.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                int department;
                while (true) {
                    department = Integer.parseInt(JOptionPane.showInputDialog("Write number of department \n 1-Department of toys for boys\n 2-Department of toys for girls \n 3-Department of toys for adults"));
                    if (department <= 3 && department >= 1) {
                        break;
                    } else {
                        continue;
                    }
                }
                String name = JOptionPane.showInputDialog("Write the name:");
                if (department == 1) {
                    JOptionPane.showMessageDialog(null, controller.ShowBoyToysByName(name));
                } else if (department == 2) {
                    JOptionPane.showMessageDialog(null, controller.ShowBoyGirlByName(name));
                } else if (department == 3) {
                    JOptionPane.showMessageDialog(null, controller.ShowAdultToysByName(name));
                }
            }
        });
        JButton button10 = new JButton("To add toys:");
        button10.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                int department;
                while (true) {
                    department = Integer.parseInt(JOptionPane.showInputDialog("Write number of department \n 1-Department of toys for boys\n 2-Department of toys for girls \n 3-Department of toys for adults"));
                    if (department <= 3 && department >= 1) {
                        break;
                    } else {
                        continue;
                    }
                }
                String name = JOptionPane.showInputDialog("Write the name:");
                String priceS = JOptionPane.showInputDialog("Write the price: ");
                while (priceS.equals("")) {
                    priceS = JOptionPane.showInputDialog("Write the price:");
                }
                int price = Integer.parseInt(priceS);
                String manufacturer = JOptionPane.showInputDialog("Write the manufacturer:");
                String quantityS = JOptionPane.showInputDialog("Write the quantity: ");
                while (quantityS.equals("")) {
                    quantityS = JOptionPane.showInputDialog("Write the quantity:");
                }
                int quantity = Integer.parseInt(quantityS);
                if (department == 1) {
                    BoyToys boyToys = new BoyToys(name, price, manufacturer, quantity);
                    JOptionPane.showMessageDialog(null, controller.AddBoyToys(boyToys));
                } else if (department == 2) {
                    GirlToys girlToys = new GirlToys(name, price, manufacturer, quantity);
                    JOptionPane.showMessageDialog(null, controller.AddGirlToys(girlToys));
                } else if (department == 3) {
                    AdultToys adultToys = new AdultToys(name, price, manufacturer, quantity);
                    JOptionPane.showMessageDialog(null, controller.AddAdultToys(adultToys));
                }
            }

        });
        JButton button11 = new JButton("To remove toy by id:");
        button11.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                String idS = JOptionPane.showInputDialog("Write the id:");
                while (idS.equals("")) {
                    idS = JOptionPane.showInputDialog("Write the id:");
                }
                int id = Integer.parseInt(idS);
                JOptionPane.showMessageDialog(null, controller.RemoveToyByID(id));
            }

        });
        JButton button12 = new JButton("To show consultants by department:");
        button12.addActionListener(new ActionListener() {
            //This method gather information and calls methods from controller. Also it output the results.
            @Override
            public void actionPerformed(ActionEvent e) {
                String idS = JOptionPane.showInputDialog("Write number of department \n 1-Department of toys for boys\n 2-Department of toys for girls \n 3-Department of toys for adults");
                while (idS.equals("")) {
                    idS = JOptionPane.showInputDialog("Write number of department \n 1-Department of toys for boys\n 2-Department of toys for girls \n 3-Department of toys for adults");
                }
                int id = Integer.parseInt(idS);
                JOptionPane.showMessageDialog(null, controller.ShowConsultantsByDepartment(id));
            }

        });
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        panel.add(button12);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button10);
        panel.add(button11);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Toyshop App");
        frame.pack();
        frame.setVisible(true);
    }
}