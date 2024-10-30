package eval;
import java.awt.BorderLayout;

import javax.swing.JFrame;import javax.swing.border.Border;

public class MainFrame extends JFrame {
	
	
	private ToolBar toolBar;
	private FormPanel formPanel;
	private ListBoxPanel listBoxPanel;
	

	
	
	public MainFrame() {
		super("Contact Form");
		
		setLayout(new BorderLayout());
		toolBar = new ToolBar();
		formPanel = new FormPanel();
		listBoxPanel = new ListBoxPanel();
		
		
		
		add(toolBar, BorderLayout.NORTH);
		add(formPanel,BorderLayout.WEST);
		add(listBoxPanel,BorderLayout.CENTER);
		
		toolBar.setScreenCleaner(new ScreenCleaner() {
			
			@Override
			public void cleaner() {
				// TODO Auto-generated method stub
				formPanel.clearText();
				
			}
		});
		
		formPanel.setFormListener(new FormListener() {
			
			@Override
			public void formEventOccurred(FormEvent e) {
				// TODO Auto-generated method stub
				String name = e.getName();
				String email = e.getEmail();
				String phone = e.getPhone();
				String address = e.getAddress();
				listBoxPanel.addListBox(name, email, phone, address);
			}
		});
		
	
		setVisible(true);
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
