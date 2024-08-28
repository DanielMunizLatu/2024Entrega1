package presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import excepciones.UsuarioNoExisteException;
import logica.DataUsuario;
import logica.IControladorActividad;
import logica.IControladorUsuario;

public class AltaActividad extends JInternalFrame {
	
	private  IControladorActividad controlAct;
    private JTextField textFieldnombre;
    private JTextField textFielddescripcion;
    private JComboBox<DataUsuario> cmbEntrenador;
    
    private JLabel titulo;
    private JLabel lbnombre;
    private JLabel ldescripcion;
    private JLabel lentrenador;
	private IControladorUsuario controlUsr;
      
    
    public AltaActividad(IControladorActividad ica) {
        controlAct = ica;
        
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Ingresar actividad");
        setBounds(10, 40, 338, 316);
 
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 104, 100, 100, 40, 0 };
        gridBagLayout.rowHeights = new int[] { 49, 8, 12, 13, 11, 16, 19, 14, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
                Double.MIN_VALUE };
        getContentPane().setLayout(gridBagLayout);
        
        // Label titulo
        titulo = new JLabel("Ingresar actividad");
        titulo.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel_5.gridwidth = 2;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 1;
        gbc_lblNewLabel_5.gridy = 0;
        getContentPane().add(titulo, gbc_lblNewLabel_5);
        
        // Label nombre
        lbnombre = new JLabel("Nombre:");
        lbnombre.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 2;
        getContentPane().add(lbnombre, gbc_lblNewLabel);
        
        // Caja de texto para el nombre
        textFieldnombre = new JTextField();
        textFieldnombre.setEnabled(false);
        GridBagConstraints gbc_txtNombre = new GridBagConstraints();
        gbc_txtNombre.gridwidth = 2;
        gbc_txtNombre.fill = GridBagConstraints.BOTH;
        gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
        gbc_txtNombre.gridx = 1;
        gbc_txtNombre.gridy = 2;
        getContentPane().add(textFieldnombre, gbc_txtNombre);
        textFieldnombre.setColumns(10);
        
                 
       // Etiqueta para la descripcon
            ldescripcion = new JLabel("Descripcion:");
            ldescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
            GridBagConstraints gbc_lbdescripcion = new GridBagConstraints();
            gbc_lbdescripcion.anchor = GridBagConstraints.EAST;
            gbc_lbdescripcion.insets = new Insets(0, 0, 5, 5);
            gbc_lbdescripcion.gridx = 0;
            gbc_lbdescripcion.gridy = 3;
            getContentPane().add(ldescripcion, gbc_lbdescripcion);
        
            // Caja de texto para descripcion
            textFielddescripcion = new JTextField();
            textFielddescripcion.setEnabled(false);
            GridBagConstraints gbc_txtDesc = new GridBagConstraints();
            gbc_txtDesc.gridwidth=2;
            gbc_txtDesc.fill = GridBagConstraints.BOTH;
            gbc_txtDesc.insets = new Insets(0, 0, 5, 5);
            gbc_txtDesc.gridx = 1;
            gbc_txtDesc.gridy = 3;
            getContentPane().add(textFielddescripcion, gbc_txtDesc);
            textFielddescripcion.setColumns(10);
            
            // Etiqueta entrenador      
            lentrenador = new JLabel("Entrenador:");
            lentrenador.setHorizontalAlignment(SwingConstants.RIGHT);
            GridBagConstraints gbc_lblEntrenador = new GridBagConstraints();
            gbc_lblEntrenador.anchor = GridBagConstraints.EAST;
            gbc_lblEntrenador.insets = new Insets(0, 0, 5, 5);
            gbc_lblEntrenador.gridx = 0;
            gbc_lblEntrenador.gridy = 4;
            getContentPane().add(lentrenador, gbc_lblEntrenador); 
            
            // Combo usuario
            cmbEntrenador = new JComboBox<DataUsuario>();
            GridBagConstraints gbc_cmbEntrenadores = new GridBagConstraints();
            gbc_cmbEntrenadores.gridwidth = 2;
            gbc_cmbEntrenadores.insets = new Insets(0, 0, 5, 5);
            gbc_cmbEntrenadores.fill = GridBagConstraints.HORIZONTAL;
            gbc_cmbEntrenadores.gridx = 1;
            gbc_cmbEntrenadores.gridy = 4;
            getContentPane().add(cmbEntrenador, gbc_cmbEntrenadores);
            
            
            cmbEntrenador.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                      cargarEntrenador();
                }  
            });
    }
    public void cargarEntrenador() {
        DefaultComboBoxModel<DataUsuario> model; // Este modelo se crea para carga el combo 
        try {                                    // En model esta lo que vamos a carga al combo
            model = new DefaultComboBoxModel<DataUsuario>(controlUsr.getUsuarios()); //Aca se carga
            cmbEntrenador.setModel(model);        //VER EN LA API DefaultComboBoxModel
        } catch (UsuarioNoExisteException e) {
            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
        }

    }
} 