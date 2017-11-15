package br.com.furb.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerLabel extends JLabel implements ActionListener {

	private static final String REMAINING = "Restante: 00:00";
	private static final long serialVersionUID = -6805490290381029578L;
	private Date finalDate;
	private SimpleDateFormat sdf;

	public TimerLabel() {
		this(null);
	}
	
	public TimerLabel(Date finalDate) {
		setText(REMAINING);
		this.finalDate = finalDate;
		sdf = new SimpleDateFormat("mm:ss");
		Timer t = new Timer(1000, this);
		t.start();
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = REMAINING;
		if (finalDate != null) {
			long diff = finalDate.getTime() - new Date().getTime();
			if (diff > 0) {
				Date date = new Date(diff);
				text = String.format("Restante: %s", sdf.format(date));
			}
		}
		setText(text);
	}

}
