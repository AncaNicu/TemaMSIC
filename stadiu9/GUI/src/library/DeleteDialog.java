package library;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//clasa pt fereastra raspunzatoare de stergerea unei carti
public class DeleteDialog implements Dialog {

    @Override
    public void showDialog() {
    	//fereastra are campuri pt autor si titlu
    	//o eticheta pt mesaje si butonul Delete
    	
        var deleteFrame = new JFrame("Delete Book");
        deleteFrame.setSize(400, 300);
        var deletePanel = new JPanel();
        deleteFrame.add(deletePanel);
        deletePanel.setLayout(null);

        var titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10, 20, 80, 25);
        deletePanel.add(titleLabel);

        var titleText = new JTextField(20);
        titleText.setBounds(100, 20, 250, 25);
        deletePanel.add(titleText);

        var authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 50, 80, 25);
        deletePanel.add(authorLabel);

        var authorText = new JTextField(20);
        authorText.setBounds(100, 50, 250, 25);
        deletePanel.add(authorText);

        var deleteBookButton = new JButton("Delete Book");
        deleteBookButton.setBounds(10, 110, 120, 25);
        deletePanel.add(deleteBookButton);

        var validationLabel = new JLabel("");
        validationLabel.setBounds(10, 80, 300, 25);
        deletePanel.add(validationLabel);

        //actiunea efectuata la apasarea lui Delete
        deleteBookButton.addActionListener(e -> {
        	//ia datele din campuri
            String title = titleText.getText();
            String author = authorText.getText();

            //daca nu e niciun camp gol => incearca sa stearga cartea
            if (!title.isEmpty() && !author.isEmpty()) {
            	validationLabel.setText("");
                DeleteOperation deleteOp = new DeleteOperation();
                String message = deleteOp.deleteBook(title, author);
                validationLabel.setText(message);
            } else {
                validationLabel.setText("Please fill in both title and author fields.");
            }
        });

        deleteFrame.setVisible(true);
    }
}
