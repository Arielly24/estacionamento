package dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import model.Cliente;
public class EstacionamentoDao {
	
	
	private Cliente cliente;
    private static final String LOCAL_ARQUIVO = "C:/Users\\Arielly/eclipse-workspace/estacionamentoo/movimento.ds1.txt";
    
    
    
    //contrutor que pede cliente
    public EstacionamentoDao(Cliente cliente) {
        this.cliente = cliente;
    }
    
    // construtor vazio 
    public EstacionamentoDao() {
        
    }
    
    
    public Cliente getCliente() {
        return cliente;
    }
    public void gravar() {
        
        Path path = Paths.get(LOCAL_ARQUIVO);
        
        try {
            BufferedWriter whiter = Files.newBufferedWriter(path, Charset.forName("UTF-8"),
                    StandardOpenOption.WRITE, StandardOpenOption.APPEND);
 
            whiter.write(cliente.toStringGravar());
            whiter.newLine();
            whiter.close();
            
        } catch (Exception e) {
            e.printStackTrace();
 
        }
 
    }
    
//    public ArrayList<Cliente> listarClientes() {
//        
//        Path path = Paths.get(LOCAL_ARQUIVO);
//       
//        try {
//            BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
//            
//            String linha = reader.readLine();
//            ArrayList<Cliente> clientes = new ArrayList<>(); 
//            
//            
//            while (linha != null) {
//                String [] vetorCliente = linha.split(";");
//                
//                Cliente cliente = new Cliente();
//                cliente.setCodigo(vetorCliente[0]);
//                cliente.setPlaca(vetorCliente[1]);
//                cliente.setModelo(vetorCliente[2]);
//                cliente.setDataEntrada(vetorCliente[3]);
//                cliente.setDataSaida(vetorCliente[4]);
//                cliente.setHoraEntrada(vetorCliente[5]);
//                cliente.setHoraSaida(vetorCliente[6]);
//                cliente.setTempo(Integer.parseInt(vetorCliente[7]));
//                cliente.setValor(Double.parseDouble(vetorCliente[8]));
//                
//                clientes.add(cliente); 
//                
//                
//                linha = reader.readLine();
//                
//                
//            }
//            
//            System.out.println(clientes);
//            
//            reader.close();
//            
//            return clientes;
//            
//            
//        } catch (Exception e) {
//            System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
//            e.printStackTrace();
//            return null; 
//        }
//    }
    
    public ArrayList<Cliente>buscarCliente() {
        //procedimento para abrir um arquivo para leitura ou escrita
    
        //passo1 obter localização do arquivo 
        Path path = Paths.get(LOCAL_ARQUIVO);
        
        //passo2 criar o buffer
        try {
            BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            
            String linha = reader.readLine();
            ArrayList<Cliente> clientes = new ArrayList<>(); 
            
            
            while (linha != null) {
                String [] vetorCliente = linha.split(";");
                
                Cliente cliente = new Cliente();
                cliente.setCodigo(vetorCliente[0]);
                cliente.setPlaca(vetorCliente[1]);
                cliente.setModelo(vetorCliente[2]);
                cliente.setDataEntrada(vetorCliente[3]);

                
                clientes.add(cliente); 
                
                
                linha = reader.readLine();
                
                
            }
            System.out.println(clientes);
            
            reader.close();
            
            return clientes;
            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
            e.printStackTrace();
            return null; 
        }
    }
            
            public Cliente buscarCliente(String placa) {
                
                Path path = Paths.get(LOCAL_ARQUIVO);
               
                try {
                    BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
                    
                    String linha = reader.readLine();
                    cliente = new Cliente(); 
                    
                    
                    while (linha != null) {
                        String [] vetorCliente = linha.split(";");
                        
                        if (vetorCliente[0].equals(placa)){
                            cliente.setCodigo(vetorCliente[0]);
                            cliente.setPlaca(vetorCliente[1]);
                            cliente.setModelo(vetorCliente[2]);
                            cliente.setDataEntrada(vetorCliente[3]);
                            cliente.setHoraEntrada(vetorCliente[4]);
                            cliente.setDataSaida(vetorCliente[5]);
                            cliente.setHoraSaida(vetorCliente[6]);
                 //           cliente.setTempo(vetorCliente[7]);
                            cliente.setValor(Double.parseDouble(vetorCliente[8]));
                            break;
                        }
                        
                        linha = reader.readLine();
                        
                    }
                    
                    reader.close();
                    
                    return cliente;
            
            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
            e.printStackTrace();
            return null; 
        }
    }
    
    
    
    
    
    
    
    
    
    
}
