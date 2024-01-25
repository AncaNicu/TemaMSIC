package library;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//clasa pt fereastra raspunzatoare de editarea unei carti
public class UpdateDialog implements Dialog {

    @Override
    public void showDialog() {
    	//fereastra are campuri pt autorul vechi si titlul vechi
    	//si pt noile date ale cartii de editat
    	//o eticheta pt mesaje si butonul Delete
    	
        var updateFrame = new JFrame("Update Book");
        updateFrame.setSize(450, 360);
        var updatePanel = new JPanel();
        updateFrame.add(updatePanel);
        updatePanel.setLayout(null);

        var targetTitleLabel = new JLabel("Target Title:");
        targetTitleLabel.setBounds(10, 20, 100, 25);
        updatePanel.add(targetTitleLabel);

        var targetTitleText = new JTextField(20);
        targetTitleText.setBounds(150, 20, 250, 25);
        updatePanel.add(targetTitleText);

        var targetAuthorLabel = new JLabel("Target Author:");
        targetAuthorLabel.setBounds(10, 50, 100, 25);
        updatePanel.add(targetAuthorLabel);

        var targetAuthorText = new JTextField(20);
        targetAuthorText.setBounds(150, 50, 250, 25);
        updatePanel.add(targetAuthorText);

        var titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10, 80, 80, 25);
        updatePanel.add(titleLabel);

        var titleText = new JTextField(20);
        titleText.setBounds(150, 80, 250, 25);
        updatePanel.add(titleText);

        var authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 110, 80, 25);
        updatePanel.add(authorLabel);

        var authorText = new JTextField(20);
        authorText.setBounds(150, 110, 250, 25);
        updatePanel.add(authorText);

        var publisherLabel = new JLabel("Publisher:");
        publisherLabel.setBounds(10, 140, 80, 25);
        updatePanel.add(publisherLabel);

        var publisherText = new JTextField(20);
        publisherText.setBounds(150, 140, 250, 25);
        updatePanel.add(publisherText);

        var keywordsLabel = new JLabel("Keywords:");
        keywordsLabel.setBounds(10, 170, 80, 25);
        updatePanel.add(keywordsLabel);

        var keywordsText = new JTextField(20);
        keywordsText.setBounds(150, 170, 250, 25);
        updatePanel.add(keywordsText);

        var domainsLabel = new JLabel("Domains:");
        domainsLabel.setBounds(10, 200, 80, 25);
        updatePanel.add(domainsLabel);

        var domainsText = new JTextField(20);
        domainsText.setBounds(150, 200, 250, 25);
        updatePanel.add(domainsText);

        var yearLabel = new JLabel("Year:");
        yearLabel.setBounds(10, 230, 80, 25);
        updatePanel.add(yearLabel);

        var yearText = new JTextField(20);
        yearText.setBounds(150, 230, 250, 25);
        updatePanel.add(yearText);

        var validationLabel = new JLabel("");
        validationLabel.setBounds(10, 260, 300, 25);
        updatePanel.add(validationLabel);

        var updateBookButton = new JButton("Update Book");
        updateBookButton.setBounds(10, 290, 120, 25);
        updatePanel.add(updateBookButton);

      //actiunea efectuata la apasarea lui Update
        updateBookButton.addActionListener(e -> {
        	//ia datele din campuri
            String targetTitle = targetTitleText.getText();
            String targetAuthor = targetAuthorText.getText();
            String title = titleText.getText();
            String author = authorText.getText();
            String publisher = publisherText.getText();
            String[] keywords = keywordsText.getText().split(", ");
            String[] domains = domainsText.getText().split(", ");
            String year = yearText.getText();

            //daca nu e niciun camp gol
            if (!targetTitle.isEmpty() && !targetAuthor.isEmpty() && !title.isEmpty() && !author.isEmpty()
                    && !publisher.isEmpty() && !keywordsText.getText().isEmpty() && !domainsText.getText().isEmpty() && !year.isEmpty()) {
            	Validate validateYear = new ValidateYear();
                //daca anul introdus e valid => incearca editarea
            	if (validateYear.validate(year)) {
                	validationLabel.setText("");
                    validationLabel.setText("");
                    int yearAsNr = Integer.parseInt(year);
                    UpdateOperation updateOp = new UpdateOperation();
                    String message = updateOp.updateBookByTitleAndAuthor(targetTitle + "," + targetAuthor, title, author, keywords, yearAsNr, domains, publisher);
                    validationLabel.setText(message);
                } else {
                    validationLabel.setText("Invalid year. Please enter a valid positive integer.");
                }
            } else {
                validationLabel.setText("Please fill in all fields.");
            }
        });


        updateFrame.setVisible(true);
    }
}
