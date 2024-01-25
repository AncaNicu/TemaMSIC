package library;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//clasa pt fereastra raspunzatoare de inserarea unei carti
public class InsertDialog implements Dialog {

    @Override
    public void showDialog() {
    	//fereastra pt inserarea unei carti are campuri pt toate datele cartii
    	//o eticheta pt afisarea de mesaje si butonul Insert
    	
        var insertFrame = new JFrame("Insert Book");
        insertFrame.setSize(400, 300);
        var insertPanel = new JPanel();
        insertFrame.add(insertPanel);
        insertPanel.setLayout(null);

        var titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10, 20, 80, 25);
        insertPanel.add(titleLabel);

        var titleText = new JTextField(20);
        titleText.setBounds(100, 20, 250, 25);
        insertPanel.add(titleText);

        var authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 50, 80, 25);
        insertPanel.add(authorLabel);

        var authorText = new JTextField(20);
        authorText.setBounds(100, 50, 250, 25);
        insertPanel.add(authorText);

        var publisherLabel = new JLabel("Publisher:");
        publisherLabel.setBounds(10, 80, 80, 25);
        insertPanel.add(publisherLabel);

        var publisherText = new JTextField(20);
        publisherText.setBounds(100, 80, 250, 25);
        insertPanel.add(publisherText);

        var keywordsLabel = new JLabel("Keywords:");
        keywordsLabel.setBounds(10, 110, 80, 25);
        insertPanel.add(keywordsLabel);

        var keywordsText = new JTextField(20);
        keywordsText.setBounds(100, 110, 250, 25);
        insertPanel.add(keywordsText);

        var domainsLabel = new JLabel("Domains:");
        domainsLabel.setBounds(10, 140, 80, 25);
        insertPanel.add(domainsLabel);

        var domainsText = new JTextField(20);
        domainsText.setBounds(100, 140, 250, 25);
        insertPanel.add(domainsText);

        var yearLabel = new JLabel("Year:");
        yearLabel.setBounds(10, 170, 80, 25);
        insertPanel.add(yearLabel);

        var yearText = new JTextField(20);
        yearText.setBounds(100, 170, 250, 25);
        insertPanel.add(yearText);

        var validationLabel = new JLabel("");
        validationLabel.setBounds(10, 200, 300, 25);
        insertPanel.add(validationLabel);

        var insertBookButton = new JButton("Insert Book");
        insertBookButton.setBounds(10, 230, 120, 25);
        insertPanel.add(insertBookButton);

        //actiunea efectuata la apasarea lui Insert
        insertBookButton.addActionListener(e -> {
        	//ia datele din campuri
            String title = titleText.getText();
            String author = authorText.getText();
            String publisher = publisherText.getText();
            String[] keywords = keywordsText.getText().split(", ");
            String[] domains = domainsText.getText().split(", ");
            String year = yearText.getText();
            
            Validate validateYear = new ValidateYear();

            //daca niciun camp nu e gol
            if (!title.isEmpty() && !author.isEmpty() && !publisher.isEmpty() && 
            		!keywordsText.getText().isEmpty() && !domainsText.getText().isEmpty() && !year.isEmpty()) {
            	//daca anul introdus e valid => incearca inserarea
                if (validateYear.validate(year)) {
                    validationLabel.setText("");
                    int yearAsNr = Integer.parseInt(year);
                    InsertOperation insertOp = new InsertOperation();
                    String message = insertOp.insertNewBook(title, author, keywords, yearAsNr, domains, publisher);
                    validationLabel.setText(message);
                } else {
                    validationLabel.setText("Invalid year. Please enter a valid positive integer.");
                }
            } else {
                validationLabel.setText("Please fill in all fields.");
            }
        });

        insertFrame.setVisible(true);
    }
}
