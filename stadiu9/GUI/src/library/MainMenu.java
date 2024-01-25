package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

//clasa pt meniul principal
public class MainMenu implements ActionListener {
	
    private JButton insertButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton byAuthorButton;
    private JButton byDomainButton;
    private JButton byKeywordsButton;
    private JButton byPublisherButton;
    private JButton byYearsButton;
    private JButton noOfAuthorsButton;
    private JButton noOfBooksButton;
    private JLabel resultLabel;

    public void displayMenu() {
    	//meniul are butoane pt toate operatiile care se pot efectua asupra cartilor
    	
        JFrame frame;
        JPanel panel;

        frame = new JFrame();
        frame.setSize(640, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        //inserare, editare, stergere
        insertButton = new JButton("Insert");
        insertButton.setBounds(10, 20, 80, 25);
        panel.add(insertButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(100, 20, 80, 25);
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(190, 20, 80, 25);
        panel.add(deleteButton);

        //cautarile
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setBounds(10, 60, 80, 25);
        panel.add(searchLabel);

        byAuthorButton = new JButton("By Author");
        byAuthorButton.setBounds(10, 90, 100, 25);
        panel.add(byAuthorButton);

        byDomainButton = new JButton("By Domain");
        byDomainButton.setBounds(120, 90, 110, 25);
        panel.add(byDomainButton);

        byKeywordsButton = new JButton("By Keywords");
        byKeywordsButton.setBounds(240, 90, 120, 25);
        panel.add(byKeywordsButton);

        byPublisherButton = new JButton("By Publisher");
        byPublisherButton.setBounds(370, 90, 110, 25);
        panel.add(byPublisherButton);

        byYearsButton = new JButton("By Years");
        byYearsButton.setBounds(490, 90, 100, 25);
        panel.add(byYearsButton);

        //generarea de rapoarte
        JLabel generateReportLabel = new JLabel("Generate Report:");
        generateReportLabel.setBounds(10, 130, 120, 25);
        panel.add(generateReportLabel);

        noOfAuthorsButton = new JButton("No of Authors");
        noOfAuthorsButton.setBounds(10, 160, 120, 25);
        panel.add(noOfAuthorsButton);

        noOfBooksButton = new JButton("No of Books");
        noOfBooksButton.setBounds(140, 160, 120, 25);
        panel.add(noOfBooksButton);
        
        resultLabel = new JLabel("");
        resultLabel.setBounds(10, 190, 300, 25);
        panel.add(resultLabel);

        //adauga fiecarui buton cate un action listener
        //iar clasa MainMenu va gestiona actinile determinate de apasarea butoanelor
        insertButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        byAuthorButton.addActionListener(this);
        byDomainButton.addActionListener(this);
        byKeywordsButton.addActionListener(this);
        byPublisherButton.addActionListener(this);
        byYearsButton.addActionListener(this);
        noOfAuthorsButton.addActionListener(this);
        noOfBooksButton.addActionListener(this);
    }

    //gestioneaza actiunile generate de apasarea butoanelor
    @Override
    public void actionPerformed(ActionEvent e) {
    	resultLabel.setText("");
        Dialog dialog;
        PerformOperation op;
        if (e.getSource() == insertButton) {
        	resultLabel.setText("Insert button pressed");
        	//pt butonul Insert -> deschide Insert Dialog
            dialog = new InsertDialog();
            dialog.showDialog();
        } else if (e.getSource() == updateButton) {
        	resultLabel.setText("Update button pressed");
        	//pt butonul Update -> deschide Update Dialog
            dialog = new UpdateDialog();
            dialog.showDialog();
        } else if (e.getSource() == deleteButton) {
        	resultLabel.setText("Delete button pressed");
        	//pt butonul Delete -> deschide Delete Dialog
            dialog = new DeleteDialog();
            dialog.showDialog();
        } else if (e.getSource() == byAuthorButton) {
        	resultLabel.setText("Search by author button pressed");
        	//pt butonul Search by author -> deschide Search by author Dialog
            dialog = new SearchByAuthorDialog();
            dialog.showDialog();
        } else if (e.getSource() == byDomainButton) {
        	resultLabel.setText("Search by domain button pressed");
        	//pt butonul Search by domain -> deschide Search by domain Dialog
            dialog = new SearchByDomainDialog();
            dialog.showDialog();
        } else if (e.getSource() == byKeywordsButton) {
        	resultLabel.setText("Search by keywords button pressed");
        	//pt butonul Search by keywords -> deschide Search by keywords Dialog
            dialog = new SearchByKeywordsDialog();
            dialog.showDialog();
        } else if (e.getSource() == byPublisherButton) {
        	resultLabel.setText("Search by publisher button pressed");
        	//pt butonul Search by publisher -> deschide Search by publisher Dialog
            dialog = new SearchByPublisherDialog();
            dialog.showDialog();
        } else if (e.getSource() == byYearsButton) {
        	resultLabel.setText("Search by years button pressed");
        	//pt butonul Search by years -> deschide Search by years Dialog
            dialog = new SearchByYearsDialog();
            dialog.showDialog();
        } else if (e.getSource() == noOfAuthorsButton) {
            //genereaza raportul cu nr de autori
            op = new PerformGenerateNoOfAuthorsReport();
            resultLabel.setText(op.performOperation());
        } else if (e.getSource() == noOfBooksButton) {
        	//genereaza raportul cu nr de carti
            op = new PerformGenerateNoOfBooksReport();
            resultLabel.setText(op.performOperation());
        }
    }
}
