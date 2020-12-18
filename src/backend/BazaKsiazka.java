/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



public class BazaKsiazka implements BazaInterface {
    private Connection polaczenie;
    
    @Override
    public void wyswietl(JTextArea tDane) 
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=master",
                    "sa", "student");
            
            Statement skladnia=polaczenie.createStatement();
            PreparedStatement ps=polaczenie.prepareStatement("{call dbo.wyswietlKsiazka}");
            ResultSet rezultat=ps.executeQuery();
            while(rezultat.next()) {
                tDane.append(rezultat.getString("nrKsiazki")+
                        ". "+rezultat.getString("tytul")+
                        ", "+rezultat.getString("autor")+
                        ", "+rezultat.getString("rokWydania")+
                        ", "+rezultat.getString("wydawnictwo")+"\n");
            }
            polaczenie.close();
            
        }   
        catch(Exception e) {
         JOptionPane.showMessageDialog(null, "Błąd "+e.getMessage(),
                  "Błąd",JOptionPane.ERROR_MESSAGE);
        }           
    }

    @SuppressWarnings("null")
    public void dodaj(Ksiazka k) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=master",
                    "sa", "student");
            k = (Ksiazka)k;
            try(PreparedStatement pstmt = polaczenie.prepareStatement
                    ("{call dbo.dodajKsiazka(?,?,?,?,?)}"); ) {  
                pstmt.setString(1, k.getNrKsiazki());  
                pstmt.setString(2, k.getTytul());  
                pstmt.setString(3, k.getAutor());  
                pstmt.setString(4, k.getRokWydania());  
                pstmt.setString(5, k.getWydawnictwo());                 
                pstmt.execute();
            }   
                
        }   
        catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Błąd "+ex.getMessage(), "Błąd", 0);
        }  
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Błąd "+ex.getMessage(), "Błąd", 0);
        }          
    }
    public void inicjalizujBaze() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=master",
                    "sa", "student");
            
            CallableStatement procedura=
                    polaczenie.prepareCall("{call dbo.tabelaCzyIstnieje}");
            procedura.execute();
            polaczenie.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void dodaj(String nrKsiazki, String tytul, String autor, String rokWydania, String wydawnictwo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

