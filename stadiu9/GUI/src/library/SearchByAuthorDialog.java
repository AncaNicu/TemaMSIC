package library;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//clasa pt fereastra raspunzatoare de cautarea dupa autor
public class SearchByAuthorDialog implements Dialog {

    @Override
    public void showDialog() {
    	//fereastra are camp pt autor
    	//o eticheta pt mesaje si butonul Search
    	
        var searchFrame = new JFrame("Search by Author");
        searchFrame.setSize(400, 150);
        var searchPanel = new JPanel();
        searchFrame.add(searchPanel);
        searchPanel.setLayout(null);

        var authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 20, 80, 25);
        searchPanel.add(authorLabel);

        var authorText = new JTextField(20);
        authorText.setBounds(100, 20, 250, 25);
        searchPanel.add(authorText);

        var validationLabel = new JLabel("");
        validationLabel.setBounds(10, 50, 300, 25);
        searchPanel.add(validationLabel);

        var searchButton = new JButton("Search");
        searchButton.setBounds(10, 80, 120, 25);
        searchPanel.add(searchButton);

        //actiunea efectuata la apasarea lui Search
        searchButton.addActionListener(e -> {
        	//ia autorul din camp
            String author = authorText.getText();

            //daca e completat autorul => efectueaza cautarea
            if (!author.isEmpty()) {
            	validationLabel.setText("");
                SearchOperation searchOp = new SearchOperation();
                String message = searchOp.searchBooksByAuthor(author);
                validationLabel.setText(message);
            } else {
                validationLabel.setText("Please enter an author to perform the search.");
            }
        });

        searchFrame.setVisible(true);
    }
}
