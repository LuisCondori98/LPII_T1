package com.t1.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.t1.entity.Libro;
import com.t1.entity.Prestamo;
import com.t1.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtCodigo;
	private JComboBox cboCategorias;
	private JComboBox cboProveedores;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(324, 29, 89, 23);
		contentPane.add(btnRegistrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Cod. Prestamo: ");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);

		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Usuario");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNomProducto = new JLabel("Fecha :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);

		JLabel lblStock = new JLabel("Estado: ");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);

		/*JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);*/

		JLabel lblProveedores = new JLabel("Libro: ");
		lblProveedores.setBounds(230, 106, 102, 14);
		contentPane.add(lblProveedores);

		cboProveedores = new JComboBox();
		cboProveedores.setBounds(300, 104, 120, 22);
		contentPane.add(cboProveedores);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(324, 63, 89, 23);
		contentPane.add(btnBuscar);

		llenaCombo();
		buscar();
	}

	void llenaCombo() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		String jpqlc = "SELECT u FROM Usuario u";
		String jpqlpr = "SELECT l FROM Libro l";
		
		List<Usuario> lstUsuarios = em.createQuery(jpqlc, Usuario.class).getResultList();
		
		for(Usuario u : lstUsuarios) {
			
			cboCategorias.addItem(u.getNombre());
		}
		
		List<Libro> lstLibros = em.createQuery(jpqlpr, Libro.class).getResultList();
		
		for(Libro l: lstLibros) {
			
			cboProveedores.addItem(l.getTitulo());
		}
	}

	void registrar() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		/*try {
			
			Producto p = new Producto();
			
			p.setId_prod(txtCodigo.getText());
			p.setDes_prod(txtDescripcion.getText());
			p.setStk_prod(Integer.parseInt(txtStock.getText()));
			p.setPre_prod(Double.parseDouble(txtPrecio.getText()));
			p.setIdcategoria(cboCategorias.getSelectedIndex());
			p.setIdproveedor(cboProveedores.getSelectedIndex());
			
			em.getTransaction().begin();;
			em.persist(p);
			em.getTransaction().commit();
			
			System.out.println("Producto registrado correctamente");
		} catch(Exception e) {
			
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			
			em.clear();
			emf.close();
		}*/
	}

	void listado() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT p FROM Usuario p";
		
		List<Usuario> lstProductos = em.createQuery(jpql, Usuario.class).getResultList();
		
		txtSalida.setText("==== Listado de Productos FAKE ====\n");
		for(Usuario u : lstProductos) {
			
			imprimir("\nCodigo: \t" + u.getId_usuario());
			imprimir("Nombres: \t" + u.getNombre());
			imprimir("Correo: \t" + u.getCorreo());
		}
		
		em.clear();
		emf.close();
	}
	
	private void imprimir(String string) {
		
		txtSalida.append(string + "\n");
	}
	
	void buscar() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT p FROM Prestamo p";
		
		List<Prestamo> lstProductos = em.createQuery(jpql, Prestamo.class).getResultList();
		
		txtCodigo.setText(lstProductos.size() + 1+"");
	}
}