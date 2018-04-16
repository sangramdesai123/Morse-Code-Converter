import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code="expt11.class" width=500  height=500></applet>*/
public class expt11 extends Applet implements ActionListener
{
	Label l1,l2;
	Button b1,b2;
	TextField t1,t2;
	public void init()
	{
		
		setLayout(null);
		l1=new Label("Enter no.");
		l1=new Label("Factorial");
		t1=new TextField();
		t2=new TextField();
		b1=new Button("Compute");
		b2=new Button("Clear");
		
		/*l1.setBounds(50,50,100,30);
		l2.setBounds(50,120,100,30);
		t1.setBounds(150,50,150,30);
		t2.setBounds(150,120,150,30);
		b1.setBounds(80,180,150,30);
		b2.setBounds(180,180,80,30);*/
		
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			int a=Integer.parseInt(t1.getText());
			int f=1;
			for(int i=1;i<=a;i++)
			{
				f=f*i;
			}
			t2.setText(String.valueOf(f));
		}
		if(ae.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
		}
	}
}