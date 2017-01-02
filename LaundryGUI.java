import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class LaundryGUI 
{
	private String[] TimeAL = {"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00","08:30","09:00","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};
	private String[] WeekDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private ArrayList<String> WeekDaysAL = new ArrayList<String>(Arrays.asList(WeekDays));
	private Day[] Week = {new Day(WeekDays[0]),new Day(WeekDays[1]),new Day(WeekDays[2]),new Day(WeekDays[3]),new Day(WeekDays[4]),new Day(WeekDays[5]),new Day(WeekDays[6])};;
	private ArrayList<Student> SL = new ArrayList<Student>();
	private DateFormat DateForm = new SimpleDateFormat("HH:mm");
	
	public void Start()
	{
		SL.add(new Student ("John Park", "12345"));
		SL.add(new Student ("Sarah Lee", "99999"));
		SL.add(new Student ("SumYung Guy", "02020"));
		SerLi.setFont(new Font("Arial",Font.BOLD,20));
		Home();
		
		try 
	    {
	        while (true) 
	        {
	            CleanUP();
	            Thread.sleep(30 * 1000);
	        }
	    } 
	    catch (InterruptedException e) 
	    {
	        e.printStackTrace();
	    }
	}
	
	@SuppressWarnings("serial")
	public void Home()
	{		
		JFrame H = new JFrame(); //H stands for Home
	    H.setSize(850, 600);
	    H.setTitle("Laundry Program: Home");
	    H.setResizable(false);
	    H.setLocationRelativeTo(null); //Makes the window appear in the center of the screen
	    H.setLayout(new GridLayout(1,3));
	    
	    H.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                H.dispose();
            }
        });
	    
	    JButton hSignUpB = new JButton("Sign Up");
	    hSignUpB.setFont(new Font("Arial",Font.BOLD,20));
	    hSignUpB.addActionListener(new AbstractAction()
	    { //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt)
            {
                try {
					ModularWindow("SignUp");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
	    
	    JButton hEnterCodeB = new JButton("Enter Code");
	    hEnterCodeB.setFont(new Font("Arial",Font.BOLD,20));
	    hEnterCodeB.addActionListener(new AbstractAction()
	    { //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt)
            {
            	try {
					ModularWindow("EnterCode");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
	    
	    JButton hCancelB = new JButton("Cancel");
	    hCancelB.setFont(new Font("Arial",Font.BOLD,20));
	    hCancelB.addActionListener(new AbstractAction()
	    { //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt)
            {
            	try {
					ModularWindow("Cancel");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
	    
	    JPanel ButtonP = new JPanel();
	    ButtonP.setLayout(new GridLayout(7,1));
	    ButtonP.add(new JLabel(""));
	    ButtonP.add(hSignUpB);
	    ButtonP.add(new JLabel(""));
	    ButtonP.add(hEnterCodeB);
	    ButtonP.add(new JLabel(""));
	    ButtonP.add(hCancelB);
	    ButtonP.add(new JLabel(""));
	    
	    H.add(new JLabel(""));
	    H.add(ButtonP);
	    H.add(new JLabel(""));
	    
	    H.setVisible(true);
	}
	
	JTextField ModularT = new JTextField();
	
	@SuppressWarnings("serial")
	public void ModularWindow(String type) throws ParseException
	{
		JFrame M = new JFrame(); //M stands for Modular
	    M.setSize(350, 500);
	    M.setResizable(false);
	    M.setLocationRelativeTo(null); //Makes the window appear in the center of the screen
	    M.setLayout(new GridLayout(5,1));
	    
	    ModularT.setFont(new Font("Arial",Font.BOLD,25));
	    
	    JButton mOKSUB = new JButton("OK");
	    mOKSUB.setFont(new Font("Arial",Font.BOLD,20));
	    mOKSUB.addActionListener(new AbstractAction()
	    { //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt)
            {
            	System.out.println("SignUp");
            	String ID = ModularT.getText();
            	Student temp = null;
            	for (int i = 0; i < SL.size(); i++)
            	{
            		if (SL.get(i).getID().equals(ID))
            			temp = SL.get(i);
            	}
            	if (temp != null )
            	{
            		M.dispose();
            		ModularT.setText("");
            		SignUp(temp);
            	}
            	else
            	{
            		System.out.println("Warning");
            		ModularWarning("IncID","","");
            	}
                
            }
        });
	    
	    JButton mOKECB = new JButton("OK");
	    mOKECB.setFont(new Font("Arial",Font.BOLD,20));
	    mOKECB.addActionListener(new AbstractAction()
	    { //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt)
            {
            	System.out.println("EnterCode");
            	String ucode = ModularT.getText();
                int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
                System.out.println(day-1); //Bug testing
                Line dayl = Week[day-1].getWasher().getLi();
                Reservation r1 = (Reservation) dayl.peek();
                if (r1 == null)
                	ModularWarning("IncCo","","");
                else
                {
	                Date d1 = null;
	                Date td = null;
	                if (ucode.equals(r1.returnCode()))
	                {
	                	String time = ucode.substring(6);
	                	try {d1 = DateForm.parse(time);} catch (ParseException e) {e.printStackTrace();}
	                	Date now = new Date();
	                	String tTime = DateForm.format(now);
						try {td = DateForm.parse(tTime);} catch (ParseException e) {e.printStackTrace();}
	                	//long difference = d1.getTime() - td.getTime();
	                	if (td.before(d1))
	                		ModularWarning("CoCoIT","","");
	                	else
	                	{
	                		ModularWarning("CoCoCT","","");
	                		M.dispose();
	                		dayl.next();
	                	}
	                }
	                else
	                	ModularWarning("IncCo","","");
                }
                
            }
        });
	    
	    JButton mOKCB = new JButton("OK");
	    mOKCB.setFont(new Font("Arial",Font.BOLD,20));
	    mOKCB.addActionListener(new AbstractAction()
	    { //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt)
            {
            	System.out.println("Cancel");
                //Enter Code Window for Cancel
            	String cday = ModularT.getText().substring(3,6);
            	System.out.println(cday);
            	int ciday = 0;
            	if (cday.equals("Sun"))
            		ciday = 0;
            	else if (cday.equals("Mon"))
            		ciday = 1;
            	else if (cday.equals("Tue"))
            		ciday = 2;
            	else if (cday.equals("Wed"))
            		ciday = 3;
            	else if (cday.equals("Thu"))
            		ciday = 4;
            	else if (cday.equals("Fri"))
            		ciday = 5;
            	else 
            		ciday = 6;
            	
            	if (Week[ciday].getWasher().getLi().getNode() == null)
            	{
            		System.out.println("No code found");
            		ModularWarning("CoNFo","","");
            	}
            	else
            	{
	            	ListNode temp = Week[ciday].getWasher().getLi().getNode();
	            	ListNode temp1 = temp;
	            	boolean removed = false;
	            	if (((Reservation) temp1.getValue()).returnCode().equals(ModularT.getText()))
	            	{
	            		temp = temp.getNext();
	            		removed = true;
	            	}
	            	else
	            	{
	            		while (temp1.getNext()!=null && removed == false)
	            		{
	            			if (((Reservation) temp1.getNext().getValue()).returnCode().equals(ModularT.getText()))
	            			{
	            				if (temp1.getNext().getNext()!=null)
	            					temp1 = temp1.getNext().getNext();
	            				else if (temp1.getNext().getNext()==null)
	            					temp1.setNext(null);
	            				removed = true;
	            			}
	            			temp1 = temp1.getNext();
	            		}
	            	}
	            	if (removed)
	            	{
	            		Week[ciday].getWasher().getLi().setNode(temp);
	            		M.dispose();
	            		ModularT.setText("");
	            		ModularWarning("CoFo","","");
	            	}
	            	else
	            	{
	            		System.out.println("No code found");
	            		ModularWarning("CoNFo","","");
	            	}
            	}
            }
        });
	    
	    JButton mCancelB = new JButton("Cancel");
	    mCancelB.setFont(new Font("Arial",Font.BOLD,20));
	    mCancelB.addActionListener(new AbstractAction()
	    { //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt)
            {
                M.dispose();
                ModularT.setText("");
            }
        });
	    
	    JLabel Title;
	    JButton mOK;
	    
	    if (type.equals("SignUp"))
	    {
	    	M.setTitle("Laundry Program: Sign Up");
	    	Title = new JLabel("Please Enter ID:");
	    	mOK = mOKSUB;
	    }
	    else if (type.equals("EnterCode"))
	    {
	    	M.setTitle("Laundry Program: Enter Code");
	    	Title = new JLabel("Please Enter Code:");
	    	mOK = mOKECB;
	    }
	    else
	    {
	    	M.setTitle("Laundry Program: Cancel Reservation");
	    	Title = new JLabel("Please Enter Code:");
	    	mOK = mOKCB;
	    }
	    
	    Title.setFont(new Font("Arial",Font.BOLD,25));
	    
	    JPanel mBP = new JPanel();
	    mBP.setLayout(new GridLayout(1,2));
	    mBP.add(mCancelB);
	    mBP.add(mOK);
	    
	    M.add(new JLabel(""));
	    M.add(Title);
	    M.add(ModularT);
	    M.add(new JLabel(""));
	    M.add(mBP);
	    
	    M.setVisible(true);
	}
	
	JComboBox<String> CDays = new JComboBox<String>(WeekDays);
	
	DefaultListModel<String> DLM = new DefaultListModel<String>();
    JList<String> SerLi = new JList<String>(DLM);
    JScrollPane scrollPane = new JScrollPane(SerLi);
	
	@SuppressWarnings("serial")
	public void SignUp(Student s)
	{
		JFrame SU = new JFrame();
	    SU.setSize(850, 600);
	    SU.setTitle("Laundry Program: Sign Up");
	    SU.setResizable(false);
	    SU.setLocationRelativeTo(null); //Makes the window appear in the center of the screen
	    SU.setLayout(new GridLayout(1,2));
	    
	    JComboBox<String> CDays = new JComboBox<String>(WeekDays);
	    CDays.setFont(new Font("Arial",Font.BOLD,25));
	    CDays.addActionListener(
	    		new AbstractAction()
	    		{
	    			public void actionPerformed(ActionEvent e)
	    			{
	    				DLM.clear();
	    				System.out.println((String) CDays.getSelectedItem());
	    				Search((String) CDays.getSelectedItem(), s);
	    			}
	    		}
	    		);
	    
	    JButton suCancelB = new JButton("Cancel");
	    suCancelB.setFont(new Font("Arial",Font.BOLD,20));
	    suCancelB.addActionListener(new AbstractAction()
	    { //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt)
            {
                SU.dispose();
            }
        });
	    
	    JButton suOKB = new JButton("OK");
	    suOKB.setFont(new Font("Arial",Font.BOLD,20));
	    suOKB.addActionListener(new AbstractAction()
	    { //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt)
            {
                SU.dispose();
                MachineQueue q1 = Week[WeekDaysAL.indexOf(CDays.getSelectedItem())].getWasher();
                String time = SerLi.getSelectedValue();
                try {
					String code = q1.addR(time, s);
					ModularWarning("SIR",s.getName(),code);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                //Code Window
            }
        });
	    
	    JLabel d = new JLabel("Day:");
	    d.setFont(new Font("Arial",Font.BOLD,20));
	    JLabel n = new JLabel("Welcome, " + s.getName());
	    n.setFont(new Font("Arial",Font.BOLD,20));
	    JLabel w = new JLabel("Wash Cycle: 30min");
	    w.setFont(new Font("Arial",Font.BOLD,20));
	    JLabel dr = new JLabel("Dry Cycle: 30min");
	    dr.setFont(new Font("Arial",Font.BOLD,20));
	    JLabel t = new JLabel("Total Time: 1hr");
	    t.setFont(new Font("Arial",Font.BOLD,20));
	    
	    JPanel SUL = new JPanel();
	    SUL.setLayout(new GridLayout(9,1));
	    SUL.add(n);
	    SUL.add(d);
	    SUL.add(CDays);
	    SUL.add(w);
	    SUL.add(dr);
	    SUL.add(t);
	    SUL.add(new JLabel(""));
	    SUL.add(suCancelB);
	    SUL.add(suOKB);
	    
	    SU.add(scrollPane);
	    SU.add(SUL);
	    
	    SU.setVisible(true);
	}
	
	public void Search(String day, Student s)
	{
		ListNode temp;
		Day d1 = Week[WeekDaysAL.indexOf(day)];
		System.out.println(d1.getDay());
		if (Week[WeekDaysAL.indexOf(day)].getWasher().findStudent(s))
		{
			DLM.addElement("You already have a reserved slot ");
			DLM.addElement("for this day");
		}
		else
		{
			if (Week[WeekDaysAL.indexOf(day)].getWasher().getLi()!=null)
			{
				temp = Week[WeekDaysAL.indexOf(day)].getWasher().getLi().getNode();
				ArrayList<String> fill = new ArrayList<String>();
				fill.add("23:30");
				while (temp!=null)
				{
					fill.add(((Reservation) temp.getValue()).returnTime());
					temp = temp.getNext();
				}
				int i = 0;
				while (i < TimeAL.length)
				{
					if (!fill.contains(TimeAL[i]))
						DLM.addElement(TimeAL[i]);
					i++;
				}
			}
			else
			{
				int i = 0;
				while (i < TimeAL.length)
				{
					DLM.addElement(TimeAL[i]);
					i++;
				}
			}
		}
	}
	
	public void CleanUP()
	{
		
	}
	
	public void ModularWarning(String type, String text, String text1)
	{
		JFrame MW = new JFrame(); 
	    MW.setSize(350, 350);
	    MW.setResizable(false);
	    MW.setLocationRelativeTo(null); //Makes the window appear in the center of the screen
	    MW.setLayout(new GridLayout(5,1));
	    
	    MW.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                MW.dispose();
            }
        });
	    
	    JLabel l1 = new JLabel("");
	    JLabel l2 = new JLabel("");
	    JLabel l3 = new JLabel("");
	    JLabel l4 = new JLabel("");
	    JLabel l5 = new JLabel("");
	    
	    l1.setFont(new Font("Arial",Font.BOLD,25));
	    l2.setFont(new Font("Arial",Font.BOLD,25));
	    l3.setFont(new Font("Arial",Font.BOLD,25));
	    l4.setFont(new Font("Arial",Font.BOLD,25));
	    l5.setFont(new Font("Arial",Font.BOLD,25));
	    	
	    
	    if (type.equals("IncID"))
	    {
	    	l2.setText("ID Not Found:");
	    	l3.setText("Please try again.");
	    }
	    else if (type.equals("SIR"))
	    {
	    	l1.setText("Congrats "+text+"!");
	    	l2.setText("Your slot has");
	    	l3.setText("been reserved.");
	    	l4.setText("Your code:");
	    	l5.setText(text1);
	    	l5.setForeground(Color.red);
	    	l5.setFont(new Font("Arial",Font.BOLD,30));
	    }
	    else if (type.equals("IncCo"))
	    {
	    	l2.setText("Incorrect Code:");
	    	l3.setText("Please try again.");
	    }
	    else if (type.equals("CoCoIT"))
	    {
	    	l2.setText("Sorry,");
	    	l3.setText("You are next in line,");
	    	l4.setText("but you are too early.");
	    }
	    else if (type.equals("CoCoCT"))
	    {
	    	l2.setText("Congrats!");
	    	l3.setText("You may use the washing");
	    	l4.setText("machine and dryer!");
	    }
	    else if (type.equals("CoNFo"))
	    {
	    	l2.setText("Error:");
	    	l3.setText("Code not found");
	    }
	    else if (type.equals("CoFo"))
	    {
	    	l2.setText("Thank you,");
	    	l3.setText("Your code is now ");
	    	l4.setText("cancelled.");
	    }
	    
	    MW.add(l1);
	    MW.add(l2);
	    MW.add(l3);
	    MW.add(l4);
	    MW.add(l5);
	    
	    MW.setVisible(true);
	}
	
	public void cleanUp()
	{
		System.out.println("EnterCode");
    	String ucode = ModularT.getText();
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        System.out.println(day-1); //Bug testing
        Line dayl = Week[day-1].getWasher().getLi();
        String time = ucode.substring(6);
        Date d1 = null;
        Date td = null;
    	try {d1 = DateForm.parse(time);} catch (ParseException e) {e.printStackTrace();}
    	Date now = new Date();
    	String tTime = DateForm.format(now);
		try {td = DateForm.parse(tTime);} catch (ParseException e) {e.printStackTrace();}
    	long difference = td.getTime() - d1.getTime();
    	if (difference > 420000)
    		dayl.next();
	}
}
