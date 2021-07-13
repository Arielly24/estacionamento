package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.EstacionamentoDao;
import model.Cliente;
import util.UTIL;

 

public class FrameEstacionamento { 

 

     private JLabel labelEntrada, labelPlaca, labelModelo, labelSaida, labelPlacaSaida, labelModeloSaida, 
                             labelDataEntrada, labelHoraEntrada, labelDataSaida, labelHoraSaida, labelTempo, labelValor;
     
     private JTextField textPlaca, textModelo, textPlacaSaida, textModeloSaida, textDataEntrada, 
                             textHoraEntrada, textDataSaida, textHoraSaida, textTempo, textValor;

 

      private JTable tabela;
      private DefaultTableModel tabelaModel;
	  private JScrollPane scrollTabela;
	  private JButton buttonEntrar;
	  private JButton buttonSaida;
	  private JButton buttonFechar;
	  private JButton buttonBuscar;
	  
	  
     
    public void criarTela() {
        
        Font fontTitulos = new Font("Consolas", Font.BOLD, 22);
        Font fontSub = new Font("Consolas", Font.BOLD, 15);
        Font fontBig = new Font("Consolas", Font.BOLD, 18);
        
       

        JFrame tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setTitle("Estacionamento");
        tela.setSize(800, 520);
        tela.setLayout(null);
        tela.setResizable(false);
            
        labelEntrada = new JLabel("ENTRADA");
        labelEntrada.setBackground(Color.cyan);
        labelEntrada.setOpaque(true);
        labelEntrada.setBounds(40, 10, 100, 30);
        labelEntrada.setForeground(Color.BLACK);
        labelEntrada.setFont(fontTitulos);
        
        labelPlaca = new JLabel("PLACA:");
        labelPlaca.setBounds(40, 45, 120, 30);
        labelPlaca.setFont(fontSub);
        textPlaca = new JTextField();
        textPlaca.setBounds(40, 75, 260, 30); 
        
        labelModelo = new JLabel("MODELO:");
        labelModelo.setBounds(340, 45, 120, 30);
        labelModelo.setFont(fontSub);
        textModelo = new JTextField();               
        textModelo.setBounds(340, 75, 255, 30);       
        
        labelSaida = new JLabel("SAÍDA");
        labelSaida.setBackground(Color.cyan);
        labelSaida.setOpaque(true);
        labelSaida.setBounds(40, 250, 80, 30);
        labelSaida.setForeground(Color.black);
        labelSaida.setFont(fontTitulos);
        
        labelPlacaSaida = new JLabel("PLACA:");
        labelPlacaSaida.setBounds(40, 285, 120, 30);
        labelPlacaSaida.setFont(fontSub);
        textPlacaSaida = new JTextField();
        textPlacaSaida.setBounds(40, 315, 120, 30);
        
        
        
        labelModeloSaida = new JLabel("MODELO:");
        labelModeloSaida.setBounds(40, 350, 120, 30);
        labelModeloSaida.setFont(fontSub);
        textModeloSaida = new JTextField();
        textModeloSaida.setBounds(40, 380, 80, 30);
        
        
        labelDataEntrada = new JLabel("DATA ENTRADA:");
        labelDataEntrada.setBounds(140, 350, 120, 30);
        labelDataEntrada.setFont(fontSub);
        textDataEntrada = new JTextField();
        textDataEntrada.setBounds(140, 380, 110, 30);
        
        
        labelHoraEntrada = new JLabel("HORA ENTRADA:");
        labelHoraEntrada.setBounds(280, 350, 120, 30);
        labelHoraEntrada.setFont(fontSub);
        textHoraEntrada = new JTextField();
        textHoraEntrada.setBounds(280, 380, 110, 30);
        
        
        labelDataSaida = new JLabel("DATA SAÍDA:");
        labelDataSaida.setBounds(420, 350, 120, 30);
        labelDataSaida.setFont(fontSub);
        textDataSaida = new JTextField();
        textDataSaida.setBounds(420, 380, 110, 30);
        
        labelHoraSaida = new JLabel("HORA SAÍDA:");
        labelHoraSaida.setBounds(560, 350, 120, 30);
        labelHoraSaida.setFont(fontSub);
        textHoraSaida = new JTextField();
        textHoraSaida.setBounds(560, 380, 110, 30);
        
        labelTempo = new JLabel("TEMPO:");
        labelTempo.setBounds(690, 350, 120, 30);
        labelTempo.setFont(fontSub);
        textTempo = new JTextField();
        textTempo.setBounds(690, 380, 80, 30);
        
        
        labelValor = new JLabel("VALOR A PAGAR:");
        labelValor.setOpaque(true);
        labelValor.setBackground(Color.cyan);
        labelValor.setBounds(40, 420, 140, 30);
        labelValor.setFont(fontBig);
        textValor = new JTextField();
        textValor.setBounds(190, 420, 180, 40);
        
        
        buttonEntrar = new JButton("ENTRAR");
        buttonEntrar.setBounds(620, 75, 137, 30);    
        buttonEntrar.setForeground(Color.BLACK);
        buttonEntrar.setBackground(Color.cyan);
        
        buttonSaida = new JButton("EFETUAR SAÍDA");
        buttonSaida.setBounds(400, 420, 180, 40);    
        buttonSaida.setForeground(Color.BLACK);
        buttonSaida.setBackground(Color.green);
        
        buttonFechar = new JButton("FECHAR SISTEMA");
        buttonFechar.setBounds(590, 420, 180, 40);    
        buttonFechar.setForeground(Color.BLACK);
        buttonFechar.setBackground(Color.red);
        
        buttonBuscar = new JButton("BUSCAR");
        buttonBuscar.setBounds(180, 315, 120, 30);
        buttonBuscar.setForeground(Color.BLACK);
        buttonBuscar.setBackground(Color.cyan);
        
        
        
        
        //Criar colunas 
        tabelaModel = new DefaultTableModel();
        tabelaModel.addColumn("CÓDIGO");
        tabelaModel.addColumn("PLACA");
        tabelaModel.addColumn("MODELO");
        tabelaModel.addColumn("DATA ENTRADA");
        
        EstacionamentoDao estacionamentoDao = new EstacionamentoDao(); 
		ArrayList<Cliente> clientes = estacionamentoDao.buscarCliente();
		
		for (Cliente cliente : clientes) {
			
			String[] vetorCliente = {cliente.getCodigo(), cliente.getPlaca(), cliente.getModelo(), cliente.getDataEntrada()};
		
		tabelaModel.addRow (vetorCliente);
		
		}
		
		// criar a tabela 
		
		tabela = new JTable (tabelaModel); 
                
            
            //largura das colunas
        tabela.getColumnModel().getColumn(0).setPreferredWidth(185);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(185);      
        tabela.getColumnModel().getColumn(2).setPreferredWidth(185); 
        tabela.getColumnModel().getColumn(3).setPreferredWidth(185);
                
            //impedir movimentação das colunas
        tabela.getTableHeader().setReorderingAllowed(false);

 

            // criar o painel de rolagem
        scrollTabela = new JScrollPane (tabela);
        scrollTabela.setBounds (40, 115, 720, 120);
    
        tela.getContentPane().add(labelEntrada);
        tela.getContentPane().add(labelPlaca);
        tela.getContentPane().add(textPlaca);
        tela.getContentPane().add(labelModelo);
        tela.getContentPane().add(textModelo);
        tela.getContentPane().add(labelSaida);
        tela.getContentPane().add(labelPlacaSaida);
        tela.getContentPane().add(textPlacaSaida);
        tela.getContentPane().add(labelModeloSaida);
        tela.getContentPane().add(textModeloSaida);
        tela.getContentPane().add(labelDataEntrada);
        tela.getContentPane().add(textDataEntrada);
        tela.getContentPane().add(labelHoraEntrada);
        tela.getContentPane().add(textHoraEntrada);
        tela.getContentPane().add(labelDataSaida);
        tela.getContentPane().add(textDataSaida);    
        tela.getContentPane().add(labelHoraSaida);
        tela.getContentPane().add(textHoraSaida);
        tela.getContentPane().add(labelTempo);
        tela.getContentPane().add(textTempo);
        tela.getContentPane().add(labelValor);
        tela.getContentPane().add(textValor);
        tela.getContentPane().add(buttonFechar);
        tela.getContentPane().add(buttonSaida);
        tela.getContentPane().add(buttonBuscar);
        
        
        tela.getContentPane().add(buttonEntrar);
        tela.getContentPane().add(scrollTabela);
    
        tela.setVisible(true);
        
        
        
     // ouvinte do botão entrar
		buttonEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (validarFormulario()) {
					Cliente cliente = new Cliente();
					cliente.setCodigo(UTIL.gerarCodigo());
					cliente.setPlaca(textPlaca.getText().toUpperCase());
					cliente.setModelo(textModelo.getText().toUpperCase());
					cliente.setDataEntrada(UTIL.converterData(LocalDate.now()));
					cliente.setHoraEntrada(UTIL.converterHora(LocalTime.now()));		
			

					EstacionamentoDao dao = new EstacionamentoDao(cliente);
					dao.gravar();

					JOptionPane.showMessageDialog(null,
							cliente.getModelo() + " estacionou!");

					textPlaca.setText("");
					textModelo.setText("");

					System.out.println(cliente.toString());

				} else {}
			}
		});
		
		buttonBuscar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub								
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Cliente cliente = new Cliente();
				EstacionamentoDao dao = new EstacionamentoDao();
				cliente = dao.buscarCliente(textPlacaSaida.getText());  
				
				textPlaca.setText(cliente.getPlaca());
				textModelo.setText(cliente.getModelo());
				textDataEntrada.setText(cliente.getDataEntrada());
				textHoraEntrada.setText(cliente.getHoraEntrada());
				textDataSaida.setText(UTIL.converterData(LocalDate.now()));
				textHoraSaida.setText(UTIL.converterHora(LocalTime.now()));
			//	textTempo.setText(cliente.getTempo());       
				textValor.setText((String.valueOf(cliente.getValor())));  
				
			}
		});												

}

private boolean validarFormulario() {

	boolean valido = true;

	if (textPlaca.getText().trim().length() == 0) {
		labelPlaca.setForeground(Color.RED);
		valido = false;
	} else if (textModelo.getText().trim().length() == 0) {
		labelModelo.setForeground(Color.RED);
		valido = false;
	}
	
	return valido;
}



}
