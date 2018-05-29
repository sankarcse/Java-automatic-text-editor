import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.JOptionPane; 
import javax.swing.JScrollPane;
import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.io.FileWriter.*;
import java.io.FileReader.*;
import java.util.Timer;
import java.util.TimerTask;

class MyNote extends JFrame implements ActionListener{
	JTextArea ta;
	JMenuBar mb;
	JMenu file,edit;
	JMenuItem new1,open,save,close,cut,copy,paste;
	JFileChooser fc; 
	Scanner s=null;
	JScrollPane jsp;
	
	
	MyNote()   //throws FileNotFoundException
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fc=new JFileChooser(".");
        ta = new JTextArea();	
		 ta= new JTextArea();
        getContentPane().add(ta);
        getContentPane().add(new JScrollPane(ta), BorderLayout.CENTER);
		setLayout(null);
		//jsp=new JScrollPane(ta);
		//add(jsp);
		fc=new JFileChooser();
		ta=new JTextArea();
		mb=new JMenuBar();
		mb.setBounds(0,0,800,30);
		ta.setBounds(0,30,800,770);
		//menu
		file=new JMenu("File");
		edit=new JMenu("Edit");
		//menu items
		new1=new JMenuItem("New");
		open=new JMenuItem("Open");
		save=new JMenuItem("saveas");
		close=new JMenuItem("Close");
		cut=new JMenuItem("Cut");
		copy=new JMenuItem("Copy");
		paste=new JMenuItem("Paste");
		//adding items to file
		file.add(new1);
		file.add(open);
		file.add(save);
		file.add(close);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		mb.add(file);
		mb.add(edit);
		add(mb);
		add(ta); 
		
		//adding action listener
		
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		
		
		
		new1.addActionListener(this);
		open.addActionListener(this);
		close.addActionListener(this);
		save.addActionListener(this);
		//adding shortcut keys
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		
		KeyStroke opn=KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK);
		open.setAccelerator(opn);
		
		KeyStroke sav=KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK);
		save.setAccelerator(sav);
		
		KeyStroke ne=KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK);
		new1.setAccelerator(ne);
		
		KeyStroke cls=KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK);
		close.setAccelerator(cls);
		
		KeyStroke cu=KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK);
		cut.setAccelerator(cu);
		
		KeyStroke cpy=KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK);
		copy.setAccelerator(cpy);
		
		KeyStroke pst=KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK);
		paste.setAccelerator(pst);
		
		//asking for saving the changes made
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
			
			try(FileWriter f1=new FileWriter(fc.getSelectedFile()))
				{
					BufferedWriter br=new BufferedWriter(f1);
					s=new Scanner(ta.getText());
					while(s.hasNext())
					{
					br.write(s.nextLine());
					br.newLine();
					}
					br.close();
				}
				catch(IOException ie)
				{
					
					System.out.println(ie);
				}
				finally{
					try{
					FileWriter fr=new FileWriter("test.txt");
					BufferedWriter br1=new BufferedWriter(fr);
					s=new Scanner(ta.getText());
					while(s.hasNext())
					{
					br1.write(s.nextLine());
					br1.newLine();
					}
					br1.close();
				}
				catch(IOException ie1)
				{
					System.out.println(ie1);
				}
				System.exit(0);
				}
	}  

});
}
//defining Action methods
	public void actionPerformed(ActionEvent ae)
	{
			if(ae.getSource()==new1)
			{
				
				
				
				
	class Reminder{
   JTextArea t1 =new JTextArea();
 Timer timer;
//t1.setText("");
int n=fc.showOpenDialog(this);
//System.out.println(n);

    public Reminder(int seconds) {
		 
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
	}

    class RemindTask extends TimerTask {
        public void run() {
				
				if(n==JFileChooser.APPROVE_OPTION)
				{
					try
					{
						s=new Scanner(fc.getSelectedFile());
						while(s.hasNext())
						{
							String str=s.nextLine();
							ta.append(str+"\n");
						}
		 			}catch(FileNotFoundException aie)
					{
						System.out.println(aie);
					}
				}
            new Reminder(1);
            timer.cancel(); //Terminate the timer thread
        }
    }
}

}
			if(ae.getSource()==close)
			{
				
				try(FileWriter f1=new FileWriter(fc.getSelectedFile()))
				{
					BufferedWriter br=new BufferedWriter(f1);
					s=new Scanner(ta.getText());
					while(s.hasNext())
					{
					br.write(s.nextLine());
					br.newLine();
					}
					br.close();
				}
				catch(IOException ie)
				{
					System.out.println(ie);
				}
				finally{
				System.exit(0);
				}
			}
			if(ae.getSource()==open)
			{
				ta.setText("");
				int n=fc.showOpenDialog(this);
				if(n==JFileChooser.APPROVE_OPTION)
				{
					try
					{
						s=new Scanner(fc.getSelectedFile());
						while(s.hasNext())
						{
							String str=s.nextLine();
							ta.append(str+"\n");
						}
		 			}catch(FileNotFoundException aie)
					{
						System.out.println(aie);
					}
				}
			}
			if(ae.getSource()==save)
		   	{
				int p=fc.showSaveDialog(this);
				if(p==JFileChooser.APPROVE_OPTION)
				{
				try(FileWriter f1=new FileWriter(fc.getSelectedFile()))
				{
					BufferedWriter br=new BufferedWriter(f1);
					s=new Scanner(ta.getText());
					while(s.hasNext())
					{
					br.write(s.nextLine());
					br.newLine();
					}
					br.close();
				}
				catch(IOException ie)
				{
					System.out.println(ie);
				}
			}
		}
			if(ae.getSource()==cut)
			{
				ta.cut();
			}
			if(ae.getSource()==copy)
			{
				ta.copy();
			} 
			if(ae.getSource()==paste)
			{
				ta.paste();
			}
	}
	
	public static void main(String [] cse) throws IOException
	{
			
			MyNote mn=new MyNote();
			mn.setSize(800,800);
			mn.setVisible(true); 
			mn.setTitle("AUTOMATIC TEXT SAVING NOTEPAD");
				new Reminder(1);
        System.out.format("Task scheduled.%n");
		}
	}
