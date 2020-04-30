import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelMenu extends JLabel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color colorOriginal;
	private String tituloOriginal;
	public LabelMenu (String title) {
		super(title);
		colorOriginal = new Color(126,87,194);
		tituloOriginal = title;
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setOpaque(true);
		setBackground(colorOriginal);
		setFont(new Font("Times New Roman", Font.BOLD, 13));
		setForeground(Color.WHITE);
		//setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		setHorizontalAlignment(SwingConstants.CENTER);
		addMouseListener(this);
	}
	public String getTituloOriginal() {
		return tituloOriginal;
	}
	public Color getColorOriginal() {
		return colorOriginal;
	}
	@Override
	public void mouseClicked(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		LabelMenu label = (LabelMenu) e.getSource();
		label.setOpaque(true);
		label.setBackground(new Color(116, 82, 255));
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		LabelMenu label = (LabelMenu) e.getSource();
		label.setBackground(label.getColorOriginal());
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
