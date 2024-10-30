
package eval;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListBoxPanel extends JPanel {
    
    private JList<String> contactList;
    private DefaultListModel<String> listModel;

    public ListBoxPanel() {
        setBorder(BorderFactory.createEtchedBorder());
        
        listModel = new DefaultListModel<>();
        contactList = new JList<>(listModel);
       
        JScrollPane scrollPane = new JScrollPane(contactList);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }
    
    public void addListBox(String name, String email, String phone, String address) {
   
        listModel.addElement("Name: " + name);
        listModel.addElement("Email: " + email);
        listModel.addElement("Phone: " + phone);
        listModel.addElement("Address: " + address);
        
    }
}