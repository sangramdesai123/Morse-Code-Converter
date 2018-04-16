import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*
<applet code=exp10.class       height=200 width=300>
</applet>
*/


 public class exp10 extends Applet   implements ActionListener
{
	Label l1,l2;
	TextField t1,t2;
	Button b1,b2;
	public void init() 
	{	setBackground(Color.RED);
		setForeground(Color.BLACK);
		
		l1=new Label("Enter value");
		l2=new Label("result");
		t1=new TextField(10);
		t2=new TextField(10);
		b1=new Button("Calculate");
		b2=new Button("Clear");
		
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		int n=Integer.parseInt(t1.getText());
		int fact=1;
		if(e.getSource()==b1)
		{
			if(n==0||n==1)
			{
				fact=1;
				t2.setText(String.valueOf(fact));
			}
			else
			{
				for(int i=2;i<=n;i++)
				{
					fact=fact*i;
				}
				t2.setText(String.valueOf(fact));
			}
		}
		else
		{
			t1.setText("");
			t2.setText("");
		}
		
		
		
	}
	
	
	
	
	
	
}